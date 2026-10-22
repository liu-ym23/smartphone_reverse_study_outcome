package io.noties.markwon.scrollable;

import android.animation.ValueAnimator;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J)\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J9\u0010\u0018\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001JA\u0010\u001b\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u0006\u0010\u0019\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J9\u0010\u001f\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001JA\u0010 \u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u0006\u0010\u0019\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n \u0015*\u0004\u0018\u00010\u001e0\u001eH\u0096\u0001J1\u0010!\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u0006\u0010\u0019\u001a\u00020\u001cH\u0096\u0001J \u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001aH\u0016J \u0010&\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001aH\u0002J9\u0010(\u001a\u00020\u00102\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod;", "Landroid/text/method/MovementMethod;", "context", "Landroid/content/Context;", "delegate", "(Landroid/content/Context;Landroid/text/method/MovementMethod;)V", "flinger", "Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod$ViewFlinger;", "lastX", "", "maxVelocity", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "tracker", "Landroid/view/VelocityTracker;", "canSelectArbitrarily", "", "initialize", "", "p0", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "p1", "Landroid/text/Spannable;", "onGenericMotionEvent", "p2", "Landroid/view/MotionEvent;", "onKeyDown", "", "p3", "Landroid/view/KeyEvent;", "onKeyOther", "onKeyUp", "onTakeFocus", "onTouchEvent", "widget", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "event", "onTouchEventInner", "buffer", "onTrackballEvent", "Companion", "ViewFlinger", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class c implements MovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16666a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f16667b;
    private io.noties.markwon.scrollable.b c;
    private VelocityTracker d;
    private final b e;
    private final float f;
    private final MovementMethod g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod$Companion;", "", "()V", "getTouchSpans", "", ExifInterface.GPS_DIRECTION_TRUE, "event", "Landroid/view/MotionEvent;", "widget", "Landroid/widget/TextView;", "span", "Ljava/lang/Class;", "(Landroid/view/MotionEvent;Landroid/widget/TextView;Ljava/lang/Class;)[Ljava/lang/Object;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final <T> T[] a(MotionEvent r3, TextView r4, Class<T> r5) {
            Intrinsics.checkParameterIsNotNull(r3, "event");
            Intrinsics.checkParameterIsNotNull(r4, "widget");
            Intrinsics.checkParameterIsNotNull(r5, "span");
            float r2 = r3.getX();
            float r6 = r3.getY();
            float r7 = r2 - r4.getTotalPaddingLeft();
            float r8 = r6 - r4.getTotalPaddingTop();
            float r9 = r7 + r4.getScrollX();
            float r10 = r8 + r4.getScrollY();
            Layout r0 = r4.getLayout();
            CharSequence r11 = r4.getText();
            if (r0 != null) goto L5;
            return null;
        L5:
            if (ZeusTransformUtils.instanceOf(r11, Spanned.class) == false) goto L10;
            int r12 = r0.getOffsetForHorizontal(r0.getLineForVertical((int) r10), r9);
            return (T[]) ((Spanned) ZeusTransformUtils.preCheckCast(r11, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r12, r12, r5);
        L10:
            return null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/scrollable/HorizontalScrollableMovementMethod$ViewFlinger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animator", "Landroid/animation/ValueAnimator;", "scroller", "Landroid/widget/OverScroller;", "fling", "", "widget", "Landroid/view/View;", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "velocityX", "", "stop", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ValueAnimator f16668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OverScroller f16669b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "io/noties/markwon/scrollable/HorizontalScrollableMovementMethod$ViewFlinger$fling$1$1"}, k = 3, mv = {1, 1, 15})
        static final class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f16670a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ io.noties.markwon.scrollable.b f16671b;
            final /* synthetic */ View c;

            a(b r1, io.noties.markwon.scrollable.b r2, View r3) {
                this.f16670a = r1;
                this.f16671b = r2;
                this.c = r3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r2) {
                if (b.a(this.f16670a).computeScrollOffset() == false) goto L5;
                this.f16671b.a(b.a(this.f16670a).getCurrX());
                ViewCompat.postInvalidateOnAnimation(this.c);
                return;
            L5:
                Intrinsics.checkExpressionValueIsNotNull(r2, "it");
                if (r2.getAnimatedFraction() >= 1.0f) goto L10;
                r2.end();
                return;
            }
        }

        public static final /* synthetic */ OverScroller a(b r0) {
            return r0.f16669b;
        }

        public final void a() {
            ValueAnimator r0 = this.f16668a;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            this.f16668a = (ValueAnimator) ZeusTransformUtils.preCheckCast(null, ValueAnimator.class, "com.obric.memorydata.plugin");
            this.f16669b.abortAnimation();
        }

        public final void a(View r13, io.noties.markwon.scrollable.b r14, int r15) {
            Intrinsics.checkParameterIsNotNull(r13, "widget");
            Intrinsics.checkParameterIsNotNull(r14, "scrollable");
            this.f16669b.fling((int) r14.b(), 0, r15, 0, -((int) r14.c()), 0, 0, 0, (int) r14.a(), 0);
            ValueAnimator r16 = this.f16668a;
            if (r16 == null) goto L5;
            r16.cancel();
        L5:
            ValueAnimator r17 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            Intrinsics.checkExpressionValueIsNotNull(r17, "anim");
            r17.setDuration(Long.MAX_VALUE);
            r17.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(new a(this, r14, r13), ValueAnimator.AnimatorUpdateListener.class, "com.obric.memorydata.plugin"));
            r17.start();
            this.f16668a = r17;
        }
    }

    static {
        f16666a = new a(null);
    }

    private final boolean a(TextView r8, Spannable r9, MotionEvent r10) {
        Spannable r11 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r9, Spannable.class, "com.obric.memorydata.plugin");
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L18;
        this.e.a();
        io.noties.markwon.scrollable.b[] r2 = (io.noties.markwon.scrollable.b[]) ZeusTransformUtils.preCheckCast(f16666a.a(r10, r8, io.noties.markwon.scrollable.b.class), io.noties.markwon.scrollable.b[].class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        io.noties.markwon.scrollable.b r3 = (io.noties.markwon.scrollable.b) ZeusTransformUtils.preCheckCast(ArraysKt.firstOrNull(r2), io.noties.markwon.scrollable.b.class, "com.obric.memorydata.plugin");
    L8:
        this.c = r3;
        if (r3 == null) goto L26;
        VelocityTracker r4 = this.d;
        if (r4 == null) goto L14;
        if (r4 == null) goto L15;
        r4.clear();
    L15:
        VelocityTracker r5 = this.d;
        if (r5 == null) goto L26;
    L24:
        r5.addMovement(r10);
        goto L26
    L14:
        this.d = VelocityTracker.obtain();
    L26:
        if (r12 != 1) goto L28;
    L29:
        io.noties.markwon.scrollable.b r13 = this.c;
        if (r13 == null) goto L39;
        VelocityTracker r6 = this.d;
        if (r6 == null) goto L34;
        r6.computeCurrentVelocity(1000, this.f);
    L34:
        b r7 = this.e;
        View r14 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
        VelocityTracker r15 = this.d;
        if (r15 == null) goto L37;
        int r16 = MathKt.roundToInt(r15.getXVelocity());
    L38:
        r7.a(r14, r13, r16);
        goto L39
    L37:
        r16 = 0;
    L39:
        this.c = (io.noties.markwon.scrollable.b) ZeusTransformUtils.preCheckCast(null, io.noties.markwon.scrollable.b.class, "com.obric.memorydata.plugin");
        VelocityTracker r17 = this.d;
        if (r17 == null) goto L42;
        r17.recycle();
    L42:
        this.d = (VelocityTracker) ZeusTransformUtils.preCheckCast(null, VelocityTracker.class, "com.obric.memorydata.plugin");
    L43:
        this.f16667b = r10.getX();
        io.noties.markwon.scrollable.b r18 = this.c;
        if (r18 != null) goto L46;
        return false;
    L46:
        if (r18.d() == true) goto L48;
        return false;
    L48:
        return true;
    L28:
        if (r12 != 3) goto L43;
    L7:
        r3 = null;
        goto L8
    L18:
        io.noties.markwon.scrollable.b r19 = this.c;
        if (r19 == null) goto L26;
        if (r19.d() == false) goto L26;
        r19.a(r19.b() + (r10.getX() - this.f16667b));
        ViewCompat.postInvalidateOnAnimation((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        r5 = this.d;
        if (r5 == null) goto L26;
        goto L24
    }

    @Override // android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return this.g.canSelectArbitrarily();
    }

    @Override // android.text.method.MovementMethod
    public void initialize(TextView r3, Spannable r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        this.g.initialize(r3, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onGenericMotionEvent(TextView r3, Spannable r4, MotionEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.g.onGenericMotionEvent(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyDown(TextView r3, Spannable r4, int r5, KeyEvent r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.g.onKeyDown(r3, r7, r5, r6);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyOther(TextView r3, Spannable r4, KeyEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.g.onKeyOther(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyUp(TextView r3, Spannable r4, int r5, KeyEvent r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.g.onKeyUp(r3, r7, r5, r6);
    }

    @Override // android.text.method.MovementMethod
    public void onTakeFocus(TextView r3, Spannable r4, int r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        this.g.onTakeFocus(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r3, Spannable r4, MotionEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "widget");
        Intrinsics.checkParameterIsNotNull(r6, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkParameterIsNotNull(r5, "event");
        a(r3, r6, r5);
        return this.g.onTouchEvent(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTrackballEvent(TextView r3, Spannable r4, MotionEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.g.onTrackballEvent(r3, r6, r5);
    }
}
