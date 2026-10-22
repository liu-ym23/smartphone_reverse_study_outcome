package com.obric.oui.progress;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import u8.c;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
public class OProgressView extends View {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f7207c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Path f7208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RectF f7209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RectF f7210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f7211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7213l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7215n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7216o;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int backgroundColor;
        int backgroundColorRes;
        int progress;
        int progressColor;
        int progressColorRes;

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
            this.progressColorRes = r10.readInt();
            this.backgroundColorRes = r10.readInt();
            this.progressColor = r10.readInt();
            this.backgroundColor = r10.readInt();
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
            r10.writeInt(this.progressColorRes);
            r10.writeInt(this.backgroundColorRes);
            r10.writeInt(this.progressColor);
            r10.writeInt(this.backgroundColor);
        }
    }

    static /* synthetic */ class a {
    }

    public OProgressView(Context r10) {
        this(r10, null);
    }

    public OProgressView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public OProgressView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0);
    }

    public OProgressView(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.f7208g = new Path();
        this.f7215n = 0;
        this.f7216o = 0;
        TypedArray r14 = r10.obtainStyledAttributes(r11, l.OProgressView, r12, r13);
        this.f7212k = r14.getInt(l.OProgressView_oui_progress, 0);
        this.f7215n = r14.getResourceId(l.OProgressView_oui_progress_color, c.oui_fill_highlighted);
        this.f7216o = r14.getResourceId(l.OProgressView_oui_background_color, c.oui_line_2);
        setProgressBackgroundHeight(r14.getDimensionPixelSize(l.OProgressView_oui_background_height, a(6.0f)));
        b();
        r14.recycle();
    }

    private int a(float r10) {
        return (int) (r10 * Resources.getSystem().getDisplayMetrics().density);
    }

    private void b() {
        if (this.f7215n == 0) goto L6;
        this.f7213l = ContextCompat.getColor(getContext(), this.f7215n);
    L6:
        if (this.f7216o == 0) goto L8;
        this.f7214m = ContextCompat.getColor(getContext(), this.f7216o);
    L8:
        invalidate();
    }

    public int getBackgroundColor() {
        return this.f7214m;
    }

    public int getProgress() {
        return this.f7212k;
    }

    public int getProgressColor() {
        return this.f7213l;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        b();
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (this.f7207c != null) goto L5;
        this.f7207c = new Paint();
    L5:
        this.f7207c.reset();
        this.f7207c.setStyle(Paint.Style.FILL);
        this.f7207c.setAntiAlias(true);
        float r11 = getHeight();
        float r12 = (r11 - this.f7211j) / 2.0f;
        if (this.f7209h != null) goto L8;
        this.f7209h = new RectF();
    L8:
        float r13 = r11 - r12;
        this.f7209h.set(0.0f, r12, getWidth(), r13);
        if (this.f7210i != null) goto L11;
        this.f7210i = new RectF();
    L11:
        this.f7210i.set(0.0f, r12, (getWidth() * getProgress()) / 100.0f, r13);
        r10.save();
        this.f7208g.reset();
        Path r14 = this.f7208g;
        RectF r15 = this.f7209h;
        float r16 = this.f7211j;
        r14.addRoundRect(r15, r16, r16, Path.Direction.CW);
        r10.clipPath(this.f7208g);
        this.f7207c.setColor(this.f7214m);
        r10.drawRect(this.f7209h, this.f7207c);
        this.f7207c.setColor(this.f7213l);
        r10.drawRect(this.f7210i, this.f7207c);
        r10.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        setProgress(r11.progress);
        this.f7215n = r11.progressColorRes;
        this.f7216o = r11.backgroundColorRes;
        this.f7213l = r11.progressColor;
        this.f7214m = r11.backgroundColor;
        b();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        r10.progress = this.f7212k;
        r10.progressColorRes = this.f7215n;
        r10.backgroundColorRes = this.f7216o;
        r10.progressColor = this.f7213l;
        r10.backgroundColor = this.f7214m;
        return r10;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        this.f7216o = 0;
        this.f7214m = r10;
        invalidate();
    }

    public void setProgress(int r10) {
        if (this.f7212k != r10) goto L6;
        return;
    L6:
        if (r10 > 0) goto L8;
        r10 = 0;
    L10:
        this.f7212k = r10;
        invalidate();
        return;
    L8:
        if (r10 < 100) goto L10;
        r10 = 100;
        goto L10
    }

    public void setProgressBackgroundHeight(float r10) {
        this.f7211j = r10;
    }

    public void setProgressColor(int r10) {
        this.f7215n = 0;
        this.f7213l = r10;
        invalidate();
    }
}
