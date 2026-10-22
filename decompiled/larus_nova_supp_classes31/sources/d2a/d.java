package d2a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public final SparseArray<List<Animator>> a;
    public final SparseArray<List<Animator>> b;

    public d() {
        this.a = new SparseArray();
        this.b = new SparseArray();
    }

    public final void a(View r5, Function1<? super k, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "callback");
        a r0 = new a(r5);
        r6.invoke(r0);
        Animator r7 = r0.a;
        if (r7 != null) goto L5;
        r7 = r0.h;
    L5:
        r7.setStartDelay(0);
        r7.setDuration(r0.b);
        r7.setInterpolator(r0.c);
        if ((r7 instanceof ValueAnimator) == false) goto L8;
        ValueAnimator r8 = (ValueAnimator) r7;
        r8.setRepeatCount(0);
        r8.setRepeatMode(1);
    L8:
        g.a(r7, r0.d, r0.e, r0.f, r0.g);
        SparseArray<List<Animator>> r9 = this.a;
        List<Animator> r1 = r9.get(0);
        if (r1 != null) goto L12;
        r1 = new ArrayList();
        r9.put(0, r1);
    L12:
        r1.add(r7);
    }
}
