package bi;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f916b;

    public c(String r5, String r10) {
        this.f915a = r5;
        this.f916b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (c.class != r5.getClass()) goto L25;
        c r10 = (c) r5;
        String r11 = r10.f915a;
        String r12 = this.f915a;
        if (r12 != null) goto L13;
        if (r11 == null) goto L17;
    L16:
        return false;
    L17:
        String r13 = r10.f916b;
        String r14 = this.f916b;
        if (r14 != null) goto L20;
        if (r13 == null) goto L24;
    L23:
        return false;
    L24:
        return true;
    L20:
        if (r14.equals(r13) == true) goto L24;
    L13:
        if (r12.equals(r11) == true) goto L17;
        goto L17
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f915a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = r11 * 31;
        String r13 = this.f916b;
        if (r13 == null) goto L10;
        r5 = r13.hashCode();
    L10:
        return r12 + r5;
    L5:
        r11 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        String r10 = "";
        String r11 = this.f915a;
        if (r11 != null) goto L6;
        r11 = "";
    L6:
        r5.append(r11);
        r5.append(": ");
        String r12 = this.f916b;
        if (r12 == null) goto L9;
        r10 = r12;
    L9:
        r5.append(r10);
        return r5.toString();
    }
}
