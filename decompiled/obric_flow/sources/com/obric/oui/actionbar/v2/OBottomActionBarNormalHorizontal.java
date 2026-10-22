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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalHorizontal;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getButtonCount", "()I", "", "Landroid/view/View;", "buttons", "", "setButtons", "(Ljava/util/List;)V", "getMaxButtonCount", "maxCount", "setMaxButtonCount", "(I)V", "headerView", "setHeaderView", "(Landroid/view/View;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarNormalHorizontal extends FrameLayout {
    public static final /* synthetic */ int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f11925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f11926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f11927c;
    public final int d;
    public int e;
    public final int f;

    @JvmOverloads
    public OBottomActionBarNormalHorizontal(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    public final int getButtonCount() {
        return this.f11926b.getChildCount();
    }

    public final int getMaxButtonCount() {
        return this.e;
    }

    public final void setButtons(List<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r10, "buttons");
        if (r10.size() <= this.e) goto L6;
        ps.a.g("OBottomActionBarNormalHorizontal", "Cannot set more than " + this.e + " buttons");
        return;
    L6:
        LinearLayout r5 = this.f11926b;
        r5.removeAllViews();
        Iterator<T> r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L24;
        View r12 = (View) r11.next();
        boolean r13 = true;
        if (r10.size() == 1) goto L13;
        r13 = false;
    L13:
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if (r14 == null) goto L16;
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(r14.width, r14.height);
    L17:
        if (r13 == false) goto L19;
        r15.width = -1;
    L21:
        if (r5.getChildCount() <= 0) goto L23;
        r15.leftMargin = this.d;
    L23:
        Unit r16 = Unit.INSTANCE;
        r5.addView(r12, r15);
        goto L8
    L19:
        r15.width = 0;
        r15.weight = 1.0f;
        goto L21
    L16:
        r15 = new LinearLayout.LayoutParams(-1, -2);
        goto L17
    }

    public final void setHeaderView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "headerView");
        FrameLayout r10 = this.f11927c;
        r10.removeAllViews();
        r10.addView(r5);
        ViewGroup.LayoutParams r11 = this.f11926b.getLayoutParams();
        if (r11 == null) goto L7;
        int r12 = com.lynx.tasm.utils.a.B(8, this);
        ((ViewGroup.MarginLayoutParams) r11).topMargin = r12;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setMaxButtonCount(int r5) {
        if (this.f11926b.getChildCount() <= r5) goto L6;
        ps.a.c("OBottomActionBarNormalHorizontal", "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r5 <= 0) goto L8;
        this.e = r5;
        return;
    L8:
        ps.a.c("OBottomActionBarNormalHorizontal", "Max button count must be greater than 0");
    }

    @JvmOverloads
    public OBottomActionBarNormalHorizontal(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.d = com.lynx.tasm.utils.a.B(12, this);
        this.e = 2;
        View.inflate(r10, R$layout.o_widget_bottom_action_bar_v2_normal_horizontal, this);
        View r5 = findViewById(R$id.bottom_action_bar_root);
        this.f11925a = r5;
        this.f = r5.getPaddingBottom();
        addView(new ODivider(r10, null, 6, 0), new FrameLayout.LayoutParams(-1, com.lynx.tasm.utils.a.C(this, 0.6d)));
        this.f11926b = (LinearLayout) findViewById(R$id.action_bar_horizontal_container);
        this.f11927c = (FrameLayout) findViewById(R$id.action_bar_header_container);
        setClipChildren(false);
        setClipToPadding(false);
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.OBottomActionBar, 0, 0);
        if (r12.getBoolean(R$styleable.OBottomActionBar_oui_widgetFitInsetBottom, true) == false) goto L5;
        int r13 = j.r(this, null).bottom;
        View r14 = this.f11925a;
        r14.setPaddingRelative(r14.getPaddingLeft(), r14.getPaddingTop(), r14.getPaddingRight(), Math.max(r13, this.f));
        setOnApplyWindowInsetsListener(new b(this, 0));
    L5:
        r12.recycle();
    }
}
