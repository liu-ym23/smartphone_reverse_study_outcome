package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class o1 implements p1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h2 f10621c;

    public o1(h2 r10) {
        this.f10621c = r10;
    }

    @Override // kotlinx.coroutines.p1
    public h2 a() {
        return this.f10621c;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return false;
    }

    public String toString() {
        if (n0.c() == false) goto L6;
        return a().q("New");
    L6:
        return super.toString();
    }
}
