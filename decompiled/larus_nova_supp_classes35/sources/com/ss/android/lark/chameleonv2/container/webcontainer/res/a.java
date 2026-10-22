package com.ss.android.lark.chameleonv2.container.webcontainer.res;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.ss.android.lark.chameleon.container.webcontainer.res.WebResourceInterceptorImpl;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.text.StringsKt;
import y0b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements b {
    public final CopyOnWriteArrayList<b> a;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.res.a$a, reason: collision with other inner class name */
    public static final class C0021a {
    }

    static {
    }

    public a() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // y0b.b
    public final WebResourceResponse shouldInterceptRequest(Uri r6, String r7, Map<String, String> r8) {
        j.a(WebResourceInterceptorImpl.TAG, "shouldInterceptRequest0 url=" + r6 + ", requestMethod=" + r7 + ", headers=" + r8 + '}');
        if (StringsKt.equals("options", r7, true) == false) goto L15;
        return null;
    L15:
        Iterator<b> r0 = this.a.iterator();     // Catch: Throwable -> L12
    L7:
        if (r0.hasNext() == false) goto L14;
        b r3 = r0.next();     // Catch: Throwable -> L12
        WebResourceResponse r4 = r3.shouldInterceptRequest(r6, r7, r8);     // Catch: Throwable -> L12
        if (r4 == null) goto L7;
        j.a(WebResourceInterceptorImpl.TAG, "interceptor by " + r3);     // Catch: Throwable -> L12
        return r4;
    L14:
        return null;
    L12:
        th = move-exception;
        j.d(WebResourceInterceptorImpl.TAG, th);
        goto L14
    }
}
