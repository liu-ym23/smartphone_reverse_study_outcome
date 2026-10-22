package dl0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserContent;
import com.bytedance.android.live.liveinteract.multianchor.model.ListUserLinkmicAudienceContent;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUserInfo;
import com.bytedance.android.live.liveinteract.utils.y;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.jm;
import com.bytedance.android.livesdk.config.km;
import com.bytedance.android.livesdk.link.model.bridge.k1;
import com.bytedance.android.livesdk.link.model.bridge.l1;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n {
    public static final int a() {
        return ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
    }

    public static final boolean b() {
        if (((Boolean) km.a.getValue()).booleanValue() == true) goto L6;
        return false;
    L6:
        if (((Boolean) jm.a.getValue()).booleanValue() == true) goto L11;
        if (tc0.c.h().A == null) goto L11;
        return false;
    L11:
        if (v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 32) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final boolean c() {
        return jc1.k.n(IUserService.class).user().c();
    }

    public static final String d() {
        return jc1.k.n(IUserService.class).user().n();
    }

    public static final ArrayList<LinkPlayerInfo> f(List<WaitingListUser> r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$toLinkPlayerInfo");
        ArrayList<LinkPlayerInfo> r1 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        WaitingListUser r2 = (WaitingListUser) r7.next();
        Intrinsics.checkNotNullParameter(r2, "$this$toLinkPlayerInfo");
        LinkPlayerInfo r3 = new LinkPlayerInfo();
        r3.isHasApplied = r2.isHasApplied();
        r3.mUser = r2.getUserFlex();
        r3.setModifyTime(r2.getModifyTime());
        r3.setLinkStatus(r2.getMLinkStatus());
        r3.setLinkType(r2.getMLinkType());
        r3.setRoleType(r2.getMRoleType());
        r3.userPosition = r2.getUserPosition();
        r3.silenceStatus = r2.getSilenceStatus();
        r3.mInteractIdStr = r2.getLinkmicIdStr();
        r3.songList = r2.getSongList();
        r3.orderedSongCount = r2.getOrderedSongCount();
        r3.clientVersion = r2.getClientVersion();
        r3.appId = r2.getAppId();
        r3.applyTypeNew = r2.getApplyType();
        r3.devicePlatform = r2.getDevicePlatform();
        r3.listUserType = r2.getListUserType();
        r3.listUserFromType = r2.getListUserFromType();
        WaitingListUserInfo r4 = new WaitingListUserInfo();
        r3.waitingListUserInfo = r4;
        r4.hasExpired = r2.getHasExpired();
        WaitingListUserInfo r5 = r3.waitingListUserInfo;
        r5.isMutualFollow = r2.isMutualFollow();
        WaitingListUserInfo r8 = r3.waitingListUserInfo;
        r8.applyReason = r2.getApplyReason();
        WaitingListUserInfo r9 = r3.waitingListUserInfo;
        r9.last7DaysGiftCountTxt = r2.getLast7DaysGiftCountTxt();
        r3.fuzzyFanTicket = r2.getFanTicket();
        r3.rank = r2.getRank();
        r3.isAddPrice = r2.isAddPrice();
        r3.addPriceTime = r2.getAddPriceTime();
        r3.isAnonymous = r2.isAnonymous();
        r3.micPosTagInfo = r2.getMicPosTag();
        r1.add(r3);
        goto L4
    L6:
        return r1;
    }

    public static final LinkPlayerInfo e(com.bytedance.android.livesdk.link.model.bridge.k r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$toLinkPlayerInfo");
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) vh7.f.c(ILinkPlayerInfoBridge.class);
        r0.setUser(r7.getUser());
        r0.setInteractId(r7.getLinkMicIdStr());
        r0.setLinkStatus(r7.getStatus());
        r0.setLinkType(r7.getLinkType());
        r0.setUserPositionFlex(r7.getUserPosition());
        r0.setSilenceStatus(r7.getSilenceStatus());
        r0.setMediaType(r7.getLinkType());
        r0.setModifyTime(r7.getModifyTime());
        r0.setRoleType(r7.getRoleType());
        r0.setApplyType(r7.getApplyType());
        r0.setMatchEffect(r7.getMatchEffect());
        r0.setCityEffect(r7.getCityEffect());
        r0.setShowCityEffect(r7.getShowCityEffect());
        r0.setMIsJoinUser(r7.isJoinUser());
        r0.setMcStatus(r7.getMcStatus());
        boolean r1 = false;
        if (((int) r7.isBackground()) != 1) goto L5;
        boolean r2 = true;
    L6:
        r0.setBackground(r2);
        k1 r3 = r7.getContent();
        String r4 = null;
        if (r3 == null) goto L11;
        l1 r5 = r3.getLinkMicAudienceContent();
        if (r5 == null) goto L11;
        kd1.b r6 = r5.getMicDress();
    L12:
        r0.setMicDress(r6);
        k1 r9 = r7.getContent();
        if (r9 == null) goto L19;
        l1 r10 = r9.getLinkMicAudienceContent();
        if (r10 == null) goto L19;
        if (r10.isEnlarged() != true) goto L19;
        r1 = true;
    L19:
        r0.setEnlarged(r1);
        r0.setMicPosTagInfo(r7.getMicPosTagInfo());
        r0.setLinkRoomId(r8);
        k1 r11 = r7.getContent();
        if ((r11 instanceof ListUserContent) == true) goto L22;
        r11 = null;
    L22:
        ListUserContent r12 = (ListUserContent) r11;
        if (r12 == null) goto L27;
        ListUserLinkmicAudienceContent r13 = r12.getLinkMicAudienceContent();
        if (r13 == null) goto L27;
        com.bytedance.android.live.liveinteract.model.c r14 = (com.bytedance.android.live.liveinteract.model.c) r13.castTo(com.bytedance.android.live.liveinteract.model.c.class);
    L28:
        if (r14 == null) goto L33;
        r0.setFanTicket(r14.getFanTicket());
        int r15 = y.a;
        IBaseUser r16 = r7.getUser();
        if (r16 == null) goto L32;
        r4 = r16.getIdString();
    L32:
        r0.setFanTicketDisplayStr(y.a(r4, com.bytedance.android.live.liveinteract.model.d.a(r14), r14.getFanTicketRealStr(), r14.getFanTicketFuzzyStr()));
        r0.setHost(r14.isHost());
        r0.setAppId(r14.getAppId());
        r0.setClientVersion(r14.getClientVersion());
        r0.setDevicePlatform(r14.getDevicePlatform());
        r0.setLinkedListUserInfo(com.bytedance.android.live.liveinteract.plantform.model.p.a(r14.getJoinChannelTime(), r14.getExpectLeaveTime(), r14.getCurrentTime()));
        r0.setListUserRole(r14.getListUserRole());
        r0.setPaidCount(r14.getPaidCount());
        r0.setAnonymous(r14.isAnonymous());
        r0.setSelfDisciplineDuration(r14.getSelfDisciplineDurationTime());
        r0.setSelfDisciplineTargetDuration(r14.getSelfDisciplineTargetDuration());
        r0.setThemedCompetitionRole(r14.getThemedCompetitionRole());
    L33:
        vh7.c r17 = jm2.a.d(r0);
        if (r17 == null) goto L38;
        return (LinkPlayerInfo) r17;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo");
    L27:
        r14 = null;
    L11:
        r6 = null;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public static final ArrayList g(List r4, Long r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$toLinkPlayerInfoList");
        ArrayList r0 = new ArrayList();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        com.bytedance.android.livesdk.link.model.bridge.k r1 = jm2.a.d((com.bytedance.android.livesdk.link.model.bridge.k) r6.next());
        if (r1 == null) goto L13;
        com.bytedance.android.livesdk.link.model.bridge.k r2 = r1;
        if (r5 == null) goto L10;
        long r3 = r5.longValue();
    L11:
        r0.add(e(r2, r3));
        goto L4
    L10:
        r3 = 0;
        goto L11
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.link.model.bridge.IAnchorLinkUserBridge");
    L14:
        return r0;
    }
}
