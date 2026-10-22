package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import a20.m;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.n;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.j0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.model.z;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.LiveOpenFeaturePanelViewModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.o2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.hn0;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.config.xp;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveOpenFeatureIconBehaviorController extends com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a<LiveOpenFeaturePanelViewModel> {
    public final g3 b;
    public final DataCenter c;
    public final a d;
    public final Lazy e;
    public final LiveOpenFeaturePanelViewModel f;

    public static final class a extends o2<c0.b, InteractEntranceCell, z> {
        public z c;

        public a(Function2<? super InteractEntranceCell, ? super z, ? extends c0.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "behaviorFactory");
            super(r2);
        }

        public static void c(InteractEntranceCell r1, c0.b r2) {
            Intrinsics.checkNotNullParameter(r1, "data");
            Intrinsics.checkNotNullParameter(r2, "behavior");
            if ((r2 instanceof f10.a) == true) goto L5;
            r2 = null;
        L5:
            f10.a r3 = (f10.a) r2;
            if (r3 == null) goto L9;
            r3.xg(r1.i());
            return;
        }

        public final /* bridge */ /* synthetic */ Object b(o2.b r1, o2.a r2, Object r3) {
            z r4 = (z) r2;
            c0.b r5 = (c0.b) r3;
            c((InteractEntranceCell) r1, r5);
            return r5;
        }
    }

    public final class b extends f2<f10.f, InteractEntranceCell, c0.b> {
        public final /* synthetic */ LiveOpenFeatureIconBehaviorController b;

        public b(LiveOpenFeatureIconBehaviorController r1) {
            this.b = r1;
        }

        public final f10.f a(f2.b r12) {
            InteractEntranceCell r13 = (InteractEntranceCell) r12;
            Intrinsics.checkNotNullParameter(r13, "data");
            ImageModel r0 = r13.icon;
            if (r0 == null) goto L5;
            List<String> r1 = r0.getUrls();
        L6:
            List<String> r2 = r1;
            if (r2 != null) goto L9;
        L12:
            boolean r3 = true;
        L14:
            if (r3 == true) goto L20;
            ImageModel r4 = r13.icon;
            if (r4 == null) goto L20;
            List<String> r5 = r4.getUrls();
            if (r5 == null) goto L20;
        L21:
            List<String> r6 = r5;
            String r7 = r13.title;
            boolean r8 = LiveOpenFeatureIconBehaviorController.g(this.b, r13);
            String r9 = r13.h();
            String r11 = r13.desc;
            if (r11 != null) goto L24;
            String r14 = "";
        L25:
            String r15 = r14;
            f10.f r16 = new f10.f(r6, r7, r8, r9, r15, r13, r13.labels, r13.rightButton);
            r16.t = true;
            ((ExtendedToolbarButton.c) r16).j = r13.groupType;
            ((ExtendedToolbarButton.c) r16).k = r13.interactType;
            r16.u = this.b.f.getFeatureIconRunningStateManager().a(((ExtendedToolbarButton.c) r16).s, true);
            r16.v = r13.f();
            r16.x = r13.f.b;
            this.b.getClass();
            ExtendedToolbarButton.HighLightMode r17 = ExtendedToolbarButton.HighLightMode.DISABLE;
            Intrinsics.checkNotNullParameter(r17, "<set-?>");
            ((ExtendedToolbarButton) r16).f = r17;
            return r16;
        L24:
            r14 = r11;
        L20:
            r5 = CollectionsKt.listOf("");
            goto L21
        L9:
            if (r2.isEmpty() == true) goto L12;
            r3 = false;
            goto L14
        L5:
            r1 = null;
            goto L6
        }

        public final c0.b b(f2.b r3) {
            InteractEntranceCell r4 = (InteractEntranceCell) r3;
            Intrinsics.checkNotNullParameter(r4, "data");
            a r1 = this.b.d;
            if (r1 == null) goto L5;
            Intrinsics.checkNotNullParameter(r4, "data");
            return (c0.b) r1.a(r4, r1.c);
        L5:
            return null;
        }

        public final void c(f2.b r3) {
            InteractEntranceCell r4 = (InteractEntranceCell) r3;
            Intrinsics.checkNotNullParameter(r4, "data");
            a r1 = this.b.d;
            if (r1 == null) goto L9;
            Intrinsics.checkNotNullParameter(r4, "data");
            c0.b r0 = (c0.b) r1.a(r4, r1.c);
            if (r0 == null) goto L10;
            a.c(r4, r0);
            return;
        L10:
            return;
        }

        public final f10.f d(f2.b r7, ExtendedToolbarButton.c r8) {
            InteractEntranceCell r9 = (InteractEntranceCell) r7;
            f10.f r11 = (f10.f) r8;
            Intrinsics.checkNotNullParameter(r9, "data");
            Intrinsics.checkNotNullParameter(r11, "icon");
            ImageModel r0 = r9.icon;
            if (r0 == null) goto L5;
            List<String> r1 = r0.getUrls();
        L6:
            List<String> r2 = r1;
            if (r2 != null) goto L9;
        L12:
            boolean r3 = true;
        L13:
            String r4 = "";
            if (r3 == true) goto L20;
            ImageModel r5 = r9.icon;
            if (r5 == null) goto L20;
            List<String> r6 = r5.getUrls();
            if (r6 == null) goto L20;
        L21:
            r11.getClass();
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            ((ExtendedToolbarButton.c) r11).p = r6;
            String r12 = r9.title;
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            ((ExtendedToolbarButton.c) r11).q = r12;
            ((ExtendedToolbarButton.c) r11).r = LiveOpenFeatureIconBehaviorController.g(this.b, r9);
            String r13 = r9.desc;
            if (r13 == null) goto L24;
            r4 = r13;
        L24:
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r11.C = r4;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r11.D = r9;
            r11.t = true;
            ((ExtendedToolbarButton.c) r11).j = r9.groupType;
            ((ExtendedToolbarButton.c) r11).k = r9.interactType;
            r11.u = this.b.f.getFeatureIconRunningStateManager().a(r9.h(), true);
            r11.v = r9.f();
            r11.x = r9.f.b;
            r11.F = r9.rightButton;
            this.b.getClass();
            ExtendedToolbarButton.HighLightMode r14 = ExtendedToolbarButton.HighLightMode.DISABLE;
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            ((ExtendedToolbarButton) r11).f = r14;
            return r11;
        L20:
            r6 = CollectionsKt.listOf("");
            goto L21
        L9:
            if (r2.isEmpty() == true) goto L12;
            r3 = false;
            goto L13
        L5:
            r1 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a, a20.d
    public final void onDestroy() {
        a r0 = this.d;
        if (r0 == null) goto L5;
        ((LinkedHashMap) ((o2) r0).a).clear();
    L5:
        f2 r1 = (f2) this.e.getValue();
        DataCenter r2 = this.c;
        Iterator r3 = ((LinkedHashMap) r1.a).entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        Map.Entry r4 = (Map.Entry) r3.next();
        ExtendedToolbarButton.c r5 = (ExtendedToolbarButton.c) ((Pair) r4.getValue()).getFirst();
        c0.b r6 = (c0.b) ((Pair) r4.getValue()).getSecond();
        Intrinsics.checkNotNullParameter(r5, "icon");
        Intrinsics.checkNotNullParameter(r6, "behavior");
        y3.f(r2).f(r5, r6);
        goto L7
    L9:
        ((LinkedHashMap) r1.a).clear();
    }

    public LiveOpenFeatureIconBehaviorController(LiveOpenFeaturePanelViewModel r5) {
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        this.f = r5;
        a20.b r0 = r5.getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease();
        g3 r1 = null;
        if (r0 == null) goto L5;
        DataCenter r2 = r0.d();
    L6:
        this.c = r2;
        g3 r3 = y3.f(r2);
        if ((r3 instanceof x3) == false) goto L10;
        r1 = r3;
    L10:
        this.b = r1;
        a20.b r4 = r5.getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease();
        if (r4 == null) goto L26;
        Function2<InteractEntranceCell, z, c0.b> r6 = r4.f();
        if (r6 == null) goto L26;
        a r7 = new a(r6);
        a20.b r8 = r5.getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease();
        if (r8 == null) goto L25;
        Context r9 = r8.c();
        if (r9 == null) goto L25;
        a20.b r11 = r5.getOpenPlatformBehaviorCallback$livebroadcastgame_impl_saasRelease();
        if (r11 == null) goto L25;
        DataCenter r12 = r11.d();
        if (r12 == null) goto L25;
        r7.c = new z(r9, r12, r1);
    L25:
        Unit r13 = Unit.INSTANCE;
        this.d = r7;
    L26:
        this.e = LazyKt.lazy(new LiveOpenFeatureIconBehaviorController$openFeatureIconLoader$2(this));
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final boolean g(LiveOpenFeatureIconBehaviorController r9, InteractEntranceCell r11) {
        r9.getClass();
        r r12 = r11.e();
        j0 r0 = null;
        if (r12 == null) goto L5;
        com.bytedance.android.live.broadcastgame.api.model.c r13 = r12.f();
    L6:
        long r1 = -1;
        long r3 = Long.MAX_VALUE;
        if (r13 == null) goto L24;
        long r5 = com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a.d();
        r r14 = r11.e();
        if (r14 == null) goto L13;
        com.bytedance.android.live.broadcastgame.api.model.c r15 = r14.f();
        if (r15 == null) goto L13;
        long r7 = r15.b();
    L15:
        if (r5 <= r7) goto L24;
        long r6 = com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a.d();
        r r16 = r11.e();
        if (r16 == null) goto L21;
        com.bytedance.android.live.broadcastgame.api.model.c r17 = r16.f();
        if (r17 == null) goto L21;
        long r8 = r17.a();
    L23:
        if (r6 >= r8) goto L24;
    L71:
        return true;
    L21:
        r8 = -1;
    L13:
        r7 = Long.MAX_VALUE;
    L24:
        r r18 = r11.e();
        if (r18 == null) goto L27;
        com.bytedance.android.live.broadcastgame.api.model.a r19 = r18.e();
    L28:
        if (r19 == null) goto L45;
        long r21 = com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a.d();
        r r22 = r11.e();
        if (r22 == null) goto L34;
        com.bytedance.android.live.broadcastgame.api.model.a r23 = r22.e();
        if (r23 == null) goto L34;
        long r24 = r23.b();
    L36:
        if (r21 <= r24) goto L45;
        long r25 = com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a.d();
        r r26 = r11.e();
        if (r26 == null) goto L42;
        com.bytedance.android.live.broadcastgame.api.model.a r27 = r26.e();
        if (r27 == null) goto L42;
        long r28 = r27.a();
    L44:
        if (r25 < r28) goto L71;
    L42:
        r28 = -1;
    L34:
        r24 = Long.MAX_VALUE;
    L45:
        r r29 = r11.e();
        if (r29 == null) goto L49;
        r0 = r29.B();
    L49:
        if (r0 == null) goto L73;
        r r2 = r11.e();
        if (r2 == null) goto L55;
        j0 r4 = r2.B();
        if (r4 == null) goto L55;
        boolean r31 = r4.c();
    L56:
        if (r31 == false) goto L74;
        long r32 = com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a.d();
        r r33 = r11.e();
        if (r33 == null) goto L63;
        j0 r34 = r33.B();
        if (r34 == null) goto L63;
        r3 = r34.b();
    L63:
        if (r32 <= r3) goto L75;
        long r35 = com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a.d();
        r r110 = r11.e();
        if (r110 == null) goto L70;
        j0 r111 = r110.B();
        if (r111 == null) goto L70;
        r1 = r111.a();
    L70:
        if (r35 < r1) goto L71;
        return false;
    L75:
        return false;
    L74:
        return false;
    L55:
        r31 = false;
        goto L56
    L73:
        return false;
    L27:
        r19 = null;
        goto L28
    L5:
        r13 = null;
        goto L6
    }

    @Override // a20.e
    public final void b(View r6, f10.f r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "icon");
        x3 r0 = y3.f(this.c);
        String r2 = null;
        if ((r0 instanceof x3) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L19;
        ((HashMap) r0.c).put(r7, r6);
        r0.D(r7, r6);
        if (r7.D.interactType != InteractID.OpenMicroApp.getValue()) goto L20;
        String r9 = r7.D.extra;
        if (r9 != null) goto L11;
    L16:
        String r11 = "";
    L17:
        int r1 = n.a;
        InteractEntranceCell r3 = r7.D;
        n.g(r11, n.l(r3.groupType, r3.d, false), true, r7.D.g(), Integer.valueOf(r8));
        return;
    L11:
        if ((!StringsKt.isBlank(r9)) == false) goto L13;
        r2 = r9;
    L13:
        if (r2 == null) goto L16;
        r11 = new JSONObject(r2).optString(OpenPlatformBaseDebugger.APP_ID);
        if (r11 != null) goto L17;
    L20:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a
    public final f10.f f(InteractEntranceCell r5, boolean r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "data");
        f2 r8 = (f2) this.e.getValue();
        DataCenter r0 = this.c;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "data");
        f2.a r1 = new f2.a(r5.h(), r5.groupType);
        if (r8.a.containsKey(r1) == false) goto L5;
        r8.c(r5);
        Object r9 = ((LinkedHashMap) r8.a).get(r1);
        Intrinsics.checkNotNull(r9);
        return r8.d(r5, (ExtendedToolbarButton.c) ((Pair) r9).getFirst());
    L5:
        f10.f r11 = r8.a(r5);
        c0.b r12 = r8.b(r5);
        if (r12 == null) goto L9;
        Intrinsics.checkNotNullParameter(r11, "icon");
        Intrinsics.checkNotNullParameter(r12, "behavior");
        y3.f(r0).p(r11, r12);
        r8.a.put(r1, new Pair(r11, r12));
    L9:
        return r11;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a
    public final void e(View r29, f10.f r31, int r32, m r33) {
        Intrinsics.checkNotNullParameter(r29, "view");
        Intrinsics.checkNotNullParameter(r31, "icon");
        h3.b(this.c, r31.f());
        View r4 = r29.findViewById(2131384095);
        if (r4 != null) goto L6;
    L12:
        g3 r5 = this.b;
        if (r5 == null) goto L25;
        if (r5.x(r31) != true) goto L25;
        g3 r1 = this.b;
        if (r1 == null) goto L19;
        String r8 = r1.u(r31);
    L21:
        if (TextUtils.isEmpty(r8) == true) goto L142;
        com.bytedance.android.live.core.utils.f2.c(r8, 0);
        return;
    L142:
        return;
    L19:
        r8 = null;
    L25:
        if (r31.h() != null) goto L140;
        g3 r6 = this.b;
        if (r6 == null) goto L29;
        c0.b r7 = r6.s(r31);
    L31:
        if ((r7 instanceof f10.a) == true) goto L33;
        c0.b r9 = null;
    L34:
        f10.a r11 = (f10.a) r9;
        if (r11 == null) goto L37;
        r11.xg(r31.D.i());
    L37:
        boolean r12 = r7 instanceof com.bytedance.android.live.broadcastgame.openplatform.behavior.a;
        if (r12 == true) goto L40;
        c0.b r13 = null;
    L41:
        com.bytedance.android.live.broadcastgame.openplatform.behavior.a r14 = (com.bytedance.android.live.broadcastgame.openplatform.behavior.a) r13;
        if (r14 == null) goto L44;
        String r15 = r31.D.g();
        Integer r16 = Integer.valueOf(r32);
        r14.f = r15;
        r14.g = r16;
    L44:
        if (r12 == true) goto L46;
        c0.b r17 = null;
    L47:
        com.bytedance.android.live.broadcastgame.openplatform.behavior.a r18 = (com.bytedance.android.live.broadcastgame.openplatform.behavior.a) r17;
        if (r18 == null) goto L50;
        r18.b = r33;
    L50:
        if (r7 == null) goto L138;
        int r19 = GameDataReportHelper.a;
        u r21 = r31.D.i();
        if (r33 == null) goto L56;
        OpenFeatureIconCallbackFrom r3 = r33.a;
        if (r3 == null) goto L56;
        String r22 = r3.getValue();
    L57:
        GameDataReportHelper.b(r21, r22);
        int r23 = d20.a.a;
        u r24 = r31.D.i();
        Intrinsics.checkNotNullParameter(r24, "item");
        int r25 = r24.interactId;
        if (r25 != InteractID.Adventure.getValue()) goto L68;
        LinkedHashMap r26 = new LinkedHashMap();
        d20.a.a(r26);
        r26.put("request_page", "interact_panel");
        IUserService r27 = jc1.k.f(IUserService.class);
        if (r27 == null) goto L65;
        com.bytedance.android.livesdk.user.f r28 = r27.user();
        if (r28 == null) goto L65;
        String r34 = r28.n();
        if (r34 == null) goto L65;
    L66:
        r26.put("user_id", r34);
        r26.put("user_type", "anchor");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_room_meetgame_icon_click", r26, new Object[]{Room.class});
    L112:
        if ((r7 instanceof com.bytedance.android.live.broadcastgame.openplatform.behavior.a) == false) goto L114;
        String r35 = r31.w;
        Intrinsics.checkNotNullParameter(r35, "<set-?>");
        ((com.bytedance.android.live.broadcastgame.openplatform.behavior.a) r7).a = r35;
    L114:
        r7.onClick(r29);
        if (((Boolean) ud0.a.getValue()).booleanValue() == false) goto L126;
        InteractEntranceCell r2 = r31.D;
        if (r2 == null) goto L126;
        int r36 = n.a;
        r r37 = r2.e();
        if (r37 == null) goto L124;
        String r38 = r37.b();
        if (r38 == null) goto L124;
        String r110 = r38;
    L125:
        InteractEntranceCell r39 = r31.D;
        String r41 = r39.title;
        InteractID.a r42 = InteractID.Companion;
        int r43 = r39.interactType;
        r42.getClass();
        InteractID r111 = InteractID.a.b(r43);
        InteractEntranceCell r44 = r31.D;
        n.d(true, r110, r41, r111, r44.groupType, r44.d, r44.g(), Integer.valueOf(r32), r31.w, null, 0);
    L124:
        r110 = "";
    L126:
        InteractID.a r45 = InteractID.Companion;
        int r46 = ((ExtendedToolbarButton.c) r31).k;
        r45.getClass();
        InteractID r47 = InteractID.a.b(r46);
        Intrinsics.checkNotNullParameter(r47, "$this$isOpenFeatureMutex");
        if (SetsKt.setOf(new InteractID[]{InteractID.EffectGame, InteractID.DrawSth, InteractID.OpenGame, InteractID.OpenMicroApp, InteractID.SonicMiniGame, InteractID.InteractLoki, InteractID.InteractGamePlus, InteractID.InteractMiniApp, InteractID.OpenMicroGame}).contains(r47) == true) goto L130;
        this.f.dismissContainer();
        return;
    L130:
        u r48 = ((IInteractGameService) jc1.k.n(IInteractGameService.class)).getCurrentPlayingGame();
        if (r48 == null) goto L133;
        String r49 = r48.e();
    L135:
        if (Intrinsics.areEqual(r49, ((ExtendedToolbarButton.c) r31).s) == false) goto L143;
        this.f.dismissContainer();
        return;
    L143:
        return;
    L133:
        r49 = null;
    L65:
        r34 = "0";
        goto L66
    L68:
        if (r25 != InteractID.DynamicItem.getValue()) goto L73;
        String r51 = (String) ((Map) xp.a.getValue()).get(r24.name);
        if (r51 == null) goto L112;
        LinkedHashMap r52 = new LinkedHashMap();
        r52.put("playmode_type", r51);
        r52.put("source", "interaction_button");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_function_interact_playmode_panel_item_click", r52, new Object[]{Room.class});
        goto L112
    L73:
        if (r25 != InteractID.RevenueGameEffect.getValue()) goto L75;
    L107:
        String r53 = (String) ((Map) hn0.a.getValue()).get(Integer.valueOf(r24.interactId));
        if (r53 != null) goto L110;
        r53 = "19";
    L110:
        LinkedHashMap r54 = new LinkedHashMap();
        r54.put("playmode_type", r53);
        r54.put("source", "interaction_button");
        r54.put("user_type", "anchor");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_function_interact_playmode_panel_item_click", r54, new Object[]{Room.class});
        goto L112
    L75:
        if (r25 == InteractID.RevenueGameEffectDynamic.getValue()) goto L107;
        if (r25 != InteractID.SonicMiniGame.getValue()) goto L112;
        r r55 = r24.c();
        if (r55 == null) goto L82;
        int r56 = r55.g();
    L83:
        IInteractService r57 = jc1.k.f(IInteractService.class);
        if (r57 != null) goto L86;
    L90:
        boolean r58 = false;
    L91:
        if (r58 == false) goto L112;
        IInteractService r59 = jc1.k.f(IInteractService.class);
        if (r59 == null) goto L112;
        com.bytedance.android.live.liveinteract.utils.m r61 = r59.getLinkMicGameLogUtils();
        if (r61 == null) goto L112;
        r r62 = r24.c();
        if (r62 == null) goto L100;
        String r63 = r62.b();
        if (r63 == null) goto L100;
    L101:
        r r64 = r24.c();
        if (r64 == null) goto L105;
        String r65 = r64.q();
        if (r65 == null) goto L105;
    L106:
        int r112 = n.a;
        r61.e(r63, r65, n.l(r24.groupType, r24.c, false));
    L105:
        r65 = "";
    L100:
        r63 = "";
        goto L101
    L86:
        if (r57.isTalkRoomLoaded() != true) goto L90;
        if (r56 != 4) goto L90;
        r58 = true;
        goto L91
    L82:
        r56 = 0;
    L56:
        r22 = null;
        goto L57
    L138:
        com.bytedance.android.live.broadcastgame.opengame.utils.i.c("behavior 为 null，无法点击");
        return;
    L46:
        r17 = r7;
        goto L47
    L40:
        r13 = r7;
        goto L41
    L33:
        r9 = r7;
        goto L34
    L29:
        r7 = null;
        goto L31
    L140:
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        throw null;
    L6:
        if (((ExtendedToolbarButton.c) r31).r == true) goto L8;
    L10:
        int r66 = 8;
    L11:
        r4.setVisibility(r66);
        goto L12
    L8:
        if (h3.a(r31.f()) == true) goto L10;
        r66 = 0;
        goto L11
    }
}
