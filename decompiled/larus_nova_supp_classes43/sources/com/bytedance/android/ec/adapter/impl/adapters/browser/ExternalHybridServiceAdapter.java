package com.bytedance.android.ec.adapter.impl.adapters.browser;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.android.livesdkapi.TTInternalBusinessService;
import com.bytedance.android.livesdkapi.jsb.ExternalJsBridgeMethodInjector;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveHybridComponent;
import com.bytedance.android.livesdkapi.service.IExternalLiveLynxCallback;
import com.bytedance.android.livesdkapi.service.IExternalLynxComponent;
import com.bytedance.android.livesdkapi.service.IInternalBusinessService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pd.g;
import pd.h;
import pd.i;
import pd.j;
import pd.k;
import pd.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b6\u00107J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J%\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0013H\u0016J,\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\"\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u001fH\u0016J\"\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010'\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016JE\u00102\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/bytedance/android/ec/adapter/impl/adapters/browser/ExternalHybridServiceAdapter;", "Lpd/e;", "Landroid/app/Activity;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "", com.bytedance.android.ec.core.event.a.KEY_URL, "Lpd/h;", "callback", "", "useAnnie", "Lpd/j;", "createLynxComponent", "T", "event", "params", "", "sendEventToAllJsBridges", "(Ljava/lang/String;Ljava/lang/Object;)V", "eventName", "Lorg/json/JSONObject;", "enqueueEvent", "Lpd/i;", "webCallback", "Lpd/g;", "createWebViewRecord", "Lpd/f;", "getExternalJsBridgeMethodInjectorAdapter", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "Lpd/k;", "Lpd/l;", "createAnnieCardComponent", "Lpd/c;", "lifecycle", "Lpd/b;", "createAnnieComponent", "isLynx", "preloadResourceForLynx", "isAnnieInit", "initAnnieXCardLiveEnv", "initAnnie", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "bizKey", "", "expiredTime", "strategy", "Lpd/d;", "callBack", "prerenderAnnieWithSchema", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lpd/d;)V", "TAG", "Ljava/lang/String;", "<init>", "()V", "ec-adapter-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalHybridServiceAdapter implements pd.e {
    public static final ExternalHybridServiceAdapter INSTANCE = null;
    private static final String TAG = null;

    public static final class a implements IExternalLiveLynxCallback {
        public final /* synthetic */ h a;

        public final void onFallback() {
            h r0 = this.a;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        public a(h r1) {
            this.a = r1;
        }

        public final void onFirstScreen(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            h r0 = this.a;
            if (r0 == null) goto L6;
            r0.onFirstScreen(r10);
            return;
        }

        public final void onLoadSuccess(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            h r0 = this.a;
            if (r0 == null) goto L6;
            r0.onLoadSuccess(r10);
            return;
        }

        public final void onRuntimeReady(View r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            h r0 = this.a;
            if (r0 == null) goto L6;
            r0.onRuntimeReady(r10);
            return;
        }

        public final void onLoadFailed(View r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            h r0 = this.a;
            if (r0 == null) goto L6;
            r0.onLoadFailed(r10, r11);
            return;
        }

        public final void onPageStart(View r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            h r0 = this.a;
            if (r0 == null) goto L6;
            r0.onPageStart(r10, r11);
            return;
        }

        public final void onReceivedError(View r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
            h r0 = this.a;
            if (r0 == null) goto L6;
            r0.onReceivedError(r10, r11);
            return;
        }
    }

    public static final class b implements g {
        public final /* synthetic */ IExternalLiveHybridComponent a;

        @Override // pd.g
        public final void a() {
        }

        @Override // pd.g
        public final void c() {
        }

        @Override // pd.g
        public final void updateBusinessGlobalProps(Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
        }

        @Override // pd.g
        public final void updateGlobalProps(Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "map");
        }

        @Override // pd.g
        public final View getHybridView() {
            return this.a.getHybridView();
        }

        @Override // pd.g
        public final void release() {
            this.a.release();
        }

        @Override // pd.g
        public final View b() {
            return getHybridView();
        }

        public b(IExternalLiveHybridComponent r1) {
            this.a = r1;
        }

        @Override // pd.g
        public final void loadUrl(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a.loadUrl(r10);
        }

        @Override // pd.g
        public final void updateData(Map<String, ? extends Object> r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            this.a.updateData(r10);
        }

        @Override // pd.g
        public final void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.f.b r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r11, "provider");
            this.a.registerMethod(r10, r11);
        }

        @Override // pd.g
        public final void renderTemplate(String r10, Map<String, ? extends Object> r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            this.a.renderTemplate(r10, r11);
        }

        @Override // pd.g
        public final <T> void sendJsEvent(String r10, T r11) {
            Intrinsics.checkNotNullParameter(r10, "event");
            Intrinsics.checkNotNullParameter(r11, "params");
            this.a.sendJsEvent(r10, r11);
        }

        @Override // pd.g
        public final <P, R> void registerMethod(String r10, com.bytedance.ies.web.jsbridge2.g<P, R> r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r11, "method");
            this.a.registerMethod(r10, r11);
        }
    }

    public static final class c implements pd.f {
        public c() {
        }

        @Override // pd.f
        public final f a(IECBridgeMethod r10) {
            Intrinsics.checkNotNullParameter(r10, "bridgeMethod");
            return new f(r10);
        }

        @Override // pd.f
        public final void b(Function0<? extends Map<String, ? extends com.bytedance.ies.web.jsbridge2.f.b>> r10) {
            Intrinsics.checkNotNullParameter(r10, "methods");
            ExternalJsBridgeMethodInjector.INSTANCE.getStatefulMethodsProvidersForFragmentScene().add(r10);
        }

        @Override // pd.f
        public final void c(Function0<? extends Map<String, ? extends com.bytedance.ies.web.jsbridge2.f.b>> r10) {
            Intrinsics.checkNotNullParameter(r10, "methods");
            ExternalJsBridgeMethodInjector.INSTANCE.getStatefulMethodsProviders().add(r10);
        }

        @Override // pd.f
        public final com.bytedance.android.ec.adapter.impl.adapters.browser.c d(IECBridgeMethod r10) {
            Intrinsics.checkNotNullParameter(r10, "bridgeMethod");
            return new com.bytedance.android.ec.adapter.impl.adapters.browser.c(r10);
        }
    }

    private ExternalHybridServiceAdapter() {
    }

    public l createAnnieCardComponent(Context r10, Uri r11, k r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "uri");
        Intrinsics.checkNotNullParameter(r12, "callback");
        return null;
    }

    @Override // pd.e
    public boolean initAnnie() {
        return false;
    }

    public boolean initAnnieXCardLiveEnv() {
        return false;
    }

    @Override // pd.e
    public boolean isAnnieInit() {
        return false;
    }

    @Override // pd.e
    public void preloadResourceForLynx(String r1, boolean r10) {
    }

    @Override // pd.e
    public void prerenderAnnieWithSchema(Context r1, String r10, String r11, Integer r12, String r13, pd.d r14) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "bizKey");
    }

    @Override // pd.e
    public <T> void sendEventToAllJsBridges(String r1, T r10) {
        Intrinsics.checkNotNullParameter(r1, "event");
    }

    static {
        INSTANCE = new ExternalHybridServiceAdapter();
        TAG = "shopping-debug-ExternalHybridServiceAdapter";
    }

    @Override // pd.e
    public pd.f getExternalJsBridgeMethodInjectorAdapter() {
        return new c();
    }

    @Override // pd.e
    public void enqueueEvent(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "params");
        IInternalBusinessService r0 = TTInternalBusinessService.Companion.getBusinessService();
        if (r0 == null) goto L6;
        r0.enqueueEvent(r10, r11);
        return;
    }

    @Override // pd.e
    public void releasePrerender(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "bizKey");
    }

    @Override // pd.e
    public pd.b createAnnieComponent(Context r10, String r11, pd.c r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "lifecycle");
        IInternalBusinessService r0 = TTInternalBusinessService.Companion.getBusinessService();
        if (r0 == null) goto L5;
        IExternalLiveAnnieComponent r13 = r0.createHybrideCard(r10, UriProtector.parse(r11), new qe.f(r12));
    L6:
        Object r14 = "null";
        if (r0 != null) goto L9;
        r0 = "null";
    L9:
        r0.toString();
        if (r13 != null) goto L12;
        IExternalLiveAnnieComponent r15 = "null";
    L13:
        r15.toString();
        if (r13 == null) goto L19;
        View r16 = r13.getHybridView();
        if (r16 == null) goto L19;
        r14 = r16;
    L19:
        r14.toString();
        if (r13 != null) goto L22;
        return null;
    L22:
        return new qe.b(r13);
    L12:
        r15 = r13;
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    @Override // pd.e
    public JSONObject readGeckoFromChannel(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "pageUrl");
        Intrinsics.checkNotNullParameter(r11, "channel");
        Intrinsics.checkNotNullParameter(r12, "configName");
        Intrinsics.checkNotNullParameter(r10, "pageUrl");
        Intrinsics.checkNotNullParameter(r11, "channel");
        Intrinsics.checkNotNullParameter(r12, "configName");
        return null;
    }

    @Override // pd.e
    public String tranceUrlToGeckoUrl(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "channel");
        Intrinsics.checkNotNullParameter(r12, "bundle");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "channel");
        Intrinsics.checkNotNullParameter(r12, "bundle");
        return "";
    }

    @Override // pd.e
    public j createLynxComponent(Activity r10, String r11, h r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        IInternalBusinessService r14 = TTInternalBusinessService.Companion.getBusinessService();
        if (r14 == null) goto L9;
        final IExternalLynxComponent r15 = r14.createLynxComponent(r10, r11, new a(r12));
        if (r15 != null) goto L8;
        return null;
    L8:
        return new AnonymousClass1(r15);
    L9:
        return null;
    }

    @Override // pd.e
    public g createWebViewRecord(Activity r10, String r11, i r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        IExternalBrowserService r14 = jc1.k.f(IExternalBrowserService.class);
        if (r14 == null) goto L9;
        int r0 = qe.e.a;
        IExternalLiveHybridComponent r15 = r14.createWebViewRecord(r10, r11, new qe.d(r12));
        if (r15 != null) goto L8;
        return null;
    L8:
        return new b(r15);
    L9:
        return null;
    }
}
