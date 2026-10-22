package com.bytedance.android.livesdk.common;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
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
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0002`aB'\b\u0007\u0012\u0006\u0010Y\u001a\u00020X\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u00020\u0006¢\u0006\u0004\b]\u0010^J\u0012\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J&\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0006J\u001e\u0010'\u001a\u00020\b2\u0016\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010%J\u0018\u0010*\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0006\u0010+\u001a\u00020\bJ\u0010\u0010,\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0003H\u0016J\n\u00100\u001a\u0004\u0018\u00010/H\u0016J\u001e\u0010\u0005\u001a\u00020\b2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010%H\u0016J\b\u00102\u001a\u00020\bH\u0016J\u0006\u00103\u001a\u00020\bJ\b\u00104\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0003H\u0016J\n\u00107\u001a\u0004\u0018\u00010\u000bH\u0016J$\u00109\u001a\u00020\b2\u0006\u00108\u001a\u00020\u000b2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010%J\b\u0010:\u001a\u0004\u0018\u00010/J\u0010\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0003H\u0016J\u000e\u0010>\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u0003R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010FR\u0014\u0010M\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bM\u0010HR\u0016\u0010N\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bP\u0010R\"\u0004\bS\u0010TR\u0018\u0010W\u001a\u00020\u0006*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V¨\u0006b"}, d2 = {"Lcom/bytedance/android/livesdk/common/MarqueeTextView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/common/j;", "", "isLoop", "startMarqueeIfNeed", "", "distance", "", "startAnimation", "Lkotlin/Pair;", "", "getMarqueeTextAndWidth", "getEndAnimationText", "text", "getEllipsisStart", "minWidthPx", "setMinWidth", "maxWidthPx", "setMaxWidth", "Landroid/view/View;", "getA11yDescView", "getContent", "setTextWithFading", "", "duration", "setAnimationDuration", "setTextWithEllipsis", "setTextWithEllipsisImmediately", "speedPx", "setSpeed", "", "radius", "dx", "dy", "color", "setTextShadow", "Lkotlin/Function1;", "onClick", "setOnClickListener", "unit", "size", "setTextSize", "setUnbold", "setTextColor", "includepad", "setIncludeFontPadding", "Landroid/graphics/Paint;", "getPaint", "action", "scrollToOrigin", "cancelMarquee", "cancelAnimation", "isScrollEnd", "setScrollEnd", "getOriginText", "s", "setTextAndMarquee", "getTextPaint", "needEdge", "textNeedLeftEdge", "b", "setNeedLeftEdge", "Lcom/bytedance/android/livesdk/common/MarqueeTextView$FadingEdgeHorizontalScrollView;", "scrollView", "Lcom/bytedance/android/livesdk/common/MarqueeTextView$FadingEdgeHorizontalScrollView;", "Landroid/widget/TextView;", "userNameView", "Landroid/widget/TextView;", "marqueeSpeedPx", "I", "originText", "Ljava/lang/String;", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "lastTextEndState", "infix", "animDuration", "J", "isScrollEndFinish", "Z", "()Z", "setScrollEndFinish", "(Z)V", "getDpInt", "(I)I", "dpInt", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "FadingEdgeHorizontalScrollView", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarqueeTextView extends FrameLayout implements j {
    public static final a Companion = null;
    private static final int DEFAULT_SPEED_DP = 24;
    private static final int ELLIPSIS = 2;
    private static final int FADING = 1;
    public static final String TAG = "MarqueeTextView";
    private long animDuration;
    private Animator animator;
    private final String infix;
    private boolean isScrollEndFinish;
    private int lastTextEndState;
    private int marqueeSpeedPx;
    private String originText;
    private FadingEdgeHorizontalScrollView scrollView;
    private TextView userNameView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/common/MarqueeTextView$FadingEdgeHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxWidthPx", "getMaxWidthPx", "()I", "setMaxWidthPx", "(I)V", "needLeftEdge", "", "getNeedLeftEdge", "()Z", "setNeedLeftEdge", "(Z)V", "getLeftFadingEdgeStrength", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FadingEdgeHorizontalScrollView extends HorizontalScrollView {
        private int maxWidthPx;
        private boolean needLeftEdge;

        public static final class a implements View.OnTouchListener {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View r1, MotionEvent r2) {
                return true;
            }
        }

        public FadingEdgeHorizontalScrollView(Context r7) {
            this(r7, null, 0, 6, null);
        }

        public FadingEdgeHorizontalScrollView(Context r7, AttributeSet r8) {
            this(r7, r8, 0, 4, null);
        }

        @Override // android.widget.HorizontalScrollView, android.view.View
        public float getLeftFadingEdgeStrength() {
            if (this.needLeftEdge == true) goto L7;
            return 0.0f;
        L7:
            return super.getLeftFadingEdgeStrength();
        }

        public final int getMaxWidthPx() {
            return this.maxWidthPx;
        }

        public final boolean getNeedLeftEdge() {
            return this.needLeftEdge;
        }

        public final void setMaxWidthPx(int r1) {
            this.maxWidthPx = r1;
        }

        public final void setNeedLeftEdge(boolean r1) {
            this.needLeftEdge = r1;
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
        public void onMeasure(int r4, int r5) {
            if (this.maxWidthPx <= 0) goto L8;
            int r0 = View.MeasureSpec.getMode(r4);
            int r1 = View.MeasureSpec.getSize(r4);
            int r2 = this.maxWidthPx;
            if (r2 <= 0) goto L8;
            if (r1 <= r2) goto L8;
            r4 = View.MeasureSpec.makeMeasureSpec(r2, r0);
        L8:
            super.onMeasure(r4, r5);
        }

        public FadingEdgeHorizontalScrollView(Context r2, AttributeSet r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2, r3, r4);
            setOnTouchListener(a.a);
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

    public static final class c implements Runnable {
        public final /* synthetic */ MarqueeTextView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1 c;

        public c(MarqueeTextView r1, String r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MarqueeTextView.access$setOriginText$p(this.a, this.b);     // Catch: Throwable -> L9
            TextView r0 = MarqueeTextView.access$getUserNameView$p(this.a);     // Catch: Throwable -> L9
            if (r0 == null) goto L5;
            r0.setText(this.b);     // Catch: Throwable -> L9
        L5:
            boolean r1 = MarqueeTextView.access$startMarqueeIfNeed(this.a, true);     // Catch: Throwable -> L9
            Function1 r2 = this.c;     // Catch: Throwable -> L9
            if (r2 == null) goto L12;
            Unit r3 = (Unit) r2.invoke(Boolean.valueOf(r1));     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MarqueeTextView a;

        public d(MarqueeTextView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i(MarqueeTextView.TAG, "setTextWithEllipsis, get end animation text");     // Catch: Throwable -> L6
            TextView r0 = MarqueeTextView.access$getUserNameView$p(this.a);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setText(MarqueeTextView.access$getEndAnimationText(this.a));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ MarqueeTextView a;

        public e(MarqueeTextView r1) {
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
            FadingEdgeHorizontalScrollView r0 = MarqueeTextView.access$getScrollView$p(this.a);
            if (r0 == null) goto L12;
            r0.scrollTo(r6, 0);
            return;
        L12:
            return;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ MarqueeTextView a;
        public final /* synthetic */ Function1 b;

        public f(MarqueeTextView r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r0 = MarqueeTextView.startMarqueeIfNeed$default(this.a, false, 1, null);     // Catch: Throwable -> L6
            Function1 r1 = this.b;     // Catch: Throwable -> L6
            if (r1 == null) goto L9;
            Unit r2 = (Unit) r1.invoke(Boolean.valueOf(r0));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public MarqueeTextView(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public MarqueeTextView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithFadingMode(String r1) {
    }

    private final String getEndAnimationText() {
        int r0 = getEllipsisStart(this.originText);
        if (r0 <= 0) goto L5;
        TextView r1 = this.userNameView;
        if (r1 == null) goto L40;
        TextPaint r2 = r1.getPaint();
        if (r2 == null) goto L40;
        FadingEdgeHorizontalScrollView r3 = this.scrollView;
        if (r3 == null) goto L14;
        int r4 = r3.getMaxWidthPx();
    L15:
        if (r4 <= 0) goto L20;
        FadingEdgeHorizontalScrollView r5 = this.scrollView;
        if (r5 == null) goto L19;
        int r6 = r5.getMaxWidthPx();
    L21:
        Integer r7 = Integer.valueOf(r6);
    L22:
        if (r7 == null) goto L24;
        int r8 = r7.intValue();
    L25:
        StringBuilder r9 = new StringBuilder("getEndAnimationText, windowLength : ");
        r9.append(r8);
        r9.append(", max witdh ");
        FadingEdgeHorizontalScrollView r10 = this.scrollView;
        if (r10 == null) goto L28;
        Integer r11 = Integer.valueOf(r10.getMaxWidthPx());
    L29:
        r9.append(r11);
        r9.append(", width ");
        r9.append(getWidth());
        ALogger.i(TAG, r9.toString());
        String r12 = this.originText;
        if (r12 == null) goto L40;
        StringBuilder r13 = new StringBuilder(r12.subSequence(0, r0));
        r13.append("...");
    L32:
        float r14 = r8;
        if (r2.measureText(r13.toString()) <= r14) goto L36;
        r13.deleteCharAt(r13.length() - 4);
    L36:
        if (r2.measureText(r13.toString()) >= r14) goto L38;
        r13.append(' ');
        goto L36
    L38:
        ALogger.i(TAG, "getEndAnimationText, final string is " + r13.toString());
        return r13.toString();
    L28:
        r11 = null;
        goto L29
    L24:
        r8 = 0;
        goto L25
    L19:
        r7 = null;
        goto L22
    L20:
        r6 = getWidth();
        goto L21
    L14:
        r4 = 0;
    L40:
        return null;
    L5:
        return this.originText;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void cancelAnimation() {
        Animator r0 = this.animator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.animator = null;
    }

    public final void cancelMarquee() {
        Animator r0 = this.animator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        FadingEdgeHorizontalScrollView r1 = this.scrollView;
        if (r1 == null) goto L8;
        r1.scrollTo(0, 0);
    L8:
        TextView r2 = this.userNameView;
        if (r2 == null) goto L12;
        r2.setText(this.originText);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public String getContent() {
        TextView r0 = this.userNameView;
        if (r0 == null) goto L7;
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L7;
        return r1.toString();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public Paint getPaint() {
        TextView r0 = this.userNameView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPaint();
    }

    public final Paint getTextPaint() {
        TextView r0 = this.userNameView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPaint();
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void scrollToOrigin() {
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L6;
        r0.scrollTo(0, 0);
        return;
    }

    public final void setUnbold() {
        TextView r0 = this.userNameView;
        if (r0 == null) goto L6;
        r0.setTypeface(Typeface.defaultFromStyle(0));
        return;
    }

    private final Pair<String, Integer> getMarqueeTextAndWidth() {
        String r0 = getEndAnimationText();
        String r1 = this.originText + this.infix;
        float r3 = 0.0f;
        if (this.isScrollEndFinish == false) goto L10;
        TextView r2 = this.userNameView;
        if (r2 == null) goto L9;
        TextPaint r4 = r2.getPaint();
        if (r4 == null) goto L9;
        r3 = r4.measureText(r1);
    L9:
        int r5 = ((int) r3) - getWidth();
    L17:
        return TuplesKt.to(r1 + r0, Integer.valueOf(r5));
    L10:
        TextView r6 = this.userNameView;
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
        return this.userNameView;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public String getOriginText() {
        return this.originText;
    }

    public final boolean isScrollEndFinish() {
        return this.isScrollEndFinish;
    }

    public static final /* synthetic */ String access$getEndAnimationText(MarqueeTextView r0) {
        return r0.getEndAnimationText();
    }

    public static final /* synthetic */ String access$getOriginText$p(MarqueeTextView r0) {
        return r0.originText;
    }

    public static final /* synthetic */ FadingEdgeHorizontalScrollView access$getScrollView$p(MarqueeTextView r0) {
        return r0.scrollView;
    }

    public static final /* synthetic */ TextView access$getUserNameView$p(MarqueeTextView r0) {
        return r0.userNameView;
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
        TextView r2 = this.userNameView;
        if (r2 == null) goto L39;
        TextPaint r3 = r2.getPaint();
        if (r3 == null) goto L39;
        FadingEdgeHorizontalScrollView r4 = this.scrollView;
        if (r4 == null) goto L20;
        int r5 = r4.getMaxWidthPx();
    L21:
        if (r5 <= 0) goto L26;
        FadingEdgeHorizontalScrollView r6 = this.scrollView;
        if (r6 == null) goto L25;
        int r7 = r6.getMaxWidthPx();
    L27:
        Integer r8 = Integer.valueOf(r7);
    L28:
        if (r8 == null) goto L39;
        float r10 = r8.intValue();
        if (r3.measureText(r9) > r10) goto L32;
        return 0;
    L32:
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L34:
        if (r0 >= r9.length()) goto L39;
        int r13 = r12 + 1;
        r11.append(r9.charAt(r0));
        if (r3.measureText(r11.toString()) >= r10) goto L37;
        r0 = r0 + 1;
        r12 = r13;
        goto L34
    L37:
        return r12;
    L25:
        r8 = null;
        goto L28
    L26:
        r7 = getWidth();
        goto L27
    L20:
        r5 = 0;
    L39:
        return -1;
    L5:
        if (r9.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final boolean startMarqueeIfNeed(boolean r4) {
        int r0 = getEllipsisStart(this.originText);
        if (r0 <= 0) goto L15;
        String r2 = this.originText;
        if (r2 == null) goto L7;
        int r3 = r2.length();
    L8:
        if (r0 >= r3) goto L15;
        cancelAnimation();
        ALogger.i(TAG, "startMarqueeIfNeed, get text and width");
        Pair<String, Integer> r1 = getMarqueeTextAndWidth();
        TextView r5 = this.userNameView;
        if (r5 == null) goto L13;
        r5.setText((CharSequence) r1.getFirst());
    L13:
        startAnimation(((Number) r1.getSecond()).intValue(), r4);
        return true;
    L7:
        r3 = 0;
    L15:
        return false;
    }

    public void setAnimationDuration(long r1) {
        this.animDuration = r1;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setIncludeFontPadding(boolean r2) {
        TextView r0 = this.userNameView;
        if (r0 == null) goto L6;
        r0.setIncludeFontPadding(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setMaxWidth(int r2) {
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L5;
        r0.setMaxWidthPx(r2);
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

    public final void setMinWidth(int r2) {
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L5;
        r0.setMinimumWidth(r2);
    L5:
        int r3 = this.lastTextEndState;
        if (r3 != 1) goto L9;
        setTextWithFading(this.originText);
        return;
    L9:
        if (r3 != 2) goto L13;
        setTextWithEllipsis(this.originText);
        return;
    }

    public final void setNeedLeftEdge(boolean r2) {
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L6;
        r0.setNeedLeftEdge(r2);
        return;
    }

    public final void setOnClickListener(Function1<? super View, Unit> r3) {
        TextView r0 = this.userNameView;
        if (r0 == null) goto L8;
        if (r3 == null) goto L6;
        r3 = new b(r3);
    L6:
        r0.setOnClickListener((View.OnClickListener) r3);
        return;
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

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextColor(int r2) {
        TextView r0 = this.userNameView;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithEllipsis(String r3) {
        this.lastTextEndState = 2;
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L5;
        r0.scrollTo(0, 0);
    L5:
        this.originText = r3;
        post(new d(this));
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithEllipsisImmediately(String r3) {
        this.lastTextEndState = 2;
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L5;
        r0.scrollTo(0, 0);
    L5:
        this.originText = r3;
        TextView r4 = this.userNameView;
        if (r4 == null) goto L9;
        r4.setText(getEndAnimationText());
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextWithFading(String r3) {
        this.lastTextEndState = 1;
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L5;
        r0.scrollTo(0, 0);
    L5:
        this.originText = r3;
        TextView r1 = this.userNameView;
        if (r1 == null) goto L9;
        r1.setText(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void textNeedLeftEdge(boolean r2) {
        FadingEdgeHorizontalScrollView r0 = this.scrollView;
        if (r0 == null) goto L6;
        r0.setNeedLeftEdge(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void startMarqueeIfNeed(j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "marqueeCallback");
        Intrinsics.checkNotNullParameter(r2, "marqueeCallback");
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void startMarqueeIfNeed(Function1<? super Boolean, Unit> r2) {
        post(new f(this, r2));
    }

    public static final /* synthetic */ void access$setOriginText$p(MarqueeTextView r0, String r1) {
        r0.originText = r1;
    }

    public static final /* synthetic */ void access$setScrollView$p(MarqueeTextView r0, FadingEdgeHorizontalScrollView r1) {
        r0.scrollView = r1;
    }

    public static final /* synthetic */ void access$setUserNameView$p(MarqueeTextView r0, TextView r1) {
        r0.userNameView = r1;
    }

    public static final /* synthetic */ boolean access$startMarqueeIfNeed(MarqueeTextView r0, boolean r1) {
        return r0.startMarqueeIfNeed(r1);
    }

    private final void startAnimation(int r8, boolean r9) {
        Animator r0 = this.animator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        FadingEdgeHorizontalScrollView r1 = this.scrollView;
        if (r1 == null) goto L8;
        r1.scrollTo(0, 0);
    L8:
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{0, r8});
        r2.setInterpolator(new LinearInterpolator());
        long r3 = this.animDuration;
        if (r3 > 0) goto L12;
        r3 = (r8 * BubbleId.PadCast) / this.marqueeSpeedPx;
    L12:
        r2.setDuration(r3);
        r2.addUpdateListener(new e(this));
        if (r9 == false) goto L15;
        r2.setRepeatCount(-1);
        r2.setRepeatMode(1);
    L15:
        r2.start();
        Unit r10 = Unit.INSTANCE;
        this.animator = r2;
    }

    public final void setTextAndMarquee(String r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "s");
        post(new c(this, r2, r3));
    }

    @Override // com.bytedance.android.livesdk.common.j
    public void setTextSize(int r2, float r3) {
        TextView r0 = this.userNameView;
        if (r0 == null) goto L6;
        r0.setTextSize(r2, r3);
        return;
    }

    public MarqueeTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.marqueeSpeedPx = getDpInt(DEFAULT_SPEED_DP);
        this.infix = "       ";
        LayoutInflater.from(r2).inflate(2131566881, this, true);
        this.scrollView = (FadingEdgeHorizontalScrollView) findViewById(2131385217);
        this.userNameView = (TextView) findViewById(2131392049);
        this.animDuration = -1;
    }

    public static /* synthetic */ boolean startMarqueeIfNeed$default(MarqueeTextView r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.startMarqueeIfNeed(r1);
    }

    public final void setTextShadow(float r2, float r3, float r4, int r5) {
        TextView r0 = this.userNameView;
        if (r0 == null) goto L6;
        r0.setShadowLayer(r2, r3, r4, r5);
        return;
    }

    public /* synthetic */ MarqueeTextView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static /* synthetic */ void startAnimation$default(MarqueeTextView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.startAnimation(r1, r2);
    }
}
