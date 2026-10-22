package vp1;

import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.MultiCameraPanelEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.CameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MainCameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MatchInfoWrapper;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nm1.m;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements m, o {
    public d() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void A(DataCenter r2) {
        if (r2 == null) goto L4;
        Integer r3 = Integer.valueOf(r2.hashCode());
    L5:
        LayerEventDispatcher r4 = o70.c.a(r3);
        if (r4 == null) goto L9;
        MultiCameraPanelEvent r0 = MultiCameraPanelEvent.b;
        r4.b(MultiCameraPanelEvent.c);
        return;
    L9:
        return;
    L4:
        r3 = null;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IBaseStreamUrl E(DataCenter r10) {
        int r0 = lu2.b.a;
        Object r1 = null;
        u r2 = r.u(r10, null, 2);
        if (r10 == null) goto L30;
        IRoom r3 = lu2.c.f(r10);
        if (r3 == null) goto L30;
        if (lu2.b.d(r10) == false) goto L30;
        EpisodeExtraInfo r11 = lu2.c.a(r3);
        if (r11 == null) goto L42;
        List r12 = r11.getCameraInfos();
        if (r12 == null) goto L42;
        Iterator r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L25;
        Object r4 = r13.next();
        long r5 = ((IVSCameraInfo) r4).getCameraId();
        if (r2 == null) goto L22;
        com.bytedance.live.datacontext.m<Long> r6 = r2.cameraId();
        if (r6 == null) goto L22;
        if (r5 != ((Number) r6.getValue()).longValue()) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L14;
        r1 = r4;
    L22:
        r7 = false;
    L25:
        IVSCameraInfo r8 = (IVSCameraInfo) r1;
        if (r8 == null) goto L42;
        IBaseStreamUrl r14 = r8.getStreamUrl();
        if (r14 == null) goto L42;
        return r14;
    L42:
        return r3.getStreamUrl();
    L30:
        if (r10 == null) goto L35;
        IRoom r15 = lu2.c.f(r10);
        if (r15 == null) goto L35;
        r1 = r15.getStreamUrl();
    L35:
        return r1;
    }

    public final boolean F(DataCenter r1) {
        return lu2.b.b(r1);
    }

    public final boolean J(DataCenter r5) {
        int r0 = lu2.b.a;
        IRoom r1 = null;
        u r2 = r.u(r5, null, 2);
        if (r2 == null) goto L23;
        com.bytedance.live.datacontext.m<Long> r3 = r2.cameraId();
        if (r3 == null) goto L23;
        Long r4 = (Long) r3.getValue();
        if (r4 == null) goto L23;
        long r6 = r4.longValue();
        if (r5 == null) goto L12;
        r1 = lu2.c.f(r5);
    L12:
        VSCameraInfo r7 = lu2.b.i(r1, r6);
        if (r7 == null) goto L23;
        IBaseStreamUrl r8 = r7.streamUrl;
        if (r8 != null) goto L17;
    L18:
        IBaseStreamUrl r9 = r7.streamUrl;
        if (r9 == null) goto L23;
        if (r9.getVrType() != 2) goto L23;
        return true;
    L17:
        if (r8.getVrType() != 1) goto L18;
        return true;
    L23:
        return false;
    }

    public final VSCameraInfo K(DataCenter r1) {
        return lu2.b.c(r1);
    }

    public final boolean a(DataCenter r1) {
        return lu2.b.d(r1);
    }

    public final VSCameraInfo c(Room r5) {
        int r0 = lu2.b.a;
        IVSCameraInfo r1 = null;
        if (r5 == null) goto L21;
        EpisodeExtraInfo r6 = lu2.c.a(r5);
        if (r6 == null) goto L21;
        List r7 = r6.getCameraInfos();
        if (r7 == null) goto L21;
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L19;
        Object r2 = r8.next();
        IVSCameraInfo r3 = (IVSCameraInfo) r2;
        if (r3.isPaidCamera() == true) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L10;
    L20:
        IVSCameraInfo r9 = (IVSCameraInfo) r2;
    L23:
        if ((r9 instanceof VSCameraInfo) == false) goto L27;
        r1 = r9;
    L27:
        return (VSCameraInfo) r1;
    L14:
        if (r3.viewRight() == true) goto L16;
        r4 = true;
        goto L17
    L19:
        r2 = null;
    L21:
        r9 = null;
        goto L23
    }

    public final long f(DataCenter r3) {
        VSCameraInfo r0 = lu2.b.c(r3);
        if (r0 == null) goto L7;
        CameraMatchInfo r1 = r0.cameraMatchInfo;
        if (r1 == null) goto L7;
        return r1.getMatchId();
    L7:
        if (r3 == null) goto L15;
        IRoom r4 = lu2.c.f(r3);
        if (r4 == null) goto L15;
        EpisodeExtraInfo r5 = lu2.c.a(r4);
        if (r5 == null) goto L15;
        MainCameraMatchInfo r6 = r5.getMainCameraMatchInfo();
        if (r6 == null) goto L15;
        return r6.getMatchId();
    L15:
        return 0;
    }

    public final boolean i(DataCenter r3) {
        u r0 = r.u(r3, null, 2);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Long> r1 = r0.cameraId();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L9;
        long r4 = r2.longValue();
    L10:
        VSCameraInfo r5 = lu2.b.h(r4, r3);
        if (r5 != null) goto L13;
    L15:
        return false;
    L13:
        if (r5.isPaidCamera() != true) goto L15;
        return true;
    L9:
        r4 = 0;
        goto L10
    }

    public final MatchInfoWrapper n(DataCenter r14) {
        VSCameraInfo r0 = lu2.b.c(r14);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Long r3 = null;
        if (r1 == false) goto L21;
        VSCameraInfo r2 = lu2.b.c(r14);
        if (r2 == null) goto L38;
        CameraMatchInfo r4 = r2.cameraMatchInfo;
        if (r4 == null) goto L39;
        long r5 = r4.getMatchId();
        List r7 = r4.getEventId();
        long r8 = r4.getContentId();
        u r15 = r.u(r14, null, 2);
        if (r15 == null) goto L19;
        com.bytedance.live.datacontext.m<Long> r16 = r15.cameraId();
        if (r16 == null) goto L19;
        r3 = (Long) r16.getValue();
    L19:
        MatchInfoWrapper r12 = new MatchInfoWrapper(r5, r7, r8, r3, r2.cameraType);
    L40:
        return r12;
    L39:
        return null;
    L38:
        return null;
    L21:
        if (r14 == null) goto L41;
        IRoom r6 = lu2.c.f(r14);
        if (r6 == null) goto L42;
        EpisodeExtraInfo r9 = lu2.c.a(r6);
        if (r9 == null) goto L43;
        MainCameraMatchInfo r10 = r9.getMainCameraMatchInfo();
        if (r10 == null) goto L44;
        long r11 = r10.getMatchId();
        List r13 = r10.getEventId();
        long r17 = r10.getContentId();
        u r18 = r.u(r14, null, 2);
        if (r18 == null) goto L33;
        com.bytedance.live.datacontext.m<Long> r19 = r18.cameraId();
        if (r19 == null) goto L33;
        r3 = (Long) r19.getValue();
    L33:
        Long r110 = r3;
        VSCameraInfo r111 = lu2.b.c(r14);
        if (r111 == null) goto L36;
        int r112 = r111.cameraType;
    L37:
        r12 = new MatchInfoWrapper(r11, r13, r17, r110, r112);
        goto L40
    L36:
        r112 = 0;
        goto L37
    L44:
        return null;
    L43:
        return null;
    L42:
        return null;
    L41:
        return null;
    L5:
        if (r0.cameraType != 2) goto L7;
        r1 = true;
        goto L8
    }

    public final VSCameraInfo o(IRoom r1) {
        return lu2.b.a(r1);
    }

    public final boolean y(DataCenter r2) {
        VSCameraInfo r3 = lu2.b.c(r2);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.cameraType != 2) goto L7;
        return true;
    }

    public final boolean I(Room r1, Long r2) {
        return lu2.b.e(r1, r2);
    }

    public final VSCameraInfo d(Room r1, long r2) {
        return lu2.b.i(r1, r2);
    }

    public final VSCameraInfo h(long r1, DataCenter r3) {
        return lu2.b.h(r1, r3);
    }

    public final String j(long r4, IRoom r6) {
        if (r6 == null) goto L8;
        int r0 = lu2.b.a;
        IEpisodeExtraInfo r1 = r6.getEpisodeComponentData();
        if (r1 == null) goto L8;
        if (r1.getDefaultCameraId() != r4) goto L8;
        return "major";
    L8:
        VSCameraInfo r5 = lu2.b.i(r6, r4);
        if (r5 != null) goto L11;
    L13:
        return "others";
    L11:
        if (r5.isMatchCamera() != true) goto L13;
        return "others_game";
    }

    public final long k(IRoom r6, Long r7) {
        int r0 = lu2.b.a;
        if (RoomKt.hasMultiCamera(r6) == false) goto L11;
        if (r7 == null) goto L6;
        long r3 = r7.longValue();
    L7:
        VSCameraInfo r8 = lu2.b.i(r6, r3);
        if (r8 != null) goto L10;
        return 0;
    L10:
        return r8.groupId;
    L6:
        r3 = 0;
        goto L7
    L11:
        return 0;
    }

    public final List<Long> s(IRoom r3, DataCenter r4) {
        int r0 = lu2.b.a;
        if (r3 == null) goto L18;
        if (r4 == null) goto L9;
        Long r5 = (Long) r4.get("cmd_vs_room_enter_in_cameraid");
        if (r5 == null) goto L9;
        long r1 = r5.longValue();
    L10:
        VSCameraInfo r6 = lu2.b.i(r3, r1);
        if (r6 == null) goto L17;
        CameraMatchInfo r7 = r6.cameraMatchInfo;
        if (r7 == null) goto L17;
        List<Long> r8 = r7.getHideTabIds();
        if (r8 == null) goto L17;
        return r8;
    L17:
        return CollectionsKt.emptyList();
    L9:
        r1 = 0;
        goto L10
    L18:
        return CollectionsKt.emptyList();
    }

    public final boolean w(long r1, DataCenter r3) {
        VSCameraInfo r2 = lu2.b.h(r1, r3);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isPaidCamera() != true) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(DataCenter r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r9, "map");
        int r1 = lu2.b.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        VSCameraInfo r0 = lu2.b.c(r8);
        String r2 = "";
        if (r0 == null) goto L15;
        String r6 = r0.title;
        if (r6 == null) goto L8;
        r2 = r6;
    L8:
        r9.put("vs_machine_title", r2);
        r9.put("vs_machine_id", r0.cameraIdStr);
        if (r0.isMatchCamera() == false) goto L11;
        String r3 = "others_game";
    L12:
        r9.put("vs_machine_type", r3);
        if (r0.isPaidCamera() == false) goto L40;
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r8).J0().g(r0, r9);
    L40:
        u r10 = r.u(r8, null, 2);
        if (r10 == null) goto L46;
        com.bytedance.live.datacontext.m<String> r11 = r10.Y();
        if (r11 == null) goto L47;
        r9.put("platform", r11.getValue());
        return;
    L47:
        return;
    L46:
        return;
    L11:
        r3 = "others";
        goto L12
    L15:
        if (r8 == null) goto L22;
        IRoom r4 = lu2.c.f(r8);
        if (r4 == null) goto L22;
        EpisodeExtraInfo r5 = lu2.c.a(r4);
        if (r5 == null) goto L22;
        String r7 = r5.getTitle();
        if (r7 == null) goto L22;
    L27:
        if (r7 == null) goto L30;
        r2 = r7;
    L30:
        r9.put("vs_machine_title", r2);
        if (r8 == null) goto L38;
        IRoom r12 = lu2.c.f(r8);
        if (r12 == null) goto L38;
        IEpisodeExtraInfo r13 = r12.getEpisodeComponentData();
        if (r13 == null) goto L38;
        String r14 = String.valueOf(r13.getDefaultCameraId());
        if (r14 == null) goto L38;
    L39:
        r9.put("vs_machine_id", r14);
        r9.put("vs_machine_type", "major");
    L38:
        r14 = "0";
    L22:
        if (r8 == null) goto L26;
        IRoom r15 = lu2.c.f(r8);
        if (r15 == null) goto L26;
        r7 = r15.getTitle();
    L26:
        r7 = null;
        goto L27
    }

    public final void g(List<Long> r2, long r3, long r5, DataCenter r7) {
        int r0 = lu2.b.a;
        if (r7 == null) goto L14;
        IRoom r8 = lu2.c.f(r7);
        if (r8 == null) goto L15;
        EpisodeExtraInfo r9 = lu2.c.a(r8);
        if (r9 == null) goto L16;
        MainCameraMatchInfo r10 = r9.getMainCameraMatchInfo();
        if (r10 == null) goto L17;
        if (r2 != null) goto L12;
        r2 = CollectionsKt.emptyList();
    L12:
        r10.setEventId(r2);
        r10.setContentId(r3);
        r10.setMatchId(r5);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public final boolean q(long r6, Long r8, IRoom r9, boolean r10) {
        int r0 = lu2.b.a;
        boolean r3 = false;
        if (r6 <= 0) goto L9;
        if (r8 != null) goto L7;
    L8:
        boolean r11 = true;
    L10:
        if (r11 == true) goto L12;
    L14:
        r3 = true;
    L16:
        return !r3;
    L12:
        if (lu2.b.e(r9, Long.valueOf(r6)) == true) goto L16;
        if (r10 == false) goto L16;
    L7:
        if (r6 != r8.longValue()) goto L8;
    L9:
        r11 = false;
        goto L10
    }
}
