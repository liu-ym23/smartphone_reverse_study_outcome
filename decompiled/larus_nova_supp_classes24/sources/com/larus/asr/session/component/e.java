package com.larus.asr.session.component;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Function0<String> e;
    public final Function1<k0, Long> f;

    public e(boolean r5, boolean r6, Function0 r7, com.larus.asr.session.p0 r8, int r9) {
        boolean r1 = false;
        if ((r9 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r9 & 2) == 0) goto L8;
        boolean r0 = true;
    L10:
        if ((r9 & 4) == 0) goto L13;
        r6 = false;
    L13:
        if ((r9 & 8) == 0) goto L16;
        r1 = true;
    L16:
        if ((r9 & 16) == 0) goto L18;
        r7 = d.a;
    L18:
        Function1<k0, Long> r10 = r8;
        if ((r9 & 32) == 0) goto L21;
        r10 = new c();
    L21:
        Intrinsics.checkNotNullParameter(r7, "bizSceneProvider");
        Intrinsics.checkNotNullParameter(r10, "startTimeProvider");
        this.a = r5;
        this.b = r0;
        this.c = r6;
        this.d = r1;
        this.e = r7;
        this.f = r10;
        return;
    L8:
        r0 = false;
        goto L10
    }
}
