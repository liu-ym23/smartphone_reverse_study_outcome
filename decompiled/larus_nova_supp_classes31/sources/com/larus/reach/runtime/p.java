package com.larus.reach.runtime;

import com.larus.platform.service.z2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean b(int r4) {
        if (1 > r4) goto L19;
        Integer r2 = z2.a.getReachConfig().d();
        if (r2 != null) goto L7;
    L15:
        int r3 = 100;
    L16:
        if (r4 > r3) goto L20;
        return true;
    L20:
        return false;
    L7:
        if (r2.intValue() <= 1) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        r3 = r2.intValue();
        goto L16
    L9:
        r5 = false;
        goto L10
    L19:
        return false;
    }

    public static boolean a(List r4, String r5) {
        if (r5 == null) goto L37;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 != null) goto L7;
        return false;
    L7:
        if (r6.length() <= 0) goto L9;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r6 = null;
    L14:
        if (r6 == null) goto L39;
        if (r4 != null) goto L18;
        r4 = CollectionsKt.emptyList();
    L18:
        List r7 = r4;
        if ((r7 instanceof Collection) == true) goto L21;
    L23:
        Iterator r8 = r7.iterator();
    L25:
        if (r8.hasNext() == false) goto L41;
        String r2 = (String) r8.next();
        if (r2 == null) goto L29;
        String r3 = StringsKt.trim(r2).toString();
    L31:
        if (Intrinsics.areEqual(r3, r6) == false) goto L25;
        return true;
    L29:
        r3 = null;
        goto L31
    L41:
        return false;
    L21:
        if (r7.isEmpty() == false) goto L23;
        return false;
    L39:
        return false;
    L9:
        r1 = false;
        goto L11
    L37:
        return false;
    }
}
