package com.ss.android.lark.chameleonv2.container.webcontainer;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import tb5.o;
import tb5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ o a;

    public final BridgeAuthType authType() {
        return n.I(this.a.authType());
    }

    public final boolean shouldRunInUIThread() {
        return !(this.a instanceof q);
    }

    public l(o r1) {
        this.a = r1;
    }

    public final void a(Object r1, xwb.d r2, String r3, OfficeWebView r4) {
        tb5.f.d((String) r1, this.a, new k(r2));
    }
}
