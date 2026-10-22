package com.larus.drive.sdk.impl.component.chat;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.component.chat.DriveChatReceiveComponent$sendDriveFileAndTextByCreation$1", f = "DriveChatReceiveComponent.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {})
final class DriveChatReceiveComponent$sendDriveFileAndTextByCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CustomMultiAttachmentInfo $customMultiAttachment;
    final /* synthetic */ Map<String, String> $driveBizExt;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ boolean $isSpeak;
    final /* synthetic */ String $sendBotId;
    final /* synthetic */ wc9.e $sendConversation;
    final /* synthetic */ String $sendCvsId;
    final /* synthetic */ String $sendText;
    final /* synthetic */ String $txtScene;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DriveChatReceiveComponent this$0;

    public DriveChatReceiveComponent$sendDriveFileAndTextByCreation$1(String r1, String r2, wc9.e r3, String r4, String r5, String r6, String r7, CustomMultiAttachmentInfo r8, DriveChatReceiveComponent r9, boolean r10, Map<String, String> r11, Continuation<? super DriveChatReceiveComponent$sendDriveFileAndTextByCreation$1> r12) {
        this.$sendCvsId = r1;
        this.$sendBotId = r2;
        this.$sendConversation = r3;
        this.$sendText = r4;
        this.$fromScene = r5;
        this.$txtScene = r6;
        this.$enterMethod = r7;
        this.$customMultiAttachment = r8;
        this.this$0 = r9;
        this.$isSpeak = r10;
        this.$driveBizExt = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r16, Continuation<?> r17) {
        DriveChatReceiveComponent$sendDriveFileAndTextByCreation$1 r14 = new DriveChatReceiveComponent$sendDriveFileAndTextByCreation$1(this.$sendCvsId, this.$sendBotId, this.$sendConversation, this.$sendText, this.$fromScene, this.$txtScene, this.$enterMethod, this.$customMultiAttachment, this.this$0, this.$isSpeak, this.$driveBizExt, r17);
        r14.L$0 = r16;
        return r14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r46) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L10;
        ResultKt.throwOnFailure(r46);     // Catch: Throwable -> L7
        Object r3 = r46;
    L63:
        Object r1 = Result.constructor-impl(Boxing.boxBoolean(((Boolean) r3).booleanValue()));     // Catch: Throwable -> L7
    L66:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L70;
        FLogger.a.e("DriveChatReceiveComponent", "[sendDriveFileAndTextByCreation] sendCreationMessage failed", r4);
    L70:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r46);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        String r6 = this.$sendCvsId;
        String r7 = "";
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        wc9.e r8 = this.$sendConversation;
        if (r6.length() != 0) goto L17;
        boolean r9 = true;
    L18:
        String r10 = null;
        if (r9 == false) goto L27;
        if (r8 == null) goto L22;
        String r11 = r8.a;
    L23:
        if (r11 == null) goto L26;
        r7 = r11;
    L26:
        r6 = r7;
        goto L27
    L22:
        r11 = null;
    L27:
        String r12 = this.$sendBotId;
        if (r12 != null) goto L30;
    L39:
        e0 r13 = (e0) AuthModelDelegate.b.e().getValue();
        if (r13 == null) goto L45;
        LaunchInfo r14 = r13.a;
        if (r14 == null) goto L45;
        r10 = r14.W();
    L45:
        if (this.$sendConversation != null) goto L47;
    L71:
        boolean r15 = false;
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("[sendDriveFileAndTextByCreation] invalid conversation, conversationNull:");
        if (this.$sendConversation != null) goto L74;
        boolean r18 = true;
    L75:
        r17.append(r18);
        r17.append(", cvsIdEmpty:");
        if (r6.length() != 0) goto L78;
        r15 = true;
    L78:
        r17.append(r15);
        r16.e("DriveChatReceiveComponent", r17.toString());
        return Unit.INSTANCE;
    L74:
        r18 = false;
        goto L75
    L47:
        if (r6.length() != 0) goto L49;
        boolean r20 = true;
    L50:
        if (r20 == true) goto L71;
        wc9.e r21 = this.$sendConversation;
        String r22 = this.$sendText;
        String r23 = this.$fromScene;
        String r110 = this.$txtScene;
        String r111 = this.$enterMethod;
        CustomMultiAttachmentInfo r112 = this.$customMultiAttachment;
        DriveChatReceiveComponent r113 = this.this$0;
        boolean r114 = this.$isSpeak;
        Map<String, String> r115 = this.$driveBizExt;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L7
        ICreationWorkflowService.Companion r24 = ICreationWorkflowService.a;     // Catch: Throwable -> L7
        CreationSendMessageConfig.Companion.getClass();     // Catch: Throwable -> L7
        CreationSendMessageConfig.a r25 = new CreationSendMessageConfig.a();     // Catch: Throwable -> L7
        r25.j(r21);     // Catch: Throwable -> L7
        r25.l(r6);     // Catch: Throwable -> L7
        r25.f(r10);     // Catch: Throwable -> L7
        r25.i(r22);     // Catch: Throwable -> L7
        r25.s(r23);     // Catch: Throwable -> L7
        if (r110 == null) goto L57;
        r23 = r110;
    L57:
        r25.u(r23);     // Catch: Throwable -> L7
        r25.m(r111);     // Catch: Throwable -> L7
        r25.d(Boxing.boxInt(0));     // Catch: Throwable -> L7
        r25.k(r112);     // Catch: Throwable -> L7
        int r26 = DriveChatReceiveComponent.j;     // Catch: Throwable -> L7
        r113.getClass();     // Catch: Throwable -> L7
        LinkedHashMap r27 = new LinkedHashMap();     // Catch: Throwable -> L7
        r27.put("is_audio", String.valueOf(r114));     // Catch: Throwable -> L7
        if (r114 == false) goto L60;
        r27.put("drive_add_speak_duration", "1");     // Catch: Throwable -> L7
    L60:
        r25.q(r27);     // Catch: Throwable -> L7
        CreationSendMessageConfig r28 = CreationSendMessageConfig.copy$default(r25.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r115, null, null, null, null, false, null, null, false, false, null, 134152191, null);     // Catch: Throwable -> L7
        r25.a = r28;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r3 = r24.W(r28, this);     // Catch: Throwable -> L7
        if (r3 != r0) goto L63;
        return r0;
    L49:
        r20 = false;
        goto L50
    L30:
        if (r12.length() <= 0) goto L32;
        boolean r30 = true;
    L33:
        if (r30 == true) goto L36;
        r12 = null;
    L36:
        if (r12 == null) goto L39;
        r10 = r12;
        goto L45
    L32:
        r30 = false;
        goto L33
    L17:
        r9 = false;
    L7:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L66
    }
}
