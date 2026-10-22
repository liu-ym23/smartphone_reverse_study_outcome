package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t implements am3.c<Appointment.LiveFragments> {
    public t() {
    }

    public static Appointment.LiveFragments a(am3.g r6) throws Exception {
        Appointment.LiveFragments r0 = new Appointment.LiveFragments();
        r0.extractItemIds = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.extractItemIds.add(Long.valueOf(r6.j()));
        goto L3
    L7:
        am3.h.e(r6);
        goto L3
    L9:
        r6.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
