package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.webkit.ValueCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements ValueCallback<String> {
    public final /* synthetic */ tb5.m a;

    public g(tb5.m r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String r2) {
        tb5.m r0 = this.a;
        r0.onCallBack(r2);
    }
}
