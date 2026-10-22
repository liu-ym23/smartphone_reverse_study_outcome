package com.larus.camera.impl.edulibs.camera.internal.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mx8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\u0018\u00002\u00020\u0001:\u0001:B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0014J\u0016\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J\u001e\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0012J \u0010*\u001a\u00020\u00142\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0013J0\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020$H\u0014J\u0018\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020$H\u0002J\b\u00107\u001a\u00020\u0014H\u0002J\u0010\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0013H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipRectAnimateView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "animateDuration", "", "getAnimateDuration", "()J", "setAnimateDuration", "(J)V", "onUpdate", "Lkotlin/Function2;", "", "Lcom/larus/camera/impl/edulibs/camera/internal/view/EduClipRectAnimateView$RectData;", "", "initData", "dstData", "isInit", "", "drawPath", "Landroid/graphics/Path;", "tmpData", "tmpPath", "tmpMatrix", "Landroid/graphics/Matrix;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setConfig", "lineWidth", "", "lineColor", "setInitRectSize", "width", "height", "radius", "onAnimUpdate", "block", "startRectAnimation", "dst", "onLayout", "changed", "left", "top", "right", "bottom", "calculateInitRect", "viewWidth", "viewHeight", "checkAndStartAnimation", "calculatePath", "data", "RectData", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EduClipRectAnimateView extends View {
    public static final /* synthetic */ int k = 0;
    public final Paint a;
    public long b;
    public Function2<? super Float, ? super a, Unit> c;
    public final a d;
    public a e;
    public boolean f;
    public final Path g;
    public final a h;
    public final Path i;
    public final Matrix j;

    public static final class a {
        public final RectF a;
        public float b;
        public float c;

        public a(RectF r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "location");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ EduClipRectAnimateView a;
        public final /* synthetic */ a b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            Function2<? super Float, ? super a, Unit> r4 = this.a.c;
            if (r4 == null) goto L6;
            r4.invoke(Float.valueOf(1.0f), this.b);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            Function2<? super Float, ? super a, Unit> r4 = this.a.c;
            if (r4 == null) goto L6;
            r4.invoke(Float.valueOf(1.0f), this.b);
            return;
        }

        public b(EduClipRectAnimateView r1, a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void b() {
        final a r0 = this.e;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f == false) goto L9;
        final RectF r1 = this.d.a;
        final RectF r2 = r0.a;
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r3.setDuration(this.b);
        r3.addUpdateListener(new d(this, r1, r2, r0));
        r3.addListener(new b(this, r0));
        r3.start();
        return;
    }

    public final long getAnimateDuration() {
        return this.b;
    }

    public EduClipRectAnimateView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(a r9) {
        this.h.a.set(r9.a);
        a r0 = this.h;
        r0.b = r9.b;
        r0.c = r9.c;
        Path r1 = this.g;
        RectF r2 = r9.a;
        float r3 = r9.c + r9.b;
        float r4 = r2.left;
        float r5 = r2.top;
        RectF r6 = new RectF(r4, r5, r4 + r3, r5 + r3);
        r1.reset();
        this.i.reset();
        this.i.moveTo(r6.left, r6.bottom);
        this.i.lineTo(r6.left, r6.bottom - r9.c);
        this.i.addArc(r6, 270.0f, -90.0f);
        this.i.moveTo(r2.left + r9.b, r2.top);
        this.i.lineTo(r2.left + r3, r2.top);
        int r10 = 0;
    L4:
        if (r10 >= 4) goto L16;
        this.j.reset();
        this.j.postRotate(r10 * 90.0f, r6.centerX(), r6.centerY());
        float r7 = 0.0f;
        if (r10 == 1) goto L9;
        if (r10 == 2) goto L9;
        float r8 = 0.0f;
    L10:
        if (r10 != 2) goto L12;
    L14:
        r7 = r2.height() - r3;
    L15:
        this.j.postTranslate(r8, r7);
        r1.addPath(this.i, this.j);
        r10 = r10 + 1;
        goto L4
    L12:
        if (r10 == 3) goto L14;
    L9:
        r8 = r2.width() - r3;
        goto L10
    L16:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        r3.drawPath(this.g, this.a);
    }

    public final void setAnimateDuration(long r1) {
        this.b = r1;
    }

    public EduClipRectAnimateView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        Paint r4 = new Paint();
        r4.setStyle(Paint.Style.STROKE);
        this.a = r4;
        this.b = 300;
        this.d = new a(new RectF(), 0.0f, 0.0f);
        this.g = new Path();
        this.h = new a(new RectF(), 0.0f, 0.0f);
        this.i = new Path();
        this.j = new Matrix();
    }

    @Override // android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.f == true) goto L9;
        int r6 = getWidth();
        int r7 = getHeight();
        if (r6 <= 0) goto L10;
        if (r7 <= 0) goto L11;
        this.f = true;
        a r8 = this.d;
        RectF r9 = r8.a;
        r9.offset((r6 - r9.width()) / 2.0f, (r7 - r8.a.height()) / 2.0f);
        a(this.d);
        b();
        return;
    L11:
        return;
    L10:
        return;
    }
}
