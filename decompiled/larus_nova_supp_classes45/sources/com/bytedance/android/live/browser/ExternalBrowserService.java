package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveAnnieComponent;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveHybridComponent;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveLynxCallback;
import com.bytedance.android.livesdkapi.jsb.IExternalLiveWebCallback;
import com.bytedance.android.livesdkapi.jsb.IOuterAnnieCardCallback;
import com.bytedance.android.livesdkapi.jsb.IOuterAnnieCardComponent;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.q1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J,\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J$\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J,\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\"\u0010)\u001a\u0004\u0018\u00010$2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J#\u0010*\u001a\u00020!\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010#\u001a\u0002H+H\u0016¢\u0006\u0002\u0010-¨\u0006."}, d2 = {"Lcom/bytedance/android/live/browser/ExternalBrowserService;", "Lcom/bytedance/android/livesdkapi/jsb/IExternalBrowserService;", "()V", "conversionUrlToGeckoUrl", "", "pageUrl", "channel", "configName", "createAnnieCardComponent", "Lcom/bytedance/android/livesdkapi/jsb/IOuterAnnieCardComponent;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "callback", "Lcom/bytedance/android/livesdkapi/jsb/IOuterAnnieCardCallback;", "createHybrideCard", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveAnnieComponent;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/bytedance/android/livesdkapi/jsb/IExternalAnnieLifecycle;", "createLynxComponent", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveHybridComponent;", "activity", "Landroid/app/Activity;", LiveSlardarConstants.EXTRA_KEY_URL, "lynxCallback", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveLynxCallback;", "useAnnie", "", "createWebViewRecord", "webCallback", "Lcom/bytedance/android/livesdkapi/jsb/IExternalLiveWebCallback;", "enqueueEvent", "", "eventName", "params", "Lorg/json/JSONObject;", "handleUrl", "isLynx", "initAnnie", "initAnnieXCardLiveEnv", "readGeckoFromChannel", "sendEventToAllJsBridges", "T", "event", "(Ljava/lang/String;Ljava/lang/Object;)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalBrowserService implements IExternalBrowserService {

    public static final class a implements IOuterAnnieCardComponent {
        public final HybridCard a;
        public final /* synthetic */ HybridCard b;

        public final View getHybridView() {
            return this.b.getHybridView();
        }

        public final void release() {
            this.b.release();
        }

        public final void registerCrashMonitor() {
            IOuterAnnieCardComponent.DefaultImpls.registerCrashMonitor(this);
            this.b.b();
        }

        public final void unRegisterCrashMonitor() {
            IOuterAnnieCardComponent.DefaultImpls.unRegisterCrashMonitor(this);
            this.b.d();
        }

        public final View getMView() {
            return this.a;
        }

        public a(HybridCard r1) {
            this.b = r1;
            this.a = r1;
        }

        public final void updateData(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.b.updateData(r2);
        }

        public final void load(String r2, Map<String, ? extends Object> r3) {
            this.b.load(r2, r3);
        }

        public final <P, R> void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.g<P, R> r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "method");
            this.b.registerMethod(r2, r3);
        }

        public final void registerStatefulMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "provider");
            this.b.registerMethod(r2, r3);
        }

        public final <T> void sendJsEvent(String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "data");
            this.b.sendJsEvent(r2, r3);
        }
    }

    public static final class b extends b7.a {
        public final /* synthetic */ IOuterAnnieCardCallback a;

        public b(IOuterAnnieCardCallback r1) {
            this.a = r1;
        }

        public final void onLoadSuccess(View r2) {
            this.a.onLoadSuccess(r2);
        }

        public final void onPrepareTemplateEnd(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "resFrom");
            this.a.onPrepareTemplateEnd(r2, r3);
        }

        public final void onLoadFail(View r2, String r3, String r4) {
            this.a.onLoadFail(r2, r3, r4);
        }
    }

    public static final class c extends com.bytedance.android.annie.lynx.f {
        public final /* synthetic */ IExternalLiveLynxCallback b;

        public c(IExternalLiveLynxCallback r1) {
            this.b = r1;
            super(null);
        }

        public final void r(LynxView r3, q1.b r4) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            IExternalLiveLynxCallback.ExternalLiveLynxScrollInfo r0 = null;
            if (r4 == null) goto L9;
            String r1 = r4.b;
            if (r1 == null) goto L9;
            String r5 = r4.c;
            if (r5 == null) goto L9;
            r0 = new IExternalLiveLynxCallback.ExternalLiveLynxScrollInfo(r1, r5);
        L9:
            IExternalLiveLynxCallback r6 = this.b;
            if (r6 == null) goto L13;
            r6.onScrollStart(r3, r0);
            return;
        }

        public final void s(LynxView r3, q1.b r4) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            IExternalLiveLynxCallback.ExternalLiveLynxScrollInfo r0 = null;
            if (r4 == null) goto L9;
            String r1 = r4.b;
            if (r1 == null) goto L9;
            String r5 = r4.c;
            if (r5 == null) goto L9;
            r0 = new IExternalLiveLynxCallback.ExternalLiveLynxScrollInfo(r1, r5);
        L9:
            IExternalLiveLynxCallback r6 = this.b;
            if (r6 == null) goto L13;
            r6.onScrollStop(r3, r0);
            return;
        }
    }

    public static final class d implements IExternalLiveHybridComponent {
        public final String a;
        public final HybridCard b;
        public final /* synthetic */ HybridCard c;

        public final void reload() {
        }

        public final void updateData(Map<String, ? extends Object> r1, boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "data");
        }

        public final void release() {
            this.c.release();
        }

        public final void registerCrashMonitor() {
            IExternalLiveHybridComponent.DefaultImpls.registerCrashMonitor(this);
            this.c.b();
        }

        public final void unRegisterCrashMonitor() {
            IExternalLiveHybridComponent.DefaultImpls.unRegisterCrashMonitor(this);
            this.c.d();
        }

        public final View getHybridView() {
            return this.b;
        }

        public final String getUrl() {
            return this.a;
        }

        public final void loadUrl(String r3) {
            Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
            this.c.load(r3, null);
        }

        public final void updateBusinessGlobalProps(Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            HybridCard r0 = this.c;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            HashMap r1 = new HashMap();
            r1.put("initialBusinessProps", r4);
            r0.updateGlobalProps(r1);
        }

        public final void updateData(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.c.updateData(r2);
        }

        public d(HybridCard r1, String r2) {
            this.c = r1;
            this.a = r2;
            this.b = r1;
        }

        public final void loadUrl(String r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
            this.c.load(r2, r3);
        }

        public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "provider");
            this.c.registerMethod(r2, r3);
        }

        public final void renderTemplate(String r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
            this.c.load(r2, r3);
        }

        public final <T> void sendJsEvent(String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r3, "params");
            this.c.sendJsEvent(r2, r3);
        }

        public final <P, R> void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.g<P, R> r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "method");
            this.c.registerMethod(r2, r3);
        }
    }

    public static final class e extends b7.a {
        public final /* synthetic */ IExternalLiveLynxCallback a;

        public e(IExternalLiveLynxCallback r1) {
            this.a = r1;
        }

        public final void onLoadSuccess(View r2) {
            if (r2 == null) goto L10;
            IExternalLiveLynxCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.onLoadSuccess(r2);
        L6:
            IExternalLiveLynxCallback r1 = this.a;
            if (r1 == null) goto L11;
            r1.onRuntimeReady(r2);
            return;
        L11:
            return;
        }

        public final void onPrepareTemplateEnd(boolean r3) {
            IExternalLiveLynxCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.onTemplateLoaded(null, r3);
            return;
        }

        public final boolean onFallback(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errorMessage");
            IExternalLiveLynxCallback r0 = this.a;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.onFallback(r2, r3);
        }

        public final void onInnerFallback(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errorMessage");
            IExternalLiveLynxCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.onInnerFallback(r2, r3);
            return;
        }

        public final void onLoadStart(View r2, boolean r3) {
            if (r2 == null) goto L7;
            IExternalLiveLynxCallback r4 = this.a;
            if (r4 == null) goto L8;
            r4.onPageStart(r2, null);
            return;
        L8:
            return;
        }

        public final void onPrepareTemplateEnd(boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "resFrom");
            IExternalLiveLynxCallback r0 = this.a;
            if (r0 == null) goto L6;
            r0.onTemplateLoaded(null, r3, r4);
            return;
        }

        public final boolean enableInvoke(String r2, JSONObject r3, String r4) {
            IExternalLiveLynxCallback r0 = this.a;
            if (r0 != null) goto L7;
            return true;
        L7:
            return r0.enableInvoke(r2, r3, r4);
        }

        public final void onContainerError(View r1, int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "errorMessage");
            if (r1 == null) goto L8;
            IExternalLiveLynxCallback r4 = this.a;
            if (r4 == null) goto L9;
            r4.onReceivedError(r1, r3);
            return;
        L9:
            return;
        }

        public final void onLoadFail(View r1, String r2, String r3) {
            if (r1 == null) goto L7;
            IExternalLiveLynxCallback r4 = this.a;
            if (r4 == null) goto L8;
            r4.onLoadFailed(r1, r3);
            return;
        L8:
            return;
        }
    }

    public static final class f implements IExternalLiveHybridComponent {
        public final String a;
        public final HybridCard b;
        public final /* synthetic */ HybridCard c;

        public final void reload() {
        }

        public final void updateData(Map<String, ? extends Object> r1, boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "data");
        }

        public final void release() {
            this.c.release();
        }

        public final void registerCrashMonitor() {
            IExternalLiveHybridComponent.DefaultImpls.registerCrashMonitor(this);
            this.c.b();
        }

        public final void unRegisterCrashMonitor() {
            IExternalLiveHybridComponent.DefaultImpls.unRegisterCrashMonitor(this);
            this.c.d();
        }

        public final View getHybridView() {
            return this.b;
        }

        public final String getUrl() {
            return this.a;
        }

        public final void loadUrl(String r3) {
            Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
            this.c.load(r3, null);
        }

        public final void updateBusinessGlobalProps(Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            HybridCard r0 = this.c;
            Intrinsics.checkNotNullParameter(r0, "<this>");
            HashMap r1 = new HashMap();
            r1.put("initialBusinessProps", r4);
            r0.updateGlobalProps(r1);
        }

        public final void updateData(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.c.updateData(r2);
        }

        public f(HybridCard r1, String r2) {
            this.c = r1;
            this.a = r2;
            this.b = r1;
        }

        public final void loadUrl(String r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
            this.c.load(r2, r3);
        }

        public final void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.f.b r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "provider");
            this.c.registerMethod(r2, r3);
        }

        public final void renderTemplate(String r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
            this.c.load(r2, r3);
        }

        public final <T> void sendJsEvent(String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r3, "params");
            this.c.sendJsEvent(r2, r3);
        }

        public final <P, R> void registerMethod(String r2, com.bytedance.ies.web.jsbridge2.g<P, R> r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "method");
            this.c.registerMethod(r2, r3);
        }
    }

    public static final class g extends b7.a {
        public final /* synthetic */ IExternalLiveWebCallback a;

        public g(IExternalLiveWebCallback r1) {
            this.a = r1;
        }

        public final void onLoadSuccess(View r3) {
            if (r3 == null) goto L7;
            IExternalLiveWebCallback r0 = this.a;
            if (r0 == null) goto L8;
            r0.onPageFinished((WebView) r3, null);
            return;
        L8:
            return;
        }

        public final void onLoadStart(View r2, boolean r3) {
            if (r2 == null) goto L7;
            IExternalLiveWebCallback r4 = this.a;
            if (r4 == null) goto L8;
            r4.onPageStarted((WebView) r2, null);
            return;
        L8:
            return;
        }
    }

    public ExternalBrowserService() {
    }

    public void initAnnie() {
        if (com.bytedance.android.annie.ng.g.g == true) goto L6;
        ((IBrowserService) jc1.k.n(IBrowserService.class)).initAnnie();
        return;
    }

    public boolean initAnnieXCardLiveEnv() {
        return ((IBrowserService) jc1.k.n(IBrowserService.class)).initAnnieXCardLiveEnv();
    }

    private final Uri handleUrl(String r5, boolean r6) {
        if (r6 == false) goto L4;
        Uri.Builder r7 = UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon();
    L5:
        Uri r8 = UriProtector.parse(r5).buildUpon().build();
        Set r0 = UriProtector.getQueryParameterNames(r8);
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) r2.next();
        String r4 = UriProtector.getQueryParameter(r8, r3);
        if (r4 == null) goto L12;
        r1.put(r3, r4);
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L13:
        Iterator r9 = r1.entrySet().iterator();
    L15:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r11 = (Map.Entry) r9.next();
        r7.appendQueryParameter((String) r11.getKey(), r11.getValue().toString());
        goto L15
    L17:
        r7.appendQueryParameter(LiveSlardarConstants.EXTRA_KEY_URL, r8.toString());
        return r7.build();
    L4:
        r7 = UriProtector.parse("sslocal://webcast_webview?hybrid_type=h5").buildUpon();
        goto L5
    }

    public void enqueueEvent(String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        EventCenter.enqueueEvent(new Event(r5, System.currentTimeMillis(), new f66.d(r6)));
    }

    public <T> void sendEventToAllJsBridges(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ((IBrowserService) jc1.k.n(IBrowserService.class)).sendEventToAllJsBridges(r2, r3);
    }

    public String conversionUrlToGeckoUrl(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "pageUrl");
        Intrinsics.checkNotNullParameter(r6, "channel");
        Intrinsics.checkNotNullParameter(r7, "configName");
        int r3 = e0.a;
        Intrinsics.checkNotNullParameter(r5, "pageUrl");
        Intrinsics.checkNotNullParameter(r6, "channel");
        Intrinsics.checkNotNullParameter(r7, "configName");
        d1 r8 = e0.a(r5, r6, r7);
        if (r8 == null) goto L6;
        String r9 = r8.b;
        if (r9 == null) goto L6;
        return r9;
    L6:
        return "";
    }

    public IOuterAnnieCardComponent createAnnieCardComponent(Context r3, Uri r4, IOuterAnnieCardCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        Intrinsics.checkNotNullParameter(r5, "callback");
        HybridCard r6 = ((IBrowserService) jc1.k.n(IBrowserService.class)).getHybridCard(r3, r4, new b(r5));
        if (r6 != null) goto L7;
        return null;
    L7:
        return new a(r6);
    }

    public IExternalLiveAnnieComponent createHybrideCard(Context r4, Uri r5, IExternalAnnieLifecycle r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "uri");
        Intrinsics.checkNotNullParameter(r6, NewBroadcastMonitor.STAGE.LIFECYCLE);
        IBrowserService r0 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r0 == null) goto L5;
        HybridCard r7 = r0.getHybridCard(r4, r5, new com.bytedance.android.live.browser.a(r6));
    L6:
        if (r7 != null) goto L8;
        return null;
    L8:
        return new p(r7);
    L5:
        r7 = null;
        goto L6
    }

    public IExternalLiveHybridComponent createLynxComponent(Activity r2, String r3, IExternalLiveLynxCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        return createLynxComponent(r2, r3, r4, true);
    }

    public IExternalLiveHybridComponent createWebViewRecord(Activity r2, String r3, IExternalLiveWebCallback r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        return createWebViewRecord(r2, r3, r4, true);
    }

    public JSONObject readGeckoFromChannel(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "pageUrl");
        Intrinsics.checkNotNullParameter(r3, "channel");
        Intrinsics.checkNotNullParameter(r4, "configName");
        return e0.d(r2, r3, r4);
    }

    public IExternalLiveHybridComponent createLynxComponent(Activity r4, String r5, IExternalLiveLynxCallback r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, LiveSlardarConstants.EXTRA_KEY_URL);
        if (r7 == false) goto L9;
        Uri r8 = handleUrl(r5, true);
        HybridCard r9 = ((IBrowserService) jc1.k.n(IBrowserService.class)).getHybridCard(r4, r8, new e(r6));
        if (r9 != null) goto L7;
        return null;
    L7:
        r9.c(new c(r6));
        return new d(r9, r5);
    L9:
        return null;
    }

    public IExternalLiveHybridComponent createWebViewRecord(Activity r6, String r7, IExternalLiveWebCallback r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, LiveSlardarConstants.EXTRA_KEY_URL);
        if (StringsKt.startsWith$default(r7, "http", false, 2, null) == false) goto L5;
        String r0 = r7;
    L6:
        if (r9 == false) goto L12;
        Uri r11 = handleUrl(r0, false);
        HybridCard r12 = ((IBrowserService) jc1.k.n(IBrowserService.class)).getHybridCard(r6, r11, new g(r8));
        if (r12 != null) goto L11;
        return null;
    L11:
        return new f(r12, r7);
    L12:
        return null;
    L5:
        r0 = i2.d(UriProtector.parse(r7), LiveSlardarConstants.EXTRA_KEY_URL, "");
        goto L6
    }
}
