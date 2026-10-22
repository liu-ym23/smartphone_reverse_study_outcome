package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0012J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/CustomViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroidx/core/view/NestedScrollingParent2;", "Landroidx/core/view/NestedScrollingParentHelper;", "getScrollingChildHelper", "Lcom/bytedance/android/live/revlink/impl/pk/ui/i;", "scrollListener", "Lcom/bytedance/android/live/revlink/impl/pk/ui/i;", "getScrollListener", "()Lcom/bytedance/android/live/revlink/impl/pk/ui/i;", "setScrollListener", "(Lcom/bytedance/android/live/revlink/impl/pk/ui/i;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomViewPager extends ViewPager implements NestedScrollingParent2 {
    public NestedScrollingParentHelper a;
    public boolean b;

    public final i getScrollListener() {
        return null;
    }

    public final void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r4, "consumed");
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "target");
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
        if ((r3 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setScrollListener(i r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final NestedScrollingParentHelper getScrollingChildHelper() {
        if (this.a != null) goto L6;
        this.a = new NestedScrollingParentHelper(this);
    L6:
        return this.a;
    }

    public CustomViewPager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = true;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.b == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r2);
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.b == true) goto L5;
        return false;
    L5:
        return super.onTouchEvent(r2);
    }

    public CustomViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = true;
    }

    public final void onStopNestedScroll(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        NestedScrollingParentHelper r0 = getScrollingChildHelper();
        if (r0 == null) goto L6;
        r0.onStopNestedScroll(r2, r3);
        return;
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        NestedScrollingParentHelper r0 = getScrollingChildHelper();
        if (r0 == null) goto L6;
        r0.onNestedScrollAccepted(r2, r3, r4, r5);
        return;
    }
}
