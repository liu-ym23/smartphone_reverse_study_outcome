package com.bytedance.pia.core.plugins;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.tracing.b;
import com.bytedance.pia.core.utils.m;
import com.google.common.reflect.w;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.p;
import dh.f;
import i4.a;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import lh.d;
import nh.c;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
public class HtmlPlugin extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f7044c;
    public volatile d d;
    public a e;
    public boolean f;

    public HtmlPlugin(nh.d r5) {
        super(r5);
        this.f7044c = new CountDownLatch(1);
        this.e = null;
        this.f = false;
    }

    @Override // nh.c
    public final f a(j r10) {
        String r5 = com.bytedance.pia.core.utils.j.k(((WebResourceRequest) r10.f23302a).getUrl(), null);
        if (r5 != null) goto L5;
    L51:
        return null;
    L5:
        if (r5.equals(this.f20236b.f20237h) == false) goto L51;
        if (((WebResourceRequest) r10.f23302a).isForMainFrame() == false) goto L51;
        if (this.d == null) goto L11;
        this.f20236b.s.f7115n = 0;
    L53:
        Intrinsics.checkNotNullParameter("[HTML] Start intercepting main document.", "message");     // Catch: Throwable -> L52
        com.bytedance.pia.core.utils.j.y("[HTML] Start intercepting main document.", null);     // Catch: Throwable -> L52
        w r11 = this.f20236b.f20247r;     // Catch: Throwable -> L52
        EventName r12 = EventName.f7096j;     // Catch: Throwable -> L52
        r11.getClass();     // Catch: Throwable -> L52
        com.bytedance.pia.core.tracing.d r13 = new com.bytedance.pia.core.tracing.d(r11, r12, System.currentTimeMillis());     // Catch: Throwable -> L52
        r13.d.put("url", ((WebResourceRequest) r10.f23302a).getUrl());     // Catch: Throwable -> L52
        r13.a();     // Catch: Throwable -> L52
        Lazy r14 = Settings.B;     // Catch: Throwable -> L52
        this.f7044c.await(p.a().g(), TimeUnit.SECONDS);     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter("[HTML] Finish waiting response.", "message");     // Catch: Throwable -> L52
        com.bytedance.pia.core.utils.j.y("[HTML] Finish waiting response.", null);     // Catch: Throwable -> L52
        a r15 = this.e;     // Catch: Throwable -> L52
        if (r15 == null) goto L28;
        Boolean r16 = ((jh.a) r15.d).d();     // Catch: Throwable -> L52
        if (r16 == null) goto L28;
        if (r16.booleanValue() == true) goto L28;
        if (this.f == true) goto L28;
        Uri r17 = this.f20236b.g;     // Catch: Throwable -> L52
        a r18 = this.e;     // Catch: Throwable -> L52
        Keva r19 = jh.c.f18344a;     // Catch: Throwable -> L52
        Intrinsics.checkNotNullParameter(r17, LynxResourceModule.URI_KEY);     // Catch: Throwable -> L52
        if (p.a().m() == false) goto L28;
        if (jh.c.e.get() == false) goto L28;
        jh.c.e(r17, r18, true);     // Catch: Throwable -> L52
    L28:
        if (this.d == null) goto L50;
        com.bytedance.pia.core.utils.j.A("[HTML] Intercept: " + ((WebResourceRequest) r10.f23302a).getUrl().toString());
        b r20 = this.f20236b.s;
        Map r21 = this.d.e;
        r20.getClass();
        if (r21 != null) goto L32;
    L48:
        this.f20236b.s.b("NTF");
        w r22 = this.f20236b.f20247r;
        EventName r23 = EventName.f7097k;
        r22.getClass();
        com.bytedance.pia.core.tracing.d r24 = new com.bytedance.pia.core.tracing.d(r22, r23, System.currentTimeMillis());
        r24.d.put("url", ((WebResourceRequest) r10.f23302a).getUrl());
        r24.a();
        Intrinsics.checkNotNullParameter("[HTML] Finish intercepting main document.", "message");
        com.bytedance.pia.core.utils.j.y("[HTML] Finish intercepting main document.", null);
        return this.d;
    L32:
        if (r21.containsKey("x-pia-ssr-fallback") != true) goto L48;
        if (Intrinsics.areEqual(r21.get("x-pia-ssr-fallback"), "query") == false) goto L37;
        r20.f7114m = 11;
        goto L48
    L37:
        if (Intrinsics.areEqual(r21.get("x-pia-ssr-fallback"), "custom") == false) goto L40;
        r20.f7114m = 15;
        goto L48
    L40:
        if (Intrinsics.areEqual(r21.get("x-pia-ssr-fallback"), "header") == false) goto L43;
        r20.f7114m = 12;
        goto L48
    L43:
        if (Intrinsics.areEqual(r21.get("x-pia-ssr-fallback"), "error") == false) goto L46;
        r20.f7114m = 13;
        goto L48
    L46:
        if (Intrinsics.areEqual(r21.get("x-pia-ssr-fallback"), "middleware") == false) goto L48;
        r20.f7114m = 14;
        goto L48
    L50:
        this.f20236b.s.f7111j = 6;
        goto L51
    L11:
        this.f20236b.s.f7115n = 1;
        goto L53
    }

    @Override // nh.c
    public final String c() {
        return "html";
    }

    @Override // nh.c
    public final void f() {
        m.b(new com.obric.oui.lisitem.a(this, 17));
    }

    public final void h(String r10, Throwable r11) {
        this.f7044c.countDown();
        nh.d r5 = this.f20236b;
        r5.f20246q.a("request_html.end", System.currentTimeMillis());
        w r12 = r5.f20247r;
        EventName r13 = EventName.f7095i;
        r12.getClass();
        new com.bytedance.pia.core.tracing.d(r12, r13, System.currentTimeMillis()).a();
        if (r11 == null) goto L5;
        Intrinsics.checkNotNullParameter("[Manifest] Request Manifest Error:", "message");
        com.bytedance.pia.core.utils.j.x("[Manifest] Request Manifest Error:", r11);
    L5:
        if (r10 == null) goto L8;
        r5.g("event-on-html-ready", new Object[]{r10});
        return;
    L8:
        r5.g("event-on-html-error", new Object[]{r11});
    }

    @Override // nh.c, fh.c
    public final void release() {
        this.f7044c.countDown();
    }
}
