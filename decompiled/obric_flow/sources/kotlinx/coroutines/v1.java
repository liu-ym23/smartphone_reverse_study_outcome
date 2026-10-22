package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 implements t0, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v1 f19027a = null;

    static {
        f19027a = new v1();
    }

    @Override // kotlinx.coroutines.o
    public final boolean a(Throwable r5) {
        return false;
    }

    @Override // kotlinx.coroutines.t0
    public final void dispose() {
    }

    @Override // kotlinx.coroutines.o
    public final Job getParent() {
        return null;
    }

    public final String toString() {
        return "NonDisposableHandle";
    }
}
