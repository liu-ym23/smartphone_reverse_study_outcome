package com.obric.assistant.settings.autogui;

import com.obric.assistant.spi.task.ObricTaskSkillDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static k a() {
        com.obric.assistant.e r0 = com.obric.assistant.e.a;
        String r1 = ObricTaskSkillDelegate.b.i();
        r0.getClass();
        com.obric.assistant.e.a r2 = com.obric.assistant.e.a(r1);
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.a;
    L6:
        String r5 = "";
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        if (r2 == null) goto L11;
        r3 = r2.b;
    L11:
        if (r3 == null) goto L15;
        r5 = r3;
    L15:
        return new k(r4, r5);
    L5:
        r4 = null;
        goto L6
    }
}
