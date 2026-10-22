package com.bytedance.android.live.room.api.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final e a(b r2, ActionType r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$getPanelInfo");
        Intrinsics.checkNotNullParameter(r3, "actionType");
        int r1 = e.e;
        Intrinsics.checkNotNullParameter(r2, "panelInfoProvider");
        Intrinsics.checkNotNullParameter(r3, "actionType");
        return new e(r2.getPanelName(), r2.getUnionId(), r3, r4);
    }
}
