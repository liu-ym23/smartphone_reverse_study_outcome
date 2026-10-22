package com.obric.oui.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewKt;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class ODownloadProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f14196c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ValueAnimator f14198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f14202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f14203n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f14204o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Drawable f14205p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f14206q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Drawable f14207r;
    public Drawable s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f14208t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ValueAnimator f14209u;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14211b;

        static {
            CREATOR = new b();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.f14210a);
            r5.writeInt(this.f14211b);
        }
    }

    public ODownloadProgressView(Context r5) {
        this(r5, null);
    }

    public static int b(float r5) {
        return (int) (r5 * Resources.getSystem().getDisplayMetrics().density);
    }

    private Drawable getCurrentStateDrawable() {
        return c(this.f14194a);
    }

    private Drawable getLastStateDrawable() {
        return c(this.f14195b);
    }

    public final void a() {
        ValueAnimator r5 = this.f14209u;
        r5.removeAllUpdateListeners();
        r5.cancel();
    }

    public final Drawable c(int r5) {
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L26;
        if (r5 == 2) goto L25;
        if (r5 == 3) goto L24;
        if (r5 == 4) goto L23;
        if (r5 == 5) goto L22;
        return null;
    L22:
        return this.s;
    L23:
        return this.f14207r;
    L24:
        return this.f14206q;
    L25:
        return this.f14205p;
    L26:
        return this.f14204o;
    L20:
        return this.f14202m;
    }

    public final void d() {
        if (this.f14194a == 0) goto L6;
        a();
        return;
    L6:
        ViewKt.doOnPreDraw(this, new a(this, 0));
    }

    public int getCurrentState() {
        return this.f14194a;
    }

    public Drawable getDownloadDrawable() {
        return this.f14204o;
    }

    public Drawable getFailedDrawable() {
        return this.s;
    }

    public int getLastState() {
        return this.f14195b;
    }

    public Drawable getPauseDrawable() {
        return this.f14205p;
    }

    public Drawable getProcessingDrawable() {
        return this.f14202m;
    }

    public int getProgress() {
        return this.f14197h;
    }

    public Drawable getProgressBgDrawable() {
        return this.f14203n;
    }

    public Drawable getRetryDrawable() {
        return this.f14206q;
    }

    public Drawable getSucceedDrawable() {
        return this.f14207r;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.d = 255;
        ValueAnimator r5 = this.f14198i;
        r5.removeAllUpdateListeners();
        r5.cancel();
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        super.onDraw(r13);
        if (this.f14196c != null) goto L5;
        this.f14196c = new Paint();
    L5:
        this.f14196c.reset();
        this.f14196c.setAntiAlias(true);
        int r5 = this.e / 2;
        r13.save();
        Drawable r10 = getLastStateDrawable();
        if (r10 != null) goto L8;
    L17:
        Drawable r11 = getCurrentStateDrawable();
        if (r11 == null) goto L39;
        int r12 = this.f14194a;
        if (r12 == 0) goto L25;
        if (r12 == 4) goto L25;
        if (r12 == 5) goto L25;
        int r14 = this.e;
        int r15 = this.g;
        int r16 = (r14 - r15) / 2;
        int r17 = (r14 + r15) / 2;
        r11.setBounds(r16, r16, r17, r17);
    L27:
        if (this.f14194a != 0) goto L33;
        ValueAnimator r18 = this.f14209u;
        if (r18.isRunning() == false) goto L33;
        if (r18.getAnimatedValue() == null) goto L33;
        r13.save();
        Drawable r19 = this.f14203n;
        r19.setBounds(r11.getBounds());
        r19.setColorFilter(this.f14200k, PorterDuff.Mode.SRC_IN);
        r19.draw(r13);
        r13.restore();
        float r20 = r5;
        r13.rotate(((Float) r18.getAnimatedValue()).floatValue(), r20, r20);
    L33:
        r11.setAlpha(this.d);
        r11.draw(r13);
        int r21 = this.f14194a;
        if (r21 == 0) goto L37;
        if (r21 == 4) goto L37;
        if (r21 != 5) goto L39;
    L37:
        invalidate();
        return;
    L25:
        int r22 = this.e;
        r11.setBounds(0, 0, r22, r22);
    L39:
        r13.restore();
        ValueAnimator r23 = this.f14198i;
        if (r23.isRunning() == true) goto L42;
    L45:
        float r24 = this.f14197h;
    L44:
        float r25 = (r24 * 360.0f) / 100.0f;
        r13.save();
        if (r25 < 360.0f) goto L49;
        this.f14203n.setColorFilter(this.f14199j, PorterDuff.Mode.SRC_IN);
        this.f14203n.draw(r13);
    L50:
        r13.restore();
        return;
    L49:
        Drawable r26 = this.f14203n;
        int r27 = this.f14200k;
        PorterDuff.Mode r28 = PorterDuff.Mode.SRC_IN;
        r26.setColorFilter(r27, r28);
        this.f14203n.draw(r13);
        Path r29 = this.f14208t;
        r29.reset();
        r29.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        r29.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r25, false);
        r13.save();
        r13.clipPath(r29);
        this.f14203n.setColorFilter(this.f14199j, r28);
        this.f14203n.draw(r13);
        r13.restore();
        goto L50
    L42:
        if (r23.getAnimatedValue() == null) goto L45;
        r24 = ((Float) r23.getAnimatedValue()).floatValue();
        goto L44
    L8:
        if (this.d == 255) goto L17;
        int r30 = this.f14195b;
        if (r30 == 0) goto L15;
        if (r30 == 4) goto L15;
        if (r30 == 5) goto L15;
        int r31 = Math.min(r10.getIntrinsicWidth(), this.g);
        int r32 = Math.min(r10.getIntrinsicHeight(), this.g);
        int r33 = this.e;
        r10.setBounds((r33 - r31) / 2, (r33 - r32) / 2, (r31 + r33) / 2, (r33 + r32) / 2);
    L16:
        r10.setAlpha(255 - this.d);
        r10.draw(r13);
    L15:
        int r34 = this.e;
        r10.setBounds(0, 0, r34, r34);
        goto L16
    }

    @Override // android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        int r11 = View.MeasureSpec.getMode(r5);
        int r12 = View.MeasureSpec.getSize(r5);
        if (r11 == Integer.MIN_VALUE) goto L7;
        if (r12 <= 0) goto L7;
        this.e = r12;
    L8:
        int r13 = this.e;
        setMeasuredDimension(r13, r13);
        return;
    L7:
        this.e = this.f;
        goto L8
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setCurrentState(r10.f14211b);
        setProgress(r10.f14210a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.f14210a = this.f14197h;
        r5.f14211b = this.f14194a;
        return r5;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r5, int r10) {
        super.onVisibilityChanged(r5, r10);
        if (r10 != 0) goto L5;
        d();
        return;
    L5:
        a();
    }

    public void setActionColor(int r5) {
        this.f14204o = this.f14204o.mutate();
        this.f14205p = this.f14205p.mutate();
        this.f14206q = this.f14206q.mutate();
        DrawableCompat.setTint(this.f14204o, r5);
        DrawableCompat.setTint(this.f14205p, r5);
        DrawableCompat.setTint(this.f14206q, r5);
    }

    public void setAlphaAnimationDuration(long r5) {
    }

    public void setCurrentState(int r5) {
        int r10 = this.f14194a;
        if (r10 != r5) goto L5;
        return;
    L5:
        this.f14195b = r10;
        this.f14194a = r5;
        invalidate();
        d();
    }

    public void setDownloadDrawable(Drawable r5) {
        this.f14204o = r5;
    }

    public void setFailedDrawable(Drawable r5) {
        this.s = r5;
    }

    public void setPauseDrawable(Drawable r5) {
        this.f14205p = r5;
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        super.setPressed(r5);
        invalidate();
    }

    public void setProcessingColor(int r5) {
        Drawable r10 = this.f14202m.mutate();
        this.f14202m = r10;
        DrawableCompat.setTint(r10, r5);
    }

    public void setProcessingDrawable(Drawable r5) {
        this.f14202m = r5;
    }

    public void setProcessingDuration(int r5) {
        this.f14201l = r5;
    }

    public void setProgress(int r5) {
        if (this.f14197h == r5) goto L7;
        this.f14198i.cancel();
        this.f14197h = Math.max(Math.min(r5, 100), 0);
        invalidate();
        return;
    }

    public void setProgressBackgroundColor(int r5) {
        this.f14200k = r5;
    }

    public void setProgressBgDrawable(Drawable r5) {
        this.f14203n = r5;
    }

    public void setProgressColor(int r5) {
        this.f14199j = r5;
    }

    public void setProgressDuration(int r5) {
    }

    public void setRetryDrawable(Drawable r5) {
        this.f14206q = r5;
    }

    public void setSize(int r5) {
        if (r5 != 0) goto L5;
        this.f = b(48.0f);
        this.g = b(24.0f);
    L9:
        Drawable r10 = this.f14203n;
        int r11 = this.f;
        r10.setBounds(0, 0, r11, r11);
        invalidate();
        return;
    L5:
        if (r5 == 2) goto L7;
        this.f = b(36.0f);
        this.g = b(16.0f);
        goto L9
    L7:
        this.f = b(24.0f);
        this.g = b(12.0f);
        goto L9
    }

    public void setSucceedDrawable(Drawable r5) {
        this.f14207r = r5;
    }

    public ODownloadProgressView(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public ODownloadProgressView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11, 0);
        this.f14194a = 0;
        this.f14195b = 0;
        this.d = 255;
        this.f14198i = new ValueAnimator();
        this.f14201l = 1200;
        this.f14208t = new Path();
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f14209u = new ValueAnimator();
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.ODownloadProgressView, r11, 0);
        int r13 = r12.getInt(R$styleable.ODownloadProgressView_oui_progress_view_size, 1);
        this.f14197h = r12.getInt(R$styleable.ODownloadProgressView_oui_progress, 0);
        this.f14199j = r12.getColor(R$styleable.ODownloadProgressView_oui_progress_color, ContextCompat.getColor(r5, R$color.oui_accent_6_bg));
        this.f14200k = r12.getColor(R$styleable.ODownloadProgressView_oui_progress_background_color, ContextCompat.getColor(r5, R$color.oui_basic_line_2));
        int r14 = r12.getColor(R$styleable.ODownloadProgressView_oui_progressing_action_color, ContextCompat.getColor(r5, R$color.oui_accent_6_bg));
        int r15 = r12.getColor(R$styleable.ODownloadProgressView_oui_download_action_color, ContextCompat.getColor(r5, R$color.oui_accent_6_bg));
        r12.recycle();
        this.f14202m = ResourcesCompat.getDrawable(getResources(), R$drawable.o_ic_progress_processing, null);
        this.f14203n = ResourcesCompat.getDrawable(getResources(), R$drawable.o_ic_download_progress_bg, null);
        this.f14204o = ResourcesCompat.getDrawable(getResources(), R$drawable.o_ic_arrow_down_download, null);
        this.f14205p = ResourcesCompat.getDrawable(getResources(), R$drawable.o_ic_pause_download, null);
        this.f14206q = ResourcesCompat.getDrawable(getResources(), R$drawable.o_ic_download_retry, null);
        if (r14 == 0) goto L5;
        setProcessingColor(r14);
    L5:
        if (r15 == 0) goto L7;
        setActionColor(r15);
    L7:
        this.f14207r = ResourcesCompat.getDrawable(getResources(), R$drawable.o_ic_download_succeed, null);
        this.s = ResourcesCompat.getDrawable(getResources(), R$drawable.o_ic_download_failed, null);
        setSize(r13);
        d();
    }
}
