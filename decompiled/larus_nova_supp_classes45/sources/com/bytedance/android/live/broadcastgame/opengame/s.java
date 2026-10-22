package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.f0;
import com.bytedance.android.live.broadcastgame.opengame.control.out_report.OpenGameReportDialog;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.x;
import com.bytedance.android.live.broadcastgame.opengame.panel.FullScreenOpenPanel;
import com.bytedance.android.live.broadcastgame.opengame.test.OpenGameTestHelper;
import com.bytedance.android.live.broadcastgame.openplatform.behavior.ToolbarOpenPlatformBehavior;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.LiveOpenFeaturePanelViewModel;
import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.broadcastgame.xplay.XplayGlobalServiceImpl;
import com.bytedance.android.live.broadcastgame.xplay.perf.XplayPerfPanelView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.LiveRealStartEvent;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements f0 {
    public WeakReference<com.bytedance.android.live.broadcastgame.api.openplatform.b> a;
    public Disposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ s a;
        public final /* synthetic */ Function0 b;

        public a(s r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            LiveRealStartEvent r4 = (LiveRealStartEvent) r3;
            if (Intrinsics.areEqual(r4.mEnterFrom, "toybox") == true) goto L5;
            return;
        L5:
            if (r4.isVerified() == false) goto L12;
            Disposable r5 = this.a.b;
            if (r5 == null) goto L9;
            r5.dispose();
        L9:
            this.b.invoke();
            return;
        }
    }

    public static final class b<T> implements SingleOnSubscribe {
        public final /* synthetic */ Context a;
        public final /* synthetic */ DataCenter b;
        public final /* synthetic */ u c;

        public static final class a implements com.bytedance.android.live.broadcastgame.opengame.view.e {
            public final /* synthetic */ SingleEmitter a;

            @Override // com.bytedance.android.live.broadcastgame.opengame.view.e
            public final void onDismiss() {
                this.a.onSuccess(Boolean.FALSE);
            }

            public a(SingleEmitter r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.live.broadcastgame.opengame.view.e
            public final void a(boolean r2) {
                this.a.onSuccess(Boolean.valueOf(r2));
            }

            @Override // com.bytedance.android.live.broadcastgame.opengame.view.e
            public final void onError(String r3) {
                Intrinsics.checkNotNullParameter(r3, "reason");
                this.a.onError(new Exception(r3));
            }
        }

        public b(Context r1, DataCenter r2, u r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(SingleEmitter<Boolean> r6) {
            Intrinsics.checkNotNullParameter(r6, "emitter");
            int r0 = com.bytedance.android.live.broadcastgame.opengame.view.i.j;
            Context r1 = this.a;
            DataCenter r2 = this.b;
            u r3 = this.c;
            com.bytedance.android.live.broadcastgame.opengame.utils.g r4 = com.bytedance.android.live.broadcastgame.opengame.utils.g.a;
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "dataCenter");
            Intrinsics.checkNotNullParameter(r3, "gameItem");
            Intrinsics.checkNotNullParameter(r4, "gameManager");
            new com.bytedance.android.live.broadcastgame.opengame.view.i(r1, r2, r3, r4).d(new a(r6));
        }
    }

    public s() {
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final com.bytedance.android.live.broadcastgame.opengame.test.c e() {
        return new com.bytedance.android.live.broadcastgame.opengame.test.c();
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final OpenGameTestHelper g() {
        return new OpenGameTestHelper();
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final List<Class<?>> getAllOpenPlatformActivity() {
        return CollectionsKt.listOf(FullScreenOpenPanel.class);
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final com.bytedance.android.live.broadcastgame.opengame.behavior.b h() {
        return new com.bytedance.android.live.broadcastgame.opengame.behavior.b(y3.e());
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final com.bytedance.android.live.broadcastgame.opengame.behavior.c j() {
        return new com.bytedance.android.live.broadcastgame.opengame.behavior.c();
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final void getOpenGameClient() {
        x r0 = x.a;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final void getXplayGlobalService() {
        LinkedHashSet<com.bytedance.android.live.broadcastgame.api.xplay.f> r0 = XplayGlobalServiceImpl.a;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final void addItemToDataCacheHelper(String r4) {
        Intrinsics.checkNotNullParameter(r4, "appId");
        List<String> r0 = d20.b.a;
        Intrinsics.checkNotNullParameter(r4, "id");
        List<String> r1 = d20.b.a;
        ArrayList r2 = (ArrayList) r1;
        if (r2.contains(r4) == false) goto L5;
        r2.remove(r4);
    L5:
        ListProtector.add(r1, 0, r4);
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final void closeOpenPlatformGame(String r4) {
        Intrinsics.checkNotNullParameter(r4, "schema");
        WeakReference<com.bytedance.android.live.broadcastgame.api.openplatform.b> r1 = this.a;
        if (r1 == null) goto L23;
        com.bytedance.android.live.broadcastgame.api.openplatform.b r2 = r1.get();
        if (r2 == null) goto L26;
        int r3 = OpenOpenPlatformGameUtils.a;
        Intrinsics.checkNotNullParameter(r2, "pluginManager");
        Intrinsics.checkNotNullParameter(r4, "schema");
        if (StringsKt.isBlank(r4) == false) goto L10;
        r2.b("game_promote");
        return;
    L10:
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.n<i0> r5 = r0.getCurrentOpenPlatformAppInfo();
        if (r5 == null) goto L18;
        i0 r6 = (i0) r5.getValue();
        if (r6 == null) goto L18;
        String r7 = r6.b;
        if (r7 == null) goto L18;
    L20:
        if (p.a(r4, r7) == true) goto L25;
        r2.b("game_promote");
        return;
    L25:
        return;
    L18:
        r7 = "";
        goto L20
    L26:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final XplayPerfPanelView d(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "containerView");
        m20.a r0 = XplayPerfPanelView.o;
        Intrinsics.checkNotNullParameter(r6, KtvSubElement.CONTAINER);
        XplayPerfPanelView r1 = new XplayPerfPanelView(r6.getContext(), null, 6, 0);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-2, -2);
        r2.topMargin = s1.f(180.0f);
        r2.rightMargin = s1.f(10.0f);
        r2.gravity = 8388613;
        Unit r3 = Unit.INSTANCE;
        r6.addView(r1, r2);
        return r1;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final String decryptUserInfo(String r6) {
        Intrinsics.checkNotNullParameter(r6, "cipherText");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L9;
        Long r3 = Long.valueOf(r2.getRoomId());
    L10:
        WeakReference<com.bytedance.android.live.broadcastgame.api.openplatform.b> r4 = this.a;
        if (r4 == null) goto L15;
        com.bytedance.android.live.broadcastgame.api.openplatform.b r5 = r4.get();
        if (r5 == null) goto L15;
        String r7 = r5.h();
    L16:
        if (r3 == null) goto L26;
        if (r7 == null) goto L26;
        if (r6.length() != 0) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == true) goto L26;
        int r9 = com.bytedance.android.live.broadcastgame.opengame.utils.f.a;
        return com.bytedance.android.live.broadcastgame.opengame.utils.f.b(r6, r3.longValue(), r7);
    L21:
        r8 = false;
    L26:
        return null;
    L15:
        r7 = null;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final void deleteData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        List<String> r0 = d20.b.a;
        Intrinsics.checkNotNullParameter(r2, "id");
        ((ArrayList) d20.b.a).remove(r2);
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final void preloadOpenPlatformGame(String r3) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return;
    L5:
        int r1 = OpenOpenPlatformGameUtils.a;
        Intrinsics.checkNotNullParameter(r3, "schema");
        com.bytedance.bdp.live.livecontainer.sonicgame.a r0 = ma4.c.b;
        if (r0 == null) goto L9;
        r0.b(r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final com.bytedance.android.live.broadcastgame.openplatform.behavior.a a(u r2, mh1.p r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return new com.bytedance.android.live.broadcastgame.openplatform.behavior.a(r2, r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final Disposable openCertificatePage(Context r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "onCertificate");
        ILiveService r0 = TTLiveService.getLiveService();
        String r1 = "https://webcast.amemv.com/falcon/webcast_douyin/page/certification/index.html?hide_nav_bar=1&__live_platform__=webcast";
        if (r0 == null) goto L8;
        String r2 = (String) r0.getLiveSettingValue("live_verify_url", "https://webcast.amemv.com/falcon/webcast_douyin/page/certification/index.html?hide_nav_bar=1&__live_platform__=webcast");
        if (r2 == null) goto L8;
        r1 = r2;
    L8:
        String r3 = r1.concat("&enter_from=toybox");
        jc1.k.n(IHostAction.class).openLiveBrowser(r3, new Bundle(), r4);
        Disposable r6 = this.b;
        if (r6 == null) goto L11;
        r6.dispose();
    L11:
        Disposable r7 = RxUtilKt.h(xs2.b.a().b(LiveRealStartEvent.class)).subscribe(new a(this, r5));
        this.b = r7;
        return r7;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final void openOpenPlatformGame(String r33, Map<String, ? extends Object> r34) {
        Intrinsics.checkNotNullParameter(r33, "schema");
        Intrinsics.checkNotNullParameter(r34, "startParmaMap");
        WeakReference<com.bytedance.android.live.broadcastgame.api.openplatform.b> r3 = this.a;
        if (r3 == null) goto L331;
        com.bytedance.android.live.broadcastgame.api.openplatform.b r4 = r3.get();
        if (r4 == null) goto L337;
        int r5 = OpenOpenPlatformGameUtils.a;
        Intrinsics.checkNotNullParameter(r4, "pluginManager");
        Intrinsics.checkNotNullParameter(r33, "schema");
        Intrinsics.checkNotNullParameter(r34, "startParmaMap");
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L12;
        Room r6 = (Room) r2.getValue();
    L14:
        if (r6 != null) goto L16;
        ALogger.i("OpenPlatformService", "room is empty");
        return;
    L16:
        int r7 = com.bytedance.android.live.broadcastgame.opengame.utils.e.a;
        Intrinsics.checkNotNullParameter(r34, "params");
        int r8 = com.bytedance.android.live.broadcastgame.opengame.utils.k.b;
        Iterator r9 = CollectionsKt.listOf(new com.bytedance.android.live.broadcastgame.opengame.utils.k[]{com.bytedance.android.live.broadcastgame.opengame.utils.k.e.c, com.bytedance.android.live.broadcastgame.opengame.utils.k.d.c, com.bytedance.android.live.broadcastgame.opengame.utils.k.a.c, com.bytedance.android.live.broadcastgame.opengame.utils.k.g.c, com.bytedance.android.live.broadcastgame.opengame.utils.k.C0089k.c, com.bytedance.android.live.broadcastgame.opengame.utils.k.f.c, com.bytedance.android.live.broadcastgame.opengame.utils.k.j.c, com.bytedance.android.live.broadcastgame.opengame.utils.k.i.c, com.bytedance.android.live.broadcastgame.opengame.utils.k.c.c}).iterator();
    L18:
        if (r9.hasNext() == false) goto L26;
        com.bytedance.android.live.broadcastgame.opengame.utils.k r11 = (com.bytedance.android.live.broadcastgame.opengame.utils.k) r9.next();
        Object r13 = r34.get(r11.a);
        if (r13 == null) goto L25;
        if ((r13 instanceof String) == false) goto L18;
        if (StringsKt.isBlank((CharSequence) r13) == false) goto L18;
    L25:
        ALogger.i("OpenPlatformService", "checkParams " + r11.a + " is " + r13);
        boolean r12 = false;
    L27:
        if (r12 == false) goto L29;
        ALogger.i("OpenPlatformService", "checkParams fail");
    L29:
        RoomContext r14 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r14 == null) goto L36;
        com.bytedance.live.datacontext.i r15 = r14.isAnchor();
        if (r15 == null) goto L36;
        if (((Boolean) r15.getValue()).booleanValue() != true) goto L36;
        boolean r16 = true;
    L37:
        String r23 = "null";
        if (r16 == false) goto L209;
        int r17 = com.bytedance.android.live.broadcastgame.opengame.utils.e.a;
        com.bytedance.android.live.broadcastgame.opengame.utils.k.a r18 = com.bytedance.android.live.broadcastgame.opengame.utils.k.a.c;
        if (r34.containsKey(OpenPlatformBaseDebugger.APP_ID) == true) goto L42;
        ALogger.i("CheckOpenParamsUtils", "start params has no app_id");
    L49:
        Object r19 = null;
    L50:
        String r110 = (String) r19;
        if (r110 == null) goto L338;
        InteractGameContext r21 = InteractGameContext.Companion.getContext();
        if (r21 == null) goto L60;
        com.bytedance.live.datacontext.n<i0> r22 = r21.getCurrentOpenPlatformAppInfo();
        if (r22 == null) goto L60;
        i0 r24 = (i0) r22.getValue();
        if (r24 == null) goto L60;
        String r25 = r24.b;
    L62:
        if (Intrinsics.areEqual(r25, r110) == false) goto L64;
        UtilityKotlinExtentionsKt.s(120, false, false, OpenOpenPlatformGameUtils$openOpenPlatformGameByAnchor$1.INSTANCE, 6);
        return;
    L64:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.d r26 = com.bytedance.android.live.broadcastgame.opengame.utils.k.d.c;
        if (r34.containsKey("game_id") == true) goto L67;
        ALogger.i("CheckOpenParamsUtils", "start params has no game_id");
    L74:
        Object r27 = null;
    L75:
        String r28 = (String) r27;
        if (r28 == null) goto L80;
        Long r29 = StringsKt.toLongOrNull(r28);
        if (r29 == null) goto L80;
        long r111 = r29.longValue();
    L81:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.e r31 = com.bytedance.android.live.broadcastgame.opengame.utils.k.e.c;
        if (r34.containsKey("game_name") == true) goto L84;
        ALogger.i("CheckOpenParamsUtils", "start params has no game_name");
    L91:
        Object r32 = null;
    L92:
        String r35 = (String) r32;
        if (r35 != null) goto L95;
        r35 = "";
    L95:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.g r36 = com.bytedance.android.live.broadcastgame.opengame.utils.k.g.c;
        if (r34.containsKey("icon") == true) goto L98;
        ALogger.i("CheckOpenParamsUtils", "start params has no icon");
    L105:
        Object r37 = null;
    L106:
        String r38 = (String) r37;
        if (r38 != null) goto L109;
        r38 = "";
    L109:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.C0089k r39 = com.bytedance.android.live.broadcastgame.opengame.utils.k.C0089k.c;
        if (r34.containsKey("version") == true) goto L112;
        ALogger.i("CheckOpenParamsUtils", "start params has no version");
    L119:
        Object r41 = null;
    L120:
        String r42 = (String) r41;
        int r112 = com.bytedance.android.live.broadcastgame.opengame.utils.k.h.c;
        if (r34.containsKey("is_scan") == true) goto L123;
        ALogger.i("CheckOpenParamsUtils", "start params has no is_scan");
    L130:
        Object r113 = null;
    L131:
        Boolean r114 = (Boolean) r113;
        if (r114 == null) goto L134;
        boolean r115 = r114.booleanValue();
    L135:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.j r116 = com.bytedance.android.live.broadcastgame.opengame.utils.k.j.c;
        String r117 = "support_live_scene";
        if (r34.containsKey("support_live_scene") == true) goto L138;
        ALogger.i("CheckOpenParamsUtils", "start params has no support_live_scene");
        boolean r118 = r115;
    L145:
        Object r119 = null;
    L146:
        List r120 = (List) r119;
        if (r120 == null) goto L149;
        List r121 = r120.subList(0, r120.size());
    L150:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.c r122 = com.bytedance.android.live.broadcastgame.opengame.utils.k.c.c;
        if (r34.containsKey("extra") == true) goto L153;
        ALogger.i("CheckOpenParamsUtils", "start params has no extra");
    L159:
        Object r123 = null;
    L160:
        String r124 = (String) r123;
        LinkedHashMap r43 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r0 = r34.entrySet().iterator();
    L162:
        if (r0.hasNext() == false) goto L164;
        Map.Entry<String, ? extends Object> r44 = r0.next();
        r43.put(r44.getKey(), r44.getValue());
        goto L162
    L164:
        r43.put("OPEN_APP_ICON_URL", r38);
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L204
        HashMap r46 = new HashMap();     // Catch: Throwable -> L204
        if (r124 != null) goto L168;
    L171:
        boolean r47 = true;
    L172:
        if (r47 == true) goto L178;
        JSONObject r48 = new JSONObject(r124);     // Catch: Throwable -> L204
        Intrinsics.checkNotNullParameter(r48, "$this$toMap");     // Catch: Throwable -> L204
        HashMap r49 = new HashMap();     // Catch: Throwable -> L204
        Iterator<String> r125 = r48.keys();     // Catch: Throwable -> L204
    L175:
        if (r125.hasNext() == false) goto L177;
        String r126 = r125.next();     // Catch: Throwable -> L204
        r49.put(r126, r48.get(r126));     // Catch: Throwable -> L204
        r125 = r125;
        goto L175
    L177:
        r46 = r49;
    L178:
        u r127 = new u(0, null, null, null, 127);     // Catch: Throwable -> L204
        r127.name = r35;     // Catch: Throwable -> L204
        r127.iconUrl = CollectionsKt.listOf(r38);     // Catch: Throwable -> L204
        JSONObject r51 = new JSONObject(r46);     // Catch: Throwable -> L204
        com.bytedance.android.live.broadcastgame.opengame.utils.k.d r52 = com.bytedance.android.live.broadcastgame.opengame.utils.k.d.c;     // Catch: Throwable -> L204
        r51.put("game_id", r111);     // Catch: Throwable -> L204
        com.bytedance.android.live.broadcastgame.opengame.utils.k.e r53 = com.bytedance.android.live.broadcastgame.opengame.utils.k.e.c;     // Catch: Throwable -> L204
        r51.put("game_name", r35);     // Catch: Throwable -> L204
        com.bytedance.android.live.broadcastgame.opengame.utils.k.C0089k r54 = com.bytedance.android.live.broadcastgame.opengame.utils.k.C0089k.c;     // Catch: Throwable -> L204
        r51.put("version", r42);     // Catch: Throwable -> L204
        com.bytedance.android.live.broadcastgame.opengame.utils.k.a r55 = com.bytedance.android.live.broadcastgame.opengame.utils.k.a.c;     // Catch: Throwable -> L204
        r51.put(OpenPlatformBaseDebugger.APP_ID, r110);     // Catch: Throwable -> L204
        com.bytedance.android.live.broadcastgame.opengame.utils.k.j r56 = com.bytedance.android.live.broadcastgame.opengame.utils.k.j.c;     // Catch: Throwable -> L204
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L195
        List r58 = r121;     // Catch: Throwable -> L195
        if (r58 != null) goto L182;
    L185:
        boolean r128 = true;
    L186:
        if (r128 == true) goto L192;
        Object r59 = r121.toArray(new Integer[0]);     // Catch: Throwable -> L195
        if (r59 == null) goto L191;
    L193:
        Object r61 = Result.constructor-impl(r59);     // Catch: Throwable -> L195
    L198:
        if (Result.isFailure-impl(r61) == false) goto L200;
        r61 = null;
    L200:
        if (r61 != null) goto L202;
        r61 = new JSONArray();     // Catch: Throwable -> L204
    L202:
        r51.put(r117, r61);     // Catch: Throwable -> L204
        Unit r62 = Unit.INSTANCE;     // Catch: Throwable -> L204
        r127.extra = r51.toString();     // Catch: Throwable -> L204
        r43.put("game", r127);     // Catch: Throwable -> L204
        OpenOpenPlatformGameUtils.a();     // Catch: Throwable -> L204
        r4.i(r111, r110, r33, r43, r118, true);     // Catch: Throwable -> L204
        Object r63 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L204
    L206:
        Throwable r64 = Result.exceptionOrNull-impl(r63);
        if (r64 == null) goto L334;
        int r65 = q.a;
        q.g(String.valueOf(r64.getMessage()), "openOpenPlatformGameByAnchor");
        return;
    L334:
        return;
    L191:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L195
    L192:
        r59 = new JSONArray();     // Catch: Throwable -> L195
        goto L193
    L182:
        if (r58.isEmpty() == true) goto L185;
        r128 = false;
    L195:
        th = move-exception;
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L204
        r61 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L204
        goto L198
    L168:
        if (StringsKt.isBlank(r124) == true) goto L171;
        r47 = false;
    L204:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        r63 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L206
    L153:
        r123 = r34.get("extra");
        if ((r123 instanceof String) == true) goto L160;
        if (r123 == null) goto L158;
        r23 = Reflection.getOrCreateKotlinClass(r123.getClass()).toString();
    L158:
        ALogger.i("CheckOpenParamsUtils", "start params extra type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r23);
        goto L159
    L149:
        r121 = null;
        goto L150
    L138:
        r119 = r34.get("support_live_scene");
        r118 = r115;
        if ((r119 instanceof List) == false) goto L141;
        r117 = "support_live_scene";
        goto L146
    L141:
        if (r119 == null) goto L143;
        String r129 = Reflection.getOrCreateKotlinClass(r119.getClass()).toString();
    L144:
        ALogger.i("CheckOpenParamsUtils", "start params support_live_scene type error : need" + Reflection.getOrCreateKotlinClass(List.class) + " but is " + r129);
        goto L145
    L143:
        r129 = "null";
        goto L144
    L134:
        r115 = false;
        goto L135
    L123:
        r113 = r34.get("is_scan");
        if ((r113 instanceof Boolean) == true) goto L131;
        if (r113 == null) goto L128;
        String r130 = Reflection.getOrCreateKotlinClass(r113.getClass()).toString();
    L129:
        ALogger.i("CheckOpenParamsUtils", "start params is_scan type error : need" + Reflection.getOrCreateKotlinClass(Boolean.class) + " but is " + r130);
        goto L130
    L128:
        r130 = "null";
        goto L129
    L112:
        r41 = r34.get("version");
        if ((r41 instanceof String) == true) goto L120;
        if (r41 == null) goto L117;
        String r68 = Reflection.getOrCreateKotlinClass(r41.getClass()).toString();
    L118:
        ALogger.i("CheckOpenParamsUtils", "start params version type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r68);
        goto L119
    L117:
        r68 = "null";
        goto L118
    L98:
        r37 = r34.get("icon");
        if ((r37 instanceof String) == true) goto L106;
        if (r37 == null) goto L103;
        String r69 = Reflection.getOrCreateKotlinClass(r37.getClass()).toString();
    L104:
        ALogger.i("CheckOpenParamsUtils", "start params icon type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r69);
        goto L105
    L103:
        r69 = "null";
        goto L104
    L84:
        r32 = r34.get("game_name");
        if ((r32 instanceof String) == true) goto L92;
        if (r32 == null) goto L89;
        String r71 = Reflection.getOrCreateKotlinClass(r32.getClass()).toString();
    L90:
        ALogger.i("CheckOpenParamsUtils", "start params game_name type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r71);
        goto L91
    L89:
        r71 = "null";
    L80:
        r111 = 0;
        goto L81
    L67:
        r27 = r34.get("game_id");
        if ((r27 instanceof String) == true) goto L75;
        if (r27 == null) goto L72;
        String r72 = Reflection.getOrCreateKotlinClass(r27.getClass()).toString();
    L73:
        ALogger.i("CheckOpenParamsUtils", "start params game_id type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r72);
        goto L74
    L72:
        r72 = "null";
    L60:
        r25 = null;
        goto L62
    L338:
        return;
    L42:
        r19 = r34.get(OpenPlatformBaseDebugger.APP_ID);
        if ((r19 instanceof String) == true) goto L50;
        if (r19 == null) goto L47;
        String r73 = Reflection.getOrCreateKotlinClass(r19.getClass()).toString();
    L48:
        ALogger.i("CheckOpenParamsUtils", "start params app_id type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r73);
        goto L49
    L47:
        r73 = "null";
        goto L48
    L209:
        int r131 = com.bytedance.android.live.broadcastgame.opengame.utils.e.a;
        com.bytedance.android.live.broadcastgame.opengame.utils.k.a r132 = com.bytedance.android.live.broadcastgame.opengame.utils.k.a.c;
        if (r34.containsKey(OpenPlatformBaseDebugger.APP_ID) == true) goto L212;
        ALogger.i("CheckOpenParamsUtils", "start params has no app_id");
    L219:
        Object r74 = null;
    L220:
        String r75 = (String) r74;
        if (r75 == null) goto L339;
        com.bytedance.android.live.broadcastgame.opengame.utils.k.d r76 = com.bytedance.android.live.broadcastgame.opengame.utils.k.d.c;
        if (r34.containsKey("game_id") == true) goto L226;
        ALogger.i("CheckOpenParamsUtils", "start params has no game_id");
    L233:
        Object r77 = null;
    L234:
        String r78 = (String) r77;
        if (r78 == null) goto L239;
        Long r79 = StringsKt.toLongOrNull(r78);
        if (r79 == null) goto L239;
        long r133 = r79.longValue();
    L240:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.e r81 = com.bytedance.android.live.broadcastgame.opengame.utils.k.e.c;
        if (r34.containsKey("game_name") == true) goto L243;
        ALogger.i("CheckOpenParamsUtils", "start params has no game_name");
    L250:
        Object r82 = null;
    L251:
        String r83 = (String) r82;
        if (r83 != null) goto L254;
        String r134 = "";
    L255:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.g r84 = com.bytedance.android.live.broadcastgame.opengame.utils.k.g.c;
        if (r34.containsKey("icon") == true) goto L258;
        ALogger.i("CheckOpenParamsUtils", "start params has no icon");
    L265:
        Object r85 = null;
    L266:
        String r86 = (String) r85;
        if (r86 != null) goto L269;
        String r135 = "";
    L270:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.C0089k r87 = com.bytedance.android.live.broadcastgame.opengame.utils.k.C0089k.c;
        if (r34.containsKey("version") == true) goto L273;
        ALogger.i("CheckOpenParamsUtils", "start params has no version");
    L280:
        Object r88 = null;
    L281:
        String r89 = (String) r88;
        if (r89 != null) goto L284;
        String r91 = "";
    L285:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.f r92 = com.bytedance.android.live.broadcastgame.opengame.utils.k.f.c;
        if (r34.containsKey("game_type") == true) goto L288;
        ALogger.i("CheckOpenParamsUtils", "start params has no game_type");
    L295:
        Object r93 = null;
    L296:
        Integer r94 = (Integer) r93;
        if (r94 == null) goto L299;
        int r210 = r94.intValue();
    L300:
        com.bytedance.android.live.broadcastgame.opengame.utils.k.i r95 = com.bytedance.android.live.broadcastgame.opengame.utils.k.i.c;
        if (r34.containsKey("launch_from") == true) goto L303;
        ALogger.i("CheckOpenParamsUtils", "start params has no launch_from");
    L309:
        Object r96 = null;
    L310:
        String r97 = (String) r96;
        if (r97 != null) goto L313;
        r97 = "other";
    L313:
        com.bytedance.android.live.broadcastgame.api.openplatform.b r98 = r4;
        if ((r98 instanceof AudiencePluginManager) == true) goto L316;
        r98 = null;
    L316:
        AudiencePluginManager r136 = (AudiencePluginManager) r98;
        if (r136 == null) goto L336;
        com.bytedance.android.live.broadcastgame.api.openplatform.f r137 = new com.bytedance.android.live.broadcastgame.api.openplatform.f("game_promote");
        r137.a = new com.bytedance.android.live.broadcastgame.api.openplatform.f.a(r133, r91, r75, r33, r134, r210, true, r97, r135);
        Unit r99 = Unit.INSTANCE;
        r136.r(r137);
        return;
    L336:
        return;
    L303:
        r96 = r34.get("launch_from");
        if ((r96 instanceof String) == true) goto L310;
        if (r96 == null) goto L308;
        r23 = Reflection.getOrCreateKotlinClass(r96.getClass()).toString();
    L308:
        ALogger.i("CheckOpenParamsUtils", "start params launch_from type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r23);
        goto L309
    L299:
        r210 = 0;
        goto L300
    L288:
        r93 = r34.get("game_type");
        if ((r93 instanceof Integer) == true) goto L296;
        if (r93 == null) goto L293;
        String r100 = Reflection.getOrCreateKotlinClass(r93.getClass()).toString();
    L294:
        ALogger.i("CheckOpenParamsUtils", "start params game_type type error : need" + Reflection.getOrCreateKotlinClass(Integer.class) + " but is " + r100);
        goto L295
    L293:
        r100 = "null";
        goto L294
    L284:
        r91 = r89;
        goto L285
    L273:
        r88 = r34.get("version");
        if ((r88 instanceof String) == true) goto L281;
        if (r88 == null) goto L278;
        String r101 = Reflection.getOrCreateKotlinClass(r88.getClass()).toString();
    L279:
        ALogger.i("CheckOpenParamsUtils", "start params version type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r101);
        goto L280
    L278:
        r101 = "null";
        goto L279
    L269:
        r135 = r86;
        goto L270
    L258:
        r85 = r34.get("icon");
        if ((r85 instanceof String) == true) goto L266;
        if (r85 == null) goto L263;
        String r102 = Reflection.getOrCreateKotlinClass(r85.getClass()).toString();
    L264:
        ALogger.i("CheckOpenParamsUtils", "start params icon type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r102);
        goto L265
    L263:
        r102 = "null";
        goto L264
    L254:
        r134 = r83;
        goto L255
    L243:
        r82 = r34.get("game_name");
        if ((r82 instanceof String) == true) goto L251;
        if (r82 == null) goto L248;
        String r103 = Reflection.getOrCreateKotlinClass(r82.getClass()).toString();
    L249:
        ALogger.i("CheckOpenParamsUtils", "start params game_name type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r103);
        goto L250
    L248:
        r103 = "null";
    L239:
        r133 = 0;
        goto L240
    L226:
        r77 = r34.get("game_id");
        if ((r77 instanceof String) == true) goto L234;
        if (r77 == null) goto L231;
        String r104 = Reflection.getOrCreateKotlinClass(r77.getClass()).toString();
    L232:
        ALogger.i("CheckOpenParamsUtils", "start params game_id type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r104);
        goto L233
    L231:
        r104 = "null";
        goto L232
    L339:
        return;
    L212:
        r74 = r34.get(OpenPlatformBaseDebugger.APP_ID);
        if ((r74 instanceof String) == true) goto L220;
        if (r74 == null) goto L217;
        String r105 = Reflection.getOrCreateKotlinClass(r74.getClass()).toString();
    L218:
        ALogger.i("CheckOpenParamsUtils", "start params app_id type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r105);
        goto L219
    L217:
        r105 = "null";
    L36:
        r16 = false;
        goto L37
    L26:
        r12 = true;
    L12:
        r6 = null;
        goto L14
    L337:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final InteractGameFeedbackDialog openOuterGameFeedback(Context r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        InteractGameFeedbackDialog r0 = new InteractGameFeedbackDialog(r11, 0, 0, 2, r12);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
    L7:
        return r0;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final void f(Context r2, String r3, InteractGameService.e r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "appId");
        Intrinsics.checkNotNullParameter(r4, "fetchGameItemCallBack");
        ((LiveOpenFeaturePanelViewModel) ViewModelProviders.of((FragmentActivity) r2).get(LiveOpenFeaturePanelViewModel.class)).getFeatureListHandler().c(r3, new r(r4));
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final Single<Boolean> showOpenGameAuthDialog(Context r2, DataCenter r3, u r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "gameItem");
        return Single.create(new b(r2, r3, r4));
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final ToolbarOpenPlatformBehavior b(Context r2, DataCenter r3, Function2 r4, com.bytedance.android.live.broadcastgame.api.interactgame.g r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "behaviorFactory");
        Intrinsics.checkNotNullParameter(r5, "createFactory");
        return new ToolbarOpenPlatformBehavior(r2, r3, r5, r4);
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final AudiencePluginManager i(Context r8, DataCenter r9, long r11, ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        Intrinsics.checkNotNullParameter(r12, "containerView");
        AudiencePluginManager r0 = new AudiencePluginManager(r8, r9, r11, r12);
        this.a = new WeakReference(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final com.bytedance.android.live.broadcastgame.opengame.a c(com.bytedance.android.live.pushstream.d r9, Context r11, DataCenter r12, long r13, ViewGroup r14) {
        Intrinsics.checkNotNullParameter(r9, "liveStream");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, "containerView");
        com.bytedance.android.live.broadcastgame.opengame.a r0 = new com.bytedance.android.live.broadcastgame.opengame.a(r9, r11, r12, r13, r14);
        this.a = new WeakReference(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.f0
    public final OpenGameReportDialog openOuterGameReport(Context r8, String r9, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, OpenPlatformBaseDebugger.DEVELOP);
        Intrinsics.checkNotNullParameter(r11, "appId");
        Intrinsics.checkNotNullParameter(r12, "appName");
        OpenGameReportDialog r0 = new OpenGameReportDialog(r8, r9, r11, r12, r13);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
    L7:
        return r0;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L7
    }
}
