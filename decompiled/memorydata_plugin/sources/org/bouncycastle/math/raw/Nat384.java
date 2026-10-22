package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat384 {
    public static void mul(int[] r13, int[] r14, int[] r15) {
        Nat192.mul(r13, r14, r15);
        Nat192.mul(r13, 6, r14, 6, r15, 12);
        int r2 = Nat192.addToEachOther(r15, 6, r15, 12);
        int r3 = r2 + Nat192.addTo(r15, 18, r15, 12, Nat192.addTo(r15, 0, r15, 6, 0) + r2);
        int[] r4 = Nat192.create();
        int[] r12 = Nat192.create();
        if (Nat192.diff(r13, 6, r13, 0, r4, 0) == Nat192.diff(r14, 6, r14, 0, r12, 0)) goto L5;
        boolean r16 = true;
    L6:
        int[] r17 = Nat192.createExt();
        Nat192.mul(r4, r12, r17);
        if (r16 == false) goto L9;
        int r18 = Nat.addTo(12, r17, 0, r15, 6);
    L10:
        Nat.addWordAt(24, r3 + r18, r15, 18);
        return;
    L9:
        r18 = Nat.subFrom(12, r17, 0, r15, 6);
        goto L10
    L5:
        r16 = false;
        goto L6
    }

    public static void square(int[] r12, int[] r13) {
        Nat192.square(r12, r13);
        Nat192.square(r12, 6, r13, 12);
        int r2 = Nat192.addToEachOther(r13, 6, r13, 12);
        int r3 = r2 + Nat192.addTo(r13, 18, r13, 12, Nat192.addTo(r13, 0, r13, 6, 0) + r2);
        int[] r4 = Nat192.create();
        Nat192.diff(r12, 6, r12, 0, r4, 0);
        int[] r14 = Nat192.createExt();
        Nat192.square(r4, r14);
        Nat.addWordAt(24, r3 + Nat.subFrom(12, r14, 0, r13, 6), r13, 18);
    }
}
