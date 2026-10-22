package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w4 extends dq1.e {
    public final /* synthetic */ DataCenter a;
    public final /* synthetic */ RoomContext b;

    public w4(DataCenter r1, RoomContext r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // dq1.e
    public final void d(VSCameraInfo r6, VSCameraInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "targetCamera");
        int r8 = a5.a;
        DataCenter r9 = this.a;
        RoomContext r0 = this.b;
        com.bytedance.live.datacontext.m r1 = r0.getVsVerticalStream();
        if (nm1.v.a(r7) != 2) goto L5;
        boolean r2 = true;
    L6:
        r1.setValue(Boolean.valueOf(r2));
        if (r9 == null) goto L15;
        Room r3 = com.bytedance.android.live.core.utils.z.o(r9);
        if (r3 == null) goto L15;
        if (com.bytedance.android.live.core.utils.q2.b(r3) != true) goto L15;
        r0.getCameraId().setValue(Long.valueOf(r7.cameraId));
        nm1.m r10 = pm1.f.l();
        if (r10 == null) goto L17;
        r0.getCurrentMatchId().setValue(Long.valueOf(r10.f(r9)));
        return;
    L17:
        return;
    L15:
        r0.getCameraId().setValue(0L);
        return;
    L5:
        r2 = false;
        goto L6
    }
}
