package com.bytedance.ai.lynx;

import android.app.Application;
import android.util.LruCache;
import com.bytedance.ai.resource.e0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.bytedance.ai.applet.render.core.lynx.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2178c;

    public d(Application r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f2177b = r10;
        this.f2178c = r11;
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.a
    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        String r10 = "AppletDynamicComponentFetcher load builtin asset " + r5;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L6;
        r11.i("AppletResourceLoader", r10);
        return;
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.a
    public final void c(String r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "error");
        String r11 = "AppletDynamicComponentFetcher builtin asset failed. " + r10.getMessage();
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L6;
        r12.e("AppletResourceLoader", r11);
        return;
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.a
    public final void d(String r5, zm.c r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "handler");
        String r11 = this.f2178c;
        if (r11 != null) goto L5;
    L8:
        String r12 = r5;
    L9:
        String r13 = com.lynx.tasm.utils.b.j("AppletDynamicComponentFetcher start to load ", r5, ", realUrl: ", r12);
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L12;
        r14.i("AppletResourceLoader", r13);
    L12:
        LruCache r15 = e0.f2711a;
        com.bytedance.ai.applet.render.core.lynx.k r16 = new com.bytedance.ai.applet.render.core.lynx.k(r10, 2);
        com.bytedance.ai.applet.render.core.lynx.k r17 = new com.bytedance.ai.applet.render.core.lynx.k(r10, 3);
        e0.k(this.f2177b, r12, r16, r17, false);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r12 = e0.m(r5, r11);
        goto L9
    }
}
