package com.bytedance.ai.model.widgets;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0016J,\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016JY\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u0006\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u0001012\u0016\u00102\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0004\u0012\u00020\"\u0018\u0001032#\u00105\u001a\u001f\u0012\u0013\u0012\u001106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\"\u0018\u000103H\u0016JW\u0010:\u001a\u0004\u0018\u00010.2\u0006\u0010\u0006\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u0001012\u0016\u00102\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0004\u0012\u00020\"\u0018\u0001032#\u00105\u001a\u001f\u0012\u0013\u0012\u001106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\"\u0018\u000103J\u0018\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=H\u0016J\u0010\u0010?\u001a\u00020\u000f2\u0006\u00100\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020\"H\u0016J\b\u0010B\u001a\u00020\"H\u0016J\b\u0010C\u001a\u00020\"H\u0016J\u0006\u0010D\u001a\u00020\"J\u0006\u0010E\u001a\u00020\"J\b\u0010F\u001a\u00020\"H\u0016J\b\u0010G\u001a\u00020\"H\u0016J\u001a\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010K\u001a\u000206H\u0016J\u0014\u0010L\u001a\u00020\"*\u00020\u001a2\u0006\u0010M\u001a\u00020NH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006P"}, d2 = {"Lcom/bytedance/ai/model/widgets/WebViewFloatingPageV2;", "Lcom/bytedance/ai/model/widgets/WebViewPage;", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/bytedance/ai/api/model/view/IFloatingPage;", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "pageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "<init>", "(Lcom/bytedance/ai/model/AppletRuntime;Lcom/bytedance/ai/model/objects/PageInfo;)V", "ivyWebViewClient", "Lcom/ivy/ivykit/api/plugin/web/IvyWebClient;", "ivyWebView", "Lcom/ivy/ivykit/api/plugin/render/WebViewPluginView;", "evaluateCompleted", "", "getEvaluateCompleted$annotations", "()V", "getEvaluateCompleted", "()Z", "setEvaluateCompleted", "(Z)V", "isShowing", "isShowing$annotations", "setShowing", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "_onAppBackGroundListener", "Lcom/bytedance/ai/api/model/ability/OnAppBackGroundCallback;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onFocusChange", "", "hasFocus", "createContainer", "root", "Landroid/view/ViewGroup;", "params", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "realView", "Landroid/view/View;", "createPage", "context", "Landroid/content/Context;", "onSuccess", "Lkotlin/Function1;", "", "onFail", "", "Lkotlin/ParameterName;", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, MessageIndication.MESSAGE_TYPE_MSG, "createRealPage", "handleContentSizeChange", "width", "", "height", "showFloating", "Landroidx/fragment/app/FragmentActivity;", "floatingViewDestroy", "floatingViewShow", "floatingViewHide", "onBackground", "onForeground", "onMaskClicked", "onDestroy", "getViewModel", "Lcom/bytedance/ai/viewmodel/IAIViewModel;", "isShared", "groupId", "changeTo", "event", "Landroidx/lifecycle/Lifecycle$Event;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebViewFloatingPageV2 extends f1 implements LifecycleOwner, k2.s {
    public static final /* synthetic */ int l = 0;
    public final lx7.a f;
    public kx7.c g;
    public boolean h;
    public boolean i;
    public final LifecycleRegistry j;
    public final g2.f k;

    public static final class a implements ix7.e {
        public final /* synthetic */ WebViewFloatingPageV2 a;

        public final void b(SslError r1) {
        }

        public final lx7.b c(lx7.b r10) {
            Intrinsics.checkNotNullParameter(r10, "before");
            return r10;
        }

        public final boolean d(com.ivy.ivykit.plugin.impl.web.b r1) {
            return false;
        }

        public final void e(View r1) {
        }

        public final void f() {
        }

        public final boolean g(WebView r1, ValueCallback r10) {
            return false;
        }

        public final void i(WebView r1, int r10) {
        }

        public final void onReceivedTitle(WebView r1, String r10) {
        }

        public a(WebViewFloatingPageV2 r1) {
            this.a = r1;
        }

        public final void onPageStarted(String r10) {
            com.bytedance.ai.utils.f.j("Create Floating Ball onPageStarted");
            this.a.onViewStart(r10);
        }

        public final boolean j(WebView r10, com.ivy.ivykit.plugin.impl.web.c r11) {
            com.bytedance.ai.utils.g.a.e("WebViewFloatingPageV2", "onRenderProcessGone: " + r11);
            return true;
        }

        public final void k(WebResourceRequest r10, WebResourceError r11) {
            Object r12 = null;
            if (Build.VERSION.SDK_INT < 23) goto L12;
            StringBuilder r0 = new StringBuilder("Request: ");
            if (r10 == null) goto L7;
            Uri r13 = r10.getUrl();
        L8:
            r0.append(r13);
            r0.append(", error: ");
            if (r11 == null) goto L11;
            r12 = r11.getDescription();
        L11:
            r0.append(r12);
            String r14 = r0.toString();
        L16:
            this.a.onViewError(r14);
            return;
        L7:
            r13 = null;
            goto L8
        L12:
            StringBuilder r15 = new StringBuilder("Request: ");
            if (r10 == null) goto L15;
            r12 = r10.getUrl();
        L15:
            r15.append(r12);
            r14 = r15.toString();
            goto L16
        }

        public final void onPageFinished(WebView r10, String r11) {
            com.bytedance.ai.utils.f.j("Create Floating Ball onPageFinished");
            WebViewFloatingPageV2 r0 = this.a;
            if (r0.a != null) goto L5;
            r0.h(r10);
        L5:
            WebView r12 = r0.a;
            if (r12 != null) goto L14;
        L12:
            this.a.onViewFinish(r11);
            return;
        L14:
            r12.evaluateJavascript(("window.getAppData = function() { return JSON.stringify(" + r0.getPageInfo().getPageData() + "); }; \n") + ("window.getViewContext = function() { return JSON.stringify(" + r0.viewContext() + "); };\n"), null);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            com.bytedance.ai.utils.g.a.e("WebViewPage", "JavaScript execution error: " + th.getMessage());
            goto L12
        }

        public final boolean shouldOverrideUrlLoading(WebView r10, String r11) {
            if (r11 != null) goto L5;
        L8:
            boolean r12 = true;
        L9:
            if (r12 == false) goto L11;
        L27:
            return false;
        L11:
            if (StringsKt.startsWith$default(r11, "http", false, 2, null) == true) goto L27;
            com.bytedance.ai.utils.g.a.i("WebViewFloatingPageV2", "shouldOverrideUrlLoading http url:" + r11);     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
            Intent r13 = new Intent("android.intent.action.VIEW", UriProtector.parse(r11));     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
            r13.setFlags(805306368);     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
            AtomicBoolean r14 = f2.b.a;     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
            h2.a r15 = f2.b.c;     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
            if (r15 == null) goto L26;
            Context r16 = r15.a;     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
            if (r16 == null) goto L26;
            r16.startActivity(r13);     // Catch: ActivityNotFoundException -> L18 IllegalStateException -> L20 IllegalArgumentException -> L22 SecurityException -> L24
        L26:
            return true;
        L18:
            e = move-exception;
            com.bytedance.ai.utils.g.a.w("WebViewFloatingPageV2", "shouldOverrideUrlLoading http url:" + r11, e);
        L22:
            e = move-exception;
            com.bytedance.ai.utils.g.a.w("WebViewFloatingPageV2", "shouldOverrideUrlLoading http url:" + r11, e);
        L20:
            e = move-exception;
            com.bytedance.ai.utils.g.a.w("WebViewFloatingPageV2", "shouldOverrideUrlLoading http url:" + r11, e);
        L24:
            e = move-exception;
            com.bytedance.ai.utils.g.a.w("WebViewFloatingPageV2", "shouldOverrideUrlLoading http url:" + r11, e);
            goto L26
        L5:
            if (r11.length() == 0) goto L8;
            r12 = false;
            goto L9
        }

        public final void a(int r10, String r11, String r12) {
            StringBuilder r0 = new StringBuilder("errorCode: ");
            r0.append(r10);
            r0.append(", description: ");
            r0.append(r11);
            r0.append(", failingUrl: ");
            if (r12 != null) goto L5;
            r12 = "";
        L5:
            r0.append(r12);
            String r13 = r0.toString();
            this.a.onViewError(r13);
        }

        public final void h(String r10, int r11, String r12) {
            com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
            h2.a r1 = f2.b.c;
            if (r1 == null) goto L7;
            boolean r13 = true;
            if (r1.k != true) goto L7;
        L8:
            if (r13 == false) goto L16;
            if (r10 == null) goto L17;
            WebViewFloatingPageV2 r14 = this.a;
            if (TextUtils.isEmpty(r12) == false) goto L14;
            r12 = "unknown-source";
        L14:
            r0.d("AppletFloatingBall", "[console]\"" + r10 + "\", source: " + r12 + '(' + r11 + "), pageId: " + r14.getPageID());
            return;
        L17:
            return;
        L16:
            return;
        L7:
            r13 = false;
            goto L8
        }
    }

    public static final class b extends ix7.d.a {
        public final /* synthetic */ WebViewFloatingPageV2 a;

        public b(WebViewFloatingPageV2 r1) {
            this.a = r1;
        }

        public final void d(View r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Intrinsics.checkNotNullParameter(r10, "view");
            final WebViewFloatingPageV2 r0 = this.a;
            r10.setOnFocusChangeListener(new a1(r0));
            if ((r10 instanceof WebView) == false) goto L5;
            WebView r11 = (WebView) r10;
        L6:
            if (r11 == null) goto L9;
            this.a.h(r11);
            return;
        L9:
            return;
        L5:
            r11 = null;
            goto L6
        }
    }

    public static final class c implements ix7.g {
        public final /* synthetic */ PageInfo a;
        public final /* synthetic */ WebViewFloatingPageV2 b;

        public c(PageInfo r1, WebViewFloatingPageV2 r10) {
            this.a = r1;
            this.b = r10;
        }

        public final WebResourceResponse a(String r10, WebResourceResponse r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            if (r11 != null) goto L5;
        L12:
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            return r11;
        L5:
            if (Intrinsics.areEqual(r11.getMimeType(), "text/html") == false) goto L12;
            com.bytedance.ai.utils.g.a.i("WebViewFloatingPageV2", "[afterLoadResource] " + r11.getMimeType() + " inject data for the floatingPage");
            InputStream r12 = r11.getData();
            if (r12 == null) goto L10;
            PageInfo r0 = this.a;
            WebViewFloatingPageV2 r1 = this.b;
            String r13 = "window.__APPLET_VIEW_DATA__ = " + r0.getPageData() + ";\n";
            String r14 = "window.__APPLET_VIEW_CONTEXT__ = " + r1.viewContext() + ";\n";
            return new WebResourceResponse(r11.getMimeType(), "utf-8", new ByteArrayInputStream(StringsKt.replace$default(com.bytedance.ai.utils.f.k(r12), "<!-- INJECT_GLOBAL_VARIABLES_CONTENT -->", "<script> window.__AI_SDK_VERSION__ = '1.15.0-rc.7';\n" + r13 + r14 + " </script>", false, 4, null).getBytes(Charsets.UTF_8)));
        L10:
            return null;
        }
    }

    public static final class d {
    }

    static {
    }

    @Override // k2.k
    public final void createContainer(ViewGroup r1, k2.b r10, Activity r11, Fragment r12) {
        Intrinsics.checkNotNullParameter(r1, "root");
        Intrinsics.checkNotNullParameter(r10, "params");
    }

    @Override // k2.s
    public final void a() {
        if (this.i == false) goto L7;
        com.bytedance.ai.utils.g.a.d("WebViewFloatingPageV2", "floatingViewShow: widget " + getPageID() + " is showing");
        return;
    L7:
        if (this.h == true) goto L10;
        com.bytedance.ai.utils.g.a.d("WebViewFloatingPageV2", "floatingViewShow: widget " + getPageID() + " evaluate is NOT completed");
        return;
    L10:
        this.i = true;
        com.bytedance.ai.utils.g.a.d("WebViewFloatingPageV2", "floatingViewShow: ");
        p2.c.d(new u0(this));
        j(this.j, Lifecycle.Event.ON_RESUME);
    }

    @Override // k2.s
    public final void c() {
        p2.c.d(new p0(this));
        d3.w r0 = this.b;
        if (r0 == null) goto L6;
        JsonObject r1 = new JsonObject();
        r1.addProperty("viewId", getPageInfo().getPageId());
        Unit r10 = Unit.INSTANCE;
        r0.a("applet.floatingMaskClicked", r1);
        return;
    }

    @Override // k2.s
    public final void i() {
        if (this.i == true) goto L6;
        com.bytedance.ai.utils.g.a.d("WebViewFloatingPageV2", "floatingViewShow: widget " + getPageID() + " is hide");
        return;
    L6:
        this.i = false;
        com.bytedance.ai.utils.g.a.d("WebViewFloatingPageV2", "floatingViewHide: ");
        p2.c.d(new x0(this));
        j(this.j, Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.i
    public final void onDestroy() {
        com.bytedance.ai.utils.g.a.d("WebViewFloatingPageV2", "floating onDestroy");
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L5;
        r0.i(this.k);
    L5:
        AppletRuntime r1 = getAppletRuntime();
        r1.h.g();
        r1.f();
        AppletRuntimeManager.m(getPageID());
        p2.c.d(new n0(this));
        p2.c.e(new r0(this), 2000);
    }

    @Override // k2.o
    public final View realView() {
        kx7.c r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    @Override // k2.s
    public final int height() {
        View r0 = realView();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getHeight();
    }

    @Override // k2.s
    public final int width() {
        View r0 = realView();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getWidth();
    }

    @Override // k2.s
    public final void e() {
        onDestroy();
    }

    public final Lifecycle getLifecycle() {
        return this.j;
    }

    @Override // com.bytedance.ai.model.widgets.c
    public final void onFocusChange(boolean r10) {
        kx7.c r0 = this.g;
        if (r0 == null) goto L10;
        String r1 = r0.b();
        if (r1 == null) goto L11;
        com.bytedance.ai.utils.g.a.d("WebViewFloatingPageV2", r1 + " widget " + getPageID() + " focus change: " + r10 + " send");
        JSONObject r11 = new JSONObject(MapsKt.mapOf(TuplesKt.to("data", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("containerID", r1), TuplesKt.to("focusState", Boolean.valueOf(r10))}))));
        kx7.c r12 = this.g;
        if (r12 == null) goto L12;
        r12.h("onFocusChange", r11);
        return;
    L12:
        return;
    L11:
        return;
    }

    public WebViewFloatingPageV2(AppletRuntime r11, PageInfo r12) {
        Intrinsics.checkNotNullParameter(r11, "appletRuntime");
        Intrinsics.checkNotNullParameter(r12, "pageInfo");
        super(r11, r12);
        this.j = new LifecycleRegistry(this);
        g2.f r13 = new g2.f(new v0(this), new w0(this), 12);
        this.k = r13;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 == null) goto L5;
        r0.w(r13);
    L5:
        r12.setPageId(getPageID());
        h2.a r14 = f2.b.c;
        if (r14 == null) goto L11;
        String r1 = r14.m;
        if (r1 == null) goto L12;
        this.f = IIvyWebService.a.a(IIvyWebService.a, r1, com.bytedance.android.ec.core.event.a.KEY_SCHEMA, new a(this), new b(this), null, null, new c(r12, this), null, 432);
        return;
    L12:
        return;
    }

    @Override // u4.a
    public final a6.a getViewModel(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "groupId");
        if (r10 == true) goto L12;
        Intrinsics.checkNotNullParameter(r11, "groupId");
        if (r10 == false) goto L8;
        return null;
    L8:
        a6.a r12 = (a6.a) ((LinkedHashMap) this.d).get(r11);
        if (r12 != null) goto L14;
        f1.b r13 = new f1.b(r11);
        this.d.put(r11, r13);
        return r13;
    L14:
        return r12;
    L12:
        return SharedViewModelExtKt.b(this, r11);
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.j
    public final void handleContentSizeChange(final double r10, final double r11) {
        p2.c.d(new s0(this, r10, r11));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ai.model.widgets.z0] */
    public final void j(final LifecycleRegistry r10, final Lifecycle.Event r11) {
        ?? r0 = new z0(r11, r10);
        if (r11 != Lifecycle.Event.ON_DESTROY) goto L5;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        r10.handleLifecycleEvent(r11);     // Catch: Throwable -> L9
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r12) == null) goto L18;
        r0.invoke();
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        if (r10.getCurrentState() != Lifecycle.State.DESTROYED) goto L15;
        r0.invoke();
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.ai.model.widgets.t0] */
    @Override // com.bytedance.ai.model.widgets.c, k2.p
    public final View createPage(final PageInfo r10, Context r11, final Function1<? super Integer, Unit> r12, final Function1<? super String, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        super.createPage(r10, r11, null, null);
        final ?? r14 = new t0(this, r13);
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        if (r10.getPageName() != null) goto L5;
    L22:
        r14.invoke("pageInfo is null, context=" + r11 + ", pageName=" + r10.getPageName() + ", pageUrl=" + r10.getPageUrl());
    L23:
        return null;
    L5:
        if (r10.getPageUrl() == null) goto L22;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L10;
        Activity r16 = r15.currentActivity();
    L12:
        if ((r16 instanceof FragmentActivity) == false) goto L14;
        FragmentActivity r17 = (FragmentActivity) r16;
    L15:
        if (r17 == null) goto L17;
    L20:
        final FragmentActivity r18 = r17;
    L21:
        setPageInfo(r10);
        p2.c.d(new y0(r18, this, r10, r12, r14));
        goto L23
    L17:
        if ((r11 instanceof FragmentActivity) == false) goto L19;
        r17 = (FragmentActivity) r11;
        goto L20
    L19:
        r18 = null;
        goto L21
    L14:
        r17 = null;
        goto L15
    L10:
        r16 = null;
        goto L12
    }
}
