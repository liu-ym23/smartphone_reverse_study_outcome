package com.bytedance.android.livesdk.common;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0002fgB'\b\u0007\u0012\u0006\u0010_\u001a\u00020^\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010`\u0012\b\b\u0002\u0010b\u001a\u00020\u0005¢\u0006\u0004\bc\u0010dJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0014J0\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010$\u001a\u00020\u0003J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0005H\u0016J\u001e\u0010)\u001a\u00020\u00072\u0016\u0010(\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u0007\u0018\u00010'J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0003H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0003H\u0016J\u001e\u0010\u0004\u001a\u00020\u00072\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010'H\u0016J\u0010\u0010\u0004\u001a\u00020\u00072\u0006\u00108\u001a\u000207H\u0016J\b\u00109\u001a\u00020\u0007H\u0016J\u0006\u0010:\u001a\u00020\u0007J\b\u0010;\u001a\u00020\u0007H\u0016J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0003H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010M\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010@R\u0018\u0010N\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010@R\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010TR\u0014\u0010U\u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\bU\u0010OR\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010VR\"\u0010W\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010T\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010]\u001a\u00020\u0005*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\¨\u0006h"}, d2 = {"Lcom/bytedance/android/livesdk/common/MatchMarqueeTextView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/common/j;", "", "startMarqueeIfNeed", "", "distance", "", "startAnimation", "Lkotlin/Pair;", "", "getMarqueeTextAndWidth", "getEndAnimationText", "text", "getEllipsisStart", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "setTextWithEllipsis", "setTextWithFading", "setTextWithFadingMode", "", "duration", "setAnimationDuration", "setTextWithEllipsisImmediately", "maxWidthPx", "setMaxWidth", "Landroid/view/View;", "getA11yDescView", "getContent", "isInAnimation", "speedPx", "setSpeed", "Lkotlin/Function1;", "onClick", "setOnClickListener", "unit", "", "size", "setTextSize", "color", "setTextColor", "includepad", "setIncludeFontPadding", "Landroid/graphics/Paint;", "getPaint", "needEdge", "textNeedLeftEdge", "action", "Lcom/bytedance/android/livesdk/common/j$a;", "marqueeCallback", "scrollToOrigin", "reset", "cancelAnimation", "isScrollEnd", "setScrollEnd", "getOriginText", "lastWidth", "I", "animDuration", "J", "Lcom/bytedance/android/livesdk/common/MatchMarqueeTextView$FadingEdgeHorizontalScrollView;", "scrollView", "Lcom/bytedance/android/livesdk/common/MatchMarqueeTextView$FadingEdgeHorizontalScrollView;", "Lcom/bytedance/android/livesdk/common/MatchTitleTextView;", "realTextView", "Lcom/bytedance/android/livesdk/common/MatchTitleTextView;", "getRealTextView", "()Lcom/bytedance/android/livesdk/common/MatchTitleTextView;", "setRealTextView", "(Lcom/bytedance/android/livesdk/common/MatchTitleTextView;)V", "marqueeSpeedPx", "originText", "Ljava/lang/String;", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "lastTextEndState", "Z", "infix", "Lcom/bytedance/android/livesdk/common/j$a;", "isScrollEndFinish", "()Z", "setScrollEndFinish", "(Z)V", "getDpInt", "(I)I", "dpInt", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "FadingEdgeHorizontalScrollView", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchMarqueeTextView extends FrameLayout implements j {
    public static final a Companion = null;
    private static final int DEFAULT_SPEED_DP = 24;
    private static final int ELLIPSIS = 2;
    private static final int FADING = 1;
    private long animDuration;
    private Animator animator;
    private final String infix;
    private boolean isInAnimation;
    private boolean isScrollEndFinish;
    private int lastTextEndState;
    private int lastWidth;
    private j.a marqueeCallback;
    private int marqueeSpeedPx;
    private String originText;
    private MatchTitleTextView realTextView;
    private FadingEdgeHorizontalScrollView scrollView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/common/MatchMarqueeTextView$FadingEdgeHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "needLeftEdge", "", "getNeedLeftEdge", "()Z", "setNeedLeftEdge", "(Z)V", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getLeftFadingEdgeStrength", "", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FadingEdgeHorizontalScrollView extends HorizontalScrollView {
        private boolean needLeftEdge;

        public FadingEdgeHorizontalScrollView(Context r7) {
            this(r7, null, 0, 6, null);
        }

        public FadingEdgeHorizontalScrollView(Context r7, AttributeSet r8) {
            this(r7, r8, 0, 4, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "ev");
            return false;
        }

        @Override // android.widget.HorizontalScrollView, android.view.View
        public float getLeftFadingEdgeStrength() {
            if (this.needLeftEdge == false) goto L5;
            return 1.0f;
        L5:
            return 0.0f;
        }

        public final boolean getNeedLeftEdge() {
            return this.needLeftEdge;
        }

        public final void setNeedLeftEdge(boolean r1) {
            this.needLeftEdge = r1;
        }

        public FadingEdgeHorizontalScrollView(Context r2, AttributeSet r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2, r3, r4);
        }

        public /* synthetic */ FadingEdgeHorizontalScrollView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 4) == 0) goto L8;
            r3 = 0;
        L8:
            this(r1, r2, r3);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View r2) {
            this.a.invoke(r2);
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MatchMarqueeTextView a;

        public c(MatchMarqueeTextView r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            Object r4 = r3.getAnimatedValue();
            if ((r4 instanceof Integer) == true) goto L5;
            r4 = null;
        L5:
            Integer r5 = (Integer) r4;
            if (r5 == null) goto L11;
            int r6 = r5.intValue();
            MatchTitleTextView r0 = this.a.getRealTextView();
            if (r0 == null) goto L12;
            r0.scrollTo(r6, 0);
            return;
        L12:
            return;
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ MatchMarqueeTextView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public d(MatchMarqueeTextView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MatchMarqueeTextView.access$setInAnimation$p(this.a, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MatchMarqueeTextView.access$setInAnimation$p(this.a, false);
            j.a r3 = MatchMarqueeTextView.access$getMarqueeCallback$p(this.a);
            if (r3 == null) goto L6;
            r3.onEnd();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            MatchMarqueeTextView.access$setInAnimation$p(this.a, true);
        }
    }

    public static final class e implements j.a {
        public final /* synthetic */ Function1 a;

        @Override // com.bytedance.android.livesdk.common.j.a
        public final void onEnd() {
        }

        @Override // com.bytedance.android.livesdk.common.j.a
        public final void onStart() {
            Function1 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke(Boolean.TRUE);
            return;
        }

        public e(Function1 r1) {
            this.a = r1;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ MatchMarqueeTextView a;
        public final /* synthetic */ j.a b;

        public f(MatchMarqueeTextView r1, j.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MatchMarqueeTextView.access$setMarqueeCallback$p(this.a, this.b);     // Catch: Throwable -> L4
            MatchMarqueeTextView.access$startMarqueeIfNeed(this.a);     // Catch: Throwable -> L4
            this.b.onStart();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public MatchMarqueeTextView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public MatchMarqueeTextView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    private final String getEndAnimationText() {
        int r0 = getEllipsisStart(this.originText);
        if (r0 <= 0) goto L5;
        AppCompatTextView r1 = this.realTextView;
        if (r1 == null) goto L30;
        TextPaint r2 = r1.getPaint();
        if (r2 == null) goto L30;
        int r3 = getWidth();
        if (r3 <= 0) goto L14;
        String r4 = this.originText;
        if (r4 == null) goto L30;
        StringBuilder r5 = new StringBuilder(r4.subSequence(0, r0));
        r5.append("...");
    L18:
        float r6 = r3;
        if (r2.measureText(r5.toString()) <= r6) goto L26;
        if ((r5.length() - 4) < 0) goto L23;
        r5.deleteCharAt(r5.length() - 4);
        goto L18
    L23:
        return r5.toString();
    L26:
        if (r2.measureText(r5.toString()) >= r6) goto L29;
        r5.append(' ');
        goto L26
    L29:
        return r5.toString();
    L14:
        return this.originText;
    L30:
        return null;
    L5:
        return this.originText;
    }

    private final boolean startMarqueeIfNeed() {
        int r0 = getEllipsisStart(this.originText);
        if (r0 <= 0) goto L15;
        String r2 = this.originText;
        if (r2 == null) goto L7;
        int r3 = r2.length();
    L8:
        if (r0 >= r3) goto L15;
        cancelAnimation();
        Pair<String, Integer> r1 = getMarqueeTextAndWidth();
        AppCompatTextView r4 = this.realTextView;
        if (r4 == null) goto L13;
        r4.setText((CharSequence) r1.getFirst());
    L13:
        startAnimation(((Number) r1.getSecond()).intValue());
        return true;
    L7:
        r3 = 0;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void cancelAnimation() {
        Animator r0 = this.animator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.animator = null;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public String getContent() {
        MatchTitleTextView r0 = this.realTextView;
        if (r0 == null) goto L7;
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public Paint getPaint() {
        AppCompatTextView r0 = this.realTextView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPaint();
    }

    public final void reset() {
        MatchTitleTextView r0 = this.realTextView;
        if (r0 == null) goto L6;
        r0.x();
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void scrollToOrigin() {
        MatchTitleTextView r0 = this.realTextView;
        if (r0 == null) goto L5;
        r0.x();
    L5:
        FadingEdgeHorizontalScrollView r1 = this.scrollView;
        if (r1 == null) goto L9;
        r1.scrollTo(0, 0);
        return;
    }

    private final Pair<String, Integer> getMarqueeTextAndWidth() {
        String r0 = getEndAnimationText();
        String r1 = this.originText + this.infix;
        float r3 = 0.0f;
        if (this.isScrollEndFinish == false) goto L10;
        AppCompatTextView r2 = this.realTextView;
        if (r2 == null) goto L9;
        TextPaint r4 = r2.getPaint();
        if (r4 == null) goto L9;
        r3 = r4.measureText(r1);
    L9:
        int r5 = ((int) r3) - getWidth();
    L17:
        return TuplesKt.to(r1 + r0, Integer.valueOf(r5));
    L10:
        AppCompatTextView r6 = this.realTextView;
        if (r6 == null) goto L15;
        TextPaint r7 = r6.getPaint();
        if (r7 == null) goto L15;
        r3 = r7.measureText(r1);
    L15:
        r5 = (int) r3;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.common.j
    public View getA11yDescView() {
        return this.realTextView;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public String getOriginText() {
        return this.originText;
    }

    public final MatchTitleTextView getRealTextView() {
        return this.realTextView;
    }

    public final boolean isInAnimation() {
        return this.isInAnimation;
    }

    public final boolean isScrollEndFinish() {
        return this.isScrollEndFinish;
    }

    public static final /* synthetic */ j.a access$getMarqueeCallback$p(MatchMarqueeTextView r0) {
        return r0.marqueeCallback;
    }

    public static final /* synthetic */ boolean access$isInAnimation$p(MatchMarqueeTextView r0) {
        return r0.isInAnimation;
    }

    public static final /* synthetic */ boolean access$startMarqueeIfNeed(MatchMarqueeTextView r0) {
        return r0.startMarqueeIfNeed();
    }

    private final int getDpInt(int r2) {
        return (int) ((s1.l().density * r2) + 0.5f);
    }

    private final int getEllipsisStart(String r9) {
        int r0 = 0;
        if (r9 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return -1;
    L12:
        AppCompatTextView r2 = this.realTextView;
        if (r2 == null) goto L27;
        TextPaint r3 = r2.getPaint();
        if (r3 == null) goto L27;
        float r4 = getWidth();
        if (r3.measureText(r9) > r4) goto L20;
        return 0;
    L20:
        StringBuilder r5 = new StringBuilder();
        int r6 = 0;
    L22:
        if (r0 >= r9.length()) goto L27;
        int r7 = r6 + 1;
        r5.append(r9.charAt(r0));
        if (r3.measureText(r5.toString()) >= r4) goto L25;
        r0 = r0 + 1;
        r6 = r7;
        goto L22
    L25:
        return r6;
    L27:
        return -1;
    L5:
        if (r9.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final void startAnimation(int r7) {
        Animator r0 = this.animator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        MatchTitleTextView r1 = this.realTextView;
        if (r1 == null) goto L8;
        r1.scrollTo(0, 0);
    L8:
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{0, r7});
        r2.setInterpolator(new LinearInterpolator());
        long r3 = this.animDuration;
        if (r3 > 0) goto L12;
        r3 = (r7 * BubbleId.PadCast) / this.marqueeSpeedPx;
    L12:
        r2.setDuration(r3);
        r2.addUpdateListener(new c(this));
        r2.addListener(new d(this));
        r2.start();
        Unit r8 = Unit.INSTANCE;
        this.animator = r2;
    }

    public void setAnimationDuration(long r1) {
        this.animDuration = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.common.j
    public void setIncludeFontPadding(boolean r2) {
        AppCompatTextView r0 = this.realTextView;
        if (r0 == null) goto L6;
        r0.setIncludeFontPadding(r2);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.common.j
    public void setMaxWidth(int r2) {
        AppCompatTextView r0 = this.realTextView;
        if (r0 == null) goto L5;
        r0.setMaxWidth(r2);
    L5:
        requestLayout();
        int r3 = this.lastTextEndState;
        if (r3 != 1) goto L9;
        setTextWithFading(this.originText);
        return;
    L9:
        if (r3 != 2) goto L13;
        setTextWithEllipsis(this.originText);
        return;
    }

    public final void setOnClickListener(Function1<? super View, Unit> r3) {
        AppCompatTextView r0 = this.realTextView;
        if (r0 == null) goto L8;
        if (r3 == null) goto L6;
        r3 = new b(r3);
    L6:
        r0.setOnClickListener((View.OnClickListener) r3);
        return;
    }

    public final void setRealTextView(MatchTitleTextView r1) {
        this.realTextView = r1;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setScrollEnd(boolean r1) {
        this.isScrollEndFinish = r1;
    }

    public final void setScrollEndFinish(boolean r1) {
        this.isScrollEndFinish = r1;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setSpeed(int r1) {
        this.marqueeSpeedPx = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.common.j
    public void setTextColor(int r2) {
        AppCompatTextView r0 = this.realTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithEllipsis(String r1) {
        setTextWithEllipsisImmediately(r1);
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithEllipsisImmediately(String r2) {
        if (this.isInAnimation == false) goto L7;
        Animator r0 = this.animator;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        this.lastTextEndState = 2;
        MatchTitleTextView r1 = this.realTextView;
        if (r1 == null) goto L10;
        r1.x();
    L10:
        this.originText = r2;
        AppCompatTextView r3 = this.realTextView;
        if (r3 == null) goto L14;
        r3.setText(getEndAnimationText());
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithFading(String r1) {
        setTextWithEllipsisImmediately(r1);
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithFadingMode(String r2) {
        this.lastTextEndState = 1;
        this.originText = r2;
        AppCompatTextView r0 = this.realTextView;
        if (r0 == null) goto L5;
        r0.setText(r2);
    L5:
        FadingEdgeHorizontalScrollView r3 = this.scrollView;
        if (r3 == null) goto L9;
        r3.scrollTo(0, 0);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void startMarqueeIfNeed(j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "marqueeCallback");
        post(new f(this, r2));
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void textNeedLeftEdge(boolean r2) {
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L5;
        r0.setNeedLeftEdge(r2);
    L5:
        if (r2 == false) goto L13;
        FadingEdgeHorizontalScrollView r3 = this.scrollView;
        if (r3 == null) goto L9;
        r3.setFadingEdgeLength(getDpInt(20));
    L9:
        FadingEdgeHorizontalScrollView r4 = this.scrollView;
        if (r4 == null) goto L14;
        r4.setScrollbarFadingEnabled(true);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void startMarqueeIfNeed(Function1<? super Boolean, Unit> r2) {
        startMarqueeIfNeed(new e(r2));
    }

    public static final /* synthetic */ void access$setInAnimation$p(MatchMarqueeTextView r0, boolean r1) {
        r0.isInAnimation = r1;
    }

    public static final /* synthetic */ void access$setMarqueeCallback$p(MatchMarqueeTextView r0, j.a r1) {
        r0.marqueeCallback = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextSize(int r2, float r3) {
        MatchTitleTextView r0 = this.realTextView;
        if (r0 == null) goto L6;
        r0.setTextSize(r2, r3);
        return;
    }

    public MatchMarqueeTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.lastWidth = -1;
        this.animDuration = -1;
        this.marqueeSpeedPx = getDpInt(DEFAULT_SPEED_DP);
        this.infix = "       ";
        LayoutInflater.from(r2).inflate(2131566886, this, true);
        this.scrollView = (FadingEdgeHorizontalScrollView) findViewById(2131385217);
        this.realTextView = (MatchTitleTextView) findViewById(2131379700);
    }

    public /* synthetic */ MatchMarqueeTextView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.lastWidth != getWidth()) goto L5;
        return;
    L5:
        if (this.isInAnimation == true) goto L21;
        this.lastWidth = getWidth();
        String r6 = this.originText;
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.length() <= 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 != true) goto L23;
        MatchTitleTextView r8 = this.realTextView;
        if (r8 == null) goto L16;
        r8.x();
    L16:
        AppCompatTextView r9 = this.realTextView;
        if (r9 == null) goto L24;
        r9.setText(getEndAnimationText());
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r7 = false;
        goto L12
    }
}
