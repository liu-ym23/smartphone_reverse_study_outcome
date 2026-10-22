package com.bytedance.android.live.room.api.messagewindow.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j {
    public final boolean a;
    public final double b;
    public final a c;

    public interface a {
        h a();
    }

    public j(fm0.a.a r7) {
        Intrinsics.checkNotNullParameter(r7, "cb");
        this.c = r7;
        int r8 = v71.a.a;
        m71.c r9 = m71.c.a;
        n71.b r0 = (n71.b) r9.getValue();
        boolean r1 = false;
        if (r0 == null) goto L7;
        Boolean r2 = r0.h();
        if (r2 == null) goto L7;
        boolean r3 = r2.booleanValue();
    L8:
        this.a = r3;
        n71.b r10 = (n71.b) r9.getValue();
        if (r10 == null) goto L18;
        Double r12 = Double.valueOf(r10.i());
        if (r12.doubleValue() <= 0.0f) goto L13;
        r1 = true;
    L13:
        if (r1 == true) goto L16;
        r12 = null;
    L16:
        if (r12 == null) goto L18;
        double r4 = r12.doubleValue();
    L19:
        this.b = r4;
        return;
    L18:
        r4 = 1.0E-5d;
    L7:
        r3 = false;
        goto L8
    }
}
