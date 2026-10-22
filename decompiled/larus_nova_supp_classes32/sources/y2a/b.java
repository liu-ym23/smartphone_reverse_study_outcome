package y2a;

import com.larus.utils.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final String b(boolean r0) {
        if (r0 == false) goto L4;
        return "True";
    L4:
        return "False";
    }

    public static final String a(String r1) {
        if (o0.d(r1) == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L9;
        return "unknown";
    L9:
        return r1;
    }
}
