package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.ex.widget.WidgetView;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$color;
import com.obric.oui.common.style.OStateGradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import zq.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u000fJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 R$\u0010%\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u001b¨\u0006&"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBoxLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "enabled", "", "setEnabled", "(Z)V", "checked", "setChecked", "Lzq/a;", "listener", "setOnCheckedChangeListener", "(Lzq/a;)V", "Lzq/b;", "setOnCheckedStateChangedListener", "(Lzq/b;)V", "color", "setPrimaryColor", "(I)V", WidgetView.UI_MODE_LIGHT, "setAlwaysLight", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "value", "getCheckedState", "()I", "setCheckedState", "checkedState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCheckBoxLayout extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCheckBox f12314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OStateGradientDrawable f12315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12316c;

    @JvmOverloads
    public OCheckBoxLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final OCheckBox getCheckBox() {
        return this.f12314a;
    }

    public final int getCheckedState() {
        return this.f12314a.getCheckedState();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f12314a.isChecked();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        int r10 = a.B(32, this);
        this.f12316c = r10;
        this.f12315b.setCornerRadius(r10);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        int r11 = View.MeasureSpec.makeMeasureSpec(this.f12316c, BasicMeasure.EXACTLY);
        super.onMeasure(r11, r11);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.f12314a.performClick();
    }

    public final void setAlwaysLight(boolean r5) {
        this.f12314a.setAlwaysLight(r5);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        this.f12314a.setChecked(r5);
    }

    public final void setCheckedState(int r5) {
        this.f12314a.setCheckedState(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        this.f12314a.setEnabled(r5);
    }

    public final void setOnCheckedChangeListener(zq.a r5) {
        this.f12314a.setOnCheckedChangeListener(r5);
    }

    public final void setOnCheckedStateChangedListener(b r5) {
        this.f12314a.setOnCheckedStateChangedListener(r5);
    }

    public final void setPrimaryColor(@ColorInt int r5) {
        this.f12314a.setPrimaryColor(r5);
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f12314a.toggle();
    }

    @JvmOverloads
    public OCheckBoxLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OCheckBoxLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OCheckBoxLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        OStateGradientDrawable r12 = new OStateGradientDrawable();
        this.f12315b = r12;
        this.f12316c = a.B(32, this);
        if (r10 == null) goto L5;
        OCheckBox r13 = new OCheckBox(r5, r10, r11);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 17;
        r13.setLayoutParams(r14);
        this.f12314a = r13;
        addView(r13);
    L6:
        this.f12314a.setEnableExpandTouchRect(false);
        r12.setCornerRadius(this.f12316c);
        ColorStateList r15 = ContextCompat.getColorStateList(r5, R$color.o_checkbox_layout_bg_color);
        Intrinsics.checkNotNull(r15);
        r12.setSolidColors(r15);
        setBackground(r12);
        setClickable(true);
        return;
    L5:
        OCheckBox r16 = new OCheckBox(r5);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);
        r17.gravity = 17;
        r16.setLayoutParams(r17);
        this.f12314a = r16;
        addView(r16);
        goto L6
    }
}
