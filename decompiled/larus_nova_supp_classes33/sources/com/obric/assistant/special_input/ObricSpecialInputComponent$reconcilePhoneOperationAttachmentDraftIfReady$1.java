package com.obric.assistant.special_input;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.assistant.task.ObricTaskStatusManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$reconcilePhoneOperationAttachmentDraftIfReady$1", f = "ObricSpecialInputComponent.kt", i = {}, l = {1574}, m = "invokeSuspend", n = {}, s = {})
public final class ObricSpecialInputComponent$reconcilePhoneOperationAttachmentDraftIfReady$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ k0 $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $localMsgId;
    final /* synthetic */ q0 $panelContext;
    int label;
    final /* synthetic */ ObricSpecialInputComponent this$0;

    public ObricSpecialInputComponent$reconcilePhoneOperationAttachmentDraftIfReady$1(ObricSpecialInputComponent r1, q0 r2, String r3, String r4, k0 r5, Continuation<? super ObricSpecialInputComponent$reconcilePhoneOperationAttachmentDraftIfReady$1> r6) {
        this.this$0 = r1;
        this.$panelContext = r2;
        this.$localMsgId = r3;
        this.$conversationId = r4;
        this.$context = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricSpecialInputComponent$reconcilePhoneOperationAttachmentDraftIfReady$1(this.this$0, this.$panelContext, this.$localMsgId, this.$conversationId, this.$context, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r34) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r34);
        Object r3 = r34;
    L87:
        ObricSpecialInputComponent.SpecialPanelRestoreResult r4 = (ObricSpecialInputComponent.SpecialPanelRestoreResult) r3;
        ObricSpecialInputComponent r5 = this.this$0;
        int r6 = ObricSpecialInputComponent.G1;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r7 = r5.f70();
        if (r7 == null) goto L90;
        String r8 = r7.Wv();
    L92:
        if (Intrinsics.areEqual(r8, this.$localMsgId) == false) goto L115;
        o0 r9 = o0.a;
        String r10 = this.$conversationId;
        r9.getClass();
        k0 r11 = o0.b(r10);
        if (r11 == null) goto L96;
        String r12 = r11.b;
    L98:
        if (Intrinsics.areEqual(r12, this.$localMsgId) == false) goto L115;
        ObricSpecialInputComponent r13 = this.this$0;
        k0 r14 = this.$context;
        q0 r15 = this.$panelContext;
        String r16 = this.$localMsgId;
        r13.getClass();
        int r17 = ObricSpecialInputComponent.b.a[r4.ordinal()];
        if (r17 == 1) goto L109;
        if (r17 != 2) goto L104;
        FLogger.a.i("ObricSpecialInputComponent", "[PhoneAttachmentDraft] wait restore prerequisite, requestType=" + r15.a);
    L113:
        this.this$0.X = null;
        return Unit.INSTANCE;
    L104:
        if (r17 != 3) goto L107;
        r13.G3(r14, "special_panel_context_invalid");
        goto L113
    L107:
        throw new NoWhenBranchMatchedException();
    L109:
        r13.W = r16;
        bc8.a r18 = (bc8.a) r13.s.getValue();
        if (r18 == null) goto L112;
        r18.mX();
    L112:
        FLogger.a.i("ObricSpecialInputComponent", "[PhoneAttachmentDraft] special panel restored, requestType=" + r15.a);
        goto L113
    L96:
        r12 = null;
    L115:
        this.this$0.X = null;
        return Unit.INSTANCE;
    L90:
        r8 = null;
        goto L92
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r34);
        ObricSpecialInputComponent r19 = this.this$0;
        q0 r20 = this.$panelContext;
        this.label = 1;
        int r21 = ObricSpecialInputComponent.G1;
        com.larus.bmhome.instruction.g r22 = r19.j4();
        boolean r110 = false;
        if (r22 != null) goto L11;
    L13:
        boolean r23 = false;
    L14:
        if (r23 == false) goto L16;
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.PENDING;
    L85:
        if (r3 != r1) goto L87;
        return r1;
    L16:
        int r24 = r20.a;
        if (r24 == 0) goto L67;
        if (r24 == 1) goto L22;
        if (r24 == 2) goto L21;
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.FAILED;
        goto L85
    L21:
        r3 = r19.Q5(r20, this);
        goto L85
    L22:
        String r25 = r20.c;
        if (r25 != null) goto L25;
    L35:
        String r26 = r20.d;
        if (r26 != null) goto L38;
    L45:
        DMTaskState r27 = null;
    L46:
        if (r27 != null) goto L52;
        ObricTaskStatusManager.a.getClass();
        if (ObricTaskStatusManager.f.getValue() != null) goto L50;
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.PENDING;
        goto L85
    L50:
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.FAILED;
        goto L85
    L52:
        if (com.obric.assistant.utils.l.f(r27) == true) goto L54;
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.FAILED;
        goto L85
    L54:
        r19.f5(ObricSpecialInputComponent.z3(r20, null, r27));
        if (((Boolean) r19.L.getValue()).booleanValue() == false) goto L65;
        laa.v r28 = (laa.v) r19.P.getValue();
        if (r28 == null) goto L61;
        DMTaskState r29 = r28.a;
        if (r29 == null) goto L61;
        String r30 = r29.getTaskId();
    L63:
        if (Intrinsics.areEqual(r30, r27.getTaskId()) == false) goto L65;
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.SUCCESS;
    L61:
        r30 = null;
    L65:
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.FAILED;
        goto L85
    L38:
        if (r26.length() <= 0) goto L40;
        r110 = true;
    L40:
        if (r110 == true) goto L43;
        r26 = null;
    L43:
        if (r26 == null) goto L45;
        ObricTaskStatusManager.a.getClass();
        r27 = ObricTaskStatusManager.d(r26);
        goto L46
    L25:
        if (r25.length() <= 0) goto L27;
        boolean r31 = true;
    L28:
        if (r31 == true) goto L31;
        r25 = null;
    L31:
        if (r25 == null) goto L35;
        ObricTaskStatusManager.a.getClass();
        r27 = ObricTaskStatusManager.e(r25);
        if (r27 == null) goto L35;
    L27:
        r31 = false;
        goto L28
    L67:
        if (Intrinsics.areEqual(r20.b, "phone_operation_quick_instruction") == false) goto L84;
        PhoneOperationModeRestoreResult r32 = p0.a(r19.j4(), "quick_instruction_attachment_draft", false);
        Intrinsics.checkNotNullParameter(r32, "<this>");
        if (r32 != PhoneOperationModeRestoreResult.READY) goto L71;
        boolean r33 = true;
    L72:
        if (r33 == false) goto L84;
        laa.j.a.a(r19, false, null, null, qha.o.a(r19.getContext(), new com.larus.bmhome.actionbar.model.z0(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -1, 15)), true, true, 36);
        if (((Boolean) r19.L.getValue()).booleanValue() == false) goto L83;
        com.larus.bmhome.actionbar.model.z0 r35 = r19.Q;
        if (r35 != null) goto L79;
    L81:
        if (r110 == false) goto L83;
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.SUCCESS;
        goto L85
    L79:
        if (Intrinsics.areEqual(r35.b, "obric_quick_instruction") != true) goto L81;
        r110 = true;
    L83:
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.FAILED;
        goto L85
    L71:
        r33 = false;
    L84:
        r3 = ObricSpecialInputComponent.SpecialPanelRestoreResult.FAILED;
        goto L85
    L11:
        if (r22.z0() != true) goto L13;
        r23 = true;
        goto L14
    }
}
