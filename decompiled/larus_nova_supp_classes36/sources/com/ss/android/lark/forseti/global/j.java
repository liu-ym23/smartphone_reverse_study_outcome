package com.ss.android.lark.forseti.global;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public static final List<tua.c.a> a = null;

    static {
        a = new ArrayList();
    }

    public static void a(boolean r2) {
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((tua.c.a) r0.next()).a(r2);
        goto L4
    }
}
