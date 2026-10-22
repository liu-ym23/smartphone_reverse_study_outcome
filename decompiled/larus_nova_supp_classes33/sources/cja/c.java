package cja;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements a<Integer> {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    @Override // cja.a
    public final boolean a(long r2, long r4, gja.a<Integer> r6) {
        Intrinsics.checkNotNullParameter(r6, "spec");
        return r6.a(r2, r4);
    }

    @Override // cja.a
    public final Integer b(long r8, Integer r10, Integer r11, float r12, gja.a<Integer> r13) {
        int r14 = r10.intValue();
        int r15 = r11.intValue();
        Intrinsics.checkNotNullParameter(r13, "spec");
        return r13.c(r8, Integer.valueOf(r14), Integer.valueOf(r15), r12);
    }

    @Override // cja.a
    public final float c(long r8, Integer r10, Integer r11, float r12, gja.a<Integer> r13) {
        int r14 = r10.intValue();
        int r15 = r11.intValue();
        Intrinsics.checkNotNullParameter(r13, "spec");
        return r13.d(r8, Integer.valueOf(r14), Integer.valueOf(r15), r12);
    }
}
