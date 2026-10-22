package com.larus.canvas.feature.component.logic.trace;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
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
import ky8.i;
import my8.q;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.trace.CanvasGenImageTraceComponent$mobCanvasSendMessage$1", f = "CanvasGenImageTraceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasGenImageTraceComponent$mobCanvasSendMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.f $task;
    int label;
    final /* synthetic */ CanvasGenImageTraceComponent this$0;

    public CanvasGenImageTraceComponent$mobCanvasSendMessage$1(CanvasGenImageTraceComponent r1, ky8.f r2, Continuation<? super CanvasGenImageTraceComponent$mobCanvasSendMessage$1> r3) {
        this.this$0 = r1;
        this.$task = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CanvasGenImageTraceComponent$mobCanvasSendMessage$1(this.this$0, this.$task, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r169) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L73;
        ResultKt.throwOnFailure(r169);
        z0 r1 = (z0) this.this$0.i.getValue();
        String r2 = null;
        if (r1 == null) goto L7;
        Long r74 = r1.a;
    L8:
        z0 r3 = (z0) this.this$0.i.getValue();
        if (r3 == null) goto L11;
        String r60 = r3.b;
    L12:
        String r4 = this.$task.e.f;
        q r5 = this.this$0.F2();
        if (r5 == null) goto L15;
        String r6 = r5.b();
    L16:
        q r7 = this.this$0.F2();
        if (r7 == null) goto L19;
        String r8 = r7.c();
    L20:
        q r9 = this.this$0.F2();
        if (r9 == null) goto L23;
        String r10 = r9.z;
    L24:
        q r11 = this.this$0.F2();
        if (r11 == null) goto L27;
        String r12 = r11.z;
    L29:
        if (Intrinsics.areEqual(r12, "chat_upload") == false) goto L31;
        String r13 = "chat";
    L32:
        String r79 = r13;
        q r14 = this.this$0.F2();
        if (r14 == null) goto L35;
        String r15 = r14.t;
    L36:
        q r16 = this.this$0.F2();
        if (r16 == null) goto L39;
        String r55 = r16.q;
    L40:
        q r17 = this.this$0.F2();
        if (r17 == null) goto L43;
        String r100 = r17.r;
    L44:
        q r18 = this.this$0.F2();
        if (r18 == null) goto L47;
        String r101 = r18.s;
    L48:
        boolean r19 = this.$task.e.c();
        Long r20 = this.$task.e.b();
        if (r20 == null) goto L51;
        String r70 = r20.toString();
    L52:
        i r21 = this.$task.e;
        OptionItem r22 = r21.b;
        if (r22 == null) goto L55;
        boolean r72 = true;
    L56:
        if (r22 == null) goto L60;
        InstructionTab r23 = r21.a;
        if (r23 == null) goto L60;
        String r132 = r23.getTabName();
    L61:
        i r24 = this.$task.e;
        if (r24.a == null) goto L64;
    L66:
        boolean r71 = false;
    L67:
        q r25 = this.this$0.F2();
        if (r25 == null) goto L70;
        r2 = r25.d();
    L70:
        l3.b(r6, r8, null, r10, null, r15, null, null, null, null, null, null, "pic_and_text", "original", r2, null, null, null, null, null, this.$task.e.e, null, null, null, null, null, null, null, null, null, Boxing.boxInt(1), null, null, null, null, "", null, null, null, null, null, null, null, null, null, null, null, Boxing.boxInt(16), null, null, null, null, r55, null, null, r4, null, r60, "1", null, null, null, null, null, null, null, Boxing.boxBoolean(r19), r70, Boxing.boxBoolean(r71), Boxing.boxBoolean(r72), null, r74, null, null, null, null, r79, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r100, r101, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boxing.boxBoolean(false), null, "no_tab", null, Boxing.boxInt(0), null, null, null, null, null, null, null, null, r132, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -135135403, -553652353, -2193422, 1610609663, -1027, 255);
        return Unit.INSTANCE;
    L64:
        if (r24.b != null) goto L66;
        r71 = true;
    L60:
        r132 = null;
        goto L61
    L55:
        r72 = false;
        goto L56
    L51:
        r70 = null;
        goto L52
    L47:
        r101 = null;
        goto L48
    L43:
        r100 = null;
        goto L44
    L39:
        r55 = null;
        goto L40
    L35:
        r15 = null;
        goto L36
    L31:
        r13 = "action_bar";
        goto L32
    L27:
        r12 = null;
        goto L29
    L23:
        r10 = null;
        goto L24
    L19:
        r8 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L11:
        r60 = null;
        goto L12
    L7:
        r74 = null;
        goto L8
    L73:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
