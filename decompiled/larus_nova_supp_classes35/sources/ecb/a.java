package ecb;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends MessageParams<a, Object> {
    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r1, String r2) {
        Message r3 = b(r1, r2);
        r3.setType(Message.Type.CARD);
        r3.setMessageContent(null);
        return r3;
    }
}
