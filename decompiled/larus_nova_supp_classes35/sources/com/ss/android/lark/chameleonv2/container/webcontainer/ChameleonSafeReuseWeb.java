package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleObserver;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.GeckoConst;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.UIThreadCallbackAdapter;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonFragmentV2;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.AppInfoUtils;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import tb5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChameleonSafeReuseWeb extends n implements LifecycleObserver, xwb.k {
    public final boolean c;
    public boolean d;
    public Integer e;
    public final b f;
    public final h g;
    public final Map<WebViewClient, Integer> h;
    public final Map<WebChromeClient, Integer> i;
    public n0b.a j;
    public final a k;
    public final wv4.a l;
    public final Map<String, tb5.i<?>> m;
    public vv4.k.b n;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ ChameleonSafeReuseWeb a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a(ChameleonSafeReuseWeb r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r3) {
            if (this.a.d == false) goto L6;
            com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonSafeReuseWeb", "webView detached from window, deactivate owner. hashCode:" + this.a.e);
            ChameleonSafeReuseWeb r4 = this.a;
            r4.s(false, r4.e);
            return;
        }
    }

    public class b extends i {
        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.i
        public final boolean onRenderProcessGone(WebView r1, RenderProcessGoneDetail r2) {
            return false;
        }

        public b(f r1) {
            super(r1);
        }
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void removeJSONParamInterceptor() {
        this.n = null;
    }

    public final String toString() {
        return "CML_TAG_ChameleonSafeReuseWeb";
    }

    public final ChameleonWebView K() {
        Object r0 = this.a;
        if ((r0 instanceof ChameleonWebView) == true) goto L5;
        com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_ChameleonSafeReuseWeb", "webview is not instanceof ChameleonWebView");
        return null;
    L5:
        return (ChameleonWebView) r0;
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final tb5.n getBridge() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChameleonSafeReuseWeb(ChameleonWebView r8) {
        super(r8, r8.getBridge());
        this.k = new a(this);
        this.m = new HashMap();
        this.n = null;
        boolean r0 = false;
        int r1 = com.ss.android.lark.officesdk.utils.di.d.a;     // Catch: Exception -> L18
        ApplicationInfo r2 = com.ss.android.lark.officesdk.utils.di.d.a.a().getApplicationInfo();     // Catch: Exception -> L18
        if ((r2.flags & 2) == 0) goto L6;
        boolean r3 = true;
    L7:
        boolean r4 = r2.packageName.contains(GeckoConst.DEBUG);     // Catch: Exception -> L18
        String r5 = AppInfoUtils.a(com.ss.android.lark.officesdk.utils.di.d.a.a()).toLowerCase();     // Catch: Exception -> L18
        boolean r6 = r5.contains(com.ss.android.lark.chameleon.util.AppInfoUtils.VERSION_TYPE.VERSION_ALPHA);     // Catch: Exception -> L18
        boolean r7 = r5.contains(com.ss.android.lark.chameleon.util.AppInfoUtils.VERSION_TYPE.VERSION_BETA);     // Catch: Exception -> L18
        if (r6 == true) goto L12;
        if (r7 == true) goto L12;
        if (r3 == true) goto L12;
        if (r4 == false) goto L13;
    L12:
        r0 = true;
        goto L13
    L6:
        r3 = false;
    L13:
        this.c = r0;
        f r9 = new f(r8);
        this.f = new b(r9);
        this.g = new h(r9);
        this.h = new HashMap();
        this.i = new HashMap();
        xwb.a r10 = r8.getBridge();
        r10.getClass();
        Intrinsics.checkNotNullParameter(this, "interceptor");
        if (r10.d.contains(this) == true) goto L16;
        r10.d.add(this);
    L16:
        wv4.a r11 = new wv4.a(this);
        this.l = r11;
        r11.b = new e(this);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void addWebChromeClientDelegate(WebChromeClient r3) {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonSafeReuseWeb", "addWebChromeClientDelegate ");
        addWebChromeClientDelegate(r3, 0);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void addWebViewClientDelegate(WebViewClient r2) {
        addWebViewClientDelegate(r2, 0);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void c(vv4.k.a r3) {
        if (K() != null) goto L5;
        return;
    L5:
        ChameleonWebView r0 = K();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "renderGoneListener");
        UIThreadCallbackAdapter r1 = r0.h1;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "renderGoneListener");
        r1.c.remove(r3);
        CopyOnWriteArrayList<vv4.k.a> r2 = RenderGoneHelper.a;
        Intrinsics.checkNotNullParameter(r3, "cb");
        RenderGoneHelper.a.remove(r3);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void n(vv4.k.b r1) {
        this.n = r1;
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void o(WebPluginHost r8) {
        com.ss.android.lark.officesdk.utils.di.j.c("CML_TAG_ChameleonSafeReuseWeb", "replaceFragment call stack:\n ", new Throwable());
        ChameleonPluginHost r9 = (ChameleonPluginHost) r8;
        FragmentManager r0 = r9.getFragment().getFragmentManager();
        if (r0 == null) goto L19;
        ChameleonConfig r1 = r9.getChameleonConfig();
        String r2 = u1b.a.b(r1);
        com.ss.android.lark.chameleonv2.container.webcontainer.util.b.e(r2, r1, com.ss.android.lark.chameleonv2.container.webcontainer.util.b.c(r9.getSession()));
        Context r3 = r9.getFragment().getContext();
        if (r3 != null) goto L13;
        int r4 = com.ss.android.lark.officesdk.utils.di.d.a;
        DependencyContainer r5 = DependencyContainer.a;
        ntb.e r6 = DependencyContainer.a(ntb.e.class, null);
        if (r6 == null) goto L12;
        r3 = r6.getTopActivity();
        if (r3 != null) goto L13;
        r3 = com.ss.android.lark.officesdk.utils.di.d.a.a();
        goto L13
    L12:
        throw new IllegalStateException("IContextDependency not injected");
    L13:
        String r7 = r1.getLoadUrl();
        Bundle r10 = r9.getFragment().getArguments();
        int r11 = ChameleonFragmentV2.x;
        Fragment r12 = ChameleonFragmentV2.a.a(r3, r7, r2, r10);
        FragmentTransaction r13 = r0.beginTransaction();
        int r14 = r9.getFragment().getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r14) == true) goto L17;
        r13 = r13.replace(r14, r12);
    L17:
        r13.commitAllowingStateLoss();
        return;
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void removeWebChromeClientDelegate(WebChromeClient r2) {
        ((CopyOnWriteArrayList) this.g.d).remove(r2);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void removeWebViewClientDelegate(WebViewClient r2) {
        ((CopyOnWriteArrayList) this.f.e).remove(r2);
        ((HashMap) this.h).remove(r2);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void unbindJSHandler(String r2) {
        ((HashMap) this.m).remove(r2);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void w(vv4.k.a r3) {
        if (K() != null) goto L5;
        return;
    L5:
        ChameleonWebView r0 = K();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "renderGoneListener");
        UIThreadCallbackAdapter r1 = r0.h1;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "renderGoneListener");
        r1.c.add(r3);
        CopyOnWriteArrayList<vv4.k.a> r2 = RenderGoneHelper.a;
        Intrinsics.checkNotNullParameter(r3, "cb");
        RenderGoneHelper.a.add(r3);
    }

    public final boolean J(final Message r10, final tb5.m r11) {
        if (this.d == true) goto L6;
        return false;
    L6:
        if ((this.a instanceof OfficeWebView) == true) goto L8;
        return false;
    L8:
        final String r4 = r10.getApiName();
        if (r4 != null) goto L11;
        return false;
    L11:
        Map<String, tb5.i<?>> r0 = this.m;
        if (r0 != null) goto L14;
    L17:
        boolean r1 = true;
    L18:
        if (r1 == false) goto L21;
        r10.getData();
        return false;
    L21:
        final tb5.i r5 = (tb5.i) ((HashMap) this.m).get(r4);
        if (r5 != null) goto L24;
        r10.getData();
        return false;
    L24:
        if ((r5 instanceof q) == false) goto L32;
        n0b.a r2 = this.j;
        if (r2 == null) goto L28;
        r2.a(r4);
    L28:
        String r12 = r10.getData();
        if (this.c == true) goto L31;
        tb5.f.c(r12, r5, r11);
    L33:
        return true;
    L31:
        tb5.f.c(r12, r5, r11);
        goto L33
    L32:
        Runnable r3 = new com.ss.android.lark.chameleonv2.container.webcontainer.b(this, r4, r5, r10, r11);
        Lazy r13 = ThreadUtil.a;
        ThreadUtil.a.g(r3);
        goto L33
    L14:
        if (((HashMap) r0).isEmpty() == true) goto L17;
        r1 = false;
        goto L18
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void addWebChromeClientDelegate(WebChromeClient r3, int r4) {
        Map<WebChromeClient, Integer> r0 = this.i;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, Integer.valueOf(r4));
        h r5 = this.g;
        if (((CopyOnWriteArrayList) r5.d).contains(r3) == true) goto L5;
        ((CopyOnWriteArrayList) r5.d).add(r3);
    L5:
        h r6 = this.g;
        Comparator r7 = new c(this);
        r6.getClass();
        ArrayList r2 = new ArrayList(r6.d);
        Collections.sort(r2, r7);
        ((CopyOnWriteArrayList) r6.d).clear();
        ((CopyOnWriteArrayList) r6.d).addAll(r2);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void addWebViewClientDelegate(WebViewClient r3, int r4) {
        Map<WebViewClient, Integer> r0 = this.h;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, Integer.valueOf(r4));
        b r5 = this.f;
        if (((CopyOnWriteArrayList) r5.e).contains(r3) == true) goto L5;
        ((CopyOnWriteArrayList) r5.e).add(r3);
    L5:
        b r6 = this.f;
        Comparator r7 = new d(this);
        r6.getClass();
        ArrayList r2 = new ArrayList(r6.e);
        Collections.sort(r2, r7);
        ((CopyOnWriteArrayList) r6.e).clear();
        ((CopyOnWriteArrayList) r6.e).addAll(r2);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void h(String r2, tb5.i r3) {
        ((HashMap) this.m).put(r2, r3);
    }

    public final boolean p(Message r3, xwb.d r4) {
        Message r0 = new Message();
        r0.setData(r3.getData());
        r0.setCallbackID(r3.getCallbackID());
        r0.setApiName(r3.getApiName());
        return J(r3, new k(r4));
    }

    public final void s(boolean r3, Integer r4) {
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonSafeReuseWeb", "setWebViewActive:" + r3 + ", hashCode:" + r4);
        this.d = r3;
        if (K() != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L13;
        this.e = r4;
        ChameleonWebView r5 = K();
        b r6 = this.f;
        i r7 = r5.g2;
        if (((CopyOnWriteArrayList) r7.e).contains(r6) == true) goto L9;
        ListProtector.add(r7.e, 0, r6);
    L9:
        ChameleonWebView r8 = K();
        h r9 = this.g;
        h r10 = r8.h2;
        if (((CopyOnWriteArrayList) r10.d).contains(r9) == true) goto L12;
        ListProtector.add(r10.d, 0, r9);
    L12:
        K().removeOnAttachStateChangeListener(this.k);
        K().addOnAttachStateChangeListener(this.k);
        return;
    L13:
        this.e = null;
        ChameleonWebView r11 = K();
        ((CopyOnWriteArrayList) r11.g2.e).remove(this.f);
        ChameleonWebView r12 = K();
        ((CopyOnWriteArrayList) r12.h2.d).remove(this.g);
        K().removeOnAttachStateChangeListener(this.k);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.n
    public final void a(String r5, JSONObject r6, ValueCallback<String> r7) {
        vv4.k.b r0 = this.n;
        if (r0 != null) goto L5;
    L21:
        this.b.a(r5, r6, r7);
        return;
    L5:
        if (r0.enableAddJsonExtraParam() == false) goto L21;
        if (this.n.getInterceptJSONObject() == null) goto L21;
        JSONObject r1 = this.n.getInterceptJSONObject();
        String r2 = this.n.getInterceptFuncName();
        if (r6 == null) goto L21;
        if (TextUtils.isEmpty(r2) == true) goto L21;
        if (r5 == null) goto L21;
        if (r5.contains(r2) == false) goto L21;
        Iterator r3 = r1.keySet().iterator();
    L17:
        if (r3.hasNext() == false) goto L21;
        String r4 = (String) r3.next();
        if (r6.containsKey(r4) == true) goto L17;
        r6.put(r4, r1.get(r4));
        goto L17
    }
}
