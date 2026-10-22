package k8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10132a = null;

    static {
        f10132a = new b();
    }

    private b() {
    }

    @Override // k8.a
    public /* bridge */ /* synthetic */ Float a(long r10, Float r11, Float r12, float r13, o8.a<Float> r14) {
        return d(r10, r11.floatValue(), r12.floatValue(), r13, r14);
    }

    @Override // k8.a
    public /* bridge */ /* synthetic */ float b(long r10, Float r11, Float r12, float r13, o8.a<Float> r14) {
        return e(r10, r11.floatValue(), r12.floatValue(), r13, r14);
    }

    @Override // k8.a
    public boolean c(long r10, long r11, o8.a<Float> r12) {
        Intrinsics.checkNotNullParameter(r12, "spec");
        return r12.e(r10, r11);
    }

    public Float d(long r10, float r11, float r12, float r13, o8.a<Float> r14) {
        Intrinsics.checkNotNullParameter(r14, "spec");
        return r14.a(r10, Float.valueOf(r11), Float.valueOf(r12), r13);
    }

    public float e(long r10, float r11, float r12, float r13, o8.a<Float> r14) {
        Intrinsics.checkNotNullParameter(r14, "spec");
        return r14.c(r10, Float.valueOf(r11), Float.valueOf(r12), r13);
    }
}
