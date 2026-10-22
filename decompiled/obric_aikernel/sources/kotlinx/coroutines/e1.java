package kotlinx.coroutines;

/* JADX INFO: loaded from: classes3.dex */
final class e1 implements p1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f10383c;

    public e1(boolean r10) {
        this.f10383c = r10;
    }

    @Override // kotlinx.coroutines.p1
    public h2 a() {
        return null;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return this.f10383c;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Empty{");
        if (isActive() == false) goto L5;
        String r11 = "Active";
    L6:
        r10.append(r11);
        r10.append('}');
        return r10.toString();
    L5:
        r11 = "New";
        goto L6
    }
}
