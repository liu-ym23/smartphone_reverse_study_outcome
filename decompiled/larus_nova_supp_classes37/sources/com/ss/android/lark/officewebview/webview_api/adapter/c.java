package com.ss.android.lark.officewebview.webview_api.adapter;

import android.webkit.ValueCallback;
import com.bytedance.ee.lark.component.AbstractNativeComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c<T> implements ValueCallback {
    public final /* synthetic */ ValueCallback<String> a;

    public c(AbstractNativeComponent.a.a r1) {
        this.a = r1;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r2) {
        ValueCallback<String> r0 = this.a;
        r0.onReceiveValue((String) r2);
    }
}
