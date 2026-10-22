package com.google.common.primitives;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class SignedBytes {

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<byte[]> {
        private static final /* synthetic */ LexicographicalComparator[] $VALUES = null;
        public static final LexicographicalComparator INSTANCE = null;

        private static /* synthetic */ LexicographicalComparator[] $values() {
            return new LexicographicalComparator[]{INSTANCE};
        }

        static {
            INSTANCE = new LexicographicalComparator("INSTANCE", 0);
            $VALUES = $values();
        }

        private LexicographicalComparator(String r1, int r2) {
            super(r1, r2);
        }

        public static LexicographicalComparator valueOf(String r2) {
            return (LexicographicalComparator) ZeusTransformUtils.preCheckCast(Enum.valueOf(LexicographicalComparator.class, r2), LexicographicalComparator.class, "com.obric.memorydata.plugin");
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LexicographicalComparator[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(byte[] r3, byte[] r4) {
            return compare2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(byte[] r4, byte[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            int r1 = SignedBytes.a(r4[r0], r5[r0]);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r4.length - r5.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    public static byte a(long r3) {
        byte r0 = (byte) r3;
        if (r0 != r3) goto L5;
        boolean r1 = true;
    L6:
        n.a(r1, "Out of range: %s", r3);
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public static int a(byte r0, byte r1) {
        return r0 - r1;
    }
}
