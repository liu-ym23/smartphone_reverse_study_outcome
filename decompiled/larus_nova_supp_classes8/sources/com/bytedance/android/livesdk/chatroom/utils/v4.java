package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v4 implements dq1.f {
    public final /* synthetic */ DataCenter a;

    public v4(DataCenter r1) {
        this.a = r1;
    }

    @Override // dq1.f
    public final boolean a(VSCameraInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "targetCamera");
        int r4 = a5.a;
        DataCenter r5 = this.a;
        if (r5 == null) goto L5;
        Boolean r6 = (Boolean) r5.get("data_broadcast_pause_state_new", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L10;
        com.bytedance.android.live.core.utils.f2.c("主播暂时离开，暂时无法切换", 0);
        return true;
    L10:
        return false;
    L5:
        r6 = null;
        goto L7
    }
}
