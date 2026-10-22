package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager$handleNoPermissionAction$1", f = "NoPermissionModuleManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NoPermissionModuleManager$handleNoPermissionAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NoPermissionModuleManager this$0;

    public NoPermissionModuleManager$handleNoPermissionAction$1(NoPermissionModuleManager r1, Continuation<? super NoPermissionModuleManager$handleNoPermissionAction$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new NoPermissionModuleManager$handleNoPermissionAction$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r6);
        NoPermissionModuleManager r7 = this.this$0;
        String r2 = r7.f;
        String r3 = qqb.a.d();     // Catch: Throwable -> L17
        qqb.a.f(r2);     // Catch: Throwable -> L15
        int r4 = ScsLogger.a;     // Catch: Throwable -> L15
        StringBuilder r5 = new StringBuilder("handleNoPermissionAction, type: ");     // Catch: Throwable -> L15
        NoPermissionType r1 = r7.d.get();     // Catch: Throwable -> L15
        if (r1 == null) goto L9;
        String r8 = r1.name();     // Catch: Throwable -> L15
    L10:
        r5.append(r8);     // Catch: Throwable -> L15
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r5.toString());     // Catch: Throwable -> L15
        if (r7.d.get() == null) goto L13;
        r7.j = NoPermissionModuleManager.c(r7);     // Catch: Throwable -> L15
        NoPermissionModuleManager.b(r7);     // Catch: Throwable -> L15
    L13:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r3, "traceId");
        qqb.a.g(r3);
        return Unit.INSTANCE;
    L9:
        r8 = null;
    L15:
        th = th;
    L19:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r3, "traceId");
        qqb.a.g(r3);
        throw th;
    L17:
        th = th;
        r3 = BuildConfig.FLAVOR;
        goto L19
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
