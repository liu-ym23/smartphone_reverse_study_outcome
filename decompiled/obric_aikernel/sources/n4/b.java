package n4;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11199b;

    public b(String r10, String r11) {
        this.f11198a = r10;
        this.f11199b = r11;
    }

    public String a() {
        return this.f11198a;
    }

    public String b() {
        return this.f11199b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L27:
        return false;
    L8:
        if (b.class != r10.getClass()) goto L27;
        b r11 = (b) r10;
        String r12 = this.f11198a;
        if (r12 == null) goto L16;
        if (r12.equals(r11.f11198a) == false) goto L17;
    L18:
        String r13 = this.f11199b;
        if (r13 == null) goto L24;
        if (r13.equals(r11.f11199b) == false) goto L25;
    L26:
        return true;
    L25:
        return false;
    L24:
        if (r11.f11199b == null) goto L26;
    L17:
        return false;
    L16:
        if (r11.f11198a == null) goto L18;
        goto L17
    }

    public int hashCode() {
        String r10 = this.f11198a;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        String r14 = this.f11199b;
        if (r14 == null) goto L10;
        r11 = r14.hashCode();
    L10:
        return r13 + r11;
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        String r11 = this.f11198a;
        String r12 = "";
        if (r11 != null) goto L6;
        r11 = "";
    L6:
        r10.append(r11);
        r10.append(": ");
        String r13 = this.f11199b;
        if (r13 == null) goto L9;
        r12 = r13;
    L9:
        r10.append(r12);
        return r10.toString();
    }
}
