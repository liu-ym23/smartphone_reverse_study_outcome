package com.bytedance.ai.applet.permission;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$systemPermissionGranted$1", f = "AppletAuthorizeHelper.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
public final class AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$systemPermissionGranted$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $nativeScopeName;
    int label;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$systemPermissionGranted$1(AppletAuthorizeHelper r1, String r10, Continuation<? super AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$systemPermissionGranted$1> r11) {
        this.this$0 = r1;
        this.$nativeScopeName = r10;
        super(1, r11);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AppletAuthorizeHelper$authorizeOrThrow$isSystemAlreadyGranted$1$systemPermissionGranted$1(this.this$0, this.$nativeScopeName, r10);
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
    L17:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletAuthorizeHelper r11 = this.this$0;
        String r12 = this.$nativeScopeName;
        this.label = 1;
        Lazy<Keva> r13 = AppletAuthorizeHelper.d;
        r11.getClass();
        ((Keva) AppletAuthorizeHelper.d.getValue()).storeBoolean("requested_" + r12, true);
        j r14 = new j(IntrinsicsKt.intercepted(this), 1);
        r14.C();
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L11;
        r15.y(null, r12, new d(r14));
    L12:
        r10 = r14.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        if (r10 != r0) goto L17;
        return r0;
    L11:
        Result.Companion r16 = Result.Companion;
        r14.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        goto L12
    }
}
