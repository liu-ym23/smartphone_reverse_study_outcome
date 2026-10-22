package com.ss.android.lark.coremd.ext;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l {
    public static final void a(com.ss.android.lark.coremd.impl.parse.b.a r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == null) goto L8;
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        r1.b((com.ss.android.lark.coremd.base.parse.f) r3.next());
        goto L6
    L10:
        return;
    }

    public static final void b(com.ss.android.lark.coremd.impl.parse.b.a r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "plugins");
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r1.e((com.ss.android.lark.coremd.base.parse.g) r3.next());
        goto L4
    }
}
