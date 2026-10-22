package x4;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final ConcurrentHashMap<String, String> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        return a.get(r1);
    L5:
        r0 = false;
        goto L6
    }
}
