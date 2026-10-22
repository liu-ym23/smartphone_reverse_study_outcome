package kotlinx.coroutines;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n0 implements h {
    public final m0 a;

    public final String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }

    public n0(m0 r1) {
        this.a = r1;
    }

    public final void a(Throwable r1) {
        this.a.dispose();
    }
}
