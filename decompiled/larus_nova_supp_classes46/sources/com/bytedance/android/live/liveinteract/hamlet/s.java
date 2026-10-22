package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.base.model.message.i3;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.model.x0;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.TaskMixerConfig;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;
    public final /* synthetic */ long b;
    public final /* synthetic */ i3 c;

    public s(HamletAvatarWidget r1, long r2, i3 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r26) {
        com.bytedance.android.live.network.response.e r1 = (com.bytedance.android.live.network.response.e) r26;
        af0.a r2 = af0.a.a;
        long r3 = this.b;
        r2.getClass();
        long r5 = System.currentTimeMillis() - r3;
        LinkMonitorData r4 = LinkMonitorData.HamletAvatarCameraCreateSuccess;     // Catch: Exception -> L5
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L5
        r6.put("duration", r5);     // Catch: Exception -> L5
        Unit r7 = Unit.INSTANCE;     // Catch: Exception -> L5
        af0.a.l(r4, r6);     // Catch: Exception -> L5
    L6:
        ff0.d r8 = ff0.d.a;
        Pair[] r9 = new Pair[7];
        r9[0] = TuplesKt.to("logId", String.valueOf(r1.logId));
        com.bytedance.android.livesdk.chatroom.model.multicamera.b r10 = (com.bytedance.android.livesdk.chatroom.model.multicamera.b) r1.data;
        if (r10 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.model.multicamera.a r11 = r10.getCamera();
        if (r11 == null) goto L11;
        Long r12 = r11.getCameraId();
    L12:
        r9[1] = TuplesKt.to("cameraId", String.valueOf(r12));
        com.bytedance.android.livesdk.chatroom.model.multicamera.b r13 = (com.bytedance.android.livesdk.chatroom.model.multicamera.b) r1.data;
        if (r13 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.model.multicamera.a r14 = r13.getCamera();
        if (r14 == null) goto L17;
        String r15 = r14.getRtmpPushUrl();
    L18:
        r9[2] = TuplesKt.to("rtmpPushUrl", String.valueOf(r15));
        r9[3] = TuplesKt.to("targetStreamInfo_roomId", String.valueOf(this.c.getRtcRoomId()));
        r9[4] = TuplesKt.to("targetStreamInfo_uid", String.valueOf(this.c.getRtcUserId()));
        x0 r16 = this.a.G;
        if (r16 == null) goto L21;
        String r17 = r16.a();
    L22:
        r9[5] = TuplesKt.to("currentStreamInfo_roomId", String.valueOf(r17));
        x0 r18 = this.a.G;
        if (r18 == null) goto L25;
        String r19 = r18.b();
    L26:
        r9[6] = TuplesKt.to("currentStreamInfo_uid", String.valueOf(r19));
        com.bytedance.android.live.liveinteract.utils.j.a(1, "createNewCamera success", 0, null, MapsKt.mutableMapOf(r9), 12);
        List<com.bytedance.android.livesdk.chatroom.model.multicamera.a> r20 = this.a.u;
        com.bytedance.android.livesdk.chatroom.model.multicamera.b r21 = (com.bytedance.android.livesdk.chatroom.model.multicamera.b) r1.data;
        if (r21 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.model.multicamera.a r22 = r21.getCamera();
    L30:
        ((ArrayList) r20).add(r22);
        if (this.a.Lq(this.c) == false) goto L85;
        com.bytedance.android.livesdk.chatroom.model.multicamera.b r23 = (com.bytedance.android.livesdk.chatroom.model.multicamera.b) r1.data;
        if (r23 == null) goto L100;
        com.bytedance.android.livesdk.chatroom.model.multicamera.a r24 = r23.getCamera();
        if (r24 == null) goto L101;
        final String r25 = r24.getRtmpPushUrl();
        if (r25 == null) goto L102;
        HamletAvatarWidget r27 = this.a;
        final i3 r28 = this.c;
        r27.getClass();
        Pair[] r29 = new Pair[6];
        r29[0] = TuplesKt.to("targetStreamInfo_roomId", String.valueOf(r28.getRtcRoomId()));
        r29[1] = TuplesKt.to("targetStreamInfo_uid", String.valueOf(r28.getRtcUserId()));
        r29[2] = TuplesKt.to("publicStreamId", "publicStreamInfo.publicStreamId");
        x0 r30 = r27.G;
        if (r30 == null) goto L41;
        String r31 = r30.a();
    L42:
        r29[3] = TuplesKt.to("currentStreamInfo_roomId", String.valueOf(r31));
        x0 r32 = r27.G;
        if (r32 == null) goto L45;
        String r33 = r32.b();
    L46:
        r29[4] = TuplesKt.to("currentStreamInfo_uid", String.valueOf(r33));
        r29[5] = TuplesKt.to("pushUrl", r25);
        com.bytedance.android.live.liveinteract.utils.j.a(1, "createAndStartExtraViewStreamMixTask", 0, null, MapsKt.mutableMapOf(r29), 12);
        af0.a.a.getClass();
        af0.a.m(LinkMonitorData.HamletAvatarSubMixerStart);
        r27.M = System.currentTimeMillis();
        Function0<hg6.g> r34 = r27.R;
        if (r34 == null) goto L51;
        hg6.g r35 = (hg6.g) r34.invoke();
        if (r35 == null) goto L51;
        final ei6.a r36 = r35.V0();
    L52:
        Function0<he0.b.a> r37 = r27.S;
        if (r37 == null) goto L55;
        he0.b.a r38 = (he0.b.a) r37.invoke();
    L56:
        final df0.a r39 = new df0.a(r38, r28.getPublicStreamId(), ((Widget) r27).dataCenter);
        Iterator<T> r40 = ((LinkedHashMap) r27.H).keySet().iterator();
    L58:
        if (r40.hasNext() == false) goto L66;
        String r41 = (String) r40.next();
        df0.a r42 = (df0.a) ((LinkedHashMap) r27.H).get(r41);
        if (r42 == null) goto L62;
        r42.f = r28.getPublicStreamId();
    L62:
        if (r36 == null) goto L58;
        ti6.d r43 = r36.p();
        if (r43 == null) goto L58;
        r43.b(r41, r27 + " createAndStartExtraViewStreamMixTask");
        goto L58
    L66:
        String r44 = r28.getMixStreamTaskId();
        if (r44 == null) goto L69;
        df0.a r45 = r27.H.put(r44, r39);
    L69:
        if (r36 == null) goto L71;
        fi6.a r46 = r36.g();
    L72:
        r39.b = r46;
        if (r36 == null) goto L81;
        ti6.d r47 = r36.p();
        if (r47 == null) goto L81;
        TaskMixerConfig r48 = new TaskMixerConfig();
        String r49 = String.valueOf(r28.getMixStreamTaskId());
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        r48.c = r49;
        r48.j = new HamletAvatarWidget$createAndStartExtraViewStreamMixTask$$inlined$apply$lambda$1(r28, r39, r25, r36);
        r48.g = r25;
        fi6.a r50 = r36.g();
        if (r50 == null) goto L79;
        ti6.h r110 = r50.T;
    L80:
        r48.f = r110;
        r48.b(TaskMixerConfig.TaskType.EXTRA);
        r48.a(MixStreamType.SERVER_MIX);
        Unit r51 = Unit.INSTANCE;
        r47.l(r48);
        goto L81
    L79:
        r110 = null;
    L81:
        if (r36 == null) goto L103;
        ti6.d r52 = r36.p();
        if (r52 == null) goto L104;
        r52.d(String.valueOf(r28.getMixStreamTaskId()), r27 + " createAndStartExtraViewStreamMixTask");
        return;
    L104:
        return;
    L103:
        return;
    L71:
        r46 = null;
        goto L72
    L55:
        r38 = null;
    L51:
        r36 = null;
        goto L52
    L45:
        r33 = null;
        goto L46
    L41:
        r31 = null;
        goto L42
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L85:
        HamletAvatarWidget r53 = this.a;
        com.bytedance.android.livesdk.chatroom.model.multicamera.a r54 = ((com.bytedance.android.livesdk.chatroom.model.multicamera.b) r1.data).getCamera();
        if (r54 == null) goto L88;
        Long r111 = r54.getCameraId();
    L89:
        r53.Cq(r111);
        return;
    L88:
        r111 = null;
        goto L89
    L29:
        r22 = null;
        goto L30
    L25:
        r19 = null;
        goto L26
    L21:
        r17 = null;
    L17:
        r15 = null;
    L11:
        r12 = null;
        goto L12
    }
}
