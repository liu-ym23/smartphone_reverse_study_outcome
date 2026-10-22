package com.bytedance.android.live.revlink.impl.control.launchcontext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements sc0.d {
    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof d) == false) goto L14;
        ((d) r2).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r1 = (int) 0;
        return (((((((((((((((((r1 * 31) + 0) * 31) + 0) * 31) + r1) * 31) + 0) * 31) + r1) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + r1;
    }

    public final String toString() {
        return "PkAudienceLaunchContext(channelID=0, guestUid=null, loadType=null, pkId=0, duration=0, startTimeMs=0, matchType=0, openBattleMessage=null, rawSei=null, startLoadBeginTimeMs=0)";
    }
}
