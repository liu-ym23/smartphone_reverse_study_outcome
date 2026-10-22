package h7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.api.param.AnnieViewType;
import com.bytedance.android.annie.business.container.AnnieXLiveCard;
import com.bytedance.android.annie.business.container.AnnieXLiveDialog;
import com.bytedance.android.annie.business.container.AnnieXLiveFlowLoaderControl;
import com.bytedance.android.annie.business.container.AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1;
import com.bytedance.android.annie.business.container.AnnieXLiveFragment;
import com.bytedance.android.annie.card.ContainerInitialPropsManager;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.param.JsGsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.anniex.ability.service.BaseAnnieXLifecycleConfigService;
import com.bytedance.android.anniex.ability.service.IAnnieXLifecycleConfigService;
import com.bytedance.android.anniex.lite.base.ILitePageService;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.flow.FlowContainerLoaderControl;
import com.bytedance.ies.bullet.flow.FlowContainerLoaderSwitch;
import com.bytedance.ies.bullet.forest.j;
import com.bytedance.ies.bullet.prefetchv2.a0;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.webkit.InjectData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p46.f;
import t36.d;
import y36.i;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b9.b {
    public b a;
    public volatile boolean b;
    public AnnieXLiveContext c;
    public AnnieXLiveDialog d;

    /* JADX INFO: renamed from: h7.a$a, reason: collision with other inner class name */
    public static final class C0163a {
    }

    public static final class b implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ a a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r10) {
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r11, "savedInstanceState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            if (this.a.b == false) goto L33;
            FragmentActivity r11 = a.I1(r10, this.a.c);
            if (r11 == null) goto L28;
            FragmentManager r12 = r11.getSupportFragmentManager();
            if (r12 == null) goto L28;
            a r13 = this.a;
            AnnieXLiveDialog r14 = r13.d;
            if (r14 == null) goto L28;
            AnnieXLiveContext r15 = r13.c;
            if (r15 == null) goto L15;
            Uri r16 = r15.getUri();
            if (r16 == null) goto L15;
            String r17 = UriProtector.getQueryParameter(r16, "allowing_state_loss");
        L17:
            if (Intrinsics.areEqual(r17, "1") == false) goto L23;
            FragmentTransaction r18 = r12.beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r18, r14, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "AnnieX Live Dialog", 0) == true) goto L22;
            r18 = r18.add(r14, "AnnieX Live Dialog");
        L22:
            r18.commitAllowingStateLoss();
            goto L28
        L23:
            LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, "AnnieX Live Dialog", r19);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r14, r19) == true) goto L28;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
        L27:
            r14.show(r12, "AnnieX Live Dialog");
        L15:
            r17 = null;
        L28:
            this.a.b = false;
            a r20 = this.a;
            r20.c = null;
            r20.d = null;
            return;
        }
    }

    static {
    }

    public a() {
    }

    @Override // b9.b
    public final void init() {
    }

    public static boolean J1(Uri r10) {
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.ANNIEX_ENABLE_NA_PREFETCH.a(), Boolean.FALSE) == false) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10.getHost(), "webcast_webview") == false) goto L11;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r10, "enable_prefetch"), "1") == false) goto L11;
        return true;
    L11:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r10, "enable_na_prefetch"), "1") == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static Bundle K1(Bundle r10) {
        if (r10 != null) goto L6;
        Bundle r11 = new Bundle();
        r11.putString("biz_key", "webcast");
        r11.putLong("open_time", System.currentTimeMillis());
        return r11;
    L6:
        if (r10.getString("biz_key") != null) goto L9;
        r10.putString("biz_key", "webcast");
    L9:
        if (r10.getLong("open_time") > 0) goto L13;
        r10.putLong("open_time", System.currentTimeMillis());
        return r10;
    L13:
        return r10;
    }

    public static void H1(Bundle r10, Uri r11) {
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r11, "ec_tabkit_container"), "1") == false) goto L5;
        r10.putString("annie_x_inner_bundle_schema", r11.buildUpon().appendQueryParameter("anniex_kitview_create_opt", "1").build().toString());
        return;
    L5:
        r10.putString("annie_x_inner_bundle_schema", r11.toString());
    }

    public static FragmentActivity I1(Context r1, AnnieXLiveContext r10) {
        if ((r1 instanceof FragmentActivity) == false) goto L7;
        return (FragmentActivity) r1;
    L7:
        if ((r1 instanceof ContextWrapper) == true) goto L9;
        HybridLogger r11 = HybridLogger.a;
        k7.a.b("AnnieBusinessService", "get context error, context is not excepted type or null", r10);
        return null;
    L9:
        return I1(((ContextWrapper) r1).getBaseContext(), r10);
    }

    @Override // b9.b
    public final void f0(KitType r29, Uri r30, Bundle r31) {
        Intrinsics.checkNotNullParameter(r29, "kitType");
        Intrinsics.checkNotNullParameter(r30, "rawUri");
        if (r31 != null) goto L5;
        Bundle r10 = new Bundle();
    L6:
        H1(r10, r30);
        Bundle r11 = K1(r31);
        if (UriProtector.getQueryParameter(r30, "enable_preload") == null) goto L9;
    L11:
        Uri r12 = r30;
    L13:
        if (J1(r30) == false) goto L15;
        a0.a.d(r30, null, "webcast");
    L15:
        if (r31 == null) goto L17;
        String r1 = r31.getString("__annie_flow_session_id");
    L18:
        String r13 = ((IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null)).i(r12);
        if (r13 == null) goto L22;
        r1 = r13;
    L22:
        r11.putString("__x_session_id", r1);
        if (h.e0() == false) goto L26;
        if (r1 == null) goto L26;
        j.c(r12, r1);
    L26:
        if (r1 == null) goto L134;
        AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 r14 = AnnieXLiveFlowLoaderControl.a;
        Intrinsics.checkNotNullParameter(r29, "kitType");
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r12, "uri");
        long r15 = System.currentTimeMillis();
        Long r16 = Long.valueOf(r11.getLong("open_time"));
        if (r16 != null) goto L30;
    L38:
        ExecutorService r17 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.c(r1, "open_time", Long.valueOf(r15));
        Lazy r18 = BulletContextManager.b;
        BulletContext r19 = BulletContextManager.c(BulletContextManager.a.a(), "webcast", r12, r11);
        r19.f = "webcast";
        d r20 = r19.e;
        if (r20 == null) goto L135;
        String r21 = (String) ((i) new p(r20, "annie_x_url", null)).b;
        if (r21 != null) goto L43;
        r21 = "";
    L43:
        String r22 = r20.getOriginUrl().toString();
        AnnieXLiveFlowLoaderControl.a r110 = new AnnieXLiveFlowLoaderControl.a(r21, r22, r11);
        long r111 = r11.getLong("open_time");
        Application r112 = com.bytedance.ies.bullet.core.h.h.b;
        String r113 = UriProtector.getQueryParameter(r12, "type");
        if (r113 != null) goto L46;
    L49:
        boolean r114 = true;
    L50:
        if (r114 == false) goto L52;
        r113 = "fullscreen";
    L52:
        String r25 = r113;
        IAnnieBusinessLatchService r115 = (IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null);
        if (r22 != null) goto L55;
        String r116 = "";
    L56:
        Pair<IAnnieBusinessLatchService.PrefetchStrategy, String> r117 = r115.k(r12, r116);
        IAnnieBusinessLatchService.a r118 = ((IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null)).e(r111, r25, (String) r117.getSecond(), r22);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r118.d = r1;
        String r23 = "1";
        r118.g.put("enableRegisterXBridge", "1");
        Map<String, String> r24 = r118.g;
        if (AnnieConfigSettingKeys.LATCH_ENABLE_CHECK_VERSION.a().booleanValue() == true) goto L60;
        r23 = "0";
    L60:
        r24.put("enableCheckVersion", r23);
        IAnnieBusinessLatchService r26 = (IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null);
        if (r22 != null) goto L64;
        r22 = "";
    L64:
        if (r117.getFirst() != IAnnieBusinessLatchService.PrefetchStrategy.Latch) goto L66;
        boolean r119 = true;
    L67:
        r110.e = r26.C0(r112, r22, r1, r12, r111, r118, r119);
        AnnieXLiveFlowLoaderControl.a.put(r1, r110);
        String r27 = UriProtector.getQueryParameter(r12, "__initialProps_data_key");
        Map r120 = new LinkedHashMap();
        if (r27 == null) goto L72;
        Lazy r121 = ContainerInitialPropsManager.a;
        Intrinsics.checkNotNullParameter(r27, "key");
        JsonObject r28 = (JsonObject) ((HashMap) ContainerInitialPropsManager.a.getValue()).get(r27);
        if (r28 == null) goto L72;
        Lazy r122 = UtilsKt.a;
        Intrinsics.checkNotNullParameter(r28, "<this>");
        r120 = new JsGsonMap(r28);
    L72:
        Map<String, Object> r32 = r110.a(r110.a, r110.b);
        LinkedHashMap r123 = new LinkedHashMap();
        if ((!r32.isEmpty()) == false) goto L75;
        r123.put(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY, r32);
    L75:
        LinkedHashMap r33 = new LinkedHashMap();
        Iterator r124 = r120.entrySet().iterator();
    L77:
        if (r124.hasNext() == false) goto L82;
        Map.Entry r125 = (Map.Entry) r124.next();
        Object r126 = r125.getValue();
        if (r126 == null) goto L77;
        r33.put(r125.getKey(), r126);
        goto L77
    L82:
        if ((!r33.isEmpty()) == false) goto L85;
        r123.putAll(r33);
    L85:
        if (r123.isEmpty() == false) goto L87;
        r123 = null;
    L87:
        r110.c = r123;
        String r34 = com.bytedance.android.annie.api.data.subscribe.d.c(r110.a(r110.a, r110.b));
        Map<String, Object> r35 = r110.c;
        if (r35 == null) goto L92;
        if (r123 != null) goto L91;
        String r36 = "{\"initialProps\":" + r34 + '}';
    L93:
        InjectData r127 = new InjectData("{}", r34, r36);
        m16.b r128 = new m16.b();
        r128.g(InjectData.class, r127);
        r128.d(p16.a.class, new p16.a(r1));
        r128.d(BulletContext.class, r19);
        Application r37 = com.bytedance.ies.bullet.core.h.h.b;
        if (r37 == null) goto L96;
        r128.d(Context.class, new MutableContextWrapper(r37));
    L96:
        if (r123 == null) goto L100;
        Map r38 = MapsKt.toMutableMap(r123);
        if (r38 == null) goto L100;
        com.bytedance.ies.bullet.core.j r39 = r19.u;
        f r129 = new f();
        r129.a = r38;
        r39.b = r129;
    L100:
        AbsBulletMonitorCallback r40 = r19.c;
        long r130 = System.currentTimeMillis();
        Long r41 = Long.valueOf(r11.getLong("open_time"));
        if (r41 != null) goto L103;
    L105:
        int r42 = AbsBulletMonitorCallback.c;
        r40.s(r130, false);
        e r43 = r19.w;
        LinkedHashMap r44 = new LinkedHashMap();
        r44.put("forestSessionId", r1);
        if (r29 != KitType.LYNX) goto L116;
        HybridLogger.m("AnnieXLiveHybridComponent", "===AnnieXLiveHybridComponent 拼接公共参数===", null, null, 12);
        Uri r45 = UriProtector.parse(r21);
        Set r46 = UriProtector.getQueryParameterNames(r45);
        Uri.Builder r47 = r45.buildUpon();
        Iterator<T> r131 = ((com.bytedance.android.annie.service.network.i) Annie.getService$default(com.bytedance.android.annie.service.network.i.class, null, 2, null)).s1().entrySet().iterator();
    L109:
        if (r131.hasNext() == false) goto L115;
        Map.Entry r132 = (Map.Entry) r131.next();
        if ((!StringsKt.isBlank((CharSequence) r132.getValue())) == false) goto L109;
        if (r46.contains(r132.getKey()) == true) goto L109;
        r47.appendQueryParameter((String) r132.getKey(), (String) r132.getValue());
        goto L109
    L115:
        r21 = r47.build().toString();
    L116:
        r44.put(com.bytedance.android.ec.core.event.a.KEY_LOCATION, r21);
        if (r29 != KitType.LYNX) goto L119;
        Object r0 = 0;
    L120:
        r44.put("offline", r0);
        r43.h = r44;
        FlowContainerLoaderControl.b(r1, r19, r12, "webcast", r11, r128, new com.bytedance.android.annie.business.container.e());
        return;
    L119:
        r0 = Boolean.FALSE;
        goto L120
    L103:
        if (r41.longValue() <= 0) goto L105;
        r130 = Math.min(r41.longValue(), r130);
        goto L105
    L91:
        Intrinsics.checkNotNull(r35);
        r36 = com.bytedance.android.annie.api.data.subscribe.d.c(r35);
        goto L93
    L92:
        r36 = "{}";
        goto L93
    L66:
        r119 = false;
        goto L67
    L55:
        r116 = r22;
        goto L56
    L46:
        if (StringsKt.isBlank(r113) == true) goto L49;
        r114 = false;
        goto L50
    L135:
        return;
    L30:
        if (r16.longValue() <= 0) goto L32;
        boolean r133 = true;
    L33:
        if (r133 == true) goto L36;
        r16 = null;
    L36:
        if (r16 == null) goto L38;
        long r134 = r16.longValue();
        HybridLogger r135 = HybridLogger.a;
        HybridLogger.m("FlowContainerLoader", "openTime:" + r134 + ", currentTime: " + r15, null, null, 12);
        r15 = Math.min(r134, r15);
        goto L38
    L32:
        r133 = false;
        goto L33
    L134:
        return;
    L17:
        r1 = null;
        goto L18
    L9:
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.ANNIEX_ENABLE_DEFAULT_FOREST_PRELOAD.a(), Boolean.TRUE) == false) goto L11;
        r12 = r30.buildUpon().appendQueryParameter("enable_preload", "main").build();
        goto L13
    L5:
        r10 = r31;
        goto L6
    }

    @Override // b9.b
    public final HybridFragment B1(Context r10, Uri r11, b7.b r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "rawUri");
        if (r13 != null) goto L5;
        r13 = new Bundle();
    L5:
        H1(r13, r11);
        AnnieXLiveContext r14 = L1(r10, r11, r12, r13, AnnieViewType.FULLSCREEN);
        if (r12 == null) goto L8;
        r12.onPrepareInitDataEnd();
    L8:
        if (r12 == null) goto L11;
        r12.onContainerInitStart();
    L11:
        if (Intrinsics.areEqual("1", UriProtector.getQueryParameter(r11, "is_cj_biz")) == false) goto L13;
        ((g9.b) Annie.getService(g9.b.class, r14.getBizKey())).K();
    L13:
        HybridLogger r15 = HybridLogger.a;
        Map r16 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r11.toString()));
        com.bytedance.ies.bullet.base.utils.logger.a r17 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r17.a(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, r14.getUuid());
        Unit r0 = Unit.INSTANCE;
        HybridLogger.k("AnnieBusinessService", "container_init_start", r16, r17);
        HybridFragment r18 = ((e9.b) Annie.getService(e9.b.class, "webcast")).g1();
        if ((r18 instanceof AnnieXLiveFragment) == false) goto L16;
        AnnieXLiveFragment r19 = (AnnieXLiveFragment) r18;
    L17:
        if (r19 != null) goto L19;
        r19 = new AnnieXLiveFragment();
    L19:
        r19.setAnnieXLiveContext(r14);
        r19.setArguments(r13);
        return r19;
    L16:
        r19 = null;
        goto L17
    }

    @Override // b9.b
    public final HybridCard J0(Context r10, Uri r11, b7.b r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "rawUri");
        if (r13 != null) goto L5;
        Bundle r0 = new Bundle();
    L6:
        H1(r0, r11);
        r0.putString("annie_x_inner_container_type", PageType.CARD.getPageType());
        r0.putBoolean("show_loading", false);
        AnnieXLiveContext r14 = L1(r10, r11, r12, r13, AnnieViewType.CARD);
        if (r12 == null) goto L9;
        r12.onPrepareInitDataEnd();
    L9:
        if (r12 == null) goto L11;
        r12.onContainerInitStart();
    L11:
        HybridLogger r15 = HybridLogger.a;
        Map r16 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r11.toString()));
        com.bytedance.ies.bullet.base.utils.logger.a r17 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r17.a(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, r14.getUuid());
        Unit r1 = Unit.INSTANCE;
        HybridLogger.k("AnnieBusinessService", "container_init_start", r16, r17);
        return new AnnieXLiveCard(r10, r14);
    L5:
        r0 = r13;
        goto L6
    }

    @Override // b9.b
    public final HybridDialog o1(Context r10, Uri r11, b7.b r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "rawUri");
        if (r13 != null) goto L5;
        r13 = new Bundle();
    L5:
        H1(r13, r11);
        r13.putString("annie_x_inner_container_type", PageType.POPUP.getPageType());
        AnnieXLiveContext r0 = L1(r10, r11, r12, r13, AnnieViewType.POPUP);
        if (r12 == null) goto L8;
        r12.onPrepareInitDataEnd();
    L8:
        if (r12 == null) goto L10;
        r12.onContainerInitStart();
    L10:
        Integer r14 = AnnieConfigSettingKeys.ENABLE_EC_MALL_POPUP_NEST_OPTIMIZE.a();
        if (r14 != null) goto L14;
    L23:
        HybridLogger r15 = HybridLogger.a;
        Map r16 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r11.toString()));
        com.bytedance.ies.bullet.base.utils.logger.a r17 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r17.a(com.bytedance.android.ec.core.event.a.KEY_SESSION_ID, r0.getUuid());
        Unit r18 = Unit.INSTANCE;
        HybridLogger.k("AnnieBusinessService", "container_init_start", r16, r17);
        AnnieXLiveDialog r19 = new AnnieXLiveDialog();
        r19.e = r0;
        com.bytedance.android.annie.business.container.i r20 = r19.d;
        if (r20 == null) goto L26;
        r20.c = r0;
    L26:
        r19.setArguments(r13);
        if (AnnieConfigSettingKeys.ANNIE_ALLOW_POPUP_DELAY_OPEN.a().booleanValue() == true) goto L29;
    L55:
        FragmentActivity r21 = I1(r10, r0);
        if (r21 == null) goto L78;
        FragmentManager r22 = r21.getSupportFragmentManager();
        if (r22 != null) goto L60;
        return null;
    L60:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r11, "allowing_state_loss"), "1") == false) goto L66;
        FragmentTransaction r23 = r22.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r23, r19, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "AnnieX Live Dialog", 0) == true) goto L65;
        r23 = r23.add(r19, "AnnieX Live Dialog");
    L65:
        r23.commitAllowingStateLoss();
    L72:
        if (r19.t == true) goto L74;
        return null;
    L74:
        return r19;
    L66:
        LandscapeRestrictionOperation r24 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, "AnnieX Live Dialog", r24);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r22, r19, r24) == true) goto L72;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L70:
        r19.show(r22, "AnnieX Live Dialog");
        goto L72
    L78:
        return null;
    L29:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r11, "delay_open"), "1") == false) goto L31;
    L40:
        k7.a.b("AnnieBusinessService", "popup scheme delay open", r0);
        if (h.i() == false) goto L45;
        Application r25 = com.bytedance.ies.bullet.core.h.h.b;
        if (r25 != null) goto L51;
        return null;
    L51:
        this.b = true;
        this.c = r0;
        this.d = r19;
        if (this.a != null) goto L54;
        b r26 = new b(this);
        this.a = r26;
        r25.registerActivityLifecycleCallbacks(r26);
    L54:
        return r19;
    L45:
        Context r27 = r10.getApplicationContext();
        if ((r27 instanceof Application) == false) goto L48;
        r25 = (Application) r27;
    L49:
        if (r25 != null) goto L51;
        return null;
    L48:
        r25 = null;
        goto L49
    L31:
        if ((r10 instanceof Activity) == false) goto L33;
        Activity r110 = (Activity) r10;
    L34:
        if (r110 != null) goto L36;
    L38:
        boolean r111 = false;
    L39:
        if (r111 == false) goto L55;
    L36:
        if (r110.isFinishing() != true) goto L38;
        r111 = true;
        goto L39
    L33:
        r110 = null;
        goto L34
    L14:
        if (r14.intValue() != 1) goto L23;
        com.bytedance.android.anniex.assemble.a r28 = com.bytedance.android.anniex.assemble.a.a;
        IAnnieXLifecycleConfigService r29 = (IAnnieXLifecycleConfigService) com.bytedance.android.anniex.assemble.a.g(r0.getBizKey(), IAnnieXLifecycleConfigService.class);
        if (r29 == null) goto L23;
        if ((r29 instanceof BaseAnnieXLifecycleConfigService) == false) goto L20;
        BaseAnnieXLifecycleConfigService r30 = (BaseAnnieXLifecycleConfigService) r29;
    L21:
        if (r30 == null) goto L23;
        r0.getUuid();
        goto L23
    L20:
        r30 = null;
        goto L21
    }

    @Override // b9.b
    public final boolean p1(Context r10, Uri r11, h8.c r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "rawUri");
        String r14 = w36.a.a(r11, "__bullet_trident_call_id");
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        String r0 = q26.i.b(r11, r13);
        Object r15 = null;
        if (r13 == null) goto L8;
        String r16 = r13.getString("anniex_vid");
    L10:
        if (h.z() == false) goto L21;
        if (r16 == null) goto L18;
        boolean r17 = true;
        if (r16.length() <= 0) goto L15;
        boolean r18 = true;
    L16:
        if (r18 != true) goto L18;
    L19:
        if (r17 == false) goto L21;
        ExecutorService r19 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.a(r0, "anniex_live_vid", r16.toString());
        goto L21
    L15:
        r18 = false;
    L18:
        r17 = false;
    L21:
        if (r13 == null) goto L23;
        r13.remove("anniex_vid");
    L23:
        boolean r1 = Intrinsics.areEqual(w36.a.a(r11, "type"), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        com.bytedance.android.anniex.assemble.a r20 = com.bytedance.android.anniex.assemble.a.a;
        ILitePageService r21 = (ILitePageService) com.bytedance.android.anniex.assemble.a.g("webcast", ILitePageService.class);
        if (r21 == null) goto L40;
        new Bundle();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        if (r13 != null) goto L28;
        Bundle r22 = new Bundle();
    L29:
        r22.putString("__x_session_id", r0);
        r22.putString("__x_inner_schema", r11.toString());
        if (r1 == false) goto L32;
        r22.putString("popup_type_opt", w36.a.a(r11, "popup_type_opt"));
    L33:
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        if (r13 == null) goto L37;
        r15 = r13.get("bdx_act_request_code");
    L37:
        if ((r15 instanceof Integer) == false) goto L39;
        Integer r23 = (Integer) r15;
    L39:
        new c(r12);
        Unit r24 = Unit.INSTANCE;
        return r21.show();
    L32:
        r22.putString("page_type_opt", w36.a.a(r11, "page_type_opt"));
        goto L33
    L28:
        r22 = r13;
        goto L29
    L40:
        com.bytedance.android.anniex.lite.a.a.a(r0);
        return false;
    L8:
        r16 = null;
        goto L10
    }

    public static AnnieXLiveContext L1(Context r20, Uri r21, b7.b r22, Bundle r23, AnnieViewType r24) {
        Bundle r10 = K1(r23);
        if (UriProtector.getQueryParameter(r21, "enable_preload") == null) goto L5;
    L7:
        Uri r14 = r21;
    L8:
        boolean r11 = r14.getBooleanQueryParameter("enable_flow_loader", true);
        FlowContainerLoaderSwitch r12 = FlowContainerLoaderSwitch.INSTANCE;
        String r13 = r14.toString();
        String r15 = r14.getScheme();
        if (r15 == null) goto L29;
        int r16 = r15.hashCode();
        if (r16 == (-1772600516)) goto L26;
        if (r16 == 3213448) goto L22;
        if (r16 != 99617003) goto L29;
        if (r15.equals("https") == false) goto L29;
        KitType r17 = KitType.WEB;
    L31:
        if (r12.enableAnnieXFlowLoader("webcast", r13, r17) == false) goto L34;
        if (r11 == false) goto L34;
        boolean r18 = true;
    L36:
        if (J1(r21) == false) goto L39;
        if (r18 == true) goto L39;
        a0.a.d(r21, null, "webcast");
    L39:
        String r19 = UriProtector.getQueryParameter(r14, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r23 == null) goto L42;
        String r0 = r23.getString("__annie_flow_session_id");
    L43:
        String r25 = ((IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null)).i(r14);
        if (r25 != null) goto L46;
        String r110 = r0;
    L47:
        if (r23 == null) goto L49;
        long r1 = r23.getLong("open_time");
    L50:
        long r111 = r1;
        c7.a r26 = new AnnieXLiveContext(r14, r22, r10, r110, null, 16, null);
        r26.setViewType(r24);
        r26.setFromFlow(r18);
        b7.b r27 = r26.getCommonLifecycle();
        if (r27 == null) goto L53;
        r27.onInit(r26);
    L53:
        b7.b r28 = r26.getCommonLifecycle();
        if (r28 == null) goto L56;
        r28.onBeforeOpenContainer();
    L56:
        b7.b r29 = r26.getCommonLifecycle();
        if (r29 == null) goto L62;
        String r30 = r14.toString();
        String r31 = UriProtector.getQueryParameter(r14, "fallback_url");
        if (r31 != null) goto L61;
        r31 = "";
    L61:
        r29.onPrepareInitDataStart(r30, r31, false);
    L62:
        AnnieXLiveFlowLoaderControl$liveFlowLoadContextMap$1 r32 = AnnieXLiveFlowLoaderControl.a;
        IAnnieBusinessLatchService.b r33 = AnnieXLiveFlowLoaderControl.a(String.valueOf(r110));
        if (r33 != null) goto L90;
        String r34 = UriProtector.getQueryParameter(r14, "type");
        if (r34 != null) goto L67;
    L70:
        boolean r35 = true;
    L71:
        if (r35 == false) goto L73;
        r34 = "fullscreen";
    L73:
        String r36 = r34;
        IAnnieBusinessLatchService r37 = (IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null);
        if (r19 != null) goto L76;
        String r38 = "";
    L77:
        Pair<IAnnieBusinessLatchService.PrefetchStrategy, String> r112 = r37.k(r14, r38);
        IAnnieBusinessLatchService.a r39 = ((IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null)).e(r111, r36, (String) r112.getSecond(), r19);
        String r40 = r26.getUuid();
        r39.getClass();
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        r39.d = r40;
        String r41 = "1";
        r39.g.put("enableRegisterXBridge", "1");
        Map<String, String> r42 = r39.g;
        if (AnnieConfigSettingKeys.LATCH_ENABLE_CHECK_VERSION.a().booleanValue() == true) goto L81;
        r41 = "0";
    L81:
        r42.put("enableCheckVersion", r41);
        IAnnieBusinessLatchService r43 = (IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null);
        if (r19 != null) goto L84;
        r19 = "";
    L84:
        String r44 = r26.getUuid();
        if (r112.getFirst() != IAnnieBusinessLatchService.PrefetchStrategy.Latch) goto L87;
        boolean r45 = true;
    L88:
        r33 = r43.C0(r20, r19, r44, r14, r111, r39, r45);
        goto L90
    L87:
        r45 = false;
        goto L88
    L76:
        r38 = r19;
        goto L77
    L67:
        if (StringsKt.isBlank(r34) == true) goto L70;
        r35 = false;
    L90:
        r11.setLatchProcess(r33);
        r10.putString("__x_session_id", r11.getUuid());
        SLMonitorCompat r46 = SLMonitorCompat.a;
        String r47 = r11.getUuid();
        String r48 = r24.getTag();
        r46.getClass();
        SLMonitorCompat.p(r47, r14, r48);
        if (h.e0() == false) goto L94;
        if (r18 == true) goto L94;
        int r49 = j.a;
        j.c(r14, r26.getUuid());
    L94:
        return r11;
    L49:
        r1 = 0;
        goto L50
    L46:
        r110 = r25;
        goto L47
    L42:
        r0 = null;
    L34:
        r18 = false;
        goto L36
    L22:
        if (r15.equals("http") == false) goto L29;
        r17 = KitType.WEB;
        goto L31
    L26:
        if (r15.equals("lynxview") == false) goto L29;
        r17 = KitType.LYNX;
    L29:
        r17 = KitType.UNKNOWN;
        goto L31
    L5:
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.ANNIEX_ENABLE_DEFAULT_FOREST_PRELOAD.a(), Boolean.TRUE) == false) goto L7;
        r14 = r21.buildUpon().appendQueryParameter("enable_preload", "main").build();
        goto L8
    }
}
