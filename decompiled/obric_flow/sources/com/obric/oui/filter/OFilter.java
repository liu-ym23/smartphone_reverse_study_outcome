package com.obric.oui.filter;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.o;
import com.obric.oui.filterpanel.OFilterGroupView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import or.a;
import ym.d;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/filter/OFilter;", "Lcom/obric/oui/filter/DrawableCenterButton;", "", "selected", "", "setSelected", "(Z)V", "", "getStyle", "()I", "isAlwaysLight", "setAlwaysLight", "getIsAlwaysLight", "()Z", "enabled", "setEnabled", "Lor/a;", "listener", "setSelectChangeListener", "(Lor/a;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OFilter extends DrawableCenterButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13200c;
    public final int d;
    public int e;
    public Drawable f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f13201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f13203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f13204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f13205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f13206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f13207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RectF f13208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f13210q;

    @JvmOverloads
    public OFilter(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0, false, 14);
    }

    public final void a() {
        if (isEnabled() == true) goto L6;
        return;
    L6:
        if (this.e != 1) goto L8;
        setMinHeight(com.lynx.tasm.utils.a.B(36, this));
    L10:
        if (isSelected() == false) goto L19;
        if (this.f13201h == false) goto L15;
        int r5 = R$color.primary;
        int r10 = R$color.BGBrand;
        this.f13202i = r5;
        setTypeface(null, 1);
    L25:
        this.f13205l.setColor(ContextCompat.getColor(getContext(), r10));
        this.f13206m.setColor(ContextCompat.getColor(getContext(), r5));
        setTextColor(ContextCompat.getColor(getContext(), this.f13202i));
        if (this.g == true) goto L28;
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        int r11 = this.f13198a;
        int r12 = this.f13199b;
        setPadding(r11, r12, r11, r12);
        setGravity(17);
        return;
    L28:
        if (this.f != null) goto L34;
        Drawable r13 = ContextCompat.getDrawable(getContext(), R$drawable.o_arrow_forward_filter);
        if (r13 != null) goto L32;
        Drawable r14 = null;
    L33:
        this.f = r14;
        goto L34
    L32:
        r14 = r13.mutate();
    L34:
        Drawable r15 = this.f;
        Intrinsics.checkNotNull(r15);
        Drawable r16 = DrawableCompat.wrap(r15);
        DrawableCompat.setTintMode(r16, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(r16, ContextCompat.getColor(getContext(), this.f13202i));
        r16.setBounds(0, 0, r16.getIntrinsicWidth(), r16.getIntrinsicHeight());
        setGravity(8388629);
        setCompoundDrawablesWithIntrinsicBounds(null, null, r16, null);
        int r17 = this.f13200c;
        int r18 = this.d;
        setPadding(r17, r18, r17, r18);
        return;
    L15:
        if (this.e != 1) goto L17;
        r5 = R$color.primary;
        this.f13202i = r5;
        r10 = R$color.Transparent;
        setTypeface(null, 1);
        goto L25
    L17:
        r5 = R$color.BGInput;
        this.f13202i = R$color.TextPrimary;
        setTypeface(null, 1);
        r10 = r5;
        goto L25
    L19:
        if (this.f13201h == false) goto L22;
        r5 = R$color.LineReverse2;
        this.f13202i = R$color.TextReverse;
        r10 = R$color.Transparent;
        setTypeface(null, 0);
        goto L25
    L22:
        if (this.e != 1) goto L24;
        r5 = R$color.oui_basic_text_2;
        this.f13202i = r5;
        r10 = R$color.Transparent;
        setTypeface(null, 0);
        goto L25
    L24:
        r5 = R$color.oui_basic_text_2;
        this.f13202i = r5;
        r10 = R$color.oui_basic_text_4;
        setTypeface(null, 0);
        goto L25
    L8:
        setMinHeight(-1);
        goto L10
    }

    public final boolean getIsAlwaysLight() {
        return this.f13201h;
    }

    public final int getStyle() {
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.f13209p = com.lynx.tasm.utils.a.B(4, this);
        this.f13210q = com.lynx.tasm.utils.a.B(8, this);
        invalidate();
    }

    @Override // com.obric.oui.filter.DrawableCenterButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        r10.save();
        r10.translate(getScrollX() * 1.0f, getScrollY() * 1.0f);
        if (this.e != 0) goto L5;
        float r5 = this.f13209p;
    L6:
        RectF r11 = this.f13207n;
        r11.set(0.0f, 0.0f, getWidth(), getHeight());
        o.e(r10, r11, r5, this.f13205l);
        if (this.e != 1) goto L9;
        float r12 = this.f13204k * 0.5f;
        RectF r13 = this.f13208o;
        r13.set(r12, r12, getWidth() - r12, getHeight() - r12);
        o.e(r10, r13, r5, this.f13206m);
    L9:
        r10.restore();
        super.onDraw(r10);
        return;
    L5:
        r5 = this.f13210q;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    public final void setAlwaysLight(boolean r5) {
        this.f13201h = r5;
        a();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        if (r5 == false) goto L5;
        setAlpha(1.0f);
        a();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setSelectChangeListener(a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.f13203j = r5;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        a();
        a r10 = this.f13203j;
        if (r10 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "filter");
        OFilterGroupView r11 = (OFilterGroupView) ((d) r10).f23297a;
        if (r5 == false) goto L8;
        int r12 = OFilterGroupView.f13211r;
        r11.getClass();
        return;
    L8:
        int r13 = OFilterGroupView.f13211r;
        r11.getClass();
        return;
    }

    @JvmOverloads
    public OFilter(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, false, 12);
    }

    @JvmOverloads
    public OFilter(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, false, 8);
    }

    public OFilter(Context r10, AttributeSet r11, int r12, boolean r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = false;
    L11:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f13198a = com.lynx.tasm.utils.a.B(12, this);
        this.f13199b = com.lynx.tasm.utils.a.B(5, this);
        this.f13200c = com.lynx.tasm.utils.a.B(16, this);
        this.d = com.lynx.tasm.utils.a.B(7, this);
        float r15 = com.lynx.tasm.utils.a.C(this, 0.5d);
        this.f13204k = r15;
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.FILL);
        this.f13205l = r5;
        Paint r16 = new Paint(1);
        r16.setStyle(Paint.Style.STROKE);
        r16.setStrokeWidth(r15);
        this.f13206m = r16;
        this.f13207n = new RectF();
        this.f13208o = new RectF();
        this.f13209p = com.lynx.tasm.utils.a.B(4, this);
        this.f13210q = com.lynx.tasm.utils.a.B(8, this);
        TypedArray r17 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OFilter, r12, 0);
        this.e = r17.getInt(R$styleable.OFilter_oui_filterStyle, 0);     // Catch: Throwable -> L15
        this.g = r17.getBoolean(R$styleable.OFilter_showIcon, false);     // Catch: Throwable -> L15
        this.f13201h = r17.getBoolean(R$styleable.OFilter_oui_isAlwaysLight, r13);     // Catch: Throwable -> L15
        r17.recycle();
        setSingleLine();
        setTextSize(0, r10.getResources().getDimension(R$dimen.oui_filter_text_size));
        setCompoundDrawablePadding(r10.getResources().getDimensionPixelSize(R$dimen.oui_filter_drawable_padding));
        setGravity(17);
        a();
        return;
    L15:
        th = move-exception;
        r17.recycle();
        throw th;
    }
}
