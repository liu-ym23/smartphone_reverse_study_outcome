package org.apache.xmlbeans.impl.regex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
final class RangeToken extends Token implements Serializable {
    private static final int MAPSIZE = 256;
    boolean compacted;
    RangeToken icaseCache;
    int[] map;
    int nonMapIndex;
    int[] ranges;
    boolean sorted;

    RangeToken(int r1) {
        super(r1);
        this.icaseCache = null;
        this.map = null;
        setSorted(false);
    }

    static Token complementRanges(Token r11) {
        if (r11.type != 4) goto L5;
    L9:
        RangeToken r12 = (RangeToken) ZeusTransformUtils.preCheckCast(r11, RangeToken.class, "com.obric.memorydata.plugin");
        r12.sortRanges();
        r12.compactRanges();
        int[] r0 = r12.ranges;
        int r1 = r0.length + 2;
        int r3 = 0;
        if (r0[0] != 0) goto L12;
        r1 = r1 - 2;
    L12:
        int r2 = r0[r0.length - 1];
        if (r2 != 1114111) goto L15;
        r1 = r1 - 2;
    L15:
        RangeToken r6 = Token.createRange();
        int[] r4 = new int[r1];
        r6.ranges = r4;
        int[] r7 = r12.ranges;
        if (r7[0] <= 0) goto L18;
        r4[0] = 0;
        r4[1] = r7[0] - 1;
        r3 = 2;
    L18:
        int r5 = 1;
    L19:
        int[] r8 = r12.ranges;
        if (r5 >= (r8.length - 2)) goto L22;
        int[] r9 = r6.ranges;
        int r10 = r3 + 1;
        r9[r3] = r8[r5] + 1;
        r3 = r10 + 1;
        r9[r10] = r8[r5 + 1] - 1;
        r5 = r5 + 2;
        goto L19
    L22:
        if (r2 == 1114111) goto L24;
        int[] r13 = r6.ranges;
        r13[r3] = r2 + 1;
        r13[r3 + 1] = 1114111;
    L24:
        r6.setCompacted();
        return r6;
    L5:
        if (r11.type == 5) goto L9;
        throw new IllegalArgumentException("Token#complementRanges(): must be RANGE: " + r11.type);
    }

