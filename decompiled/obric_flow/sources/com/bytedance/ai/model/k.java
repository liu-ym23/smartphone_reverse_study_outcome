package com.bytedance.ai.model;

import com.bytedance.ai.monitor.AppletMonitorableEvent$EventOrigin;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2251c;

    public /* synthetic */ k(int r5, Object r10, Object r11) {
        this.f2249a = r5;
        this.f2250b = r10;
        this.f2251c = r11;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        Object r10 = this.f2251c;
        Object r11 = this.f2250b;
        switch(this.f2249a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        z2.a r12 = (z2.a) r5;
        int r13 = AppletRuntime.f2196x;
        Intrinsics.checkNotNullParameter(r12, "error");
        r12.f = ((AppletRuntime) r11).f2197h.F;
        AppletMonitorableEvent$EventOrigin r14 = AppletMonitorableEvent$EventOrigin.f2386c;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r12.f23385c = r14;
        r12.c("main_url", (String) r10);
        return Unit.INSTANCE;
    L6:
        Function3 r15 = (Function3) r11;
        return AppletRuntime$createPage$1.a(r15, (w0.f) r10, (String) r5);
    L8:
        Function3 r16 = (Function3) r11;
        return AppletRuntime$createPage$1.a(r16, (w0.f) r10, (Integer) r5);
    }
}
