package com.bytedance.ai.applet.moa;

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
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep$handleGetPhoneNumber$1", f = "MoaLoginGrantingStep.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
final class MoaLoginGrantingStep$handleGetPhoneNumber$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Result<String>, Unit> $completion;
    int label;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public MoaLoginGrantingStep$handleGetPhoneNumber$1(MoaLoginGrantingStep r1, Function1<? super Result<String>, Unit> r10, Continuation<? super MoaLoginGrantingStep$handleGetPhoneNumber$1> r11) {
        this.this$0 = r1;
        this.$completion = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaLoginGrantingStep$handleGetPhoneNumber$1(this.this$0, this.$completion, r11);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L19:
        MoaLoginGrantingStep r12 = this.this$0;
        if (r12.f == MoaLoginGrantingStep.State.WAITING_LOGIN) goto L22;
    L30:
        Function1<Result<String>, Unit> r13 = this.$completion;
        Result.Companion r14 = Result.Companion;
        r13.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(MoaLoginGrantingStep.l()))));
        return Unit.INSTANCE;
    L22:
        if (r12.h == null) goto L30;
        Function1<Result<String>, Unit> r15 = this.$completion;
        Throwable r16 = Result.exceptionOrNull-impl(r11);
        if (r16 != null) goto L27;
        r15.invoke(Result.box-impl(Result.constructor-impl((String) r11)));
    L29:
        return Unit.INSTANCE;
    L27:
        com.bytedance.ai.utils.g.a.e("MoaLoginGrantingStep", "Failed to fetch MOA phone code", r16);
        r15.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r16))));
        goto L29
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        o r17 = this.this$0.g;
        if (r17 == null) goto L13;
        u2.e r18 = r17.a;
        if (r18 == null) goto L13;
        String r19 = r18.d();
    L14:
        if (r19 != null) goto L16;
        r19 = "";
    L16:
        UserAuthService r20 = UserAuthService.a;
        this.label = 1;
        r11 = r20.m(r19, this);
        if (r11 != r0) goto L19;
        return r0;
    L13:
        r19 = null;
        goto L14
    }
}
