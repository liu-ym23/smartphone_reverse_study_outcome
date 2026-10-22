package sg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    public final boolean c(t1a.b r1, Message r2, q0 r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        List r4 = com.larus.im.bean.message.a.G(r2);
        if (com.larus.bmhome.chat.bean.d.I0(r2) == false) goto L5;
    L9:
        return false;
    L5:
        if ((!r4.isEmpty()) == false) goto L7;
        return true;
    L7:
        if (com.larus.im.bean.message.a.f0(r2) == false) goto L9;
        return true;
    }
}
