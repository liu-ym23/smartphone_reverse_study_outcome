package org.apache.poi.hwmf.record;

import androidx.core.view.ViewCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes7.dex */
public final enum HwmfBinaryRasterOp extends Enum<HwmfBinaryRasterOp> {
    private static final /* synthetic */ HwmfBinaryRasterOp[] $VALUES = null;
    public static final HwmfBinaryRasterOp R2_BLACK = null;
    public static final HwmfBinaryRasterOp R2_COPYPEN = null;
    public static final HwmfBinaryRasterOp R2_MASKNOTPEN = null;
    public static final HwmfBinaryRasterOp R2_MASKPEN = null;
    public static final HwmfBinaryRasterOp R2_MASKPENNOT = null;
    public static final HwmfBinaryRasterOp R2_MERGENOTPEN = null;
    public static final HwmfBinaryRasterOp R2_MERGEPEN = null;
    public static final HwmfBinaryRasterOp R2_MERGEPENNOT = null;
    public static final HwmfBinaryRasterOp R2_NOP = null;
    public static final HwmfBinaryRasterOp R2_NOT = null;
    public static final HwmfBinaryRasterOp R2_NOTCOPYPEN = null;
    public static final HwmfBinaryRasterOp R2_NOTMASKPEN = null;
    public static final HwmfBinaryRasterOp R2_NOTMERGEPEN = null;
    public static final HwmfBinaryRasterOp R2_NOTXORPEN = null;
    public static final HwmfBinaryRasterOp R2_WHITE = null;
    public static final HwmfBinaryRasterOp R2_XORPEN = null;
    private final BiConsumer<int[], int[]> op;
    private final int opIndex;

    static {
        HwmfBinaryRasterOp r0 = new HwmfBinaryRasterOp("R2_BLACK", 0, 1, $$Lambda$HwmfBinaryRasterOp$SF8FZF07u9TPcPTE13KVOwxZp8.INSTANCE);
        R2_BLACK = r0;
        HwmfBinaryRasterOp r1 = new HwmfBinaryRasterOp("R2_NOTMERGEPEN", 1, 2, $$Lambda$HwmfBinaryRasterOp$Q_1wyEqyzOTHJSgymL6oLCHBX5U.INSTANCE);
        R2_NOTMERGEPEN = r1;
        HwmfBinaryRasterOp r2 = new HwmfBinaryRasterOp("R2_MASKNOTPEN", 2, 3, $$Lambda$HwmfBinaryRasterOp$kCOFo73SFJfGK2bUYRlNHZgtw.INSTANCE);
        R2_MASKNOTPEN = r2;
        HwmfBinaryRasterOp r5 = new HwmfBinaryRasterOp("R2_NOTCOPYPEN", 3, 4, $$Lambda$HwmfBinaryRasterOp$90pa7r7mVmupjYiIYnz9mZ0g5aM.INSTANCE);
        R2_NOTCOPYPEN = r5;
        HwmfBinaryRasterOp r7 = new HwmfBinaryRasterOp("R2_MASKPENNOT", 4, 5, $$Lambda$HwmfBinaryRasterOp$AyQk9tXlhFBaluW4IyZUk8x9YsQ.INSTANCE);
        R2_MASKPENNOT = r7;
        HwmfBinaryRasterOp r9 = new HwmfBinaryRasterOp("R2_NOT", 5, 6, $$Lambda$HwmfBinaryRasterOp$OnFHhahqabm4vvJKbNRjJNIhp7A.INSTANCE);
        R2_NOT = r9;
        HwmfBinaryRasterOp r11 = new HwmfBinaryRasterOp("R2_XORPEN", 6, 7, $$Lambda$HwmfBinaryRasterOp$ozEC5C9kyJStJX8nMGjOYd6gYf0.INSTANCE);
        R2_XORPEN = r11;
        HwmfBinaryRasterOp r13 = new HwmfBinaryRasterOp("R2_NOTMASKPEN", 7, 8, $$Lambda$HwmfBinaryRasterOp$bROBfavReW90kN47M4Q895eAKxU.INSTANCE);
        R2_NOTMASKPEN = r13;
        HwmfBinaryRasterOp r14 = new HwmfBinaryRasterOp("R2_MASKPEN", 8, 9, $$Lambda$HwmfBinaryRasterOp$62gwZlpwFuboViYOWpyGruigOwU.INSTANCE);
        R2_MASKPEN = r14;
        HwmfBinaryRasterOp r12 = new HwmfBinaryRasterOp("R2_NOTXORPEN", 9, 10, $$Lambda$HwmfBinaryRasterOp$_TPjJlUUb1PkAQc4TyNEe1TQ6_o.INSTANCE);
        R2_NOTXORPEN = r12;
        HwmfBinaryRasterOp r10 = new HwmfBinaryRasterOp("R2_NOP", 10, 11, $$Lambda$HwmfBinaryRasterOp$Kqg5amm3efD0wL5dMnEScJf2ME.INSTANCE);
        R2_NOP = r10;
        HwmfBinaryRasterOp r8 = new HwmfBinaryRasterOp("R2_MERGENOTPEN", 11, 12, $$Lambda$HwmfBinaryRasterOp$msjKLD6uX5fUfCK_VqIUcLPvdEc.INSTANCE);
        R2_MERGENOTPEN = r8;
        HwmfBinaryRasterOp r6 = new HwmfBinaryRasterOp("R2_COPYPEN", 12, 13, $$Lambda$HwmfBinaryRasterOp$BTNUxwZl30PzYM8m87WTA7F3aA4.INSTANCE);
        R2_COPYPEN = r6;
        HwmfBinaryRasterOp r4 = new HwmfBinaryRasterOp("R2_MERGEPENNOT", 13, 14, $$Lambda$HwmfBinaryRasterOp$L_4EAsaisKKygNhvB_FQWQP650.INSTANCE);
        R2_MERGEPENNOT = r4;
        HwmfBinaryRasterOp r3 = new HwmfBinaryRasterOp("R2_MERGEPEN", 14, 15, $$Lambda$HwmfBinaryRasterOp$0WOqo0uIR7pgtjSi5Mp8DLNBc88.INSTANCE);
        R2_MERGEPEN = r3;
        HwmfBinaryRasterOp r15 = new HwmfBinaryRasterOp("R2_WHITE", 15, 16, $$Lambda$HwmfBinaryRasterOp$uZGFs6CrftpR7xSc58_w9AHoMw.INSTANCE);
        R2_WHITE = r15;
        $VALUES = new HwmfBinaryRasterOp[]{r0, r1, r2, r5, r7, r9, r11, r13, r14, r12, r10, r8, r6, r4, r3, r15};
    }

