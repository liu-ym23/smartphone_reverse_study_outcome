package com.obric.oui.slider;

import ac.n;
import ac.o;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.t;
import com.obric.cae.R;
import defpackage.c;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public class a extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f6538b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f6539m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f6540n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f6541o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6542p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6543q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6544r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f6545s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f6546t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f6547u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Path f6548v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final tc.b f6549w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final n f6550x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6551y;

    /* JADX INFO: renamed from: com.obric.oui.slider.a$a, reason: collision with other inner class name */
    public interface InterfaceC0057a {
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f6552a;

        public b(a r8) {
            this.f6552a = r8;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r8, int r10, boolean r11) {
            i.f(r8, "seekBar");
            a r12 = this.f6552a;
            if (r12.isHapticFeedbackEnabled() == false) goto L16;
            Context r13 = r12.getContext();
            i.e(r13, "context");
            tc.b r14 = r12.f6549w;
            r14.getClass();
            if (r11 == false) goto L7;
            r14.f12369a = 0;
        L7:
            int r15 = r8.getMin();
            int r16 = r8.getMax();
            if (r10 != r15) goto L10;
            int r17 = 5;
            String r18 = "hit minProgress";
        L13:
            if (r14.f12369a >= 2) goto L18;
            zc.b.a("SeekBarVibrateHelper", "vibrateIfNeeded: ".concat(r18));
            c.o0(r13, r17);
            r14.f12369a++;
            return;
        L18:
            return;
        L10:
            if (r10 != r16) goto L17;
            r17 = 4;
            r18 = "hit maxProgress";
            goto L13
        L17:
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r8) {
            a r10 = this.f6552a;
            r10.getClass();
            r10.getClass();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r8) {
            a r10 = this.f6552a;
            r10.getClass();
            r10.getClass();
        }
    }

    public a(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    private final void drawThumb(Canvas r8) {
        if (this.f6544r != 0) goto L5;
        return;
    L5:
        r8.save();
        if (this.f6551y == false) goto L8;
        float r10 = this.f6541o;
    L9:
        float r11 = a();
        Paint r12 = this.f6545s;
        r12.setColor(this.f6544r);
        RectF r13 = this.f6547u;
        float r14 = r10 / 2.0f;
        float r15 = this.f6539m;
        r13.set(r11 - r14, r15 - r14, r11 + r14, r15 + r14);
        r8.drawRoundRect(r13, r14, r14, r12);
        r8.restore();
        r8.save();
        n r16 = this.f6550x;
        i.f(r16, "shadow");
        float r17 = 0;
        float r18 = r16.f340g;
        if (r18 <= r17) goto L12;
        r14 = r18;
    L12:
        Path r19 = new Path();
        r19.addPath(o.b(r14, r13));
        int r20 = r8.save();
        RectF r21 = new RectF(r13);
        r21.offset(r16.f336c, r16.f337d);
        float r22 = -r16.f338e;
        r21.inset(r22, r22);
        r8.clipOutPath(r19);
        int r23 = r16.f334a;
        Paint r24 = r16.f339f;
        r24.setColor(r23);
        if (r16.f335b <= r17) goto L15;
        r24.setMaskFilter(new BlurMaskFilter(r16.f335b, BlurMaskFilter.Blur.NORMAL));
    L15:
        o.e(r8, r21, r14, r24);
        r8.restoreToCount(r20);
        r8.restore();
        return;
    L8:
        r10 = this.f6540n;
        goto L9
    }

    public final float a() {
        float r8 = getWidth();
        float r10 = this.f6540n;
        return (((getProgress() * 1.0f) / getMax()) * (r8 - r10)) + (r10 / 2.0f);
    }

    @SuppressLint({"UseKtx"})
    public final void b(Canvas r12) {
        int r8 = r12.save();
        if (getProgressDrawable() == null) goto L5;
        Drawable r10 = getProgressDrawable();
        i.e(r10, "progressDrawable");
        r12.translate(0.0f, getPaddingTop());
        r10.setBounds(new Rect(0, (getMeasuredHeight() / 2) - (r10.getIntrinsicHeight() / 2), getMeasuredWidth(), (r10.getIntrinsicHeight() / 2) + (getMeasuredHeight() / 2)));
        r10.draw(r12);
    L10:
        r12.restoreToCount(r8);
        return;
    L5:
        float r11 = this.f6538b / 2;
        float r13 = a();
        if (this.f6551y == false) goto L8;
        float r14 = this.f6541o;
    L9:
        RectF r15 = this.f6547u;
        float r16 = this.f6539m;
        r15.set(0.0f, r16 - r11, r13, r16 + r11);
        Path r17 = this.f6548v;
        r17.reset();
        r17.addRoundRect(r15, new float[]{r11, r11, 0.0f, 0.0f, 0.0f, 0.0f, r11, r11}, Path.Direction.CW);
        Paint r18 = this.f6545s;
        r18.setColor(this.f6543q);
        Path r19 = this.f6546t;
        r19.reset();
        r19.addCircle(r13, r16, r14 / 2.0f, Path.Direction.CW);
        r12.clipOutPath(r19);
        r12.drawPath(r17, r18);
        goto L10
    L8:
        r14 = this.f6540n;
        goto L9
    }

    public final void drawBackground(Canvas r8) {
        r8.save();
        float r10 = this.f6538b / 2;
        a();
        RectF r11 = this.f6547u;
        float r12 = this.f6539m;
        r11.set(0.0f, r12 - r10, getWidth(), r12 + r10);
        Path r13 = this.f6546t;
        r13.reset();
        r13.addRoundRect(r11, r10, r10, Path.Direction.CW);
        Paint r14 = this.f6545s;
        r14.setColor(this.f6542p);
        r8.drawPath(r13, r14);
        r8.restore();
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r8) {
        i.f(r8, "dr");
        super.invalidateDrawable(r8);
    }

    @Override // androidx.appcompat.widget.t, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas r8) {
        monitor-enter(this);
        i.f(r8, "canvas");     // Catch: Throwable -> L6
        drawBackground(r8);     // Catch: Throwable -> L6
        b(r8);     // Catch: Throwable -> L6
        drawThumb(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r8, int r10) {
        Resources r11 = Resources.getSystem();
        i.e(r11, "Resources.getSystem()");
        super.onMeasure(r8, View.MeasureSpec.makeMeasureSpec(l6.a.I0(TypedValue.applyDimension(1, 32, r11.getDisplayMetrics())), 1073741824));
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (r8 == null) goto L4;
        Integer r10 = Integer.valueOf(r8.getAction());
    L5:
        if (r10 != null) goto L8;
    L9:
        if (r10 != null) goto L12;
    L14:
        boolean r11 = false;
    L16:
        this.f6551y = r11;
        invalidate();
        return super.onTouchEvent(r8);
    L12:
        if (r10.intValue() != 2) goto L14;
    L15:
        r11 = true;
        goto L16
    L8:
        if (r10.intValue() == 0) goto L15;
    L4:
        r10 = null;
        goto L5
    }

    public final void setBackgroundHeight(float r8) {
        this.f6538b = r8;
        invalidate();
    }

    public void setDefaultTickMarkCount(int r8) {
        invalidate();
    }

    public final void setOnSeekBarChangeListenerExt(InterfaceC0057a r8) {
        super.setOnSeekBarChangeListener(new b(this));
    }

    public final void setProcessBackgroundColor(int r8) {
        this.f6542p = getResources().getColor(r8);
        invalidate();
    }

    public final void setProcessProgressColor(int r8) {
        this.f6543q = getResources().getColor(r8);
        invalidate();
    }

    public final void setThumbColor(int r8) {
        this.f6544r = getResources().getColor(r8);
    }

    public a(Context r16, AttributeSet r17, int r18) {
        i.f(r16, "context");
        super(r16, r17, r18);
        float r8 = 6;
        this.f6538b = android.aimedia.a.a("Resources.getSystem()", 1, r8);
        this.f6539m = android.aimedia.a.a("Resources.getSystem()", 1, 16);
        this.f6540n = android.aimedia.a.a("Resources.getSystem()", 1, 18);
        this.f6541o = android.aimedia.a.a("Resources.getSystem()", 1, 22);
        Resources r10 = Resources.getSystem();
        i.e(r10, "Resources.getSystem()");
        l6.a.I0(TypedValue.applyDimension(1, 2, r10.getDisplayMetrics()));
        Paint r11 = new Paint();
        this.f6545s = r11;
        this.f6546t = new Path();
        this.f6547u = new RectF();
        this.f6548v = new Path();
        this.f6549w = new tc.b();
        n r12 = new n(Color.parseColor("#00000000"), 0.0f, 0.0f, 0.0f, 0.0f);
        this.f6550x = r12;
        TypedArray r13 = r16.getTheme().obtainStyledAttributes(r17, nb.a.B, r18, 0);
        Resources r14 = Resources.getSystem();
        i.e(r14, "Resources.getSystem()");
        this.f6538b = r13.getDimensionPixelSize(1, l6.a.I0(TypedValue.applyDimension(1, r8, r14.getDisplayMetrics())));
        this.f6542p = r13.getColor(0, r13.getResources().getColor(R.color.oui_basic_line_2));
        this.f6543q = r13.getColor(2, r13.getResources().getColor(R.color.oui_functional_blue_6));
        this.f6544r = r13.getColor(3, r13.getResources().getColor(R.color.oui_on_accent_default));
        setOnSeekBarChangeListenerExt(null);
        getResources().getColor(R.color.oui_basic_line_3);
        r11.setStyle(Paint.Style.FILL);
        TypedArray r15 = r16.obtainStyledAttributes(R.style.OUIShadow_1_2, nb.a.f9509w);
        i.e(r15, "context.obtainStyledAttr…s, R.styleable.OUILayout)");
        r12.f334a = r15.getColor(13, Color.parseColor("#00000000"));
        r12.f335b = r15.getDimension(12, 0.0f);
        r12.f336c = r15.getDimension(10, 0.0f);
        r12.f337d = r15.getDimension(11, 0.0f);
        r12.f338e = r15.getDimension(14, 0.0f);
        r15.recycle();
    }
}
