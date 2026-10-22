package com.larus.uaigc.helper;

import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.platform.model.upload.ImageInstantUploadPolicyFamily;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
import com.larus.utils.logger.FLogger;
import hq9.i4;
import hq9.s1;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationImageUploadPolicy implements com.larus.uaigc.utils.a {
    public static final CreationImageUploadPolicy a = null;
    public static final String b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final d e = null;
    public static final Lazy f = null;

    public static final class a {
        public final Bitmap.CompressFormat a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "EffectiveCompressParams(effectiveFormat=" + this.a + ", effectiveQuality=" + this.b + ')';
        }

        public a(Bitmap.CompressFormat r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "effectiveFormat");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final ic8.n0 a;
        public final long b;
        public final String c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            ic8.n0 r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            long r2 = this.b;
            return (((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.c.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReusablePreprocessResult(cachedProcessFileResult=" + this.a + ", sourceFileSize=" + this.b + ", sourceMd5=" + this.c + ')';
        }

        public b(ic8.n0 r2, long r3, String r5) {
            Intrinsics.checkNotNullParameter(r5, "sourceMd5");
            this.a = r2;
            this.b = r3;
            this.c = r5;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProcessFileResultCode.values().length];
            r0[ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ProcessFileResultCode.PREPARE_GIF_PROCESS_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ProcessFileResultCode.PREPARE_CLONE_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r4, Throwable r5) {
            FLogger.a.e(CreationImageUploadPolicy.b, "err! msg=" + r5);
        }
    }

    public CreationImageUploadPolicy() {
    }

    static {
        a = new CreationImageUploadPolicy();
        b = "CreationImageUploadPolicy";
        c = LazyKt.lazy(new r());
        d = LazyKt.lazy(new s());
        e = new d(CoroutineExceptionHandler.Key);
        f = LazyKt.lazy(new t());
    }

    public static s1 d() {
        return (s1) c.getValue();
    }

    public static Bitmap.CompressFormat f(String r2) {
        switch(r2.hashCode()) {
            case -1638728877: goto L21;
            case 105441: goto L17;
            case 111145: goto L13;
            case 1520992383: goto L6;
            default: goto L27;
        };
    L27:
        return null;
    L6:
        if (r2.equals("webp_lossless") == false) goto L27;
        if (Build.VERSION.SDK_INT < 30) goto L30;
        return Bitmap.CompressFormat.WEBP_LOSSLESS;
    L30:
        return Bitmap.CompressFormat.WEBP;
    L13:
        if (r2.equals("png") == false) goto L27;
        return Bitmap.CompressFormat.PNG;
    L17:
        if (r2.equals("jpg") == false) goto L27;
        return Bitmap.CompressFormat.JPEG;
    L21:
        if (r2.equals("webp_lossy") == false) goto L27;
        if (Build.VERSION.SDK_INT < 30) goto L34;
        return Bitmap.CompressFormat.WEBP_LOSSY;
    L34:
        return Bitmap.CompressFormat.WEBP;
    }

    public static ParcelFileDescriptor b(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static void g(ic8.n0 r17, ns8.a r18) {
        ic8.m0 r2 = r17.a;
        if (r2 == null) goto L145;
        mr9.c r3 = r2.l;
        if (r3 != null) goto L133;
        int r4 = g.a;
        ProcessFileResultCode r0 = r17.b;
        if (r0 != null) goto L9;
        int r5 = -1;
    L10:
        String r11 = "jpeg";
        if (r5 == 1) goto L53;
        if (r5 == 2) goto L39;
        if (r5 == 3) goto L38;
        if (r5 == 4) goto L38;
        if (r5 != 5) goto L37;
        String r1 = r2.a;
        if (r1 != null) goto L20;
    L34:
        boolean r6 = true;
    L35:
        if (r6 == false) goto L37;
        Map r7 = g.a(r0);
    L130:
        if (r7 != null) goto L132;
        r3 = null;
        goto L133
    L132:
        r3 = new mr9.c(ImageInstantUploadPolicyFamily.IMAGE_CREATION, 1, r7);
        goto L133
    L20:
        if ((!StringsKt.isBlank(r1)) == true) goto L23;
        r1 = null;
    L23:
        if (r1 == null) goto L34;
        String r8 = r2.e;
        if (r8 == null) goto L34;
        if ((!StringsKt.isBlank(r8)) == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L34;
        r6 = Intrinsics.areEqual(r1, r8);
    L37:
        r7 = null;
    L38:
        r7 = g.a(r0);
        goto L130
    L39:
        Pair[] r9 = new Pair[5];
        r9[0] = TuplesKt.to("data_type", UploadDataType.IMAGE.getType());
        r9[1] = TuplesKt.to("transform", "gif_first_frame");
        r9[2] = TuplesKt.to("output_format", "jpeg");
        r9[3] = TuplesKt.to("quality", "100");
        if (r0 == null) goto L42;
        String r10 = r0.getValue();
    L43:
        r9[4] = TuplesKt.to("result_code", r10);
        LinkedHashMap r12 = MapsKt.linkedMapOf(r9);
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r12.entrySet().iterator();
    L45:
        if (r14.hasNext() == false) goto L52;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (((String) r15.getValue()) == null) goto L49;
        boolean r16 = true;
    L50:
        if (r16 == false) goto L45;
        r13.put(r15.getKey(), r15.getValue());
        goto L45
    L49:
        r16 = false;
    L52:
        r7 = r13;
        goto L130
    L42:
        r10 = null;
        goto L43
    L53:
        if (r18 == null) goto L57;
        Integer r19 = r18.c;
        if (r19 == null) goto L57;
        int r20 = r19.intValue();
    L58:
        Pair[] r21 = new Pair[11];
        r21[0] = TuplesKt.to("data_type", UploadDataType.IMAGE.getType());
        r21[1] = TuplesKt.to("transform", "compress");
        if (r0 == null) goto L61;
        String r22 = r0.getValue();
    L62:
        r21[2] = TuplesKt.to("result_code", r22);
        if (r18 == null) goto L67;
        Integer r23 = r18.a;
        if (r23 == null) goto L67;
        String r24 = r23.toString();
    L68:
        r21[3] = TuplesKt.to("opt_short_size", r24);
        if (r18 == null) goto L73;
        Integer r25 = r18.b;
        if (r25 == null) goto L73;
        String r26 = r25.toString();
    L74:
        r21[4] = TuplesKt.to("opt_long_size", r26);
        r21[5] = TuplesKt.to("quality", String.valueOf(r20));
        if (r18 == null) goto L77;
        Bitmap.CompressFormat r27 = r18.d;
    L78:
        if (r27 == null) goto L87;
        String r28 = r27.toString();
        if (r28 == null) goto L87;
        if ((!StringsKt.isBlank(r28)) == true) goto L85;
        r28 = null;
    L85:
        if (r28 == null) goto L87;
        String r29 = r28.toLowerCase(Locale.ROOT);
    L88:
        if (r29 != null) goto L90;
        r29 = "jpeg";
    L90:
        r21[6] = TuplesKt.to("output_format", r29);
        if (r18 == null) goto L93;
        boolean r30 = r18.e;
    L94:
        r21[7] = TuplesKt.to("keep_exif", String.valueOf(r30));
        if (r18 == null) goto L99;
        Integer r31 = r18.f;
        if (r31 == null) goto L99;
        String r32 = r31.toString();
    L100:
        r21[8] = TuplesKt.to("quality_with_alpha", r32);
        if (r18 == null) goto L103;
        Bitmap.CompressFormat r33 = r18.g;
    L104:
        if (r33 == null) goto L113;
        String r34 = r33.toString();
        if (r34 == null) goto L113;
        if ((!StringsKt.isBlank(r34)) == true) goto L111;
        r34 = null;
    L111:
        if (r34 == null) goto L113;
        String r35 = r34.toLowerCase(Locale.ROOT);
    L114:
        if (r35 == null) goto L117;
        r11 = r35;
    L117:
        r21[9] = TuplesKt.to("format_with_alpha", r11);
        if (r18 == null) goto L120;
        int r36 = r18.h;
    L121:
        r21[10] = TuplesKt.to("min_size_to_compress", String.valueOf(r36));
        LinkedHashMap r37 = MapsKt.linkedMapOf(r21);
        r13 = new LinkedHashMap();
        Iterator r38 = r37.entrySet().iterator();
    L123:
        if (r38.hasNext() == false) goto L52;
        Map.Entry r39 = (Map.Entry) r38.next();
        if (((String) r39.getValue()) == null) goto L127;
        boolean r40 = true;
    L128:
        if (r40 == false) goto L123;
        r13.put(r39.getKey(), r39.getValue());
        goto L123
    L127:
        r40 = false;
        goto L128
    L120:
        r36 = 0;
    L113:
        r35 = null;
        goto L114
    L103:
        r33 = null;
    L99:
        r32 = null;
        goto L100
    L93:
        r30 = false;
    L87:
        r29 = null;
        goto L88
    L77:
        r27 = null;
    L73:
        r26 = null;
    L67:
        r24 = null;
        goto L68
    L61:
        r22 = null;
    L57:
        r20 = 100;
        goto L58
    L9:
        r5 = g.a.a[r0.ordinal()];
    L133:
        r2.l = r3;
        return;
    }

    public final Object c(Uri r16, ns8.a r17, Continuation<? super b> r18) {
        if ((r18 instanceof CreationImageUploadPolicy$findReusablePreprocessResult$1) == false) goto L7;
        CreationImageUploadPolicy$findReusablePreprocessResult$1 r2 = (CreationImageUploadPolicy$findReusablePreprocessResult$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L34
    L32:
        Object r0 = Result.constructor-impl((b) r1);     // Catch: Throwable -> L34
    L36:
        Throwable r5 = Result.exceptionOrNull-impl(r0);
        if (r5 == null) goto L40;
        FLogger.a.e(b, "findReusablePreprocessResult error", r5);
    L40:
        if (Result.isFailure-impl(r0) == false) goto L43;
        return null;
    L43:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L34
        f.a.getClass();     // Catch: Throwable -> L34
        if (Intrinsics.areEqual(((kq9.h) f.c.getValue()).a(), Boxing.boxBoolean(true)) == true) goto L19;
        return null;
    L19:
        String r8 = vqc.d.d(AppHost.a.getApplication(), r16);     // Catch: Throwable -> L34
        if (r8 != null) goto L22;
        return null;
    L22:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r8);     // Catch: Throwable -> L34
        long r9 = r7.length();     // Catch: Throwable -> L34
        if (r17 == null) goto L25;
        Integer r10 = Boxing.boxInt(r17.hashCode());     // Catch: Throwable -> L34
    L26:
        m.a r11 = m.a.b(r16, Boxing.boxLong(r9), String.valueOf(r10));     // Catch: Throwable -> L34
        if (r11 != null) goto L29;
        return null;
    L29:
        CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Throwable -> L34
        CreationImageUploadPolicy$findReusablePreprocessResult$2$1 r14 = new CreationImageUploadPolicy$findReusablePreprocessResult$2$1(r11, r7, r9, r8, this, null);     // Catch: Throwable -> L34
        r2.label = 1;     // Catch: Throwable -> L34
        r1 = BuildersKt.withContext(r13, r14, r2);     // Catch: Throwable -> L34
        if (r1 != r12) goto L32;
        return r12;
    L25:
        r10 = null;
    L34:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new CreationImageUploadPolicy$findReusablePreprocessResult$1(this, r18);
        goto L8
    }

    public static a e(String r1, Integer r2, Bitmap.CompressFormat r3, int r4) {
        if (r2 == null) goto L4;
        r4 = r2.intValue();
    L4:
        int r5 = Math.max(0, r4);
        if (Build.VERSION.SDK_INT < 30) goto L14;
        if (r1 == null) goto L27;
        Bitmap.CompressFormat r6 = f(r1);
        if (r6 == null) goto L27;
        r3 = r6;
    L27:
        return new a(r3, r5);
    L14:
        if (Intrinsics.areEqual(r1, "webp_lossless") == false) goto L17;
        return new a(Bitmap.CompressFormat.WEBP, 100);
    L17:
        if (Intrinsics.areEqual(r1, "webp_lossy") == false) goto L20;
        return new a(Bitmap.CompressFormat.WEBP, Math.min(r5, 99));
    L20:
        if (r1 == null) goto L26;
        Bitmap.CompressFormat r7 = f(r1);
        if (r7 == null) goto L26;
        r3 = r7;
    L26:
        return new a(r3, r5);
    }

    @Override // com.larus.uaigc.utils.a
    public final Object a(Uri r37, String r38, String r39, Continuation<? super ic8.n0> r40) {
        Uri r0 = r37;
        String r2 = r38;
        if ((r40 instanceof CreationImageUploadPolicy$compressAlbumImg$1) == false) goto L7;
        CreationImageUploadPolicy$compressAlbumImg$1 r4 = (CreationImageUploadPolicy$compressAlbumImg$1) r40;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        CreationImageUploadPolicy$compressAlbumImg$1 r11 = r4;
        Object r3 = r11.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r11.label;
        String r9 = "image/jpeg";
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        CreationImageUploadPolicy r1 = (CreationImageUploadPolicy) r11.L$5;
        CreationImageUploadPolicy r8 = (CreationImageUploadPolicy) r11.L$4;
        CreationImageUploadPolicy r10 = (CreationImageUploadPolicy) r11.L$3;
        b r12 = (b) r11.L$2;
        ns8.a r13 = (ns8.a) r11.L$1;
        Uri r14 = (Uri) r11.L$0;
        ResultKt.throwOnFailure(r3);
        b r15 = r12;
        ns8.a r16 = r13;
        Uri r17 = r14;
        Object r18 = r3;
        CreationImageUploadPolicy r19 = r10;
        String r20 = "image/jpeg";
        CreationImageUploadPolicy r21 = r8;
    L132:
        ic8.n0 r22 = (ic8.n0) r18;
        r1.getClass();
        f.a.getClass();
        Boolean r23 = ((kq9.h) f.c.getValue()).a();
        Boolean r110 = Boolean.TRUE;
        if (Intrinsics.areEqual(r23, r110) == false) goto L143;
        ProcessFileResultCode r24 = r22.b;
        if (r24 != null) goto L137;
    L139:
        boolean r25 = false;
    L140:
        if (r25 == false) goto L143;
        BuildersKt.launch$default((CoroutineScope) f.getValue(), null, null, new CreationImageUploadPolicy$reusePreprocessResult$1(r15, r17, r16, r22, null), 3, null);
        goto L143
    L137:
        if (r24.isSuccess() != true) goto L139;
        r25 = true;
    L143:
        r21.getClass();
        if (Intrinsics.areEqual(f.c().b(), r110) == false) goto L308;
        ProcessFileResultCode r26 = r22.b;
        if (r26 != null) goto L149;
        int r27 = -1;
    L151:
        if (r27 != 1) goto L153;
    L159:
        Application r28 = AppHost.a.getApplication();
        ImFileUtil.a.getClass();     // Catch: Throwable -> L163
        String r29 = ImFileUtil.i(r17);     // Catch: Throwable -> L163
        if (r29 == null) goto L164;
        String r111 = r29.toLowerCase(Locale.US);     // Catch: Throwable -> L163
    L165:
        if (r111 != null) goto L167;
    L230:
        String r30 = "jpg";
    L231:
        PolarisFileWrapper r112 = BitmapHelperKt.a(r30);     // Catch: Throwable -> L163
        ParcelFileDescriptor r31 = b(r28.getContentResolver(), r17);     // Catch: Throwable -> L263
        if (r31 == null) goto L264;
        PolarisFileInputStreamWrapper r32 = new PolarisFileInputStreamWrapper(r31.getFileDescriptor());     // Catch: Throwable -> L256
        PolarisFileOutputStreamWrapper r33 = new PolarisFileOutputStreamWrapper(r112);     // Catch: Throwable -> L249
        ByteStreamsKt.copyTo$default(r32, r33, 0, 2, null);     // Catch: Throwable -> L242
        CloseableKt.closeFinally(r33, null);     // Catch: Throwable -> L249
        CloseableKt.closeFinally(r32, null);     // Catch: Throwable -> L256
        CloseableKt.closeFinally(r31, null);     // Catch: Throwable -> L263
        boolean r113 = true;
    L265:
        if (r113 == true) goto L289;
        InputStream r34 = ContentResolverWrapper.openInputStream(r28.getContentResolver(), r17);     // Catch: Throwable -> L163
        if (r34 == null) goto L288;
        PolarisFileOutputStreamWrapper r35 = new PolarisFileOutputStreamWrapper(r112);     // Catch: Throwable -> L281
        ByteStreamsKt.copyTo$default(r34, r35, 0, 2, null);     // Catch: Throwable -> L274
        CloseableKt.closeFinally(r35, null);     // Catch: Throwable -> L281
        CloseableKt.closeFinally(r34, null);     // Catch: Throwable -> L163
        goto L289
    L274:
        th = move-exception;
        throw th;     // Catch: Throwable -> L277
    L277:
        th = move-exception;
        CloseableKt.closeFinally(r35, th);     // Catch: Throwable -> L281
        throw th;     // Catch: Throwable -> L281
    L281:
        th = move-exception;
        throw th;     // Catch: Throwable -> L284
    L284:
        th = move-exception;
        CloseableKt.closeFinally(r34, th);     // Catch: Throwable -> L163
        throw th;     // Catch: Throwable -> L163
    L289:
        if (r112 == null) goto L301;
        ic8.m0 r36 = r22.a;
        if (r36 == null) goto L299;
        String r41 = r112.getName();
        if (r41 != null) goto L295;
        r41 = "";
    L295:
        String r42 = r112.getAbsolutePath();
        if (r42 != null) goto L298;
        r42 = "";
    L298:
        ic8.m0 r114 = ic8.m0.a(r36, null, r41, r42, 16365);
    L300:
        r22 = new ic8.n0(r114, ProcessFileResultCode.SUCCESS);
        goto L308
    L299:
        r114 = null;
    L301:
        String r43 = vqc.d.d(AppHost.a.getApplication(), r17);
        if (r43 == null) goto L308;
        ic8.m0 r44 = r22.a;
        if (r44 == null) goto L306;
        ic8.m0 r115 = ic8.m0.a(r44, null, null, r43, 16367);
    L307:
        r22 = new ic8.n0(r115, ProcessFileResultCode.SUCCESS);
        goto L308
    L306:
        r115 = null;
        goto L307
    L242:
        th = move-exception;
        throw th;     // Catch: Throwable -> L245
    L245:
        th = move-exception;
        CloseableKt.closeFinally(r33, th);     // Catch: Throwable -> L249
        throw th;     // Catch: Throwable -> L249
    L249:
        th = move-exception;
        throw th;     // Catch: Throwable -> L252
    L252:
        th = move-exception;
        CloseableKt.closeFinally(r32, th);     // Catch: Throwable -> L256
        throw th;     // Catch: Throwable -> L256
    L256:
        th = move-exception;
        throw th;     // Catch: Throwable -> L259
    L259:
        th = move-exception;
        CloseableKt.closeFinally(r31, th);     // Catch: Throwable -> L263
        throw th;     // Catch: Throwable -> L263
    L264:
        r113 = false;
        goto L265
    L167:
        switch(r111.hashCode()) {
            case -1487662500: goto L226;
            case -1487656890: goto L222;
            case -1487464693: goto L218;
            case -1487464690: goto L214;
            case -1487394660: goto L211;
            case -1487103447: goto L208;
            case -1487018032: goto L204;
            case -879272239: goto L200;
            case -879267568: goto L196;
            case -879264467: goto L194;
            case -879258763: goto L191;
            case -227171396: goto L187;
            case 1140778788: goto L185;
            case 1146349984: goto L183;
            case 1176892386: goto L179;
            case 1177225566: goto L176;
            case 1544502791: goto L173;
            case 1578362927: goto L170;
            default: goto L230;
        };     // Catch: Throwable -> L163
    L185:
        String r116 = "image/pjpeg";
    L212:
        r111.equals(r116);     // Catch: Throwable -> L163
        goto L230
    L194:
        r116 = "image/jpg";
        goto L212
    L211:
        r116 = r20;
        goto L212
    L170:
        if (r111.equals("image/vnd.microsoft.icon") == false) goto L230;
    L181:
        r30 = "ico";
        goto L231
    L173:
        if (r111.equals("image/x-ms-bmp") == false) goto L230;
    L202:
        r30 = "bmp";
        goto L231
    L176:
        if (r111.equals("image/x-tiff") == false) goto L230;
    L210:
        r30 = "tiff";
        goto L231
    L179:
        if (r111.equals("image/x-icon") == true) goto L181;
    L183:
        if (r111.equals("image/x-png") == false) goto L230;
    L193:
        r30 = "png";
        goto L231
    L187:
        if (r111.equals("image/svg+xml") == false) goto L230;
        r30 = "svg";
        goto L231
    L191:
        if (r111.equals("image/png") == true) goto L193;
    L196:
        if (r111.equals("image/gif") == false) goto L230;
        r30 = "gif";
        goto L231
    L200:
        if (r111.equals("image/bmp") == true) goto L202;
    L204:
        if (r111.equals("image/webp") == false) goto L230;
        r30 = "webp";
        goto L231
    L208:
        if (r111.equals("image/tiff") == true) goto L210;
    L214:
        if (r111.equals("image/heif") == false) goto L230;
        r30 = "heif";
        goto L231
    L218:
        if (r111.equals("image/heic") == false) goto L230;
        r30 = "heic";
        goto L231
    L222:
        if (r111.equals("image/avif") == false) goto L230;
        r30 = "avif";
        goto L231
    L226:
        if (r111.equals("image/apng") == false) goto L230;
        r30 = "apng";
        goto L231
    L164:
        r111 = null;
    L288:
        r112 = null;
        goto L289
    L153:
        if (r27 == 2) goto L159;
        if (r27 == 3) goto L159;
        if (r27 == 4) goto L301;
    L149:
        r27 = c.a[r26.ordinal()];
    L308:
        r19.getClass();
        g(r22, r16);
        return r22;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r45 = r11.J$0;
        ns8.a r46 = (ns8.a) r11.L$3;
        String r47 = (String) r11.L$2;
        String r48 = (String) r11.L$1;
        Uri r49 = (Uri) r11.L$0;
        ResultKt.throwOnFailure(r3);
        r16 = r46;
        r0 = r49;
        r9 = "image/jpeg";
        Object r50 = r3;
        String r51 = r47;
        r2 = r48;
    L115:
        b r117 = (b) r50;
        if (r117 == null) goto L118;
        ic8.n0 r52 = r117.a;
    L119:
        if (r52 == null) goto L125;
        g(r52, r16);
        FLogger.a.i(b, "findReusablePreprocessResult: " + r52);
        Lazy r53 = ImageUploadDuplicateStatHelper.a;
        StringBuilder r54 = new StringBuilder();
        r54.append(r2);
        if (r51 != null) goto L123;
        r51 = "";
    L123:
        r54.append(r51);
        ImageUploadDuplicateStatHelper.b(r54.toString(), r0, r52, System.currentTimeMillis() - r45, true);
        return r52;
    L125:
        IAIChatUploadMediaService.Companion r55 = IAIChatUploadMediaService.a;
        StringBuilder r56 = new StringBuilder();
        r56.append(r2);
        if (r51 != null) goto L128;
        r51 = "";
    L128:
        r56.append(r51);
        String r57 = r56.toString();
        r11.L$0 = r0;
        r11.L$1 = r16;
        r11.L$2 = r117;
        r11.L$3 = this;
        r11.L$4 = this;
        r11.L$5 = this;
        r11.label = 2;
        r20 = r9;
        r18 = IAIChatUploadMediaService.a.a(r55, r0, r16, false, true, r57, r11, 12);
        if (r18 != r6) goto L131;
        return r6;
    L131:
        r21 = this;
        r19 = r21;
        r15 = r117;
        r17 = r0;
        r1 = r19;
        goto L132
    L118:
        r52 = null;
        goto L119
    L16:
        ResultKt.throwOnFailure(r3);
        r45 = System.currentTimeMillis();
        ImFileUtil.a.getClass();
        String r58 = ImFileUtil.i(r37);
        if (r58 == null) goto L19;
        String r59 = r58.toLowerCase(Locale.US);
    L20:
        Map<String, i4> r60 = d().d;
        if (r60 == null) goto L23;
        i4 r61 = r60.get(r2);
    L25:
        if (Intrinsics.areEqual(r59, "image/jpeg") == false) goto L27;
    L30:
        boolean r62 = true;
    L31:
        if (r62 == false) goto L33;
        Bitmap.CompressFormat r63 = Bitmap.CompressFormat.JPEG;
    L34:
        Bitmap.CompressFormat r64 = Bitmap.CompressFormat.PNG;
        int r118 = d().c;
        int r119 = d().c;
        if (r61 != null) goto L41;
        Integer r120 = Integer.valueOf(d().a);
        Integer r121 = Integer.valueOf(d().b);
        Integer r210 = Integer.valueOf(d().c);
        Integer r211 = Integer.valueOf(d().c);
        f.a.getClass();
        Integer r122 = f.c().c();
        if (r122 == null) goto L39;
        int r212 = r122.intValue();
    L40:
        ns8.a r65 = new ns8.a(r120, r121, r210, r63, false, r211, r64, r212);
        r9 = "image/jpeg";
    L111:
        r11.L$0 = r0;
        r11.L$1 = r2;
        r51 = r39;
        r11.L$2 = r51;
        r11.L$3 = r65;
        r11.J$0 = r45;
        r11.label = 1;
        r50 = c(r0, r65, r11);
        if (r50 != r6) goto L114;
        return r6;
    L114:
        r16 = r65;
        goto L115
    L39:
        r212 = 0;
        goto L40
    L41:
        int r123 = NetConnectionTypeProvider.a.getValue();
        Integer r124 = ((kq9.l) d.getValue()).a();
        if (r124 == null) goto L44;
        int r125 = r124.intValue();
    L45:
        if (r123 > r125) goto L47;
        boolean r126 = true;
    L48:
        if (r126 == false) goto L52;
        hq9.p0 r127 = r61.b();
        if (r127 == null) goto L55;
        String r128 = r127.a();
    L56:
        if (r126 == false) goto L60;
        hq9.p0 r129 = r61.b();
        if (r129 == null) goto L64;
        Integer r130 = r129.c();
    L63:
        Integer r66 = r130;
    L65:
        a r67 = e(r128, r66, r63, r118);
        if (r126 == false) goto L70;
        hq9.p0 r68 = r61.b();
        if (r68 == null) goto L73;
        String r69 = r68.b();
    L74:
        if (r126 == false) goto L78;
        hq9.p0 r131 = r61.b();
        if (r131 == null) goto L81;
        Integer r132 = r131.d();
    L82:
        a r70 = e(r69, r132, r64, r119);
        if (r126 == false) goto L87;
        hq9.p0 r133 = r61.b();
        if (r133 == null) goto L90;
        Integer r134 = r133.f();
    L91:
        if (r134 == null) goto L93;
        int r135 = r134.intValue();
    L94:
        Integer r213 = Integer.valueOf(r135);
        if (r126 == false) goto L99;
        hq9.p0 r71 = r61.b();
        if (r71 == null) goto L102;
        Integer r72 = r71.e();
    L103:
        if (r72 == null) goto L105;
        int r73 = r72.intValue();
    L106:
        Integer r214 = Integer.valueOf(r73);
        Integer r215 = Integer.valueOf(r67.b);
        Bitmap.CompressFormat r74 = r67.a;
        Integer r310 = Integer.valueOf(r70.b);
        Bitmap.CompressFormat r75 = r70.a;
        f.a.getClass();
        Integer r76 = f.c().c();
        if (r76 == null) goto L109;
        int r311 = r76.intValue();
    L110:
        r65 = new ns8.a(r213, r214, r215, r74, false, r310, r75, r311);
        goto L111
    L109:
        r311 = 0;
        goto L110
    L105:
        r73 = d().b;
    L102:
        r72 = null;
        goto L103
    L99:
        hq9.p0 r77 = r61.a();
        if (r77 == null) goto L102;
        r72 = r77.e();
        goto L103
    L93:
        r135 = d().a;
    L90:
        r134 = null;
        goto L91
    L87:
        hq9.p0 r136 = r61.a();
        if (r136 == null) goto L90;
        r134 = r136.f();
    L81:
        r132 = null;
        goto L82
    L78:
        hq9.p0 r137 = r61.a();
        if (r137 == null) goto L81;
        r132 = r137.d();
    L73:
        r69 = null;
        goto L74
    L70:
        hq9.p0 r78 = r61.a();
        if (r78 == null) goto L73;
        r69 = r78.b();
    L64:
        r66 = null;
        goto L65
    L60:
        hq9.p0 r138 = r61.a();
        if (r138 == null) goto L64;
        r130 = r138.c();
    L55:
        r128 = null;
        goto L56
    L52:
        hq9.p0 r139 = r61.a();
        if (r139 == null) goto L55;
        r128 = r139.a();
        goto L56
    L47:
        r126 = false;
        goto L48
    L44:
        r125 = -2;
        goto L45
    L33:
        r63 = Bitmap.CompressFormat.PNG;
        goto L34
    L27:
        if (Intrinsics.areEqual(r59, "image/jpg") == true) goto L30;
        r62 = false;
        goto L31
    L23:
        r61 = null;
        goto L25
    L19:
        r59 = null;
    L7:
        r4 = new CreationImageUploadPolicy$compressAlbumImg$1(this, r40);
        goto L8
    }
}
