package cja;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b implements a<Float> {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    @Override // cja.a
    public final boolean a(long r2, long r4, gja.a<Float> r6) {
        Intrinsics.checkNotNullParameter(r6, "spec");
        return r6.a(r2, r4);
    }

    @Override // cja.a
    public final Float b(long r8, Float r10, Float r11, float r12, gja.a<Float> r13) {
        float r14 = r10.floatValue();
        float r15 = r11.floatValue();
        Intrinsics.checkNotNullParameter(r13, "spec");
        return r13.c(r8, Float.valueOf(r14), Float.valueOf(r15), r12);
    }

    @Override // cja.a
    public final float c(long r8, Float r10, Float r11, float r12, gja.a<Float> r13) {
        float r14 = r10.floatValue();
        float r15 = r11.floatValue();
        Intrinsics.checkNotNullParameter(r13, "spec");
        return r13.d(r8, Float.valueOf(r14), Float.valueOf(r15), r12);
    }
}
