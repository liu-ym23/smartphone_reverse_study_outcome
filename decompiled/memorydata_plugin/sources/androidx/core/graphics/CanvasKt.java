package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aD\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aN\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u001e"}, d2 = {"withClip", "", "Landroid/graphics/Canvas;", "clipPath", "Landroid/graphics/Path;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CanvasKt {
    public static final void withClip(Canvas r2, float r3, float r4, float r5, float r6, Function1<? super Canvas, Unit> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.clipRect(r3, r4, r5, r6);
        r8.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r2, int r3, int r4, int r5, int r6, Function1<? super Canvas, Unit> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.clipRect(r3, r4, r5, r6);
        r8.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r2, Path r3, Function1<? super Canvas, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.clipPath(r3);
        r5.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r2, Rect r3, Function1<? super Canvas, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.clipRect(r3);
        r5.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withClip(Canvas r2, RectF r3, Function1<? super Canvas, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.clipRect(r3);
        r5.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withMatrix(Canvas r2, Matrix r3, Function1<? super Canvas, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.concat(r3);
        r5.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withMatrix$default(Canvas r1, Matrix r2, Function1 r3, int r4, Object r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = new Matrix();
    L5:
        int r7 = r1.save();
        r1.concat(r2);
        r6.invoke(r1);     // Catch: Throwable -> L9
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r7);
        InlineMarker.finallyEnd(1);
        return;
    L9:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r7);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withRotation(Canvas r2, float r3, float r4, float r5, Function1<? super Canvas, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.rotate(r3, r4, r5);
        r7.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withRotation$default(Canvas r1, float r2, float r3, float r4, Function1 r5, int r6, Object r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0.0f;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r4 = 0.0f;
    L11:
        int r9 = r1.save();
        r1.rotate(r2, r3, r4);
        r8.invoke(r1);     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r9);
        InlineMarker.finallyEnd(1);
        return;
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r9);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withSave(Canvas r2, Function1<? super Canvas, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r4.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withScale(Canvas r2, float r3, float r4, float r5, float r6, Function1<? super Canvas, Unit> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.scale(r3, r4, r5, r6);
        r8.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withScale$default(Canvas r1, float r2, float r3, float r4, float r5, Function1 r6, int r7, Object r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        if ((r7 & 1) == 0) goto L6;
        r2 = 1.0f;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 1.0f;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = 0.0f;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r5 = 0.0f;
    L14:
        int r10 = r1.save();
        r1.scale(r2, r3, r4, r5);
        r9.invoke(r1);     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r10);
        InlineMarker.finallyEnd(1);
        return;
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r10);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withSkew(Canvas r2, float r3, float r4, Function1<? super Canvas, Unit> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.skew(r3, r4);
        r6.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withSkew$default(Canvas r1, float r2, float r3, Function1 r4, int r5, Object r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = 0.0f;
    L8:
        int r8 = r1.save();
        r1.skew(r2, r3);
        r7.invoke(r1);     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r8);
        InlineMarker.finallyEnd(1);
        return;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r8);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void withTranslation(Canvas r2, float r3, float r4, Function1<? super Canvas, Unit> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        int r0 = r2.save();
        r2.translate(r3, r4);
        r6.invoke(r2);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r2.restoreToCount(r0);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void withTranslation$default(Canvas r1, float r2, float r3, Function1 r4, int r5, Object r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 0.0f;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = 0.0f;
    L8:
        int r8 = r1.save();
        r1.translate(r2, r3);
        r7.invoke(r1);     // Catch: Throwable -> L12
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r8);
        InlineMarker.finallyEnd(1);
        return;
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.restoreToCount(r8);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
