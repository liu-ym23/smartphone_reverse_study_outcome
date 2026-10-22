package wqa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i {
    public final String a;
    public final String b;

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.a;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0.append(r1);
        r0.append(": ");
        String r3 = this.b;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r2);
        return r0.toString();
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L26:
        return false;
    L8:
        if (i.class != r5.getClass()) goto L26;
        i r6 = (i) r5;
        String r2 = this.a;
        if (r2 == null) goto L16;
        if (r2.equals(r6.a) == false) goto L17;
    L18:
        String r3 = this.b;
        String r7 = r6.b;
        if (r3 != null) goto L21;
        if (r7 == null) goto L25;
    L24:
        return false;
    L25:
        return true;
    L21:
        if (r3.equals(r7) == true) goto L25;
    L17:
        return false;
    L16:
        if (r6.a == null) goto L18;
        goto L17
    }

    public i(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
