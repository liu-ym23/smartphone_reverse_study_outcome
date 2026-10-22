package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.setting.SettingKeyUtils;
import com.bytedance.android.livesdk.config.pr0;
import com.bytedance.android.livesdk.config.qx0;
import com.bytedance.android.livesdk.config.sx0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VrUtils {
    public static int a;
    public static Integer b;
    public static final Lazy c = null;
    public static int d;
    public static final VrUtils e = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/utils/VrUtils$VRGestureDragType;", "", "", "type", "I", "getType", "()I", "NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY", "NO_GESTURE_DRAG_VIEW_ALWAYS", "NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY", "NO_GESTURE_DRAG_VIEW_NEVER", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum VRGestureDragType extends Enum<VRGestureDragType> {
        public static final VRGestureDragType NO_GESTURE_DRAG_VIEW_ALWAYS = null;
        public static final VRGestureDragType NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY = null;
        public static final VRGestureDragType NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY = null;
        public static final VRGestureDragType NO_GESTURE_DRAG_VIEW_NEVER = null;
        public static final /* synthetic */ VRGestureDragType[] a = null;
        private final int type;

        static {
            VRGestureDragType r1 = new VRGestureDragType("NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY", 0, 0);
            NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY = r1;
            VRGestureDragType r2 = new VRGestureDragType("NO_GESTURE_DRAG_VIEW_ALWAYS", 1, 1);
            NO_GESTURE_DRAG_VIEW_ALWAYS = r2;
            VRGestureDragType r3 = new VRGestureDragType("NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY", 2, 2);
            NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY = r3;
            VRGestureDragType r4 = new VRGestureDragType("NO_GESTURE_DRAG_VIEW_NEVER", 3, 3);
            NO_GESTURE_DRAG_VIEW_NEVER = r4;
            a = new VRGestureDragType[]{r1, r2, r3, r4};
        }

        public static VRGestureDragType valueOf(String r1) {
            return (VRGestureDragType) r27.a.a(VRGestureDragType.class, r1);
        }

        public static VRGestureDragType[] values() {
            return (VRGestureDragType[]) a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public VRGestureDragType(String r1, int r2, int r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    public VrUtils() {
    }

    @JvmStatic
    public static final boolean e() {
        if (C(null) == true) goto L5;
    L7:
        return false;
    L5:
        if (qx0.a.getValue().booleanValue() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final String n() {
        if (C(null) == false) goto L18;
        int r1 = a;
        if (r1 > 0) goto L20;
        IRoomContextService r2 = jc1.k.f(IRoomContextService.class);
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.o r0 = IRoomContextService.a.a(r2, null, 0, 3);
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.m r3 = r0.getRoom();
        if (r3 == null) goto L18;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L18;
        String r5 = String.valueOf(r4.getVRType());
        if (r5 == null) goto L18;
        return r5;
    L20:
        return String.valueOf(r1);
    L18:
        return "0";
    }

    static {
        e = new VrUtils();
        b = 0;
        c = LazyKt.lazy(VrUtils$vrEnable$2.INSTANCE);
        d = -1;
    }

    @JvmStatic
    public static final boolean B() {
        if (((Boolean) SettingKeyUtils.f.getValue()).booleanValue() == true) goto L5;
    L27:
        return false;
    L5:
        if (C(null) == false) goto L27;
        MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L11;
        Room r3 = (Room) r2.getValue();
    L13:
        if (x(r3) == false) goto L27;
        IRoomContextService r4 = jc1.k.f(IRoomContextService.class);
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.o r5 = IRoomContextService.a.a(r4, null, 0, 3);
        if (r5 == null) goto L21;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L21;
        IRoom r7 = (IRoom) r6.getValue();
    L23:
        if (A(r7, null) == true) goto L27;
        if (PadConfigUtils.c() == true) goto L27;
        return true;
    L21:
        r7 = null;
    L11:
        r3 = null;
        goto L13
    }

    @JvmStatic
    public static final boolean f() {
        if (pr0.a.getValue().booleanValue() == false) goto L5;
        e.getClass();
        boolean r0 = ((Boolean) c.getValue()).booleanValue();
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (C(null) == false) goto L10;
        return true;
    L5:
        r0 = true;
        goto L6
    }

    @JvmStatic
    public static final boolean h() {
        return com.bytedance.android.livesdk.config.s3.a.getValue().booleanValue();
    }

    @JvmStatic
    public static final int m() {
        Lazy r0 = SettingKeyUtils.a;
        return ((Number) SettingKeyUtils.e.getValue()).intValue();
    }

    @JvmStatic
    public static final boolean q() {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L32;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L33;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L35;
        StreamUrl r3 = r2.getStreamUrl();
        if (r3 == null) goto L23;
        Map r4 = r3.getPullDatas();
        if (r4 == null) goto L23;
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r6 = r4.entrySet().iterator();
    L15:
        if (r6.hasNext() == false) goto L22;
        Map.Entry r7 = (Map.Entry) r6.next();
        if (((LiveCoreSDKData.PullData) r7.getValue()).getKind() == 2) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L15;
        r5.put(r7.getKey(), r7.getValue());
        goto L15
    L19:
        r8 = false;
        goto L20
    L22:
        int r9 = r5.size();
    L24:
        if (r9 <= 0) goto L34;
        return true;
    L34:
        return false;
    L23:
        r9 = 0;
        goto L24
    L35:
        return false;
    L33:
        return false;
    L32:
        return false;
    }

    @JvmStatic
    public static final boolean s() {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        IRoom r3 = (IRoom) r2.getValue();
    L11:
        if (x(r3) == true) goto L13;
    L23:
        return false;
    L13:
        if (B() == false) goto L23;
        IRoomContextService r4 = jc1.k.f(IRoomContextService.class);
        if (r4 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.o r5 = IRoomContextService.a.a(r4, null, 0, 3);
        if (r5 == null) goto L23;
        com.bytedance.live.datacontext.m r6 = r5.A1();
        if (r6 == null) goto L23;
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L23;
        return true;
    L9:
        r3 = null;
        goto L11
    }

    @JvmStatic
    public static final boolean j() {
        if (h() == true) goto L5;
    L9:
        return false;
    L5:
        if (m() != VRGestureDragType.NO_GESTURE_DRAG_VIEW_INTERACTIVE_ONLY.getType()) goto L7;
    L8:
        return true;
    L7:
        if (m() != VRGestureDragType.NO_GESTURE_DRAG_VIEW_ALWAYS.getType()) goto L9;
        goto L8
    }

    @JvmStatic
    public static final boolean C(DataCenter r5) {
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, r5, 0, 2);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        IRoom r3 = (IRoom) r2.getValue();
    L11:
        if (A(r3, null) == false) goto L14;
    L18:
        return true;
    L14:
        if (v(r5) == true) goto L18;
        if (d != 2) goto L18;
        return false;
    L9:
        r3 = null;
        goto L11
    }

    @JvmStatic
    public static final boolean c(DataCenter r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (gb2.a.c(r3, true) == true) goto L11;
        if (B() == true) goto L9;
        return false;
    L9:
        if (com.bytedance.android.live.core.utils.a0.n(r3).isMediaRoom() == false) goto L11;
        return false;
    L11:
        if (com.bytedance.android.live.core.utils.a0.d(r3, false) == false) goto L13;
        return false;
    L13:
        if (C(r3) == true) goto L15;
        return false;
    L15:
        if (w(r3) == false) goto L23;
        return true;
    L23:
        return false;
    }

    @JvmStatic
    public static final boolean d(DataCenter r0) {
        if (w(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (B() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean g(IRoom r6) {
        if (r6 == null) goto L8;
        if (r6.isVrRoom() != true) goto L8;
        return true;
    L8:
        if (q() == true) goto L42;
        Object r2 = null;
        if (r6 == null) goto L32;
        IEpisodeExtraInfo r7 = r6.getEpisodeComponentData();
        if (r7 == null) goto L32;
        List r8 = r7.getCameraInfos();
        if (r8 == null) goto L32;
        Iterator r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L31;
        Object r3 = r9.next();
        IVSCameraInfo r4 = (IVSCameraInfo) r3;
        IBaseStreamUrl r5 = r4.getStreamUrl();
        if (r5 != null) goto L22;
    L23:
        IBaseStreamUrl r10 = r4.getStreamUrl();
        if (r10 != null) goto L26;
    L28:
        boolean r11 = false;
    L29:
        if (r11 == false) goto L18;
        r2 = r3;
        goto L31
    L26:
        if (r10.getVrType() != 2) goto L28;
    L27:
        r11 = true;
        goto L29
    L22:
        if (r5.getVrType() == 1) goto L27;
    L31:
        r2 = (IVSCameraInfo) r2;
    L32:
        if (r2 != null) goto L43;
        return false;
    L43:
        return true;
    L42:
        return true;
    }

    @JvmStatic
    public static final boolean i(DataCenter r2) {
        if (r2 != null) goto L4;
    L10:
        return false;
    L4:
        if (((Boolean) r2.get("data_hide_screen", Boolean.FALSE)).booleanValue() == false) goto L10;
        if (C(null) == false) goto L10;
        if (sx0.a.getValue().booleanValue() == false) goto L10;
        return true;
    }

    @JvmStatic
    public static final int l(DataCenter r3) {
        if (r3 == null) goto L5;
        Integer r4 = (Integer) r3.get("data_screen_orientation", 1);
    L6:
        if (r4 != null) goto L9;
    L10:
        if (r4 != null) goto L13;
        return 1;
    L13:
        if (r4.intValue() != 6) goto L16;
    L14:
        return 0;
    L16:
        return 1;
    L9:
        if (r4.intValue() == 0) goto L14;
    L5:
        r4 = null;
        goto L6
    }

    @JvmStatic
    public static final String o(DataCenter r1) {
        if (C(null) == false) goto L12;
        if (r1 != null) goto L7;
        Integer r2 = b;
        if (r2 == null) goto L20;
        if (r2.intValue() == 0) goto L20;
        return String.valueOf(b);
    L20:
        return String.valueOf(a);
    L7:
        if (w(r1) == false) goto L10;
        return String.valueOf(b);
    L10:
        if (v(r1) == false) goto L12;
        return "1";
    L12:
        return "0";
    }

    @JvmStatic
    public static final boolean p(IRoom r6) {
        Object r0 = null;
        if (C(null) == true) goto L6;
        return false;
    L6:
        if (r6 != null) goto L8;
    L10:
        if (r6 == null) goto L31;
        IEpisodeExtraInfo r7 = r6.getEpisodeComponentData();
        if (r7 == null) goto L31;
        List r8 = r7.getCameraInfos();
        if (r8 == null) goto L31;
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L30;
        Object r3 = r9.next();
        IVSCameraInfo r4 = (IVSCameraInfo) r3;
        IBaseStreamUrl r5 = r4.getStreamUrl();
        if (r5 != null) goto L21;
    L22:
        IBaseStreamUrl r10 = r4.getStreamUrl();
        if (r10 != null) goto L25;
    L27:
        boolean r11 = false;
    L28:
        if (r11 == false) goto L17;
        r0 = r3;
        goto L30
    L25:
        if (r10.getVrType() != 2) goto L27;
    L26:
        r11 = true;
        goto L28
    L21:
        if (r5.getVrType() == 1) goto L26;
    L30:
        r0 = (IVSCameraInfo) r0;
    L31:
        if (r0 == null) goto L33;
        return true;
    L33:
        return false;
    L8:
        if (r6.isVrRoom() != true) goto L10;
        return true;
    }

    @JvmStatic
    public static final boolean r(DataCenter r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Integer r4 = (Integer) r3.get("cmd_multicamera_biz_type", -1);
        if (r4 != null) goto L9;
        return false;
    L9:
        if (r4.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    }

    @JvmStatic
    public static final boolean v(DataCenter r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Object r2 = null;
        Object r4 = r3.get("cmd_current_camera_info", null);
        if ((r4 instanceof ym0.a) == false) goto L9;
        r2 = r4;
    L9:
        ym0.a r5 = (ym0.a) r2;
        if (r5 != null) goto L13;
        return false;
    L13:
        if (r5.c() != 1) goto L15;
        boolean r6 = true;
    L17:
        if (r5.d() != 1) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == true) goto L24;
        if (r6 == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L19:
        r7 = false;
        goto L20
    L15:
        r6 = false;
        goto L17
    }

    @JvmStatic
    public static final boolean w(DataCenter r12) {
        if (C(r12) == true) goto L5;
        return false;
    L5:
        if (r12 == null) goto L9;
        IRoom r0 = com.bytedance.android.live.core.utils.a0.n(r12);
        if (r0 == null) goto L9;
        a = r0.getVRType();
    L9:
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        Integer r4 = null;
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r1, null, 0, 3);
    L13:
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.m r5 = r2.getCameraId();
    L17:
        if (r5 != null) goto L31;
        Integer r13 = b;
        if (r13 != null) goto L22;
    L23:
        Integer r14 = b;
        if (r14 != null) goto L27;
        return false;
    L27:
        if (r14.intValue() != 2) goto L101;
    L28:
        return true;
    L101:
        return false;
    L22:
        if (r13.intValue() == 1) goto L28;
    L31:
        if (((Long) r5.getValue()).longValue() <= 0) goto L84;
        com.bytedance.live.datacontext.m r3 = r2.getCameraId();
        if (r3 == null) goto L35;
        Long r6 = (Long) r3.getValue();
    L36:
        com.bytedance.live.datacontext.m r7 = r2.getRoom();
        if (r7 == null) goto L43;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L43;
        IEpisodeExtraInfo r9 = r8.getEpisodeComponentData();
        if (r9 == null) goto L43;
        Long r10 = Long.valueOf(r9.getDefaultCameraId());
    L45:
        if ((!Intrinsics.areEqual(r6, r10)) == false) goto L84;
        com.bytedance.live.datacontext.m r15 = r2.getRoom();
        if (r15 == null) goto L67;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L67;
        IEpisodeExtraInfo r17 = r16.getEpisodeComponentData();
        if (r17 == null) goto L67;
        List r18 = r17.getCameraInfos();
        if (r18 == null) goto L67;
        Iterator r19 = r18.iterator();
    L56:
        if (r19.hasNext() == false) goto L65;
        Object r11 = r19.next();
        long r20 = ((IVSCameraInfo) r11).getCameraId();
        com.bytedance.live.datacontext.m r21 = r2.getCameraId();
        if (r21 != null) goto L60;
    L62:
        boolean r22 = false;
    L63:
        if (r22 == false) goto L56;
    L66:
        IVSCameraInfo r23 = (IVSCameraInfo) r11;
    L68:
        if (r23 == null) goto L72;
        IBaseStreamUrl r110 = r23.getStreamUrl();
        if (r110 == null) goto L72;
        r4 = Integer.valueOf(r110.getVrType());
    L72:
        b = r4;
        if (r4 != null) goto L76;
    L77:
        Integer r111 = b;
        if (r111 != null) goto L81;
        return false;
    L81:
        if (r111.intValue() != 2) goto L103;
    L82:
        return true;
    L103:
        return false;
    L76:
        if (r4.intValue() == 1) goto L82;
    L60:
        if (r20 != ((Number) r21.getValue()).longValue()) goto L62;
        r22 = true;
        goto L63
    L65:
        r11 = null;
    L67:
        r23 = null;
    L43:
        r10 = null;
        goto L45
    L35:
        r6 = null;
    L84:
        if (r12 == null) goto L88;
        IRoom r24 = com.bytedance.android.live.core.utils.a0.n(r12);
        if (r24 == null) goto L88;
        r4 = Integer.valueOf(r24.getVRType());
    L88:
        b = r4;
        if (r12 == null) goto L105;
        IRoom r112 = com.bytedance.android.live.core.utils.a0.n(r12);
        if (r112 != null) goto L93;
        return false;
    L93:
        if (r112.isVrRoom() != true) goto L107;
        return true;
    L107:
        return false;
    L105:
        return false;
    L15:
        r5 = null;
        goto L17
    L12:
        r2 = null;
        goto L13
    }

    @JvmStatic
    public static final boolean x(IRoom r1) {
        if (r1 == null) goto L5;
        boolean r2 = r1.isVrRoom();
    L6:
        if (r2 == true) goto L8;
        return false;
    L8:
        if (C(null) == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean y(DataCenter r1) {
        if (r1 == null) goto L7;
        IRoom r2 = com.bytedance.android.live.core.utils.a0.n(r1);
        if (r2 == null) goto L7;
        boolean r3 = r2.isVrRoom();
    L8:
        if (r3 == true) goto L10;
        return false;
    L10:
        if (C(null) == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        r3 = false;
        goto L8
    }

    @JvmStatic
    public static final boolean z(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        if (((Boolean) r2.get("cmd_vr_stream_enable", Boolean.TRUE)).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (C(null) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean A(IRoom r4, RoomContext r5) {
        if (r4 != null) goto L4;
    L30:
        return false;
    L4:
        if (r4.isMergeVSRoom() == false) goto L7;
        return true;
    L7:
        if (r4.isMediaRoom() == false) goto L15;
        IEpisodeExtraInfo r0 = r4.getEpisodeComponentData();
        if (r0 == null) goto L15;
        List r1 = r0.getCameraInfos();
        if (r1 == null) goto L15;
        if ((!r1.isEmpty()) != true) goto L15;
        return true;
    L15:
        if (r5 == null) goto L23;
        IRoomContextService r2 = jc1.k.f(IRoomContextService.class);
        if (r2 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.r r6 = r2.getRoomExpService(r5);
        if (r6 == null) goto L30;
        if (r6.isMergeVSMediaRoom(r4) != true) goto L30;
        return true;
    L23:
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        if (r7 == null) goto L30;
        com.bytedance.android.livesdk.chatroom.r r8 = r7.getRoomExpService(null, 0);
        if (r8 == null) goto L30;
        if (r8.isMergeVSMediaRoom(r4) != true) goto L30;
        return true;
    }

    @JvmStatic
    public static final boolean k(DataCenter r12, Room r13) {
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        if (r13 != null) goto L5;
        return false;
    L5:
        if (r13.getRoomAuthStatus() == null) goto L76;
        IRoomAuthStatus r0 = r13.getRoomAuthStatus();
        IEpisodeExtraInfo r14 = r13.getEpisodeComponentData();
        if (r14 == null) goto L65;
        List r15 = r14.getCameraInfos();
        if (r15 == null) goto L65;
        if ((!r15.isEmpty()) != true) goto L65;
        IRoomContextService r16 = jc1.k.f(IRoomContextService.class);
        IVSCameraInfo r6 = null;
        Object r7 = null;
        r6 = null;
        r6 = null;
        if (r16 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.o r17 = IRoomContextService.a.a(r16, null, 0, 3);
    L17:
        if (r17 == null) goto L19;
        com.bytedance.live.datacontext.m r8 = r17.getCameraId();
        com.bytedance.live.datacontext.m r9 = r17.getCameraId();
        if (r9 == null) goto L27;
        Long r10 = (Long) r9.getValue();
        if (r10 == null) goto L27;
        long r11 = r10.longValue();
    L29:
        if (r11 <= 0) goto L65;
        com.bytedance.live.datacontext.m r4 = r17.getCameraId();
        if (r4 == null) goto L33;
        Long r5 = (Long) r4.getValue();
    L34:
        Room r18 = r17.S1();
        if (r18 == null) goto L39;
        IEpisodeExtraInfo r19 = r18.getEpisodeComponentData();
        if (r19 == null) goto L39;
        Long r20 = Long.valueOf(r19.getDefaultCameraId());
    L41:
        if ((!Intrinsics.areEqual(r5, r20)) == false) goto L65;
        Room r110 = r17.S1();
        if (r110 == null) goto L60;
        IEpisodeExtraInfo r111 = r110.getEpisodeComponentData();
        if (r111 == null) goto L60;
        List r112 = r111.getCameraInfos();
        if (r112 == null) goto L60;
        Iterator r113 = r112.iterator();
    L50:
        if (r113.hasNext() == false) goto L59;
        Object r21 = r113.next();
        long r22 = ((IVSCameraInfo) r21).getCameraId();
        if (r8 != null) goto L54;
    L56:
        boolean r23 = false;
    L57:
        if (r23 == false) goto L50;
        r7 = r21;
        goto L59
    L54:
        if (r22 != ((Number) r8.getValue()).longValue()) goto L56;
        r23 = true;
    L59:
        r6 = (IVSCameraInfo) r7;
    L60:
        if (r6 == null) goto L65;
        IRoomAuthStatus r114 = r6.getCameraRoomAuth();
        if (r114 == null) goto L65;
        r0 = r114;
    L39:
        r20 = null;
        goto L41
    L33:
        r5 = null;
    L27:
        r11 = 0;
        goto L29
    L19:
        if (r0.getCastScreenExplicit() != 1) goto L73;
        return true;
    L73:
        return false;
    L16:
        r17 = null;
    L65:
        if (r0.getCastScreenExplicit() != 1) goto L75;
        return true;
    L75:
        return false;
    L76:
        return false;
    }

    @JvmStatic
    public static final boolean t(DataCenter r2, boolean r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r3 == true) goto L9;
        if (gb2.a.c(r2, true) == false) goto L9;
        return false;
    L9:
        if (d(r2) == true) goto L11;
        return false;
    L11:
        if (com.bytedance.android.live.core.utils.a0.d(r2, false) == false) goto L13;
        return false;
    L13:
        if (C(null) == false) goto L20;
        return true;
    L20:
        return false;
    }

    @JvmStatic
    public static final boolean u(DataCenter r3, boolean r4) {
        if (t(r3, r4) == false) goto L13;
        IRoomContextService r5 = jc1.k.f(IRoomContextService.class);
        if (r5 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.o r6 = IRoomContextService.a.a(r5, null, 0, 3);
        if (r6 == null) goto L13;
        com.bytedance.live.datacontext.m r7 = r6.A1();
        if (r7 == null) goto L13;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L13;
        return true;
    L13:
        return false;
    }

    @JvmStatic
    public static final void a(List r2, CompositeDisposable r3, RoomContext r4) {
        Intrinsics.checkNotNullParameter(r2, "viewItems");
        if (sx0.a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (C(null) == false) goto L20;
        if (r4 == null) goto L24;
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.r r1 = r0.getRoomExpService(r4);
        if (r1 == null) goto L22;
        com.bytedance.live.datacontext.m r5 = r1.x();
        if (r5 != null) goto L15;
        return;
    L15:
        if (((Boolean) r5.getValue()).booleanValue() == false) goto L17;
        b(true, r2, r4);
    L17:
        RxUtilKt.c(r5.a().subscribe(new i5(r2, r4)), r3);
        return;
    L22:
        return;
    L21:
        return;
    L24:
        return;
    }

    @JvmStatic
    public static final void b(boolean r8, List<ph1.a> r9, DataContext r10) {
        Intrinsics.checkNotNullParameter(r9, "viewItems");
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L72;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 != null) goto L7;
        return;
    L7:
        if (((Boolean) SettingKeyUtils.b.getValue()).booleanValue() == true) goto L9;
        return;
    L9:
        if (C(null) == false) goto L75;
        if (r10 == null) goto L80;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L15;
        IRoom r3 = (IRoom) r2.getValue();
    L17:
        if (p(r3) == true) goto L20;
        return;
    L20:
        if (r9.isEmpty() == false) goto L22;
        return;
    L22:
        IRoomContextService r4 = jc1.k.f(IRoomContextService.class);
        if (r4 == null) goto L76;
        com.bytedance.android.livesdk.chatroom.r r11 = r4.getRoomExpService(r10);
        if (r11 == null) goto L77;
        com.bytedance.live.datacontext.n r12 = r11.l();
        if (r12 == null) goto L78;
        ArrayList r13 = (ArrayList) r12.getValue();
        if (r13 == null) goto L79;
        if (r8 == false) goto L32;
        String r5 = "add";
    L33:
        ALogger.i("VrUtils", "Before " + r5 + ", vrCleanModeAnchorViews has " + r13.size() + " item(s).");
        if (r8 == false) goto L47;
        Iterator<T> r14 = r9.iterator();
    L37:
        if (r14.hasNext() == false) goto L56;
        ph1.a r15 = (ph1.a) r14.next();
        Iterator r6 = r13.iterator();
    L40:
        if (r6.hasNext() == false) goto L44;
        Object r7 = r6.next();
        if (Intrinsics.areEqual((ph1.a) r7, r15) == false) goto L40;
    L45:
        if (r7 != null) goto L37;
        r13.add(r15);
        goto L37
    L44:
        r7 = null;
    L56:
        ALogger.i("VrUtils", "After " + r5 + ", vrCleanModeAnchorViews has " + r13.size() + " item(s).");
        return;
    L47:
        Iterator<T> r16 = r9.iterator();
    L49:
        if (r16.hasNext() == false) goto L56;
        ph1.a r17 = (ph1.a) r16.next();
        Iterator r18 = r13.iterator();
    L52:
        if (r18.hasNext() == false) goto L49;
        if (Intrinsics.areEqual((ph1.a) r18.next(), r17) == false) goto L52;
        r18.remove();
        goto L52
    L32:
        r5 = "remove";
        goto L33
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L15:
        r3 = null;
        goto L17
    L80:
        return;
    L75:
        return;
    }
}
