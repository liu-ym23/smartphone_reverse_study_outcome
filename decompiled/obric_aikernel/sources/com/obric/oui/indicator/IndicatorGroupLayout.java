package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o9.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/indicator/IndicatorGroupLayout;", "Landroid/widget/LinearLayout;", "", "draw", "", "setDrawBackground", "", EventBody.KEY_VALUE, "j", "I", "getBgColor", "()I", "setBgColor", "(I)V", "bgColor", "i", "getCornerRadius", "setCornerRadius", "cornerRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class IndicatorGroupLayout extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f6782c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f6783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6786j;

    @JvmOverloads
    public IndicatorGroupLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public IndicatorGroupLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public IndicatorGroupLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6782c = new RectF();
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.FILL);
        Unit r14 = Unit.INSTANCE;
        this.f6783g = r13;
        setBackgroundColor(0);
    }

    public /* synthetic */ IndicatorGroupLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final int getBgColor() {
        return this.f6786j;
    }

    public final int getCornerRadius() {
        return this.f6785i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        if (this.f6784h == false) goto L5;
        this.f6782c.set(0.0f, 0.0f, getWidth(), getHeight());
        q.i(r10, this.f6782c, this.f6785i * 1.0f, this.f6783g);
    L5:
        super.onDraw(r10);
    }

    public final void setBgColor(int r10) {
        if (this.f6786j == r10) goto L5;
        this.f6786j = r10;
    L5:
        this.f6783g.setColor(r10);
    }

    public final void setCornerRadius(int r10) {
        this.f6785i = r10;
    }

    public final void setDrawBackground(boolean r10) {
        this.f6784h = r10;
        invalidate();
    }
}
