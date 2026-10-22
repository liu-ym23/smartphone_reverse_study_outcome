package com.bytedance.ai.model;

import android.webkit.WebView;
import com.lynx.tasm.ui.image.f0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2241c;

    public /* synthetic */ f(r r5, String r10) {
        this.f2239a = 1;
        this.f2241c = r5;
        this.f2240b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r5 = this.f2240b;
        Object r10 = this.f2241c;
        switch(this.f2239a) {
            case 0: goto L17;
            default: goto L24;
        };
    L17:
        int r11 = AppletRuntime.f2196x;
        String r12 = (String) r10;
        if (p.g(r5) == null) goto L20;
        Intrinsics.checkNotNullParameter(r12, "message");
    L20:
        Intrinsics.checkNotNullParameter(r5, "pageId");
        com.bytedance.ai.model.widgets.a r13 = (com.bytedance.ai.model.widgets.a) p.f2293b.get(r5);
        if (r13 == null) goto L29;
        r13.a(r12);
        return;
    L29:
        return;
    L24:
        WebView r14 = ((u) ((r) r10)).f2301a.e;     // Catch: Exception -> L12
        if (r14 != null) goto L9;
        r14 = null;
    L9:
        if (r14 == null) goto L26;
        r14.evaluateJavascript("appletOnMessage(" + JSONObject.quote(r5) + ')', new q(0));     // Catch: Exception -> L12
        return;
    L26:
        return;
    L12:
        e = move-exception;
        String r15 = f0.d(e, new StringBuilder("JavaScript execution error: "), "applet");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L27;
        r16.e("applet", r15);
        return;
    }

    public /* synthetic */ f(String r5, String r10) {
        this.f2239a = 0;
        this.f2240b = r5;
        this.f2241c = r10;
    }
}
