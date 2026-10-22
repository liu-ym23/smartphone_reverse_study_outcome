package com.obric.widget.host.runtime;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WidgetInstanceManager f14940b;

    public /* synthetic */ b(WidgetInstanceManager r5, int r10) {
        this.f14939a = r10;
        this.f14940b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        int r10 = this.f14939a;
        WidgetInstanceManager r11 = this.f14940b;
        WidgetInstanceRecord r12 = (WidgetInstanceRecord) r5;
        switch(r10) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return WidgetInstanceManager.c(r11, r12);
    L7:
        return WidgetInstanceManager.f(r11, r12);
    L9:
        return WidgetInstanceManager.b(r11, r12);
    }
}
