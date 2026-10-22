package je0;

import android.util.Base64;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.plantform.model.p;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.utils.y;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.e0;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.j;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;
import com.bytedance.android.livesdkapi.model.VideoTalkBgDeviceConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final boolean A() {
        if (((Boolean) vm2.e.k.getValue(null, vm2.e.a[9])).booleanValue() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean G() {
        return k.n(IKtvService.class).isCurrentUserIsSinger();
    }

    public static final boolean H() {
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L10;
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 != null) goto L7;
    L8:
        return true;
    L7:
        if (r0.isEngineOn() != true) goto L8;
        return false;
    L10:
        l.n2.getClass();
        if (l.a.a() == null) goto L19;
        l r1 = l.a.a();
        if (r1 != null) goto L15;
    L16:
        return true;
    L15:
        if (r1.isEngineOn() != true) goto L16;
        return false;
    L19:
        return !D();
    }

    public static final int R() {
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r0 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 != null) goto L5;
        return 0;
    L5:
        Iterable r1 = r0.getOnlineUserList();
        if (r1 == null) goto L23;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        Object r4 = r3.next();
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) r4;
        Intrinsics.checkNotNull(r5);
        boolean r6 = true;
        if (r5.getRoleType() != 1) goto L14;
        r6 = false;
    L14:
        if (r6 == false) goto L9;
        r2.add(r4);
        goto L9
    L17:
        return r2.size();
    L23:
        return 0;
    }

    public static final int S() {
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r0 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 != null) goto L5;
        return 0;
    L5:
        List<T> r1 = r0.getOnlineUserList();
        if (r1 != 0) goto L8;
        return 0;
    L8:
        return r1.size();
    }

    public static final boolean U() {
        ReadOnlyProperty r0 = vm2.d.Z5;
        KProperty[] r1 = vm2.d.a;
        j r3 = null;
        if (((Boolean) r0.getValue(null, r1[361(0x169, float:5.06E-43)])).booleanValue() == true) goto L6;
        return false;
    L6:
        if (((Boolean) vm2.d.c6.getValue(null, r1[364(0x16c, float:5.1E-43)])).booleanValue() == false) goto L8;
    L10:
        com.bytedance.live.datacontext.j r2 = m.d().getVideoTalkRoomSubScene();
        if (r2 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r4 == null) goto L16;
        r3 = r4.t();
    L16:
        if (r3 != null) goto L18;
    L22:
        if (r3 == null) goto L32;
        int r5 = r3.a;
        if (r5 != 8) goto L26;
    L30:
        return true;
    L26:
        if (r5 == 12) goto L30;
        if (r5 == 16) goto L30;
        return false;
    L32:
        return false;
    L18:
        if (r3.a != 9) goto L22;
        if (r3.c != 61) goto L22;
        return true;
    L8:
        if (tc0.c.h().A == null) goto L10;
        return false;
    }

    public static final boolean V() {
        j r2 = null;
        if (((Boolean) vm2.d.f6.getValue(null, vm2.d.a[367(0x16f, float:5.14E-43)])).booleanValue() == true) goto L5;
        return false;
    L5:
        com.bytedance.live.datacontext.j r0 = m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L10;
        r2 = r1.t();
    L10:
        if (r2 == null) goto L23;
        int r3 = r2.a;
        if (r3 != 8) goto L14;
        List r4 = r2.b;
        if (r4 != null) goto L22;
        return false;
    L22:
        return r4.contains(2);
    L14:
        if (r3 != 12) goto L16;
    L18:
        return true;
    L16:
        if (r3 == 16) goto L18;
        return false;
    L23:
        return false;
    }

    public static final boolean Y() {
        return k.n(IMiddlewareUserService.class).user().c();
    }

    public static final List<KtvMusic> Z() {
        return k.n(IKtvService.class).getKtvRoomCurSelfOrderList(b0());
    }

    public static final String b0() {
        return k.n(IMiddlewareUserService.class).user().n();
    }

    public static final ILinkPlayerInfoBridge c() {
        l.n2.getClass();
        l r0 = l.a.a();
        if (r0 != null) goto L5;
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 != null) goto L9;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r2 = IVoiceChatGuestService.a.a();
        if (r2 != null) goto L13;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r3 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r3 != null) goto L17;
        return null;
    L17:
        return r3.currentCPositionUser();
    L13:
        return r2.currentCPositionUser();
    L9:
        return r1.currentCPositionUser();
    L5:
        return r0.currentCPositionUser();
    }

    public static final boolean c0() {
        return ((Boolean) vm2.d.R2.getValue(null, vm2.d.a[197(0xc5, float:2.76E-43)])).booleanValue();
    }

    public static final List<Integer> d() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L26;
        l.n2.getClass();
        if (l.a.a() != null) goto L26;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L14;
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() != null) goto L14;
        return CollectionsKt.emptyList();
    L14:
        u r0 = m.d();
        if (r0 == null) goto L25;
        com.bytedance.live.datacontext.j r1 = r0.s();
        if (r1 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L25;
        List<Integer> r4 = r3.c;
        if (r4 == null) goto L25;
        return r4;
    L25:
        return CollectionsKt.emptyList();
    L26:
        u r5 = m.d();
        if (r5 == null) goto L37;
        com.bytedance.live.datacontext.j r6 = r5.getVideoTalkRoomSubScene();
        if (r6 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L37;
        j r8 = r7.t();
        if (r8 == null) goto L37;
        List<Integer> r9 = r8.b;
        if (r9 == null) goto L37;
        return r9;
    L37:
        return CollectionsKt.emptyList();
    }

    public static final int f() {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L8;
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentScene();
    L8:
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() == null) goto L14;
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 != null) goto L13;
        return 0;
    L13:
        return r1.getCurrentScene();
    L14:
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L57;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() != null) goto L57;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L47;
        l.n2.getClass();
        if (l.a.a() != null) goto L47;
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 == null) goto L27;
        int r3 = r2.getLinkMode();
    L29:
        if (v.a(r3, 4) == false) goto L33;
        return 1;
    L33:
        if (v.a(r3, 64) == false) goto L36;
        return 7;
    L36:
        u r4 = m.d();
        if (r4 == null) goto L46;
        com.bytedance.live.datacontext.j r5 = r4.s();
        if (r5 == null) goto L46;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r5.getValue();
        if (r6 == null) goto L46;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r7 = r6.t();
        if (r7 == null) goto L46;
        return r7.a;
    L46:
        return 0;
    L27:
        r3 = 0;
    L47:
        u r8 = m.d();
        if (r8 == null) goto L60;
        com.bytedance.live.datacontext.j r9 = r8.getVideoTalkRoomSubScene();
        if (r9 == null) goto L61;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r10 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r9.getValue();
        if (r10 == null) goto L62;
        j r11 = r10.t();
        if (r11 != null) goto L56;
        return 0;
    L56:
        return r11.a;
    L62:
        return 0;
    L61:
        return 0;
    L60:
        return 0;
    L57:
        return 4;
    }

    public static final String g() {
        return k.n(IKtvService.class).getKtvRoomCurrentSingerIdStr();
    }

    public static final Integer h() {
        rj0.k.m2.getClass();
        if (rj0.k.a.a() != null) goto L23;
        l.n2.getClass();
        if (l.a.a() != null) goto L23;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() != null) goto L15;
        IVoiceChatGuestService.Companion.getClass();
        if (IVoiceChatGuestService.a.a() != null) goto L15;
        if (jc0.a.a() == true) goto L15;
        return null;
    L15:
        com.bytedance.live.datacontext.j r0 = m.d().s();
        if (r0 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 == null) goto L32;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r2 = r1.t();
        if (r2 != null) goto L22;
        return null;
    L22:
        return Integer.valueOf(r2.b);
    L32:
        return null;
    L31:
        return null;
    L23:
        com.bytedance.live.datacontext.j r3 = m.d().getVideoTalkRoomSubScene();
        if (r3 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
        if (r4 == null) goto L35;
        j r5 = r4.t();
        if (r5 != null) goto L30;
        return null;
    L30:
        return Integer.valueOf(r5.c);
    L35:
        return null;
    L34:
        return null;
    }

    public static final int o() {
        if (((IInteractService) k.n(IInteractService.class)).hitStageAB() == false) goto L5;
        return 27;
    L5:
        return 21;
    }

    public static final boolean p() {
        com.bytedance.live.datacontext.m r0 = k.n(IKtvService.class).getHasBgm();
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.getValue();
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    public static final boolean B() {
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        if (r0 == null) goto L9;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        if (r1.isLiveTypeAudio() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean D() {
        String r0 = b0();
        com.bytedance.live.datacontext.m r1 = m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.getOwnerUserIdString();
    L9:
        return Intrinsics.areEqual(r0, r3);
    L7:
        r3 = null;
        goto L9
    }

    public static final boolean F() {
        if (D() == false) goto L7;
        rj0.k.m2.getClass();
        rj0.k r0 = rj0.k.a.a();
        if (r0 == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
    L11:
        if (r1 != null) goto L15;
        return false;
    L15:
        return r1.b5(b0());
    L10:
        r1 = null;
        goto L11
    L7:
        l.n2.getClass();
        l r2 = l.a.a();
        if (r2 == null) goto L10;
        r1 = r2.getLinkUserInfoCenter();
        goto L11
    }

    public static final boolean L() {
        Integer r0 = h();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 63) goto L8;
        return true;
    }

    public static final boolean M() {
        if (f() != 16) goto L11;
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        if (r0 == null) goto L11;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L11;
        if (r1.isLiveTypeAudio() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean N() {
        int r0 = f();
        if (r0 != 8) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 12) goto L8;
        return false;
    }

    public static final boolean O() {
        if (N() == false) goto L5;
    L8:
        return true;
    L5:
        if (M() == true) goto L8;
        return false;
    }

    public static final boolean P() {
        Integer r0 = h();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 29) goto L8;
        return true;
    }

    public static final boolean W() {
        if (vm2.d.C0() == true) goto L6;
        ALogger.i("VideoKtv", "roomSupportVideoKtv,live_video_ktv_enable is false");
        return false;
    L6:
        float r3 = z0.b(true);
        ALogger.i("VideoKtv", "roomSupportVideoKtv,score:" + r3);
        if (r3 > 0) goto L9;
    L10:
        return true;
    L9:
        if (r3 >= vm2.d.D0()) goto L10;
        return false;
    }

    public static final String a() {
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        return r1.getOwnerUserIdString();
    L7:
        return null;
    }

    public static final long a0() {
        Room r0 = m.i().getCurrentRoom();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getRoomId();
    }

    public static final boolean q() {
        if (D() == true) goto L9;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 != null) goto L7;
        return true;
    L7:
        if (r0.isEngineOn() == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean r() {
        return Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE);
    }

    public static final boolean s() {
        if (f() != 16) goto L11;
        com.bytedance.live.datacontext.m r0 = m.i().getRoom();
        if (r0 == null) goto L11;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L11;
        if (r1.isLiveTypeAudio() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean u() {
        if (f() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean v() {
        com.bytedance.live.datacontext.j r0 = m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L9;
        j r2 = r1.t();
        if (r2 == null) goto L9;
        return d0.e(r2.b);
    L9:
        return false;
    }

    public static final boolean w() {
        if (f() != 12) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean y() {
        if (f() != 9) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean z() {
        Integer r0 = h();
        if (r0 != null) goto L6;
    L7:
        Integer r1 = h();
        if (r1 != null) goto L11;
    L13:
        return false;
    L11:
        if (r1.intValue() != 113) goto L13;
    L14:
        return true;
    L6:
        if (r0.intValue() == 15) goto L14;
        goto L7
    }

    public static final boolean C(ILinkPlayerInfoBridge r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isSelf");
        IBaseUser r2 = r1.getUser();
        if (r2 == null) goto L5;
        String r3 = r2.getIdString();
    L7:
        return Intrinsics.areEqual(r3, b0());
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean E(DataCenter r1) {
        String r0 = b0();
        if (r1 == null) goto L7;
        IRoom r2 = a0.o(r1);
        if (r2 == null) goto L7;
        String r3 = r2.getOwnerUserIdString();
    L9:
        return Intrinsics.areEqual(r0, r3);
    L7:
        r3 = null;
        goto L9
    }

    public static final boolean I(Integer r3) {
        if (r3 != null) goto L6;
    L8:
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.intValue() != 1) goto L13;
        return true;
    L13:
        return false;
    L6:
        if (r3.intValue() != 2) goto L8;
        return true;
    }

    public static final com.bytedance.android.live.liveinteract.multianchor.model.c T(com.bytedance.android.livesdk.link.model.bridge.k r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$parseListUserExtra");
        if (r5.getListUserExtra() != null) goto L5;
        String r0 = r5.getExtra();
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L21;
        return null;
    L21:
        am3.c r2 = ((IMiddlewareNetworkService) k.n(IMiddlewareNetworkService.class)).getProtoDecoder(com.bytedance.android.live.liveinteract.multianchor.model.c.class);     // Catch: Exception -> L18
        byte[] r3 = Base64.decode(r5.getExtra(), 0);     // Catch: Exception -> L18
        am3.g r4 = new am3.g();     // Catch: Exception -> L18
        r4.k(new am3.b(r3));     // Catch: Exception -> L18
        r5.setListUserExtra((com.bytedance.android.live.liveinteract.multianchor.model.c) r2.decode(r4));     // Catch: Exception -> L18
        return r5.getListUserExtra();
    L18:
        e = move-exception;
        ALogger.e("ttlive_msg", e.toString());
        return null;
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L14
    L5:
        return r5.getListUserExtra();
    }

    public static final long b(long r2) {
        return System.currentTimeMillis() - r2;
    }

    public static final IRoom e(DataCenter r1) {
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.m r2 = m.l(r1, null).getRoom();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (IRoom) r2.getValue();
    L8:
        com.bytedance.live.datacontext.m r3 = m.i().getRoom();
        if (r3 != null) goto L11;
        return null;
    L11:
        return (IRoom) r3.getValue();
    }

    public static final ArrayList<ILinkPlayerInfoBridge> e0(List<? extends n0> r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$toLinkPlayerInfo");
        ArrayList<ILinkPlayerInfoBridge> r1 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L18;
        n0 r2 = (n0) r7.next();
        Intrinsics.checkNotNullParameter(r2, "$this$toLinkPlayerInfo");
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r3.setHasApplied(r2.isHasApplied());
        r3.setUser(r2.getUserFlex());
        r3.setModifyTime(r2.getModifyTime());
        r3.setLinkStatus(r2.getMLinkStatus());
        r3.setLinkType(r2.getMLinkType());
        r3.setRoleType(r2.getMRoleType());
        r3.setUserPositionFlex(r2.getUserPosition());
        r3.setSilenceStatus(r2.getSilenceStatus());
        r3.setInteractId(r2.getLinkmicIdStr());
        r3.setSongList(r2.getSongListFlex());
        r3.setOrderedSongCount(r2.getOrderedSongCount());
        r3.setClientVersion(r2.getClientVersion());
        r3.setAppId(r2.getAppId());
        r3.setDevicePlatform(r2.getDevicePlatform());
        r3.setListUserType(r2.getListUserType());
        r3.setListUserFromType(r2.getListUserFromType());
        r3.setWaitingListUserInfo((o0) vh7.f.c(o0.class));
        o0 r4 = r3.getWaitingListUserInfo();
        if (r4 == null) goto L8;
        r4.setHasExpired(r2.getHasExpired());
    L8:
        o0 r5 = r3.getWaitingListUserInfo();
        if (r5 == null) goto L11;
        r5.setMutualFollow(r2.isMutualFollow());
    L11:
        o0 r8 = r3.getWaitingListUserInfo();
        if (r8 == null) goto L14;
        r8.setApplyReason(r2.getApplyReason());
    L14:
        o0 r9 = r3.getWaitingListUserInfo();
        if (r9 == null) goto L17;
        r9.setLast7DaysGiftCountTxt(r2.getLast7DaysGiftCountTxt());
    L17:
        r3.setFuzzyFanTicket(r2.getFanTicket());
        r3.setRank(r2.getRank());
        r3.setAlreadyInvited(r2.getAlreadyInvited());
        r3.setAddPrice(r2.isAddPrice());
        r3.setAddPriceTime(r2.getAddPriceTime());
        r3.setAnonymous(r2.isAnonymous());
        r3.setMicPosTagInfo(r2.getMicPosTagFlex());
        r3.setApplyType(r2.getApplyType());
        r3.setInvitor(r2.getInvitorFlex());
        r3.setPaidAmount(r2.getPaidAmount());
        r3.setJoinTeamFightInfo(r2.getJoinTeamFightInfoFlex());
        r3.setInvitor(r2.getInvitorFlex());
        r3.setApplyTypeNew(r2.getApplyType());
        r3.setUserHighScoreSongTag(r2.getUserHighScoreSongTagFlex());
        r3.setTags(r2.getTags());
        r3.setEventInfo(r2.getEventInfoFlex());
        r3.setButtonText(r2.getButtonText());
        r3.setTag(r2.getTag());
        r1.add(r3);
        goto L4
    L18:
        return r1;
    }

    public static final String g0(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r5) {
        StringBuilder r0 = new StringBuilder("ListUsers{size=");
        if (r5 == null) goto L5;
        int r1 = r5.size();
    L6:
        r0.append(r1);
        r0.append(",");
        if (r5 == null) goto L15;
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L15;
        com.bytedance.android.livesdk.link.model.bridge.k r2 = (com.bytedance.android.livesdk.link.model.bridge.k) r6.next();
        r0.append("[");
        if (r2.getUser() == null) goto L14;
        r0.append("id=");
        IBaseUser r3 = r2.getUser();
        Intrinsics.checkNotNull(r3);
        r0.append(r3.getIdString());
        r0.append(",");
    L14:
        r0.append("pos=");
        r0.append(r2.getUserPosition());
        r0.append(",silence=");
        r0.append(r2.getSilenceStatus());
        r0.append(",linkId=");
        r0.append(r2.getLinkMicIdStr());
        r0.append(",linkType=");
        r0.append(r2.getLinkType());
        r0.append(",isBg=");
        r0.append(r2.isBackground());
        r0.append(",mc=");
        r0.append(r2.getMcStatus());
        r0.append(",isCPos=");
        r0.append(CPositionModeUtil.isCPositionUser(r2));
        r0.append("]");
    L15:
        r0.append("}");
        return r0.toString();
    L5:
        r1 = 0;
        goto L6
    }

    public static final int j(com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$getAppLogLinkCnt");
        Iterable r7 = r6.getOnlineUserList();
        if (r7 == null) goto L26;
        ArrayList r1 = new ArrayList();
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L20;
        Object r2 = r8.next();
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L10;
        String r5 = r4.getIdString();
    L11:
        boolean r9 = true;
        if ((!Intrinsics.areEqual(r5, b0())) == true) goto L14;
    L16:
        r9 = false;
    L17:
        if (r9 == false) goto L6;
        r1.add(r2);
        goto L6
    L14:
        if (r3.getRoleType() == 1) goto L16;
    L10:
        r5 = null;
        goto L11
    L20:
        return r1.size();
    L26:
        return 0;
    }

    public static final boolean j0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        l.n2.getClass();
        l r1 = l.a.a();
        if (r1 != null) goto L11;
        rj0.k.m2.getClass();
        rj0.k r3 = rj0.k.a.a();
        if (r3 != null) goto L15;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r4 = IVoiceChatGuestService.a.a();
        if (r4 != null) goto L19;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r5 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r5 != null) goto L23;
        IVoiceChatGuestService r6 = IVoiceChatGuestService.a.a();
        if (r6 != null) goto L27;
        com.bytedance.android.live.liveinteract.voicechat.d r7 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r7 != null) goto L31;
        return false;
    L31:
        return r7.userIsCPosition(r2);
    L27:
        return r6.userIsCPosition(r2);
    L23:
        return r5.userIsCPosition(r2);
    L19:
        return r4.userIsCPosition(r2);
    L15:
        return r3.userIsCPosition(r2);
    L11:
        return r1.userIsCPosition(r2);
    L5:
        r0 = false;
        goto L6
    }

    public static final String k(DataCenter r1) {
        if (r1 == null) goto L7;
        IRoom r2 = a0.o(r1);
        if (r2 == null) goto L7;
        String r3 = r2.getIdStr();
        if (r3 == null) goto L7;
    L9:
        return l(r3, false);
    L7:
        r3 = "0";
        goto L9
    }

    public static final List<KtvMusic> k0(String r1) {
        Intrinsics.checkNotNullParameter(r1, "userId");
        return k.n(IKtvService.class).getKtvRoomCurSelfOrderList(r1);
    }

    public static final boolean t(Integer r3) {
        return !((List) vm2.i.D.getValue(null, vm2.i.a[28])).contains(String.valueOf(r3));
    }

    public static final boolean x(Integer r2) {
        if (r2 != null) goto L6;
    L7:
        if (r2 != null) goto L10;
    L12:
        return false;
    L10:
        if (r2.intValue() != 3) goto L12;
        return true;
    L6:
        if (r2.intValue() != 1) goto L7;
        return true;
    }

    public static final boolean J(boolean r4, boolean r5) {
        ReadOnlyProperty r0 = vm2.d.M2;
        KProperty[] r1 = vm2.d.a;
        if (((Boolean) r0.getValue(null, r1[192(0xc0, float:2.69E-43)])).booleanValue() == false) goto L26;
        if (r4 == true) goto L22;
        if (r5 == false) goto L23;
        com.bytedance.live.datacontext.m r6 = m.i().getRoom();
        if (r6 == null) goto L24;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L27;
        String r8 = e0.a(r7, "live_video_enable_c_position");
        if (r8.length() != 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
    L20:
        return true;
    L19:
        if (Intrinsics.areEqual(r8, "2") == true) goto L20;
        return false;
    L16:
        r9 = false;
        goto L17
    L27:
        return false;
    L24:
        return false;
    L23:
        return false;
    L22:
        return ((Boolean) vm2.d.E6.getValue(null, r1[392(0x188, float:5.5E-43)])).booleanValue();
    L26:
        return false;
    }

    public static final boolean K(boolean r3, boolean r4) {
        if (((Boolean) vm2.d.N2.getValue(null, vm2.d.a[193(0xc1, float:2.7E-43)])).booleanValue() == true) goto L5;
        return false;
    L5:
        if (r3 == true) goto L9;
        if (r4 == true) goto L9;
        return false;
    L9:
        com.bytedance.live.datacontext.m r5 = m.i().getRoom();
        if (r5 == null) goto L16;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L16;
        return Intrinsics.areEqual(e0.a(r6, "live_audio_enable_c_position"), "2");
    L16:
        return false;
    }

    public static final void Q(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        if (r2 == null) goto L5;
        StackTraceElement[] r3 = r2.getStackTrace();
    L6:
        ALogger.stacktrace(6, r1, r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static final ILinkPlayerInfoBridge d0(com.bytedance.android.livesdk.link.model.bridge.k r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$toLinkPlayerInfo");
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r0.setUser(r8.getUser());
        Long r1 = r8.getKSongUid();
        if (r1 == null) goto L5;
        long r2 = r1.longValue();
    L6:
        r0.setKSongUid(Long.valueOf(r2));
        r0.setInteractId(r8.getLinkMicIdStr());
        r0.setLinkMicUniqueIdStr(r8.getLinkMicUniqueIdStr());
        r0.setLinkStatus(r8.getStatus());
        r0.setLinkType(r8.getLinkType());
        r0.setUserPositionFlex(r8.getUserPosition());
        r0.setSilenceStatus(r8.getSilenceStatus());
        r0.setMediaType(r8.getLinkType());
        r0.setModifyTime(r8.getModifyTime());
        r0.setRoleType(r8.getRoleType());
        r0.setApplyType(r8.getApplyType());
        r0.setMatchEffect(r8.getMatchEffect());
        r0.setCityEffect(r8.getCityEffect());
        r0.setShowCityEffect(r8.getShowCityEffect());
        r0.setMIsJoinUser(r8.isJoinUser());
        r0.setMcStatus(r8.getMcStatus());
        boolean r3 = false;
        if (((int) r8.isBackground()) != 1) goto L9;
        boolean r4 = true;
    L10:
        r0.setBackground(r4);
        k1 r5 = r8.getContent();
        String r6 = null;
        List r7 = null;
        if (r5 == null) goto L15;
        l1 r10 = r5.getLinkMicAudienceContent();
        if (r10 == null) goto L15;
        kd1.b r11 = r10.getMicDress();
    L16:
        r0.setMicDress(r11);
        k1 r12 = r8.getContent();
        if (r12 == null) goto L23;
        l1 r13 = r12.getLinkMicAudienceContent();
        if (r13 == null) goto L23;
        if (r13.isEnlarged() != true) goto L23;
        r3 = true;
    L23:
        r0.setEnlarged(r3);
        k1 r14 = r8.getContent();
        if (r14 == null) goto L28;
        l1 r15 = r14.getLinkMicAudienceContent();
        if (r15 == null) goto L28;
        Linkmic2DAvatar r16 = r15.getLinkmic2DAvatar();
    L29:
        r0.setLinkmic2DAvatar(r16);
        r0.setMicPosTagInfo(r8.getMicPosTagInfo());
        k1 r17 = r8.getContent();
        if (r17 == null) goto L34;
        l1 r18 = r17.getLinkMicAudienceContent();
        if (r18 == null) goto L34;
        com.bytedance.android.live.liveinteract.model.c r19 = (com.bytedance.android.live.liveinteract.model.c) r18.castTo(com.bytedance.android.live.liveinteract.model.c.class);
    L36:
        if (((Boolean) vm2.d.Z6.getValue(null, vm2.d.a[413(0x19d, float:5.79E-43)])).booleanValue() == true) goto L38;
        if (r9 == true) goto L38;
    L43:
        com.bytedance.android.live.liveinteract.multianchor.model.c r20 = T(r8);
        if (r20 == null) goto L55;
        com.bytedance.android.live.liveinteract.model.b r21 = (com.bytedance.android.live.liveinteract.model.b) r20.castTo(com.bytedance.android.live.liveinteract.model.b.class);
        if (r21 == null) goto L55;
        r0.setFanTicket(r21.getFanTicket());
        int r22 = y.a;
        IBaseUser r23 = r8.getUser();
        if (r23 == null) goto L50;
        String r24 = r23.getIdString();
    L51:
        List<Long> r25 = r21.getRankUserIds();
        if (r25 == null) goto L54;
        r7 = jc1.m.a(r25);
    L54:
        r0.setFanTicketDisplayStr(y.a(r24, r7, r21.getFanTicketRealStr(), r21.getFanTicketFuzzyStr()));
        r0.setHost(r21.isHost());
        r0.setAppId(r21.getAppId());
        r0.setClientVersion(r21.getClientVersion());
        r0.setDevicePlatform(r21.getDevicePlatform());
        r0.setLinkedListUserInfo(p.a(r21.getJoinChannelTime(), r21.getExpectLeaveTime(), r21.getCurrentTime()));
        r0.setListUserRole(r21.getListUserRole());
        goto L55
    L50:
        r24 = null;
    L55:
        return r0;
    L38:
        if (r19 == null) goto L43;
        r0.setFanTicket(r19.getFanTicket());
        int r26 = y.a;
        IBaseUser r27 = r8.getUser();
        if (r27 == null) goto L42;
        r6 = r27.getIdString();
    L42:
        r0.setFanTicketDisplayStr(y.a(r6, com.bytedance.android.live.liveinteract.model.d.a(r19), r19.getFanTicketRealStr(), r19.getFanTicketFuzzyStr()));
        r0.setHost(r19.isHost());
        r0.setAppId(r19.getAppId());
        r0.setClientVersion(r19.getClientVersion());
        r0.setDevicePlatform(r19.getDevicePlatform());
        r0.setLinkedListUserInfo(p.a(r19.getJoinChannelTime(), r19.getExpectLeaveTime(), r19.getCurrentTime()));
        r0.setListUserRole(r19.getListUserRole());
        r0.setPaidCount(r19.getPaidCount());
        r0.setAnonymous(r19.isAnonymous());
        r0.setSelfDisciplineDuration(r19.getSelfDisciplineDurationTime());
        r0.setSelfDisciplineTargetDuration(r19.getSelfDisciplineTargetDuration());
        r0.setThemedCompetitionRole(r19.getThemedCompetitionRole());
        r0.setChorusGuestStatus(r19.getChorusGuestStatus());
        r0.setOriginLinkType(r19.getOriginLinkType());
        r0.setAiGuestType(r19.getAiGuestType());
        r0.setMicHidden(r19.isMicHidden());
    L34:
        r19 = null;
    L28:
        r16 = null;
    L15:
        r11 = null;
        goto L16
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public static final ArrayList<ILinkPlayerInfoBridge> f0(List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$toLinkPlayerInfoList");
        ArrayList<ILinkPlayerInfoBridge> r0 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.link.model.bridge.k r1 = jm2.a.d((com.bytedance.android.livesdk.link.model.bridge.k) r4.next());
        if (r1 == null) goto L9;
        r0.add(d0(r1, r3));
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.IAnchorLinkUserBridge");
    L10:
        return r0;
    }

    public static void h0(ILinkPlayerInfoBridge r8, com.bytedance.android.livesdk.link.model.bridge.k r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$updateByLinkUser");
        Intrinsics.checkNotNullParameter(r9, "linkUser");
        r8.setUser(r9.getUser());
        r8.setInteractId(r9.getLinkMicIdStr());
        r8.setLinkMicUniqueIdStr(r9.getLinkMicUniqueIdStr());
        r8.setLinkStatus(r9.getStatus());
        r8.setLinkType(r9.getLinkType());
        r8.setUserPosition(r9.getUserPosition());
        r8.setSilenceStatus(r9.getSilenceStatus());
        r8.setModifyTime(r9.getModifyTime());
        r8.setRoleType(r9.getRoleType());
        r8.setApplyType(r9.getApplyType());
        r8.setMatchEffect(r9.getMatchEffect());
        r8.setCityEffect(r9.getCityEffect());
        r8.setShowCityEffect(r9.getShowCityEffect());
        r8.setMIsJoinUser(r9.isJoinUser());
        r8.setMcStatus(r9.getMcStatus());
        k1 r0 = r9.getContent();
        List r1 = null;
        String r2 = null;
        if (r0 == null) goto L7;
        l1 r3 = r0.getLinkMicAudienceContent();
        if (r3 == null) goto L7;
        kd1.b r4 = r3.getMicDress();
    L8:
        r8.setMicDress(r4);
        k1 r5 = r9.getContent();
        if (r5 == null) goto L15;
        l1 r6 = r5.getLinkMicAudienceContent();
        if (r6 == null) goto L15;
        boolean r7 = true;
        if (r6.isEnlarged() != true) goto L15;
    L16:
        r8.setEnlarged(r7);
        k1 r10 = r9.getContent();
        if (r10 == null) goto L21;
        l1 r11 = r10.getLinkMicAudienceContent();
        if (r11 == null) goto L21;
        Linkmic2DAvatar r12 = r11.getLinkmic2DAvatar();
    L22:
        r8.setLinkmic2DAvatar(r12);
        r8.setMicPosTagInfo(r9.getMicPosTagInfo());
        k1 r13 = r9.getContent();
        if (r13 == null) goto L27;
        l1 r14 = r13.getLinkMicAudienceContent();
        if (r14 == null) goto L27;
        com.bytedance.android.live.liveinteract.model.c r15 = (com.bytedance.android.live.liveinteract.model.c) r14.castTo(com.bytedance.android.live.liveinteract.model.c.class);
    L29:
        if (((Boolean) vm2.d.Z6.getValue(null, vm2.d.a[413(0x19d, float:5.79E-43)])).booleanValue() == false) goto L36;
        if (r15 == null) goto L36;
        r8.setFanTicket(r15.getFanTicket());
        int r16 = y.a;
        IBaseUser r17 = r8.getUser();
        if (r17 == null) goto L35;
        r2 = r17.getIdString();
    L35:
        r8.setFanTicketDisplayStr(y.a(r2, com.bytedance.android.live.liveinteract.model.d.a(r15), r15.getFanTicketRealStr(), r15.getFanTicketFuzzyStr()));
        r8.setHost(r15.isHost());
        r8.setAppId(r15.getAppId());
        r8.setClientVersion(r15.getClientVersion());
        r8.setDevicePlatform(r15.getDevicePlatform());
        r8.setLinkedListUserInfo(p.a(r15.getJoinChannelTime(), r15.getExpectLeaveTime(), r15.getCurrentTime()));
        r8.setListUserRole(r15.getListUserRole());
        r8.setPaidCount(r15.getPaidCount());
        r8.setAnonymous(r15.isAnonymous());
        r8.setSelfDisciplineDuration(r15.getSelfDisciplineDurationTime());
        r8.setSelfDisciplineTargetDuration(r15.getSelfDisciplineTargetDuration());
        r8.setThemedCompetitionRole(r15.getThemedCompetitionRole());
        r8.setChorusGuestStatus(r15.getChorusGuestStatus());
        r8.setOriginLinkType(r15.getOriginLinkType());
        r8.setAiGuestType(r15.getAiGuestType());
        r8.setMicHidden(r15.isMicHidden());
        return;
    L36:
        com.bytedance.android.live.liveinteract.multianchor.model.c r18 = T(r9);
        if (r18 == null) goto L50;
        com.bytedance.android.live.liveinteract.model.b r19 = (com.bytedance.android.live.liveinteract.model.b) r18.castTo(com.bytedance.android.live.liveinteract.model.b.class);
        if (r19 == null) goto L51;
        r8.setFanTicket(r19.getFanTicket());
        int r20 = y.a;
        IBaseUser r21 = r8.getUser();
        if (r21 == null) goto L43;
        String r22 = r21.getIdString();
    L44:
        List<Long> r23 = r19.getRankUserIds();
        if (r23 == null) goto L47;
        r1 = jc1.m.a(r23);
    L47:
        r8.setFanTicketDisplayStr(y.a(r22, r1, r19.getFanTicketRealStr(), r19.getFanTicketFuzzyStr()));
        r8.setHost(r19.isHost());
        r8.setAppId(r19.getAppId());
        r8.setDevicePlatform(r19.getDevicePlatform());
        r8.setClientVersion(r19.getClientVersion());
        r8.setLinkedListUserInfo(p.a(r19.getJoinChannelTime(), r19.getExpectLeaveTime(), r19.getCurrentTime()));
        r8.setListUserRole(r19.getListUserRole());
        return;
    L43:
        r22 = null;
        goto L44
    L51:
        return;
    L50:
        return;
    L27:
        r15 = null;
    L21:
        r12 = null;
    L15:
        r7 = false;
    L7:
        r4 = null;
        goto L8
    }

    public static final ILinkPlayerInfoBridge i(com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$findLinkUser");
        Intrinsics.checkNotNullParameter(r4, "uid");
        Iterable r5 = r3.getOnlineUserList();
        Object r0 = null;
        if (r5 == null) goto L19;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L15;
        Object r1 = r6.next();
        IBaseUser r2 = ((ILinkPlayerInfoBridge) r1).getUser();
        if (r2 == null) goto L10;
        String r7 = r2.getIdString();
    L12:
        if (Intrinsics.areEqual(r7, r4) == false) goto L6;
        r0 = r1;
        goto L15
    L10:
        r7 = null;
    L15:
        return (ILinkPlayerInfoBridge) r0;
    L19:
        return null;
    }

    public static final boolean i0(boolean r4, boolean r5) {
        f();
        ReadOnlyProperty r0 = vm2.d.V2;
        KProperty[] r1 = vm2.d.a;
        VideoTalkBgDeviceConfig r2 = (VideoTalkBgDeviceConfig) r0.getValue(null, r1[201(0xc9, float:2.82E-43)]);
        if (r4 == false) goto L5;
        float r3 = r2.anchorScore;
    L6:
        float r6 = z0.b(r4);
        if (r5 == true) goto L19;
        boolean r7 = com.bytedance.android.live.liveinteract.plantform.performance.j.a;
        if (com.bytedance.android.live.liveinteract.plantform.performance.j.a == true) goto L11;
        return false;
    L11:
        if (r6 > 0) goto L14;
        return false;
    L14:
        if (r6 < r3) goto L16;
        return false;
    L16:
        if (((Boolean) vm2.d.Y5.getValue(null, r1[360(0x168, float:5.04E-43)])).booleanValue() == true) goto L18;
        return false;
    L18:
        return true;
    L19:
        return false;
    L5:
        r3 = r2.audienceScore;
        goto L6
    }

    public static final String l(String r1, boolean r2) {
        StringBuilder r0 = new StringBuilder();
        if (r1 != null) goto L5;
        r1 = "0";
    L5:
        r0.append(r1);
        r0.append("_");
        if (r2 == false) goto L8;
        String r3 = PbRequest.SwitchType.FEED;
    L9:
        r0.append(r3);
        return r0.toString();
    L8:
        r3 = PbRequest.SwitchType.ROOM;
        goto L9
    }

    public static final int m(Map<String, Long> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "linkMap");
        int r0 = 0;
        if (r6 == false) goto L18;
        boolean r1 = r5.containsKey(String.valueOf(5));
        com.bytedance.android.livesdk.chatroom.viewmodel.f.a.getClass();
        Iterator r2 = com.bytedance.android.livesdk.chatroom.viewmodel.f.a.a.iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        int r3 = ((Number) r2.next()).intValue();
        if (r3 == 5) goto L6;
        if (r5.containsKey(String.valueOf(r3)) == false) goto L6;
        r0 = r3;
        goto L6
    L12:
        if (r0 != 0) goto L16;
        if (r1 == false) goto L16;
        return 5;
    L16:
        return r0;
    L18:
        if (r5.isEmpty() == false) goto L21;
        return 0;
    L21:
        if (r5.containsKey(String.valueOf(16)) == false) goto L24;
        return 16;
    L24:
        if (r5.containsKey(String.valueOf(12)) == false) goto L26;
        return 12;
    L26:
        return 8;
    }

    public static final py.k n(IBaseUser r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$getUserAvatar");
        if (r3 != AvatarType.AVATAR_THUMB.getValue()) goto L21;
        py.k r4 = r2.getAvatarThumbKt();
        if (r4 != null) goto L7;
    L9:
        py.k r5 = r2.getAvatarMedium();
        if (r5 != null) goto L12;
    L14:
        py.k r6 = r2.getAvatarLarge();
        if (r6 == null) goto L58;
        if ((!UtilityKotlinExtentionsKt.n(r6)) != true) goto L58;
        return r2.getAvatarLarge();
    L58:
        return r2.getAvatarLarge();
    L12:
        if ((!UtilityKotlinExtentionsKt.n(r5)) != true) goto L14;
        return r2.getAvatarMedium();
    L7:
        if ((!UtilityKotlinExtentionsKt.n(r4)) != true) goto L9;
        return r2.getAvatarThumbKt();
    L21:
        if (r3 != AvatarType.AVATAR_MEDIUM.getValue()) goto L38;
        py.k r7 = r2.getAvatarMedium();
        if (r7 != null) goto L25;
    L27:
        py.k r8 = r2.getAvatarThumbKt();
        if (r8 != null) goto L30;
    L32:
        py.k r9 = r2.getAvatarLarge();
        if (r9 == null) goto L62;
        if ((!UtilityKotlinExtentionsKt.n(r9)) != true) goto L62;
        return r2.getAvatarLarge();
    L62:
        return r2.getAvatarLarge();
    L30:
        if ((!UtilityKotlinExtentionsKt.n(r8)) != true) goto L32;
        return r2.getAvatarThumbKt();
    L25:
        if ((!UtilityKotlinExtentionsKt.n(r7)) != true) goto L27;
        return r2.getAvatarMedium();
    L38:
        py.k r10 = r2.getAvatarLarge();
        if (r10 != null) goto L41;
    L43:
        py.k r11 = r2.getAvatarMedium();
        if (r11 != null) goto L46;
    L48:
        py.k r12 = r2.getAvatarThumbKt();
        if (r12 == null) goto L54;
        if ((!UtilityKotlinExtentionsKt.n(r12)) != true) goto L54;
        return r2.getAvatarThumbKt();
    L54:
        return r2.getAvatarThumbKt();
    L46:
        if ((!UtilityKotlinExtentionsKt.n(r11)) != true) goto L48;
        return r2.getAvatarMedium();
    L41:
        if ((!UtilityKotlinExtentionsKt.n(r10)) != true) goto L43;
        return r2.getAvatarLarge();
    }

    public static final boolean X(boolean r6, IRoom r7, boolean r8) {
        boolean r1 = false;
        if (((Boolean) vm2.d.P2.getValue(null, vm2.d.a[195(0xc3, float:2.73E-43)])).booleanValue() == true) goto L7;
        if (r8 == false) goto L49;
        int r9 = x.a;
        x.h(false, r6, "client switcher off");
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.l(false, r6, "client switcher off");
        return false;
    L49:
        return false;
    L7:
        if (r6 == true) goto L9;
        String r10 = e0.a(r7, "video_talk_enable_avatar");
        if (us1.d.a() == true) goto L29;
    L46:
        if (r8 == false) goto L54;
        int r11 = x.a;
        x.h(r1, r6, "roomMapValue:" + r10 + ", deviceSupportEffect:" + us1.d.a() + "deviceScore:" + z0.b(r6) + ", scoreLimit:" + vm2.d.B0());
        TalkRoomBusinessFullLinkMonitor r12 = TalkRoomBusinessFullLinkMonitor.a;
        String r13 = "roomMapValue:" + r10 + ", deviceSupportEffect:" + us1.d.a() + "deviceScore:" + z0.b(r6) + ", scoreLimit:" + vm2.d.B0();
        r12.getClass();
        TalkRoomBusinessFullLinkMonitor.l(r1, r6, r13);
        return r1;
    L54:
        return r1;
    L29:
        if (r10.length() != 0) goto L31;
        boolean r4 = true;
    L32:
        if (r4 == false) goto L34;
    L35:
        float r5 = z0.b(r6);
        if (r5 > 0) goto L38;
    L41:
        boolean r14 = true;
    L42:
        if (r14 == false) goto L46;
        if (o.o(null) == true) goto L46;
        r1 = true;
        goto L46
    L38:
        if (r5 >= vm2.d.B0()) goto L41;
        r14 = false;
        goto L42
    L34:
        if (Intrinsics.areEqual(r10, "2") == false) goto L46;
    L31:
        r4 = false;
        goto L32
    L9:
        if (vm2.d.z0() == false) goto L19;
        float r15 = z0.b(r6);
        if (r15 > 0) goto L13;
    L16:
        boolean r16 = true;
    L17:
        if (r16 == false) goto L19;
        boolean r17 = true;
    L20:
        if (r8 == false) goto L22;
        int r18 = x.a;
        x.h(r17, r6, "hitAb:" + vm2.d.z0() + ",deviceScore:" + z0.b(r6) + ", scoreLimit:" + vm2.d.A0());
        TalkRoomBusinessFullLinkMonitor r19 = TalkRoomBusinessFullLinkMonitor.a;
        String r2 = "hitAb:" + vm2.d.z0() + ",deviceScore:" + z0.b(r6) + ", scoreLimit:" + vm2.d.A0();
        r19.getClass();
        TalkRoomBusinessFullLinkMonitor.l(r17, r6, r2);
    L22:
        if (r17 == true) goto L24;
        return false;
    L24:
        if (jc0.a.c() == true) goto L52;
        return true;
    L52:
        return false;
    L13:
        if (r15 >= vm2.d.A0()) goto L16;
        r16 = false;
    L19:
        r17 = false;
        goto L20
    }
}
