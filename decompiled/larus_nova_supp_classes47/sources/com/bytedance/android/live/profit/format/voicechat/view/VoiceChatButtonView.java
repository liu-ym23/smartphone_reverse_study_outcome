package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.config.bi1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatButtonView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatButtonView$d;", "listener", "", "setButtonClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "d", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatButtonView extends FrameLayout {
    public static final /* synthetic */ int e = 0;
    public d a;
    public u0 b;
    public final TextView c;
    public final TextView d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VoiceChatButtonView a;

        public a(VoiceChatButtonView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            final VoiceChatButtonView r0 = this.a;
            MutablePropertyReference0Impl r5 = new VoiceChatButtonView$1$1(r0);
            u0 r1 = u0.f;
            if (t0.a(r5, new u0(500)) == true) goto L5;
            return;
        L5:
            d r6 = this.a.a;
            if (r6 == null) goto L9;
            r6.b();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VoiceChatButtonView a;

        public b(VoiceChatButtonView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            final VoiceChatButtonView r0 = this.a;
            MutablePropertyReference0Impl r5 = new VoiceChatButtonView$2$1(r0);
            u0 r1 = u0.f;
            if (t0.a(r5, new u0(500)) == true) goto L5;
            return;
        L5:
            d r6 = this.a.a;
            if (r6 == null) goto L9;
            r6.a();
            return;
        }
    }

    public static final class c {
    }

    public interface d {
        void a();

        void b();
    }

    public static final class e implements Animator.AnimatorListener {
        public final /* synthetic */ View a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        public e(View r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            UtilityKotlinExtentionsKt.w(this.a);
        }
    }

    public static final class f implements Animator.AnimatorListener {
        public final /* synthetic */ View a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        public f(View r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            ViewUtilsKt.e(this.a);
        }
    }

    static {
    }

    public VoiceChatButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceChatButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setButtonClickListener(d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    public final Animator a(boolean r10, long r12) {
        Float r1 = Float.valueOf(1.0f);
        Object r3 = Float.valueOf(0.0f);
        if (r10 == false) goto L12;
        PathInterpolator r13 = new PathInterpolator(0.76f, 0.0f, 0.24f, 1.0f);
        Property r0 = View.ALPHA;
        float[] r2 = new float[2];
        Boolean r6 = Boolean.TRUE;
        Object r7 = bi1.a(r6, r3);
        if (r7 != null) goto L7;
        r7 = r1;
    L7:
        r2[0] = ((Number) r7).floatValue();
        Object r4 = bi1.a(r6, r1);
        if (r4 == null) goto L11;
        r3 = r4;
    L11:
        r2[1] = ((Number) r3).floatValue();
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this, r0, r2);
        r5.setDuration(417);
        r5.setStartDelay(r12);
        r5.setInterpolator(r13);
        r5.addListener(new e(this));
        return r5;
    L12:
        PathInterpolator r14 = new PathInterpolator(0.5f, 0.0f, 0.5f, 1.0f);
        Property r8 = View.ALPHA;
        float[] r9 = new float[2];
        Boolean r15 = Boolean.FALSE;
        Object r16 = bi1.a(r15, r3);
        if (r16 != null) goto L15;
        r16 = r1;
    L15:
        r9[0] = ((Number) r16).floatValue();
        Object r17 = bi1.a(r15, r1);
        if (r17 == null) goto L19;
        r3 = r17;
    L19:
        r9[1] = ((Number) r3).floatValue();
        ObjectAnimator r18 = ObjectAnimator.ofFloat(this, r8, r9);
        r18.setDuration(383);
        r18.setStartDelay(r12);
        r18.setInterpolator(r14);
        r18.addListener(new f(this));
        return r18;
    }

    public VoiceChatButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        u0 r5 = u0.f;
        this.b = u0.f;
        LayoutInflater.from(r2).inflate(2131566023, this);
        this.c = (TextView) findViewById(2131392684);
        this.d = (TextView) findViewById(2131392703);
        View r6 = findViewById(2131392687);
        if (r6 == null) goto L5;
        r6.setOnClickListener(new a(this));
    L5:
        ConstraintLayout r7 = (VoiceChatStartButton) findViewById(2131392682);
        if (r7 == null) goto L9;
        r7.setOnClickListener(new b(this));
        return;
    }

    public /* synthetic */ VoiceChatButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
