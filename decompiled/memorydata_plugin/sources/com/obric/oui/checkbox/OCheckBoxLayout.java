package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0015\u001a\u00020\rJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0014J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0019H\u0002J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0017J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0017H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010.J\u0010\u0010/\u001a\u00020\u00192\b\b\u0001\u00100\u001a\u00020\bJ\b\u00101\u001a\u00020\u0019H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBoxLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundDrawable", "Lcom/obric/oui/common/style/OStateGradientDrawable;", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", EventBody.KEY_VALUE, "checkedState", "getCheckedState", "()I", "setCheckedState", "(I)V", "layoutSizePx", "getCheckBox", "isChecked", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performClick", "refreshDimensionCache", "setAlwaysLight", "light", "setChecked", "checked", "setEnabled", "enabled", "setOnCheckedChangeListener", "listener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedChangeListener;", "setOnCheckedStateChangedListener", "Lcom/obric/oui/checkbox/OCheckBox$OnCheckedStateChangedListener;", "setPrimaryColor", TypedValues.Custom.S_COLOR, "toggle", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCheckBoxLayout extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OCheckBox f13448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OStateGradientDrawable f13449b;
    private int c;

    public OCheckBoxLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OCheckBoxLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OCheckBoxLayout(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        OStateGradientDrawable r0 = new OStateGradientDrawable();
        this.f13449b = r0;
        a();
        if (r10 == null) goto L5;
        OCheckBox r4 = new OCheckBox(r9, r10, r8);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.f13448a = r4;
        Object r12 = ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
    L6:
        addView((View) r12);
        this.f13448a.setEnableExpandTouchRect(false);
        r0.setCornerRadius(this.c);
        ColorStateList r13 = ContextCompat.getColorStateList(r9, ZeusTransformUtils.mapRes(R.color.o_checkbox_layout_bg_color, TypedValues.Custom.S_COLOR, "o_checkbox_layout_bg_color"));
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNullExpressionValue(r13, "getColorStateList(contex…eckbox_layout_bg_color)!!");
        r0.setSolidColors(r13);
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r0, Drawable.class, "com.obric.memorydata.plugin"));
        setClickable(true);
        return;
    L5:
        OCheckBox r14 = new OCheckBox(r9);
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        r15.gravity = 17;
        r14.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        this.f13448a = r14;
        r12 = ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public /* synthetic */ OCheckBoxLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void a() {
        this.c = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 32);
    }

    public final OCheckBox getCheckBox() {
        return this.f13448a;
    }

    public final int getCheckedState() {
        return this.f13448a.getCheckedState();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f13448a.isChecked();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        a();
        this.f13449b.setCornerRadius(this.c);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
        super.onMeasure(r3, r3);
    }

    @Override // android.view.View
    public boolean performClick() {
        return this.f13448a.performClick();
    }

    public final void setAlwaysLight(boolean r1) {
        this.f13448a.setAlwaysLight(r1);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.f13448a.setChecked(r1);
    }

    public final void setCheckedState(int r1) {
        this.f13448a.setCheckedState(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        this.f13448a.setEnabled(r1);
    }

    public final void setOnCheckedChangeListener(OCheckBox.b r3) {
        OCheckBox.b r4 = (OCheckBox.b) ZeusTransformUtils.wrapperContextForParams(r3, OCheckBox.b.class, "com.obric.memorydata.plugin");
        this.f13448a.setOnCheckedChangeListener(r4);
    }

    public final void setOnCheckedStateChangedListener(OCheckBox.c r3) {
        OCheckBox.c r4 = (OCheckBox.c) ZeusTransformUtils.wrapperContextForParams(r3, OCheckBox.c.class, "com.obric.memorydata.plugin");
        this.f13448a.setOnCheckedStateChangedListener(r4);
    }

    public final void setPrimaryColor(int r1) {
        this.f13448a.setPrimaryColor(r1);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f13448a.toggle();
    }
}
