package com.larus.slides.impl.select.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/larus/slides/impl/select/widget/GenerateImageViewPagerContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GenerateImageViewPagerContainer extends FrameLayout {
    public final ViewPager2 a;

    public GenerateImageViewPagerContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GenerateImageViewPagerContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final ViewPager2 getViewPager() {
        return this.a;
    }

    public GenerateImageViewPagerContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ViewPager2 r0 = new ViewPager2(r2, r3, r4);
        this.a = r0;
        r0.setPageTransformer(new MarginPageTransformer(c7.b(12)));
        addView(r0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public /* synthetic */ GenerateImageViewPagerContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r9, int r10, int r11, int r12) {
        super.onSizeChanged(r9, r10, r11, r12);
        double r0 = r10;
        double r13 = RangesKt.coerceAtMost((r0 / 16.0d) * 9.0d, r9 - c7.b(32));
        int r14 = (int) (((((double) r9) - r13) * 0.5d) + 0.5d);
        int r15 = RangesKt.coerceAtLeast((int) (((r0 - RangesKt.coerceAtMost((r13 / 9.0d) * 16.0d, r0)) * 0.5d) + 0.5d), 0);
        RecyclerView r16 = this.a.getChildAt(0);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r17 = r16;
        FLogger.a.i("updatePaddingRelative", "view:" + r17.getClass().getSimpleName() + ",source:,start:" + r14 + ",top:" + r15 + ",end:" + r14 + ",bottom:" + r15);
        r17.setPaddingRelative(r14, r15, r14, r15);
        r17.setClipToPadding(false);
    }
}
