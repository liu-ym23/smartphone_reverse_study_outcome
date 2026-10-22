package b6;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static String a(int r8) {
        if (r8 >= 1000) goto L5;
    L18:
        StringBuilder r10 = new StringBuilder("Code must be in range [1000,5000): ");
        r10.append(r8);
        StringBuilder r11 = r10;
    L20:
        return r11.toString();
    L5:
        if (r8 >= 5000) goto L18;
        if (r8 < 1004) goto L12;
        if (r8 > 1006) goto L12;
    L15:
        r11 = defpackage.b.f("Code ", r8, " is reserved and may not be used.");
    L12:
        if (r8 >= 1012) goto L14;
        return null;
    L14:
        if (r8 <= 2999) goto L15;
        return null;
    }

    public static void b(jf.d.c r8, byte[] r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        byte[] r13 = r8.f8837o;
        int r14 = r8.f8838p;
        int r15 = r8.f8839q;
    L4:
        if (r14 >= r15) goto L6;
        int r16 = r12 % r11;
        r13[r14] = (byte) (r13[r14] ^ r10[r16]);
        r14 = r14 + 1;
        r12 = r16 + 1;
        goto L4
    L6:
        long r17 = r8.f8836n;
        if (r17 == r8.f8833a.f8830b) goto L16;
        if (r17 != (-1)) goto L11;
        long r18 = 0;
    L13:
        if (r8.a(r18) != (-1)) goto L3;
        return;
    L11:
        r18 = r17 + ((long) (r8.f8839q - r8.f8838p));
        goto L13
    L16:
        throw new IllegalStateException();
    }
}
