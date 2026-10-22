package com.larksuite.component.autolinearlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/autolinearlayout/AutoLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "autoAjustmentCompleted", "", "lastWidthMeasureSpec", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "addView", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "changeToHorizontal", "changeToVertical", "findPrimary", "Lcom/larksuite/component/universe_design/button/UDButton;", "findSecondary", "Companion", "widget-autolinearlayout_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class AutoLinearLayout extends LinearLayout {
    public static final List<String> c = null;
    public boolean a;
    public int b;

    public static final class a {
    }

    static {
        c = CollectionsKt.listOf(new String[]{"primary", "secondary"});
    }

    public AutoLinearLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public AutoLinearLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        if (getChildCount() == 2) goto L5;
        super.onMeasure(r10, r11);
        return;
    L5:
        if (this.b == r10) goto L7;
        this.b = r10;
        AppCompatButton r0 = (UDButton) findViewWithTag("primary");
        AppCompatButton r5 = (UDButton) findViewWithTag("secondary");
        setOrientation(0);
        ViewGroup.LayoutParams r7 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r7;
        r8.weight = 1.0f;
        r8.width = 0;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) r6;
        r9.weight = 1.0f;
        r9.width = 0;
        removeViewInLayout(r0);
        addViewInLayout(r0, 1, r0.getLayoutParams(), true);
        this.a = false;
    L7:
        super.onMeasure(r10, r11);
        if (this.a == true) goto L17;
        UDButton r1 = (UDButton) findViewWithTag("primary");
        UDButton r12 = (UDButton) findViewWithTag("secondary");
        if (ny7.a.a(r1) == false) goto L12;
    L13:
        AppCompatButton r2 = (UDButton) findViewWithTag("primary");
        AppCompatButton r3 = (UDButton) findViewWithTag("secondary");
        setOrientation(1);
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) r4;
        r13.weight = 0.0f;
        r13.width = -1;
        ViewGroup.LayoutParams r14 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) r14;
        r15.weight = 0.0f;
        r15.width = -1;
        removeViewInLayout(r3);
        addViewInLayout(r3, 1, r3.getLayoutParams(), true);
    L14:
        this.a = true;
        super.onMeasure(r10, r11);
        return;
    L12:
        if (ny7.a.a(r12) == false) goto L14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void addView(View r4, int r5, ViewGroup.LayoutParams r6) {
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r6, "params");
        if ((r4 instanceof UDButton) == false) goto L11;
        List<String> r0 = c;
        if (CollectionsKt.contains(r0, ((UDButton) r4).getTag()) == false) goto L9;
        super.addView(r4, r5, r6);
        return;
    L9:
        throw new IllegalArgumentException(("Child View must has one of " + r0 + " tag").toString());
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
