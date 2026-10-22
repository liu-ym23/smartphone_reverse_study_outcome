package io.noties.markwon.scrollable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u00010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0006H\u0096\u0001J)\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J9\u0010 \u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u000e\u0010!\u001a\n \u001d*\u0004\u0018\u00010\"0\"H\u0096\u0001JA\u0010#\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010!\u001a\u00020\u00152\u000e\u0010$\u001a\n \u001d*\u0004\u0018\u00010%0%H\u0096\u0001J9\u0010&\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u000e\u0010!\u001a\n \u001d*\u0004\u0018\u00010%0%H\u0096\u0001JA\u0010'\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010!\u001a\u00020\u00152\u000e\u0010$\u001a\n \u001d*\u0004\u0018\u00010%0%H\u0096\u0001J1\u0010(\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u0006\u0010!\u001a\u00020\u0015H\u0096\u0001J \u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\"H\u0016J \u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\"H\u0002J9\u0010/\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001f0\u001f2\u000e\u0010!\u001a\n \u001d*\u0004\u0018\u00010\"0\"H\u0096\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod2;", "Landroid/text/method/MovementMethod;", "context", "Landroid/content/Context;", "delegate", "allowParentInterceptTouchWhenOverScroll", "", "(Landroid/content/Context;Landroid/text/method/MovementMethod;Z)V", "firstCanScrollLeft", "firstCanScrollRight", "firstX", "", "firstY", "flag", "flinger", "Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod2$ViewFlinger;", "lastX", "maxVelocity", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "touchSlop", "", "tracker", "Landroid/view/VelocityTracker;", "canSelectArbitrarily", "initialize", "", "p0", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "p1", "Landroid/text/Spannable;", "onGenericMotionEvent", "p2", "Landroid/view/MotionEvent;", "onKeyDown", "p3", "Landroid/view/KeyEvent;", "onKeyOther", "onKeyUp", "onTakeFocus", "onTouchEvent", "widget", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "event", "onTouchEventInner", "buffer", "onTrackballEvent", "ViewFlinger", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class d implements MovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f16673b;
    private VelocityTracker c;
    private final a d;
    private final float e;
    private final int f;
    private boolean g;
    private float h;
    private float i;
    private boolean j;
    private boolean k;
    private final MovementMethod l;
    private final boolean m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod2$ViewFlinger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animator", "Landroid/animation/ValueAnimator;", "scroller", "Landroid/widget/OverScroller;", "fling", "", "widget", "Landroid/view/View;", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "velocityX", "", "stop", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ValueAnimator f16674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OverScroller f16675b;

        /* JADX INFO: renamed from: io.noties.markwon.scrollable.d$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "io/noties/markwon/scrollable/HorizontalScrollableMovementMethod2$ViewFlinger$fling$1$1"}, k = 3, mv = {1, 1, 15})
        static final class C0870a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f16676a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ io.noties.markwon.scrollable.b f16677b;
            final /* synthetic */ View c;

            C0870a(a r1, io.noties.markwon.scrollable.b r2, View r3) {
                this.f16676a = r1;
                this.f16677b = r2;
                this.c = r3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r2) {
                if (a.a(this.f16676a).computeScrollOffset() == false) goto L5;
                this.f16677b.a(a.a(this.f16676a).getCurrX());
                ViewCompat.postInvalidateOnAnimation(this.c);
                return;
            L5:
                Intrinsics.checkExpressionValueIsNotNull(r2, "it");
                if (r2.getAnimatedFraction() >= 1.0f) goto L10;
                r2.end();
                return;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "t", "getInterpolation"}, k = 3, mv = {1, 1, 15})
        static final class b implements Interpolator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f16678a = null;

            static {
                f16678a = new b();
            }

            b() {
            }

            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float r2) {
                float r3 = r2 - 1.0f;
                return ((((r3 * r3) * r3) * r3) * r3) + 1.0f;
            }
        }

        public a(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "context");
            this.f16675b = new OverScroller(r6, (Interpolator) ZeusTransformUtils.preCheckCast(b.f16678a, Interpolator.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ OverScroller a(a r0) {
            return r0.f16675b;
        }

        public final void a() {
            ValueAnimator r0 = this.f16674a;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            this.f16674a = (ValueAnimator) ZeusTransformUtils.preCheckCast(null, ValueAnimator.class, "com.obric.memorydata.plugin");
            this.f16675b.abortAnimation();
        }

        public final void a(View r13, io.noties.markwon.scrollable.b r14, int r15) {
            Intrinsics.checkParameterIsNotNull(r13, "widget");
            Intrinsics.checkParameterIsNotNull(r14, "scrollable");
            this.f16675b.fling((int) r14.b(), 0, r15, 0, -((int) r14.c()), 0, 0, 0, (int) r14.a(), 0);
            ValueAnimator r16 = this.f16674a;
            if (r16 == null) goto L5;
            r16.cancel();
        L5:
            ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            Intrinsics.checkExpressionValueIsNotNull(r17, "anim");
            r17.setDuration(Long.MAX_VALUE);
            r17.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(new C0870a(this, r14, r13), ValueAnimator.AnimatorUpdateListener.class, "com.obric.memorydata.plugin"));
            r17.start();
            this.f16674a = r17;
        }
    }

    public d(Context r3, MovementMethod r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        MovementMethod r7 = (MovementMethod) ZeusTransformUtils.wrapperContextForParams(r4, MovementMethod.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r6, "context");
        Intrinsics.checkParameterIsNotNull(r7, "delegate");
        this.l = r7;
        this.m = r5;
        a r8 = null;
        if (io.noties.markwon.g.b.f16544a.a() == false) goto L9;
    L6:
        this.d = r8;
        ViewConfiguration r9 = ViewConfiguration.get(r6);
        Intrinsics.checkExpressionValueIsNotNull(r9, "ViewConfiguration.get(context)");
        this.e = r9.getScaledMaximumFlingVelocity();
        ViewConfiguration r10 = ViewConfiguration.get(r6);
        Intrinsics.checkExpressionValueIsNotNull(r10, "ViewConfiguration.get(context)");
        this.f = r10.getScaledTouchSlop();
        return;
    L9:
        r8 = new a(r6);     // Catch: Exception -> L8
        goto L6
    }

    private final boolean a(TextView r9, Spannable r10, MotionEvent r11) {
        Spannable r12 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r10, Spannable.class, "com.obric.memorydata.plugin");
        int r13 = r11.getActionMasked();
        if (r13 != 0) goto L40;
        this.g = true;
        this.h = r11.getX();
        this.i = r11.getY();
        a r4 = this.d;
        if (r4 == null) goto L7;
        r4.a();
    L7:
        b[] r5 = (b[]) ZeusTransformUtils.preCheckCast(c.f16666a.a(r11, r9, b.class), b[].class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        b r6 = (b) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r5), b.class, "com.obric.memorydata.plugin");
    L11:
        this.f16673b = r6;
        if (r6 != null) goto L14;
    L77:
        if (r13 != 1) goto L79;
    L80:
        b r14 = this.f16673b;
        if (r14 == null) goto L93;
        VelocityTracker r7 = this.c;
        if (r7 == null) goto L105;
        r7.computeCurrentVelocity(1000, this.e);
    L105:
        VelocityTracker r8 = this.c;     // Catch: Exception -> L104
        if (r8 == null) goto L89;
        int r15 = MathKt.roundToInt(r8.getXVelocity());     // Catch: Exception -> L104
    L90:
        a r16 = this.d;
        if (r16 == null) goto L93;
        r16.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), r14, r15);
    L89:
        r15 = 0;
    L93:
        this.f16673b = (b) ZeusTransformUtils.preCheckCast(null, b.class, "com.obric.memorydata.plugin");
        VelocityTracker r17 = this.c;
        if (r17 == null) goto L96;
        r17.recycle();
    L96:
        this.c = (VelocityTracker) ZeusTransformUtils.preCheckCast(null, VelocityTracker.class, "com.obric.memorydata.plugin");
    L97:
        this.f16672a = r11.getX();
        b r18 = this.f16673b;
        if (r18 == null) goto L103;
        if (r18.d() != true) goto L103;
        return true;
    L103:
        return false;
    L79:
        if (r13 != 3) goto L97;
    L14:
        if (r6.d() == false) goto L19;
        ViewParent r19 = r9.getParent();
        if (r19 == null) goto L19;
        r19.requestDisallowInterceptTouchEvent(true);
    L19:
        if (Math.abs(r6.b()) >= r6.c()) goto L21;
    L24:
        boolean r20 = true;
    L25:
        this.j = r20;
        if (r6.b() >= 0) goto L28;
    L31:
        boolean r21 = true;
    L32:
        this.k = r21;
        VelocityTracker r22 = this.c;
        if (r22 == null) goto L36;
        if (r22 == null) goto L37;
        r22.clear();
    L37:
        VelocityTracker r23 = this.c;
        if (r23 == null) goto L77;
    L76:
        r23.addMovement(r11);
        goto L77
    L36:
        this.c = VelocityTracker.obtain();
        goto L37
    L28:
        if (r6.e() != 0.0f) goto L31;
        r21 = false;
        goto L32
    L21:
        if (r6.e() != 0.0f) goto L24;
        r20 = false;
        goto L25
    L10:
        r6 = null;
        goto L11
    L40:
        b r24 = this.f16673b;
        if (r24 == null) goto L77;
        if (r24.d() == false) goto L77;
        float r25 = Math.abs(r11.getX() - this.h);
        if (this.g == true) goto L47;
    L49:
        float r26 = Math.abs(r11.getY() - this.i);
        if (r26 <= r25) goto L57;
        if (r26 <= this.f) goto L57;
        ViewParent r27 = r9.getParent();
        if (r27 == null) goto L57;
        r27.requestDisallowInterceptTouchEvent(false);
    L57:
        if (r25 > r26) goto L59;
    L74:
        r23 = this.c;
        if (r23 == null) goto L77;
    L59:
        if (r25 <= this.f) goto L74;
        if (this.m == true) goto L63;
    L73:
        r24.a(r24.b() + (r11.getX() - this.f16672a));
        ViewCompat.postInvalidateOnAnimation((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"));
        goto L74
    L63:
        if (r11.getX() <= this.h) goto L67;
        if (this.k == true) goto L67;
    L70:
        ViewParent r28 = r9.getParent();
        if (r28 == null) goto L73;
        r28.requestDisallowInterceptTouchEvent(false);
    L67:
        if (r11.getX() >= this.h) goto L73;
        if (this.j == true) goto L73;
    L47:
        if (r25 <= this.f) goto L49;
        r9.cancelLongPress();
        this.g = false;
        goto L49
    }

    @Override // android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return this.l.canSelectArbitrarily();
    }

    @Override // android.text.method.MovementMethod
    public void initialize(TextView r3, Spannable r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        this.l.initialize(r3, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onGenericMotionEvent(TextView r3, Spannable r4, MotionEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.l.onGenericMotionEvent(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyDown(TextView r3, Spannable r4, int r5, KeyEvent r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.l.onKeyDown(r3, r7, r5, r6);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyOther(TextView r3, Spannable r4, KeyEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.l.onKeyOther(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyUp(TextView r3, Spannable r4, int r5, KeyEvent r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.l.onKeyUp(r3, r7, r5, r6);
    }

    @Override // android.text.method.MovementMethod
    public void onTakeFocus(TextView r3, Spannable r4, int r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        this.l.onTakeFocus(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r4, Spannable r5, MotionEvent r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r5, Spannable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r4, "widget");
        Intrinsics.checkParameterIsNotNull(r7, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkParameterIsNotNull(r6, "event");
        a(r4, r7, r6);     // Catch: Exception -> L5
    L8:
        return this.l.onTouchEvent(r4, r7, r6);
    L5:
        e = move-exception;
        Log.d("onTouchEventInner", "onTouchEventInner exception: " + e);
        goto L8
    }

    @Override // android.text.method.MovementMethod
    public boolean onTrackballEvent(TextView r3, Spannable r4, MotionEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.l.onTrackballEvent(r3, r6, r5);
    }
}
