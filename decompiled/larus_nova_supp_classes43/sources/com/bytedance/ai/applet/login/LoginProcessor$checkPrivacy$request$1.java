package com.bytedance.ai.applet.login;

import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.LoginProcessor$checkPrivacy$request$1", f = "LoginProcessor.kt", i = {}, l = {759}, m = "invokeSuspend", n = {}, s = {})
final class LoginProcessor$checkPrivacy$request$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ String $versionTag;
    int label;

    public LoginProcessor$checkPrivacy$request$1(String r1, String r10, Continuation<? super LoginProcessor$checkPrivacy$request$1> r11) {
        this.$appletId = r1;
        this.$versionTag = r10;
        super(1, r11);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new LoginProcessor$checkPrivacy$request$1(this.$appletId, this.$versionTag, r10);
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
        Object r11 = ((Result) r10).unbox-impl();
    L12:
        if (Result.isFailure-impl(r11) == false) goto L14;
        Object r12 = null;
    L15:
        Boolean r13 = (Boolean) r12;
        if (r13 != null) goto L18;
        Throwable r14 = Result.exceptionOrNull-impl(r11);
        if (r14 == null) goto L22;
        throw r14;
    L22:
        throw new Exception("check result is null, but no error message");
    L18:
        return Boxing.boxBoolean(r13.booleanValue());
    L14:
        r12 = r11;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r15 = UserAuthService.a;
        String r16 = this.$appletId;
        String r17 = this.$versionTag;
        this.label = 1;
        r11 = r15.d(r16, r17, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
