package com.larus.bmhome.social.userchat.model;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.Message;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/social/userchat/model/MessageWithBotId;", "Ljava/io/Serializable;", "botId", "", "msg", "Lcom/larus/im/bean/message/Message;", "<init>", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;)V", "getBotId", "()Ljava/lang/String;", "getMsg", "()Lcom/larus/im/bean/message/Message;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageWithBotId implements Serializable {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("msg_body")
    private final Message msg;

    public MessageWithBotId() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public final String getBotId() {
        return this.botId;
    }

    public final Message getMsg() {
        return this.msg;
    }

    public MessageWithBotId(String r1, Message r2) {
        this.botId = r1;
        this.msg = r2;
    }

    public /* synthetic */ MessageWithBotId(String r2, Message r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
