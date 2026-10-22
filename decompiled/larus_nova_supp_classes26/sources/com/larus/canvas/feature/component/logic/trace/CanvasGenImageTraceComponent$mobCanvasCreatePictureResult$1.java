package com.larus.canvas.feature.component.logic.trace;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.canvas.service.bean.InstructionTab;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.trace.CanvasGenImageTraceComponent$mobCanvasCreatePictureResult$1", f = "CanvasGenImageTraceComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasGenImageTraceComponent$mobCanvasCreatePictureResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $alreadyFailed;
    final /* synthetic */ ky8.f $task;
    final /* synthetic */ long $time;
    int label;
    final /* synthetic */ CanvasGenImageTraceComponent this$0;

    public CanvasGenImageTraceComponent$mobCanvasCreatePictureResult$1(CanvasGenImageTraceComponent r1, ky8.f r2, long r3, boolean r5, Continuation<? super CanvasGenImageTraceComponent$mobCanvasCreatePictureResult$1> r6) {
        this.this$0 = r1;
        this.$task = r2;
        this.$time = r3;
        this.$alreadyFailed = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CanvasGenImageTraceComponent$mobCanvasCreatePictureResult$1(this.this$0, this.$task, this.$time, this.$alreadyFailed, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L87;
        ResultKt.throwOnFailure(r13);
        by7.a r14 = new by7.a("create_picture_result");
        CanvasGenImageTraceComponent r0 = this.this$0;
        ky8.f r1 = this.$task;
        long r2 = this.$time;
        boolean r4 = this.$alreadyFailed;
        q r5 = r0.F2();
        String r6 = null;
        if (r5 == null) goto L7;
        String r7 = r5.w;
    L8:
        r14.d("ai_create_show_mode", r7);
        q r8 = r0.F2();
        if (r8 == null) goto L11;
        String r9 = r8.b();
    L12:
        r14.d("bot_id", r9);
        q r10 = r0.F2();
        if (r10 == null) goto L15;
        String r11 = r10.c();
    L16:
        r14.d("chat_type", r11);
        i r12 = r1.e;
        int r15 = 0;
        if (r12.d == false) goto L20;
        String r16 = "regenerate";
    L31:
        r14.d("create_way", r16);
        q r17 = r0.F2();
        if (r17 == null) goto L34;
        String r18 = r17.t;
    L35:
        r14.d("current_page", r18);
        r14.d("duration", Boxing.boxLong(r2 - r1.i));
        q r3 = r0.F2();
        if (r3 == null) goto L38;
        String r19 = r3.q;
    L39:
        r14.d("enter_method", r19);
        r14.d("is_image_edit", Boxing.boxInt(r1.e.c() ? 1 : 0));
        Long r20 = r1.e.b();
        if (r20 == null) goto L42;
        String r21 = r20.toString();
    L43:
        r14.d("image_edit_function_id", r21);
        if (r1.e.b == null) goto L46;
        int r22 = 1;
    L47:
        r14.d("with_image_style", Boxing.boxInt(r22));
        i r23 = r1.e;
        if (r23.b == null) goto L52;
        InstructionTab r24 = r23.a;
        if (r24 == null) goto L52;
        String r25 = r24.getTabName();
    L53:
        r14.d("style_tab_label", r25);
        r14.d("is_attachment_sug", Boxing.boxInt(0));
        r14.d("is_deep_thinking", TriggerSendLoading.NO_LOADING);
        r14.d("is_from_template", Boxing.boxInt(0));
        i r26 = r1.e;
        if (r26.a == null) goto L56;
    L58:
        int r27 = 0;
    L59:
        r14.d("is_manual_input", Boxing.boxInt(r27));
        r14.d("is_replica_gen", Boxing.boxInt(0));
        CanvasInfo r28 = r1.a();
        if (r28 == null) goto L62;
        String r29 = r28.replySubId;
    L63:
        r14.d(MusicAppletPage.KEY_MESSAGE_ID, r29);
        CanvasInfo r30 = r1.a();
        if (r30 == null) goto L68;
        Long r31 = r30.canvasId;
        if (r31 == null) goto L68;
        String r32 = r31.toString();
    L69:
        r14.d(MusicAppletPage.KEY_CONVERSATION_ID, r32);
        q r33 = r0.F2();
        if (r33 == null) goto L72;
        r6 = r33.d();
    L72:
        r14.d("previous_page", r6);
        if (r4 == true) goto L84;
        Integer r34 = r1.n();
        if (r34 != null) goto L79;
    L81:
        boolean r35 = false;
    L82:
        if (r35 == true) goto L84;
        r15 = 1;
        goto L84
    L79:
        if (r34.intValue() != 11) goto L81;
        r35 = true;
    L84:
        r14.d("success", Boxing.boxInt(r15));
        r14.d("success_cnt", Boxing.boxInt(r15));
        r14.d("total_cnt", Boxing.boxInt(r15));
        r14.d("with_image", Boxing.boxInt(1));
        r14.b();
        return Unit.INSTANCE;
    L68:
        r32 = null;
        goto L69
    L62:
        r29 = null;
        goto L63
    L56:
        if (r26.b != null) goto L58;
        r27 = 1;
    L52:
        r25 = null;
        goto L53
    L46:
        r22 = 0;
        goto L47
    L42:
        r21 = null;
        goto L43
    L38:
        r19 = null;
        goto L39
    L34:
        r18 = null;
        goto L35
    L20:
        if (Intrinsics.areEqual(r12.e, "router_auto_send") == false) goto L22;
        r16 = "chat_action_bar";
        goto L31
    L22:
        r16 = r12.e;
        if (r16 != null) goto L26;
        r16 = "";
    L26:
        if (r16.length() != 0) goto L28;
        boolean r36 = true;
    L29:
        if (r36 == false) goto L31;
        r16 = "other";
        goto L31
    L28:
        r36 = false;
        goto L29
    L15:
        r11 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    L7:
        r7 = null;
        goto L8
    L87:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
