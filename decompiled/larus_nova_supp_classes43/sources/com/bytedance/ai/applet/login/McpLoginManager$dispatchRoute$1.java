package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.McpLoginManager$dispatchRoute$1", f = "McpLoginManager.kt", i = {}, l = {461, 472}, m = "invokeSuspend", n = {}, s = {})
final class McpLoginManager$dispatchRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ b $loginContext;
    int label;

    public McpLoginManager$dispatchRoute$1(b r1, String r10, Continuation<? super McpLoginManager$dispatchRoute$1> r11) {
        this.$loginContext = r1;
        this.$appletId = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new McpLoginManager$dispatchRoute$1(this.$loginContext, this.$appletId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 != 0) goto L5;
        ResultKt.throwOnFailure(r10);
        this.$loginContext.getClass();     // Catch: Exception -> L23
        throw null;     // Catch: Exception -> L23
    L5:
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L23
        if (((Boolean) r10).booleanValue() == false) goto L18;
        p.a(p.a, this.$appletId, o.c.a);     // Catch: Exception -> L23
    L26:
        return Unit.INSTANCE;
    L18:
        p.a(p.a, this.$appletId, o.d.a);     // Catch: Exception -> L23
        goto L26
    L7:
        if (r0 != 2) goto L14;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L23
        if (((Boolean) r10).booleanValue() == false) goto L11;
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "Logic Error: loginType is 0, but user has already agreed to privacy.");     // Catch: Exception -> L23
        p.a(p.a, this.$appletId, new o.b(FinishReason.SUCCESS));     // Catch: Exception -> L23
        goto L26
    L11:
        p.a(p.a, this.$appletId, o.d.a);     // Catch: Exception -> L23
        goto L26
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("McpLoginManager", "Error during dispatchRoute checkPrivacy", e);
        p.a.getClass();
        goto L26
    }
}
