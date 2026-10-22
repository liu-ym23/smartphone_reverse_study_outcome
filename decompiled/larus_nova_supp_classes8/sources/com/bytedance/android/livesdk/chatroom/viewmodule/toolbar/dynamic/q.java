package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q {
    public static final HashMap<String, String> a = null;
    public static boolean b;
    public static int c;

    static {
        a = new HashMap();
        c = -1;
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        int r0 = c;
        if (r0 == (-1)) goto L6;
        a.put(String.valueOf(r0), ToolbarReasonTag.COMPONENT.getTag() + r4);
        return;
    }

    public static String c(int r1) {
        String r2 = a.get(String.valueOf(r1));
        if (r2 != null) goto L6;
        r2 = "UnKnown";
    L6:
        if (b == true) goto L8;
        return r2;
    L8:
        return r2.concat(" after unload");
    }

    public static void a(int r3, ToolbarReasonTag r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "reason");
        String r6 = String.valueOf(r3);
        Intrinsics.checkNotNullParameter(r6, "id");
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "reason");
        a.put(r6, r4.getTag() + r5);
    }
}
