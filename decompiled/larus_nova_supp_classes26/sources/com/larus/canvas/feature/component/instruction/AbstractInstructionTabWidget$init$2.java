package com.larus.canvas.feature.component.instruction;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.larus.canvas.impl.databinding.LarusInstructionTabItemViewBinding;
import com.larus.canvas.service.bean.InstructionTab;
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
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.instruction.AbstractInstructionTabWidget$init$2", f = "AbstractInstructionTabWidget.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
public final class AbstractInstructionTabWidget$init$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AbstractInstructionTabWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ AbstractInstructionTabWidget a;

        public a(AbstractInstructionTabWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            c r9 = (c) r7;
            String r2 = null;
            if (r9.a != InstructionTabEventType.EVENT_INSTRUCTION_TAB_SELECTED) goto L26;
            AbstractInstructionTabWidget r10 = this.a;
            r10.getClass();
            InstructionTab r0 = r9.b;
            if (r0 == null) goto L7;
            String r1 = r0.getTabLabel();
        L9:
            if (Intrinsics.areEqual(r1, r10.i().getTabLabel()) == true) goto L11;
        L24:
            r10.f = false;
            r10.f();
            goto L26
        L11:
            if (r10.m() == false) goto L24;
            r10.f = true;
            LarusInstructionTabItemViewBinding r3 = r10.e;
            if (r3 == null) goto L17;
            LinearLayout r4 = r3.a;
            if (r4 == null) goto L17;
            r4.setBackgroundResource(v19.c.b(2130970806, r4.getContext(), 2131239608));
        L17:
            Context r5 = r10.h().getContext();
            if (r5 == null) goto L26;
            LarusInstructionTabItemViewBinding r11 = r10.e;
            if (r11 == null) goto L26;
            AppCompatTextView r12 = r11.d;
            if (r12 == null) goto L26;
            r12.setTextColor(ContextCompat.getColor(r5, v19.c.b(2130972123, r5, 2131103203)));
            goto L26
        L7:
            r1 = null;
        L26:
            if (r9.a != InstructionTabEventType.EVENT_INSTRUCTION_TAB_UN_SELECTED) goto L36;
            AbstractInstructionTabWidget r13 = this.a;
            r13.getClass();
            InstructionTab r14 = r9.b;
            if (r14 == null) goto L31;
            r2 = r14.getTabLabel();
        L31:
            if (Intrinsics.areEqual(r2, r13.i().getTabLabel()) == false) goto L36;
            if (r13.f == false) goto L36;
            r13.f = false;
            r13.f();
        L36:
            return Unit.INSTANCE;
        }
    }

    public AbstractInstructionTabWidget$init$2(AbstractInstructionTabWidget r1, Continuation<? super AbstractInstructionTabWidget$init$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AbstractInstructionTabWidget$init$2(this.this$0, r3);
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
        a1 r6 = d.b;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
