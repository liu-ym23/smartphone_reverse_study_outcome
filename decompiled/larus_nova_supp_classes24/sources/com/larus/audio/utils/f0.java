package com.larus.audio.utils;

import com.larus.utils.logger.LogLevel;
import f2a.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f0 implements m58.l {
    public final d a;

    public f0(d r2) {
        Intrinsics.checkNotNullParameter(r2, "logger");
        this.a = r2;
    }

    @Override // m58.l
    public final b a(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "what");
        if (r3 != 3) goto L5;
        d r5 = this.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "what");
        f2a.c r0 = new f2a.c(r5.a, LogLevel.DEBUG, r4);
    L16:
        return new b(r0);
    L5:
        if (r3 != 4) goto L7;
        r0 = this.a.b(r4);
        goto L16
    L7:
        if (r3 != 5) goto L9;
        r0 = this.a.c(r4);
        goto L16
    L9:
        if (r3 == 6) goto L11;
        d r6 = this.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r4, "what");
        r0 = new f2a.c(r6.a, LogLevel.DEBUG, r4);
        goto L16
    L11:
        r0 = this.a.a(r4);
        goto L16
    }
}
