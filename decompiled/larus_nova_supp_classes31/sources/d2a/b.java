package d2a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final void a(Function1 r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r9, "callback");
        d r0 = new d();
        r9.invoke(r0);
        AnimatorSet r10 = new AnimatorSet();
        int r1 = r0.a.size();
        if (r1 <= 0) goto L21;
        ArrayList r2 = new ArrayList();
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L20;
        List<Animator> r5 = r0.a.valueAt(r4);
        int r6 = r0.a.keyAt(r4);
        List<Animator> r7 = r5;
        if (r7 != null) goto L9;
    L12:
        boolean r8 = true;
    L13:
        if (r8 == true) goto L19;
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(r7);
        r2.add(r11);
        final List<Animator> r12 = r0.b.get(r6);
        if (r12 != null) goto L18;
        r12 = CollectionsKt.emptyList();
    L18:
        r0.b.remove(r6);
        g.b(r11, new c(r12), null, null, 14);
    L19:
        r4 = r4 + 1;
        goto L5
    L9:
        if (r7.isEmpty() == true) goto L12;
        r8 = false;
        goto L13
    L20:
        r10.playSequentially(r2);
    L21:
        r10.start();
    }
}
