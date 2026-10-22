package com.ss.android.lark.chameleon;

import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tb5.i;
import vv4.k;
import vv4.m;
import yv4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001a\u001b\u001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\rH\u0016J \u0010\n\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011`\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0015\u0010\u0006\u001a\u00060\u0007R\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/lazy/BridgeInteractivePlugin;", "<init>", "()V", "webviewHandlerContext", "Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$WebviewHandlerContext;", "getWebviewHandlerContext", "()Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$WebviewHandlerContext;", "getBridgeHandlers", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "handlersHolder", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleon/AbsChameleonHandler;", "Lkotlin/collections/ArrayList;", "getUrl", "getChameleonConfig", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "getSession", "callbackOk", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "Companion", "WebviewHandlerContext", "LKAPIEvent", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsChameleonPlugin extends BasePlugin<ChameleonPluginHost> implements a {
    public static final Companion Companion = null;
    public static final String TAG = "CML_TAG_AbsChameleonPlugin";
    private final WebviewHandlerContext webviewHandlerContext;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$Companion;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "TAG", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$LKAPIEvent;", "T", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", IPortraitService.TYPE, com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "sender", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "detail", "<init>", "(Ljava/lang/String;ILjava/io/Serializable;)V", "getType", "()Ljava/lang/String;", "getSender", "()I", "getDetail", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ILjava/io/Serializable;)Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$LKAPIEvent;", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", "toString", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LKAPIEvent<T extends Serializable> implements NonProguard {

        @SerializedName("detail")
        private final T detail;

        @SerializedName("sender")
        private final int sender;

        @SerializedName(IPortraitService.TYPE)
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LKAPIEvent copy$default(LKAPIEvent r0, String r1, int r2, Serializable r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.sender;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.detail;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.type;
        }

        public final int component2() {
            return this.sender;
        }

        public final T component3() {
            return this.detail;
        }

        public final LKAPIEvent<T> copy(String r2, int r3, T r4) {
            Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
            Intrinsics.checkNotNullParameter(r4, "detail");
            return new LKAPIEvent(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof LKAPIEvent) == true) goto L8;
            return false;
        L8:
            LKAPIEvent r6 = (LKAPIEvent) r5;
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
            return false;
        L12:
            if (this.sender == r6.sender) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.detail, r6.detail) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + this.sender) * 31) + this.detail.hashCode();
        }

        public String toString() {
            return "LKAPIEvent(type=" + this.type + ", sender=" + this.sender + ", detail=" + this.detail + ')';
        }

        public final T getDetail() {
            return this.detail;
        }

        public final int getSender() {
            return this.sender;
        }

        public final String getType() {
            return this.type;
        }

        public LKAPIEvent(String r2, int r3, T r4) {
            Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
            Intrinsics.checkNotNullParameter(r4, "detail");
            this.type = r2;
            this.sender = r3;
            this.detail = r4;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J'\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u0002H\u0011H\u0016¢\u0006\u0002\u0010\u0015R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/AbsChameleonPlugin$WebviewHandlerContext;", "Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", "<init>", "(Lcom/ss/android/lark/chameleon/AbsChameleonPlugin;)V", "getCmlContext", "Landroid/content/Context;", "getFragment", "Landroidx/fragment/app/Fragment;", "webviewLoader", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getSession", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "getBizName", "sendEvent", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "T", "Ljava/io/Serializable;", IPortraitService.TYPE, Keys.API_RETURN_KEY_DATA, "(Ljava/lang/String;Ljava/io/Serializable;)V", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class WebviewHandlerContext implements IChameleonHandlerContext {
        final /* synthetic */ AbsChameleonPlugin this$0;

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public Context getCmlContext() {
            return AbsChameleonPlugin.access$getContext(this.this$0);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public Fragment getFragment() {
            ChameleonPluginHost r0 = this.this$0.getHost();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getFragment();
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public String getSession() {
            ChameleonPluginHost r0 = this.this$0.getHost();
            if (r0 == null) goto L6;
            String r1 = r0.getSession();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public IChameleonLoader getWebviewLoader() {
            ChameleonPluginHost r0 = this.this$0.getHost();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getLoader();
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public String getBizName() {
            ChameleonConfig r0 = getChameleonConfig();
            if (r0 == null) goto L6;
            String r1 = r0.getBizName();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public ChameleonConfig getChameleonConfig() {
            return IChameleonHandlerContext.DefaultImpls.getChameleonConfig(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public WebView getWebview() {
            return IChameleonHandlerContext.DefaultImpls.getWebview(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public void destroyWebview() {
            IChameleonHandlerContext.DefaultImpls.destroyWebview(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public void reloadWebview() {
            IChameleonHandlerContext.DefaultImpls.reloadWebview(this);
        }

        public WebviewHandlerContext(AbsChameleonPlugin r1) {
            this.this$0 = r1;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public <T extends m> T getWebService(Class<T> r1) {
            return (T) IChameleonHandlerContext.DefaultImpls.getWebService(this, r1);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public <T extends Serializable> void sendEvent(String r5, T r6) {
            Intrinsics.checkNotNullParameter(r5, IPortraitService.TYPE);
            Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
            ChameleonPluginHost r0 = this.this$0.getHost();
            if (r0 == null) goto L10;
            k r1 = r0.getWeb();
            if (r1 == null) goto L11;
            WebView r2 = r1.getWebView();
            if (r2 == null) goto L12;
            r2.evaluateJavascript(StringsKt.trimIndent("\n                javascript:LarkWebViewJavaScriptBridge.nativeCallBack({\n                  callbackID: 'LarkAPI.ipc.event',\n                  callbackType: 'continued',\n                  data: " + swb.k.b(new LKAPIEvent(r5, -1, r6)) + ",\n                })\n            "), null);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        return new ArrayList();
    }

    public AbsChameleonPlugin() {
        this.webviewHandlerContext = new WebviewHandlerContext(this);
    }

    public final ChameleonConfig getChameleonConfig() {
        return ((ChameleonContextAbility) getHost().getHostAbility(ChameleonContextAbility.class)).getChameleonConfig();
    }

    public final String getSession() {
        return ((ChameleonContextAbility) getHost().getHostAbility(ChameleonContextAbility.class)).getSession();
    }

    public String getUrl() {
        return ((ChameleonContextAbility) getHost().getHostAbility(ChameleonContextAbility.class)).getUrl();
    }

    public final WebviewHandlerContext getWebviewHandlerContext() {
        return this.webviewHandlerContext;
    }

    public static final /* synthetic */ Context access$getContext(AbsChameleonPlugin r0) {
        return r0.getContext();
    }

    public final void callbackOk(tb5.m r4) {
        if (r4 == null) goto L10;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L5
        r0.put(ChameleonOpenTracker.ParamKey.RESULT, Boolean.TRUE);     // Catch: Throwable -> L5
        r4.b(r0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        j.d("CML_TAG_AbsChameleonPlugin", th);
        return;
    }

    public void getBridgeHandlers(Map<String, i<?>> r4) {
        Intrinsics.checkNotNullParameter(r4, "handlersHolder");
        Iterator<AbsChameleonHandler<?>> r0 = getBridgeHandlers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AbsChameleonHandler<?> r1 = r0.next();
        r1.setContext(this.webviewHandlerContext);
        r4.put(r1.getName(), r1);
        goto L4
    }
}
