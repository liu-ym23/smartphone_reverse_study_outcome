package com.bytedance.ies.bullet.web.pia;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements WebResourceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dh.e f6240a;

    public l(dh.e r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        this.f6240a = r5;
    }

    @Override // android.webkit.WebResourceRequest
    public final String getMethod() {
        return "GET";
    }

    @Override // android.webkit.WebResourceRequest
    public final Map getRequestHeaders() {
        Map r5 = this.f6240a.getRequestHeaders();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new LinkedHashMap();
    }

    @Override // android.webkit.WebResourceRequest
    public final Uri getUrl() {
        return this.f6240a.getUrl();
    }

    @Override // android.webkit.WebResourceRequest
    public final boolean hasGesture() {
        return false;
    }

    @Override // android.webkit.WebResourceRequest
    public final boolean isForMainFrame() {
        return this.f6240a.isForMainFrame();
    }

    @Override // android.webkit.WebResourceRequest
    public final boolean isRedirect() {
        return false;
    }
}
