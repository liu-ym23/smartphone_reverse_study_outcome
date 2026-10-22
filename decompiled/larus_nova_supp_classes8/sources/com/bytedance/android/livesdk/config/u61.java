package com.bytedance.android.livesdk.config;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u61 {
    public static final boolean a(t61 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$enableLinkedPanelOpt");
        if (r1.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.m5() == false) goto L7;
        return true;
    }

    public static final boolean b(t61 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$enableOrderSongPanelOpt");
        if (r1.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.z6() == false) goto L7;
        return true;
    }

    public static final boolean c(t61 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$linkedPanelMemoryLeakFix");
        if (r1.getTotalSwitch() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.O3() == false) goto L7;
        return true;
    }
}
