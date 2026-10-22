package va;

/* JADX INFO: loaded from: classes2.dex */
public class a implements pa.a {
    public a() {
    }

    @Override // pa.a
    public /* bridge */ /* synthetic */ String a(Object r10) {
        return b((StackTraceElement[]) r10);
    }

    public String b(StackTraceElement[] r10) {
        StringBuilder r11 = new StringBuilder(256);
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.length == 0) goto L28;
        int r12 = 0;
        if (r10.length == 1) goto L10;
        int r13 = r10.length;
    L12:
        if (r12 >= r13) goto L22;
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
    L22:
        return r11.toString();
    L10:
        return "\t─ " + r10[0].toString();
    L28:
        return null;
    }
}
