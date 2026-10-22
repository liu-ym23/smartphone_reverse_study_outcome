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
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class OProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f14212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f14213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f14214c;
    public RectF d;
    public float e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14217j;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14220c;
        public int d;
        public int e;

        static {
            CREATOR = new c();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.f14218a);
            r5.writeInt(this.f14219b);
            r5.writeInt(this.f14220c);
            r5.writeInt(this.d);
            r5.writeInt(this.e);
        }
    }

    public OProgressView(Context r5) {
        this(r5, null);
    }

    public final void a() {
        if (this.f14216i == 0) goto L6;
        this.g = ContextCompat.getColor(getContext(), this.f14216i);
    L6:
        if (this.f14217j == 0) goto L8;
        this.f14215h = ContextCompat.getColor(getContext(), this.f14217j);
    L8:
        invalidate();
    }

    public int getBackgroundColor() {
        return this.f14215h;
    }

    public int getProgress() {
        return this.f;
    }

    public int getProgressColor() {
        return this.g;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (this.f14212a != null) goto L5;
        this.f14212a = new Paint();
    L5:
        this.f14212a.reset();
        this.f14212a.setStyle(Paint.Style.FILL);
        this.f14212a.setAntiAlias(true);
        float r5 = getHeight();
        float r11 = (r5 - this.e) / 2.0f;
        if (this.f14214c != null) goto L8;
        this.f14214c = new RectF();
    L8:
        float r12 = r5 - r11;
        this.f14214c.set(0.0f, r11, getWidth(), r12);
        if (this.d != null) goto L11;
        this.d = new RectF();
    L11:
        this.d.set(0.0f, r11, (getProgress() * getWidth()) / 100.0f, r12);
        r10.save();
        Path r13 = this.f14213b;
        r13.reset();
        RectF r14 = this.f14214c;
        float r15 = this.e;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        r10.clipPath(r13);
        this.f14212a.setColor(this.f14215h);
        r10.drawRect(this.f14214c, this.f14212a);
        this.f14212a.setColor(this.g);
        r10.drawRect(this.d, this.f14212a);
        r10.restore();
    }

    @Override // android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setProgress(r10.f14218a);
        this.f14216i = r10.f14219b;
        this.f14217j = r10.f14220c;
        this.g = r10.d;
        this.f14215h = r10.e;
        a();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.f14218a = this.f;
        r5.f14219b = this.f14216i;
        r5.f14220c = this.f14217j;
        r5.d = this.g;
        r5.e = this.f14215h;
        return r5;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        this.f14217j = 0;
        this.f14215h = r5;
        invalidate();
    }

    public void setProgress(int r5) {
        if (this.f != r5) goto L5;
        return;
    L5:
        if (r5 > 0) goto L8;
        r5 = 0;
    L10:
        this.f = r5;
        invalidate();
        return;
    L8:
        if (r5 < 100) goto L10;
        r5 = 100;
        goto L10
    }

    public void setProgressBackgroundHeight(float r5) {
        this.e = r5;
    }

    public void setProgressColor(int r5) {
        this.f14216i = 0;
        this.g = r5;
        invalidate();
    }

    public OProgressView(Context r5, AttributeSet r10) {
        this(r5, r10, 0);
    }

    public OProgressView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11, 0);
        this.f14213b = new Path();
        this.f14216i = 0;
        this.f14217j = 0;
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.OProgressView, r11, 0);
        this.f = r12.getInt(R$styleable.OProgressView_oui_progress, 0);
        this.f14216i = r12.getResourceId(R$styleable.OProgressView_oui_progress_color, R$color.oui_fill_highlighted);
        this.f14217j = r12.getResourceId(R$styleable.OProgressView_oui_background_color, R$color.oui_line_2);
        setProgressBackgroundHeight(r12.getDimensionPixelSize(R$styleable.OProgressView_oui_background_height, (int) (6.0f * Resources.getSystem().getDisplayMetrics().density)));
        a();
        r12.recycle();
    }
}
