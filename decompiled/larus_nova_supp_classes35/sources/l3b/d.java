package l3b;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.blueprint.s;
import com.ss.android.lark.blueprint.t;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final BubbleStyle a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        return null;
    L9:
        k3b.a r3 = b(r2);
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.e();
    L5:
        r0 = false;
        goto L7
    }

    public static final k3b.a b(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int r2 = 0;
        if (r6.getVisibility() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        return null;
    L9:
        int r3 = r6.getChildCount();
    L10:
        if (r2 >= r3) goto L29;
        View r4 = r6.getChildAt(r2);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Object r5 = r4.getTag(2131364308);
        if ((r5 instanceof k) == false) goto L14;
        k r7 = (k) r5;
    L16:
        if ((r7 instanceof t) == false) goto L18;
        t r8 = (t) r7;
    L19:
        if (r8 == null) goto L21;
        s r9 = r8.a();
    L23:
        if ((r9 instanceof k3b.a) == false) goto L25;
        k3b.a r10 = (k3b.a) r9;
    L26:
        if (r10 != null) goto L28;
        r2 = r2 + 1;
        goto L10
    L28:
        return r10;
    L25:
        r10 = null;
        goto L26
    L21:
        r9 = null;
        goto L23
    L18:
        r8 = null;
        goto L19
    L14:
        r7 = null;
        goto L16
    L29:
        return null;
    L5:
        r1 = false;
        goto L7
    }

    public static final u5b.c c(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
        return null;
    L9:
        k3b.a r3 = b(r2);
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.d();
    L5:
        r0 = false;
        goto L7
    }

    public static final boolean e(y6b.a<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Object r3 = r2.b();
        if ((r3 instanceof f) == false) goto L5;
        f r4 = (f) r3;
    L6:
        if (r4 != null) goto L8;
    L12:
        return false;
    L8:
        if (r4.f != 3) goto L12;
        if (r4.g == null) goto L12;
        return true;
    L5:
        r4 = null;
        goto L6
    }

    public static final void d(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r2 == false) goto L5;
        int r3 = -1;
    L6:
        r0.width = r3;
        r1.setLayoutParams(r0);
        return;
    L5:
        r3 = -2;
        goto L6
    }
}
