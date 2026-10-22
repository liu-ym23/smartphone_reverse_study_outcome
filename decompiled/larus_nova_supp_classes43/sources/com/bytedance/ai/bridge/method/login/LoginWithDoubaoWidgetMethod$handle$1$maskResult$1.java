package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.login.LoginWithDoubaoWidgetMethod$handle$1$maskResult$1", f = "LoginWithDoubaoWidgetMethod.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
public final class LoginWithDoubaoWidgetMethod$handle$1$maskResult$1 extends SuspendLambda implements Function1<Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ String $versionTag;
    int label;

    public LoginWithDoubaoWidgetMethod$handle$1$maskResult$1(String r1, Continuation<? super LoginWithDoubaoWidgetMethod$handle$1$maskResult$1> r10) {
        this.$versionTag = r1;
        super(1, r10);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new LoginWithDoubaoWidgetMethod$handle$1$maskResult$1(this.$versionTag, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Result<String>> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L12:
        return Result.box-impl(r11);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r12 = UserAuthService.a;
        String r13 = this.$versionTag;
        this.label = 1;
        r11 = r12.n(r13, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
