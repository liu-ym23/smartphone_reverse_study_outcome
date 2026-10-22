package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.swipe;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0016J \u00103\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u000202H\u0016J\u0006\u00104\u001a\u00020-J\u0006\u00105\u001a\u00020-J\u0006\u00106\u001a\u00020-J\u000e\u00107\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020-2\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020-H\u0002J\b\u0010=\u001a\u00020-H\u0002J\b\u0010>\u001a\u00020-H\u0002J\b\u0010?\u001a\u00020-H\u0002J\f\u0010@\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010@\u001a\u00020\u0005*\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/swipe/SwipeActionItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "triggerDistancePx", BuildConfig.FLAVOR, "<init>", "(Landroidx/recyclerview/widget/RecyclerView;F)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "capturedItemInfo", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/swipe/SwipeActionHandler$CapturedItemInfo;", "animatingCapturedInfo", "iconAppearDistancePx", "cxMax", "bgRadius", "iconRadius", "ringStrokeWidth", "ringRadiusMax", "triggerBgAnimator", "Landroid/animation/ValueAnimator;", "triggerIconAnimator", "Landroid/animation/AnimatorSet;", "triggerIconScaleUpAnimator", "triggerIconScaleDownAnimator", "triggerRingAnimator", "triggerEffectExecuted", BuildConfig.FLAVOR, "paint", "Landroid/graphics/Paint;", "ringPaint", "ringStrokeColor", BuildConfig.FLAVOR, "saveCanvasRectF", "Landroid/graphics/RectF;", "itemBackgroundRectF", "ringPathCircle", "Landroid/graphics/Path;", "ringPathMeasure", "Landroid/graphics/PathMeasure;", "ringPath", "circleRadiusScaleFactorMax", "ringRippleAlphaMax", "onDraw", BuildConfig.FLAVOR, "canvas", "Landroid/graphics/Canvas;", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDrawOver", "invalidate", "release", "performTriggerEffect", "startDragging", "animateItemBack", "itemView", "Landroid/view/View;", "performVibration", "performTriggerAnimation", "performTriggerRippleAnimation", "performTriggerIconAnimation", "performTriggerBgAnimation", "dp", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeActionItemDecoration extends RecyclerView.ItemDecoration {
    public final RecyclerView a;
    public final float b;
    public final Context c;
    public SwipeActionHandler.CapturedItemInfo d;
    public SwipeActionHandler.CapturedItemInfo e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public ValueAnimator k;
    public AnimatorSet l;
    public ValueAnimator m;
    public ValueAnimator n;
    public ValueAnimator o;
    public boolean p;
    public final Paint q;
    public final Paint r;
    public final int s;
    public RectF t;
    public RectF u;
    public final Path v;
    public final PathMeasure w;
    public final Path x;
    public final float y;
    public final int z;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ SwipeActionItemDecoration a;

        public b(SwipeActionItemDecoration r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            this.a.i();
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ SwipeActionItemDecoration a;
        public final /* synthetic */ View b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.i();
            this.a.e = null;
            this.b.setTranslationX(0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.i();
            this.a.e = null;
            this.b.setTranslationX(0.0f);
        }

        public c(SwipeActionItemDecoration r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void i() {
        if (this.a.isComputingLayout() == true) goto L9;
        this.a.invalidateItemDecorations();     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void h(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        this.e = this.d;
        r4.animate().translationX(0.0f).setDuration(200).setUpdateListener(new b(this)).setInterpolator(new DecelerateInterpolator()).setListener(new c(this, r4)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeActionItemDecoration(SceneCoordinateRecyclerView r5, float r6) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        this.a = r5;
        this.b = r6;
        Context r7 = r5.getContext();
        this.c = r7;
        this.f = UIUtils.dp2px(r7, 30);
        this.g = UIUtils.dp2px(r7, 46.0f);
        this.h = UIUtils.dp2px(r7, 16.0f);
        this.i = UIUtils.dp2px(r7, 8.0f);
        float r8 = UIUtils.dp2px(r7, 1.0f);
        this.j = UIUtils.dp2px(r7, 40.0f);
        Paint r0 = new Paint();
        r0.setFlags(1);
        r0.setColor(UDColorUtils.getColor(r7, 2131099925));
        this.q = r0;
        Paint r1 = new Paint();
        r1.setFlags(1);
        r1.setStyle(Paint.Style.STROKE);
        r1.setStrokeWidth(r8);
        r1.setStrokeCap(Paint.Cap.ROUND);
        this.r = r1;
        this.s = UDColorUtils.getColor(r7, 2131099925);
        this.v = new Path();
        this.w = new PathMeasure();
        this.x = new Path();
        this.y = 1.2f;
        this.z = 102;
    }

    public final void onDraw(Canvas r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        super.onDraw(r5, r6, r7);
        SwipeActionHandler.CapturedItemInfo r8 = this.d;
        if (r8 != null) goto L7;
        r8 = this.e;
        if (r8 != null) goto L7;
        return;
    L7:
        RecyclerView.ViewHolder r9 = r8.b;
        Iterator r10 = ViewGroupKt.getChildren(r6).iterator();
    L8:
        ColorDrawable r1 = null;
        if (r10.hasNext() == false) goto L13;
        Object r0 = r10.next();
        if (Intrinsics.areEqual((View) r0, r9.itemView) == false) goto L8;
    L14:
        View r2 = (View) r0;
        if (r2 != null) goto L17;
        return;
    L17:
        Drawable r11 = r9.itemView.getBackground();
        if ((r11 instanceof ColorDrawable) == false) goto L20;
        r1 = (ColorDrawable) r11;
    L20:
        if (r1 == null) goto L29;
        int r12 = this.q.getColor();
        this.q.setColor(r1.getColor());
        RectF r13 = this.u;
        if (r13 != null) goto L24;
        r13 = new RectF();
        this.u = r13;
    L24:
        r13.set(0.0f, r2.getY(), r2.getWidth(), r2.getY() + r2.getHeight());
        r5.drawRect(r13, this.q);
        this.q.setColor(r12);
        return;
    L29:
        return;
    L13:
        r0 = null;
        goto L14
    }

    public final void onDrawOver(Canvas r17, RecyclerView r18, RecyclerView.State r19) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        Intrinsics.checkNotNullParameter(r18, "parent");
        Intrinsics.checkNotNullParameter(r19, "state");
        super.onDrawOver(r17, r18, r19);
        SwipeActionHandler.CapturedItemInfo r2 = this.d;
        if (r2 != null) goto L7;
        r2 = this.e;
        if (r2 != null) goto L7;
        return;
    L7:
        RecyclerView.ViewHolder r4 = r2.b;
        Drawable r5 = (Drawable) r2.h.getValue();
        Iterator r3 = ViewGroupKt.getChildren(r18).iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        Object r6 = r3.next();
        if (Intrinsics.areEqual((View) r6, r4.itemView) == false) goto L9;
    L14:
        View r7 = (View) r6;
        if (r7 != null) goto L17;
        return;
    L17:
        float r8 = Math.min(this.b, Math.max(0.0f, r7.getTranslationX()));
        float r9 = this.f;
        if (r8 >= r9) goto L20;
        float r10 = 0.0f;
    L24:
        float r11 = this.h;
        float r12 = r11 + ((this.g - r11) * r10);
        float r13 = r7.getY() + r2.a();
        ValueAnimator r14 = this.m;
        boolean r15 = false;
        if (r14 != null) goto L27;
    L29:
        boolean r16 = false;
    L30:
        if (r16 == false) goto L41;
        ValueAnimator r20 = this.m;
        if (r20 == null) goto L34;
        Object r21 = r20.getAnimatedValue();
    L36:
        if ((r21 instanceof Float) == false) goto L38;
        Float r22 = (Float) r21;
    L39:
        if (r22 == null) goto L59;
        float r23 = r22.floatValue();
    L60:
        ValueAnimator r110 = this.k;
        if (r110 == null) goto L63;
        Object r111 = r110.getAnimatedValue();
    L65:
        if ((r111 instanceof Float) == false) goto L67;
        Float r112 = (Float) r111;
    L68:
        if (r112 == null) goto L70;
        float r113 = r112.floatValue();
    L72:
        if (r10 != 1.0f) goto L74;
        boolean r114 = true;
    L75:
        if (r114 == true) goto L79;
        if (this.p == true) goto L79;
    L85:
        float r24 = this.i;
        float r25 = r24 + ((r23 * (this.y - 1)) * r24);
        RectF r26 = this.t;
        if (r26 != null) goto L88;
        r26 = new RectF();
        this.t = r26;
    L88:
        float r115 = this.h;
        r26.set(0.0f, r13 - r115, this.g + r115, r115 + r13);
        float r116 = -r25;
        r26.inset(r116, r116);
        int r27 = r17.saveLayerAlpha(r26, MathKt.roundToInt(ScreenUtils.MAX_SYSTEM_BRIGHTNESS * r10));
        r5.setBounds(MathKt.roundToInt(r12 - r25), MathKt.roundToInt(r13 - r25), MathKt.roundToInt(r12 + r25), MathKt.roundToInt(r25 + r13));
        r5.draw(r17);
        r17.restoreToCount(r27);
        this.x.reset();
        ValueAnimator r28 = this.o;
        if (r28 == null) goto L91;
        Object r29 = r28.getAnimatedValue();
    L93:
        if ((r29 instanceof Float) == false) goto L95;
        Float r30 = (Float) r29;
    L96:
        if (r30 == null) goto L98;
        float r31 = r30.floatValue();
    L100:
        if (this.p == true) goto L108;
        if (r10 >= 1.0f) goto L108;
        this.v.reset();
        this.v.addCircle(r12, r13, this.h, Path.Direction.CW);
        this.w.setPath(this.v, false);
        float r32 = this.w.getLength();
        if (r10 > 0.25f) goto L105;
        PathMeasure r33 = this.w;
        r33.getSegment(r32 * 0.75f, r33.getLength() * (r10 + 0.75f), this.x, true);
    L106:
        this.r.setColor(this.s);
        r17.drawPath(this.x, this.r);
        return;
    L105:
        PathMeasure r34 = this.w;
        r34.getSegment(r32 * 0.75f, r34.getLength(), this.x, true);
        PathMeasure r35 = this.w;
        r35.getSegment(0.0f, r35.getLength() * (r10 - 0.25f), this.x, false);
    L108:
        if (r31 != 0.0f) goto L110;
        boolean r36 = true;
    L111:
        if (r36 == false) goto L113;
        return;
    L113:
        if (r31 != 1.0f) goto L115;
        r15 = true;
    L115:
        if (r15 == true) goto L123;
        this.x.addCircle(r12, r13, this.j * r31, Path.Direction.CW);
        this.r.setColor(this.s);
        this.r.setAlpha((int) ((1.0f - r31) * this.z));
        r17.drawPath(this.x, this.r);
        return;
    L123:
        return;
    L110:
        r36 = false;
        goto L111
    L98:
        r31 = 0.0f;
        goto L100
    L95:
        r30 = null;
        goto L96
    L91:
        r29 = null;
    L79:
        if (r113 <= 0.0f) goto L85;
        if (this.p == false) goto L84;
        if (r10 >= 1.0f) goto L84;
        r113 = r10;
    L84:
        int r117 = this.q.getAlpha();
        this.q.setAlpha(MathKt.roundToInt(r117 * r113));
        float r37 = this.h;
        r17.drawCircle(r12, r13, r37 + (((this.y - 1) * r23) * r37), this.q);
        this.q.setAlpha(r117);
        goto L85
    L74:
        r114 = false;
        goto L75
    L70:
        r113 = 0.0f;
        goto L72
    L67:
        r112 = null;
        goto L68
    L63:
        r111 = null;
    L59:
        r23 = 0.0f;
        goto L60
    L38:
        r22 = null;
        goto L39
    L34:
        r21 = null;
        goto L36
    L41:
        ValueAnimator r38 = this.n;
        if (r38 != null) goto L44;
    L46:
        boolean r39 = false;
    L47:
        if (r39 == false) goto L59;
        ValueAnimator r40 = this.n;
        if (r40 == null) goto L51;
        Object r41 = r40.getAnimatedValue();
    L53:
        if ((r41 instanceof Float) == false) goto L55;
        Float r42 = (Float) r41;
    L56:
        if (r42 == null) goto L59;
        r23 = 1 - r42.floatValue();
        goto L60
    L55:
        r42 = null;
        goto L56
    L51:
        r41 = null;
        goto L53
    L44:
        if (r38.isRunning() != true) goto L46;
        r39 = true;
        goto L47
    L27:
        if (r14.isRunning() != true) goto L29;
        r16 = true;
        goto L30
    L20:
        float r118 = this.b;
        if (r8 >= r118) goto L23;
        r10 = (r8 - r9) / (r118 - r9);
        goto L24
    L23:
        r10 = 1.0f;
        goto L24
    L13:
        r6 = null;
        goto L14
    }
}
