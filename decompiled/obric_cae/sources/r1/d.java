package r1;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f11314b;

    public d(Long r8, String r10) {
        this.f11313a = r10;
        this.f11314b = r8;
    }

    public final String a() {
        return this.f11313a;
    }

    public final Long b() {
        return this.f11314b;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r8;
        String r11 = r10.f11313a;
        if (he.i.a(this.f11313a, r11) == true) goto L12;
        return false;
    L12:
        if (he.i.a(this.f11314b, r10.f11314b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r8 = this.f11313a.hashCode() * 31;
        Long r10 = this.f11314b;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r8 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final String toString() {
        return "Preference(key=" + this.f11313a + ", value=" + this.f11314b + ')';
    }
}
