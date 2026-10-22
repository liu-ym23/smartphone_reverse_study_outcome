package fd0;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.liveinteract.animator.LiveAnimator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final LiveAnimator a;
    public final View[] b;
    public final List<Animator> c;

    public final void a() {
        c("alpha", new float[]{0.0f, 0.25f, 0.5f, 0.75f, 1.0f});
    }

    public final void b() {
        c("alpha", new float[]{1.0f, 0.75f, 0.5f, 0.25f, 0.0f});
    }

    public final LiveAnimator e() {
        this.a.c();
        return this.a;
    }

    public final void d(float... r2) {
        c("scaleX", r2);
        c("scaleY", r2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [fd0.d] */
    public final void f(float... r8) {
        ?? r0 = new d();
        View[] r1 = this.b;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        View r4 = r1[r3];
        ValueAnimator r5 = ValueAnimator.ofFloat(r8);
        r5.addUpdateListener(new e(r0, r4));
        ((ArrayList) this.c).add(r5);
        r3 = r3 + 1;
        goto L3
    }

    public f(LiveAnimator r2, View... r3) {
        this.c = new ArrayList();
        this.a = r2;
        this.b = r3;
    }

    public final void c(String r6, float... r7) {
        View[] r0 = this.b;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        View r3 = r0[r2];
        List<Animator> r4 = this.c;
        ArrayList r5 = (ArrayList) r4;
        r5.add(ObjectAnimator.ofFloat(r3, r6, r7));
        r2 = r2 + 1;
        goto L3
    }
}
