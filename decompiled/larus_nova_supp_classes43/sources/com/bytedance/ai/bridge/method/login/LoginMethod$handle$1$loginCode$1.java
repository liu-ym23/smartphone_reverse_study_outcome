package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.login.AbsLoginMethodIDL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginMethod$handle$1$loginCode$1", f = "LoginMethod.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
public final class LoginMethod$handle$1$loginCode$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ AbsLoginMethodIDL.a $params;
    int label;
    final /* synthetic */ LoginMethod this$0;

    public LoginMethod$handle$1$loginCode$1(LoginMethod r1, String r10, AbsLoginMethodIDL.a r11, Continuation<? super LoginMethod$handle$1$loginCode$1> r12) {
        this.this$0 = r1;
        this.$appletId = r10;
        this.$params = r11;
        super(1, r12);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new LoginMethod$handle$1$loginCode$1(this.this$0, this.$appletId, this.$params, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        LoginMethod r11 = this.this$0;
        String r12 = this.$appletId;
        Integer r13 = this.$params.getTimeout();
        if (r13 == null) goto L11;
        Duration.Companion r14 = Duration.Companion;
        Duration r15 = Duration.box-impl(DurationKt.toDuration(r13.intValue(), DurationUnit.MILLISECONDS));
    L12:
        this.label = 1;
        r10 = LoginMethod.b(r11, r12, r15, this);
        if (r10 != r0) goto L15;
        return r0;
    L11:
        r15 = null;
        goto L12
    }
}
