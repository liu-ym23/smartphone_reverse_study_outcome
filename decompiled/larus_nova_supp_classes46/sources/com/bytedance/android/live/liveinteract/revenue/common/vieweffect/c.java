package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import kotlin.jvm.internal.Intrinsics;
import nh0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final boolean a(m r3) {
        if (r3 == null) goto L17;
        String r1 = r3.h();
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        return true;
    L13:
        if (Intrinsics.areEqual(r3.h(), "undefined") == true) goto L19;
        return false;
    L19:
        return true;
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
        goto L11
    L17:
        return true;
    }
}
