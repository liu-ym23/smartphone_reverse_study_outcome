package ld;

import gd.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {
    @Override // gd.b
    public final String a(Object r8) {
        StackTraceElement[] r10 = (StackTraceElement[]) r8;
        StringBuilder r11 = new StringBuilder(256);
        if (r10 != null) goto L5;
    L21:
        return null;
    L5:
        if (r10.length == 0) goto L21;
        int r12 = 0;
        if (r10.length != 1) goto L11;
        r11 = new StringBuilder("\t─ ");
        r11.append(r10[0].toString());
    L26:
        return r11.toString();
    L11:
        int r13 = r10.length;
    L12:
        if (r12 >= r13) goto L26;
        String r14 = "\n";
        if (r12 != 0) goto L17;
        r11.append("\n");
    L17:
        if (r12 == (r13 - 1)) goto L19;
        r11.append("\t├ ");
        r11.append(r10[r12].toString());
    L20:
        r11.append(r14);
        r12 = r12 + 1;
        goto L12
    L19:
        r11.append("\t└ ");
        r14 = r10[r12].toString();
        goto L20
    }
}
