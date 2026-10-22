package com.bytedance.ies.bullet.web.pia;

import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements dh.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceResponse f6232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoadFrom f6233b;

    public h(WebResourceResponse r5, LoadFrom r10) {
        this.f6232a = r5;
        this.f6233b = r10;
    }

    @Override // dh.f
    public final LoadFrom a() {
        return this.f6233b;
    }

    @Override // dh.f
    public final Map b() {
        return this.f6232a.getResponseHeaders();
    }

    @Override // dh.f
    public final String c() {
        String r5 = this.f6232a.getReasonPhrase();
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    }

    @Override // dh.f
    public final String d() {
        return this.f6232a.getEncoding();
    }

    @Override // dh.f
    public final String e() {
        return this.f6232a.getMimeType();
    }

    @Override // dh.f
    public final InputStream getData() {
        return this.f6232a.getData();
    }

    @Override // dh.f
    public final int getStatusCode() {
        return this.f6232a.getStatusCode();
    }
}
