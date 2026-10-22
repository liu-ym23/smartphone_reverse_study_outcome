package ly;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcast.api.model.z0;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.InitialProps;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.largefont.IHostLargeFontService;
import com.bytedance.android.livesdk.chatroom.utils.g4;
import com.bytedance.android.livesdk.chatroom.utils.x;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.interact.data.FlavorKt;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.TemplateData;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public final float a;
    public final Context b;
    public final DataCenter c;
    public final ViewGroup d;
    public final boolean e;
    public final int f;
    public final com.bytedance.android.live.liveinteract.jsbridge.method.s g;
    public final boolean h;
    public final u i;
    public t j;
    public boolean k;
    public String l;
    public Map<String, String> m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public final ViewGroup s;
    public final CompositeDisposable t;
    public final Map<String, Function1<JsonObject, Unit>> u;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ h a;
        public final /* synthetic */ boolean b;

        public b(h r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            h r0 = this.a;
            boolean r1 = this.b;
            r0.getClass();
            int r2 = s1.y();
            u r3 = r0.i;
            if (r3 == null) goto L7;
            LivePlayerView r4 = r3.R8();
            if (r4 == null) goto L7;
            int r5 = r4.getHeight();
        L9:
            if (r0.e == false) goto L16;
            int r6 = r0.f;
            if (r6 == 3) goto L16;
            if (r6 == 4) goto L16;
            if (r6 == 2) goto L16;
            boolean r7 = false;
        L17:
            if (r7 == false) goto L20;
            if (r5 <= 0) goto L20;
            boolean r8 = true;
        L21:
            if (r8 == true) goto L25;
            r5 = s1.w();
        L25:
            if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.FALSE) == true) goto L27;
            Boolean r11 = (Boolean) r0.c.get("status_bar_is_visible", Boolean.TRUE);
            if (r11 == null) goto L33;
            boolean r12 = r11.booleanValue();
        L35:
            if (r12 == true) goto L38;
            if (r8 == true) goto L38;
            int r9 = StatusBarUtil.getStatusBarHeight(r0.b);
            boolean r13 = iy.b.a;
            iy.b.e("AnchorModeDynamicCardManager", "screenHeight 添加 statusBarHeight:" + r9);
            r5 = r5 + r9;
        L38:
            ViewGroup r14 = r0.d;
            if (r14 == null) goto L41;
            int r15 = r14.getWidth();
        L42:
            ViewGroup r16 = r0.d;
            if (r16 == null) goto L45;
            int r17 = r16.getHeight();
        L46:
            if (r15 == r2) goto L59;
            boolean r18 = ky.a.a;
            int r19 = r0.f;
            if (r19 != 0) goto L50;
            boolean r110 = true;
        L51:
            if (r110 == true) goto L59;
            if (r19 == 2) goto L57;
            if (r19 == 3) goto L57;
            if (r19 == 4) goto L57;
            boolean r21 = false;
        L58:
            if (r21 == true) goto L59;
        L60:
            r0.o = r5;
            r0.p = r2;
            r0.q = r15;
            r0.r = r17;
            boolean r22 = iy.b.a;
            iy.b.e("AnchorModeDynamicCardManager", "loadAndAddCardView screen size：" + r0.p + "--" + r0.o + ",statusBarHeight：" + s1.A());
            StringBuilder r23 = new StringBuilder("loadAndAddCardView container size：");
            r23.append(r0.q);
            r23.append("--");
            r23.append(r0.r);
            iy.b.e("AnchorModeDynamicCardManager", r23.toString());
            t r24 = r0.j;
            View r25 = null;
            if (r24 == null) goto L63;
            ih0.c r26 = r24.d;
        L64:
            StringBuilder r27 = new StringBuilder("loadAndAddCardView canReuse:");
            r27.append(r1);
            r27.append(", hybridCard?.getSelfAsView()=");
            if (r26 == null) goto L67;
            View r111 = r26.S0();
        L68:
            r27.append(r111);
            iy.b.e("AnchorModeDynamicCardManager", r27.toString());
            if (r1 == true) goto L72;
            if (r26 == null) goto L81;
            ih0.c.a.a(r26, r0.a(), r0.b(r2, r5, r15, r17), 1);
        L81:
            if (r26 == null) goto L83;
            r26.J();
        L83:
            boolean r28 = ((Boolean) vm2.e.T.getValue(null, vm2.e.a[44])).booleanValue();
            boolean r29 = jc1.k.n(IInteractService.class).needAdjustScreen(r0.f, r15, r17);
            if (r28 == true) goto L88;
            if (r29 == false) goto L88;
            int r31 = ((Number) jc1.k.n(IInteractService.class).getSizeForXScreenAdjust(0, 5, r15, r17).getFirst()).intValue();
        L89:
            if (r28 == false) goto L91;
            r31 = (r17 * r2) / r5;
            int r32 = r17;
        L92:
            iy.b.e("AnchorModeDynamicCardManager", "resizeCardView adjustWH：" + r31 + '-' + r32 + ";  containerWH:" + r15 + '-' + r17 + "; renderWH: " + r2 + '-' + r5);
            float r33 = 1.0f;
            if (r2 <= 0) goto L95;
            float r112 = r31 / r2;
        L96:
            if (r5 <= 0) goto L98;
            r33 = r32 / r5;
        L98:
            iy.b.e("AnchorModeDynamicCardManager", "resizeCard scaleX:" + r112 + "-scaleY: " + r33);
            if (r2 < r5) goto L102;
            r112 = r33;
        L102:
            t r34 = r0.j;
            if (r34 == null) goto L115;
            ih0.c r35 = r34.d;
            if (r35 == null) goto L115;
            View r36 = r35.S0();
            if (r36 == null) goto L115;
            if ((r0.d instanceof ConstraintLayout) == false) goto L111;
            ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(r2, r5);
        L112:
            r36.setLayoutParams(r113);
            r36.setPivotX(0.0f);
            r36.setPivotY(0.0f);
            r36.setScaleX(r112);
            r36.setScaleY(r112);
            float r37 = (r15 - r31) / 2.0f;
            float r38 = (r17 - r32) / 2.0f;
            iy.b.e("AnchorModeDynamicCardManager", "resizeCard adjustOffsetX:" + r37 + ", adjustOffsetY:" + r38);
            r36.setTranslationX(r37);
            if (r28 == true) goto L115;
            r36.setTranslationY(r38);
            goto L115
        L111:
            r113 = new FrameLayout.LayoutParams(r2, r5);
        L115:
            if (r26 == null) goto L117;
            r25 = r26.S0();
        L117:
            if (r25 == null) goto L122;
            ViewGroup r39 = r0.d;
            if (r39 == null) goto L123;
            r39.addView(r26.S0());
            return;
        L123:
            return;
        L122:
            return;
        L95:
            r112 = 1.0f;
            goto L96
        L91:
            r32 = (r31 * r5) / r2;
        L88:
            r31 = r15;
            goto L89
        L72:
            if (r26 == null) goto L74;
            r26.updateGlobalProps(r0.b(r2, r5, r15, r17));
        L74:
            if (r26 == null) goto L76;
            r26.updateData(r0.a());
        L76:
            JsonObject r41 = new JsonObject();
            if (r0.e == false) goto L79;
            String r42 = FileUtils.FEED_CACHE;
        L80:
            r41.addProperty("to", r42);
            Unit r43 = Unit.INSTANCE;
            r0.h("reuseRoom", r41);
            goto L81
        L79:
            r42 = NewBroadcastMonitor.PAGE.ROOM;
            goto L80
        L67:
            r111 = null;
            goto L68
        L63:
            r26 = null;
        L57:
            r21 = true;
            goto L58
        L50:
            r110 = false;
        L59:
            r17 = r5;
            goto L60
        L45:
            r17 = 0;
            goto L46
        L41:
            r15 = 0;
        L33:
            r12 = true;
            goto L35
        L27:
            if (StatusBarUtil.isStatusBarTransparent() == false) goto L33;
            r12 = false;
        L20:
            r8 = false;
        L16:
            r7 = true;
        L7:
            r5 = 0;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c extends b7.a {
        public final /* synthetic */ h a;
        public final /* synthetic */ long b;

        public final void onLoadSuccess(View r2) {
            super.onLoadSuccess(r2);
            if (vm2.h.P() == false) goto L11;
            t r3 = this.a.j;
            if (r3 == null) goto L11;
            ih0.c r4 = r3.d;
            if (r4 == null) goto L11;
            View r5 = r4.S0();
            if (r5 == null) goto L11;
            UtilityKotlinExtentionsKt.w(r5);
        L11:
            iy.b.e("AnchorModeDynamicCardManager", "main card onLoadSuccess");
        }

        public c(h r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onLoadStart(View r1, boolean r2) {
            super.onLoadStart(r1, r2);
            iy.b.e("AnchorModeDynamicCardManager", "main card onLoadStart");
            iy.b.e("DynamicCenterWrds", "[DynamicCenterCardManager]-hybridCard onLoadStart");
        }

        public final void onLoadFail(View r2, String r3, String r4) {
            super.onLoadFail(r2, r3, r4);
            boolean r5 = iy.b.a;
            iy.b.e("AnchorModeDynamicCardManager", "main card onLoadFail: url=" + r3 + ", reason=" + r4);
            LinkedHashMap<Long, t> r6 = s.a;
            s.a(this.b);
            if (((Boolean) vm2.h.a6.getValue(null, vm2.h.a[363(0x16b, float:5.09E-43)])).booleanValue() == false) goto L7;
            t r7 = this.a.j;
            if (r7 == null) goto L7;
            r7.a();
        L7:
            this.a.j = null;
        }
    }

    static {
    }

    public final Map<String, Object> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        u r1 = this.i;
        JsonObject r2 = null;
        if (r1 == null) goto L5;
        IRoom r3 = r1.getRoom();
    L6:
        u r4 = this.i;
        if (r4 == null) goto L9;
        IBaseUser r5 = r4.getUser();
    L10:
        u r6 = this.i;
        if (r6 == null) goto L14;
        String r7 = r6.n6();
        if (r7 == null) goto L14;
    L15:
        com.bytedance.android.livesdk.chatroom.o r8 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r8 == null) goto L20;
        com.bytedance.live.datacontext.j r9 = r8.s2();
        if (r9 == null) goto L20;
        z0 r11 = (z0) r9.getValue();
    L20:
        boolean r12 = iy.b.a;
        iy.b.e("AnchorModeDynamicCardManager", "getDynamicData room:" + r3 + ", user:" + r5 + ", enterFromMerge:" + r7 + ", isContinueRoom:false");
        if (r3 != null) goto L23;
        return r0;
    L23:
        String r13 = (String) CollectionsKt.firstOrNull(r3.getLinkMap().keySet());
        int r14 = 0;
        if (r13 == null) goto L26;
        int r15 = CastIntegerProtector.parseInt(r13);
    L27:
        iy.b.e("AnchorModeDynamicCardManager", "getDynamicData scene:" + r15);
        r0.put("scene", Integer.valueOf(r15));
        t r16 = this.j;
        if (r16 == null) goto L33;
        com.bytedance.android.live.anchormodelink.handlers.d r17 = r16.a;
        if (r17 == null) goto L33;
        Integer r18 = r17.i;
        if (r18 == null) goto L33;
    L37:
        if (r18 == null) goto L39;
        int r19 = r18.intValue();
    L40:
        r0.put("uilayout", Integer.valueOf(r19));
        r0.put("is_anchor", Boolean.valueOf(je0.d.r()));
        r0.put("is_feed", Boolean.valueOf(this.e));
        int r21 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r22 = MultiSceneEnterRoomStatisticsUtils.a.a(this.c, Long.valueOf(IRoomKtKt.getId((IRoomBase) r3)));
        if (r22 == null) goto L43;
        long r23 = r22.c();
    L44:
        long r110 = System.currentTimeMillis();
        iy.b.e("AnchorModeDynamicCardManager", "getDynamicData startTime: " + r23 + "， currentTime:" + r110 + " diff:" + (r110 - r23));
        r0.put("enter_room_time", Long.valueOf(r23));
        r0.put("enter_from", r7);
        JsonObject r24 = SettingUtil.getGson().toJsonTree(r3).getAsJsonObject();     // Catch: Throwable -> L47
    L49:
        if (r24 == null) goto L51;
        Map r25 = UtilsKt.i(r24);
    L52:
        r0.put("current_room", r25);
        r2 = SettingUtil.getGson().toJsonTree(r5).getAsJsonObject();     // Catch: Throwable -> L55
    L57:
        if (r2 == null) goto L59;
        Map r26 = UtilsKt.i(r2);
    L60:
        r0.put("current_user", r26);
        r0.put("is_preload", Boolean.valueOf(!this.k));
        r0.put("is_revert_live", 0);
        String r27 = this.l;
        if (r27 == null) goto L63;
        r0.put("linkmic_params", r27);
    L63:
        Map<String, String> r28 = this.m;
        if (r28 == null) goto L67;
        r0.put("schema_params", r28);
    L67:
        if (je0.d.r() == false) goto L97;
        s1.f(this.a);
        if (x.a() == false) goto L77;
        IHostBusiness r29 = jc1.k.f(IHostBusiness.class);
        if (r29 == null) goto L75;
        IHostLargeFontService r31 = r29.getLiveLargeFontService();
        if (r31 == null) goto L75;
        float r32 = r31.noZoom(Float.valueOf(this.a));
    L76:
        int r33 = s1.f(r32);
    L79:
        if (this.q > 0) goto L86;
        ViewGroup r34 = this.d;
        if (r34 == null) goto L83;
        int r35 = r34.getWidth();
    L84:
        this.q = r35;
        goto L86
    L83:
        r35 = 0;
    L86:
        if (this.r > 0) goto L92;
        ViewGroup r36 = this.d;
        if (r36 == null) goto L90;
        int r37 = r36.getHeight();
    L91:
        this.r = r37;
        goto L92
    L90:
        r37 = 0;
    L92:
        int r38 = this.r - r33;
        int r39 = this.q;
        if ((r38 / r39) < 1) goto L95;
        int r41 = (r39 * 16) / 9;
        int r42 = (r38 - r41) / 2;
        r38 = r41;
        int r43 = r42;
    L96:
        LinkedHashMap r44 = new LinkedHashMap();
        r44.put("x", Integer.valueOf((int) s1.G(r14)));
        r44.put("y", Integer.valueOf((int) s1.G(r43)));
        r44.put("w", Integer.valueOf((int) s1.G(r39)));
        r44.put("h", Integer.valueOf((int) s1.G(r38)));
        boolean r45 = iy.b.a;
        iy.b.e("AnchorModeDynamicCardManager", "getDynamicData anchorPreviewFrame: " + r44);
        r0.put("anchor_preview_frame", r44);
        goto L97
    L95:
        int r46 = (r38 * 9) / 16;
        r14 = (r39 - r46) / 2;
        r39 = r46;
        r43 = 0;
    L75:
        r32 = this.a;
        goto L76
    L77:
        r33 = s1.f(this.a);
    L97:
        boolean r47 = iy.b.a;
        iy.b.e("AnchorModeDynamicCardManager", "getDynamicData props: " + r0);
        return r0;
    L59:
        r26 = new LinkedHashMap();
    L55:
        th = move-exception;
        ALogger.e("AnchorModeDynamicCardManager", "user to jsonObject error, error: " + th);
        goto L57
    L51:
        r25 = new LinkedHashMap();
    L47:
        th = move-exception;
        ALogger.e("AnchorModeDynamicCardManager", "room to jsonObject error, error: " + th);
        r24 = null;
        goto L49
    L43:
        r23 = 0;
        goto L44
    L39:
        r19 = 0;
    L33:
        z5 r48 = r3.getLinkerDetail();
        if (r48 == null) goto L36;
        r18 = Integer.valueOf(r48.getUiLayout());
        goto L37
    L36:
        r18 = null;
        goto L37
    L26:
        r15 = 0;
    L14:
        r7 = "";
        goto L15
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void f() {
        ALogger.e("AnchorModeDynamicCardManager", "onRecycle--reuseCard=" + this.n);
        ReadOnlyProperty r0 = vm2.h.d6;
        KProperty[] r2 = vm2.h.a;
        if (((Boolean) r0.getValue(null, r2[366(0x16e, float:5.13E-43)])).booleanValue() == false) goto L5;
        this.t.dispose();
    L5:
        t r1 = this.j;
        if (r1 == null) goto L8;
        Integer r3 = Integer.valueOf(r1.e);
    L10:
        if (this.n == true) goto L12;
    L27:
        t r4 = this.j;
        if (r4 == null) goto L30;
        r4.a();
    L30:
        boolean r5 = iy.b.a;
        iy.b.e("AnchorModeDynamicCardManager", "[seiHandler.setOutProvider]  set null isFeed:" + this.e);
        t r6 = this.j;
        if (r6 == null) goto L35;
        com.bytedance.android.live.anchormodelink.handlers.d r7 = r6.a;
        if (r7 == null) goto L35;
        r7.j = null;
    L35:
        this.j = null;
        ((LinkedHashMap) this.u).clear();
        return;
    L12:
        if (d(r3) == false) goto L27;
        t r8 = this.j;
        if (r8 == null) goto L19;
        ih0.c r9 = r8.d;
        if (r9 == null) goto L19;
        r9.J();
    L19:
        if (((Boolean) vm2.h.c6.getValue(null, r2[365(0x16d, float:5.11E-43)])).booleanValue() == false) goto L30;
        t r11 = this.j;
        if (r11 == null) goto L30;
        ih0.c r12 = r11.d;
        if (r12 == null) goto L30;
        View r13 = r12.S0();
        if (r13 == null) goto L30;
        r13.setTag(2131362966, null);
        goto L30
    L8:
        r3 = null;
        goto L10
    }

    public static boolean d(Integer r2) {
        boolean r0 = ky.a.a;
        if (vm2.d.c0().getOnlyReuseCardInFullScreenFeed() == false) goto L18;
        if (r2 != null) goto L7;
    L8:
        if (r2 != null) goto L11;
    L12:
        if (r2 != null) goto L15;
    L17:
        return false;
    L15:
        if (r2.intValue() != 2) goto L17;
    L11:
        if (r2.intValue() == 4) goto L18;
    L7:
        if (r2.intValue() != 3) goto L8;
    L18:
        return true;
    }

    public final void c(com.bytedance.android.scope.j r4) {
        t r0 = this.j;
        ih0.c r1 = null;
        if (r0 == null) goto L5;
        ih0.c r2 = r0.d;
    L7:
        if ((r2 instanceof uh6.a) == false) goto L15;
        iy.b.e("AnchorModeDynamicCardManager", "register aio link");
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r5 = com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(uh6.b.class));
        Intrinsics.checkNotNull(r5);
        uh6.b r6 = (f80.a) r5;
        t r7 = this.j;
        if (r7 == null) goto L11;
        r1 = r7.d;
    L11:
        if (r1 == null) goto L14;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.h((uh6.a) r1, r4), this.t);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.aiolink.service.IAioLinkBridgeExternal");
    L15:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void e(long r41) {
        long r1 = System.currentTimeMillis();
        ((IBrowserService) jc1.k.n(IBrowserService.class)).initAnnie();
        boolean r3 = ky.a.a;
        String r4 = vm2.d.c0().getSchema();
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L12;
        r4 = "sslocal://webcast_lynxview?group=livelinkmic&business_type=livelinkmic&enable_code_cache=true";
    L12:
        if (FlavorKt.isSaas() == false) goto L14;
        r4 = r4 + "&mix_container_type=true";
    L14:
        String r7 = vm2.d.c0().getUrl();
        if (r7 != null) goto L17;
    L21:
        r7 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/dynamic_center_saas/root/template.js";
    L22:
        String r8 = vm2.d.c0().getDebugIp();
        if (r2.a(r8) == false) goto L26;
        r7 = "http://" + r8 + ":9001/pages/root/template.js";
    L26:
        if (v.a() == false) goto L28;
        r7 = r7 + "?enable_debug=true";
    L28:
        Uri.Builder r9 = UriProtector.parse(r7).buildUpon();
        if (FoldScreenUtils.f() == false) goto L31;
        String r11 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L32:
        r9.appendQueryParameter("is_android_fold", r11);
        Uri r5 = UriProtector.parse(r4).buildUpon().appendQueryParameter(LiveSlardarConstants.EXTRA_KEY_URL, r9.build().toString()).build();
        c r12 = new c(this, r41);
        if (this.h == false) goto L35;
    L42:
        boolean r13 = false;
    L43:
        this.n = r13;
        t r14 = s.a.get(Long.valueOf(r41));
        ih0.c r15 = null;
        if (r14 == null) goto L46;
        Boolean r16 = Boolean.valueOf(r14.c);
    L47:
        String r17 = FileUtils.FEED_CACHE;
        if (r16 != null) goto L51;
        String r18 = "empty";
    L54:
        boolean r19 = this.e;
        if (r19 == true) goto L58;
        r17 = NewBroadcastMonitor.PAGE.ROOM;
    L58:
        if (r14 != null) goto L60;
    L62:
        if (r14 == null) goto L69;
        ih0.c r21 = r14.d;
        if (r21 == null) goto L66;
        View r22 = r21.S0();
    L67:
        if (r22 == null) goto L69;
        boolean r23 = true;
    L70:
        boolean r110 = iy.b.a;
        iy.b.e("AnchorModeDynamicCardManager", "实例缓存 poolInstanceCard：" + r14);
        if (r23 == true) goto L73;
        int r111 = g.a;
        Context r112 = this.b;
        DataCenter r113 = this.c;
        Intrinsics.checkNotNullParameter(r112, "context");
        Intrinsics.checkNotNullParameter(r5, "uri");
        Intrinsics.checkNotNullParameter(r12, "commonLifecycle");
        ((IBrowserService) jc1.k.n(IBrowserService.class)).initAnnie();
        u6 r24 = new u6(r5);
        Map r25 = Annie.getService$default(com.bytedance.android.annie.service.network.i.class, null, 2, null).s1();
        u6 r26 = r24.d(LiveSlardarConstants.EXTRA_KEY_URL);
        Iterator r27 = r25.entrySet().iterator();
    L91:
        if (r27.hasNext() == false) goto L102;
        Map.Entry r114 = (Map.Entry) r27.next();
        String r115 = r26.a((String) r114.getKey());
        if (r115 != null) goto L95;
    L98:
        boolean r116 = true;
    L99:
        if (r116 == false) goto L91;
        r26.b((String) r114.getKey(), (String) r114.getValue());
        goto L91
    L95:
        if (r115.length() == 0) goto L98;
        r116 = false;
        goto L99
    L102:
        Uri r28 = r24.c();
        InitialProps r29 = InitialProps.d;
        Uri r31 = r26.c();
        r29.getClass();
        GsonMap r32 = InitialProps.a(r28, r31, r113, true);
        if (r32 == null) goto L105;
        TemplateData r33 = TemplateData.fromMap(MapsKt.mapOf(TuplesKt.to("initialProps", r32)));
    L106:
        String r117 = "AnchorModeDynamicCardManager";
        r15 = null;
        ra.a r34 = com.bytedance.android.anniex.api.d.g(new com.bytedance.android.anniex.api.d("webcast", MapsKt.mapOf(TuplesKt.to("location", r26.toString())), ra.b.b(ra.b.B.c(r28), false, null, null, null, 0, 0, 0.0f, false, false, null, false, CollectionsKt.listOf(new com.lynx.tasm.behavior.a[]{new ly.c(), new d(), new e(), new f()}), null, false, false, false, null, false, 0.0f, 16769023), 8), r28, r33, null, 24);
        com.bytedance.android.anniex.assemble.a r35 = com.bytedance.android.anniex.assemble.a.a;
        AnnieXLynxView r36 = com.bytedance.android.anniex.api.c.a(r112, r34);
        r36.setTag(2131362966, r12);
        r36.addLynxViewClient(new ly.a(r36));
        r36.E(r34, Long.valueOf(r1));
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r2 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c(r36, r34, new ly.b(r12, r5));
        r14 = new t(r2, this.f);
        if (this.n == false) goto L119;
        if (d(Integer.valueOf(this.f)) == false) goto L119;
        LinkedHashMap<Long, t> r37 = s.a;
        Intrinsics.checkNotNullParameter(r14, "hybridCard");
        LinkedHashMap<Long, t> r38 = s.a;
        if (r38.containsKey(Long.valueOf(r41)) == false) goto L113;
        s.a(r41);
    L113:
        r38.put(Long.valueOf(r41), r14);
        if (r38.size() <= 3) goto L119;
        Map.Entry r39 = (Map.Entry) CollectionsKt.firstOrNull(r38.entrySet());
        if (r39 == null) goto L119;
        s.a(((Number) r39.getKey()).longValue());
    L119:
        if (vm2.h.P() == false) goto L123;
        AnnieXLynxView r42 = r2.h;
        if (r42 == null) goto L123;
        UtilityKotlinExtentionsKt.u(r42);
    L123:
        this.j = r14;
        if (r14 == null) goto L126;
        r14.c = this.e;
    L126:
        boolean r43 = iy.b.a;
        iy.b.e(r117, "从" + r18 + " 到" + r17 + "，是否复用了：" + r23);
        t r44 = this.j;
        if (r44 == null) goto L129;
        r15 = r44.d;
    L129:
        if (r15 == null) goto L131;
        r15.r1();
    L131:
        if (r15 == null) goto L133;
        r15.registerMethod("registerMessage", new j(this));
    L133:
        if (r15 == null) goto L135;
        r15.registerMethod("live.unregisterMessage", new k(this));
    L135:
        if (r15 == null) goto L137;
        r15.registerMethod("registerMessageLatch", new l(this));
    L137:
        if (r15 == null) goto L139;
        r15.registerMethod("registerWrds", new m(this));
    L139:
        if (r15 == null) goto L141;
        r15.registerMethod("live.unregisterWrds", new n(this));
    L141:
        if (r15 == null) goto L143;
        r15.registerMethod("reportAggregateALog", o.a);
    L143:
        if (r15 == null) goto L145;
        r15.registerMethod("reportLinkmicStatus", p.a);
    L145:
        if (r15 == null) goto L147;
        r15.registerMethod("getLiveNtpTime", new q(this));
    L147:
        if (r15 == null) goto L149;
        r15.registerMethod("getLinkmicStatus", new r(this));
    L149:
        if (r15 == null) goto L151;
        r15.registerMethod("updateLinkmicStatus", new i(this));
    L151:
        t r45 = this.j;
        if (r45 == null) goto L158;
        ih0.c r46 = r45.d;
        if (r46 == null) goto L158;
        View r47 = r46.S0();
        if (r47 == null) goto L158;
        r47.setBackgroundColor(0);
    L158:
        ViewGroup r48 = this.d;
        if (r48 == null) goto L165;
        r48.post(new b(this, r23));
        return;
    L165:
        return;
    L105:
        r33 = null;
        goto L106
    L73:
        if (vm2.h.P() == false) goto L81;
        if (r14 == null) goto L81;
        ih0.c r49 = r14.d;
        if (r49 == null) goto L81;
        View r51 = r49.S0();
        if (r51 == null) goto L81;
        UtilityKotlinExtentionsKt.w(r51);
    L81:
        if (((Boolean) vm2.h.c6.getValue(null, vm2.h.a[365(0x16d, float:5.11E-43)])).booleanValue() == false) goto L88;
        if (r14 == null) goto L88;
        ih0.c r52 = r14.d;
        if (r52 == null) goto L88;
        View r53 = r52.S0();
        if (r53 == null) goto L88;
        r53.setTag(2131362966, r12);
    L88:
        r117 = "AnchorModeDynamicCardManager";
        goto L123
    L66:
        r22 = null;
    L69:
        r23 = false;
        goto L70
    L60:
        if (Intrinsics.areEqual(Boolean.valueOf(r19), r16) == false) goto L62;
        s.a(r41);
        r14 = null;
        goto L62
    L51:
        if (r16.booleanValue() == false) goto L53;
        r18 = FileUtils.FEED_CACHE;
        goto L54
    L53:
        r18 = NewBroadcastMonitor.PAGE.ROOM;
        goto L54
    L46:
        r16 = null;
        goto L47
    L35:
        if (vm2.d.c0().getReuseCard() != true) goto L37;
        boolean r118 = true;
    L38:
        if (r118 == false) goto L42;
        if (this.l != null) goto L42;
        r13 = true;
        goto L43
    L37:
        r118 = false;
        goto L38
    L31:
        r11 = "0";
        goto L32
    L17:
        if (r7.length() != 0) goto L19;
        boolean r54 = true;
    L20:
        if (r54 == false) goto L22;
    L19:
        r54 = false;
        goto L20
    L5:
        if (r4.length() == 0) goto L8;
        r6 = false;
        goto L9
    }

    public final void g(long r6, boolean r8) {
        this.k = r8;
        boolean r9 = ky.a.a;
        boolean r0 = true;
        if (v.a() == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == true) goto L10;
    L12:
        Object r12 = this.c.get("data_enter_room_linkmic_params");
        if ((r12 instanceof String) == true) goto L15;
        r12 = null;
    L15:
        this.l = (String) r12;
        g4 r13 = g4.b;
        r13.b("linkmic_center_main_lynx_load");
        e(r6);
        r13.a("linkmic_center_main_lynx_load");
        Object r7 = this.c.get("data_enter_room_schema_uri");
        if ((r7 instanceof String) == true) goto L18;
        r7 = null;
    L18:
        String r14 = (String) r7;
        int r15 = com.bytedance.android.live.anchormodelink.util.c.a;
        HashMap r16 = new HashMap();
        if (r14 != null) goto L21;
    L24:
        if (r0 == true) goto L36;
        Uri r17 = UriProtector.parse(r14);
        Set r1 = UriProtector.getQueryParameterNames(r17);
        if (r1 == null) goto L36;
        Iterator r2 = r1.iterator();
    L31:
        if (r2.hasNext() == false) goto L36;
        String r3 = (String) r2.next();
        String r4 = UriProtector.getQueryParameter(r17, r3);
        if (r4 != null) goto L35;
        r4 = "";
    L35:
        r16.put(r3, r4);
    L36:
        this.m = r16;
        boolean r18 = iy.b.a;
        iy.b.e("AnchorModeDynamicCardManager", "[新视频连线] 甩房流程 DynamicCenterCardManager#onCreate linkmicParams:" + this.l + " schemaParams:" + this.m);
        this.c.put("data_enter_room_linkmic_params", null);
        this.c.put("data_enter_room_schema_uri", null);
        return;
    L21:
        if (r14.length() == 0) goto L24;
        r0 = false;
        goto L24
    L10:
        if (r6 > 0) goto L12;
        f2.c("room_id异常 " + r6, 0);
        goto L12
    L5:
        if (vm2.d.c0().getDebug() != true) goto L7;
        r11 = true;
        goto L8
    }

    public final void h(String r4, JsonObject r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        t r1 = this.j;
        if (r1 == null) goto L8;
        ih0.c r2 = r1.d;
        if (r2 == null) goto L9;
        JsonObject r3 = new JsonObject();
        r3.addProperty("type", r4);
        r3.add("data", r5);
        Unit r6 = Unit.INSTANCE;
        r2.sendJsEvent("onLinkmicStatusChange", r3);
        return;
    L9:
        return;
    }

    public final Map<String, Object> b(int r3, int r4, int r5, int r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("screenWidth", Integer.valueOf((int) s1.G(r3)));
        r0.put("screenHeight", Integer.valueOf((int) s1.G(r4)));
        r0.put("statusBarHeight", Integer.valueOf((int) s1.G(StatusBarUtil.getStatusBarHeight(this.b))));
        if (this.e == true) goto L13;
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.FALSE) == true) goto L13;
        DataCenter r7 = this.c;
        if (r7 == null) goto L14;
        Boolean r8 = (Boolean) r7.get("status_bar_is_visible", Boolean.TRUE);
        if (r8 == null) goto L14;
        boolean r9 = r8.booleanValue();
    L16:
        r0.put("containerWidth", Integer.valueOf((int) s1.G(r5)));
        r0.put("containerHeight", Integer.valueOf((int) s1.G(r6)));
        r0.put("isStatusBarVisible", Boolean.valueOf(r9));
        u r11 = this.i;
        if (r11 == null) goto L19;
        IRoom r12 = r11.getRoom();
    L20:
        String r13 = "";
        if (r12 == null) goto L23;
        Object r14 = Long.valueOf(r12.getRoomId());
    L24:
        r0.put("room_id", r14.toString());
        if (r12 == null) goto L28;
        String r15 = r12.getAnchorId();
        if (r15 == null) goto L28;
    L29:
        r0.put("anchor_id", r15);
        if (r12 == null) goto L33;
        String r16 = r12.getRequestId();
        if (r16 == null) goto L33;
    L34:
        r0.put("request_id", r16);
        com.bytedance.android.livesdk.log.filter.o r17 = j0.l().c(am2.x.class);
        if (r17 == null) goto L46;
        Map r18 = r17.getMap();
        if (r18 == null) goto L46;
        String r19 = (String) r18.get("enter_from_merge");
        if (r19 != null) goto L41;
        r19 = "";
    L41:
        r0.put("enter_from_merge", r19);
        String r21 = (String) r18.get("enter_method");
        if (r21 == null) goto L45;
        r13 = r21;
    L45:
        r0.put("enter_method", r13);
    L46:
        boolean r22 = iy.b.a;
        iy.b.e("AnchorModeDynamicCardManager", "getGlobalProps props: " + r0);
        return r0;
    L33:
        r16 = "";
    L28:
        r15 = "";
        goto L29
    L23:
        r14 = "";
        goto L24
    L19:
        r12 = null;
    L14:
        r9 = true;
    L13:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L14;
        r9 = false;
        goto L16
    }

    public h(Context r3, DataCenter r4, ViewGroup r5, boolean r6, int r7, boolean r8, ViewGroup r9, com.bytedance.android.live.liveinteract.jsbridge.method.s r11, u r12) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "containerView");
        this.a = 52.0f;
        this.t = new CompositeDisposable();
        this.u = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r3, "context");
        this.b = r3.getApplicationContext();
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.h = r8;
        this.g = r11;
        this.i = r12;
        this.s = r9;
    }
}
