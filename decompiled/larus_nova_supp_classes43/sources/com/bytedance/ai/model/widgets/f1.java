package com.bytedance.ai.model.widgets;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageStatus;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class f1 extends com.bytedance.ai.model.widgets.c {
    public WebView a;
    public d3.w b;
    public com.bytedance.ai.model.o0 c;
    public final Map<String, a6.a> d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b implements a6.a {
        public final u4.g a;

        @Override // a6.a
        public final u4.b getIStorage() {
            return this.a;
        }

        public b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "appGroupId");
            this.a = new u4.g(false, r10);
        }
    }

    public static final class c extends d3.a0 {
        public final String a;
        public final String b;
        public final ContainerType c;
        public final String d;
        public final String e;

        @Override // d3.a0
        public final String getAppId() {
            return this.b;
        }

        @Override // d3.a0
        public final String getAppletId() {
            return this.a;
        }

        @Override // d3.a0
        public final String getContainerId() {
            return this.d;
        }

        @Override // d3.a0
        public final ContainerType getContainerType() {
            return this.c;
        }

        @Override // d3.a0
        public final String getUrl() {
            return this.e;
        }

        public c(f1 r10, WebView r11) {
            this.a = r10.getAppletId();
            this.b = r10.getAppletId();
            this.c = ContainerType.PAGE;
            this.d = r10.getPageID();
            this.e = r11.getUrl();
        }
    }

    static {
    }

    @Override // com.bytedance.ai.model.widgets.c
    public final String getRenderType() {
        return "webview";
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.j
    public final void doRefresh() {
        if (f2.k.b == false) goto L6;
        AppletRuntime r0 = getAppletRuntime();
        AtomicInteger r1 = AppletRuntime.x;
        r0.B(null, null);
        return;
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.j
    public final String viewContext() {
        getPageInfo().setPageId(getPageID());
        return getPageInfo().toViewContext();
    }

    @Override // k2.o
    public final View engineView() {
        return this.a;
    }

    @Override // k2.h
    public final d3.b0 getAIBridge() {
        return this.b;
    }

    public final void h(WebView r10) {
        if (r10 == null) goto L31;
        r10.setTag(2131363149, new WeakReference(this));
        r10.getSettings().setJavaScriptEnabled(true);
        r10.getSettings().setDisplayZoomControls(false);
        r10.getSettings().setBuiltInZoomControls(false);
        com.bytedance.ai.model.o0 r0 = new com.bytedance.ai.model.o0(this);
        this.c = r0;
        Intrinsics.checkNotNull(r0);
        r10.addJavascriptInterface(r0, "AppletJSBridge");
        WebViewAIBridgePort.Companion.getClass();
        WebViewAIBridgePort r1 = WebViewAIBridgePort.a.a(r10);
        if (r1 == null) goto L32;
        d3.w r11 = new d3.w();
        this.b = r11;
        r11.d(new q4.a());
        d3.w r12 = this.b;
        if (r12 == null) goto L8;
        r12.j(r10);
    L8:
        d3.w r13 = this.b;
        if (r13 == null) goto L13;
        e3.a r14 = r13.i;
        if (r14 == null) goto L13;
        r14.e(d3.a0.class, new c(this, r10));
    L13:
        d3.w r15 = this.b;
        if (r15 == null) goto L18;
        e3.a r16 = r15.i;
        if (r16 == null) goto L18;
        e3.d.a.a(r16, k2.j.class, this);
    L18:
        d3.w r17 = this.b;
        if (r17 == null) goto L23;
        e3.a r18 = r17.i;
        if (r18 == null) goto L23;
        e3.d.a.a(r18, AppletRuntime.class, getAppletRuntime());
    L23:
        d3.w r19 = this.b;
        if (r19 == null) goto L28;
        e3.a r20 = r19.i;
        if (r20 == null) goto L28;
        r20.e(d3.z.class, new e1(this));
    L28:
        d3.w r21 = this.b;
        if (r21 == null) goto L32;
        r21.k(r1);
    L32:
        this.a = r10;
        return;
    L31:
        r10 = null;
        goto L32
    }

    @Override // k2.r
    public final void onMessageToJS(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        com.bytedance.ai.model.o0 r0 = this.c;
        if (r0 == null) goto L6;
        r0.d(r10);
        return;
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.i
    public final void onViewError(String r1) {
        super.onViewError(r1);
        setPageStatus(PageStatus.LOADING_ERROR);
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.i
    public final void onViewFinish(String r1) {
        super.onViewFinish(r1);
        setPageStatus(PageStatus.LOADING_FINISH);
        p2.c.d(new c1(this));
    }

    @Override // com.bytedance.ai.model.widgets.c, k2.i
    public final void onViewStart(String r1) {
        super.onViewStart(r1);
        setPageStatus(PageStatus.LOADING_START);
    }

    public f1(AppletRuntime r10, PageInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "appletRuntime");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        super(r10, r11);
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(new d1());
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        d3.w r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r10, r11);
        return;
    }
}
