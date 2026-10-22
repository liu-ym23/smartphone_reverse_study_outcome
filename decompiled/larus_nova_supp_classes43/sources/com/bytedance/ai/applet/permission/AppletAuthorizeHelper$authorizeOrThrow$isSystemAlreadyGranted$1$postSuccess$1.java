package com.bytedance.ai.applet.permission;

import com.bytedance.ai.applet.granting.GrantingAction;
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
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1", f = "AppletAuthorizeHelper.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
public final class AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $scopeName;
    final /* synthetic */ GrantingAction $userAction;
    int label;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1(AppletAuthorizeHelper r1, String r10, GrantingAction r11, Continuation<? super AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1> r12) {
        this.this$0 = r1;
        this.$scopeName = r10;
        this.$userAction = r11;
        super(1, r12);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$postSuccess$1(this.this$0, this.$scopeName, this.$userAction, r10);
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
        AppletAuthorizeHelper r11 = this.this$0;
        String r12 = this.$scopeName;
        GrantingAction r13 = this.$userAction;
        this.label = 1;
        r10 = AppletAuthorizeHelper.b(r11, r12, r13, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
