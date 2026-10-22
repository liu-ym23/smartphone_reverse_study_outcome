package lg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g implements tg8.b {
    public g() {
    }

    public final boolean c(t1a.b r1, Message r2, q0 r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        boolean r4 = h.b(r3, r2);
        boolean r5 = hc8.c.a.j(r2);
        if (r4 == false) goto L8;
        if (r5 == false) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }
}
