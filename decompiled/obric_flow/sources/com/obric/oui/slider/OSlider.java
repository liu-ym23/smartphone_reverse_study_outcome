package com.obric.oui.slider;

import ai.j0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u000b2\b\b\u0001\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u000b2\b\b\u0001\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\rJ\u0017\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\rJ\u0015\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b \u0010\u001fJ\u0015\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b%\u0010$J\r\u0010&\u001a\u00020!¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020!¢\u0006\u0004\b(\u0010'J\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\rJ\u0015\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020!¢\u0006\u0004\b+\u0010$J\r\u0010,\u001a\u00020!¢\u0006\u0004\b,\u0010'J\r\u0010-\u001a\u00020!¢\u0006\u0004\b-\u0010'J\u0017\u00100\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u0015\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u00020!¢\u0006\u0004\b3\u0010$J\u0015\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u000b2\u0006\u00108\u001a\u000204H\u0016¢\u0006\u0004\b9\u00107J\r\u0010;\u001a\u00020:¢\u0006\u0004\b;\u0010<J\u0017\u0010>\u001a\u00020\u000b2\u0006\u0010=\u001a\u000204H\u0016¢\u0006\u0004\b>\u00107R$\u0010D\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010\u001fR$\u0010H\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010@\u001a\u0004\bF\u0010B\"\u0004\bG\u0010\u001f¨\u0006I"}, d2 = {"Lcom/obric/oui/slider/OSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "thumbColor", "", "setThumbColorInt", "(I)V", "thumbColorResId", "setThumbColor", "backgroundColor", "setProcessBackgroundColorInt", "progressColor", "setProcessProgressColorInt", "backgroundColorResId", "setProcessBackgroundColor", "progressColorResId", "setProcessProgressColor", "tickColor", "setTickColorInt", "tickColorResId", "setTickColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setLeftIcon", "(Landroid/graphics/drawable/Drawable;)V", "setRightIcon", "", "value", "setMinValue", "(F)V", "setMaxValue", "getMinValue", "()F", "getMaxValue", "setTickMarkCount", "process", "setProgress", "getProgress", "getRealProgress", "Lcom/obric/oui/slider/b;", "listener", "setOnSeekBarChangeListenerExt", "(Lcom/obric/oui/slider/b;)V", "seekBarHeight", "setSeekBarHeight", "", "isStyleSegmented", "setIsSegmented", "(Z)V", "enabled", "setEnabled", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "hapticFeedbackEnabled", "setHapticFeedbackEnabled", "n", "Landroid/graphics/drawable/Drawable;", "getLeftImage", "()Landroid/graphics/drawable/Drawable;", "setLeftImage", "leftImage", "o", "getRightImage", "setRightImage", "rightImage", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class OSlider extends ConstraintLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f14520p = 0;
    public final SeekBarFloatCompat g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f14521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f14522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f14524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f14525l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14526m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f14527n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f14528o;

    @JvmOverloads
    public OSlider(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final float e(float r5) {
        float r10 = this.f14523j;
        return Float.parseFloat(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(j0.b(this.f14524k, r10, (r5 - 0.0f) / 100.0f, r10))}, 1)));
    }

    public final Drawable getLeftImage() {
        return this.f14527n;
    }

    public final float getMaxValue() {
        return e(this.g.getMaxValue());
    }

    public final float getMinValue() {
        return e(this.g.getMinValue());
    }

    public final float getProgress() {
        return this.g.getFloatProgress();
    }

    public final float getRealProgress() {
        return e(this.g.getFloatProgress());
    }

    public final Drawable getRightImage() {
        return this.f14528o;
    }

    public final SeekBar getSeekBar() {
        return this.g;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.f14526m = com.lynx.tasm.utils.a.B(32, this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, View.MeasureSpec.makeMeasureSpec(this.f14526m, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        return super.onTouchEvent(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        this.g.setEnabled(r5);
        this.f14521h.setEnabled(r5);
        if (r5 == false) goto L5;
        float r10 = 1.0f;
    L6:
        setAlpha(r10);
        return;
    L5:
        r10 = 0.5f;
        goto L6
    }

    @Override // android.view.View
    public void setHapticFeedbackEnabled(boolean r5) {
        super.setHapticFeedbackEnabled(r5);
        this.g.setHapticFeedbackEnabled(r5);
    }

    public final void setIsSegmented(boolean r5) {
        SeekBarFloatCompat r10 = this.g;
        r10.f14550y = r5;
        if (r5 == false) goto L5;
        r10.setProgressDrawable(null);
        r10.f14531a = 0;
        r10.setProgress(r10.o(0));
    L6:
        r10.d();
        r10.invalidate();
        return;
    L5:
        r10.f14531a = -1;
        goto L6
    }

    public final void setLeftIcon(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        this.f14521h.setImageDrawable(r5);
    }

    public final void setLeftImage(Drawable r5) {
        this.f14527n = r5;
    }

    public final void setMaxValue(float r5) {
        Log.d("OSlider", Intrinsics.stringPlus("setMaxValue >>> ", Float.valueOf(r5)));
        this.f14524k = r5;
        SeekBarFloatCompat r10 = this.g;
        r10.setMinValue(0.0f);
        r10.setMaxValue(100.0f);
    }

    public final void setMinValue(float r5) {
        Log.d("OSlider", Intrinsics.stringPlus("setMinValue >>> ", Float.valueOf(r5)));
        this.f14523j = r5;
        SeekBarFloatCompat r10 = this.g;
        r10.setMinValue(0.0f);
        r10.setMaxValue(100.0f);
    }

    public final void setOnSeekBarChangeListenerExt(b r5) {
        this.f14525l = r5;
    }

    public final void setProcessBackgroundColor(@ColorRes int r5) {
        this.g.setProcessBackgroundColor(r5);
    }

    public final void setProcessBackgroundColorInt(@ColorInt int r5) {
        this.g.setProcessBackgroundColorInt(r5);
    }

    public final void setProcessProgressColor(@ColorRes int r5) {
        this.g.setProcessProgressColor(r5);
    }

    public final void setProcessProgressColorInt(@ColorInt int r5) {
        this.g.setProcessProgressColorInt(r5);
    }

    public final void setProgress(float r5) {
        float r10 = this.f14523j;
        float r11 = (((r5 - r10) / (this.f14524k - r10)) * 100.0f) + 0.0f;
        this.g.setProgress(r11);
    }

    public final void setRightIcon(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        this.f14522i.setImageDrawable(r5);
    }

    public final void setRightImage(Drawable r5) {
        this.f14528o = r5;
    }

    public final void setSeekBarHeight(float r5) {
        this.g.setBackgroundHeight(r5);
    }

    public final void setThumbColor(@ColorRes int r5) {
        this.g.setThumbColor(r5);
    }

    public final void setThumbColorInt(@ColorInt int r5) {
        this.g.setThumbColorInt(r5);
    }

    public final void setTickColor(@ColorRes int r5) {
        this.g.setTickColor(r5);
    }

    public final void setTickColorInt(@ColorInt int r5) {
        this.g.setTickColorInt(r5);
    }

    public final void setTickMarkCount(int r5) {
        this.g.setDefaultTickMarkCount(r5);
    }

    @JvmOverloads
    public OSlider(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSlider(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OSlider(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14524k = 100.0f;
        com.lynx.tasm.utils.a.B(6, this);
        this.f14526m = com.lynx.tasm.utils.a.B(32, this);
        TypedArray r12 = r5.getTheme().obtainStyledAttributes(r10, R$styleable.OSlider, r11, 0);
        float r13 = r12.getDimensionPixelSize(R$styleable.OSlider_sliderHeight, com.lynx.tasm.utils.a.B(6, this));
        setLeftImage(r12.getDrawable(R$styleable.OSlider_oui_slider_left_icon));
        setRightImage(r12.getDrawable(R$styleable.OSlider_oui_slider_right_icon));
        LayoutInflater.from(r5).inflate(R$layout.o_slider, this);
        SeekBarFloatCompat r14 = (SeekBarFloatCompat) findViewById(R$id.seekBar);
        this.g = r14;
        r14.setBackgroundHeight(r13);
        ImageView r15 = (ImageView) findViewById(R$id.tvLeftIcon);
        this.f14521h = r15;
        if (this.f14527n == null) goto L5;
        r15.setVisibility(0);
        r15.setImageDrawable(this.f14527n);
    L5:
        ImageView r16 = (ImageView) findViewById(R$id.tvRightIcon);
        this.f14522i = r16;
        Drawable r17 = this.f14528o;
        if (r17 == null) goto L8;
        r16.setImageDrawable(r17);
        r16.setVisibility(0);
    L8:
        r14.setOnSeekBarChangeListenerExt(new we.a(this));
        r14.setHapticFeedbackEnabled(isHapticFeedbackEnabled());
    }
}
