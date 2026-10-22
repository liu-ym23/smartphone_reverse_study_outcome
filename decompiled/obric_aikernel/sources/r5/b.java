package r5;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {
    public static void a(@NonNull AnimatorSet r10, @NonNull List<Animator> r11) {
        int r12 = r11.size();
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        Animator r15 = r11.get(r14);
        r13 = Math.max(r13, r15.getStartDelay() + r15.getDuration());
        r14 = r14 + 1;
        goto L3
    L5:
        ValueAnimator r16 = ValueAnimator.ofInt(new int[]{0, 0});
        r16.setDuration(r13);
        r11.add(0, r16);
        r10.playTogether(r11);
    }
}
