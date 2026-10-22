package com.larus.bmhome.chat.nestedmenu.ui;

import com.larus.bmhome.taskskill.model.PcDevice;
import di8.d0;
import di8.f0;
import di8.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v {
    public static final PcDevice a(d0 r2) {
        f0 r3 = r2.c();
        if ((r3 instanceof p0) == false) goto L5;
        p0 r4 = (p0) r3;
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.c;
    L5:
        r4 = null;
        goto L6
    }
}
