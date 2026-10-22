package com.bytedance.android.live.browser;

import android.content.Intent;
import com.bytedance.android.livesdkapi.jsb.IExternalActivityResultListener;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x extends y6.b<com.bytedance.ies.web.jsbridge2.f<?, ?>> {
    public final /* synthetic */ Map.Entry b;

    public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
        return ((com.bytedance.ies.web.jsbridge2.f.b) this.b.getValue()).a();
    }

    public x(Map.Entry r1) {
        this.b = r1;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        com.bytedance.ies.web.jsbridge2.f r0 = ((y6.b) this).a;
        if ((r0 instanceof IExternalActivityResultListener) == true) goto L5;
        r0 = null;
    L5:
        IExternalActivityResultListener r1 = (IExternalActivityResultListener) r0;
        if (r1 == null) goto L9;
        r1.onActivityResult(r3, r4, r5);
        return;
    }
}
