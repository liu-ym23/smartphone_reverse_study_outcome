package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.o2;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkProfitApi;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.MultiLinkCommonEmptyMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.empty.MultiLinkAudioCommonEmptyMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.playmode.SceneType;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.DynamicTeamFightViewManager;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView.LinkMicQuickInteractView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.f2;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.zh1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.xb;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sh0.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/dynamic/DynamicTeamFightWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/c;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DynamicTeamFightWidget extends AbsPlayModeWidget implements com.bytedance.android.live.liveinteract.revenue.fight.c, vlc.l, Observer<KVData> {
    public static final /* synthetic */ int m = 0;
    public TeamFightContext a;
    public vlc.d b;
    public final CompositeDisposable c;
    public String d;
    public com.bytedance.android.live.liveinteract.multiscene.a e;
    public com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d f;
    public com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.e g;
    public o2 h;
    public long i;
    public boolean j;
    public boolean k;
    public final SceneType l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Map r4 = ((SubscriberJsEvent) r3).getParams();
            Object r0 = null;
            if (r4 == null) goto L5;
            Object r5 = r4.get("duration");
        L7:
            if ((r5 instanceof String) == true) goto L9;
            Object r1 = null;
        L10:
            String r2 = (String) r1;
            if (r2 == null) goto L14;
            Integer r6 = Integer.valueOf(CastIntegerProtector.parseInt(r2));
        L18:
            if (r6 == null) goto L20;
            int r7 = r6.intValue();
        L21:
            com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.c.Z0;
            Integer r9 = Integer.valueOf(r7);
            r8.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r8, r9);
            return;
        L20:
            r7 = 0;
            goto L21
        L14:
            if ((r5 instanceof Integer) == false) goto L17;
            r0 = r5;
        L17:
            r6 = (Integer) r0;
            goto L18
        L9:
            r1 = r5;
            goto L10
        L5:
            r5 = null;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DynamicTeamFightWidget a;

        public c(DynamicTeamFightWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            UserAttr r5 = (UserAttr) r4;
            Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a).isAnchor();
            boolean r1 = false;
            if (r0 == null) goto L5;
            boolean r2 = r0.booleanValue();
        L6:
            if (r2 == true) goto L9;
            boolean r3 = com.bytedance.android.live.liveinteract.utils.e.a;
            if (com.bytedance.android.live.liveinteract.utils.e.c(r5.getAdminPrivileges()) == true) goto L9;
        L10:
            ALogger.i("TeamFightTitleLayout", "：administrator：" + r1 + ", " + TeamFightContext.Companion.d());
            int r6 = li0.c.a;
            JSONObject r7 = new JSONObject();
            r7.put("eventName", "event_team_fight_privilege_change");
            r7.put("has_privilege", r1);
            jc1.k.n(IBaseBrowserService.class).sendEventToAllJsBridges("H5_webcastNotification", r7);
            return;
        L9:
            r1 = true;
            goto L10
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DynamicTeamFightWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(DynamicTeamFightWidget r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r12) {
            com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
            li0.b r0 = li0.b.b;
            DynamicTeamFightWidget r1 = this.a;
            int r2 = DynamicTeamFightWidget.m;
            if (r1.isAnchor() == false) goto L6;
            String r3 = "anchor";
        L9:
            f2 r14 = (f2) r13.data;
            if (r14 == null) goto L12;
            com.bytedance.android.live.liveinteract.multiscene.a r15 = r14.getLinkMicTeamFightInfo();
        L13:
            int r4 = this.b;
            String r5 = this.c;
            Intrinsics.checkNotNullParameter(r3, "userType");
            if (r15 == null) goto L30;
            HashMap r6 = new HashMap();
            int r7 = je0.d.S() - 1;
            if (r7 >= 0) goto L19;
            r7 = ((ArrayList) com.bytedance.android.live.liveinteract.multiscene.b.a(r15)).size();
        L19:
            r6.put("guest_cnt", String.valueOf(r7));
            r6.put("setting_time", String.valueOf(r15.getDuration()));
            if (r5 == null) goto L22;
            r6.put("to_guest_id", r5);
        L22:
            String r8 = "blue";
            if (r4 != 1) goto L25;
            Object r9 = "blue";
        L26:
            r6.put("to_guest_side", r9);
            if (r4 != 1) goto L29;
            r8 = "red";
        L29:
            r6.put("to_guest_newside", r8);
            r6.put("user_type", r3);
            li0.b.k(r6);
            TalkRoomLogUtils.B0(r6, null, null, 6);
            li0.b.j(r0, r6, r15, false, 4);
            j0.l().sendLog("livesdk_grouppk_microset_click", r6, new Object[]{IRoom.class});
            goto L30
        L25:
            r9 = "red";
        L30:
            com.bytedance.android.live.core.utils.f2.c(s1.B(2131922780), 0);
            return;
        L12:
            r15 = null;
            goto L13
        L6:
            if (hd0.c.f().h() == false) goto L8;
            r3 = "guest";
            goto L9
        L8:
            r3 = "user";
            goto L9
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            if (r3 == null) goto L5;
            String r4 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r3);
        L6:
            com.bytedance.android.live.core.utils.f2.c(r4, 0);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    static {
    }

    @Override // xh0.b
    public final ArrayList<xh0.f> getIncompatibleSourceList() {
        IncompatibleTag r2 = IncompatibleTag.PLAY_MODE;
        return CollectionsKt.arrayListOf(new xh0.f[]{new xh0.f(r2, 5), new xh0.f(r2, 16, ""), new xh0.f(r2, 11, ""), new xh0.f(r2, 17, ""), new xh0.f(r2, 6, ""), new xh0.f(r2, 29, ""), new xh0.f(IncompatibleTag.SCENE, 9, s1.C(2131922801, new Object[]{s1.B(2131918515)}))});
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final void n5(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
    }

    public final boolean wq(int r3) {
        if (r3 != 1) goto L5;
        return true;
    L5:
        if (r3 != 2) goto L7;
        return true;
    L7:
        if (r3 == 3) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final boolean Rh() {
        com.bytedance.android.live.liveinteract.multiscene.a r0 = this.e;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getFightStatus());
    L6:
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.intValue() != 3) goto L11;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final boolean ck() {
        com.bytedance.android.live.liveinteract.multiscene.a r0 = this.e;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getFightStatus());
    L6:
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.intValue() != 2) goto L11;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final String g3() {
        li0.b r0 = li0.b.b;
        return li0.b.b();
    }

    @Override // xh0.b
    public final xh0.h getPlayModeInfo() {
        return new xh0.h(7, s1.B(2131922767));
    }

    public final IRoom getRoom() {
        return a0.n(((Widget) this).dataCenter);
    }

    public final boolean isAnchor() {
        return a0.d(((Widget) this).dataCenter, false);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final boolean isTeamFightShowing() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        ih0.b r1 = r0.dynamicService(((Widget) this).dataCenter);
        if (r1 == null) goto L9;
        if (r1.jl("team_fight") != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final TeamFightContext o3() {
        TeamFightContext r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("teamFightContext");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final xh0.g rl() {
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r0 = MultiRevenueDataContext.a.d();
        if (r0 == null) goto L7;
        xh0.g r1 = r0.a(7, null);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new xh0.g(IncompatibleTag.DEFAULT, -1, true, null, 24);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final boolean z3() {
        com.bytedance.android.live.liveinteract.multiscene.a r0 = this.e;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getFightStatus());
    L6:
        if (r1 != null) goto L9;
    L10:
        if (r1 != null) goto L13;
    L15:
        return false;
    L13:
        if (r1.intValue() != 3) goto L15;
    L16:
        return true;
    L9:
        if (r1.intValue() == 2) goto L16;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final boolean zh() {
        com.bytedance.android.live.liveinteract.multiscene.a r0 = this.e;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getFightStatus());
    L6:
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.intValue() != 1) goto L11;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final li0.b.a g4() {
        long r0 = System.currentTimeMillis();
        long r2 = this.i;
        long r1 = r0 - r2;
        long r4 = 0;
        if (r1 > 0) goto L5;
    L7:
        li0.b r3 = li0.b.b;
        TeamFightContext r5 = this.a;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("teamFightContext");
    L11:
        return new li0.b.a(r4, li0.b.c(((Number) r5.getFightStatus().getValue()).intValue()));
    L5:
        if (r2 <= 0) goto L7;
        r4 = 0 + (r1 / ((long) 1000));
        goto L7
    }

    @Override // xh0.b
    public final boolean isOpen() {
        return isTeamFightShowing();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.b = r0;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
    L5:
        int r1 = com.bytedance.android.live.liveinteract.multiscene.i.a;
        Pair r2 = com.bytedance.live.datacontext.d.a(DynamicTeamFightWidget$initDataContext$pair$1.INSTANCE);
        TeamFightContext r3 = (TeamFightContext) r2.getFirst();
        r3.getWidget().d(this);
        r3.setDynamic(true);
        com.bytedance.live.datacontext.b.a(r3, com.bytedance.android.live.liveinteract.revenue.fight.a.class);
        this.c.add((Disposable) r2.getSecond());
        this.a = r3;
        this.f = new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d(this, ((Widget) this).context, ((Widget) this).dataCenter);
        IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r4 == null) goto L10;
        ih0.b r5 = r4.dynamicService(((Widget) this).dataCenter);
        if (r5 == null) goto L10;
        r5.E6("team_fight", new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.c(this));
    L10:
        ne0.e r6 = getStore().d(d0.b, new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.d(this));
        r6.d(mi0.a.b, new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.e(this));
        r6.d(mi0.g.b, new f(this));
        r6.d(mi0.c.b, new g(this));
        r6.d(mi0.e.b, new h(this));
        r6.d(mi0.f.b, new i(this));
        if (this.l != SceneType.SCENE_AUDIO_TALKROOM) goto L13;
        getStore().d(sh0.k.b, new j(this)).d(sh0.m.b, new k(this));
    L13:
        Disposable r7 = xs2.b.a().b(jd0.l.class).subscribe(l.a);
        this.c.add(r7);
        Disposable r8 = ((ObservableSubscribeProxy) jc1.k.n(IBaseBrowserService.class).registerJsEventSubscriber("livesdk_teamfight_data_update").observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(b.a);
        this.c.add(r8);
        Disposable r9 = jc1.k.n(IMiddlewareUserService.class).user().u().observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        this.c.add(r9);
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        ih0.b r1 = r0.dynamicService(((Widget) this).dataCenter);
        if (r1 == null) goto L7;
        r1.jc("team_fight");
    L7:
        ((Widget) this).dataCenter.removeObserver(this);
        vlc.d r2 = this.b;
        if (r2 == null) goto L11;
        r2.removeMessageListener(this);
    L11:
        if (z3() == false) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
    L22:
        this.c.dispose();
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d r4 = this.f;
        if (r4 == null) goto L29;
        DynamicTeamFightViewManager r5 = r4.a;
        if (r5 == null) goto L27;
        r5.b("onDestroy");
        r5.k.dispose();
        r5.e.b();
    L27:
        r4.a = null;
        return;
    L29:
        return;
    L19:
        if (isAnchor() == true) goto L21;
        li0.b.b.f();
        goto L22
    L21:
        li0.b r6 = li0.b.b;
        isAnchor();
        li0.b.e(this.h);
        goto L22
    L13:
        if (zh() == true) goto L16;
        r3 = false;
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final com.bytedance.android.live.liveinteract.multiscene.a X2() {
        return this.e;
    }

    public DynamicTeamFightWidget(SceneType r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        this.l = r2;
        this.c = new CompositeDisposable();
        this.d = "";
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final void Cm(int r4) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("room_id", Long.valueOf(getRoom().getId()));
        r0.addProperty("duration", Integer.valueOf(r4));
        TeamFightContext r5 = TeamFightContext.Companion.getContext();
        if (r5 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r6 = r5.getRequestPage();
        if (r6 == null) goto L8;
        String r7 = (String) r6.getValue();
        if (r7 == null) goto L8;
    L9:
        r0.addProperty("request_page", r7);
        xq("playmode_request_api_start", r0);
        return;
    L8:
        r7 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final void d3(String r11) {
        Intrinsics.checkNotNullParameter(r11, "requestPage");
        this.d = r11;
        String r2 = null;
        if (isTeamFightShowing() == false) goto L16;
        int r1 = li0.c.a;
        Context r3 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r11, "requestPage");
        ReadOnlyProperty r0 = vm2.d.F7;
        KProperty[] r6 = vm2.d.a;
        String r8 = ((zh1) r0.getValue(null, r6[444(0x1bc, float:6.22E-43)])).a();
        if (r8 != null) goto L7;
        r8 = "sslocal://webcast_lynxview?type=popup&gravity=bottom&rate_height=271&hide_loading=0&show_error=1&radius=20/";
    L7:
        u6 r9 = new u6(r8);
        String r4 = ((zh1) r0.getValue(null, r6[444(0x1bc, float:6.22E-43)])).b();
        if (r4 != null) goto L10;
        r4 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/team_fight_douyin/pages/team_fight_manager/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L10:
        r9.b("url", r4);
        u6 r5 = r9.d("url");
        com.bytedance.android.live.liveinteract.revenue.fight.c r7 = TeamFightContext.Companion.c();
        if (r7 == null) goto L15;
        com.bytedance.android.live.liveinteract.multiscene.a r10 = r7.X2();
        if (r10 == null) goto L15;
        r2 = String.valueOf(r10.getFightStatus());
    L15:
        r5.b("teamfight_status", r2);
        r5.b("duration", String.valueOf(((Number) com.bytedance.android.livesdk.sharedpref.c.Z0.getValue()).intValue()));
        r5.b("request_page", r11);
        li0.c.d(r5);
        jc1.k.n(IBaseLiveActionHandler.class).handle(r3, r9.c());
        return;
    L16:
        int r12 = li0.c.a;
        Context r13 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r11, "requestPage");
        ReadOnlyProperty r14 = vm2.d.E7;
        KProperty[] r15 = vm2.d.a;
        String r16 = ((zh1) r14.getValue(null, r15[443(0x1bb, float:6.21E-43)])).a();
        if (r16 != null) goto L19;
        r16 = "sslocal://webcast_lynxview?mask_alpha=0.5&type=popup&gravity=bottom&hide_loading=0&show_error=1&radius=12&height_percent=65";
    L19:
        u6 r17 = new u6(r16);
        String r18 = ((zh1) r14.getValue(null, r15[443(0x1bb, float:6.21E-43)])).b();
        if (r18 != null) goto L22;
        r18 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/team_fight_douyin/pages/team_fight_open_panel/template.js?business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
    L22:
        r17.b("url", r18);
        u6 r19 = r17.d("url");
        r19.b("win_crown_icon", li0.c.c());
        if (com.bytedance.android.live.liveinteract.revenue.common.b.a(2) == null) goto L27;
        String r20 = com.bytedance.android.live.liveinteract.revenue.common.b.a(2);
        if (r20 != null) goto L28;
        r20 = "";
    L28:
        r19.b("loser_crown_icon", r20);
        r19.b("duration", String.valueOf(((Number) com.bytedance.android.livesdk.sharedpref.c.Z0.getValue()).intValue()));
        r19.b("request_page", r11);
        li0.c.d(r19);
        jc1.k.n(IBaseLiveActionHandler.class).handle(r13, r17.c());
        return;
    L27:
        r20 = "https://p3-webcast.douyinpic.com/img/webcast/790cc1846778234a9e87c38bc38be527.png~tplv-obj.image";
        goto L28
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final void d6(JsonObject r3) {
        TeamFightContext r0 = TeamFightContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<String> r1 = r0.getRequestPage();
        if (r1 == null) goto L7;
        r1.setValue(this.d);
    L7:
        r3.addProperty("request_page", this.d);
        xq("playmode_manage_result", r3);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final JsonObject e2(JsonObject r4) {
        JsonObject r5 = new JsonObject();
        JsonObject r0 = new JsonObject();
        r0.addProperty("duration", (Number) com.bytedance.android.livesdk.sharedpref.c.Z0.getValue());
        com.bytedance.android.live.liveinteract.multiscene.a r1 = this.e;
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getTeamBattleType());
    L6:
        r0.addProperty("team_battle_type", r2);
        Gson r3 = com.bytedance.android.annie.api.data.subscribe.d.a;
        r0.add("teamfight_info", com.bytedance.android.annie.api.data.subscribe.d.b(this.e));
        r5.add("team_fight", r0);
        return r5;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, xh0.b
    public final xh0.g isCanOpen(HashMap<String, Object> r11) {
        if (this.l != SceneType.SCENE_VIDEO_TALKROOM) goto L5;
        boolean r0 = com.bytedance.android.livesdk.sharedpref.d.b();
    L6:
        if (r0 == false) goto L8;
        com.bytedance.android.live.profit.vote.e r1 = yt0.c.m();
        if (r1 == null) goto L16;
        if (r1.fi() != true) goto L16;
        return new xh0.g(IncompatibleTag.PLAY_MODE, getPlayModeKey(), false, "giftVote", s1.C(2131922801, new Object[]{s1.B(2131918883)}));
    L16:
        if (getRoom().isLiveTypeAudio() == true) goto L22;
        if (jc1.k.n(IKtvService.class).currentIsMultipleKtvMode() == false) goto L22;
        IncompatibleTag r5 = IncompatibleTag.PLAY_MODE;
        return new xh0.g(r5, 10, false, r5 + "_10", s1.C(2131922801, new Object[]{s1.B(2131923106)}));
    L22:
        return super.isCanOpen(r11);
    L8:
        return new xh0.g(IncompatibleTag.PLAY_MODE, getPlayModeKey(), false, "fail_no_gift", s1.B(2131922789));
    L5:
        r0 = com.bytedance.android.livesdk.sharedpref.d.a();
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }

    public final void onMessage(tlc.d r14) {
        if ((r14 instanceof ILinkMicGuideMessageBridge) == false) goto L23;
        ILinkMicGuideMessageBridge r15 = (ILinkMicGuideMessageBridge) r14;
        if (r15.getGuidelineType() == 8) goto L7;
        return;
    L7:
        if (r15.getTeamFightBubbleGuideContent() == null) goto L25;
        xb r16 = r15.getTeamFightBubbleGuideContent();
        if (r16 == null) goto L11;
        a5 r17 = r16.getText();
    L13:
        if (r17 == null) goto L17;
        String r0 = r17.getDefaultPattern();
        if (r0 == null) goto L17;
    L18:
        pp1.c r12 = new pp1.c(r0, null, null, 0, null, null, 1001, 0, MapsKt.mapOf(TuplesKt.to("message_type", "grouppk")), 0, 7870);
        if (getRoom().isLiveTypeAudio() == true) goto L26;
        ALogger.w("DynamicTeamFightWidget", "onGuideBubbleShow " + r17 + ' ' + r12);
        ((Widget) this).dataCenter.put("cmd_show_self_bubble_on_openplatform_behavior", r12);
        return;
    L26:
        return;
    L17:
        r0 = s1.B(2131922778);
        goto L18
    L11:
        r17 = null;
        goto L13
    L25:
        return;
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r12) {
        Integer r0 = (Integer) r12.get("option");
        Long r1 = (Long) r12.get("duration");
        String r2 = (String) r12.get("reqFrom");
        String r13 = (String) r12.get("select_uid_list_str");
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        String r10 = r13;
        if (r0 == null) goto L46;
        if (r1 == null) goto L47;
        if (r2 == null) goto L49;
        int r8 = r0.intValue();
        long r6 = r1.longValue();
        ALogger.i("DynamicTeamFightWidget", "TeamFight.Request.Create.Send.create team fight option=" + r8 + " duration=" + r6);
        boolean r14 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        if (this.j == false) goto L13;
        return;
    L13:
        if (isAnchor() == true) goto L16;
        if (r14 == true) goto L16;
        return;
    L16:
        this.j = true;
        o r3 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r3 == null) goto L25;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L25;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L25;
        if (r5.isLiveTypeAudio() != true) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == true) goto L42;
        o r9 = com.bytedance.android.live.liveinteract.api.utils.m.j(this);
        if (r9 == null) goto L43;
        com.bytedance.live.datacontext.j r11 = r9.getVideoTalkRoomSubScene();
        if (r11 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r15 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r11.getValue();
        if (r15 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r16 = r15.t();
        if (r16 == null) goto L43;
        if (r16.c != 4) goto L39;
        boolean r17 = true;
    L40:
        if (r17 == true) goto L42;
    L39:
        r17 = false;
    L43:
        boolean r18 = true;
    L44:
        long r19 = System.currentTimeMillis();
        JsonObject r110 = new JsonObject();
        r110.addProperty("type", "will_create");
        yq(r110, r19, null);
        ALogger.d("DynamicTeamFightWidget", "sendWillCreateToMainLynx updateInfo=" + r110);
        xq("playmode_manage_result", r110);
        this.c.add(((LinkProfitApi) com.bytedance.android.live.network.c.b().e(LinkProfitApi.class)).createTeamFight(getRoom().getId(), r6, r8, r18, r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.a(this, r19), new com.bytedance.android.live.liveinteract.revenue.fight.dynamic.b(this, r19)));
        return;
    L42:
        r18 = false;
    L25:
        r7 = false;
        goto L26
    L49:
        return;
    L47:
        return;
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r5) {
        Integer r6 = (Integer) r5.get("reason");
        if (r6 == null) goto L16;
        int r7 = r6.intValue();
        ALogger.w("DynamicTeamFightWidget", "try finish team fight reason=" + r7);
        if (isTeamFightShowing() == true) goto L7;
        ALogger.e("DynamicTeamFightWidget", "team fight already finished");
        return;
    L7:
        JsonObject r1 = new JsonObject();
        r1.addProperty("reason", Integer.valueOf(r7));
        r1.addProperty("room_id", Long.valueOf(getRoom().getId()));
        TeamFightContext r8 = TeamFightContext.Companion.getContext();
        if (r8 == null) goto L13;
        com.bytedance.live.datacontext.m<String> r9 = r8.getRequestPage();
        if (r9 == null) goto L13;
        String r10 = (String) r9.getValue();
        if (r10 == null) goto L13;
    L14:
        r1.addProperty("request_page", r10);
        xq("playmode_request_api_end", r1);
        return;
    L13:
        r10 = "";
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final void F1(Object r4, SceneType r5) {
        Intrinsics.checkNotNullParameter(r4, "layer");
        Intrinsics.checkNotNullParameter(r5, "sceneType");
        if (isTeamFightShowing() == true) goto L5;
        return;
    L5:
        if (li0.d.g(this.e) == true) goto L62;
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d r2 = this.f;
        if (r2 == null) goto L63;
        Intrinsics.checkNotNullParameter(r4, "layer");
        Intrinsics.checkNotNullParameter(r5, "sceneType");
        if ((r4 instanceof MultiLinkAudioCommonGuestMicSeatBasicLayer) == false) goto L23;
        LinkMicQuickInteractView r6 = (LinkMicQuickInteractView) ((MultiLinkAudioCommonGuestMicSeatBasicLayer) r4).m(2131389576);
        ViewGroup.LayoutParams r7 = null;
        if (r6 == null) goto L13;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
    L15:
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L18;
        r7 = r0;
    L18:
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r7;
        if (r8 == null) goto L64;
        r8.bottomToTop = 2131389587;
        r8.topToBottom = -1;
        if (r6 == null) goto L65;
        r6.setLayoutParams(r8);
        return;
    L65:
        return;
    L64:
        return;
    L13:
        r0 = null;
        goto L15
    L23:
        int r1 = 0;
        if ((r4 instanceof MultiLinkAudioCommonEmptyMicSeatBasicLayer) == false) goto L43;
        if (gh0.a.d() == false) goto L67;
        MultiLinkAudioCommonEmptyMicSeatBasicLayer r9 = (MultiLinkAudioCommonEmptyMicSeatBasicLayer) r4;
        TextView r10 = (TextView) r9.m(2131389540);
        if (r10 != null) goto L30;
        return;
    L30:
        if (r2.a == null) goto L40;
        MultiLinkNormalEmptyViewBinder.a r11 = r9.e;
        if (r11 == null) goto L34;
        int r12 = r11.a;
    L35:
        int r3 = DynamicTeamFightViewManager.s;
        if (((r12 - 1) % 4) >= 2) goto L38;
        r1 = 1;
    L38:
        if (r1 != 1) goto L40;
        String r13 = "红队";
    L41:
        r10.setText(r13);
        return;
    L34:
        r12 = 0;
    L40:
        r13 = "蓝队";
        goto L41
    L67:
        return;
    L43:
        if ((r4 instanceof MultiLinkCommonGuestMicSeatBasicLayer) == false) goto L51;
        MultiLinkCommonGuestMicSeatBasicLayer r14 = (MultiLinkCommonGuestMicSeatBasicLayer) r4;
        MultiLinkGuestViewBinder.a r15 = r14.e;
        if (r15 == null) goto L48;
        r1 = r15.a;
    L48:
        if (r2.a == null) goto L70;
        DynamicTeamFightViewManager.f(r14, r1);
        return;
    L70:
        return;
    L51:
        if ((r4 instanceof MultiLinkCommonEmptyMicSeatBasicLayer) == false) goto L56;
        if (r2.a == null) goto L72;
        DynamicTeamFightViewManager.e((MultiLinkCommonEmptyMicSeatBasicLayer) r4);
        return;
    L72:
        return;
    L56:
        if ((r4 instanceof pg0.b) == true) goto L58;
        return;
    L58:
        if (r2.a == null) goto L75;
        DynamicTeamFightViewManager.g((pg0.b) r4);
        return;
    L75:
        return;
    L63:
        return;
    }

    public final void xq(String r4, JsonObject r5) {
        ih0.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r0 == null) goto L6;
        r0.Dk("team_fight", r4, r5, false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final xh0.g M5(long r7, String r9, List r10) {
        Intrinsics.checkNotNullParameter(r9, "reqFrom");
        HashMap<String, Object> r1 = new HashMap();
        r1.put("option", 0);
        r1.put("duration", Long.valueOf(r7));
        r1.put("reqFrom", r9);
        if (r10 == null) goto L11;
        StringBuilder r8 = new StringBuilder();
        Iterator r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r8.append(((String) r11.next()) + ',');
        goto L6
    L8:
        String r12 = r8.toString();
        if (StringsKt.endsWith$default(r12, ",", false, 2, null) == false) goto L12;
        r12 = r12.substring(0, r12.length() - 1);
    L12:
        r1.put("select_uid_list_str", r12);
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r13 = MultiRevenueDataContext.a.d();
        if (r13 == null) goto L17;
        xh0.g r14 = r13.h(7, r1);
        if (r14 == null) goto L17;
        return r14;
    L17:
        return new xh0.g(IncompatibleTag.DEFAULT, -1, true, null, 24);
    L11:
        r12 = "";
        goto L12
    }

    public final void yq(JsonObject r4, long r5, String r7) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("request_page", this.d);
        r0.addProperty("request_timestamp", Long.valueOf(r5));
        r0.addProperty("option", 0);
        if (r7 == null) goto L5;
        r0.addProperty("log_id", r7);
    L5:
        r4.add("extra", r0);
        r4.add("config", new JsonObject());
        r4.addProperty("request_page", this.d);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.c
    public final void e5(int r16, int r17, long r18, String r20) {
        if (r20 != null) goto L5;
        String r11 = "";
    L6:
        com.bytedance.android.live.liveinteract.multiscene.a r2 = this.e;
        if (r2 == null) goto L14;
        String r3 = r2.getTeamFightIdStr();
        if (r3 == null) goto L11;
        long r4 = CastLongProtector.parseLong(r3);
    L12:
        long r6 = r4;
        Disposable r1 = ((LinkProfitApi) com.bytedance.android.live.network.c.b().e(LinkProfitApi.class)).updateTeamFightPlayerTeam(getRoom().getId(), r6, r16, d5.c(r11), r11, r18, r17).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r17, r20), e.a);
        this.c.add(r1);
        return;
    L11:
        r4 = 0;
        goto L12
    L14:
        return;
    L5:
        r11 = r20;
        goto L6
    }
}
