package com.bytedance.ai.ex.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2149c;

    public /* synthetic */ b(int r5, Object r10, Object r11) {
        this.f2147a = r5;
        this.f2148b = r10;
        this.f2149c = r11;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch(this.f2147a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        e r5 = (e) this.f2149c;
        return RepeatWhenAttachedKt.C01602.f((ViewTreeObserver) this.f2148b, r5);
    L6:
        d r10 = (d) this.f2149c;
        return RepeatWhenAttachedKt.AnonymousClass2.f((ViewTreeObserver) this.f2148b, r10);
    L8:
        c r11 = (c) this.f2149c;
        return RepeatWhenAttachedKt.C01571.C00111.b((View) this.f2148b, r11);
    L10:
        RepeatWhenAttachedKt$isAttached$1$onAttachListener$1 r12 = (RepeatWhenAttachedKt$isAttached$1$onAttachListener$1) this.f2149c;
        return RepeatWhenAttachedKt.AnonymousClass1.b((View) this.f2148b, r12);
    }
}
