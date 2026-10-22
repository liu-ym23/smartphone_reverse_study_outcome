package com.bytedance.android.annie.pia;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements i47.d {
    public final /* synthetic */ WebResourceRequest a;

    public final /* synthetic */ Map getOptions() {
        return null;
    }

    public final Map<String, String> getRequestHeaders() {
        return this.a.getRequestHeaders();
    }

    public final Uri getUrl() {
        return this.a.getUrl();
    }

    public final boolean isForMainFrame() {
        return this.a.isForMainFrame();
    }

    public c(WebResourceRequest r1) {
        this.a = r1;
    }
}
