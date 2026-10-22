package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.model.PcDevice;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m2 {
    public static final boolean a(PcDevice r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List<Integer> r5 = r4.q();
        if (r5 != null) goto L5;
        return false;
    L5:
        List<Integer> r1 = l2.a;
        com.larus.platform.service.p1 r2 = com.larus.platform.service.p1.a;
        List<Integer> r3 = l2.a;
        if ((r3 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r6 = r3.iterator();
    L12:
        if (r6.hasNext() == false) goto L21;
        if ((!r5.contains(Integer.valueOf(((Number) r6.next()).intValue()))) == false) goto L12;
        return true;
    L21:
        return false;
    L8:
        if (r3.isEmpty() == false) goto L10;
        return false;
    }
}
