package mg8;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lg8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements tg8.b {
    public f() {
    }

    public final boolean c(t1a.b r3, Message r4, q0 r5) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r4, "data");
        if (com.larus.bmhome.chat.bean.d.I0(r4) == false) goto L5;
    L20:
        boolean r6 = true;
    L22:
        return !r6;
    L5:
        if (r4.getMessageStatusLocal() != 21) goto L20;
        if (com.larus.bmhome.chat.bean.d.Q0(r4) == true) goto L20;
        if (h.b(r5, r4) == false) goto L20;
        Map r7 = r4.getExt();
        if (r7 == null) goto L13;
        String r8 = (String) r7.get("need_auth_identity");
    L15:
        if (Intrinsics.areEqual(r8, "1") == false) goto L20;
        if (h.a(r5, r4) == false) goto L20;
        r6 = false;
        goto L22
    L13:
        r8 = null;
        goto L15
    }
}
