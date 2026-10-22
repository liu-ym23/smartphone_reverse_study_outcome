package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.bytedance.ai.ex.widget.WidgetView;
import com.lynx.tasm.utils.a;
import com.lynx.tasm.utils.d;
import com.lynx.tasm.utils.g;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zq.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001d\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001e\u0010\u001fR0\u0010(\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\b!\u0010\"\u0012\u0004\b&\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0010¨\u0006)"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "", "setPrimaryColor", "(I)V", "", WidgetView.UI_MODE_LIGHT, "setAlwaysLight", "(Z)V", "enableExpand", "setEnableExpandTouchRect", "checked", "setChecked", "Lzq/b;", "listener", "setOnCheckedStateChangedListener", "(Lzq/b;)V", "Lzq/a;", "setOnCheckedChangeListener", "(Lzq/a;)V", "value", "d", "I", "getCheckedState", "()I", "setCheckedState", "getCheckedState$annotations", "()V", "checkedState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCheckBox extends AppCompatImageView implements Checkable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f12304m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f12305n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f12306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12308c;
    public int d;
    public boolean e;
    public boolean f;
    public ColorMatrixColorFilter g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuffColorFilter f12309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f12313l;

    static {
        f12304m = new int[]{R.attr.state_checked};
        f12305n = new int[]{R$attr.oui_state_indeterminate};
    }

    public OCheckBox(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f12308c = a.B(18, this);
        this.f12310i = -1;
        this.f12311j = -1;
        this.f12312k = -1;
        this.f12313l = true;
        n(r5, null, R$attr.OCheckBoxStyle);
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    public final void e() {
        int r5 = this.f12311j;
        if (r5 == (-1)) goto L6;
        this.g = new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r5), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r5), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r5), 0.0f, 0.0f, 0.0f, (Color.alpha(r5) * 1.0f) / 255, 0.0f});
    L6:
        if (this.f12312k == (-1)) goto L9;
        this.f12309h = new PorterDuffColorFilter(this.f12312k, PorterDuff.Mode.SRC_IN);
        return;
    }

    public final int getCheckedState() {
        return this.d;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        if (this.d == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void n(Context r5, AttributeSet r10, int r11) {
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.OCheckBox, r11, 0);
        this.f12307b = r12.getInt(R$styleable.OCheckBox_oui_checkBoxColorStyle, 0);
        this.f12313l = r12.getBoolean(R$styleable.ORadio_oui_adapt_for_csr, true);
        this.f12310i = r12.getColor(R$styleable.OCheckBox_oui_checkBoxPrimaryColor, -1);
        this.f12311j = r12.getColor(R$styleable.OCheckBox_oui_checkBoxCheckedColor, -1);
        this.f12312k = r12.getColor(R$styleable.OCheckBox_oui_checkBoxUncheckedColor, -1);
        Drawable r13 = r12.getDrawable(R$styleable.OCheckBox_oui_checkBoxButton);
        if (r13 != null) goto L5;
        r13 = null;
    L5:
        this.f12306a = r13;
        this.f = r12.getBoolean(R$styleable.OCheckBox_oui_checkBoxAlwaysLight, false);
        if (r12.hasValue(R$styleable.OCheckBox_oui_checkedState) == false) goto L8;
        setCheckedState(r12.getInt(R$styleable.OCheckBox_oui_checkedState, 0));
    L8:
        r12.recycle();
        e();
        Drawable r14 = this.f12306a;
        if (r14 != null) goto L11;
        p();
    L12:
        setBackground(null);
        o();
        setClickable(true);
        return;
    L11:
        setImageDrawable(r14);
        goto L12
    }

    public final void o() {
        Drawable r5 = getDrawable();
        if (r5 == null) goto L6;
        r5.clearColorFilter();
    L6:
        e();
        Drawable r10 = getDrawable();
        if (r10 != null) goto L10;
        return;
    L10:
        if (isChecked() == false) goto L12;
        ColorFilter r11 = this.g;
    L13:
        r10.setColorFilter(r11);
        return;
    L12:
        r11 = this.f12309h;
        goto L13
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f12313l == false) goto L6;
        d.n(a.B(44, this), this);
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int r5) {
        int[] r10 = super.onCreateDrawableState(r5 + 2);
        if (this.d != 2) goto L6;
        View.mergeDrawableStates(r10, f12305n);
    L6:
        if (isChecked() == false) goto L8;
        View.mergeDrawableStates(r10, f12304m);
    L8:
        return r10;
    }

    @Override // android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r5, int r10) {
        int r11 = View.MeasureSpec.makeMeasureSpec(this.f12308c, BasicMeasure.EXACTLY);
        super.onMeasure(r11, r11);
    }

    public final void p() {
        boolean r5 = this.f;
        if (r5 == false) goto L5;
        Drawable r10 = getResources().getDrawable(R$drawable.o_checkbox_circle_always_light, null);
    L11:
        this.f12306a = r10;
        int r11 = this.f12310i;
        if (r11 != (-1)) goto L14;
    L35:
        setImageDrawable(this.f12306a);
        return;
    L14:
        if ((r10 instanceof StateListDrawable) == false) goto L35;
        if (r10 == null) goto L34;
        StateListDrawable r12 = (StateListDrawable) r10;
        Intrinsics.checkNotNullParameter(r12, "drawable");
        Intrinsics.checkNotNullParameter("primary_shape", "pathName");
        int r13 = r12.getStateCount();
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L35;
        int r15 = r14 + 1;
        Drawable r16 = r12.getStateDrawable(r14);
        if ((r16 instanceof VectorDrawable) == false) goto L26;
        VectorDrawable r17 = (VectorDrawable) r16;
        z5.a.p(r17, r11);     // Catch: Exception -> L23
        r17.invalidateSelf();     // Catch: Exception -> L23
    L32:
        r14 = r15;
    L23:
        e = move-exception;
        Log.e("VectorBreaker", "Color injection failed", e);
        goto L32
    L26:
        if ((r16 instanceof AnimatedVectorDrawable) == false) goto L32;
        AnimatedVectorDrawable r18 = (AnimatedVectorDrawable) r16;
        z5.a.q(r18, r11);     // Catch: Exception -> L30
        r18.invalidateSelf();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        Log.e("VectorBreaker", "setPathColor2, Color injection failed", e);
        goto L32
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
    L5:
        if (r5 == false) goto L7;
        r10 = getResources().getDrawable(R$drawable.o_checkbox_circle, null);
        goto L11
    L7:
        if (this.f12307b != 1) goto L9;
        r10 = getResources().getDrawable(R$drawable.o_checkbox_circle_on_image, null);
        goto L11
    L9:
        r10 = getResources().getDrawable(R$drawable.o_checkbox_circle, null);
        goto L11
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        boolean r5 = super.performClick();
        if (r5 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        g.p(1, getContext());
    L8:
        return r5;
    }

    public final void setAlwaysLight(boolean r5) {
        this.f = r5;
        p();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r5) {
        setCheckedState(r5 ? 1 : 0);
    }

    public final void setCheckedState(int r5) {
        if (this.d == r5) goto L9;
        this.d = r5;
        o();
        refreshDrawableState();
        if (this.e == false) goto L7;
        return;
    L7:
        this.e = false;
        return;
    }

    public final void setEnableExpandTouchRect(boolean r5) {
        this.f12313l = r5;
    }

    public final void setOnCheckedChangeListener(zq.a r5) {
    }

    public final void setOnCheckedStateChangedListener(b r5) {
    }

    public final void setPrimaryColor(@ColorInt int r5) {
        this.f12310i = r5;
        p();
        invalidate();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    public OCheckBox(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        super(r5, r10);
        this.f12308c = a.B(18, this);
        this.f12310i = -1;
        this.f12311j = -1;
        this.f12312k = -1;
        this.f12313l = true;
        n(r5, r10, R$attr.OCheckBoxStyle);
    }

    public OCheckBox(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "attrs");
        super(r5, r10, r11);
        this.f12308c = a.B(18, this);
        this.f12310i = -1;
        this.f12311j = -1;
        this.f12312k = -1;
        this.f12313l = true;
        n(r5, r10, r11);
    }
}
