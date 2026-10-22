package com.obric.flow.cardlistpage.ui.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.obric.flow.cardlistpage.R$dimen;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Float f11836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f11837b;

    public a(Context r5, float r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f11836a = Float.valueOf(r10);
        this.f11837b = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getSize(r10);
        Integer r13 = this.f11837b;
        if (r13 == null) goto L5;
        int r14 = r13.intValue();
        int r5 = getContext().getResources().getDimensionPixelSize(R$dimen.card_height);
        int r15 = getContext().getResources().getDimensionPixelSize(R$dimen.normal_space_new);
        int r16 = RangesKt.coerceAtLeast((int) Math.ceil(RangesKt.coerceAtLeast(r14, 1) / 2.0f), 1);
        int r17 = RangesKt.coerceAtLeast((RangesKt.coerceAtLeast(r16 - 1, 0) * r15) + (r5 * r16), r5);
    L10:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r12, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r17, BasicMeasure.EXACTLY));
        return;
    L5:
        float r18 = r12;
        Float r19 = this.f11836a;
        if (r19 == null) goto L8;
        float r20 = r19.floatValue();
    L9:
        r17 = (int) (r18 * r20);
        goto L10
    L8:
        r20 = 1.0f;
        goto L9
    }

    public a(Context r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f11836a = null;
        this.f11837b = Integer.valueOf(r10);
    }
}
