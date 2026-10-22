package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.obric.cae.R;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class e extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f1117b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l f1118m;

    public e(Context r8, AttributeSet r10) {
        this(r8, r10, R.attr.buttonStyle);
    }

    private l getEmojiTextViewHelper() {
        if (this.f1118m != null) goto L6;
        this.f1118m = new l(this);
    L6:
        return this.f1118m;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d r8 = this.f1116a;
        if (r8 == null) goto L5;
        r8.a();
    L5:
        w r10 = this.f1117b;
        if (r10 == null) goto L9;
        r10.b();
        return;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        Method r8 = b1.f1104a;
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        Method r8 = b1.f1104a;
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        Method r8 = b1.f1104a;
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        Method r8 = b1.f1104a;
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        Method r8 = b1.f1104a;
        if (super.getAutoSizeTextType() == 1) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback r8 = super.getCustomSelectionActionModeCallback();
        if ((r8 instanceof androidx.core.widget.o) == false) goto L6;
        ((androidx.core.widget.o) r8).getClass();
        return null;
    L6:
        return r8;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d r8 = this.f1116a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f1116a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1117b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1117b.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r8) {
        super.onInitializeAccessibilityEvent(r8);
        r8.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        r8.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        w r14 = this.f1117b;
        if (r14 == null) goto L6;
        r14.getClass();
        Method r15 = b1.f1104a;
        return;
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
        super.onTextChanged(r8, r10, r11, r12);
        if (this.f1117b == null) goto L6;
        Method r13 = b1.f1104a;
        return;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean r8) {
        super.setAllCaps(r8);
        getEmojiTextViewHelper().b(r8);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int r8, int r10, int r11, int r12) {
        Method r13 = b1.f1104a;
        super.setAutoSizeTextTypeUniformWithConfiguration(r8, r10, r11, r12);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] r8, int r10) {
        Method r11 = b1.f1104a;
        super.setAutoSizeTextTypeUniformWithPresetSizes(r8, r10);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int r8) {
        Method r10 = b1.f1104a;
        super.setAutoSizeTextTypeWithDefaults(r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f1116a;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f1116a;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r8) {
        super.setCustomSelectionActionModeCallback(r8);
    }

    public void setEmojiCompatEnabled(boolean r8) {
        getEmojiTextViewHelper().c(r8);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r8) {
        super.setFilters(getEmojiTextViewHelper().f1207b.f10113a.a(r8));
    }

    public void setSupportAllCaps(boolean r8) {
        w r10 = this.f1117b;
        if (r10 == null) goto L6;
        r10.f1277a.setAllCaps(r8);
        return;
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        d r10 = this.f1116a;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f1116a;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList r8) {
        w r10 = this.f1117b;
        r10.h(r8);
        r10.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r8) {
        w r10 = this.f1117b;
        r10.i(r8);
        r10.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context r8, int r10) {
        super.setTextAppearance(r8, r10);
        w r11 = this.f1117b;
        if (r11 == null) goto L6;
        r11.g(r8, r10);
        return;
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r8, float r10) {
        Method r11 = b1.f1104a;
        super.setTextSize(r8, r10);
    }

    public e(Context r8, AttributeSet r10, int r11) {
        s0.a(r8);
        super(r8, r10, r11);
        q0.a(this, getContext());
        d r12 = new d(this);
        this.f1116a = r12;
        r12.d(r10, r11);
        w r13 = new w(this);
        this.f1117b = r13;
        r13.f(r10, r11);
        r13.b();
        getEmojiTextViewHelper().a(r10, r11);
    }
}
