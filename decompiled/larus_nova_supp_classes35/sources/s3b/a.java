package s3b;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {
    public final AudioContent.AudioState a;

    public a(AudioContent.AudioState r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chatbase.model.c.b
    public final f5b.b b(Object r4) {
        f5b.b r5 = (f5b.b) r4;
        Message r0 = r5.getMessage();
        if (r0.getType() == Message.Type.AUDIO) goto L5;
    L10:
        return r5;
    L5:
        if (r0.getContent() == null) goto L10;
        if (this.a == null) goto L10;
        ((AudioContent) r0.getContent()).setFileState(this.a);
        goto L10
    }
}
