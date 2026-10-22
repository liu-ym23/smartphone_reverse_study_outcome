package rjb;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static final /* synthetic */ int b = 0;
    public final b a;

    public static final class a {
    }

    static {
    }

    public final Rect d() {
        return this.a.b();
    }

    public final int e() {
        int r0 = this.a.c();
        if (r0 != 1) goto L5;
        return 3;
    L5:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L8;
        return 5;
    L8:
        if (r0 == 4) goto L10;
        return 0;
    L10:
        return 80;
    L12:
        return 48;
    }

    public h(b r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        this.a = r2;
    }

    public final Point a(LinearLayout r7, Size r8, Rect r9) {
        Intrinsics.checkNotNullParameter(r7, "containerView");
        Intrinsics.checkNotNullParameter(r8, "containerWH");
        Intrinsics.checkNotNullParameter(r9, "anchorRect");
        int r0 = this.a.c();
        this.a.f();
        int r1 = this.a.e(r7, r8, r9);
        int r10 = this.a.g(r7, r8, r9);
        Point r2 = new Point();
        if (r0 != 1) goto L5;
        int r3 = c(r9, r1, r8, 32);
        r2.x = (r9.left - r8.getWidth()) - r10;
        r2.y = r3;
    L18:
        return r2;
    L5:
        if (r0 != 2) goto L7;
        r2.x = b(r9, r1, r8, 32);
        r2.y = (r9.top - r8.getHeight()) - r10;
        goto L18
    L7:
        if (r0 != 3) goto L9;
        int r11 = c(r9, r1, r8, 32);
        r2.x = r9.right + r10;
        r2.y = r11;
        goto L18
    L9:
        if (r0 != 4) goto L11;
        r2.x = b(r9, r1, r8, 32);
        r2.y = r9.bottom + r10;
        goto L18
    L11:
        if (r0 == 5) goto L13;
        Point r12 = new Point();
        r12.x = (r9.left + r9.right) / 2;
        r12.y = (r9.top + r9.bottom) / 2;
        goto L18
    L13:
        r2.x = ((r9.left + r9.right) / 2) + r1;
        r2.y = ((r9.top + r9.bottom) / 2) + r10;
        goto L18
    }

    public final void f(LinearLayout r2, Size r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "containerView");
        Intrinsics.checkNotNullParameter(r3, "containerWH");
        this.a.d(r2, r3, r4);
    }

    public final void g(Context r2, LinearLayout r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "guide");
        this.a.a(r2, r3, r4);
    }

    public static final int b(Rect r1, int r2, Size r3, int r4) {
        if (r4 != 16) goto L5;
        int r5 = r1.left;
    L13:
        return r5 + r2;
    L5:
        if (r4 != 32) goto L7;
        int r6 = r1.left;
        r2 = r2 + r6;
        r5 = ((r1.right - r6) - r3.getWidth()) / 2;
        goto L13
    L7:
        if (r4 == 48) goto L9;
        r5 = r1.left;
        goto L13
    L9:
        int r7 = r1.left;
        r2 = r2 + r7;
        r5 = (r1.right - r7) - r3.getWidth();
        goto L13
    }

    public static final int c(Rect r1, int r2, Size r3, int r4) {
        if (r4 != 16) goto L5;
        int r5 = r1.top;
    L13:
        return r5 + r2;
    L5:
        if (r4 != 32) goto L7;
        int r6 = r1.top;
        r2 = r2 + r6;
        r5 = ((r1.bottom - r6) - r3.getHeight()) / 2;
        goto L13
    L7:
        if (r4 == 48) goto L9;
        r5 = r1.top;
        goto L13
    L9:
        int r7 = r1.top;
        r2 = r2 + r7;
        r5 = (r1.bottom - r7) - r3.getHeight();
        goto L13
    }
}
