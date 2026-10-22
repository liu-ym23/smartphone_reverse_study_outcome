package md8;

import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final CollectFrom a;
    public final Message b;
    public final String c;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("from:");
        r0.append(this.a);
        r0.append(",msg:");
        Message r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.getMessageId();
    L6:
        r0.append(r2);
        r0.append(",collectId:");
        r0.append(this.c);
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public a(CollectFrom r1, Message r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
