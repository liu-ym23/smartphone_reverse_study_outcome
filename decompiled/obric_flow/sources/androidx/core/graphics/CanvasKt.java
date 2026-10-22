package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.constraintlayout.motion.widget.a;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\n2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a0\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aD\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001aN\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b\u001a:\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¨\u0006\u001e"}, d2 = {"withClip", "", "Landroid/graphics/Canvas;", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipRect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", OpenPageMethod.ALIGN_LEFT, "", "top", "right", "bottom", "", "withMatrix", "matrix", "Landroid/graphics/Matrix;", "withRotation", "degrees", "pivotX", "pivotY", "withSave", "withScale", "x", "y", "withSkew", "withTranslation", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CanvasKt {
    public static final void withClip(Canvas r5, Rect r10, Function1<? super Canvas, Unit> r11) {
        int r12 = r5.save();
        r5.clipRect(r10);
        r11.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r12, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r12, 1);
        throw th;
    }

    public static final void withMatrix(Canvas r5, Matrix r10, Function1<? super Canvas, Unit> r11) {
        int r12 = r5.save();
        r5.concat(r10);
        r11.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r12, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r12, 1);
        throw th;
    }

    public static /* synthetic */ void withMatrix$default(Canvas r5, Matrix r10, Function1 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = new Matrix();
    L5:
        int r14 = r5.save();
        r5.concat(r10);
        r11.invoke(r5);     // Catch: Throwable -> L9
        a.z(1, r5, r14, 1);
        return;
    L9:
        th = move-exception;
        a.z(1, r5, r14, 1);
        throw th;
    }

    public static final void withRotation(Canvas r5, float r10, float r11, float r12, Function1<? super Canvas, Unit> r13) {
        int r14 = r5.save();
        r5.rotate(r10, r11, r12);
        r13.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r14, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r14, 1);
        throw th;
    }

    public static /* synthetic */ void withRotation$default(Canvas r5, float r10, float r11, float r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = 0.0f;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = 0.0f;
    L9:
        if ((r14 & 4) == 0) goto L11;
        r12 = 0.0f;
    L11:
        int r16 = r5.save();
        r5.rotate(r10, r11, r12);
        r13.invoke(r5);     // Catch: Throwable -> L15
        a.z(1, r5, r16, 1);
        return;
    L15:
        th = move-exception;
        a.z(1, r5, r16, 1);
        throw th;
    }

    public static final void withSave(Canvas r5, Function1<? super Canvas, Unit> r10) {
        int r11 = r5.save();
        r10.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r11, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r11, 1);
        throw th;
    }

    public static final void withScale(Canvas r5, float r10, float r11, float r12, float r13, Function1<? super Canvas, Unit> r14) {
        int r15 = r5.save();
        r5.scale(r10, r11, r12, r13);
        r14.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r15, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r15, 1);
        throw th;
    }

    public static /* synthetic */ void withScale$default(Canvas r5, float r10, float r11, float r12, float r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = 1.0f;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r11 = 1.0f;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r12 = 0.0f;
    L12:
        if ((r15 & 8) == 0) goto L14;
        r13 = 0.0f;
    L14:
        int r17 = r5.save();
        r5.scale(r10, r11, r12, r13);
        r14.invoke(r5);     // Catch: Throwable -> L18
        a.z(1, r5, r17, 1);
        return;
    L18:
        th = move-exception;
        a.z(1, r5, r17, 1);
        throw th;
    }

    public static final void withSkew(Canvas r5, float r10, float r11, Function1<? super Canvas, Unit> r12) {
        int r13 = r5.save();
        r5.skew(r10, r11);
        r12.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r13, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r13, 1);
        throw th;
    }

    public static /* synthetic */ void withSkew$default(Canvas r5, float r10, float r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0.0f;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = 0.0f;
    L8:
        int r15 = r5.save();
        r5.skew(r10, r11);
        r12.invoke(r5);     // Catch: Throwable -> L12
        a.z(1, r5, r15, 1);
        return;
    L12:
        th = move-exception;
        a.z(1, r5, r15, 1);
        throw th;
    }

    public static final void withTranslation(Canvas r5, float r10, float r11, Function1<? super Canvas, Unit> r12) {
        int r13 = r5.save();
        r5.translate(r10, r11);
        r12.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r13, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r13, 1);
        throw th;
    }

    public static /* synthetic */ void withTranslation$default(Canvas r5, float r10, float r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0.0f;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = 0.0f;
    L8:
        int r15 = r5.save();
        r5.translate(r10, r11);
        r12.invoke(r5);     // Catch: Throwable -> L12
        a.z(1, r5, r15, 1);
        return;
    L12:
        th = move-exception;
        a.z(1, r5, r15, 1);
        throw th;
    }

    public static final void withClip(Canvas r5, RectF r10, Function1<? super Canvas, Unit> r11) {
        int r12 = r5.save();
        r5.clipRect(r10);
        r11.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r12, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r12, 1);
        throw th;
    }

    public static final void withClip(Canvas r5, int r10, int r11, int r12, int r13, Function1<? super Canvas, Unit> r14) {
        int r15 = r5.save();
        r5.clipRect(r10, r11, r12, r13);
        r14.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r15, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r15, 1);
        throw th;
    }

    public static final void withClip(Canvas r5, float r10, float r11, float r12, float r13, Function1<? super Canvas, Unit> r14) {
        int r15 = r5.save();
        r5.clipRect(r10, r11, r12, r13);
        r14.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r15, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r15, 1);
        throw th;
    }

    public static final void withClip(Canvas r5, Path r10, Function1<? super Canvas, Unit> r11) {
        int r12 = r5.save();
        r5.clipPath(r10);
        r11.invoke(r5);     // Catch: Throwable -> L6
        a.z(1, r5, r12, 1);
        return;
    L6:
        th = move-exception;
        a.z(1, r5, r12, 1);
        throw th;
    }
}
