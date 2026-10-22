package com.obric.oui.segmentedtab;

import ai.j0;
import android.animation.TypeEvaluator;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements TypeEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f14367b;

    public d(OBottomToolBar r5) {
        this.f14366a = 0;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        this.f14367b = r5;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float r5, Object r10, Object r11) {
        switch(this.f14366a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        g r12 = (g) r10;
        g r13 = (g) r11;
        Intrinsics.checkNotNullParameter(r12, "startValue");
        Intrinsics.checkNotNullParameter(r13, "endValue");
        float r14 = r12.f14376a;
        float r15 = j0.b(r13.f14376a, r14, r5, r14);
        float r16 = r12.f14377b;
        float r17 = j0.b(r13.f14377b, r16, r5, r16);
        Intrinsics.checkNotNullParameter((OTabSegmentedLayout) this.f14367b, "this$0");
        g r18 = new g();
        r18.f14376a = r15;
        r18.f14377b = r17;
        return r18;
    L6:
        c r19 = (c) r10;
        c r20 = (c) r11;
        Intrinsics.checkNotNullParameter(r19, "startValue");
        Intrinsics.checkNotNullParameter(r20, "endValue");
        float r21 = r19.f14364a;
        float r22 = j0.b(r20.f14364a, r21, r5, r21);
        float r23 = r19.f14365b;
        float r24 = j0.b(r20.f14365b, r23, r5, r23);
        Intrinsics.checkNotNullParameter((OBottomToolBar) this.f14367b, "this$0");
        c r25 = new c();
        r25.f14364a = r22;
        r25.f14365b = r24;
        return r25;
    }

    public d(OTabSegmentedLayout r5) {
        this.f14366a = 1;
        Intrinsics.checkNotNullParameter(r5, "this$0");
        this.f14367b = r5;
    }
}
