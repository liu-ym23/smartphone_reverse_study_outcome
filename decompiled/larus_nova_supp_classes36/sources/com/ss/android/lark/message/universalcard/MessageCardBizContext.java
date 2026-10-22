package com.ss.android.lark.message.universalcard;

import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import com.google.gson.JsonObject;
import com.larksuite.component.card.protocol.context.BizContext;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/message/universalcard/MessageCardBizContext;", "Lcom/larksuite/component/card/protocol/context/BizContext;", "msgId", "", "chatId", "senderId", "senderTenantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMsgId", "()Ljava/lang/String;", "getChatId", "getSenderId", "getSenderTenantId", "toJson", "Lcom/google/gson/JsonObject;", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MessageCardBizContext extends BizContext {
    private final String chatId;
    private final String msgId;
    private final String senderId;
    private final String senderTenantId;

    public JsonObject toJson() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("msg_id", this.msgId);
        r0.addProperty("chat_id", this.chatId);
        r0.addProperty("biz_type", Integer.valueOf(getBizType().getValue()));
        return r0;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final String getSenderTenantId() {
        return this.senderTenantId;
    }

    public MessageCardBizContext(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r3, "chatId");
        super(r2, UniversalCardBizType.BIZ_TYPE_MESSAGE_CARD);
        this.msgId = r2;
        this.chatId = r3;
        this.senderId = r4;
        this.senderTenantId = r5;
    }
}
