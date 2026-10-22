package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g2 extends CoroutineDispatcher {
    public g2() {
    }

    public abstract g2 c0();

    protected final String d0() {
        g2 r10 = z0.c();
        if (this != r10) goto L14;
        return "Dispatchers.Main";
    L14:
        g2 r11 = r10.c0();     // Catch: UnsupportedOperationException -> L9
    L10:
        if (this != r11) goto L13;
        return "Dispatchers.Main.immediate";
    L13:
        return null;
    L9:
        r11 = null;
        goto L10
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int r10) {
        kotlinx.coroutines.internal.r.a(r10);
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String r10 = d0();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return o0.a(this) + '@' + o0.b(this);
    }
}
