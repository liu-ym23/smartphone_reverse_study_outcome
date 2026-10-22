package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final FirstLevelTab a(int r6) {
        FirstLevelTab[] r0 = FirstLevelTab.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        FirstLevelTab r4 = r0[r3];
        if (r4.getValue() != r6) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L12;
        r3 = r3 + 1;
    L12:
        if (r4 == null) goto L14;
        return r4;
    L14:
        return FirstLevelTab.Unknown;
    L7:
        r5 = false;
        goto L8
    L11:
        r4 = null;
        goto L12
    }

    public static final String b(FirstLevelTab r1) {
        Intrinsics.checkNotNullParameter(r1, "firstLevelTab");
        int r2 = r1.getValue();
        if (r2 != FirstLevelTab.MySongTab.getValue()) goto L6;
        return "mine";
    L6:
        if (r2 != FirstLevelTab.OrderedSongTab.getValue()) goto L9;
        return "order";
    L9:
        if (r2 != FirstLevelTab.OrderSongTab.getValue()) goto L12;
        return "request";
    L12:
        if (r2 != FirstLevelTab.WantListenTab.getValue()) goto L15;
        return "listen";
    L15:
        if (r2 != FirstLevelTab.AudienceSingTab.getValue()) goto L18;
        return "user_order";
    L18:
        if (r2 != FirstLevelTab.PersonalKaraokeSungTab.getValue()) goto L20;
        return "history";
    L20:
        return "";
    }
}
