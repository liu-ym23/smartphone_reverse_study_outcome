package com.obric.memorydata.middleware.impl.image;

import android.content.Context;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.utility.NetworkUtils;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.w;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import com.ss.bduploader.UploadEventManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J*\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0002J(\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\f\u0010!\u001a\u00020\"*\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploader;", "", "<init>", "()V", "uploadAwaiter", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadAwaiter;", "uploadFileSync", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", "bizType", "Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;", "file", "Ljava/io/File;", "(Lcom/obric/memorydata/middleware/impl/image/ImageXBizType;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureUploader", "", "uploader", "Lcom/ss/bduploader/BDImageXUploader;", "token", "Lcom/obric/memorydata/middleware/impl/image/ImageXToken;", "createUploadListener", "Lcom/ss/bduploader/BDImageXUploaderListener;", "finish", "Lkotlin/Function1;", "progress", "Lkotlin/Function0;", "logUpload", "context", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "event", "", "code", "startedAt", "", "hasRequiredUploadFields", "", "COMMIT_TYPE_NO_COMMIT", "", "TOKEN_EXPIRED", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f11724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final j f11725b = null;

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"com/obric/memorydata/middleware/impl/image/ImageXFileUploader$createUploadListener$1", "Lcom/ss/bduploader/BDImageXUploaderListener;", "onNotify", "", "what", "", "parameter", "", "info", "Lcom/ss/bduploader/BDImageXInfo;", "onLog", "code", "", "imageXUploadCheckNetState", "errorCode", "tryCount", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements BDImageXUploaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<d, Unit> f11726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f11727b;

        a(Function1<? super d, Unit> r3, Function0<Unit> r4) {
            Function1<d, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
            this.f11726a = r5;
            this.f11727b = r6;
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public int imageXUploadCheckNetState(int r1, int r2) {
            return NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) ? 1 : 0;
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public void onLog(int r1, int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "info");
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public void onNotify(int r19, long r20, BDImageXInfo r22) {
            if (r19 != 0) goto L5;
            Function1<d, Unit> r0 = this.f11726a;
            d r7 = new d(null, null, "imagex upload completed without file result", 3, null);
        L54:
            r0.invoke(r7);
            return;
        L5:
            if (r19 == 1) goto L52;
            String r5 = null;
            if (r19 != 2) goto L9;
        L28:
            Function1<d, Unit> r1 = this.f11726a;
            if (r22 == null) goto L39;
            Long r2 = Long.valueOf(r22.mErrorCode);
            if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() == 0) goto L33;
            boolean r4 = true;
        L34:
            if (r4 == true) goto L37;
            r2 = null;
        L37:
            if (r2 == null) goto L39;
            long r9 = r2.longValue();
        L40:
            Long r10 = Long.valueOf(r9);
            if (r22 == null) goto L50;
            String r3 = r22.mErrorMsg;
            if (r3 == null) goto L50;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L47;
            r5 = r3;
        L47:
            if (r5 == null) goto L50;
            String r11 = r5;
        L51:
            d r6 = new d(null, r10, r11, 1, null);
        L26:
            r1.invoke(r6);
            return;
        L50:
            r11 = "imagex file upload failed";
            goto L51
        L33:
            r4 = false;
        L39:
            r9 = r20;
            goto L40
        L9:
            if (r19 != 3) goto L11;
            r0 = this.f11726a;
            r7 = new d(null, null, "imagex file upload canceled", 3, null);
            goto L54
        L11:
            if (r19 != 6) goto L13;
            r1 = this.f11726a;
            if (r22 == null) goto L25;
            String r8 = r22.mImageTosKey;
            if (r8 == null) goto L25;
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L22;
            String r12 = r8;
        L23:
            if (r12 == null) goto L25;
            r6 = new d(r12, null, null, 6, null);
            goto L26
        L22:
            r12 = null;
        L25:
            r6 = new d(null, null, "imagex upload returned no key", 3, null);
            goto L26
        L13:
            if (r19 == 7) goto L28;
            return;
        L52:
            this.f11727b.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/middleware/impl/image/ImageXFileUploader$uploadFileSync$2$1", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadHandle;", CommonConsts.APM_INNER_EVENT_COST_START, "", "complete", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, IslandSession.REOPEN_VALUE_CLOSE, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f11728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BDImageXUploader f11729b;
        final /* synthetic */ File c;
        final /* synthetic */ ImageXBizType d;
        final /* synthetic */ AtomicLong e;
        final /* synthetic */ com.obric.memorydata.middleware.api.logging.e f;
        final /* synthetic */ long g;

        b(i r1, BDImageXUploader r2, File r3, ImageXBizType r4, AtomicLong r5, com.obric.memorydata.middleware.api.logging.e r6, long r7) {
            this.f11728a = r1;
            this.f11729b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        private static final Unit a(AtomicLong r9, com.obric.memorydata.middleware.api.logging.e r10, long r11) {
            long r0 = System.nanoTime();
            long r2 = r9.get();
            if ((r0 - r2) < TimeUnit.SECONDS.toNanos(10)) goto L8;
            if (r9.compareAndSet(r2, r0) == false) goto L8;
            e.a(e.f11724a, r10, "upload_progress", "NONE", r11);
        L8:
            return Unit.INSTANCE;
        }

        private static final Unit a(Function1 r4, ImageXBizType r5, i r6, d r7) {
            Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "result");
            r8.invoke(r7);
            Long r9 = r7.b();
            if (r9 == null) goto L9;
            if (r9.longValue() != 100028) goto L9;
            com.obric.memorydata.middleware.impl.image.b.f11718a.a(r5, r6);
        L9:
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$AIGaE6WWcrZJdGbPp_J1Jsx_VR8(AtomicLong r0, com.obric.memorydata.middleware.api.logging.e r1, long r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ Unit lambda$HpYVZiEYIzJzXYFmTM9JPYsXV0c(Function1 r0, ImageXBizType r1, i r2, d r3) {
            return a(r0, r1, r2, r3);
        }

        @Override // com.obric.memorydata.middleware.impl.image.l
        public void a() {
            BDImageXUploader r0 = this.f11729b;
            if (r0 == null) goto L6;
            r0.cancelUpload();
            return;
        }

        @Override // com.obric.memorydata.middleware.impl.image.l
        public void a(Function1<? super d, Unit> r8) {
            final Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "complete");
            if (this.f11728a != null) goto L5;
        L9:
            r9.invoke(new d(null, null, "UPLOAD_AUTH_FAILED", 3, null));
            return;
        L5:
            if (this.f11729b == null) goto L9;
            e.a(e.f11724a, this.f11729b, this.c, this.f11728a);
            BDImageXUploader r0 = this.f11729b;
            e r1 = e.f11724a;
            final ImageXBizType r2 = this.d;
            final i r3 = this.f11728a;
            Function1 r4 = new $$Lambda$e$b$HpYVZiEYIzJzXYFmTM9JPYsXV0c(r9, r2, r3);
            final AtomicLong r10 = this.e;
            final com.obric.memorydata.middleware.api.logging.e r5 = this.f;
            final long r6 = this.g;
            r0.setListener(e.a(r1, r4, new $$Lambda$e$b$AIGaE6WWcrZJdGbPp_J1Jsx_VR8(r10, r5, r6)));
            this.f11729b.start();
        }

        @Override // com.obric.memorydata.middleware.impl.image.l
        public void b() {
            BDImageXUploader r0 = this.f11729b;
            if (r0 == null) goto L6;
            r0.close();
            return;
        }
    }

    static {
        f11724a = new e();
        f11725b = new j(0, 0, 3, null);
    }

    private e() {
    }

    private static final l a(ImageXBizType r11, File r12, AtomicLong r13, com.obric.memorydata.middleware.api.logging.e r14, long r15) {
        boolean r1 = false;
        UploadEventManager.instance.setUseEngineUploader(false);
        i r3 = com.obric.memorydata.middleware.impl.image.b.f11718a.a(r11);
        if (r3 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        BDImageXUploader r0 = new BDImageXUploader();
    L11:
        return (l) ZeusTransformUtils.preCheckCast(new b(r3, r0, r12, r11, r13, r14, r15), l.class, "com.obric.memorydata.plugin");
    L9:
        r0 = null;
        goto L11
    L5:
        if (f11724a.a(r3) != true) goto L7;
        r1 = true;
        goto L7
    }

    public static final /* synthetic */ BDImageXUploaderListener a(e r2, Function1 r3, Function0 r4) {
        return r2.a((Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    private final BDImageXUploaderListener a(Function1<? super d, Unit> r2, Function0<Unit> r3) {
        return (BDImageXUploaderListener) ZeusTransformUtils.preCheckCast(new a((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin")), BDImageXUploaderListener.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(com.obric.memorydata.middleware.api.logging.e r7, long r8, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, "code");
        f11724a.a(r7, r10, r11, r8);
        return Unit.INSTANCE;
    }

    private static final Unit a(String r2, String r3, long r4, com.obric.memorydata.middleware.api.logging.g r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$mainTrace");
        r6.a("upload_event", r2);
        r6.a("upload_code", r3);
        r6.a("elapsed_ms", Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r4)));
        return Unit.INSTANCE;
    }

    private final void a(com.obric.memorydata.middleware.api.logging.e r9, final String r10, final String r11, final long r12) {
        if (Intrinsics.areEqual(r10, "upload_progress") == false) goto L8;
        o r8 = (o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin");
        if (AppContext.INSTANCE.isDebug() == false) goto L10;
        com.obric.memorydata.middleware.api.logging.g r13 = new com.obric.memorydata.middleware.api.logging.g();
        r13.a("elapsed_ms", Long.valueOf(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r12)));
        Unit r14 = Unit.INSTANCE;
        r8.a("文件上传进行中", r9, r13.a());
        return;
    L10:
        return;
    L8:
        o.a((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin"), "文件上传状态", r10, r9, new $$Lambda$e$A4yKDAEFjAWJ9y1s1u0V12IZJFs(r10, r11, r12), null, 16, null);
    }

    public static final /* synthetic */ void a(e r0, com.obric.memorydata.middleware.api.logging.e r1, String r2, String r3, long r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(e r0, BDImageXUploader r1, File r2, i r3) {
        r0.a(r1, r2, r3);
    }

    private final void a(BDImageXUploader r6, File r7, i r8) {
        r6.setFilePath(1, new String[]{r7.getAbsolutePath()});
        String r9 = FilesKt.getExtension(r7);
        String r3 = null;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L6;
        r9 = null;
    L6:
        if (r9 == null) goto L8;
        r6.setFileExtension('.' + r9);
    L8:
        r6.setUploadDomain(r8.f());
        String r10 = r8.g();
        if (r10 != null) goto L11;
    L15:
        r6.setTopAccessKey(r8.a());
        r6.setTopSecretKey(r8.b());
        r6.setTopSessionToken(r8.c());
        r6.setServiceID(r8.e());
        r6.setEnableCommitUpload(0);
        return;
    L11:
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L13;
        r3 = r10;
    L13:
        if (r3 == null) goto L15;
        r6.setFilePrefix(r3);
        goto L15
    }

    private final boolean a(i r5) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L44;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.b(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L45;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.c(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == true) goto L46;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.e(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L29;
    L32:
        boolean r12 = true;
    L33:
        if (r12 == true) goto L47;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.f(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L37;
    L40:
        boolean r14 = true;
    L41:
        if (r14 == false) goto L43;
        return false;
    L43:
        return true;
    L37:
        if (StringsKt.isBlank(r13) == true) goto L40;
        r14 = false;
        goto L41
    L47:
        return false;
    L29:
        if (StringsKt.isBlank(r11) == true) goto L32;
        r12 = false;
        goto L33
    L46:
        return false;
    L21:
        if (StringsKt.isBlank(r9) == true) goto L24;
        r10 = false;
        goto L25
    L45:
        return false;
    L13:
        if (StringsKt.isBlank(r7) == true) goto L16;
        r8 = false;
        goto L17
    L44:
        return false;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r6 = false;
        goto L9
    }

    public static /* synthetic */ Unit lambda$A4yKDAEFjAWJ9y1s1u0V12IZJFs(String r0, String r1, long r2, com.obric.memorydata.middleware.api.logging.g r4) {
        return a(r0, r1, r2, r4);
    }

    /* JADX INFO: renamed from: lambda$Wtllf-b_ZNzXVeMLbAoCuTGB5gI, reason: not valid java name */
    public static /* synthetic */ l m1018lambda$Wtllfb_ZNzXVeMLbAoCuTGB5gI(ImageXBizType r0, File r1, AtomicLong r2, com.obric.memorydata.middleware.api.logging.e r3, long r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$ZPajkO75Od9cafpLJH7C3efjAvs(com.obric.memorydata.middleware.api.logging.e r0, long r1, String r3, String r4) {
        return a(r0, r1, r3, r4);
    }

    public final Object a(final ImageXBizType r14, final File r15, Continuation<? super d> r16) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r16, Continuation.class, "com.obric.memorydata.plugin");
        if (r15.isFile() == true) goto L7;
        return new d(null, null, "local file does not exist", 3, null);
    L7:
        if (r14 != ImageXBizType.AUDITORY_MEMORY_FILE) goto L9;
        String r0 = "auditory";
    L11:
        if (r14 != ImageXBizType.AUDITORY_MEMORY_FILE) goto L13;
        String r2 = FilesKt.getNameWithoutExtension(r15);
    L14:
        final com.obric.memorydata.middleware.api.logging.e r8 = new com.obric.memorydata.middleware.api.logging.e(r0, r2, "image_upload");
        final long r9 = System.nanoTime();
        final AtomicLong r3 = new AtomicLong(r9);
        return j.a(f11725b, new $$Lambda$e$Wtllfb_ZNzXVeMLbAoCuTGB5gI(r14, r15, r3, r8, r9), new $$Lambda$e$ZPajkO75Od9cafpLJH7C3efjAvs(r8, r9), null, r7, 4, null);
    L13:
        r2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        goto L14
    L9:
        r0 = "imagex_file";
        goto L11
    }
}
