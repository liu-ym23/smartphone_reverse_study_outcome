package ai;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bi.e f290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f291b;

    public q0(bi.e r5, Object r10) {
        this.f290a = r5;
        this.f291b = r10;
    }

    public static q0 a(bi.e r5, Object r10) {
        if (r5.w() == false) goto L7;
        return new q0(r5, r10);
    L7:
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
