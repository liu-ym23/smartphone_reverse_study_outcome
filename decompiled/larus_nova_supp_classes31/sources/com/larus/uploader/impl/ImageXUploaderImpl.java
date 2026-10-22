package com.larus.uploader.impl;

import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalDowngradeData;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.upload.UploadImageMetaResolver;
import com.larus.bmhome.upload.sdk.ResourceUploadEngine;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import mr9.j;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ImageXUploaderImpl implements b4 {
    public final String a;
    public BDImageXUploader b;
    public final CoroutineScope c;
    public b4.a d;
    public Job e;
    public final com.larus.platform.model.chat.c f;

    public final class ImageXUploadListener implements BDImageXUploaderListener {
        public final j a;
        public final /* synthetic */ ImageXUploaderImpl b;

        public final int imageXUploadCheckNetState(int r1, int r2) {
            return 1;
        }

        public ImageXUploadListener(ImageXUploaderImpl r2, j r3) {
            Intrinsics.checkNotNullParameter(r3, "param");
            this.b = r2;
            this.a = r3;
        }

        public static final Object a(ImageXUploadListener r13, BDImageXInfo r14, Continuation r15) {
            r13.getClass();
            if ((r15 instanceof ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1) == false) goto L7;
            ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1 r1 = (ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1) r15;
            int r2 = r1.label;
            if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
            r1.label = r2 - Integer.MIN_VALUE;
        L8:
            Object r16 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L18;
            if (r4 != 1) goto L17;
            Ref.ObjectRef r17 = (Ref.ObjectRef) r1.L$3;
            ImageXUploaderImpl r5 = (ImageXUploaderImpl) r1.L$2;
            Ref.ObjectRef r6 = (Ref.ObjectRef) r1.L$1;
            BDImageXInfo r7 = (BDImageXInfo) r1.L$0;
            ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
        L23:
            r17.element = r16;     // Catch: Throwable -> L14
            FLogger.a.i(r5.a, "[prepareUploadResult] local image size, height:" + ((mr9.d) r6.element).a + ", width:" + ((mr9.d) r6.element).b);     // Catch: Throwable -> L14
            Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L29:
            ImageXUploaderImpl r19 = r13.b;
            Throwable r110 = Result.exceptionOrNull-impl(r18);
            if (r110 == null) goto L32;
            FLogger.a.e(r19.a, "[handleOnUploadSuccess] parse local image size failed, " + r110);
        L32:
            FLogger.a.i(r13.b.a, "[handleOnUploadSuccess] success, uri:" + r7.mImageTosKey);
            return new l(r7.mImageTosKey, null, null, (mr9.d) r6.element, null, false, null, 118);
        L14:
            Throwable th = th;
            Ref.ObjectRef r111 = r6;
        L28:
            Result.Companion r0 = Result.Companion;
            r18 = Result.constructor-impl(ResultKt.createFailure(th));
            r6 = r111;
            goto L29
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r16);
            r111 = new Ref.ObjectRef();
            r111.element = new mr9.d(0, 0);
            ImageXUploaderImpl r8 = r13.b;
            Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L26
            UploadImageMetaResolver r10 = UploadImageMetaResolver.a;     // Catch: Throwable -> L26
            j r11 = r13.a;     // Catch: Throwable -> L26
            r1.L$0 = r14;     // Catch: Throwable -> L26
            r1.L$1 = r111;     // Catch: Throwable -> L26
            r1.L$2 = r8;     // Catch: Throwable -> L26
            r1.L$3 = r111;     // Catch: Throwable -> L26
            r1.label = 1;     // Catch: Throwable -> L26
            Object r12 = r10.b(r11, r1);     // Catch: Throwable -> L26
            if (r12 == r3) goto L38;
            r5 = r8;
            r6 = r111;
            r16 = r12;
            r7 = r14;
            r17 = r6;
            goto L23
        L38:
            return r3;
        L26:
            th = move-exception;
            r7 = r14;
            th = th;
        L7:
            r1 = new ImageXUploaderImpl$ImageXUploadListener$prepareUploadResult$1(r13, r15);
            goto L8
        }

        public final void onLog(int r5, int r6, String r7) {
            Job r0 = this.b.e;
            if (r0 == null) goto L5;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L5:
            ImageXUploaderImpl r1 = this.b;
            r1.e = null;
            FLogger.a.i(r1.a, "[onLog] what:" + r5 + ", code:" + r6 + ", info" + r7);
        }

        public final void onNotify(int r14, long r15, BDImageXInfo r17) {
            Job r0 = this.b.e;
            boolean r3 = true;
            if (r0 == null) goto L5;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L5:
            ImageXUploaderImpl r1 = this.b;
            r1.e = null;
            FLogger r5 = FLogger.a;
            r5.i(r1.a, "[onNotify] what:" + r14 + ", parameter:" + r15);
            if (r14 == 124) goto L8;
        L12:
            BuildersKt.launch$default(this.b.c, Dispatchers.getMain(), null, new ImageXUploaderImpl$ImageXUploadListener$onNotify$1(r15, this.b, r14, r17, this, null), 2, null);
            return;
        L8:
            if (r15 == 1) goto L11;
            r3 = false;
        L11:
            r5.i(this.b.a, "[preheat] resultUsed hit=" + r3);
            goto L12
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.larus.platform.api.b4
    public final void a() {
        FLogger r0 = FLogger.a;
        r0.i(this.a, "[doUpload] start");
        BDImageXUploader r1 = this.b;
        if (r1 == null) goto L5;
        r1.setPreheatUploader(3);
    L5:
        BDImageXUploader r2 = this.b;
        if (r2 == null) goto L9;
        r2.start();
    L9:
        if (this.f.a == false) goto L17;
        r0.i(this.a, "[doUpload] enable timeout, sdkTimeout: " + this.f.b);
        Job r3 = this.e;
        if (r3 == null) goto L13;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L13:
        this.e = BuildersKt.launch$default(this.c, null, null, new ImageXUploaderImpl$doUpload$1(this, null), 3, null);
        b4.a r4 = this.d;
        if (r4 == null) goto L18;
        r4.b(new k(0L, false));
        return;
    L18:
        return;
    }

    public final void c() {
        FLogger.a.i(this.a, "[destroy]");
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.e = null;
        BDImageXUploader r1 = this.b;
        if (r1 == null) goto L8;
        r1.close();
    L8:
        this.b = null;
        this.d = null;
    }

    public ImageXUploaderImpl(j r11) {
        Intrinsics.checkNotNullParameter(r11, "uploadParam");
        String r0 = "ImageXUploaderImpl_" + r11.l;
        this.a = r0;
        z2 r1 = z2.a;
        com.larus.platform.model.chat.d r2 = r1.getBDImageXUploaderConfig();
        this.c = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.f = r1.getBDImageXUploadOptConfig();
        FLogger.a.i(r0, "[createBDImageXUploader], params:" + r11);
        BDImageXUploader r3 = new BDImageXUploader();
        if (r11.g == false) goto L5;
        r3.setMediaDataReader(new com.larus.uploader.impl.a(r11.getContext(), r11.a), r11.i);
    L6:
        c.a(r3, r11.h);
        String r4 = r11.k;
        if (r4 != null) goto L9;
    L11:
        MultimodalDowngradeData r5 = ChatInputService.b.A6();
        Integer r6 = null;
        if (r5 == null) goto L21;
        Integer r7 = r5.getUploadRetryCount();
        if (r7 == null) goto L21;
        if (r7.intValue() < 0) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L21;
    L22:
        if (r5 == null) goto L31;
        Integer r9 = r5.getUploadRetryTimeout();
        if (r9 == null) goto L31;
        if (r9.intValue() < 0) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == false) goto L31;
        r6 = r9;
        goto L31
    L28:
        r10 = false;
    L31:
        r3.setSocketNum(r2.h());
        r3.setSliceRetryCount(r2.g());
        if (r7 == null) goto L34;
        int r12 = r7.intValue();
    L35:
        r3.setFileRetryCount(r12);
        r3.setEnableCommitUpload(0);
        if (r6 == null) goto L38;
        int r13 = r6.intValue();
    L39:
        r3.setSDKMaxRetryTimeout(r13);
        int r14 = r2.a();
        int r15 = r2.b();
        int r16 = r2.d();
        int r17 = r2.c();
        if (r7 == null) goto L42;
        int r18 = 1;
    L43:
        r3.setCustomNetworkTimeoutParams(r14, r15, r16, r17, r18);
        if (ArraysKt.contains(new String[]{"html", "xml", "svg+xml"}, r11.k) == false) goto L55;
        r3.setSpecifiedContentType(1, new String[]{"text/plain"});
    L55:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L48
        int r20 = com.larus.uploader.impl.preheat.c.a;     // Catch: Throwable -> L48
        r3.setServerParameter(com.larus.uploader.impl.preheat.c.a(AccountService.a.getUserId()));     // Catch: Throwable -> L48
        Object r21 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L48
    L50:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (r22 == null) goto L53;
        FLogger.a.e(this.a, "setServerParameter failed", r22);
    L53:
        r3.setOpenBoe(HttpExtKt.e().a);
        this.b = r3;
        r3.setListener(new ImageXUploadListener(this, r11));
        return;
    L48:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L42:
        r18 = 0;
        goto L43
    L38:
        r13 = r2.f();
        goto L39
    L34:
        r12 = r2.e();
        goto L35
    L18:
        r8 = false;
    L21:
        r7 = null;
        goto L22
    L9:
        if (o0.d(r4) == false) goto L11;
        r3.setFileExtension(".".concat(r4));
        goto L11
    L5:
        r3.setFilePath(r11.i, new String[]{r11.a});
        goto L6
    }

    @Override // com.larus.platform.api.b4
    public final void b(ResourceUploadEngine.upload.2.1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d = r2;
    }

    @Override // com.larus.platform.api.b4
    public final void cancel(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        FLogger.a.i(this.a, "[cancel]");
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.e = null;
        b4.a r1 = this.d;
        if (r1 == null) goto L8;
        r1.a(new ResourceUploadError(ResourceUploadError.CANCELED, r4));
    L8:
        BDImageXUploader r6 = this.b;
        if (r6 == null) goto L11;
        r6.cancelUpload();
    L11:
        if (r5 == false) goto L14;
        c();
        return;
    }
}
