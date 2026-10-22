package pla;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final boolean d(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void e(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setVisibility(8);
    }

    public static final void f(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setVisibility(0);
    }

    public static final void g(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getParent() != null) goto L5;
        return;
    L5:
        if ((r1.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r0 = r1.getParent();
        if (r0 == null) goto L10;
        ((ViewGroup) r0).removeView(r1);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final void a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        b(r1, r2, r2, false);
    }

    public static final void h(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        f(r1);
        return;
    L5:
        e(r1);
    }

    public static final void b(final View r8, final int r9, final int r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (r8.getParent() == null) goto L9;
        ViewParent r0 = r8.getParent();
        if (r0 == null) goto L8;
        ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        final ViewGroup r6 = r1;
        r1.post(new h(r8, r9, r10, r11, r6));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r1 = null;
        goto L10
    }

    public static final void c(final View r7, final int r8, final int r9, final View... r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r10, "views");
        final g r4 = new g(r7);
        r7.post(new i(r10, r7, r4, r8, r9));
    }
}
