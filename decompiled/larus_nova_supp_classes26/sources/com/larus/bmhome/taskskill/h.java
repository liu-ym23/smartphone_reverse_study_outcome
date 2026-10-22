package com.larus.bmhome.taskskill;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static bs8.h a(wc9.e r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.a;
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        bs8.a.C0004a r2 = bs8.a.h;
        if (r4 == null) goto L11;
        r0 = r4.r;
    L11:
        r2.getClass();
        bs8.a r5 = bs8.a.C0004a.a(r0);
        if (r5 == null) goto L16;
        boolean r3 = true;
        if (r5.c() != true) goto L16;
    L17:
        if (r3 == false) goto L20;
        FLogger.a.i("PcLocalConversationGate", "[getState] pc local hit, conversationId=" + r1 + ", runtimeType=" + r5.c);
    L20:
        return new bs8.h(r1, r5);
    L16:
        r3 = false;
        goto L17
    L5:
        r1 = null;
        goto L6
    }
}
