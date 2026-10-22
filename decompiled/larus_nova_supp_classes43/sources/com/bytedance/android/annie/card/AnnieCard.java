package com.bytedance.android.annie.card;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.CardCustomMonitorKey;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.card.web.WebComponent;
import com.bytedance.android.annie.card.web.secLink.LiveSecLinkManager;
import com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy;
import com.bytedance.android.annie.container.fragment.n;
import com.bytedance.android.annie.monitor.SlardarMonitorUtils;
import com.bytedance.android.annie.param.JsGsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.HybridKitType;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.annie.util.t;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import o7.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieCard extends HybridCard implements f {
    public final AnonymousClass2 A;
    public final Lazy B;
    public volatile boolean C;
    public int D;
    public boolean E;
    public boolean F;
    public View.OnClickListener G;
    public View.OnTouchListener H;
    public CardParamVoNew j;
    public final com.bytedance.android.annie.param.a k;
    public b7.b l;
    public final Map<String, Map<String, String>> m;
    public long n;
    public String o;
    public com.bytedance.android.annie.card.base.b p;
    public final List<IHybridComponent.a> q;
    public Map<String, ? extends Object> r;
    public String s;
    public final boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public boolean x;
    public FailSubFragmentProxy y;
    public ViewGroup z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardCustomMonitorKey.values().length];
            r0[CardCustomMonitorKey.RealOpenTime.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[CardCustomMonitorKey.UserOpenTime.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[CardCustomMonitorKey.LoadScene.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[CardCustomMonitorKey.IsContainerPreload.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[CardCustomMonitorKey.IsUserOpen.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[CardCustomMonitorKey.IsPrerender.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[CardCustomMonitorKey.HasReload.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[CardCustomMonitorKey.HintSecLink.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[CardCustomMonitorKey.DidAppear.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            a = r0;
        }
    }

    public static final class c extends com.bytedance.ies.web.jsbridge2.g<JsonObject, Object> {
        public final /* synthetic */ AnnieCard a;

        public c(AnnieCard r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10, CallContext r11) {
            JsonObject r12 = (JsonObject) r10;
            Intrinsics.checkNotNullParameter(r12, "params");
            Intrinsics.checkNotNullParameter(r11, "context");
            JsonElement r13 = r12.get("eventName");
            if (r13 != null) goto L5;
            return null;
        L5:
            if (r13.isJsonPrimitive() == true) goto L7;
            return null;
        L7:
            if (TextUtils.isEmpty(r13.getAsJsonPrimitive().getAsString()) == true) goto L23;
            JsonElement r14 = r12.get("noLivePrefix");
            if (r14 != null) goto L12;
        L14:
            boolean r15 = false;
        L15:
            if (r15 == false) goto L17;
            String r16 = "noLivePrefix" + r13.getAsString();
        L18:
            this.a.m.put(r16, (Map<String, String>) GsonProtectorUtils.fromJson(new Gson(), r12.get("params"), new com.bytedance.android.annie.card.a().getType()));
            return null;
        L17:
            r16 = r13.getAsString();
            goto L18
        L12:
            if (r14.isJsonPrimitive() == false) goto L14;
            r15 = r14.getAsJsonPrimitive().getAsBoolean();
            goto L15
        L23:
            return null;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ FailSubFragmentProxy a;

        public d(FailSubFragmentProxy r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ AnnieCard a;

        public e(AnnieCard r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FailSubFragmentProxy r0 = this.a.y;     // Catch: Throwable -> L10
            if (r0 == null) goto L5;
            View r1 = r0.c;     // Catch: Throwable -> L10
        L6:
            if (r1 == null) goto L13;
            r1.setVisibility(8);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L5:
            r1 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public /* bridge */ /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.card.f
    public final void onInjectShareInfo(y6.e r1) {
    }

    private final m9.d getPerfEvent() {
        return (m9.d) this.B.getValue();
    }

    private final String getUrl() {
        CardParamVoNew r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void b() {
        CardParamVoNew r0 = this.j;
        if (r0 == null) goto L12;
        String r1 = r0.b;
        if (r1 == null) goto L13;
        Set<String> r10 = SlardarMonitorUtils.a;
        if (r0.a != HybridKitType.LYNX) goto L9;
        String r11 = "lynx";
    L10:
        SlardarMonitorUtils.b(r1, "view", r11);
        return;
    L9:
        r11 = "H5";
        goto L10
    L13:
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void d() {
        CardParamVoNew r0 = this.j;
        if (r0 == null) goto L8;
        String r1 = r0.b;
        if (r1 == null) goto L9;
        SlardarMonitorUtils.c(r1);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public String getBizKey() {
        return this.k.getBizKey();
    }

    public final PageType getPageType() {
        CardParamVoNew r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.I0();
    }

    public final void m() {
        CardParamVoNew r0 = this.j;
        if (r0 != null) goto L5;
    L25:
        x8.b r1 = this.k.d;
        StringBuilder r10 = new StringBuilder("===initView end: ");
        String r11 = getUrl();
        if (r11 != null) goto L28;
        r11 = "empty";
    L28:
        r10.append(r11);
        r10.append("===");
        r1.f("AnnieCard", "init_view_end", r10.toString());
        return;
    L5:
        if (r0.a != HybridKitType.LYNX) goto L7;
        IHybridComponent.HybridType r12 = IHybridComponent.HybridType.LYNX;
    L8:
        IHybridComponent r13 = getMCurrentHybridComponent();
        BaseHybridComponent r14 = null;
        if (r13 == null) goto L11;
        IHybridComponent.HybridType r15 = r13.hybridType();
    L12:
        if (r15 != r12) goto L21;
        CardParamVoNew r16 = this.j;
        if (r16 == null) goto L30;
        IHybridComponent r17 = getMCurrentHybridComponent();
        if ((r17 instanceof BaseHybridComponent) == false) goto L18;
        r14 = (BaseHybridComponent) r17;
    L18:
        if (r14 == null) goto L31;
        r14.updateHybridParamsNew(r16);
        return;
    L31:
        return;
    L30:
        return;
    L21:
        removeAllViews();
        IHybridComponent r18 = getMCurrentHybridComponent();
        if (r18 == null) goto L24;
        r18.release();
    L24:
        setMCurrentHybridComponent(null);
        i(r12);
        goto L25
    L11:
        r15 = null;
        goto L12
    L7:
        r12 = IHybridComponent.HybridType.H5;
        goto L8
    }

    @Override // com.bytedance.android.annie.card.f
    public final void onRefresh() {
        this.k.d.e("AnnieCard", "===onRefresh:===");
        a7.a.a(this, null, null, 3);
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        if (this.C == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.C = true;
        ExternalAddJsEventHelper.a();
        String r1 = this.s;
        if (r1 == null) goto L8;
        Lazy r10 = ContainerInitialPropsManager.a;
        Intrinsics.checkNotNullParameter(r1, "key");
        ((HashMap) ContainerInitialPropsManager.a.getValue()).remove(r1);
    L8:
        super.release();
        String r11 = this.k.getUrl();
        if (r11 != null) goto L11;
    L16:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L20;
        m9.d r13 = getPerfEvent();
        String r14 = this.k.getUrl();
        Intrinsics.checkNotNull(r14);
        r13.j1(r14);
    L21:
        b7.b r15 = this.l;
        if (r15 == null) goto L25;
        r15.onRelease();
    L25:
        if ((!this.m.isEmpty()) == false) goto L34;
        long r16 = System.currentTimeMillis();
        Iterator r17 = ((LinkedHashMap) this.m).entrySet().iterator();
    L28:
        if (r17.hasNext() == false) goto L33;
        Map.Entry r18 = (Map.Entry) r17.next();
        String r19 = (String) r18.getKey();
        Map<String, String> r20 = (Map) r18.getValue();
        if (r20.containsKey(com.bytedance.android.ec.core.event.a.KEY_DURATION) == true) goto L32;
        r20.put(com.bytedance.android.ec.core.event.a.KEY_DURATION, String.valueOf(r16 - this.n));
    L32:
        ((x9.b) k(x9.b.class)).logV3(r19, r20);
        goto L28
    L33:
        ((LinkedHashMap) this.m).clear();
    L34:
        ILatchService.e r21 = this.k.a;
        if (r21 == null) goto L37;
        r21.dispose();
    L37:
        AppCompatActivity r22 = null;
        this.k.setCommonLifecycle(null);
        this.l = null;
        this.u = -1;
        setMReleasedFlag(true);
        this.k.d.e("AnnieCard", "AnnieCard release");
        this.p = null;
        ((ArrayList) this.q).clear();
        AnonymousClass2 r23 = this.A;
        if (r23 == null) goto L46;
        AppCompatActivity r24 = getContext();
        if ((r24 instanceof AppCompatActivity) == false) goto L42;
        r22 = r24;
    L42:
        if (r22 == null) goto L46;
        Lifecycle r25 = r22.getLifecycle();
        if (r25 == null) goto L46;
        r25.removeObserver(r23);
    L46:
        CardParamVoNew r26 = this.j;
        if (r26 != null) goto L49;
    L51:
        r0 = false;
    L52:
        if (r0 == false) goto L58;
        CardParamVoNew r27 = this.j;
        if (r27 == null) goto L58;
        String r28 = (String) r27.R.getValue();
        if (r28 == null) goto L58;
        Map<String, WeakReference<AnnieCard>> r29 = p8.a.a;
        Intrinsics.checkNotNullParameter(r28, com.bytedance.android.ec.core.event.a.KEY_URL);
        WeakReference<AnnieCard> r30 = p8.a.a.remove(r28);
        int r31 = x8.a.a;
        x8.a.d("Annie_ComponentRecord", "remove(url=" + r28 + ") = " + r30, false);
    L58:
        y8.e.a.a(getContext());
        return;
    L49:
        if (r26.d() != true) goto L51;
    L20:
        this.k.d.e("AnnieCard", "annie card released but url is null");
        goto L21
    L11:
        if (r11.length() <= 0) goto L13;
        boolean r32 = true;
    L14:
        if (r32 != true) goto L16;
        r12 = true;
        goto L18
    L13:
        r32 = false;
        goto L14
    }

    private final y6.c getJSBridgeManger() {
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 != null) goto L5;
        return null;
    L5:
        return ((BaseHybridComponent) r0).getJSBridgeManger();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean canGoBack() {
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canGoBack();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void goBack() {
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 == null) goto L6;
        r0.goBack();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 == null) goto L6;
        r0.hide();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean isPopup() {
        if (getPageType() != PageType.POPUP) goto L5;
        return true;
    L5:
        return false;
    }

    public final void l() {
        if (getPageType() == PageType.CARD) goto L7;
        FailSubFragmentProxy r0 = this.y;
        if (r0 == null) goto L9;
        r0.c();
        return;
    L9:
        return;
    L7:
        ThreadUtils.c(new e(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b7.b r0 = this.l;
        if (r0 == null) goto L6;
        r0.onAttachedToWindow(this.k.getUrl());
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void show() {
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 == null) goto L6;
        r0.show();
        return;
    }

    public final com.bytedance.android.annie.param.a getMAnnieContext() {
        return this.k;
    }

    public final CardParamVoNew getMHybridParamVoNew() {
        return this.j;
    }

    public static final /* synthetic */ m9.d h(AnnieCard r0) {
        return r0.getPerfEvent();
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void c(com.bytedance.android.annie.card.base.b r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxCallback");
        IHybridComponent r0 = getMCurrentHybridComponent();
        BaseHybridComponent r1 = null;
        if (r0 == null) goto L5;
        IHybridComponent.HybridType r11 = r0.hybridType();
    L7:
        if (r11 != IHybridComponent.HybridType.LYNX) goto L14;
        IHybridComponent r12 = getMCurrentHybridComponent();
        if ((r12 instanceof BaseHybridComponent) == false) goto L11;
        r1 = (BaseHybridComponent) r12;
    L11:
        if (r1 == null) goto L15;
        r1.registerLifecycleCallback(r10);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r11 = null;
        goto L7
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void e(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        y6.c r0 = getJSBridgeManger();
        if (r0 == null) goto L6;
        r0.b(r10);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9, types: [com.bytedance.android.annie.card.AnnieCard$getBaseLifecycle$1] */
    public final void i(final IHybridComponent.HybridType r21) {
        b7.b r0 = this.l;
        if (r0 == null) goto L6;
        r0.onPrepareComponentStart();
    L6:
        if (this.s != null) goto L14;
        CardParamVoNew r1 = this.j;
        if (r1 == null) goto L14;
        String r10 = r1.o();
        if (r10 == null) goto L14;
        if ((!StringsKt.isBlank(r10)) == false) goto L14;
        this.s = UriProtector.getQueryParameter(UriProtector.parse(r10), "__initialProps_data_key");
    L14:
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        String r12 = "";
        r11.element = "";
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = "";
        Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = "";
        if (r21 != IHybridComponent.HybridType.LYNX) goto L17;
        String r15 = "lynx";
    L18:
        String r16 = r15;
        CardParamVoNew r17 = this.j;
        if (r17 == null) goto L27;
        String r18 = r17.o();
        if (r18 == null) goto L23;
        r11.element = r18;
    L23:
        String r19 = r17.b;
        if (r19 == null) goto L27;
        r13.element = r19;
        r14.element = ListProtector.get(StringsKt.split$default(r19, new String[]{"?"}, false, 0, 6, null), 0);
    L27:
        if (AnnieConfigSettingKeys.SEND_LOG_IN_CHILD_THREAD.a().booleanValue() == false) goto L29;
        Schedulers.computation().scheduleDirect(new com.bytedance.android.annie.card.c(this, r11, r16, r13, r14));
    L39:
        if (com.bytedance.android.annie.ng.g.g == false) goto L206;
        if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L206;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L206;
        throw new RuntimeException("不能在子线程创建Annie组件");
    L206:
        com.bytedance.android.annie.card.e r20 = com.bytedance.android.annie.ng.g.e;     // Catch: Throwable -> L57
        CardParamVoNew r22 = this.j;     // Catch: Throwable -> L57
        Context r23 = getContext();     // Catch: Throwable -> L57
        ?? r24 = new AnnieCard$getBaseLifecycle$1(this, r21);     // Catch: Throwable -> L57
        com.bytedance.android.annie.param.a r25 = this.k;     // Catch: Throwable -> L57
        if (((HashMap) r20.a).containsKey(r21) == false) goto L51;
        com.bytedance.android.annie.card.e.b r26 = (com.bytedance.android.annie.card.e.b) ((HashMap) r20.a).get(r21);     // Catch: Throwable -> L57
    L52:
        if (r26 != 0) goto L54;
        IHybridComponent r27 = null;
    L55:
        setMCurrentHybridComponent(r27);     // Catch: Throwable -> L57
    L74:
        b7.b r28 = this.l;
        if (r28 == null) goto L77;
        r28.onPrepareComponentEnd();
    L77:
        KeyEvent.Callback r29 = getHybridView();
        if ((r29 instanceof o7.a) == false) goto L80;
        o7.a r30 = (o7.a) r29;
    L81:
        if (r30 == null) goto L84;
        r30.b();
    L84:
        if (getMCurrentHybridComponent() == null) goto L86;
    L89:
        IHybridComponent r31 = getMCurrentHybridComponent();
        if (r31 == null) goto L92;
        r31.registerMethod("lynxReleaseSendLog", new c(this));
    L92:
        IHybridComponent r32 = getMCurrentHybridComponent();
        if (r32 == null) goto L159;
        View r33 = r32.getHybridView();
        if (r33 == null) goto L159;
        b7.b r34 = this.l;
        if (r34 == null) goto L105;
        CardParamVoNew r35 = this.j;
        if (r35 == null) goto L103;
        PageType r36 = r35.I0();
        if (r36 == null) goto L103;
        String r37 = r36.getPageType();
    L104:
        r34.onAttachView(r33, r21, r37);
    L103:
        r37 = null;
    L105:
        addView(r33);
        View.OnTouchListener r38 = this.H;
        if (r38 == null) goto L108;
        r33.setOnTouchListener(r38);
    L108:
        View.OnClickListener r39 = this.G;
        if (r39 == null) goto L112;
        r33.setOnClickListener(r39);
    L112:
        if (isPopup() == true) goto L159;
        CardParamVoNew r40 = this.j;
        if (r40 == null) goto L118;
        String r110 = r40.g();
        if (r110 == null) goto L118;
        List r41 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
    L119:
        List r42 = r41;
        if (r42 != null) goto L122;
    L125:
        boolean r43 = true;
    L127:
        if (r43 == true) goto L148;
        int r44 = r41.size();
        if (2 > r44) goto L132;
        if (r44 >= 4) goto L132;
        boolean r45 = true;
    L133:
        if (r45 == false) goto L148;
        int[] r46 = new int[r41.size()];
        Iterator r47 = r41.iterator();
        int r48 = 0;
    L136:
        if (r47.hasNext() == false) goto L138;
        r46[r48] = n.a((String) r47.next(), -1, ColorProtector.parseColor("#00000000"));
        r48 = r48 + 1;
        goto L136
    L138:
        int r49 = n.a;
        Integer r50 = Integer.valueOf(t.a.h());
        CardParamVoNew r51 = this.j;
        if (r51 == null) goto L141;
        int r52 = r51.h();
    L142:
        ShapeDrawable r53 = n.c(r50, r52, r46);
        setBackgroundDrawable(r53);
        ViewParent r54 = getParent();
        if ((r54 instanceof FrameLayout) == false) goto L145;
        FrameLayout r55 = (FrameLayout) r54;
    L146:
        if (r55 == null) goto L159;
        r55.setBackgroundDrawable(r53);
        goto L159
    L145:
        r55 = null;
        goto L146
    L141:
        r52 = 0;
    L132:
        r45 = false;
    L148:
        CardParamVoNew r56 = this.j;
        if (r56 == null) goto L159;
        String r57 = r56.s();
        if (r57 == null) goto L159;
        int r58 = n.a(r57, -1, 0);
        setBackgroundColor(r58);
        ViewParent r59 = getParent();
        if ((r59 instanceof FrameLayout) == false) goto L155;
        FrameLayout r60 = (FrameLayout) r59;
    L156:
        if (r60 == null) goto L159;
        r60.setBackgroundColor(r58);
        goto L159
    L155:
        r60 = null;
        goto L156
    L122:
        if (r42.isEmpty() == true) goto L125;
        r43 = false;
    L118:
        r41 = null;
    L159:
        if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L161;
        ((c9.d) k(c9.d.class)).c0(getContext(), this);
    L161:
        y6.c r61 = getJSBridgeManger();
        if (r61 == null) goto L173;
        Iterator<T> r62 = this.q.iterator();
    L165:
        if (r62.hasNext() == false) goto L167;
        ((IHybridComponent.a) r62.next()).onJSBridgeCreated(r61);
        goto L165
    L167:
        ILatchService.e r63 = this.k.a;
        if (r63 == null) goto L171;
        r63.f(r61.d());
    L171:
        if ((r61 instanceof JSBridgeManager) == false) goto L173;
        ((JSBridgeManager) r61).t.a(this);
    L173:
        CardParamVoNew r64 = this.j;
        if (r64 != null) goto L176;
    L178:
        boolean r65 = false;
    L179:
        if (r65 == false) goto L204;
        CardParamVoNew r66 = this.j;
        if (r66 == null) goto L204;
        String r67 = (String) r66.R.getValue();
        if (r67 == null) goto L204;
        Map<String, WeakReference<AnnieCard>> r68 = p8.a.a;
        Intrinsics.checkNotNullParameter(r67, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(this, "card");
        int r69 = x8.a.a;
        x8.a.d("Annie_ComponentRecord", "add(url=" + r67 + ", card=" + this + ')', false);
        if (r67.length() != 0) goto L187;
        boolean r70 = true;
    L188:
        if (r70 == true) goto L204;
        Integer r71 = AnnieConfigSettingKeys.LIVE_ENABLE_VIEW_REMOVE.a();
        if (r71 != null) goto L194;
    L196:
        Map<String, WeakReference<AnnieCard>> r72 = p8.a.a;
        if (r72.containsKey(r67) == false) goto L203;
        WeakReference r73 = (WeakReference) ((LinkedHashMap) r72).get(r67);
        if (r73 == null) goto L203;
        AnnieCard r74 = (AnnieCard) r73.get();
        if (r74 == null) goto L203;
        r74.release();
        r74.removeAllViews();
        r74.s = null;
        r74.G = null;
        r74.setMCurrentHybridComponent(null);
        r74.setDestroyedFlag(true);
        Unit r75 = Unit.INSTANCE;
        x8.a.d("Annie_ComponentRecord", "destroyed url = ".concat(r67), false);
    L203:
        r72.put(r67, new WeakReference(this));
        goto L204
    L194:
        if (r71.intValue() != 0) goto L196;
        x8.a.d("Annie_ComponentRecord", "disable view remove url=".concat(r67), false);
        goto L204
    L187:
        r70 = false;
    L204:
        setMReleasedFlag(false);
        return;
    L176:
        if (r64.d() != true) goto L178;
        r65 = true;
        goto L179
    L86:
        if (r21 != IHybridComponent.HybridType.LYNX) goto L89;
        n(200, this.o);
        return;
    L80:
        r30 = null;
        goto L81
    L54:
        r27 = r26.a(r23, r22, r24, r25);     // Catch: Throwable -> L57
        goto L55
    L51:
        r26 = 0;
    L57:
        th = move-exception;
        CardParamVoNew r76 = this.j;
        if (r76 == null) goto L63;
        String r77 = r76.e();
        if (r77 == null) goto L63;
        q(new AnnieCard$createAndAddView$1$1(this), r77);
    L63:
        b7.b r78 = this.l;
        String r79 = "unknown container error";
        if (r78 == null) goto L69;
        String r80 = th.getMessage();
        if (r80 != null) goto L68;
        r80 = "unknown container error";
    L68:
        r78.onContainerError(null, 200, r80);
    L69:
        String r81 = th.getMessage();
        if (r81 == null) goto L73;
        r79 = r81;
    L73:
        this.o = r79;
        this.k.d.a("AnnieCard", "type: " + r21 + ", reason: " + this.o);
        goto L74
    L29:
        String r82 = (String) r11.element;
        String r83 = (String) r13.element;
        String r84 = (String) r14.element;
        x9.b r85 = (x9.b) k(x9.b.class);
        Pair[] r86 = new Pair[5];
        r86[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEME, r82);
        r86[1] = TuplesKt.to("container_type", r16);
        r86[2] = TuplesKt.to("original_url", r83);
        r86[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r84);
        CardParamVoNew r87 = getMHybridParamVoNew();
        if (r87 == null) goto L37;
        PageType r88 = r87.I0();
        if (r88 == null) goto L37;
        String r89 = r88.getPageType();
        if (r89 == null) goto L37;
        r12 = r89;
    L37:
        r86[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE, r12);
        r85.logV3("livesdk_live_container_load", MapsKt.mutableMapOf(r86));
        goto L39
    L17:
        r15 = "web";
        goto L18
    }

    public final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, "theme");
        if (this.y == null) goto L5;
        return;
    L5:
        ViewGroup r1 = this.z;
        if (r1 != null) goto L8;
    L12:
        r1 = this;
    L13:
        Context r11 = getContext();
        Pair[] r12 = new Pair[4];
        boolean r0 = false;
        r12[0] = TuplesKt.to("theme", r10);
        CardParamVoNew r13 = this.j;
        if (r13 == null) goto L16;
        PageType r14 = r13.I0();
    L18:
        if (r14 != PageType.POPUP) goto L20;
        boolean r15 = true;
    L21:
        r12[1] = TuplesKt.to("is_popup", String.valueOf(r15));
        CardParamVoNew r16 = this.j;
        if (r16 == null) goto L28;
        String r17 = r16.o();
        if (r17 == null) goto L28;
        if (StringsKt.contains$default(r17, "gravity=bottom", false, 2, null) != true) goto L28;
        r0 = true;
    L28:
        r12[2] = TuplesKt.to("is_bottom_popup", String.valueOf(r0));
        r12[3] = TuplesKt.to("popup_width", String.valueOf(this.D));
        FailSubFragmentProxy r18 = u7.b.a(r1, r11, MapsKt.hashMapOf(r12), getBizKey());
        ThreadUtils.c(new d(r18));
        this.y = r18;
        return;
    L20:
        r15 = false;
        goto L21
    L16:
        r14 = null;
        goto L18
    L8:
        if (getPageType() == null) goto L12;
        if (getPageType() == PageType.CARD) goto L12;
        goto L12
    }

    public final <T extends com.bytedance.android.annie.service.a> T k(Class<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return (T) Annie.getService(r10, getBizKey());
    }

    public final void o(com.bytedance.android.annie.card.web.e r10) {
        Intrinsics.checkNotNullParameter(r10, "webCallback");
        IHybridComponent r0 = getMCurrentHybridComponent();
        BaseHybridComponent r1 = null;
        if (r0 == null) goto L5;
        IHybridComponent.HybridType r11 = r0.hybridType();
    L7:
        if (r11 != IHybridComponent.HybridType.H5) goto L13;
        IHybridComponent r12 = getMCurrentHybridComponent();
        if ((r12 instanceof BaseHybridComponent) == false) goto L11;
        r1 = (BaseHybridComponent) r12;
    L11:
        if (r1 == null) goto L15;
        r1.registerLifecycleCallback(r10);
        return;
    L15:
        return;
    L13:
        this.p = r10;
        return;
    L5:
        r11 = null;
        goto L7
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        if (getPageType() == PageType.POPUP) goto L13;
        x8.b r0 = this.k.d;
        StringBuilder r1 = new StringBuilder("onConfigurationChanged, widthDp:");
        Object r11 = "-1";
        if (r10 == null) goto L7;
        Object r12 = Integer.valueOf(r10.screenWidthDp);
    L8:
        r1.append(r12);
        r1.append(", heightDp: ");
        if (r10 == null) goto L11;
        r11 = Integer.valueOf(r10.screenHeightDp);
    L11:
        r1.append(r11);
        r0.e("AnnieCard", r1.toString());
        this.k.e.b(r10, this);
        return;
    L7:
        r12 = "-1";
        goto L8
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.t == false) goto L5;
        Paint r0 = new Paint();
        r0.setStrokeWidth(6.0f);
        r0.setColor(ColorProtector.parseColor("#FF0000"));
        r10.drawLine(0.0f, 0.0f, getWidth(), 0.0f, r0);
        r10.drawLine(0.0f, 0.0f, 0.0f, getHeight(), r0);
        r10.drawLine(getWidth(), 0.0f, getWidth(), getHeight(), r0);
        r10.drawLine(0.0f, getHeight(), getWidth(), getHeight(), r0);
    L5:
        super.onDraw(r10);
    }

    public final void setDialogWidth(int r1) {
        this.D = r1;
    }

    public final void setErrorPageCloseHandler(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "closeHandler");
        FailSubFragmentProxy r0 = this.y;
        if ((r0 instanceof FailSubFragmentProxy) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter(r10, "handler");
        if (r0.f != null) goto L13;
        r0.f = r10;
        return;
    L13:
        return;
    }

    public final void setErrorPageRetryHandler(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "retryHandler");
        FailSubFragmentProxy r0 = this.y;
        if ((r0 instanceof FailSubFragmentProxy) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter(r10, "handler");
        if (r0.e != null) goto L13;
        r0.e = r10;
        return;
    L13:
        return;
    }

    public final void setErrorPageRoot(ViewGroup r1) {
        this.z = r1;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        ((ArrayList) this.q).add(r10);
        y6.c r0 = getJSBridgeManger();
        if (r0 == null) goto L6;
        r10.onJSBridgeCreated(r0);
        return;
    }

    public final void setMHybridParamVoNew(CardParamVoNew r1) {
        this.j = r1;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r10) {
        this.G = r10;
        View r0 = getHybridView();
        if (r0 == null) goto L6;
        r0.setOnClickListener(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 == null) goto L6;
        r0.setOnScrollChangeListener(r10);
        return;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r10) {
        super.setOnTouchListener(r10);
        this.H = r10;
        View r0 = getHybridView();
        if (r0 == null) goto L6;
        r0.setOnTouchListener(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public void setRadius(float r10) {
        if (AnnieConfigSettingKeys.ANNIE_CARD_USE_CLIP_PATH.a().booleanValue() == false) goto L5;
        super.setRadius(r10);
        return;
    L5:
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 == null) goto L10;
        r0.setRadius(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 == null) goto L6;
        r0.updateData(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 == null) goto L6;
        r0.updateGlobalProps(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void a(Uri r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        x8.b r1 = this.k.d;
        StringBuilder r12 = new StringBuilder("===loadSchema:");
        String r13 = getUrl();
        if (r13 != null) goto L5;
        r13 = "empty";
    L5:
        r12.append(r13);
        r12.append("====");
        r1.e("AnnieCard", r12.toString());
        String r14 = r10.getHost();
        boolean r15 = false;
        if (r14 != null) goto L8;
    L10:
        if (r15 == true) goto L12;
        this.v = true;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        this.j = com.bytedance.android.annie.param.c.a(r10, null);
        m();
        a7.a.a(this, null, r11, 1);
        return;
    L12:
        if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L14;
        com.bytedance.android.annie.util.c.a(r10 + "需要重定向，不支持直接加载！");
    L14:
        this.k.d.a("AnnieCard", r10 + " needs to be redirected and should not be loaded directly!");
        return;
    L8:
        if (StringsKt.contains$default(r14, "webcast_redirect", false, 2, null) != true) goto L10;
        r15 = true;
        goto L10
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void f(int r10, int r11) {
        IHybridComponent r0 = getMCurrentHybridComponent();
        if ((r0 instanceof BaseHybridComponent) == false) goto L5;
        BaseHybridComponent r1 = (BaseHybridComponent) r0;
    L6:
        if (r1 == null) goto L9;
        r1.updateScreenMetrics(r10, r11);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard
    public final void g(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "visibleChangeReason");
        JSONObject r0 = new JSONObject();
        r0.put("visible", r10);
        r0.put("source", r11);
        Unit r12 = Unit.INSTANCE;
        sendJsEvent("pageVisibilityChange", r0);
        if (r10 == false) goto L5;
        sendJsEvent("viewAppeared", new JSONObject());
        return;
    L5:
        sendJsEvent("viewDisappeared", new JSONObject());
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r10, Map<String, ? extends Object> r11) {
        p(CardCustomMonitorKey.HasReload, Integer.valueOf(this.f ? 1 : 0));
        this.w = true;
        if (r11 == null) goto L6;
        this.r = r11;
    L6:
        if (this.r != null) goto L12;
        String r0 = this.s;
        if (r0 == null) goto L12;
        Lazy r1 = ContainerInitialPropsManager.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        JsonObject r12 = (JsonObject) ((HashMap) ContainerInitialPropsManager.a.getValue()).get(r0);
        if (r12 == null) goto L12;
        Lazy r13 = UtilsKt.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        this.r = new JsGsonMap(r12);
        Unit r14 = Unit.INSTANCE;
    L12:
        x8.b r15 = this.k.d;
        StringBuilder r16 = new StringBuilder("===load: ");
        if (r10 != null) goto L15;
        String r17 = "empty";
    L16:
        r16.append(r17);
        r16.append("===");
        r15.e("AnnieCard", r16.toString());
        if (r11 != null) goto L19;
        r11 = this.r;
    L19:
        super.load(r10, r11);
        return;
    L15:
        r17 = r10;
        goto L16
    }

    public final void n(int r10, String r11) {
        CardParamVoNew r0 = this.j;
        if (r0 != null) goto L5;
    L24:
        CardParamVoNew r1 = this.j;
        if (r1 == null) goto L27;
        String r12 = r1.c;
    L29:
        if (TextUtils.isEmpty(r12) == true) goto L65;
        removeAllViews();
        IHybridComponent r13 = getMCurrentHybridComponent();
        if (r13 == null) goto L33;
        r13.release();
    L33:
        setMCurrentHybridComponent(null);
        if (r12 != null) goto L36;
    L40:
        CardParamVoNew r14 = this.j;
        if (r14 == null) goto L54;
        String r15 = r14.b;
        if (r15 == null) goto L54;
        String r16 = r14.o();
        if (LiveSecLinkManager.b(r15, r16, getBizKey()) == false) goto L54;
        com.bytedance.android.annie.param.a r17 = this.k;
        if (r17 == null) goto L51;
        x8.b r18 = r17.d;
        if (r18 == null) goto L51;
        r18.a("AnnieCard", "invalid scheme " + r16);
    L51:
        b7.b r19 = this.l;
        if (r19 == null) goto L54;
        r19.onContainerError(null, 500, "invalid scheme " + r16);
    L54:
        i(IHybridComponent.HybridType.H5);
        com.bytedance.android.annie.card.base.b r20 = this.p;
        if (r20 == null) goto L62;
        IHybridComponent r21 = getMCurrentHybridComponent();
        if ((r21 instanceof WebComponent) == false) goto L59;
        WebComponent r22 = (WebComponent) r21;
    L60:
        if (r22 == null) goto L62;
        r22.registerLifecycleCallback(r20);
        goto L62
    L59:
        r22 = null;
    L62:
        IHybridComponent r23 = getMCurrentHybridComponent();
        if (r23 == null) goto L72;
        a7.a.a(r23, null, this.r, 1);
        return;
    L72:
        return;
    L36:
        if (l.f(r12) == false) goto L38;
        int r24 = com.bytedance.android.annie.param.c.a;
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        CardParamVoNew r25 = com.bytedance.android.annie.param.c.a(UriProtector.parse("sslocal://webcast_webview?type=card&hybrid_type=h5&url=" + Uri.encode(r12)), null);
    L39:
        this.j = r25;
        goto L40
    L38:
        r25 = com.bytedance.android.annie.param.c.a(UriProtector.parse(r12), null);
        goto L39
    L65:
        FailSubFragmentProxy r26 = this.y;
        if (r26 == null) goto L68;
        r26.d();
    L68:
        b7.b r27 = this.l;
        if (r27 == null) goto L74;
        r27.onFallback(r10, r11);
        return;
    L74:
        return;
    L27:
        r12 = null;
        goto L29
    L5:
        if (r0.a != HybridKitType.LYNX) goto L24;
        String r28 = r0.c;
        if ((!StringsKt.isBlank(r28)) == true) goto L11;
        r28 = null;
    L11:
        if (r28 == null) goto L24;
        b7.b r29 = this.l;
        if (r29 == null) goto L15;
        r29.onInnerFallback(r10, r11);
    L15:
        b7.b r30 = this.l;
        if (r30 == null) goto L18;
        r30.onInit(this.k);
    L18:
        b7.b r31 = this.l;
        if (r31 == null) goto L21;
        r31.onBeforeOpenContainer();
    L21:
        b7.b r32 = this.l;
        if (r32 == null) goto L24;
        r32.onPrepareInitDataStart(r28, "", true);
        goto L24
    }

    public final void p(CardCustomMonitorKey r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (this.k.getMonitorID() != null) goto L5;
        return;
    L5:
        String r0 = this.k.getMonitorID();
        Intrinsics.checkNotNull(r0);
        k9.d r1 = ((k9.e) k(k9.e.class)).V0();
        this.k.d.e("AnnieCard", "setCustomMonitorKey " + r10 + ", value: " + r11 + ", monitorId: " + r0);
        switch(b.a[r10.ordinal()]) {
            case 1: goto L41;
            case 2: goto L35;
            case 3: goto L31;
            case 4: goto L27;
            case 5: goto L24;
            case 6: goto L19;
            case 7: goto L15;
            case 8: goto L12;
            case 9: goto L9;
            default: goto L73;
        };
    L12:
        r1.d(r0, "hint_seclink", r11.toString());
        Bundle r12 = this.k.getBundle();
        if (r12 == null) goto L55;
        r12.putString("hint_seclink", r11.toString());
        return;
    L55:
        return;
    L15:
        r1.d(r0, "has_reload", r11.toString());
        Bundle r13 = this.k.getBundle();
        if (r13 == null) goto L57;
        r13.putString("has_reload", r11.toString());
        return;
    L57:
        return;
    L24:
        r1.d(r0, "is_user_open", r11.toString());
        Bundle r14 = this.k.getBundle();
        if (r14 == null) goto L62;
        r14.putString("is_user_open", r11.toString());
        return;
    L62:
        return;
    L27:
        r1.d(r0, "is_container_preload", r11.toString());
        Bundle r15 = this.k.getBundle();
        if (r15 == null) goto L64;
        r15.putString("is_container_preload", r11.toString());
        return;
    L64:
        return;
    L73:
        return;
    L9:
        if ((r11 instanceof Long) == false) goto L11;
        r1.c(r0, "containerview_didappear", ((Number) r11).longValue());
        return;
    L11:
        this.k.d.e("AnnieCard", "setCustomMonitorKey " + r10 + ", typeof value is not Long, do nothing");
        return;
    L19:
        if ((r11 instanceof Integer) == false) goto L23;
        r1.a(r0, "is_prerender", ((Number) r11).intValue());
        Bundle r16 = this.k.getBundle();
        if (r16 == null) goto L59;
        r16.putString("is_prerender", r11.toString());
        return;
    L59:
        return;
    L23:
        this.k.d.e("AnnieCard", "setCustomMonitorKey " + r10 + ", typeof value is not Int, do nothing");
        return;
    L31:
        if ((r11 instanceof Integer) == false) goto L33;
        r1.b(r0, ((Number) r11).intValue());
        return;
    L33:
        this.k.d.e("AnnieCard", "setCustomMonitorKey " + r10 + ", typeof value is not Int, do nothing");
        return;
    L35:
        if ((r11 instanceof Long) == false) goto L39;
        r1.c(r0, "user_open_time", ((Number) r11).longValue());
        Bundle r17 = this.k.getBundle();
        if (r17 == null) goto L68;
        r17.putString("user_open_time", r11.toString());
        return;
    L68:
        return;
    L39:
        this.k.d.e("AnnieCard", "setCustomMonitorKey " + r10 + ", typeof value is not Long, do nothing");
        return;
    L41:
        if (this.x == false) goto L43;
        return;
    L43:
        this.x = true;
        if ((r11 instanceof Long) == false) goto L51;
        Number r18 = (Number) r11;
        r1.c(r0, "open_time", r18.longValue());
        Bundle r19 = this.k.getBundle();
        if (r19 == null) goto L48;
        r19.putString("has_reload", r11.toString());
    L48:
        Bundle r110 = this.k.getBundle();
        if (r110 == null) goto L71;
        r110.putLong("real_open_time", r18.longValue());
        return;
    L71:
        return;
    L51:
        this.k.d.e("AnnieCard", "setCustomMonitorKey " + r10 + ", typeof value is not Long, do nothing");
    }

    public final void q(Function0<Unit> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "retryHandler");
        Intrinsics.checkNotNullParameter(r11, "theme");
        if (CollectionsKt.listOf(new String[]{"sjb", "light", "dark"}).contains(r11) == true) goto L5;
        return;
    L5:
        j(r11);
        FailSubFragmentProxy r12 = this.y;
        FailSubFragmentProxy r0 = null;
        if (r12 == null) goto L8;
        View r13 = r12.c;
    L9:
        if (r13 == null) goto L12;
        r13.setVisibility(0);
    L12:
        FailSubFragmentProxy r14 = this.y;
        if (r14 == null) goto L15;
        r14.d();
    L15:
        FailSubFragmentProxy r15 = this.y;
        if ((r15 instanceof FailSubFragmentProxy) == true) goto L20;
        r15 = null;
    L20:
        if (r15 == null) goto L25;
        Intrinsics.checkNotNullParameter(r10, "handler");
        if (r15.e != null) goto L25;
        r15.e = r10;
    L25:
        FailSubFragmentProxy r16 = this.y;
        if ((r16 instanceof FailSubFragmentProxy) == false) goto L28;
        r0 = r16;
    L28:
        if (r0 == null) goto L36;
        Function0<Unit> r17 = this.k.b;
        if (r17 == null) goto L37;
        Intrinsics.checkNotNullParameter(r17, "handler");
        if (r0.f != null) goto L38;
        r0.f = r17;
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L8:
        r13 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r12v22, types: [androidx.lifecycle.LifecycleObserver, com.bytedance.android.annie.card.AnnieCard$2] */
    public AnnieCard(final Context r11, CardParamVoNew r12, com.bytedance.android.annie.param.a r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "mAnnieContext");
        AppCompatActivity r0 = null;
        int r10 = 0;
        super(r11, r0, 6, r10);
        this.j = r12;
        this.k = r13;
        this.l = r13.getCommonLifecycle();
        this.m = new LinkedHashMap();
        this.o = "";
        this.q = new ArrayList();
        boolean r14 = AnnieConfigSettingKeys.STROKE_SWITCH.a().booleanValue();
        this.t = r14;
        this.u = -1;
        this.B = LazyKt.lazy(new AnnieCard$perfEvent$2(this));
        this.D = -1;
        this.F = true;
        x8.b r15 = r13.d;
        StringBuilder r16 = new StringBuilder("===init start: ");
        String r17 = getUrl();
        String r18 = "empty";
        if (r17 != null) goto L5;
        r17 = "empty";
    L5:
        r16.append(r17);
        r16.append("===");
        r15.f("AnnieCard", "init_annie_card", r16.toString());
        b7.b r19 = this.l;
        if (r19 == null) goto L8;
        r19.onContainerInitEnd();
    L8:
        ExternalAddJsEventHelper.b();
        if (r13.b != null) goto L11;
        r13.b = new AnonymousClass1(this);
    L11:
        m();
        if (r14 == false) goto L14;
        setWillNotDraw(false);
        setPadding(6, 6, 6, 6);
    L14:
        y8.e r110 = y8.e.a;
        Intrinsics.checkNotNullParameter(r11, "context");
        Object r1 = y8.e.c;
        monitor-enter(r1);
    L39:
        th = move-exception;
        throw th;
    L17:
        if (y8.e.b != 0) goto L19;
        r11.registerComponentCallbacks(r110);     // Catch: Throwable -> L39
    L19:
        y8.e.b++;     // Catch: Throwable -> L39
        monitor-exit(r1);
        if (AnnieConfigSettingKeys.MEMORY_LEAK_REPORTER.a().booleanValue() == false) goto L30;
        ?? r111 = new AnonymousClass2(this, r11);
        this.A = r111;
        if ((r11 instanceof AppCompatActivity) == false) goto L26;
        r0 = (AppCompatActivity) r11;
    L26:
        if (r0 == null) goto L30;
        Lifecycle r112 = r0.getLifecycle();
        if (r112 == null) goto L30;
        r112.addObserver(r111);
    L30:
        r13.e.c(p.a.getResources());
        x8.b r113 = r13.d;
        StringBuilder r114 = new StringBuilder("===init end: ");
        String r20 = getUrl();
        if (r20 == null) goto L34;
        r18 = r20;
    L34:
        r114.append(r18);
        r114.append("===");
        r113.f("AnnieCard", "init_card_end", r114.toString());
        CardCustomMonitorKey r115 = CardCustomMonitorKey.IsPrerender;
        Bundle r116 = r13.getBundle();
        if (r116 == null) goto L37;
        r10 = r116.getInt("isPrerender");
    L37:
        p(r115, Integer.valueOf(r10));
    }

    @Override // com.bytedance.android.annie.api.card.HybridCard, com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public final void setRadius(float r10, float r11, float r12, float r13) {
        if (AnnieConfigSettingKeys.ANNIE_CARD_USE_CLIP_PATH.a().booleanValue() == false) goto L5;
        super.setRadius(r10, r11, r12, r13);
        return;
    L5:
        IHybridComponent r0 = getMCurrentHybridComponent();
        if (r0 == null) goto L10;
        r0.setRadius(r10, r11, r12, r13);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r10, int r11, int r12, int r13) {
        super.onLayout(r1, r10, r11, r12, r13);
        Configuration r14 = p.a.getResources().getConfiguration();
        if (r14 == null) goto L5;
        int r15 = r14.orientation;
    L6:
        int r16 = this.u;
        if (r16 != (-1)) goto L9;
        this.u = r15;
        return;
    L9:
        if (r15 == r16) goto L22;
        this.u = r15;
        JSONObject r17 = new JSONObject();
        int r18 = this.u;
        if (r18 != 1) goto L13;
        String r19 = "portrait";
    L18:
        if (Intrinsics.areEqual(r19, "") == true) goto L23;
        r17.put("screenOrientation", r19);
        sendJsEvent("orientationChanged", r17);
        return;
    L23:
        return;
    L13:
        if (r18 == 2) goto L15;
        r19 = "";
        goto L18
    L15:
        r19 = "landscape";
        goto L18
    L22:
        return;
    L5:
        r15 = -1;
        goto L6
    }
}
