package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.obric.common.oui.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\rJ\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/segmentedtab/UnReadMsgView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cornerRadius", "", "setCornerRadius", "(I)V", "strokeWidth", "setStrokeWidth", "backgroundColor", "setBackgroundColor", "strokeColor", "setStrokeColor", "", "isRadiusHalfHeight", "setIsRadiusHalfHeight", "(Z)V", "isWidthHeightEqual", "setIsWidthHeightEqual", "getBackgroundColor", "()I", "getCornerRadius", "getStrokeWidth", "getStrokeColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnReadMsgView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f14361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14363c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;

    @JvmOverloads
    public UnReadMsgView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    private final void setCornerRadius(int r5) {
        this.f14363c = (int) ((r5 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        a();
    }

    private final void setStrokeWidth(int r5) {
        this.d = (int) ((r5 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        a();
    }

    public final void a() {
        StateListDrawable r5 = new StateListDrawable();
        GradientDrawable r10 = this.f14361a;
        int r11 = this.f14362b;
        int r12 = this.e;
        r10.setColor(r11);
        r10.setCornerRadius(this.f14363c);
        r10.setStroke(this.d, r12);
        r5.addState(new int[]{-16842919}, r10);
        setBackground(r5);
    }

    public final int getBackgroundColor() {
        return this.f14362b;
    }

    public final int getCornerRadius() {
        return this.f14363c;
    }

    public final int getStrokeColor() {
        return this.e;
    }

    public final int getStrokeWidth() {
        return this.d;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (this.f == false) goto L5;
        setCornerRadius(getHeight() / 2);
        return;
    L5:
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r5, int r10) {
        if (this.g == true) goto L5;
    L10:
        super.onMeasure(r5, r10);
        return;
    L5:
        if (getWidth() <= 0) goto L10;
        if (getHeight() <= 0) goto L10;
        int r11 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast(getWidth(), getHeight()), BasicMeasure.EXACTLY);
        super.onMeasure(r11, r11);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r5) {
        this.f14362b = r5;
        a();
    }

    public final void setIsRadiusHalfHeight(boolean r5) {
        this.f = r5;
        a();
    }

    public final void setIsWidthHeightEqual(boolean r5) {
        this.g = r5;
        a();
    }

    public final void setStrokeColor(int r5) {
        this.e = r5;
        a();
    }

    @JvmOverloads
    public UnReadMsgView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ UnReadMsgView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public UnReadMsgView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14361a = new GradientDrawable();
        TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.MsgView);
        this.f14362b = r12.getColor(R$styleable.MsgView_mv_backgroundColor, 0);
        this.f14363c = r12.getDimensionPixelSize(R$styleable.MsgView_mv_cornerRadius, 0);
        this.d = r12.getDimensionPixelSize(R$styleable.MsgView_mv_strokeWidth, 0);
        this.e = r12.getColor(R$styleable.MsgView_mv_strokeColor, 0);
        this.f = r12.getBoolean(R$styleable.MsgView_mv_isRadiusHalfHeight, false);
        this.g = r12.getBoolean(R$styleable.MsgView_mv_isWidthHeightEqual, false);
        r12.recycle();
    }
}
