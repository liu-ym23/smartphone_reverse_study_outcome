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
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor$handleDialogAgree$1", f = "LoginProcessor.kt", i = {}, l = {581}, m = "invokeSuspend", n = {}, s = {})
final class LoginProcessor$handleDialogAgree$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    int label;

    public LoginProcessor$handleDialogAgree$1(String r1, Continuation<? super LoginProcessor$handleDialogAgree$1> r10) {
        this.$appletId = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LoginProcessor$handleDialogAgree$1(this.$appletId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L13
    L17:
    L16:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        LoginProcessor r11 = LoginProcessor.a;     // Catch: Exception -> L13
        String r12 = this.$appletId;     // Catch: Exception -> L13
        this.label = 1;     // Catch: Exception -> L13
        if (LoginProcessor.b(r11, r12, this) != r0) goto L17;
        return r0;
    L13:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("LoginProcessor", "handleDialogAgree routeToLoginEntry failed for " + this.$appletId, e);
        LoginProcessor r13 = LoginProcessor.a;
        String r14 = this.$appletId;
        h.a r15 = new h.a(LocalFinishReason.BIZ_FAILED);
        r13.getClass();
        LoginProcessor.l(r14, r15);
        goto L16
    }
}
