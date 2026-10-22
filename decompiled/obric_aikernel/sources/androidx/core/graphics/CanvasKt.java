package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas r10, float r11, float r12, float r13, float r14, Function1<? super Canvas, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r15, "block");
        int r16 = r10.save();
        r10.clipRect(r11, r12, r13, r14);
        r15.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r10, int r11, int r12, int r13, int r14, Function1<? super Canvas, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r15, "block");
        int r16 = r10.save();
        r10.clipRect(r11, r12, r13, r14);
        r15.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r10, Path r11, Function1<? super Canvas, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "clipPath");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r13 = r10.save();
        r10.clipPath(r11);
        r12.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r13);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r13);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r10, Rect r11, Function1<? super Canvas, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "clipRect");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r13 = r10.save();
        r10.clipRect(r11);
        r12.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r13);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r13);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r10, RectF r11, Function1<? super Canvas, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "clipRect");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r13 = r10.save();
        r10.clipRect(r11);
        r12.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r13);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r13);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withMatrix(Canvas r10, Matrix r11, Function1<? super Canvas, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "matrix");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r13 = r10.save();
        r10.concat(r11);
        r12.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r13);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r13);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withMatrix$default(Canvas r10, Matrix r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = new Matrix();
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "matrix");
        Intrinsics.checkNotNullParameter(r12, "block");
        int r15 = r10.save();
        r10.concat(r11);
        r12.invoke(r10);     // Catch: Throwable -> L9
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r15);
        InlineMarker.finallyEnd(1);
        return;
    L9:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r15);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withRotation(Canvas r10, float r11, float r12, float r13, Function1<? super Canvas, Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r14, "block");
        int r15 = r10.save();
        r10.rotate(r11, r12, r13);
        r14.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r15);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r15);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withRotation$default(Canvas r10, float r11, float r12, float r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = 0.0f;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = 0.0f;
    L9:
        if ((r15 & 4) == 0) goto L11;
        r13 = 0.0f;
    L11:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r14, "block");
        int r17 = r10.save();
        r10.rotate(r11, r12, r13);
        r14.invoke(r10);     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r17);
        InlineMarker.finallyEnd(1);
        return;
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r17);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withSave(Canvas r10, Function1<? super Canvas, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "block");
        int r12 = r10.save();
        r11.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r12);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r12);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withScale(Canvas r10, float r11, float r12, float r13, float r14, Function1<? super Canvas, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r15, "block");
        int r16 = r10.save();
        r10.scale(r11, r12, r13, r14);
        r15.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withScale$default(Canvas r10, float r11, float r12, float r13, float r14, Function1 r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = 1.0f;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r12 = 1.0f;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r13 = 0.0f;
    L12:
        if ((r16 & 8) == 0) goto L14;
        r14 = 0.0f;
    L14:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r15, "block");
        int r18 = r10.save();
        r10.scale(r11, r12, r13, r14);
        r15.invoke(r10);     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r18);
        InlineMarker.finallyEnd(1);
        return;
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r18);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withSkew(Canvas r10, float r11, float r12, Function1<? super Canvas, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "block");
        int r14 = r10.save();
        r10.skew(r11, r12);
        r13.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r14);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r14);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withSkew$default(Canvas r10, float r11, float r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0.0f;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r12 = 0.0f;
    L8:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "block");
        int r16 = r10.save();
        r10.skew(r11, r12);
        r13.invoke(r10);     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        return;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withTranslation(Canvas r10, float r11, float r12, Function1<? super Canvas, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "block");
        int r14 = r10.save();
        r10.translate(r11, r12);
        r13.invoke(r10);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r14);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r14);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withTranslation$default(Canvas r10, float r11, float r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = 0.0f;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r12 = 0.0f;
    L8:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "block");
        int r16 = r10.save();
        r10.translate(r11, r12);
        r13.invoke(r10);     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        return;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r10.restoreToCount(r16);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
