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
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.obric.cae.R;
import ge.l;
import j0.d0;
import j0.r;
import xd.j;
import z.f;

/* JADX INFO: loaded from: classes2.dex */
public class ODownloadProgressView extends View {
    public Drawable A;
    public Drawable B;
    public Drawable C;
    public final Path D;
    public final ValueAnimator E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6460b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Paint f6461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6463o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6464p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6465q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6466r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ValueAnimator f6467s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6468t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6469u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6470v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Drawable f6471w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Drawable f6472x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Drawable f6473y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Drawable f6474z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6476b;

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
            this.f6475a = r8.readInt();
            this.f6476b = r8.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            super.writeToParcel(r8, r10);
            r8.writeInt(this.f6475a);
            r8.writeInt(this.f6476b);
        }
    }

    public class a implements l<View, j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ODownloadProgressView f6477a;

        public a(ODownloadProgressView r8) {
            this.f6477a = r8;
        }

        @Override // ge.l
        public final j invoke(View r8) {
            ODownloadProgressView r10 = this.f6477a;
            if (r10.f6459a == 0) goto L5;
        L11:
            r10.a();
        L13:
            return j.f13877a;
        L5:
            if (r10.isShown() == false) goto L11;
            ValueAnimator r11 = r10.E;
            if (r11.isRunning() == true) goto L13;
            r10.a();
            r11.setInterpolator(new LinearInterpolator());
            r11.setDuration(r10.f6470v);
            r11.setFloatValues(new float[]{0.0f, 360.0f});
            r11.addUpdateListener(new com.obric.oui.progress.a(this));
            r11.setRepeatCount(-1);
            r11.start();
            goto L13
        }
    }

    public ODownloadProgressView() {
        throw null;
    }

    public ODownloadProgressView(Context r8, AttributeSet r10) {
        super(r8, r10, 0, 0);
        this.f6459a = 0;
        this.f6460b = 0;
        this.f6462n = 255;
        this.f6467s = new ValueAnimator();
        this.f6470v = 1200;
        this.D = new Path();
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.E = new ValueAnimator();
        TypedArray r11 = r8.obtainStyledAttributes(r10, nb.a.f9496j, 0, 0);
        int r12 = r11.getInt(4, 1);
        this.f6466r = r11.getInt(1, 0);
        Object r13 = androidx.core.content.a.f1674a;
        this.f6468t = r11.getColor(3, androidx.core.content.a.c.a(r8, R.color.oui_accent_6_bg));
        this.f6469u = r11.getColor(2, androidx.core.content.a.c.a(r8, R.color.oui_basic_line_2));
        int r14 = r11.getColor(5, androidx.core.content.a.c.a(r8, R.color.oui_accent_6_bg));
        int r15 = r11.getColor(0, androidx.core.content.a.c.a(r8, R.color.oui_accent_6_bg));
        r11.recycle();
        Resources r16 = getResources();
        ThreadLocal<TypedValue> r17 = f.f14146a;
        this.f6471w = f.a.a(r16, R.drawable.o_ic_progress_processing, null);
        this.f6472x = f.a.a(getResources(), R.drawable.o_ic_download_progress_bg, null);
        this.f6473y = f.a.a(getResources(), R.drawable.o_ic_arrow_down_download, null);
        this.f6474z = f.a.a(getResources(), R.drawable.o_ic_pause_download, null);
        this.A = f.a.a(getResources(), R.drawable.o_ic_download_retry, null);
        if (r14 == 0) goto L5;
        setProcessingColor(r14);
    L5:
        if (r15 == 0) goto L7;
        setActionColor(r15);
    L7:
        this.B = f.a.a(getResources(), R.drawable.o_ic_download_succeed, null);
        this.C = f.a.a(getResources(), R.drawable.o_ic_download_failed, null);
        setSize(r12);
        d();
    }

    public static int b(float r8) {
        return (int) (r8 * Resources.getSystem().getDisplayMetrics().density);
    }

    private Drawable getCurrentStateDrawable() {
        return c(this.f6459a);
    }

    private Drawable getLastStateDrawable() {
        return c(this.f6460b);
    }

    public final void a() {
        ValueAnimator r8 = this.E;
        r8.removeAllUpdateListeners();
        r8.cancel();
    }

    public final Drawable c(int r8) {
        if (r8 == 0) goto L20;
        if (r8 == 1) goto L26;
        if (r8 == 2) goto L25;
        if (r8 == 3) goto L24;
        if (r8 == 4) goto L23;
        if (r8 == 5) goto L22;
        return null;
    L22:
        return this.C;
    L23:
        return this.B;
    L24:
        return this.A;
    L25:
        return this.f6474z;
    L26:
        return this.f6473y;
    L20:
        return this.f6471w;
    }

    public final void d() {
        if (this.f6459a == 0) goto L6;
        a();
        return;
    L6:
        r.a(this, new d0(this, new a(this)));
    }

    public int getCurrentState() {
        return this.f6459a;
    }

    public Drawable getDownloadDrawable() {
        return this.f6473y;
    }

    public Drawable getFailedDrawable() {
        return this.C;
    }

    public int getLastState() {
        return this.f6460b;
    }

    public Drawable getPauseDrawable() {
        return this.f6474z;
    }

    public Drawable getProcessingDrawable() {
        return this.f6471w;
    }

    public int getProgress() {
        return this.f6466r;
    }

    public Drawable getProgressBgDrawable() {
        return this.f6472x;
    }

    public Drawable getRetryDrawable() {
        return this.A;
    }

    public Drawable getSucceedDrawable() {
        return this.B;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        this.f6462n = 255;
        ValueAnimator r8 = this.f6467s;
        r8.removeAllUpdateListeners();
        r8.cancel();
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        super.onDraw(r13);
        if (this.f6461m != null) goto L5;
        this.f6461m = new Paint();
    L5:
        this.f6461m.reset();
        boolean r8 = true;
        this.f6461m.setAntiAlias(true);
        int r10 = this.f6463o / 2;
        r13.save();
        Drawable r11 = getLastStateDrawable();
        if (r11 != null) goto L8;
    L20:
        Drawable r12 = getCurrentStateDrawable();
        if (r12 == null) goto L48;
        int r14 = this.f6459a;
        if (r14 == 0) goto L28;
        if (r14 == 4) goto L28;
        if (r14 == 5) goto L28;
        boolean r15 = false;
    L29:
        if (r15 == false) goto L31;
        int r16 = this.f6463o;
        r12.setBounds(0, 0, r16, r16);
    L33:
        if (this.f6459a != 0) goto L39;
        ValueAnimator r17 = this.E;
        if (r17.isRunning() == false) goto L39;
        if (r17.getAnimatedValue() == null) goto L39;
        r13.save();
        Drawable r18 = this.f6472x;
        r18.setBounds(r12.getBounds());
        r18.setColorFilter(this.f6469u, PorterDuff.Mode.SRC_IN);
        r18.draw(r13);
        r13.restore();
        float r19 = r10;
        r13.rotate(((Float) r17.getAnimatedValue()).floatValue(), r19, r19);
    L39:
        r12.setAlpha(this.f6462n);
        r12.draw(r13);
        int r20 = this.f6459a;
        if (r20 == 0) goto L45;
        if (r20 == 4) goto L45;
        if (r20 == 5) goto L45;
        r8 = false;
    L45:
        if (r8 == false) goto L48;
        invalidate();
        return;
    L31:
        int r21 = this.f6463o;
        int r22 = this.f6465q;
        int r23 = (r21 - r22) / 2;
        int r24 = (r21 + r22) / 2;
        r12.setBounds(r23, r23, r24, r24);
    L28:
        r15 = true;
    L48:
        r13.restore();
        ValueAnimator r25 = this.f6467s;
        if (r25.isRunning() == true) goto L51;
    L53:
        float r26 = this.f6466r;
    L54:
        float r27 = (r26 * 360.0f) / 100.0f;
        r13.save();
        if (r27 < 360.0f) goto L57;
        this.f6472x.setColorFilter(this.f6468t, PorterDuff.Mode.SRC_IN);
        this.f6472x.draw(r13);
    L58:
        r13.restore();
        return;
    L57:
        this.f6472x.setColorFilter(this.f6469u, PorterDuff.Mode.SRC_IN);
        this.f6472x.draw(r13);
        Path r28 = this.D;
        r28.reset();
        r28.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        r28.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r27, false);
        r13.save();
        r13.clipPath(r28);
        this.f6472x.setColorFilter(this.f6468t, PorterDuff.Mode.SRC_IN);
        this.f6472x.draw(r13);
        r13.restore();
        goto L58
    L51:
        if (r25.getAnimatedValue() == null) goto L53;
        r26 = ((Float) r25.getAnimatedValue()).floatValue();
        goto L54
    L8:
        if (this.f6462n == 255) goto L20;
        int r29 = this.f6460b;
        if (r29 == 0) goto L15;
        if (r29 == 4) goto L15;
        if (r29 == 5) goto L15;
        boolean r30 = false;
    L16:
        if (r30 == false) goto L18;
        int r31 = this.f6463o;
        r11.setBounds(0, 0, r31, r31);
    L19:
        r11.setAlpha(255 - this.f6462n);
        r11.draw(r13);
        goto L20
    L18:
        int r32 = Math.min(r11.getIntrinsicWidth(), this.f6465q);
        int r33 = Math.min(r11.getIntrinsicHeight(), this.f6465q);
        int r34 = this.f6463o;
        r11.setBounds((r34 - r32) / 2, (r34 - r33) / 2, (r32 + r34) / 2, (r34 + r33) / 2);
    L15:
        r30 = true;
        goto L16
    }

    @Override // android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r10) {
        int r11 = View.MeasureSpec.getMode(r8);
        int r12 = View.MeasureSpec.getSize(r8);
        if (r11 == Integer.MIN_VALUE) goto L5;
        if (r12 <= 0) goto L5;
    L6:
        this.f6463o = r12;
        int r13 = this.f6463o;
        setMeasuredDimension(r13, r13);
        return;
    L5:
        r12 = this.f6464p;
        goto L6
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.getSuperState());
        setCurrentState(r10.f6476b);
        setProgress(r10.f6475a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f6475a = this.f6466r;
        r8.f6476b = this.f6459a;
        return r8;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r8, int r10) {
        super.onVisibilityChanged(r8, r10);
        if (r10 != 0) goto L5;
        d();
        return;
    L5:
        a();
    }

    public void setActionColor(int r8) {
        this.f6473y = this.f6473y.mutate();
        this.f6474z = this.f6474z.mutate();
        this.A = this.A.mutate();
        b0.a.b.g(this.f6473y, r8);
        b0.a.b.g(this.f6474z, r8);
        b0.a.b.g(this.A, r8);
    }

    public void setAlphaAnimationDuration(long r8) {
    }

    public void setCurrentState(int r8) {
        int r10 = this.f6459a;
        if (r10 != r8) goto L5;
        return;
    L5:
        this.f6460b = r10;
        this.f6459a = r8;
        invalidate();
        d();
    }

    public void setDownloadDrawable(Drawable r8) {
        this.f6473y = r8;
    }

    public void setFailedDrawable(Drawable r8) {
        this.C = r8;
    }

    public void setPauseDrawable(Drawable r8) {
        this.f6474z = r8;
    }

    @Override // android.view.View
    public void setPressed(boolean r8) {
        super.setPressed(r8);
        invalidate();
    }

    public void setProcessingColor(int r8) {
        Drawable r10 = this.f6471w.mutate();
        this.f6471w = r10;
        b0.a.b.g(r10, r8);
    }

    public void setProcessingDrawable(Drawable r8) {
        this.f6471w = r8;
    }

    public void setProcessingDuration(int r8) {
        this.f6470v = r8;
    }

    public void setProgress(int r8) {
        if (this.f6466r == r8) goto L7;
        this.f6467s.cancel();
        int r10 = this.f6466r;
        this.f6466r = Math.max(Math.min(r8, 100), 0);
        invalidate();
        return;
    }

    public void setProgressBackgroundColor(int r8) {
        this.f6469u = r8;
    }

    public void setProgressBgDrawable(Drawable r8) {
        this.f6472x = r8;
    }

    public void setProgressColor(int r8) {
        this.f6468t = r8;
    }

    public void setProgressDuration(int r8) {
    }

    public void setRetryDrawable(Drawable r8) {
        this.A = r8;
    }

    public void setSize(int r8) {
        if (r8 != 0) goto L5;
        this.f6464p = b(48.0f);
        int r10 = b(24.0f);
    L10:
        this.f6465q = r10;
        Drawable r11 = this.f6472x;
        int r12 = this.f6464p;
        r11.setBounds(0, 0, r12, r12);
        invalidate();
        return;
    L5:
        if (r8 == 2) goto L7;
        this.f6464p = b(36.0f);
        float r13 = 16.0f;
    L8:
        r10 = b(r13);
        goto L10
    L7:
        this.f6464p = b(24.0f);
        r13 = 12.0f;
        goto L8
    }

    public void setSucceedDrawable(Drawable r8) {
        this.B = r8;
    }
}
