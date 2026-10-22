package com.larus.canvas.feature.component.logic.trace;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.canvas.service.bean.CanvasInfo;
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
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.trace.CanvasGenImageTraceComponent$mobCanvasSendMessageStatus$1", f = "CanvasGenImageTraceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasGenImageTraceComponent$mobCanvasSendMessageStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $success;
    final /* synthetic */ ky8.f $task;
    int label;
    final /* synthetic */ CanvasGenImageTraceComponent this$0;

    public CanvasGenImageTraceComponent$mobCanvasSendMessageStatus$1(ky8.f r1, boolean r2, CanvasGenImageTraceComponent r3, Continuation<? super CanvasGenImageTraceComponent$mobCanvasSendMessageStatus$1> r4) {
        this.$task = r1;
        this.$success = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CanvasGenImageTraceComponent$mobCanvasSendMessageStatus$1(this.$task, this.$success, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r162) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L89;
        ResultKt.throwOnFailure(r162);
        CanvasInfo r1 = this.$task.a();
        String r2 = null;
        if (r1 == null) goto L9;
        Long r3 = r1.canvasSubId;
        if (r3 == null) goto L9;
        String r14 = r3.toString();
    L10:
        CanvasInfo r4 = this.$task.a();
        if (r4 == null) goto L15;
        Long r5 = r4.canvasId;
        if (r5 == null) goto L15;
        String r7 = r5.toString();
    L17:
        if (this.$success == false) goto L19;
        long r6 = 1;
    L20:
        z0 r8 = (z0) this.this$0.i.getValue();
        if (r8 == null) goto L23;
        Long r69 = r8.a;
    L24:
        z0 r9 = (z0) this.this$0.i.getValue();
        if (r9 == null) goto L27;
        String r61 = r9.b;
    L28:
        String r10 = this.$task.e.f;
        q r11 = this.this$0.F2();
        if (r11 == null) goto L31;
        String r12 = r11.b();
    L32:
        q r13 = this.this$0.F2();
        if (r13 == null) goto L35;
        String r15 = r13.c();
    L36:
        q r16 = this.this$0.F2();
        if (r16 == null) goto L39;
        String r17 = r16.z;
    L40:
        q r18 = this.this$0.F2();
        if (r18 == null) goto L43;
        String r19 = r18.z;
    L45:
        if (Intrinsics.areEqual(r19, "chat_upload") == false) goto L47;
        String r20 = "chat";
    L48:
        String r75 = r20;
        q r21 = this.this$0.F2();
        if (r21 == null) goto L51;
        String r51 = r21.t;
    L52:
        q r22 = this.this$0.F2();
        if (r22 == null) goto L55;
        String r60 = r22.q;
    L56:
        q r23 = this.this$0.F2();
        if (r23 == null) goto L59;
        String r98 = r23.r;
    L60:
        q r24 = this.this$0.F2();
        if (r24 == null) goto L63;
        String r99 = r24.s;
    L64:
        boolean r95 = this.$task.e.c();
        Long r25 = this.$task.e.b();
        if (r25 == null) goto L67;
        String r96 = r25.toString();
    L68:
        i r26 = this.$task.e;
        OptionItem r27 = r26.b;
        if (r27 == null) goto L71;
        boolean r97 = true;
    L72:
        if (r27 == null) goto L76;
        InstructionTab r28 = r26.a;
        if (r28 == null) goto L76;
        String r126 = r28.getTabName();
    L77:
        i r29 = this.$task.e;
        if (r29.a == null) goto L80;
    L82:
        boolean r118 = false;
    L83:
        q r30 = this.this$0.F2();
        if (r30 == null) goto L86;
        r2 = r30.d();
    L86:
        l3.d(r12, r15, null, r17, r7, r51, null, null, null, null, null, r14, "pic_and_text", "original", r2, null, null, null, null, null, null, this.$task.e.e, null, null, null, null, Boxing.boxLong(r6), null, "", null, null, null, null, Boxing.boxInt(1), null, null, null, null, null, null, null, null, null, null, null, null, null, Boxing.boxInt(16), r10, null, null, null, null, null, null, null, null, r60, r61, "1", null, null, null, null, null, null, r69, null, null, null, null, null, r75, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boxing.boxBoolean(r95), r96, Boxing.boxBoolean(r97), r98, r99, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boxing.boxBoolean(false), null, null, "no_tab", Boxing.boxBoolean(r118), Boxing.boxInt(0), null, null, null, null, null, null, r126, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1107542135, 1070596029, -8322, -59768895, 2147483645);
        return Unit.INSTANCE;
    L80:
        if (r29.b != null) goto L82;
        r118 = true;
    L76:
        r126 = null;
        goto L77
    L71:
        r97 = false;
        goto L72
    L67:
        r96 = null;
        goto L68
    L63:
        r99 = null;
        goto L64
    L59:
        r98 = null;
        goto L60
    L55:
        r60 = null;
        goto L56
    L51:
        r51 = null;
        goto L52
    L47:
        r20 = "action_bar";
        goto L48
    L43:
        r19 = null;
        goto L45
    L39:
        r17 = null;
        goto L40
    L35:
        r15 = null;
        goto L36
    L31:
        r12 = null;
        goto L32
    L27:
        r61 = null;
        goto L28
    L23:
        r69 = null;
        goto L24
    L19:
        r6 = 0;
    L15:
        r7 = null;
    L9:
        r14 = null;
        goto L10
    L89:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
