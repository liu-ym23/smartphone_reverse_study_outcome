package com.obric.widget.host.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f14931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Throwable f14932c;

    public /* synthetic */ b(Function1 r5, Throwable r10, int r11) {
        this.f14930a = r11;
        this.f14931b = r5;
        this.f14932c = r10;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f14930a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Throwable r5 = this.f14932c;
        return DefaultWidgetHostView.C01921.b(this.f14931b, r5);
    L6:
        Throwable r10 = this.f14932c;
        return DefaultWidgetHostView.C01911.b(this.f14931b, r10);
    L8:
        Throwable r11 = this.f14932c;
        return DefaultWidgetHostView.C01901.f(this.f14931b, r11);
    }
}
