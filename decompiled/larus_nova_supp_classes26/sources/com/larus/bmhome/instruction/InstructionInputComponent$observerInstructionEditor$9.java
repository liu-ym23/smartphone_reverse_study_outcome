package com.larus.bmhome.instruction;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observerInstructionEditor$9", f = "InstructionInputComponent.kt", i = {}, l = {1692}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observerInstructionEditor$9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionInputComponent a;

        public a(InstructionInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            String r5 = (String) r3;
            FLogger.a.d("InstructionInputComponent", "inputBoxHintText = " + r5);
            if (r5 == null) goto L8;
            InstructionInputComponent r6 = this.a;
            String r0 = InstructionInputComponent.Z2;
            ICoreInputAbility r7 = r6.G3();
            if (r7 == null) goto L8;
            r7.Yk(r5);
        L8:
            return Unit.INSTANCE;
        }
    }

    public InstructionInputComponent$observerInstructionEditor$9(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$observerInstructionEditor$9> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputComponent$observerInstructionEditor$9(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        InstructionInputComponent r6 = this.this$0;
        String r2 = InstructionInputComponent.Z2;
        InstructionEditorViewModel r7 = r6.a4();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.d1<String> r8 = r7.getInputBoxHintChanged();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
