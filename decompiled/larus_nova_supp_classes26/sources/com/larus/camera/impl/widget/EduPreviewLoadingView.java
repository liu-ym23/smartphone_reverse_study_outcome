package com.larus.camera.impl.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u000e*\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u000eH\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/camera/impl/widget/EduPreviewLoadingView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadingAnimator", "Landroid/animation/Animator;", "isLoading", "", "startDelayed", "setLoadingState", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAnimation", "ensureViewMeasured", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduPreviewLoadingView extends AppCompatImageView {
    public static final /* synthetic */ int d = 0;
    public Animator a;
    public boolean b;
    public boolean c;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ kotlinx.coroutines.i<Unit> b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            kotlinx.coroutines.i<Unit> r0 = this.b;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            return false;
        }

        public b(View r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.ImageView*/.onDetachedFromWindow();
        Animator r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.a = null;
    }

    public EduPreviewLoadingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EduPreviewLoadingView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final Object j(View r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof EduPreviewLoadingView$ensureViewMeasured$1) == false) goto L7;
        EduPreviewLoadingView$ensureViewMeasured$1 r0 = (EduPreviewLoadingView$ensureViewMeasured$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r9);
    L32:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        View r10 = (View) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L28:
        this.c = true;
        r0.L$0 = null;
        r0.label = 2;
        if (DelayKt.delay(50, r0) != r2) goto L32;
        return r2;
    L16:
        ResultKt.throwOnFailure(r9);
        if (r7.getWidth() != 0) goto L19;
    L23:
        r0.L$0 = r7;
        r0.label = 1;
        kotlinx.coroutines.j r11 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
        r11.C();
        r7.getViewTreeObserver().addOnPreDrawListener(new b(r7, r11));
        Object r12 = r11.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);
    L26:
        if (r12 != r2) goto L28;
        return r2;
    L19:
        if (r7.getHeight() == 0) goto L23;
        return Unit.INSTANCE;
    L7:
        r0 = new EduPreviewLoadingView$ensureViewMeasured$1(this, r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.View, android.widget.ImageView, androidx.appcompat.widget.AppCompatImageView, com.larus.camera.impl.widget.EduPreviewLoadingView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [android.widget.ImageView] */
    public final Object l(boolean r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof EduPreviewLoadingView$setLoadingState$1) == false) goto L7;
        EduPreviewLoadingView$setLoadingState$1 r0 = (EduPreviewLoadingView$setLoadingState$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        ValueAnimator r4 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L46:
        Animator r16 = this.a;
        if (r16 == null) goto L49;
        r16.cancel();
    L49:
        this.a = null;
    L51:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        EduPreviewLoadingView r17 = (EduPreviewLoadingView) r0.L$0;
        ResultKt.throwOnFailure(r15);
        ?? r18 = r17;
    L25:
        if (this.b == false) goto L39;
        Bitmap r19 = BitmapFactory.decodeResource(getResources(), 2131242876);
        if (r19 == null) goto L34;
        int r5 = getWidth();
        if (r19.getWidth() <= 0) goto L32;
        final float r8 = r5 / r19.getWidth();
    L33:
        final Matrix r7 = new Matrix();
        final float r9 = (-r19.getHeight()) * r8;
        final int r10 = getHeight() - r19.getHeight();
        r7.postScale(r8, r8);
        r7.postTranslate(0.0f, r9);
        setImageBitmap(r19);
        setImageMatrix(r7);
        ValueAnimator r110 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r110.setInterpolator(new PathInterpolator(0.25f, 0.0f, 0.25f, 1.0f));
        r110.setDuration(800);
        r110.setRepeatCount(-1);
        r110.setRepeatMode(1);
        r110.addUpdateListener(new l(r7, r8, r9, r10, this));
        Intrinsics.checkNotNull(r110);
        r110.addListener(new m(this, this, this));
        r4 = r110;
        goto L34
    L32:
        r8 = 1.0f;
    L34:
        this.a = r4;
        if (r4 == null) goto L38;
        if (r4 == null) goto L51;
        r4.start();
        goto L51
    L38:
        r18.setVisibility(4);
        goto L51
    L39:
        r18.setVisibility(4);
        goto L51
    L16:
        ResultKt.throwOnFailure(r15);
        this.b = r13;
        if (r13 == true) goto L19;
    L40:
        if (r13 == true) goto L51;
        if (this.c == false) goto L46;
        r0.label = 2;
        if (DelayKt.delay(50, r0) != r2) goto L46;
        return r2;
    L19:
        if (this.a != null) goto L40;
        setVisibility(0);
        r0.L$0 = this;
        r0.label = 1;
        if (j(this, r0) != r2) goto L23;
        return r2;
    L23:
        r18 = this;
    L7:
        r0 = new EduPreviewLoadingView$setLoadingState$1(this, r14);
        goto L8
    }
}
