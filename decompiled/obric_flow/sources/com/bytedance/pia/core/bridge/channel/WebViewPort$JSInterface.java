package com.bytedance.pia.core.bridge.channel;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.bytedance.pia.core.utils.a;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewPort$JSInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f6958c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f6959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6960b;

    static {
        f6958c = new WeakHashMap();
    }

    public WebViewPort$JSInterface() {
        this.f6959a = new AtomicReference(null);
        this.f6960b = null;
    }

    @JavascriptInterface
    @Keep
    public void postMessage(String r5) {
        if ("__port_init__".equals(r5) == false) goto L5;
    L6:
        AtomicReference r10 = this.f6959a;
        a r11 = new a();
    L8:
        if (r10.compareAndSet(null, r11) == true) goto L9;
        if (r10.get() == null) goto L8;
        this.f6960b = (a) r10.getAndSet(null);
    L13:
        a r12 = this.f6960b;
        if (r12 == null) goto L20;
        r12.c(r5);
        return;
    L20:
        return;
    L9:
        this.f6960b = (a) r10.get();
        goto L13
    L5:
        if ("__port_init_next__".equals(r5) == false) goto L13;
        goto L6
    }
}
