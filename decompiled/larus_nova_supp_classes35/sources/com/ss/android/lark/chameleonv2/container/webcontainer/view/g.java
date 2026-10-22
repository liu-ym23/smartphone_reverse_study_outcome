package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleonv2.container.webcontainer.n;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import vv4.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends n implements IChameleonHandlerContext {
    public final WebView c;
    public final IChameleonHandlerContext d;

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final String getBizName() {
        return this.d.getBizName();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final Context getCmlContext() {
        return this.d.getCmlContext();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final Fragment getFragment() {
        return this.d.getFragment();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final String getSession() {
        return this.d.getSession();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final IChameleonLoader getWebviewLoader() {
        return this.d.getWebviewLoader();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final ChameleonConfig getChameleonConfig() {
        return IChameleonHandlerContext.DefaultImpls.getChameleonConfig(this);
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final void destroyWebview() {
        IChameleonHandlerContext.DefaultImpls.destroyWebview(this);
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final WebView getWebview() {
        return this.c;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final void reloadWebview() {
        IChameleonHandlerContext.DefaultImpls.reloadWebview(this);
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final <T extends m> T getWebService(Class<T> r1) {
        return (T) IChameleonHandlerContext.DefaultImpls.getWebService(this, r1);
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final <T extends Serializable> void sendEvent(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        this.d.sendEvent(r2, r3);
    }

    public g(WebView r2, xwb.a r3, IChameleonHandlerContext r4) {
        Intrinsics.checkNotNullParameter(r2, "web");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        Intrinsics.checkNotNullParameter(r4, "chameleonHandlerContext");
        super(r2, r3);
        this.c = r2;
        this.d = r4;
    }
}
