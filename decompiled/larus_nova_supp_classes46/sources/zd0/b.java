package zd0;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements yd0.c<c> {
    public final ViewGroup a;

    public b(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        this.a = r2;
    }

    @Override // yd0.c
    public final void a(yd0.b r2) {
        c r3 = (c) r2;
        Intrinsics.checkNotNullParameter(r3, "bgView");
        this.a.removeView(r3.a);
    }

    @Override // yd0.c
    public final void b(yd0.b r3) {
        c r4 = (c) r3;
        Intrinsics.checkNotNullParameter(r4, "bgView");
        ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-1, -1);
        r4.a.setLayoutParams(r0);
        this.a.addView(r4.a, r0);
    }

    @Override // yd0.b
    public final void setVisible(boolean r2) {
        ViewGroup r0 = this.a;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }
}
