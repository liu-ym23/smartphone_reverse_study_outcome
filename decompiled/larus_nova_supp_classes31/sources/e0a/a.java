package e0a;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final boolean a(Map<String, ? extends Object> r2) {
        Integer r0 = null;
        if (r2 == null) goto L5;
        Object r3 = r2.get("is_in_lottery_state");
    L7:
        if ((r3 instanceof Integer) == false) goto L9;
        r0 = (Integer) r3;
    L9:
        if (r0 != null) goto L12;
    L14:
        return false;
    L12:
        if (r0.intValue() != 1) goto L14;
        return true;
    L5:
        r3 = null;
        goto L7
    }
}
