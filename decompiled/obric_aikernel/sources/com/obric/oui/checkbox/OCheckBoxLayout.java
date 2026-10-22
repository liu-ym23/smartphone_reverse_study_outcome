package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0013R$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/obric/oui/checkbox/OCheckBoxLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "", "enabled", "", "setEnabled", "checked", "setChecked", "Lcom/obric/oui/checkbox/OCheckBox$b;", "listener", "setOnCheckedChangeListener", "Lcom/obric/oui/checkbox/OCheckBox$c;", "setOnCheckedStateChangedListener", "", TypedValues.Custom.S_COLOR, "setPrimaryColor", "light", "setAlwaysLight", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", EventBody.KEY_VALUE, "getCheckedState", "()I", "setCheckedState", "(I)V", "checkedState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OCheckBoxLayout extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OCheckBox f6367c;

    @JvmOverloads
    public OCheckBoxLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OCheckBoxLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OCheckBoxLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        if (r11 == null) goto L5;
        OCheckBox r13 = new OCheckBox(r10, r11, r12);
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-2, -2);
        r14.gravity = 17;
        Unit r15 = Unit.INSTANCE;
        r13.setLayoutParams(r14);
        this.f6367c = r13;
        addView(r13);
        return;
    L5:
        OCheckBox r16 = new OCheckBox(r10);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);
        r17.gravity = 17;
        Unit r18 = Unit.INSTANCE;
        r16.setLayoutParams(r17);
        this.f6367c = r16;
        addView(r16);
    }

    public /* synthetic */ OCheckBoxLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final OCheckBox getCheckBox() {
        return this.f6367c;
    }

    public final int getCheckedState() {
        return this.f6367c.getCheckedState();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f6367c.isChecked();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = View.MeasureSpec.makeMeasureSpec(MathKt.roundToInt(TypedValue.applyDimension(1, 32, r12.getDisplayMetrics())), 1073741824);
        super.onMeasure(r13, r13);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L15;
        if (isEnabled() == false) goto L15;
        int r11 = r10.getAction();
        if (r11 != 0) goto L8;
        setBackground(getResources().getDrawable(e.o_ic_radio_round_press_bg, null));
        goto L15
    L8:
        if (r11 != 1) goto L10;
    L12:
        setBackground(null);
        goto L15
    L10:
        if (r11 == 3) goto L12;
    L15:
        return super.onTouchEvent(r10);
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.f6367c.performClick();
    }

    public final void setAlwaysLight(boolean r10) {
        this.f6367c.setAlwaysLight(r10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r10) {
        this.f6367c.setChecked(r10);
    }

    public final void setCheckedState(int r10) {
        this.f6367c.setCheckedState(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.f6367c.setEnabled(r10);
        if (r10 == true) goto L6;
        setBackground(null);
        return;
    }

    public final void setOnCheckedChangeListener(OCheckBox.b r10) {
        this.f6367c.setOnCheckedChangeListener(r10);
    }

    public final void setOnCheckedStateChangedListener(OCheckBox.c r10) {
        this.f6367c.setOnCheckedStateChangedListener(r10);
    }

    public final void setPrimaryColor(@ColorInt int r10) {
        this.f6367c.setPrimaryColor(r10);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f6367c.toggle();
    }
}
