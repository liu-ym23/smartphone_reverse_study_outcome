package t39;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d {
    public final String a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final String e;
    public final String f;

    public d() {
        this(null, null, null, null, null, null, null, 127);
    }

    public d(String r1, String r2, Integer r3, Integer r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ d(String r7, String r8, Integer r9, Integer r10, String r11, String r12, String r13, int r14) {
        String r1 = null;
        if ((r14 & 1) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Integer r3 = 1;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Integer r4 = 1;
    L19:
        if ((r14 & 16) != 0) goto L23;
        r1 = r11;
    L23:
        if ((r14 & 64) == 0) goto L25;
        String r5 = "";
    L26:
        this(r0, r2, r3, r4, r1, r5);
        return;
    L25:
        r5 = r13;
        goto L26
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r0 = r7;
        goto L7
    }
}
