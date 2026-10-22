package com.bytedance.android.livesdk.interactivity.comment.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/view/ScaleAlphaLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScaleAlphaLinearLayoutManager extends LinearLayoutManager {
    public RecyclerView a;
    public float b;
    public float c;
    public float d;
    public final float e;
    public final Lazy f;

    public ScaleAlphaLinearLayoutManager(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, 1, false);
        this.b = 1.0f;
        this.c = 1.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = LazyKt.lazy(ScaleAlphaLinearLayoutManager$mSnapHelper$2.INSTANCE);
    }

    public final void onAttachedToWindow(RecyclerView r2) {
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.onAttachedToWindow(r2);
        ((LinearSnapHelper) this.f.getValue()).attachToRecyclerView(r2);
        this.a = r2;
    }

    public final void p(View r7) {
        if (r7 == null) goto L9;
        getDecoratedMeasuredWidth(r7);
        int r0 = getDecoratedMeasuredHeight(r7);
        getDecoratedLeft(r7);
        getDecoratedRight(r7);
        float r1 = (getDecoratedTop(r7) + getDecoratedBottom(r7)) / 2.0f;
        RecyclerView r3 = this.a;
        if (r3 == null) goto L6;
        float r4 = r3.getHeight() * 0.3f;
    L7:
        float r2 = ((Number) RangesKt.coerceIn(Float.valueOf(Math.abs(r1 - r4) / Math.abs((getHeight() / 2.0f) - (r0 / 2.0f))), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
        float r5 = 1 - r2;
        float r6 = (this.c * r5) + (this.b * r2);
        float r8 = (this.e * r5) + (this.d * r2);
        r7.setScaleX(r6);
        r7.setScaleY(r6);
        r7.setAlpha(r8);
        return;
    L6:
        r4 = 0.0f;
        goto L7
    }

    public final int scrollVerticallyBy(int r4, RecyclerView.Recycler r5, RecyclerView.State r6) {
        int r2 = 0;
        if (getOrientation() != 1) goto L10;
        int r7 = super.scrollVerticallyBy(r4, r5, r6);
        int r8 = getChildCount();
    L5:
        if (r2 >= r8) goto L8;
        p(getChildAt(r2));
        r2 = r2 + 1;
        goto L5
    L8:
        return r7;
    L10:
        return 0;
    }

    public final void layoutDecorated(View r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "child");
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.layoutDecorated(r2, r3, r4, r5, r6);
        p(r2);
    }

    public final void layoutDecoratedWithMargins(View r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "child");
        super/*androidx.recyclerview.widget.RecyclerView.LayoutManager*/.layoutDecoratedWithMargins(r2, r3, r4, r5, r6);
        p(r2);
    }
}
