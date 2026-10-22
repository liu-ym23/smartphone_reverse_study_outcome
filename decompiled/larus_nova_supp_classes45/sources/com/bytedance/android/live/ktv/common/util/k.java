package com.bytedance.android.live.ktv.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public l a;
    public final ArrayList<v> b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Iterator<v> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        v r1 = r0.next();
        if (r1.b.getOneDrawCallback() != null) goto L4;
        r1.b.setOneDrawCallback(new ViewStatisticsWrapper$startWatchNextDraw$1(r1));
        goto L4
    }

    public k() {
        this.b = new ArrayList();
    }

    public final void b(c r5) {
        Intrinsics.checkNotNullParameter(r5, "viewStatistics");
        String r0 = r5.getTypeName();
        Iterator<v> r1 = this.b.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        v r2 = r1.next();
        if (Intrinsics.areEqual(r2.a, r0) == false) goto L4;
    L9:
        v r3 = r2;
        if (r3 == null) goto L12;
        this.b.remove(r3);
    L12:
        ArrayList<v> r4 = this.b;
        v r6 = new v(r0, r5, this);
        if (r6.b.getOneDrawCallback() != null) goto L16;
        r6.b.setOneDrawCallback(new ViewStatisticsWrapper$startWatchNextDraw$1(r6));
    L16:
        Unit r7 = Unit.INSTANCE;
        r4.add(r6);
        return;
    L8:
        r2 = null;
        goto L9
    }
}
