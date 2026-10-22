package d19;

import android.animation.Animator;
import com.larus.common_ui.edgeeffect.ScreenEdgeEffectGLView;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.continue_talk.f2;
import com.larus.voicecall.impl.continue_talk.g2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l implements Animator.AnimatorListener {
    public final /* synthetic */ ScreenEdgeEffectGLView a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function1 c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r4) {
        FLogger.a.i("ScreenEdgeEffectGLView", "hideScreenEdgeEffect onCancel");
        this.a.c();
        this.a.destroy();
        this.a.post(new k(this.c, r4));
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        FLogger.a.i("ScreenEdgeEffectGLView", "hideScreenEdgeEffect onEnd");
        this.a.c();
        this.a.destroy();
        this.a.post(new j(this.b, r4));
    }

    public l(ScreenEdgeEffectGLView r1, f2 r2, g2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
