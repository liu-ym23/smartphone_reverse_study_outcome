package com.bytedance.ai.lynx;

import android.util.LruCache;
import com.bytedance.ai.resource.e0;
import com.lynx.tasm.behavior.ui.utils.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends fo.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2180b;

    public e(String r5, String r10) {
        this.f2179a = r5;
        this.f2180b = r10;
    }

    @Override // fo.h
    public final void a(n r5, fo.g r10) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r10, "callback");
        String r11 = (String) r5.f10761a;
        String r12 = this.f2180b;
        if (r12 != null) goto L5;
    L8:
        String r13 = r11;
    L9:
        String r14 = f4.b.b(new StringBuilder("AppletDynamicComponentFetcher start to load "), r11, ", realUrl: ", r13);
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L12;
        r15.i("AppletResourceLoader", r14);
    L12:
        LruCache r16 = e0.f2711a;
        Intrinsics.checkNotNull(r13);
        com.bytedance.ai.applet.render.core.lynx.m r17 = new com.bytedance.ai.applet.render.core.lynx.m(r5, r10, 2);
        com.bytedance.ai.applet.render.core.lynx.m r18 = new com.bytedance.ai.applet.render.core.lynx.m(r5, r10, 3);
        e0.k(this.f2179a, r13, r17, r18, false);
        return;
    L5:
        if (r12.length() == 0) goto L8;
        LruCache r19 = e0.f2711a;
        r13 = e0.m(r11, r12);
        goto L9
    }
}
