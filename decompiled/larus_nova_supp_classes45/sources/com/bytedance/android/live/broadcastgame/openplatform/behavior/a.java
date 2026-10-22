package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import a20.m;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcast.api.model.o0;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.n;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.openplatform.api.MiniAppPreModifyCheckApi;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import com.bytedance.android.live.broadcastgame.openplatform.miniapp.OpenOPAppHelper;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.ev0;
import com.bytedance.android.livesdk.config.n90;
import com.bytedance.android.livesdk.config.xc1;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.message.model.pf;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mh1.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements f10.a {
    public String a;
    public m b;
    public final String c;
    public u d;
    public final p e;
    public String f;
    public Integer g;
    public final /* synthetic */ i20.a h;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.openplatform.behavior.a$a, reason: collision with other inner class name */
    public static final class C0090a implements o0 {
        public final /* synthetic */ View a;

        public C0090a(View r1) {
            this.a = r1;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ View b;

        public b(a r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            if (r9 == null) goto L11;
            MiniAppPreModifyCheckApi.b r11 = (MiniAppPreModifyCheckApi.b) ((ExtraResponse) r9).data;
            if (r11 == null) goto L11;
            if (r11.a() != true) goto L11;
            Ref.ObjectRef r12 = new Ref.ObjectRef();
            r12.element = null;
            IBrowserService r0 = (IBrowserService) k.f(IBrowserService.class);
            if (r0 == null) goto L15;
            Context r1 = this.b.getContext();
            a r2 = this.a;
            r2.getClass();
            Uri.Builder r3 = UriProtector.parse(((xc1) n90.a.getValue()).b()).buildUpon();
            r3.appendQueryParameter(OpenPlatformBaseDebugger.APP_ID, r2.d.e());
            r3.appendQueryParameter("app_name", r2.d.name);
            r3.appendQueryParameter("entrance_form", "solid_entrance");
            r3.appendQueryParameter("enter_from_merge", "live_take_page");
            int r4 = n.a;
            u r5 = r2.d;
            r3.appendQueryParameter("enter_position", n.l(r5.groupType, r5.c, false));
            r0.showHybridDialog(r1, r3.build(), new com.bytedance.android.live.broadcastgame.openplatform.behavior.b(this, r12));
            return;
        L15:
            return;
        L11:
            p r13 = this.a.e;
            if (r13 == null) goto L17;
            int r6 = OpenOPAppHelper.a;
            OpenOPAppHelper.b(this.b.getContext(), this.a.d, r13);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ View b;

        public c(a r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            p r5 = this.a.e;
            if (r5 == null) goto L6;
            int r0 = OpenOPAppHelper.a;
            OpenOPAppHelper.b(this.b.getContext(), this.a.d, r5);
            return;
        }
    }

    public static final class d implements o0 {
        public final /* synthetic */ View a;

        public d(View r1) {
            this.a = r1;
        }
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void p4(View r1, DataCenter r2) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void a(u r5) {
        InteractID.a r0 = InteractID.Companion;
        int r1 = r5.interactId;
        r0.getClass();
        if (InteractID.a.a(InteractID.a.b(r1)) == true) goto L5;
        return;
    L5:
        m r2 = this.b;
        if (r2 == null) goto L23;
        String r3 = r2.a.getValue();
        if (r2.a != OpenFeatureIconCallbackFrom.TAB_LIST) goto L10;
        r3 = "game_tab";
    L10:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r5.d = r3;
        if (r2.getType() != OpenFeatureIconCallbackType.START_BUTTON) goto L13;
    L16:
        boolean r4 = true;
    L17:
        r5.e = r4;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r6 = AnchorGameContext.a.a();
        if (r6 == null) goto L24;
        com.bytedance.live.datacontext.n<String> r7 = r6.getClickIconSource();
        if (r7 == null) goto L25;
        r7.setValue(r3);
        return;
    L25:
        return;
    L24:
        return;
    L13:
        if (r2.a == OpenFeatureIconCallbackFrom.RECENT_USE) goto L16;
        r4 = false;
        goto L17
    }

    public final void onClick(View r14) {
        Intrinsics.checkNotNullParameter(r14, "v");
        int r0 = n.a;
        r r1 = this.d.c();
        if (r1 == null) goto L6;
        String r2 = r1.b();
        if (r2 == null) goto L6;
    L7:
        String r3 = r2;
        u r4 = this.d;
        String r5 = r4.name;
        InteractID.a r6 = InteractID.Companion;
        int r7 = r4.interactId;
        r6.getClass();
        InteractID r8 = InteractID.a.b(r7);
        u r9 = this.d;
        n.d(true, r3, r5, r8, r9.groupType, r9.c, this.f, this.g, this.a, r9.f, Integer.valueOf(r9.g));
        int r11 = this.d.interactId;
        if (tb1.c.g == true) goto L12;
        f2.c("当前不支持该玩法", 0);
        return;
    L12:
        if (r11 != InteractID.SonicMiniGame.getValue()) goto L24;
        p r12 = this.e;
        if (r12 == null) goto L92;
        a(this.d);
        int r13 = OpenOPAppHelper.a;
        Context r15 = r14.getContext();
        u r16 = this.d;
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "item");
        Intrinsics.checkNotNullParameter(r12, "miniAppHelper");
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.C0095a r17 = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.C0095a();
        RoomContext r18 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r18 == null) goto L93;
        com.bytedance.live.datacontext.n r19 = r18.getDataCenter();
        if (r19 == null) goto L94;
        DataCenter r21 = (DataCenter) r19.getValue();
        if (r21 == null) goto L111;
        r17.a(new OpenOPAppHelper.CheckOpenPlatformPluginRunningNode(r16, r21, r15, false));
        r17.a(new OpenOPAppHelper.CheckGameConflictNode(r16, r21, r15));
        r17.a(new OpenOPAppHelper.CheckMiniGameToolbarConflictNode(r12));
        r17.a(new OpenOPAppHelper.d(r16, r21));
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r110 = r17.b();
        r110.b = 0;
        r110.a();
        return;
    L111:
        return;
    L94:
        return;
    L93:
        return;
    L92:
        return;
    L24:
        if (r11 != InteractID.OpenGame.getValue()) goto L36;
        p r22 = this.e;
        if (r22 == null) goto L96;
        int r23 = OpenOPAppHelper.a;
        Context r111 = r14.getContext();
        u r24 = this.d;
        Intrinsics.checkNotNullParameter(r111, "context");
        Intrinsics.checkNotNullParameter(r24, "item");
        Intrinsics.checkNotNullParameter(r22, "miniAppHelper");
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.C0095a r25 = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.C0095a();
        RoomContext r26 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r26 == null) goto L97;
        com.bytedance.live.datacontext.n r27 = r26.getDataCenter();
        if (r27 == null) goto L98;
        DataCenter r28 = (DataCenter) r27.getValue();
        if (r28 == null) goto L112;
        r25.a(new OpenOPAppHelper.CheckOpenPlatformPluginRunningNode(r24, r28, r111, false));
        r25.a(new OpenOPAppHelper.CheckGameConflictNode(r24, r28, r111));
        r25.a(new OpenOPAppHelper.CheckMiniGameToolbarConflictNode(r22));
        r25.a(new OpenOPAppHelper.d(r24, r28));
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r112 = r25.b();
        r112.b = 0;
        r112.a();
        return;
    L112:
        return;
    L98:
        return;
    L97:
        return;
    L96:
        return;
    L36:
        if (r11 != InteractID.OpenMicroApp.getValue()) goto L74;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r29 = AnchorMiniAppDataContext.a.a();
        if (r29 == null) goto L45;
        com.bytedance.live.datacontext.m r31 = r29.getMicroAppMountPunishing();
        if (r31 == null) goto L45;
        if (((Boolean) r31.getValue()).booleanValue() != true) goto L45;
        f2.b(2131920950, 0);
        return;
    L45:
        AnchorMiniAppDataContext r32 = AnchorMiniAppDataContext.a.a();
        if (r32 == null) goto L63;
        com.bytedance.live.datacontext.n r33 = r32.getMicroAppLiveMountLimitData();
        if (r33 == null) goto L63;
        pf.a r34 = (pf.a) r33.getValue();
        if (r34 == null) goto L63;
        if (r34.nextMountLimit == false) goto L58;
        long r35 = r34.nextMountTime;
        if (r35 <= 0) goto L58;
        if ((r35 * ((long) 1000)) <= System.currentTimeMillis()) goto L58;
        boolean r36 = true;
    L59:
        if (r36 == false) goto L63;
        f2.c(r34.toast, 0);
        g r113 = com.bytedance.android.livesdk.log.u.l();
        LinkedHashMap r37 = new LinkedHashMap();
        r37.put("_param_for_special", "micro_app");
        Unit r38 = Unit.INSTANCE;
        r113.h("mp_live_mount_limit_toast_show", r37, new Object[]{Room.class});
        return;
    L58:
        r36 = false;
    L63:
        if (((Boolean) ev0.a.getValue()).booleanValue() == false) goto L68;
        IMiddlewareBroadcastService r39 = (IMiddlewareBroadcastService) k.f(IMiddlewareBroadcastService.class);
        if (r39 == null) goto L100;
        r39.checkToolbarPermission(r14.getContext(), Long.valueOf(3), "live_detail", new C0090a(r14));
        return;
    L100:
        return;
    L68:
        if (((xc1) n90.a.getValue()).a() == false) goto L70;
        Disposable r114 = ((MiniAppPreModifyCheckApi) com.bytedance.android.live.network.c.b().e(MiniAppPreModifyCheckApi.class)).preCheck(new MiniAppPreModifyCheckApi.a(this.d.e())).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r14), new c(this, r14));
        Intrinsics.checkNotNullParameter(r114, "$this$autoDispose");
        this.h.a(r114);
        return;
    L70:
        p r41 = this.e;
        if (r41 == null) goto L103;
        int r42 = OpenOPAppHelper.a;
        OpenOPAppHelper.b(r14.getContext(), this.d, r41);
        return;
    L103:
        return;
    L74:
        if (r11 == InteractID.OpenMicroGame.getValue()) goto L76;
        f2.c("当前版本不支持该玩法", 0);
        return;
    L76:
        if (((Boolean) ev0.a.getValue()).booleanValue() == false) goto L80;
        IMiddlewareBroadcastService r43 = (IMiddlewareBroadcastService) k.f(IMiddlewareBroadcastService.class);
        if (r43 == null) goto L105;
        r43.checkToolbarPermission(r14.getContext(), Long.valueOf(9), "live_detail", new d(r14));
        return;
    L105:
        return;
    L80:
        p r44 = this.e;
        if (r44 == null) goto L107;
        a(this.d);
        int r45 = OpenOPAppHelper.a;
        Context r115 = r14.getContext();
        u r46 = this.d;
        Intrinsics.checkNotNullParameter(r115, "context");
        Intrinsics.checkNotNullParameter(r46, "item");
        Intrinsics.checkNotNullParameter(r44, "miniAppHelper");
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.C0095a r47 = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.a.C0095a();
        RoomContext r48 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r48 == null) goto L108;
        com.bytedance.live.datacontext.n r49 = r48.getDataCenter();
        if (r49 == null) goto L109;
        DataCenter r51 = (DataCenter) r49.getValue();
        if (r51 == null) goto L113;
        r47.a(new OpenOPAppHelper.a(r46, r51, r115));
        r47.a(new OpenOPAppHelper.CheckGameConflictNode(r46, r51, r115));
        r47.a(new OpenOPAppHelper.CheckMiniGameToolbarConflictNode(r44));
        r47.a(new OpenOPAppHelper.b(r115, r46, r51));
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.a r116 = r47.b();
        r116.b = 0;
        r116.a();
        return;
    L113:
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L6:
        r2 = "";
        goto L7
    }

    @Override // f10.a
    public final void xg(u r2) {
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public a(u r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "interactItem");
        this.h = new i20.a();
        this.d = r2;
        this.e = r3;
        this.f = null;
        this.g = null;
        this.a = "";
        this.c = "open_ability_closeTipDialog";
    }
}
