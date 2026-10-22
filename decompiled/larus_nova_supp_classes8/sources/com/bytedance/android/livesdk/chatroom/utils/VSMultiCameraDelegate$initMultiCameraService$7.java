package com.bytedance.android.livesdk.chatroom.utils;

import android.os.SystemClock;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.ContentDurationLogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.CameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSMultiCameraDelegate$initMultiCameraService$7 extends dq1.e {
    public final /* synthetic */ DataCenter a;
    public final /* synthetic */ RoomContext b;
    public final /* synthetic */ com.bytedance.android.livesdk.log.j c;
    public final /* synthetic */ ContentDurationLogger d;

    @Override // dq1.e
    public final void c() {
        final Room r0 = com.bytedance.android.live.core.utils.z.o(this.a);
        this.b.getLoggerHelper().c(new VSMultiCameraDelegate$initMultiCameraService$7$onCameraFirstFrame$1(this, r0));
        com.bytedance.android.livesdk.log.j r1 = this.c;
        if (r1 == null) goto L5;
        long r2 = SystemClock.elapsedRealtime();
        r1.a = r2;
        r1.c = true;
        r1.e = r2;
        com.bytedance.android.livesdk.log.j.g(r1, null, 0, 1);
    L5:
        dq1.a r3 = pm1.f.a();
        if (r3 == null) goto L15;
        VSCameraInfo r4 = r3.C4();
        if (r4 == null) goto L16;
        CameraMatchInfo r5 = r4.cameraMatchInfo;
        if (r5 == null) goto L17;
        long r6 = r5.getContentId();
        ContentDurationLogger r7 = this.d;
        if (r7 == null) goto L18;
        r7.b(r6);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public VSMultiCameraDelegate$initMultiCameraService$7(DataCenter r1, RoomContext r2, com.bytedance.android.livesdk.log.j r3, ContentDurationLogger r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
