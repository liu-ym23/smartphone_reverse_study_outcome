package com.larus.bmhome.social.userchat.model;

import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 {
    public static boolean a;
    public static boolean b;

    static {
    }

    public static void a(boolean r1) {
        a = r1;
        if (r1 == false) goto L5;
        CompletableDeferred<Boolean> r0 = wr8.d.a;
        wr8.d.b.c("PreLoadHelper#isColdLandingToChatList");
    L5:
        if (r1 == true) goto L7;
        return;
    L7:
        if (b == false) goto L11;
        b(false);
        return;
    }

    public static void b(boolean r1) {
        b = r1;
        if (r1 == true) goto L5;
        CompletableDeferred<Boolean> r0 = wr8.d.a;
        wr8.d.b.c("PreLoadHelper, not landing to main");
    L5:
        if (r1 == true) goto L7;
        return;
    L7:
        if (a == false) goto L11;
        a(false);
        return;
    }
}
