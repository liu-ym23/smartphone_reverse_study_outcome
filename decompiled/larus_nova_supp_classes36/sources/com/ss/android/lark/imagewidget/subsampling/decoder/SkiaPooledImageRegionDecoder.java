package com.ss.android.lark.imagewidget.subsampling.decoder;

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
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import rlb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SkiaPooledImageRegionDecoder implements d {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = null;
    private static boolean debug;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    private c decoderPool;
    private long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    public class a extends PthreadThreadV2 {
        public final /* synthetic */ SkiaPooledImageRegionDecoder v;

        public final void l() {
        L3:
            if (SkiaPooledImageRegionDecoder.access$100(this.v) == null) goto L19;
            SkiaPooledImageRegionDecoder r0 = this.v;
            c r1 = SkiaPooledImageRegionDecoder.access$100(r0);
            monitor-enter(r1);
            int r2 = ((ConcurrentHashMap) r1.b).size();     // Catch: Throwable -> L16
            monitor-exit(r1);
            if (r0.allowAdditionalDecoder(r2, SkiaPooledImageRegionDecoder.access$300(this.v)) == false) goto L31;
        L14:
            e = move-exception;
            SkiaPooledImageRegionDecoder.access$400(this.v, "Failed to start decoder: " + e.getMessage());
            goto L3
        L11:
            if (SkiaPooledImageRegionDecoder.access$100(this.v) == null) goto L3;
            long r3 = System.currentTimeMillis();     // Catch: Exception -> L14
            SkiaPooledImageRegionDecoder.access$400(this.v, "Starting decoder");     // Catch: Exception -> L14
            SkiaPooledImageRegionDecoder.access$500(this.v);     // Catch: Exception -> L14
            long r4 = System.currentTimeMillis();     // Catch: Exception -> L14
            SkiaPooledImageRegionDecoder.access$400(this.v, "Started decoder, took " + (r4 - r3) + "ms");     // Catch: Exception -> L14
            goto L3
        L31:
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(SkiaPooledImageRegionDecoder r1) {
            this.v = r1;
            super("SkiaPooledImageRegionDecoder$1");
        }
    }

    public class b implements FileFilter {
        public b() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r2) {
            return Pattern.matches("cpu[0-9]+", r2.getName());
        }
    }

    public static class c {
        public final Semaphore a;
        public final Map<BitmapRegionDecoder, Boolean> b;

        public final BitmapRegionDecoder d() {
            this.a.acquireUninterruptibly();
            monitor-enter(this);
            Iterator r0 = ((ConcurrentHashMap) this.b).entrySet().iterator();     // Catch: Throwable -> L15
        L6:
            if (r0.hasNext() == false) goto L12;
            Map.Entry r1 = (Map.Entry) r0.next();     // Catch: Throwable -> L15
            if (((Boolean) r1.getValue()).booleanValue() == true) goto L6;
            r1.setValue(Boolean.TRUE);     // Catch: Throwable -> L15
            BitmapRegionDecoder r2 = (BitmapRegionDecoder) r1.getKey();     // Catch: Throwable -> L15
            monitor-exit(this);
            return r2;
        L12:
            monitor-exit(this);
            return null;
        L15:
            th = move-exception;
            throw th;
        }

        public c() {
            this.a = new Semaphore(0, true);
            this.b = new ConcurrentHashMap();
        }

        public static void a(c r2) {
            monitor-enter(r2);
        L12:
        L9:
            th = move-exception;
            throw th;
        L4:
            if (((ConcurrentHashMap) r2.b).isEmpty() == true) goto L7;
            BitmapRegionDecoder r0 = r2.d();     // Catch: Throwable -> L9
            r0.recycle();     // Catch: Throwable -> L9
            ((ConcurrentHashMap) r2.b).remove(r0);     // Catch: Throwable -> L9
            goto L12
        L7:
            monitor-exit(r2);
        }

        public static boolean c(c r1) {
            monitor-enter(r1);
            boolean r0 = ((ConcurrentHashMap) r1.b).isEmpty();     // Catch: Throwable -> L6
            monitor-exit(r1);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public static void b(c r3, BitmapRegionDecoder r4) {
            monitor-enter(r3);
            Iterator r0 = ((ConcurrentHashMap) r3.b).entrySet().iterator();     // Catch: Throwable -> L20
        L5:
            if (r0.hasNext() == false) goto L15;
            Map.Entry r1 = (Map.Entry) r0.next();     // Catch: Throwable -> L20
            if (r4 != r1.getKey()) goto L5;
            if (((Boolean) r1.getValue()).booleanValue() == false) goto L13;
            r1.setValue(Boolean.FALSE);     // Catch: Throwable -> L20
            monitor-exit(r3);
            boolean r5 = true;
        L17:
            if (r5 == false) goto L28;
            r3.a.release();
            return;
        L28:
            return;
        L13:
            monitor-exit(r3);
        L16:
            r5 = false;
            goto L17
        L15:
            monitor-exit(r3);
        L20:
            th = move-exception;
            throw th;
        }
    }

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    private void debug(String r1) {
    }

    @Override // rlb.d
    public synchronized boolean isReady() {
        monitor-enter(this);
        c r0 = this.decoderPool;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        if (c.c(r0) == true) goto L8;
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
        this.decoderLock.writeLock().lock();     // Catch: Throwable -> L13
        c r0 = this.decoderPool;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        c.a(r0);     // Catch: Throwable -> L10
        this.decoderPool = null;     // Catch: Throwable -> L10
        this.context = null;     // Catch: Throwable -> L10
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

    static {
        TAG = "SkiaPooledImageRegionDecoder";
        debug = false;
    }

    private int getNumCoresOldPhones() {
        return new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(new b()).length;
    L4:
        return 1;
    }

    private void initialiseDecoder() throws Exception {
        String r0 = this.uri.toString();
        long r4 = Long.MAX_VALUE;
        if (r0.startsWith(RESOURCE_PREFIX) == false) goto L22;
        String r1 = this.uri.getAuthority();
        if (this.context.getPackageName().equals(r1) == false) goto L7;
        Resources r2 = this.context.getResources();
    L8:
        List<String> r6 = this.uri.getPathSegments();
        int r7 = r6.size();
        if (r7 == 2) goto L11;
    L13:
        if (r7 == 1) goto L15;
    L18:
        int r3 = 0;
    L73:
        r4 = this.context.getResources().openRawResourceFd(r3).getLength();     // Catch: Exception -> L62
    L20:
        BitmapRegionDecoder r5 = BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(r3), false);
    L43:
        this.fileLength = r4;
        this.imageDimensions.set(r5.getWidth(), r5.getHeight());
        this.decoderLock.writeLock().lock();
        c r8 = this.decoderPool;     // Catch: Throwable -> L55
        if (r8 == null) goto L53;
        monitor-enter(r8);     // Catch: Throwable -> L55
        Map<BitmapRegionDecoder, Boolean> r9 = r8.b;     // Catch: Throwable -> L50
        ConcurrentHashMap r10 = (ConcurrentHashMap) r9;     // Catch: Throwable -> L50
        r10.put(r5, Boolean.FALSE);     // Catch: Throwable -> L50
        r8.a.release();     // Catch: Throwable -> L50
        monitor-exit(r8);     // Catch: Throwable -> L55
        goto L53
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L53:
        this.decoderLock.writeLock().unlock();
        return;
    L55:
        th = move-exception;
        this.decoderLock.writeLock().unlock();
        throw th;
    L15:
        if (TextUtils.isDigitsOnly((CharSequence) ListProtector.get(r6, 0)) == false) goto L18;
        r3 = CastIntegerProtector.parseInt((String) ListProtector.get(r6, 0));     // Catch: NumberFormatException -> L63
    L11:
        if (((String) ListProtector.get(r6, 0)).equals("drawable") == false) goto L13;
        r3 = r2.getIdentifier((String) ListProtector.get(r6, 1), "drawable", r1);
        goto L73
    L7:
        r2 = this.context.getPackageManager().getResourcesForApplication(r1);
        goto L8
    L22:
        if (r0.startsWith(ASSET_PREFIX) == false) goto L27;
        String r11 = r0.substring(22);
        r4 = this.context.getAssets().openFd(r11).getLength();     // Catch: Exception -> L64
    L25:
        r5 = BitmapRegionDecoder.newInstance(this.context.getAssets().open(r11, 1), false);
        goto L43
    L27:
        if (r0.startsWith("file://") == false) goto L33;
        BitmapRegionDecoder r12 = BitmapRegionDecoder.newInstance(r0.substring(7), false);
        PolarisFileWrapper r13 = new PolarisFileWrapper(r0);     // Catch: Exception -> L65
        if (r13.exists() == false) goto L32;
        r4 = r13.length();     // Catch: Exception -> L65
    L32:
        r5 = r12;
        goto L43
    L33:
        InputStream r14 = null;
        ContentResolver r15 = this.context.getContentResolver();     // Catch: Throwable -> L58
        r14 = ContentResolverWrapper.openInputStream(r15, this.uri);     // Catch: Throwable -> L58
        BitmapRegionDecoder r16 = BitmapRegionDecoder.newInstance(r14, false);     // Catch: Throwable -> L58
        AssetFileDescriptor r17 = ContentResolverWrapper.openAssetFileDescriptor(r15, this.uri, "r");     // Catch: Exception -> L39 Throwable -> L58
        if (r17 == null) goto L40;
        r4 = r17.getLength();     // Catch: Exception -> L39 Throwable -> L58
    L40:
        if (r14 != null) goto L70;
    L42:
        r5 = r16;
        goto L43
    L70:
        r14.close();     // Catch: Exception -> L66
    L58:
        th = move-exception;
        if (r14 != null) goto L75;
    L61:
        throw th;
    L75:
        r14.close();     // Catch: Exception -> L67
        goto L61
    }

    private boolean isLowMemory() {
        ActivityManager r0 = (ActivityManager) this.context.getSystemService("activity");
        if (r0 == null) goto L6;
        ActivityManager.MemoryInfo r1 = new ActivityManager.MemoryInfo();
        r0.getMemoryInfo(r1);
        return r1.lowMemory;
    L6:
        return true;
    }

    private void lazyInit() {
        if (this.lazyInited.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (this.fileLength >= Long.MAX_VALUE) goto L9;
        debug("Starting lazy init of additional decoders");
        ThreadMethodProxy.start(new a(this));
        return;
    }

    private int getNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config r3) {
        this.decoderPool = new c();
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
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

    public static /* synthetic */ c access$100(SkiaPooledImageRegionDecoder r0) {
        return r0.decoderPool;
    }

    public static /* synthetic */ long access$300(SkiaPooledImageRegionDecoder r2) {
        return r2.fileLength;
    }

    public static /* synthetic */ void access$500(SkiaPooledImageRegionDecoder r0) throws Exception {
        r0.initialiseDecoder();
    }

    public static void setDebug(boolean r0) {
        debug = r0;
    }

    public static /* synthetic */ void access$400(SkiaPooledImageRegionDecoder r0, String r1) {
        r0.debug(r1);
    }

    public boolean allowAdditionalDecoder(int r5, long r6) {
        if (r5 < 4) goto L6;
        debug("No additional decoders allowed, reached hard limit (4)");
        return false;
    L6:
        long r2 = ((long) r5) * r6;
        if (r2 <= 20971520) goto L11;
        debug("No additional encoders allowed, reached hard memory limit (20Mb)");
        return false;
    L11:
        if (r5 < getNumberOfCores()) goto L15;
        debug("No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")");
        return false;
    L15:
        if (isLowMemory() == false) goto L18;
        debug("No additional encoders allowed, memory is low");
        return false;
    L18:
        debug("Additional decoder allowed, current count is " + r5 + ", estimated native memory " + (r2 / 1048576) + "Mb");
        return true;
    }

    @Override // rlb.d
    public Bitmap decodeRegion(Rect r3, int r4) {
        debug("Decode region " + r3 + " on thread " + ThreadMethodProxy.currentThread().getName());
        if (r3.width() >= this.imageDimensions.x) goto L5;
    L6:
        lazyInit();
    L7:
        this.decoderLock.readLock().lock();
        c r0 = this.decoderPool;     // Catch: Throwable -> L28
        if (r0 == null) goto L27;
        BitmapRegionDecoder r1 = r0.d();     // Catch: Throwable -> L28
        if (r1 != null) goto L31;
    L24:
        if (r1 == null) goto L27;
        c.b(this.decoderPool, r1);     // Catch: Throwable -> L28
        goto L27
    L31:
    L21:
        th = move-exception;
        c.b(this.decoderPool, r1);     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L13:
        if (r1.isRecycled() == true) goto L24;
        BitmapFactory.Options r2 = new BitmapFactory.Options();     // Catch: Throwable -> L21
        r2.inSampleSize = r4;     // Catch: Throwable -> L21
        r2.inPreferredConfig = this.bitmapConfig;     // Catch: Throwable -> L21
        Bitmap r5 = r1.decodeRegion(r3, r2);     // Catch: Throwable -> L21
        if (r5 == null) goto L20;
        c.b(this.decoderPool, r1);     // Catch: Throwable -> L28
        this.decoderLock.readLock().unlock();
        return r5;
    L20:
        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");     // Catch: Throwable -> L21
    L27:
        throw new IllegalStateException("Cannot decode region after decoder has been recycled");     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        this.decoderLock.readLock().unlock();
        throw th;
    L5:
        if (r3.height() >= this.imageDimensions.y) goto L7;
        goto L6
    }

    @Override // rlb.d
    public Point init(Context r1, Uri r2) throws Exception {
        this.context = r1;
        this.uri = r2;
        initialiseDecoder();
        return this.imageDimensions;
    }
}
