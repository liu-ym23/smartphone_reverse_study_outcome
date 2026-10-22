package com.obric.memorydata.middleware.impl.image;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JH\u0010\u0006\u001a\u00020\u00072\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\rH\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXSingleImageUpload;", "", "awaiter", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadAwaiter;", "<init>", "(Lcom/obric/memorydata/middleware/impl/image/ImageXUploadAwaiter;)V", "upload", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", "diagnostic", "Lkotlin/Function2;", "", "", "unusedCleanup", "Lkotlin/Function0;", "create", "Lcom/obric/memorydata/middleware/impl/image/ImageXSingleImageHandle;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f11732a;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/middleware/impl/image/ImageXSingleImageUpload$upload$4$1", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadHandle;", CommonConsts.APM_INNER_EVENT_COST_START, "", "complete", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, IslandSession.REOPEN_VALUE_CLOSE, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f11733a;

        /* JADX INFO: renamed from: com.obric.memorydata.middleware.impl.image.h$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/middleware/impl/image/ImageXSingleImageUpload$upload$4$1$start$1", "Lcom/obric/memorydata/middleware/impl/image/ImageXUploadCallback;", "onSuccess", "", "fileIndex", "", "imageUrl", "", "onFailure", "errorCode", "", "errorMessage", "onComplete", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0633a implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1<d, Unit> f11734a;

            C0633a(Function1<? super d, Unit> r3) {
                this.f11734a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            }

            @Override // com.obric.memorydata.middleware.impl.image.k
            public void a() {
                this.f11734a.invoke(new d(null, null, "UPLOAD_MISSING_RESULT", 3, null));
            }

            @Override // com.obric.memorydata.middleware.impl.image.k
            public void a(int r7, long r8, String r10) {
                Intrinsics.checkNotNullParameter(r10, "errorMessage");
                this.f11734a.invoke(new d(null, Long.valueOf(r8), r10, 1, null));
            }

            @Override // com.obric.memorydata.middleware.impl.image.k
            public void a(int r13, String r14) {
                Intrinsics.checkNotNullParameter(r14, "imageUrl");
                Function1<d, Unit> r12 = this.f11734a;
                if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
                d r15 = new d(null, null, "UPLOAD_EMPTY_RESULT", 3, null);
            L6:
                r12.invoke(r15);
                return;
            L5:
                r15 = new d(r14, null, null, 6, null);
                goto L6
            }
        }

        a(g r3) {
            this.f11733a = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.middleware.impl.image.l
        public void a() {
            this.f11733a.a();
        }

        @Override // com.obric.memorydata.middleware.impl.image.l
        public void a(Function1<? super d, Unit> r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "complete");
            this.f11733a.a((k) ZeusTransformUtils.preCheckCast(new C0633a(r4), k.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.memorydata.middleware.impl.image.l
        public void b() {
            this.f11733a.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public h(j r2) {
        Intrinsics.checkNotNullParameter(r2, "awaiter");
        this.f11732a = r2;
    }

    public /* synthetic */ h(j r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L5;
        r7 = new j(0, 0, 3, null);
    L5:
        this(r7);
    }

    private static final l a(Function0 r2) {
        return (l) ZeusTransformUtils.preCheckCast(new a((g) ZeusTransformUtils.preCheckCast(((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke(), g.class, "com.obric.memorydata.plugin")), l.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ l lambda$wGA75OZOFDJXm1FcqyBUCS0ql3c(Function0 r0) {
        return a(r0);
    }

    public final Object a(Function2<? super String, ? super String, Unit> r3, Function0<Unit> r4, Function0<? extends g> r5, Continuation<? super d> r6) {
        Function2<? super String, ? super String, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Continuation<? super d> r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return this.f11732a.a(new $$Lambda$h$wGA75OZOFDJXm1FcqyBUCS0ql3c(r9), r7, r8, r10);
    }
}
