package com.google.android.material.checkbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.v0;
import com.google.android.material.internal.l;
import com.google.android.material.internal.q;
import com.obric.cae.R;
import g1.d;
import g1.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialCheckBox extends f {
    public static final int[] I = null;
    public static final int[] J = null;
    public static final int[][] K = null;

    @SuppressLint({"DiscouragedApi"})
    public static final int L = 0;
    public PorterDuff.Mode A;
    public int B;
    public int[] C;
    public boolean D;
    public CharSequence E;
    public CompoundButton.OnCheckedChangeListener F;
    public final d G;
    public final a H;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedHashSet<c> f4546o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinkedHashSet<b> f4547p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ColorStateList f4548q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4549r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4550s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4551t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public CharSequence f4552u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Drawable f4553v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f4554w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4555x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorStateList f4556y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f4557z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4558a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r8) {
                return new SavedState(r8);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r8) {
                return new SavedState[r8];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r8) {
            super(r8);
            this.f4558a = ((Integer) r8.readValue(getClass().getClassLoader())).intValue();
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("MaterialCheckBox.SavedState{");
            r8.append(Integer.toHexString(System.identityHashCode(this)));
            r8.append(" CheckedState=");
            int r10 = this.f4558a;
            if (r10 != 1) goto L5;
            String r11 = "checked";
        L10:
            return android.aimedia.a.i(r8, r11, "}");
        L5:
            if (r10 == 2) goto L7;
            r11 = "unchecked";
            goto L10
        L7:
            r11 = "indeterminate";
            goto L10
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            super.writeToParcel(r8, r10);
            r8.writeValue(Integer.valueOf(this.f4558a));
        }
    }

    public class a extends g1.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialCheckBox f4559b;

        public a(MaterialCheckBox r8) {
            this.f4559b = r8;
        }

        @Override // g1.c
        public final void a(Drawable r8) {
            ColorStateList r10 = this.f4559b.f4556y;
            if (r10 == null) goto L6;
            b0.a.b.h(r8, r10);
            return;
        }

        @Override // g1.c
        public final void b(Drawable r8) {
            MaterialCheckBox r10 = this.f4559b;
            ColorStateList r11 = r10.f4556y;
            if (r11 == null) goto L6;
            b0.a.b.g(r8, r11.getColorForState(r10.C, r11.getDefaultColor()));
            return;
        }
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();
    }

    static {
        I = new int[]{R.attr.state_indeterminate};
        J = new int[]{R.attr.state_error};
        K = new int[][]{new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
        L = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context r12, AttributeSet r13) {
        super(ea.a.a(r12, r13, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), r13, R.attr.checkboxStyle);
        this.f4546o = new LinkedHashSet();
        this.f4547p = new LinkedHashSet();
        Context r14 = getContext();
        d r8 = new d(r14);
        Resources r10 = r14.getResources();
        Resources.Theme r15 = r14.getTheme();
        ThreadLocal<TypedValue> r11 = z.f.f14146a;
        Drawable r16 = z.f.a.a(r10, R.drawable.mtrl_checkbox_button_checked_unchecked, r15);
        r8.f7561a = r16;
        r16.setCallback(r8.f7553p);
        new d.c(r8.f7561a.getConstantState());
        this.G = r8;
        this.H = new a(this);
        Context r17 = getContext();
        this.f4553v = androidx.core.widget.c.a(this);
        this.f4556y = getSuperButtonTintList();
        setSupportButtonTintList(null);
        int[] r18 = g9.a.f7774o;
        l.a(r17, r13, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox);
        l.b(r17, r13, r18, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        v0 r19 = new v0(r17, r17.obtainStyledAttributes(r13, r18, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox));
        this.f4554w = r19.e(2);
        if (this.f4553v != null) goto L5;
    L15:
        this.f4557z = x9.c.b(r17, r19, 3);
        this.A = q.b(r19.h(4, -1), PorterDuff.Mode.SRC_IN);
        this.f4549r = r19.a(10, false);
        this.f4550s = r19.a(6, true);
        this.f4551t = r19.a(9, false);
        this.f4552u = r19.k(8);
        if (r19.l(7) == false) goto L18;
        setCheckedState(r19.h(7, 0));
    L18:
        r19.n();
        b();
        return;
    L5:
        if (x9.b.b(r17, false, R.attr.isMaterial3Theme) == false) goto L15;
        int r110 = r19.i(0, 0);
        int r20 = r19.i(1, 0);
        if (r110 != L) goto L10;
        if (r20 != 0) goto L10;
        boolean r111 = true;
    L11:
        if (r111 == false) goto L15;
        super.setButtonDrawable(null);
        this.f4553v = d.a.a(r17, R.drawable.mtrl_checkbox_button);
        this.f4555x = true;
        if (this.f4554w != null) goto L15;
        this.f4554w = d.a.a(r17, R.drawable.mtrl_checkbox_button_icon);
    L10:
        r111 = false;
        goto L11
    }

    private String getButtonStateDescription() {
        int r8 = this.B;
        Resources r10 = getResources();
        if (r8 != 1) goto L7;
        int r11 = R.string.mtrl_checkbox_state_description_checked;
    L6:
        return r10.getString(r11);
    L7:
        if (r8 != 0) goto L9;
        r11 = R.string.mtrl_checkbox_state_description_unchecked;
        goto L6
    L9:
        r11 = R.string.mtrl_checkbox_state_description_indeterminate;
        goto L6
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f4548q != null) goto L6;
        int r8 = t2.b.z(this, R.attr.colorControlActivated);
        int r10 = t2.b.z(this, R.attr.colorError);
        int r11 = t2.b.z(this, R.attr.colorSurface);
        int r12 = t2.b.z(this, R.attr.colorOnSurface);
        int[] r13 = {t2.b.K(1.0f, r11, r10), t2.b.K(1.0f, r11, r8), t2.b.K(0.54f, r11, r12), t2.b.K(0.38f, r11, r12), t2.b.K(0.38f, r11, r12)};
        this.f4548q = new ColorStateList(K, r13);
    L6:
        return this.f4548q;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList r8 = this.f4556y;
        if (r8 == null) goto L6;
        return r8;
    L6:
        if (super.getButtonTintList() == null) goto L10;
        return super.getButtonTintList();
    L10:
        return getSupportButtonTintList();
    }

    public final void b() {
        Drawable r8 = this.f4553v;
        ColorStateList r10 = this.f4556y;
        PorterDuff.Mode r11 = androidx.core.widget.b.b(this);
        if (r8 != null) goto L5;
        r8 = null;
    L9:
        this.f4553v = r8;
        Drawable r12 = this.f4554w;
        ColorStateList r13 = this.f4557z;
        PorterDuff.Mode r14 = this.A;
        if (r12 != null) goto L12;
        r12 = null;
    L16:
        this.f4554w = r12;
        if (this.f4555x == false) goto L58;
        d r15 = this.G;
        if (r15 == null) goto L54;
        Drawable r16 = r15.f7561a;
        a r17 = this.H;
        if (r16 == null) goto L27;
        AnimatedVectorDrawable r18 = (AnimatedVectorDrawable) r16;
        if (r17.f7548a != null) goto L26;
        r17.f7548a = new g1.b(r17);
    L26:
        r18.unregisterAnimationCallback(r17.f7548a);
    L27:
        ArrayList<g1.c> r19 = r15.f7552o;
        d.b r20 = r15.f7549b;
        if (r19 == null) goto L36;
        if (r17 == null) goto L36;
        r19.remove(r17);
        if (r15.f7552o.size() != 0) goto L36;
        e r21 = r15.f7551n;
        if (r21 == null) goto L36;
        r20.f7556b.removeListener(r21);
        r15.f7551n = null;
    L36:
        Drawable r22 = r15.f7561a;
        if (r22 == null) goto L42;
        AnimatedVectorDrawable r23 = (AnimatedVectorDrawable) r22;
        if (r17.f7548a != null) goto L41;
        r17.f7548a = new g1.b(r17);
    L41:
        r23.registerAnimationCallback(r17.f7548a);
        goto L54
    L42:
        if (r17 == null) goto L54;
        if (r15.f7552o != null) goto L48;
        r15.f7552o = new ArrayList();
    L48:
        if (r15.f7552o.contains(r17) == true) goto L54;
        r15.f7552o.add(r17);
        if (r15.f7551n != null) goto L53;
        r15.f7551n = new e(r15);
    L53:
        r20.f7556b.addListener(r15.f7551n);
    L54:
        Drawable r24 = this.f4553v;
        if ((r24 instanceof AnimatedStateListDrawable) == false) goto L58;
        if (r15 == null) goto L58;
        ((AnimatedStateListDrawable) r24).addTransition(R.id.checked, R.id.unchecked, r15, false);
        ((AnimatedStateListDrawable) this.f4553v).addTransition(R.id.indeterminate, R.id.unchecked, r15, false);
    L58:
        Drawable r25 = this.f4553v;
        if (r25 == null) goto L63;
        ColorStateList r26 = this.f4556y;
        if (r26 == null) goto L63;
        b0.a.b.h(r25, r26);
    L63:
        Drawable r27 = this.f4554w;
        if (r27 == null) goto L68;
        ColorStateList r28 = this.f4557z;
        if (r28 == null) goto L68;
        b0.a.b.h(r27, r28);
    L68:
        Drawable r29 = this.f4553v;
        Drawable r30 = this.f4554w;
        if (r29 != null) goto L71;
        r29 = r30;
    L91:
        super.setButtonDrawable(r29);
        refreshDrawableState();
        return;
    L71:
        if (r30 == null) goto L91;
        int r31 = r30.getIntrinsicWidth();
        if (r31 != (-1)) goto L77;
        r31 = r29.getIntrinsicWidth();
    L77:
        int r32 = r30.getIntrinsicHeight();
        if (r32 != (-1)) goto L82;
        r32 = r29.getIntrinsicHeight();
    L82:
        if (r31 <= r29.getIntrinsicWidth()) goto L84;
    L86:
        float r33 = r31 / r32;
        if (r33 < (r29.getIntrinsicWidth() / r29.getIntrinsicHeight())) goto L89;
        int r34 = r29.getIntrinsicWidth();
        r32 = (int) (r34 / r33);
        r31 = r34;
    L90:
        LayerDrawable r35 = new LayerDrawable(new Drawable[]{r29, r30});
        r35.setLayerSize(1, r31, r32);
        r35.setLayerGravity(1, 17);
        r29 = r35;
        goto L91
    L89:
        r32 = r29.getIntrinsicHeight();
        r31 = (int) (r33 * r32);
        goto L90
    L84:
        if (r32 > r29.getIntrinsicHeight()) goto L86;
    L12:
        if (r13 == null) goto L16;
        r12 = r12.mutate();
        if (r14 == null) goto L16;
        b0.a.b.i(r12, r14);
        goto L16
    L5:
        if (r10 == null) goto L9;
        r8 = r8.mutate();
        if (r11 == null) goto L9;
        b0.a.b.i(r8, r11);
        goto L9
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.f4553v;
    }

    public Drawable getButtonIconDrawable() {
        return this.f4554w;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f4557z;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.A;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f4556y;
    }

    public int getCheckedState() {
        return this.B;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f4552u;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        if (this.B == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f4549r == true) goto L5;
        return;
    L5:
        if (this.f4556y == null) goto L7;
        return;
    L7:
        if (this.f4557z != null) goto L12;
        setUseMaterialThemeColors(true);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int r8) {
        int[] r10 = super.onCreateDrawableState(r8 + 2);
        if (getCheckedState() != 2) goto L6;
        CheckBox.mergeDrawableStates(r10, I);
    L6:
        if (this.f4551t == false) goto L8;
        CheckBox.mergeDrawableStates(r10, J);
    L8:
        int r11 = 0;
    L10:
        if (r11 >= r10.length) goto L17;
        int r12 = r10[r11];
        if (r12 == 16842912) goto L13;
        if (r12 == 0) goto L15;
        r11 = r11 + 1;
        goto L10
    L15:
        int[] r13 = (int[]) r10.clone();
        r13[r11] = 16842912;
    L18:
        this.C = r13;
        return r10;
    L13:
        r13 = r10;
        goto L18
    L17:
        r13 = Arrays.copyOf(r10, r10.length + 1);
        r13[r10.length] = 16842912;
        goto L18
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r8) {
        if (this.f4550s == true) goto L5;
    L16:
        super.onDraw(r8);
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == false) goto L16;
        Drawable r10 = androidx.core.widget.c.a(this);
        if (r10 == null) goto L16;
        if (q.a(this) == false) goto L11;
        int r11 = -1;
    L12:
        int r12 = ((getWidth() - r10.getIntrinsicWidth()) / 2) * r11;
        int r13 = r8.save();
        r8.translate(r12, 0.0f);
        super.onDraw(r8);
        r8.restoreToCount(r13);
        if (getBackground() == null) goto L18;
        Rect r14 = r10.getBounds();
        b0.a.b.f(getBackground(), r14.left + r12, r14.top, r14.right + r12, r14.bottom);
        return;
    L18:
        return;
    L11:
        r11 = 1;
        goto L12
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        if (r8 != null) goto L6;
        return;
    L6:
        if (this.f4551t == false) goto L9;
        r8.setText(r8.getText() + ", " + this.f4552u);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        if ((r8 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r8);
        return;
    L6:
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.getSuperState());
        setCheckedState(r10.f4558a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f4558a = getCheckedState();
        return r8;
    }

    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton
    public void setButtonDrawable(int r8) {
        setButtonDrawable(d.a.a(getContext(), r8));
    }

    public void setButtonIconDrawable(Drawable r8) {
        this.f4554w = r8;
        b();
    }

    public void setButtonIconDrawableResource(int r8) {
        setButtonIconDrawable(d.a.a(getContext(), r8));
    }

    public void setButtonIconTintList(ColorStateList r8) {
        if (this.f4557z != r8) goto L5;
        return;
    L5:
        this.f4557z = r8;
        b();
    }

    public void setButtonIconTintMode(PorterDuff.Mode r8) {
        if (this.A != r8) goto L5;
        return;
    L5:
        this.A = r8;
        b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList r8) {
        if (this.f4556y != r8) goto L5;
        return;
    L5:
        this.f4556y = r8;
        b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode r8) {
        setSupportButtonTintMode(r8);
        b();
    }

    public void setCenterIfNoTextEnabled(boolean r8) {
        this.f4550s = r8;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r8) {
        setCheckedState(r8 ? 1 : 0);
    }

    public void setCheckedState(int r8) {
        if (this.B == r8) goto L31;
        this.B = r8;
        if (r8 != 1) goto L7;
        boolean r10 = true;
    L8:
        super.setChecked(r10);
        refreshDrawableState();
        if (this.E != null) goto L12;
        super.setStateDescription(getButtonStateDescription());
    L12:
        if (this.D == false) goto L14;
        return;
    L14:
        this.D = true;
        LinkedHashSet<b> r11 = this.f4547p;
        if (r11 == null) goto L21;
        Iterator<b> r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L21;
        r12.next().a();
    L21:
        if (this.B == 2) goto L25;
        CompoundButton.OnCheckedChangeListener r13 = this.F;
        if (r13 == null) goto L25;
        r13.onCheckedChanged(this, isChecked());
    L25:
        AutofillManager r14 = (AutofillManager) getContext().getSystemService(AutofillManager.class);
        if (r14 == null) goto L28;
        r14.notifyValueChanged(this);
    L28:
        this.D = false;
        return;
    L7:
        r10 = false;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
    }

    public void setErrorAccessibilityLabel(CharSequence r8) {
        this.f4552u = r8;
    }

    public void setErrorAccessibilityLabelResource(int r8) {
        if (r8 == 0) goto L4;
        CharSequence r10 = getResources().getText(r8);
    L5:
        setErrorAccessibilityLabel(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setErrorShown(boolean r8) {
        if (this.f4551t != r8) goto L5;
        return;
    L5:
        this.f4551t = r8;
        refreshDrawableState();
        Iterator<c> r10 = this.f4546o.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r10.next().a();
        goto L7
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r8) {
        this.F = r8;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence r8) {
        this.E = r8;
        if (r8 != null) goto L6;
        if (r8 != null) goto L8;
        super.setStateDescription(getButtonStateDescription());
        return;
    L8:
        return;
    L6:
        super.setStateDescription(r8);
    }

    public void setUseMaterialThemeColors(boolean r8) {
        this.f4549r = r8;
        if (r8 == false) goto L6;
        ColorStateList r10 = getMaterialThemeColorsTintList();
    L5:
        androidx.core.widget.b.c(this, r10);
        return;
    L6:
        r10 = null;
        goto L5
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton
    public void setButtonDrawable(Drawable r8) {
        this.f4553v = r8;
        this.f4555x = false;
        b();
    }
}
