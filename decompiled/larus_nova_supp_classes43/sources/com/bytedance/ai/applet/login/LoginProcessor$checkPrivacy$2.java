package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor$checkPrivacy$2", f = "LoginProcessor.kt", i = {}, l = {765}, m = "invokeSuspend", n = {}, s = {})
final class LoginProcessor$checkPrivacy$2 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<Continuation<? super Boolean>, Object> $request;
    int label;

    public LoginProcessor$checkPrivacy$2(Function1<? super Continuation<? super Boolean>, ? extends Object> r1, Continuation<? super LoginProcessor$checkPrivacy$2> r10) {
        this.$request = r1;
        super(1, r10);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new LoginProcessor$checkPrivacy$2(this.$request, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Boolean> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Function1<Continuation<? super Boolean>, Object> r11 = this.$request;
        this.label = 1;
        r10 = r11.invoke(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
