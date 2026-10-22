package com.bytedance.android.annie.business.container;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.CardCustomMonitorKey;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.business.ability.schema.model.AnnieXLiveCardModel;
import com.bytedance.android.annie.card.ContainerInitialPropsManager;
import com.bytedance.android.annie.card.ExternalAddJsEventHelper;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.param.JsGsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.data.DataProviderService;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.android.annie.xbridge.mix.DefaultMixMethodCache;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.service.webkit.InjectData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieXLiveHybridComponent extends BaseHybridComponent implements ViewTreeObserver.OnPreDrawListener, com.bytedance.android.annie.card.f {
    public static final /* synthetic */ int r = 0;
    public Context a;
    public final ia.c b;
    public final AnnieXLiveCardModel c;
    public final AnnieXLiveContext d;
    public w8.e e;
    public final DataProviderService f;
    public JSBridgeManager g;
    public final Map<String, Map<String, String>> h;
    public long i;
    public String j;
    public final List<IHybridComponent.a> k;
    public boolean l;
    public Map<String, ? extends Object> m;
    public Map<String, Object> n;
    public Disposable o;
    public final CopyOnWriteArrayList<com.bytedance.android.annie.card.web.e> p;
    public final CopyOnWriteArrayList<com.bytedance.android.annie.lynx.f> q;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardCustomMonitorKey.values().length];
            r0[CardCustomMonitorKey.RealOpenTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[CardCustomMonitorKey.UserOpenTime.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[CardCustomMonitorKey.LoadScene.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[CardCustomMonitorKey.IsContainerPreload.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[CardCustomMonitorKey.IsUserOpen.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[CardCustomMonitorKey.IsPrerender.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[CardCustomMonitorKey.HasReload.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[CardCustomMonitorKey.HintSecLink.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final class c<T> implements ObservableOnSubscribe {
        public final /* synthetic */ AnnieXLiveHybridComponent a;
        public final /* synthetic */ Map<String, Object> b;

        public c(AnnieXLiveHybridComponent r1, Map<String, ? extends Object> r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void subscribe(ObservableEmitter<Map<String, Object>> r10) {
            Intrinsics.checkNotNullParameter(r10, "_emitter");
            AnnieXLiveHybridComponent r0 = this.a;
            r0.n = r0.c(this.b);
            if (AnnieConfigSettingKeys.ENABLE_ANNIEX_WEBCAST_JSON_OPT.a().booleanValue() == false) goto L5;
            InjectData r1 = this.a.b(this.b);
        L6:
            this.a.b.registerWeakHolder(InjectData.class, r1);
            r10.onComplete();
            return;
        L5:
            r1 = this.a.a();
            goto L6
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ AnnieXLiveHybridComponent a;
        public final /* synthetic */ String b;

        public d(AnnieXLiveHybridComponent r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void run() {
            this.a.d(this.b);
        }
    }

    public static final class e implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final String a;
        public final Object b;

        public final String getName() {
            return this.a;
        }

        public final Object getParams() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(String r1, T r10) {
            this.a = r1;
            boolean r11 = r10 instanceof String;
            Object r12 = r10;
            if (r11 == false) goto L5;
            r12 = new JSONObject((String) r10);
        L5:
            this.b = r12;
        }
    }

    static {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final boolean isAnnieXComponent() {
        return true;
    }

    @Override // com.bytedance.android.annie.card.f
    public final void onInjectShareInfo(y6.e r1) {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void onPause() {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void onResume() {
    }

    public final InjectData a() {
        Map<String, Object> r0 = observeWith(this.c.c(), this.c.b());
        Pair r10 = new Pair(com.bytedance.android.annie.api.data.subscribe.d.c(r0), r0);
        String r1 = (String) r10.component1();
        Map r11 = (Map) r10.component2();
        Map<String, Object> r12 = this.n;
        if (r12 != null) goto L5;
        String r13 = "{}";
    L7:
        return new InjectData("{}", r1, r13);
    L5:
        Intrinsics.checkNotNull(r12);
        r13 = com.bytedance.android.annie.api.data.subscribe.d.c(r12);
        goto L7
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void addOnPreDrawListener() {
        View r0 = this.b.getKitView();
        if ((r0 instanceof LynxView) == false) goto L5;
        LynxView r1 = (LynxView) r0;
    L6:
        if (r1 == null) goto L9;
        realAddOnPreDrawListener(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean canGoBack() {
        return this.b.canGoBack();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
        this.b.close();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final String containerId() {
        return this.b.getContainerId();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String getBizKey() {
        return this.d.getBizKey();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final Map<String, Long> getExtraPerfInfo() {
        return this.b.getPerfMap();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final View getHybridView() {
        return this.b.getKitView();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final View getView() {
        return this.b.getKitView();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void goBack() {
        this.b.goBack();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
        this.b.enterBackground();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final IHybridComponent.HybridType hybridType() {
        AnnieXLiveCardModel r0 = this.c;
        r0.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(UriProtector.parse(r0.b()).getHost());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r10) == false) goto L10;
        r10 = null;
    L10:
        String r11 = (String) r10;
        if (r11 != null) goto L14;
        r11 = "";
    L14:
        if (Intrinsics.areEqual(r11, "webcast_webview") == false) goto L17;
        return IHybridComponent.HybridType.H5;
    L17:
        if (Intrinsics.areEqual(r11, "webcast_lynxview") == false) goto L20;
        return IHybridComponent.HybridType.LYNX;
    L20:
        return IHybridComponent.HybridType.LYNX;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        LynxView r0 = this.b.getKitView();
        if ((r0 instanceof LynxView) == false) goto L5;
        LynxView r1 = r0;
    L7:
        if (r1 != null) goto L9;
    L18:
        return true;
    L9:
        if (r1.getWidth() == 0) goto L11;
    L13:
        r1.getViewTreeObserver().removeOnPreDrawListener(this);
        if (AnnieConfigSettingKeys.ANNIE_OPEN_PRE_DRAW_FOR_LYNX.a().booleanValue() == false) goto L16;
        p r10 = p.a;
        r1.updateScreenMetrics(r10.e(), r10.d());
    L17:
        r1.requestLayout();
        goto L18
    L16:
        r1.updateScreenMetrics(r1.getWidth(), r1.getHeight());
        goto L17
    L11:
        if (r1.getHeight() != 0) goto L13;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.annie.card.f
    public final void onRefresh() {
        HybridLogger.m("AnnieXLiveHybridComponent", "===onRefresh===", null, null, 12);
        a7.a.a(this, null, null, 3);
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        if ((!this.h.isEmpty()) == false) goto L12;
        long r10 = System.currentTimeMillis();
        Iterator r0 = ((LinkedHashMap) this.h).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        Map.Entry r11 = (Map.Entry) r0.next();
        String r12 = (String) r11.getKey();
        Map<String, String> r13 = (Map) r11.getValue();
        if (r13.containsKey(com.bytedance.android.ec.core.event.a.KEY_DURATION) == true) goto L10;
        r13.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, String.valueOf(r10 - this.i));
    L10:
        ((x9.b) getService(x9.b.class)).logV3(r12, r13);
        goto L6
    L11:
        ((LinkedHashMap) this.h).clear();
    L12:
        Map r1 = x26.a.a;
        w26.g r14 = (w26.g) x26.a.a(w26.g.class);
        if (r14 == null) goto L19;
        w26.e r15 = (w26.e) r14.n0(w26.e.class);
        if (r15 == null) goto L19;
        Boolean r16 = r15.c0();
        if (r16 == null) goto L19;
        boolean r17 = r16.booleanValue();
    L21:
        if (r17 == false) goto L29;
        IAnnieBusinessLatchService.b r18 = this.d.getLatchProcess();
        if (r18 == null) goto L25;
        r18.dispose();
    L25:
        IAnnieBusinessLatchService r19 = (IAnnieBusinessLatchService) Annie.getService$default(IAnnieBusinessLatchService.class, null, 2, null);
        Uri r20 = this.c.c;
        if (r20 != null) goto L28;
        r20 = Uri.EMPTY;
    L28:
        r19.P0(r20);
    L29:
        String r21 = this.j;
        if (r21 == null) goto L32;
        Lazy r22 = ContainerInitialPropsManager.a;
        Intrinsics.checkNotNullParameter(r21, "key");
        ((HashMap) ContainerInitialPropsManager.a.getValue()).remove(r21);
    L32:
        ((ArrayList) this.k).clear();
        ExternalAddJsEventHelper.a();
        w8.e r23 = this.e;
        if (r23 == null) goto L35;
        r23.release();
    L35:
        this.f.a();
        this.d.release();
        JSBridgeManager r24 = this.g;
        if (r24 == null) goto L38;
        r24.i();
    L38:
        this.g = null;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r25 = SocketManager.a;
        SocketManager r26 = SocketManager.a.a();
        String r27 = containerId();
        r26.getClass();
        SocketManager.b(r27, null);
        this.j = null;
        this.c.getClass();
        Context r28 = this.a;
        if (r28 == null) goto L41;
        y8.e.a.a(r28);
    L41:
        this.b.release();
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L52;
        Iterator<com.bytedance.android.annie.card.web.e> r29 = this.p.iterator();
    L45:
        if (r29.hasNext() == false) goto L47;
        r29.next().getClass();
        goto L45
    L47:
        Iterator<com.bytedance.android.annie.lynx.f> r30 = this.q.iterator();
    L49:
        if (r30.hasNext() == false) goto L51;
        r30.next().onRelease();
        goto L49
    L51:
        this.p.clear();
        this.q.clear();
        this.a = null;
    L53:
        Disposable r31 = this.o;
        if (r31 == null) goto L56;
        r31.dispose();
    L56:
        this.o = null;
        return;
    L52:
        this.p.clear();
        this.q.clear();
    L19:
        r17 = true;
        goto L21
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void show() {
        this.b.enterForeground();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.container.fragment.o
    public final c7.a getAnnieContext() {
        return this.d;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final JSBridgeManager getJSBridgeManger() {
        return this.g;
    }

    public final InjectData b(Map<String, ? extends Object> r10) {
        if (AnnieConfigSettingKeys.ENABLE_ANNIEX_WEBCAST_JSON_OPT.a().booleanValue() == false) goto L8;
        String r0 = this.c.c();
        String r1 = this.c.b();
        Map<String, ? extends Object> r11 = this.m;
        if (r11 == null) goto L7;
        Intrinsics.checkNotNull(r11);
    L9:
        String r12 = com.bytedance.android.annie.api.data.subscribe.d.c(r11);
        Map<String, Object> r13 = this.n;
        if (r13 == null) goto L18;
        if (r10 == null) goto L13;
    L15:
        if (r13 == null) goto L18;
        Intrinsics.checkNotNull(r13);
        String r14 = com.bytedance.android.annie.api.data.subscribe.d.c(r13);
    L20:
        return new InjectData("{}", r12, r14);
    L13:
        if (this.j != null) goto L15;
        r14 = "{\"initialProps\":" + r12 + '}';
    L18:
        r14 = "{}";
        goto L20
    L7:
        r11 = observeWith(r0, r1);
        this.m = r11;
        Intrinsics.checkNotNull(r11);
        goto L9
    L8:
        r11 = observeWith(this.c.c(), this.c.b());
        goto L9
    }

    public final Map<String, Object> c(Map<String, ? extends Object> r10) {
        String r0 = this.j;
        if (r0 == null) goto L7;
        Lazy r1 = ContainerInitialPropsManager.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        JsonObject r11 = (JsonObject) ((HashMap) ContainerInitialPropsManager.a.getValue()).get(r0);
        if (r11 == null) goto L7;
        Lazy r12 = UtilsKt.a;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        r10 = new JsGsonMap(r11);
    L7:
        ((ILatchService) getService(ILatchService.class)).S0(this.c.c());
        if (AnnieConfigSettingKeys.ENABLE_ANNIEX_WEBCAST_JSON_OPT.a().booleanValue() == false) goto L13;
        String r13 = this.c.c();
        String r14 = this.c.b();
        Map<String, ? extends Object> r15 = this.m;
        if (r15 == null) goto L12;
        Intrinsics.checkNotNull(r15);
    L14:
        LinkedHashMap r16 = new LinkedHashMap();
        if ((!r15.isEmpty()) == false) goto L17;
        r16.put(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY, r15);
    L17:
        LinkedHashMap r17 = new LinkedHashMap();
        if (r10 == null) goto L26;
        Iterator<Map.Entry<String, ? extends Object>> r18 = r10.entrySet().iterator();
    L21:
        if (r18.hasNext() == false) goto L26;
        Map.Entry<String, ? extends Object> r19 = r18.next();
        Object r20 = r19.getValue();
        if (r20 == null) goto L21;
        r17.put(r19.getKey(), r20);
    L26:
        if ((!r17.isEmpty()) == false) goto L29;
        r16.putAll(r17);
    L29:
        if (r16.isEmpty() == false) goto L37;
        return null;
    L37:
        return r16;
    L12:
        r15 = observeWith(r13, r14);
        this.m = r15;
        Intrinsics.checkNotNull(r15);
        goto L14
    L13:
        r15 = observeWith(this.c.c(), this.c.b());
        goto L14
    }

    public final void d(String r10) {
        if (r10 != null) goto L4;
        Unit r11 = null;
    L8:
        if (r11 != null) goto L11;
        this.b.reload(this.n);
        return;
    L11:
        return;
    L4:
        if (AnnieConfigSettingKeys.ANNIEX_FIX_LOAD_SCHEMA.a().booleanValue() == true) goto L6;
        this.d.reload(UriProtector.parse(r10));
    L6:
        this.b.loadSchema(r10, this.n);
        r11 = Unit.INSTANCE;
        goto L8
    }

    public final void e(List<? extends IHybridComponent.a> r10) {
        JSBridgeManager r0 = this.g;
        if (r0 == null) goto L13;
        Iterator<T> r1 = this.k.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((IHybridComponent.a) r1.next()).onJSBridgeCreated(r0);
        goto L6
    L8:
        if (r10 == null) goto L16;
        Iterator<T> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L17;
        ((IHybridComponent.a) r11.next()).onJSBridgeCreated(r0);
        goto L11
    L17:
        return;
    L16:
        return;
    }

    public final void f(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        IHybridComponent.HybridType r11 = hybridType();
        String r0 = this.c.b();
        String r1 = (String) this.c.e.getValue();
        IHybridComponent.HybridType r12 = IHybridComponent.HybridType.LYNX;
        if (r11 != r12) goto L5;
        String r13 = "lynx";
    L7:
        if (AnnieConfigSettingKeys.SEND_LOG_IN_CHILD_THREAD.a().booleanValue() == false) goto L9;
        Schedulers.computation().scheduleDirect(new h(this, r13, r0, r1));
    L10:
        ia.c r14 = this.b;
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("containerID", containerId());
        r15.put("forestSessionId", containerId());
        LynxView r16 = null;
        if (hybridType() != r12) goto L21;
        String r17 = this.c.c();
        HybridLogger.m("AnnieXLiveHybridComponent", "===AnnieXLiveHybridComponent 拼接公共参数===", null, null, 12);
        Uri r18 = UriProtector.parse(r17);
        Set r19 = UriProtector.getQueryParameterNames(r18);
        Uri.Builder r20 = r18.buildUpon();
        Iterator<T> r21 = ((com.bytedance.android.annie.service.network.i) Annie.getService$default(com.bytedance.android.annie.service.network.i.class, null, 2, null)).s1().entrySet().iterator();
    L14:
        if (r21.hasNext() == false) goto L20;
        Map.Entry r22 = (Map.Entry) r21.next();
        if ((!StringsKt.isBlank((CharSequence) r22.getValue())) == false) goto L14;
        if (r19.contains(r22.getKey()) == true) goto L14;
        r20.appendQueryParameter((String) r22.getKey(), (String) r22.getValue());
        goto L14
    L20:
        String r23 = r20.build().toString();
    L22:
        r15.put(com.bytedance.android.ec.core.event.a.KEY_LOCATION, r23);
        if (hybridType() != IHybridComponent.HybridType.LYNX) goto L25;
        Object r24 = 0;
    L26:
        r15.put("offline", r24);
        r14.updateGlobalProps(r15);
        View r25 = this.b.getKitView();
        if ((r25 instanceof LynxView) == false) goto L29;
        r16 = (LynxView) r25;
    L29:
        if (r16 == null) goto L42;
        IAnnieBusinessLatchService.b r26 = this.d.getLatchProcess();
        if (r26 == null) goto L33;
        r26.X0(this);
    L33:
        realAddOnPreDrawListener(r16);
        return;
    L42:
        return;
    L25:
        r24 = Boolean.FALSE;
        goto L26
    L21:
        r23 = this.c.c();
        goto L22
    L9:
        g(this.c.b(), r13, r0, r1);
        goto L10
    L5:
        r13 = "web";
        goto L7
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return (T) Annie.getService(r10, getBizKey());
    }

    public final void realAddOnPreDrawListener(LynxView r10) {
        y36.a r0 = this.c.d;
        boolean r1 = false;
        if (r0 == null) goto L7;
        Boolean r11 = (Boolean) ((y36.i) r0).b;
        if (r11 == null) goto L7;
        boolean r12 = r11.booleanValue();
    L9:
        if (AnnieConfigSettingKeys.ANNIE_OPEN_PRE_DRAW_FOR_LYNX.a().booleanValue() == true) goto L11;
        if (r12 == true) goto L11;
    L12:
        if (r1 == true) goto L14;
        return;
    L14:
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L20;
        ViewTreeObserver r13 = r10.getViewTreeObserver();
        if (r13 == null) goto L21;
        r13.addOnPreDrawListener(this);
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r1 = true;
    L7:
        r12 = false;
        goto L9
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void registerLifecycleCallback(com.bytedance.android.annie.card.base.b r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycleCallback");
        if ((r10 instanceof com.bytedance.android.annie.card.web.e) == false) goto L6;
        this.p.add(r10);
        return;
    L6:
        if ((r10 instanceof com.bytedance.android.annie.lynx.f) == false) goto L10;
        this.q.add(r10);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.k.add(r10);
        JSBridgeManager r0 = this.g;
        if (r0 == null) goto L6;
        r10.onJSBridgeCreated(r0);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        if (AnnieConfigSettingKeys.BUGFIX_WEBCAST_UPDATE_DATA.a().booleanValue() == false) goto L5;
        this.b.updateData(k7.b.a(r10));
        return;
    L5:
        this.b.updateGlobalProps(k7.b.a(r10));
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        if (r10 == null) goto L5;
        this.b.updateGlobalProps(k7.b.a(r10));
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r10, Map<String, ? extends Object> r11) {
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L9;
        w26.e r12 = (w26.e) r1.n0(w26.e.class);
        if (r12 == null) goto L9;
        Boolean r13 = r12.u0();
        if (r13 == null) goto L9;
        boolean r14 = r13.booleanValue();
    L10:
        if (r14 == true) goto L12;
    L14:
        this.n = c(r11);
        if (AnnieConfigSettingKeys.ENABLE_ANNIEX_WEBCAST_JSON_OPT.a().booleanValue() == false) goto L17;
        InjectData r15 = b(r11);
    L18:
        this.b.registerWeakHolder(InjectData.class, r15);
        d(r10);
        return;
    L17:
        r15 = a();
        goto L18
    L12:
        if (Intrinsics.areEqual(this.b.getViewType(), "card") == true) goto L14;
        this.o = Observable.create(new c(this, r11)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new d(this, r10)).subscribe();
        return;
    L9:
        r14 = true;
        goto L10
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final Map<String, Object> observeWith(String r10, String r11) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
        Boolean r13 = HybridSecureUtil.b(r10);
        if (r13 == null) goto L15;
        boolean r14 = r13.booleanValue();
    L16:
        if (r14 == false) goto L18;
        Object r15 = null;
        if (AnnieConfigSettingKeys.LIVE_HYBRID_USE_NEW_DATA_SHARE.a().booleanValue() == false) goto L77;
        JSBridgeManager r16 = this.g;
        if (r16 == null) goto L76;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L67
        if (r11 != null) goto L26;
    L29:
        boolean r18 = true;
    L31:
        if ((!r18) == true) goto L34;
        r11 = null;
    L34:
        if (r11 == null) goto L54;
        String r19 = UriProtector.getQueryParameter(UriProtector.parse(r11), BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L67
        if (r19 == null) goto L54;
        Object r20 = Result.constructor-impl(new JSONArray(r19));     // Catch: Throwable -> L39
    L42:
        if (Result.isFailure-impl(r20) == false) goto L44;
        r20 = null;
    L44:
        JSONArray r21 = (JSONArray) r20;     // Catch: Throwable -> L67
        if (r21 == null) goto L54;
        if (r21.length() <= 0) goto L49;
        r0 = true;
    L49:
        if (r0 == true) goto L52;
        r21 = null;
    L52:
        if (r21 == null) goto L54;
    L65:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L67
    L70:
        if (Result.isFailure-impl(r22) == true) goto L73;
        r15 = r22;
    L73:
        this.f.c(r10, (JSONArray) r15, r16, new AnnieXLiveHybridComponent$observeWith$1$1(this));
        return this.f.b();
    L39:
        th = move-exception;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L67
        r20 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
    L54:
        String r24 = UriProtector.getQueryParameter(UriProtector.parse(r10), BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L67
        if (r24 != null) goto L140;
        r21 = null;
        goto L65
    L140:
        Object r25 = Result.constructor-impl(new JSONArray(r24));     // Catch: Throwable -> L58
    L61:
        if (Result.isFailure-impl(r25) == false) goto L63;
        r25 = null;
    L63:
        r21 = (JSONArray) r25;     // Catch: Throwable -> L67
    L58:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L67
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L67
        goto L61
    L26:
        if (StringsKt.isBlank(r11) == true) goto L29;
        r18 = false;
    L67:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L70
    L76:
        return MapsKt.emptyMap();
    L77:
        w8.e r27 = this.e;
        if (r27 != null) goto L144;
        JSBridgeManager r28 = this.g;
        if (r28 == null) goto L84;
        r27 = ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).z0(r28, r10);
        if (r27 == null) goto L84;
        this.e = r27;
    L85:
        if (r27 != null) goto L144;
        return MapsKt.emptyMap();
    L84:
        r27 = null;
    L144:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L132
        if (r11 != null) goto L91;
    L94:
        boolean r30 = true;
    L96:
        if ((!r30) == true) goto L99;
        r11 = null;
    L99:
        if (r11 == null) goto L119;
        String r31 = UriProtector.getQueryParameter(UriProtector.parse(r11), BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L132
        if (r31 == null) goto L119;
        Object r32 = Result.constructor-impl(new JSONArray(r31));     // Catch: Throwable -> L104
    L107:
        if (Result.isFailure-impl(r32) == false) goto L109;
        r32 = null;
    L109:
        JSONArray r33 = (JSONArray) r32;     // Catch: Throwable -> L132
        if (r33 == null) goto L119;
        if (r33.length() <= 0) goto L114;
        r0 = true;
    L114:
        if (r0 == true) goto L117;
        r33 = null;
    L117:
        if (r33 == null) goto L119;
    L130:
        Object r34 = Result.constructor-impl(r33);     // Catch: Throwable -> L132
    L135:
        if (Result.isFailure-impl(r34) == true) goto L138;
        r15 = r34;
    L138:
        r27.b(r10, (JSONArray) r15, new AnonymousClass2(this));
        return r27.a();
    L104:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L132
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
    L119:
        String r36 = UriProtector.getQueryParameter(UriProtector.parse(r10), BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L132
        if (r36 != null) goto L148;
        r33 = null;
        goto L130
    L148:
        Object r37 = Result.constructor-impl(new JSONArray(r36));     // Catch: Throwable -> L123
    L126:
        if (Result.isFailure-impl(r37) == false) goto L128;
        r37 = null;
    L128:
        r33 = (JSONArray) r37;     // Catch: Throwable -> L132
    L123:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L132
        r37 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L126
    L91:
        if (StringsKt.isBlank(r11) == true) goto L94;
        r30 = false;
    L132:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L135
    L18:
        return MapsKt.emptyMap();
    L15:
        r14 = o7.l.g(r10);
        goto L16
    L11:
        return MapsKt.emptyMap();
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        JSBridgeManager r0 = this.g;
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final <T extends com.bytedance.android.annie.service.a> void registerService(Class<? extends com.bytedance.android.annie.service.a> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "obj");
        Annie.registerService(r10, r11, getBizKey());
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final <T> void sendJsEvent(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "data");
        this.b.sendEvent(new e(r10, r11));
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public final void updateScreenMetrics(int r10, int r11) {
        this.b.updateScreenMetrics(r10, r11);
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public final <P, R> void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        JSBridgeManager r0 = this.g;
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }

    public AnnieXLiveHybridComponent(Context r10, ia.c r11, AnnieXLiveCardModel r12, AnnieXLiveContext r13) {
        Intrinsics.checkNotNullParameter(r11, "_container");
        Intrinsics.checkNotNullParameter(r12, "_annieXLiveCardModel");
        Intrinsics.checkNotNullParameter(r13, "_annieXLiveContext");
        super(r13);
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.f = new DataProviderService(r13.getBizKey());
        this.h = new LinkedHashMap();
        this.k = new ArrayList();
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
    L11:
        Context r14 = this.a;
        if (r14 == null) goto L24;
        y8.e r0 = y8.e.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        Object r1 = y8.e.c;
        monitor-enter(r1);
    L21:
        th = move-exception;
        throw th;
    L16:
        if (y8.e.b != 0) goto L18;
        r14.registerComponentCallbacks(r0);     // Catch: Throwable -> L21
    L18:
        y8.e.b++;     // Catch: Throwable -> L21
        monitor-exit(r1);
    L24:
        ExternalAddJsEventHelper.b();
        if (this.j != null) goto L27;
        this.j = UriProtector.getQueryParameter(r13.getUri(), "__initialProps_data_key");
    L27:
        int r15 = l7.a.a;
        Resources r16 = p.a.getResources();
        Intrinsics.checkNotNullParameter(r16, "resources");
        l7.a.a = r16.getConfiguration().screenWidthDp;
        HybridLogger r17 = HybridLogger.a;
        HybridLogger.m("AnnieXLiveMultiWindowHelper", "initScreenSizeAndOrientation, screenWidthDp:" + l7.a.a + ", screenHeightDp:" + r16.getConfiguration().screenHeightDp, null, null, 12);
        r11.bindContainerId(r13.getUuid());
        b7.b r18 = r13.getCommonLifecycle();
        if (r18 == null) goto L30;
        r18.onBeforeJsbRegister();
    L30:
        Context r19 = this.a;
        if (r19 == null) goto L33;
        this.g = new JSBridgeManager(this.d, this, r19);
    L33:
        JSBridgeManager r20 = this.g;
        if (r20 == null) goto L43;
        r20.u = true;
        r20.v = new DefaultMixMethodCache();
        WeakReference<IHybridComponent> r21 = r20.g;
        if (r21 == null) goto L42;
        IHybridComponent r22 = r21.get();
        if (r22 == null) goto L42;
        DefaultMixMethodCache r23 = r20.v;
        if (r23 == null) goto L42;
        r23.e(r20, r22);
    L42:
        a9.j r24 = a9.j.a;
        a9.j.H1(r20);
    L43:
        JSBridgeManager r25 = this.g;
        if (r25 == null) goto L48;
        com.bytedance.android.annie.card.g r26 = r25.t;
        if (r26 == null) goto L48;
        r26.a(this);
    L48:
        registerMethod("lynxReleaseSendLog", new g(this));
        b7.b r27 = r13.getCommonLifecycle();
        if (r27 == null) goto L51;
        r27.onJsbRegistered();
    L51:
        r11.registerWeakHolder(AnnieXLiveContext.class, r13);
        r11.registerWeakHolder(IHybridComponent.class, this);
        JSBridgeManager r28 = this.g;
        if (r28 == null) goto L54;
        r11.registerWeakHolder(JSBridgeManager.class, r28);
        r11.registerWeakHolder(y6.c.class, r28);
    L54:
        ((com.bytedance.android.annie.service.prefetch.p) getService(com.bytedance.android.annie.service.prefetch.p.class)).r0(this);
        if (this.a != null) goto L57;
        HybridLogger.i("AnnieXLiveHybridComponent", "_context is null", null, 12);
    L57:
        this.p = new CopyOnWriteArrayList();
        this.q = new CopyOnWriteArrayList();
        return;
    L5:
        if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L11;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L11;
        throw new RuntimeException("不能在子线程创建Annie组件");
    }

    public final void g(String r10, String r11, String r12, String r13) {
        ((x9.b) getService(x9.b.class)).logV3("livesdk_live_container_load", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEME, r10), TuplesKt.to("container_type", r11), TuplesKt.to("original_url", r12), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r13), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE, PageType.CARD.getPageType())}));
    }
}
