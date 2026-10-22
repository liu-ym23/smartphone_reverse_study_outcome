package org.apache.commons.collections4.trie.analyzer;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.collections4.trie.KeyAnalyzer;

/* JADX INFO: loaded from: classes6.dex */
public class StringKeyAnalyzer extends KeyAnalyzer<String> {
    public static final StringKeyAnalyzer INSTANCE = null;
    public static final int LENGTH = 16;
    private static final int MSB = 32768;
    private static final long serialVersionUID = -7032449491269434877L;

    static {
        INSTANCE = new StringKeyAnalyzer();
    }

    public StringKeyAnalyzer() {
    }

    private static int mask(int r1) {
        return 32768 >>> r1;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public /* synthetic */ int bitIndex(String r10, int r11, int r12, String r13, int r14, int r15) {
        return bitIndex2((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin"), r11, r12, (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin"), r14, r15);
    }

    /* JADX INFO: renamed from: bitIndex, reason: avoid collision after fix types in other method */
    public int bitIndex2(String r6, int r7, int r8, String r9, int r10, int r11) {
        if ((r7 % 16) != 0) goto L33;
        if ((r10 % 16) != 0) goto L33;
        if ((r8 % 16) != 0) goto L33;
        if ((r11 % 16) != 0) goto L33;
        int r12 = r7 / 16;
        int r13 = r10 / 16;
        int r14 = (r8 / 16) + r12;
        int r15 = (r11 / 16) + r13;
        int r5 = Math.max(r14, r15);
        boolean r0 = true;
        int r2 = 0;
    L11:
        if (r2 >= r5) goto L27;
        int r3 = r12 + r2;
        int r4 = r13 + r2;
        if (r3 < r14) goto L15;
        char r16 = 0;
    L16:
        if (r9 == null) goto L20;
        if (r4 >= r15) goto L20;
        char r17 = r9.charAt(r4);
    L21:
        if (r16 != r17) goto L23;
        if (r16 == 0) goto L26;
        r0 = false;
    L26:
        r2 = r2 + 1;
        goto L11
    L23:
        return ((r2 * 16) + Integer.numberOfLeadingZeros(r16 ^ r17)) - 16;
    L20:
        r17 = 0;
        goto L21
    L15:
        r16 = r6.charAt(r3);
        goto L16
    L27:
        if (r0 == false) goto L30;
        return -1;
    L30:
        return -2;
    L33:
        throw new IllegalArgumentException("The offsets and lengths must be at Character boundaries");
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public int bitsPerElement() {
        return 16;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public /* synthetic */ boolean isBitSet(String r3, int r4, int r5) {
        return isBitSet2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    /* JADX INFO: renamed from: isBitSet, reason: avoid collision after fix types in other method */
    public boolean isBitSet2(String r1, int r2, int r3) {
        if (r1 == null) goto L10;
        if (r2 >= r3) goto L12;
        int r4 = r2 / 16;
        if ((r1.charAt(r4) & mask(r2 % 16)) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public /* synthetic */ boolean isPrefix(String r3, int r4, int r5, String r6) {
        return isPrefix2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r4, r5, (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: isPrefix, reason: avoid collision after fix types in other method */
    public boolean isPrefix2(String r1, int r2, int r3, String r4) {
        if ((r2 % 16) != 0) goto L9;
        if ((r3 % 16) != 0) goto L9;
        return r4.startsWith(r1.substring(r2 / 16, r3 / 16));
    L9:
        throw new IllegalArgumentException("Cannot determine prefix outside of Character boundaries");
    }

    @Override // org.apache.commons.collections4.trie.KeyAnalyzer
    public /* synthetic */ int lengthInBits(String r3) {
        return lengthInBits2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: lengthInBits, reason: avoid collision after fix types in other method */
    public int lengthInBits2(String r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.length() * 16;
    }
}
