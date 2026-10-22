package h5b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.sticker.StickerFileInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends MessageParams<b, a> {
    public final StickerFileInfo A;

    public static final class a extends MessageParams.a<b, a> {
        public StickerFileInfo A;

        @Override // com.ss.android.lark.chat.entity.message.MessageParams.a
        public final MessageParams a() {
            this.h = Message.Type.STICKER;
            return new b(this);
        }

        public a() {
        }
    }

    public b(a r1) {
        super(r1);
        this.A = r1.A;
    }

    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r2, String r3) {
        Message r4 = b(r2, r3);
        r4.setType(Message.Type.STICKER);
        StickerContent r5 = new StickerContent();
        r5.setKey(this.A.key);
        r5.setWidth(this.A.width);
        r5.setHeight(this.A.height);
        r5.setStickerSetId(this.A.stickerSetId);
        r5.setStickerId(this.A.stickerId);
        r4.setMessageContent(r5);
        return r4;
    }
}
