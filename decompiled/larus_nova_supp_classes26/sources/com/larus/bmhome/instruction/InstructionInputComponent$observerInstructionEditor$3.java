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
@DebugMetadata(c = "com.larus.bmhome.instruction.InstructionInputComponent$observerInstructionEditor$3", f = "InstructionInputComponent.kt", i = {}, l = {1647}, m = "invokeSuspend", n = {}, s = {})
final class InstructionInputComponent$observerInstructionEditor$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionInputComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionInputComponent a;

        public a(InstructionInputComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r23, Continuation r24) {
            String r1 = (String) r23;
            FLogger r0 = FLogger.a;
            r0.d("InstructionInputComponent", "instructionSelectedForPrompt = " + r1);
            InstructionInputComponent r7 = this.a;
            String r2 = InstructionInputComponent.Z2;
            r7.getClass();
            r0.d("InstructionInputComponent", "onFeatureOptionUnSelected, onFeatureOptionUnSelected = " + r1);
            ICoreInputAbility r8 = r7.G3();
            if (r8 == null) goto L27;
            va8.o r3 = r7.D3();
            if (r3 == null) goto L7;
            String r4 = r3.u7();
        L8:
            if (r4 != null) goto L10;
            r4 = "";
        L10:
            String r10 = r4;
            if (StringsKt.contains$default(r10, ", " + r1, false, 2, null) == false) goto L13;
            String r5 = StringsKt.replace$default(r10, ", " + r1, "", false, 4, null);
            int r11 = 2;
            boolean r15 = false;
        L15:
            if (StringsKt.startsWith$default(r5, ", ", r15, r11, null) == false) goto L17;
            r5 = StringsKt.replaceFirst$default(r5, ", ", "", false, 4, null);
        L17:
            ICoreInputAbility.b.d(r8, r5, false, false, null, null, false, 60);
            va8.o r6 = r7.D3();
            if (r6 == null) goto L27;
            va8.o r9 = r7.D3();
            if (r9 == null) goto L24;
            String r12 = r9.u7();
            if (r12 == null) goto L24;
            int r13 = r12.length();
        L25:
            r6.v3(r13);
        L24:
            r13 = 0;
            goto L25
        L13:
            r11 = 2;
            r15 = false;
            r5 = StringsKt.replace$default(r10, r1, "", false, 4, null);
            goto L15
        L7:
            r4 = null;
        L27:
            return Unit.INSTANCE;
        }
    }

    public InstructionInputComponent$observerInstructionEditor$3(InstructionInputComponent r1, Continuation<? super InstructionInputComponent$observerInstructionEditor$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionInputComponent$observerInstructionEditor$3(this.this$0, r3);
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
        kotlinx.coroutines.flow.d1<String> r8 = r7.getInstructionFeatureUnSelectedForPrompt();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
