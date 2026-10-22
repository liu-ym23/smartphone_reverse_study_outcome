package com.bytedance.ai.applet.render.core.web;

import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l2.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/ai/applet/render/core/web/WebViewAIBridgePort$JSInterface", "", "", "message", "", "postMessage", "(Ljava/lang/String;)V", "applet-render-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebViewAIBridgePort$JSInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakHashMap f1797c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f1798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f1799b;

    static {
        f1797c = new WeakHashMap();
    }

    public WebViewAIBridgePort$JSInterface() {
        this.f1798a = new AtomicReference(null);
    }

    @JavascriptInterface
    @Keep
    public final void postMessage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        a r10 = this.f1799b;
        if (r10 == null) goto L5;
        r10.c(r5);
    L5:
        String r11 = androidx.room.jarjarred.org.antlr.runtime.a.r("[WebViewAIBridgePort] receive message:", r5, " from JavascriptInterface", "ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        a1.a.f43a.d("ai_bridge", r11);
    }
}
