package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements i {
    public static final f c = null;

    public f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadOptCommonWidthAdjustStrategy";
    }

    static {
        c = new f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i
    public final k b(com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r2, Room r3, LiveRoomEnvStateHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "uiContext");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "roomStatus");
        if (e5.n() == false) goto L5;
        float r5 = s1.y();
        float r6 = 0.4f;
    L7:
        return new k((int) (r5 * r6), 0, 6);
    L5:
        r5 = s1.y();
        r6 = 0.6f;
        goto L7
    }
}
