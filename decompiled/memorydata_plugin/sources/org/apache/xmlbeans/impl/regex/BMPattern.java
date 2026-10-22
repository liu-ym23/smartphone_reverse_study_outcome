package org.apache.xmlbeans.impl.regex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.CharacterIterator;

/* JADX INFO: loaded from: classes7.dex */
public class BMPattern {
    boolean ignoreCase;
    char[] pattern;
    int[] shiftTable;

    public BMPattern(String r5, int r6, boolean r7) {
        char[] r8 = r5.toCharArray();
        this.pattern = r8;
        this.shiftTable = new int[r6];
        this.ignoreCase = r7;
        int r9 = r8.length;
        int r10 = 0;
        int r11 = 0;
    L3:
        int[] r0 = this.shiftTable;
        if (r11 >= r0.length) goto L6;
        r0[r11] = r9;
        r11 = r11 + 1;
    L6:
        if (r10 >= r9) goto L19;
        char r12 = this.pattern[r10];
        int r1 = (r9 - r10) - 1;
        int[] r2 = this.shiftTable;
        int r3 = r12 % r2.length;
        if (r1 >= r2[r3]) goto L11;
        r2[r3] = r1;
    L11:
        if (this.ignoreCase == false) goto L18;
        char r13 = Character.toUpperCase(r12);
        int[] r4 = this.shiftTable;
        int r14 = r13 % r4.length;
        if (r1 >= r4[r14]) goto L15;
        r4[r14] = r1;
    L15:
        char r15 = Character.toLowerCase(r13);
        int[] r16 = this.shiftTable;
        int r17 = r15 % r16.length;
        if (r1 >= r16[r17]) goto L18;
        r16[r17] = r1;
    L18:
        r10 = r10 + 1;
        goto L6
    }

    public int matches(String r7, int r8, int r9) {
        if (this.ignoreCase == true) goto L5;
        int r0 = this.pattern.length;
        if (r0 != 0) goto L9;
        return r8;
    L9:
        int r10 = r8 + r0;
    L11:
        if (r10 > r9) goto L22;
        int r2 = r10 + 1;
        int r3 = r0;
    L13:
        r10 = r10 - 1;
        char r4 = r7.charAt(r10);
        r3 = r3 - 1;
        if (r4 != this.pattern[r3]) goto L19;
        if (r3 == 0) goto L17;
        if (r3 > 0) goto L13;
    L17:
        return r10;
    L19:
        int[] r1 = this.shiftTable;
        r10 = r10 + (r1[r4 % r1.length] + 1);
        if (r10 >= r2) goto L11;
        r10 = r2;
        goto L11
    L22:
        return -1;
    L5:
        return matchesIgnoreCase(r7, r8, r9);
    }

