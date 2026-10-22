package com.bytedance.android.live.revlink.impl.lynxcontainer;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final void a(b r2, FrameLayout.LayoutParams r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "lynxViewParams");
        Intrinsics.checkNotNullParameter(r3, "lp");
        if (r2.q() <= 0) goto L5;
        int r6 = s1.f(r2.q());
    L7:
        if (r2.a() <= 0) goto L9;
        int r7 = s1.f(r2.a());
    L10:
        r3.width = r6;
        r3.height = r7;
        int r8 = r2.c();
        if (r8 == 2) goto L15;
        if (r8 == 3) goto L14;
        int r9 = 3;
    L16:
        int r1 = r2.p();
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L20;
        int r10 = 48;
    L22:
        r3.gravity = r9 | r10;
        r3.leftMargin = s1.f(r2.h());
        r3.topMargin = s1.f(r2.l());
        r3.rightMargin = s1.f(r2.j());
        r3.bottomMargin = s1.f(r2.f());
        return;
    L20:
        r10 = 80;
        goto L22
    L21:
        r10 = 16;
        goto L22
    L14:
        r9 = 5;
        goto L16
    L15:
        r9 = 1;
        goto L16
    L9:
        r7 = (int) (r2.b() * r5);
        goto L10
    L5:
        r6 = (int) (r2.r() * r4);
        goto L7
    }
}
