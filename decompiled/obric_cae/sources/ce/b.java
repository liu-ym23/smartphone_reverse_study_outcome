package ce;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ae.d<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3444a = null;

    static {
        f3444a = new b();
    }

    @Override // ae.d
    public final ae.f getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // ae.d
    public final void resumeWith(Object r8) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
