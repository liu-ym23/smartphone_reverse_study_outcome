package com.larus.agents.impl.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/agents/impl/ui/OfficeTaskPreferenceScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isParentLocked", "", "nestedScrollingBeforeGesture", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "lockParentForScrollableContent", "", "keepParentLocked", "releaseParentLock", "onDetachedFromWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OfficeTaskPreferenceScrollView extends NestedScrollView {
    public boolean a;
    public boolean b;

    /* JADX WARN: Multi-variable type inference failed */
    public final void e() {
        if (this.a == true) goto L5;
        return;
    L5:
        setNestedScrollingEnabled(this.b);
        ViewParent r0 = getParent();
        if (r0 == null) goto L8;
        r0.requestDisallowInterceptTouchEvent(false);
    L8:
        this.a = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        e();
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    public OfficeTaskPreferenceScrollView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        int r0 = r4.getActionMasked();
        if (r0 != 0) goto L5;
        e();
        if (canScrollVertically(-1) == false) goto L15;
    L18:
        boolean r1 = true;
    L19:
        this.a = r1;
        if (r1 == false) goto L27;
        this.b = isNestedScrollingEnabled();
        setNestedScrollingEnabled(false);
        if (this.a == false) goto L27;
        ViewParent r2 = getParent();
        if (r2 == null) goto L27;
        r2.requestDisallowInterceptTouchEvent(true);
    L27:
        boolean r3 = super/*android.widget.FrameLayout*/.dispatchTouchEvent(r4);
        int r5 = r4.getActionMasked();
        if (r5 != 1) goto L30;
    L32:
        e();
    L33:
        return r3;
    L30:
        if (r5 == 3) goto L32;
    L15:
        if (canScrollVertically(1) == true) goto L18;
        r1 = false;
        goto L19
    L5:
        if (r0 != 2) goto L27;
        if (this.a == false) goto L27;
        ViewParent r6 = getParent();
        if (r6 == null) goto L27;
        r6.requestDisallowInterceptTouchEvent(true);
        goto L27
    }

    public OfficeTaskPreferenceScrollView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = true;
    }

    public OfficeTaskPreferenceScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = true;
    }
}
