package com.larus.bmhome.chat.mode;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.b2;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(ModelItemIdentity r3, List r4, String r5) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r4 == null) goto L16;
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Object r1 = r6.next();
        if (Intrinsics.areEqual(((b2) r1).b(), r3) == false) goto L8;
    L13:
        b2 r2 = (b2) r1;
        if (r2 == null) goto L16;
        List<String> r7 = r2.q;
    L17:
        List<String> r8 = r7;
        if (r8 != null) goto L20;
    L23:
        boolean r9 = true;
    L24:
        if (r9 == false) goto L26;
        return null;
    L26:
        if (r5 == null) goto L31;
        if (r7.contains(r5) == false) goto L31;
        return null;
    L31:
        return (String) CollectionsKt.firstOrNull(r7);
    L20:
        if (r8.isEmpty() == true) goto L23;
        r9 = false;
        goto L24
    L12:
        r1 = null;
    L16:
        r7 = null;
        goto L17
    }
}
