package com.bytedance.pia.core.utils;

import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements dh.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceResponse f7153a;

    public k(WebResourceResponse r5) {
        this.f7153a = r5;
    }

    @Override // dh.f
    public final LoadFrom a() {
        return LoadFrom.f6957c;
    }

    @Override // dh.f
    public final Map b() {
        return this.f7153a.getResponseHeaders();
    }

    @Override // dh.f
    public final String c() {
        String r5 = this.f7153a.getReasonPhrase();
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    }

    @Override // dh.f
    public final String d() {
        return this.f7153a.getEncoding();
    }

    @Override // dh.f
    public final String e() {
        return this.f7153a.getMimeType();
    }

    @Override // dh.f
    public final InputStream getData() {
        return this.f7153a.getData();
    }

    @Override // dh.f
    public final int getStatusCode() {
        return this.f7153a.getStatusCode();
    }
}
