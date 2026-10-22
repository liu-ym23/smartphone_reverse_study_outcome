package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoBasicPresenter;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.dsl.api.IDSLManagerService;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.bullet.forest.ForestLoader;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoBasicElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoBasicElement extends BaseElement {
    public UserInfoBasicPresenter d;
    public final float e;
    public final String f;
    public final c g;
    public final d h;
    public final ViewGroup i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ UserInfoBasicElement a;

        public a(UserInfoBasicElement r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            IRoom r13 = this.a.getRoom();
            if (r13 == null) goto L8;
            IBaseUser r14 = r13.getOwner();
            if (r14 == null) goto L8;
            String r15 = r14.getIdString();
            if (r15 == null) goto L8;
        L9:
            IRoom r1 = this.a.getRoom();
            if (r1 == null) goto L17;
            IBaseUser r2 = r1.getOwner();
            if (r2 == null) goto L17;
            py.f r3 = r2.getBorder();
            if (r3 == null) goto L17;
            String r4 = r3.getDressId();
            if (r4 == null) goto L17;
        L18:
            com.bytedance.android.livesdk.chatroom.o r5 = z51.a.h(this.a.getDataCenter(), 2);
            if (r5 == null) goto L25;
            com.bytedance.live.datacontext.n r6 = r5.getTemplateContext();
            if (r6 == null) goto L25;
            z70.b r7 = (z70.b) r6.getValue();
            if (r7 == null) goto L25;
            boolean r8 = r7.j("anchor_avatar");
        L26:
            if (r8 == false) goto L34;
            IRoom r16 = this.a.getRoom();
            if (r16 == null) goto L33;
            RoomAvator r17 = gb2.b.c(r16);
            if (r17 == null) goto L33;
            r15 = r17.getUserId();
            if (r15 != null) goto L34;
        L33:
            r15 = DataType.FALSE;
        L34:
            UserInfoBasicPresenter r9 = this.a.d;
            if (r9 == null) goto L59;
            Intrinsics.checkNotNullParameter(r15, "userId");
            Intrinsics.checkNotNullParameter(r4, "dressId");
            if (q0.a(r15) == false) goto L64;
            UserProfileEvent r10 = new UserProfileEvent(r15);
            r10.mSource = "anchor_profile";
            r10.setClickUserPosition("live_open_top_left_anchor");
            r10.setReportType("data_card_anchor");
            r10.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_USER_INFO));
            r10.wearId = r4;
            if (((Boolean) r9.e.b().getMiddleVm().isAppointmentShowing().getValue()).booleanValue() == false) goto L42;
            r10.addProfileClickUserExtraLog("is_announce_show", DataType.TRUE);
        L43:
            xs2.b.a().post(r10);
            ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).userInfoAutoAntiDeterioration();
            Integer r18 = (Integer) ev1.e.a.getValue();
            if (r18 != null) goto L47;
            return;
        L47:
            if (r18.intValue() != 2) goto L60;
            Integer r19 = (Integer) ev1.f.a.getValue();
            if (r19 != null) goto L52;
            return;
        L52:
            if (r19.intValue() != 1) goto L61;
            String r20 = ns0.d.a;
            q r110 = new q("shop_card_slice", r20);
            IDSLManagerService r0 = jc1.k.f(IDSLManagerService.class);
            if (r0 != null) goto L56;
            return;
        L56:
            if (r0.hasLocalGlobalCache(r110) == true) goto L63;
            ALogger.i("Live_LynxAir", "start preload.");
            int r111 = com.bytedance.android.anniex.api.b.a;
            Intrinsics.checkNotNullParameter(r20, "url");
            com.bytedance.ies.bullet.forest.f r112 = ForestLoader.a;
            ForestLoader.k(null, r20, false, null, PreloadType.LYNX, true, "AnnieX_card", null, 641);
            return;
        L63:
            return;
        L61:
            return;
        L60:
            return;
        L42:
            r10.addProfileClickUserExtraLog("is_announce_show", DataType.FALSE);
            goto L43
        L64:
            return;
        L59:
            return;
        L25:
            r8 = false;
        L17:
            r4 = "";
        L8:
            r15 = DataType.FALSE;
            goto L9
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ UserInfoBasicElement a;

        public b(UserInfoBasicElement r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            FragmentActivity r3 = this.a.getFragment().getActivity();
            if (r3 != null) goto L6;
            return false;
        L6:
            l81.n r0 = ((INavigationProxyService) jc1.k.n(INavigationProxyService.class)).getILiveSdkProjectModeService();
            if (r0 == null) goto L11;
            r0.a(r3);
            return true;
        L11:
            return true;
        }
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r1) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
        this.d = new UserInfoBasicPresenter(this.c, this.i);
        this.i.setOnClickListener(new a(this));
        l81.n r0 = ((INavigationProxyService) jc1.k.n(INavigationProxyService.class)).getILiveSdkProjectModeService();
        if (r0 == null) goto L5;
        Boolean r1 = r0.isPerfToolsDebug();
    L7:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L10;
        this.i.setOnLongClickListener(new b(this));
    L10:
        if (((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isNewFeedStyle(getDataCenter()) == false) goto L12;
        this.i.setBackground(s1.m(2131250033));
        b().getMiddleVm().getUserNameLayoutMaxWidthPx().setValue(Integer.valueOf((int) UIUtils.dip2Px(getContext(), this.e)));
        return;
    L12:
        this.i.setBackground(s1.m(2131250032));
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        UserInfoBasicPresenter r0 = this.d;
        if (r0 == null) goto L6;
        r0.e();
    L6:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixUserInfo() == false) goto L9;
        this.i.removeOnAttachStateChangeListener(this.g);
        r3.o(getContext(), this.h);
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
        UserInfoBasicPresenter r0 = this.d;
        if (r0 == null) goto L16;
        if (r0.c == true) goto L10;
        if (r0.d == true) goto L10;
        r0.f.setBackground(s1.m(2131250031));
    L10:
        if (r0.g() == false) goto L12;
    L14:
        r0.f.setBackground(s1.m(2131250030));
        goto L16
    L12:
        if (((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isNewFeedStyle(r0.a()) == false) goto L14;
        r0.f.setBackground(s1.m(2131250033));
    L16:
        if (isAnchor() == true) goto L37;
        String[] r1 = {"money", "fans", "nothing", "room_money"};     // Catch: Exception -> L32
        HashMap r2 = new HashMap();     // Catch: Exception -> L32
        IRoom r3 = getRoom();     // Catch: Exception -> L32
        String r4 = "";
        if (r3 == null) goto L23;
        String r5 = r3.getOwnerUserIdString();     // Catch: Exception -> L32
        if (r5 == null) goto L23;
    L24:
        r2.put("anchor_id", r5);     // Catch: Exception -> L32
        IRoom r6 = getRoom();     // Catch: Exception -> L32
        if (r6 == null) goto L30;
        String r7 = r6.getIdStr();     // Catch: Exception -> L32
        if (r7 == null) goto L30;
        r4 = r7;
    L30:
        r2.put("room_id", r4);     // Catch: Exception -> L32
        r2.put("rank_type", r1[3]);     // Catch: Exception -> L32
        jc1.k.n(IHostLog.class).logV3("livesdk_live_room_info", r2);     // Catch: Exception -> L32
        return;
    L23:
        r5 = "";
    L32:
        e = move-exception;
        Logger.throwException(e);
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        ElementBasicVM r0 = b().getBasicVm();
        m(r0.getContainerContentDescription().a(), new UserInfoBasicElement$initVm$$inlined$run$lambda$1(this));
        m(r0.getAnchorContentDesc().a(), new UserInfoBasicElement$initVm$$inlined$run$lambda$2(this));
        m(r0.getShowProfile().onEvent(), new UserInfoBasicElement$initVm$$inlined$run$lambda$3(this));
        ViewGroup r1 = this.i;
        IRoom r2 = getRoom();
        if (r2 == null) goto L7;
        String r3 = com.bytedance.android.live.room.navi.userinfo_p.utils.b.a(r2);
        if (r3 == null) goto L7;
    L8:
        r1.setContentDescription(r3);
        r3.e(this.i, new UserInfoBasicElement$accessibilityCompat$1(this));
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixUserInfo() == false) goto L11;
        r3.f(getContext(), this.h);
        this.i.addOnAttachStateChangeListener(this.g);
        return;
    L11:
        com.bytedance.android.live.room.navi.userinfo_p.element.b r4 = new com.bytedance.android.live.room.navi.userinfo_p.element.b(this);
        r3.f(getContext(), r4);
        this.i.addOnAttachStateChangeListener(new com.bytedance.android.live.room.navi.userinfo_p.element.a(this, r4));
        return;
    L7:
        r3 = "";
        goto L8
    }

    public UserInfoBasicElement(m91.d r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "anchorInfoContainer");
        super(r2);
        this.i = r3;
        this.e = 80.0f;
        this.f = "UserInfoBasicElementAccError";
        this.g = new c(this);
        this.h = new d(this);
    }
}
