package com.bytedance.android.annie.card.base;

import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.container.fragment.o;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.service.data.DataProviderService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.mt.protector.impl.UriProtector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o7.l;
import org.json.JSONArray;
import w8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseHybridComponent implements IHybridComponent, o {
    public static final a Companion = null;
    public static final String GLOBAL_PROPS = "__globalProps";
    public static final String INITIAL_PROPS_QUERY_KEY = "initialProps";
    public static final String INJECT_NATIVE_DATA = "__globalprops";
    public static final String STATE_OBSERVER_CHANGE = "stateObserverChange";
    private final com.bytedance.android.annie.param.a annieContext;
    private AnnieXLiveContext annieXLiveContext;
    private e dataHolder;
    private DataProviderService dataProviderService;
    private String mContainerId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BaseHybridComponent() {
        com.bytedance.android.annie.param.a r0 = null;
        this(r0, 1, r0);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ void addOnPreDrawListener() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean canGoBack() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    public abstract JSBridgeManager getJSBridgeManger();

    public abstract View getView();

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void hide() {
    }

    public boolean isAnnieXComponent() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean isPopup() {
        return false;
    }

    public abstract void onPause();

    public abstract void onResume();

    public abstract void registerLifecycleCallback(b r1);

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
    }

    @Override // a7.b
    public /* synthetic */ void setRadius(float r1) {
    }

    @Override // a7.b
    public /* synthetic */ void setRadius(float r1, float r10, float r11, float r12) {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void show() {
    }

    public void updateHybridParamsNew(CardParamVoNew r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
    }

    public abstract void updateScreenMetrics(int r1, int r10);

    public c7.a getAnnieContext() {
        com.bytedance.android.annie.param.a r0 = this.annieContext;
        if (r0 != null) goto L7;
        AnnieXLiveContext r1 = this.annieXLiveContext;
        Intrinsics.checkNotNull(r1);
        return r1;
    L7:
        return r0;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        e r0 = this.dataHolder;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.dataProviderService.a();
        Lazy r1 = ComponentManager.a;
        String r10 = this.mContainerId;
        Intrinsics.checkNotNullParameter(r10, "containerId");
        ((HashMap) ComponentManager.a.getValue()).remove(r10);
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r11 = SocketManager.a;
        SocketManager r12 = SocketManager.a.a();
        String r13 = this.mContainerId;
        r12.getClass();
        SocketManager.b(r13, null);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public View getHybridView() {
        return getView();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public String containerId() {
        return this.mContainerId;
    }

    public BaseHybridComponent(com.bytedance.android.annie.param.a r10) {
        this.annieContext = r10;
        if (r10 == null) goto L5;
        String r0 = r10.getUuid();
    L10:
        this.mContainerId = r0;
        if (r10 == null) goto L13;
        String r11 = r10.getBizKey();
    L18:
        this.dataProviderService = new DataProviderService(r11);
        Lazy r12 = ComponentManager.a;
        String r13 = this.mContainerId;
        Intrinsics.checkNotNullParameter(r13, "containerId");
        Intrinsics.checkNotNullParameter(this, "container");
        Lazy r1 = ComponentManager.a;
        if (((HashMap) r1.getValue()).containsKey(r13) == true) goto L22;
        ((HashMap) r1.getValue()).put(r13, new WeakReference(this));
        return;
    L22:
        return;
    L13:
        AnnieXLiveContext r14 = this.annieXLiveContext;
        if (r14 == null) goto L17;
        r11 = r14.getBizKey();
        if (r11 != null) goto L18;
    L17:
        r11 = "host";
        goto L18
    L5:
        AnnieXLiveContext r15 = this.annieXLiveContext;
        if (r15 == null) goto L9;
        r0 = r15.getUuid();
        if (r0 != null) goto L10;
    L9:
        r0 = "";
        goto L10
    }

    public <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return (T) Annie.getService(r10, getBizKey());
    }

    public BaseHybridComponent(AnnieXLiveContext r10) {
        Intrinsics.checkNotNullParameter(r10, "annieXLiveContext");
        com.bytedance.android.annie.param.a r0 = null;
        this(r0, 1, r0);
        this.annieXLiveContext = r10;
    }

    public Map<String, Object> observeWith(String r10, String r11) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
        com.bytedance.android.anniex.assemble.a.h();
        if (l.g(r10) == false) goto L15;
        Object r13 = null;
        if (AnnieConfigSettingKeys.LIVE_HYBRID_USE_NEW_DATA_SHARE.a().booleanValue() == false) goto L74;
        JSBridgeManager r14 = getJSBridgeManger();
        if (r14 == null) goto L73;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L64
        if (r11 != null) goto L23;
    L26:
        boolean r16 = true;
    L28:
        if ((!r16) == true) goto L31;
        r11 = null;
    L31:
        if (r11 == null) goto L51;
        String r17 = UriProtector.getQueryParameter(UriProtector.parse(r11), INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L64
        if (r17 == null) goto L51;
        Object r18 = Result.constructor-impl(new JSONArray(r17));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r18) == false) goto L41;
        r18 = null;
    L41:
        JSONArray r19 = (JSONArray) r18;     // Catch: Throwable -> L64
        if (r19 == null) goto L51;
        if (r19.length() <= 0) goto L46;
        r0 = true;
    L46:
        if (r0 == true) goto L49;
        r19 = null;
    L49:
        if (r19 == null) goto L51;
    L62:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L64
    L67:
        if (Result.isFailure-impl(r20) == true) goto L70;
        r13 = r20;
    L70:
        this.dataProviderService.c(r10, (JSONArray) r13, r14, new BaseHybridComponent$observeWith$1$1(this));
        return this.dataProviderService.b();
    L36:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L64
        r18 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
    L51:
        String r22 = UriProtector.getQueryParameter(UriProtector.parse(r10), INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L64
        if (r22 != null) goto L145;
        r19 = null;
        goto L62
    L145:
        Object r23 = Result.constructor-impl(new JSONArray(r22));     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r23) == false) goto L60;
        r23 = null;
    L60:
        r19 = (JSONArray) r23;     // Catch: Throwable -> L64
    L55:
        th = move-exception;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L64
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L64
        goto L58
    L23:
        if (StringsKt.isBlank(r11) == true) goto L26;
        r16 = false;
    L64:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L67
    L73:
        return MapsKt.emptyMap();
    L74:
        e r25 = this.dataHolder;
        if (r25 != null) goto L137;
        JSBridgeManager r26 = getJSBridgeManger();
        if (r26 == null) goto L81;
        r25 = ((w8.c) Annie.getService$default(w8.c.class, null, 2, null)).z0(r26, r10);
        if (r25 == null) goto L81;
        this.dataHolder = r25;
    L82:
        if (r25 != null) goto L137;
        return MapsKt.emptyMap();
    L81:
        r25 = null;
    L137:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L129
        if (r11 != null) goto L88;
    L91:
        boolean r28 = true;
    L93:
        if ((!r28) == true) goto L96;
        r11 = null;
    L96:
        if (r11 == null) goto L116;
        String r29 = UriProtector.getQueryParameter(UriProtector.parse(r11), INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L129
        if (r29 == null) goto L116;
        Object r30 = Result.constructor-impl(new JSONArray(r29));     // Catch: Throwable -> L101
    L104:
        if (Result.isFailure-impl(r30) == false) goto L106;
        r30 = null;
    L106:
        JSONArray r31 = (JSONArray) r30;     // Catch: Throwable -> L129
        if (r31 == null) goto L116;
        if (r31.length() <= 0) goto L111;
        r0 = true;
    L111:
        if (r0 == true) goto L114;
        r31 = null;
    L114:
        if (r31 == null) goto L116;
    L127:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L129
    L132:
        if (Result.isFailure-impl(r32) == true) goto L135;
        r13 = r32;
    L135:
        r25.b(r10, (JSONArray) r13, new AnonymousClass2(this));
        return r25.a();
    L101:
        th = move-exception;
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L129
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
    L116:
        String r34 = UriProtector.getQueryParameter(UriProtector.parse(r10), INITIAL_PROPS_QUERY_KEY);     // Catch: Throwable -> L129
        if (r34 != null) goto L141;
        r31 = null;
        goto L127
    L141:
        Object r35 = Result.constructor-impl(new JSONArray(r34));     // Catch: Throwable -> L120
    L123:
        if (Result.isFailure-impl(r35) == false) goto L125;
        r35 = null;
    L125:
        r31 = (JSONArray) r35;     // Catch: Throwable -> L129
    L120:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L129
        r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
        goto L123
    L88:
        if (StringsKt.isBlank(r11) == true) goto L91;
        r28 = false;
    L129:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L132
    L15:
        return MapsKt.emptyMap();
    L11:
        return MapsKt.emptyMap();
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void registerMethod(String r10, f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        JSBridgeManager r0 = getJSBridgeManger();
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }

    public <T extends com.bytedance.android.annie.service.a> void registerService(Class<? extends com.bytedance.android.annie.service.a> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "obj");
        Annie.registerService(r10, r11, getBizKey());
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public <T> void sendJsEvent(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "data");
        JSBridgeManager r0 = getJSBridgeManger();
        if (r0 == null) goto L6;
        r0.sendJSEvent(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public <P, R> void registerMethod(String r10, g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
        JSBridgeManager r0 = getJSBridgeManger();
        if (r0 == null) goto L6;
        r0.registerMethod(r10, r11);
        return;
    }

    public /* synthetic */ BaseHybridComponent(com.bytedance.android.annie.param.a r1, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
