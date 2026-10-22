package k8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10133a = null;

    static {
        f10133a = new c();
    }

    private c() {
    }

    @Override // k8.a
    public /* bridge */ /* synthetic */ Integer a(long r10, Integer r11, Integer r12, float r13, o8.a<Integer> r14) {
        return d(r10, r11.intValue(), r12.intValue(), r13, r14);
    }

    @Override // k8.a
    public /* bridge */ /* synthetic */ float b(long r10, Integer r11, Integer r12, float r13, o8.a<Integer> r14) {
        return e(r10, r11.intValue(), r12.intValue(), r13, r14);
    }

    @Override // k8.a
    public boolean c(long r10, long r11, o8.a<Integer> r12) {
        Intrinsics.checkNotNullParameter(r12, "spec");
        return r12.e(r10, r11);
    }

    public Integer d(long r10, int r11, int r12, float r13, o8.a<Integer> r14) {
        Intrinsics.checkNotNullParameter(r14, "spec");
        return r14.a(r10, Integer.valueOf(r11), Integer.valueOf(r12), r13);
    }

    public float e(long r10, int r11, int r12, float r13, o8.a<Integer> r14) {
        Intrinsics.checkNotNullParameter(r14, "spec");
        return r14.c(r10, Integer.valueOf(r11), Integer.valueOf(r12), r13);
    }
}
