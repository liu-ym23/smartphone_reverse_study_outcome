package com.larus.bmhome.view.markableview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.view.markableview.base.TransformImageView;
import com.larus.platform.model.chat.g;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 k2\u00020\u0001:\u0002klB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0015J\u0006\u0010;\u001a\u000209J\u0006\u0010<\u001a\u000209J\u0006\u0010=\u001a\u000209J\u000e\u0010>\u001a\u0002092\u0006\u0010?\u001a\u00020\u001fJ\u000e\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u0004\u0018\u00010\u0018J\u0010\u0010D\u001a\u0002092\b\u0010E\u001a\u0004\u0018\u00010\u0018J\u0006\u0010F\u001a\u00020\nJ\b\u0010G\u001a\u0004\u0018\u00010\u0018J\b\u0010H\u001a\u0004\u0018\u00010\u0018J\u0010\u0010I\u001a\u0002092\b\u0010J\u001a\u0004\u0018\u00010\u0018J(\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020B2\u0006\u0010O\u001a\u00020BH\u0002J\u000e\u0010P\u001a\u0002092\u0006\u0010Q\u001a\u00020\nJ\u0010\u0010R\u001a\u0002092\u0006\u0010E\u001a\u00020\u0018H\u0016J\b\u0010S\u001a\u000209H\u0014J\u0010\u0010T\u001a\u0002092\u0006\u0010U\u001a\u00020*H\u0014J\u0012\u0010V\u001a\u00020\n2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J \u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\u001fH\u0016J\u0018\u0010]\u001a\u0002092\u0006\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\u001fH\u0016J\u0010\u0010`\u001a\u0002092\u0006\u0010a\u001a\u00020,H\u0016J\u0018\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020\u001fH\u0002J\u0018\u0010e\u001a\u0002092\u0006\u0010c\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020\u001fH\u0002J\b\u0010f\u001a\u000209H\u0002J\b\u0010g\u001a\u000209H\u0002J\b\u0010h\u001a\u000209H\u0002J\b\u0010i\u001a\u000209H\u0002J\b\u0010j\u001a\u000209H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/larus/bmhome/view/markableview/MarkableImageView;", "Lcom/larus/bmhome/view/markableview/base/TransformImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "_undoEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "undoEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "getUndoEnabled", "()Lkotlinx/coroutines/flow/StateFlow;", "_redoEnabled", "redoEnabled", "getRedoEnabled", "_isInDrawing", "isInDrawing", "onUserMarkedListener", "Lcom/larus/bmhome/view/markableview/MarkableImageView$OnUserMarkedListener;", "markDisabledByOutside", "rawBitmap", "Landroid/graphics/Bitmap;", "paint", "Landroid/graphics/Paint;", "strokePaint", "curPath", "Landroid/graphics/Path;", "curBufferScale", "", "maxScale", "minScale", "mMaxScaleMultiplier", "mCropRect", "Landroid/graphics/RectF;", "mTargetAspectRatio", "lastX", "lastY", "bufferBitmap", "bufferCanvas", "Landroid/graphics/Canvas;", "bufferMatrix", "Landroid/graphics/Matrix;", "bufferInverseMatrix", "undoList", "", "redoList", "viewBitmapRect", "canDrawPathRect", "hasPathInBitmapRect", "penSizeAWaitNextTouch", "Ljava/lang/Float;", "initialBitmapCorners", "", "setOnUserMarkedListener", "", "listener", "redo", "undo", "clear", "setPenPxSize", "size", "setPenColor", "color", "", "getMarkedBitmap", "setRawBitmap", "bitmap", "hasRawBitmap", "getRawMarkedBitmap", "getPathBitmap", "setPathBitmap", "pathBitmap", "hasSameAspectRatio", "widthA", "heightA", "widthB", "heightB", "setMarkEnabled", "enabled", "setImageBitmap", "onImageLaidOut", "onDraw", "canvas", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "postScale", "deltaScale", "px", "py", "postTranslate", "deltaX", "deltaY", "setImageMatrix", "matrix", "calculateImageScaleBounds", "drawableWidth", "drawableHeight", "setupInitialImagePosition", "updateCanDrawPathRect", "redrawOnBufferCanvas", "saveDrawingPath", "checkUnRedo", "initBuffer", "Companion", "OnUserMarkedListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkableImageView extends TransformImageView {
    public static final g L = null;
    public static final float M = 0.0f;
    public static final int N = 0;
    public Bitmap A;
    public Canvas B;
    public final Matrix C;
    public final Matrix D;
    public final List<Path> E;
    public final List<Path> F;
    public RectF G;
    public RectF H;
    public boolean I;
    public Float J;
    public float[] K;
    public final StateFlowImpl j;
    public final b1 k;
    public final StateFlowImpl l;
    public final b1 m;
    public final StateFlowImpl n;
    public final b1 o;
    public b p;
    public boolean q;
    public Bitmap r;
    public final Paint s;
    public final Paint t;
    public final Path u;
    public float v;
    public final RectF w;
    public float x;
    public float y;
    public float z;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    static {
        g r0 = z2.a.c2();
        L = r0;
        M = c7.b(Float.valueOf(r0.b()));
        N = ColorProtector.parseColor("#FFD000");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void clear() {
        ((ArrayList) this.F).clear();
        ((ArrayList) this.E).clear();
        n();
        this.u.reset();
        this.I = false;
        this.n.setValue(Boolean.FALSE);
        q();
        invalidate();
        this.B = null;
        this.A = null;
    }

    public final Bitmap getPathBitmap() {
        Bitmap r0 = this.A;
        Object r1 = null;
        if (r0 == null) goto L22;
        Bitmap r2 = getViewBitmap();
        if (r2 == null) goto L23;
        RectF r3 = xt8.a.a(this.K);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        int r5 = RangesKt.coerceAtLeast(0, (int) r3.left);     // Catch: Throwable -> L9
        int r6 = RangesKt.coerceAtLeast(0, (int) r3.top);     // Catch: Throwable -> L9
        Object r7 = Result.constructor-impl(Bitmap.createScaledBitmap(Bitmap.createBitmap(r0, r5, r6, RangesKt.coerceAtMost((int) (((double) r3.width()) + 0.5d), r0.getWidth() - r5), RangesKt.coerceAtMost((int) (((double) r3.height()) + 0.5d), r0.getHeight() - r6)), r2.getWidth(), r2.getHeight(), true));     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L15;
        FLogger.a.e("MarkableImageView", "getMaskBitmap failed", r8);
    L15:
        if (Result.isFailure-impl(r7) == true) goto L19;
        r1 = r7;
    L19:
        return (Bitmap) r1;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L23:
        return null;
    L22:
        return null;
    }

    public final Bitmap getRawMarkedBitmap() {
        Bitmap r0 = this.r;
        if (r0 == null) goto L33;
        Object r3 = null;
        if ((!r0.isRecycled()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L33;
        Bitmap r1 = getPathBitmap();
        if (r1 != null) goto L34;
        return r0;
    L34:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L21
        if (r1.getWidth() == r0.getWidth()) goto L16;
    L18:
        r1 = Bitmap.createScaledBitmap(r1, r0.getWidth(), r0.getHeight(), true);     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L21
    L19:
        Bitmap r2 = Bitmap.createBitmap(r0.getWidth(), r0.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L21
        Canvas r5 = new Canvas(r2);     // Catch: Throwable -> L21
        r5.drawBitmap(r0, 0.0f, 0.0f, null);     // Catch: Throwable -> L21
        r5.drawBitmap(r1, 0.0f, 0.0f, null);     // Catch: Throwable -> L21
        Object r6 = Result.constructor-impl(r2);     // Catch: Throwable -> L21
    L24:
        if (Result.isFailure-impl(r6) == true) goto L27;
        r3 = r6;
    L27:
        Bitmap r7 = (Bitmap) r3;
        if (r7 != null) goto L31;
        return r0;
    L31:
        return r7;
    L16:
        if (r1.getHeight() != r0.getHeight()) goto L18;
    L21:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L33:
        return getMarkedBitmap();
    }

    public final void n() {
        this.j.setValue(Boolean.valueOf(!((ArrayList) this.E).isEmpty()));
        this.l.setValue(Boolean.valueOf(!((ArrayList) this.F).isEmpty()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p() {
        if ((!((ArrayList) this.F).isEmpty()) == false) goto L8;
        List<Path> r0 = this.E;
        List<Path> r1 = this.F;
        ((ArrayList) r0).add(ListProtector.remove(r1, CollectionsKt.getLastIndex(r1)));
        q();
        invalidate();
        b r2 = this.p;
        if (r2 == null) goto L9;
        r2.c();
        return;
    L9:
        return;
    }

    public final void q() {
        Canvas r0 = this.B;
        if (r0 == null) goto L11;
        r0.drawColor(0, PorterDuff.Mode.CLEAR);
        Iterator<T> r1 = this.E.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r0.drawPath((Path) r1.next(), this.s);
        goto L6
    L8:
        n();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r() {
        if ((!((ArrayList) this.E).isEmpty()) == false) goto L8;
        List<Path> r0 = this.F;
        List<Path> r1 = this.E;
        ((ArrayList) r0).add(ListProtector.remove(r1, CollectionsKt.getLastIndex(r1)));
        q();
        invalidate();
        b r2 = this.p;
        if (r2 == null) goto L9;
        r2.a();
        return;
    L9:
        return;
    }

    public final void s() {
        float r0 = this.s.getStrokeWidth() / 2;
        RectF r2 = this.G;
        this.H = new RectF(r2.left - r0, r2.top - r0, r2.right + r0, r2.bottom + r0);
    }

    public final Bitmap getMarkedBitmap() {
        Bitmap r0 = getPathBitmap();
        if (r0 == null) goto L18;
        Bitmap r1 = getViewBitmap();
        if (r1 == null) goto L18;
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        Bitmap r4 = Bitmap.createBitmap(r1.getWidth(), r1.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L9
        Canvas r5 = new Canvas(r4);     // Catch: Throwable -> L9
        r5.drawBitmap(r1, 0.0f, 0.0f, null);     // Catch: Throwable -> L9
        r5.drawBitmap(r0, 0.0f, 0.0f, null);     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(r4);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == true) goto L16;
        r2 = r6;
    L16:
        return (Bitmap) r2;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        return getViewBitmap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.markableview.base.TransformImageView
    public final void l() {
        super.l();
        Drawable r0 = getDrawable();
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = r0.getIntrinsicWidth();
        float r2 = r0.getIntrinsicHeight();
        FLogger r3 = FLogger.a;
        r3.i("MarkableImageView", "[onImageLaidOut] mThisWidth:" + getMThisWidth() + " mThisHeight:" + getMThisHeight() + " drawable:" + r1 + 'x' + r2 + " mTargetAspectRatio:" + this.x);
        if (getMThisWidth() != 0) goto L8;
    L26:
        r3.w("MarkableImageView", "[onImageLaidOut] view not laid out yet, skip matrix setup");
        return;
    L8:
        if (getMThisHeight() == 0) goto L26;
        if (this.x != 0.0f) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        this.x = r1 / r2;
    L16:
        int r5 = (int) (getMThisWidth() / this.x);
        if (r5 <= getMThisHeight()) goto L19;
        int r6 = (int) (getMThisHeight() * this.x);
        int r8 = (getMThisWidth() - r6) / 2;
        this.w.set(r8, 0.0f, r6 + r8, getMThisHeight());
    L20:
        RangesKt.coerceAtMost(RangesKt.coerceAtMost(this.w.width() / r1, this.w.width() / r2), RangesKt.coerceAtMost(this.w.height() / r2, this.w.height() / r1));
        float r7 = this.w.width();
        float r9 = this.w.height();
        float r10 = Math.max(this.w.width() / r1, this.w.height() / r2);
        RectF r11 = this.w;
        float r12 = ((r7 - (r1 * r10)) / 2.0f) + r11.left;
        float r13 = ((r9 - (r2 * r10)) / 2.0f) + r11.top;
        getMCurrentImageMatrix().reset();
        getMCurrentImageMatrix().postScale(r10, r10);
        getMCurrentImageMatrix().postTranslate(r12, r13);
        StringBuilder r14 = new StringBuilder("[setupInitialImagePosition] cropRect:");
        r14.append(this.w);
        r14.append(" scale:");
        r14.append(r10);
        r14.append(" tw:");
        r14.append(r12);
        r14.append(" th:");
        r14.append(r13);
        r14.append(" drawable:");
        r14.append(r1);
        r14.append('x');
        r14.append(r2);
        r14.append(" drawableBounds:");
        Drawable r15 = getDrawable();
        if (r15 == null) goto L23;
        Rect r16 = r15.getBounds();
    L24:
        r14.append(r16);
        r3.i("MarkableImageView", r14.toString());
        setImageMatrix(getMCurrentImageMatrix());
        return;
    L23:
        r16 = null;
        goto L24
    L19:
        int r17 = (getMThisHeight() - r5) / 2;
        this.w.set(0.0f, r17, getMThisWidth(), r5 + r17);
        goto L20
    L13:
        r4 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o() {
        if (getViewBitmap() != null) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
    L20:
        FLogger.a.w("MarkableImageView", "[initBuffer] view is not ready, view:" + getWidth() + 'x' + getHeight());
        return;
    L7:
        if (getHeight() <= 0) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Object r1 = Result.constructor-impl(Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888));     // Catch: Throwable -> L11
    L14:
        if (Result.isSuccess-impl(r1) == false) goto L16;
        Bitmap r3 = (Bitmap) r1;
        this.B = new Canvas(r3);
        this.A = r3;
        this.C.reset();
        this.K = CollectionsKt.toFloatArray(ArraysKt.toList(getMCurrentImageCorners()));
        getCurrentScale();
        getCurrentScale();
        this.v = 1.0f;
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r1);
        if (r4 == null) goto L19;
        FLogger.a.e("MarkableImageView", "[initBuffer] create buffer failed, view:" + getWidth() + 'x' + getHeight(), r4);
        this.B = null;
        this.A = null;
    L19:
        Result.box-impl(r1);
        return;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final i1<Boolean> getRedoEnabled() {
        return this.m;
    }

    public final i1<Boolean> getUndoEnabled() {
        return this.k;
    }

    public MarkableImageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super/*android.widget.ImageView*/.onDraw(r4);
        Bitmap r0 = this.A;
        if (r0 == null) goto L6;
        r4.save();
        r4.clipRect(this.G);
        r4.drawBitmap(r0, this.C, null);
        r4.restore();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r10) {
        if (this.q == false) goto L6;
        return false;
    L6:
        if (getViewBitmap() != null) goto L8;
        return false;
    L8:
        if (r10 != null) goto L11;
        return false;
    L11:
        if (this.A != null) goto L13;
        o();
    L13:
        MotionEvent r0 = MotionEvent.obtain(r10);
        r0.transform(this.D);
        float r2 = r0.getX();
        float r3 = r0.getY();
        int r4 = r10.getActionMasked();
        if (r4 != 0) goto L16;
        Float r11 = this.J;
        if (r11 == null) goto L56;
        float r12 = r11.floatValue();
        this.J = null;
        this.s.setStrokeWidth(r12);
        this.t.setStrokeWidth(this.s.getStrokeWidth());
        s();
    L56:
        FLogger.a.i("MarkableImageView", "[onTouchEvent] ACTION_DOWN - emitting isInDrawing: true");
        this.n.setValue(Boolean.TRUE);
        this.y = r2;
        this.z = r3;
        this.u.moveTo(r2, r3);
        invalidate();
    L57:
        r0.recycle();
        return true;
    L16:
        if (r4 == 1) goto L40;
        if (r4 == 2) goto L22;
        if (r4 == 3) goto L40;
    L22:
        if (r0.getPointerCount() <= 1) goto L25;
        FLogger.a.i("MarkableImageView", "[onTouchEvent] ACTION_MOVE - multi-touch detected, emitting isInDrawing: false");
        this.n.setValue(Boolean.FALSE);
    L25:
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L27;
    L39:
        this.y = r2;
        this.z = r3;
        goto L57
    L27:
        if (this.I == true) goto L33;
        if (this.H.contains(r10.getX(), r10.getY()) == true) goto L33;
        this.u.moveTo(r2, r3);
    L33:
        if (this.I == true) goto L35;
        this.I = true;
        goto L39
    L35:
        Path r13 = this.u;
        float r1 = this.y;
        float r5 = this.z;
        float r7 = 2;
        r13.quadTo(r1, r5, (r2 + r1) / r7, (r3 + r5) / r7);
        Canvas r14 = this.B;
        if (r14 == null) goto L38;
        r14.drawPath(this.u, this.s);
    L38:
        invalidate();
    L40:
        ((ArrayList) this.F).clear();
        b r6 = this.p;
        if (r6 == null) goto L44;
        r6.b();
    L44:
        if (this.H.contains(r10.getX(), r10.getY()) == false) goto L49;
        this.I = true;
        Path r15 = this.u;
        float r8 = this.y;
        float r9 = this.z;
        float r16 = 2;
        r15.quadTo(r8, r9, (r2 + r8) / r16, (r3 + r9) / r16);
        Canvas r17 = this.B;
        if (r17 == null) goto L49;
        r17.drawPath(this.u, this.s);
    L49:
        if (this.I == false) goto L52;
        ((ArrayList) this.E).add(new Path(this.u));
        n();
    L52:
        this.u.reset();
        this.I = false;
        FLogger.a.i("MarkableImageView", "[onTouchEvent] ACTION_UP/CANCEL - emitting isInDrawing: false");
        this.n.setValue(Boolean.FALSE);
        invalidate();
        goto L57
    }

    @Override // com.larus.bmhome.view.markableview.base.TransformImageView
    public void setImageBitmap(Bitmap r4) {
        Intrinsics.checkNotNullParameter(r4, "bitmap");
        FLogger r0 = FLogger.a;
        r0.i("MarkableImageView", "[setImageBitmap] bitmap:" + r4.getWidth() + 'x' + r4.getHeight() + " mThisWidth:" + getMThisWidth() + " mThisHeight:" + getMThisHeight() + " recycled:" + r4.isRecycled());
        if (r4.isRecycled() == false) goto L6;
        r0.e("MarkableImageView", "[setImageBitmap] bitmap is recycled, skip!");
        return;
    L6:
        this.x = 0.0f;
        super.setImageBitmap(r4);
        l();
        m();
        s();
    }

    @Override // com.larus.bmhome.view.markableview.base.TransformImageView
    public void setImageMatrix(Matrix r2) {
        Intrinsics.checkNotNullParameter(r2, "matrix");
        super.setImageMatrix(r2);
        this.G = xt8.a.a(getMCurrentImageCorners());
        s();
    }

    public final void setMarkEnabled(boolean r4) {
        FLogger.a.i("MarkableImageView", "[setMarkEnabled] enabled:" + r4);
        this.q = r4 ^ true;
    }

    public final void setOnUserMarkedListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.p = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPathBitmap(Bitmap r10) {
        if (r10 != null) goto L5;
        clear();
        return;
    L5:
        Bitmap r0 = getViewBitmap();
        if (r10.isRecycled() == true) goto L34;
        if (r0 == null) goto L36;
        int r1 = r10.getWidth();
        int r2 = r10.getHeight();
        int r3 = r0.getWidth();
        int r4 = r0.getHeight();
        if (r1 <= 0) goto L18;
        if (r2 <= 0) goto L18;
        if (r3 <= 0) goto L18;
        if (r4 <= 0) goto L18;
        if (Math.abs((r1 / r2) - (r3 / r4)) > 0.01f) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L23;
        FLogger.a.w("MarkableImageView", "[setPathBitmap] skip mismatched mask:" + r10.getWidth() + 'x' + r10.getHeight() + ", bitmap:" + r0.getWidth() + 'x' + r0.getHeight());
        clear();
        return;
    L23:
        if (this.A != null) goto L25;
        o();
    L25:
        Canvas r6 = this.B;
        if (r6 == null) goto L35;
        ((ArrayList) this.F).clear();
        ((ArrayList) this.E).clear();
        n();
        r6.drawColor(0, PorterDuff.Mode.CLEAR);
        RectF r7 = xt8.a.a(this.K);
        float r8 = RangesKt.coerceAtLeast(r7.left, 0.0f);
        float r9 = RangesKt.coerceAtLeast(r7.top, 0.0f);
        float r11 = RangesKt.coerceAtMost(r7.right, getWidth());
        float r12 = RangesKt.coerceAtMost(r7.bottom, getHeight());
        if (r11 > r8) goto L30;
    L32:
        invalidate();
        return;
    L30:
        if (r12 <= r9) goto L32;
        r6.drawBitmap(r10, new Rect(0, 0, r10.getWidth(), r10.getHeight()), new RectF(r8, r9, r11, r12), new Paint(3));
        goto L32
    L35:
        return;
    L18:
        r5 = false;
        goto L19
    L36:
        return;
    }

    public final void setPenColor(int r3) {
        this.s.setColor(r3);
        this.s.setAlpha((int) (255 * L.a()));
        FLogger.a.i("MarkableImageView", "[setPenColor] color:" + this.s.getColor() + " alpha=" + this.s.getAlpha());
    }

    public final void setPenPxSize(float r3) {
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L5;
        this.J = Float.valueOf(r3 / this.v);
        return;
    L5:
        this.s.setStrokeWidth(r3 / this.v);
        this.t.setStrokeWidth(this.s.getStrokeWidth());
        s();
    }

    public final void setRawBitmap(Bitmap r1) {
        this.r = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MarkableImageView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, 4, 0);
        Boolean r6 = Boolean.FALSE;
        StateFlowImpl r7 = j1.a(r6);
        this.j = r7;
        this.k = e.b(r7);
        StateFlowImpl r8 = j1.a(r6);
        this.l = r8;
        this.m = e.b(r8);
        StateFlowImpl r9 = j1.a(r6);
        this.n = r9;
        this.o = e.b(r9);
        Paint r10 = new Paint();
        setLayerType(1, null);
        r10.setStyle(Paint.Style.STROKE);
        r10.setAntiAlias(true);
        r10.setDither(true);
        r10.setFilterBitmap(true);
        r10.setStrokeJoin(Paint.Join.ROUND);
        r10.setStrokeCap(Paint.Cap.ROUND);
        float r0 = M;
        r10.setStrokeWidth(r0);
        r10.setColor(N);
        r10.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.s = r10;
        Paint r11 = new Paint();
        r11.setStyle(Paint.Style.STROKE);
        r11.setAntiAlias(true);
        r11.setStrokeJoin(Paint.Join.ROUND);
        r11.setStrokeCap(Paint.Cap.ROUND);
        r11.setStrokeWidth(r0);
        r11.setColor(-1);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.t = r11;
        this.u = new Path();
        this.v = 1.0f;
        this.w = new RectF();
        this.C = new Matrix();
        this.D = new Matrix();
        this.E = new ArrayList();
        this.F = new ArrayList();
        this.G = new RectF();
        this.H = new RectF();
        this.K = new float[8];
    }
}
