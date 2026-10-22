package com.bytedance.bpea.entry.common;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static final CopyOnWriteArraySet<b> a = null;

    static {
        a = new CopyOnWriteArraySet();
    }

    public static void a(qc4.c r5, Function2 r6) {
        b.a r7 = new b.a("invokeEndSuccess");
        Iterator<b> r0 = a.iterator();
        String r1 = "";
    L3:
        int r2 = 0;
        boolean r3 = false;
    L5:
        if (r0.hasNext() == false) goto L13;
        r7 = r0.next().b();
        if (r7.a() == false) goto L9;
        r1 = r1 + '_' + r7.b;
    L9:
        if (r3 == true) goto L12;
        if (r7.a() == false) goto L3;
    L12:
        r3 = true;
        goto L5
    L13:
        if (r3 == true) goto L15;
        return;
    L15:
        if (r7.a() == true) goto L18;
        r2 = -1;
    L18:
        r6.invoke(Integer.valueOf(r2), r1);
    }
}
