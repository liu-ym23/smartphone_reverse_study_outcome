package id;

import b3.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends m {
    public final long f(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "start");
        Intrinsics.checkNotNullParameter(r10, "end");
        long r11 = d(r5);
        long r12 = d(r10);
        if (r11 != (-1)) goto L5;
        return 0;
    L5:
        if (r12 != (-1)) goto L8;
        return 0;
    L8:
        return r12 - r11;
    }
}
