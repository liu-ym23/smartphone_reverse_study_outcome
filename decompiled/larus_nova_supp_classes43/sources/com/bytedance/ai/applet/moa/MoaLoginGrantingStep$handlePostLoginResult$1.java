package com.bytedance.ai.applet.moa;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep$handlePostLoginResult$1", f = "MoaLoginGrantingStep.kt", i = {0}, l = {307}, m = "invokeSuspend", n = {"appletId"}, s = {"L$0"})
final class MoaLoginGrantingStep$handlePostLoginResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ Function1<Result<Unit>, Unit> $completion;
    Object L$0;
    int label;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public MoaLoginGrantingStep$handlePostLoginResult$1(MoaLoginGrantingStep r1, String r10, Function1<? super Result<Unit>, Unit> r11, Continuation<? super MoaLoginGrantingStep$handlePostLoginResult$1> r12) {
        this.this$0 = r1;
        this.$code = r10;
        this.$completion = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaLoginGrantingStep$handlePostLoginResult$1(this.this$0, this.$code, this.$completion, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r10 = (String) this.L$0;
        ResultKt.throwOnFailure(r12);
        Object r13 = ((Result) r12).unbox-impl();
    L28:
        MoaLoginGrantingStep r11 = this.this$0;
        if (r11.f == MoaLoginGrantingStep.State.EXCHANGING_CODE) goto L31;
    L48:
        Function1<Result<Unit>, Unit> r14 = this.$completion;
        Result.Companion r15 = Result.Companion;
        r14.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(MoaLoginGrantingStep.l()))));
        return Unit.INSTANCE;
    L31:
        if (r11.h == null) goto L48;
        Function1<Result<Unit>, Unit> r16 = this.$completion;
        Throwable r17 = Result.exceptionOrNull-impl(r13);
        if (r17 != null) goto L45;
        ((Boolean) r13).booleanValue();
        r16.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        if (r11.i == false) goto L44;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r18 = AppletAppManagerService.a(r10);
        if (r18 == null) goto L40;
        AppletAppActivity r19 = r18.d;
    L41:
        if (r19 != null) goto L43;
        com.bytedance.ai.utils.g.a.w("MoaLoginGrantingStep", "Unable to return to chat: app activity is unavailable");
        goto L44
    L43:
        int r20 = AppletAppActivity.j;
        r19.P1(null);
        goto L44
    L40:
        r19 = null;
    L44:
        r11.k(MoaStepResult.CONTINUE);
    L47:
        return Unit.INSTANCE;
    L45:
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to exchange MOA login code", r17);
        r16.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r17))));
        r11.k(MoaStepResult.FAILED);
        goto L47
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        MoaLoginGrantingStep r110 = this.this$0;
        int r21 = MoaLoginGrantingStep.m;
        r110.q();
        o r111 = this.this$0.g;
        if (r111 == null) goto L11;
        u2.e r112 = r111.a;
    L12:
        if (r112 == null) goto L14;
        String r22 = r112.d();
    L16:
        if (r22 != null) goto L18;
        r22 = "";
    L18:
        if (r112 == null) goto L20;
        String r113 = r112.g();
    L21:
        if (r113 != null) goto L23;
        String r23 = "";
    L24:
        UserAuthService r114 = UserAuthService.a;
        String r24 = this.$code;
        this.L$0 = r22;
        this.label = 1;
        r13 = UserAuthService.a.f(r22, r24, r23, null, this);
        if (r13 != r0) goto L27;
        return r0;
    L27:
        r10 = r22;
        goto L28
    L23:
        r23 = r113;
        goto L24
    L20:
        r113 = null;
        goto L21
    L14:
        r22 = null;
        goto L16
    L11:
        r112 = null;
        goto L12
    }
}
