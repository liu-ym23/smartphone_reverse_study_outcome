package com.larus.voicecall.impl.ui;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Integer b(int r2, boolean r3) {
        int r0 = com.larus.voicecall.impl.notification.a.a;
        boolean r1 = com.larus.voicecall.impl.notification.a.c(AppHost.a.getApplication());
        if (r2 != 1) goto L5;
    L35:
        if (r1 == false) goto L37;
        int r4 = 2131241879;
    L39:
        return Integer.valueOf(r4);
    L37:
        r4 = 2131241880;
        goto L39
    L5:
        if (r2 != 2) goto L7;
    L27:
        if (r3 == false) goto L31;
        if (r1 == false) goto L30;
        int r5 = 2131241887;
    L43:
        return Integer.valueOf(r5);
    L30:
        r5 = 2131241888;
        goto L43
    L31:
        if (r1 == false) goto L33;
        r5 = 2131241885;
        goto L43
    L33:
        r5 = 2131241886;
        goto L43
    L7:
        if (r2 == 3) goto L27;
        if (r2 != 4) goto L11;
        if (r1 == false) goto L25;
        int r6 = 2131241899;
    L42:
        return Integer.valueOf(r6);
    L25:
        r6 = 2131241900;
        goto L42
    L11:
        if (r2 != 5) goto L13;
    L19:
        if (r1 == false) goto L21;
        int r7 = 2131241877;
    L41:
        return Integer.valueOf(r7);
    L21:
        r7 = 2131241878;
        goto L41
    L13:
        if (r2 == 7) goto L35;
        if (r2 == 9) goto L19;
        if (r2 == 18) goto L19;
        return null;
    }

    public static String a(Context r3, int r4, boolean r5) {
        if (r4 == 1) goto L38;
        int r2 = 2131908047;
        if (r4 != 2) goto L7;
        if (r3 == null) goto L40;
        if (r5 == true) goto L37;
        r2 = 2131898476;
    L37:
        String r6 = r3.getString(r2);
    L41:
        if (r6 != null) goto L44;
        return NameKeys.UnloadStrategy_No_Strategy;
    L44:
        return r6;
    L40:
        r6 = null;
        goto L41
    L7:
        if (r4 != 3) goto L9;
        if (r3 == null) goto L40;
        if (r5 == true) goto L32;
        r2 = 2131898446;
    L32:
        r6 = r3.getString(r2);
        goto L41
    L9:
        if (r4 != 4) goto L11;
        if (r3 == null) goto L40;
        r6 = r3.getString(2131910477);
        goto L41
    L11:
        if (r4 != 5) goto L13;
    L24:
        if (r3 == null) goto L40;
        r6 = r3.getString(2131908924);
        goto L41
    L13:
        if (r4 != 7) goto L15;
        if (r3 == null) goto L40;
        r6 = r3.getString(2131900516);
        goto L41
    L15:
        if (r4 == 9) goto L24;
        if (r4 == 18) goto L19;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L41
    L19:
        FlowRuntime.a().isOversea();
        if (r3 == null) goto L40;
        r6 = r3.getString(2131900509);
        goto L41
    L38:
        if (r3 == null) goto L40;
        r6 = r3.getString(2131898459);
        goto L41
    }
}
