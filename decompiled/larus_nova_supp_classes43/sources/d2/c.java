package d2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final String a;
    public final String b;

    public c(String r10, String r11) {
        String r0 = "";
        if (r10 == null) goto L5;
        String r12 = r10.toLowerCase();
    L6:
        this.a = r12;
        if (r11 == null) goto L9;
        r0 = r11.toLowerCase();
    L9:
        this.b = r0;
        return;
    L5:
        r12 = "";
        goto L6
    }
}
