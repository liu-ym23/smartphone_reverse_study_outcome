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
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import u8.c;
import u8.e;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
public class ODownloadProgressView extends View {
    private final Path A;
    private final ValueAnimator B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7183c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f7185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ValueAnimator f7187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7188k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7189l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7190m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7191n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ValueAnimator f7192o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7193p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f7194q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f7195r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f7196s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Drawable f7197t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Drawable f7198u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Drawable f7199v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Drawable f7200w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Drawable f7201x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Drawable f7202y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f7203z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentState;
        int progress;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState[] b(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        private SavedState(Parcel r10) {
            super(r10);
            this.progress = r10.readInt();
            this.currentState = r10.readInt();
        }

        /* synthetic */ SavedState(Parcel r10, a r11) {
            this(r10);
        }

        SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.progress);
            r10.writeInt(this.currentState);
        }
    }

    class a implements Function1<View, Unit> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ODownloadProgressView f7204c;

        /* JADX INFO: renamed from: com.obric.oui.progress.ODownloadProgressView$a$a, reason: collision with other inner class name */
        class C0133a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f7205c;

            C0133a(a r10) {
                this.f7205c = r10;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator r10) {
                this.f7205c.f7204c.invalidate();
            }
        }

        a(ODownloadProgressView r10) {
            this.f7204c = r10;
        }

        public Unit a(View r10) {
            if (ODownloadProgressView.a(this.f7204c) == 0) goto L5;
        L14:
            ODownloadProgressView.b(this.f7204c);
        L13:
            return Unit.INSTANCE;
        L5:
            if (this.f7204c.isShown() == false) goto L14;
            if (ODownloadProgressView.c(this.f7204c).isRunning() == true) goto L10;
            ODownloadProgressView.b(this.f7204c);
            ODownloadProgressView.c(this.f7204c).setInterpolator(new LinearInterpolator());
            ODownloadProgressView.c(this.f7204c).setDuration(ODownloadProgressView.d(this.f7204c));
            ODownloadProgressView.c(this.f7204c).setFloatValues(new float[]{0.0f, 360.0f});
            ODownloadProgressView.c(this.f7204c).addUpdateListener(new C0133a(this));
            ODownloadProgressView.c(this.f7204c).setRepeatCount(-1);
            ODownloadProgressView.c(this.f7204c).start();
            goto L13
        L10:
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View r10) {
            return a(r10);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ODownloadProgressView f7206c;

        b(ODownloadProgressView r10) {
            this.f7206c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            this.f7206c.invalidate();
        }
    }

    public ODownloadProgressView(Context r10) {
        this(r10, null);
    }

    public ODownloadProgressView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ODownloadProgressView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public ODownloadProgressView(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.f7183c = 0;
        this.f7184g = 0;
        this.f7186i = 255;
        this.f7192o = new ValueAnimator();
        this.f7195r = 1200;
        this.f7196s = 2000;
        this.A = new Path();
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.B = new ValueAnimator();
        TypedArray r14 = r10.obtainStyledAttributes(r11, l.ODownloadProgressView, r12, r13);
        int r15 = r14.getInt(l.ODownloadProgressView_oui_progress_view_size, 1);
        this.f7191n = r14.getInt(l.ODownloadProgressView_oui_progress, 0);
        int r16 = l.ODownloadProgressView_oui_progress_color;
        int r17 = c.oui_accent_6_bg;
        this.f7193p = r14.getColor(r16, ContextCompat.getColor(r10, r17));
        this.f7194q = r14.getColor(l.ODownloadProgressView_oui_progress_background_color, ContextCompat.getColor(r10, c.oui_basic_line_2));
        int r18 = r14.getColor(l.ODownloadProgressView_oui_progressing_action_color, ContextCompat.getColor(r10, r17));
        int r19 = r14.getColor(l.ODownloadProgressView_oui_download_action_color, ContextCompat.getColor(r10, r17));
        r14.recycle();
        this.f7197t = ResourcesCompat.getDrawable(getResources(), e.o_ic_progress_processing, null);
        this.f7198u = ResourcesCompat.getDrawable(getResources(), e.o_ic_download_progress_bg, null);
        this.f7199v = ResourcesCompat.getDrawable(getResources(), e.o_ic_arrow_down_download, null);
        this.f7200w = ResourcesCompat.getDrawable(getResources(), e.o_ic_pause_download, null);
        this.f7201x = ResourcesCompat.getDrawable(getResources(), e.o_ic_download_retry, null);
        if (r18 == 0) goto L5;
        setProcessingColor(r18);
    L5:
        if (r19 == 0) goto L7;
        setActionColor(r19);
    L7:
        this.f7202y = ResourcesCompat.getDrawable(getResources(), e.o_ic_download_succeed, null);
        this.f7203z = ResourcesCompat.getDrawable(getResources(), e.o_ic_download_failed, null);
        setSize(r15);
        m();
    }

    static /* synthetic */ int a(ODownloadProgressView r10) {
        return r10.f7183c;
    }

    static /* synthetic */ void b(ODownloadProgressView r10) {
        r10.f();
    }

    static /* synthetic */ ValueAnimator c(ODownloadProgressView r10) {
        return r10.B;
    }

    static /* synthetic */ int d(ODownloadProgressView r10) {
        return r10.f7195r;
    }

    private void e() {
        if (j() == false) goto L5;
        this.f7187j.cancel();
    L5:
        this.f7186i = 255;
    }

    private void f() {
        this.B.removeAllUpdateListeners();
        this.B.cancel();
    }

    private void g() {
        this.f7192o.removeAllUpdateListeners();
        this.f7192o.cancel();
    }

    private Drawable getCurrentStateDrawable() {
        return i(this.f7183c);
    }

    private Drawable getLastStateDrawable() {
        return i(this.f7184g);
    }

    private int h(float r10) {
        return (int) (r10 * Resources.getSystem().getDisplayMetrics().density);
    }

    private Drawable i(int r10) {
        if (r10 == 0) goto L20;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L24;
        if (r10 == 4) goto L23;
        if (r10 == 5) goto L22;
        return null;
    L22:
        return this.f7203z;
    L23:
        return this.f7202y;
    L24:
        return this.f7201x;
    L25:
        return this.f7200w;
    L26:
        return this.f7199v;
    L20:
        return this.f7197t;
    }

    private boolean j() {
        ValueAnimator r10 = this.f7187j;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isRunning() == false) goto L7;
        return true;
    }

    private boolean k(int r10) {
        if (r10 != 0) goto L4;
    L9:
        return true;
    L4:
        if (r10 == 4) goto L9;
        if (r10 == 5) goto L9;
        return false;
    }

    private void m() {
        if (this.f7183c == 0) goto L6;
        f();
        return;
    L6:
        ViewKt.doOnPreDraw(this, new a(this));
    }

    public int getCurrentState() {
        return this.f7183c;
    }

    public Drawable getDownloadDrawable() {
        return this.f7199v;
    }

    public Drawable getFailedDrawable() {
        return this.f7203z;
    }

    public int getLastState() {
        return this.f7184g;
    }

    public Drawable getPauseDrawable() {
        return this.f7200w;
    }

    public Drawable getProcessingDrawable() {
        return this.f7197t;
    }

    public int getProgress() {
        return this.f7191n;
    }

    public Drawable getProgressBgDrawable() {
        return this.f7198u;
    }

    public Drawable getRetryDrawable() {
        return this.f7201x;
    }

    public Drawable getSucceedDrawable() {
        return this.f7202y;
    }

    public void l(int r10, boolean r11) {
        if (this.f7191n != r10) goto L5;
        return;
    L5:
        this.f7192o.cancel();
        int r12 = this.f7191n;
        int r13 = Math.max(Math.min(r10, 100), 0);
        this.f7191n = r13;
        if (r12 > r13) goto L11;
        if (r11 == false) goto L11;
        this.f7192o.setInterpolator(new LinearInterpolator());
        this.f7192o.setDuration((((long) Math.abs(this.f7191n - r12)) * ((long) this.f7196s)) / 100);
        this.f7192o.setFloatValues(new float[]{r12, this.f7191n});
        this.f7192o.addUpdateListener(new b(this));
        this.f7192o.start();
        return;
    L11:
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        e();
        g();
        f();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r11) {
        super.onDraw(r11);
        if (this.f7185h != null) goto L5;
        this.f7185h = new Paint();
    L5:
        this.f7185h.reset();
        this.f7185h.setAntiAlias(true);
        int r10 = this.f7188k;
        int r12 = r10 / 2;
        int r13 = r10 / 2;
        r11.save();
        Drawable r14 = getLastStateDrawable();
        if (r14 != null) goto L8;
    L14:
        Drawable r15 = getCurrentStateDrawable();
        if (r15 != null) goto L17;
    L31:
        r11.restore();
        if (this.f7192o.isRunning() == true) goto L34;
    L36:
        float r16 = this.f7191n;
    L37:
        float r17 = (r16 * 360.0f) / 100.0f;
        r11.save();
        if (r17 < 360.0f) goto L40;
        this.f7198u.setColorFilter(this.f7193p, PorterDuff.Mode.SRC_IN);
        this.f7198u.draw(r11);
    L41:
        r11.restore();
        return;
    L40:
        this.f7198u.setColorFilter(this.f7194q, PorterDuff.Mode.SRC_IN);
        this.f7198u.draw(r11);
        this.A.reset();
        this.A.moveTo(getWidth() / 2.0f, getHeight() / 2.0f);
        this.A.arcTo(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, r17, false);
        r11.save();
        r11.clipPath(this.A);
        this.f7198u.setColorFilter(this.f7193p, PorterDuff.Mode.SRC_IN);
        this.f7198u.draw(r11);
        r11.restore();
        goto L41
    L34:
        if (this.f7192o.getAnimatedValue() == null) goto L36;
        r16 = ((Float) this.f7192o.getAnimatedValue()).floatValue();
        goto L37
    L17:
        if (k(this.f7183c) == false) goto L19;
        int r18 = this.f7188k;
        r15.setBounds(0, 0, r18, r18);
    L21:
        if (this.f7183c == 0) goto L23;
    L27:
        r15.setAlpha(this.f7186i);
        r15.draw(r11);
        if (k(this.f7183c) == false) goto L31;
        invalidate();
        return;
    L23:
        if (this.B.isRunning() == false) goto L27;
        if (this.B.getAnimatedValue() == null) goto L27;
        r11.save();
        Drawable r19 = this.f7198u;
        r19.setBounds(r15.getBounds());
        r19.setColorFilter(this.f7194q, PorterDuff.Mode.SRC_IN);
        r19.draw(r11);
        r11.restore();
        r11.rotate(((Float) this.B.getAnimatedValue()).floatValue(), r12, r13);
        goto L27
    L19:
        int r20 = this.f7188k;
        int r21 = this.f7190m;
        r15.setBounds((r20 - r21) / 2, (r20 - r21) / 2, (r20 + r21) / 2, (r20 + r21) / 2);
        goto L21
    L8:
        if (this.f7186i == 255) goto L14;
        if (k(this.f7184g) == false) goto L12;
        int r22 = this.f7188k;
        r14.setBounds(0, 0, r22, r22);
    L13:
        r14.setAlpha(255 - this.f7186i);
        r14.draw(r11);
        goto L14
    L12:
        int r23 = Math.min(r14.getIntrinsicWidth(), this.f7190m);
        int r24 = Math.min(r14.getIntrinsicHeight(), this.f7190m);
        int r25 = this.f7188k;
        r14.setBounds((r25 - r23) / 2, (r25 - r24) / 2, (r23 + r25) / 2, (r25 + r24) / 2);
        goto L13
    }

    @Override // android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        if (r12 == Integer.MIN_VALUE) goto L5;
        if (r13 <= 0) goto L5;
    L6:
        this.f7188k = r13;
        int r14 = this.f7188k;
        setMeasuredDimension(r14, r14);
        return;
    L5:
        r13 = this.f7189l;
        goto L6
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setCurrentState(r11.currentState);
        setProgress(r11.progress);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.progress = this.f7191n;
        r10.currentState = this.f7183c;
        return r10;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
        if (r11 != 0) goto L5;
        m();
        return;
    L5:
        f();
    }

    public void setActionColor(int r10) {
        this.f7199v = this.f7199v.mutate();
        this.f7200w = this.f7200w.mutate();
        this.f7201x = this.f7201x.mutate();
        DrawableCompat.setTint(this.f7199v, r10);
        DrawableCompat.setTint(this.f7200w, r10);
        DrawableCompat.setTint(this.f7201x, r10);
    }

    public void setAlphaAnimationDuration(long r10) {
    }

    public void setCurrentState(int r10) {
        int r11 = this.f7183c;
        if (r11 != r10) goto L5;
        return;
    L5:
        this.f7184g = r11;
        this.f7183c = r10;
        invalidate();
        m();
    }

    public void setDownloadDrawable(Drawable r10) {
        this.f7199v = r10;
    }

    public void setFailedDrawable(Drawable r10) {
        this.f7203z = r10;
    }

    public void setPauseDrawable(Drawable r10) {
        this.f7200w = r10;
    }

    @Override // android.view.View
    public void setPressed(boolean r10) {
        super.setPressed(r10);
        invalidate();
    }

    public void setProcessingColor(int r10) {
        Drawable r11 = this.f7197t.mutate();
        this.f7197t = r11;
        DrawableCompat.setTint(r11, r10);
    }

    public void setProcessingDrawable(Drawable r10) {
        this.f7197t = r10;
    }

    public void setProcessingDuration(int r10) {
        this.f7195r = r10;
    }

    public void setProgress(int r10) {
        l(r10, false);
    }

    public void setProgressBackgroundColor(int r10) {
        this.f7194q = r10;
    }

    public void setProgressBgDrawable(Drawable r10) {
        this.f7198u = r10;
    }

    public void setProgressColor(int r10) {
        this.f7193p = r10;
    }

    public void setProgressDuration(int r10) {
        this.f7196s = r10;
    }

    public void setRetryDrawable(Drawable r10) {
        this.f7201x = r10;
    }

    public void setSize(int r10) {
        if (r10 != 0) goto L5;
        this.f7189l = h(48.0f);
        int r11 = h(24.0f);
    L10:
        this.f7190m = r11;
        Drawable r12 = this.f7198u;
        int r13 = this.f7189l;
        r12.setBounds(0, 0, r13, r13);
        invalidate();
        return;
    L5:
        if (r10 == 2) goto L8;
        this.f7189l = h(36.0f);
        float r14 = 16.0f;
    L7:
        r11 = h(r14);
        goto L10
    L8:
        this.f7189l = h(24.0f);
        r14 = 12.0f;
        goto L7
    }

    public void setSucceedDrawable(Drawable r10) {
        this.f7202y = r10;
    }
}
