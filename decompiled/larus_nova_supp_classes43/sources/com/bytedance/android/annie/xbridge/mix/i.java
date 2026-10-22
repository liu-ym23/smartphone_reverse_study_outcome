package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.web.jsbridge2.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements a0 {
    public final /* synthetic */ BaseA2BBridgeMethod.a a;

    public i(BaseA2BBridgeMethod.b r1) {
        this.a = r1;
    }

    public final void terminate() {
        this.a.onFailed(new Jsb2TerminateException(0));
    }
}
