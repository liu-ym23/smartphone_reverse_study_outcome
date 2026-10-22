package eg8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final boolean a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (com.larus.bmhome.chat.bean.d.f0(r2.f) == false) goto L5;
    L16:
        return false;
    L5:
        if (com.larus.bmhome.chat.bean.d.Q0(r2.f) == true) goto L16;
        String r3 = com.larus.im.bean.message.a.K(r2.f);
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        return true;
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
        goto L13
    }
}
