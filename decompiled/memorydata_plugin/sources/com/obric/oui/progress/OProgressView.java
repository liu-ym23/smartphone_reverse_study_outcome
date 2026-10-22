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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class OProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f14403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Path f14404b;
    private RectF c;
    private RectF d;
    private float e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    /* JADX INFO: renamed from: com.obric.oui.progress.OProgressView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int backgroundColor;
        int backgroundColorRes;
        int progress;
        int progressColor;
        int progressColorRes;

        static {
            CREATOR = new AnonymousClass1();
        }

        private SavedState(Parcel r2) {
            super(r2);
            this.progress = r2.readInt();
            this.progressColorRes = r2.readInt();
            this.backgroundColorRes = r2.readInt();
            this.progressColor = r2.readInt();
            this.backgroundColor = r2.readInt();
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
            r1.writeInt(this.progressColorRes);
            r1.writeInt(this.backgroundColorRes);
            r1.writeInt(this.progressColor);
            r1.writeInt(this.backgroundColor);
        }
    }

    public OProgressView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public OProgressView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public OProgressView(Context r3, AttributeSet r4, int r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5, 0);
    }

    public OProgressView(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r7, r8, r5, r6);
        this.f14404b = new Path();
        this.i = 0;
        this.j = 0;
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.OProgressView, r5, r6);
        this.f = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OProgressView_oui_progress, "styleable", "OProgressView_oui_progress"), 0);
        this.i = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OProgressView_oui_progress_color, "styleable", "OProgressView_oui_progress_color"), ZeusTransformUtils.mapRes(R.color.oui_fill_highlighted, TypedValues.Custom.S_COLOR, "oui_fill_highlighted"));
        this.j = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OProgressView_oui_background_color, "styleable", "OProgressView_oui_background_color"), ZeusTransformUtils.mapRes(R.color.oui_line_2, TypedValues.Custom.S_COLOR, "oui_line_2"));
        setProgressBackgroundHeight(r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OProgressView_oui_background_height, "styleable", "OProgressView_oui_background_height"), a(6.0f)));
        a();
        r9.recycle();
    }

    private int a(float r1) {
        return (int) (r1 * Resources.getSystem().getDisplayMetrics().density);
    }

    private void a() {
        if (this.i == 0) goto L6;
        this.g = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.i);
    L6:
        if (this.j == 0) goto L8;
        this.h = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.j);
    L8:
        invalidate();
    }

    public int getBackgroundColor() {
        return this.h;
    }

    public int getProgress() {
        return this.f;
    }

    public int getProgressColor() {
        return this.g;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        a();
    }

    @Override // android.view.View
    public void onDraw(Canvas r6) {
        super.onDraw(r6);
        if (this.f14403a != null) goto L5;
        this.f14403a = new Paint();
    L5:
        this.f14403a.reset();
        this.f14403a.setStyle(Paint.Style.FILL);
        this.f14403a.setAntiAlias(true);
        float r0 = getHeight();
        float r1 = (r0 - this.e) / 2.0f;
        if (this.c != null) goto L8;
        this.c = new RectF();
    L8:
        float r2 = r0 - r1;
        this.c.set(0.0f, r1, getWidth(), r2);
        if (this.d != null) goto L11;
        this.d = new RectF();
    L11:
        this.d.set(0.0f, r1, (getWidth() * getProgress()) / 100.0f, r2);
        r6.save();
        this.f14404b.reset();
        Path r3 = this.f14404b;
        RectF r4 = this.c;
        float r5 = this.e;
        r3.addRoundRect(r4, r5, r5, Path.Direction.CW);
        r6.clipPath(this.f14404b);
        this.f14403a.setColor(this.h);
        r6.drawRect(this.c, this.f14403a);
        this.f14403a.setColor(this.g);
        r6.drawRect(this.d, this.f14403a);
        r6.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        SavedState r4 = (SavedState) ZeusTransformUtils.preCheckCast((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin"), SavedState.class, "com.obric.memorydata.plugin");
        super.onRestoreInstanceState(r4.getSuperState());
        setProgress(r4.progress);
        this.i = r4.progressColorRes;
        this.j = r4.backgroundColorRes;
        this.g = r4.progressColor;
        this.h = r4.backgroundColor;
        a();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.progress = this.f;
        r1.progressColorRes = this.i;
        r1.backgroundColorRes = this.j;
        r1.progressColor = this.g;
        r1.backgroundColor = this.h;
        return r1;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r2) {
        this.j = 0;
        this.h = r2;
        invalidate();
    }

    public void setProgress(int r2) {
        if (this.f != r2) goto L6;
        return;
    L6:
        if (r2 > 0) goto L8;
        r2 = 0;
    L10:
        this.f = r2;
        invalidate();
        return;
    L8:
        if (r2 < 100) goto L10;
        r2 = 100;
        goto L10
    }

    public void setProgressBackgroundHeight(float r1) {
        this.e = r1;
    }

    public void setProgressColor(int r2) {
        this.i = 0;
        this.g = r2;
        invalidate();
    }
}
