package com.bytedance.ai.model.widgets;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.assem.arch.core.Assem;
import com.bytedance.assem.arch.core.UIAssem;
import com.bytedance.assem.arch.extensions.VMExtKt;
import com.bytedance.assem.arch.view.UIContentAssem;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ivy.ivykit.plugin.impl.web.PluginWebView;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import m5.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010,\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J\u001f\u00101\u001a\u00020\u001c2\u0006\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0002\u00104J\u0018\u00105\u001a\u00020.2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0016J\b\u00109\u001a\u00020.H\u0002J\b\u0010:\u001a\u00020.H\u0002J&\u0010;\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u00010&2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0=H\u0002J2\u0010>\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0=2\b\u00102\u001a\u0004\u0018\u00010&2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0=H\u0002J&\u0010?\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010&2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0=H\u0002J\u000e\u0010@\u001a\u00020\u001c*\u0004\u0018\u00010&H\u0002J\b\u0010A\u001a\u00020.H\u0016J\u0012\u0010B\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010&H\u0002J\n\u00102\u001a\u0004\u0018\u00010&H\u0016J\n\u0010C\u001a\u0004\u0018\u000100H\u0016J\n\u0010D\u001a\u0004\u0018\u000100H\u0016J\b\u0010E\u001a\u00020.H\u0016J\u0012\u0010J\u001a\u00020.2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\b\u0010K\u001a\u00020.H\u0002J\u0012\u0010L\u001a\u00020.2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010M\u001a\u00020&H\u0002J\u0010\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020&H\u0016J\u001a\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020&2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\n\u0010T\u001a\u0004\u0018\u00010UH\u0016J\u0010\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020&H\u0016J\u001c\u0010X\u001a\u00020.2\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020[0ZH\u0016J\b\u0010\\\u001a\u00020.H\u0016J\b\u0010]\u001a\u00020\u001cH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/bytedance/ai/model/widgets/WebEngineAssem;", "Lcom/bytedance/assem/arch/view/UIContentAssem;", "Lcom/bytedance/ai/api/model/view/IAIRenderEngineService;", "<init>", "()V", "ivyWebViewClient", "Lcom/ivy/ivykit/api/plugin/web/IvyWebClient;", "ivyWebView", "Lcom/ivy/ivykit/api/plugin/render/WebViewPluginView;", "mRenderStateVM", "Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "getMRenderStateVM", "()Lcom/bytedance/ai/model/viewmodel/RenderStateVM;", "mRenderStateVM$delegate", "Lcom/bytedance/assem/arch/viewModel/AssemVMLazy;", "mRenderData", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "getMRenderData", "()Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "mRenderData$delegate", "Lcom/bytedance/assem/arch/extensions/HierarchyLazy;", "webView", "Landroid/webkit/WebView;", "mHandler", "Landroid/os/Handler;", "webViewJSBridge", "Lcom/bytedance/ai/model/WebViewJSBridge;", "isPopup", "", "isReachTop", "isReachBottom", "lastY", "", "pullUp", "touchSlop", "activePointerId", "isBeingDragged", "traceId", "", "eventType", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "safeGetRenderState", "onViewCreated", "", "view", "Landroid/view/View;", "shouldOverrideUrlLoading", com.bytedance.android.ec.core.event.a.KEY_URL, "openHttpBySystem", "(Ljava/lang/String;Ljava/lang/Boolean;)Z", "handleWebViewDrawEnd", "navigationStart", "", "drawEnd", "createIvyWebClient", "createHybridKit", "addCommonQuery", "requestHeaders", "", "addCommonHeaders", "checkWhiteList", "urlCheck", "doRefresh", "isDomStorageEnabled", "realView", "engineView", "onDestroy", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "webViewPort", "Lcom/bytedance/ai/applet/render/core/web/WebViewAIBridgePort;", "bindingWebView", "registerAIBridgeMethods", "injectWebViewData", "viewContext", "onMessageToJS", com.bytedance.android.ec.core.event.a.KEY_MSG, "onMessageToAIBridge", "eventName", "params", "Lcom/google/gson/JsonObject;", "getAIBridge", "Lcom/bytedance/ai/bridge/IAIBridge;", "setTitle", "title", "setTitleBar", "settings", "", "", "onBackPress", "goBack", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebEngineAssem extends UIContentAssem implements k2.q {
    public static final /* synthetic */ int C = 0;
    public d3.w A;
    public WebViewAIBridgePort B;
    public lx7.a j;
    public kx7.c k;
    public final com.bytedance.assem.arch.viewModel.b l;
    public final com.bytedance.assem.arch.extensions.f m;
    public WebView n;
    public final Handler o;
    public com.bytedance.ai.model.o0 p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public int v;
    public int w;
    public boolean x;
    public String y;
    public String z;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void f() {
    }

    @Override // k2.q
    public final void doRefresh() {
        kx7.c r0 = this.k;
        String r1 = null;
        if (r0 == null) goto L5;
        String r10 = r0.i();
    L6:
        k2.b r11 = t();
        if (r11 == null) goto L9;
        String r12 = r11.b;
    L11:
        if (Intrinsics.areEqual(r10, r12) == false) goto L13;
        s();
        return;
    L13:
        kx7.c r13 = this.k;
        if (r13 == null) goto L16;
        r1 = r13.i();
    L16:
        if (r1 != null) goto L18;
    L21:
        boolean r14 = true;
    L22:
        if (r14 == false) goto L30;
        k2.b r15 = t();
        if (r15 == null) goto L35;
        String r16 = r15.b;
        if (r16 == null) goto L36;
        kx7.c r17 = this.k;
        if (r17 == null) goto L37;
        r17.d(r16);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L30:
        kx7.c r18 = this.k;
        if (r18 == null) goto L39;
        r18.g();
        return;
    L39:
        return;
    L18:
        if (r1.length() == 0) goto L21;
        r14 = false;
        goto L22
    L9:
        r12 = null;
        goto L11
    L5:
        r10 = null;
        goto L6
    }

    @Override // k2.q
    public final boolean goBack() {
        kx7.c r0 = this.k;
        if (r0 == null) goto L5;
        boolean r1 = r0.a();
    L6:
        if (r1 == false) goto L12;
        kx7.c r10 = this.k;
        if (r10 == null) goto L10;
        r10.c();
    L10:
        return true;
    L12:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // k2.q
    public final void onBackPress() {
        kx7.c r0 = this.k;
        if (r0 == null) goto L10;
        JSONObject r1 = new JSONObject();
        kx7.c r10 = this.k;
        if (r10 == null) goto L7;
        String r11 = r10.b();
    L8:
        r1.put("containerID", r11);
        Unit r12 = Unit.INSTANCE;
        r0.h("bulletOnBackPressAction", r1);
        return;
    L7:
        r11 = null;
        goto L8
    }

    public final void onDestroy() {
        com.bytedance.ai.utils.g.a.i("WebViewAssem", "onDestroy");
        this.o.postDelayed(new e0(this), 2000);
        String r0 = this.y;
        if (r0 == null) goto L8;
        String r1 = this.z;
        if (r1 == null) goto L9;
        i1 r10 = m5.y0.a;
        m5.y0.p(r0, r1, true);
        m5.y0.o(r0, r1);
        return;
    L9:
        return;
    }

    @Override // k2.o
    public final View realView() {
        kx7.c r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    public final k2.b t() {
        return (k2.b) this.m.getValue();
    }

    @Override // k2.q
    public final String url() {
        kx7.c r0 = this.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i();
    }

    public WebEngineAssem() {
        com.bytedance.assem.arch.viewModel.g.c r0 = com.bytedance.assem.arch.viewModel.g.c.a;
        final KClass r10 = Reflection.getOrCreateKotlinClass(RenderStateVM.class);
        Function0<String> r11 = new WebEngineAssem$special$$inlined$assemViewModel$default$1(r10);
        WebEngineAssem$special$$inlined$assemViewModel$default$2 r12 = WebEngineAssem$special$$inlined$assemViewModel$default$2.INSTANCE;
        boolean r13 = false;
        if (Intrinsics.areEqual(r0, com.bytedance.assem.arch.viewModel.g.a.a) == false) goto L6;
        com.bytedance.assem.arch.viewModel.b r1 = new com.bytedance.assem.arch.viewModel.b(r10, r11, VMExtKt.h(), VMExtKt.c(this, true), VMExtKt.f(this, true), VMExtKt.b(), r12, VMExtKt.a(this, true), VMExtKt.e(this, true));
    L15:
        this.l = r1;
        if (((Assem) this).d == null) goto L18;
        r13 = true;
    L18:
        this.m = new com.bytedance.assem.arch.extensions.f(r13, com.bytedance.assem.arch.extensions.d.a(this, k2.b.class));
        this.o = new Handler(Looper.getMainLooper());
        this.q = true;
        this.u = true;
        this.w = -1;
        return;
    L6:
        if (Intrinsics.areEqual(r0, r0) == false) goto L8;
        r1 = new com.bytedance.assem.arch.viewModel.b(r10, r11, VMExtKt.h(), VMExtKt.c(this, false), VMExtKt.f(this, false), VMExtKt.b(), r12, VMExtKt.a(this, false), VMExtKt.e(this, false));
        goto L15
    L8:
        if (r0 != null) goto L10;
    L14:
        r1 = new com.bytedance.assem.arch.viewModel.b(r10, r11, VMExtKt.h(), VMExtKt.m(this), VMExtKt.o(this), VMExtKt.b(), r12, VMExtKt.j(this), VMExtKt.k(this));
        goto L15
    L10:
        if (Intrinsics.areEqual(r0, com.bytedance.assem.arch.viewModel.g.b.a) == true) goto L14;
        throw new IllegalArgumentException("Don't support this VMScope here.");
    }

    public final void s() {
        Context r0 = getContext();     // Catch: Exception -> L42
        if (r0 == null) goto L52;
        PluginWebView r1 = this.k;     // Catch: Exception -> L42
        if (r1 == null) goto L7;
        r1.k();     // Catch: Exception -> L42
    L7:
        IIvyWebService.Companion r10 = IIvyWebService.a;     // Catch: Exception -> L42
        k2.b r11 = t();     // Catch: Exception -> L42
        if (r11 == null) goto L11;
        String r12 = r11.a;     // Catch: Exception -> L42
        if (r12 == null) goto L11;
    L12:
        lx7.a r13 = this.j;     // Catch: Exception -> L42
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L42
        kx7.c r14 = r10.b(r12, r13, r0);     // Catch: Exception -> L42
        this.k = r14;     // Catch: Exception -> L42
        if (r14 == null) goto L24;
        View r15 = r14.f();     // Catch: Exception -> L42
        if (r15 == null) goto L24;
        View r16 = ((UIAssem) this).h;     // Catch: Exception -> L42
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");     // Catch: Exception -> L42
    L19:
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.view.ViewGroup");     // Catch: Exception -> L42
        ViewGroup r17 = (ViewGroup) r16;     // Catch: Exception -> L42
        r17.removeAllViews();     // Catch: Exception -> L42
        r17.addView(r15, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L42
        r15.setOnKeyListener(new f0(this));     // Catch: Exception -> L42
        String r18 = this.y;     // Catch: Exception -> L42
        if (r18 == null) goto L24;
        String r19 = this.z;     // Catch: Exception -> L42
        if (r19 == null) goto L24;
        i1 r20 = m5.y0.a;     // Catch: Exception -> L42
        m5.y0.h(r18, r19);     // Catch: Exception -> L42
    L24:
        k2.b r21 = t();     // Catch: Exception -> L42
        if (r21 == null) goto L53;
        String r22 = r21.b;     // Catch: Exception -> L42
        if (r22 == null) goto L54;
        String r23 = this.y;     // Catch: Exception -> L42
        if (r23 == null) goto L33;
        String r24 = this.z;     // Catch: Exception -> L42
        if (r24 == null) goto L33;
        i1 r25 = m5.y0.a;     // Catch: Exception -> L42
        m5.y0.k(r23, r24, MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r22)));     // Catch: Exception -> L42
    L33:
        kx7.c r26 = this.k;     // Catch: Exception -> L42
        if (r26 == null) goto L36;
        r26.d(r22);     // Catch: Exception -> L42
    L36:
        String r27 = this.y;     // Catch: Exception -> L42
        if (r27 == null) goto L55;
        String r28 = this.z;     // Catch: Exception -> L42
        if (r28 == null) goto L56;
        i1 r29 = m5.y0.a;     // Catch: Exception -> L42
        m5.y0.j(r27, r28);     // Catch: Exception -> L42
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L11:
        r12 = "";
        goto L12
    L52:
        return;
    L42:
        e = move-exception;
        String r30 = this.y;
        if (r30 == null) goto L48;
        String r31 = this.z;
        if (r31 == null) goto L48;
        i1 r32 = m5.y0.a;
        m5.y0.b(r30, "fail to create webview: " + e.getMessage(), AppletErrorCode.WEB_VIEW_CREATE_ERROR.getType(), r31);
    L48:
        com.bytedance.ai.utils.g.a.e("WebViewAssem", "createHybridKit: " + e);
    }

    public final RenderStateVM u() {
        if (o() == true) goto L7;
        return null;
    L7:
        return (RenderStateVM) this.l.getValue();
    }

    @Override // k2.o
    public final View engineView() {
        return this.n;
    }

    @Override // k2.h
    public final d3.b0 getAIBridge() {
        return this.A;
    }

    public final Lifecycle getLifecycle() {
        return ((Assem) this).c;
    }

    @Override // k2.q
    public final void b(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "settings");
        RenderStateVM r0 = u();
        if (r0 == null) goto L6;
        r0.updateState(new i5.k(r10));
        return;
    }

    @Override // k2.r
    public final void onMessageToJS(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        com.bytedance.ai.model.o0 r0 = this.p;
        if (r0 == null) goto L6;
        r0.d(r10);
        return;
    }

    public final void r(View r11) {
        Intrinsics.checkNotNullParameter(r11, "view");
        k2.b r0 = t();
        String r1 = null;
        if (r0 == null) goto L11;
        k2.j r10 = r0.n;
        if (r10 == null) goto L11;
        PageInfo r12 = r10.getPageInfo();
        if (r12 == null) goto L11;
        Map<String, Object> r13 = r12.getTraceInfo();
        if (r13 == null) goto L11;
        Object r14 = r13.get("trace_id");
    L13:
        if ((r14 instanceof String) == false) goto L15;
        String r15 = (String) r14;
    L16:
        this.y = r15;
        k2.b r16 = t();
        if (r16 == null) goto L25;
        k2.j r17 = r16.n;
        if (r17 == null) goto L25;
        PageInfo r18 = r17.getPageInfo();
        if (r18 == null) goto L25;
        Map<String, Object> r19 = r18.getTraceInfo();
        if (r19 == null) goto L25;
        Object r20 = r19.get("eventName");
    L27:
        if ((r20 instanceof String) == false) goto L29;
        r1 = (String) r20;
    L29:
        this.z = r1;
        String r21 = this.y;
        if (r21 == null) goto L33;
        if (r1 == null) goto L33;
        i1 r22 = m5.y0.a;
        m5.y0.i(r21, r1);
    L33:
        k2.b r23 = t();
        if (r23 == null) goto L36;
        boolean r24 = r23.p;
    L37:
        this.q = r24;
        this.v = ViewConfiguration.get(r11.getContext()).getScaledTouchSlop();
        h2.a r110 = f2.b.c;
        if (r110 == null) goto L46;
        IIvyWebService.Companion r25 = IIvyWebService.a;
        String r26 = r110.m;
        k2.b r111 = t();
        if (r111 == null) goto L44;
        String r112 = r111.a;
        if (r112 == null) goto L44;
    L45:
        this.j = IIvyWebService.a.a(r25, r26, r112, new h0(this), new j0(this), new k0(this), new l0(this), new m0(this), null, 384);
    L44:
        r112 = "";
    L46:
        s();
        return;
    L36:
        r24 = false;
    L25:
        r20 = null;
        goto L27
    L15:
        r15 = null;
    L11:
        r14 = null;
        goto L13
    }

    @Override // k2.q
    public final void setTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        RenderStateVM r0 = u();
        if (r0 == null) goto L6;
        r0.updateState(new i5.f(r10));
        return;
    }

    public final boolean v(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
        return false;
    L11:
        String r12 = null;
        if (StringsKt.startsWith$default(r10, "http", false, 2, null) == true) goto L14;
        return false;
    L14:
        k2.b r13 = t();
        if (r13 == null) goto L17;
        List<String> r14 = r13.k;
    L18:
        k2.b r15 = t();
        if (r15 == null) goto L21;
        r12 = r15.b;
    L21:
        Uri r16 = UriProtector.parse(r12);
        if (Intrinsics.areEqual(r16.getScheme(), "https") == false) goto L30;
        if (r14 != null) goto L25;
    L27:
        boolean r17 = false;
    L28:
        if (r17 == false) goto L30;
        return true;
    L25:
        if (CollectionsKt.contains(r14, r16.getHost()) != true) goto L27;
        r17 = true;
    L30:
        return false;
    L17:
        r14 = null;
        goto L18
    L5:
        if (r10.length() == 0) goto L8;
        r11 = false;
        goto L9
    }

    @Override // k2.o
    public final void handleWebViewDrawEnd(final long r10, final long r12) {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.d("WebViewAssem", "navigationStart:" + r10 + " drawEnd:" + r12 + ", duration:" + (r12 - r10));
        final String r11 = this.y;
        if (r11 == null) goto L13;
        String r1 = this.z;
        if (r1 == null) goto L14;
        i1 r13 = m5.y0.a;
        Intrinsics.checkNotNullParameter(r11, "traceId");
        Intrinsics.checkNotNullParameter(r1, "eventType");
        r0.d("AppletEventMonitorManager", "onWebDrawEnd: " + r11 + ", " + r10 + ", " + r12 + ", " + r1);
        if (Intrinsics.areEqual(r1, "applet_widget_timeline_full") == false) goto L10;
        m5.y0.r(new m5.o0(r11, r10, r12));
        return;
    L10:
        if (Intrinsics.areEqual(r1, "applet_page_timeline_full") == false) goto L16;
        m5.y0.r(new m5.p0(r11, r10, r12));
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        d3.w r0 = this.A;
        if (r0 == null) goto L6;
        r0.a(r10, r11);
        return;
    }
}
