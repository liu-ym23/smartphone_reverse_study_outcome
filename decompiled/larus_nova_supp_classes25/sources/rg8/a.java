package rg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements tg8.b {
    public a() {
    }

    public final boolean c(t1a.b r1, Message r2, q0 r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (com.larus.bmhome.chat.bean.d.x0(r2) == true) goto L6;
        return false;
    L6:
        return true;
    }
}
