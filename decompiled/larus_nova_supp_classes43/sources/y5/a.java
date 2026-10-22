package y5;

import android.animation.Animator;
import com.bytedance.ai.view.popup.anim.AnimController;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Animator.AnimatorListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ Ref.ObjectRef<String> b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.a.c.a(AnimController.AnimProcessType.DONE, false, null);
        Function0<Unit> r11 = this.c;
        if (r11 == null) goto L6;
        r11.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.a.c.a(AnimController.AnimProcessType.DONE, false, null);
        Function0<Unit> r11 = this.c;
        if (r11 == null) goto L6;
        r11.invoke();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "animation");
        this.a.c.a(AnimController.AnimProcessType.DOING, false, (String) this.b.element);
    }

    public a(b r1, Ref.ObjectRef r10, com.bytedance.ai.view.popup.a r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
