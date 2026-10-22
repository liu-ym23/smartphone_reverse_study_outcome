package vcb;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements b {
    public final t6c.d a;

    @Override // vcb.b
    public final void a() {
        t6c.d r0 = this.a;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L7;
        View r2 = r0.i;
        if (r2 == null) goto L7;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L8:
        t6c.d r4 = this.a;
        if (r4 == null) goto L13;
        q6c.c r5 = r4.a;
        if (r5 == null) goto L13;
        s6c.a r6 = r5.c();
    L14:
        if (r6 == null) goto L18;
        t6c.d r7 = this.a;
        if (r7 == null) goto L18;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r7.f = r6;
    L18:
        t6c.d r8 = this.a;
        if (r8 == null) goto L21;
        r8.c();
    L21:
        t6c.d r9 = this.a;
        if (r9 == null) goto L24;
        r9.f();
    L24:
        t6c.d r10 = this.a;
        if (r10 == null) goto L29;
        View r11 = r10.i;
        if (r11 == null) goto L29;
        r1 = r11.getLayoutParams();
    L29:
        if (r3 == null) goto L39;
        if (r1 != null) goto L32;
        return;
    L32:
        if (Intrinsics.areEqual(r3, r1) == true) goto L41;
        r3.width = r1.width;
        r3.height = r1.height;
        t6c.d r12 = this.a;
        if (r12 == null) goto L42;
        View r13 = r12.i;
        if (r13 == null) goto L43;
        r13.setLayoutParams(r3);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L39:
        return;
    L13:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public c(t6c.d r1) {
        this.a = r1;
    }
}
