package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10058a;

    public r0(boolean r8) {
        this.f10058a = r8;
    }

    @Override // pe.z0
    public final boolean a() {
        return this.f10058a;
    }

    @Override // pe.z0
    public final m1 c() {
        return null;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("Empty{");
        if (this.f10058a == false) goto L5;
        String r10 = "Active";
    L6:
        r8.append(r10);
        r8.append('}');
        return r8.toString();
    L5:
        r10 = "New";
        goto L6
    }
}
