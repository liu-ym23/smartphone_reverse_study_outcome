package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.config.bi1;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nu0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/OperationTipView;", "Landroid/widget/FrameLayout;", "", "d", "Lkotlin/Lazy;", "getThinking", "()Ljava/lang/String;", "thinking", "e", "getThinkingContent", "thinkingContent", "f", "getStartTopic", "startTopic", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OperationTipView extends FrameLayout {
    public final ImageView a;
    public final TextView b;
    public final ViewGroup c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final int g;
    public final int h;
    public Disposable i;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            if (this.b == true) goto L6;
            ViewUtilsKt.e(this.a);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            if (this.b == false) goto L6;
            UtilityKotlinExtentionsKt.w(this.a);
            return;
        }

        public a(View r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public OperationTipView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OperationTipView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getStartTopic() {
        return (String) this.f.getValue();
    }

    private final String getThinking() {
        return (String) this.d.getValue();
    }

    private final String getThinkingContent() {
        return (String) this.e.getValue();
    }

    public static final /* synthetic */ String a(OperationTipView r0) {
        return r0.getThinking();
    }

    public static final /* synthetic */ String b(OperationTipView r0) {
        return r0.getThinkingContent();
    }

    public final Animator c(boolean r8) {
        Object r2 = Float.valueOf(0.0f);
        Float r4 = Float.valueOf(1.0f);
        PathInterpolator r0 = new PathInterpolator(0.76f, 0.0f, 0.24f, 1.0f);
        Property r1 = View.ALPHA;
        float[] r3 = new float[2];
        Object r5 = bi1.a(Boolean.valueOf(r8), r2);
        if (r5 != null) goto L5;
        r5 = r4;
    L5:
        r3[0] = ((Number) r5).floatValue();
        Object r6 = bi1.a(Boolean.valueOf(r8), r4);
        if (r6 == null) goto L9;
        r2 = r6;
    L9:
        r3[1] = ((Number) r2).floatValue();
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, r1, r3);
        r7.setDuration(200);
        r7.setStartDelay(0);
        r7.setInterpolator(r0);
        r7.addListener(new a(this, r8));
        return r7;
    }

    public final void d(ju0.f r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        j.d(this, "onReceiveTopicMsg, topics: " + r3.b, null);
        Disposable r0 = this.i;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        e(this.h, getStartTopic(), r3.b);
    }

    public OperationTipView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = LazyKt.lazy(new OperationTipView$thinking$2(r2));
        this.e = LazyKt.lazy(new OperationTipView$thinkingContent$2(r2));
        this.f = LazyKt.lazy(new OperationTipView$startTopic$2(r2));
        this.g = 2131250658;
        this.h = 2131250659;
        LayoutInflater.from(r2).inflate(2131566025, this);
        this.a = (ImageView) findViewById(2131388727);
        this.b = (TextView) findViewById(2131388736);
        this.c = (ViewGroup) findViewById(2131388722);
    }

    public final void e(int r6, String r7, List<String> r8) {
        this.a.setImageResource(r6);
        this.b.setText(r7);
        this.c.removeAllViews();
        List r9 = CollectionsKt.take(r8, 3);
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r12 = r9.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        String r13 = (String) r12.next();
        TextView r0 = new TextView(getContext(), null, 0, 2131954915);
        r0.setText(r13);
        ViewGroup r14 = this.c;
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(-1, -2);
        r1.topMargin = UtilityKotlinExtentionsKt.i(12);
        Unit r2 = Unit.INSTANCE;
        r14.addView(r0, r1);
        r10.add(r0);
        goto L4
    L6:
        c(true).start();
    }

    public /* synthetic */ OperationTipView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
