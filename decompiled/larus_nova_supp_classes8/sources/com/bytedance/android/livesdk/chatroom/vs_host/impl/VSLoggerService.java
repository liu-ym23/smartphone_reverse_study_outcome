package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.status.api.IAggregateService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.BaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomNode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSLoggerService implements com.bytedance.android.scope.o, vr1.o {
    public VSLoggerService() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.o
    public final JSONObject getPlayerStatsLog() {
        IAggregateService r0 = jc1.k.f(IAggregateService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPlayerStatsLog();
    }

    @Override // vr1.o
    public final void c(DataCenter r6) {
        final String r1 = "livesdk_screen_shot_icon_show";
        Intrinsics.checkNotNullParameter("livesdk_screen_shot_icon_show", "eventName");
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        if (r7 == null) goto L8;
        com.bytedance.live.datacontext.j r8 = r7.getLoggerHelper();
        if (r8 == null) goto L9;
        r8.c(new VSLoggerService$sendOnceWithScreenOrientation$1(r1));
        return;
    L9:
        return;
    }

    @Override // vr1.o
    public final Map<String, String> f(VSLinkedRoomNode r10) {
        Intrinsics.checkNotNullParameter(r10, "roomNode");
        String r8 = null;
        LiveVSLog r0 = new LiveVSLog(null, null, null, null, 0, 8191);
        Episode r1 = r10.getEpisodeExtra();
        if (r1 == null) goto L5;
        Long r2 = Long.valueOf(r1.getId());
    L6:
        String r3 = String.valueOf(r2);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.e = r3;
        Episode r4 = r10.getEpisodeExtra();
        if (r4 == null) goto L9;
        r8 = r4.itemId;
    L9:
        String r5 = String.valueOf(r8);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.c = r5;
        Episode r6 = r10.getEpisodeExtra();
        int r7 = 0;
        if (r6 == null) goto L14;
        EpisodeMod r9 = r6.episodeMod;
        if (r9 == null) goto L14;
        int r11 = ((BaseEpisodeMod) r9).episodeStage;
    L15:
        r0.i = r11;
        Episode r12 = r10.getEpisodeExtra();
        if (r12 == null) goto L20;
        String r13 = r12.seasonId;
        if (r13 == null) goto L20;
    L21:
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r0.f = r13;
        Episode r14 = r10.getEpisodeExtra();
        if (r14 == null) goto L24;
        r7 = r14.style;
    L24:
        r0.k = r7;
        return r0.a();
    L20:
        r13 = "";
    L14:
        r11 = 0;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    @Override // vr1.o
    public final Map<String, String> g(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Room r3 = (Room) r2.get("data_room");
        if (r3 == null) goto L5;
        LiveVSLog.r.getClass();
        return LiveVSLog.b.a(r3).a();
    L5:
        return new LinkedHashMap();
    }

    @Override // vr1.o
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> h(DataCenter r5) {
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r6 != null) goto L7;
        return null;
    L7:
        return r6.getLoggerHelper();
    }

    @Override // vr1.o
    public final boolean i(Object r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1 instanceof n0;
    }

    @Override // vr1.o
    public final com.bytedance.android.livesdk.log.filter.o j(Class r2) {
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.u.l().c(r2);
        if ((r3 instanceof com.bytedance.android.livesdk.log.filter.o) == true) goto L6;
        return null;
    L6:
        return r3;
    }

    @Override // vr1.o
    public final Map<String, String> k(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        int r0 = ju2.f.M;
        return ju2.f.a.a(r2).b();
    }

    @Override // vr1.o
    public final String a(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if ((r2 instanceof com.bytedance.android.livesdk.log.filter.a) == true) goto L5;
        return "";
    L5:
        if (com.ss.ugc.effectplatform.util.r.b(r3) == false) goto L7;
        return "";
    L7:
        return (String) ((com.bytedance.android.livesdk.log.filter.a) r2).b.get(r3);
    }

    @Override // vr1.o
    public final void d(Class<?> r2, Map<String, String> r3) {
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.log.filter.o r4 = com.bytedance.android.livesdk.log.u.l().c(r2);
        if (r4 == null) goto L10;
        Map r5 = r4.getMap();
        if (r5 == null) goto L11;
        r5.putAll(r3);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // vr1.o
    public final boolean o(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if ((r2 instanceof com.bytedance.android.livesdk.log.filter.a) == true) goto L5;
        return false;
    L5:
        if (com.ss.ugc.effectplatform.util.r.b(r3) == false) goto L7;
        return false;
    L7:
        return ((com.bytedance.android.livesdk.log.filter.a) r2).b.containsKey(r3);
    }

    @Override // vr1.o
    public final void n(DataCenter r5, final String r6, final Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r8 == null) goto L8;
        com.bytedance.live.datacontext.j r9 = r8.getLoggerHelper();
        if (r9 == null) goto L9;
        r9.c(new VSLoggerService$sendOnceWithScreenOrientation$2(r6, r7));
        return;
    L9:
        return;
    }

    @Override // vr1.o
    public final void q(DataCenter r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        com.bytedance.android.livesdk.vs.f.a(r2).c(r3, r4, new Object[0]);
    }

    @Override // vr1.o
    public final void sendLog(String r3, Map<String, String> r4, Object... r5) {
        Intrinsics.checkNotNullParameter(r5, "args");
        com.bytedance.android.livesdk.log.u.l().sendLog(r3, r4, Arrays.copyOf(r5, r5.length));
    }

    @Override // vr1.o
    public final void w(DataCenter r3, final int r4, final long r5) {
        if (r3 == null) goto L4;
        Room r0 = com.bytedance.android.live.core.utils.z.o(r3);
    L5:
        com.bytedance.android.livesdk.castscreen.utils.f.b("landscape_room_interaction_show", r3, r0, new VSLoggerService$landscapeInteractionShowLog$1(r4, r5));
        return;
    L4:
        r0 = null;
        goto L5
    }

    @Override // vr1.o
    public final void s(String r4, Map<String, String> r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "eventBelong");
        Intrinsics.checkNotNullParameter(r7, "eventType");
        Intrinsics.checkNotNullParameter(r8, "eventPage");
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        am2.x r2 = new am2.x();
        r2.a = r6;
        r2.e = r7;
        r2.b = r8;
        r0.h(r4, r5, new Object[]{r2, Room.class});
    }
}
