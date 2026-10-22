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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observerInstructionEditor$2", f = "InstructionInputComponent.kt", i = {}, l = {1640}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observerInstructionEditor$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionInputComponent a;

        public a(InstructionInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            String r7 = (String) r5;
            FLogger r8 = FLogger.a;
            r8.d("InstructionInputComponent", "instructionSelectedForPrompt = " + r7);
            InstructionInputComponent r0 = this.a;
            String r2 = InstructionInputComponent.Z2;
            r0.getClass();
            r8.d("InstructionInputComponent", "onFeatureOptionSelected, onFeatureOptionSelected = " + r7);
            if (r0.G3() == null) goto L35;
            ICoreInputAbility r9 = r0.G3();
            int r1 = 0;
            if (r9 != null) goto L7;
        L9:
            boolean r10 = false;
        L10:
            if (r10 == true) goto L12;
            r0.R4(1);
        L12:
            va8.o r11 = r0.D3();
            if (r11 == null) goto L15;
            String r12 = r11.u7();
        L16:
            if (r12 != null) goto L19;
            r12 = "";
        L19:
            if (StringsKt.isBlank(r12) == false) goto L23;
            va8.o r13 = r0.D3();
            if (r13 == null) goto L26;
            r13.Ug(r7);
        L26:
            va8.o r14 = r0.D3();
            if (r14 == null) goto L35;
            va8.o r15 = r0.D3();
            if (r15 == null) goto L33;
            String r16 = r15.u7();
            if (r16 == null) goto L33;
            r1 = r16.length();
        L33:
            r14.v3(r1);
            goto L35
        L23:
            va8.o r17 = r0.D3();
            if (r17 == null) goto L26;
            r17.Ug(", " + r7);
            goto L26
        L15:
            r12 = null;
            goto L16
        L7:
            if (r9.Rp() != 4) goto L9;
            r10 = true;
        L35:
            return Unit.INSTANCE;
        }
    }

    public InstructionInputComponent$observerInstructionEditor$2(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$observerInstructionEditor$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputComponent$observerInstructionEditor$2(this.this$0, r3);
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
        kotlinx.coroutines.flow.d1<String> r8 = r7.getInstructionFeatureSelectedForPrompt();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
