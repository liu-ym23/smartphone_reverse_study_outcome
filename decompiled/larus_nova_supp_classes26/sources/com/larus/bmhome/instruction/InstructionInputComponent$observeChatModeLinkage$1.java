package com.larus.bmhome.instruction;

import com.larus.bmhome.auth.ConversationMode;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observeChatModeLinkage$1", f = "InstructionInputComponent.kt", i = {}, l = {936}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observeChatModeLinkage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.chat.mode.e $modeAbility;
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionInputComponent a;

        public a(InstructionInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            ConversationMode r5 = (ConversationMode) r3;
            if (r5 == null) goto L5;
            String r6 = r5.a();
        L6:
            InstructionInputComponent r0 = this.a;
            String r1 = r0.M2;
            if (r1 == null) goto L11;
            r0.M2 = null;
            if (Intrinsics.areEqual(r1, r6) == false) goto L11;
            FLogger.a.i("InstructionInputComponent", "[ChatModeLinkage] skip ActionBar-driven mode change, modeKey=" + r6);
            return Unit.INSTANCE;
        L11:
            this.a.nB(r6);
            return Unit.INSTANCE;
        L5:
            r6 = null;
            goto L6
        }
    }

    public InstructionInputComponent$observeChatModeLinkage$1(com.larus.bmhome.chat.mode.e r1, InstructionInputComponent r2, Continuation<? super InstructionInputComponent$observeChatModeLinkage$1> r3) {
        this.$modeAbility = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InstructionInputComponent$observeChatModeLinkage$1(this.$modeAbility, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.i1 r6 = this.$modeAbility.Si();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
