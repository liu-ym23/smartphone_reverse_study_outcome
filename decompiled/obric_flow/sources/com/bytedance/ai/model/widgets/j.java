package com.bytedance.ai.model.widgets;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f2349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f2350c;
    public final /* synthetic */ a d;

    public /* synthetic */ j(a r5, double r10, double r11, int r12) {
        this.f2348a = r12;
        this.d = r5;
        this.f2349b = r10;
        this.f2350c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        double r5 = this.f2350c;
        double r10 = this.f2349b;
        a r11 = this.d;
        switch(this.f2348a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        WebViewFloatingPageV2 r12 = (WebViewFloatingPageV2) r11;
        r12.f2325k = true;
        Lazy r13 = v0.d.f22502n;
        v0.d r14 = cl.a.h();
        int r15 = com.bytedance.ai.utils.c.d(Double.valueOf(r10));
        com.bytedance.ai.utils.c.d(Double.valueOf(r5));
        r14.getClass();
        Intrinsics.checkNotNullParameter(r12, "page");
        v0.a r16 = r14.f;
        if (r16 == null) goto L7;
        r16.setRealWidth(r15);
    L7:
        r12.c();
        return;
    L9:
        RelaxViewFloatingPageV2 r17 = (RelaxViewFloatingPageV2) r11;
        r17.f2318h = true;
        Lazy r18 = v0.d.f22502n;
        v0.d r19 = cl.a.h();
        int r20 = com.bytedance.ai.utils.c.d(Double.valueOf(r10));
        com.bytedance.ai.utils.c.d(Double.valueOf(r5));
        r19.getClass();
        Intrinsics.checkNotNullParameter(r17, "page");
        v0.a r21 = r19.f;
        if (r21 == null) goto L12;
        r21.setRealWidth(r20);
    L12:
        r17.c();
    }
}
