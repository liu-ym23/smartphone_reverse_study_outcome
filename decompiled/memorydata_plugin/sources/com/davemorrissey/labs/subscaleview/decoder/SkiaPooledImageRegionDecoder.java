package com.davemorrissey.labs.subscaleview.decoder;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class SkiaPooledImageRegionDecoder implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "SkiaPooledImageRegionDecoder";
    private static boolean debug = false;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    private DecoderPool decoderPool;
    private long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    private static class DecoderPool {
        private final Semaphore available;
        private final Map<BitmapRegionDecoder, Boolean> decoders;

        private DecoderPool() {
            this.available = new Semaphore(0, true);
            this.decoders = new ConcurrentHashMap();
        }

        /* synthetic */ DecoderPool(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void access$1000(DecoderPool r0) {
            r0.recycle();
        }

        static /* synthetic */ int access$200(DecoderPool r0) {
            return r0.size();
        }

        static /* synthetic */ void access$600(DecoderPool r0, BitmapRegionDecoder r1) {
            r0.add(r1);
        }

        static /* synthetic */ BitmapRegionDecoder access$700(DecoderPool r0) {
            return r0.acquire();
        }

        static /* synthetic */ void access$800(DecoderPool r0, BitmapRegionDecoder r1) {
            r0.release(r1);
        }

        static /* synthetic */ boolean access$900(DecoderPool r0) {
            return r0.isEmpty();
        }

        private BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        private synchronized void add(BitmapRegionDecoder r3) {
            monitor-enter(this);
            this.decoders.put(r3, false);     // Catch: Throwable -> L6
            this.available.release();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized BitmapRegionDecoder getNextAvailable() {
            monitor-enter(this);
            Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> r0 = this.decoders.entrySet().iterator();     // Catch: Throwable -> L14
        L5:
            if (r0.hasNext() == false) goto L12;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            if (((Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
            r1.setValue(true);     // Catch: Throwable -> L14
            BitmapRegionDecoder r2 = (BitmapRegionDecoder) ZeusTransformUtils.preCheckCast(r1.getKey(), BitmapRegionDecoder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            monitor-exit(this);
            return r2;
        L12:
            monitor-exit(this);
            return null;
        L14:
            th = move-exception;
            throw th;
        }

        private synchronized boolean isEmpty() {
            monitor-enter(this);
            boolean r0 = this.decoders.isEmpty();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized boolean markAsUnused(BitmapRegionDecoder r6) {
            monitor-enter(this);
            Iterator<Map.Entry<BitmapRegionDecoder, Boolean>> r0 = this.decoders.entrySet().iterator();     // Catch: Throwable -> L18
        L5:
            if (r0.hasNext() == false) goto L16;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
            if (r6 != r1.getKey()) goto L5;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r1.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L14;
            r1.setValue(false);     // Catch: Throwable -> L18
            monitor-exit(this);
            return true;
        L14:
            monitor-exit(this);
            return false;
        L16:
            monitor-exit(this);
            return false;
        L18:
            th = move-exception;
            throw th;
        }

        private synchronized void recycle() {
            monitor-enter(this);
        L12:
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.decoders.isEmpty() == true) goto L7;
            BitmapRegionDecoder r0 = acquire();     // Catch: Throwable -> L9
            r0.recycle();     // Catch: Throwable -> L9
            this.decoders.remove(r0);     // Catch: Throwable -> L9
            goto L12
        L7:
            monitor-exit(this);
        }

        private void release(BitmapRegionDecoder r1) {
            if (markAsUnused(r1) == false) goto L6;
            this.available.release();
            return;
        }

        private synchronized int size() {
            monitor-enter(this);
            int r0 = this.decoders.size();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config r3) {
        this.decoderPool = new DecoderPool(null);
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
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

    static /* synthetic */ DecoderPool access$100(SkiaPooledImageRegionDecoder r0) {
        return r0.decoderPool;
    }

    static /* synthetic */ long access$300(SkiaPooledImageRegionDecoder r2) {
        return r2.fileLength;
    }

    static /* synthetic */ void access$400(SkiaPooledImageRegionDecoder r0, String r1) {
        r0.debug(r1);
    }

    static /* synthetic */ void access$500(SkiaPooledImageRegionDecoder r0) {
        r0.initialiseDecoder();
    }

    private void debug(String r1) {
        if (debug == false) goto L6;
        Log.d(TAG, r1);
        return;
    }

    private int getNumCoresOldPhones() {
        return new File("/sys/devices/system/cpu/").listFiles(new C1CpuFilter(this)).length;
    L4:
        return 1;
    }

    private int getNumberOfCores() {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Runtime.getRuntime().availableProcessors();
    L7:
        return getNumCoresOldPhones();
    }

    private void initialiseDecoder() {
        String r0 = this.uri.toString();
        long r4 = Long.MAX_VALUE;
        if (r0.startsWith(RESOURCE_PREFIX) == false) goto L22;
        String r1 = this.uri.getAuthority();
        if (this.context.getPackageName().equals(r1) == false) goto L7;
        Resources r2 = ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin");
    L8:
        List<String> r7 = this.uri.getPathSegments();
        int r8 = r7.size();
        if (r8 == 2) goto L11;
    L13:
        if (r8 == 1) goto L15;
    L18:
        int r3 = 0;
    L62:
        r4 = ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").openRawResourceFd(r3).getLength();     // Catch: Exception -> L55
    L20:
        InputStream r5 = ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").openRawResource(r3);
    L26:
        BitmapRegionDecoder r6 = BitmapRegionDecoder.newInstance(r5, false);
    L42:
        this.fileLength = r4;
        this.imageDimensions.set(r6.getWidth(), r6.getHeight());
        this.decoderLock.writeLock().lock();
        DecoderPool r9 = this.decoderPool;     // Catch: Throwable -> L48
        if (r9 == null) goto L46;
        DecoderPool.access$600(r9, r6);     // Catch: Throwable -> L48
    L46:
        this.decoderLock.writeLock().unlock();
        return;
    L48:
        th = move-exception;
        this.decoderLock.writeLock().unlock();
        throw th;
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ZeusTransformUtils.preCheckCast(r7.get(0), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L18;
        r3 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.memorydata.plugin"));     // Catch: NumberFormatException -> L56
    L11:
        if (((String) ZeusTransformUtils.preCheckCast(r7.get(0), String.class, "com.obric.memorydata.plugin")).equals("drawable") == false) goto L13;
        r3 = ZeusTransformUtils.getIdentifier(r2, (String) ZeusTransformUtils.preCheckCast(r7.get(1), String.class, "com.obric.memorydata.plugin"), "drawable", r1, "com.obric.memorydata.plugin");
        goto L62
    L7:
        r2 = this.context.getPackageManager().getResourcesForApplication(r1);
        goto L8
    L22:
        if (r0.startsWith(ASSET_PREFIX) == false) goto L28;
        String r10 = r0.substring(22);
        r4 = this.context.getAssets().openFd(r10).getLength();     // Catch: Exception -> L57
    L25:
        r5 = this.context.getAssets().open(r10, 1);
        goto L26
    L28:
        if (r0.startsWith(FILE_PREFIX) == false) goto L34;
        BitmapRegionDecoder r11 = BitmapRegionDecoder.newInstance(r0.substring(7), false);
        File r12 = new File(r0);     // Catch: Exception -> L58
        if (r12.exists() == false) goto L33;
        r4 = r12.length();     // Catch: Exception -> L58
    L33:
        r6 = r11;
        goto L42
    L34:
        InputStream r13 = null;
        ContentResolver r14 = this.context.getContentResolver();     // Catch: Throwable -> L51
        r13 = r14.openInputStream(this.uri);     // Catch: Throwable -> L51
        BitmapRegionDecoder r15 = BitmapRegionDecoder.newInstance(r13, false);     // Catch: Throwable -> L51
        AssetFileDescriptor r16 = r14.openAssetFileDescriptor(this.uri, "r");     // Catch: Exception -> L59 Throwable -> L51
        if (r16 == null) goto L39;
        r4 = r16.getLength();     // Catch: Exception -> L59 Throwable -> L51
    L39:
        if (r13 != null) goto L66;
    L41:
        r6 = r15;
        goto L42
    L66:
        r13.close();     // Catch: Exception -> L60
    L51:
        th = move-exception;
        if (r13 != null) goto L72;
    L54:
        throw th;
    L72:
        r13.close();     // Catch: Exception -> L61
        goto L54
    }

    private boolean isLowMemory() {
        ActivityManager r2 = (ActivityManager) ZeusTransformUtils.preCheckCast(this.context.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        ActivityManager.MemoryInfo r0 = new ActivityManager.MemoryInfo();
        r2.getMemoryInfo(r0);
        return r0.lowMemory;
    L6:
        return true;
    }

    private void lazyInit() {
        if (this.lazyInited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.fileLength >= Long.MAX_VALUE) goto L9;
        debug("Starting lazy init of additional decoders");
        new AnonymousClass1(this).start();
        return;
    }

    public static void setDebug(boolean r0) {
        debug = r0;
    }

    public boolean allowAdditionalDecoder(int r4, long r5) {
        if (r4 < 4) goto L7;
        String r6 = "No additional decoders allowed, reached hard limit (4)";
    L5:
        debug(r6);
        return false;
    L7:
        long r1 = ((long) r4) * r5;
        if (r1 <= 20971520) goto L11;
        r6 = "No additional encoders allowed, reached hard memory limit (20Mb)";
        goto L5
    L11:
        if (r4 < getNumberOfCores()) goto L14;
        r6 = "No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")";
        goto L5
    L14:
        if (isLowMemory() == false) goto L16;
        r6 = "No additional encoders allowed, memory is low";
        goto L5
    L16:
        debug("Additional decoder allowed, current count is " + r4 + ", estimated native memory " + (r1 / 1048576) + "Mb");
        return true;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Bitmap decodeRegion(Rect r3, int r4) {
        debug("Decode region " + r3 + " on thread " + Thread.currentThread().getName());
        if (r3.width() >= this.imageDimensions.x) goto L5;
    L6:
        lazyInit();
    L7:
        this.decoderLock.readLock().lock();
        DecoderPool r0 = this.decoderPool;     // Catch: Throwable -> L30
        if (r0 == null) goto L29;
        BitmapRegionDecoder r1 = DecoderPool.access$700(r0);     // Catch: Throwable -> L30
        if (r1 != null) goto L33;
    L26:
        if (r1 == null) goto L29;
        DecoderPool.access$800(this.decoderPool, r1);     // Catch: Throwable -> L30
        goto L29
    L33:
    L22:
        th = move-exception;
        if (r1 == null) goto L25;
        DecoderPool.access$800(this.decoderPool, r1);     // Catch: Throwable -> L30
    L25:
        throw th;     // Catch: Throwable -> L30
    L13:
        if (r1.isRecycled() == true) goto L26;
        BitmapFactory.Options r2 = new BitmapFactory.Options();     // Catch: Throwable -> L22
        r2.inSampleSize = r4;     // Catch: Throwable -> L22
        r2.inPreferredConfig = this.bitmapConfig;     // Catch: Throwable -> L22
        Bitmap r5 = r1.decodeRegion(r3, r2);     // Catch: Throwable -> L22
        if (r5 == null) goto L21;
        if (r1 == null) goto L18;
        DecoderPool.access$800(this.decoderPool, r1);     // Catch: Throwable -> L30
    L18:
        this.decoderLock.readLock().unlock();
        return r5;
    L21:
        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");     // Catch: Throwable -> L22
    L29:
        throw new IllegalStateException("Cannot decode region after decoder has been recycled");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.decoderLock.readLock().unlock();
        throw th;
    L5:
        if (r3.height() >= this.imageDimensions.y) goto L7;
        goto L6
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public Point init(Context r3, Uri r4) {
        this.context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.uri = r4;
        initialiseDecoder();
        return this.imageDimensions;
    }

    @Override // com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder
    public synchronized boolean isReady() {
        monitor-enter(this);
        DecoderPool r0 = this.decoderPool;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        if (DecoderPool.access$900(r0) == true) goto L8;
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
        this.decoderLock.writeLock().lock();     // Catch: Throwable -> L13
        DecoderPool r0 = this.decoderPool;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        DecoderPool.access$1000(r0);     // Catch: Throwable -> L10
        this.decoderPool = null;     // Catch: Throwable -> L10
        this.context = ZeusTransformUtils.wrapperContext(null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        this.uri = null;     // Catch: Throwable -> L10
    L7:
        this.decoderLock.writeLock().unlock();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        this.decoderLock.writeLock().unlock();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
