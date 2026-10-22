package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class AnimatorUtils {

    interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator r10);

        void onAnimationResume(Animator r10);
    }

    private AnimatorUtils() {
    }

    static void addPauseListener(@NonNull Animator r10, @NonNull AnimatorListenerAdapter r11) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r10.addPauseListener(r11);
        return;
    }

    static void pause(@NonNull Animator r10) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        r10.pause();
        return;
    L5:
        ArrayList<Animator.AnimatorListener> r11 = r10.getListeners();
        if (r11 == null) goto L17;
        int r12 = 0;
        int r13 = r11.size();
    L8:
        if (r12 >= r13) goto L18;
        Animator.AnimatorListener r14 = r11.get(r12);
        if ((r14 instanceof AnimatorPauseListenerCompat) == false) goto L12;
        ((AnimatorPauseListenerCompat) r14).onAnimationPause(r10);
    L12:
        r12 = r12 + 1;
        goto L8
    L18:
        return;
    }

    static void resume(@NonNull Animator r10) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        r10.resume();
        return;
    L5:
        ArrayList<Animator.AnimatorListener> r11 = r10.getListeners();
        if (r11 == null) goto L17;
        int r12 = 0;
        int r13 = r11.size();
    L8:
        if (r12 >= r13) goto L18;
        Animator.AnimatorListener r14 = r11.get(r12);
        if ((r14 instanceof AnimatorPauseListenerCompat) == false) goto L12;
        ((AnimatorPauseListenerCompat) r14).onAnimationResume(r10);
    L12:
        r12 = r12 + 1;
        goto L8
    L18:
        return;
    }
}
