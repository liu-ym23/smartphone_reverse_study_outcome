package com.larus.dora.obric.device_management.device_home;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c3 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static d3 a(f3 r2, z2 r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof z2.b) == false) goto L6;
        return new d3(r2, new y2.a(((z2.b) r3).a));
    L6:
        if ((r3 instanceof z2.a) == false) goto L9;
        DoraObricGlassesMode r4 = ((z2.a) r3).a;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "selectedMode");
        return new d3(new f3(r4), null);
    L9:
        if (Intrinsics.areEqual(r3, z2.c.a) == false) goto L13;
        return new d3(r2, y2.b.a);
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
