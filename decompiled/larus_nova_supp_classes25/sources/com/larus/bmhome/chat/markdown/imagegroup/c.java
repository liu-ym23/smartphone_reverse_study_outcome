package com.larus.bmhome.chat.markdown.imagegroup;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final CopyOnWriteArraySet<String> a = null;

    static {
        a = new CopyOnWriteArraySet();
    }

    public static boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "forceRefreshId");
        CopyOnWriteArraySet<String> r0 = a;
        if ((!r0.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r3) == false) goto L7;
        return true;
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "forceRefreshId");
        a.add(r1);
    }
}
