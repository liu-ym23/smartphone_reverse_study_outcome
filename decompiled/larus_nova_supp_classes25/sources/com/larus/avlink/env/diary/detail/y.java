package com.larus.avlink.env.diary.detail;

import com.skydoves.balloon.Balloon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y implements st8.c {
    public final /* synthetic */ w a;

    public y(w r1) {
        this.a = r1;
    }

    public final void a(ut8.i r2, boolean r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "selector");
        boolean r6 = false;
        if (r3 == false) goto L14;
        w r7 = this.a;
        Balloon r8 = r7.d;
        if (r8 != null) goto L7;
    L10:
        r7.e = true;
        if (r8 == null) goto L13;
        r8.h();
    L13:
        this.a.d = null;
        return;
    L7:
        if (r8.g != true) goto L9;
        r6 = true;
    L9:
        if (r6 == true) goto L10;
        return;
    L14:
        w r9 = this.a;
        if (r9.e == false) goto L20;
        r9.f = false;
        r9.g = true;
        r9.c(r2.getContext());
        this.a.d();
        this.a.e = false;
        return;
    }
}