    private HwmfBinaryRasterOp(String r3, int r4, int r5, BiConsumer r6) {
        BiConsumer<int[], int[]> r7 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r6, BiConsumer.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.opIndex = r5;
        this.op = r7;
    }

    private static void R2_BLACK(int[] r0, int[] r1) {
        Arrays.fill(r1, ViewCompat.MEASURED_STATE_MASK);
    }

    private static void R2_COPYPEN(int[] r2, int[] r3) {
        System.arraycopy(r2, 0, r3, 0, r2.length);
    }

    private static void R2_MASKNOTPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((r5[r0] & (~r4[r0])) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_MASKPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((r5[r0] & r4[r0]) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_MASKPENNOT(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((r4[r0] & (~r5[r0])) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_MERGENOTPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((r5[r0] | (~r4[r0])) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_MERGEPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((r5[r0] | r4[r0]) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_MERGEPENNOT(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((r4[r0] & (~r5[r0])) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_NOP(int[] r0, int[] r1) {
    }

    private static void R2_NOT(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((~r5[r0]) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_NOTCOPYPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((~r4[r0]) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_NOTMASKPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((~(r5[r0] & r4[r0])) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_NOTMERGEPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((~(r5[r0] | r4[r0])) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_NOTXORPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((~(r5[r0] ^ r4[r0])) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    private static void R2_WHITE(int[] r0, int[] r1) {
        Arrays.fill(r1, -1);
    }

    private static void R2_XORPEN(int[] r4, int[] r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r5[r0] = (r5[r0] & ViewCompat.MEASURED_STATE_MASK) | ((r5[r0] ^ r4[r0]) & ViewCompat.MEASURED_SIZE_MASK);
        r0 = r0 + 1;
        goto L4
    }

    public static /* synthetic */ void lambda$0WOqo0uIR7pgtjSi5Mp8DLNBc88(int[] r0, int[] r1) {
        R2_MERGEPEN(r0, r1);
    }

    public static /* synthetic */ void lambda$62gwZlpwFuboViYOWpyGruigOwU(int[] r0, int[] r1) {
        R2_MASKPEN(r0, r1);
    }

    public static /* synthetic */ void lambda$90pa7r7mVmupjYiIYnz9mZ0g5aM(int[] r0, int[] r1) {
        R2_NOTCOPYPEN(r0, r1);
    }

    public static /* synthetic */ void lambda$AyQk9tXlhFBaluW4IyZUk8x9YsQ(int[] r0, int[] r1) {
        R2_MASKPENNOT(r0, r1);
    }

    public static /* synthetic */ void lambda$BTNUxwZl30PzYM8m87WTA7F3aA4(int[] r0, int[] r1) {
        R2_COPYPEN(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Kqg5-amm3efD0wL5dMnEScJf2ME, reason: not valid java name */
    public static /* synthetic */ void m3163lambda$Kqg5amm3efD0wL5dMnEScJf2ME(int[] r0, int[] r1) {
        R2_NOP(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$L_4EAsaisKKygNhvB_FQWQP-650, reason: not valid java name */
    public static /* synthetic */ void m3164lambda$L_4EAsaisKKygNhvB_FQWQP650(int[] r0, int[] r1) {
        R2_MERGEPENNOT(r0, r1);
    }

    public static /* synthetic */ void lambda$OnFHhahqabm4vvJKbNRjJNIhp7A(int[] r0, int[] r1) {
        R2_NOT(r0, r1);
    }

    public static /* synthetic */ void lambda$Q_1wyEqyzOTHJSgymL6oLCHBX5U(int[] r0, int[] r1) {
        R2_NOTMERGEPEN(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$SF8FZF07u9TPcPTE13KVOwx-Zp8, reason: not valid java name */
    public static /* synthetic */ void m3165lambda$SF8FZF07u9TPcPTE13KVOwxZp8(int[] r0, int[] r1) {
        R2_BLACK(r0, r1);
    }

    public static /* synthetic */ void lambda$_TPjJlUUb1PkAQc4TyNEe1TQ6_o(int[] r0, int[] r1) {
        R2_NOTXORPEN(r0, r1);
    }

    public static /* synthetic */ void lambda$bROBfavReW90kN47M4Q895eAKxU(int[] r0, int[] r1) {
        R2_NOTMASKPEN(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$kC-OFo73SFJfGK2bUYRlN-HZgtw, reason: not valid java name */
    public static /* synthetic */ void m3166lambda$kCOFo73SFJfGK2bUYRlNHZgtw(int[] r0, int[] r1) {
        R2_MASKNOTPEN(r0, r1);
    }

    public static /* synthetic */ void lambda$msjKLD6uX5fUfCK_VqIUcLPvdEc(int[] r0, int[] r1) {
        R2_MERGENOTPEN(r0, r1);
    }

    public static /* synthetic */ void lambda$ozEC5C9kyJStJX8nMGjOYd6gYf0(int[] r0, int[] r1) {
        R2_XORPEN(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$uZGFs6CrftpR7xSc58_w-9AHoMw, reason: not valid java name */
    public static /* synthetic */ void m3167lambda$uZGFs6CrftpR7xSc58_w9AHoMw(int[] r0, int[] r1) {
        R2_WHITE(r0, r1);
    }

    public static HwmfBinaryRasterOp valueOf(int r5) {
        HwmfBinaryRasterOp[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        HwmfBinaryRasterOp r3 = r0[r2];
        if (r3.opIndex == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return null;
    }

    public static HwmfBinaryRasterOp valueOf(String r2) {
        return (HwmfBinaryRasterOp) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfBinaryRasterOp.class, r2), HwmfBinaryRasterOp.class, "com.obric.memorydata.plugin");
    }

    public static HwmfBinaryRasterOp[] values() {
        return (HwmfBinaryRasterOp[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfBinaryRasterOp[].class, "com.obric.memorydata.plugin");
    }

    public int getOpIndex() {
        return this.opIndex;
    }

    public void process(int[] r1, int[] r2) {
        this.op.accept(r1, r2);
    }
}
