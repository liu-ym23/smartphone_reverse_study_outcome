package com.ss.android.lark.image.compose.android_platform;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\u0012\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,H\u0014J\f\u0010/\u001a\u00020 *\u000200H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010-\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0015¨\u00061"}, d2 = {"Lcom/ss/android/lark/image/compose/android_platform/DrawablePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "<set-?>", "", "drawInvalidateTick", "getDrawInvalidateTick", "()I", "setDrawInvalidateTick", "(I)V", "drawInvalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/geometry/Size;", "drawableIntrinsicSize", "getDrawableIntrinsicSize-NH-jbRc", "()J", "setDrawableIntrinsicSize-uvyYCjk", "(J)V", "drawableIntrinsicSize$delegate", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "callback$delegate", "Lkotlin/Lazy;", "onRemembered", "", "onAbandoned", "onForgotten", "applyAlpha", "", "alpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyLayoutDirection", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DrawablePainter extends Painter implements RememberObserver {
    public final Drawable a;
    public final MutableState b;
    public final MutableState c;
    public final Lazy d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            r0[LayoutDirection.Ltr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[LayoutDirection.Rtl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public final long m755getIntrinsicSizeNHjbRc() {
        return ((Size) this.c.getValue()).unbox-impl();
    }

    public final void onForgotten() {
        Object r0 = this.a;
        if ((r0 instanceof Animatable) == false) goto L5;
        ((Animatable) r0).stop();
    L5:
        this.a.setVisible(false, false);
        this.a.setCallback(null);
    }

    public final void onRemembered() {
        this.a.setCallback((Drawable.Callback) this.d.getValue());
        this.a.setVisible(true, true);
        Object r0 = this.a;
        if ((r0 instanceof Animatable) == false) goto L6;
        ((Animatable) r0).start();
        return;
    }

    public final void onAbandoned() {
        onForgotten();
    }

    public DrawablePainter(Drawable r7) {
        Intrinsics.checkNotNullParameter(r7, "drawable");
        this.a = r7;
        this.b = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.c = SnapshotStateKt.mutableStateOf$default(Size.box-impl(BaseImageComponentKt.b(r7)), null, 2, null);
        this.d = LazyKt.lazy(new DrawablePainter$callback$2(this));
        if (r7.getIntrinsicWidth() >= 0) goto L5;
        return;
    L5:
        if (r7.getIntrinsicHeight() < 0) goto L9;
        r7.setBounds(0, 0, r7.getIntrinsicWidth(), r7.getIntrinsicHeight());
        return;
    }

    public final boolean applyAlpha(float r4) {
        this.a.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(r4 * 255), 0, 255));
        return true;
    }

    public final boolean applyColorFilter(ColorFilter r2) {
        Drawable r0 = this.a;
        if (r2 == null) goto L5;
        android.graphics.ColorFilter r3 = AndroidColorFilter_androidKt.asAndroidColorFilter(r2);
    L6:
        r0.setColorFilter(r3);
        return true;
    L5:
        r3 = null;
        goto L6
    }

    public final boolean applyLayoutDirection(LayoutDirection r4) {
        Intrinsics.checkNotNullParameter(r4, "layoutDirection");
        int r2 = 0;
        if (Build.VERSION.SDK_INT < 23) goto L13;
        Drawable r0 = this.a;
        int r5 = a.a[r4.ordinal()];
        if (r5 == 1) goto L12;
        if (r5 != 2) goto L10;
        r2 = 1;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        return r0.setLayoutDirection(r2);
    L13:
        return false;
    }

    public final void onDraw(DrawScope r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Canvas r0 = r8.getDrawContext().getCanvas();
        ((Number) this.b.getValue()).intValue();
        this.a.setBounds(0, 0, MathKt.roundToInt(Float.intBitsToFloat((int) (r8.getSize-NH-jbRc() >> 32))), MathKt.roundToInt(Float.intBitsToFloat((int) (r8.getSize-NH-jbRc() & 4294967295L))));
        r0.save();     // Catch: Throwable -> L6
        this.a.draw(AndroidCanvas_androidKt.getNativeCanvas(r0));     // Catch: Throwable -> L6
        r0.restore();
        return;
    L6:
        th = move-exception;
        r0.restore();
        throw th;
    }
}
