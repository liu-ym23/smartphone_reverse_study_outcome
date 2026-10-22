package org.bouncycastle.math.raw;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Nat512 {
    public static void mul(int[] r13, int[] r14, int[] r15) {
        Nat256.mul(r13, r14, r15);
        Nat256.mul(r13, 8, r14, 8, r15, 16);
        int r2 = Nat256.addToEachOther(r15, 8, r15, 16);
        int r3 = r2 + Nat256.addTo(r15, 24, r15, 16, Nat256.addTo(r15, 0, r15, 8, 0) + r2);
        int[] r4 = Nat256.create();
        int[] r12 = Nat256.create();
        if (Nat256.diff(r13, 8, r13, 0, r4, 0) == Nat256.diff(r14, 8, r14, 0, r12, 0)) goto L5;
        boolean r16 = true;
    L6:
        int[] r17 = Nat256.createExt();
        Nat256.mul(r4, r12, r17);
        if (r16 == false) goto L9;
        int r18 = Nat.addTo(16, r17, 0, r15, 8);
    L10:
        Nat.addWordAt(32, r3 + r18, r15, 24);
        return;
    L9:
        r18 = Nat.subFrom(16, r17, 0, r15, 8);
        goto L10
    L5:
        r16 = false;
        goto L6
    }

    public static void square(int[] r12, int[] r13) {
        Nat256.square(r12, r13);
        Nat256.square(r12, 8, r13, 16);
        int r2 = Nat256.addToEachOther(r13, 8, r13, 16);
        int r3 = r2 + Nat256.addTo(r13, 24, r13, 16, Nat256.addTo(r13, 0, r13, 8, 0) + r2);
        int[] r4 = Nat256.create();
        Nat256.diff(r12, 8, r12, 0, r4, 0);
        int[] r14 = Nat256.createExt();
        Nat256.square(r4, r14);
        Nat.addWordAt(32, r3 + Nat.subFrom(16, r14, 0, r13, 8), r13, 24);
    }
}
