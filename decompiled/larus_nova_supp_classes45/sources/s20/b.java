package s20;

import com.bytedance.android.live.browser.di.H5Module_ProvideH5ServiceFactory;
import com.bytedance.android.live.browser.di.H5Module_ProvideInternalServiceFactory;
import com.bytedance.android.live.browser.di.H5Module_ProvideWebDialogFragmentFactory;
import com.bytedance.android.live.browser.di.HybridBaseModule_ProvideGsonFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideJsBridgeInternalServiceFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideJsBridgeServiceFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideLocalPrefetchConfigFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvidePrefetchConfigFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideStateObservingServiceFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideStateObservingServiceInterfaceFactory;
import com.bytedance.android.live.browser.di.JsBridgeModule_ProvideWebPrefetchProcessorFactory;
import com.bytedance.android.live.browser.jsbridge.JsBridgeService;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.browser.jsbridge.state.StateObservingService;
import com.bytedance.android.live.browser.q;
import com.bytedance.android.live.browser.u;
import com.bytedance.android.live.browser.v;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.lynx.di.LiveLynxModule_ProvideLynxServiceFactory;
import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements h {
    public final f a;
    public final b b;
    public Provider<com.bytedance.android.live.browser.jsbridge.h> c;
    public Provider<JsBridgeService> d;
    public Provider<v> e;
    public Provider<q> f;
    public Provider<u> g;
    public Provider<w> h;
    public Provider<Gson> i;
    public Provider<StateObservingService> j;
    public Provider<i> k;
    public H5Module_ProvideWebDialogFragmentFactory l;
    public Provider<com.bytedance.android.live.browser.jsbridge.g> m;
    public Provider<com.bytedance.android.live.browser.jsbridge.g> n;

    public final a a() {
        return new a(this.b);
    }

    public b(c r2, f r3, ml0.a r4, d r5) {
        this.b = this;
        this.a = r3;
        this.c = DoubleCheck.provider(JsBridgeModule_ProvideWebPrefetchProcessorFactory.create(r3));
        Provider<JsBridgeService> r0 = DoubleCheck.provider(JsBridgeModule_ProvideJsBridgeInternalServiceFactory.create(r3));
        this.d = r0;
        this.e = DoubleCheck.provider(JsBridgeModule_ProvideJsBridgeServiceFactory.create(r3, r0));
        Provider<q> r1 = DoubleCheck.provider(H5Module_ProvideInternalServiceFactory.create(r2));
        this.f = r1;
        this.g = DoubleCheck.provider(H5Module_ProvideH5ServiceFactory.create(r2, r1));
        this.h = DoubleCheck.provider(LiveLynxModule_ProvideLynxServiceFactory.create(r4));
        Provider<Gson> r6 = DoubleCheck.provider(HybridBaseModule_ProvideGsonFactory.create(r5));
        this.i = r6;
        Provider<StateObservingService> r7 = DoubleCheck.provider(JsBridgeModule_ProvideStateObservingServiceFactory.create(r3, r6));
        this.j = r7;
        this.k = DoubleCheck.provider(JsBridgeModule_ProvideStateObservingServiceInterfaceFactory.create(r3, r7));
        this.l = H5Module_ProvideWebDialogFragmentFactory.create(r2);
        this.m = DoubleCheck.provider(JsBridgeModule_ProvidePrefetchConfigFactory.create(r3));
        this.n = DoubleCheck.provider(JsBridgeModule_ProvideLocalPrefetchConfigFactory.create(r3));
    }
}
