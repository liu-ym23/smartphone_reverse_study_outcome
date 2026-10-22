package com.bytedance.ai.applet.render.core.lynx;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zm.c f1777b;

    public /* synthetic */ k(zm.c r5, int r10) {
        this.f1776a = r10;
        this.f1777b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        switch(this.f1776a) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L9;
            default: goto L4;
        };
    L4:
        Throwable r10 = (Throwable) r5;
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        String r11 = "getDynamicComponent failed. " + r10.getMessage();
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L7;
        r12.e("AppletResourceLoader", r11);
    L7:
        this.f1777b.m(null, r10);
        return Unit.INSTANCE;
    L9:
        com.ivy.ivykit.api.plugin.b r13 = (com.ivy.ivykit.api.plugin.b) r5;
        Intrinsics.checkNotNullParameter(r13, "response");
        com.ivy.ivykit.api.plugin.a r14 = r13.e;
        zm.c r15 = this.f1777b;
        if (r14 == null) goto L18;
        byte[] r16 = r14.f9478a;
        if (r16.length == 0) goto L18;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L17;
        r17.i("AppletResourceLoader", "getDynamicComponent success");
    L17:
        r15.m(r16, null);
    L23:
        return Unit.INSTANCE;
    L18:
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L21;
        r18.e("AppletResourceLoader", "getDynamicComponent failed. data is empty");
    L21:
        r15.m(null, new Throwable("DynamicComponent data is empty"));
        goto L23
    L24:
        Exception r19 = (Exception) r5;
        Intrinsics.checkNotNullParameter(r19, ST.IMPLICIT_ARG_NAME);
        String r20 = "loadDynamicComponent: failed. " + r19.getMessage();
        Intrinsics.checkNotNullParameter("RenderDynamicComponentFetcher", "tag");
        Intrinsics.checkNotNullParameter(r20, "msg");
        a1.a.f43a.i("RenderDynamicComponentFetcher", r20);
        this.f1777b.m(null, r19);
        return Unit.INSTANCE;
    L26:
        byte[] r21 = (byte[]) r5;
        Intrinsics.checkNotNullParameter(r21, ST.IMPLICIT_ARG_NAME);
        Intrinsics.checkNotNullParameter("RenderDynamicComponentFetcher", "tag");
        Intrinsics.checkNotNullParameter("loadDynamicComponent: getDynamicComponent success", "msg");
        a1.a.f43a.i("RenderDynamicComponentFetcher", "loadDynamicComponent: getDynamicComponent success");
        this.f1777b.m(r21, null);
        return Unit.INSTANCE;
    }
}
