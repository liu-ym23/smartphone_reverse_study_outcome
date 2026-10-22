package com.obric.oui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.crash.entity.EventBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o9.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R*\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR*\u0010\u001c\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u00158\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00158\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001b¨\u0006("}, d2 = {"Lcom/obric/oui/indicator/IndicatorDotView;", "Landroid/view/View;", "Lcom/obric/oui/indicator/b;", "", "width", "", "setWidth", "horizontalMargin", "setHorizontalMargin", EventBody.KEY_VALUE, "j", "I", "getDotColor", "()I", "setDotColor", "(I)V", "dotColor", "k", "getStrokeColor", "setStrokeColor", "strokeColor", "", "l", "F", "getStrokeWidth", "()F", "setStrokeWidth", "(F)V", "strokeWidth", "m", "getCornerRadius", "setCornerRadius", "cornerRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class IndicatorDotView extends View implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f6774c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RectF f6775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f6776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f6777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f6780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f6781m;

    @JvmOverloads
    public IndicatorDotView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public IndicatorDotView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public IndicatorDotView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6774c = new RectF();
        this.f6775g = new RectF();
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.FILL);
        Unit r14 = Unit.INSTANCE;
        this.f6776h = r13;
        Paint r15 = new Paint(1);
        r15.setStyle(Paint.Style.STROKE);
        this.f6777i = r15;
        this.f6778j = -7829368;
    }

    public /* synthetic */ IndicatorDotView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public float getCornerRadius() {
        return this.f6781m;
    }

    public int getDotColor() {
        return this.f6778j;
    }

    public int getStrokeColor() {
        return this.f6779k;
    }

    public float getStrokeWidth() {
        return this.f6780l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        this.f6774c.set(0.0f, 0.0f, getWidth(), getHeight());
        q.i(r10, this.f6774c, getCornerRadius(), this.f6776h);
        if (getStrokeWidth() <= 0) goto L6;
        float r11 = 2;
        this.f6775g.set(getStrokeWidth() / r11, getStrokeWidth() / r11, getWidth() - (getStrokeWidth() / r11), getHeight() - (getStrokeWidth() / r11));
        q.i(r10, this.f6775g, getCornerRadius(), this.f6777i);
        return;
    }

    @Override // com.obric.oui.indicator.b
    public void setCornerRadius(float r10) {
        this.f6781m = r10;
    }

    @Override // com.obric.oui.indicator.b
    public void setDotColor(int r10) {
        if (this.f6778j == r10) goto L5;
        this.f6778j = r10;
    L5:
        this.f6776h.setColor(r10);
    }

    @Override // com.obric.oui.indicator.b
    public void setHorizontalMargin(int r10) {
        a.c(this, r10);
    }

    @Override // com.obric.oui.indicator.b
    public void setStrokeColor(int r10) {
        if (this.f6779k == r10) goto L5;
        this.f6779k = r10;
    L5:
        this.f6777i.setColor(r10);
    }

    @Override // com.obric.oui.indicator.b
    public void setStrokeWidth(float r10) {
        if (this.f6780l == r10) goto L5;
        this.f6780l = r10;
    L5:
        this.f6777i.setStrokeWidth(r10);
    }

    @Override // com.obric.oui.indicator.b
    public void setWidth(int r10) {
        a.d(this, r10);
    }
}
