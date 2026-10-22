package com.ss.android.lark.imagewidget.subsampling.decoder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import rlb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SkiaImageRegionDecoder implements d {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "SkiaImageRegionDecoder";
    private final Bitmap.Config bitmapConfig;
    private BitmapRegionDecoder decoder;
    private final ReadWriteLock decoderLock;

    public SkiaImageRegionDecoder() {
        this(null);
    }

    @Override // rlb.d
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

    @Override // rlb.d
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

    private Lock getDecodeLock() {
        return this.decoderLock.readLock();
    }

    public SkiaImageRegionDecoder(Bitmap.Config r3) {
        this.decoderLock = new ReentrantReadWriteLock(true);
        Bitmap.Config r0 = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (r3 == null) goto L5;
        this.bitmapConfig = r3;
        return;
    L5:
        if (r0 == null) goto L7;
        this.bitmapConfig = r0;
        return;
    L7:
        this.bitmapConfig = Bitmap.Config.RGB_565;
    }

    @Override // rlb.d
    public Bitmap decodeRegion(Rect r3, int r4) {
        getDecodeLock().lock();
        BitmapRegionDecoder r0 = this.decoder;     // Catch: Throwable -> L16
        if (r0 != null) goto L7;
    L14:
        Log.e(TAG, "Cannot decode region after decoder has been recycled");     // Catch: Throwable -> L16
        throw new IllegalStateException(TAG);     // Catch: Throwable -> L16
    L7:
        if (r0.isRecycled() == true) goto L14;
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Throwable -> L16
        r1.inSampleSize = r4;     // Catch: Throwable -> L16
        r1.inPreferredConfig = this.bitmapConfig;     // Catch: Throwable -> L16
        Bitmap r5 = this.decoder.decodeRegion(r3, r1);     // Catch: Throwable -> L16
        if (r5 == null) goto L12;
        getDecodeLock().unlock();
        return r5;
    L12:
        Log.e(TAG, "Skia image decoder returned null bitmap - image format may not be supported");     // Catch: Throwable -> L16
        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        getDecodeLock().unlock();
        throw th;
    }

    @Override // rlb.d
    public Point init(Context r8, Uri r9) throws Exception {
        String r0 = r9.toString();
        if (r0.startsWith(RESOURCE_PREFIX) == false) goto L21;
        String r1 = r9.getAuthority();
        if (r8.getPackageName().equals(r1) == false) goto L7;
        Resources r2 = r8.getResources();
    L8:
        List<String> r10 = r9.getPathSegments();
        int r4 = r10.size();
        if (r4 == 2) goto L11;
    L13:
        if (r4 == 1) goto L15;
    L18:
        int r11 = 0;
    L19:
        this.decoder = BitmapRegionDecoder.newInstance(r8.getResources().openRawResource(r11), false);
    L32:
        return new Point(this.decoder.getWidth(), this.decoder.getHeight());
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ListProtector.get(r10, 0)) == false) goto L18;
        r11 = CastIntegerProtector.parseInt((String) ListProtector.get(r10, 0));     // Catch: NumberFormatException -> L40
    L11:
        if (((String) ListProtector.get(r10, 0)).equals("drawable") == false) goto L13;
        r11 = r2.getIdentifier((String) ListProtector.get(r10, 1), "drawable", r1);
        goto L19
    L7:
        r2 = r8.getPackageManager().getResourcesForApplication(r1);
        goto L8
    L21:
        if (r0.startsWith(ASSET_PREFIX) == false) goto L24;
        String r12 = r0.substring(22);
        this.decoder = BitmapRegionDecoder.newInstance(r8.getAssets().open(r12, 1), false);
        goto L32
    L24:
        if (r0.startsWith("file://") == false) goto L26;
        this.decoder = BitmapRegionDecoder.newInstance(r0.substring(7), false);
        goto L32
    L26:
        InputStream r3 = null;
        InputStream r5 = ContentResolverWrapper.openInputStream(r8.getContentResolver(), r9);     // Catch: Throwable -> L35
        if (r5 == null) goto L33;
        this.decoder = BitmapRegionDecoder.newInstance(r5, false);     // Catch: Throwable -> L35
        r5.close();     // Catch: Exception -> L39
        goto L32
    L33:
        Log.e(TAG, "Content resolver returned null stream. Unable to initialise with uri.");     // Catch: Throwable -> L35
        throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        if (0 != 0) goto L42;
    L38:
        throw th;
    L42:
        r3.close();     // Catch: Exception -> L41
        goto L38
    }
}