    private void createMap() {
        int[] r1 = new int[8];
        int r2 = this.ranges.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= 8) goto L5;
        r1[r4] = 0;
        r4 = r4 + 1;
    L5:
        int[] r0 = this.ranges;
        if (r3 >= r0.length) goto L16;
        int r5 = r0[r3];
        int r6 = r0[r3 + 1];
        if (r5 >= 256) goto L15;
    L9:
        if (r5 > r6) goto L12;
        if (r5 >= 256) goto L12;
        int r7 = r5 / 32;
        r1[r7] = r1[r7] | (1 << (r5 & 31));
        r5 = r5 + 1;
    L12:
        if (r6 >= 256) goto L15;
        r3 = r3 + 2;
    L15:
        r2 = r3;
    L16:
        this.nonMapIndex = r2;
        this.map = r1;
    }

    private static String escapeCharInCharClass(int r2) {
        if (r2 != 9) goto L5;
        return "\\t";
    L5:
        if (r2 != 10) goto L7;
        return "\\n";
    L7:
        if (r2 != 12) goto L9;
        return "\\f";
    L9:
        if (r2 != 13) goto L11;
        return "\\r";
    L11:
        if (r2 != 27) goto L13;
        return "\\e";
    L13:
        if (r2 != 44) goto L15;
    L25:
        StringBuilder r0 = new StringBuilder();
        String r1 = "\\";
    L26:
        StringBuilder r3 = r0.append(r1).append((char) r2);
    L34:
        return r3.toString();
    L15:
        if (r2 == 45) goto L25;
        switch(r2) {
            case 91: goto L25;
            case 92: goto L25;
            case 93: goto L25;
            case 94: goto L25;
            default: goto L18;
        };
    L18:
        if (r2 >= 32) goto L22;
        String r4 = "0" + Integer.toHexString(r2);
        StringBuilder r5 = new StringBuilder().append("\\x");
        int r6 = r4.length() - 2;
    L20:
        r3 = r5.append(r4.substring(r6));
        goto L34
    L22:
        if (r2 < 65536) goto L24;
        r4 = "0" + Integer.toHexString(r2);
        r5 = new StringBuilder().append("\\v");
        r6 = r4.length() - 6;
        goto L20
    L24:
        r0 = new StringBuilder();
        r1 = "";
        goto L26
    }

    private boolean isCompacted() {
        return this.compacted;
    }

    private boolean isSorted() {
        return this.sorted;
    }

    private void setCompacted() {
        this.compacted = true;
    }

    private void setSorted(boolean r1) {
        this.sorted = r1;
        if (r1 == true) goto L6;
        this.compacted = false;
        return;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void addRange(int r8, int r9) {
        this.icaseCache = null;
        if (r8 <= r9) goto L6;
        r9 = r8;
        r8 = r9;
    L6:
        int[] r0 = this.ranges;
        if (r0 != null) goto L9;
        this.ranges = new int[]{r8, r9};
        setSorted(true);
        return;
    L9:
        int r3 = r0.length;
        int r4 = r3 - 1;
        if ((r0[r4] + 1) != r8) goto L13;
        r0[r4] = r9;
        return;
    L13:
        int[] r2 = new int[r3 + 2];
        System.arraycopy(r0, 0, r2, 0, r3);
        this.ranges = r2;
        if (r2[r4] < r8) goto L16;
        setSorted(false);
    L16:
        int[] r1 = this.ranges;
        r1[r3] = r8;
        r1[r3 + 1] = r9;
        if (this.sorted == true) goto L21;
        sortRanges();
        return;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void compactRanges() {
        int[] r0 = this.ranges;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length > 2) goto L8;
        return;
    L8:
        if (isCompacted() == false) goto L10;
        return;
    L10:
        int r1 = 0;
        int r2 = 0;
    L11:
        int[] r3 = this.ranges;
        if (r1 >= r3.length) goto L36;
        if (r2 == r1) goto L15;
        int r4 = r1 + 1;
        r3[r2] = r3[r1];
        int r5 = r4 + 1;
        r3[r2 + 1] = r3[r4];
    L16:
        int r6 = r2 + 1;
        int r7 = r3[r6];
    L17:
        int[] r8 = this.ranges;
        if (r5 >= r8.length) goto L34;
        int r9 = r7 + 1;
        if (r9 < r8[r5]) goto L34;
        if (r9 != r8[r5]) goto L26;
        r8[r6] = r8[r5 + 1];
        r7 = r8[r6];
    L25:
        r5 = r5 + 2;
        goto L17
    L26:
        int r10 = r5 + 1;
        if (r7 >= r8[r10]) goto L25;
        if (r7 >= r8[r10]) goto L33;
        r8[r6] = r8[r10];
        r7 = r8[r6];
        goto L25
    L33:
        throw new RuntimeException("Token#compactRanges(): Internel Error: [" + this.ranges[r2] + "," + this.ranges[r6] + "] [" + this.ranges[r5] + "," + this.ranges[r10] + "]");
    L34:
        r2 = r2 + 2;
        r1 = r5;
        goto L11
    L15:
        r5 = r1 + 2;
        goto L16
    L36:
        if (r2 == r3.length) goto L38;
        int[] r11 = new int[r2];
        System.arraycopy(r3, 0, r11, 0, r2);
        this.ranges = r11;
    L38:
        setCompacted();
    }

    synchronized RangeToken getCaseInsensitiveToken() {
        monitor-enter(this);
        RangeToken r0 = this.icaseCache;     // Catch: Throwable -> L39
        if (r0 == null) goto L8;
        monitor-exit(this);
        return r0;
    L8:
        if (this.type != 4) goto L10;
        RangeToken r1 = Token.createRange();     // Catch: Throwable -> L39
    L11:
        int r2 = 0;
        int r3 = 0;
    L12:
        int[] r4 = this.ranges;     // Catch: Throwable -> L39
        if (r3 >= r4.length) goto L23;
        int r5 = r4[r3];     // Catch: Throwable -> L39
    L16:
        if (r5 > this.ranges[r3 + 1]) goto L21;
        if (r5 <= 65535) goto L19;
        r1.addRange(r5, r5);     // Catch: Throwable -> L39
    L20:
        r5 = r5 + 1;     // Catch: Throwable -> L39
        goto L16
    L19:
        char r6 = Character.toUpperCase((char) r5);     // Catch: Throwable -> L39
        r1.addRange(r6, r6);     // Catch: Throwable -> L39
        goto L20
    L21:
        r3 = r3 + 2;     // Catch: Throwable -> L39
        goto L12
    L23:
        if (this.type != 4) goto L25;
        RangeToken r7 = Token.createRange();     // Catch: Throwable -> L39
    L26:
        int[] r8 = r1.ranges;     // Catch: Throwable -> L39
        if (r2 >= r8.length) goto L36;
        int r9 = r8[r2];     // Catch: Throwable -> L39
    L30:
        if (r9 > r1.ranges[r2 + 1]) goto L35;
        if (r9 <= 65535) goto L33;
        r7.addRange(r9, r9);     // Catch: Throwable -> L39
    L34:
        r9 = r9 + 1;     // Catch: Throwable -> L39
        goto L30
    L33:
        char r10 = Character.toUpperCase((char) r9);     // Catch: Throwable -> L39
        r7.addRange(r10, r10);     // Catch: Throwable -> L39
        goto L34
    L35:
        r2 = r2 + 2;     // Catch: Throwable -> L39
        goto L26
    L36:
        r7.mergeRanges(r1);     // Catch: Throwable -> L39
        r7.mergeRanges(this);     // Catch: Throwable -> L39
        r7.compactRanges();     // Catch: Throwable -> L39
        this.icaseCache = r7;     // Catch: Throwable -> L39
        monitor-exit(this);
        return r7;
    L25:
        r7 = Token.createNRange();     // Catch: Throwable -> L39
        goto L26
    L10:
        r1 = Token.createNRange();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void intersectRanges(Token r13) {
        RangeToken r14 = (RangeToken) ZeusTransformUtils.preCheckCast(r13, RangeToken.class, "com.obric.memorydata.plugin");
        if (r14.ranges != null) goto L5;
        return;
    L5:
        if (this.ranges == null) goto L52;
        this.icaseCache = null;
        sortRanges();
        compactRanges();
        r14.sortRanges();
        r14.compactRanges();
        int[] r0 = new int[this.ranges.length + r14.ranges.length];
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L8:
        int[] r5 = this.ranges;
        if (r2 >= r5.length) goto L29;
        int[] r6 = r14.ranges;
        if (r3 >= r6.length) goto L29;
        int r7 = r5[r2];
        int r8 = r2 + 1;
        int r9 = r5[r8];
        int r10 = r6[r3];
        int r11 = r3 + 1;
        int r12 = r6[r11];
        if (r9 < r10) goto L14;
        if (r9 < r10) goto L25;
        if (r7 > r12) goto L25;
        if (r10 > r7) goto L20;
        if (r9 > r12) goto L20;
        int r15 = r4 + 1;
        r0[r4] = r7;
        r4 = r15 + 1;
        r0[r15] = r9;
    L20:
        if (r10 > r7) goto L22;
        int r16 = r4 + 1;
        r0[r4] = r7;
        r4 = r16 + 1;
        r0[r16] = r12;
        r5[r2] = r12 + 1;
    L26:
        r3 = r3 + 2;
        goto L8
    L22:
        if (r9 <= r12) goto L23;
        int r17 = r4 + 1;
        r0[r4] = r10;
        r4 = r17 + 1;
        r0[r17] = r12;
        r5[r2] = r12 + 1;
        goto L8
    L23:
        int r18 = r4 + 1;
        r0[r4] = r10;
        r4 = r18 + 1;
        r0[r18] = r9;
    L25:
        if (r12 < r7) goto L26;
        throw new RuntimeException("Token#intersectRanges(): Internal Error: [" + this.ranges[r2] + "," + this.ranges[r8] + "] & [" + r14.ranges[r3] + "," + r14.ranges[r11] + "]");
    L14:
        r2 = r2 + 2;
    L29:
        int[] r19 = this.ranges;
        if (r2 >= r19.length) goto L32;
        int r20 = r4 + 1;
        int r21 = r2 + 1;
        r0[r4] = r19[r2];
        r4 = r20 + 1;
        r2 = r21 + 1;
        r0[r20] = r19[r21];
        goto L29
    L32:
        int[] r110 = new int[r4];
        this.ranges = r110;
        System.arraycopy(r0, 0, r110, 0, r4);
        return;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    boolean match(int r6) {
        if (this.map != null) goto L6;
        createMap();
    L6:
        if (this.type != 4) goto L21;
        if (r6 < 256) goto L9;
        int r0 = this.nonMapIndex;
    L13:
        int[] r1 = this.ranges;
        if (r0 >= r1.length) goto L47;
        if (r1[r0] > r6) goto L20;
        if (r6 > r1[r0 + 1]) goto L20;
        return true;
    L20:
        r0 = r0 + 2;
        goto L13
    L47:
        return false;
    L9:
        if ((this.map[r6 / 32] & (1 << (r6 & 31))) != 0) goto L11;
        return false;
    L11:
        return true;
    L21:
        if (r6 < 256) goto L23;
        int r2 = this.nonMapIndex;
    L27:
        int[] r3 = this.ranges;
        if (r2 >= r3.length) goto L36;
        if (r3[r2] > r6) goto L34;
        if (r6 > r3[r2 + 1]) goto L34;
        return false;
    L34:
        r2 = r2 + 2;
        goto L27
    L36:
        return true;
    L23:
        if ((this.map[r6 / 32] & (1 << (r6 & 31))) == 0) goto L25;
        return false;
    L25:
        return true;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void mergeRanges(Token r9) {
        RangeToken r10 = (RangeToken) ZeusTransformUtils.preCheckCast(r9, RangeToken.class, "com.obric.memorydata.plugin");
        sortRanges();
        r10.sortRanges();
        if (r10.ranges != null) goto L5;
        return;
    L5:
        this.icaseCache = null;
        setSorted(true);
        int[] r0 = this.ranges;
        int r1 = 0;
        if (r0 != null) goto L9;
        int[] r2 = new int[r10.ranges.length];
        this.ranges = r2;
        int[] r8 = r10.ranges;
        System.arraycopy(r8, 0, r2, 0, r8.length);
        return;
    L9:
        int[] r3 = new int[r0.length + r10.ranges.length];
        int r4 = 0;
        int r5 = 0;
    L10:
        int[] r6 = this.ranges;
        if (r1 < r6.length) goto L18;
        if (r4 < r10.ranges.length) goto L18;
        this.ranges = r3;
        return;
    L18:
        if (r1 >= r6.length) goto L19;
        int[] r7 = r10.ranges;
        if (r4 >= r7.length) goto L22;
        if (r7[r4] < r6[r1]) goto L31;
        if (r7[r4] != r6[r1]) goto L30;
        if (r7[r4 + 1] < r6[r1 + 1]) goto L31;
    L30:
        int r11 = r5 + 1;
        int r12 = r1 + 1;
        r3[r5] = r6[r1];
        r5 = r11 + 1;
        r1 = r12 + 1;
        r3[r11] = r6[r12];
    L31:
        int r13 = r5 + 1;
        int r14 = r4 + 1;
        r3[r5] = r7[r4];
        r5 = r13 + 1;
        r4 = r14 + 1;
        r3[r13] = r7[r14];
        goto L10
    L22:
        int r15 = r5 + 1;
        int r16 = r1 + 1;
        r3[r5] = r6[r1];
        r5 = r15 + 1;
        r1 = r16 + 1;
        r3[r15] = r6[r16];
        goto L10
    L19:
        int r17 = r5 + 1;
        int[] r18 = r10.ranges;
        int r19 = r4 + 1;
        r3[r5] = r18[r4];
        r5 = r17 + 1;
        r4 = r19 + 1;
        r3[r17] = r18[r19];
        goto L10
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void sortRanges() {
        if (isSorted() == false) goto L5;
        return;
    L5:
        int[] r0 = this.ranges;
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = r0.length - 4;
    L9:
        if (r1 < 0) goto L21;
        int r2 = 0;
    L11:
        if (r2 > r1) goto L20;
        int[] r3 = this.ranges;
        int r4 = r2 + 2;
        if (r3[r2] <= r3[r4]) goto L15;
    L18:
        int r5 = r3[r4];
        r3[r4] = r3[r2];
        r3[r2] = r5;
        int r6 = r2 + 3;
        int r7 = r3[r6];
        int r8 = r2 + 1;
        r3[r6] = r3[r8];
        r3[r8] = r7;
    L19:
        r2 = r4;
        goto L11
    L15:
        if (r3[r2] != r3[r4]) goto L19;
        if (r3[r2 + 1] <= r3[r2 + 3]) goto L19;
    L20:
        r1 = r1 - 2;
        goto L9
    L21:
        setSorted(true);
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void subtractRanges(Token r13) {
        if (r13.type != 5) goto L6;
        intersectRanges(r13);
        return;
    L6:
        RangeToken r14 = (RangeToken) ZeusTransformUtils.preCheckCast(r13, RangeToken.class, "com.obric.memorydata.plugin");
        if (r14.ranges != null) goto L9;
        return;
    L9:
        if (this.ranges == null) goto L56;
        this.icaseCache = null;
        sortRanges();
        compactRanges();
        r14.sortRanges();
        r14.compactRanges();
        int[] r0 = new int[this.ranges.length + r14.ranges.length];
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
    L12:
        int[] r5 = this.ranges;
        if (r2 >= r5.length) goto L33;
        int[] r6 = r14.ranges;
        if (r3 >= r6.length) goto L33;
        int r7 = r5[r2];
        int r8 = r2 + 1;
        int r9 = r5[r8];
        int r10 = r6[r3];
        int r11 = r3 + 1;
        int r12 = r6[r11];
        if (r9 < r10) goto L18;
        if (r9 < r10) goto L29;
        if (r7 > r12) goto L29;
        if (r10 > r7) goto L24;
        if (r9 > r12) goto L24;
    L23:
        r2 = r2 + 2;
    L24:
        if (r10 <= r7) goto L25;
        if (r9 <= r12) goto L27;
        int r15 = r4 + 1;
        r0[r4] = r7;
        r4 = r15 + 1;
        r0[r15] = r10 - 1;
        r5[r2] = r12 + 1;
    L30:
        r3 = r3 + 2;
        goto L12
    L27:
        int r16 = r4 + 1;
        r0[r4] = r7;
        r4 = r16 + 1;
        r0[r16] = r10 - 1;
        goto L23
    L25:
        r5[r2] = r12 + 1;
    L29:
        if (r12 < r7) goto L30;
        throw new RuntimeException("Token#subtractRanges(): Internal Error: [" + this.ranges[r2] + "," + this.ranges[r8] + "] - [" + r14.ranges[r3] + "," + r14.ranges[r11] + "]");
    L18:
        int r17 = r4 + 1;
        r0[r4] = r5[r2];
        r4 = r17 + 1;
        r2 = r8 + 1;
        r0[r17] = r5[r8];
    L33:
        int[] r18 = this.ranges;
        if (r2 >= r18.length) goto L36;
        int r19 = r4 + 1;
        int r20 = r2 + 1;
        r0[r4] = r18[r2];
        r4 = r19 + 1;
        r2 = r20 + 1;
        r0[r19] = r18[r20];
        goto L33
    L36:
        int[] r110 = new int[r4];
        this.ranges = r110;
        System.arraycopy(r0, 0, r110, 0, r4);
        return;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public String toString(int r10) {
        int r4 = 0;
        if (this.type != 4) goto L29;
        if (this != Token.token_dot) goto L8;
        return ".";
    L8:
        if (this != Token.token_0to9) goto L11;
        return "\\d";
    L11:
        if (this != Token.token_wordchars) goto L14;
        return "\\w";
    L14:
        if (this != Token.token_spaces) goto L16;
        return "\\s";
    L16:
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
    L18:
        if (r4 >= this.ranges.length) goto L49;
        if ((r10 & 1024) == 0) goto L23;
        if (r4 <= 0) goto L23;
        r0.append(",");
    L23:
        int[] r5 = this.ranges;
        int r7 = r4 + 1;
        if (r5[r4] != r5[r7]) goto L26;
        int r6 = r5[r4];
    L27:
        r0.append(escapeCharInCharClass(r6));
        r4 = r4 + 2;
        goto L18
    L26:
        r0.append(escapeCharInCharClass(r5[r4]));
        r0.append('-');
        r6 = this.ranges[r7];
    L49:
        r0.append("]");
        return r0.toString();
    L29:
        if (this != Token.token_not_0to9) goto L32;
        return "\\D";
    L32:
        if (this != Token.token_not_wordchars) goto L35;
        return "\\W";
    L35:
        if (this != Token.token_not_spaces) goto L37;
        return "\\S";
    L37:
        r0 = new StringBuilder();
        r0.append("[^");
    L39:
        if (r4 >= this.ranges.length) goto L49;
        if ((r10 & 1024) == 0) goto L44;
        if (r4 <= 0) goto L44;
        r0.append(",");
    L44:
        int[] r8 = this.ranges;
        int r9 = r4 + 1;
        if (r8[r4] != r8[r9]) goto L47;
        int r11 = r8[r4];
    L48:
        r0.append(escapeCharInCharClass(r11));
        r4 = r4 + 2;
        goto L39
    L47:
        r0.append(escapeCharInCharClass(r8[r4]));
        r0.append('-');
        r11 = this.ranges[r9];
        goto L48
    }
}
