package me;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {
    public static final List i1(b r8) {
        ArrayList r10 = new ArrayList();
        Iterator r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10.add(r11.next());
        goto L4
    L7:
        return l6.a.v0(r10);
    }
}
