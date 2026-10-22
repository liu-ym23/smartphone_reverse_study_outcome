package com.obric.assistant.state.multitask.ext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g {
    public g() {
    }

    public static String a(g r9, String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "parts");
        Intrinsics.checkNotNullParameter("#", "separator");
        List r11 = ArraysKt.filterNotNull(r10);
        ArrayList r0 = new ArrayList();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        if (((String) r13).length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.add(r13);
        goto L4
    L8:
        r2 = false;
        goto L9
    L12:
        return CollectionsKt.joinToString$default(r0, "#", null, null, 0, null, null, 62, null);
    }
}
