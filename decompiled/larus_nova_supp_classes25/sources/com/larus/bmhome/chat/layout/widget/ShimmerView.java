package com.larus.bmhome.chat.layout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u001fJ\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020\u001fH\u0014J\u0006\u0010)\u001a\u00020\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ShimmerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radius", "", "linearGradient", "Landroid/graphics/LinearGradient;", "animator", "Landroid/animation/ValueAnimator;", "translateX", "shaderMatrix", "Landroid/graphics/Matrix;", "startColor", "middleColorAlpha", "endColor", "rectF", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "setUpSwipColor", "", "middleColor", "runnable", "Ljava/lang/Runnable;", "setRadius", "startShimmerAnimation", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "cancelAnimation", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ShimmerView extends View {
    public static final /* synthetic */ int l = 0;
    public float a;
    public LinearGradient b;
    public ValueAnimator c;
    public float d;
    public final Matrix e;
    public final int f;
    public final int g;
    public final int h;
    public final RectF i;
    public final Lazy j;
    public final j1 k;

    public static final class a {
    }

    static {
    }

    public ShimmerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShimmerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final Paint getPaint() {
        return (Paint) this.j.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.c;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.c = null;
        com.larus.utils.t0.a.removeCallbacks(this.k);
    }

    public static void a(final ShimmerView r14) {
        if (r14.getWidth() == 0) goto L7;
        FLogger.a.d("ShimmerView", "onDraw animation ing========start===animation===width:" + r14.getWidth());
        r14.b = new LinearGradient(0.0f, 0.0f, (float) r14.getWidth(), 0.0f, new int[]{r14.f, r14.g, r14.h}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        r14.getPaint().setShader(r14.b);
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{-r14.getWidth(), r14.getWidth()});
        r0.setDuration(800);
        r0.setRepeatCount(-1);
        r0.setInterpolator(new LinearInterpolator());
        r0.addUpdateListener(new k1(r14));
        r0.start();
        r14.c = r0;
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        if (getPaint().getShader() != null) goto L5;
        return;
    L5:
        RectF r0 = this.i;
        r0.left = 0.0f;
        r0.top = 0.0f;
        r0.right = getWidth();
        r0.bottom = getHeight();
        RectF r1 = this.i;
        float r2 = this.a;
        r4.drawRoundRect(r1, r2, r2, getPaint());
    }

    public final void setRadius(float r1) {
        this.a = r1;
    }

    public static void b(ShimmerView r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Float");
        r3.d = ((Float) r5).floatValue();
        FLogger r6 = FLogger.a;
        StringBuilder r0 = new StringBuilder("onDraw animation ing==========");
        r0.append(r3.d);
        r0.append("===");
        r0.append(-r3.getWidth());
        r0.append("===");
        r0.append(r3.getWidth());
        r6.d("ShimmerView", r0.toString());
        r3.e.setTranslate(r3.d, 0.0f);
        Shader r7 = r3.getPaint().getShader();
        if (r7 == null) goto L5;
        r7.setLocalMatrix(r3.e);
    L5:
        r3.invalidate();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.larus.bmhome.chat.layout.widget.j1] */
    public ShimmerView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.e = new Matrix();
        this.f = ftc.a.a(ContextCompat.getColor(r3, v19.c.b(2130970529, r3, 2131102529)), 68);
        this.g = ftc.a.a(ContextCompat.getColor(r3, v19.c.b(2130970529, r3, 2131102529)), 255);
        this.h = ftc.a.a(ContextCompat.getColor(r3, v19.c.b(2130970529, r3, 2131102529)), 71);
        this.i = new RectF();
        this.j = LazyKt.lazy(new i1());
        this.k = new j1(this);
    }

    public /* synthetic */ ShimmerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
