package com.larus.uaigc.createpage.bussiness.remove.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.TransformImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import vqc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0003cdeB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020BH\u0016J\b\u0010D\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020\u0016H\u0016J\b\u0010G\u001a\u000203H\u0016J\u0010\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020\bH\u0016J\u001a\u0010J\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010KH\u0016J\u0012\u0010L\u001a\u00020B2\b\u0010M\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010N\u001a\u00020B2\u0006\u0010O\u001a\u00020\"H\u0014J\u0012\u0010P\u001a\u00020\r2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J \u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\u0016H\u0016J\u0018\u0010W\u001a\u00020B2\u0006\u0010X\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020\u0016H\u0016J\u0012\u0010Z\u001a\u00020B2\b\u0010[\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010\\\u001a\u00020B2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010]\u001a\u00020BH\u0002J\b\u0010^\u001a\u00020BH\u0002J\b\u0010_\u001a\u00020BH\u0002J\b\u0010`\u001a\u00020BH\u0002J\b\u0010b\u001a\u00020BH\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u000108X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0012\u0010=\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteView;", "Lcom/yalantis/ucrop/view/CropImageView;", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/IPaletteViewAbility;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_enableUndo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "enableUndo", "Lkotlinx/coroutines/flow/StateFlow;", "getEnableUndo", "()Lkotlinx/coroutines/flow/StateFlow;", "_enableRedo", "enableRedo", "getEnableRedo", "initPenSize", "", "initPenColor", "paint", "Landroid/graphics/Paint;", "maskPaint", "curPath", "Landroid/graphics/Path;", "lastX", "lastY", "bufferBitmap", "Landroid/graphics/Bitmap;", "bufferCanvas", "Landroid/graphics/Canvas;", "bufferMatrix", "Landroid/graphics/Matrix;", "bufferInverseMatrix", "needDrawMask", "maskBitmap", "maskCanvas", "undoList", "", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteView$DrawingInfo;", "redoList", "inDrawingPath", "getInDrawingPath", "()Z", "setInDrawingPath", "(Z)V", "viewBitmapRect", "Landroid/graphics/RectF;", "canDrawPathRect", "hasPathInBitmapRect", "ringPaint", "singleTouchingPoint", "Landroid/graphics/PointF;", "getSingleTouchingPoint", "()Landroid/graphics/PointF;", "setSingleTouchingPoint", "(Landroid/graphics/PointF;)V", "penSizeAWaitNextTouch", "Ljava/lang/Float;", "initialBitmapCorners", "", "redo", "", "undo", "clear", "setPenPxSize", "size", "getCurBitmapRect", "setPenColor", "color", "getMaskBitmap", "Lkotlin/Pair;", "setImageBitmap", "bitmap", "onDraw", "canvas", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "postScale", "deltaScale", "px", "py", "postTranslate", "deltaX", "deltaY", "setImageMatrix", "matrix", "updateTouchingPoint", "updateCanDrawPathRect", "redrawOnBufferCanvas", "saveDrawingPath", "checkUnRedo", "curBufferScale", "initBuffer", "DrawingInfo", "PathDrawingInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public class PaletteView extends CropImageView {
    public final StateFlowImpl B;
    public final b1 C;
    public final StateFlowImpl D;
    public final b1 E;
    public final Paint F;
    public final Paint G;
    public final Path H;
    public Float H0;
    public float I;
    public float J;
    public Bitmap K;
    public Canvas L;
    public float[] L0;
    public final Matrix M;
    public final Matrix N;
    public final boolean O;
    public Bitmap P;
    public float P0;
    public Canvas Q;
    public final List<b> R;
    public final List<b> S;
    public boolean T;
    public RectF U;
    public RectF V;
    public boolean W;
    public final Paint k0;
    public PointF p0;

    public static final class a {
    }

    public static abstract class b {
        public final Paint a;

        public abstract void a(Canvas r1);

        public b(Paint r2) {
            Intrinsics.checkNotNullParameter(r2, "paint");
            this.a = r2;
        }
    }

    public static final class c extends b {
        public final Path b;

        @Override // com.larus.uaigc.createpage.bussiness.remove.widget.PaletteView.b
        public final void a(Canvas r3) {
            Intrinsics.checkNotNullParameter(r3, "canvas");
            r3.drawPath(this.b, this.a);
        }

        public c(Path r2, Paint r3) {
            Intrinsics.checkNotNullParameter(r2, "path");
            Intrinsics.checkNotNullParameter(r3, "paint");
            super(r3);
            this.b = r2;
        }
    }

    static {
    }

    public PaletteView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PaletteView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void A() {
        float r0 = this.F.getStrokeWidth() / 2;
        RectF r2 = this.U;
        this.V = new RectF(r2.left - r0, r2.top - r0, r2.right + r0, r2.bottom + r0);
    }

    public RectF getCurBitmapRect() {
        return f.b(((TransformImageView) this).a);
    }

    public Pair<Bitmap, Bitmap> getMaskBitmap() {
        Bitmap r0 = this.K;
        Object r1 = null;
        if (r0 == null) goto L30;
        Bitmap r2 = getViewBitmap();
        if (r2 == null) goto L31;
        RectF r3 = f.b(this.L0);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        int r5 = RangesKt.coerceAtLeast(0, (int) r3.left);     // Catch: Throwable -> L17
        int r6 = RangesKt.coerceAtLeast(0, (int) r3.top);     // Catch: Throwable -> L17
        int r7 = RangesKt.coerceAtMost((int) (((double) r3.width()) + 0.5d), r0.getWidth() - r5);     // Catch: Throwable -> L17
        int r8 = RangesKt.coerceAtMost((int) (((double) r3.height()) + 0.5d), r0.getHeight() - r6);     // Catch: Throwable -> L17
        Bitmap r9 = Bitmap.createBitmap(r0, r5, r6, r7, r8);     // Catch: Throwable -> L17
        Bitmap r10 = this.P;     // Catch: Throwable -> L17
        if (r10 == null) goto L10;
        Bitmap r11 = Bitmap.createBitmap(r10, r5, r6, r7, r8);     // Catch: Throwable -> L17
    L11:
        Bitmap r12 = Bitmap.createScaledBitmap(r9, r2.getWidth(), r2.getHeight(), true);     // Catch: Throwable -> L17
        if (r11 == null) goto L14;
        Bitmap r13 = Bitmap.createScaledBitmap(r11, r2.getWidth(), r2.getHeight(), true);     // Catch: Throwable -> L17
    L15:
        Object r14 = Result.constructor-impl(TuplesKt.to(r12, r13));     // Catch: Throwable -> L17
    L19:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L23;
        FLogger.a.e("PaletteView", "getMaskBitmap failed", r15);
    L23:
        if (Result.isFailure-impl(r14) == true) goto L27;
        r1 = r14;
    L27:
        return (Pair) r1;
    L14:
        r13 = null;
        goto L15
    L10:
        r11 = null;
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L31:
        return null;
    L30:
        return null;
    }

    public final void y() {
        this.B.setValue(Boolean.valueOf(!((ArrayList) this.R).isEmpty()));
        this.D.setValue(Boolean.valueOf(!((ArrayList) this.S).isEmpty()));
    }

    public final void z() {
        Canvas r0 = this.L;
        if (r0 == null) goto L20;
        r0.drawColor(0, PorterDuff.Mode.CLEAR);
        Canvas r1 = this.Q;
        if (r1 == null) goto L7;
        r1.drawColor(-16777216, PorterDuff.Mode.CLEAR);
    L7:
        Iterator<T> r2 = this.R.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        b r3 = (b) r2.next();
        r3.a(r0);
        Canvas r4 = this.Q;
        if (r4 == null) goto L9;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.uaigc.createpage.bussiness.remove.widget.PaletteView.PathDrawingInfo");
        Path r5 = ((c) r3).b;
        Paint r6 = new Paint(r3.a);
        r6.setColor(-1);
        Unit r7 = Unit.INSTANCE;
        r4.drawPath(r5, r6);
        goto L9
    L13:
        y();
        return;
    }

    public i1<Boolean> getEnableRedo() {
        return this.E;
    }

    public i1<Boolean> getEnableUndo() {
        return this.C;
    }

    public final boolean getInDrawingPath() {
        return this.T;
    }

    public final PointF getSingleTouchingPoint() {
        return this.p0;
    }

    public final void B(MotionEvent r4) {
        this.p0 = null;
        if (r4.getPointerCount() == 1) goto L5;
        return;
    L5:
        if (this.V.contains(r4.getX(), r4.getY()) == false) goto L9;
        this.p0 = new PointF(r4.getX(), r4.getY());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        super/*android.widget.ImageView*/.onDraw(r5);
        Bitmap r0 = this.K;
        if (r0 == null) goto L9;
        r5.save();
        r5.clipRect(this.U);
        r5.drawBitmap(r0, this.M, null);
        PointF r1 = this.p0;
        if (r1 == null) goto L7;
        r5.drawCircle(r1.x, r1.y, (this.F.getStrokeWidth() * this.P0) / 2, this.k0);
    L7:
        r5.restore();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r11) {
        if (getViewBitmap() != null) goto L5;
        return false;
    L5:
        if (r11 != null) goto L8;
        return false;
    L8:
        if (this.K == null) goto L10;
    L18:
        MotionEvent r0 = MotionEvent.obtain(r11);
        r0.transform(this.N);
        this.p0 = null;
        float r3 = r0.getX();
        float r4 = r0.getY();
        int r5 = r11.getActionMasked();
        if (r5 == 0) goto L53;
        if (r5 != 1) goto L22;
    L48:
        ((ArrayList) this.S).clear();
        if (this.W == false) goto L52;
        Path r12 = new Path(this.H);
        Paint r6 = new Paint(this.F);
        ((ArrayList) this.R).add(new c(r12, r6));
        y();
    L52:
        this.H.reset();
        this.W = false;
        this.p0 = null;
        this.T = false;
        invalidate();
    L57:
        r0.recycle();
        return true;
    L22:
        if (r5 == 2) goto L27;
        if (r5 == 3) goto L48;
    L27:
        if (r0.getPointerCount() <= 1) goto L30;
        this.T = false;
    L30:
        if (this.T == true) goto L32;
    L47:
        this.I = r3;
        this.J = r4;
        goto L57
    L32:
        if (this.W == true) goto L38;
        if (this.V.contains(r11.getX(), r11.getY()) == true) goto L38;
        this.H.moveTo(r3, r4);
    L38:
        if (this.W == true) goto L40;
        this.W = true;
        goto L47
    L40:
        Path r1 = this.H;
        float r2 = this.I;
        float r7 = this.J;
        float r8 = 2;
        r1.quadTo(r2, r7, (r3 + r2) / r8, (r4 + r7) / r8);
        Canvas r9 = this.L;
        if (r9 == null) goto L43;
        r9.drawPath(this.H, this.F);
    L43:
        Canvas r10 = this.Q;
        if (r10 == null) goto L46;
        r10.drawPath(this.H, this.G);
    L46:
        B(r11);
        invalidate();
        goto L47
    L53:
        Float r13 = this.H0;
        if (r13 == null) goto L56;
        float r14 = r13.floatValue();
        this.H0 = null;
        this.F.setStrokeWidth(r14);
        this.G.setStrokeWidth(this.F.getStrokeWidth());
        A();
    L56:
        this.T = true;
        this.I = r3;
        this.J = r4;
        this.H.moveTo(r3, r4);
        B(r11);
        invalidate();
        goto L57
    L10:
        if (getViewBitmap() == null) goto L18;
        Bitmap r15 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.L = new Canvas(r15);
        this.K = r15;
        if (this.O == false) goto L17;
        Bitmap r16 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.Q = new Canvas(r16);
        Paint r17 = new Paint();
        r17.setColor(-16777216);
        Canvas r18 = this.Q;
        if (r18 == null) goto L16;
        r18.drawRect(0.0f, 0.0f, getWidth(), getHeight(), r17);
    L16:
        this.P = r16;
    L17:
        this.M.reset();
        this.L0 = CollectionsKt.toFloatArray(ArraysKt.toList(((TransformImageView) this).a));
        setMaxScale(getCurrentScale() * 15.0f);
        setMinScale(getCurrentScale() * 0.7f);
        this.P0 = 1.0f;
        goto L18
    }

    public void setImageBitmap(Bitmap r2) {
        super/*com.yalantis.ucrop.view.TransformImageView*/.setImageBitmap(r2);
        if (r2 != null) goto L6;
        this.K = null;
        this.L = null;
        this.M.reset();
        this.N.reset();
        this.P = null;
        this.Q = null;
        ((TransformImageView) this).k = false;
        ((TransformImageView) this).j = false;
        return;
    }

    public void setImageMatrix(Matrix r1) {
        super/*com.yalantis.ucrop.view.TransformImageView*/.setImageMatrix(r1);
        this.U = f.b(((TransformImageView) this).a);
        A();
    }

    public final void setInDrawingPath(boolean r1) {
        this.T = r1;
    }

    public void setPenColor(int r2) {
        this.F.setColor(r2);
    }

    public void setPenPxSize(float r3) {
        if (this.T == false) goto L5;
        this.H0 = Float.valueOf(r3 / this.P0);
        return;
    L5:
        this.F.setStrokeWidth(r3 / this.P0);
        this.G.setStrokeWidth(this.F.getStrokeWidth());
        A();
    }

    public final void setSingleTouchingPoint(PointF r1) {
        this.p0 = r1;
    }

    public final void p(float r3, float r4) {
        if (this.L == null) goto L5;
        this.M.postTranslate(r3, r4);
        this.M.invert(this.N);
    L5:
        super/*com.yalantis.ucrop.view.TransformImageView*/.p(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaletteView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        Boolean r6 = Boolean.FALSE;
        StateFlowImpl r7 = j1.a(r6);
        this.B = r7;
        this.C = e.b(r7);
        StateFlowImpl r8 = j1.a(r6);
        this.D = r8;
        this.E = e.b(r8);
        float r9 = c7.b(20);
        int r10 = ColorProtector.parseColor("#4DFFD000");
        Paint r11 = new Paint();
        setLayerType(1, null);
        r11.setStyle(Paint.Style.STROKE);
        r11.setAntiAlias(true);
        r11.setDither(true);
        r11.setFilterBitmap(true);
        r11.setStrokeJoin(Paint.Join.ROUND);
        r11.setStrokeCap(Paint.Cap.ROUND);
        r11.setStrokeWidth(r9);
        r11.setColor(r10);
        r11.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.F = r11;
        Paint r12 = new Paint();
        r12.setStyle(Paint.Style.STROKE);
        r12.setAntiAlias(true);
        r12.setStrokeJoin(Paint.Join.ROUND);
        r12.setStrokeCap(Paint.Cap.ROUND);
        r12.setStrokeWidth(r9);
        r12.setColor(-1);
        r12.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.G = r12;
        this.H = new Path();
        this.M = new Matrix();
        this.N = new Matrix();
        this.O = true;
        this.R = new ArrayList();
        this.S = new ArrayList();
        this.U = new RectF();
        this.V = new RectF();
        Paint r13 = new Paint();
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeWidth(c7.b(2));
        r13.setColor(ColorProtector.parseColor("#CCCCCC"));
        r13.setAntiAlias(true);
        this.k0 = r13;
        this.L0 = new float[8];
        this.P0 = 1.0f;
    }

    public final void o(float r4, float r5, float r6) {
        if (this.L != null) goto L5;
    L13:
        super.o(r4, r5, r6);
        return;
    L5:
        if (r4 <= 1.0f) goto L9;
        if ((getCurrentScale() * r4) > getMaxScale()) goto L9;
    L12:
        this.M.postScale(r4, r4, r5, r6);
        this.M.invert(this.N);
        Paint r0 = this.F;
        r0.setStrokeWidth(r0.getStrokeWidth() / r4);
        this.G.setStrokeWidth(this.F.getStrokeWidth());
        this.M.getValues(((TransformImageView) this).c);
        this.P0 = ((TransformImageView) this).c[0];
    L9:
        if (r4 >= 1.0f) goto L13;
        if ((getCurrentScale() * r4) < getMinScale()) goto L13;
        goto L12
    }

    public /* synthetic */ PaletteView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
