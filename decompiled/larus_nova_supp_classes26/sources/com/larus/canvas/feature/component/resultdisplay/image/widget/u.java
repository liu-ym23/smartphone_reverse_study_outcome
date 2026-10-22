package com.larus.canvas.feature.component.resultdisplay.image.widget;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public final StateFlowImpl a;
    public final StateFlowImpl b;

    public u(ViewPager2 r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        StateFlowImpl r0 = j1.a(TuplesKt.to(0, 0));
        this.a = r0;
        this.b = r0;
        r2.addOnLayoutChangeListener(new t(this));
    }
}
