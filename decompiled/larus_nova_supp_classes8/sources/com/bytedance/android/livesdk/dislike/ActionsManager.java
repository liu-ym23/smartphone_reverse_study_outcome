package com.bytedance.android.livesdk.dislike;

import android.view.View;
import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.k2;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livesdk.chatroom.utils.o4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.Cif;
import com.bytedance.android.livesdk.config.aa;
import com.bytedance.android.livesdk.config.b11;
import com.bytedance.android.livesdk.config.bf1;
import com.bytedance.android.livesdk.config.ea1;
import com.bytedance.android.livesdk.config.jc;
import com.bytedance.android.livesdk.config.mo;
import com.bytedance.android.livesdk.config.n70;
import com.bytedance.android.livesdk.config.pe0;
import com.bytedance.android.livesdk.config.v9;
import com.bytedance.android.livesdk.dislike.action.AddWidgetAction;
import com.bytedance.android.livesdk.dislike.action.FollowAction;
import com.bytedance.android.livesdk.dislike.action.NotifyAction;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.action.RecommendToFriendsAction;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdk.utils.w5;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.model.DislikeConfig;
import com.bytedance.android.livesdkapi.model.ReportConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LivePlayNotifyIntegrateConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ActionsManager {
    public static final /* synthetic */ int g = 0;
    public final List<String> a;
    public final List<String> b;
    public final m c;
    public final Room d;
    public final String e;
    public final DataCenter f;

    public static final class a {
    }

    public static final class b extends OptionAction {
        public final /* synthetic */ ImageRecognitionButton e;

        @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
        public final void c() {
            super.c();
            this.e.onHide();
        }

        @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.e.onClick(r2);
        }

        @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
        public final void d(Function1<? super Map<String, ? extends Object>, Unit> r1) {
            this.e.onShow();
        }

        public b(ImageRecognitionButton r1, ActionsManager r2) {
            this.e = r1;
            super(r2);
            this.d = true;
        }
    }

    public static final class c implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ ActionsManager a;
        public final /* synthetic */ IHostBusiness.IFeedShareServiceForLive b;

        public c(ActionsManager r1, IHostBusiness.IFeedShareServiceForLive r2) {
            this.a = r1;
            this.b = r2;
        }

        public final String generate() {
            StringBuilder r0 = new StringBuilder("serviceForLive = ");
            r0.append(this.b);
            r0.append(", position = ");
            List<String> r1 = this.a.a;
            if (r1 == null) goto L9;
            Object[] r2 = r1.toArray(new String[0]);
            if (r2 == null) goto L8;
            String[] r3 = (String[]) r2;
        L10:
            r0.append(Arrays.toString(r3));
            return r0.toString();
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L9:
            r3 = null;
            goto L10
        }
    }

    static {
    }

    public static boolean a() {
        ILinkServiceExternal r0 = jc1.k.f(ILinkServiceExternal.class);
        if (r0 == null) goto L11;
        lc0.a r1 = r0.getControlServiceExternal();
        if (r1 == null) goto L11;
        if (gd0.v.a(r1.getCurrentMode(), 64) == false) goto L11;
        if (ea1.a.getValue().booleanValue() == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final u e() {
        List<String> r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        Room r1 = this.d;
        if (r1 == null) goto L12;
        User r2 = r1.getOwner();
        if (r2 == null) goto L12;
        Boolean r3 = Boolean.valueOf(r2.isFollowing());
    L13:
        if (r3 == null) goto L20;
        if (r3.booleanValue() == false) goto L20;
        if (x(true) == false) goto L20;
        return null;
    L20:
        return new u(new nt1.c(2131252286, 2131916229, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.f(this), ItemType.DISLIKE_ANCHOR);
    L12:
        r3 = null;
        goto L13
    L5:
        if (r0.contains("dislike") == true) goto L7;
        return null;
    }

    public final u f() {
        List<String> r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        Room r1 = this.d;
        if (r1 == null) goto L12;
        User r2 = r1.getOwner();
        if (r2 == null) goto L12;
        Boolean r3 = Boolean.valueOf(r2.isFollowing());
    L13:
        if (r3 == null) goto L20;
        if (r3.booleanValue() == false) goto L20;
        if (x(true) == false) goto L20;
        return null;
    L20:
        return new u(new nt1.c(2131252285, 2131916231, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.g(this), ItemType.DISLIKE_CONTENT);
    L12:
        r3 = null;
        goto L13
    L5:
        if (r0.contains("dislike") == true) goto L7;
        return null;
    }

    public final u i() {
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L6;
        return null;
    L6:
        if (((Boolean) n70.a.getValue()).booleanValue() == true) goto L9;
        return null;
    L9:
        if (y3.m(this.f).n(ToolbarButton.COMMERCE) == false) goto L11;
        return null;
    L11:
        c0 r0 = y3.m(this.f);
        if (r0.n(ToolbarButton.GROUP_PURCHASE) == false) goto L14;
    L19:
        boolean r1 = true;
    L20:
        if (r1 == false) goto L25;
        if (jc1.k.n(ILiveDouPlusService.class).shouldShowLocalPromotion() == false) goto L25;
        return null;
    L25:
        return new u(new nt1.c(2131252494, 2131920134, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.k(this), ItemType.DOU_PLUS);
    L14:
        if (r0.n(ToolbarButton.GROUP_PURCHASE_MORE) == true) goto L19;
        if (r0.n(ToolbarButton.GROUP_PURCHASE_AUDIENCE) == true) goto L19;
        r1 = false;
        goto L20
    }

    public final u j() {
        String r4 = com.bytedance.android.livesdk.model.b.a().getFeedbackText();
        if (com.bytedance.android.livesdk.model.b.a().getStyle() == 0) goto L5;
        boolean r5 = true;
    L7:
        return new u(new nt1.c(2131252287, 2131916236, r4, r5, false, false, null, 112), new com.bytedance.android.livesdk.dislike.action.i(this), ItemType.OPT_RECOMMEND);
    L5:
        r5 = false;
        goto L7
    }

    public final u l() {
        DataCenter r0 = this.f;
        if (r0 == null) goto L7;
        ImageRecognitionButton r1 = s32.b.c(r0);
        if (r1 == null) goto L7;
        return new u(new nt1.c(r1.getIconRes(), r1.getDescRes(), null, false, false, r1.canShowRedDot(), null, 92), new b(r1, this), ItemType.IMAGE_RECOGNITION);
    L7:
        return null;
    }

    public final u o() {
        return new u(new nt1.c(2131250328, 2131920137, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.n(this), ItemType.MORE_FRIENDS);
    }

    public static boolean x(boolean r0) {
        if (r0 == false) goto L6;
        return false;
    L6:
        return mo.a.getValue().booleanValue();
    }

    public final u b(boolean r11) {
        if (r11 == false) goto L13;
        List<String> r12 = this.b;
        String r1 = ItemType.ADD_TO_DESKTOP.name();
        Locale r2 = Locale.ROOT;
        if (r1 == null) goto L12;
        ArrayList r13 = (ArrayList) r12;
        if (r13.contains(r1.toLowerCase(r2)) == true) goto L9;
    L10:
        return null;
    L9:
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L13;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L13:
        Room r14 = this.d;
        if (r14 == null) goto L29;
        RoomAuthStatus r15 = r14.getRoomAuthStatus();
        if (r15 == null) goto L29;
        if (r15.isEnableRoomWidget() != true) goto L29;
        if (o4.c == true) goto L24;
        return null;
    L24:
        if (((b11) v9.a.getValue()).b() == false) goto L26;
        o4.c("livesdk_desktop_app_guide_show", "long_press");
    L28:
        return new u(new nt1.c(2131248575, 2131914516, null, false, false, false, null, 124), new AddWidgetAction(this), ItemType.ADD_TO_DESKTOP);
    L26:
        com.bytedance.android.livesdk.castscreen.utils.c.a("livesdk_live_widget_show", this.d, ActionsManager$createAddWidgetItem$1.INSTANCE);
    L29:
        return null;
    }

    public final u c(boolean r14) {
        StringBuilder r0 = new StringBuilder("the showList is：");
        List<String> r1 = this.a;
        boolean r2 = false;
        if (r1 == null) goto L9;
        Object[] r3 = r1.toArray(new String[0]);
        if (r3 == null) goto L8;
        String[] r4 = (String[]) r3;
    L10:
        r0.append(Arrays.toString(r4));
        ALogger.d("audio_feedback", r0.toString());
        StringBuilder r5 = new StringBuilder("create audio feedback item.isDouyinOnly:");
        r5.append(tb1.c.g);
        r5.append("\tshowList contains audio:");
        List<String> r6 = this.a;
        if (r6 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        r5.append(r7);
        ALogger.d("audio_feedback", r5.toString());
        if (Cif.a.getValue().b() == true) goto L19;
        return null;
    L19:
        if (r14 == false) goto L27;
        List<String> r15 = this.b;
        String r8 = ItemType.AUDIO_FEEDBACK.name();
        Locale r9 = Locale.ROOT;
        if (r8 == null) goto L26;
        if (((ArrayList) r15).contains(r8.toLowerCase(r9)) == true) goto L27;
        return null;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L27:
        List<String> r16 = this.a;
        if (r16 != null) goto L30;
    L32:
        if (r2 == false) goto L34;
        ActionsManager r17 = this;
    L35:
        if (r17 != null) goto L37;
        return null;
    L37:
        return new u(new nt1.c(2131252284, 2131920133, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.d(this), ItemType.AUDIO_FEEDBACK);
    L34:
        r17 = null;
        goto L35
    L30:
        if (r16.contains("audio_feedback") != true) goto L32;
        r2 = true;
        goto L32
    L13:
        if (r6.contains("audio_feedback") != true) goto L15;
        r7 = true;
        goto L16
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        r4 = null;
        goto L10
    }

    public final u g(boolean r12) {
        List<String> r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        Room r1 = this.d;
        if (r1 == null) goto L12;
        User r2 = r1.getOwner();
        if (r2 == null) goto L12;
        Boolean r3 = Boolean.valueOf(r2.isFollowing());
    L13:
        if (r3 == null) goto L20;
        if (r3.booleanValue() == false) goto L20;
        if (x(r12) == false) goto L20;
        return null;
    L20:
        if (r12 == false) goto L22;
        int r4 = 2131252285;
    L24:
        return new u(new nt1.c(r4, 2131920716, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.e(this), ItemType.DISLIKE);
    L22:
        r4 = 2131250342;
    L12:
        r3 = null;
        goto L13
    L5:
        if (r0.contains("dislike") == true) goto L7;
        return null;
    }

    public final u n(boolean r11) {
        if (r11 == false) goto L11;
        List<String> r12 = this.b;
        String r1 = ItemType.FLOAT_WINDOW.name();
        Locale r2 = Locale.ROOT;
        if (r1 == null) goto L10;
        ArrayList r13 = (ArrayList) r12;
        if (r13.contains(r1.toLowerCase(r2)) == true) goto L11;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        List<Pair<IInnerFloatWindowSceneInterceptor, Integer>> r14 = com.bytedance.android.livesdk.floatview.inner.b.a;
        if (com.bytedance.android.livesdk.floatview.inner.b.a() == true) goto L15;
        return null;
    L15:
        return new u(new nt1.c(2131252294, 2131920136, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.m(this, this.f), ItemType.FLOAT_WINDOW);
    }

    public final u q(boolean r11) {
        if (r11 == false) goto L12;
        List<String> r12 = this.b;
        String r0 = ItemType.OPT_RECOMMEND.name();
        Locale r1 = Locale.ROOT;
        if (r0 == null) goto L10;
        ArrayList r13 = (ArrayList) r12;
        if (r13.contains(r0.toLowerCase(r1)) == true) goto L12;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L12:
        return new u(new nt1.c(2131252287, 2131920141, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.i(this), ItemType.OPT_RECOMMEND);
    }

    public final u r(boolean r12) {
        if (r12 == false) goto L11;
        List<String> r1 = this.b;
        String r2 = ItemType.PK_FEEDBACK.name();
        Locale r3 = Locale.ROOT;
        if (r2 == null) goto L10;
        if (((ArrayList) r1).contains(r2.toLowerCase(r3)) == true) goto L11;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        List<String> r4 = this.a;
        if (r4 != null) goto L14;
    L16:
        ILinkServiceExternal r5 = jc1.k.f(ILinkServiceExternal.class);
        if (r5 == null) goto L21;
        lc0.d r6 = r5.getPkServiceExternal();
        if (r6 == null) goto L21;
        RevPkState r7 = r6.d();
    L22:
        String r8 = jc1.k.n(IUserService.class).user().n();
        if (r12 == true) goto L25;
    L35:
        ILinkServiceExternal r13 = jc1.k.f(ILinkServiceExternal.class);
        if (r13 == null) goto L40;
        lc0.a r14 = r13.getControlServiceExternal();
        if (r14 == null) goto L40;
        int r15 = r14.getCurrentMode();
    L42:
        if (gd0.v.a(r15, 64) == false) goto L44;
        int r9 = 2131920529;
    L46:
        return new u(new nt1.c(2131252289, r9, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.u(this), ItemType.PK_FEEDBACK);
    L44:
        r9 = 2131921375;
    L40:
        r15 = 0;
        goto L42
    L25:
        if (r7 != RevPkState.PK) goto L27;
    L28:
        Room r16 = this.d;
        if (r16 == null) goto L31;
        String r17 = r16.getOwnerUserIdString();
    L33:
        if (Intrinsics.areEqual(r8, r17) == false) goto L35;
    L34:
        return null;
    L31:
        r17 = null;
        goto L33
    L27:
        if (a() == false) goto L34;
    L21:
        r7 = null;
        goto L22
    L14:
        if (r4.contains("pk_feedback") == true) goto L16;
        return null;
    }

    public final y s(boolean r4) {
        if (r4 == false) goto L11;
        List<String> r5 = this.b;
        String r1 = ItemType.RECOMMEND_TO_FRIENDS.name();
        Locale r2 = Locale.ROOT;
        if (r1 == null) goto L10;
        ArrayList r6 = (ArrayList) r5;
        if (r6.contains(r1.toLowerCase(r2)) == true) goto L11;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        int r7 = RecommendLiveHelper.a;
        Room r8 = this.d;
        ILiveRecommendToFriendsService r3 = RecommendLiveHelper.d();
        if (r3 == null) goto L16;
        boolean r9 = r3.canShowItem(r8);
        boolean r10 = true;
        if (r9 != true) goto L16;
    L17:
        if (r10 == true) goto L19;
    L23:
        return null;
    L19:
        if (jc1.k.n(IUserService.class).user().isLogin() == false) goto L23;
        return new y(new RecommendToFriendsAction(this), ItemType.RECOMMEND_TO_FRIENDS);
    L16:
        r10 = false;
        goto L17
    }

    public final u t(boolean r11) {
        if (r11 == false) goto L12;
        List<String> r12 = this.b;
        String r1 = ItemType.SCREEN_RECORD.name();
        Locale r2 = Locale.ROOT;
        if (r1 == null) goto L10;
        if (((ArrayList) r12).contains(r1.toLowerCase(r2)) == true) goto L12;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L12:
        if (com.bytedance.android.livesdk.chatroom.record.u.f(false, this.d) == true) goto L14;
        return null;
    L14:
        ILivePlayerClient r13 = LivePlatformPlayerManager.f();
        if (r13 == null) goto L17;
        ILivePlayerExtraRenderController r14 = r13.extraRenderController();
    L18:
        if (r14 != null) goto L20;
    L22:
        List<String> r15 = this.a;
        if (r15 == null) goto L28;
        if (r15.contains("screen_record") == true) goto L28;
        return null;
    L28:
        return new u(new nt1.c(2131252290, 2131916234, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.x(this), ItemType.SCREEN_RECORD);
    L20:
        if (r14.isUgcRoom() != true) goto L22;
        return null;
    L17:
        r14 = null;
        goto L18
    }

    public final u u(boolean r11) {
        if (r11 == false) goto L11;
        List<String> r12 = this.b;
        String r1 = ItemType.REPORT.name();
        Locale r2 = Locale.ROOT;
        if (r1 == null) goto L10;
        ArrayList r13 = (ArrayList) r12;
        if (r13.contains(r1.toLowerCase(r2)) == true) goto L11;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        List<String> r14 = this.a;
        if (r14 == null) goto L17;
        if (r14.contains("report") == true) goto L17;
        return null;
    L17:
        return new u(new nt1.c(2131252291, 2131916235, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.w(this), ItemType.REPORT);
    }

    public final List<n> v(Boolean r10) {
        ArrayList r0 = new ArrayList();
        DislikeConfig r1 = (DislikeConfig) k2.a.getValue();
        IHostBusiness r2 = jc1.k.f(IHostBusiness.class);
        String r3 = null;
        if (r2 == null) goto L5;
        IHostBusiness.IFeedShareServiceForLive r4 = r2.getFeedShareServiceForLive();
    L6:
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.getFeedShareIconPosition(this.d));
    L9:
        StringBuilder r6 = new StringBuilder("serviceForLive = ");
        r6.append(r4);
        r6.append(", position = ");
        List<String> r7 = this.a;
        if (r7 == null) goto L16;
        Object[] r8 = r7.toArray(new String[0]);
        if (r8 == null) goto L15;
        String[] r9 = (String[]) r8;
    L17:
        r6.append(Arrays.toString(r9));
        ALogger.d("createLiveFeedOptionsItem", r6.toString());
        u r11 = l();
        if (r11 == null) goto L20;
        r0.add(r11);
    L20:
        u r12 = k(false, r10);
        if (r12 == null) goto L23;
        r0.add(r12);
    L23:
        Room r13 = this.d;
        if (r13 == null) goto L30;
        User r14 = r13.getOwner();
        if (r14 == null) goto L30;
        FollowInfo r15 = r14.getFollowInfo();
        if (r15 == null) goto L30;
        long r16 = r15.getPushStatus();
    L31:
        u r17 = p(r16, false);
        if (r17 == null) goto L35;
        r0.add(r17);
    L35:
        if (pe0.a.getValue().booleanValue() == false) goto L40;
        u r18 = u(false);
        if (r18 == null) goto L40;
        r0.add(r18);
    L40:
        if (com.bytedance.android.livesdk.model.b.b(r1) == false) goto L44;
        u r19 = q(false);
        if (r19 == null) goto L44;
        r0.add(r19);
    L44:
        u r110 = n(false);
        if (r110 == null) goto L48;
        r0.add(r110);
    L48:
        if (aa.a.getValue().booleanValue() == false) goto L52;
        u r111 = b(false);
        if (r111 == null) goto L52;
        r0.add(r111);
    L52:
        int r112 = FeedShareActionType.AFTER_DISLIKE.value;
        if (r5 != null) goto L56;
    L57:
        int r113 = FeedShareActionType.AFTER_FOLLOW.value;
        if (r5 != null) goto L61;
    L62:
        int r114 = FeedShareActionType.AFTER_REPORT.value;
        if (r5 != null) goto L66;
    L68:
        u r115 = c(false);
        if (r115 == null) goto L71;
        r0.add(r115);
    L71:
        ILinkServiceExternal r116 = jc1.k.f(ILinkServiceExternal.class);
        if (r116 == null) goto L76;
        lc0.d r117 = r116.getPkServiceExternal();
        if (r117 == null) goto L76;
        RevPkState r118 = r117.d();
    L78:
        if (r118 == RevPkState.PK) goto L82;
        if (a() == true) goto L82;
    L91:
        n r119 = d(2131916158, false, false);
        if (r119 == null) goto L94;
        r0.add(r119);
    L94:
        n r120 = h(false, false);
        if (r120 == null) goto L98;
        r0.add(r120);
    L98:
        return CollectionsKt.toMutableList(CollectionsKt.filterNotNull(r0));
    L82:
        if (tb1.c.a == false) goto L91;
        String r121 = jc1.k.n(IUserService.class).user().n();
        Room r20 = this.d;
        if (r20 == null) goto L87;
        r3 = r20.getOwnerUserIdString();
    L87:
        if ((!Intrinsics.areEqual(r121, r3)) == false) goto L91;
        u r122 = r(false);
        if (r122 == null) goto L91;
        r0.add(r122);
    L76:
        r118 = null;
        goto L78
    L66:
        if (r5.intValue() != r114) goto L68;
    L67:
        w5.a();
        goto L68
    L61:
        if (r5.intValue() == r113) goto L67;
    L56:
        if (r5.intValue() == r112) goto L67;
    L30:
        r16 = 2;
        goto L31
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L16:
        r9 = null;
        goto L17
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public final List<n> w(Boolean r10) {
        ArrayList r0 = new ArrayList();
        DislikeConfig r1 = (DislikeConfig) k2.a.getValue();
        IHostBusiness r2 = jc1.k.f(IHostBusiness.class);
        String r3 = null;
        if (r2 == null) goto L5;
        IHostBusiness.IFeedShareServiceForLive r4 = r2.getFeedShareServiceForLive();
    L6:
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.getFeedShareIconPosition(this.d));
    L9:
        StringBuilder r6 = new StringBuilder("serviceForLive = ");
        r6.append(r4);
        r6.append(", position = ");
        List<String> r7 = this.a;
        if (r7 == null) goto L16;
        Object[] r8 = r7.toArray(new String[0]);
        if (r8 == null) goto L15;
        String[] r9 = (String[]) r8;
    L17:
        r6.append(Arrays.toString(r9));
        ALogger.d("createLiveFeedOptionsItem", r6.toString());
        u r11 = l();
        if (r11 == null) goto L20;
        r0.add(r11);
    L20:
        n r12 = d(2131916159, true, false);
        if (r12 == null) goto L23;
        r0.add(r12);
    L23:
        n r13 = h(true, false);
        if (r13 == null) goto L27;
        r0.add(r13);
    L27:
        if (pe0.a.getValue().booleanValue() == false) goto L32;
        u r14 = u(false);
        if (r14 == null) goto L32;
        r0.add(r14);
    L32:
        if (com.bytedance.android.livesdk.model.b.b(r1) == false) goto L37;
        u r15 = q(false);
        if (r15 == null) goto L37;
        r0.add(r15);
    L37:
        if (aa.a.getValue().booleanValue() == false) goto L41;
        u r16 = b(false);
        if (r16 == null) goto L41;
        r0.add(r16);
    L41:
        ILinkServiceExternal r17 = jc1.k.f(ILinkServiceExternal.class);
        if (r17 == null) goto L46;
        lc0.d r18 = r17.getPkServiceExternal();
        if (r18 == null) goto L46;
        RevPkState r19 = r18.d();
    L47:
        Room r20 = this.d;
        if (r20 == null) goto L56;
        User r21 = r20.getOwner();
        if (r21 == null) goto L56;
        if (r21.isFollowing() != true) goto L56;
        u r22 = c(false);
        if (r22 == null) goto L56;
        r0.add(r22);
    L56:
        Room r23 = this.d;
        if (r23 == null) goto L77;
        User r24 = r23.getOwner();
        if (r24 == null) goto L77;
        if (r24.isFollowing() == true) goto L77;
        if (r19 == RevPkState.PK) goto L67;
        if (a() == false) goto L77;
    L67:
        if (tb1.c.a == false) goto L77;
        String r25 = jc1.k.n(IUserService.class).user().n();
        Room r26 = this.d;
        if (r26 == null) goto L71;
        String r27 = r26.getOwnerUserIdString();
    L73:
        if ((!Intrinsics.areEqual(r25, r27)) == false) goto L77;
        u r28 = r(false);
        if (r28 == null) goto L77;
        r0.add(r28);
        goto L77
    L71:
        r27 = null;
    L77:
        u r110 = k(false, r10);
        if (r110 == null) goto L80;
        r0.add(r110);
    L80:
        Room r111 = this.d;
        if (r111 == null) goto L87;
        User r112 = r111.getOwner();
        if (r112 == null) goto L87;
        FollowInfo r113 = r112.getFollowInfo();
        if (r113 == null) goto L87;
        long r29 = r113.getPushStatus();
    L88:
        u r114 = p(r29, false);
        if (r114 == null) goto L91;
        r0.add(r114);
    L91:
        u r115 = n(false);
        if (r115 == null) goto L94;
        r0.add(r115);
    L94:
        int r116 = FeedShareActionType.AFTER_DISLIKE.value;
        if (r5 != null) goto L98;
    L99:
        int r117 = FeedShareActionType.AFTER_FOLLOW.value;
        if (r5 != null) goto L103;
    L104:
        int r118 = FeedShareActionType.AFTER_REPORT.value;
        if (r5 != null) goto L108;
    L110:
        Room r119 = this.d;
        if (r119 == null) goto L130;
        User r120 = r119.getOwner();
        if (r120 == null) goto L130;
        if (r120.isFollowing() != true) goto L130;
        if (r19 == RevPkState.PK) goto L121;
        if (a() == false) goto L130;
    L121:
        if (tb1.c.a == false) goto L130;
        String r121 = jc1.k.n(IUserService.class).user().n();
        Room r30 = this.d;
        if (r30 == null) goto L126;
        r3 = r30.getOwnerUserIdString();
    L126:
        if ((!Intrinsics.areEqual(r121, r3)) == false) goto L130;
        u r122 = r(false);
        if (r122 == null) goto L130;
        r0.add(r122);
    L130:
        Room r123 = this.d;
        if (r123 == null) goto L140;
        User r124 = r123.getOwner();
        if (r124 == null) goto L140;
        if (r124.isFollowing() == true) goto L140;
        u r125 = c(false);
        if (r125 == null) goto L140;
        r0.add(r125);
    L140:
        return CollectionsKt.toMutableList(CollectionsKt.filterNotNull(r0));
    L108:
        if (r5.intValue() != r118) goto L110;
    L109:
        w5.a();
        goto L110
    L103:
        if (r5.intValue() == r117) goto L109;
    L98:
        if (r5.intValue() == r116) goto L109;
    L87:
        r29 = 2;
    L46:
        r19 = null;
        goto L47
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L16:
        r9 = null;
        goto L17
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public final n h(boolean r10, boolean r11) {
        if (r11 == false) goto L12;
        List<String> r12 = this.b;
        String r1 = ItemType.DISLIKE_ANCHOR.name();
        Locale r2 = Locale.ROOT;
        if (r1 == null) goto L10;
        ArrayList r13 = (ArrayList) r12;
        if (r13.contains(r1.toLowerCase(r2)) == true) goto L12;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L12:
        if (this.a.contains("dislike") == true) goto L14;
        return null;
    L14:
        if (r10 == false) goto L17;
        return new u(new nt1.c(2131252295, 2131916229, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.f(this), ItemType.DISLIKE_ANCHOR);
    L17:
        return new j(new nt1.c(2131252295, 2131916229, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.f(this), ItemType.DISLIKE_ANCHOR);
    }

    public final u k(boolean r10, Boolean r11) {
        if (r10 == false) goto L11;
        List<String> r12 = this.b;
        String r1 = ItemType.FOLLOW.name();
        Locale r2 = Locale.ROOT;
        if (r1 == null) goto L10;
        if (((ArrayList) r12).contains(r1.toLowerCase(r2)) == true) goto L11;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        List<String> r13 = this.a;
        if (r13 != null) goto L14;
    L16:
        if (r11 != null) goto L23;
        Room r14 = this.d;
        if (r14 == null) goto L22;
        User r15 = r14.getOwner();
        if (r15 == null) goto L22;
        r11 = Boolean.valueOf(r15.isFollowing());
    L22:
        r11 = null;
    L23:
        if (r11 == null) goto L29;
        if (r11.booleanValue() == false) goto L29;
        return new u(new nt1.c(2131252293, 2131915449, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.c0(this), ItemType.UNFOLLOW);
    L29:
        return new u(new nt1.c(2131252288, 2131916689, null, false, false, false, null, 124), new FollowAction(this), ItemType.FOLLOW);
    L14:
        if (r13.contains("follow") == true) goto L16;
        return null;
    }

    public final List<n> m(boolean r21, Boolean r22) {
        DislikeConfig r2 = (DislikeConfig) k2.a.getValue();
        IHostBusiness r3 = jc1.k.f(IHostBusiness.class);
        if (r3 == null) goto L5;
        IHostBusiness.IFeedShareServiceForLive r4 = r3.getFeedShareServiceForLive();
    L6:
        if (r4 == null) goto L8;
        Integer r5 = Integer.valueOf(r4.getFeedShareIconPosition(this.d));
    L9:
        ALogger.d("createLiveFeedOptionsItem", new c(this, r4));
        ArrayList r6 = new ArrayList();
        u r7 = l();
        if (r7 == null) goto L12;
        r6.add(r7);
    L12:
        long r9 = 2;
        if (com.bytedance.android.livesdk.model.b.d() == false) goto L24;
        u r8 = n(false);
        if (r8 == null) goto L17;
        r6.add(r8);
    L17:
        r6.add(k(false, r22));
        Room r1 = this.d;
        if (r1 == null) goto L23;
        RoomAuthStatus r10 = r1.getMRoomAuthStatus();
        if (r10 == null) goto L23;
        if (r10.getShowShare() != 2) goto L23;
    L155:
        Room r11 = this.d;
        if (r11 == null) goto L162;
        User r12 = r11.getOwner();
        if (r12 == null) goto L162;
        FollowInfo r13 = r12.getFollowInfo();
        if (r13 == null) goto L162;
        r9 = r13.getPushStatus();
    L162:
        r6.add(p(r9, false));
        ILinkServiceExternal r14 = jc1.k.f(ILinkServiceExternal.class);
        if (r14 == null) goto L167;
        lc0.d r15 = r14.getPkServiceExternal();
        if (r15 == null) goto L167;
        RevPkState r16 = r15.d();
    L169:
        if (r16 == RevPkState.PK) goto L173;
        if (a() == true) goto L173;
    L183:
        u r17 = null;
    L185:
        if (pe0.a.getValue().booleanValue() == false) goto L187;
        r6.add(u(false));
    L187:
        int r18 = FeedShareActionType.AFTER_REPORT.value;
        if (r5 != null) goto L191;
    L193:
        u r19 = t(false);
        if (r19 == null) goto L196;
        r6.add(r19);
    L196:
        u r20 = c(false);
        if (r20 == null) goto L200;
        r6.add(r20);
    L200:
        if (aa.a.getValue().booleanValue() == false) goto L204;
        u r23 = b(false);
        if (r23 == null) goto L204;
        r6.add(r23);
    L204:
        if (r17 == null) goto L206;
        r6.remove(r17);
        r6.add(r17);
    L206:
        List<n> r24 = CollectionsKt.toMutableList(CollectionsKt.filterNotNull(r6));
        u r25 = i();
        if (r25 != null) goto L209;
    L212:
        return r24;
    L209:
        if ((r24.size() - 1) < 5) goto L211;
        ListProtector.add(r24, 5, r25);
        goto L212
    L211:
        r24.add(r25);
        goto L212
    L191:
        if (r5.intValue() != r18) goto L193;
        w5.a();
        r6.add(null);
    L173:
        if (tb1.c.a == false) goto L183;
        String r26 = jc1.k.n(IUserService.class).user().n();
        Room r27 = this.d;
        if (r27 == null) goto L177;
        String r28 = r27.getOwnerUserIdString();
    L179:
        if ((!Intrinsics.areEqual(r26, r28)) == false) goto L183;
        r17 = r(false);
        if (r17 == null) goto L185;
        r6.add(r17);
        goto L185
    L177:
        r28 = null;
    L167:
        r16 = null;
    L23:
        r6.add(new u(new nt1.c(2131252292, 2131920142, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.j(this), ItemType.SHARE));
        goto L155
    L24:
        int r29 = com.bytedance.android.livesdk.model.b.a().getStyle();
        if (r29 != 2) goto L27;
    L32:
        boolean r30 = true;
    L33:
        if (r30 == true) goto L118;
        if (r21 == true) goto L36;
    L38:
        if (r21 == true) goto L80;
        if (com.bytedance.android.livesdk.model.b.e() == false) goto L80;
        if (mo.a.getValue().booleanValue() == false) goto L61;
        r6.add(g(true));
        u r31 = n(false);
        if (r31 == null) goto L46;
        r6.add(r31);
    L46:
        int r32 = FeedShareActionType.AFTER_DISLIKE.value;
        if (r5 == null) goto L53;
        if (r5.intValue() != r32) goto L53;
        w5.a();
        r6.add(null);
    L53:
        if (com.bytedance.android.livesdk.model.b.b(r2) == false) goto L55;
        r6.add(j());
    L55:
        r6.add(k(false, r22));
        int r33 = FeedShareActionType.AFTER_FOLLOW.value;
        if (r5 == null) goto L155;
        if (r5.intValue() != r33) goto L155;
        w5.a();
        r6.add(null);
        goto L155
    L61:
        r6.add(k(false, r22));
        int r34 = FeedShareActionType.AFTER_FOLLOW.value;
        if (r5 != null) goto L65;
    L67:
        r6.add(g(true));
        u r35 = n(false);
        if (r35 == null) goto L70;
        r6.add(r35);
    L70:
        int r36 = FeedShareActionType.AFTER_DISLIKE.value;
        if (r5 == null) goto L77;
        if (r5.intValue() != r36) goto L77;
        w5.a();
        r6.add(null);
    L77:
        if (com.bytedance.android.livesdk.model.b.b(r2) == false) goto L155;
        r6.add(j());
        goto L155
    L65:
        if (r5.intValue() != r34) goto L67;
        w5.a();
        r6.add(null);
    L80:
        if (mo.a.getValue().booleanValue() == false) goto L99;
        r6.add(g(true));
        u r37 = n(false);
        if (r37 == null) goto L84;
        r6.add(r37);
    L84:
        int r38 = FeedShareActionType.AFTER_DISLIKE.value;
        if (r5 == null) goto L91;
        if (r5.intValue() != r38) goto L91;
        w5.a();
        r6.add(null);
    L91:
        if (com.bytedance.android.livesdk.model.b.b(r2) == false) goto L93;
        r6.add(j());
    L93:
        r6.add(k(false, r22));
        int r39 = FeedShareActionType.AFTER_FOLLOW.value;
        if (r5 == null) goto L155;
        if (r5.intValue() != r39) goto L155;
        w5.a();
        r6.add(null);
        goto L155
    L99:
        r6.add(k(false, r22));
        int r40 = FeedShareActionType.AFTER_FOLLOW.value;
        if (r5 != null) goto L103;
    L105:
        r6.add(g(true));
        int r41 = FeedShareActionType.AFTER_DISLIKE.value;
        if (r5 != null) goto L109;
    L111:
        u r42 = n(false);
        if (r42 == null) goto L115;
        r6.add(r42);
    L115:
        if (com.bytedance.android.livesdk.model.b.b(r2) == false) goto L155;
        r6.add(j());
        goto L155
    L109:
        if (r5.intValue() != r41) goto L111;
        w5.a();
        r6.add(null);
        goto L111
    L103:
        if (r5.intValue() != r40) goto L105;
        w5.a();
        r6.add(null);
        goto L105
    L36:
        if (com.bytedance.android.livesdk.model.b.e() == false) goto L38;
    L118:
        if (mo.a.getValue().booleanValue() == false) goto L137;
        r6.add(f());
        r6.add(e());
        u r43 = n(false);
        if (r43 == null) goto L122;
        r6.add(r43);
    L122:
        int r44 = FeedShareActionType.AFTER_DISLIKE.value;
        if (r5 == null) goto L129;
        if (r5.intValue() != r44) goto L129;
        w5.a();
        r6.add(null);
    L129:
        if (com.bytedance.android.livesdk.model.b.b(r2) == false) goto L131;
        r6.add(j());
    L131:
        r6.add(k(false, r22));
        int r45 = FeedShareActionType.AFTER_FOLLOW.value;
        if (r5 == null) goto L155;
        if (r5.intValue() != r45) goto L155;
        w5.a();
        r6.add(null);
        goto L155
    L137:
        r6.add(k(false, r22));
        int r46 = FeedShareActionType.AFTER_FOLLOW.value;
        if (r5 != null) goto L141;
    L143:
        r6.add(f());
        r6.add(e());
        u r47 = n(false);
        if (r47 == null) goto L146;
        r6.add(r47);
    L146:
        int r48 = FeedShareActionType.AFTER_DISLIKE.value;
        if (r5 == null) goto L153;
        if (r5.intValue() != r48) goto L153;
        w5.a();
        r6.add(null);
    L153:
        if (com.bytedance.android.livesdk.model.b.b(r2) == false) goto L155;
        r6.add(j());
        goto L155
    L141:
        if (r5.intValue() != r46) goto L143;
        w5.a();
        r6.add(null);
        goto L143
    L27:
        if (r29 == 4) goto L32;
        if (r29 == 6) goto L32;
        r30 = false;
        goto L33
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public final u p(long r11, boolean r13) {
        if (jc.a.getValue().booleanValue() == true) goto L5;
        return null;
    L5:
        if (r13 == false) goto L14;
        List<String> r14 = this.b;
        String r0 = ItemType.LIVE_NOTIFICATION.name();
        Locale r2 = Locale.ROOT;
        if (r0 == null) goto L12;
        if (((ArrayList) r14).contains(r0.toLowerCase(r2)) == true) goto L14;
        return null;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L14:
        if (LivePlayNotifyIntegrateConfig.disableIWantToSee() == false) goto L16;
        return null;
    L16:
        List<String> r15 = this.a;
        if (r15 != null) goto L19;
    L21:
        Room r16 = this.d;
        if (r16 == null) goto L26;
        User r17 = r16.getOwner();
        if (r17 == null) goto L26;
        Boolean r18 = Boolean.valueOf(r17.isFollowing());
    L28:
        if (Intrinsics.areEqual(r18, Boolean.TRUE) == true) goto L30;
        return null;
    L30:
        return new u(new nt1.c(bn2.k.a(r11), 2131920752, null, false, false, false, null, 124), new NotifyAction(this, r11), ItemType.LIVE_NOTIFICATION);
    L26:
        r18 = null;
        goto L28
    L19:
        if (r15.contains("follow") == true) goto L21;
        return null;
    }

    public final n d(int r10, boolean r11, boolean r12) {
        if (r12 == false) goto L12;
        List<String> r13 = this.b;
        String r1 = ItemType.DISLIKE_CONTENT.name();
        Locale r2 = Locale.ROOT;
        if (r1 == null) goto L10;
        ArrayList r14 = (ArrayList) r13;
        if (r14.contains(r1.toLowerCase(r2)) == true) goto L12;
        return null;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L12:
        if (this.a.contains("dislike") == true) goto L14;
        return null;
    L14:
        if (r11 == false) goto L17;
        return new u(new nt1.c(2131252296, r10, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.g(this), ItemType.DISLIKE_CONTENT);
    L17:
        return new j(new nt1.c(2131252296, r10, null, false, false, false, null, 124), new com.bytedance.android.livesdk.dislike.action.g(this), ItemType.DISLIKE_CONTENT);
    }

    public ActionsManager(m r2, Room r3, String r4, String r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        Intrinsics.checkNotNullParameter(r5, "enterSource");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r6;
        ReportConfig r7 = bf1.a.getValue();
        if (r7 == null) goto L6;
        List<String> r8 = r7.longPressShowList;
        if (r8 == null) goto L6;
    L7:
        this.a = r8;
        List<ItemConfig> r9 = com.bytedance.android.livesdk.config.setting.l.b();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L9:
        if (r11.hasNext() == false) goto L13;
        String r12 = ((ItemConfig) r11.next()).getIdentity();
        if (r12 == null) goto L9;
        r10.add(r12);
        goto L9
    L13:
        this.b = r10;
        return;
    L6:
        r8 = new ArrayList();
        goto L7
    }

    public /* synthetic */ ActionsManager(m r7, Room r8, String r9, String r10, Boolean r11, int r12) {
        if ((r12 & 8) == 0) goto L5;
        r10 = "";
    L5:
        this(r7, r8, r9, r10, null);
    }
}
