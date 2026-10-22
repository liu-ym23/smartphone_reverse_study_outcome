package com.bytedance.ies.web.jsbridge2;

import com.bytedance.ies.bullet.kit.web.SSWebView;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final m d = null;
    public static final m e = null;
    public static final m f = null;
    public static final m g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f6299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f6300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6301c;

    static {
        d = new m(0);
        e = new m(1);
        f = new m(2);
        new CopyOnWriteArrayList();
        g = new m(3);
    }

    public o(d r10) {
        ArrayList r5 = new ArrayList();
        this.f6300b = r5;
        this.f6301c = false;
        t r11 = new t();
        r11.a("enable_permission_check", Boolean.valueOf(r10.f));
        m r12 = e;
        r12.a();
        r11.a("permission_config_repository", false);
        r11.b("label_create_jsb_instance", r10.f6278k);
        if (r10.f == false) goto L6;
        r12.a();
    L6:
        if (r10.f6272a == null) goto L8;
        this.f6299a = new u();
    L9:
        u r13 = this.f6299a;
        r13.getClass();
        SSWebView r14 = r10.f6272a;
        if (r14 == null) goto L18;
        r14.getContext();
        r13.f6311a = r10.g;
        r13.f = new c(r10, r13);
        r13.f6313c = r10.f6275h;
        r13.f6314h = r10.f6278k;
        SSWebView r15 = r10.f6272a;
        if (r15 == null) goto L14;
        a r16 = new a(r15);
    L15:
        r13.e = r16;
        r13.f6316j = r15;
        String r17 = r10.f6274c;
        r13.f6315i = r17;
        r15.addJavascriptInterface(r13, r17);
        r5.add(null);
        return;
    L14:
        r16 = r10.f6273b;
        goto L15
    L18:
        throw new IllegalStateException("WebView cannot be null!");
    L8:
        this.f6299a = null;
        goto L9
    }
}
