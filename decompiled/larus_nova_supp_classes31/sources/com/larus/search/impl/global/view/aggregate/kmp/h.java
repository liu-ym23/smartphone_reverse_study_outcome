package com.larus.search.impl.global.view.aggregate.kmp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h {
    public static final boolean a(String r4) {
        if (StringsKt.contains$default(r4, "豆包号", false, 2, null) == false) goto L5;
    L8:
        return true;
    L5:
        if (StringsKt.contains$default(r4, "豆包帳號", false, 2, null) == true) goto L8;
        if (StringsKt.contains$default(r4, "User ID", false, 2, null) == true) goto L8;
        return false;
    }

    public static final String b(String r12) {
        String r0 = StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(r12, "<h>", "", false, 4, null), "</h>", "", false, 4, null)).toString();
        boolean r8 = false;
        if (a(r12) == false) goto L18;
        List r13 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(StringsKt.indexOf$default(r0, ':', 0, false, 6, null)), Integer.valueOf(StringsKt.indexOf$default(r0, 65306, 0, false, 6, null))});
        ArrayList r2 = new ArrayList();
        Iterator r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L13;
        Object r3 = r14.next();
        if (((Number) r3).intValue() < 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
        r2.add(r3);
        goto L6
    L10:
        r4 = false;
        goto L11
    L13:
        Integer r15 = (Integer) CollectionsKt.minOrNull(r2);
        if (r15 == null) goto L16;
        r0 = r0.substring(r15.intValue() + 1);
    L16:
        r0 = StringsKt.trim(r0).toString();
    L18:
        if (StringsKt.isBlank(r0) == false) goto L20;
    L25:
        if (r8 == false) goto L28;
        return r0;
    L28:
        return null;
    L20:
        if (StringsKt.contains$default(r0, '@', false, 2, null) == true) goto L25;
        if (StringsKt.contains$default(r0, ' ', false, 2, null) == true) goto L25;
        r8 = new Regex("^[A-Za-z0-9][A-Za-z0-9_.-]{0,63}$").matches(r0);
        goto L25
    }
}
