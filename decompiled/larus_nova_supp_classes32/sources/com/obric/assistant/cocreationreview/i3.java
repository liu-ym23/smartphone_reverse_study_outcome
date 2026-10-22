package com.obric.assistant.cocreationreview;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.ViewPager2;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i3 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ CocreationReviewActivity a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ List<x4> c;
    public final /* synthetic */ ViewPager2 d;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        CocreationReviewActivity r6 = this.a;
        LinearLayout r0 = this.b;
        int r1 = this.c.size();
        int r2 = this.d.getCurrentItem();
        Set<String> r3 = CocreationReviewActivity.P1;
        r6.I2(r0, r1, r2);
    }

    public i3(CocreationReviewActivity r1, LinearLayout r2, List<x4> r3, ViewPager2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
