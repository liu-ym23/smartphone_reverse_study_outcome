package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class AnimatorUtils {

    interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator r1);

        void onAnimationResume(Animator r1);
    }

    private AnimatorUtils() {
    }

    static void addPauseListener(Animator r2, AnimatorListenerAdapter r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r2.addPauseListener(r3);
        return;
    }

    static void pause(Animator r6) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        r6.pause();
        return;
    L5:
        ArrayList<Animator.AnimatorListener> r0 = r6.getListeners();
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L8:
        if (r1 >= r2) goto L18;
        Animator.AnimatorListener r3 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0.get(r1), Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AnimatorPauseListenerCompat.class) == false) goto L12;
        ((AnimatorPauseListenerCompat) ZeusTransformUtils.preCheckCast(r3, AnimatorPauseListenerCompat.class, "com.obric.memorydata.plugin")).onAnimationPause(r6);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }

    static void resume(Animator r6) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        r6.resume();
        return;
    L5:
        ArrayList<Animator.AnimatorListener> r0 = r6.getListeners();
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L8:
        if (r1 >= r2) goto L18;
        Animator.AnimatorListener r3 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0.get(r1), Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AnimatorPauseListenerCompat.class) == false) goto L12;
        ((AnimatorPauseListenerCompat) ZeusTransformUtils.preCheckCast(r3, AnimatorPauseListenerCompat.class, "com.obric.memorydata.plugin")).onAnimationResume(r6);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }
}
