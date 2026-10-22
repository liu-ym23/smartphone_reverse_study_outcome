package r1;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11319c;

    public i(String r8, int r10, int r11) {
        he.i.f(r8, "workSpecId");
        this.f11317a = r8;
        this.f11318b = r10;
        this.f11319c = r11;
    }

    public final int a() {
        return this.f11318b;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r10 = (i) r8;
        String r11 = r10.f11317a;
        if (he.i.a(this.f11317a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f11318b == r10.f11318b) goto L15;
        return false;
    L15:
        if (this.f11319c == r10.f11319c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r8 = this.f11317a.hashCode() * 31;
        int r10 = (Integer.hashCode(this.f11318b) + r8) * 31;
        return Integer.hashCode(this.f11319c) + r10;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("SystemIdInfo(workSpecId=");
        r8.append(this.f11317a);
        r8.append(", generation=");
        r8.append(this.f11318b);
        r8.append(", systemId=");
        return android.aimedia.a.f(r8, this.f11319c, ')');
    }
}
