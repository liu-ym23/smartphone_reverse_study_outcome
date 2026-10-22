package com.obric.assistant.impl;

import com.larus.bmhome.instruction.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import laa.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.impl.ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1", f = "ObricSpecialInputServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $instructionInputAbility;
    final /* synthetic */ Boolean $instructionOpen;
    final /* synthetic */ Boolean $isObricSpecialInputOpen;
    final /* synthetic */ j $obricSpecialInputAbility;
    int label;

    public ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1(Boolean r1, Boolean r2, j r3, g r4, Continuation<? super ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1> r5) {
        this.$instructionOpen = r1;
        this.$isObricSpecialInputOpen = r2;
        this.$obricSpecialInputAbility = r3;
        this.$instructionInputAbility = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricSpecialInputServiceImpl$closeSpecialInputBeforeMicOn$1(this.$instructionOpen, this.$isObricSpecialInputOpen, this.$obricSpecialInputAbility, this.$instructionInputAbility, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        if (Intrinsics.areEqual(this.$instructionOpen, Boxing.boxBoolean(true)) == false) goto L11;
        if (Intrinsics.areEqual(this.$isObricSpecialInputOpen, Boxing.boxBoolean(true)) == false) goto L9;
        this.$obricSpecialInputAbility.e90();
        goto L11
    L9:
        this.$instructionInputAbility.A1();
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
