package com.bytedance.ai.applet.render.core.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends fo.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q7.a f1782a;

    public n(q7.a r5) {
        Intrinsics.checkNotNullParameter(r5, "loader");
        this.f1782a = r5;
    }

    @Override // fo.h
    public final void a(com.lynx.tasm.behavior.ui.utils.n r10, fo.g r11) {
        Intrinsics.checkNotNullParameter(r10, "request");
        Intrinsics.checkNotNullParameter(r11, "callback");
        StringBuilder r5 = new StringBuilder("request: start to load ");
        String r12 = (String) r10.f10761a;
        String r13 = androidx.room.jarjarred.org.antlr.runtime.a.w(r5, r12, "RenderExternalJSProvider", "tag", "msg");
        a1.a.f43a.i("RenderExternalJSProvider", r13);
        m r14 = new m(r10, r11, 0);
        m r15 = new m(r10, r11, 1);
        this.f1782a.e(r12, r14, r15);
    }
}
