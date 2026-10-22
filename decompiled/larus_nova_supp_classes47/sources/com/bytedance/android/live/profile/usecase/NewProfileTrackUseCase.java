package com.bytedance.android.live.profile.usecase;

import am2.u;
import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.EcomInfo;
import com.bytedance.android.live.base.model.user.HeartDiamondInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileConstant;
import com.bytedance.android.live.base.model.user.ProfileTagContent;
import com.bytedance.android.live.base.model.user.ShopHeaderInfo;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.ProfileRoomProxy;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.p000enum.TrackArea;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.message.model.vh;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NewProfileTrackUseCase implements ut0.f {
    public com.bytedance.android.live.profile.model.f a;
    public final x b;
    public String c;
    public String d;
    public final Map<String, String> e;
    public final s f;
    public final com.bytedance.android.live.profile.usecase.a g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profile/usecase/NewProfileTrackUseCase$LogProfileType;", "", "POI_VIEW_CLK", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LogProfileType extends Enum<LogProfileType> {
        public static final LogProfileType POI_VIEW_CLK = null;
        public static final /* synthetic */ LogProfileType[] a = null;

        static {
            LogProfileType r1 = new LogProfileType();
            POI_VIEW_CLK = r1;
            a = new LogProfileType[]{r1};
        }

        public static LogProfileType valueOf(String r1) {
            return (LogProfileType) r27.a.a(LogProfileType.class, r1);
        }

        public static LogProfileType[] values() {
            return (LogProfileType[]) a.clone();
        }

        public LogProfileType() {
            super("POI_VIEW_CLK", 0);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // ut0.f
    public final void j() {
    }

    @Override // ut0.f
    public final void a() {
        HashMap r0 = new HashMap();
        ps0.b r1 = this.g.getRoom();
        r0.put("anchor_id", r1.getOwnerUserIdStr().toString());
        r0.put("room_id", String.valueOf(r1.getId()));
        int r2 = vt0.e.a;
        r0.put("user_type", vt0.e.a(r1.getOwnerUserIdStr(), this.g.getTargetUser().baseProfileInfo.getIdStr()));
        boolean r3 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r4 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).getRevLinkControlService();
        if (r4 == null) goto L7;
        String r5 = r4.getConnectionType();
        if (r5 == null) goto L7;
        r0.put("connection_type", r5);
    L7:
        j0.l().sendLog("livesdk_profile_card_send_show", r0, new Object[]{new x(), IRoom.class});
    }

    @Override // ut0.f
    public final void c() {
        HashMap r0 = new HashMap();
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        String r2 = "";
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.user.e r3 = r1.user();
        if (r3 == null) goto L10;
        IBaseUser r4 = r3.b();
        if (r4 == null) goto L10;
        String r5 = r4.getIdString();
        if (r5 == null) goto L10;
    L11:
        r0.put("user_id", r5);
        com.bytedance.android.livesdk.chatroom.o r6 = os0.b.a();
        if (r6 != null) goto L14;
    L31:
        r0.put("user_type", r2);
        r0.put("request_page", "profile_card");
        j0.l().sendLog("livesdk_chatroom_audiencelink_icon_show", r0, new Object[]{IRoom.class, x.class});
        return;
    L14:
        if (Intrinsics.areEqual(r6.isAnchor(), Boolean.TRUE) == false) goto L16;
        r2 = "anchor";
        goto L31
    L16:
        IMiddlewareUserService r7 = jc1.k.f(IMiddlewareUserService.class);
        if (r7 == null) goto L28;
        com.bytedance.android.livesdk.user.e r8 = r7.user();
        if (r8 == null) goto L28;
        IBaseUser r9 = r8.b();
        if (r9 == null) goto L28;
        py.t r10 = r9.getUserAttrExt();
        if (r10 == null) goto L28;
        if (r10.isAdmin() != true) goto L28;
        r2 = "admin";
    L28:
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L30;
        r2 = "guest";
        goto L31
    L30:
        r2 = "audience";
    L10:
        r5 = "";
        goto L11
    }

    @Override // ut0.f
    public final vh g() {
        UserProfileEvent r0 = this.g.getUserProfileEvent();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.originRoomInfo;
    }

    @Override // ut0.f
    public final void n() {
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r1 = j0.l().c(x.class);
        if (r1 == null) goto L15;
        String r2 = (String) r1.getMap().get("enter_from_merge");
        String r4 = "";
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r0.put("enter_from_merge", r2);
        String r3 = (String) r1.getMap().get("enter_method");
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r0.put("enter_method", r3);
        String r5 = (String) r1.getMap().get("action_type");
        if (r5 == null) goto L14;
        r4 = r5;
    L14:
        r0.put("action_type", r4);
    L15:
        ps0.b r6 = this.g.getRoom();
        LiveMode r7 = r6.getStreamType();
        int r8 = h1.a;
        r0.put("live_type", i1.a(r7));
        r0.put("anchor_id", r6.getOwnerUserIdStr().toString());
        r0.put("room_id", String.valueOf(r6.getId()));
        r0.put("function_type", os0.b.c().getIInteractService().getCurrentFunctionType());
        com.bytedance.android.livesdk.chatroom.o r9 = os0.b.a();
        String r10 = "guest";
        if (r9 != null) goto L18;
    L25:
        IMiddlewareUserService r12 = jc1.k.f(IMiddlewareUserService.class);
        if (r12 == null) goto L30;
        com.bytedance.android.livesdk.user.e r13 = r12.user();
        if (r13 == null) goto L30;
        String r14 = r13.n();
    L31:
        r0.put("user_id", String.valueOf(r14));
        qs0.h r15 = os0.b.c().getInteractLogUtils();
        if (r15 == null) goto L36;
        String r16 = r15.getCurrentPlayModes();
        if (r16 == null) goto L36;
        r0.put("play_mode", r16);
    L36:
        String r17 = this.g.getTargetUser().baseProfileInfo.getIdStr();
        r0.put("to_user_id", r17.toString());
        if (Intrinsics.areEqual(r17, r6.getOwnerUserIdStr()) == false) goto L39;
        r10 = "anchor";
    L39:
        r0.put("to_user_type", r10);
        r0.put("request_page", "profile_card");
        j0.l().sendLog("livesdk_like_button_show", r0, new Object[0]);
        return;
    L30:
        r14 = null;
        goto L31
    L18:
        if (Intrinsics.areEqual(r9.isAnchor(), Boolean.TRUE) == false) goto L21;
        String r18 = "anchor";
    L24:
        r0.put("user_type", r18);
        goto L25
    L21:
        if (os0.b.c().getLinkPlayerState().getData() == 0) goto L23;
        r18 = "guest";
        goto L24
    L23:
        r18 = "audience";
        goto L24
    }

    public final Map<String, String> p() {
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.chatroom.o r1 = os0.b.a();
        String r2 = "guest";
        if (r1 != null) goto L5;
        String r3 = "";
    L12:
        r0.put("user_type", r3);
        IMiddlewareUserService r4 = jc1.k.f(IMiddlewareUserService.class);
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.user.e r5 = r4.user();
        if (r5 == null) goto L17;
        String r6 = r5.n();
    L18:
        r0.put("user_id", String.valueOf(r6));
        ps0.b r7 = this.g.getRoom();
        String r8 = this.g.getTargetUser().baseProfileInfo.getIdStr();
        r0.put("to_user_id", r8.toString());
        if (Intrinsics.areEqual(r8, r7.getOwnerUserIdStr()) == false) goto L21;
        r2 = "anchor";
    L21:
        r0.put("to_user_type", r2);
        r0.put("request_page", "profile_card");
        return r0;
    L17:
        r6 = null;
        goto L18
    L5:
        if (Intrinsics.areEqual(r1.isAnchor(), Boolean.TRUE) == false) goto L8;
        r3 = "anchor";
        goto L12
    L8:
        if (os0.b.c().getLinkPlayerState().getData() == 0) goto L10;
        r3 = "guest";
        goto L12
    L10:
        r3 = "user";
        goto L12
    }

    public final HashMap<String, String> r() {
        IBaseUser r0 = jc1.k.n(IMiddlewareUserService.class).user().b();
        NewProfileUser r1 = this.g.getTargetUser();
        HashMap<String, String> r2 = new HashMap();
        r2.put("request_page", "user_card");
        if (u() == false) goto L6;
        String r3 = "anchor";
    L9:
        r2.put("user_type", r3);
        if (StringUtils.equal(r0.getIdString().toString(), r1.baseProfileInfo.getIdStr()) == false) goto L12;
        String r4 = "oneself";
    L13:
        r2.put("to_user_type", r4);
        r2.put("to_user_id", r1.baseProfileInfo.getIdStr());
        return r2;
    L12:
        r4 = "others";
        goto L13
    L6:
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L8;
        r3 = "guest";
        goto L9
    L8:
        r3 = "user";
        goto L9
    }

    public final Map<String, String> t() {
        DressSuitInfo r0 = this.g.getTargetUser().getDressSuitInfo();
        if (r0 == null) goto L17;
        String r1 = r0.getExtra();
        if (r1 == null) goto L17;
        LinkedHashMap r2 = null;
        JsonObject r3 = (JsonObject) GsonHelper.get().fromJson(r1, JsonObject.class);     // Catch: Exception -> L9
    L10:
        if (r3 == null) goto L15;
        GsonMap r4 = UtilsKt.i(r3);
        r2 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator r5 = r4.entrySet().iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        Map.Entry r6 = (Map.Entry) r5.next();
        r2.put(r6.getKey(), String.valueOf(r6.getValue()));
    L15:
        if (r2 == null) goto L17;
        return r2;
    L9:
        r3 = null;
    L17:
        return MapsKt.emptyMap();
    }

    public static boolean u() {
        com.bytedance.android.livesdk.chatroom.o r0 = os0.b.a();
        if (r0 == null) goto L5;
        Boolean r1 = r0.isAnchor();
    L7:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L7
    }

    @Override // ut0.f
    public final void d() {
        j0.l().sendLog("livesdk_room_meetgame_invite_message_icon_show", p(), new Object[]{IRoom.class, x.class});
    }

    @Override // ut0.f
    public final void e() {
        j0.l().sendLog("livesdk_room_meetgame_invite_icon_show", p(), new Object[]{IRoom.class, x.class});
    }

    @Override // ut0.f
    public final void h() {
        j0.l().sendLog("livesdk_room_meetgame_invite_message_icon_click", p(), new Object[]{IRoom.class, x.class});
    }

    @Override // ut0.f
    public final void i() {
        j0.l().sendLog("livesdk_room_meetgame_invite_icon_click", p(), new Object[]{IRoom.class, x.class});
    }

    public NewProfileTrackUseCase(com.bytedance.android.live.profile.usecase.a r3) {
        Intrinsics.checkNotNullParameter(r3, "profileViewModel");
        this.g = r3;
        this.a = new com.bytedance.android.live.profile.model.f();
        this.b = new x();
        this.c = "";
        this.d = "";
        this.e = MapsKt.mapOf(TuplesKt.to("request_page", NewProfileInfoViewModel.PAGE_NAME));
        this.f = new s();
        if (j0.l().c(com.bytedance.android.live.profile.model.f.class) != null) goto L6;
        j0.l().register(com.bytedance.android.live.profile.model.f.class, new com.bytedance.android.live.profile.model.g());
        return;
    }

    @Override // ut0.f
    public final void k(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        HashMap r0 = new HashMap();
        r0.put("message_type", r3);
        r0.put("click_user_position", this.d);
        B("livesdk_anchor_audiencecard_click", r0);
    }

    @Override // ut0.f
    public final void l(List<? extends ProfileTagContent> r5) {
        Intrinsics.checkNotNullParameter(r5, "tags");
        Iterator<T> r6 = r5.iterator();
        String r1 = "";
    L4:
        if (r6.hasNext() == false) goto L9;
        ProfileTagContent r2 = (ProfileTagContent) r6.next();
        if (r2 == null) goto L4;
        r1 = r1 + r2.tagType + ',';
        goto L4
    L9:
        C("livesdk_standard_show_tags", MapsKt.mapOf(TuplesKt.to("tags", r1)));
    }

    @Override // ut0.f
    public final void m(String r5) {
        Intrinsics.checkNotNullParameter(r5, "actionType");
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.chatroom.o r1 = os0.b.a();
        if (r1 == null) goto L5;
        Boolean r2 = r1.isAnchor();
    L7:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L9;
        String r3 = "anchor";
    L10:
        r0.put("user_type", r3);
        r0.put("action_type", r5);
        qs0.i r6 = os0.b.c().getIInteractService();
        if (r6 == null) goto L15;
        String r4 = r6.getCurrentFunctionType();
        if (r4 == null) goto L15;
        r0.put("function_type", r4);
    L15:
        if (r6 == null) goto L19;
        String r7 = r6.getFunctionType2();
        if (r7 == null) goto L19;
        r0.put("function_type2", r7);
    L19:
        if (r6 == null) goto L27;
        Boolean r8 = r6.chatRoomIsOpen();
        if (r8 == null) goto L27;
        if (r8.booleanValue() == false) goto L25;
        String r9 = DataType.FALSE;
    L26:
        r0.put("pre_status", r9);
        goto L27
    L25:
        r9 = DataType.TRUE;
    L27:
        j0.l().sendLog("livesdk_profile_card_user_connect", r0, new Object[]{x.class, IRoom.class});
        return;
    L9:
        r3 = "admin";
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    @Override // ut0.f
    public final void o(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        HashMap r0 = new HashMap();
        r0.put("message_type", r3);
        r0.put("click_user_position", this.d);
        B("livesdk_anchor_audiencecard_show", r0);
    }

    public final HashMap<String, String> q(String r9) {
        HashMap<String, String> r0 = new HashMap();
        NewProfileUser r1 = this.g.getTargetUser();
        DressSuitInfo r2 = r1.getDressSuitInfo();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getUserSuitId();
    L6:
        boolean r5 = false;
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        String r7 = "none";
    L20:
        r0.put("package_id", r7);
        boolean r8 = this.g.getPageTypeUseCase().a;
        String r10 = DataType.TRUE;
        if (r8 == false) goto L23;
        String r12 = DataType.TRUE;
    L24:
        r0.put("is_self", r12);
        DressSuitInfo r13 = this.g.getTargetUser().getDressSuitInfo();
        if (r13 == null) goto L27;
        r3 = r13.getUserSuitId();
    L27:
        if (r3 != null) goto L29;
    L30:
        r5 = true;
    L31:
        if (r5 == false) goto L33;
        r10 = DataType.FALSE;
    L33:
        r0.put("is_wear", r10);
        r0.put("to_user_id", r9.toString());
        r0.putAll(t());
        return r0;
    L29:
        if (r3.length() != 0) goto L31;
    L23:
        r12 = DataType.FALSE;
        goto L24
    L15:
        DressSuitInfo r14 = r1.getDressSuitInfo();
        if (r14 == null) goto L18;
        r7 = r14.getUserSuitId();
    L19:
        Intrinsics.checkNotNull(r7);
        goto L20
    L18:
        r7 = null;
        goto L19
    L9:
        if (r4.length() == 0) goto L12;
        r6 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }

    public final void v(boolean r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6 == false) goto L5;
        String r7 = "fans";
    L6:
        r0.put("entrance_type", r7);
        String r1 = "guest";
        if (u() == false) goto L10;
        String r8 = "anchor";
    L13:
        r0.put("user_type", r8);
        if (u() == false) goto L16;
        String r9 = DataType.TRUE;
    L17:
        r0.put("is_anchor", r9);
        String r10 = this.g.getTargetUser().baseProfileInfo.getIdStr();
        if (Intrinsics.areEqual(r10, this.g.getRoom().getOwnerUserIdStr()) == false) goto L21;
        r1 = "anchor";
    L24:
        r0.put("multi_to_user_type", r1);
        r0.put("multi_to_user_id", r10);
        B("livesdk_profile_card_fans_club_join", r0);
        return;
    L21:
        if (vt0.h.b(r10) == true) goto L24;
        r1 = "audience";
        goto L24
    L16:
        r9 = DataType.FALSE;
        goto L17
    L10:
        if (os0.b.c().getLinkPlayerState().getData() == 0) goto L12;
        r8 = "guest";
        goto L13
    L12:
        r8 = "audience";
        goto L13
    L5:
        r7 = "not_fans";
        goto L6
    }

    public static void y(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "targetId");
        Intrinsics.checkNotNullParameter(r8, "selfId");
        HashMap r0 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r1 = j0.l().c(x.class);
        String r2 = "";
        if (r1 == null) goto L14;
        String r3 = (String) r1.getMap().get("enter_from_merge");
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.put("enter_from_merge", r3);
        String r4 = (String) r1.getMap().get("enter_method");
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r0.put("enter_method", r4);
        String r5 = (String) r1.getMap().get("action_type");
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        r0.put("action_type", r5);
    L14:
        com.bytedance.android.livesdk.chatroom.o r6 = os0.b.a();
        Long r9 = null;
        if (r6 == null) goto L19;
        com.bytedance.live.datacontext.m r10 = r6.getRoom();
        if (r10 == null) goto L19;
        IRoom r12 = (IRoom) r10.getValue();
    L20:
        if (r12 == null) goto L23;
        String r13 = r12.getOwnerUserIdString();
        if (r13 == null) goto L23;
    L24:
        r0.put("anchor_id", r13);
        if (r12 == null) goto L27;
        r9 = Long.valueOf(r12.getId());
    L27:
        r0.put("room_id", String.valueOf(r9));
        if (r12 == null) goto L33;
        String r14 = r12.getRequestId();
        if (r14 == null) goto L33;
        r2 = r14;
    L33:
        r0.put("request_id", r2);
        r0.put("card_type", s(r13, r8, r7));
        j0.l().sendLog("livesdk_profile_card_livevip_join", r0, new Object[]{am2.o.class});
        return;
    L23:
        r13 = DataType.FALSE;
    L19:
        r12 = null;
        goto L20
    }

    public final void A(String r7, Map<? extends String, String> r8) {
        Intrinsics.checkNotNullParameter(r7, "name");
        ps0.b r0 = this.g.getRoom();
        BaseProfileInfo r1 = this.g.getTargetUser().baseProfileInfo;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getIdStr();
    L6:
        LinkedHashMap r4 = new LinkedHashMap();
        int r5 = vt0.h.a;
        IMiddlewareUserService r6 = jc1.k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L11;
        com.bytedance.android.livesdk.user.e r9 = r6.user();
        if (r9 == null) goto L11;
        r2 = r9.n();
    L11:
        r4.put("request_page", vt0.h.a(String.valueOf(r2), this.g.getTargetUser().baseProfileInfo.getIdStr(), this.g.getRoom().getOwnerUserIdStr()));
        IRoomOthersData r10 = r0.k3();
        if (r10 == null) goto L16;
        IGroupLiveData r12 = r10.getGroupData();
        if (r12 == null) goto L16;
        int r13 = r12.getGroupLiveMode();
    L17:
        IRoomOthersData r14 = r0.k3();
        if (r14 == null) goto L23;
        IGroupLiveData r15 = r14.getGroupData();
        if (r15 == null) goto L23;
        String r16 = String.valueOf(r15.isGroupLive());
        if (r16 == null) goto L23;
    L24:
        r4.put("is_grouped_lived", r16);
        r4.put("is_union_battle", String.valueOf(r13));
        if (r13 == 1) goto L31;
        boolean r17 = com.bytedance.android.live.revenue.core.util.h.a;
        r4.put("group_member_cnt", String.valueOf(com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberNum()));
        if (Intrinsics.areEqual(r3, this.g.getRoom().getOwnerUserIdStr()) == false) goto L29;
        String r18 = "group_room_owner";
    L34:
        r4.put("to_user_type", r18);
        r4.put("to_user_id", String.valueOf(r3));
        r4.put("function_type", r7);
        if (r8 == null) goto L55;
        Iterator<Map.Entry<? extends String, String>> r19 = r8.entrySet().iterator();
    L38:
        if (r19.hasNext() == false) goto L55;
        Map.Entry<? extends String, String> r20 = r19.next();
        String r22 = r20.getKey();
        String r23 = r20.getValue();
        if (r22 != null) goto L42;
    L45:
        boolean r24 = true;
    L46:
        if (r24 == true) goto L38;
        if (r23 != null) goto L49;
    L52:
        boolean r25 = true;
    L53:
        if (r25 == true) goto L38;
        r4.put(r22, r23);
        goto L38
    L49:
        if (r23.length() == 0) goto L52;
        r25 = false;
        goto L53
    L42:
        if (r22.length() == 0) goto L45;
        r24 = false;
    L55:
        B("livesdk_profile_card_function_click", r4);
        return;
    L29:
        r18 = "group_member";
        goto L34
    L31:
        if (Intrinsics.areEqual(r3, this.g.getRoom().getOwnerUserIdStr()) == false) goto L33;
        r18 = "union_battle_room_owner";
        goto L34
    L33:
        r18 = "union_battle_member";
    L23:
        r16 = DataType.FALSE;
    L16:
        r13 = 0;
        goto L17
    L5:
        r3 = null;
        goto L6
    }

    public final void B(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "logName");
        Intrinsics.checkNotNullParameter(r6, "map");
        j0.l().sendLog(r5, r6, new Object[]{this.a, this.b, IRoom.class});
    }

    public final void C(String r5, Map<String, String> r6) {
        j0.l().sendLog(r5, r6, new Object[]{this.a, this.b, IRoom.class});
    }

    @Override // ut0.f
    public final void b(ProfileTagContent r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "tagContent");
        String r0 = r3.clickBuriedPoint;
        if (r0 != null) goto L5;
        return;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        Map<? extends String, ? extends String> r5 = r3.clickBuriedPointParams;
        if (r5 == null) goto L8;
        r1.putAll(r5);
    L8:
        if (r4 == null) goto L10;
        r1.putAll(r4);
    L10:
        C(r0, r1);
    }

    @Override // ut0.f
    public final void f(ProfileTagContent r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "tagContent");
        String r0 = r3.showBuriedPoint;
        if (r0 != null) goto L5;
        return;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        Map<? extends String, ? extends String> r5 = r3.showBuriedPointParams;
        if (r5 == null) goto L8;
        r1.putAll(r5);
    L8:
        if (r4 == null) goto L10;
        r1.putAll(r4);
    L10:
        C(r0, r1);
    }

    @Override // ut0.f
    public final void recordBusinessShow(TrackArea r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "area");
        Intrinsics.checkNotNullParameter(r5, "name");
        s r2 = this.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "area");
        Intrinsics.checkNotNullParameter(r5, "name");
        LinkedHashMap r0 = (LinkedHashMap) r2.a;
        Object r1 = r0.get(r4);
        if (r1 != null) goto L5;
        r1 = new ArrayList();
        r0.put(r4, r1);
    L5:
        ((List) r1).add(r5);
    }

    public final void x(String r7, long r8) {
        Intrinsics.checkNotNullParameter(r7, "targetUserId");
        qs0.i r0 = os0.b.c().getIInteractService();
        Integer r1 = null;
        if (r0 == null) goto L7;
        mv0.k.e r2 = r0.getVideoTalkService();
        if (r2 == null) goto L7;
        Pair<Boolean, Long> r3 = r2.k(r7.toString());
    L9:
        if (r3 != null) goto L11;
    L17:
        HashMap r4 = new HashMap();
        r4.put("to_anchor_id", r7.toString());
        r4.put("to_room_id", String.valueOf(r8));
        boolean r9 = com.bytedance.android.live.revenue.core.util.h.a;
        p11.j r10 = ((ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class)).mo471getRevenueLinkDataHolder();
        if (r10 != null) goto L20;
    L22:
        if (r10 == null) goto L24;
        r1 = Integer.valueOf(r10.getMatchType());
    L24:
        int r12 = r1.intValue();
        if (r12 == 0) goto L29;
        if (r12 == 1) goto L28;
        String r13 = "non_connection_screen";
    L30:
        if (r10 == null) goto L32;
        r4.put("channel_id", String.valueOf(r10.getChannelId()));
        r4.put("pk_id", String.valueOf(r10.getPkId()));
    L32:
        r4.put("connection_type", r13);
        j0.l().sendLog("connection_room_transfer", r4, new Object[]{this.a, this.b, IRoom.class});
        return;
    L28:
        r13 = "random_pk";
        goto L30
    L29:
        r13 = "manual_pk";
        goto L30
    L20:
        if (r10.getDuration() != 0) goto L22;
        r13 = "anchor";
        goto L30
    L11:
        if (((Boolean) r3.getFirst()).booleanValue() != true) goto L17;
        Long r14 = (Long) r3.getSecond();
        qs0.i r15 = os0.b.c().getIInteractService();
        if (r15 == null) goto L34;
        mv0.k.e r16 = r15.getVideoTalkService();
        if (r16 == null) goto L35;
        r16.n(r7);
        return;
    L35:
        return;
    L34:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public static String s(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "anchorId");
        Intrinsics.checkNotNullParameter(r2, "selfId");
        Intrinsics.checkNotNullParameter(r3, "targetId");
        if (Intrinsics.areEqual(r2, r1) == false) goto L9;
        if (Intrinsics.areEqual(r3, r2) == false) goto L7;
        return "anchor_c_anchor";
    L7:
        return "anchor_c_user";
    L9:
        if (Intrinsics.areEqual(r3, r2) == false) goto L12;
        return "user_c_user";
    L12:
        if (Intrinsics.areEqual(r3, r1) == false) goto L14;
        return "user_c_anchor";
    L14:
        return "user_c_others";
    }

    public final void z(String r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r7, "from");
        HashMap r0 = new HashMap();
        r0.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r0.put("entrance_location", r7);
        com.bytedance.android.livesdk.log.filter.o r8 = j0.l().c(x.class);
        String r1 = "";
        if (r8 == null) goto L11;
        String r2 = (String) r8.getMap().get("enter_from_merge");
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        String r9 = (String) r8.getMap().get("enter_method");
        if (r9 != null) goto L10;
        r9 = "";
    L10:
        r0.put("store_source_page", r2);
        r0.put("store_source_method", r9);
    L11:
        r0.put("store_group_type", "live");
        if (r6 != ProfileConstant.ProfileType.SHOP.getType()) goto L14;
        String r10 = "shop";
    L15:
        r0.put("store_type", r10);
        EcomInfo r12 = this.g.getTargetUser().ecomInfo;
        if (r12 == null) goto L22;
        ShopHeaderInfo r13 = r12.getShopHeaderInfo();
        if (r13 == null) goto L22;
        HeartDiamondInfo r14 = r13.getHeartDiamondInfo();
        if (r14 == null) goto L22;
        Integer r15 = Integer.valueOf(r14.getLevel());
    L23:
        r0.put("dou_shop_level", String.valueOf(r15));
        com.bytedance.android.livesdk.log.filter.o r16 = j0.l().c(IRoom.class);
        if (r16 == null) goto L30;
        String r17 = (String) r16.getMap().get("anchor_id");
        if (r17 == null) goto L29;
        r1 = r17;
    L29:
        r0.put("author_id", r1);
    L30:
        j0.l().sendLog(r5, r0, new Object[0]);
        return;
    L22:
        r15 = null;
        goto L23
    L14:
        r10 = "window";
        goto L15
    }

    public final void w(boolean r20, boolean r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r23, "mFromSource");
        Intrinsics.checkNotNullParameter(r24, "clickPosition");
        String r3 = this.g.getTargetUser().baseProfileInfo.getIdStr();
        boolean r4 = this.g.getPageTypeUseCase().c;
        ps0.b r5 = this.g.getRoom();
        boolean r6 = com.bytedance.android.live.revenue.core.util.h.a;
        ILinkService r7 = (ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class);
        p11.j r8 = r7.mo471getRevenueLinkDataHolder();
        if (r8 == null) goto L5;
        String r9 = r8.a();
    L6:
        boolean r10 = Intrinsics.areEqual(r9, r3.toString());
        if (Intrinsics.areEqual(r5.getOwnerUserIdStr(), r3) == false) goto L9;
        char r12 = 0;
    L16:
        qs0.s r14 = os0.b.c().getIMicRoomService();
        String r15 = jc1.k.n(IMiddlewareUserService.class).user().n();
        boolean r16 = r5.a();
        if (r14 == null) goto L22;
        if (r16 == false) goto L22;
        if (r14.isLoyalAudience() == false) goto L22;
        boolean r17 = true;
    L23:
        qs0.i r13 = os0.b.c().getIInteractService();
        if (r16 == true) goto L26;
    L28:
        boolean r18 = false;
    L29:
        if (r16 == true) goto L31;
    L33:
        boolean r19 = false;
    L34:
        IRoom r110 = r5.b();
        if ((r110 instanceof IRoom) == true) goto L37;
        r110 = null;
    L37:
        IRoom r111 = r110;
        if (r16 == false) goto L49;
        if (r111 == null) goto L45;
        IOfficialChannelInfo r112 = r111.getOfficialChannelInfo();
        if (r112 == null) goto L45;
        IBaseUser r113 = r112.getChannelUser();
        if (r113 == null) goto L45;
        String r114 = r113.getIdString();
    L47:
        if (Intrinsics.areEqual(r3, r114) == false) goto L49;
        r12 = 3;
    L45:
        r114 = null;
    L49:
        FollowLog r115 = new FollowLog("", r3);
        if (r10 == false) goto L53;
        r115.c = "right_anchor";
    L53:
        if (TextUtils.isEmpty(this.c) == true) goto L61;
        String r116 = this.c;
        String r117 = "";
        if (Intrinsics.areEqual(r116, "guest_connection") == false) goto L57;
    L60:
        r115.c = r116;
    L62:
        if (r4 == true) goto L64;
        if (r16 == false) goto L95;
        if (r12 != 0) goto L78;
    L79:
        if (r12 != 0) goto L87;
        if (r18 == false) goto L82;
        r115.a = "carousel_host_c_anchor";
    L115:
        if (TextUtils.equals(r23, "top_single_room_rank") == false) goto L117;
    L120:
        r115.a = r23;
    L121:
        HashMap r1 = new HashMap();
        if (r20 == false) goto L124;
        r1.put("growth_deepevent", String.valueOf(1));
    L124:
        r1.put("is_personal_profile", DataType.TRUE);
        boolean r25 = Intrinsics.areEqual(r3, r5.getOwnerUserIdStr());
        if (r20 == false) goto L133;
        qs0.d r118 = os0.b.c().getIBroadcastService();
        if (r118 == null) goto L133;
        if (r118.isPlayingGame() == false) goto L131;
        Object r119 = DataType.TRUE;
    L132:
        r1.put("is_gaming", r119);
        Unit r120 = Unit.INSTANCE;
        goto L133
    L131:
        r119 = DataType.FALSE;
    L133:
        if (r20 == false) goto L136;
        HashMap r121 = new HashMap();
        r121.put("follow_type", "follow");
        r121.put("type", "native");
        LiveSlardarMonitor.monitorStatus("ttlive_monitor_profile_follow", 0, r121);
    L136:
        if ((r5.b() instanceof IRoom) == false) goto L142;
        int r122 = h1.a;
        IRoom r123 = r5.b();
        if (r123 == null) goto L141;
        r1.putAll(h1.a(r123));
        goto L142
    L141:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
    L142:
        LiveMode r124 = r5.getStreamType();
        int r125 = h1.a;
        r1.put("live_type", i1.a(r124));
        Long r126 = r5.getAutoCover();
        if (r126 != null) goto L146;
    L147:
        Long r127 = r5.getAutoCover();
        if (r127 != null) goto L151;
    L153:
        String r128 = "other";
    L154:
        r1.put("cover_type", r128);
    L156:
        if (((Boolean) ts0.a.e.getValue()).booleanValue() == false) goto L158;
        Object r129 = DataType.TRUE;
    L159:
        r1.put("is_screen_clear", r129);
        qs0.b r130 = os0.b.c().getAudienceGameContext();
        if (r130 != null) goto L162;
    L164:
        r1.put("action_page", "profile_card");
        if (r22 == false) goto L167;
        Object r131 = DataType.TRUE;
    L168:
        r1.put("is_follow_back", r131);
        r1.put("connection_type", r13.getLinkConnectionType());
        String r26 = r7.getLinkAnchorCount();
        if (r26 == null) goto L171;
        r1.put("anchor_cnt", r26);
        Unit r27 = Unit.INSTANCE;
    L171:
        if (r20 == false) goto L181;
        com.bytedance.android.livesdk.chatroom.o r28 = os0.b.a();
        if (r28 == null) goto L179;
        com.bytedance.live.datacontext.m r29 = r28.isCleanMode();
        if (r29 == null) goto L179;
        if (((Boolean) r29.getValue()).booleanValue() != true) goto L179;
        Object r30 = DataType.TRUE;
    L180:
        r1.put("if_clear_mode", r30);
    L179:
        r30 = DataType.FALSE;
    L181:
        r1.put("click_user_position", r24);
        boolean r2 = r5 instanceof ProfileRoomProxy;
        if (r2 == false) goto L225;
        if (r2 == true) goto L185;
        ps0.b r32 = null;
    L186:
        ProfileRoomProxy r33 = (ProfileRoomProxy) r32;
        if (r33 == null) goto L189;
        IRoom r34 = r33.a;
    L190:
        int r35 = vt0.g.a;
        Intrinsics.checkNotNullParameter(r3, "uid");
        ILinkService r36 = (ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class);
        p11.j r37 = r36.mo471getRevenueLinkDataHolder();
        if (r37 == null) goto L193;
        String r38 = r37.a();
    L195:
        if (Intrinsics.areEqual(r38, r3) == true) goto L223;
        p11.e r39 = r36.mo468getMultiAnchorService();
        if (r39 != null) goto L199;
    L201:
        if (r34 != null) goto L206;
        com.bytedance.live.datacontext.m r40 = os0.b.a().getRoom();
        if (r40 == null) goto L205;
        r34 = (IRoom) r40.getValue();
        goto L206
    L205:
        r34 = null;
    L206:
        if (r34 == null) goto L208;
        String r42 = r34.getOwnerUserIdString();
    L210:
        if (Intrinsics.areEqual(r42, r3) == true) goto L223;
        if (r34 == null) goto L218;
        IOfficialChannelInfo r43 = r34.getOfficialChannelInfo();
        if (r43 == null) goto L218;
        IBaseUser r44 = r43.getChannelUser();
        if (r44 == null) goto L218;
        String r45 = r44.getIdString();
    L220:
        if (Intrinsics.areEqual(r45, r3) == true) goto L223;
        int r46 = 0;
    L224:
        r115.d = r46;
    L229:
        p11.h r47 = r7.mo470getPkService();
        if (r47 != null) goto L232;
    L234:
        boolean r48 = false;
    L235:
        if (r48 == false) goto L241;
        if (r8 == null) goto L238;
        Long r49 = Long.valueOf(r8.getPkId());
    L239:
        String r50 = String.valueOf(r49.longValue());
        if (r50 == null) goto L241;
    L242:
        r1.put("pk_id", r50);
        if (r48 == false) goto L245;
        Object r52 = DataType.TRUE;
    L246:
        r1.put("is_in_pk", r52);
        NewProfileUser r53 = this.g.getTargetUser();
        DressSuitInfo r54 = r53.getDressSuitInfo();
        if (r54 == null) goto L249;
        String r55 = r54.getUserSuitId();
    L250:
        if (r55 != null) goto L252;
    L255:
        boolean r56 = true;
    L256:
        if (r56 == false) goto L258;
        String r57 = "none";
    L263:
        r1.put("package_id", r57);
        com.bytedance.android.live.profile.model.d r58 = this.g.getPageTypeUseCase().a(r53);
        if (r58.a != 0) goto L271;
        int r59 = r58.b;
        int r60 = 1;
        int r62 = 3;
        if (r59 == 1) goto L270;
        if (r59 == 3) goto L270;
        String r63 = "audience_to_audience";
    L277:
        int r64 = r58.b;
        if (r64 == r60) goto L282;
        if (r64 == r62) goto L281;
        String r65 = "-1";
    L283:
        r115.e = FollowLog.Scene.ProfileCard;
        r115.g = r63;
        r115.h = r65;
        if (Intrinsics.areEqual(r5.getOwnerUserIdStr(), r3) == false) goto L286;
        r1.put("to_user_type", "anchor");
    L361:
        UserProfileEvent r66 = this.g.getUserProfileEvent();
        if (r66 == null) goto L366;
        Long r67 = r66.getCommentMsgId();
        if (r67 == null) goto L366;
        r1.put("msg_id", String.valueOf(r67.longValue()));
        Unit r68 = Unit.INSTANCE;
    L366:
        p11.h r69 = r7.mo470getPkService();
        if (r69 == null) goto L371;
        HashMap r70 = r69.getFollowExtraParams(r3);
        if (r70 == null) goto L371;
        r1.putAll(r70);
        Unit r72 = Unit.INSTANCE;
    L371:
        com.bytedance.android.live.profile.usecase.a r73 = this.g;
        if ((r73 instanceof com.bytedance.android.live.profile.a) == true) goto L374;
    L376:
        r1.put("is_square_msg_enter", DataType.FALSE);
    L377:
        j0 r74 = j0.l();
        if (r20 == false) goto L380;
        String r75 = "livesdk_follow";
    L381:
        x r76 = new x();
        r76.a = "live_interact";
        r76.b = "live_detail";
        r74.sendLog(r75, r1, new Object[]{this.a, r115, u.class, r76, IRoom.class, am2.n.f()});
        return;
    L380:
        r75 = "livesdk_unfollow";
        goto L381
    L374:
        if (((com.bytedance.android.live.profile.a) r73).showSquareButtonArea() == false) goto L376;
        r1.put("is_square_msg_enter", DataType.TRUE);
        goto L377
    L286:
        mv0.k.d r77 = os0.b.c().getIInteractService().getLinkUserInfoCenter();
        if (r77 == null) goto L304;
        List<ILinkPlayerInfoBridge> r78 = r77.n();
        if (r78 == null) goto L304;
        Iterator<T> r79 = r78.iterator();
    L292:
        if (r79.hasNext() == false) goto L302;
        Object r80 = r79.next();
        ILinkPlayerInfoBridge r82 = (ILinkPlayerInfoBridge) r80;
        if (r82 == null) goto L298;
        IBaseUser r83 = r82.getUser();
        if (r83 == null) goto L298;
        String r84 = r83.getIdString();
    L300:
        if (Intrinsics.areEqual(r84, r3) == false) goto L292;
    L303:
        ILinkPlayerInfoBridge r85 = (ILinkPlayerInfoBridge) r80;
    L306:
        if (r85 == null) goto L308;
        r1.put("to_user_type", "guest");
        goto L361
    L308:
        mv0.k.d r86 = os0.b.c().getIInteractService().getLinkUserInfoCenter();
        if (r86 == null) goto L326;
        List<ILinkPlayerInfoBridge> r87 = r86.m();
        if (r87 == null) goto L326;
        Iterator<T> r88 = r87.iterator();
    L314:
        if (r88.hasNext() == false) goto L324;
        Object r89 = r88.next();
        ILinkPlayerInfoBridge r132 = (ILinkPlayerInfoBridge) r89;
        if (r132 == null) goto L320;
        IBaseUser r133 = r132.getUser();
        if (r133 == null) goto L320;
        String r134 = r133.getIdString();
    L322:
        if (Intrinsics.areEqual(r134, r3) == false) goto L314;
    L325:
        ILinkPlayerInfoBridge r90 = (ILinkPlayerInfoBridge) r89;
    L327:
        if (r90 == null) goto L329;
        r1.put("to_user_type", "guest");
        goto L361
    L329:
        IRoomOthersData r92 = r5.k3();
        if (r92 == null) goto L343;
        IAnchorTogetherLive r93 = r92.getAnchorTogetherLive();
        if (r93 == null) goto L343;
        List r94 = r93.getTogetherAnchor();
        if (r94 == null) goto L343;
        Iterator r95 = r94.iterator();
    L337:
        if (r95.hasNext() == false) goto L341;
        Object r96 = r95.next();
        if (Intrinsics.areEqual(((IBaseUser) r96).getIdString(), r3) == false) goto L337;
    L342:
        IBaseUser r97 = (IBaseUser) r96;
    L345:
        if (r97 == null) goto L347;
        r1.put("to_user_type", "member");
        goto L361
    L347:
        boolean r98 = com.bytedance.android.live.revenue.core.util.h.a;
        List r99 = com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getGroupMemberList();
        if (r99 == null) goto L357;
        Iterator r100 = r99.iterator();
    L351:
        if (r100.hasNext() == false) goto L355;
        Object r101 = r100.next();
        if (Intrinsics.areEqual(((IBaseUser) r101).getIdString(), r3) == false) goto L351;
        Object r102 = r101;
    L356:
        IBaseUser r103 = (IBaseUser) r102;
    L358:
        if (r103 == null) goto L360;
        r1.put("to_user_type", "member");
        goto L361
    L360:
        r1.put("to_user_type", r117);
        goto L361
    L355:
        r102 = null;
        goto L356
    L357:
        r103 = null;
        goto L358
    L341:
        r96 = null;
    L343:
        r97 = null;
    L320:
        r134 = null;
        goto L322
    L324:
        r89 = null;
    L326:
        r90 = null;
    L298:
        r84 = null;
        goto L300
    L302:
        r80 = null;
    L304:
        r85 = null;
        goto L306
    L281:
        r65 = DataType.FALSE;
        goto L283
    L282:
        r65 = DataType.TRUE;
    L270:
        r63 = "audience_to_anchor";
        goto L277
    L271:
        r60 = 1;
        r62 = 3;
        int r104 = r58.b;
        if (r104 == 1) goto L276;
        if (r104 == 3) goto L276;
        r63 = "anchor_to_audience";
    L276:
        r63 = "anchor_to_anchor";
        goto L277
    L258:
        DressSuitInfo r105 = r53.getDressSuitInfo();
        if (r105 == null) goto L261;
        r57 = r105.getUserSuitId();
    L262:
        Intrinsics.checkNotNull(r57);
        goto L263
    L261:
        r57 = null;
        goto L262
    L252:
        if (r55.length() == 0) goto L255;
        r56 = false;
        goto L256
    L249:
        r55 = null;
        goto L250
    L245:
        r52 = DataType.FALSE;
        goto L246
    L238:
        r49 = null;
    L241:
        r50 = r117;
        goto L242
    L232:
        if (r47.getPkState() != 1) goto L234;
        r48 = true;
    L218:
        r45 = null;
        goto L220
    L208:
        r42 = null;
        goto L210
    L199:
        if (r39.a(r3) != true) goto L201;
    L223:
        r46 = 1;
        goto L224
    L193:
        r38 = null;
        goto L195
    L189:
        r34 = null;
        goto L190
    L185:
        r32 = r5;
        goto L186
    L225:
        if (r25 == false) goto L227;
        Object r106 = DataType.TRUE;
    L228:
        r1.put("is_anchor", r106);
        goto L229
    L227:
        r106 = DataType.FALSE;
        goto L228
    L167:
        r131 = DataType.FALSE;
        goto L168
    L162:
        if (r130.j() == null) goto L164;
        qs0.b.a r135 = r130.j();
        Intrinsics.checkNotNull(r135);
        r1.put("game_id", String.valueOf(r135.a()));
        qs0.b.a r136 = r130.j();
        Intrinsics.checkNotNull(r136);
        r1.put("game_name", String.valueOf(r136.b()));
        goto L164
    L158:
        r129 = DataType.FALSE;
        goto L159
    L151:
        if (r127.longValue() != 1) goto L153;
        r128 = "autocover";
        goto L154
    L146:
        if (r126.longValue() == 0) goto L156;
    L117:
        if (TextUtils.equals(r23, "single_room_rank") == true) goto L120;
        if (TextUtils.equals(r23, "weekly_rank") == false) goto L121;
    L82:
        if (r17 == false) goto L84;
        String r107 = "loyal_audience_c_anchor";
    L85:
        r115.a = r107;
        goto L115
    L84:
        r107 = "carousel_audience_c_anchor";
        goto L85
    L87:
        if (r12 != 3) goto L115;
        if (r18 == false) goto L90;
        r115.a = "carousel_host_c_official_id";
        goto L115
    L90:
        if (r17 == false) goto L92;
        String r108 = "loyal_audience_c_official_id";
    L93:
        r115.a = r108;
        goto L115
    L92:
        r108 = "carousel_audience_c_official_id";
        goto L93
    L78:
        if (r12 == 3) goto L79;
    L95:
        if (r12 == 1) goto L98;
        r115.a = "live_audience_c_anchor";
        goto L115
    L98:
        if (r16 == false) goto L104;
        if (r19 == false) goto L104;
        if (r17 == false) goto L102;
        String r109 = "loyal_audience_c_carousel_host";
    L103:
        r116 = r109;
        r115.a = r116;
    L112:
        if (TextUtils.isEmpty(r116) == false) goto L115;
        r115.a = "live_audience_c_audience";
        goto L115
    L102:
        r109 = "carousel_audience_c_carousel_host";
    L104:
        if (r10 == false) goto L108;
        r115.a = "audience_c_anchor";
        if (r115.c != null) goto L112;
        r116 = "audience_c_anchor";
        goto L112
    L108:
        r115.a = "live_audience_c_audience";
        if (r115.c != null) goto L112;
        r116 = "live_audience_c_audience";
        goto L112
    L64:
        if (r16 == false) goto L67;
        if (r19 == false) goto L67;
        r115.a = "anchor_c_carousel_host";
    L73:
        if (TextUtils.isEmpty(r116) == false) goto L115;
        r115.a = "live_anchor_c_audience";
    L67:
        if (r10 == false) goto L69;
        r115.a = "anchor_c_anchor";
        goto L73
    L69:
        r115.a = "live_anchor_c_audience";
        if (r115.c != null) goto L73;
        r116 = "live_anchor_c_audience";
        goto L73
    L57:
        if (Intrinsics.areEqual(r116, "guest_contribution_list") == true) goto L60;
        if (Intrinsics.areEqual(r116, "guest_waiting_list") == false) goto L62;
    L61:
        r117 = "";
        r116 = null;
        goto L62
    L31:
        if (r13.isMicRoomHost(r3) == false) goto L33;
        r19 = true;
        goto L34
    L26:
        if (r13.isMicRoomHost(r15.toString()) == false) goto L28;
        r18 = true;
    L22:
        r17 = false;
        goto L23
    L9:
        if (r8 == null) goto L11;
        String r137 = r8.a();
    L13:
        if (Intrinsics.areEqual(r137, r3) == false) goto L15;
        r12 = 2;
        goto L16
    L15:
        r12 = 1;
        goto L16
    L11:
        r137 = null;
        goto L13
    L5:
        r9 = null;
        goto L6
    }
}
