package com.bytedance.android.live.browser;

import android.os.Bundle;
import com.bytedance.android.live.browser.jsbridge.newmethods.FetchV3Method;
import com.bytedance.android.live.browser.jsbridge.newmethods.MeasureTextMethod;
import com.bytedance.android.live.browser.jsbridge.newmethods.e4;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.WebDialogFragmentForAnnie;
import com.bytedance.android.livesdk.jsbridge.methods.f5;
import com.bytedance.android.livesdkapi.base.ILiveBrowserFragment;
import com.bytedance.android.livesdkapi.jsb.ExternalJsBridgeMethodInjector;
import com.bytedance.sdk.xbridge.cn.network.XRequestMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/browser/H5AssistService;", "Lcom/bytedance/android/live/browser/IH5AssistService;", "Landroid/os/Bundle;", "bundle", "Lcom/bytedance/android/livesdkapi/base/ILiveBrowserFragment;", "createSaaSDeprecatedBrowserFragment", "Lcom/bytedance/android/live/browser/webview/fragment/BaseWebDialogFragment;", "createWebDialogFragment", "Lcom/bytedance/android/annie/xbridge/mix/e;", "getExternalMethodInjector", "", "bid", "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "providerMethod", "providerPreHandleMethod", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class H5AssistService implements IH5AssistService {

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new FetchV3Method();
        }
    }

    public static final class b implements com.bytedance.ies.web.jsbridge2.f.b {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new MeasureTextMethod();
        }
    }

    public static final class c implements com.bytedance.android.annie.xbridge.mix.e {
        public c() {
        }

        public final Map<String, Object> a() {
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator r1 = ExternalJsBridgeMethodInjector.INSTANCE.getLegacyMethodsProviders().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.putAll((Map) ((Function0) r1.next()).invoke());
            goto L4
        L6:
            Iterator r2 = ExternalJsBridgeMethodInjector.INSTANCE.getStatelessMethodsProviders().iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            r0.putAll((Map) ((Function0) r2.next()).invoke());
            goto L8
        L10:
            Iterator r3 = ExternalJsBridgeMethodInjector.INSTANCE.getStatefulMethodsProviders().iterator();
        L12:
            if (r3.hasNext() == false) goto L14;
            r0.putAll((Map) ((Function0) r3.next()).invoke());
            goto L12
        L14:
            return r0;
        }
    }

    public H5AssistService() {
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public ILiveBrowserFragment createSaaSDeprecatedBrowserFragment(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return null;
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public BaseWebDialogFragment createWebDialogFragment() {
        return new WebDialogFragmentForAnnie();
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public com.bytedance.android.annie.xbridge.mix.e getExternalMethodInjector() {
        List r0 = com.bytedance.android.annie.xbridge.mix.s.a;
        a r1 = a.a;
        Intrinsics.checkNotNullParameter("fetch", "name");
        Intrinsics.checkNotNullParameter(r1, "provider");
        ConcurrentHashMap r4 = com.bytedance.android.annie.xbridge.mix.m.a;
        r4.put("fetch", r1);
        b r2 = b.a;
        Intrinsics.checkNotNullParameter("measureText", "name");
        Intrinsics.checkNotNullParameter(r2, "provider");
        r4.put("measureText", r2);
        Intrinsics.checkNotNullParameter("__getCurrentState", "name");
        Intrinsics.checkNotNullParameter(e4.class, "method");
        com.bytedance.android.annie.xbridge.mix.m.b.put("__getCurrentState", e4.class);
        return new c();
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public Map<String, IDLXBridgeMethod> providerMethod(String r4) {
        Intrinsics.checkNotNullParameter(r4, "bid");
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("x.getAppInfo", new vd7.d());
        r5.put("x.getAPIParams", new de7.c());
        r5.put("x.getUserInfo", new jd7.e());
        r5.put("x.getSettings", new vd7.e());
        r5.put("x.setStorageItem", new ve7.h());
        r5.put("x.getStorageItem", new ve7.f());
        r5.put("x.getStorageInfo", new ve7.e());
        r5.put("x.removeStorageItem", new ve7.g());
        r5.put("x.reportAppLog", new wd7.h());
        r5.put("x.reportMonitorLog", new wd7.i());
        r5.put("x.reportALog", new wd7.g());
        r5.put("x.request", new XRequestMethod());
        int r0 = com.bytedance.ies.bullet.base.bridge.i.a;
        r5.put("x.subscribeEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.c()));
        r5.put("x.unsubscribeEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.d()));
        r5.put("x.publishEvent", com.bytedance.ies.bullet.base.bridge.i.c(new a66.a()));
        FetchV3Method r1 = new FetchV3Method();
        r1.d = true;
        Unit r2 = Unit.INSTANCE;
        r5.put("fetch", com.bytedance.ies.bullet.base.bridge.i.a(com.bytedance.android.annie.xbridge.mix.n.a("fetch", r1, new m16.b())));
        return r5;
    }

    @Override // com.bytedance.android.live.browser.IH5AssistService
    public Map<String, IDLXBridgeMethod> providerPreHandleMethod(String r4) {
        Intrinsics.checkNotNullParameter(r4, "bid");
        LinkedHashMap r5 = new LinkedHashMap();
        m16.b r0 = new m16.b();
        int r1 = com.bytedance.ies.bullet.base.bridge.i.a;
        r5.put("appInfo", com.bytedance.ies.bullet.base.bridge.i.a(com.bytedance.android.annie.xbridge.mix.n.a("appInfo", new com.bytedance.android.livesdk.jsbridge.methods.z(r0), r0)));
        r5.put("userInfo", com.bytedance.ies.bullet.base.bridge.i.a(com.bytedance.android.annie.xbridge.mix.n.a("userInfo", new f5(), r0)));
        return r5;
    }
}
