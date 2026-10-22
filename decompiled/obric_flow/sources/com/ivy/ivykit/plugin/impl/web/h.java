package com.ivy.ivykit.plugin.impl.web;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends ql.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BulletContainerView f9542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ol.d f9543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ol.c f9544c;
    public final ol.e d;
    public final ol.g e;
    public final ol.f f;
    public WebView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.ivy.ivykit.plugin.impl.jsb.a f9545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final rb.b f9546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f9547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f9548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.ies.bullet.kit.web.impl.b f9549l;

    public h(String r5, j r10, Context r11) {
        Intrinsics.checkNotNullParameter(r5, "schema");
        Intrinsics.checkNotNullParameter(r10, "webViewClient");
        Intrinsics.checkNotNullParameter(r11, "context");
        int r12 = 6;
        BulletContainerView r13 = new BulletContainerView(r11, null, r12, 0);
        r13.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r13.f(r10.f);
        this.f9542a = r13;
        this.f9545h = new com.ivy.ivykit.plugin.impl.jsb.a();
        rb.b r14 = new rb.b();
        Intrinsics.checkNotNullParameter(h.class, "clazz");
        r14.b(h.class, new rb.a(this, 0));
        this.f9546i = r14;
        this.f9547j = new b(this);
        this.f9548k = new d(this, r10);
        this.f9549l = new com.bytedance.ies.bullet.kit.web.impl.b(this, 1);
        this.f9543b = r10.f21783a;
        this.f9544c = r10.f21784b;
        this.d = r10.f21785c;
        this.e = r10.d;
        this.f = r10.e;
    }

    public static final WebView b(h r5, com.bytedance.ies.bullet.service.base.h r10) {
        SSWebView r11 = null;
        if (r10 == null) goto L12;
        r5.getClass();
        View r12 = r10.a();
        if (r12 == null) goto L12;
        if ((r12 instanceof WebView) == true) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L12;
        WebView r13 = (WebView) r12;
    L14:
        if (r5.g != null) goto L20;
        r5.g = r13;
        if ((r13 instanceof SSWebView) == false) goto L18;
        r11 = (SSWebView) r13;
    L18:
        if (r11 == null) goto L20;
        r11.setWebViewEventDelegate(new e(r5));
        r11.setWebViewScrollDelegate(new f(r5));
        r11.setWebScrollListener(new b(r5));
        r11.setWebOverScrollByListener(new g(r5));
    L20:
        return r13;
    L12:
        r13 = null;
        goto L14
    }

    @Override // ql.b
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r10, "url");
        rb.b r5 = new rb.b();
        rb.b r11 = this.f9546i;
        Intrinsics.checkNotNullParameter(r11, "other");
        r5.f21717a.putAll(r11.f21717a);
        ol.f r12 = this.f;
        if (r12 == null) goto L5;
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(ol.f.class, "clazz");
        r5.b(ol.f.class, new rb.a(r12, 0));
    L5:
        boolean r13 = StringsKt.P(r10, "http");
        BulletContainerView r14 = this.f9542a;
        if (r13 == false) goto L13;
        String r15 = URLEncoder.encode(r10);
        if (Intrinsics.areEqual(IIvyAIPackageResourceService.Companion.getBid(), r14.getBid()) == true) goto L10;
        String r16 = "&need_sec_link=1&sec_link_scene=im";
    L11:
        Uri r17 = Uri.parse("aweme://webview/?url=" + r15 + "&use_xbridge3=true&loader_name=forest" + r16);
    L12:
        Uri r18 = r17;
        a r19 = new a(this);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.URI_KEY);
        r14.j(r18, null, null, r5, r19);
        return;
    L10:
        r16 = "";
        goto L11
    L13:
        r17 = Uri.parse(r10);
        goto L12
    }
}
