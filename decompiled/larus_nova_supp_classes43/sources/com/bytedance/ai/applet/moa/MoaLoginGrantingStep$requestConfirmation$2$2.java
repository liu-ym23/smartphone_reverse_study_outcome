package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep$requestConfirmation$2$2", f = "MoaLoginGrantingStep.kt", i = {}, l = {137, 138}, m = "invokeSuspend", n = {}, s = {})
public final class MoaLoginGrantingStep$requestConfirmation$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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

    public MoaLoginGrantingStep$requestConfirmation$2$2(MoaLoginGrantingStep r1, Continuation<? super MoaLoginGrantingStep$requestConfirmation$2$2> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MoaLoginGrantingStep$requestConfirmation$2$2(this.this$0, r11);
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
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L6;
        if (r1 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        ResultKt.throwOnFailure(r10);
    L21:
        return Unit.INSTANCE;
    L9:
        ResultKt.throwOnFailure(r10);
        MoaLoginGrantingStep.Type r11 = this.this$0.c;
        int r12 = a.a[r11.ordinal()];
        if (r12 == 1) goto L17;
        if (r12 != 2) goto L16;
        MoaLoginGrantingStep r13 = this.this$0;
        this.label = 2;
        if (MoaLoginGrantingStep.j(r13, this) != r0) goto L21;
        return r0;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        MoaLoginGrantingStep r14 = this.this$0;
        this.label = 1;
        if (r14.p(this) != r0) goto L21;
        return r0;
    }
}
