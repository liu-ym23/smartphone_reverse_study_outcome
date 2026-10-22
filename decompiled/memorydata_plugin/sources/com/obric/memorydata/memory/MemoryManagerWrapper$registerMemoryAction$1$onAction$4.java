package com.obric.memorydata.memory;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.memory.ui.settings.AiVolumeShortcutGuideDialogActivity;
import com.obric.memorydata.memory.ui.settings.ShortcutMemoryConsentType;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.UserStateManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.MemoryManagerWrapper$registerMemoryAction$1$onAction$4", f = "MemoryManagerWrapper.kt", i = {1}, l = {278, 315, 348}, m = "invokeSuspend", n = {"pendingConsentType"}, s = {"L$0"})
final class MemoryManagerWrapper$registerMemoryAction$1$onAction$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundleSnapshot;
    final /* synthetic */ long $epoch;
    final /* synthetic */ int $from;
    final /* synthetic */ com.obric.memorydata.middleware.api.logging.e $logContext;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.MemoryManagerWrapper$registerMemoryAction$1$onAction$4$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.MemoryManagerWrapper$registerMemoryAction$1$onAction$4$3", f = "MemoryManagerWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        private static final Unit invokeSuspend$lambda$0(boolean r0) {
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: lambda$j66kOh-unyAGX214F76Yhu_QCMw, reason: not valid java name */
        public static /* synthetic */ Unit m688lambda$j66kOhunyAGX214F76Yhu_QCMw(boolean r0) {
            return invokeSuspend$lambda$0(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            UserStateManager.INSTANCE.requestAgreePrivacyAndLogin((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$onAction$4$3$j66kOhunyAGX214F76Yhu_QCMw.INSTANCE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.MemoryManagerWrapper$registerMemoryAction$1$onAction$4$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.MemoryManagerWrapper$registerMemoryAction$1$onAction$4$6", f = "MemoryManagerWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ShortcutMemoryConsentType $pendingConsentType;
        int label;

        AnonymousClass6(ShortcutMemoryConsentType r3, Continuation<? super AnonymousClass6> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$pendingConsentType = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this.$pendingConsentType, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass6) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass6.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            AiVolumeShortcutGuideDialogActivity.f11400a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.$pendingConsentType);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    MemoryManagerWrapper$registerMemoryAction$1$onAction$4(int r3, com.obric.memorydata.middleware.api.logging.e r4, Bundle r5, long r6, Continuation<? super MemoryManagerWrapper$registerMemoryAction$1$onAction$4> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$from = r3;
        this.$logContext = r4;
        this.$bundleSnapshot = r5;
        this.$epoch = r6;
        super(1, r9);
    }

    private static final Unit invokeSuspend$lambda$0(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        r2.a("from", Integer.valueOf(r1));
        r2.a(InfoRequestQPSOptTraceLogger.REASON, "screen_locked");
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$1(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        r2.a("from", Integer.valueOf(r1));
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$2(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        r2.a("from", Integer.valueOf(r1));
        r2.a(InfoRequestQPSOptTraceLogger.REASON, "shortcut_consent_pending");
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$3(int r1, ShortcutMemoryConsentType r2, com.obric.memorydata.middleware.api.logging.g r3) {
        r3.a("from", Integer.valueOf(r1));
        r3.a("consent_type", r2.name());
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$4(int r1, Throwable r2, com.obric.memorydata.middleware.api.logging.g r3) {
        r3.a("from", Integer.valueOf(r1));
        r3.a(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r2.getClass().getSimpleName());
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$5(int r1, com.obric.memorydata.middleware.api.logging.g r2) {
        r2.a("from", Integer.valueOf(r1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$-uiYJxKoH4bHsp5_L9sC8W-leJI, reason: not valid java name */
    public static /* synthetic */ Unit m686lambda$uiYJxKoH4bHsp5_L9sC8WleJI(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return invokeSuspend$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit lambda$N15lDxaU3JtovIPqztyFlHJk5oY(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return invokeSuspend$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit lambda$SGaljg2e0XnapsIOAfzMm3VvD8c(int r0, ShortcutMemoryConsentType r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return invokeSuspend$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$n7NGSTDVDp7_PpCjNXEsep8iNlc(int r0, Throwable r1, com.obric.memorydata.middleware.api.logging.g r2) {
        return invokeSuspend$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$pnv1e_brqZvs0RCuRojw7qrP4U0(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return invokeSuspend$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$xG5ziNtSNt8AWStDBFqdMex-eno, reason: not valid java name */
    public static /* synthetic */ Unit m687lambda$xG5ziNtSNt8AWStDBFqdMexeno(int r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return invokeSuspend$lambda$1(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$registerMemoryAction$1$onAction$4(this.$from, this.$logContext, this.$bundleSnapshot, this.$epoch, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r3) {
        return ((MemoryManagerWrapper$registerMemoryAction$1$onAction$4) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), MemoryManagerWrapper$registerMemoryAction$1$onAction$4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ShortcutMemoryConsentType r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r18);
        Object r3 = r18;
    L54:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L57;
        v.a(v.f11572a, this.$epoch, "confirmLaunched:from=" + this.$from);
    L57:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ShortcutMemoryConsentType r4 = (ShortcutMemoryConsentType) ZeusTransformUtils.preCheckCast(this.L$0, ShortcutMemoryConsentType.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L13
        r2 = r4;
    L44:
        v.a(v.f11572a, this.$epoch, "guideLaunched:from=" + this.$from);     // Catch: Throwable -> L13
        goto L57
    L15:
        ResultKt.throwOnFailure(r18);
    L28:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r18);
        if (v.a(v.f11572a, this.$from) == false) goto L23;
        com.obric.memorydata.middleware.api.logging.o r1 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r5 = this.$logContext;
        final int r6 = this.$from;
        Function1 r7 = new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$onAction$4$pnv1e_brqZvs0RCuRojw7qrP4U0(r6);
        Function1 r8 = null;
        int r9 = 16;
        Object r10 = null;
        String r11 = "系统主动记忆因锁屏而跳过";
    L19:
        com.obric.memorydata.middleware.api.logging.o.a(r1, r11, "operation_skipped", r5, r7, r8, r9, r10);
    L21:
        return Unit.INSTANCE;
    L23:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L29;
        com.obric.memorydata.middleware.api.logging.o r12 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r13 = this.$logContext;
        final int r14 = this.$from;
        com.obric.memorydata.middleware.api.logging.o.a(r12, "系统主动记忆因隐私或登录状态不可用而终止", "build_blocked", "privacy_or_login_unavailable", null, r13, new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$onAction$4$xG5ziNtSNt8AWStDBFqdMexeno(r14), 8, null);
        CoroutineContext r15 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r16 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (kotlinx.coroutines.i.a(r15, r16, r17) != r0) goto L28;
        return r0;
    L29:
        com.obric.memorydata.memory.ui.settings.u r19 = v.b(v.f11572a, this.$from);
        if (r19 != com.obric.memorydata.memory.ui.settings.u.a.f11508a) goto L33;
        r1 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        r5 = this.$logContext;
        final int r20 = this.$from;
        r7 = new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$onAction$4$N15lDxaU3JtovIPqztyFlHJk5oY(r20);
        r8 = null;
        r9 = 16;
        r10 = null;
        r11 = "系统主动记忆因已有授权请求而丢弃";
        goto L19
    L33:
        if (ZeusTransformUtils.instanceOf(r19, com.obric.memorydata.memory.ui.settings.u.c.class) == false) goto L35;
        com.obric.memorydata.memory.ui.settings.u.c r21 = (com.obric.memorydata.memory.ui.settings.u.c) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.memory.ui.settings.u.c.class, "com.obric.memorydata.plugin");
    L36:
        if (r21 == null) goto L38;
        final ShortcutMemoryConsentType r22 = r21.a();
    L39:
        if (r22 == null) goto L47;
        com.obric.memorydata.middleware.api.logging.o r23 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r110 = this.$logContext;
        final int r24 = this.$from;
        com.obric.memorydata.middleware.api.logging.o.a(r23, "系统主动记忆需要展示快捷记忆授权", "shortcut_consent_required", r110, new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$onAction$4$SGaljg2e0XnapsIOAfzMm3VvD8c(r24, r22), null, 16, null);
        v.a(v.f11572a, r22, this.$from, this.$bundleSnapshot, this.$logContext.c());
        CoroutineContext r25 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Function2 r26 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(r22, null), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Continuation r27 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        this.L$0 = r22;     // Catch: Throwable -> L13
        this.label = 2;     // Catch: Throwable -> L13
        r2 = r22;
        if (kotlinx.coroutines.i.a(r25, r26, r27) != r0) goto L44;
        return r0;
    L47:
        v.a(v.f11572a, this.$from, this.$bundleSnapshot, false);
        if (v.a(v.f11572a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.$from, this.$bundleSnapshot) == true) goto L50;
        v.a(v.f11572a, this.$bundleSnapshot, this.$from, false, null, this.$logContext, 12, null);
        goto L21
    L50:
        com.obric.memorydata.middleware.api.logging.o r28 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r111 = this.$logContext;
        final int r29 = this.$from;
        com.obric.memorydata.middleware.api.logging.o.a(r28, "系统主动记忆等待用户确认", "confirmation_required", r111, new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$onAction$4$uiYJxKoH4bHsp5_L9sC8WleJI(r29), null, 16, null);
        CoroutineContext r30 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r31 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryManagerWrapper$registerMemoryAction$1$onAction$4$launched$1(this.$bundleSnapshot, this.$from, this.$logContext, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r32 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 3;
        r3 = kotlinx.coroutines.i.a(r30, r31, r32);
        if (r3 != r0) goto L54;
        return r0;
    L38:
        r22 = null;
        goto L39
    L35:
        r21 = null;
    L13:
        th = move-exception;
        com.obric.memorydata.middleware.api.logging.o r33 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.a.f11610a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r34 = this.$logContext;
        final int r35 = this.$from;
        com.obric.memorydata.middleware.api.logging.o.a(r33, "系统主动记忆快捷键引导启动失败", "guide_launch_failed", "guide_launch_failed", null, r34, new $$Lambda$MemoryManagerWrapper$registerMemoryAction$1$onAction$4$n7NGSTDVDp7_PpCjNXEsep8iNlc(r35, th), 8, null);
        v.a(v.f11572a, r2);
        goto L57
    }
}
