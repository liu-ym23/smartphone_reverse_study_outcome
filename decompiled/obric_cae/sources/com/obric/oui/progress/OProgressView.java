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
import com.obric.cae.R;

/* JADX INFO: loaded from: classes2.dex */
public class OProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f6478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f6479b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f6480m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RectF f6481n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6482o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6483p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6484q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6485r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6486s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6487t;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6489b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6490m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f6491n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6492o;

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
            this.f6488a = r8.readInt();
            this.f6489b = r8.readInt();
            this.f6490m = r8.readInt();
            this.f6491n = r8.readInt();
            this.f6492o = r8.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r8, int r10) {
            super.writeToParcel(r8, r10);
            r8.writeInt(this.f6488a);
            r8.writeInt(this.f6489b);
            r8.writeInt(this.f6490m);
            r8.writeInt(this.f6491n);
            r8.writeInt(this.f6492o);
        }
    }

    public OProgressView(Context r8, AttributeSet r10) {
        super(r8, r10, 0, 0);
        this.f6479b = new Path();
        this.f6486s = 0;
        this.f6487t = 0;
        TypedArray r11 = r8.obtainStyledAttributes(r10, nb.a.f9501o, 0, 0);
        this.f6483p = r11.getInt(2, 0);
        this.f6486s = r11.getResourceId(3, R.color.oui_fill_highlighted);
        this.f6487t = r11.getResourceId(0, R.color.oui_line_2);
        setProgressBackgroundHeight(r11.getDimensionPixelSize(1, (int) (Resources.getSystem().getDisplayMetrics().density * 6.0f)));
        a();
        r11.recycle();
    }

    public final void a() {
        if (this.f6486s == 0) goto L6;
        Context r8 = getContext();
        int r10 = this.f6486s;
        Object r11 = androidx.core.content.a.f1674a;
        this.f6484q = androidx.core.content.a.c.a(r8, r10);
    L6:
        if (this.f6487t == 0) goto L8;
        Context r12 = getContext();
        int r13 = this.f6487t;
        Object r14 = androidx.core.content.a.f1674a;
        this.f6485r = androidx.core.content.a.c.a(r12, r13);
    L8:
        invalidate();
    }

    public int getBackgroundColor() {
        return this.f6485r;
    }

    public int getProgress() {
        return this.f6483p;
    }

    public int getProgressColor() {
        return this.f6484q;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r8) {
        super.onConfigurationChanged(r8);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        super.onDraw(r8);
        if (this.f6478a != null) goto L5;
        this.f6478a = new Paint();
    L5:
        this.f6478a.reset();
        this.f6478a.setStyle(Paint.Style.FILL);
        this.f6478a.setAntiAlias(true);
        float r10 = getHeight();
        float r11 = (r10 - this.f6482o) / 2.0f;
        if (this.f6480m != null) goto L8;
        this.f6480m = new RectF();
    L8:
        float r12 = r10 - r11;
        this.f6480m.set(0.0f, r11, getWidth(), r12);
        if (this.f6481n != null) goto L11;
        this.f6481n = new RectF();
    L11:
        this.f6481n.set(0.0f, r11, (getProgress() * getWidth()) / 100.0f, r12);
        r8.save();
        Path r13 = this.f6479b;
        r13.reset();
        RectF r14 = this.f6480m;
        float r15 = this.f6482o;
        r13.addRoundRect(r14, r15, r15, Path.Direction.CW);
        r8.clipPath(r13);
        this.f6478a.setColor(this.f6485r);
        r8.drawRect(this.f6480m, this.f6478a);
        this.f6478a.setColor(this.f6484q);
        r8.drawRect(this.f6481n, this.f6478a);
        r8.restore();
    }

    @Override // android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r8) {
        SavedState r10 = (SavedState) r8;
        super.onRestoreInstanceState(r10.getSuperState());
        setProgress(r10.f6488a);
        this.f6486s = r10.f6489b;
        this.f6487t = r10.f6490m;
        this.f6484q = r10.f6491n;
        this.f6485r = r10.f6492o;
        a();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r8 = new SavedState(super.onSaveInstanceState());
        r8.f6488a = this.f6483p;
        r8.f6489b = this.f6486s;
        r8.f6490m = this.f6487t;
        r8.f6491n = this.f6484q;
        r8.f6492o = this.f6485r;
        return r8;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r8) {
        this.f6487t = 0;
        this.f6485r = r8;
        invalidate();
    }

    public void setProgress(int r8) {
        if (this.f6483p != r8) goto L5;
        return;
    L5:
        if (r8 > 0) goto L8;
        r8 = 0;
    L10:
        this.f6483p = r8;
        invalidate();
        return;
    L8:
        if (r8 < 100) goto L10;
        r8 = 100;
        goto L10
    }

    public void setProgressBackgroundHeight(float r8) {
        this.f6482o = r8;
    }

    public void setProgressColor(int r8) {
        this.f6486s = 0;
        this.f6484q = r8;
        invalidate();
    }
}
