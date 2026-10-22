package com.obric.assistant.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.larus.utils.e1;
import com.obric.assistant.view.continuespeech.AudioContinueGradientView;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\b\u0010 \u001a\u00020\u0018H\u0014J\u001e\u0010!\u001a\u00020\u00182\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%R\u001b\u0010\n\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/assistant/view/LongPressMockView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mockView", "getMockView", "()Landroid/widget/FrameLayout;", "mockView$delegate", "Lkotlin/Lazy;", "loadingView", "getLoadingView", "loadingView$delegate", "voiceView", "Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "getVoiceView", "()Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "voiceView$delegate", "startShortPress", "", "updateBg", "isChatWindow", "", "panelShown", "onLongPress", "startLongPress", "stopLongPress", "onDetachedFromWindow", "setAudioData", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LongPressMockView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ LongPressMockView a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public b(LongPressMockView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            LongPressMockView r3 = this.a;
            int r0 = LongPressMockView.d;
            r3.getClass();
        }
    }

    static {
    }

    public LongPressMockView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LongPressMockView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final FrameLayout getLoadingView() {
        return (FrameLayout) this.b.getValue();
    }

    private final FrameLayout getMockView() {
        return (FrameLayout) this.a.getValue();
    }

    private final AudioContinueGradientView getVoiceView() {
        return (AudioContinueGradientView) this.c.getValue();
    }

    public final void a() {
        ViewPropertyAnimator r0 = getLoadingView().animate();
        r0.setDuration(300);
        r0.alpha(0.0f);
        r0.setListener(new b(this));
        r0.start();
    }

    public final void b() {
        getVoiceView().a();
        e1.x(getMockView());
        e1.x(getLoadingView());
        e1.x(getVoiceView());
        getLoadingView().setAlpha(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMockView().animate().cancel();
        getVoiceView().animate().cancel();
        getLoadingView().animate().cancel();
    }

    public final void setAudioData(ArrayList<Double> r2) {
        Intrinsics.checkNotNullParameter(r2, "sampleData");
        getVoiceView().setAudioData(r2);
    }

    public final void c(boolean r7, boolean r8) {
        FrameLayout r0 = getLoadingView();
        int r1 = 2131232047;
        if (r7 == false) goto L7;
        if (r8 == false) goto L6;
        int r5 = 2131232047;
    L10:
        r0.setBackgroundResource(r5);
        FrameLayout r2 = getMockView();
        if (r7 == false) goto L15;
        if (r8 == true) goto L18;
        r1 = 2131232046;
    L18:
        r2.setBackgroundResource(r1);
        return;
    L15:
        if (r8 == false) goto L17;
        r1 = 2131232049;
        goto L18
    L17:
        r1 = 2131232048;
        goto L18
    L6:
        r5 = 2131232046;
        goto L10
    L7:
        if (r8 == false) goto L9;
        r5 = 2131232049;
        goto L10
    L9:
        r5 = 2131232048;
        goto L10
    }

    public LongPressMockView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new com.obric.assistant.view.b(r2));
        this.b = LazyKt.lazy(new c(r2));
        this.c = LazyKt.lazy(new d(r2));
        addView(getMockView(), new FrameLayout.LayoutParams(-1, -1));
        addView(getLoadingView(), new FrameLayout.LayoutParams(-1, -1));
        AudioContinueGradientView r5 = getVoiceView();
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -1);
        r6.gravity = 17;
        Unit r7 = Unit.INSTANCE;
        addView(r5, r6);
    }

    public /* synthetic */ LongPressMockView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
