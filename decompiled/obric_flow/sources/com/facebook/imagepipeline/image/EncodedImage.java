package com.facebook.imagepipeline.image;

import android.graphics.Rect;
import android.util.Pair;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.AlphaChecker;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.AvifFormatUtil;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.DngExifUtil;
import com.facebook.imageutils.HeifExifUtil;
import com.facebook.imageutils.HeifFormatUtil;
import com.facebook.imageutils.ImageMetaData;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class EncodedImage implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CloseableReference f8177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageFormat f8178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8179c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Rect f8183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f8184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f8187o;

    public static class EncodeImagePooledByteBuffer implements PooledByteBuffer, ResourceReleaser<EncodeImagePooledByteBuffer>, MemoryCacheHitTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CloseableReference f8188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f8189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8190c;

        public EncodeImagePooledByteBuffer(CloseableReference r5) {
            this.f8188a = r5;
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public final byte a(int r5) {
            CloseableReference r10 = this.f8188a;
            monitor-enter(r10);
            Object r11 = r10.f7671b.d();     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            return ((PooledByteBuffer) r11).a(r5);
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
        public final void b() {
            this.f8190c = true;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            CloseableReference r5 = this.f8188a;
            monitor-enter(r5);
            Object r10 = r5.f7671b.d();     // Catch: Throwable -> L8
            monitor-exit(r5);     // Catch: Throwable -> L8
            ((PooledByteBuffer) r10).close();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.common.references.ResourceReleaser
        public final void release(Object r5) {
            ((EncodeImagePooledByteBuffer) r5).f8188a.close();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public final int size() {
            CloseableReference r5 = this.f8188a;
            monitor-enter(r5);
            Object r10 = r5.f7671b.d();     // Catch: Throwable -> L8
            monitor-exit(r5);     // Catch: Throwable -> L8
            return ((PooledByteBuffer) r10).size();
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public final int a(int r5, byte[] r10, int r11, int r12) {
            CloseableReference r13 = this.f8188a;
            monitor-enter(r13);
            Object r14 = r13.f7671b.d();     // Catch: Throwable -> L8
            monitor-exit(r13);     // Catch: Throwable -> L8
            return ((PooledByteBuffer) r14).a(r5, r10, r11, r12);
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public final boolean a() {
            CloseableReference r5 = this.f8188a;
            monitor-enter(r5);
            Object r10 = r5.f7671b.d();     // Catch: Throwable -> L8
            monitor-exit(r5);     // Catch: Throwable -> L8
            return ((PooledByteBuffer) r10).a();
        L8:
            th = move-exception;
            throw th;
        }
    }

    public EncodedImage(CloseableReference r5) {
        this.f8178b = ImageFormat.f7971c;
        this.f8179c = -1;
        this.d = 0;
        this.e = -1;
        this.f = -1;
        this.g = 1;
        this.f8180h = -1;
        this.f8181i = true;
        this.f8182j = 0;
        this.f8185m = false;
        this.f8186n = false;
        if (CloseableReference.b(r5) == false) goto L18;
        monitor-enter(r5);
        Object r10 = r5.f7671b.d();     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        PooledByteBuffer r11 = (PooledByteBuffer) r10;
        if ((r11 instanceof EncodeImagePooledByteBuffer) == false) goto L12;
        this.f8177a = r5.clone();
        EncodeImagePooledByteBuffer r12 = (EncodeImagePooledByteBuffer) r11;
        this.f8184l = r12.f8189b;
        if (r12.f8190c == false) goto L21;
        this.f8186n = true;
        this.f8185m = false;
        r12.f8190c = false;
        return;
    L21:
        return;
    L12:
        this.f8177a = CloseableReference.a(new EncodeImagePooledByteBuffer(r5.clone()), CloseableReference.e, CloseableReference.f);
        return;
    L14:
        th = move-exception;
        throw th;
    L18:
        throw new IllegalArgumentException();
    }

    public static EncodedImage a(EncodedImage r5) {
        EncodedImage r10 = null;
        if (r5 == null) goto L19;
        CloseableReference r11 = r5.f8177a;
        if (r11 == null) goto L7;
        CloseableReference r12 = r11.b();
    L8:
        if (r12 != null) goto L20;
    L11:
        if (r12 == null) goto L13;
        r12.close();
    L13:
        if (r10 == null) goto L15;
        r10.b(r5);
    L15:
        return r10;
    L20:
        r10 = new EncodedImage(r12);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r12.close();
        throw th;
    L7:
        r12 = null;
        goto L8
    L19:
        return null;
    }

    public final String b() {
        CloseableReference r5 = this.f8177a;
        if (r5 == null) goto L5;
        CloseableReference r10 = r5.b();
    L6:
        if (r10 != null) goto L9;
        return "";
    L9:
        int r11 = Math.min(d(), 10);
        byte[] r12 = new byte[r11];
        monitor-enter(r10);     // Catch: Throwable -> L18
        Object r13 = r10.f7671b.d();     // Catch: Throwable -> L27
        monitor-exit(r10);     // Catch: Throwable -> L27
        PooledByteBuffer r14 = (PooledByteBuffer) r13;     // Catch: Throwable -> L18
        if (r14 == null) goto L16;
        int r15 = 0;
        r14.a(0, r12, 0, r11);     // Catch: Throwable -> L18
        r10.close();
        StringBuilder r16 = new StringBuilder(r11 * 2);
    L23:
        if (r15 >= r11) goto L26;
        r16.append(String.format("%02X", new Object[]{Byte.valueOf(r12[r15])}));
        r15 = r15 + 1;
        goto L23
    L26:
        return r16.toString();
    L16:
        r10.close();
        return "";
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r10.close();
        throw th;
    L5:
        r10 = null;
        goto L6
    }

    public final InputStream c() {
        CloseableReference r5 = this.f8177a;
        if (r5 == null) goto L5;
        CloseableReference r10 = r5.b();
    L6:
        if (r10 != null) goto L22;
        return null;
    L22:
    L14:
        th = move-exception;
        r10.close();
        throw th;
    L8:
        monitor-enter(r10);     // Catch: Throwable -> L14
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        PooledByteBufferInputStream r12 = new PooledByteBufferInputStream((PooledByteBuffer) r11);     // Catch: Throwable -> L14
        r10.close();
        return r12;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L5:
        r10 = null;
        goto L6
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        CloseableReference r5 = this.f8177a;
        if (r5 == null) goto L6;
        r5.close();
        return;
    }

    public final int d() {
        CloseableReference r5 = this.f8177a;
        if (r5 == null) goto L14;
        monitor-enter(r5);
        Object r10 = r5.f7671b.d();     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        if (r10 == null) goto L14;
        return ((PooledByteBuffer) this.f8177a.c()).size();
    L10:
        th = move-exception;
        throw th;
    L14:
        return this.f8180h;
    }

    public final synchronized boolean e() {
        monitor-enter(this);
        boolean r5 = CloseableReference.b(this.f8177a);     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r5 == true) goto L8;
        return false;
    L8:
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.util.Pair] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v35, types: [android.util.Pair] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v40, types: [android.util.Pair] */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v7 */
    public final void f() {
        ImageFormat r5 = ImageFormatChecker.a(c());     // Catch: IOException -> L247
        this.f8178b = r5;
        Rect r10 = null;
        InputStream r11 = null;
        r10 = null;
        r10 = null;
        boolean r12 = true;
        if (DefaultImageFormats.b(r5) == false) goto L7;
    L110:
        InputStream r13 = c();
        byte[] r14 = new byte[4];
        PooledByteBufferInputStream r15 = (PooledByteBufferInputStream) r13;     // Catch: Throwable -> L120 IOException -> L122
        r15.getClass();     // Catch: Throwable -> L120 IOException -> L122
        r15.read(r14, 0, 4);     // Catch: Throwable -> L120 IOException -> L122
        int r16 = 0;
    L262:
        if (r16 >= 4) goto L124;
        if ("RIFF".charAt(r16) != r14[r16]) goto L115;
        r16 = r16 + 1;
        goto L262
    L115:
        r13.close();     // Catch: IOException -> L117
    L261:
    L161:
        ?? r17 = 0;
    L162:
        if (r17 == 0) goto L164;
        this.e = ((Integer) ((Pair) r17).first).intValue();
        this.f = ((Integer) ((Pair) r17).second).intValue();
    L164:
        ImageFormat r18 = DefaultImageFormats.f7962a;
        if (r5 != r18) goto L171;
        if (this.f8179c != (-1)) goto L171;
        if (r17 == 0) goto L183;
        int r19 = JfifUtil.a(c());
        this.d = r19;
        this.f8179c = JfifUtil.a(r19);
    L183:
        InputStream r20 = c();
        if (r5 != r18) goto L276;
    L229:
        r12 = false;
    L230:
        this.f8181i = r12;
        Map r21 = this.f8184l;
        if (r21 != null) goto L233;
    L239:
        this.f8183k = r10;
        return;
    L233:
        if (r21.isEmpty() == true) goto L239;
        String r22 = (String) r21.get("regionToDecode");
        if (r22 == null) goto L239;
        r10 = Rect.unflattenFromString(r22);
        goto L239
    L276:
        if (r5 == DefaultImageFormats.f) goto L229;
        if (r5 == DefaultImageFormats.f7965h) goto L229;
        if (r5 == DefaultImageFormats.f7969l) goto L230;
        if (r5 == DefaultImageFormats.f7964c) goto L230;
        if (r5 == DefaultImageFormats.f7968k) goto L230;
        if (r5 == DefaultImageFormats.d) goto L230;
        if (r5 == DefaultImageFormats.e) goto L230;
        if (r5 == DefaultImageFormats.f7966i) goto L230;
        if (r5 != DefaultImageFormats.f7963b) goto L210;
        byte[] r23 = new byte[29];     // Catch: IOException -> L251
        AlphaChecker.a(29, r20, r23);     // Catch: IOException -> L251
        byte r24 = r23[25];     // Catch: IOException -> L251
        if (r24 == 4) goto L230;
        if (r24 != 6) goto L229;
    L210:
        if (r5 != DefaultImageFormats.f7967j) goto L230;
        monitor-enter(ImageFormatChecker.class);     // Catch: IOException -> L251
    L216:
        th = move-exception;
        throw th;     // Catch: IOException -> L251
    L214:
        if (ImageFormatChecker.f7974c != null) goto L218;
        ImageFormatChecker.f7974c = new ImageFormatChecker();     // Catch: Throwable -> L216
    L218:
        ImageFormatChecker r25 = ImageFormatChecker.f7974c;     // Catch: Throwable -> L216
        monitor-exit(ImageFormatChecker.class);     // Catch: Throwable -> L216
        int r26 = r25.f7975a;     // Catch: IOException -> L251
        byte[] r27 = new byte[r26];     // Catch: IOException -> L251
        AlphaChecker.a(r26, r20, r27);     // Catch: IOException -> L251
        boolean r28 = WebpSupportStatus.a(r27, 12, WebpSupportStatus.f);     // Catch: IOException -> L251
        if ((r27[20] & 16) != 16) goto L223;
        boolean r29 = true;
    L224:
        if (r28 == false) goto L229;
        if (r29 == false) goto L229;
    L223:
        r29 = false;
        goto L224
    L171:
        if (r5 != DefaultImageFormats.f7968k) goto L176;
        if (this.f8179c != (-1)) goto L176;
        int r30 = HeifExifUtil.a(c());
        this.d = r30;
        this.f8179c = JfifUtil.a(r30);
    L176:
        if (r5 != DefaultImageFormats.f7970m) goto L181;
        if (this.f8179c != (-1)) goto L181;
        int r31 = DngExifUtil.a(c());
        this.d = r31;
        this.f8179c = JfifUtil.a(r31);
    L181:
        if (this.f8179c != (-1)) goto L183;
        this.f8179c = 0;
        goto L183
    L124:
        r13.read();     // Catch: Throwable -> L120 IOException -> L122
        r13.read();     // Catch: Throwable -> L120 IOException -> L122
        r13.read();     // Catch: Throwable -> L120 IOException -> L122
        r13.read();     // Catch: Throwable -> L120 IOException -> L122
        ((PooledByteBufferInputStream) r13).read(r14, 0, 4);     // Catch: Throwable -> L120 IOException -> L122
        int r32 = 0;
    L125:
        if (r32 >= 4) goto L131;
        if ("WEBP".charAt(r32) != r14[r32]) goto L128;
        r32 = r32 + 1;
        goto L125
    L128:
        r13.close();     // Catch: IOException -> L117
        goto L261
    L131:
        ((PooledByteBufferInputStream) r13).read(r14, 0, 4);     // Catch: Throwable -> L120 IOException -> L122
        StringBuilder r33 = new StringBuilder();     // Catch: Throwable -> L120 IOException -> L122
        int r34 = 0;
    L132:
        if (r34 >= 4) goto L134;
        r33.append((char) r14[r34]);     // Catch: Throwable -> L120 IOException -> L122
        r34 = r34 + 1;     // Catch: Throwable -> L120 IOException -> L122
        goto L132
    L134:
        r17 = r33.toString();     // Catch: Throwable -> L120 IOException -> L122
        if ("VP8 ".equals(r17) == false) goto L142;
        Pair r35 = WebpUtil.a(r13);     // Catch: Throwable -> L120 IOException -> L122
        r13.close();     // Catch: IOException -> L139
        r17 = r35;
    L292:
        goto L162
    L142:
        if ("VP8L".equals(r17) == false) goto L147;
        Pair r36 = WebpUtil.b(r13);     // Catch: Throwable -> L120 IOException -> L122
        r13.close();     // Catch: IOException -> L139
        r17 = r36;
        goto L292
    L147:
        if ("VP8X".equals(r17) == false) goto L152;
        r13.skip(8);     // Catch: Throwable -> L120 IOException -> L122
        Pair r37 = new Pair(Integer.valueOf(WebpUtil.c(r13) + 1), Integer.valueOf(WebpUtil.c(r13) + 1));     // Catch: Throwable -> L120 IOException -> L122
        r13.close();     // Catch: IOException -> L139
        r17 = r37;
        goto L292
    L152:
        r13.close();     // Catch: IOException -> L154
    L288:
    L139:
        e = e;
    L151:
        e.printStackTrace();
    L117:
        e = e;
        r17 = 0;
    L122:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L120
        if (r13 == null) goto L161;
        r13.close();     // Catch: IOException -> L154
    L154:
        e = move-exception;
        e.printStackTrace();
    L120:
        th = move-exception;
        if (r13 != null) goto L270;
    L246:
        throw th;
    L270:
        r13.close();     // Catch: IOException -> L244
    L244:
        e = move-exception;
        e.printStackTrace();
        goto L246
    L7:
        if (r5 == DefaultImageFormats.f7967j) goto L110;
        int r38 = 8;
        if (DefaultImageFormats.a(r5) == false) goto L40;
        InputStream r39 = c();
        int[] r110 = HeifFormatUtil.a(r39);     // Catch: Throwable -> L30 Exception -> L32
        if (r110 == null) goto L278;
        this.e = r110[0];     // Catch: Throwable -> L30 Exception -> L32
        this.f = r110[1];     // Catch: Throwable -> L30 Exception -> L32
        int r40 = Math.abs(360 - r110[2]) % 360;     // Catch: Throwable -> L30 Exception -> L32
        this.f8179c = r40;     // Catch: Throwable -> L30 Exception -> L32
        if (r40 != 0) goto L17;
        r38 = 1;
    L26:
        this.d = r38;     // Catch: Throwable -> L30 Exception -> L32
        if (r110[3] != 0) goto L278;
        this.f8178b = HeifFormatUtil.a();     // Catch: Throwable -> L30 Exception -> L32
    L17:
        if (r40 != 90) goto L19;
        r38 = 6;
        goto L26
    L19:
        if (r40 != 180) goto L21;
        r38 = 3;
        goto L26
    L21:
        if (r40 == 270) goto L26;
        r38 = 0;
    L278:
        r39.close();     // Catch: IOException -> L250
    L88:
        r17 = 0;
    L30:
        th = move-exception;
        if (r39 != null) goto L259;
    L39:
        throw th;
    L259:
        r39.close();     // Catch: IOException -> L252
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
        if (r39 == null) goto L88;
    L40:
        ImageFormat r41 = AvifFormatUtil.f8449b;
        if (r41 != null) goto L52;
        Class r42 = AvifFormatUtil.f8448a;
        if (r42 != null) goto L303;
        r41 = ImageFormat.f7971c;
        goto L52
    L303:
        AvifFormatUtil.f8449b = (ImageFormat) r42.getDeclaredField("AVIF_FORMAT").get(null);     // Catch: Throwable -> L48 IllegalAccessException -> L49 NoSuchFieldException -> L50
    L51:
        r41 = AvifFormatUtil.f8449b;
        goto L52
    L49:
        FLog.b("AvifFormatUtil", "IllegalAccessException happened when invoke getAvifFormat");
    L50:
        FLog.b("AvifFormatUtil", "No AVIF_FORMAT field In AvifDecoder");
    L48:
        FLog.b("AvifFormatUtil", "Exception happened when invoke getAvifFormat");
    L52:
        if (r5 == r41) goto L67;
        ImageFormat r43 = AvifFormatUtil.f8450c;
        if (r43 != null) goto L66;
        Class r44 = AvifFormatUtil.f8448a;
        if (r44 != null) goto L301;
        r43 = ImageFormat.f7971c;
        goto L66
    L301:
        AvifFormatUtil.f8450c = (ImageFormat) r44.getDeclaredField("AVIF_FORMAT_ANIMATED").get(null);     // Catch: Throwable -> L62 IllegalAccessException -> L63 NoSuchFieldException -> L64
    L65:
        r43 = AvifFormatUtil.f8450c;
        goto L66
    L63:
        FLog.b("AvifFormatUtil", "IllegalAccessException happened when invoke getAvifFormatAnimated");
    L64:
        FLog.b("AvifFormatUtil", "No AVIF_FORMAT_ANIMATED field In AvifDecoder");
    L62:
        FLog.b("AvifFormatUtil", "Exception happened when invoke getAvifFormatAnimated");
    L66:
        if (r5 == r43) goto L67;
        InputStream r45 = c();     // Catch: Throwable -> L106
        ImageMetaData r46 = BitmapUtil.a(r45);     // Catch: Throwable -> L102
        Pair r47 = r46.f8456a;     // Catch: Throwable -> L102
        if (r47 == null) goto L274;
        this.e = ((Integer) r47.first).intValue();     // Catch: Throwable -> L102
        this.f = ((Integer) r47.second).intValue();     // Catch: Throwable -> L102
    L274:
        r45.close();     // Catch: IOException -> L253
    L105:
        r17 = r46.f8456a;
    L102:
        th = th;
        r11 = r45;
    L107:
        if (r11 != null) goto L290;
    L109:
        throw th;
    L290:
        r11.close();     // Catch: IOException -> L254
    L106:
        th = th;
    L67:
        InputStream r48 = c();
        FrescoSystrace.a().getClass();     // Catch: Throwable -> L82 Exception -> L84
        int[] r111 = AvifFormatUtil.a(r48);     // Catch: Throwable -> L82 Exception -> L84
        if (r111 == null) goto L282;
        this.e = r111[0];     // Catch: Throwable -> L82 Exception -> L84
        this.f = r111[1];     // Catch: Throwable -> L82 Exception -> L84
        int r112 = r111[2];     // Catch: Throwable -> L82 Exception -> L84
        if (r112 == 0) goto L78;
        if (r112 == 1) goto L79;
        if (r112 == 2) goto L77;
        if (r112 == 3) goto L76;
        r38 = 0;
        goto L79
    L76:
        r38 = 6;
        goto L79
    L77:
        r38 = 3;
    L79:
        this.d = r38;     // Catch: Throwable -> L82 Exception -> L84
        this.f8179c = JfifUtil.a(r38);     // Catch: Throwable -> L82 Exception -> L84
        r17 = new Pair(Integer.valueOf(r111[0]), Integer.valueOf(r111[1]));     // Catch: Throwable -> L82 Exception -> L84
    L272:
        r48.close();     // Catch: IOException -> L255
    L81:
        FrescoSystrace.a().getClass();
        goto L164
    L78:
        r38 = 1;
        goto L79
    L282:
        r48.close();     // Catch: IOException -> L256
    L87:
        FrescoSystrace.a().getClass();
    L84:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L82
        if (r48 != null) goto L295;
    L92:
        FrescoSystrace.a().getClass();
        goto L88
    L295:
        r48.close();     // Catch: IOException -> L258
    L82:
        th = move-exception;
        if (r48 != null) goto L284;
    L95:
        FrescoSystrace.a().getClass();
        throw th;
    L284:
        r48.close();     // Catch: IOException -> L257
    L247:
        e = move-exception;
        Throwables.a(e, Error.class);
        Throwables.a(e, RuntimeException.class);
        throw new RuntimeException(e);
    }

    public final void g() {
        if (this.e >= 0) goto L5;
    L8:
        f();
        return;
    L5:
        if (this.f < 0) goto L8;
    }

    public final void a(Map r5) {
        this.f8184l = r5;
        CloseableReference r10 = this.f8177a;
        if (r10 == null) goto L14;
        monitor-enter(r10);
        Object r11 = r10.f7671b.d();     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        if ((r11 instanceof EncodeImagePooledByteBuffer) == false) goto L17;
        ((EncodeImagePooledByteBuffer) this.f8177a.c()).f8189b = r5;
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean c(EncodedImage r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.e() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final void b(EncodedImage r5) {
        r5.g();
        this.f8178b = r5.f8178b;
        r5.g();
        this.e = r5.e;
        r5.g();
        this.f = r5.f;
        r5.g();
        this.f8179c = r5.f8179c;
        r5.g();
        this.d = r5.d;
        this.g = r5.g;
        this.f8180h = r5.d();
        r5.g();
        this.f8181i = r5.f8181i;
        this.f8182j = r5.f8182j;
        this.f8183k = r5.f8183k;
        this.f8184l = r5.f8184l;
        this.f8185m = r5.f8185m;
        this.f8186n = r5.f8186n;
    }
}