    public int matches(CharacterIterator r7, int r8, int r9) {
        CharacterIterator r10 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r7, CharacterIterator.class, "com.obric.memorydata.plugin");
        if (this.ignoreCase == true) goto L5;
        int r0 = this.pattern.length;
        if (r0 != 0) goto L9;
        return r8;
    L9:
        int r11 = r8 + r0;
    L11:
        if (r11 > r9) goto L22;
        int r2 = r11 + 1;
        int r3 = r0;
    L13:
        r11 = r11 - 1;
        char r4 = r10.setIndex(r11);
        r3 = r3 - 1;
        if (r4 != this.pattern[r3]) goto L19;
        if (r3 == 0) goto L17;
        if (r3 > 0) goto L13;
    L17:
        return r11;
    L19:
        int[] r1 = this.shiftTable;
        r11 = r11 + (r1[r4 % r1.length] + 1);
        if (r11 >= r2) goto L11;
        r11 = r2;
        goto L11
    L22:
        return -1;
    L5:
        return matchesIgnoreCase(r10, r8, r9);
    }

    public int matches(char[] r7, int r8, int r9) {
        if (this.ignoreCase == true) goto L5;
        int r0 = this.pattern.length;
        if (r0 != 0) goto L9;
        return r8;
    L9:
        int r10 = r8 + r0;
    L11:
        if (r10 > r9) goto L22;
        int r2 = r10 + 1;
        int r3 = r0;
    L13:
        r10 = r10 - 1;
        char r4 = r7[r10];
        r3 = r3 - 1;
        if (r4 != this.pattern[r3]) goto L19;
        if (r3 == 0) goto L17;
        if (r3 > 0) goto L13;
    L17:
        return r10;
    L19:
        int[] r1 = this.shiftTable;
        r10 = r10 + (r1[r4 % r1.length] + 1);
        if (r10 >= r2) goto L11;
        r10 = r2;
        goto L11
    L22:
        return -1;
    L5:
        return matchesIgnoreCase(r7, r8, r9);
    }

    int matchesIgnoreCase(String r8, int r9, int r10) {
        int r0 = this.pattern.length;
        if (r0 != 0) goto L5;
        return r9;
    L5:
        int r11 = r9 + r0;
    L7:
        if (r11 > r10) goto L22;
        int r2 = r11 + 1;
        int r3 = r0;
    L9:
        r11 = r11 - 1;
        char r4 = r8.charAt(r11);
        r3 = r3 - 1;
        char r5 = this.pattern[r3];
        if (r4 == r5) goto L16;
        char r6 = Character.toUpperCase(r4);
        char r7 = Character.toUpperCase(r5);
        if (r6 == r7) goto L16;
        if (Character.toLowerCase(r6) == Character.toLowerCase(r7)) goto L16;
    L19:
        int[] r1 = this.shiftTable;
        r11 = r11 + (r1[r4 % r1.length] + 1);
        if (r11 >= r2) goto L7;
        r11 = r2;
    L16:
        if (r3 == 0) goto L17;
        if (r3 > 0) goto L9;
    L17:
        return r11;
    L22:
        return -1;
    }

    int matchesIgnoreCase(CharacterIterator r8, int r9, int r10) {
        CharacterIterator r11 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r8, CharacterIterator.class, "com.obric.memorydata.plugin");
        int r0 = this.pattern.length;
        if (r0 != 0) goto L5;
        return r9;
    L5:
        int r12 = r9 + r0;
    L7:
        if (r12 > r10) goto L22;
        int r2 = r12 + 1;
        int r3 = r0;
    L9:
        r12 = r12 - 1;
        char r4 = r11.setIndex(r12);
        r3 = r3 - 1;
        char r5 = this.pattern[r3];
        if (r4 == r5) goto L16;
        char r6 = Character.toUpperCase(r4);
        char r7 = Character.toUpperCase(r5);
        if (r6 == r7) goto L16;
        if (Character.toLowerCase(r6) == Character.toLowerCase(r7)) goto L16;
    L19:
        int[] r1 = this.shiftTable;
        r12 = r12 + (r1[r4 % r1.length] + 1);
        if (r12 >= r2) goto L7;
        r12 = r2;
    L16:
        if (r3 == 0) goto L17;
        if (r3 > 0) goto L9;
    L17:
        return r12;
    L22:
        return -1;
    }

    int matchesIgnoreCase(char[] r8, int r9, int r10) {
        int r0 = this.pattern.length;
        if (r0 != 0) goto L5;
        return r9;
    L5:
        int r11 = r9 + r0;
    L7:
        if (r11 > r10) goto L22;
        int r2 = r11 + 1;
        int r3 = r0;
    L9:
        r11 = r11 - 1;
        char r4 = r8[r11];
        r3 = r3 - 1;
        char r5 = this.pattern[r3];
        if (r4 == r5) goto L16;
        char r6 = Character.toUpperCase(r4);
        char r7 = Character.toUpperCase(r5);
        if (r6 == r7) goto L16;
        if (Character.toLowerCase(r6) == Character.toLowerCase(r7)) goto L16;
    L19:
        int[] r1 = this.shiftTable;
        r11 = r11 + (r1[r4 % r1.length] + 1);
        if (r11 >= r2) goto L7;
        r11 = r2;
    L16:
        if (r3 == 0) goto L17;
        if (r3 > 0) goto L9;
    L17:
        return r11;
    L22:
        return -1;
    }
}
