package com.larus.reach.impl;

import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final boolean a(ns9.t r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getType() != ReachType.BANNER) goto L13;
        ReachRequestSource r3 = r2.a.f;
        if (r3 != ReachRequestSource.SERVER_CMD) goto L7;
    L12:
        return true;
    L7:
        if (r3 == ReachRequestSource.INAPP_PUSH_PULL) goto L12;
        if (r3 == ReachRequestSource.CLIENT_BRIDGE) goto L12;
        if (r3 == ReachRequestSource.LOCAL_SUBMIT) goto L12;
    L13:
        return false;
    }
}
