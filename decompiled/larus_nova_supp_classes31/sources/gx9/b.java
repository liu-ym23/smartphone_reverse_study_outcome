package gx9;

import com.larus.im.bean.message.Message;
import com.larus.platform.model.chat.i0;
import com.larus.platform.service.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final i0 a;
    public final gx9.a b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.a = z2.a.M0();
        this.b = new gx9.a();
    }

    public static String a(Message r4) {
        if (r4 != null) goto L6;
        return "(null)";
    L6:
        return "(" + r4.getMessageId() + '_' + r4.getLocalMessageId() + '_' + r4.getLocalIndex() + '_' + r4.getCreateTime() + ')';
    }
}
