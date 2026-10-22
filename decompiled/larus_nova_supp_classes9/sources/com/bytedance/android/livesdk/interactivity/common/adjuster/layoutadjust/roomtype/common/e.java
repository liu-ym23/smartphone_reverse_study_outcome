package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements i {
    public static final e c = null;

    public e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "CommonAudienceWidthAdjust";
    }

    static {
        c = new e();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i
    public final k b(com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r2, Room r3, LiveRoomEnvStateHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "uiContext");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "roomStatus");
        return new k(-1, (int) (s1.y() * 0.4f), 2);
    }
}
