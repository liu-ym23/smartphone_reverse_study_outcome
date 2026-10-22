package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19026a;

    public v0(boolean r5) {
        this.f19026a = r5;
    }

    @Override // kotlinx.coroutines.g1
    public final u1 b() {
        return null;
    }

    @Override // kotlinx.coroutines.g1
    public final boolean isActive() {
        return this.f19026a;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Empty{");
        if (this.f19026a == false) goto L5;
        String r10 = "Active";
    L7:
        return ai.j0.p(r5, r10, '}');
    L5:
        r10 = "New";
        goto L7
    }
}
