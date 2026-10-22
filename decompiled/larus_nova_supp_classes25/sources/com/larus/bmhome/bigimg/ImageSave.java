package com.larus.bmhome.bigimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.LocalImageWatermarkRequest;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ImageSave {
    public static final ImageSave a = null;
    public static final Lazy b = null;

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.bmhome.bigimg.ImageSave$a$a, reason: collision with other inner class name */
        public static final class C0032a extends a {
            public final String a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0032a) == true) goto L8;
                return false;
            L8:
                C0032a r6 = (C0032a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Blocked(url=" + this.a + ", tip=" + this.b + ')';
            }

            public C0032a(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "url");
                Intrinsics.checkNotNullParameter(r3, "tip");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b extends a {
            public final String a;
            public final long b;

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
                if (this.b == r9.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                long r1 = this.b;
                return r0 + ((int) (r1 ^ (r1 >>> 32)));
            }

            public final String toString() {
                return "Failure(url=" + this.a + ", duration=" + this.b + ')';
            }

            public b(String r2, long r3) {
                Intrinsics.checkNotNullParameter(r2, "url");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class c extends a {
            public final String a;
            public final long b;

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof c) == true) goto L8;
                return false;
            L8:
                c r9 = (c) r8;
                if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r9.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                long r1 = this.b;
                return r0 + ((int) (r1 ^ (r1 >>> 32)));
            }

            public final String toString() {
                return "Success(url=" + this.a + ", duration=" + this.b + ')';
            }

            public c(String r2, long r3) {
                Intrinsics.checkNotNullParameter(r2, "url");
                this.a = r2;
                this.b = r3;
            }
        }

        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WatermarkPerfLogger.Path.values().length];
            r0[WatermarkPerfLogger.Path.A.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[WatermarkPerfLogger.Path.B_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[WatermarkPerfLogger.Path.B_FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[WatermarkPerfLogger.Path.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {
        public final /* synthetic */ DataSource<CloseableReference<PooledByteBuffer>> a;

        public c(DataSource<CloseableReference<PooledByteBuffer>> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r1) {
            Throwable r2 = (Throwable) r1;
            this.a.close();
            return Unit.INSTANCE;
        }
    }

    public static final class d extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
        public final /* synthetic */ kotlinx.coroutines.i<String> a;
        public final /* synthetic */ Map<String, String> b;
        public final /* synthetic */ Boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;

        public final void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> r4) {
            Intrinsics.checkNotNullParameter(r4, "dataSource");
            FLogger.a.w("ImageSave", "cache is not exist, download failed");
            if (this.a.isActive() == false) goto L5;
            this.a.resumeWith(Result.constructor-impl(null));
        L5:
            r4.close();
        }

        public final void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> r12) {
            if (r12 == null) goto L6;
            boolean r1 = true;
            if (r12.isFinished() != true) goto L6;
        L7:
            if (r1 == true) goto L9;
            return;
        L9:
            FLogger.a.w("ImageSave", "cache is not exist, download finish");
            Object r0 = null;
            if (r12 == null) goto L12;
            CloseableReference r2 = (CloseableReference) r12.getResult();
        L13:
            if (r2 == null) goto L15;
            Map<String, String> r5 = this.b;
            Boolean r6 = this.c;
            String r7 = this.d;
            boolean r8 = this.e;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L41
            EncodedImage r9 = new EncodedImage(r2);     // Catch: Throwable -> L35
            InputStream r4 = r9.getInputStream();     // Catch: Throwable -> L28
            ImageFormat r10 = ImageFormatChecker.getImageFormat_WrapIOException(r4);     // Catch: Throwable -> L30
            CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L28
            ImageSave r11 = ImageSave.a;     // Catch: Throwable -> L28
            InputStream r13 = r9.getInputStream();     // Catch: Throwable -> L28
            Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L28
            r11.getClass();     // Catch: Throwable -> L28
            String r14 = ImageSave.t(r13, r10, r5, r6, r7, r8);     // Catch: Throwable -> L28
            r9.close();     // Catch: Throwable -> L41
            CloseableReference.closeSafely(r2);     // Catch: Throwable -> L41
            r12.close();     // Catch: Throwable -> L41
            Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L41
        L43:
            Throwable r16 = Result.exceptionOrNull-impl(r15);
            if (r16 == null) goto L47;
            FLogger.a.e("ImageSave", "download finish but save bitmap failed", r16);
        L47:
            if (Result.isFailure-impl(r15) == true) goto L50;
            r0 = r15;
        L50:
            String r17 = (String) r0;
            if (this.a.isActive() == false) goto L53;
            this.a.resumeWith(Result.constructor-impl(r17));
        L53:
            FLogger.a.w("ImageSave", "download finish and save bitmap");
            return;
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L28
            throw th;     // Catch: Throwable -> L28
        L28:
            th = th;
        L37:
            if (r9 == null) goto L39;
            r9.close();     // Catch: Throwable -> L41
        L39:
            CloseableReference.closeSafely(r2);     // Catch: Throwable -> L41
            r12.close();     // Catch: Throwable -> L41
            throw th;     // Catch: Throwable -> L41
        L35:
            th = th;
            r9 = null;
        L41:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L43
        L15:
            if (this.a.isActive() == false) goto L17;
            this.a.resumeWith(Result.constructor-impl(null));
        L17:
            if (r12 == null) goto L63;
            r12.close();
            return;
        L63:
            return;
        L12:
            r2 = null;
        L6:
            r1 = false;
            goto L7
        }

        public d(kotlinx.coroutines.j r1, Map r2, Boolean r3, String r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public ImageSave() {
    }

    static {
        a = new ImageSave();
        b = LazyKt.lazy(new p1());
    }

    public static void g(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheFilepath");
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return;
    L5:
        com.larus.utils.l0.b(new o1(r2));
    }

    public static void m(String r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ImageSave$getLocalPath$1(r7, r8, null), 3, null);
    }

    public static String n(String r4, boolean r5) {
        List r6 = new Regex(",").split(r4, 0);     // Catch: Exception -> L16
        if (r6.isEmpty() == true) goto L13;
        ListIterator r0 = r6.listIterator(r6.size());     // Catch: Exception -> L16
    L6:
        if (r0.hasPrevious() == false) goto L13;
        if (((String) r0.previous()).length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L6;
        List r7 = CollectionsKt.take(r6, r0.nextIndex() + 1);     // Catch: Exception -> L16
    L14:
        byte[] r8 = Base64.decode(((String[]) r7.toArray(new String[0]))[1], 0);     // Catch: Exception -> L16
        return p(BitmapFactory.decodeByteArray(r8, 0, r8.length), r5);
    L10:
        r3 = false;
    L13:
        r7 = CollectionsKt.emptyList();     // Catch: Exception -> L16
    L16:
        return null;
    }

    public static String p(Bitmap r5, boolean r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        StringBuilder r1 = new StringBuilder();
        AppHost.Companion r2 = AppHost.a;
        r1.append(r2.getAppName());
        r1.append(System.currentTimeMillis());
        r1.append(".jpeg");
        String r3 = r1.toString();
        String r4 = i1.b();
        if (i1.e(r5, r4, r3) == false) goto L12;
        String r7 = r4 + File.separator + r3;
        if (r6 == false) goto L10;
        com.larus.platform.service.e.a(r7);
    L10:
        i1.f(r2.getApplication(), r7, true);
        return r7;
    L12:
        FLogger.a.w("ImageSave", "save failed");
        return null;
    }

    public static void A(ImageSave r6, String r7, com.larus.livetutor.impl.tutor.controller.f0 r8) {
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "url");
        String r9 = f("save_album", "image", false);
        if (r9 == null) goto L5;
        r8.invoke(new a.C0032a(r7, r9));
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ImageSave$saveOriginImageWithOutToastResult$2(r7, null, r8, null), 3, null);
    }

    public static final Object a(ImageSave r11, String r12, Continuation r13) {
        r11.getClass();
        if ((r13 instanceof ImageSave$applyDownloadWatermarkIfNeeded$1) == false) goto L7;
        ImageSave$applyDownloadWatermarkIfNeeded$1 r1 = (ImageSave$applyDownloadWatermarkIfNeeded$1) r13;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r14 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        com.larus.platform.service.watermark.g.b r5 = null;
        if (r4 == 0) goto L26;
        if (r4 == 1) goto L21;
        if (r4 == 2) goto L18;
        if (r4 != 3) goto L17;
        r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
    L56:
        String r15 = (String) r14;     // Catch: Throwable -> L24
        if (r15 == null) goto L68;
    L69:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L24
    L72:
        String r10 = r12;
        Object r17 = r16;
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L80;
        FLogger.a.w("ImageSave", "applyDownloadWatermarkIfNeeded failed: " + r18);
        return r10;
    L80:
        return r17;
    L68:
        r15 = r12;
        goto L69
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
    L50:
        String r19 = (String) r14;     // Catch: Throwable -> L24
        if (r19 == null) goto L68;
        r15 = "file://".concat(r19);     // Catch: Throwable -> L24
        goto L69
    L21:
        r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
    L62:
        com.larus.platform.service.watermark.g r110 = (com.larus.platform.service.watermark.g) r14;     // Catch: Throwable -> L24
        if ((r110 instanceof com.larus.platform.service.watermark.g.b) == false) goto L65;
        r5 = (com.larus.platform.service.watermark.g.b) r110;     // Catch: Throwable -> L24
    L65:
        if (r5 == null) goto L68;
        r15 = r5.a;     // Catch: Throwable -> L24
        if (r15 != null) goto L69;
    L26:
        ResultKt.throwOnFailure(r14);
        if (r12.length() != 0) goto L29;
        boolean r111 = true;
    L30:
        if (r111 == true) goto L79;
        DownloadWatermarkScene r112 = DownloadWatermarkScene.CI_GEN_IMAGE_DOWNLOAD;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L24
        WatermarkPerfLogger.Path.Companion.getClass();     // Catch: Throwable -> L24
        int r9 = b.a[WatermarkPerfLogger.Path.a.a(r12).ordinal()];     // Catch: Throwable -> L24
        if (r9 == 1) goto L59;
        if (r9 == 2) goto L43;
        if (r9 == 3) goto L68;
        if (r9 == 4) goto L68;
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L24
    L43:
        if (StringsKt.startsWith$default(r12, "file", false, 2, null) == false) goto L53;
        String r6 = UriProtector.parse(r12).getPath();     // Catch: Throwable -> L24
        if (r6 == null) goto L68;
        r1.L$0 = r12;     // Catch: Throwable -> L24
        r1.label = 2;     // Catch: Throwable -> L24
        r14 = r11.k(r6, r112, r1);     // Catch: Throwable -> L24
        if (r14 != r3) goto L50;
    L78:
        return r3;
    L53:
        r1.L$0 = r12;     // Catch: Throwable -> L24
        r1.label = 3;     // Catch: Throwable -> L24
        r14 = r11.k(r12, r112, r1);     // Catch: Throwable -> L24
        if (r14 != r3) goto L56;
    L59:
        DownloadWatermarkService r113 = DownloadWatermarkService.a;     // Catch: Throwable -> L24
        com.larus.platform.service.watermark.d r0 = new com.larus.platform.service.watermark.d(r12, r112);     // Catch: Throwable -> L24
        r1.L$0 = r12;     // Catch: Throwable -> L24
        r1.label = 1;     // Catch: Throwable -> L24
        r14 = r113.c(r0, r1);     // Catch: Throwable -> L24
        if (r14 != r3) goto L62;
    L79:
        return r12;
    L29:
        r111 = false;
    L24:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r1 = new ImageSave$applyDownloadWatermarkIfNeeded$1(r11, r13);
        goto L8
    }

    public static final PolarisFileWrapper b(ImageSave r7, PolarisFileWrapper r8, String r9) {
        r7.getClass();
        if ((!StringsKt.isBlank(r9)) == true) goto L6;
        r9 = null;
    L6:
        if (r9 != null) goto L8;
        r9 = "doubao_" + System.currentTimeMillis();
    L8:
        int r10 = StringsKt.lastIndexOf$default(r9, '.', 0, false, 6, null);
        if (r10 <= 0) goto L11;
        String r1 = r9.substring(0, r10);
    L12:
        if (r10 <= 0) goto L14;
        String r11 = r9.substring(r10);
    L15:
        PolarisFileWrapper r2 = new PolarisFileWrapper(r8, r9);
        int r12 = 1;
    L17:
        if (r2.exists() == false) goto L19;
        r2 = new PolarisFileWrapper(r8, r1 + '(' + r12 + ')' + r11);
        r12 = r12 + 1;
        goto L17
    L19:
        return r2;
    L14:
        r11 = "";
        goto L15
    L11:
        r1 = r9;
        goto L12
    }

    public static final Object e(ImageSave r5, String r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof ImageSave$getLocalPathInternal$1) == false) goto L7;
        ImageSave$getLocalPathInternal$1 r0 = (ImageSave$getLocalPathInternal$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
        return r8;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
    L38:
        ImageRequest r10 = ImageRequestBuilder.newBuilderWithSource((Uri) r8).setProgressiveRenderingEnabled(true).build();
        CacheKey r11 = Fresco.getImagePipeline().getCacheKey(r10, AppHost.a.getApplication());
        if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r11) == false) goto L51;
        FileBinaryResource r12 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r11);
        if ((r12 instanceof FileBinaryResource) == false) goto L43;
        FileBinaryResource r13 = r12;
    L44:
        if (r13 == null) goto L46;
        File r14 = r13.getFile();
    L47:
        if (r14 == null) goto L51;
        if (r14.exists() == false) goto L51;
        return r14.getAbsolutePath();
    L46:
        r14 = null;
        goto L47
    L43:
        r13 = null;
    L51:
        CoroutineDispatcher r15 = Dispatchers.getIO();
        ImageSave$getLocalPathInternal$2 r3 = new ImageSave$getLocalPathInternal$2(r10, null);
        r0.label = 2;
        Object r16 = BuildersKt.withContext(r15, r3, r0);
        if (r16 == r9) goto L54;
        return r16;
    L54:
        return r9;
    L16:
        ResultKt.throwOnFailure(r8);
        if (r6.length() != 0) goto L19;
        boolean r17 = true;
    L20:
        if (r17 == false) goto L23;
        FLogger.a.w("ImageSave", "getLocalPathInternal url is null");
        return null;
    L23:
        if (StringsKt.startsWith$default(r6, "data:", false, 2, null) == false) goto L28;
        if (StringsKt.contains$default(r6, "base64", false, 2, null) == false) goto L28;
        return n(r6, false);
    L28:
        if (StringsKt.startsWith$default(r6, "file", false, 2, null) == false) goto L31;
        return UriProtector.parse(r6).getPath();
    L31:
        if (StringsKt.startsWith$default(r6, "http://", false, 2, null) == false) goto L33;
    L35:
        r0.label = 1;
        r8 = ImageLoaderKt.r(r6, "image_save", r0);
        if (r8 != r9) goto L38;
    L33:
        if (StringsKt.startsWith$default(r6, "https://", false, 2, null) == true) goto L35;
        return r6;
    L19:
        r17 = false;
    L7:
        r0 = new ImageSave$getLocalPathInternal$1(r5, r7);
        goto L8
    }

    public static String f(String r9, String r10, boolean r11) {
        FlowFileProtectionService r0 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        FLogger r4 = FLogger.a;
        if (r4.isDebug() == false) goto L14;
        StringBuilder r5 = new StringBuilder("action=");
        r5.append(r9);
        r5.append(" mediaType=");
        r5.append(r10);
        r5.append(" flowServiceAvailable=");
        if (r0 == null) goto L13;
        r1 = true;
    L13:
        r5.append(r1);
        r5.append(" encryptionEnabled=");
        r5.append(r3);
        r5.append(" blocked=");
        r5.append(r3);
        r5.append(" showTip=");
        r5.append(r11);
        r4.i("flow_file_egress_gate", r5.toString());
    L14:
        String r2 = null;
        if (r3 == true) goto L17;
        return null;
    L17:
        r4.i("ImageSave", "file egress blocked action=" + r9 + " mediaType=" + r10);
        com.larus.platform.service.o r6 = com.larus.platform.service.o.a;
        JSONObject r7 = new JSONObject();
        r7.put("action", r9);
        r7.put("entry", "image_save");
        r7.put("content_type", r10);
        Unit r12 = Unit.INSTANCE;
        r6.reportEvent("flow_enterprise_file_egress_block", r7);
        if (Intrinsics.areEqual(r9, "share_prepare") == false) goto L21;
        if (r0 == null) goto L23;
        String r13 = r0.A0();
    L24:
        if (r13 != null) goto L26;
    L28:
        if (r2 != null) goto L30;
        r2 = "";
    L30:
        if (r11 == true) goto L32;
    L34:
        return r2;
    L32:
        if ((!StringsKt.isBlank(r2)) == false) goto L34;
        t19.s.j(t19.s.a, AppHost.a.getApplication(), r2, null, false, 28);
        goto L34
    L26:
        if ((!StringsKt.isBlank(r13)) == false) goto L28;
        r2 = r13;
    L23:
        r13 = null;
        goto L24
    L21:
        if (r0 == null) goto L23;
        r13 = r0.H0();
        goto L24
    L5:
        if (r0.I0() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final Object k(String r6, DownloadWatermarkScene r7, Continuation<? super String> r8) {
        if ((r8 instanceof ImageSave$exchangeLocalPathForWatermark$1) == false) goto L7;
        ImageSave$exchangeLocalPathForWatermark$1 r0 = (ImageSave$exchangeLocalPathForWatermark$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        com.larus.platform.service.watermark.g.d r10 = (com.larus.platform.service.watermark.g) r9;
        if ((r10 instanceof com.larus.platform.service.watermark.g.d) == false) goto L20;
        com.larus.platform.service.watermark.g.d r11 = r10;
    L21:
        if (r11 == null) goto L23;
        com.larus.platform.service.watermark.c r12 = r11.a;
    L25:
        if ((r12 instanceof com.larus.platform.service.watermark.c.b) == false) goto L27;
        com.larus.platform.service.watermark.c.b r13 = (com.larus.platform.service.watermark.c.b) r12;
    L28:
        if (r13 != null) goto L30;
        return null;
    L30:
        return r13.a;
    L27:
        r13 = null;
        goto L28
    L23:
        r12 = null;
        goto L25
    L20:
        r11 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        DownloadWatermarkService r14 = DownloadWatermarkService.a;
        LocalImageWatermarkRequest r4 = new LocalImageWatermarkRequest(new com.larus.platform.service.watermark.b.b(r6), LocalImageWatermarkRequest.OutputPreference.AS_PATH, r7);
        r0.label = 1;
        r9 = r14.b(r4, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new ImageSave$exchangeLocalPathForWatermark$1(this, r8);
        goto L8
    }

    public static void j(ImageSave r13, String r14, String r15, Function1 r16) {
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "url");
        Intrinsics.checkNotNullParameter(r15, "fileName");
        Intrinsics.checkNotNullParameter(r16, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ImageSave$downloadImageToLocal$1(r14, r16, null, r15, null, false, null), 3, null);
    }

    public static boolean q(File r6, ImageFormat r7, Map r8, boolean r9) {
        if (r6.exists() == true) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        FLogger.a.w("ImageSave", "saveBitmapToSD, file isn't exist, path(" + r6.getPath() + ')');
        return false;
    L10:
        String r1 = System.currentTimeMillis() + '.' + r7.getFileExtension();
        String r4 = i1.b();
        if (i1.d(r6, r4, r1) == false) goto L17;
        String r10 = r4 + File.separator + r1;
        int r2 = yq8.a.a;
        yq8.a.a(r10, r8, r7.getFileExtension());
        if (r9 == false) goto L15;
        com.larus.platform.service.e.b(r10);
    L15:
        i1.f(AppHost.a.getApplication(), r10, true);
        g(r10);
        return true;
    L17:
        g(r4 + File.separator + r1);
        FLogger.a.w("ImageSave", "save failed");
        return false;
    L5:
        r0 = false;
        goto L7
    }

    public static void r(Context r10, String r11, String r12, Function2 r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        if (f("save_album", "image", true) == null) goto L7;
        if (r13 == null) goto L9;
        r13.invoke(Boolean.FALSE, "");
        return;
    L9:
        return;
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ImageSave$saveBitmapWithFilePath$1(r11, r13, r10, r12, null), 3, null);
    }

    public static /* synthetic */ void s(ImageSave r0, Context r1, String r2, Function2 r3) {
        r0.getClass();
        r(r1, r2, null, r3);
    }

    public static void u(final Context r6, final String r7, final String r8, final Function2 r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "filePath");
        String r0 = r7.toLowerCase(Locale.getDefault());
        boolean r2 = false;
        if (StringsKt.endsWith$default(r0, ".mp4", false, 2, null) == false) goto L5;
    L10:
        r2 = true;
    L11:
        if (r2 == false) goto L19;
        if (r8 != null) goto L15;
        r8 = Environment.DIRECTORY_MOVIES;
    L15:
        if (f("save_album", "video", true) == null) goto L18;
        if (r9 == null) goto L23;
        r9.invoke(Boolean.FALSE, "");
        return;
    L23:
        return;
    L18:
        ((ExecutorService) b.getValue()).execute(new q1(r7, r9, r6, r8));
        return;
    L19:
        if (r8 != null) goto L21;
        r8 = Environment.DIRECTORY_DCIM;
    L21:
        r(r6, r7, r8, r9);
        return;
    L5:
        if (StringsKt.endsWith$default(r0, ".mkv", false, 2, null) == true) goto L10;
        if (StringsKt.endsWith$default(r0, ".avi", false, 2, null) == true) goto L10;
        if (StringsKt.endsWith$default(r0, ".mov", false, 2, null) == false) goto L11;
        goto L10
    }

    public static /* synthetic */ void v(ImageSave r0, Context r1, String r2, od8.q r3) {
        r0.getClass();
        u(r1, r2, null, r3);
    }

    public final Object o(String r9, Map<String, String> r10, boolean r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof ImageSave$saveBitmapInternal$1) == false) goto L7;
        ImageSave$saveBitmapInternal$1 r0 = (ImageSave$saveBitmapInternal$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ImageSave$saveBitmapInternal$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        String r7 = null;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r13);
    L68:
        String r14 = (String) r13;
        if (r14 == null) goto L72;
        a.getClass();
        g(r14);
    L72:
        return Boxing.boxBoolean(com.larus.utils.o0.d(r14));
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r13);
    L58:
        String r15 = (String) r13;
        if (r15 == null) goto L62;
        a.getClass();
        g(r15);
    L62:
        return Boxing.boxBoolean(com.larus.utils.o0.d(r15));
    L17:
        r11 = r6.Z$0;
        r10 = (Map) r6.L$0;
        ResultKt.throwOnFailure(r13);
    L45:
        ImageRequest r4 = ImageRequestBuilder.newBuilderWithSource((Uri) r13).setProgressiveRenderingEnabled(true).build();
        CacheKey r16 = Fresco.getImagePipeline().getCacheKey(r4, AppHost.a.getApplication());
        if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r16) == false) goto L65;
        FileBinaryResource r17 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r16);
        if ((r17 instanceof FileBinaryResource) == false) goto L50;
        FileBinaryResource r18 = r17;
    L51:
        if (r18 == null) goto L53;
        File r19 = r18.getFile();
    L54:
        if (r19 != null) goto L63;
        FLogger.a.i("ImageSave", "cache file is not null");
        r6.L$0 = null;
        r6.label = 2;
        r13 = i(this, r4, r10, null, r11, r6, 12);
        if (r13 != r2) goto L58;
        return r2;
    L63:
        FLogger.a.i("ImageSave", "cache file is exist");
        ImageFormat r110 = ImageFormatChecker.getImageFormat(r19.getAbsolutePath());
        ImageSave r5 = a;
        Intrinsics.checkNotNull(r110);
        r5.getClass();
        return Boxing.boxBoolean(q(r19, r110, r10, r11));
    L53:
        r19 = null;
        goto L54
    L50:
        r18 = null;
        goto L51
    L65:
        FLogger.a.i("ImageSave", "cache is not exist, start download");
        r6.L$0 = null;
        r6.label = 3;
        r13 = i(this, r4, r10, null, r11, r6, 12);
        if (r13 != r2) goto L68;
        return r2;
    L18:
        ResultKt.throwOnFailure(r13);
        if (r9.length() != 0) goto L21;
        boolean r111 = true;
    L22:
        if (r111 == false) goto L26;
        FLogger.a.w("ImageSave", "url is null");
        return Boxing.boxBoolean(false);
    L26:
        if (StringsKt.startsWith$default(r9, "data:", false, 2, null) == false) goto L35;
        if (StringsKt.contains$default(r9, "base64", false, 2, null) == false) goto L35;
        String r20 = n(r9, r11);
        if (r20 == null) goto L33;
        a.getClass();
        g(r20);
        r7 = r20;
    L33:
        return Boxing.boxBoolean(com.larus.utils.o0.d(r7));
    L35:
        if (StringsKt.startsWith$default(r9, "file", false, 2, null) == false) goto L42;
        String r21 = UriProtector.parse(r9).getPath();
        if (r21 == null) goto L41;
        ImageFormat r112 = ImageFormatChecker.getImageFormat(r21);
        ImageSave r113 = a;
        PolarisFileWrapper r8 = new PolarisFileWrapper(r21);
        Intrinsics.checkNotNull(r112);
        r113.getClass();
        return Boxing.boxBoolean(q(r8, r112, null, r11));
    L41:
        return Boxing.boxBoolean(false);
    L42:
        r6.L$0 = r10;
        r6.Z$0 = r11;
        r6.label = 1;
        r13 = ImageLoaderKt.r(r9, "image_save", r6);
        if (r13 != r2) goto L45;
        return r2;
    L21:
        r111 = false;
    L7:
        r0 = new ImageSave$saveBitmapInternal$1(this, r12);
        goto L8
    }

    public final Object y(Context r18, String r19, Map<String, String> r20, Continuation<? super Uri> r21) {
        if ((r21 instanceof ImageSave$saveOriginImageForCopy$1) == false) goto L7;
        ImageSave$saveOriginImageForCopy$1 r1 = (ImageSave$saveOriginImageForCopy$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Context r5 = (Context) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Object r6 = r0;
        Context r7 = r5;
    L22:
        String r8 = (String) r6;
        if (r8 != null) goto L34;
        return null;
    L34:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L27
        Object r10 = Result.constructor-impl(i1.c(r7, new PolarisFileWrapper(r8)));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r10) == false) goto L33;
        return null;
    L33:
        return r10;
    L27:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (f("copy_file", "image", true) == null) goto L17;
        return null;
    L17:
        r7 = r18;
        r1.L$0 = r7;
        r1.label = 1;
        kotlinx.coroutines.j r12 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r1), 1);
        r12.C();
        z(a, r19, null, r20, null, false, false, null, new s1(r12), MessageCellStateTransformerType.DOWNLOAD_APP_ENTITY);
        r6 = r12.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L20:
        if (r6 != r3) goto L22;
        return r3;
    L7:
        r1 = new ImageSave$saveOriginImageForCopy$1(this, r21);
        goto L8
    }

    public static Object l(ImageSave r7, Context r8, String r9, String r10, Continuation r11) {
        String r4 = r8.getApplicationInfo().loadLabel(r8.getPackageManager()).toString();
        r7.getClass();
        if (f("export_downloads", "file", true) == null) goto L6;
        return null;
    L6:
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageSave$exportCacheFileToDownloads$2(r9, r10, r4, r8, null), r11);
    }

    public static final Object c(ImageSave r8, String r9, Function1 r10, Map r11, boolean r12, Continuation r13) {
        r8.getClass();
        if ((r13 instanceof ImageSave$doSaveOriginImageForShareInternal$1) == false) goto L7;
        ImageSave$doSaveOriginImageForShareInternal$1 r0 = (ImageSave$doSaveOriginImageForShareInternal$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        String r5 = null;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        boolean r16 = r0.Z$0;
        Map r17 = (Map) r0.L$2;
        Function1 r18 = (Function1) r0.L$1;
        String r19 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
        r12 = r16;
        r9 = r19;
        r11 = r17;
        r10 = r18;
    L46:
        String r20 = (String) r14;
        if (r20 == null) goto L49;
        r10.invoke(r20);
        return Unit.INSTANCE;
    L49:
        File r110 = null;
    L50:
        if (r110 != null) goto L79;
        FLogger.a.w("ImageSave", "cacheFile is null, url(" + r9 + ')');
        r10.invoke(null);
    L79:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L58
        if (r110 == null) goto L55;
        String r22 = r110.getAbsolutePath();     // Catch: Throwable -> L58
    L56:
        Object r23 = Result.constructor-impl(ImageFormatChecker.getImageFormat(r22));     // Catch: Throwable -> L58
    L61:
        if (Result.isFailure-impl(r23) == false) goto L63;
        r23 = null;
    L63:
        ImageFormat r24 = (ImageFormat) r23;
        StringBuilder r25 = new StringBuilder("share_");
        r25.append(System.currentTimeMillis());
        r25.append('.');
        if (r24 == null) goto L67;
        String r3 = r24.getFileExtension();
        if (r3 == null) goto L67;
    L68:
        r25.append(r3);
        String r26 = r25.toString();
        String r4 = i1.b();
        if (i1.d(r110, r4, r26) == false) goto L77;
        String r27 = r4 + File.separator + r26;
        int r111 = yq8.a.a;
        if (r24 == null) goto L73;
        r5 = r24.getFileExtension();
    L73:
        yq8.a.a(r27, r11, r5);
        if (r12 == false) goto L76;
        com.larus.platform.service.e.a(r27);
    L76:
        r10.invoke(r27);
        return Unit.INSTANCE;
    L77:
        FLogger.a.w("ImageSave", "save failed");
        r10.invoke(null);
        return Unit.INSTANCE;
    L67:
        r3 = "jpeg";
        goto L68
    L55:
        r22 = null;
    L58:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L61
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r12 = r0.Z$0;
        r11 = (Map) r0.L$2;
        r10 = (Function1) r0.L$1;
        r9 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L35:
        ImageRequest r29 = ImageRequestBuilder.newBuilderWithSource((Uri) r14).setProgressiveRenderingEnabled(true).build();
        CacheKey r6 = Fresco.getImagePipeline().getCacheKey(r29, AppHost.a.getApplication());
        if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r6) == false) goto L43;
        FileBinaryResource r30 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r6);
        if ((r30 instanceof FileBinaryResource) == false) goto L40;
        FileBinaryResource r31 = r30;
    L41:
        if (r31 == null) goto L49;
        r110 = r31.getFile();
        goto L50
    L40:
        r31 = null;
        goto L41
    L43:
        CoroutineDispatcher r7 = Dispatchers.getIO();
        ImageSave$doSaveOriginImageForShareInternal$cacheFile$path$1 r32 = new ImageSave$doSaveOriginImageForShareInternal$cacheFile$path$1(r29, r11, r12, null);
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.L$2 = r11;
        r0.Z$0 = r12;
        r0.label = 2;
        r14 = BuildersKt.withContext(r7, r32, r0);
        if (r14 != r15) goto L46;
        return r15;
    L16:
        ResultKt.throwOnFailure(r14);
        if (r9.length() != 0) goto L19;
        boolean r33 = true;
    L20:
        if (r33 == false) goto L23;
        FLogger.a.w("ImageSave", "doSaveOriginImageForShareInternal url is null");
        r10.invoke(null);
        return Unit.INSTANCE;
    L23:
        if (StringsKt.contains$default(r9, "base64", false, 2, null) == false) goto L28;
        String r34 = n(r9, r12);
        if (r34 == null) goto L49;
        r110 = new PolarisFileWrapper(r34);
        goto L50
    L28:
        if (StringsKt.startsWith$default(r9, "file", false, 2, null) == false) goto L32;
        String r35 = UriProtector.parse(r9).getPath();
        if (r35 == null) goto L49;
        r110 = new PolarisFileWrapper(r35);
        goto L50
    L32:
        r0.L$0 = r9;
        r0.L$1 = r10;
        r0.L$2 = r11;
        r0.Z$0 = r12;
        r0.label = 1;
        r14 = ImageLoaderKt.r(r9, "image_save_share", r0);
        if (r14 != r15) goto L35;
        return r15;
    L19:
        r33 = false;
    L7:
        r0 = new ImageSave$doSaveOriginImageForShareInternal$1(r8, r13);
        goto L8
    }

    public static final Object d(ImageSave r12, String r13, String r14, Map r15, boolean r16, Continuation r17) {
        r12.getClass();
        if ((r17 instanceof ImageSave$downloadImageToLocalInternal$1) == false) goto L7;
        ImageSave$downloadImageToLocalInternal$1 r2 = (ImageSave$downloadImageToLocalInternal$1) r17;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L48:
        return r1;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r0 = r2.Z$0;
        String r6 = (String) r2.L$1;
        Map r8 = (Map) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Object r9 = r1;
        String r7 = r6;
        Map r10 = r8;
    L31:
        ImageRequest r11 = ImageRequestBuilder.newBuilderWithSource((Uri) r9).setProgressiveRenderingEnabled(true).build();
        CacheKey r18 = Fresco.getImagePipeline().getCacheKey(r11, AppHost.a.getApplication());
        if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(r18) == false) goto L44;
        FileBinaryResource r19 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(r18);
        if ((r19 instanceof FileBinaryResource) == false) goto L36;
        FileBinaryResource r20 = r19;
    L37:
        if (r20 == null) goto L39;
        File r21 = r20.getFile();
    L40:
        if (r21 == null) goto L44;
        if (r21.exists() == false) goto L44;
        ImageFormat r22 = ImageFormatChecker.getImageFormat(r21.getAbsolutePath());
        PolarisFileInputStreamWrapper r23 = new PolarisFileInputStreamWrapper(r21);
        Intrinsics.checkNotNull(r22);
        return t(r23, r22, r10, Boxing.boxBoolean(true), r7, r0);
    L39:
        r21 = null;
        goto L40
    L36:
        r20 = null;
    L44:
        Boolean r24 = Boxing.boxBoolean(true);
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 2;
        r1 = h(r11, r10, r24, r7, r0, r2);
        if (r1 != r4) goto L48;
        return r4;
    L16:
        ResultKt.throwOnFailure(r1);
        if (r13.length() != 0) goto L19;
        boolean r25 = true;
    L21:
        if (r25 == false) goto L24;
        FLogger.a.w("ImageSave", "downloadImageToLocalInternal url is null");
    L49:
        return null;
    L24:
        if (com.larus.utils.y0.e(r13) == true) goto L27;
        FLogger.a.w("ImageSave", "downloadImageToLocalInternal url is invalid ".concat(r13));
        goto L49
    L27:
        r7 = StringsKt.substringAfterLast$default(StringsKt.trimEnd(r14, new char[]{'/'}), '/', null, 2, null);
        r10 = r15;
        r2.L$0 = r10;
        r2.L$1 = r7;
        r2.Z$0 = r16;
        r2.label = 1;
        Object r26 = ImageLoaderKt.r(r13, "image_save_share", r2);
        if (r26 == r4) goto L51;
        r9 = r26;
        r0 = r16;
        goto L31
    L51:
        return r4;
    L19:
        r25 = false;
    L7:
        r2 = new ImageSave$downloadImageToLocalInternal$1(r12, r17);
        goto L8
    }

    public static Object h(ImageRequest r8, Map r9, Boolean r10, String r11, boolean r12, Continuation r13) {
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r13), 1);
        r6.C();
        DataSource r14 = Fresco.getImagePipeline().fetchEncodedImage(r8, AppHost.a.getApplication());
        r6.i(new c(r14));
        r14.subscribe(new d(r6, r9, r10, r11, r12), CallerThreadExecutor.getInstance());
        Object r15 = r6.B();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L5:
        return r15;
    }

    public static String t(InputStream r6, ImageFormat r7, Map r8, Boolean r9, String r10, boolean r11) {
        PolarisFileOutputStreamWrapper r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r10 != null) goto L7;
        r10 = String.valueOf(System.currentTimeMillis());
    L7:
        String r12 = r10 + '.' + r7.getFileExtension();
        String r1 = i1.b();
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L68:
        boolean r13 = false;
    L69:
        if (r13 == false) goto L77;
        String r14 = r1 + File.separator + r12;
        int r15 = yq8.a.a;
        yq8.a.a(r14, r8, r7.getFileExtension());
        if (r11 == false) goto L74;
        com.larus.platform.service.e.a(r14);
    L74:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L76;
        i1.f(AppHost.a.getApplication(), r14, true);
    L76:
        return r14;
    L77:
        FLogger.a.w("ImageSave", "save failed");
        return null;
    L10:
        if (TextUtils.isEmpty(r12) == true) goto L68;
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L68;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1);
        if (r2.exists() == true) goto L17;
        r2.mkdirs();
    L17:
        PolarisFileWrapper r4 = new PolarisFileWrapper(r2 + "/" + r12);
        if (r4.exists() == true) goto L97;
        r4.createNewFile();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L97:
        PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(r4);     // Catch: Throwable -> L43 Exception -> L45
    L95:
        byte[] r5 = new byte[2048];     // Catch: Throwable -> L39 Exception -> L41
    L27:
        if (r6.read(r5) < 0) goto L29;
        r3.write(r5);     // Catch: Throwable -> L39 Exception -> L41
        goto L27
    L29:
        r3.flush();     // Catch: Throwable -> L39 Exception -> L41
        r6.close();     // Catch: Exception -> L32
    L83:
        r3.close();     // Catch: Exception -> L36
    L38:
        r13 = true;
    L36:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L83
    L41:
        Exception e = e;
    L79:
        e.printStackTrace();     // Catch: Throwable -> L56
        r6.close();     // Catch: Exception -> L50
    L85:
        r3.close();     // Catch: Exception -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L50:
        e = move-exception;
        e.printStackTrace();
    L56:
        th = th;
        r0 = r3;
    L58:
        r3 = r0;
    L87:
        r6.close();     // Catch: Exception -> L61
    L81:
        r3.close();     // Catch: Exception -> L65
        throw th;
    L65:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L61:
        e = move-exception;
        e.printStackTrace();
    L39:
        th = th;
    L45:
        e = move-exception;
        e = e;
        r3 = null;
    L43:
        th = th;
        goto L58
    }

    public static void w(String r12, Map r13, Function3 r14, Function1 r15, Function1 r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r12, "url");
        if (f("save_album", "image", true) == null) goto L7;
        if (r14 == null) goto L9;
        r14.invoke(Boolean.FALSE, r12, null);
        return;
    L9:
        return;
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ImageSave$saveOriginImage$1(r12, r15, r13, r17, r16, r14, null), 3, null);
    }

    public static /* synthetic */ Object i(ImageSave r6, ImageRequest r7, Map r8, Boolean r9, boolean r10, Continuation r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        Map r1 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = Boolean.FALSE;
    L8:
        Boolean r2 = r9;
        if ((r12 & 16) == 0) goto L11;
        boolean r4 = false;
    L12:
        r6.getClass();
        return h(r7, r1, r2, null, r4, r11);
    L11:
        r4 = r10;
        goto L12
    }

    public static /* synthetic */ void x(ImageSave r2, String r3, Map r4, Function3 r5, Function1 r6, boolean r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 32) == 0) goto L14;
        r7 = false;
    L14:
        r2.getClass();
        w(r3, r4, r5, r6, null, r7);
    }

    public static void z(ImageSave r14, String r15, Bitmap r16, Map r17, Function1 r18, boolean r19, boolean r20, CoroutineScope r21, Function1 r22, int r23) {
        if ((r23 & 2) == 0) goto L5;
        Bitmap r5 = null;
    L7:
        if ((r23 & 4) == 0) goto L9;
        Map r3 = null;
    L11:
        if ((r23 & 8) == 0) goto L13;
        Function1 r6 = null;
    L14:
        boolean r4 = false;
        if ((r23 & 16) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r23 & 32) != 0) goto L23;
        r4 = r20;
    L23:
        if ((r23 & 64) == 0) goto L25;
        CoroutineScope r8 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    L26:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "url");
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r22, "callback");
        if (r4 == true) goto L29;
    L31:
        BuildersKt.launch$default(r8, null, null, new ImageSave$saveOriginImageForShare$1(r15, r22, r3, r7, r5, r6, null), 3, null);
        return;
    L29:
        if (f("share_prepare", "image", true) == null) goto L31;
        r22.invoke(null);
        return;
    L25:
        r8 = r21;
        goto L26
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L14
    L9:
        r3 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }
}
