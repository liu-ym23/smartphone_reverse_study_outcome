package com.larus.bmhome.view.actionbar.custom.cache;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.z1;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final boolean b(b2 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        z1 r2 = r1.n;
        if (r2 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r2.b, Boolean.TRUE);
    }

    public static final boolean a(ArrayList<b2> r3, ModelItemIdentity r4, boolean r5) {
        b2 r0 = null;
        Object r1 = null;
        if (r3 == null) goto L11;
        Iterator<T> r6 = r3.iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Object r2 = r6.next();
        if (Intrinsics.areEqual(((b2) r2).b(), r4) == false) goto L6;
        r1 = r2;
    L10:
        r0 = (b2) r1;
    L11:
        if (r0 != null) goto L13;
    L21:
        return false;
    L13:
        if (b(r0) == true) goto L21;
        if (r5 == false) goto L20;
        Integer r7 = r0.l;
        int r8 = AgentMode.MOA.getValue();
        if (r7 == null) goto L21;
        if (r7.intValue() != r8) goto L21;
    L20:
        return true;
    }
}
