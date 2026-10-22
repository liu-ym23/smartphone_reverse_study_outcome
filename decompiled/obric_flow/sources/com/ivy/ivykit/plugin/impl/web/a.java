package com.ivy.ivykit.plugin.impl.web;

import android.net.Uri;
import android.webkit.WebView;
import com.bytedance.ies.bullet.core.m;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f9534a;

    public a(h r5) {
        this.f9534a = r5;
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void b() {
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", "onOpen");
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void f() {
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", "onBulletViewCreate");
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void n() {
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", "onBulletViewRelease");
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void o(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", "onKitViewCreate");
        h r11 = this.f9534a;
        WebView r12 = h.b(r11, r10);
        if (r12 == null) goto L8;
        ol.c r13 = r11.f9544c;
        if (r13 == null) goto L9;
        r13.d(r12);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void p(Uri r5, com.bytedance.ies.bullet.service.base.h r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        h r11 = this.f9534a;
        WebView r12 = h.b(r11, r10);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r11.f9544c == null) goto L9;
        Intrinsics.checkNotNullParameter(r12, "view");
        return;
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void q(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", "onFallback");
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void r(Uri r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r10, "e");
        ConcurrentHashMap r11 = tl.b.f22138a;
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", "onLoadFail: " + r10.getMessage());
        if (this.f9534a.f9544c == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "e");
        return;
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void s(Uri r5, hb.a r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", "onKitViewDestroy");
        h.b(this.f9534a, r10);
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void u(Uri r5, com.bytedance.ies.bullet.core.container.e r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        ol.c r11 = this.f9534a.f9544c;
    }

    @Override // com.bytedance.ies.bullet.core.m, com.bytedance.ies.bullet.core.n
    public final void v(Uri r5, com.bytedance.ies.bullet.service.base.h r10, rd.e r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "schemaModelUnion");
        tl.b.b("com.ivy.ivykit.plugin.impl.web.PluginWebView", "onLoadModelSuccess");
    }
}
