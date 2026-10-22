package com.ss.android.lark.chameleon.api.pluginapi;

import android.content.Context;
import android.webkit.WebView;
import com.ss.android.lark.chameleon.api.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.pluginsystem.WebFragment;
import com.ss.android.lark.chameleon.pluginsystem.plugin.SimpleWebV2;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J'\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u0002H\u001cH\u0016¢\u0006\u0002\u0010 R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonWeb;", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/SimpleWebV2;", "Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", "web", "Landroid/webkit/WebView;", "bridge", "Lcom/ss/android/lark/chameleon/bridge/Bridge;", "chameleonHandlerContext", "(Landroid/webkit/WebView;Lcom/ss/android/lark/chameleon/bridge/Bridge;Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;)V", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "getChameleonHandlerContext", "()Lcom/ss/android/lark/chameleon/api/IChameleonHandlerContext;", "fragment", "Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "getFragment", "()Lcom/ss/android/lark/chameleon/pluginsystem/WebFragment;", "webviewLoader", "Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/api/pluginapi/IChameleonLoader;", "getBizName", BuildConfig.FLAVOR, "getSession", "sendEvent", BuildConfig.FLAVOR, "T", "Ljava/io/Serializable;", IPortraitService.TYPE, Keys.API_RETURN_KEY_DATA, "(Ljava/lang/String;Ljava/io/Serializable;)V", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class ChameleonWeb extends SimpleWebV2 implements IChameleonHandlerContext {
    private final IChameleonHandlerContext chameleonHandlerContext;

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public Context getAppContext() {
        return this.chameleonHandlerContext.getAppContext();
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public String getBizName() {
        return this.chameleonHandlerContext.getBizName();
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public WebFragment getFragment() {
        return this.chameleonHandlerContext.getFragment();
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public String getSession() {
        return this.chameleonHandlerContext.getSession();
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public IChameleonLoader getWebviewLoader() {
        return this.chameleonHandlerContext.getWebviewLoader();
    }

    public final IChameleonHandlerContext getChameleonHandlerContext() {
        return this.chameleonHandlerContext;
    }

    @Override // com.ss.android.lark.chameleon.api.IChameleonHandlerContext
    public <T extends Serializable> void sendEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        this.chameleonHandlerContext.sendEvent(r2, r3);
    }

    public ChameleonWeb(WebView r2, Bridge r3, IChameleonHandlerContext r4) {
        Intrinsics.checkNotNullParameter(r2, "web");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        Intrinsics.checkNotNullParameter(r4, "chameleonHandlerContext");
        super(r2, r3);
        this.chameleonHandlerContext = r4;
    }
}
