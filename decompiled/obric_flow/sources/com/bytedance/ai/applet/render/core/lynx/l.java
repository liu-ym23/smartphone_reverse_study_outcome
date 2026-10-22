package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q7.a f1778b;

    public l(Context r5, q7.a r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "loader");
        super(r5);
        this.f1778b = r10;
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.a
    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        String r10 = "loadDynamicComponent: load builtin asset " + r5;
        Intrinsics.checkNotNullParameter("RenderDynamicComponentFetcher", "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        a1.a.f43a.i("RenderDynamicComponentFetcher", r10);
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.a
    public final void c(String r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "error");
        String r11 = "loadDynamicComponent: builtin asset failed. " + r10.getMessage();
        Intrinsics.checkNotNullParameter("RenderDynamicComponentFetcher", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        a1.a.f43a.i("RenderDynamicComponentFetcher", r11);
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.a
    public final void d(String r5, zm.c r10) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r10, "handler");
        String r11 = androidx.room.jarjarred.org.antlr.runtime.a.w(new StringBuilder("loadDynamicComponent: start to load "), r5, "RenderDynamicComponentFetcher", "tag", "msg");
        a1.a.f43a.i("RenderDynamicComponentFetcher", r11);
        k r12 = new k(r10, 0);
        k r13 = new k(r10, 1);
        this.f1778b.e(r5, r12, r13);
    }
}
