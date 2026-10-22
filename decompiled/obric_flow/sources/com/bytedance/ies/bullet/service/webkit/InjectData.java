package com.bytedance.ies.bullet.service.webkit;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/webkit/InjectData;", "", "", "getGlobalProps", "()Ljava/lang/String;", "getInitialProps", "getInjectInitData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class InjectData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f6150a;

    @JavascriptInterface
    @Keep
    public final String getGlobalProps() {
        String r5 = this.f6150a;
        if (r5 != null) goto L6;
        return "{}";
    L6:
        return r5;
    }

    @JavascriptInterface
    @Keep
    public final String getInitialProps() {
        return "{}";
    }

    @JavascriptInterface
    @Keep
    public final String getInjectInitData() {
        return "{}";
    }
}
