package hd;

import gd.b;
import nd.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8048a;

    public /* synthetic */ a(int r8) {
        this.f8048a = r8;
    }

    @Override // gd.b
    public final String a(Object r11) {
        switch(this.f8048a) {
            case 0: goto L5;
            default: goto L34;
        };
    L5:
        String[] r12 = (String[]) r11;
        if (r12 != null) goto L8;
    L31:
        return "";
    L8:
        if (r12.length == 0) goto L31;
        String[] r10 = new String[r12.length];
        int r8 = r12.length;
        int r13 = 0;
        int r14 = 0;
    L11:
        if (r13 >= r8) goto L16;
        String r15 = r12[r13];
        if (r15 == null) goto L15;
        r10[r14] = r15;
        r14 = r14 + 1;
    L15:
        r13 = r13 + 1;
        goto L11
    L16:
        if (r14 == 0) goto L31;
        StringBuilder r16 = new StringBuilder("╔═══════════════════════════════════════════════════════════════════════════════════════════════════\n");
        int r17 = 0;
    L19:
        if (r17 >= r14) goto L44;
        String r18 = r10[r17];
        StringBuilder r19 = new StringBuilder(r18.length() + 10);
        String[] r20 = r18.split("\n");
        int r21 = r20.length;
        int r22 = 0;
    L21:
        if (r22 >= r21) goto L25;
        if (r22 == 0) goto L24;
        r19.append("\n");
    L24:
        String r23 = r20[r22];
        r19.append(9553);
        r19.append(r23);
        r22 = r22 + 1;
        goto L21
    L25:
        r16.append(r19.toString());
        if (r17 == (r14 - 1)) goto L28;
        String r24 = "\n╟───────────────────────────────────────────────────────────────────────────────────────────────────\n";
    L29:
        r16.append(r24);
        r17 = r17 + 1;
        goto L19
    L28:
        r24 = "\n╚═══════════════════════════════════════════════════════════════════════════════════════════════════";
        goto L29
    L44:
        return r16.toString();
    L34:
        return c.a((Throwable) r11);
    }
}
