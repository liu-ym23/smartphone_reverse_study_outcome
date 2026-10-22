package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class SkiaImageRegionDecoder implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private final Bitmap.Config bitmapConfig;
    private BitmapRegionDecoder decoder;
    private final ReadWriteLock decoderLock;

    public SkiaImageRegionDecoder() {
        this(null);
    }

    public SkiaImageRegionDecoder(Bitmap.Config r3) {
        this.decoderLock = new ReentrantReadWriteLock(true);
        Bitmap.Config r0 = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (r3 == null) goto L5;
    L4:
        this.bitmapConfig = r3;
        return;
    L5:
        if (r0 == null) goto L7;
        this.bitmapConfig = r0;
        return;
    L7:
        r3 = Bitmap.Config.RGB_565;
        goto L4
    }

    private Lock getDecodeLock() {
        int r0 = Build.VERSION.SDK_INT;
        ReadWriteLock r2 = this.decoderLock;
        if (r0 >= 21) goto L7;
        return r2.writeLock();
    L7:
        return r2.readLock();
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Bitmap decodeRegion(Rect r2, int r3) {
        getDecodeLock().lock();
        BitmapRegionDecoder r0 = this.decoder;     // Catch: Throwable -> L15
        if (r0 == null) goto L14;
        if (r0.isRecycled() == true) goto L14;
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Throwable -> L15
        r1.inSampleSize = r3;     // Catch: Throwable -> L15
        r1.inPreferredConfig = this.bitmapConfig;     // Catch: Throwable -> L15
        Bitmap r4 = this.decoder.decodeRegion(r2, r1);     // Catch: Throwable -> L15
        if (r4 == null) goto L12;
        getDecodeLock().unlock();
        return r4;
    L12:
        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");     // Catch: Throwable -> L15
    L14:
        throw new IllegalStateException("Cannot decode region after decoder has been recycled");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        getDecodeLock().unlock();
        throw th;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Point init(Context r9, Uri r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        String r0 = r10.toString();
        if (r0.startsWith(RESOURCE_PREFIX) == false) goto L21;
        String r1 = r10.getAuthority();
        if (r11.getPackageName().equals(r1) == false) goto L7;
        Resources r2 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin");
    L8:
        List<String> r12 = r10.getPathSegments();
        int r5 = r12.size();
        if (r5 == 2) goto L11;
    L13:
        if (r5 == 1) goto L15;
    L18:
        int r13 = 0;
    L19:
        InputStream r14 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").openRawResource(r13);
    L23:
        BitmapRegionDecoder r15 = BitmapRegionDecoder.newInstance(r14, false);
    L24:
        this.decoder = r15;
    L33:
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ZeusTransformUtils.preCheckCast(r12.get(0), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L18;
        r13 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r12.get(0), String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L39
    L11:
        if (((String) ZeusTransformUtils.preCheckCast(r12.get(0), String.class, "com.obric.memorydata.plugin")).equals("drawable") == false) goto L13;
        r13 = ZeusTransformUtils.getIdentifier(r2, (String) ZeusTransformUtils.preCheckCast(r12.get(1), String.class, "com.obric.memorydata.plugin"), "drawable", r1, "com.obric.memorydata.plugin");
        goto L19
    L7:
        r2 = r11.getPackageManager().getResourcesForApplication(r1);
        goto L8
    L21:
        if (r0.startsWith(ASSET_PREFIX) == false) goto L26;
        r14 = r11.getAssets().open(r0.substring(22), 1);
        goto L23
    L26:
        if (r0.startsWith(FILE_PREFIX) == false) goto L28;
        r15 = BitmapRegionDecoder.newInstance(r0.substring(7), false);
        goto L24
    L28:
        InputStream r3 = null;
        r3 = r11.getContentResolver().openInputStream(r10);     // Catch: Throwable -> L34
        this.decoder = BitmapRegionDecoder.newInstance(r3, false);     // Catch: Throwable -> L34
        if (r3 == null) goto L33;
        r3.close();     // Catch: Exception -> L38
    L34:
        th = move-exception;
        if (r3 != null) goto L41;
    L37:
        throw th;
    L41:
        r3.close();     // Catch: Exception -> L40
        goto L37
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized boolean isReady() {
        monitor-enter(this);
        BitmapRegionDecoder r0 = this.decoder;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        if (r0.isRecycled() == true) goto L8;
        boolean r1 = true;
    L9:
        monitor-exit(this);
        return r1;
    L8:
        r1 = false;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized void recycle() {
        monitor-enter(this);
        this.decoderLock.writeLock().lock();     // Catch: Throwable -> L11
        this.decoder.recycle();     // Catch: Throwable -> L8
        this.decoder = null;     // Catch: Throwable -> L8
        this.decoderLock.writeLock().unlock();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        this.decoderLock.writeLock().unlock();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
