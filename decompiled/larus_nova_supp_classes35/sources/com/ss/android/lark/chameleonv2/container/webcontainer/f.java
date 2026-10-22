package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.content.Context;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officewebview.base.OfficeWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements wwb.c {
    public final /* synthetic */ OfficeWebView a;

    public final oxb.n getServiceManager() {
        return new oxb.n();
    }

    public final Context getWebViewContext() {
        return this.a.getContext();
    }

    public final OfficeWebView getWebView() {
        return this.a;
    }

    public f(ChameleonWebView r1) {
        this.a = r1;
    }
}
