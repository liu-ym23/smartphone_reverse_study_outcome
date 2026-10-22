package com.bytedance.android.annie.card.web;

import android.webkit.JavascriptInterface;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/card/web/InjectDataHolder;", "", "", "getGlobalProps", "getInitialProps", "getInjectInitData", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class InjectDataHolder {
    public volatile String a;
    public final String b;
    public final String c;

    @JavascriptInterface
    public final String getGlobalProps() {
        return this.a;
    }

    @JavascriptInterface
    public final String getInitialProps() {
        return this.b;
    }

    @JavascriptInterface
    public final String getInjectInitData() {
        return this.c;
    }

    public InjectDataHolder(String r10, String r11) {
        Intrinsics.checkNotNullParameter("{}", "globalProps");
        Intrinsics.checkNotNullParameter(r10, BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);
        Intrinsics.checkNotNullParameter(r11, "injectInitData");
        this.a = "{}";
        this.b = r10;
        this.c = r11;
    }
}
