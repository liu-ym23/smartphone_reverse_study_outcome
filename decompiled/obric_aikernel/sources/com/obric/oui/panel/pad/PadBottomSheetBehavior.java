package com.obric.oui.panel.pad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.panel.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\rJ?\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/panel/pad/PadBottomSheetBehavior;", "Landroid/view/View;", "V", "Lcom/obric/oui/panel/BottomSheetBehavior;", "", "calculateCollapsedOffset", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "child", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onInterceptTouchEvent", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/MotionEvent;)Z", "onTouchEvent", "coordinatorLayout", "directTargetChild", TypedValues.AttributesType.S_TARGET, "", "axes", WsConstants.KEY_CONNECTION_TYPE, "onStartNestedScroll", "(Landroidx/coordinatorlayout/widget/CoordinatorLayout;Landroid/view/View;Landroid/view/View;Landroid/view/View;II)Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class PadBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {
    public PadBottomSheetBehavior(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        super(r10, r11);
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior
    protected void calculateCollapsedOffset() {
        if (this.fitToContents == false) goto L5;
        int r10 = RangesKt.coerceAtLeast(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
    L6:
        this.collapsedOffset = r10;
        this.collapsedOffset = r10 / 2;
        return;
    L5:
        r10 = this.parentHeight - this.lastPeekHeight;
        goto L6
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_EVENT);
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r10, V r11, View r12, View r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, "directTargetChild");
        Intrinsics.checkNotNullParameter(r13, TypedValues.AttributesType.S_TARGET);
        return false;
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r10, V r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "child");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_EVENT);
        return false;
    }
}
