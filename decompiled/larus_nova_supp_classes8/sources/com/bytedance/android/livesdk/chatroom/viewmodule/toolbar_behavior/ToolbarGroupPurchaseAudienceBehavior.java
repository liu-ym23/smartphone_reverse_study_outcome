package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.livead.GroupPurchaseItem;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeAnchorView;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeFragmentDelegate;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.su0;
import com.bytedance.android.livesdk.config.tu0;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomLifeGrouponInfo;
import com.bytedance.android.livesdkapi.room.handler.enterroom.EnterKey;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomScene;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessInject;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonSyntaxException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarGroupPurchaseAudienceBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdkapi/room/handler/enterroom/ILivePreviewBusinessInject;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarGroupPurchaseAudienceBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Observer<KVData>, ILivePreviewBusinessInject {
    public static final /* synthetic */ int p = 0;
    public DataCenter a;
    public RoomContext b;
    public Room c;
    public GroupPurchaseItem d;
    public final JSONObject e;
    public View f;
    public ILiveLocalLifeAnchorView g;
    public boolean h;
    public ILivePreviewBusinessBridge i;
    public d j;
    public final Lazy k;
    public ILiveLocalLifeFragmentDelegate l;
    public DialogFragment m;
    public final b n;
    public final Context o;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.viewmodel.c {
        public final /* synthetic */ ToolbarGroupPurchaseAudienceBehavior a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final ToolbarButton c() {
            return ToolbarButton.GROUP_PURCHASE_AUDIENCE;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
            return com.bytedance.android.livesdk.chatroom.viewmodel.a.d.b;
        }

        public b(ToolbarGroupPurchaseAudienceBehavior r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean a(long r4) {
            ALogger.i("AnimationCenterScheduler", "start group purchase");
            ToolbarGroupPurchaseAudienceBehavior r0 = this.a;
            int r1 = ToolbarGroupPurchaseAudienceBehavior.p;
            IHostLiveLocalLife r2 = r0.d();
            if (r2 == null) goto L10;
            DataCenter r3 = this.a.a;
            if (r3 == null) goto L8;
            String r5 = com.bytedance.android.live.core.utils.z.d(r3, null);
            if (r5 == null) goto L8;
        L12:
            return r2.startIconAnimation(r5, r4);
        L8:
            r5 = "";
            goto L12
        L10:
            return false;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ToolbarGroupPurchaseAudienceBehavior a;

        public c(ToolbarGroupPurchaseAudienceBehavior r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IAnimationScheduler.Companion r0 = IAnimationScheduler.M0;     // Catch: Throwable -> L6
            DataCenter r1 = this.a.a;     // Catch: Throwable -> L6
            r0.getClass();     // Catch: Throwable -> L6
            IAnimationScheduler r2 = IAnimationScheduler.Companion.a(r1);     // Catch: Throwable -> L6
            if (r2 == null) goto L9;
            r2.registerListener(this.a.n);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements ILiveEnterRoomCallback {
        public final /* synthetic */ ToolbarGroupPurchaseAudienceBehavior a;

        public d(ToolbarGroupPurchaseAudienceBehavior r1) {
            this.a = r1;
        }

        public final ILiveEnterRoomParams getEnterParams(ILivePreviewBusinessSession r9) {
            Intrinsics.checkNotNullParameter(r9, "session");
            ILiveEnterRoomParams r10 = ILiveEnterRoomParams.Companion.simple(EnterKey.PreviewLifeIcon.INSTANCE, "local_service");
            Bundle r0 = r10.getBusinessBundle();
            JSONObject r1 = new JSONObject();
            JSONObject r2 = new JSONObject();
            r2.put("from", "icon");
            r2.put("action", "open_shelf");
            JSONObject r3 = new JSONObject();
            JSONObject r4 = new JSONObject();
            Room r5 = this.a.c;
            if (r5 == null) goto L5;
            long r6 = r5.id;
        L6:
            r4.put("room_id", r6);
            Room r7 = this.a.c;
            if (r7 == null) goto L10;
            String r8 = r7.getOwnerUserIdString();
            if (r8 == null) goto L10;
        L11:
            r4.put("anchor_id", r8);
            r4.put("icon_type", "house");
            ToolbarGroupPurchaseAudienceBehavior r11 = this.a;
            GroupPurchaseItem r12 = r11.d;
            String r13 = null;
            if (r12 == null) goto L14;
            String r14 = r12.getOpenUrl();
        L15:
            r4.put("lynx_url", r11.c(r14, null));
            GroupPurchaseItem r15 = this.a.d;
            if (r15 == null) goto L18;
            String r16 = r15.getWebUrl();
        L19:
            r4.put("url", r16);
            GroupPurchaseItem r17 = this.a.d;
            if (r17 == null) goto L22;
            String r18 = r17.getWebTitle();
        L23:
            r4.put(LiveEndPageData.TAG_TITLE, r18);
            r4.put("is_portrait", this.a.g());
            r4.put("is_landscape_room", this.a.f());
            r4.put("enter_from_merge", this.a.e.optString("enter_from_merge"));
            r4.put("action_type", this.a.e.optString("action_type"));
            r4.put("request_id", this.a.e.optString("request_id"));
            r4.put("is_other_channel", this.a.e.optString("is_other_channel"));
            r4.put("enter_method", this.a.e.optString("enter_method"));
            GroupPurchaseItem r19 = this.a.d;
            if (r19 == null) goto L26;
            r13 = r19.getLogExtra();
        L26:
            r4.put("log_extra", r13);
            r4.put("video_id", this.a.e.optString("video_id"));
            r4.put("auto_open_shelf", false);
            Unit r20 = Unit.INSTANCE;
            r3.put("extra", r4);
            r2.put("open_shelf_params", r3);
            r1.put("preview_params", r2);
            r0.putString("locallife_live_params", r1.toString());
            return r10;
        L22:
            r18 = null;
            goto L23
        L18:
            r16 = null;
            goto L19
        L14:
            r14 = null;
        L10:
            r8 = "0";
            goto L11
        L5:
            r6 = 0;
            goto L6
        }

        public final void onBeforeEnterRoom(ILivePreviewBusinessSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
            ILiveEnterRoomCallback.DefaultImpls.onBeforeEnterRoom(this, r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    public final IHostLiveLocalLife d() {
        return (IHostLiveLocalLife) this.k.getValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final boolean f() {
        Room r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isStar() == false) goto L7;
    L11:
        boolean r1 = false;
    L12:
        if (r1 != true) goto L16;
        return true;
    L16:
        return false;
    L7:
        if (r0.isThirdParty() == false) goto L9;
    L10:
        r1 = true;
        goto L12
    L9:
        if (r0.isScreenshot() == false) goto L11;
        goto L10
    }

    public final boolean g() {
        DataCenter r0 = this.a;
        if (r0 == null) goto L5;
        Boolean r1 = (Boolean) r0.get("data_is_portrait", Boolean.TRUE);
    L7:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L7
    }

    public final void h() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("program_type", "little_windmill");
        r0.put("source", "bottom_toolbar");
        j(r0, new String[]{"enter_from_merge", "enter_method"});
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_small_program_audience_icon_show", r0, new Object[]{Room.class});
    }

    public ToolbarGroupPurchaseAudienceBehavior(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.o = r2;
        this.e = new JSONObject();
        this.k = LazyKt.lazy(ToolbarGroupPurchaseAudienceBehavior$liveLocalLifeService$2.INSTANCE);
        this.n = new b(this);
    }

    public static final void b(ToolbarGroupPurchaseAudienceBehavior r2) {
        r2.getClass();
        Activity r3 = com.bytedance.android.live.core.utils.a.d();
        if ((r3 instanceof FragmentActivity) == false) goto L11;
        String r0 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.b();
        if (TextUtils.isEmpty(r0) == true) goto L7;
        IHostLiveLocalLife r1 = jc1.k.n(IHostLiveLocalLife.class);
        Intrinsics.checkNotNull(r0);
        r1.openUrlByBullet(r3, r0);
        return;
    L7:
        Uri r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.d.a();
        if (r4 == null) goto L13;
        IBaseBrowserService.b.a(jc1.k.n(IBrowserService.class), r3, r4);
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r9) {
        if (r9 == null) goto L8;
        String r10 = r9.d;
        if (r10 == null) goto L8;
        String r7 = r10;
    L9:
        Room r11 = this.c;
        if (r11 == null) goto L12;
        long r1 = r11.getRoomId();
    L13:
        long r3 = r1;
        IHostLiveLocalLife r2 = d();
        if (r2 == null) goto L24;
        d3 r5 = new d3(this);
        DataCenter r12 = this.a;
        if (r12 == null) goto L21;
        String r13 = com.bytedance.android.live.core.utils.z.d(r12, null);
        if (r13 == null) goto L21;
        String r6 = r13;
    L22:
        r2.getLifeComponentInfo("push", r3, r5, r6, r7);
        return;
    L21:
        r6 = "";
        goto L22
    L24:
        return;
    L12:
        r1 = 0;
    L8:
        r7 = "";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r4) {
        Object r0 = null;
        if (r4 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.f0 r1 = r4.l;
        if (r1 == null) goto L7;
        Object r2 = r1.c;
    L9:
        if ((r2 instanceof GroupPurchaseItem) == false) goto L12;
        r0 = r2;
    L12:
        this.d = (GroupPurchaseItem) r0;
        if (this.h == false) goto L15;
        return;
    L15:
        if (r4 == null) goto L19;
        boolean r3 = true;
        if (r4.l.b != true) goto L19;
    L20:
        e(r3);
        h();
        return;
    L19:
        r3 = false;
    L7:
        r2 = null;
        goto L9
    }

    public final void e(boolean r19) {
        DataCenter r0 = this.a;
        Boolean r2 = null;
        if (r0 == null) goto L5;
        Boolean r1 = (Boolean) r0.get("has_group_purchase_icon_show", Boolean.FALSE);
    L6:
        Intrinsics.areEqual(r1, Boolean.TRUE);
        ILiveLocalLifeAnchorView r3 = this.g;
        String r6 = "";
        if (r3 != null) goto L57;
        Bundle r4 = new Bundle();
        GroupPurchaseItem r7 = this.d;
        if (r7 == null) goto L15;
        UrlModel r8 = r7.getDynamicIconUrl();
        if (r8 == null) goto L15;
        List r9 = r8.getUrlList();
        if (r9 == null) goto L15;
        r4.putStringArrayList("url_list", new ArrayList(r9));
    L15:
        GroupPurchaseItem r10 = this.d;
        if (r10 == null) goto L18;
        String r11 = r10.getLogExtra();
    L19:
        r4.putString("log_extra", r11);
        this.e.putOpt("value", "null");
        r4.putString("mob_params", this.e.toString());
        r4.putBoolean("is_portrait", g());
        r4.putBoolean("is_landscape_room", f());
        r4.putBoolean("icon_shown", false);
        ILivePreviewBusinessBridge r12 = this.i;
        if (r12 == null) goto L24;
        ILivePreviewBusinessSession r13 = r12.getSession();
        if (r13 == null) goto L24;
        ILiveEnterRoomScene r14 = r13.getScene();
    L25:
        r4.putBoolean("is_preview", Intrinsics.areEqual(r14, ILiveEnterRoomScene.PreviewToolbar.INSTANCE));
        IHostLiveLocalLife r15 = d();
        if (r15 == null) goto L42;
        Context r16 = this.o;
        DataCenter r17 = this.a;
        if (r17 == null) goto L31;
        String r18 = com.bytedance.android.live.core.utils.z.d(r17, null);
        if (r18 == null) goto L31;
    L32:
        ILiveLocalLifeAnchorView r5 = r15.getGroupPurchaseAnchorView(r16, r4, r18, this.i);
        if (r5 == null) goto L42;
        View r20 = r5.getView();
        View r21 = this.f;
        if (r21 == null) goto L41;
        ((ViewGroup) r21).addView(r20);
        if (ht2.g.f(this.c, 7, true) == false) goto L39;
        r20.setAlpha(0.0f);
        ht2.g.c(7, this.c, this.f);
    L39:
        Unit r22 = Unit.INSTANCE;
    L43:
        this.g = r5;
        boolean r23 = r5 instanceof ILiveLocalLifeAnchorView;
        if (r23 == false) goto L49;
        if (r23 == true) goto L47;
        r5 = null;
    L47:
        if (r5 == null) goto L49;
        r5.addOnClickListener(new e3(this));
    L49:
        IHostLiveLocalLife r24 = d();
        if (r24 == null) goto L67;
        DataCenter r25 = this.a;
        if (r25 == null) goto L55;
        String r26 = com.bytedance.android.live.core.utils.z.d(r25, null);
        if (r26 == null) goto L55;
    L56:
        r24.setLifeCartShown(r26);
    L55:
        r26 = "";
    L67:
        if (r19 == true) goto L185;
        ILiveLocalLifeAnchorView r27 = this.g;
        if ((r27 instanceof ILiveLocalLifeAnchorView) == true) goto L71;
        r27 = null;
    L71:
        if (r27 == null) goto L73;
        View r28 = r27.getView();
    L74:
        if (r28 != null) goto L76;
    L82:
        String r29 = null;
    L83:
        IHostLiveLocalLife r30 = d();
        if (r30 == null) goto L92;
        DataCenter r31 = this.a;
        if (r31 == null) goto L89;
        String r32 = com.bytedance.android.live.core.utils.z.d(r31, null);
        if (r32 == null) goto L89;
    L91:
        if (r30.handleEnterAction(r32, this.o, r29) == true) goto L185;
    L89:
        r32 = "";
    L92:
        int r33 = com.bytedance.android.livesdk.locallife.h.a;
        DataCenter r34 = this.a;
        if (r34 == null) goto L98;
        String r35 = com.bytedance.android.live.core.utils.z.d(r34, null);
        if (r35 == null) goto L98;
        String r36 = r35;
    L99:
        DataCenter r37 = this.a;
        if (r37 == null) goto L102;
        String r110 = (String) r37.get("data_enter_locallife_live_params", "");
    L103:
        ToolbarGroupPurchaseAudienceBehavior$initAnchorView$2 r111 = new ToolbarGroupPurchaseAudienceBehavior$initAnchorView$2(this);
        ToolbarGroupPurchaseAudienceBehavior$initAnchorView$3 r112 = new ToolbarGroupPurchaseAudienceBehavior$initAnchorView$3(this);
        ToolbarGroupPurchaseAudienceBehavior$initAnchorView$4 r113 = new ToolbarGroupPurchaseAudienceBehavior$initAnchorView$4(this);
        ToolbarGroupPurchaseAudienceBehavior$initAnchorView$5 r114 = new ToolbarGroupPurchaseAudienceBehavior$initAnchorView$5(this);
        Intrinsics.checkNotNullParameter(r36, "uniqueKey");
        if (r110 != null) goto L106;
    L109:
        boolean r38 = true;
    L110:
        if (r38 == false) goto L220;
    L181:
        DataCenter r39 = this.a;
        if (r39 == null) goto L185;
        r39.put("data_enter_locallife_live_params", null);
        goto L185
    L220:
        yl2.b r40 = (yl2.b) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r110, yl2.b.class);     // Catch: JsonSyntaxException -> L114
    L116:
        IHostLiveLocalLife r41 = jc1.k.f(IHostLiveLocalLife.class);
        if (r41 == null) goto L120;
        r41.addDebugData(r36, "老进房", "enter_action", null, r110);
    L120:
        if (r40 == null) goto L122;
        yl2.g r42 = r40.e();
    L123:
        if (r42 == null) goto L133;
        String r43 = r40.e().a();
        if (r43 != null) goto L127;
    L130:
        boolean r44 = true;
    L131:
        if (r44 == true) goto L133;
        Unit r45 = (Unit) r111.invoke(r40.e().a());
        goto L181
    L127:
        if (r43.length() == 0) goto L130;
        r44 = false;
    L133:
        if (r40 == null) goto L135;
        Boolean r46 = r40.g();
    L136:
        Boolean r47 = Boolean.TRUE;
        if (Intrinsics.areEqual(r46, r47) == false) goto L162;
        yl2.c r48 = r40.a();
        if (r48 == null) goto L141;
        String r49 = r48.a();
    L142:
        yl2.d r50 = r40.b();
        if (r50 == null) goto L145;
        String r51 = r50.a();
    L146:
        Unit r52 = (Unit) r112.invoke(r47, r49, r51);
        yl2.d r53 = r40.b();
        if (r53 == null) goto L149;
        yl2.g r54 = r53.b();
    L150:
        if (r54 == null) goto L154;
        int r55 = com.bytedance.android.livesdk.live.a.a;
        if (com.bytedance.android.livesdk.live.a.c(r40.b().b().a()) == false) goto L154;
        Unit r56 = (Unit) r111.invoke(r40.b().b().a());
    L154:
        yl2.d r57 = r40.b();
        if (r57 == null) goto L157;
        yl2.h r58 = r57.c();
    L158:
        if (r58 == null) goto L181;
        int r59 = com.bytedance.android.livesdk.live.a.a;
        if (com.bytedance.android.livesdk.live.a.c(r40.b().c().a()) == false) goto L181;
        Unit r60 = (Unit) r114.invoke(r40.b().c().a(), r40.b().c().d(), r40.b().c().c(), r40.b().c().b());
        goto L181
    L157:
        r58 = null;
        goto L158
    L149:
        r54 = null;
        goto L150
    L145:
        r51 = null;
        goto L146
    L141:
        r49 = null;
        goto L142
    L162:
        if (r40 == null) goto L164;
        Boolean r61 = r40.d();
    L166:
        if (Intrinsics.areEqual(r61, r47) == false) goto L168;
        Unit r62 = (Unit) r113.invoke();
        goto L181
    L168:
        if (r40 == null) goto L170;
        yl2.h r63 = r40.f();
    L171:
        if (r63 == null) goto L181;
        String r64 = r40.f().a();
        if (r64 != null) goto L175;
    L178:
        boolean r115 = true;
    L179:
        if (r115 == true) goto L181;
        Unit r65 = (Unit) r114.invoke(r40.f().a(), r40.f().d(), r40.f().c(), r40.f().b());
        goto L181
    L175:
        if (r64.length() == 0) goto L178;
        r115 = false;
        goto L179
    L170:
        r63 = null;
        goto L171
    L164:
        r61 = null;
        goto L166
    L135:
        r46 = null;
        goto L136
    L122:
        r42 = null;
    L114:
        e = move-exception;
        e.printStackTrace();
        r40 = null;
        goto L116
    L106:
        if (r110.length() == 0) goto L109;
        r38 = false;
        goto L110
    L102:
        r110 = null;
    L98:
        r36 = "";
        goto L99
    L76:
        if (d() == null) goto L82;
        IHostLiveLocalLife r66 = d();
        Intrinsics.checkNotNull(r66);
        Pair[] r67 = new Pair[2];
        r67[0] = TuplesKt.to("life_req_id", this.e.optString("request_id"));
        Room r68 = this.c;
        if (r68 == null) goto L80;
        long r69 = r68.id;
    L81:
        r67[1] = TuplesKt.to("life_room_id", String.valueOf(r69));
        r29 = r66.createBtmSourceToken(r28, "c565869.d0", MapsKt.mutableMapOf(r67));
        goto L83
    L80:
        r69 = 0;
        goto L81
    L73:
        r28 = null;
    L185:
        if (com.bytedance.android.livesdk.config.setting.x.a() == true) goto L222;
    L198:
        IHostLiveLocalLife r70 = d();
        if (r70 == null) goto L224;
        LinkedHashMap r71 = new LinkedHashMap();
        if (r19 == false) goto L203;
        String r72 = "message";
    L204:
        r71.put("from", r72);
        if (r19 == false) goto L212;
        GroupPurchaseItem r73 = this.d;
        if (r73 == null) goto L218;
        String r75 = r73.toString();
        if (r75 == null) goto L218;
    L211:
        r6 = r75;
    L218:
        r71.put("icon_config", r6);
        Unit r76 = Unit.INSTANCE;
        r70.log("icon_add", r71);
        return;
    L212:
        Room r77 = this.c;
        if (r77 == null) goto L218;
        RoomLifeGrouponInfo r78 = r77.lifeGrouponInfo;
        if (r78 == null) goto L218;
        r75 = com.bytedance.android.livesdk.jsbridge.methods.draft.m.a(r78);
        if (r75 != null) goto L211;
    L203:
        r72 = "enter";
        goto L204
    L224:
        return;
    L222:
        Result.Companion r79 = Result.Companion;     // Catch: Throwable -> L196
        if (su0.a.getValue().booleanValue() == false) goto L190;
        ALogger.i("AnimationCenterScheduler", "register group purchase by delay");     // Catch: Throwable -> L196
        Boolean r80 = Boolean.valueOf(com.bytedance.android.live.core.utils.i0.c().postDelayed(new c(this), tu0.a.getValue().longValue()));     // Catch: Throwable -> L196
    L194:
        Result.constructor-impl(r80);     // Catch: Throwable -> L196
        goto L198
    L190:
        ALogger.i("AnimationCenterScheduler", "register group purchase");     // Catch: Throwable -> L196
        IAnimationScheduler.Companion r81 = IAnimationScheduler.M0;     // Catch: Throwable -> L196
        DataCenter r82 = this.a;     // Catch: Throwable -> L196
        r81.getClass();     // Catch: Throwable -> L196
        IAnimationScheduler r83 = IAnimationScheduler.Companion.a(r82);     // Catch: Throwable -> L196
        if (r83 == null) goto L193;
        r83.registerListener(this.n);     // Catch: Throwable -> L196
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L196
    L193:
        r80 = r2;
    L196:
        th = move-exception;
        Result.Companion r84 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L198
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L31:
        r18 = "";
    L42:
        r5 = null;
    L24:
        r14 = null;
        goto L25
    L18:
        r11 = null;
        goto L19
    L57:
        View r85 = r3.getView();
        if (r85 == null) goto L67;
        if (r85.getParent() == null) goto L62;
        PoolUtilKt.a(r85);
    L62:
        View r86 = this.f;
        if (r86 == null) goto L66;
        ((ViewGroup) r86).addView(r85);
        goto L67
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r1 = null;
        goto L6
    }

    public final ILiveEnterRoomCallback onBindBridge(ILivePreviewBusinessBridge r2) {
        Intrinsics.checkNotNullParameter(r2, "bridge");
        this.i = r2;
        d r3 = new d(this);
        this.j = r3;
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L5;
        String r0 = r7.getKey();
    L6:
        if (r0 == null) goto L32;
        int r1 = r0.hashCode();
        if (r1 == 130381608) goto L26;
        if (r1 == 1586184680) goto L14;
        return;
    L14:
        if (r0.equals("log_enter_params") == false) goto L29;
        JSONObject r2 = new JSONObject((String) r7.getData());
        if (tb1.c.a == false) goto L18;
        String r8 = com.bytedance.android.livesdk.chatroom.utils.k1.c();
    L20:
        if (com.bytedance.android.livesdk.utils.c1.c(this.a) == false) goto L22;
    L23:
        this.e.putOpt("isAd", Boolean.TRUE);
    L24:
        JSONObject r3 = this.e;
        r3.putOpt("enter_from_merge", r8);
        r3.putOpt("enter_method", r2.optString("enter_method"));
        r3.putOpt("request_id", r2.optString("request_id"));
        r3.putOpt("is_other_channel", r2.optString("is_other_channel"));
        r3.putOpt("value", r2.optString("value"));
        r3.putOpt("video_id", r2.optString("video_id"));
        return;
    L22:
        if (com.bytedance.android.livesdk.utils.c1.b(this.a) == false) goto L24;
    L18:
        r8 = r2.optString("enter_from_merge");
        goto L20
    L29:
        return;
    L26:
        if (r0.equals("log_action_type") == false) goto L31;
        String r9 = (String) r7.getData();
        this.e.put("action_type", r9);
        return;
    L31:
        return;
    L32:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void onHide(boolean r4) {
        ILiveLocalLifeAnchorView r5 = this.g;
        boolean r0 = r5 instanceof ILiveLocalLifeAnchorView;
        if (r0 == false) goto L8;
        if (r0 == true) goto L6;
        r5 = null;
    L6:
        if (r5 == null) goto L8;
        View r6 = r5.getView();
    L9:
        if (r6 == null) goto L20;
        View r1 = this.f;
        if ((r1 instanceof ViewGroup) == true) goto L13;
        r1 = null;
    L13:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L16;
        int r3 = r2.indexOfChild(r6);
    L17:
        if (r3 < 0) goto L20;
        if (r2 == null) goto L20;
        r2.removeView(r6);
        goto L20
    L16:
        r3 = -1;
    L20:
        this.g = null;
        return;
    L8:
        r6 = null;
        goto L9
    }

    public static final void a(ToolbarGroupPurchaseAudienceBehavior r5, int r6) {
        if (r5.h == true) goto L36;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r5.a).i(ToolbarButton.GROUP_PURCHASE_AUDIENCE.extended());
        ILiveLocalLifeAnchorView r0 = r5.g;
        boolean r1 = r0 instanceof ILiveLocalLifeAnchorView;
        if (r1 == false) goto L11;
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        View r2 = r0.getView();
    L12:
        if (r2 == null) goto L23;
        View r3 = r5.f;
        if ((r3 instanceof ViewGroup) == true) goto L16;
        r3 = null;
    L16:
        ViewGroup r4 = (ViewGroup) r3;
        if (r4 == null) goto L19;
        int r7 = r4.indexOfChild(r2);
    L20:
        if (r7 < 0) goto L23;
        if (r4 == null) goto L23;
        r4.removeView(r2);
        goto L23
    L19:
        r7 = -1;
    L23:
        r5.g = null;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("reason", String.valueOf(r6));
        IHostLiveLocalLife r9 = r5.d();
        if (r9 == null) goto L31;
        DataCenter r10 = r5.a;
        if (r10 == null) goto L29;
        String r11 = com.bytedance.android.live.core.utils.z.d(r10, null);
        if (r11 == null) goto L29;
    L30:
        r9.sendLog(r11, "live_life_icon_dismiss", r8);
    L29:
        r11 = "";
    L31:
        IHostLiveLocalLife r12 = r5.d();
        if (r12 == null) goto L35;
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("reason", String.valueOf(r6));
        Unit r14 = Unit.INSTANCE;
        r12.log("icon_remove", r13);
        return;
    L35:
        return;
    L11:
        r2 = null;
        goto L12
    }

    public static void j(Map r5, String... r6) {
        com.bytedance.android.livesdk.log.filter.n0 r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r0 == null) goto L20;
        com.bytedance.android.livesdk.log.filter.n0 r1 = r0;
        int r2 = 0;
        if (r6.length != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        int r4 = r6.length;
    L11:
        if (r2 >= r4) goto L18;
        String r7 = r6[r2];
        if (((com.bytedance.android.livesdk.log.filter.a) r1).b.containsKey(r7) == false) goto L17;
        String r8 = (String) ((com.bytedance.android.livesdk.log.filter.a) r1).b.get(r7);
        if (r8 == null) goto L17;
        r5.put(r7, r8);
    L17:
        r2 = r2 + 1;
        goto L11
    L18:
        return;
    L7:
        r3 = false;
        goto L8
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.log.filter.PageSourceFilter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.h = true;
        if (com.bytedance.android.livesdk.config.setting.x.a() == false) goto L7;
        ALogger.i("AnimationCenterScheduler", "unregister group purchase");
        IAnimationScheduler.M0.getClass();
        IAnimationScheduler r4 = IAnimationScheduler.Companion.a(r3);
        if (r4 == null) goto L7;
        r4.unRegisterListener(this.n);
    L7:
        ILiveLocalLifeFragmentDelegate r5 = this.l;
        if (r5 == null) goto L10;
        r5.dismissPage();
    L10:
        this.l = null;
        DialogFragment r6 = this.m;
        if (r6 != null) goto L20;
    L18:
        this.m = null;
        return;
    L20:
        r6.dismissAllowingStateLoss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L18;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L18
    }

    public final String c(String r3, String r4) {
        if (r3 != null) goto L5;
        return "";
    L5:
        Uri.Builder r5 = UriProtector.parse(r3).buildUpon();
        GroupPurchaseItem r0 = this.d;
        if (r0 == null) goto L8;
        String r1 = r0.getPoiRoomInfo();
    L9:
        Uri.Builder r6 = r5.appendQueryParameter("poi_room_info", r1);
        if (r4 == null) goto L13;
        r6.appendQueryParameter("source_btm_token", r4);
    L13:
        return r6.build().toString();
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.f = r4;
        this.a = r5;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        this.b = r6;
        if (r6 == null) goto L7;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L7;
        Room r8 = (Room) r7.getValue();
    L8:
        this.c = r8;
        this.h = false;
        if (com.bytedance.android.live.core.utils.z.e(r5, false) == false) goto L11;
        return;
    L11:
        if (g() == false) goto L16;
        r5.observe("log_action_type", this, true);
        r5.observe("log_enter_params", this, true);
        return;
    L16:
        return;
    L7:
        r8 = null;
        goto L8
    }

    public final void i(boolean r10, String r11, String r12) {
        if (this.d != null) goto L5;
        return;
    L5:
        IHostLiveLocalLife r0 = d();
        AppCompatActivity r1 = null;
        if (r0 == null) goto L53;
        DataCenter r2 = this.a;
        if (r2 == null) goto L11;
        String r3 = com.bytedance.android.live.core.utils.z.d(r2, null);
        if (r3 == null) goto L11;
    L12:
        Bundle r4 = new Bundle();
        Room r5 = this.c;
        long r6 = 0;
        if (r5 == null) goto L15;
        long r7 = r5.id;
    L16:
        r4.putLong("room_id", r7);
        com.bytedance.android.live.base.model.user.o0.a r8 = com.bytedance.android.live.base.model.user.o0.a;
        Room r9 = this.c;
        if (r9 == null) goto L19;
        r9.getOwnerUserIdString();
    L19:
        r8.getClass();
        r4.putLong("anchor_id", 0);
        r4.putString("icon_type", "house");
        GroupPurchaseItem r13 = this.d;
        if (r13 == null) goto L22;
        String r14 = r13.getOpenUrl();
    L23:
        r4.putString("lynx_url", c(r14, null));
        GroupPurchaseItem r15 = this.d;
        if (r15 == null) goto L26;
        String r16 = r15.getWebUrl();
    L27:
        r4.putString("url", r16);
        GroupPurchaseItem r17 = this.d;
        if (r17 == null) goto L30;
        String r18 = r17.getWebTitle();
    L31:
        r4.putString(LiveEndPageData.TAG_TITLE, r18);
        r4.putBoolean("is_portrait", g());
        r4.putBoolean("is_landscape_room", f());
        r4.putString("enter_from_merge", this.e.optString("enter_from_merge"));
        r4.putString("action_type", this.e.optString("action_type"));
        r4.putString("request_id", this.e.optString("request_id"));
        r4.putString("is_other_channel", this.e.optString("is_other_channel"));
        r4.putString("enter_method", this.e.optString("enter_method"));
        GroupPurchaseItem r19 = this.d;
        if (r19 == null) goto L34;
        String r20 = r19.getLogExtra();
    L35:
        r4.putString("log_extra", r20);
        r4.putString("video_id", this.e.optString("video_id"));
        r4.putBoolean("auto_open_shelf", r10);
        r4.putString("shelf_from_position", r11);
        r4.putString("anchor_product_id", r12);
        if (r10 == false) goto L38;
        String r110 = "c565869.d0";
    L39:
        ILiveLocalLifeAnchorView r111 = this.g;
        if ((r111 instanceof ILiveLocalLifeAnchorView) == true) goto L42;
        r111 = null;
    L42:
        if (r111 == null) goto L44;
        View r112 = r111.getView();
    L45:
        if (r112 != null) goto L47;
    L52:
        Unit r113 = Unit.INSTANCE;
        DialogFragment r114 = r0.getLiveGoodsShelvesDialogFragment(r3, r4);
    L54:
        this.m = r114;
        AppCompatActivity r115 = ContextUtil.contextToActivity(this.o);
        if ((r115 instanceof AppCompatActivity) == false) goto L58;
        r1 = r115;
    L58:
        AppCompatActivity r21 = r1;
        if (r21 == null) goto L73;
        FragmentManager r116 = r21.getSupportFragmentManager();
        if (r116 == null) goto L74;
        DialogFragment r117 = this.m;
        if (r117 == null) goto L75;
        LandscapeRestrictionOperation r118 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r117, "live_goods_shelves_dialog_fragment", r118);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r116, r117, r118) == true) goto L76;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L70
    L68:
        r117.show(r116, "live_goods_shelves_dialog_fragment");
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L47:
        if (d() == null) goto L52;
        IHostLiveLocalLife r119 = d();
        Intrinsics.checkNotNull(r119);
        Pair[] r22 = new Pair[2];
        r22[0] = TuplesKt.to("life_req_id", this.e.optString("request_id"));
        Room r23 = this.c;
        if (r23 == null) goto L51;
        r6 = r23.id;
    L51:
        r22[1] = TuplesKt.to("life_room_id", String.valueOf(r6));
        r4.putString("source_btm_token", r119.createBtmSourceToken(r112, r110, MapsKt.mutableMapOf(r22)));
        goto L52
    L44:
        r112 = null;
        goto L45
    L38:
        r110 = "c9398.d208721";
        goto L39
    L34:
        r20 = null;
        goto L35
    L30:
        r18 = null;
        goto L31
    L26:
        r16 = null;
        goto L27
    L22:
        r14 = null;
        goto L23
    L15:
        r7 = 0;
    L11:
        r3 = "";
        goto L12
    L53:
        r114 = null;
        goto L54
    }
}
