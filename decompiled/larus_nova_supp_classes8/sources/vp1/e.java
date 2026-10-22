package vp1;

import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.b0;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.eventbus.VSJumpCameraEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static final e a = null;

    public e() {
    }

    static {
        a = new e();
    }

    public final void a(vlc.d r22, DataCenter r23) {
        if (r22 != null) goto L5;
        return;
    L5:
        if (r23 != null) goto L7;
        return;
    L7:
        String r12 = "1";
        if (dq1.b.a(com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r23)) == false) goto L44;
        dq1.a r2 = pm1.f.a();
        if (r2 == null) goto L12;
        VSCameraInfo r3 = r2.C4();
    L13:
        dq1.a r16 = pm1.f.a();
        if (r16 == null) goto L18;
        List<VSCameraInfo> r17 = r16.p4();
        if (r17 == null) goto L18;
        int r4 = r17.size();
    L19:
        if (r4 <= 1) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L27;
        if (r3 == null) goto L27;
        String r18 = "";
        String r14 = String.valueOf(r3.cameraId);
        if (r14 == null) goto L28;
    L29:
        if (r5 == false) goto L33;
        if (r3 == null) goto L33;
        String r6 = String.valueOf(r3.groupId);
        if (r6 == null) goto L33;
    L34:
        int r7 = lu2.b.a;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r23);
        if (r3 == null) goto L37;
        Long r8 = Long.valueOf(r3.cameraId);
    L39:
        if (lu2.b.e(r1, r8) == true) goto L42;
        r12 = "0";
    L42:
        xq1.b.b().a(r22, MapsKt.mapOf(new Pair[]{TuplesKt.to("camera_id", r14), TuplesKt.to("sub_room_id", r14), TuplesKt.to("group_id", r6), TuplesKt.to("is_match_sub_camera", r12)}));
        return;
    L37:
        r8 = null;
    L33:
        r6 = r18;
    L28:
        r14 = r18;
    L27:
        r18 = "";
        goto L28
    L21:
        r5 = false;
    L18:
        r4 = 0;
        goto L19
    L12:
        r3 = null;
        goto L13
    L44:
        u r9 = r.u(r23, null, 2);
        IRoom r10 = (IRoom) r23.get("data_room", null);
        if (r10 != null) goto L47;
    L49:
        boolean r11 = false;
    L50:
        if (r11 == false) goto L58;
        if (r9 == null) goto L58;
        m<Long> r13 = r9.cameraId();
        if (r13 == null) goto L58;
        Long r15 = (Long) r13.getValue();
        if (r15 == null) goto L58;
        String r19 = String.valueOf(r15.longValue());
        if (r19 == null) goto L58;
    L59:
        if (r11 == false) goto L74;
        IRoom r20 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r23);
        Long r21 = null;
        u r110 = r.u(r23, null, 2);
        if (r110 == null) goto L65;
        m<Long> r111 = r110.cameraId();
        if (r111 == null) goto L65;
        r21 = (Long) r111.getValue();
    L65:
        int r112 = lu2.b.a;
        long r113 = 0;
        if (RoomKt.hasMultiCamera(r20) == false) goto L73;
        if (r21 == null) goto L69;
        long r24 = r21.longValue();
    L70:
        VSCameraInfo r25 = lu2.b.i(r20, r24);
        if (r25 == null) goto L73;
        r113 = r25.groupId;
        goto L73
    L69:
        r24 = 0;
    L73:
        String r26 = String.valueOf(r113);
    L76:
        if (lu2.b.f(r23) == true) goto L79;
        r12 = "0";
    L79:
        xq1.b.b().a(r22, MapsKt.mapOf(new Pair[]{TuplesKt.to("camera_id", r19), TuplesKt.to("sub_room_id", r19), TuplesKt.to("group_id", r26), TuplesKt.to("is_match_sub_camera", r12)}));
        return;
    L74:
        r26 = "";
    L58:
        r19 = "";
        goto L59
    L47:
        if (RoomKt.hasMultiCamera(r10) != true) goto L49;
        r11 = true;
        goto L50
    }

    public final void c(VSJumpCameraEvent r9, DataCenter r10) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (r9 == null) goto L64;
        if (r10 == null) goto L65;
        int r1 = 1;
        if (r9.getStreamUrl() == null) goto L19;
        IBaseStreamUrl r11 = r9.getStreamUrl();
        if (r11 == null) goto L12;
        r11.validatePullUrl();
    L12:
        IBaseStreamUrl r12 = r9.getStreamUrl();
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.hasLiveCoreSDKData() != true) goto L59;
        IBaseStreamUrl r13 = r9.getStreamUrl();
        if (r13 == null) goto L60;
        r13.validateMultiPullData();
        return;
    L60:
        return;
    L59:
        return;
    L19:
        Object r2 = null;
        IRoom r14 = (IRoom) r10.get("data_room", null);
        if (r14 == null) goto L66;
        IEpisodeExtraInfo r0 = r14.getEpisodeComponentData();
        if (r0 != null) goto L26;
        return;
    L26:
        if (r9.getCameraId() != r0.getDefaultCameraId()) goto L37;
        Intrinsics.checkNotNullParameter(r14, "$this$realEpisodeStyle");
        r9.setStyle(b0.b(r14));
        if (r9.getStyle() != 0) goto L36;
        IBaseStreamUrl r3 = r14.getStreamUrl();
        if (r3 != null) goto L32;
    L34:
        r1 = 2;
    L35:
        r9.setStyle(r1);
        goto L36
    L32:
        if (r3.getStreamOrientation() != 2) goto L34;
    L36:
        r9.setStreamUrl(r14.getStreamUrl());
        return;
    L37:
        List r15 = r0.getCameraInfos();
        if (r15 == null) goto L68;
        Iterator r16 = r15.iterator();
    L42:
        if (r16.hasNext() == false) goto L49;
        Object r4 = r16.next();
        if (((IVSCameraInfo) r4).getCameraId() != r9.getCameraId()) goto L46;
        boolean r5 = true;
    L47:
        if (r5 == false) goto L42;
        r2 = r4;
        goto L49
    L46:
        r5 = false;
    L49:
        IVSCameraInfo r6 = (IVSCameraInfo) r2;
        if (r6 == null) goto L63;
        Intrinsics.checkNotNullParameter(r6, "$this$realCameraStyle");
        r9.setStyle(b0.a(r6));
        r9.setStreamUrl((IBaseStreamUrl) com.bytedance.android.live.base.model.m.b(r6.getStreamUrl(), IBaseStreamUrl.class));
        return;
    L63:
        return;
    L68:
        return;
    L66:
        return;
    L65:
        return;
    }

    public final void b(RoomSession r12, IRoom r13, DataCenter r14) {
        if (r13 != null) goto L4;
        return;
    L4:
        if (r12 != null) goto L6;
        return;
    L6:
        IEpisodeExtraInfo r0 = r13.getEpisodeComponentData();
        if (r0 == null) goto L20;
        List r1 = r0.getCameraInfos();
        if (r1 == null) goto L20;
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L20;
        IBaseStreamUrl r3 = ((IVSCameraInfo) r2.next()).getStreamUrl();
        if (r3 == null) goto L12;
        IBaseStreamUrl r4 = (IBaseStreamUrl) com.bytedance.android.live.base.model.m.b(r3, IBaseStreamUrl.class);
        if (r4 == null) goto L12;
        r4.validatePullUrl();
        if (r4.getLiveCoreSDKData() == null) goto L12;
        r4.validateMultiPullData();
    L20:
        u r5 = r.u(r14, null, 2);
        if (r5 == null) goto L27;
        m<Long> r6 = r5.cameraId();
        if (r6 == null) goto L27;
        Long r7 = (Long) r6.getValue();
        if (r7 == null) goto L27;
        long r8 = r7.longValue();
    L28:
        Intrinsics.checkNotNullParameter(r13, "$this$realEpisodeStyle");
        int r9 = b0.b(r13);
        boolean r10 = false;
        if (r8 <= 0) goto L50;
        if (RoomKt.hasMultiCamera(r13) == false) goto L50;
        IEpisodeExtraInfo r15 = r13.getEpisodeComponentData();
        if (r15 == null) goto L77;
        List r16 = r15.getCameraInfos();
        if (r16 == null) goto L77;
        Iterator r17 = r16.iterator();
    L38:
        if (r17.hasNext() == false) goto L45;
        Object r18 = r17.next();
        if (((IVSCameraInfo) r18).getCameraId() != r8) goto L42;
        boolean r11 = true;
    L43:
        if (r11 == false) goto L38;
    L46:
        IVSCameraInfo r19 = (IVSCameraInfo) r18;
        if (r19 == null) goto L77;
        Intrinsics.checkNotNullParameter(r19, "$this$realCameraStyle");
        r9 = b0.a(r19);
        goto L77
    L42:
        r11 = false;
        goto L43
    L45:
        r18 = null;
    L77:
        u r110 = r.u(r14, null, 2);
        if (r110 == null) goto L104;
        m<Boolean> r111 = r110.A();
        if (r111 == null) goto L105;
        if (r9 != 2) goto L83;
        r10 = true;
    L83:
        r111.setValue(Boolean.valueOf(r10));
        return;
    L105:
        return;
    L104:
        return;
    L50:
        if (RoomKt.hasMultiCamera(r13) == false) goto L77;
        long r20 = r12.getDefaultCameraId();
        u r112 = r.u(r14, null, 2);
        if (r112 == null) goto L56;
        m<Long> r113 = r112.cameraId();
        if (r113 == null) goto L56;
        r113.setValue(Long.valueOf(r20));
    L56:
        IEpisodeExtraInfo r114 = r13.getEpisodeComponentData();
        if (r114 != null) goto L59;
    L60:
        IEpisodeExtraInfo r115 = r13.getEpisodeComponentData();
        if (r115 == null) goto L77;
        List r116 = r115.getCameraInfos();
        if (r116 == null) goto L77;
        Iterator r117 = r116.iterator();
    L66:
        if (r117.hasNext() == false) goto L73;
        Object r118 = r117.next();
        if (((IVSCameraInfo) r118).getCameraId() != r20) goto L70;
        boolean r21 = true;
    L71:
        if (r21 == false) goto L66;
    L74:
        IVSCameraInfo r119 = (IVSCameraInfo) r118;
        if (r119 == null) goto L77;
        Intrinsics.checkNotNullParameter(r119, "$this$realCameraStyle");
        r9 = b0.a(r119);
        goto L77
    L70:
        r21 = false;
        goto L71
    L73:
        r118 = null;
        goto L74
    L59:
        if (r20 == r114.getDefaultCameraId()) goto L77;
    L27:
        r8 = 0;
        goto L28
    }

    public final void d(RoomSession r2, Room r3, DataCenter r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r2 != null) goto L6;
        return;
    L6:
        IEpisodeExtraInfo r5 = r3.getEpisodeComponentData();
        if (r5 == null) goto L18;
        List r6 = r5.getCameraInfos();
        if (r6 == null) goto L18;
        Iterator r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L18;
        IBaseStreamUrl r8 = (IBaseStreamUrl) com.bytedance.android.live.base.model.m.b(((IVSCameraInfo) r7.next()).getStreamUrl(), IBaseStreamUrl.class);
        if (r8 == null) goto L12;
        r8.validatePullUrl();
        if (r8.getLiveCoreSDKData() == null) goto L12;
        r8.validateMultiPullData();
    L18:
        u r9 = r.u(r4, null, 2);
        if (r9 == null) goto L31;
        m<Boolean> r10 = r9.o0();
        if (r10 == null) goto L32;
        r10.setValue(Boolean.FALSE);
        return;
    L32:
        return;
    }
}
