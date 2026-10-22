package com.larksuite.component.ui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import j08.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000212B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0016H\u0014J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u000eH\u0016J\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000eJ\u0010\u0010*\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\u0014J\b\u0010,\u001a\u00020\u000bH\u0003J\b\u0010-\u001a\u00020\u000bH\u0003J\b\u0010.\u001a\u00020\u000bH\u0003J\u0012\u0010/\u001a\u00020\u00122\b\b\u0001\u00100\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larksuite/component/ui/button/LKUICheckBox2;", "Landroid/view/View;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIsRadio", "", "mIsChecked", "mDrawableSize", "mCurrDrawable", "Landroid/graphics/drawable/Drawable;", "mOnCheckedChangeListener", "Lcom/larksuite/component/ui/button/LKUICheckBox2$OnCheckedChangeListener;", "init", "", "setupAttrs", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setupCurrDrawable", "doDrawCheckBox", "drawable", "drawableStateChanged", "isChecked", "toggle", "setChecked", "checked", "performClick", "isRadio", "setRadio", "value", "setOnCheckedChangeListener", "listener", "getCheckBoxDrawableRes", "getRadioButtonDrawableRes", "getDrawableRes", "getDrawable", "resId", "Companion", "OnCheckedChangeListener", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class LKUICheckBox2 extends View implements Checkable {
    public static final SparseArray<Drawable> f = null;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 0;
    public boolean a;
    public boolean b;
    public int c;
    public Drawable d;
    public b e;

    public static final class a {
    }

    public interface b {
        void a(LKUICheckBox2 r1, boolean r2);
    }

    static {
        f = new SparseArray();
        g = 2131243838;
        h = 2131243839;
        i = 2131243836;
        j = 2131243837;
        k = 2131243855;
        l = 2131243856;
        m = 2131243853;
        n = 2131243854;
    }

    private final int getDrawableRes() {
        if (this.a == false) goto L6;
        return getRadioButtonDrawableRes();
    L6:
        return getCheckBoxDrawableRes();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.b);
    }

    private final int getCheckBoxDrawableRes() {
        if (isEnabled() == false) goto L9;
        if (this.b == false) goto L14;
        return g;
    L14:
        return h;
    L9:
        if (this.b == false) goto L12;
        return i;
    L12:
        return j;
    }

    private final int getRadioButtonDrawableRes() {
        if (isEnabled() == false) goto L9;
        if (this.b == false) goto L14;
        return k;
    L14:
        return l;
    L9:
        if (this.b == false) goto L12;
        return m;
    L12:
        return n;
    }

    public final void b() {
        int r0 = getDrawableRes();
        SparseArray<Drawable> r1 = f;
        Drawable r2 = r1.get(r0);
        if (r2 != null) goto L5;
        r2 = d.b(getContext(), r0);
        r1.put(r0, r2);
    L5:
        this.d = r2;
        invalidate();
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        b();
        invalidate();
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.b;
    }

    public LKUICheckBox2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    private final void setupAttrs(AttributeSet r4) {
        setClickable(r4.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "clickable", true));
        setChecked(r4.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "checked", this.b));
        setEnabled(r4.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "enabled", isEnabled()));
    }

    public final void a(AttributeSet r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        setupAttrs(r5);
        TypedArray r6 = getContext().obtainStyledAttributes(r5, new int[]{2130970387});
        this.a = r6.getBoolean(0, this.a);
        r6.recycle();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (this.d != null) goto L5;
        b();
    L5:
        Drawable r0 = this.d;
        if (r0 == null) goto L9;
        r0.setBounds(new Rect(getPaddingLeft(), getPaddingTop(), this.c + getPaddingLeft(), this.c + getPaddingTop()));
        r0.draw(r8);
        r8.save();
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.b != r2) goto L5;
        return;
    L5:
        this.b = r2;
        b r0 = this.e;
        if (r0 == null) goto L8;
        r0.a(this, r2);
    L8:
        refreshDrawableState();
    }

    public final void setOnCheckedChangeListener(b r1) {
        this.e = r1;
    }

    public final void setRadio(boolean r2) {
        if (this.a != r2) goto L5;
        return;
    L5:
        this.a = r2;
        b();
    }

    public LKUICheckBox2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a(r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L10;
        int r1 = (int) j08.b.a(getContext(), 18.0f);
        if (r0.width != (-2)) goto L8;
        r6 = View.MeasureSpec.makeMeasureSpec((getPaddingLeft() + r1) + getPaddingRight(), 1073741824);
    L8:
        if (r0.height != (-2)) goto L10;
        r7 = View.MeasureSpec.makeMeasureSpec((r1 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L10:
        this.c = Math.min((View.MeasureSpec.getSize(r6) - getPaddingLeft()) - getPaddingRight(), (View.MeasureSpec.getSize(r7) - getPaddingTop()) - getPaddingBottom());
        super.onMeasure(r6, r7);
    }

    public LKUICheckBox2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a(r3);
    }
}
