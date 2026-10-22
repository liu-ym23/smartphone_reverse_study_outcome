package com.larus.bmhome.instruction;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observerInstructionEditor$12", f = "InstructionInputComponent.kt", i = {}, l = {1726}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observerInstructionEditor$12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionInputComponent a;

        public a(InstructionInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            boolean r7 = ((Boolean) r5).booleanValue();
            InstructionInputComponent r8 = this.a;
            String r0 = InstructionInputComponent.Z2;
            InstructionEditorViewModel r9 = r8.a4();
            if (r9 == null) goto L5;
            r9.markInputSendReadyState(r7);
        L5:
            com.larus.bmhome.chat.component.bottom.attachment.g1 r10 = this.a.f70();
            if (r10 != null) goto L8;
        L10:
            boolean r11 = false;
        L11:
            if (r11 == false) goto L13;
            InstructionInputComponent.Y2(this.a, r7);
        L13:
            ICoreInputAbility r12 = this.a.G3();
            if (r12 == null) goto L49;
            InstructionInputComponent r2 = this.a;
            if (r7 == true) goto L18;
            if (r7 == true) goto L47;
            va8.o r13 = r2.D3();
            if (r13 == null) goto L25;
            String r14 = r13.u7();
        L26:
            if (r14 != null) goto L29;
            r14 = "";
        L29:
            if (StringsKt.isBlank(r14) == false) goto L45;
            com.larus.bmhome.chat.component.bottom.attachment.g1 r15 = r2.f70();
            if (r15 != null) goto L33;
        L35:
            boolean r16 = false;
        L36:
            if (r16 == false) goto L42;
            ICoreInputAbility r17 = r2.G3();
            if (r17 == null) goto L40;
            r2.R4(r17.Rp());
        L40:
            InstructionInputComponent.Y2(r2, false);
            goto L49
        L42:
            if (r12.Rp() == 2) goto L50;
            r2.R4(1);
            goto L49
        L50:
            return Unit.INSTANCE;
        L33:
            if (r15.iJ() != true) goto L35;
            r16 = true;
            goto L36
        L45:
            InstructionInputComponent.Y2(r2, true);
            goto L49
        L25:
            r14 = null;
            goto L26
        L47:
            throw new NoWhenBranchMatchedException();
        L18:
            if (r12.Rp() != 2) goto L20;
            r2.R4(2);
            goto L49
        L20:
            r2.R4(3);
        L49:
            return Unit.INSTANCE;
        L8:
            if (r10.iJ() != true) goto L10;
            r11 = true;
            goto L11
        }
    }

    public InstructionInputComponent$observerInstructionEditor$12(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$observerInstructionEditor$12> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputComponent$observerInstructionEditor$12(this.this$0, r3);
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
        kotlinx.coroutines.flow.d1<Boolean> r8 = r7.getActionBarInstructionInputSendReady();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
