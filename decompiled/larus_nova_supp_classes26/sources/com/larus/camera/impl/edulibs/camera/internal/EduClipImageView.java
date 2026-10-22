package com.larus.camera.impl.edulibs.camera.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableKt;
import com.larus.camera.impl.edulibs.camera.internal.view.EduClipImageRect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.i;
import nx8.k;
import nx8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0017\u0018\u0000 s2\u00020\u0001:\u0002stB)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u00108\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020;H\u0014J\u001a\u0010<\u001a\u00020\u00162\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020\u001eH\u0002J\u0012\u0010>\u001a\u00020\u001e2\b\u0010?\u001a\u0004\u0018\u00010@H\u0017J\u0012\u0010A\u001a\u00020\u00162\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0016J\u0017\u0010C\u001a\u00020\u00162\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\bDJ\u000e\u0010E\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010FJ\u000e\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020 J\b\u0010I\u001a\u0004\u0018\u00010JJ\u0006\u0010K\u001a\u00020*J\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001e0MJ\f\u0010N\u001a\b\u0012\u0004\u0012\u00020J0MJ\u0006\u0010O\u001a\u00020*J\b\u0010P\u001a\u0004\u0018\u00010\u000fJ\"\u0010Q\u001a\u00020\u00162\u0006\u0010R\u001a\u00020*2\b\b\u0002\u0010S\u001a\u00020\u001e2\b\b\u0002\u0010T\u001a\u00020\u001eJ\u0016\u0010U\u001a\u00020\u00162\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020\u001eJ$\u0010V\u001a\u00020\u00162\u0006\u0010R\u001a\u00020*2\b\b\u0002\u0010S\u001a\u00020\u001e2\b\b\u0002\u0010T\u001a\u00020\u001eH\u0002J\u0016\u0010W\u001a\u00020\u00162\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020\u001eJ\u000e\u0010X\u001a\u00020\u00162\u0006\u0010R\u001a\u00020*J\u001c\u0010Y\u001a\u00020\u00162\b\b\u0002\u0010S\u001a\u00020\u001e2\b\b\u0002\u0010T\u001a\u00020\u001eH\u0002J\f\u0010Z\u001a\u00020**\u00020*H\u0002J\f\u0010[\u001a\u00020**\u00020*H\u0002J\u0016\u0010\\\u001a\u00020\u00162\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020^J\u000e\u0010`\u001a\u00020\u00162\u0006\u0010a\u001a\u00020^J\u001c\u0010b\u001a\u00020\u00162\f\u0010c\u001a\b\u0012\u0004\u0012\u00020J0M2\u0006\u0010d\u001a\u00020*J \u0010e\u001a\u00020\u00162\u0006\u0010c\u001a\u00020J2\u0006\u0010f\u001a\u00020\u001e2\b\b\u0002\u0010g\u001a\u00020\u001eJ\u001e\u0010h\u001a\u00020J2\u0006\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020*2\u0006\u0010k\u001a\u00020\u001eJ\u000e\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020JJ\u0018\u0010n\u001a\u00020\u00162\u0006\u0010c\u001a\u00020J2\u0006\u0010o\u001a\u00020\u001eH\u0002J\b\u0010p\u001a\u00020\u0016H\u0002J\u0018\u0010q\u001a\u00020\u00162\u0006\u0010r\u001a\u00020^2\u0006\u0010R\u001a\u00020^H\u0002R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u000e\u00107\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/EduClipImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "uiConfig", "Lcom/larus/camera/impl/edulibs/cameraapi/EduImageUiConfig;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/larus/camera/impl/edulibs/cameraapi/EduImageUiConfig;)V", "logger", "Lcom/larus/camera/impl/edulibs/cameraapi/EduLogger;", "getLogger", "()Lcom/larus/camera/impl/edulibs/cameraapi/EduLogger;", "originBitmap", "Landroid/graphics/Bitmap;", "getOriginBitmap", "()Landroid/graphics/Bitmap;", "setOriginBitmap", "(Landroid/graphics/Bitmap;)V", "imageSetCallback", "Lkotlin/Function1;", "", "getImageSetCallback", "()Lkotlin/jvm/functions/Function1;", "setImageSetCallback", "(Lkotlin/jvm/functions/Function1;)V", "drawHelper", "Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipImageDrawHelper;", "isRotating", "", "clipChangeListener", "Lcom/larus/camera/impl/edulibs/cameraapi/IEduClipImageView$ClipRectChangeListener;", "clipRect", "Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipImageRect;", "showDecoration", "rectDecorations", "", "Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipRectDecoration;", "animator", "Landroid/animation/ValueAnimator;", "rotateDegrees", "", "orientationDegrees", "screenOrientationDegrees", "preparedContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "value", "isMultiMode", "()Z", "setMultiMode", "(Z)V", "enableClipRect", "getEnableClipRect", "setEnableClipRect", "hasUserChangeClip", "getDefaultCornerBitmap", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawInternal", "showSelect", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImageBitmap", "bm", "setImageBitmapAndReprepare", "setImageBitmapAndReprepare$impl_mainlandRelease", "ensurePrepared", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setClipRectChangeListener", "l", "getClipRect", "Landroid/graphics/RectF;", "getRotateDegrees", "getClipModifyList", "", "getAllClipRect", "getSelectIndex", "createViewBitmap", "rotateByDegrees", "degrees", "animate", "cancelCurrent", "rotateToDegrees", "rotateByDegreesInner", "changeOrientation", "setScreenOrientationDegrees", "rotateToDegreesInner", "degree2Positive", "degree2Valid", "setClipAlpha", "bgAlpha", "", "rectAlpha", "setCornerRadius", "radius", "initClipRect", "rect", "selectIndex", "setClipRect", "isOriginRect", "isInAnimate", "createDefaultClipRect", "width", "height", "isHorizontal", "calcClipRect", "originRect", "setClipRectInternal", "ignoreCheck", "prepare", "updateMatrix", "scale", "Companion", "RotateAnimationListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduClipImageView extends AppCompatImageView {
    public static final /* synthetic */ int p = 0;
    public Bitmap a;
    public Function1<? super Bitmap, Unit> b;
    public final mx8.a c;
    public boolean d;
    public m.a e;
    public final EduClipImageRect f;
    public boolean g;
    public final List<mx8.e> h;
    public ValueAnimator i;
    public int j;
    public int k;
    public int l;
    public i<? super Unit> m;
    public boolean n;
    public boolean o;

    public static final class a {
    }

    public final class b extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public final float a;
        public final float b;
        public final /* synthetic */ EduClipImageView c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            EduClipImageView r3 = this.c;
            r3.d = false;
            r3.g = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            EduClipImageView r3 = this.c;
            r3.d = false;
            r3.g = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            EduClipImageView r4 = this.c;
            r4.d = true;
            EduClipImageRect r0 = r4.f;
            if (r0.j == null) goto L5;
            r0.j = null;
        L5:
            r4.g = false;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [android.widget.ImageView, com.larus.camera.impl.edulibs.camera.internal.EduClipImageView] */
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            Object r0 = r4.getAnimatedValue();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Float");
            float r1 = ((Float) r0).floatValue();
            float r2 = ((this.b - this.a) * r4.getAnimatedFraction()) + this.a;
            ?? r5 = this.c;
            int r3 = EduClipImageView.p;
            mx8.a r6 = r5.c;
            r6.b = r1;
            r6.c = r2;
            r6.b();
            r5.f.c(false);
            r5.invalidate();
        }

        public b(EduClipImageView r1, float r2, float r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ EduClipImageView a;

        /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.ImageView, com.larus.camera.impl.edulibs.camera.internal.EduClipImageView] */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            ?? r0 = this.a;
            Bitmap r1 = r0.a;
            if (r1 == null) goto L49;
            Float r3 = Float.valueOf(r0.getWidth());
            if (r3.floatValue() <= 0.0f) goto L8;
            boolean r4 = true;
        L10:
            if (r4 == true) goto L13;
            r3 = null;
        L13:
            if (r3 == null) goto L49;
            float r5 = r3.floatValue();
            Float r6 = Float.valueOf(r0.getHeight());
            if (r6.floatValue() <= 0.0f) goto L17;
            boolean r8 = true;
        L18:
            if (r8 == true) goto L21;
            r6 = null;
        L21:
            if (r6 == null) goto L49;
            float r7 = r6.floatValue();
            Float r9 = Float.valueOf(r1.getWidth());
            if (r9.floatValue() <= 0.0f) goto L25;
            boolean r10 = true;
        L26:
            if (r10 == true) goto L29;
            r9 = null;
        L29:
            if (r9 == null) goto L49;
            float r11 = r9.floatValue();
            Float r2 = Float.valueOf(r1.getHeight());
            if (r2.floatValue() <= 0.0f) goto L33;
            boolean r12 = true;
        L34:
            if (r12 == true) goto L37;
            r2 = null;
        L37:
            if (r2 == null) goto L49;
            float r13 = r2.floatValue();
            mx8.a r14 = r0.c;
            r14.a = true;
            r14.h = r5;
            r14.i = r7;
            r14.j = r11;
            r14.k = r13;
            if (r11 > 0.0f) goto L41;
        L43:
            r0.c.b();
            i<? super Unit> r15 = r0.m;
            if (r15 != null) goto L46;
        L48:
            r0.m = null;
            goto L49
        L46:
            if (r15.isActive() == false) goto L48;
            Result.Companion r16 = Result.Companion;
            r15.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            goto L48
        L41:
            if (r13 <= 0.0f) goto L43;
            r14.b = r14.a(r14.c);
            r14.f.set(0.0f, 0.0f, r11, r13);
            goto L43
        L33:
            r12 = false;
            goto L34
        L25:
            r10 = false;
            goto L26
        L17:
            r8 = false;
            goto L18
        L8:
            r4 = false;
        L49:
            return false;
        }

        public c(EduClipImageView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public EduClipImageView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 6);
    }

    public EduClipImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 4);
    }

    public final List<RectF> getAllClipRect() {
        List<EduClipImageRect.a> r0 = this.f.g;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((EduClipImageRect.a) r2.next()).d);
        goto L4
    L6:
        return r1;
    }

    public final List<Boolean> getClipModifyList() {
        EduClipImageRect r0 = this.f;
        boolean r2 = false;
        if (r0.h == false) goto L5;
        List<EduClipImageRect.a> r1 = r0.g;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r4 = r1.iterator();
    L17:
        if (r4.hasNext() == false) goto L27;
        EduClipImageRect.a r5 = (EduClipImageRect.a) r4.next();
        if (this.o == false) goto L21;
    L24:
        boolean r6 = true;
    L25:
        r3.add(Boolean.valueOf(r6));
        goto L17
    L21:
        if (r5.m == true) goto L24;
        r6 = false;
        goto L25
    L27:
        return r3;
    L5:
        if (this.o == true) goto L13;
        EduClipImageRect.a r7 = r0.f;
        if (r7 != null) goto L9;
    L11:
        boolean r8 = false;
    L12:
        if (r8 == true) goto L13;
    L31:
        return CollectionsKt.listOf(Boolean.valueOf(r2));
    L9:
        if (r7.m != true) goto L11;
        r8 = true;
    L13:
        r2 = true;
        goto L31
    }

    public final RectF getClipRect() {
        EduClipImageRect.a r0 = this.f.f;
        if (r0 == null) goto L15;
        boolean r2 = false;
        if (r0.d.width() != 0.0f) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L17;
        if (r0.d.height() != 0.0f) goto L12;
        r2 = true;
    L12:
        if (r2 == true) goto L15;
    L17:
        return r0.d;
    L7:
        r1 = false;
    L15:
        return null;
    }

    public final int getSelectIndex() {
        Iterator r0 = ((ArrayList) this.f.g).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        EduClipImageRect.a r2 = (EduClipImageRect.a) r0.next();
        if (Intrinsics.areEqual(this.f.f, r2) == true) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return r1;
    L9:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Bitmap getDefaultCornerBitmap() {
        Drawable r2 = ContextCompat.getDrawable(getContext(), 2131240698);
        if (r2 != null) goto L7;
        return null;
    L7:
        return DrawableKt.toBitmap$default(r2, 0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Bitmap m() {
        Bitmap r0 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L4 Exception -> L6
        n(new Canvas(r0), false);     // Catch: Throwable -> L4 Exception -> L6
        RectF r1 = this.c.g;     // Catch: Throwable -> L4 Exception -> L6
        int r3 = (int) r1.width();     // Catch: Throwable -> L4 Exception -> L6
        int r4 = (int) r1.height();     // Catch: Throwable -> L4 Exception -> L6
        Bitmap r5 = Bitmap.createBitmap(r3, r4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L4 Exception -> L6
        new Canvas(r5).drawBitmap(r0, new Rect((int) r1.left, (int) r1.top, (int) r1.right, (int) r1.bottom), new Rect(0, 0, r3, r4), null);     // Catch: Throwable -> L4 Exception -> L6
        return r5;
    L6:
        e = move-exception;
        getLogger().e("ClipImageView", "createViewBitmap error", e);     // Catch: Throwable -> L4
        return this.a;
    L4:
        th = move-exception;
        throw th;
    }

    private final k getLogger() {
        return com.larus.camera.impl.edulibs.camera.a.c;
    }

    public final boolean getEnableClipRect() {
        return this.n;
    }

    public final Function1<Bitmap, Unit> getImageSetCallback() {
        return this.b;
    }

    public final Bitmap getOriginBitmap() {
        return this.a;
    }

    public final int getRotateDegrees() {
        return this.j;
    }

    public final void j(int r5) {
        int r0 = r5 % 360;
        if (r0 <= 180) goto L6;
        r0 = r0 - 360;
    L8:
        getLogger().d("ClipImageView", "changeOrientation: target=" + r0 + ", degrees=" + r5);
        mx8.a r6 = this.c;
        if (r6.a == true) goto L13;
        this.k = r0;
        r6.c = this.j + r0;
        return;
    L13:
        if (r0 == this.k) goto L16;
        this.k = r0;
        o(false, true);
        return;
    L16:
        return;
    L6:
        if (r0 >= (-180)) goto L8;
        r0 = r0 + 360;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super/*android.widget.ImageView*/.onDraw(r2);
        n(r2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r17) {
        if (this.n == false) goto L176;
        if (this.d == true) goto L176;
        if (isEnabled() == false) goto L176;
        EduClipImageRect r1 = this.f;
        r1.getClass();
        Integer r2 = null;
        if (r17 == null) goto L150;
        int r6 = r17.getActionMasked();
        if (r6 == 0) goto L128;
        if (r6 == 1) goto L125;
        if (r6 == 2) goto L40;
        if (r6 != 3) goto L19;
        EduClipImageRect.c r7 = r1.j;
        if (r7 == null) goto L24;
        EduClipImageRect.a r8 = r7.c;
    L25:
        if (r8 == null) goto L38;
        EduClipImageRect.a r9 = r1.f;
        if (r7 == null) goto L29;
        EduClipImageRect.a r10 = r7.c;
    L31:
        if (Intrinsics.areEqual(r9, r10) == true) goto L38;
        EduClipImageRect.c r11 = r1.j;
        if (r11 == null) goto L35;
        EduClipImageRect.a r12 = r11.c;
    L36:
        r1.f = r12;
        goto L38
    L35:
        r12 = null;
        goto L36
    L29:
        r10 = null;
    L38:
        if (r1.j == null) goto L150;
        r1.j = null;
    L149:
        boolean r3 = true;
    L151:
        if (r3 == false) goto L170;
        invalidate();
        if (r17 == null) goto L155;
        r2 = Integer.valueOf(r17.getActionMasked());
    L155:
        if (r2 != null) goto L158;
    L159:
        if (r2 == null) goto L170;
        if (r2.intValue() != 1) goto L170;
    L164:
        if (this.f.h == false) goto L166;
        int r4 = RangesKt.coerceAtLeast(getSelectIndex(), 0) + 1;
    L167:
        m.a r5 = this.e;
        if (r5 == null) goto L170;
        r5.a(r4);
        goto L170
    L166:
        r4 = 1;
        goto L167
    L158:
        if (r2.intValue() == 3) goto L164;
    L170:
        if (r3 == false) goto L172;
    L173:
        return true;
    L172:
        if (super/*android.widget.ImageView*/.onTouchEvent(r17) == true) goto L173;
        return false;
    L24:
        r8 = null;
        goto L25
    L19:
        if (r1.j == null) goto L150;
    L40:
        EduClipImageRect.c r13 = r1.j;
        if (r13 == null) goto L122;
        float r14 = r17.getX();
        float r15 = r17.getY();
        float r16 = r14 - r13.e;
        float r18 = r15 - r13.f;
        r13.e = r14;
        r13.f = r15;
        r13.h.set(r13.g);
        EduClipImageRect.Location r19 = r13.a;
        if (r19 != EduClipImageRect.Location.CENTER) goto L65;
        r13.g.offset(r16, r18);
        RectF r20 = r13.g;
        float r21 = r20.left;
        RectF r110 = r13.d;
        float r111 = r110.left;
        if (r21 < r111) goto L47;
    L49:
        float r22 = r20.right;
        float r112 = r110.right;
        if (r22 > r112) goto L52;
    L54:
        RectF r23 = r13.g;
        float r24 = r23.top;
        RectF r25 = r13.d;
        float r113 = r25.top;
        if (r24 < r113) goto L57;
    L59:
        float r26 = r23.bottom;
        float r27 = r25.bottom;
        if (r26 > r27) goto L62;
    L115:
        if ((!Intrinsics.areEqual(r13.h, r13.g)) == false) goto L117;
        r13.c.m = true;
    L117:
        EduClipImageRect.a r28 = r13.c;
        Matrix r29 = r1.a.e;
        r28.getClass();
        Intrinsics.checkNotNullParameter(r29, "invertMatrix");
        r29.mapRect(r28.d, r28.e);
        if (Intrinsics.areEqual(r1.f, r13.c) == true) goto L120;
        r1.f = r13.c;
    L120:
        r1.c(true);
        goto L122
    L62:
        if (r18 <= 0.0f) goto L115;
        r23.offset(0.0f, r27 - r26);
        goto L115
    L57:
        if (r18 >= 0.0f) goto L59;
        r23.offset(0.0f, r113 - r24);
        goto L115
    L52:
        if (r16 <= 0.0f) goto L54;
        r20.offset(r112 - r22, 0.0f);
        goto L54
    L47:
        if (r16 >= 0.0f) goto L49;
        r20.offset(r111 - r21, 0.0f);
        goto L54
    L65:
        if (r19 != EduClipImageRect.Location.LEFT) goto L67;
    L83:
        RectF r30 = r13.g;
        r30.left += r16;
        if (r30.width() >= r13.b) goto L86;
        r13.g.left -= r16;
    L89:
        EduClipImageRect.Location r31 = r13.a;
        if (r31 != EduClipImageRect.Location.TOP) goto L92;
    L108:
        RectF r32 = r13.g;
        r32.top += r18;
        if (r32.height() >= r13.b) goto L111;
        r13.g.top -= r18;
        goto L115
    L111:
        RectF r33 = r13.g;
        float r34 = r33.top;
        float r35 = r13.d.top;
        if (r34 >= r35) goto L115;
        r33.top = r34 - r35;
        goto L115
    L92:
        if (r31 == EduClipImageRect.Location.TOP_LEFT) goto L108;
        if (r31 == EduClipImageRect.Location.TOP_RIGHT) goto L108;
        if (r31 != EduClipImageRect.Location.BOTTOM) goto L99;
    L102:
        RectF r36 = r13.g;
        r36.bottom += r18;
        if (r36.height() >= r13.b) goto L105;
        r13.g.bottom -= r18;
        goto L115
    L105:
        RectF r37 = r13.g;
        float r38 = r37.bottom;
        float r39 = r13.d.bottom;
        if (r38 <= r39) goto L115;
        r37.bottom = r39;
        goto L115
    L99:
        if (r31 == EduClipImageRect.Location.BOTTOM_LEFT) goto L102;
        if (r31 != EduClipImageRect.Location.BOTTOM_RIGHT) goto L115;
    L86:
        RectF r40 = r13.g;
        float r41 = r40.left;
        float r42 = r13.d.left;
        if (r41 >= r42) goto L89;
        r40.left = r42;
        goto L89
    L67:
        if (r19 == EduClipImageRect.Location.TOP_LEFT) goto L83;
        if (r19 == EduClipImageRect.Location.BOTTOM_LEFT) goto L83;
        if (r19 != EduClipImageRect.Location.RIGHT) goto L74;
    L77:
        RectF r43 = r13.g;
        r43.right += r16;
        if (r43.width() >= r13.b) goto L80;
        r13.g.right -= r16;
        goto L89
    L80:
        RectF r44 = r13.g;
        float r45 = r44.right;
        float r46 = r13.d.right;
        if (r45 <= r46) goto L89;
        r44.right = r46;
        goto L89
    L74:
        if (r19 == EduClipImageRect.Location.TOP_RIGHT) goto L77;
        if (r19 != EduClipImageRect.Location.BOTTOM_RIGHT) goto L89;
    L122:
        if (r1.j == null) goto L150;
    L125:
        if (r1.j == null) goto L150;
        r1.j = null;
        goto L149
    L128:
        if (r1.h == false) goto L136;
        Iterator r47 = ((ArrayList) r1.g).iterator();
        EduClipImageRect.Location r48 = null;
    L131:
        if (r47.hasNext() == false) goto L142;
        EduClipImageRect.a r49 = (EduClipImageRect.a) r47.next();
        EduClipImageRect.Location r50 = r49.a(r17.getX(), r17.getY());
        if (r50 != null) goto L143;
        r48 = r50;
    L143:
        EduClipImageRect.a r114 = r49;
        EduClipImageRect.Location r115 = r50;
        if (r115 == null) goto L148;
        if (r114 == null) goto L148;
        RectF r116 = new RectF(r1.a.g);
        float r51 = r1.b.c;
        r116.inset(r51, r51);
        r1.j = new EduClipImageRect.c(r115, r1.b.h, r114, r116, r17.getX(), r17.getY());
    L148:
        if (r1.j == null) goto L150;
    L142:
        r50 = r48;
        r49 = null;
        goto L143
    L136:
        EduClipImageRect.a r52 = r1.f;
        if (r52 == null) goto L139;
        r48 = r52.a(r17.getX(), r17.getY());
    L140:
        if (r48 == null) goto L142;
        r50 = r48;
        r49 = r1.f;
        goto L143
    L139:
        r48 = null;
    L150:
        r3 = false;
    L176:
        return super/*android.widget.ImageView*/.onTouchEvent(r17);
    }

    public final void setClipRectChangeListener(m.a r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
        this.e = r2;
    }

    public final void setCornerRadius(float r2) {
        this.f.b.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setEnableClipRect(boolean r2) {
        if (r2 == this.n) goto L5;
        boolean r0 = true;
    L6:
        this.n = r2;
        if (r0 == true) goto L9;
        return;
    L9:
        if (this.a == null) goto L13;
        invalidate();
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageBitmap(Bitmap r2) {
        this.a = r2;
        Function1<? super Bitmap, Unit> r0 = this.b;
        if (r0 == null) goto L5;
        r0.invoke(r2);
    L5:
        getViewTreeObserver().addOnPreDrawListener(new c(this));
    }

    public final void setImageBitmapAndReprepare$impl_mainlandRelease(Bitmap r3) {
        this.c.a = false;
        setImageBitmap(r3);
    }

    public final void setImageSetCallback(Function1<? super Bitmap, Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMultiMode(boolean r3) {
        EduClipImageRect r0 = this.f;
        if (r3 == r0.h) goto L6;
        r0.h = r3;
        invalidate();
        return;
    }

    public final void setOriginBitmap(Bitmap r1) {
        this.a = r1;
    }

    public final void setScreenOrientationDegrees(int r1) {
        this.l = r1;
    }

    public final void n(final Canvas r23, boolean r24) {
        EduClipImageView r0 = this;
        Bitmap r1 = r0.a;
        if (r1 == null) goto L8;
        if (r1.isRecycled() == true) goto L8;
        r23.drawBitmap(r1, r0.c.d, null);
    L8:
        if (r0.c.a == true) goto L10;
        return;
    L10:
        if (r0.n == false) goto L61;
        final EduClipImageRect r2 = r0.f;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r23, "canvas");
        r23.save();
        r2.a(new mx8.b(r23));
        r23.drawColor(r2.e);
        r23.restore();
        EduClipImageRect.b r3 = r2.b;
        if (r3.i > 0.0f) goto L14;
    L16:
        EduClipImageRect.a r4 = r2.f;
        if (r2.i == null) goto L25;
        if (r4 == null) goto L25;
        if (r24 == false) goto L25;
        r23.save();
        int r5 = r2.i.length;
        int r6 = 0;
    L21:
        if (r6 >= r5) goto L23;
        r23.drawBitmap(r2.i[r6], r4.l[r6], r2.c);
        r6 = r6 + 1;
        goto L21
    L23:
        r23.restore();
    L25:
        if (r0.f.h == true) goto L27;
        return;
    L27:
        if ((!r0.h.isEmpty()) == true) goto L29;
        return;
    L29:
        if (r0.g == false) goto L64;
        Iterator<T> r13 = r0.f.g.iterator();
        int r7 = 0;
    L32:
        if (r13.hasNext() == false) goto L65;
        Object r8 = r13.next();
        int r14 = r7 + 1;
        if (r7 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();
    L36:
        EduClipImageRect.a r9 = (EduClipImageRect.a) r8;
        mx8.e r15 = (mx8.e) CollectionsKt.getOrNull(r0.h, r7);
        if (r15 == null) goto L55;
        RectF r10 = r9.e;
        int r11 = r0.l;
        Intrinsics.checkNotNullParameter(r23, "canvas");
        Intrinsics.checkNotNullParameter(r10, "rect");
        float r12 = r10.centerX();
        float r16 = r10.centerY();
        if (r11 != (-90)) goto L41;
    L46:
        float r17 = Math.max(r12, (((r10.bottom - r16) + r12) - r15.c) - (r15.g / 2.0f));
    L47:
        float r18 = r17;
        boolean r19 = true;
    L48:
        float r20 = r15.b;
        r23.save();
        if (r19 == false) goto L51;
        r23.rotate(r11, r12, r16);
    L51:
        float r21 = r15.g / 2.0f;
        float r110 = r20 / 2.0f;
        r23.drawRoundRect(r18 - r21, r16 - r110, r18 + r21, r16 + r110, r110, r110, r15.e);
        Paint.FontMetrics r22 = r15.d.getFontMetrics();
        String r25 = r15.a;
        float r26 = r18 - (r15.f / 2.0f);
        float r27 = r22.descent;
        float r28 = r22.ascent;
        r23.drawText(r25, r26, (r16 - ((r27 - r28) / 2.0f)) - r28, r15.d);
        if (r19 == false) goto L54;
        r23.rotate(-r11, r12, r16);
    L54:
        r23.restore();
        goto L55
    L41:
        if (r11 != 90) goto L43;
        r17 = Math.max(r12, (((r16 - r10.top) + r12) - r15.c) - (r15.g / 2.0f));
        goto L47
    L43:
        if (r11 == 270) goto L46;
        r18 = Math.max(r12, (r10.right - r15.c) - (r15.g / 2.0f));
        r19 = false;
    L55:
        r0 = this;
        r7 = r14;
        goto L32
    L65:
        return;
    L64:
        return;
    L14:
        if (r3.j == 0) goto L16;
        r23.save();
        r2.a(new mx8.c(r23, r2));
        r23.restore();
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(boolean r7, boolean r8) {
        int r0 = this.k + this.j;
        float r2 = r0;
        float r1 = this.c.a(r2);
        getLogger().d("ClipImageView", "before rotate: scale=" + r1 + ", degrees=" + r0 + ", current=" + this.c.c);
        if (r7 == false) goto L9;
        if (r8 == false) goto L8;
        ValueAnimator r9 = this.i;
        if (r9 == null) goto L8;
        r9.cancel();
    L8:
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{this.c.b, r1});
        r10.setDuration(300);
        b r11 = new b(this, this.c.c, r2);
        r10.addUpdateListener(r11);
        r10.addListener(r11);
        r10.start();
        this.i = r10;
        return;
    L9:
        mx8.a r12 = this.c;
        r12.b = r1;
        r12.c = r2;
        r12.b();
        this.f.c(false);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(float r4, float r5) {
        EduClipImageRect r0 = this.f;
        r0.c.setAlpha((int) (r5 * 255));
        r0.e = Color.argb((int) (Color.alpha(r0.b.d) * r4), Color.red(r0.b.d), Color.green(r0.b.d), Color.blue(r0.b.d));
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EduClipImageView(Context r13, AttributeSet r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r14 = null;
    L5:
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14);
        mx8.a r16 = new mx8.a();
        this.c = r16;
        this.g = true;
        this.h = new ArrayList();
        this.n = true;
        this.f = new EduClipImageRect(r16, new EduClipImageRect.b(getDefaultCornerBitmap(), getResources().getDimension(2131167536), getResources().getDimensionPixelSize(2131167535), ResourcesCompat.getColor(getResources(), 2131102605, null), getResources().getDimension(2131167538), getResources().getDimension(2131167537), getResources().getDimension(2131167545), getResources().getDimension(2131167543), getResources().getDimension(2131167544), ResourcesCompat.getColor(getResources(), 2131103086, null)));
    }

    public final RectF l(int r6, int r7, boolean r8) {
        RectF r0 = new RectF(0.0f, 0.0f, r6, r7);
        mx8.a r9 = this.c;
        if (r9.a == true) goto L5;
        return r0;
    L5:
        float r2 = 2;
        r0.offset((r9.h / r2) - r0.centerX(), (r9.i / r2) - r0.centerY());
        RectF r10 = this.c.g;
        boolean r3 = true;
        if (r10.width() != 0.0f) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
    L31:
        return r0;
    L11:
        if (r10.height() == 0.0f) goto L14;
        r3 = false;
    L14:
        if (r3 == true) goto L31;
        if (r8 == false) goto L18;
        float r12 = r10.height();
        float r4 = r10.width();
    L19:
        float r13 = r12 / r4;
        if (r13 >= 0.75f) goto L22;
    L23:
        if (r8 == false) goto L27;
        r0.top = r10.top;
        r0.bottom = r10.bottom;
        float r14 = r0.width() - r10.width();
        if (r14 <= 0.0f) goto L30;
        float r15 = r14 / r2;
        r0.left += r15;
        r0.right -= r15;
    L30:
        getLogger().d("ClipImageView", "createDefaultClipRect: ratio=" + r13 + ", image=" + r10 + ", result=" + r0);
        goto L31
    L27:
        r0.left = r10.left;
        r0.right = r10.right;
        float r16 = r0.height() - r10.height();
        if (r16 <= 0.0f) goto L30;
        float r17 = r16 / r2;
        r0.top += r17;
        r0.bottom -= r17;
        goto L30
    L22:
        if (r13 <= 2.25f) goto L30;
    L18:
        r12 = r10.width();
        r4 = r10.height();
        goto L19
    L8:
        r11 = false;
        goto L9
    }
}
