package com.larus.bmhome.resource.access;

import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class s {
    public static final StateFlowImpl a = null;

    static {
        a = j1.a(MapsKt.emptyMap());
    }

    public static final boolean a(ResourceInputType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1 != ResourceInputType.TOS_KEY) goto L5;
    L8:
        return true;
    L5:
        if (r1 == ResourceInputType.REMOTE_URL) goto L8;
        return false;
    }

    public static final boolean b(a0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof a0.d) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r1 instanceof a0.c) == true) goto L10;
        if ((r1 instanceof a0.a) == true) goto L10;
        return false;
    }

    public static final mr9.l c(f0 r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        mr9.l r0 = r10.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = r10.c;
        boolean r2 = true;
        if (r1 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L23;
        String r4 = r10.d;
        if (r4 != null) goto L16;
    L19:
        if (r2 == false) goto L23;
        return null;
    L16:
        if (r4.length() == 0) goto L19;
        r2 = false;
    L23:
        return new mr9.l(r10.c, null, r10.d, null, null, false, null, 122);
    L8:
        if (r1.length() == 0) goto L11;
        r3 = false;
        goto L12
    }
}
