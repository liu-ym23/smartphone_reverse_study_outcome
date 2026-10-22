package com.ss.android.lark.image.compose.common;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u0005H\u0014J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0014R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/image/compose/common/CirclePlaceholderPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "", "strokeColor", "<init>", "(JFJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyAlpha", "", "applyColorFilter", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CirclePlaceholderPainter extends Painter {
    public final long a;
    public final float b;
    public final long c;
    public final long d;
    public float e;
    public ColorFilter f;

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public final long m758getIntrinsicSizeNHjbRc() {
        return this.d;
    }

    public final boolean applyAlpha(float r1) {
        this.e = r1;
        return true;
    }

    public final boolean applyColorFilter(ColorFilter r1) {
        this.f = r1;
        return true;
    }

    public final void onDraw(DrawScope r24) {
        Intrinsics.checkNotNullParameter(r24, "<this>");
        float r13 = 2;
        float r1 = RangesKt.coerceAtMost(Float.intBitsToFloat((int) (r24.getSize-NH-jbRc() >> 32)), Float.intBitsToFloat((int) (r24.getSize-NH-jbRc() & 4294967295L))) / r13;
        float r18 = Float.intBitsToFloat((int) (r24.getSize-NH-jbRc() >> 32)) / r13;
        float r19 = Float.intBitsToFloat((int) (r24.getSize-NH-jbRc() & 4294967295L)) / r13;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r24, this.a, r1, Offset.constructor-impl((Float.floatToRawIntBits(r18) << 32) | (((long) Float.floatToRawIntBits(r19)) & 4294967295L)), this.e, null, this.f, 0, 80, null);
        float r2 = this.b;
        if (r2 <= 0.0f) goto L6;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r24, this.c, r1 - (r2 / r13), Offset.constructor-impl((Float.floatToRawIntBits(r18) << 32) | (((long) Float.floatToRawIntBits(r19)) & 4294967295L)), this.e, new Stroke(this.b, 0.0f, 0, 0, null, 30, null), this.f, 0, 64, null);
        return;
    }

    public CirclePlaceholderPainter(long r1, float r3, long r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = Size.Companion.getUnspecified-NH-jbRc();
        this.e = 1.0f;
    }
}
