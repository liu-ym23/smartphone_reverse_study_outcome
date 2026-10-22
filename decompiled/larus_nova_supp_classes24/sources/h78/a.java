package h78;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final List<b> a = null;
    public static final List<b> b = null;

    static {
        ArrayList r0 = new ArrayList();
        a = r0;
        ArrayList r1 = new ArrayList();
        b = r1;
        t r3 = h.m;
        if (r3 == null) goto L8;
        o58.a r4 = r3.a();
        if (r4 == null) goto L8;
        List<String> r5 = r4.b;
        if (r5 == null) goto L8;
    L9:
        c r2 = new c(r5);
        Intrinsics.checkNotNullParameter(r2, "rule");
        r1.add(r2);
        t r6 = h.m;
        if (r6 == null) goto L15;
        o58.a r7 = r6.a();
        if (r7 == null) goto L15;
        List<String> r8 = r7.a;
        if (r8 == null) goto L15;
    L16:
        d r9 = new d(r8);
        Intrinsics.checkNotNullParameter(r9, "rule");
        r0.add(r9);
        return;
    L15:
        r8 = CollectionsKt.emptyList();
    L8:
        r5 = CollectionsKt.emptyList();
        goto L9
    }
}
