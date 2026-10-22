package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.live.liveinteract.plantform.model.o0;
import com.bytedance.android.live.liveinteract.plantform.model.z0;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.e0;
import com.bytedance.android.livesdk.config.link.InteractFrequencyConfig;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public static final SimpleDateFormat a = null;
    public static final g b = null;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.c.e1;
            if (this.a == false) goto L5;
            int r1 = 1;
        L6:
            Integer r2 = Integer.valueOf(r1);
            r0.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r0, r2);
            if (TextUtils.isEmpty(((z0) r4.data).a()) == true) goto L10;
            f2.c(((z0) r4.data).a(), 0);
        L10:
            if (this.a == false) goto L13;
            w.d();
            return;
        L13:
            return;
        L5:
            r1 = 2;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            ((Throwable) r2).printStackTrace();
            ALogger.e("[PaidQueue]", String.valueOf(Unit.INSTANCE));
        }
    }

    static {
        a = new SimpleDateFormat("yyyy-MM-dd");
        b = new g((InteractFrequencyConfig) vm2.d.x0.getValue(null, vm2.d.a[73]));
    }

    public static final boolean B() {
        com.bytedance.android.live.liveinteract.revenue.fight.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r0 == null) goto L9;
        com.bytedance.android.live.liveinteract.revenue.fight.a r1 = r0.o3();
        if (r1 == null) goto L9;
        if (r1.isFightShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean I() {
        return jc1.k.n(IMiddlewareUserService.class).user().c();
    }

    public static final String J() {
        return jc1.k.n(IMiddlewareUserService.class).user().n();
    }

    public static final int c() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public static final int d() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentUiLayout();
    }

    public static final String j() {
        StringBuilder r0 = new StringBuilder();
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r0.append(com.bytedance.android.live.liveinteract.api.data.a.C0017a.g() + "抖币");
        r0.append(" ");
        int r1 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.f();
        if (r1 >= 120) goto L5;
        String r2 = r1 + "秒";
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = (r1 / 60) + "分钟";
        goto L6
    }

    public static final boolean s() {
        if (((Boolean) vm2.h.t5.getValue(null, vm2.h.a[330(0x14a, float:4.62E-43)])).booleanValue() == false) goto L10;
        Integer r0 = (Integer) com.bytedance.android.livesdk.sharedpref.c.e1.getValue();
        if (r0 != null) goto L8;
    L9:
        return true;
    L8:
        if (r0.intValue() != 0) goto L9;
    L10:
        return false;
    }

    public static final boolean u() {
        if (jc1.k.n(IKtvService.class).isKtvComponentOpen() == false) goto L5;
        return true;
    L5:
        if (c() != 9) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r0 = false;
        goto L8
    }

    public static final boolean w() {
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService().isKtvOn() == false) goto L5;
    L8:
        return true;
    L5:
        if (v() == true) goto L8;
        return false;
    }

    public static final boolean y() {
        cj0.a r0 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicContext();
        if (r0 == null) goto L9;
        cj0.c r1 = r0.getWidget();
        if (r1 == null) goto L9;
        if (r1.isIncreasePriceOn() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean z() {
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L13;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r0 = MultiRevenueDataContext.a.c();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 != true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.isPaidLinkOn() != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public static final boolean C() {
        if (c() != 16) goto L11;
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L11;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L11;
        if (r1.isLiveTypeAudio() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean D() {
        int r0 = c();
        if (r0 != 8) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 12) goto L8;
        return false;
    }

    public static final boolean H() {
        if (vm2.d.C0() == true) goto L6;
        ALogger.i("VideoKtv", "roomSupportVideoKtv,live_video_ktv_enable is false");
        return false;
    L6:
        float r3 = com.bytedance.android.livesdk.utils.z0.b(true);
        ALogger.i("VideoKtv", "roomSupportVideoKtv,score:" + r3);
        if (r3 > 0) goto L9;
    L10:
        return true;
    L9:
        if (r3 >= vm2.d.D0()) goto L10;
        return false;
    }

    public static final IRoom b() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (IRoom) r0.getValue();
    }

    public static final String g() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        IRoomOthersData r2 = r1.getRoomOthers();
    L9:
        if ((r2 instanceof RoomOthersData) == true) goto L11;
        r2 = null;
    L11:
        RoomOthersData r3 = (RoomOthersData) r2;
        if (r3 != null) goto L14;
        return null;
    L14:
        return r3.getInvitePanelGuideContent();
    L7:
        r2 = null;
        goto L9
    }

    public static final String i() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L7;
        return "anchor";
    L7:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L10;
        return "admin";
    L10:
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L14;
        return "audience";
    L14:
        if (r0.intValue() != 2) goto L17;
        return "guest";
    L17:
        return "audience";
    }

    public static final boolean k() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        String r2 = r1.getAnchorAbValue("link_efficiency");
    L9:
        if (Intrinsics.areEqual(r2, "1") == false) goto L11;
    L14:
        return true;
    L11:
        if (Intrinsics.areEqual(r2, "2") == true) goto L14;
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public static final boolean l() {
        if (c() != 16) goto L11;
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L11;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L11;
        if (r1.isLiveTypeAudio() != true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean m() {
        if (c() != 5) goto L5;
        return true;
    L5:
        if (c() == 9) goto L16;
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L13;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L13;
        if (r1.isLiveTypeAudio() != true) goto L13;
        return true;
    L13:
        return false;
    L16:
        return true;
    }

    public static final boolean n() {
        if (c() != 5) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (l() == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public static final boolean v() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r2 = r1.t();
        if (r2 == null) goto L11;
        if (r2.a != 9) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean A(IRoom r2) {
        if (r2 == null) goto L7;
        Map r3 = r2.getAnchorABMap();
        if (r3 == null) goto L7;
        String r4 = (String) r3.get("bigevent_disable_lynx_panel");
    L9:
        if (Intrinsics.areEqual(r4, "2") == false) goto L12;
    L18:
        return false;
    L12:
        if (vm2.i.a().getLinkServiceEnable() == false) goto L18;
        if (vm2.i.b().getSettingPanelOpen() == false) goto L16;
    L17:
        return true;
    L16:
        if (o(null) == false) goto L18;
    L7:
        r4 = null;
        goto L9
    }

    public static final boolean F(int r3) {
        if (((Boolean) vm2.d.J6.getValue(null, vm2.d.a[397(0x18d, float:5.56E-43)])).booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (r3 != 28) goto L8;
        return false;
    }

    public static final boolean G(IRoom r6) {
        ReadOnlyProperty r0 = vm2.d.E0;
        KProperty[] r1 = vm2.d.a;
        if (((Boolean) r0.getValue(null, r1[80])).booleanValue() == true) goto L7;
        ALogger.w("supportKtvCamera", "LIVE_KTV_CAMERA_CLIENT_ENABLE:false");
        return false;
    L7:
        if (r6 == null) goto L9;
        e0.a(r6, "ktv_enable_open_camera");
    L18:
        boolean r7 = ((Boolean) vm2.d.p1.getValue(null, r1[117(0x75, float:1.64E-43)])).booleanValue();
        ALogger.w("supportKtvCamera", "roomSupportKtv:" + r7);
        if (r7 == true) goto L30;
        float r8 = com.bytedance.android.livesdk.utils.z0.b(true);
        if (r8 > 0) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L30;
        if (((Boolean) vm2.d.F0.getValue(null, r1[81])).booleanValue() == true) goto L30;
        return false;
    L23:
        if (r8 >= ((Number) vm2.d.I0.getValue(null, r1[84])).floatValue()) goto L26;
        r9 = false;
    L30:
        return true;
    L9:
        int r10 = e0.a;
        IRoomContextService r11 = jc1.k.f(IRoomContextService.class);
        if (r11 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.o r12 = r11.getRoomDataContext(com.bytedance.live.datacontext.d.d(com.bytedance.android.livesdk.chatroom.o.class));
        if (r12 == null) goto L16;
        com.bytedance.live.datacontext.m r13 = r12.getRoom();
        if (r13 == null) goto L16;
        IRoom r14 = (IRoom) r13.getValue();
    L17:
        e0.a(r14, "ktv_enable_open_camera");
    L16:
        r14 = null;
        goto L17
    }

    public static final boolean L(ILinkPlayerInfoBridge r4) {
        Intrinsics.checkNotNullParameter(r4, "linkPlayerInfo");
        z();
        if (z() == false) goto L5;
    L7:
        return false;
    L5:
        if (r4.getPaidAmount() <= 0) goto L7;
        return true;
    }

    public static final ILinkPlayerInfoBridge M(n0 r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toLinkPlayerInfo");
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r0.setHasApplied(r4.isHasApplied());
        r0.setUser(r4.getUserFlex());
        r0.setModifyTime(r4.getModifyTime());
        r0.setLinkStatus(r4.getMLinkStatus());
        r0.setLinkType(r4.getMLinkType());
        r0.setRoleType(r4.getMRoleType());
        long r1 = r4.getUserPosition();
        Intrinsics.checkNotNullParameter(r0, "$this$userPositionKt");
        r0.setUserPositionFlex((int) r1);
        r0.setSilenceStatus(r4.getSilenceStatus());
        r0.setInteractId(r4.getLinkmicIdStr());
        r0.setSongList(r4.getSongListFlex());
        r0.setOrderedSongCount(r4.getOrderedSongCount());
        r0.setClientVersion(r4.getClientVersion());
        r0.setAppId(r4.getAppId());
        r0.setDevicePlatform(r4.getDevicePlatform());
        r0.setListUserType(r4.getListUserType());
        r0.setListUserFromType(r4.getListUserFromType());
        r0.setWaitingListUserInfo((o0) vh7.f.c(o0.class));
        o0 r2 = r0.getWaitingListUserInfo();
        if (r2 == null) goto L5;
        r2.setHasExpired(r4.getHasExpired());
    L5:
        o0 r3 = r0.getWaitingListUserInfo();
        if (r3 == null) goto L8;
        r3.setMutualFollow(r4.isMutualFollow());
    L8:
        o0 r5 = r0.getWaitingListUserInfo();
        if (r5 == null) goto L11;
        r5.setApplyReason(r4.getApplyReason());
    L11:
        o0 r6 = r0.getWaitingListUserInfo();
        if (r6 == null) goto L14;
        r6.setLast7DaysGiftCountTxt(r4.getLast7DaysGiftCountTxt());
    L14:
        r0.setFuzzyFanTicket(r4.getFanTicket());
        r0.setRank(r4.getRank());
        r0.setAlreadyInvited(r4.getAlreadyInvited());
        r0.setAddPrice(r4.isAddPrice());
        r0.setAddPriceTime(r4.getAddPriceTime());
        r0.setAnonymous(r4.isAnonymous());
        r0.setMicPosTagInfo(r4.getMicPosTagFlex());
        r0.setApplyType(r4.getApplyType());
        r0.setInvitor(r4.getInvitorFlex());
        r0.setPaidAmount(r4.getPaidAmount());
        r0.setJoinTeamFightInfo(r4.getJoinTeamFightInfoFlex());
        r0.setInvitor(r4.getInvitorFlex());
        r0.setApplyTypeNew(r4.getApplyType());
        r0.setUserHighScoreSongTag(r4.getUserHighScoreSongTagFlex());
        r0.setTags(r4.getTags());
        r0.setEventInfo(r4.getEventInfo());
        r0.setButtonText(r4.getButtonText());
        r0.setTag(r4.getTag());
        return r0;
    }

    public static final ArrayList<ILinkPlayerInfoBridge> N(List<? extends n0> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toLinkPlayerInfo");
        ArrayList<ILinkPlayerInfoBridge> r0 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(M((n0) r3.next()));
        goto L4
    L6:
        return r0;
    }

    public static final boolean o(Integer r5) {
        if (r5 != null) goto L5;
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L13;
        Integer r7 = Integer.valueOf(r6.getCurrentUiLayout());
    L14:
        if (r7 != null) goto L17;
    L18:
        if (r7 != null) goto L21;
        return false;
    L21:
        if (r7.intValue() != 63) goto L25;
    L22:
        return true;
    L25:
        return false;
    L17:
        if (r7.intValue() == 62) goto L22;
    L13:
        r7 = null;
        goto L14
    L5:
        if (r5.intValue() != 62) goto L7;
    L8:
        return true;
    L7:
        if (r5.intValue() == 63) goto L8;
        return false;
    }

    public static final boolean p(DataCenter r3) {
        if (r3 == null) goto L17;
        IRoom r1 = (IRoom) r3.get("data_room");
        if (r1 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual((Boolean) r3.get("data_is_anchor"), Boolean.TRUE) == true) goto L10;
        return false;
    L10:
        if (r1.isLiveTypeAudio() != true) goto L12;
        return false;
    L12:
        if (vm2.d.r0() == true) goto L14;
        return false;
    L14:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L21;
        return true;
    L21:
        return false;
    L17:
        return false;
    }

    public static final boolean q(DataCenter r3) {
        if (r3 == null) goto L17;
        IRoom r1 = (IRoom) r3.get("data_room");
        if (r1 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual((Boolean) r3.get("data_is_anchor"), Boolean.TRUE) == true) goto L10;
        return false;
    L10:
        if (r1.isLiveTypeAudio() != true) goto L12;
        return false;
    L12:
        if (vm2.d.r0() == true) goto L14;
        return false;
    L14:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == true) goto L21;
        return true;
    L21:
        return false;
    L17:
        return false;
    }

    public static final boolean r(IRoom r2) {
        if (r2 == null) goto L9;
        Map r3 = r2.getAnchorABMap();
        if (r3 == null) goto L9;
        String r4 = (String) r3.get("ktv_kick_when_linker_full");
        if (r4 == null) goto L9;
        int r5 = CastIntegerProtector.parseInt(r4);
    L11:
        if (r5 != 1) goto L14;
        return true;
    L14:
        return false;
    L9:
        r5 = 0;
        goto L11
    }

    public static final boolean t(boolean r5) {
        if (c() != 10) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L17;
        if (r5 == false) goto L13;
        if (((Number) vm2.d.A0.getValue(null, vm2.d.a[76])).intValue() != 1) goto L29;
    L14:
        return true;
    L29:
        return false;
    L13:
        if (((Number) vm2.d.B0.getValue(null, vm2.d.a[77])).intValue() == 1) goto L14;
        return false;
    L17:
        if (c() != 4) goto L24;
        int r6 = com.bytedance.android.live.liveinteract.utils.r.b;
        if (r6 != 2) goto L21;
    L22:
        return true;
    L21:
        if (r6 == 3) goto L22;
        return false;
    L24:
        if (r5 == false) goto L28;
        return vm2.d.z();
    L28:
        return ((Boolean) vm2.d.D0.getValue(null, vm2.d.a[79])).booleanValue();
    L5:
        r0 = false;
        goto L7
    }

    public static final boolean x(IRoom r1) {
        if (r1 == null) goto L8;
        Map r2 = r1.getAnchorABMap();
        if (r2 == null) goto L8;
        String r3 = (String) r2.get("optran_paid_linkmic");
        if (r3 == null) goto L8;
        Integer r4 = StringsKt.toIntOrNull(r3);
    L9:
        if (r4 != null) goto L12;
    L14:
        return false;
    L12:
        if (r4.intValue() != 2) goto L14;
        return true;
    L8:
        r4 = null;
        goto L9
    }

    public static final void E(DataContext r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "selection");
        HashMap r1 = new HashMap();
        r1.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.g(r4).getVideoTalkRoomSubScene();
        if (r6 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r8 = r7.t();
        if (r8 == null) goto L9;
        m.B(r1, Integer.valueOf(r8.a), 4);
    L9:
        m.J(r1);
        r1.put("selection", r5);
        j0.l().sendLog("livesdk_anchor_audience_connection_layout_change_popup_click", r1, new Object[]{IRoom.class});
    }

    public static final void a(TextView r2, g0 r3) {
        if (r2 == null) goto L15;
        int r0 = r2.getPaddingStart() + r2.getPaddingEnd();
        r2.measure(0, 0);
        int r1 = r2.getMeasuredWidth() + r0;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r4 == null) goto L6;
        r4.width = r1;
        Unit r5 = Unit.INSTANCE;
    L7:
        r2.setLayoutParams(r4);
        if (r3.getBgColorImg() == null) goto L13;
        py.k r6 = r3.getBgColorImg();
        if (r6 == null) goto L17;
        r2.post(new n(r6, r2));
        return;
    L17:
        return;
    L13:
        r2.setBackgroundResource(2131248855);
        return;
    L6:
        r4 = null;
        goto L7
    }

    public static final py.k h(IBaseUser r2, int r3) {
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

    public static final void O(IRoom r3, boolean r4, CompositeDisposable r5) {
        Intrinsics.checkNotNullParameter(r3, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r5, "compositeDisposable");
        r5.add(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).updatePaidQueueSettings(r3.getId(), r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r4), b.a));
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.c.i1;
        if (((Boolean) r6.getValue()).booleanValue() == false) goto L6;
        Boolean r7 = Boolean.FALSE;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r7);
        return;
    }

    public static final String e(Context r6, long r7, long r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        long r10 = r9 - r7;
        long r0 = 60000;
        if (r10 <= r0) goto L5;
        long r2 = 3600000;
        if (r10 > r2) goto L11;
        return s1.C(2131921195, new Object[]{Integer.valueOf((int) (r10 / r0))});
    L11:
        if (r10 > 86400000) goto L15;
        return s1.C(2131921162, new Object[]{Integer.valueOf((int) (r10 / r2))});
    L15:
        return a.format(new Date(r7));
    L5:
        return r6.getString(2131921166);
    }

    public static final String f(Context r6, long r7, long r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        long r10 = r9 - r7;
        long r0 = 60000;
        if (r10 <= r0) goto L5;
        long r2 = 3600000;
        if (r10 > r2) goto L11;
        return s1.C(2131921164, new Object[]{Integer.valueOf((int) (r10 / r0))});
    L11:
        if (r10 > 86400000) goto L15;
        return s1.C(2131921163, new Object[]{Integer.valueOf((int) (r10 / r2))});
    L15:
        return a.format(new Date(r7));
    L5:
        return r6.getString(2131921165);
    }

    public static final void K(Context r5, IRoom r6, String r7, long r8, Integer r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, "enterPageType");
        String r2 = null;
        u6 r1 = new u6((String) vm2.d.H0.getValue(null, vm2.d.a[83]));
        if (r10 == null) goto L5;
        r1.b("height", String.valueOf(r10.intValue()));
    L5:
        u6 r11 = r1.d("url");
        if (r6 == null) goto L8;
        Long r0 = Long.valueOf(r6.getId());
    L9:
        r11.b("room_id", String.valueOf(r0));
        if (r6 == null) goto L12;
        r2 = r6.getOwnerUserIdString();
    L12:
        r11.b("anchor_id", r2);
        r11.b("function_type", m.a());
        if (r6 != null) goto L15;
    L17:
        String r9 = "video_live";
    L18:
        r11.b("live_type", r9);
        r11.b("user_type", i());
        r11.b("play_mode", m.c());
        r11.b("enter_page", r7);
        r11.b("tag_type", String.valueOf(r8));
        jc1.k.n(IBaseLiveActionHandler.class).handle(r5, r1.c());
        return;
    L15:
        if (r6.isLiveTypeAudio() != true) goto L17;
        r9 = "voice_live";
        goto L18
    L8:
        r0 = null;
        goto L9
    }
}
