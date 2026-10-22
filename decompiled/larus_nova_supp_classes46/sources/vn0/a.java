package vn0;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements qj0.a {
    public final ViewGroup a;

    public a(ViewGroup r1) {
        this.a = r1;
    }

    @Override // qj0.a
    public final boolean a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        ViewGroup r0 = this.a;
        if (r0 == null) goto L5;
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131363436);
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.indexOfChild(r4) != (-1)) goto L10;
        r1.addView(r4);
        return true;
    L5:
        r1 = null;
        goto L6
    }

    @Override // qj0.a
    public final boolean b(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        ViewGroup r0 = this.a;
        if (r0 == null) goto L5;
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131363436);
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.indexOfChild(r4) == (-1)) goto L10;
        r1.removeView(r4);
        return true;
    L5:
        r1 = null;
        goto L6
    }
}
