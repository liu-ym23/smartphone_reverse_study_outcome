package com.bytedance.ai.applet.moa;

import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep$handlePrivacyAgreement$1", f = "MoaLoginGrantingStep.kt", i = {}, l = {154, 164}, m = "invokeSuspend", n = {}, s = {})
final class MoaLoginGrantingStep$handlePrivacyAgreement$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Result<Unit>, Unit> $completion;
    int label;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MoaLoginGrantingStep.Type.values().length];
            r0[MoaLoginGrantingStep.Type.PRIVACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MoaLoginGrantingStep.Type.LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public MoaLoginGrantingStep$handlePrivacyAgreement$1(MoaLoginGrantingStep r1, Function1<? super Result<Unit>, Unit> r10, Continuation<? super MoaLoginGrantingStep$handlePrivacyAgreement$1> r11) {
        this.this$0 = r1;
        this.$completion = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaLoginGrantingStep$handlePrivacyAgreement$1(this.this$0, this.$completion, r11);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L39:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L21:
        MoaLoginGrantingStep r12 = this.this$0;
        if (r12.f == MoaLoginGrantingStep.State.ACCEPTING_PRIVACY) goto L24;
    L40:
        Function1<Result<Unit>, Unit> r13 = this.$completion;
        Result.Companion r14 = Result.Companion;
        r13.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(MoaLoginGrantingStep.l()))));
        return Unit.INSTANCE;
    L24:
        if (r12.h == null) goto L40;
        Function1<Result<Unit>, Unit> r15 = this.$completion;
        MoaLoginGrantingStep r16 = this.this$0;
        Throwable r17 = Result.exceptionOrNull-impl(r11);
        if (r17 != null) goto L37;
        ((Boolean) r11).booleanValue();
        r15.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        int r18 = a.a[r16.c.ordinal()];
        if (r18 == 1) goto L36;
        if (r18 != 2) goto L35;
        this.label = 2;
        if (r16.n(this) != r0) goto L39;
        return r0;
    L35:
        throw new NoWhenBranchMatchedException();
    L36:
        r16.k(MoaStepResult.CONTINUE);
        goto L39
    L37:
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to accept MOA privacy authorization", r17);
        r15.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r17))));
        r16.k(MoaStepResult.FAILED);
        goto L39
    L10:
        ResultKt.throwOnFailure(r10);
        o r19 = this.this$0.g;
        if (r19 == null) goto L15;
        u2.e r20 = r19.a;
        if (r20 == null) goto L15;
        String r21 = r20.d();
    L16:
        if (r21 != null) goto L18;
        r21 = "";
    L18:
        UserAuthService r22 = UserAuthService.a;
        this.label = 1;
        r11 = r22.a(r21, null, this);
        if (r11 != r0) goto L21;
        return r0;
    L15:
        r21 = null;
        goto L16
    }
}
