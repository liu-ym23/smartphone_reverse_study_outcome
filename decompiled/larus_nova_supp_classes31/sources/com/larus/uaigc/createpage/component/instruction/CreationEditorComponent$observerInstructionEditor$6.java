package com.larus.uaigc.createpage.component.instruction;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$6", f = "CreationEditorComponent.kt", i = {}, l = {2917}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            String r7 = (String) r5;
            FLogger r8 = FLogger.a;
            r8.d("CreationEditorComponent", "instructionFeatureSelectedForPrompt");
            CreationEditorComponent r1 = this.a;
            int r2 = CreationEditorComponent.g2;
            r1.getClass();
            r8.d("CreationEditorComponent", "onFeatureOptionSelected, onFeatureOptionSelected = " + r7);
            if (r1.a4() == null) goto L35;
            ICoreInputAbility r9 = r1.a4();
            int r0 = 0;
            if (r9 != null) goto L7;
        L9:
            boolean r10 = false;
        L10:
            if (r10 == true) goto L12;
            r1.j6(1);
        L12:
            va8.o r11 = r1.X3();
            if (r11 == null) goto L15;
            String r12 = r11.u7();
        L16:
            if (r12 != null) goto L19;
            r12 = "";
        L19:
            if (StringsKt.isBlank(r12) == false) goto L23;
            va8.o r13 = r1.X3();
            if (r13 == null) goto L26;
            r13.Ug(r7);
        L26:
            va8.o r14 = r1.X3();
            if (r14 == null) goto L35;
            va8.o r15 = r1.X3();
            if (r15 == null) goto L33;
            String r16 = r15.u7();
            if (r16 == null) goto L33;
            r0 = r16.length();
        L33:
            r14.v3(r0);
            goto L35
        L23:
            va8.o r17 = r1.X3();
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

    public CreationEditorComponent$observerInstructionEditor$6(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$6(this.this$0, r3);
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
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getInstructionFeatureSelectedForPrompt();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
