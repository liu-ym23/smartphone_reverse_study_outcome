package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.style.OStateGradientDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0013R$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/obric/oui/checkbox/OCheckBoxLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "", "enabled", "", "setEnabled", "checked", "setChecked", "Lcom/obric/oui/checkbox/OCheckBox$a;", "listener", "setOnCheckedChangeListener", "Lcom/obric/oui/checkbox/OCheckBox$b;", "setOnCheckedStateChangedListener", "", "color", "setPrimaryColor", "light", "setAlwaysLight", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "value", "getCheckedState", "()I", "setCheckedState", "(I)V", "checkedState", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OCheckBoxLayout extends FrameLayout implements Checkable {
    public final OCheckBox a;
    public final OStateGradientDrawable b;
    public int c;

    public OCheckBoxLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OCheckBoxLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    public final int getCheckedState() {
        return this.a.getCheckedState();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.a.isChecked();
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.a.performClick();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.a.toggle();
    }

    public final OCheckBox getCheckBox() {
        return this.a;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        int r3 = d.n(this, 32);
        this.c = r3;
        this.b.setCornerRadius(r3);
    }

    public final void setAlwaysLight(boolean r2) {
        this.a.setAlwaysLight(r2);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        this.a.setChecked(r2);
    }

    public final void setCheckedState(int r2) {
        this.a.setCheckedState(r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.a.setEnabled(r2);
    }

    public final void setOnCheckedChangeListener(OCheckBox.a r2) {
        this.a.setOnCheckedChangeListener(r2);
    }

    public final void setOnCheckedStateChangedListener(OCheckBox.b r2) {
        this.a.setOnCheckedStateChangedListener(r2);
    }

    public final void setPrimaryColor(int r2) {
        this.a.setPrimaryColor(r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        int r3 = View.MeasureSpec.makeMeasureSpec(this.c, 1073741824);
        super.onMeasure(r3, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View, android.widget.ImageView, com.obric.oui.checkbox.OCheckBox] */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.view.View, android.widget.ImageView, com.obric.oui.checkbox.OCheckBox] */
    public OCheckBoxLayout(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        OStateGradientDrawable r0 = new OStateGradientDrawable();
        this.b = r0;
        this.c = d.n(this, 32);
        if (r6 == null) goto L5;
        ?? r3 = new OCheckBox(r5, r6, r7);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.gravity = 17;
        r3.setLayoutParams(r8);
        this.a = r3;
        addView(r3);
    L6:
        this.a.setEnableExpandTouchRect(false);
        r0.setCornerRadius(this.c);
        ColorStateList r9 = ContextCompat.getColorStateList(r5, 2131103749);
        Intrinsics.checkNotNull(r9);
        r0.setSolidColors(r9);
        setBackground(r0);
        setClickable(true);
        return;
    L5:
        ?? r10 = new OCheckBox(r5);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        r10.setLayoutParams(r11);
        this.a = r10;
        addView(r10);
        goto L6
    }

    public /* synthetic */ OCheckBoxLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
