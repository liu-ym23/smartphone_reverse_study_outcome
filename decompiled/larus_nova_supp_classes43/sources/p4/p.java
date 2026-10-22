package p4;

import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/GetMessageInfoByCardIdResponse;", "Lcom/bytedance/ai/bridge/remote/model/BaseApiResponse;", "messageId", "", "conversationId", "botId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMessageId", "()Ljava/lang/String;", "getConversationId", "getBotId", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p extends a {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName(ConversationConstants.KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("message_id")
    private final String messageId;

    public p() {
        super(0);
        this.messageId = null;
        this.conversationId = null;
        this.botId = null;
    }

    @Override // p4.a
    public final String toString() {
        return "GetMessageInfoByCardIdResponse(" + super.toString() + ", messageId=" + this.messageId + ", conversationId=" + this.conversationId + ", botId=" + this.botId + ')';
    }

    public final String e() {
        return this.conversationId;
    }

    public final String f() {
        return this.messageId;
    }
}
