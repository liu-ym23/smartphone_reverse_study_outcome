package com.obric.assistant;

import com.bytedance.keva.Keva;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ObricMsgInfoSaveServiceImpl;", "Lcom/obric/assistant/state/api/v2/core/IObricMsgInfoSaveService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "lastSendMessageCreateTime", NameKeys.UnloadStrategy_No_Strategy, "lastReceiveMessageCreateTime", "lastReceiveMessageId", NameKeys.UnloadStrategy_No_Strategy, "saveInformationOnSendOrRegenMessage", NameKeys.UnloadStrategy_No_Strategy, "saveInformationOnReceiveMessage", "saveMsgInfoOnRegen", "msg", "Lcom/larus/im/bean/message/Message;", "saveMsgInfoOnSend", "saveMsgRespondedTimeForOtherContentType", "saveMsgRespondedTime", "isCurrentReplyMessage", NameKeys.UnloadStrategy_No_Strategy, "isDismissMsg", "savePendingSendMessage", "clearPendingSendMessage", "getPendingSendMessageCreateTime", "isReplyForPendingSendMessage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMsgInfoSaveServiceImpl implements IObricMsgInfoSaveService {
    public final Keva a;
    public long b;
    public long c;
    public String d;

    public static final class a {
    }

    static {
    }

    public final long e() {
        Long r0 = Long.valueOf(this.a.getLong("last_send_message_create_time", this.b));
        if (r0.longValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        return r0.longValue();
    L12:
        return this.b;
    L5:
        r1 = false;
        goto L6
    }

    public final void f() {
        FLogger.a.i("ObricMsgInfoSaveServiceImpl", "saveInformationOnReceiveMessage");
        this.a.storeLong("response_end_time", System.currentTimeMillis());
        this.a.storeBoolean("is_shown_in_response", false);
        this.a.storeString("last_send_message_id", NameKeys.UnloadStrategy_No_Strategy);
        this.a.storeString("last_send_message_conversation_id", NameKeys.UnloadStrategy_No_Strategy);
    }

    public final void g() {
        FLogger.a.i("ObricMsgInfoSaveServiceImpl", "saveInformationOnSendOrRegenMessage");
        this.a.storeBoolean("is_shown_in_response", true);
        this.a.storeBoolean("is_shown_after_responded", false);
        this.a.storeLong("last_message_send_time_ms", System.currentTimeMillis());
        this.a.storeLong("last_message_send_time_s", System.currentTimeMillis() / ((long) 1000));
        this.a.storeLong("last_send_message_create_time", this.b);
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L6;
        this.a.storeLong("last_message_send_time_in_device_locked", System.currentTimeMillis());
        return;
    }

    public ObricMsgInfoSaveServiceImpl() {
        this.a = xg9.b.a();
        this.d = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void a(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (com.larus.utils.o0.d(com.larus.bmhome.chat.bean.d.o(r4)) == false) goto L6;
        FLogger.a.i("ObricMsgInfoSaveServiceImpl", "message onRegen and is not empty, store LAST_MESSAGE_SEND_TIME");
        this.b = r4.getCreateTime();
        h(r4);
        g();
        return;
    }

    public final void b(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        long r0 = e();
        if (r6.getContentType() == 800) goto L5;
        return;
    L5:
        if (r6.getCreateTime() > r0) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r6.getMessageId(), this.d) == true) goto L12;
        FLogger.a.i("ObricMsgInfoSaveServiceImpl", "onMessageReceiveEnd contentType is other, store RESPONSE_END_TIME");
        this.d = String.valueOf(r6.getMessageId());
        f();
        return;
    }

    public final void c(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (com.larus.utils.o0.d(com.larus.bmhome.chat.bean.d.o(r4)) == false) goto L6;
        FLogger.a.i("ObricMsgInfoSaveServiceImpl", "message onSend and is not empty, store LAST_MESSAGE_SEND_TIME");
        this.b = r4.getCreateTime();
        h(r4);
        g();
        return;
    }

    public final void h(Message r5) {
        Keva r0 = this.a;
        String r1 = r5.getMessageId();
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        if (r1 != null) goto L5;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r0.storeString("last_send_message_id", r1);
        Keva r3 = this.a;
        String r6 = r5.getConversationId();
        if (r6 == null) goto L9;
        r2 = r6;
    L9:
        r3.storeString("last_send_message_conversation_id", r2);
    }

    public final void d(boolean r13, Message r14) {
        Intrinsics.checkNotNullParameter(r14, "msg");
        boolean r1 = false;
        if (com.larus.bmhome.chat.bean.d.k0(r14) == false) goto L5;
    L12:
        boolean r0 = true;
    L14:
        if (r0 == false) goto L18;
        FLogger.a.i("ObricMsgInfoSaveServiceImpl", "saveMsgRespondedTime isDismissMsg:true");
        return;
    L18:
        if (r14.getContentType() == 66) goto L20;
    L22:
        boolean r2 = false;
    L23:
        Keva r4 = this.a;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
        String r5 = r4.getString("last_send_message_id", NameKeys.UnloadStrategy_No_Strategy);
        if (r5 != null) goto L27;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L27:
        if (r5.length() != 0) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == true) goto L52;
        String r8 = this.a.getString("last_send_message_conversation_id", NameKeys.UnloadStrategy_No_Strategy);
        if (r8 != null) goto L36;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L36:
        if (r8.length() <= 0) goto L38;
        boolean r9 = true;
    L39:
        if (r9 == false) goto L48;
        String r10 = r14.getConversationId();
        if (r10 == null) goto L45;
        r6 = r10;
    L45:
        if (Intrinsics.areEqual(r8, r6) == false) goto L52;
    L48:
        if (Intrinsics.areEqual(r14.getReplyId(), r5) == false) goto L52;
        if (r14.getCreateTime() <= e()) goto L52;
        boolean r11 = true;
    L54:
        if (r13 == true) goto L67;
        if (r11 == true) goto L67;
        if (Intrinsics.areEqual(r14.getReplyId(), "0") == true) goto L59;
    L60:
        Map r15 = r14.getExt();
        if (r15 == null) goto L63;
        String r16 = (String) r15.get("msg_scene");
    L65:
        if (Intrinsics.areEqual(r16, "edu_homework_correction") == true) goto L67;
    L69:
        if (r2 == true) goto L71;
        if (r1 == true) goto L71;
        return;
    L71:
        FLogger.a.i("ObricMsgInfoSaveServiceImpl", "CurrentReplyMessage is true real ending, store RESPONSE_END_TIME, isMultiContentSubReceiving:" + r2 + ", isValidReply:" + r1 + ", isReplyForPendingSendMessage:" + r11);
        if (r14.getCreateTime() <= this.c) goto L74;
        this.c = r14.getCreateTime();
        this.d = String.valueOf(r14.getMessageId());
    L74:
        f();
        if (r2 == false) goto L79;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ObricMsgInfoSaveServiceImpl$saveMsgRespondedTime$1(this, null), 3, null);
        return;
    L79:
        return;
    L63:
        r16 = null;
        goto L65
    L59:
        if (r14.getCreateTime() <= e()) goto L60;
    L67:
        if (Intrinsics.areEqual(r14.getMessageId(), this.d) == true) goto L69;
        r1 = true;
        goto L69
    L38:
        r9 = false;
    L52:
        r11 = false;
        goto L54
    L29:
        r7 = false;
        goto L30
    L20:
        if (com.larus.im.bean.message.a.z0(r14) == false) goto L22;
        r2 = true;
        goto L23
    L5:
        if (com.larus.bmhome.chat.bean.d.W0(r14) == true) goto L12;
        if (com.larus.bmhome.chat.bean.d.O0(r14) == true) goto L12;
        if (com.larus.bmhome.chat.bean.d.X(r14) == true) goto L12;
        r0 = false;
        goto L14
    }
}
