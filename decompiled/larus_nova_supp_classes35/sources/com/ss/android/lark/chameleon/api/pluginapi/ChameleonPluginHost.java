package com.ss.android.lark.chameleon.api.pluginapi;

import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.pluginsystem.WebFragment;
import com.ss.android.lark.chameleon.pluginsystem.WebPluginHost;
import com.ss.android.lark.chameleon.pluginsystem.WebService;
import com.ss.android.lark.chameleon.pluginsystem.WebServiceManager;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J+\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\n\b\u0000\u0010\u001d*\u0004\u0018\u00010\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010 H\u0016¢\u0006\u0002\u0010!R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "Lcom/ss/android/lark/chameleon/pluginsystem/WebPluginHost;", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonContextAbility;", "web", "Lcom/ss/android/lark/chameleon/pluginsystem/Web;", "url", BuildConfig.FLAVOR, "config", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "sessionId", "serviceManager", "Lcom/ss/android/lark/chameleon/pluginsystem/WebServiceManager;", "(Lcom/ss/android/lark/chameleon/pluginsystem/Web;Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/ChameleonConfig;Ljava/lang/String;Lcom/ss/android/lark/chameleon/pluginsystem/WebServiceManager;)V", "fragment", "Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "getFragment", "()Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "setFragment", "(Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;)V", "loader", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "getLoader", "()Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "setLoader", "(Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;)V", "getChameleonConfig", "getSession", "getUrl", "getWebService", "P", "Lcom/ss/android/lark/chameleon/pluginsystem/WebService;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/ss/android/lark/chameleon/pluginsystem/WebService;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonPluginHost extends WebPluginHost implements ChameleonContextAbility {
    private final ChameleonConfig config;
    public WebFragment fragment;
    public IChameleonLoader loader;
    private final WebServiceManager serviceManager;
    private final String sessionId;
    private final String url;

    public final WebFragment getFragment() {
        WebFragment r0 = this.fragment;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        return null;
    }

    public final IChameleonLoader getLoader() {
        IChameleonLoader r0 = this.loader;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("loader");
        return null;
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.ChameleonContextAbility
    public ChameleonConfig getChameleonConfig() {
        return this.config;
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.ChameleonContextAbility
    public String getSession() {
        return this.sessionId;
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.ChameleonContextAbility
    public String getUrl() {
        return this.url;
    }

    @Override // com.ss.android.lark.chameleon.api.pluginapi.ChameleonContextAbility
    public <P extends WebService> P getWebService(Class<P> r2) {
        return (P) this.serviceManager.getWebService(r2);
    }

    public final void setFragment(WebFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fragment = r2;
    }

    public final void setLoader(IChameleonLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loader = r2;
    }

    public ChameleonPluginHost(Web r2, String r3, ChameleonConfig r4, String r5, WebServiceManager r6) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "serviceManager");
        super(r2);
        this.url = r3;
        this.config = r4;
        this.sessionId = r5;
        this.serviceManager = r6;
        registerHostAbility(this);
    }
}
