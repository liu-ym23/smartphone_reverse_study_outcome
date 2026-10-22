package com.larus.canvas.feature.component.instruction.widget;

import com.larus.canvas.feature.component.instruction.InstructionTabEventType;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.instruction.widget.DropDownBoxWidget$sendDropdownBoxSelectedEvent$1", f = "DropDownBoxWidget.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
final class DropDownBoxWidget$sendDropdownBoxSelectedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ jy8.e $downBoxSelectItem;
    int label;
    final /* synthetic */ DropDownBoxWidget this$0;

    public DropDownBoxWidget$sendDropdownBoxSelectedEvent$1(DropDownBoxWidget r1, jy8.e r2, Continuation<? super DropDownBoxWidget$sendDropdownBoxSelectedEvent$1> r3) {
        this.this$0 = r1;
        this.$downBoxSelectItem = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DropDownBoxWidget$sendDropdownBoxSelectedEvent$1(this.this$0, this.$downBoxSelectItem, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        MutableSharedFlow<com.larus.canvas.feature.component.instruction.c> r14 = com.larus.canvas.feature.component.instruction.d.a;
        InstructionTabEventType r4 = InstructionTabEventType.EVENT_DROP_DOWN_BOX_SELECTED;
        DropDownBoxWidget r15 = this.this$0;
        int r2 = DropDownBoxWidget.l;
        InstructionTab r5 = r15.i();
        List<OptionItem> r16 = this.this$0.i().getOptionList();
        Object r3 = null;
        if (r16 == null) goto L20;
        jy8.e r6 = this.$downBoxSelectItem;
        Iterator<T> r17 = r16.iterator();
    L12:
        if (r17.hasNext() == false) goto L19;
        Object r7 = r17.next();
        if (((OptionItem) r7).getId() != r6.a) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L12;
        r3 = r7;
        goto L19
    L16:
        r8 = false;
    L19:
        r3 = (OptionItem) r3;
    L20:
        com.larus.canvas.feature.component.instruction.c r18 = new com.larus.canvas.feature.component.instruction.c(r4, r5, r3, false, 8);
        this.label = 1;
        if (com.larus.canvas.feature.component.instruction.d.a(r18, this) != r0) goto L24;
        return r0;
    }
}
