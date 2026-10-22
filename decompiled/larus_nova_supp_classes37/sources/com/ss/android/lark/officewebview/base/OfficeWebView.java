package com.ss.android.lark.officewebview.base;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.DependencyContextUniqueId;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.l;
import com.ss.android.lark.officewebview.service.impl.WebViewPerformanceService;
import com.ss.android.lark.picker.base.view.ItemViewType;
import dxb.h;
import dxb.i;
import dxb.s;
import dxb.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ntb.o;
import org.json.JSONObject;
import otb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u009c\u00012\u00020\u0001:\u0004\u009c\u0001\u009d\u0001B+\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u000bJ\r\u0010\u0011\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0012J\u001c\u0010/\u001a\u0002002\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016J\u0010\u00102\u001a\u0002002\u0006\u00103\u001a\u00020\rH\u0016J\r\u00104\u001a\u00020\rH\u0000¢\u0006\u0002\b5J\u001e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u0002002\u0006\u0010C\u001a\u00020DJ\u000e\u0010E\u001a\u0002002\u0006\u0010C\u001a\u00020DJ\u0006\u0010I\u001a\u00020\u0014J\b\u0010J\u001a\u000200H\u0014J\n\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020\u0000H\u0016J\u0018\u0010N\u001a\u0002002\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020?H\u0016J\u0012\u0010Q\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0012\u0010T\u001a\u0002002\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010U\u001a\u000200H\u0016J\u0012\u0010V\u001a\u00020\u001d2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u000200H\u0002J\u0016\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020H\u0018\u00010[H\u0016J\u0010\u0010\\\u001a\u0002002\b\u0010]\u001a\u0004\u0018\u00010$J\u0014\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020H0[H\u0016J\u001a\u0010_\u001a\u00020`2\u0006\u0010W\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u001a\u0010c\u001a\u00020`2\u0006\u0010W\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010d\u001a\u000200H\u0016J\b\u0010e\u001a\u000200H\u0016J\u0010\u0010f\u001a\u0002002\b\u0010g\u001a\u0004\u0018\u00010hJ\u0010\u0010i\u001a\u0002002\b\u0010g\u001a\u0004\u0018\u00010jJ(\u0010k\u001a\u0002002\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020m2\u0006\u0010p\u001a\u00020mH\u0014JP\u0010q\u001a\u00020\u001d2\u0006\u0010r\u001a\u00020m2\u0006\u0010s\u001a\u00020m2\u0006\u0010t\u001a\u00020m2\u0006\u0010u\u001a\u00020m2\u0006\u0010v\u001a\u00020m2\u0006\u0010w\u001a\u00020m2\u0006\u0010x\u001a\u00020m2\u0006\u0010y\u001a\u00020m2\u0006\u0010z\u001a\u00020\u001dH\u0014J\u000e\u0010{\u001a\u0002002\u0006\u0010\n\u001a\u00020\u0007J\b\u0010|\u001a\u00020\rH\u0016J\b\u0010}\u001a\u00020\rH\u0016J\u000e\u0010~\u001a\u0002002\u0006\u0010\u007f\u001a\u00020\"J\t\u0010\u0080\u0001\u001a\u00020\"H\u0016J\t\u0010\u0081\u0001\u001a\u000200H\u0016J\u0014\u0010\u0082\u0001\u001a\u0002002\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\rH\u0016J+\u0010\u0082\u0001\u001a\u0002002\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\r2\u0015\u0010\u0084\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010[H\u0016J>\u0010\u0085\u0001\u001a\u0002002\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\r2\u0007\u0010\u0087\u0001\u001a\u00020\r2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010\u008b\u0001\u001a\u000200H\u0016J\t\u0010\u008c\u0001\u001a\u000200H\u0016J\t\u0010\u008d\u0001\u001a\u000200H\u0016J\u0007\u0010\u008e\u0001\u001a\u00020\u001dJ\t\u0010\u008f\u0001\u001a\u000200H\u0014J\u001f\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\t\u0010@\u001a\u0005\u0018\u00010\u0092\u00012\u0006\u0010\n\u001a\u00020mH\u0016J\t\u0010\u0093\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0094\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0095\u0001\u001a\u00020\u001dH\u0002J\u0013\u0010\u0096\u0001\u001a\u0002002\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001J\u0007\u0010\u0099\u0001\u001a\u000200J\u0007\u0010\u009a\u0001\u001a\u00020\u001dJ\t\u0010\u009b\u0001\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b+\u0010 R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010*\u001a\u0004\b8\u00109R\u001a\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020H0GX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, d2 = {"Lcom/ss/android/lark/officewebview/base/OfficeWebView;", "Lcom/ss/android/lark/officewebview/base/BaseOfficeWebView;", "context", "Landroid/content/Context;", "set", "Landroid/util/AttributeSet;", "bizType", "Lcom/ss/android/lark/officewebview/monitor/webview/BizType;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/ss/android/lark/officewebview/monitor/webview/BizType;)V", "type", "(Landroid/content/Context;Lcom/ss/android/lark/officewebview/monitor/webview/BizType;)V", "mTracingId", "", "bridgeWebViewTouchDispatcher", "Lcom/ss/android/lark/officewebview/util/BridgeWebViewTouchDispatcher;", "monitorId", "getContainerMonitorId", "getContainerMonitorId$webview_release", "mBridge", "Lcom/ss/android/lark/officewebview/bridge/Bridge;", "injectedLogParams", "", "larkHybridMonitor", "Lcom/ss/android/lark/officewebview/base/OfficeWebView$LarkHybridMonitor;", "monitorConfig", "Lcom/ss/android/lark/officewebview/dependency/IAnniexMonitorDependency$MonitorConfig;", "bizScene", "value", "", "webViewIsDestroy", "getWebViewIsDestroy", "()Z", "mStartTime", "", "mParamInjector", "Lcom/ss/android/lark/officewebview/base/interfaces/ILarkWebViewParamInjector;", "pluginList", "", "getPluginList", "()Ljava/util/List;", "pluginList$delegate", "Lkotlin/Lazy;", "isEnablePluginDuplicateCheck", "isEnablePluginDuplicateCheck$delegate", "officeWebViewLabel", "Landroid/widget/TextView;", "setInjectedLogParams", "", "logParams", "setBizScene", "scene", "getBizScene", "getBizScene$webview_release", "pluginBridge", "Lcom/ss/android/lark/officewebview/dependency/IOpenPluginWrapper;", "getPluginBridge", "()Lcom/ss/android/lark/officewebview/dependency/IOpenPluginWrapper;", "pluginBridge$delegate", "sendEvent", "Lcom/ss/android/lark/officewebview/dependency/PluginBaseResult;", "api", "params", "Lorg/json/JSONObject;", "callback", "Lcom/ss/android/lark/officewebview/dependency/PluginEventCallback;", "registerPlugin", "plugin", "Lcom/ss/android/lark/officewebview/dependency/Plugin;", "registerPluginOnce", "mCommonParams", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getBridge", "afterInitServiceManager", "getServiceManager", "Lcom/ss/android/lark/officewebview/service/ServiceManager;", "getWebView", "reportEvent", "eventName", "eventJson", "addTouchListener", "onTouchListener", "Landroid/view/View$OnTouchListener;", "removeTouchListener", "clearTouchListeners", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "initTracing", "getCommonParams", "", "setParamInjector", "paramInjector", "getReasonParams", "createErrorMonitor", "Lcom/ss/android/lark/officewebview/monitor/webview/WebMonitor;", "monitorCode", "Lcom/ss/android/lark/officesdk/di/core/deps/IMonitorDependency$IMonitorCode;", "createNormalMonitor", "destroy", "onDestroy", "setStableListener", "listener", "Lcom/ss/android/lark/officewebview/quality/stable/IStableListener;", "setPerformListener", "Lcom/ss/android/lark/officewebview/quality/performance/IPerformanceListener;", "onScrollChanged", "left", "", "top", "oldLeft", "oldTop", "overScrollBy", "deltaX", "deltaY", "scrollX", "scrollY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "setBizType", "getBizType", "getBaseTraceId", "setStartTime", "startTime", "getStartTime", "onResume", "loadUrl", "url", "additionalHttpHeaders", "loadDataWithBaseURL", "baseUrl", "data", "mimeType", "encoding", "historyUrl", "goBack", "onPause", "onStop", "isForegroundUsable", "onAttachedToWindow", "startActionMode", "Landroid/view/ActionMode;", "Landroid/view/ActionMode$Callback;", "getIsEnableLarkWebviewInsetPauseTimers", "getIsEnableLarkWebviewInsetResumeTimers", "enablePluginDuplicateCheck", "setMonitorConfig", "monitor", "Lcom/ss/android/lark/officewebview/base/interfaces/ILarkWebViewHybridMonitor;", "checkWhiteScreen", "checkWhiteScreenForResult", "getWebViewType", "Companion", "LarkHybridMonitor", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class OfficeWebView extends g {
    public static final /* synthetic */ int u = 0;
    public dxb.b h;
    public String i;
    public final com.ss.android.lark.officewebview.util.c j;
    public final String k;
    public final xwb.a l;
    public Map<String, String> m;
    public String n;
    public boolean o;
    public long p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final ConcurrentHashMap<String, Object> t;

    public static final class a {
    }

    static {
    }

    public OfficeWebView(Context r3) {
        this(r3, null, 6);
    }

    public OfficeWebView(Context r2, AttributeSet r3) {
        this(r2, r3, 4);
    }

    private final boolean getIsEnableLarkWebviewInsetPauseTimers() {
        return false;
    }

    private final boolean getIsEnableLarkWebviewInsetResumeTimers() {
        return false;
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        this.o = true;
        int r0 = t.a;
        String r1 = getUrl();
        dxb.g r2 = new dxb.g("wb_webview_destroy", dxb.c.h, this);
        t.a(this, r2, r1);
        r2.b();
        int r3 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r4 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r4 == null) goto L5;
        r4.destroy();
    L5:
        super.destroy();
        xwb.a r5 = this.l;
        r5.getClass();
        j.e("CML_TAG_JSBridge", "destroy");
        ((ConcurrentHashMap) r5.b.a).clear();
        r5.c.shutdown();
        getPluginBridge().release();
        int r6 = com.ss.android.lark.officesdk.utils.di.g.a;
        if (com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.webview.monitor.clean.disable") == true) goto L11;
        Intrinsics.checkNotNullParameter(this.k, "monitorId");
        zwb.a r7 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r7 == null) goto L11;
        r7.d0();
    L11:
        if (((Boolean) this.r.getValue()).booleanValue() == false) goto L13;
        getPluginList().clear();
    L13:
        j.e("LarkWebView", "larkwebview destroy");
    }

    @Override // com.ss.android.lark.officewebview.base.g, wwb.c
    public OfficeWebView getWebView() {
        return this;
    }

    public final void setParamInjector(wwb.e r1) {
    }

    private final zwb.c getPluginBridge() {
        return (zwb.c) this.s.getValue();
    }

    private final List<String> getPluginList() {
        return (List) this.q.getValue();
    }

    private final String getWebViewType() {
        int r0 = dxb.d.a;
        Lazy<n> r1 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(this);
        TTWebViewUtil.a.c(this);
        return "sys_webview";
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public String getBizType() {
        dxb.b r0 = this.h;
        if (r0 != null) goto L6;
        dxb.b r1 = dxb.b.b;
        r0 = dxb.b.d;
    L6:
        return r0.a();
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public Map<String, Object> getCommonParams() {
        this.t.put("event_time", Long.valueOf(System.currentTimeMillis()));
        Map<String, String> r0 = this.m;
        if (r0 == null) goto L6;
        this.t.putAll(r0);
    L6:
        return this.t;
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public Map<String, Object> getReasonParams() {
        return new HashMap();
    }

    @Override // android.webkit.WebView
    public final void goBack() {
        int r0 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r1 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r1 == null) goto L5;
        r1.goBack();
    L5:
        super.goBack();
    }

    @Override // com.ss.android.lark.officewebview.base.g
    public final void k() {
        this.a.b(com.ss.android.lark.officewebview.service.impl.c.class);
        this.a.b(com.ss.android.lark.officewebview.service.impl.a.class);
        ((oxb.e) this.a.a(oxb.e.class)).J(this);
        Lazy<n> r0 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(this);
        j.e("LarkWebView", "afterInitServiceManager, isTTWebView = false");
        TTWebViewUtil.a.d(this);
        this.a.b(com.ss.android.lark.officewebview.service.impl.g.class);
        com.ss.android.lark.officewebview.quality.stable.d r1 = (com.ss.android.lark.officewebview.quality.stable.d) this.a.a(com.ss.android.lark.officewebview.quality.stable.d.class);
        oxb.f r2 = (oxb.f) this.a.a(oxb.f.class);
        if (r2 == null) goto L5;
        otb.e r3 = r2.B();
    L6:
        r1.M(r3, this);
        if (ixb.a.a() == false) goto L11;
        this.a.b(com.ss.android.lark.officewebview.service.impl.e.class);
        jxb.a r4 = (jxb.a) this.a.a(jxb.a.class);
        if (r4 == null) goto L11;
        r4.b(this);
    L11:
        this.a.b(WebViewPerformanceService.class);
        ((mxb.b) this.a.a(mxb.b.class)).b(this);
        this.a.b(com.ss.android.lark.officewebview.service.impl.d.class);
        this.a.b(com.ss.android.lark.officewebview.service.impl.f.class);
        ((com.ss.android.lark.officewebview.quality.safe.a) this.a.a(com.ss.android.lark.officewebview.quality.safe.a.class)).b(this);
        dxb.b r5 = this.h;
        if (r5 == null) goto L15;
        TTWebViewUtil.a.e(this, r5.a());
        return;
    L15:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        j.e("LarkWebView", "onAttachedToWindow, biz = " + this.n);
        int r0 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r1 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r1 == null) goto L5;
        r1.onAttachedToWindow();
    L5:
        super.onAttachedToWindow();
        oxb.n r2 = getServiceManager();
        if (r2 == null) goto L11;
        jxb.a r3 = (jxb.a) r2.a(jxb.a.class);
        if (r3 == null) goto L12;
        r3.start();
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public void onPause() {
        int r0 = t.a;
        String r1 = getUrl();
        Lazy<Handler> r2 = ThreadUtil.a;
        ThreadUtil.a.b(new h(this, r1));
        super.onPause();
        j.e("LarkWebView", "lark webview onPause, biz = " + this.n);
        if (getIsEnableLarkWebviewInsetPauseTimers() == false) goto L6;
        pauseTimers();
        j.e("LarkWebView", "lark webview call inset pauseTimers");
        return;
    }

    public final boolean n() {
        if (getWebView().o == false) goto L6;
        String r0 = "destroy";
    L13:
        if (r0.length() <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L19;
        j.e("LarkWebView", "biz = " + this.n + " not foreground, reason = " + r0);
        return false;
    L19:
        return true;
    L15:
        r1 = false;
        goto L16
    L6:
        if (getWebView().isAttachedToWindow() == true) goto L9;
        r0 = "not attached";
        goto L13
    L9:
        if (getWebView().isShown() == true) goto L11;
        r0 = "not shown";
        goto L13
    L11:
        r0 = "";
        goto L13
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public void onResume() {
        super.onResume();
        int r0 = t.a;
        String r1 = getUrl();
        Lazy<Handler> r2 = ThreadUtil.a;
        ThreadUtil.a.b(new i(this, r1));
        j.e("LarkWebView", "lark webview onResume, biz = " + this.n);
        if (getIsEnableLarkWebviewInsetResumeTimers() == false) goto L5;
        resumeTimers();
        j.e("LarkWebView", "lark webview call inset resumeTimers");
    L5:
        oxb.n r3 = getServiceManager();
        if (r3 == null) goto L11;
        jxb.a r4 = (jxb.a) r3.a(jxb.a.class);
        if (r4 == null) goto L12;
        r4.start();
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public String getBaseTraceId() {
        return this.i;
    }

    public final String getBizScene$webview_release() {
        return this.n;
    }

    public final xwb.a getBridge() {
        return this.l;
    }

    public final String getContainerMonitorId$webview_release() {
        return this.k;
    }

    @Override // com.ss.android.lark.officewebview.base.g, wwb.c
    public oxb.n getServiceManager() {
        return this.a;
    }

    @Override // com.ss.android.lark.officewebview.base.g, cxb.a
    public long getStartTime() {
        return this.p;
    }

    public final boolean getWebViewIsDestroy() {
        return this.o;
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public final void loadUrl(String r2) {
        int r0 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r1 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r1 == null) goto L5;
        r1.X();
    L5:
        super.loadUrl(r2);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        Iterator r0 = ((ArrayList) this.j.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((View.OnTouchListener) r0.next()).onTouch(this, r3) == false) goto L4;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        if (r3 == null) goto L13;
        r3.setAction(3);
    L13:
        return super.onTouchEvent(r3);
    L8:
        r1 = false;
        goto L9
    }

    public void setBizScene(String r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.n = r2;
    }

    public final void setBizType(dxb.b r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.h = r3;
        Lazy<n> r0 = TTWebViewUtil.a;
        TTWebViewUtil.a.e(this, r3.a());
        ConcurrentHashMap<String, Object> r4 = this.t;
        dxb.b r1 = this.h;
        if (r1 != null) goto L5;
        r1 = dxb.b.d;
    L5:
        r4.put("biz_type", r1.a());
    }

    public final void setInjectedLogParams(Map<String, String> r1) {
        this.m = r1;
    }

    public final void setMonitorConfig(wwb.d r2) {
        if (r2 == null) goto L6;
        r2.getMonitorDataCallback();
        int r3 = com.ss.android.lark.officewebview.util.a.a;
        zwb.a r4 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r4 == null) goto L6;
        r4.buildConfig();
    L6:
        j.b("LarkWebView", "monitor is null");
    }

    public final void setPerformListener(mxb.a r3) {
        if (r3 == null) goto L8;
        oxb.n r0 = getServiceManager();
        if (r0 == null) goto L8;
        mxb.b r1 = (mxb.b) r0.a(mxb.b.class);
        if (r1 == null) goto L8;
        r1.E();
    L8:
        StringBuilder r2 = new StringBuilder("setPerformListener result = ");
        if (r3 != null) goto L11;
        boolean r4 = true;
    L12:
        r2.append(r4);
        j.e("LarkWebView", r2.toString());
        return;
    L11:
        r4 = false;
        goto L12
    }

    public final void setStableListener(com.ss.android.lark.officewebview.quality.stable.c r3) {
        if (r3 == null) goto L8;
        oxb.n r0 = getServiceManager();
        if (r0 == null) goto L8;
        com.ss.android.lark.officewebview.quality.stable.d r1 = (com.ss.android.lark.officewebview.quality.stable.d) r0.a(com.ss.android.lark.officewebview.quality.stable.d.class);
        if (r1 == null) goto L8;
        r1.r();
    L8:
        StringBuilder r2 = new StringBuilder("setStableListener result = ");
        if (r3 != null) goto L11;
        boolean r4 = true;
    L12:
        r2.append(r4);
        j.e("LarkWebView", r2.toString());
        return;
    L11:
        r4 = false;
        goto L12
    }

    public final void setStartTime(long r1) {
        this.p = r1;
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public final void loadUrl(String r1, Map<String, String> r2) {
        super.loadUrl(r1, r2);
        int r3 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r4 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r4 == null) goto L6;
        r4.X();
        return;
    }

    public final dxb.g m(String r2, o.b r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return new dxb.g(r2, r3, this);
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback r4, int r5) {
        j.e("LarkWebView", "startActionMode---run");
        int r1 = com.ss.android.lark.officewebview.util.h.a;
        DependencyContainer r2 = DependencyContainer.a;
        zwb.d r3 = (zwb.d) DependencyContainer.a(zwb.d.class, DependencyContextUniqueId.OfficeWebView);
        if (r3 == null) goto L8;
        ActionMode.Callback r6 = r3.v();
        if (r6 == null) goto L8;
        r4 = r6;
    L8:
        oxb.n r7 = getServiceManager();
        if (r7 == null) goto L11;
        wwb.a r8 = (wwb.a) r7.a(wwb.a.class);
    L12:
        if (r8 == null) goto L15;
        j.e("LarkWebView", "use Customize callBack");
        return super.startActionMode(r8.a(), r5);
    L15:
        j.e("LarkWebView", "not find ILarkWebViewActionMode impl");
        return super.startActionMode(r4, r5);
    L11:
        r8 = null;
        goto L12
    }

    public OfficeWebView(Context r5, AttributeSet r6, int r7) {
        dxb.b r1 = null;
        if ((r7 & 2) == 0) goto L6;
        r6 = null;
    L6:
        if ((r7 & 4) == 0) goto L8;
        r1 = dxb.b.d;
    L8:
        super(new com.ss.android.lark.officewebview.util.d(r5), r6);
        this.h = r1;
        String r8 = "";
        this.i = "";
        this.j = new com.ss.android.lark.officewebview.util.c();
        int r9 = com.ss.android.lark.officewebview.util.a.a;
        zwb.a r10 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r10 == null) goto L12;
        String r11 = r10.Z();
        if (r11 == null) goto L12;
    L13:
        this.k = r11;
        this.l = new xwb.a(this);
        this.n = "";
        this.q = LazyKt.lazy(OfficeWebView$pluginList$2.INSTANCE);
        this.r = LazyKt.lazy(new OfficeWebView$isEnablePluginDuplicateCheck$2(this));
        this.s = LazyKt.lazy(new OfficeWebView$pluginBridge$2(this));
        ConcurrentHashMap<String, Object> r12 = new ConcurrentHashMap();
        dxb.b r0 = this.h;
        if (r0 != null) goto L16;
        r0 = dxb.b.d;
    L16:
        r12.put("biz_type", r0.a());
        r12.put("os", "Android");
        r12.put("trace_id", this.i);
        int r2 = dxb.d.a;
        Lazy<n> r3 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(this);
        r12.put("webview_type", "sys_webview");
        r12.put("ttwebview_version", getTTWebViewVersion());
        TTWebViewUtil.a.d(this);
        TTWebViewUtil.a.c(this);
        r12.put("webview_tt_type", "sys_webview");
        this.t = r12;
        int r13 = l.a;
        o r14 = l.a.a();
        if (r14 == null) goto L22;
        String r15 = r14.k0();
        if (r15 == null) goto L22;
        r8 = r15;
    L22:
        this.i = r8;
        int r16 = t.a;
        this.g.getClass();
        long r4 = System.currentTimeMillis() - 0;
        Lazy<Handler> r17 = ThreadUtil.a;
        ThreadUtil.a.b(new s(this, r4));
        Intrinsics.checkNotNullParameter(r11, "monitorId");
        Intrinsics.checkNotNullParameter(this, "view");
        zwb.a r18 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r18 == null) goto L26;
        r18.i0();
        r18.attach();
        return;
    L26:
        return;
    L12:
        r11 = "";
        goto L13
    }

    public final zwb.f o(String r2, JSONObject r3, xwb.c r4) {
        Intrinsics.checkNotNullParameter(r2, "api");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        return getPluginBridge().a(r2, r3, r4);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int r3, int r4, int r5, int r6) {
        super.onScrollChanged(r3, r4, r5, r6);
        oxb.n r0 = this.a;
        if (r0 == null) goto L8;
        oxb.h r1 = (oxb.h) r0.a(oxb.h.class);
        if (r1 == null) goto L9;
        r1.u(r3, r4, r5, r6);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public final void loadDataWithBaseURL(String r2, String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "data");
        super.loadDataWithBaseURL(r2, r3, r4, r5, r6);
        int r7 = com.ss.android.lark.officewebview.util.a.a;
        getUrl();
        Intrinsics.checkNotNullParameter(this, "webView");
        zwb.a r8 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r8 == null) goto L6;
        r8.X();
        return;
    }

    @Override // android.view.View
    public boolean overScrollBy(int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, boolean r22) {
        boolean r0 = super.overScrollBy(r14, r15, r16, r17, r18, r19, r20, r21, r22);
        oxb.n r2 = this.a;
        if (r2 == null) goto L7;
        oxb.h r3 = (oxb.h) r2.a(oxb.h.class);
        if (r3 == null) goto L7;
        r3.m(r14, r15, r16, r17, r18, r19, r20, r21, r22);
    L7:
        return r0;
    }
}
