package com.obric.aikernel.res.metadata.data;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final boolean a(boolean r10, boolean r11, boolean r12) {
        if (r10 == false) goto L6;
        if (r11 == false) goto L6;
        if (r12 == true) goto L6;
        return true;
    L6:
        return false;
    }

    public static final boolean b(boolean r10, boolean r11, Collection<Boolean> r12) {
        Intrinsics.checkNotNullParameter(r12, "dependencyAvailableStates");
        if (r10 == false) goto L20;
        if (r11 == false) goto L6;
        return false;
    L6:
        if (r12.isEmpty() == false) goto L8;
    L7:
        boolean r13 = true;
    L14:
        if (r13 == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        Iterator<T> r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L7;
        if (((Boolean) r14.next()).booleanValue() == true) goto L10;
        r13 = false;
        goto L14
    L20:
        return false;
    }
}
