package com.larus.canvas.feature.component.instruction.widget;

import com.larus.canvas.feature.component.instruction.InstructionTabEventType;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.uaigc.service.IUgcAIGCService;
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
@DebugMetadata(c = "com.larus.canvas.feature.component.instruction.widget.ToolsWidget$buildCustomAreaView$1$2$1", f = "ToolsWidget.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
public final class ToolsWidget$buildCustomAreaView$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ jy8.d $item;
    int label;
    final /* synthetic */ ToolsWidget this$0;

    public ToolsWidget$buildCustomAreaView$1$2$1(ToolsWidget r1, jy8.d r2, Continuation<? super ToolsWidget$buildCustomAreaView$1$2$1> r3) {
        this.this$0 = r1;
        this.$item = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ToolsWidget$buildCustomAreaView$1$2$1(this.this$0, this.$item, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r28) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r28);
    L23:
        ToolsWidget r3 = this.this$0;
        jy8.d r4 = this.$item;
        r3.getClass();
        hy9.d r5 = IUgcAIGCService.a.j();
        String r10 = r3.j().get("bot_id");
        String r12 = r3.j().get("action_bar_template_id");
        String r16 = r3.j().get("ai_create_show_mode");
        String r6 = r4.b;
        String r7 = r3.i().getTabName();
        String r8 = String.valueOf(r4.a);
        String r23 = r3.j().get("current_page");
        String r11 = r3.j().get("enter_method");
        String r14 = r3.j().get("previous_page");
        hy9.d.a.a(r5, r6, r7, r8, r3.j().get("show_from"), "single_function", r10, r11, r12, null, r14, null, r16, null, null, null, null, "no_tab", null, r23, null, r3.e(), 2815232);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r28);
        MutableSharedFlow<com.larus.canvas.feature.component.instruction.c> r9 = com.larus.canvas.feature.component.instruction.d.a;
        InstructionTabEventType r13 = InstructionTabEventType.EVENT_INSTRUCTION_OPTION_CLICK;
        InstructionTab r15 = this.this$0.i();
        List<OptionItem> r17 = this.this$0.i().getOptionList();
        Object r18 = null;
        if (r17 == null) goto L20;
        jy8.d r19 = this.$item;
        Iterator<T> r20 = r17.iterator();
    L12:
        if (r20.hasNext() == false) goto L19;
        Object r21 = r20.next();
        if (((OptionItem) r21).getId() != r19.a) goto L16;
        boolean r22 = true;
    L17:
        if (r22 == false) goto L12;
        r18 = r21;
        goto L19
    L16:
        r22 = false;
    L19:
        r18 = (OptionItem) r18;
    L20:
        com.larus.canvas.feature.component.instruction.c r24 = new com.larus.canvas.feature.component.instruction.c(r13, r15, r18, false, 8);
        this.label = 1;
        if (com.larus.canvas.feature.component.instruction.d.a(r24, this) != r1) goto L23;
        return r1;
    }
}
