package com.ss.android.lark.inline.ai.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J(\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\bH\u0016J@\u0010 \u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020%H\u0016J8\u0010 \u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J0\u0010&\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\bH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/NSPConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/core/view/NestedScrollingParent3;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nspHandler", "Lcom/ss/android/lark/inline/ai/ui/NSPConstraintLayout$NSPHandler;", "nspHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "setNSPHandler", "", "onNestedPreFling", "", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "onNestedFling", "consumed", "onStartNestedScroll", "child", "axes", "type", "onNestedScrollAccepted", "onStopNestedScroll", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "onNestedPreScroll", "dx", "dy", "NSPHandler", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class NSPConstraintLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public a a;
    public final NestedScrollingParentHelper b;

    public interface a {
        boolean a(View r1, float r2);

        void b(View r1, int r2, int r3, int[] r4);

        void c(View r1, int r2, int[] r3, int r4);

        void onStartNestedScroll(View r1, View r2, int r3);

        void onStopNestedScroll(View r1, int r2);
    }

    public NSPConstraintLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NSPConstraintLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "target");
    }

    public final void setNSPHandler(a r1) {
        this.a = r1;
    }

    public final void onStopNestedScroll(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        a r0 = this.a;
        if (r0 == null) goto L5;
        r0.onStopNestedScroll(r2, r3);
    L5:
        this.b.onStopNestedScroll(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NSPConstraintLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new NestedScrollingParentHelper(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onNestedPreFling(View r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "target");
        a r0 = this.a;
        if (r0 == null) goto L6;
        return r0.a(r2, r4);
    L6:
        return super/*android.view.ViewGroup*/.onNestedPreFling(r2, r3, r4);
    }

    public /* synthetic */ NSPConstraintLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onNestedFling(View r2, float r3, float r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "target");
        return super/*android.view.ViewGroup*/.onNestedFling(r2, r3, r4, r5);
    }

    public final void onNestedScrollAccepted(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        this.b.onNestedScrollAccepted(r2, r3, r4, r5);
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
        a r5 = this.a;
        if (r5 == null) goto L5;
        r5.onStartNestedScroll(r1, r2, r4);
        return true;
    L5:
        return false;
    }

    public final void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r4, "consumed");
        a r6 = this.a;
        if (r6 == null) goto L6;
        r6.c(r1, r3, r4, r5);
        return;
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r7, "consumed");
        a r8 = this.a;
        if (r8 == null) goto L6;
        r8.b(r1, r5, r6, r7);
        return;
    }
}
