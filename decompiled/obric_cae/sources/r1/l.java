package r1;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11325b;

    public l(String r8, int r10) {
        he.i.f(r8, "workSpecId");
        this.f11324a = r8;
        this.f11325b = r10;
    }

    public final int a() {
        return this.f11325b;
    }

    public final String b() {
        return this.f11324a;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof l) == true) goto L8;
        return false;
    L8:
        l r10 = (l) r8;
        String r11 = r10.f11324a;
        if (he.i.a(this.f11324a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f11325b == r10.f11325b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r8 = this.f11324a.hashCode() * 31;
        return Integer.hashCode(this.f11325b) + r8;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("WorkGenerationalId(workSpecId=");
        r8.append(this.f11324a);
        r8.append(", generation=");
        return android.aimedia.a.f(r8, this.f11325b, ')');
    }
}
