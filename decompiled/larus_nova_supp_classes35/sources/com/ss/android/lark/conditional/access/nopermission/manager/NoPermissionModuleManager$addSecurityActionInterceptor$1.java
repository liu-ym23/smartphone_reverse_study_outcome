package com.ss.android.lark.conditional.access.nopermission.manager;

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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager$addSecurityActionInterceptor$1", f = "NoPermissionModuleManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NoPermissionModuleManager$addSecurityActionInterceptor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n4c.a $interceptor;
    int label;
    final /* synthetic */ NoPermissionModuleManager this$0;

    public NoPermissionModuleManager$addSecurityActionInterceptor$1(n4c.a r1, NoPermissionModuleManager r2, Continuation<? super NoPermissionModuleManager$addSecurityActionInterceptor$1> r3) {
        this.$interceptor = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NoPermissionModuleManager$addSecurityActionInterceptor$1(this.$interceptor, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        int r4 = ScsLogger.a;
        StringBuilder r5 = new StringBuilder("addSecurityActionInterceptor, biz: ");
        n4c.a r0 = this.$interceptor;
        if (r0 == null) goto L7;
        String r1 = r0.getBizName();
    L8:
        r5.append(r1);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r5.toString());
        n4c.a r6 = this.$interceptor;
        if (r6 == null) goto L12;
        this.this$0.m.put(r6.getBizName(), r6);
    L12:
        return Unit.INSTANCE;
    L7:
        r1 = null;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
