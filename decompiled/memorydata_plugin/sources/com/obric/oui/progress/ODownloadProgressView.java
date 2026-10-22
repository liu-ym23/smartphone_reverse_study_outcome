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
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewKt;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class ODownloadProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14399b;
    private Paint c;
    private int d;
    private ValueAnimator e;
    private long f;
    private int g;
    private int h;
    private int i;
    private int j;
    private final ValueAnimator k;
    private int l;
    private int m;
    private int n;
    private int o;
    private Drawable p;
    private Drawable q;
    private Drawable r;
    private Drawable s;
    private Drawable t;
    private Drawable u;
    private Drawable v;
    private final Path w;
    private final PorterDuffXfermode x;
    private final ValueAnimator y;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentState;
        int progress;

        static {
            CREATOR = new AnonymousClass1();
        }

        private SavedState(Parcel r2) {
            super(r2);
            this.progress = r2.readInt();
            this.currentState = r2.readInt();
        }

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.progress);
            r1.writeInt(this.currentState);
        }
    }

    public ODownloadProgressView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ODownloadProgressView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public ODownloadProgressView(Context r3, AttributeSet r4, int r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, 0);
    }

    public ODownloadProgressView(Context r7, AttributeSet r8, int r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r11, r12, r9, r10);
        this.f14398a = 0;
        this.f14399b = 0;
        this.d = 255;
        this.f = 300;
        this.k = new ValueAnimator();
        this.n = 1200;
        this.o = 2000;
        this.w = new Path();
        this.x = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.y = new ValueAnimator();
        TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.ODownloadProgressView, r9, r10);
        int r14 = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.ODownloadProgressView_oui_progress_view_size, "styleable", "ODownloadProgressView_oui_progress_view_size"), 1);
        this.j = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.ODownloadProgressView_oui_progress, "styleable", "ODownloadProgressView_oui_progress"), 0);
        this.l = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ODownloadProgressView_oui_progress_color, "styleable", "ODownloadProgressView_oui_progress_color"), ContextCompat.getColor(r11, ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, TypedValues.Custom.S_COLOR, "oui_accent_6_bg")));
        this.m = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ODownloadProgressView_oui_progress_background_color, "styleable", "ODownloadProgressView_oui_progress_background_color"), ContextCompat.getColor(r11, ZeusTransformUtils.mapRes(R.color.oui_basic_line_2, TypedValues.Custom.S_COLOR, "oui_basic_line_2")));
        int r0 = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ODownloadProgressView_oui_progressing_action_color, "styleable", "ODownloadProgressView_oui_progressing_action_color"), ContextCompat.getColor(r11, ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, TypedValues.Custom.S_COLOR, "oui_accent_6_bg")));
        int r15 = r13.getColor(ZeusTransformUtils.mapRes(R.styleable.ODownloadProgressView_oui_download_action_color, "styleable", "ODownloadProgressView_oui_download_action_color"), ContextCompat.getColor(r11, ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, TypedValues.Custom.S_COLOR, "oui_accent_6_bg")));
        r13.recycle();
        this.p = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_ic_progress_processing, "drawable", "o_ic_progress_processing"), null);
        this.q = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_ic_download_progress_bg, "drawable", "o_ic_download_progress_bg"), null);
        this.r = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_ic_arrow_down_download, "drawable", "o_ic_arrow_down_download"), null);
        this.s = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_ic_pause_download, "drawable", "o_ic_pause_download"), null);
        this.t = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_ic_download_retry, "drawable", "o_ic_download_retry"), null);
        if (r0 == 0) goto L5;
        setProcessingColor(r0);
    L5:
        if (r15 == 0) goto L7;
        setActionColor(r15);
    L7:
        this.u = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_ic_download_succeed, "drawable", "o_ic_download_succeed"), null);
        this.v = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_ic_download_failed, "drawable", "o_ic_download_failed"), null);
        setSize(r14);
        a();
    }

    private int a(float r1) {
        return (int) (r1 * Resources.getSystem().getDisplayMetrics().density);
    }

    static /* synthetic */ int a(ODownloadProgressView r0) {
        return r0.f14398a;
    }

    private void a() {
        if (this.f14398a == 0) goto L6;
        e();
        return;
    L6:
        ViewKt.doOnPreDraw(this, new AnonymousClass1(this));
    }

    private boolean a(int r1) {
        if (r1 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r1 == 4) goto L9;
        if (r1 == 5) goto L9;
        return false;
    }

    private Drawable b(int r2) {
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L26;
        if (r2 == 2) goto L25;
        if (r2 == 3) goto L24;
        if (r2 == 4) goto L23;
        if (r2 == 5) goto L22;
        return null;
    L22:
        return this.v;
    L23:
        return this.u;
    L24:
        return this.t;
    L25:
        return this.s;
    L26:
        return this.r;
    L20:
        return this.p;
    }

    static /* synthetic */ void b(ODownloadProgressView r0) {
        r0.e();
    }

    private boolean b() {
        ValueAnimator r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    static /* synthetic */ ValueAnimator c(ODownloadProgressView r0) {
        return r0.y;
    }

    private void c() {
        if (b() == false) goto L5;
        this.e.cancel();
    L5:
        this.d = 255;
    }

    static /* synthetic */ int d(ODownloadProgressView r0) {
        return r0.n;
    }

    private void d() {
        this.k.removeAllUpdateListeners();
        this.k.cancel();
    }

    private void e() {
        this.y.removeAllUpdateListeners();
        this.y.cancel();
    }

    private Drawable getCurrentStateDrawable() {
        return b(this.f14398a);
    }

    private Drawable getLastStateDrawable() {
        return b(this.f14399b);
    }

    public void a(int r7, boolean r8) {
        if (this.j != r7) goto L5;
        return;
    L5:
        this.k.cancel();
        int r0 = this.j;
        int r9 = Math.max(Math.min(r7, 100), 0);
        this.j = r9;
        if (r0 > r9) goto L11;
        if (r8 == false) goto L11;
        this.k.setInterpolator(new LinearInterpolator());
        this.k.setDuration((((long) Math.abs(this.j - r0)) * ((long) this.o)) / 100);
        this.k.setFloatValues(new float[]{r0, this.j});
        this.k.addUpdateListener(new AnonymousClass2(this));
        this.k.start();
        return;
    L11:
        invalidate();
    }

    public int getCurrentState() {
        return this.f14398a;
    }

    public Drawable getDownloadDrawable() {
        return this.r;
    }

    public Drawable getFailedDrawable() {
        return this.v;
    }

    public int getLastState() {
        return this.f14399b;
    }

    public Drawable getPauseDrawable() {
        return this.s;
    }

    public Drawable getProcessingDrawable() {
        return this.p;
    }

    public int getProgress() {
        return this.j;
    }

    public Drawable getProgressBgDrawable() {
        return this.q;
    }

    public Drawable getRetryDrawable() {
        return this.t;
    }

    public Drawable getSucceedDrawable() {
        return this.u;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        c();
        d();
        e();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas r14) {
        super.onDraw(r14);
        if (this.c != null) goto L5;
        this.c = new Paint();
    L5:
        this.c.reset();
        this.c.setAntiAlias(true);
        int r0 = this.g;
        int r1 = r0 / 2;
        int r2 = r0 / 2;
        r14.save();
        Drawable r3 = getLastStateDrawable();
        if (r3 != null) goto L8;
    L14:
        Drawable r4 = getCurrentStateDrawable();
        if (r4 != null) goto L17;
    L31:
        r14.restore();
        if (this.k.isRunning() == true) goto L34;
    L36:
        float r5 = this.j;
    L37:
        float r6 = (r5 * 360.0f) / 100.0f;
        r14.save();
        if (r6 < 360.0f) goto L40;
        this.q.setColorFilter(this.l, PorterDuff.Mode.SRC_IN);
        this.q.draw(r14);
    L41:
        r14.restore();
        return;
    L40:
        this.q.setColorFilter(this.m, PorterDuff.Mode.SRC_IN);
        this.q.draw(r14);
        this.w.reset();
        this.w.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        this.w.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r6, false);
        r14.save();
        r14.clipPath(this.w);
        this.q.setColorFilter(this.l, PorterDuff.Mode.SRC_IN);
        this.q.draw(r14);
        r14.restore();
        goto L41
    L34:
        if (this.k.getAnimatedValue() == null) goto L36;
        r5 = ((Float) ZeusTransformUtils.preCheckCast(this.k.getAnimatedValue(), Float.class, "com.obric.memorydata.plugin")).floatValue();
        goto L37
    L17:
        if (a(this.f14398a) == false) goto L19;
        int r7 = this.g;
        r4.setBounds(0, 0, r7, r7);
    L21:
        if (this.f14398a == 0) goto L23;
    L27:
        r4.setAlpha(this.d);
        r4.draw(r14);
        if (a(this.f14398a) == false) goto L31;
        invalidate();
        return;
    L23:
        if (this.y.isRunning() == false) goto L27;
        if (this.y.getAnimatedValue() == null) goto L27;
        r14.save();
        Drawable r8 = this.q;
        r8.setBounds(r4.getBounds());
        r8.setColorFilter(this.m, PorterDuff.Mode.SRC_IN);
        r8.draw(r14);
        r14.restore();
        r14.rotate(((Float) ZeusTransformUtils.preCheckCast(this.y.getAnimatedValue(), Float.class, "com.obric.memorydata.plugin")).floatValue(), r1, r2);
        goto L27
    L19:
        int r9 = this.g;
        int r10 = this.i;
        r4.setBounds((r9 - r10) / 2, (r9 - r10) / 2, (r9 + r10) / 2, (r9 + r10) / 2);
        goto L21
    L8:
        if (this.d == 255) goto L14;
        if (a(this.f14399b) == false) goto L12;
        int r11 = this.g;
        r3.setBounds(0, 0, r11, r11);
    L13:
        r3.setAlpha(255 - this.d);
        r3.draw(r14);
        goto L14
    L12:
        int r12 = Math.min(r3.getIntrinsicWidth(), this.i);
        int r13 = Math.min(r3.getIntrinsicHeight(), this.i);
        int r15 = this.g;
        r3.setBounds((r15 - r12) / 2, (r15 - r13) / 2, (r12 + r15) / 2, (r15 + r13) / 2);
        goto L13
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        int r4 = View.MeasureSpec.getMode(r2);
        int r5 = View.MeasureSpec.getSize(r2);
        if (r4 == Integer.MIN_VALUE) goto L5;
        if (r5 <= 0) goto L5;
    L6:
        this.g = r5;
        int r6 = this.g;
        setMeasuredDimension(r6, r6);
        return;
    L5:
        r5 = this.h;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        SavedState r4 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"), SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r4.getSuperState());
        setCurrentState(r4.currentState);
        setProgress(r4.progress);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.progress = this.j;
        r1.currentState = this.f14398a;
        return r1;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 != 0) goto L5;
        a();
        return;
    L5:
        e();
    }

    public void setActionColor(int r2) {
        this.r = this.r.mutate();
        this.s = this.s.mutate();
        this.t = this.t.mutate();
        DrawableCompat.setTint(this.r, r2);
        DrawableCompat.setTint(this.s, r2);
        DrawableCompat.setTint(this.t, r2);
    }

    public void setAlphaAnimationDuration(long r1) {
        this.f = r1;
    }

    public void setCurrentState(int r2) {
        int r0 = this.f14398a;
        if (r0 != r2) goto L5;
        return;
    L5:
        this.f14399b = r0;
        this.f14398a = r2;
        invalidate();
        a();
    }

    public void setDownloadDrawable(Drawable r1) {
        this.r = r1;
    }

    public void setFailedDrawable(Drawable r1) {
        this.v = r1;
    }

    public void setPauseDrawable(Drawable r1) {
        this.s = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r1) {
        super.setPressed(r1);
        invalidate();
    }

    public void setProcessingColor(int r2) {
        Drawable r0 = this.p.mutate();
        this.p = r0;
        DrawableCompat.setTint(r0, r2);
    }

    public void setProcessingDrawable(Drawable r1) {
        this.p = r1;
    }

    public void setProcessingDuration(int r1) {
        this.n = r1;
    }

    public void setProgress(int r2) {
        a(r2, false);
    }

    public void setProgressBackgroundColor(int r1) {
        this.m = r1;
    }

    public void setProgressBgDrawable(Drawable r1) {
        this.q = r1;
    }

    public void setProgressColor(int r1) {
        this.l = r1;
    }

    public void setProgressDuration(int r1) {
        this.o = r1;
    }

    public void setRetryDrawable(Drawable r1) {
        this.t = r1;
    }

    public void setSize(int r3) {
        if (r3 != 0) goto L5;
        this.h = a(48.0f);
        int r4 = a(24.0f);
    L10:
        this.i = r4;
        Drawable r5 = this.q;
        int r0 = this.h;
        r5.setBounds(0, 0, r0, r0);
        invalidate();
        return;
    L5:
        if (r3 == 2) goto L8;
        this.h = a(36.0f);
        float r6 = 16.0f;
    L7:
        r4 = a(r6);
        goto L10
    L8:
        this.h = a(24.0f);
        r6 = 12.0f;
        goto L7
    }

    public void setSucceedDrawable(Drawable r1) {
        this.u = r1;
    }
}
