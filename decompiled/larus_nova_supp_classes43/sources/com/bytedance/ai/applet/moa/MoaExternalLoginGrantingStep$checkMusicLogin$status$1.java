package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaExternalLoginGrantingStep$checkMusicLogin$status$1", f = "MoaExternalLoginGrantingStep.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
public final class MoaExternalLoginGrantingStep$checkMusicLogin$status$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean>>, Object> {
    final /* synthetic */ g2.b $aiAbility;
    Object L$0;
    int label;

    public static final class a implements Function2<Boolean, String, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<Result<Boolean>> a;

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10, Object r11) {
            boolean r12 = ((Boolean) r10).booleanValue();
            String r13 = (String) r11;
            if (this.a.isActive() == false) goto L11;
            kotlinx.coroutines.i<Result<Boolean>> r0 = this.a;
            if (r13 != null) goto L8;
            Result.Companion r14 = Result.Companion;
            Object r15 = Result.constructor-impl(Boolean.valueOf(r12));
        L9:
            r0.resumeWith(Result.constructor-impl(Result.box-impl(r15)));
            goto L11
        L8:
            Result.Companion r16 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r13)));
        L11:
            return Unit.INSTANCE;
        }
    }

    public MoaExternalLoginGrantingStep$checkMusicLogin$status$1(g2.b r1, Continuation<? super MoaExternalLoginGrantingStep$checkMusicLogin$status$1> r10) {
        this.$aiAbility = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaExternalLoginGrantingStep$checkMusicLogin$status$1(this.$aiAbility, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<Boolean>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        g2.b r11 = (g2.b) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        g2.b r12 = this.$aiAbility;
        this.L$0 = r12;
        this.label = 1;
        kotlinx.coroutines.j r13 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r13.C();
        r12.c(new a(r13));
        r10 = r13.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r10 != r0) goto L13;
        return r0;
    }
}
