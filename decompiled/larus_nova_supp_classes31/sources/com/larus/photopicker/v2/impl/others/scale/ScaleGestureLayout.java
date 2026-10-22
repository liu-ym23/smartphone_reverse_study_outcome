package com.larus.photopicker.v2.impl.others.scale;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.animation.MatrixEvaluator;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import qp9.a0;
import qp9.h;
import qp9.i;
import qp9.j;
import qp9.l;
import qp9.m;
import qp9.q;
import qp9.y;
import qp9.z;
import rp9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e*\u00014\b\u0007\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H\u0017J(\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0014J\u0016\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007J\u000e\u0010D\u001a\u00020<2\u0006\u00103\u001a\u00020$J<\u0010E\u001a\u00020<2\b\u0010F\u001a\u0004\u0018\u00010\u000f2\b\u0010G\u001a\u0004\u0018\u00010\u000f2\u0006\u0010H\u001a\u00020\u001d2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NJJ\u0010O\u001a\u00020<2\b\u0010F\u001a\u0004\u0018\u00010\u000f2\b\u0010G\u001a\u0004\u0018\u00010\u000f2\u0006\u0010H\u001a\u00020\u001d2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020<0QJ \u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0014J \u0010Z\u001a\u00020<2\u0006\u0010[\u001a\u00020:2\u0006\u0010\\\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u001dH\u0002J\u0018\u0010^\u001a\u00020<2\u0006\u0010\\\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u001dH\u0002J \u0010_\u001a\u00020<2\u0006\u0010`\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u001dH\u0002J\b\u0010c\u001a\u00020<H\u0002J\b\u0010d\u001a\u00020<H\u0002J\b\u0010e\u001a\u00020<H\u0002J\u001e\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010g2\u0006\u0010h\u001a\u00020\rH\u0002J$\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0g2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u001dH\u0002J\u0018\u0010l\u001a\u00020<2\u0006\u0010m\u001a\u00020\u001d2\u0006\u0010n\u001a\u00020\u001dH\u0002J\b\u0010o\u001a\u00020<H\u0016J\u0018\u0010p\u001a\u00020<2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u001dH\u0002J\b\u0010q\u001a\u00020<H\u0002J\u0018\u0010r\u001a\u00020\u00162\u0006\u0010s\u001a\u00020\u000b2\u0006\u0010t\u001a\u00020\u000bH\u0002J\u0010\u0010u\u001a\u00020\u00162\u0006\u0010v\u001a\u00020\u001dH\u0002J\b\u0010w\u001a\u00020<H\u0002J\b\u0010x\u001a\u00020\u0011H\u0002J \u0010y\u001a\u00020<2\u0006\u0010z\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u001dH\u0002J\u0018\u0010{\u001a\u00020<2\u0006\u0010|\u001a\u00020\u001d2\u0006\u0010}\u001a\u00020\u001dH\u0002J\b\u0010~\u001a\u00020\rH\u0002J\u001a\u0010\u007f\u001a\u00020<2\u0007\u0010\u0080\u0001\u001a\u00020\u001d2\u0007\u0010\u0081\u0001\u001a\u00020\u001dH\u0002J\u0007\u0010\u0082\u0001\u001a\u00020<J\u0010\u0010\u0083\u0001\u001a\u00020<2\u0007\u0010\u0083\u0001\u001a\u00020\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u001a\u00100\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout;", "Lcom/larus/photopicker/v2/impl/others/scale/ClipFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "displayMatrix", "Landroid/graphics/Matrix;", "displayRectF", "Landroid/graphics/RectF;", "videoRect", "Landroid/graphics/Rect;", "scaleEndExecute", "", "scroller", "Landroid/widget/OverScroller;", "scrollByMultiPoint", "autoFitAnimator", "Landroid/animation/Animator;", "springBackAnimator", "appearOrDisAppearAnimator", "Landroid/animation/AnimatorSet;", "animationRunnable", "Ljava/lang/Runnable;", "totalDragDistanceY", "", "totalDragDistanceX", "currentAlpha", "curScaleFactor", "fastOutSlowInInterpolator", "Landroidx/interpolator/view/animation/FastOutSlowInInterpolator;", "scaleGestureLayoutListener", "Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayoutListener;", "matrixEvaluator", "Lcom/google/android/material/animation/MatrixEvaluator;", "isExit", "minScaleValue", "getMinScaleValue", "()F", "setMinScaleValue", "(F)V", "maxScaleValue", "getMaxScaleValue", "setMaxScaleValue", "doubleClickScaleValue", "getDoubleClickScaleValue", "setDoubleClickScaleValue", "listener", "com/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout$listener$1", "Lcom/larus/photopicker/v2/impl/others/scale/ScaleGestureLayout$listener$1;", "gestureDetector", "Lcom/larus/photopicker/v2/impl/others/scale/CombinationGestureDetector;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "setVideoSize", "videoWidth", "videoHeight", "setZoomListener", "animateAppear", "fromRect", "visibleRect", "radius", "maskInsetPixel", "", "listItemScaleType", "Lcom/larus/photopicker/v2/impl/others/ListItemScaleType;", "animationConfiguration", "Lcom/larus/photopicker/v2/impl/others/scale/AppearOrDisappearAnimationConfiguration;", "animateDisappear", "endAction", "Lkotlin/Function0;", "drawChildContent", "canvas", "Landroid/graphics/Canvas;", "child", "Landroid/view/View;", "drawingTime", "", "isDragging", "zoomOutIfNeeded", "motionEvent", "distanceX", "distanceY", "moveIfNeeded", "scaleIfNeeded", "scaleFactor", "focusX", "focusY", "restoreFromMoveEnd", "restoreFromScaleEnd", "autoFitForScale", "calculateAutoFitValue", "Lkotlin/Pair;", "displayRect", "calculateFocusPoint", "previousScrollX", "previousScrollY", "flingIfNeeded", "velocityX", "velocityY", "computeScroll", "doubleTapIfNeed", "executePendingAppearAnimation", "createMatrixAnimator", "fromMatrix", "toMatrix", "createAlphaAnimator", "resultValue", "resetGestureDetectorState", "isAnimationAppearRunning", "scaleMatrix", "scaleValue", "translateBy", "deltaX", "deltaY", "getCurrentDisPlayRectF", "calculateDisplayArea", "viewWidth", "viewHeight", "reset", "enableScale", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ScaleGestureLayout extends ClipFrameLayout {
    public static final /* synthetic */ int M = 0;
    public float A;
    public final FastOutSlowInInterpolator B;
    public a0 C;
    public final MatrixEvaluator D;
    public boolean E;
    public float F;
    public float G;
    public float H;
    public final h I;
    public boolean J;
    public int K;
    public int L;
    public Matrix n;
    public RectF o;
    public Rect p;
    public boolean q;
    public final OverScroller r;
    public boolean s;
    public Animator t;
    public Animator u;
    public AnimatorSet v;
    public q w;
    public float x;
    public float y;
    public float z;

    public static final class a {
    }

    public static final class b implements i {
        public final /* synthetic */ ScaleGestureLayout a;

        @Override // qp9.i
        public final void onLongPress(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public b(ScaleGestureLayout r1) {
            this.a = r1;
        }

        @Override // qp9.i
        public final void a(c r7) {
            Intrinsics.checkNotNullParameter(r7, "detector");
            ScaleGestureLayout r8 = this.a;
            if (r8.q == false) goto L7;
            r8.q = false;
            return;
        L7:
            if (r8.A > 1.0f) goto L30;
            float r0 = r8.x;
            if (r0 > 0.0f) goto L12;
        L19:
            Animator r1 = r8.u;
            if (r1 != null) goto L22;
        L24:
            boolean r2 = false;
        L25:
            if (r2 == true) goto L31;
            Animator r3 = r8.j(new Matrix(r8.n), new Matrix());
            r3.addListener(new y(r8));
            AnimatorSet r4 = new AnimatorSet();
            r4.playTogether(new Animator[]{r3, r8.i(1.0f)});
            r4.start();
            r8.u = r4;
            return;
        L31:
            return;
        L22:
            if (r1.isRunning() != true) goto L24;
            r2 = true;
            goto L25
        L12:
            if (Math.abs(r0) <= (r8.getHeight() * 0.2f)) goto L19;
            if (r8.E == true) goto L18;
            r8.E = true;
            a0 r5 = r8.C;
            if (r5 == null) goto L18;
            r5.onExit();
        L18:
            r8.l();
            return;
        }

        @Override // qp9.i
        public final void b(j r2) {
            Intrinsics.checkNotNullParameter(r2, "detector");
            ScaleGestureLayout r3 = this.a;
            r3.q = true;
            a0 r4 = r3.C;
            if (r4 == null) goto L5;
            r4.b();
        L5:
            ScaleGestureLayout.f(this.a);
        }

        @Override // qp9.i
        public final boolean c(j r4) {
            Intrinsics.checkNotNullParameter(r4, "detector");
            boolean r0 = true;
            this.a.getParent().requestDisallowInterceptTouchEvent(true);
            ScaleGestureLayout r5 = this.a;
            if (r5.A >= 1.0f) goto L5;
        L7:
            r0 = false;
        L8:
            if (r0 == false) goto L12;
            a0 r6 = r5.C;
            if (r6 == null) goto L12;
            r6.a();
        L12:
            return r0;
        L5:
            if (r5.J == true) goto L7;
            goto L7
        }

        @Override // qp9.i
        public final boolean d(j r8) {
            Intrinsics.checkNotNullParameter(r8, "detector");
            boolean r1 = false;
            if (r8.n != (-1.0f)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
        L20:
            float r2 = r8.n;
            float r3 = r8.f;
            float r9 = r8.g;
            if (Float.isNaN(r2) == false) goto L23;
        L38:
            return false;
        L23:
            if (Float.isInfinite(r2) == true) goto L38;
            ScaleGestureLayout r4 = this.a;
            int r5 = ScaleGestureLayout.M;
            r4.getClass();
            if (r2 != 1.0f) goto L28;
            r1 = true;
        L28:
            if (r1 == true) goto L37;
            int r6 = sp9.c.a;
            float r7 = sp9.c.a(r4.n);
            if (r2 >= 1.0f) goto L34;
            r2 = Math.max(r4.F / r7, r2);
        L36:
            Pair<Float, Float> r10 = r4.h(r3, r9);
            r4.n.postScale(r2, r2, ((Number) r10.getFirst()).floatValue(), ((Number) r10.getSecond()).floatValue());
            r4.A = sp9.c.a(r4.n);
            r4.invalidate();
            goto L37
        L34:
            if (r2 <= 1.0f) goto L36;
            r2 = Math.min(r4.G / r7, r2);
        L37:
            return true;
        L8:
            if (r8.l != (-1.0f)) goto L10;
            boolean r11 = true;
        L11:
            if (r11 == false) goto L13;
            float r12 = r8.j;
            float r13 = r8.k;
            r8.l = (float) Math.sqrt((r12 * r12) + (r13 * r13));
        L13:
            float r14 = r8.l;
            if (r8.m != (-1.0f)) goto L16;
            boolean r15 = true;
        L17:
            if (r15 == false) goto L19;
            float r16 = r8.h;
            float r17 = r8.i;
            r8.m = (float) Math.sqrt((r16 * r16) + (r17 * r17));
        L19:
            r8.n = r14 / r8.m;
            goto L20
        L16:
            r15 = false;
            goto L17
        L10:
            r11 = false;
            goto L11
        L5:
            r0 = false;
            goto L6
        }

        @Override // qp9.i
        public final void onDoubleTap(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            ScaleGestureLayout r0 = this.a;
            float r1 = r6.getX();
            float r7 = r6.getY();
            AnimatorSet r2 = r0.v;
            boolean r3 = false;
            if (r2 != null) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r4 == true) goto L38;
            Animator r5 = r0.t;
            if (r5 != null) goto L12;
        L14:
            boolean r8 = false;
        L15:
            if (r8 == true) goto L39;
            Animator r9 = r0.u;
            if (r9 != null) goto L20;
        L22:
            if (r3 == false) goto L26;
            Animator r10 = r0.u;
            if (r10 == null) goto L26;
            r10.cancel();
        L26:
            int r11 = sp9.b.a;
            if (sp9.b.c(r0.A, r0.H) == false) goto L29;
            Matrix r12 = new Matrix();
        L36:
            Animator r13 = r0.j(new Matrix(r0.n), r12);
            r13.start();
            r0.u = r13;
            return;
        L29:
            float r14 = r0.A;
            float r15 = r0.H;
            if ((r14 * r15) <= r15) goto L32;
            r15 = r15 / r14;
        L32:
            Matrix r16 = new Matrix(r0.n);
            Pair<Float, Float> r17 = r0.h(r1, r7);
            r16.postScale(r15, r15, ((Number) r17.getFirst()).floatValue(), ((Number) r17.getSecond()).floatValue());
            RectF r18 = new RectF(r0.o);
            r16.mapRect(r18);
            Pair<Float, Float> r19 = r0.g(r18);
            if (r19 == null) goto L35;
            r16.postTranslate(((Number) r19.getFirst()).floatValue(), ((Number) r19.getSecond()).floatValue());
        L35:
            r12 = r16;
            goto L36
        L20:
            if (r9.isRunning() != true) goto L22;
            r3 = true;
            goto L22
        L39:
            return;
        L12:
            if (r5.isRunning() != true) goto L14;
            r8 = true;
            goto L15
        L38:
            return;
        L5:
            if (r2.isRunning() != true) goto L7;
            r4 = true;
            goto L8
        }

        @Override // qp9.i
        public final boolean onDown(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            if (r4.getPointerCount() <= 2) goto L5;
            this.a.getParent().requestDisallowInterceptTouchEvent(true);
        L5:
            AnimatorSet r5 = this.a.v;
            if (r5 != null) goto L8;
        L10:
            boolean r6 = false;
        L11:
            if (r6 == false) goto L13;
            return false;
        L13:
            ScaleGestureLayout r7 = this.a;
            if (r7.A <= 1.0f) goto L16;
            r7.getParent().requestDisallowInterceptTouchEvent(true);
        L16:
            this.a.r.forceFinished(true);
            return true;
        L8:
            if (r5.isRunning() != true) goto L10;
            r6 = true;
            goto L11
        }

        @Override // qp9.i
        public final void onSingleTapConfirmed(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            a0 r3 = this.a.C;
            if (r3 == null) goto L6;
            r3.onClick();
            return;
        }

        @Override // qp9.i
        public final void onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r2, "e1");
            Intrinsics.checkNotNullParameter(r3, "e2");
            ScaleGestureLayout.d(this.a, r4, r5);
        }

        @Override // qp9.i
        public final boolean onScroll(MotionEvent r8, MotionEvent r9, float r10, float r11) {
            Intrinsics.checkNotNullParameter(r8, "e1");
            Intrinsics.checkNotNullParameter(r9, "e2");
            boolean r0 = false;
            if (this.a.q == false) goto L6;
            return false;
        L6:
            if (r9.getPointerCount() < 3) goto L8;
            return false;
        L8:
            ScaleGestureLayout r12 = this.a;
            if (r9.getPointerCount() <= 1) goto L11;
            boolean r1 = true;
        L12:
            r12.s = r1;
            ScaleGestureLayout r13 = this.a;
            if (r13.s == false) goto L15;
            r13.m(-r10, -r11);
        L33:
            return true;
        L15:
            float r2 = r13.A;
            if (r2 <= 1.0f) goto L19;
            ScaleGestureLayout.e(r13, -r10, -r11);
            goto L33
        L19:
            if (r2 != 1.0f) goto L21;
            r0 = true;
        L21:
            if (r0 == false) goto L33;
            float r14 = -r10;
            float r15 = -r11;
            float r3 = r13.y + r14;
            r13.y = r3;
            float r4 = r13.x + r15;
            r13.x = r4;
            if (r13.J == true) goto L28;
            if (r4 <= Math.abs(r3)) goto L28;
            r13.J = true;
            r13.getParent().requestDisallowInterceptTouchEvent(true);
        L28:
            if (r13.J == false) goto L33;
            int r5 = sp9.c.a;
            RectF r6 = new RectF(0.0f, 0.0f, r13.getWidth(), r13.getHeight());
            float r7 = r13.x;
            Intrinsics.checkNotNullParameter(r6, "viewRect");
            float r16 = 1.0f - Math.min(1.0f, Math.abs(r7) / (r6.height() * 1.0f));
            r13.z = r16;
            a0 r17 = r13.C;
            if (r17 == null) goto L32;
            r17.c(r16);
        L32:
            RectF r18 = new RectF(0.0f, 0.0f, r13.getWidth(), r13.getHeight());
            float r19 = r13.x;
            Intrinsics.checkNotNullParameter(r18, "viewRect");
            float r20 = ((Math.min(1.0f, Math.abs(r19) / (r18.height() * 1.0f)) * (-0.5f)) + 1.0f) / sp9.c.a(r13.n);
            Matrix r21 = r13.n;
            r21.postTranslate(r14, r15);
            r21.postScale(r20, r20, r9.getX(), r9.getY());
            r13.invalidate();
            goto L33
        L11:
            r1 = false;
            goto L12
        }
    }

    static {
    }

    public ScaleGestureLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ScaleGestureLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void c(ScaleGestureLayout r0) {
        setVideoSize$lambda$0(r0);
    }

    public final void l() {
        this.y = 0.0f;
        this.x = 0.0f;
        this.A = 1.0f;
        this.z = 1.0f;
        this.s = false;
        this.J = false;
        ViewParent r1 = getParent();
        if (r1 == null) goto L6;
        r1.requestDisallowInterceptTouchEvent(false);
        return;
    }

    private final RectF getCurrentDisPlayRectF() {
        RectF r0 = new RectF(this.o);
        this.n.mapRect(r0);
        return r0;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.r.computeScrollOffset() == false) goto L6;
        int r0 = this.K;
        int r1 = this.L;
        int r2 = this.r.getCurrX();
        int r3 = this.r.getCurrY();
        this.K = r2;
        this.L = r3;
        m(r2 - r0, r3 - r1);
        return;
    }

    public final void k() {
        this.n.reset();
        Animator r0 = this.t;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.t = null;
        AnimatorSet r1 = this.v;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.v = null;
        Animator r2 = this.u;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.u = null;
        this.w = null;
        l();
        invalidate();
    }

    public final float getDoubleClickScaleValue() {
        return this.H;
    }

    public final float getMaxScaleValue() {
        return this.G;
    }

    public final float getMinScaleValue() {
        return this.F;
    }

    public static final void f(ScaleGestureLayout r4) {
        boolean r2 = false;
        if (r4.A < 1.0f) goto L25;
        Animator r0 = r4.t;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L34;
        Animator r3 = r4.u;
        if (r3 != null) goto L14;
    L16:
        if (r2 == false) goto L19;
        return;
    L19:
        if (r4.r.isFinished() == false) goto L37;
        Pair<Float, Float> r5 = r4.g(r4.getCurrentDisPlayRectF());
        if (r5 == null) goto L38;
        Matrix r6 = new Matrix(r4.n);
        r6.postTranslate(((Number) r5.getFirst()).floatValue(), ((Number) r5.getSecond()).floatValue());
        Animator r7 = r4.j(new Matrix(r4.n), r6);
        r7.start();
        r4.t = r7;
        return;
    L38:
        return;
    L37:
        return;
    L14:
        if (r3.isRunning() != true) goto L16;
        r2 = true;
        goto L16
    L34:
        return;
    L7:
        if (r0.isRunning() != true) goto L9;
        r1 = true;
        goto L10
    L25:
        Animator r8 = r4.u;
        if (r8 != null) goto L28;
    L30:
        if (r2 == true) goto L39;
        Animator r9 = r4.j(r4.n, new Matrix());
        r9.addListener(new z(r4));
        r9.start();
        r4.u = r9;
        return;
    L39:
        return;
    L28:
        if (r8.isRunning() != true) goto L30;
        r2 = true;
        goto L30
    }

    private static final void setVideoSize$lambda$0(ScaleGestureLayout r9) {
        float r0 = r9.getWidth();
        float r1 = r9.getHeight();
        Rect r2 = r9.p;
        if (r2 == null) goto L16;
        float r3 = r2.width();
        Rect r4 = r9.p;
        if (r4 == null) goto L17;
        float r5 = r4.height();
        float r6 = r3 / r5;
        float r7 = r0 / r1;
        float r8 = 0.0f;
        if (r6 <= r7) goto L10;
        float r10 = (r5 * r0) / r3;
        float r11 = (r1 - r10) / 2;
        float r12 = r10 + r11;
    L14:
        r9.o = new RectF(r8, r11, r0, r12);
        return;
    L10:
        if (r6 >= r7) goto L12;
        float r13 = r9.getHeight();
        float r14 = (r3 * r1) / r5;
        float r15 = (r0 - r14) / 2;
        float r16 = r15 + r14;
    L13:
        r8 = r15;
        r0 = r16;
        r12 = r13;
        r11 = 0.0f;
        goto L14
    L12:
        r13 = r1;
        r16 = r0;
        r15 = 0.0f;
        goto L13
    L17:
        return;
    }

    public final Pair<Float, Float> g(RectF r5) {
        int r0 = sp9.b.a;
        float r1 = 0.0f;
        if (sp9.b.e(r5.left, 0.0f) == false) goto L13;
        if (sp9.b.e(r5.top, 0.0f) == false) goto L13;
        if (sp9.b.c(r5.right, getWidth()) == false) goto L13;
        if (sp9.b.c(r5.bottom, getHeight()) == false) goto L13;
        return null;
    L13:
        if (r5.width() >= getWidth()) goto L16;
        float r2 = getWidth() / 2;
        float r3 = r5.centerX();
    L25:
        float r4 = r2 - r3;
    L28:
        if (r5.height() >= getHeight()) goto L31;
        float r6 = getHeight() / 2;
        float r7 = r5.centerY();
    L40:
        r1 = r6 - r7;
    L42:
        return new Pair(Float.valueOf(r4), Float.valueOf(r1));
    L31:
        if (sp9.b.b(r5.top, 0.0f) == false) goto L36;
        if (sp9.b.b(r5.bottom, getHeight()) == false) goto L36;
        r1 = -r5.top;
    L36:
        if (sp9.b.d(r5.top, 0.0f) == false) goto L42;
        if (sp9.b.d(r5.bottom, getHeight()) == false) goto L42;
        r6 = getHeight();
        r7 = r5.bottom;
        goto L40
    L16:
        if (sp9.b.b(r5.left, 0.0f) == false) goto L21;
        if (sp9.b.b(r5.right, getWidth()) == false) goto L21;
        r4 = -r5.left;
    L21:
        if (sp9.b.d(r5.left, 0.0f) == true) goto L23;
    L26:
        r4 = 0.0f;
        goto L28
    L23:
        if (sp9.b.e(r5.right, getWidth()) == false) goto L26;
        r2 = getWidth();
        r3 = r5.right;
        goto L25
    }

    public final Animator i(float r4) {
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{this.z, r4});
        r5.addUpdateListener(new m(this));
        return r5;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        boolean r2 = false;
        if (getChildCount() != 0) goto L5;
        return false;
    L5:
        h r1 = this.I;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r10, "motionEvent");
        if (r1.b == false) goto L79;
        j r4 = r1.d;
        r4.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r10, "event");
        if (r10.getActionMasked() != 0) goto L11;
        r4.b();
    L11:
        if (r4.q == false) goto L14;
    L77:
        r1.e.a(r10);
        r1.c.onTouchEvent(r10);
    L81:
        return true;
    L14:
        if (r4.b == false) goto L62;
        int r0 = r10.getActionMasked();
        if (r0 != 1) goto L18;
        r4.b();
        goto L77
    L18:
        if (r0 != 2) goto L20;
        r4.c(this, r10);
        if ((r4.o / r4.p) <= 0.67f) goto L77;
        if (r4.a.a(this, r4) == false) goto L77;
        MotionEvent r3 = r4.c;
        Intrinsics.checkNotNull(r3);
        r3.recycle();
        r4.c = MotionEvent.obtain(r10);
        goto L77
    L20:
        if (r0 == 3) goto L55;
        if (r0 != 5) goto L23;
        r4.a.c(this, r4);
        int r5 = r4.r;
        int r6 = r4.s;
        r4.b();
        r4.c = MotionEvent.obtain(r10);
        if (r4.t == true) goto L49;
        r5 = r6;
    L49:
        r4.r = r5;
        r4.s = r10.getPointerId(r10.getActionIndex());
        r4.t = false;
        if (r10.findPointerIndex(r4.r) >= 0) goto L52;
    L53:
        r4.r = r10.getPointerId(j.a(r10, r4.s, -1));
    L54:
        r4.c(this, r10);
        r4.b = r4.a.b(this, r4);
        goto L77
    L52:
        if (r4.r != r4.s) goto L54;
    L23:
        if (r0 != 6) goto L77;
        int r7 = r10.getPointerCount();
        int r8 = r10.getActionIndex();
        int r9 = r10.getPointerId(r8);
        if (r7 <= 2) goto L39;
        int r11 = r4.r;
        if (r9 != r11) goto L33;
        int r12 = j.a(r10, r4.s, r8);
        if (r12 < 0) goto L37;
        r4.a.c(this, r4);
        r4.r = r10.getPointerId(r12);
        r4.t = true;
        r4.c = MotionEvent.obtain(r10);
        r4.c(this, r10);
        r4.b = r4.a.b(this, r4);
    L38:
        MotionEvent r13 = r4.c;
        Intrinsics.checkNotNull(r13);
        r13.recycle();
        r4.c = MotionEvent.obtain(r10);
        r4.c(this, r10);
    L40:
        if (r2 == false) goto L77;
        r4.c(this, r10);
        int r14 = r4.r;
        if (r9 != r14) goto L44;
        r14 = r4.s;
    L44:
        int r15 = r10.findPointerIndex(r14);
        r4.f = r10.getX(r15);
        r4.g = r10.getY(r15);
        r4.a.c(this, r4);
        r4.b();
        r4.r = r14;
        r4.t = true;
    L37:
        r2 = true;
        goto L38
    L33:
        if (r9 != r4.s) goto L38;
        int r16 = j.a(r10, r11, r8);
        if (r16 < 0) goto L37;
        r4.a.c(this, r4);
        r4.s = r10.getPointerId(r16);
        r4.t = false;
        r4.c = MotionEvent.obtain(r10);
        r4.c(this, r10);
        r4.b = r4.a.b(this, r4);
        goto L38
    L39:
        r2 = true;
        goto L40
    L55:
        r4.a.c(this, r4);
        r4.b();
        goto L77
    L62:
        int r17 = r10.getActionMasked();
        if (r17 == 0) goto L76;
        if (r17 == 1) goto L75;
        if (r17 != 5) goto L77;
        MotionEvent r18 = r4.c;
        if (r18 == null) goto L70;
        Intrinsics.checkNotNull(r18);
        r18.recycle();
    L70:
        r4.c = MotionEvent.obtain(r10);
        int r19 = r10.getActionIndex();
        int r20 = r10.findPointerIndex(r4.r);
        int r21 = r10.getPointerId(r19);
        r4.s = r21;
        if (r20 < 0) goto L73;
        if (r20 == r19) goto L73;
    L74:
        r4.t = false;
        r4.c(this, r10);
        r4.b = r4.a.b(this, r4);
    L73:
        r4.r = r10.getPointerId(j.a(r10, r21, -1));
        goto L74
    L75:
        r4.b();
        goto L77
    L76:
        r4.r = r10.getPointerId(0);
        r4.t = true;
        goto L77
    L79:
        if (r10.getPointerCount() != 1) goto L81;
        r1.e.a(r10);
        r1.c.onTouchEvent(r10);
        goto L81
    }

    public final void setDoubleClickScaleValue(float r1) {
        this.H = r1;
    }

    public final void setMaxScaleValue(float r1) {
        this.G = r1;
    }

    public final void setMinScaleValue(float r1) {
        this.F = r1;
    }

    public final void setZoomListener(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.C = r2;
    }

    public final Pair<Float, Float> h(float r3, float r4) {
        RectF r0 = getCurrentDisPlayRectF();
        int r1 = sp9.b.a;
        if (sp9.b.d(r3, r0.left) == false) goto L6;
        r3 = r0.left;
    L9:
        if (sp9.b.d(r4, r0.top) == false) goto L12;
        r4 = r0.top;
    L15:
        return new Pair(Float.valueOf(r3), Float.valueOf(r4));
    L12:
        if (sp9.b.b(r4, r0.bottom) == false) goto L15;
        r4 = r0.bottom;
        goto L15
    L6:
        if (sp9.b.b(r3, r0.right) == false) goto L9;
        r3 = r0.right;
        goto L9
    }

    public final Animator j(Matrix r4, Matrix r5) {
        ValueAnimator r6 = ValueAnimator.ofObject(this.D, new Object[]{r4, r5});
        r6.addUpdateListener(new l(this));
        r6.setInterpolator(this.B);
        return r6;
    }

    public final void m(float r3, float r4) {
        if (sp9.b.a(r3, 0.0f) == true) goto L5;
    L7:
        this.n.postTranslate(r3, r4);
        invalidate();
        return;
    L5:
        if (sp9.b.a(r4, 0.0f) == false) goto L7;
    }

    public ScaleGestureLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.n = new Matrix();
        this.r = new OverScroller(r2);
        this.z = 1.0f;
        this.A = 1.0f;
        this.B = new FastOutSlowInInterpolator();
        this.D = new MatrixEvaluator();
        this.F = 0.7f;
        this.G = 10.0f;
        this.H = 3.0f;
        this.I = new h(r2, new b(this));
    }

    public static final void d(ScaleGestureLayout r20, float r21, float r22) {
        Animator r3 = r20.t;
        boolean r4 = true;
        if (r3 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == true) goto L63;
        Animator r6 = r20.u;
        if (r6 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == true) goto L64;
        AnimatorSet r8 = r20.v;
        if (r8 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == true) goto L65;
        RectF r10 = r20.getCurrentDisPlayRectF();
        if (r10.width() < r20.getWidth()) goto L27;
    L29:
        float r11 = -Math.max(r10.right - r20.getWidth(), 0.0f);
        float r12 = 0;
        float r13 = Math.max(r12 - r10.left, 0.0f);
        float r14 = -Math.max(r10.bottom - r20.getHeight(), 0.0f);
        float r15 = Math.max(r12 - r10.top, 0.0f);
        if (sp9.b.a(r11, 0.0f) == false) goto L39;
        if (sp9.b.a(r13, 0.0f) == false) goto L39;
        if (sp9.b.a(r14, 0.0f) == false) goto L39;
        if (sp9.b.a(r15, 0.0f) == false) goto L39;
        return;
    L39:
        if (r21 <= 0.0f) goto L43;
        if (r13 <= 0.0f) goto L43;
    L46:
        boolean r16 = true;
    L49:
        if (r22 <= 0.0f) goto L53;
        if (r15 <= 0.0f) goto L53;
    L58:
        if (r16 == true) goto L61;
        if (r4 == true) goto L61;
        return;
    L61:
        r20.K = 0;
        r20.L = 0;
        r20.r.fling(0, 0, (int) r21, (int) r22, (int) r11, (int) r13, (int) r14, (int) r15);
        ViewCompat.postInvalidateOnAnimation(r20);
        return;
    L53:
        if (r22 < 0.0f) goto L55;
    L57:
        r4 = false;
        goto L58
    L55:
        if (r14 >= 0.0f) goto L57;
    L43:
        if (r21 < 0.0f) goto L45;
    L47:
        r16 = false;
        goto L49
    L45:
        if (r11 >= 0.0f) goto L47;
    L27:
        if (r10.height() >= r20.getHeight()) goto L29;
        return;
    L65:
        return;
    L19:
        if (r8.isRunning() != true) goto L21;
        r9 = true;
        goto L22
    L64:
        return;
    L12:
        if (r6.isRunning() != true) goto L14;
        r7 = true;
        goto L15
    L63:
        return;
    L5:
        if (r3.isRunning() != true) goto L7;
        r5 = true;
        goto L8
    }

    public static final void e(ScaleGestureLayout r6, float r7, float r8) {
        RectF r0 = r6.getCurrentDisPlayRectF();
        int r1 = sp9.b.a;
        if (sp9.b.c(r0.left, 0.0f) == false) goto L8;
        if (sp9.b.e(r0.right, r6.getWidth()) == false) goto L8;
    L22:
        float r2 = 0.0f;
    L34:
        if (sp9.b.c(r0.top, 0.0f) == false) goto L39;
        if (sp9.b.e(r0.bottom, r6.getHeight()) == false) goto L39;
    L53:
        float r3 = 0.0f;
    L65:
        if (Math.abs(r7) > Math.abs(r8)) goto L67;
    L83:
        r6.m(r2, r3);
        return;
    L67:
        if (sp9.b.a(r2, 0.0f) == false) goto L83;
        boolean r9 = true;
        if (r7 > 0.0f) goto L71;
    L73:
        boolean r5 = false;
    L75:
        if (r7 < 0.0f) goto L77;
    L79:
        r9 = false;
    L80:
        if (r5 == true) goto L82;
        if (r9 == false) goto L83;
    L82:
        r6.getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L77:
        if (sp9.b.e(r0.right, r6.getWidth()) == false) goto L79;
    L71:
        if (sp9.b.c(r0.left, 0.0f) == false) goto L73;
        r5 = true;
    L39:
        if (sp9.b.c(r0.top, 0.0f) == false) goto L47;
        if (sp9.b.b(r0.bottom, r6.getHeight()) == false) goto L47;
        if (r8 >= 0.0f) goto L53;
        float r4 = Math.min(Math.abs(r0.bottom - r6.getHeight()), Math.abs(r8));
    L62:
        r3 = -r4;
    L47:
        if (sp9.b.d(r0.top, 0.0f) == false) goto L55;
        if (sp9.b.e(r0.bottom, r6.getHeight()) == false) goto L55;
        if (r8 < 0.0f) goto L53;
        r3 = Math.min(Math.abs(r0.top), Math.abs(r8));
    L55:
        if (sp9.b.d(r0.top, 0.0f) == true) goto L57;
    L63:
        r3 = r8;
        goto L65
    L57:
        if (sp9.b.b(r0.bottom, r6.getHeight()) == false) goto L63;
        if (r8 < 0.0f) goto L61;
        r3 = Math.min(Math.abs(r0.top), Math.abs(r8));
        goto L65
    L61:
        r4 = Math.min(Math.abs(r0.bottom - r6.getHeight()), Math.abs(r8));
    L8:
        if (sp9.b.c(r0.left, 0.0f) == false) goto L16;
        if (sp9.b.b(r0.right, r6.getWidth()) == false) goto L16;
        if (r7 >= 0.0f) goto L22;
        float r10 = Math.min(Math.abs(r0.right - r6.getWidth()), Math.abs(r7));
    L31:
        r2 = -r10;
    L16:
        if (sp9.b.d(r0.left, 0.0f) == false) goto L24;
        if (sp9.b.e(r0.right, r6.getWidth()) == false) goto L24;
        if (r7 < 0.0f) goto L22;
        r2 = Math.min(Math.abs(r0.left), Math.abs(r7));
    L24:
        if (sp9.b.d(r0.left, 0.0f) == true) goto L26;
    L32:
        r2 = r7;
        goto L34
    L26:
        if (sp9.b.b(r0.right, r6.getWidth()) == false) goto L32;
        if (r7 < 0.0f) goto L30;
        r2 = Math.min(Math.abs(r0.left), Math.abs(r7));
        goto L34
    L30:
        r10 = Math.min(Math.abs(r0.right - r6.getWidth()), Math.abs(r7));
        goto L31
    }

    @Override // com.larus.photopicker.v2.impl.others.scale.ClipFrameLayout
    public final boolean a(Canvas r2, View r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r3, "child");
        r2.save();
        r2.concat(this.n);
        boolean r5 = super.a(r2, r3, r4);
        r2.restore();
        return r5;
    }

    public /* synthetic */ ScaleGestureLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // com.larus.photopicker.v2.impl.others.scale.ClipFrameLayout, android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (getWidth() > 0) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (this.p == null) goto L18;
        if (r5 == true) goto L12;
        return;
    L12:
        if (this.n.isIdentity() == false) goto L20;
        q r6 = this.w;
        if (r6 == null) goto L21;
        this.w = null;
        r6.run();
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    L5:
        if (getHeight() <= 0) goto L7;
        r5 = true;
        goto L9
    }
}
