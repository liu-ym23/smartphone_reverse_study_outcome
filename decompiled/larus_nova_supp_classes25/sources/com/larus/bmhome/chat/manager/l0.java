package com.larus.bmhome.chat.manager;

import com.larus.platform.model.HoverActionConfig;
import com.larus.platform.service.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Integer r4) {
        if (r4 == null) goto L18;
        r4.intValue();
        HoverActionConfig r1 = z2.a.r();
        int r5 = r4.intValue();
        if (r5 == 0) goto L12;
        if (r5 != 1) goto L8;
        boolean r6 = r1.getSupportMainBot();
    L13:
        if (r6 == true) goto L15;
        return false;
    L15:
        if (r1.getShowQuoteOnAction() == false) goto L20;
        return true;
    L20:
        return false;
    L8:
        if (r5 == 2) goto L10;
        r6 = false;
        goto L13
    L10:
        r6 = r1.getSupportOfficialBot();
        goto L13
    L12:
        r6 = r1.getSupportUserBot();
        goto L13
    L18:
        return false;
    }
}
