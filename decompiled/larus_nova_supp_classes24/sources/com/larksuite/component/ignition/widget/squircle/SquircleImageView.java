package com.larksuite.component.ignition.widget.squircle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0014J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0014J\u0010\u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0002J\u001a\u0010.\u001a\u00020$2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010/\u001a\u00020$H\u0002J\f\u00100\u001a\u00020$*\u00020\u001bH\u0002J\f\u00101\u001a\u00020$*\u00020\u001bH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R&\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larksuite/component/ignition/widget/squircle/SquircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "xfermode", "Landroid/graphics/PorterDuffXfermode;", "value", "radius", "getRadius", "()I", "setRadius", "(I)V", "borderWidth", "getBorderWidth", "setBorderWidth", "borderColor", "getBorderColor", "setBorderColor", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "rectPath", "Landroid/graphics/Path;", "squirclePath", "onSizeChanged", "", "w", "h", "oldw", "oldh", "draw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "drawBorder", "applyStyle", "ensurePath", "setBorderMode", "setClipMode", "ignition-widget-squircle_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SquircleImageView extends AppCompatImageView {
    public final PorterDuffXfermode a;
    public int b;
    public int c;
    public int d;
    public final Lazy e;
    public final Path f;
    public final Path g;

    private final Paint getPaint() {
        return (Paint) this.e.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        this.g.reset();
        Path r1 = this.g;
        Rect r9 = new Rect(0, 0, getWidth(), getHeight());
        int r2 = this.b;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r9, "bounds");
        float r3 = r2;
        float r10 = r3 * 0.29289323f;
        float r11 = r10 * 2;
        float r12 = r3 * 1.057191f;
        float r13 = r3 * 2.0f;
        float r14 = r9.width();
        float r15 = r9.height();
        r1.offset(-r9.left, -r9.top);
        r1.moveTo(0.0f, r13);
        r1.cubicTo(0.0f, r12, 0.0f, r11, r10, r10);
        r1.cubicTo(r11, 0.0f, r12, 0.0f, r13, 0.0f);
        float r8 = r14 - r13;
        r1.lineTo(r8, 0.0f);
        float r19 = r14 - r12;
        float r110 = r14 - r11;
        float r20 = r14 - r10;
        r1.cubicTo(r19, 0.0f, r110, 0.0f, r20, r10);
        r1.cubicTo(r14, r11, r14, r12, r14, r13);
        float r16 = r15 - r13;
        r1.lineTo(r14, r16);
        float r17 = r15 - r12;
        float r21 = r15 - r11;
        float r22 = r15 - r10;
        r1.cubicTo(r14, r17, r14, r21, r20, r22);
        r1.cubicTo(r110, r15, r19, r15, r8, r15);
        r1.lineTo(r13, r15);
        r1.cubicTo(r12, r15, r11, r15, r10, r22);
        r1.cubicTo(0.0f, r21, 0.0f, r17, 0.0f, r16);
        r1.lineTo(0.0f, r13);
        r1.close();
        r1.offset(r9.left, r9.top);
        this.f.reset();
        float r4 = 1;
        this.f.addRect(-1.0f, -1.0f, getWidth() + r4, getHeight() + r4, Path.Direction.CW);
        this.f.op(this.g, Path.Op.DIFFERENCE);
    }

    public final int getBorderColor() {
        return this.d;
    }

    public final int getBorderWidth() {
        return this.c;
    }

    public final int getRadius() {
        return this.b;
    }

    public SquircleImageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setBorderMode(Paint r2) {
        r2.setStyle(Paint.Style.STROKE);
        r2.setXfermode(null);
    }

    private final void setClipMode(Paint r2) {
        r2.setStyle(Paint.Style.FILL);
        r2.setXfermode(this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void draw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        int r0 = r8.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super/*android.widget.ImageView*/.draw(r8);
        setClipMode(getPaint());
        r8.drawPath(this.f, getPaint());
        r8.restoreToCount(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super/*android.widget.ImageView*/.onDraw(r4);
        if (this.c <= 0) goto L7;
        setBorderMode(getPaint());
        getPaint().setColor(this.d);
        getPaint().setStrokeWidth(this.c * 2.0f);
        r4.drawPath(this.g, getPaint());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderColor(int r1) {
        this.d = r1;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderWidth(int r1) {
        this.c = r1;
        invalidate();
    }

    public final void setRadius(int r2) {
        if (r2 == this.b) goto L6;
        j();
        this.b = r2;
        return;
    }

    public SquircleImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SquircleImageView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.e = LazyKt.lazy(SquircleImageView$paint$2.INSTANCE);
        this.f = new Path();
        this.g = new Path();
        TypedArray r6 = getContext().obtainStyledAttributes(r4, new int[]{2130969033, 2130969035, 2130973712}, r5, 0);
        setRadius(r6.getDimensionPixelSize(2, this.b));
        setBorderWidth(r6.getDimensionPixelSize(1, this.c));
        setBorderColor(r6.getColor(0, this.d));
        r6.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.ImageView*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        if (r2 != r4) goto L5;
        return;
    L5:
        j();
    }
}
