package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LivePaidPlayerContainerWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.CameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z4 extends dq1.e {
    public final /* synthetic */ DataCenter a;
    public final /* synthetic */ RoomContext b;
    public final /* synthetic */ Function0 c;

    @Override // dq1.e
    public final void b(VSCameraInfo r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "targetCamera");
        int r0 = a5.a;
        DataCenter r1 = this.a;
        if (r1 == null) goto L48;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r1);
        if (r2 == null) goto L50;
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r3 != null) goto L11;
        return;
    L11:
        if (r2.getEpisodeComponentData() == null) goto L52;
        HashMap r4 = new HashMap();
        r4.put("vs_machine_id", String.valueOf(r9.cameraId));
        nm1.m r5 = pm1.f.l();
        if (r5 == null) goto L22;
        r4.put("vs_machine_type", r5.j(r9.cameraId, r2));
        VSCameraInfo r11 = r5.K(r1);
        if (r11 != null) goto L18;
    L20:
        String r12 = "0";
    L21:
        r4.put("is_paid_machine", r12);
        goto L22
    L18:
        if (r11.isPaidCamera() != true) goto L20;
        r12 = "1";
    L22:
        r3.putAll(r4);
        if (r10 == null) goto L25;
        Bundle r13 = r10.getBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1");
    L26:
        com.bytedance.android.livesdk.log.filter.o r14 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r14 == null) goto L49;
        HashMap r6 = new HashMap();
        if (r13 != null) goto L31;
    L33:
        r14.remove("is_game_data");
    L35:
        if (r13 != null) goto L37;
    L39:
        r14.remove("is_tag");
    L41:
        if (r13 != null) goto L43;
    L45:
        r14.remove("enter_from_game");
    L46:
        r14.putAll(r6);
        return;
    L43:
        if (r13.containsKey("enter_from_game") != true) goto L45;
        r6.put("enter_from_game", r13.getString("enter_from_game"));
        goto L46
    L37:
        if (r13.containsKey("is_tag") != true) goto L39;
        r6.put("is_tag", r13.getString("is_tag"));
        goto L41
    L31:
        if (r13.containsKey("is_game_data") != true) goto L33;
        r6.put("is_game_data", r13.getString("is_game_data"));
        goto L35
    L49:
        return;
    L25:
        r13 = null;
        goto L26
    L52:
        return;
    L50:
        return;
    }

    @Override // dq1.e
    public final void d(VSCameraInfo r6, VSCameraInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "targetCamera");
        int r0 = a5.a;
        long r1 = ((Number) this.b.getContentId().getValue()).longValue();
        CameraMatchInfo r8 = r7.cameraMatchInfo;
        if (r8 == null) goto L5;
        long r2 = r8.getContentId();
    L6:
        com.bytedance.android.livesdk.log.filter.o r9 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r2 == r1) goto L12;
        if (r9 == null) goto L12;
        Map r10 = r9.getMap();
        if (r10 == null) goto L12;
        String r11 = (String) r10.put("vs_content_id", String.valueOf(r2));
    L12:
        if (r6 == null) goto L16;
    L16:
        return;
    L5:
        r2 = r1;
        goto L6
    }

    public z4(DataCenter r1, RoomContext r2, fk1.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // dq1.e
    public final void a(VSCameraInfo r1, VSCameraInfo r2, Bundle r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "targetCamera");
        LivePaidPlayerContainerWidget r6 = (LivePaidPlayerContainerWidget) this.c.invoke();
        if (r6 == null) goto L6;
        r6.zq();
        return;
    }
}
