package fg8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final boolean a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (com.larus.bmhome.chat.bean.d.f0(r2.f) == true) goto L14;
        String r3 = com.larus.im.bean.message.a.K(r2.f);
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        return true;
    L7:
        if (r3.length() == 0) goto L10;
        r4 = false;
    L14:
        return false;
    }
}
