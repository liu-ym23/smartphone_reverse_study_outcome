package com.obric.widget.host.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f14935c;

    public /* synthetic */ c(int r5, Object r10, Object r11) {
        this.f14933a = r5;
        this.f14934b = r10;
        this.f14935c = r11;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f14933a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return DefaultWidgetHost.a((DefaultWidgetHost) this.f14934b, (DefaultWidgetHost.ActiveWidgetKey) this.f14935c);
    L7:
        return DefaultWidgetHostView.C01921.f((Function1) this.f14934b, (String) this.f14935c);
    L9:
        return DefaultWidgetHostView.C01911.f((Function1) this.f14934b, (String) this.f14935c);
    }
}
