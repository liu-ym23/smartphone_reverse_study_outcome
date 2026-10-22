package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof h) == true) goto L8;
        return false;
    L8:
        ((h) r4).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "MmRecordingNetworkMockScenario(id=null, matcher=null, responseDelayMs=0, responseProvider=null, afterActions=null)";
    }
}
