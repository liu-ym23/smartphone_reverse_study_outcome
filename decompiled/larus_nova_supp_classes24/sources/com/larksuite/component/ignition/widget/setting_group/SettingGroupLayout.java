package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.UIUtils;
import h18.d;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010&\u001a\u00020'2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J(\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0014J\n\u0010-\u001a\u0004\u0018\u00010.H\u0002J\n\u0010/\u001a\u0004\u0018\u00010.H\u0002J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020'H\u0002J\b\u00103\u001a\u00020'H\u0002R&\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R&\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R&\u0010!\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020 8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00064"}, d2 = {"Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "itemBackgroundColor", "getItemBackgroundColor", "()I", "setItemBackgroundColor", "(I)V", "", "hasDivider", "getHasDivider", "()Z", "setHasDivider", "(Z)V", "dividerBackgroundColor", "getDividerBackgroundColor", "setDividerBackgroundColor", "dividerPaddingLeft", "getDividerPaddingLeft", "setDividerPaddingLeft", "", "itemCornerRadius", "getItemCornerRadius", "()F", "setItemCornerRadius", "(F)V", "applyAttrs", "", "onSizeChanged", "w", "h", "oldw", "oldh", "getFirstVisibleChild", "Landroid/view/View;", "getLastVisibleChild", "adjustBackground", "child", "setItemBackground", "setupDivider", "ignition-widget-settinggroup_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class SettingGroupLayout extends LinearLayout {
    public int a;
    public boolean b;
    public int c;
    public int d;
    public float e;

    public final void b() {
        if (this.b == false) goto L7;
        SettingGroupDividerDrawable r0 = new SettingGroupDividerDrawable(getContext());
        r0.c = UIUtils.getColor(getContext(), this.c);
        r0.invalidateSelf();
        setDividerDrawable(r0);
        setShowDividers(2);
        int r1 = this.d;
        if (r1 < 0) goto L9;
        r0.b = r1;
        r0.invalidateSelf();
        return;
    L9:
        return;
    L7:
        setDividerDrawable(null);
        setShowDividers(0);
    }

    private final View getFirstVisibleChild() {
        Iterator r0 = RangesKt.until(0, getChildCount()).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r2 = r0.next();
        if (getChildAt(((Number) r2).intValue()).getVisibility() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
    L12:
        Integer r3 = (Integer) r2;
        if (r3 != null) goto L15;
        return null;
    L15:
        return getChildAt(r3.intValue());
    L8:
        r4 = false;
        goto L9
    L11:
        r2 = null;
        goto L12
    }

    private final View getLastVisibleChild() {
        Iterator r0 = RangesKt.downTo(getChildCount() - 1, 0).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r3 = r0.next();
        if (getChildAt(((Number) r3).intValue()).getVisibility() != 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
    L12:
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L15;
        return null;
    L15:
        return getChildAt(r4.intValue());
    L8:
        r5 = false;
        goto L9
    L11:
        r3 = null;
        goto L12
    }

    public final void a() {
        if (getChildCount() > 0) goto L5;
        return;
    L5:
        int r0 = getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L14;
        View r2 = getChildAt(r1);
        Drawable r3 = r2.getBackground();
        if ((r3 instanceof GradientDrawable) == false) goto L10;
        GradientDrawable r4 = (GradientDrawable) r3;
    L11:
        if (r4 != null) goto L13;
        r4 = new GradientDrawable();
        r4.setColor(UIUtils.getColorStateList(getContext(), this.a));
    L13:
        View r5 = getFirstVisibleChild();
        View r6 = getLastVisibleChild();
        int r7 = b.a;
        b.a(r4, getContext(), Intrinsics.areEqual(r5, r2), Intrinsics.areEqual(r6, r2), this.e);
        r2.setBackground(r4);
        r1 = r1 + 1;
        goto L6
    L10:
        r4 = null;
        goto L11
    }

    public final int getDividerBackgroundColor() {
        return this.c;
    }

    public final int getDividerPaddingLeft() {
        return this.d;
    }

    public final boolean getHasDivider() {
        return this.b;
    }

    public final int getItemBackgroundColor() {
        return this.a;
    }

    public final float getItemCornerRadius() {
        return this.e;
    }

    public SettingGroupLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setDividerBackgroundColor(int r2) {
        if (this.c != r2) goto L5;
        return;
    L5:
        this.c = r2;
        b();
    }

    public final void setDividerPaddingLeft(int r2) {
        if (this.d != r2) goto L5;
        return;
    L5:
        this.d = r2;
        b();
    }

    public final void setHasDivider(boolean r2) {
        if (this.b != r2) goto L5;
        return;
    L5:
        this.b = r2;
        b();
    }

    public final void setItemBackgroundColor(int r2) {
        if (this.a != r2) goto L5;
        return;
    L5:
        this.a = r2;
        a();
    }

    public final void setItemCornerRadius(float r2) {
        if (this.e != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.e = r2;
        a();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public SettingGroupLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public SettingGroupLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 2131952398);
    }

    public SettingGroupLayout(Context r5, AttributeSet r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7, r8);
        this.a = 2131100568;
        this.c = 2131100548;
        this.d = -1;
        this.e = d.b(getContext(), 10);
        setOrientation(1);
        TypedArray r9 = getContext().obtainStyledAttributes(r6, new int[]{2130969759, 2130969769, 2130970195, 2130970396}, r7, r8);
        setHasDivider(r9.getBoolean(2, this.b));
        setItemBackgroundColor(r9.getResourceId(3, 2131100568));
        setDividerBackgroundColor(r9.getResourceId(0, 2131100548));
        setDividerPaddingLeft(r9.getDimensionPixelSize(1, this.d));
        r9.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        a();
    }
}
