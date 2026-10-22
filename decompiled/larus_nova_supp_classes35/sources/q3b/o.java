package q3b;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements hya.b<String> {
    public final String a;
    public final String b;

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public o(Message r2) {
        this.a = r2.getId();
        if (r2.isPreMessage() == false) goto L5;
        String r3 = null;
    L6:
        this.b = r3;
        return;
    L5:
        r3 = r2.getcId();
        goto L6
    }
}
