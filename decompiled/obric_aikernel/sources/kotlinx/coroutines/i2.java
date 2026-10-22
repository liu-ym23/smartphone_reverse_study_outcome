package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 implements b1, t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i2 f10525c = null;

    static {
        f10525c = new i2();
    }

    private i2() {
    }

    @Override // kotlinx.coroutines.t
    public boolean b(Throwable r10) {
        return false;
    }

    @Override // kotlinx.coroutines.b1
    public void dispose() {
    }

    @Override // kotlinx.coroutines.t
    public v1 getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
