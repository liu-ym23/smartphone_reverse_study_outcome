package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/room/discovery/AnchorPerfDialogScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "canScroll", "", "setCanScroll", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfDialogScrollView extends NestedScrollView {
    public boolean a;

    public AnchorPerfDialogScrollView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return super/*android.widget.FrameLayout*/.dispatchTouchEvent(r2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r2) == false) goto L7;
        return true;
    }

    public final void setCanScroll(boolean r1) {
        this.a = r1;
    }

    public AnchorPerfDialogScrollView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public AnchorPerfDialogScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = true;
        setNestedScrollingEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedPreScroll(View r3, int r4, int r5, int[] r6, int r7) {
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r6, "consumed");
        if (r5 <= 0) goto L5;
        byte r1 = 1;
    L8:
        if (r1 == (-1)) goto L24;
        if (r1 == 0) goto L22;
        if (r1 != 1) goto L32;
        int r8 = 0 - getScrollY();
        if (r8 > 0) goto L15;
    L17:
        int r9 = r5;
    L18:
        if (r9 > 0) goto L20;
        return;
    L20:
        if (r3.canScrollVertically(1) == false) goto L28;
        r3.scrollBy(0, r9);
        r6[1] = r5;
        return;
    L28:
        return;
    L15:
        if (canScrollVertically(1) == false) goto L17;
        int r10 = RangesKt.coerceAtMost(r5, r8);
        scrollBy(0, r10);
        r6[1] = r10;
        r9 = r5 - r10;
        goto L18
    L32:
        return;
    L22:
        r6[1] = 0;
        return;
    L24:
        if (r3.canScrollVertically(-1) == false) goto L31;
        int r12 = -RangesKt.coerceAtMost(Math.abs(r5), Math.abs(r3.getScrollY()));
        r3.scrollBy(0, r12);
        r6[1] = r12;
        return;
    L31:
        return;
    L5:
        if (r5 >= 0) goto L7;
        r1 = -1;
        goto L8
    L7:
        r1 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "target");
        boolean r7 = true;
        if (r5 > 0) goto L5;
    L6:
        if (r5 < 0) goto L8;
    L10:
        r7 = false;
    L11:
        if (r7 == false) goto L14;
        scrollBy(0, r5);
        return;
    L14:
        return;
    L8:
        if (canScrollVertically(-1) == false) goto L10;
    L5:
        if (canScrollVertically(1) == true) goto L11;
        goto L6
    }
}
