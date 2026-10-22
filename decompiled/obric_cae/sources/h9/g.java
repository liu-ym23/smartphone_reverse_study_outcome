package h9;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n.h<String, h> f7955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.h<String, PropertyValuesHolder[]> f7956b;

    public g() {
        this.f7955a = new n.h();
        this.f7956b = new n.h();
    }

    public static g a(Context r8, int r10) {
        Animator r11 = AnimatorInflater.loadAnimator(r8, r10);     // Catch: Exception -> L11
        if ((r11 instanceof AnimatorSet) == true) goto L6;
        if (r11 == null) goto L10;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L11
        r12.add(r11);     // Catch: Exception -> L11
        return b(r12);
    L10:
        return null;
    L6:
        return b(((AnimatorSet) r11).getChildAnimations());
    L11:
        e = move-exception;
        Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(r10), e);
        return null;
    }

    public static g b(ArrayList r12) {
        g r8 = new g();
        int r10 = r12.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L20;
        Animator r13 = (Animator) r12.get(r11);
        if ((r13 instanceof ObjectAnimator) == false) goto L19;
        ObjectAnimator r14 = (ObjectAnimator) r13;
        r8.f7956b.put(r14.getPropertyName(), r14.getValues());
        String r15 = r14.getPropertyName();
        long r16 = r14.getStartDelay();
        long r17 = r14.getDuration();
        TimeInterpolator r18 = r14.getInterpolator();
        if ((r18 instanceof AccelerateDecelerateInterpolator) == true) goto L16;
        if (r18 == null) goto L16;
        if ((r18 instanceof AccelerateInterpolator) == false) goto L14;
        r18 = a.f7945c;
    L17:
        h r19 = new h(r16, r17, r18);
        r19.f7960d = r14.getRepeatCount();
        r19.f7961e = r14.getRepeatMode();
        r8.f7955a.put(r15, r19);
        r11 = r11 + 1;
        goto L3
    L14:
        if ((r18 instanceof DecelerateInterpolator) == false) goto L17;
        r18 = a.f7946d;
    L16:
        r18 = a.f7944b;
        goto L17
    L19:
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + r13);
    L20:
        return r8;
    }

    public final h c(String r8) {
        n.h<String, h> r10 = this.f7955a;
        if (r10.getOrDefault(r8, null) == null) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L10;
        return r10.getOrDefault(r8, null);
    L10:
        throw new IllegalArgumentException();
    L5:
        r11 = false;
        goto L6
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L10;
        return false;
    L10:
        return this.f7955a.equals(((g) r8).f7955a);
    }

    public final int hashCode() {
        return this.f7955a.hashCode();
    }

    public final String toString() {
        return "\n" + g.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f7955a + "}\n";
    }
}
