package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.lynx.tasm.utils.j;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.divider.ODivider;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalVertical;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getButtonCount", "()I", "", "Landroid/view/View;", "buttons", "", "setButtons", "(Ljava/util/List;)V", "getMaxButtonCount", "maxCount", "setMaxButtonCount", "(I)V", "headerView", "setHeaderView", "(Landroid/view/View;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarNormalVertical extends FrameLayout {
    public static final /* synthetic */ int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f11928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f11929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f11930c;
    public final int d;
    public int e;
    public final int f;

    @JvmOverloads
    public OBottomActionBarNormalVertical(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final int getButtonCount() {
        return this.f11929b.getChildCount();
    }

    public final int getMaxButtonCount() {
        return this.e;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        FrameLayout r5 = this.f11930c;
        if (r5.getChildCount() <= 0) goto L19;
        int r12 = View.MeasureSpec.getSize(r11);
        int r13 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r10), Integer.MIN_VALUE);
        int r14 = View.MeasureSpec.makeMeasureSpec(0, 0);
        LinearLayout r15 = this.f11929b;
        r15.measure(r13, r14);
        int r16 = r15.getMeasuredHeight();
        View r17 = this.f11928a;
        int r18 = r17.getPaddingBottom() + r17.getPaddingTop();
        ViewGroup.LayoutParams r19 = r15.getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
    L8:
        if (r20 != null) goto L10;
        int r21 = 0;
    L11:
        int r22 = Math.max(0, r12 - ((r18 + r21) + r16));
        r5.measure(r13, r14);
        int r23 = r5.getMeasuredHeight();
        ViewGroup.LayoutParams r24 = r5.getLayoutParams();
        if (r22 >= r23) goto L17;
        if (r24.height == r22) goto L19;
        r24.height = r22;
        r5.setLayoutParams(r24);
        goto L19
    L17:
        if (r24.height == (-2)) goto L19;
        r24.height = -2;
        r5.setLayoutParams(r24);
        goto L19
    L10:
        r21 = r20.topMargin;
        goto L11
    L7:
        r20 = null;
    L19:
        super.onMeasure(r10, r11);
    }

    public final void setButtons(List<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r10, "buttons");
        LinearLayout r5 = this.f11929b;
        r5.removeAllViews();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        View r12 = (View) r11.next();
        Intrinsics.checkNotNullParameter(r12, "button");
        int r13 = r5.getChildCount();
        int r14 = this.e;
        if (r13 >= r14) goto L7;
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if (r15 == null) goto L11;
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(r15.width, r15.height);
    L13:
        if (r5.getChildCount() <= 0) goto L15;
        r16.topMargin = this.d;
    L15:
        Unit r17 = Unit.INSTANCE;
        r5.addView(r12, r16);
        goto L4
    L11:
        r16 = new LinearLayout.LayoutParams(-1, -2);
        goto L13
    L7:
        ps.a.g("OBottomActionBarNormalVertical", Intrinsics.stringPlus("Maximum number of buttons reached: ", Integer.valueOf(r14)));
        goto L4
    }

    public final void setHeaderView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "headerView");
        FrameLayout r10 = this.f11930c;
        r10.removeAllViews();
        r10.addView(r5);
        ViewGroup.LayoutParams r11 = this.f11929b.getLayoutParams();
        if (r11 == null) goto L7;
        int r12 = com.lynx.tasm.utils.a.B(8, this);
        ((ViewGroup.MarginLayoutParams) r11).topMargin = r12;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setMaxButtonCount(int r5) {
        if (this.f11929b.getChildCount() <= r5) goto L6;
        ps.a.c("OBottomActionBarNormalVertical", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r5 <= 0) goto L8;
        this.e = r5;
        return;
    L8:
        ps.a.c("OBottomActionBarNormalVertical", "Max button count must be greater than 0");
    }

    @JvmOverloads
    public OBottomActionBarNormalVertical(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.d = com.lynx.tasm.utils.a.B(12, this);
        this.e = 3;
        View.inflate(r10, R$layout.o_widget_bottom_action_bar_v2_normal_vertical, this);
        View r5 = findViewById(R$id.bottom_action_bar_root);
        this.f11928a = r5;
        this.f = r5.getPaddingBottom();
        addView(new ODivider(r10, null, 6, 0), new FrameLayout.LayoutParams(-1, com.lynx.tasm.utils.a.C(this, 0.6d)));
        this.f11929b = (LinearLayout) findViewById(R$id.action_bar_vertical_container);
        this.f11930c = (FrameLayout) findViewById(R$id.action_bar_header_container);
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OBottomActionBar, 0, 0);
        if (r12.getBoolean(R$styleable.OBottomActionBar_oui_widgetFitInsetBottom, true) == false) goto L5;
        int r13 = j.r(this, null).bottom;
        View r14 = this.f11928a;
        r14.setPaddingRelative(r14.getPaddingLeft(), r14.getPaddingTop(), r14.getPaddingRight(), Math.max(r13, this.f));
        setOnApplyWindowInsetsListener(new b(this, 1));
    L5:
        r12.recycle();
    }
}
