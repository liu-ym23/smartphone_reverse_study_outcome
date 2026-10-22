package d2a;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final e a = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [d2a.e] */
    static {
        a = new e();
    }

    public static final void c(Animator r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "callback");
        b(r2, null, r3, null, 13);
    }

    public static final f a(Animator r7, Function1 r8, Function1 r9, Function1 r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "onStart");
        Intrinsics.checkNotNullParameter(r9, "onEnd");
        Intrinsics.checkNotNullParameter(r10, "onCancel");
        Intrinsics.checkNotNullParameter(r11, "onRepeat");
        f r0 = new f(r11, r7, r9, r10, r8);
        r7.addListener(r0);
        return r0;
    }

    public static /* synthetic */ f b(Animator r2, Function1 r3, Function1 r4, Function1 r5, int r6) {
        int r0 = r6 & 1;
        e r1 = a;
        if (r0 == 0) goto L6;
        r3 = r1;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = r1;
    L9:
        if ((r6 & 4) == 0) goto L11;
        e r7 = r1;
    L13:
        if ((r6 & 8) == 0) goto L16;
        r5 = r1;
    L16:
        return a(r2, r3, r4, r7, r5);
    L11:
        r7 = null;
        goto L13
    }
}
