package com.bytedance.ai.model.widgets;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f2339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LifecycleRegistry f2340c;

    public /* synthetic */ e(Lifecycle.Event r5, LifecycleRegistry r10, int r11) {
        this.f2338a = r11;
        this.f2339b = r5;
        this.f2340c = r10;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f2338a) {
            case 0: goto L14;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        String r5 = " Unable to " + this.f2339b;
        IllegalStateException r10 = new IllegalStateException("current state is " + this.f2340c.getCurrentState());
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L8;
        r11.e("WebViewFloatingPageV2", r5, r10);
    L8:
        return Unit.INSTANCE;
    L9:
        String r12 = " Unable to " + this.f2339b;
        IllegalStateException r13 = new IllegalStateException("current state is " + this.f2340c.getCurrentState());
        Intrinsics.checkNotNullParameter("RelaxViewFloatingPageV2", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L13;
        r14.e("RelaxViewFloatingPageV2", r12, r13);
    L13:
        return Unit.INSTANCE;
    L14:
        String r15 = " Unable to " + this.f2339b;
        IllegalStateException r16 = new IllegalStateException("current state is " + this.f2340c.getCurrentState());
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L18;
        r17.e("LynxViewFloatingPage", r15, r16);
    L18:
        return Unit.INSTANCE;
    }
}
