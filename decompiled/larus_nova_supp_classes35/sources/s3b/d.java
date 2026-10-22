package s3b;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends com.ss.android.lark.chatbase.model.c.b<f5b.b> {
    public final Message a;

    public d(Message r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chatbase.model.c.b
    public final f5b.b b(Object r2) {
        f5b.b r3 = (f5b.b) r2;
        r3.setMessage(this.a);
        return r3;
    }
}
