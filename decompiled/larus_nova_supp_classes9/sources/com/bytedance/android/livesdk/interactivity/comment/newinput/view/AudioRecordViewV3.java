package com.bytedance.android.livesdk.interactivity.comment.newinput.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3$c;", "a", "Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3$c;", "getFinishListener", "()Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3$c;", "setFinishListener", "(Lcom/bytedance/android/livesdk/interactivity/comment/newinput/view/AudioRecordViewV3$c;)V", "finishListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BuildConfig.FLAVOR, "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioRecordViewV3 extends FrameLayout {
    public c a;
    public final ConstraintLayout b;
    public final AudioWaveViewV3 c;
    public final ConstraintLayout d;
    public final ConstraintLayout e;
    public final LottieAnimationView f;
    public int g;
    public boolean h;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ AudioRecordViewV3 a;

        public a(AudioRecordViewV3 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            c r3 = this.a.getFinishListener();
            if (r3 == null) goto L6;
            r3.a();
            return;
        }
    }

    public static final class b {
    }

    public interface c {
        void a();
    }

    static {
    }

    public final void b() {
        this.g = 0;
        this.c.c();
        this.f.pauseAnimation();
    }

    public final c getFinishListener() {
        return this.a;
    }

    public AudioRecordViewV3(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setFinishListener(c r1) {
        this.a = r1;
    }

    public AudioRecordViewV3(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public static void a(ConstraintLayout r5, ConstraintLayout r6) {
        ObjectAnimator r7 = ObjectAnimator.ofFloat(r6, "alpha", new float[]{1.0f, 0.0f});
        r7.setDuration(150);
        r7.start();
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{0.0f, 1.0f});
        r8.setDuration(150);
        r8.setStartDelay(100);
        r8.start();
    }

    public final void c(int r5, boolean r6) {
        int r0 = this.g;
        if (r5 != r0) goto L6;
        return;
    L6:
        if (r5 == 1) goto L30;
        if (r5 == 2) goto L17;
        if (r5 != 3) goto L34;
        if (r0 != 1) goto L14;
        if (r6 == false) goto L14;
        a(this.d, this.b);
    L14:
        if (r0 != 2) goto L34;
        if (r6 == false) goto L34;
        a(this.d, this.e);
    L34:
        if (r6 == false) goto L37;
        this.g = r5;
        return;
    L37:
        return;
    L17:
        if (r0 == 1) goto L19;
        if (r0 != 3) goto L34;
        if (this.h == true) goto L27;
        this.h = true;
        this.f.playAnimation();
    L27:
        if (r6 == false) goto L34;
        a(this.e, this.d);
        goto L34
    L19:
        if (this.h == true) goto L21;
        this.h = true;
        this.f.playAnimation();
    L21:
        if (r6 == false) goto L34;
        a(this.e, this.b);
        goto L34
    L30:
        if (this.h == true) goto L34;
        if (r0 != 3) goto L34;
        if (r6 == false) goto L34;
        a(this.b, this.d);
        goto L34
    }

    public AudioRecordViewV3(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131567641, this);
        setBackgroundResource(2131248676);
        ConstraintLayout r5 = findViewById(2131363515);
        this.b = r5;
        this.c = (AudioWaveViewV3) r5.findViewById(2131363517);
        this.d = findViewById(2131363415);
        this.e = findViewById(2131363422);
        LottieAnimationView r6 = findViewById(2131363424);
        this.f = r6;
        r6.addAnimatorListener(new a(this));
    }
}
