package com.ctc.wstx.shaded.msv_core.datatype.regexp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.CharacterIterator;

/* JADX INFO: loaded from: classes2.dex */
class RegularExpression implements Serializable {
    static final int CARRIAGE_RETURN = 13;
    static final boolean DEBUG = false;
    static final int EXTENDED_COMMENT = 16;
    static final int IGNORE_CASE = 2;
    static final int LINE_FEED = 10;
    static final int LINE_SEPARATOR = 8232;
    static final int MULTIPLE_LINES = 8;
    static final int PARAGRAPH_SEPARATOR = 8233;
    static final int PROHIBIT_FIXED_STRING_OPTIMIZATION = 256;
    static final int PROHIBIT_HEAD_CHARACTER_OPTIMIZATION = 128;
    static final int SINGLE_LINE = 4;
    static final int SPECIAL_COMMA = 1024;
    static final int UNICODE_WORD_BOUNDARY = 64;
    static final int USE_UNICODE_CATEGORY = 32;
    private static final int WT_IGNORE = 0;
    private static final int WT_LETTER = 1;
    private static final int WT_OTHER = 2;
    static final int XMLSCHEMA_MODE = 512;
    transient a context;
    transient RangeToken firstChar;
    transient String fixedString;
    transient boolean fixedStringOnly;
    transient int fixedStringOptions;
    transient com.ctc.wstx.shaded.msv_core.datatype.regexp.a fixedStringTable;
    boolean hasBackReferences;
    transient int minlength;
    int nofparen;
    transient int numberOfClosures;
    transient c operations;
    int options;
    String regex;
    Token tokentree;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CharacterIterator f3554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f3555b;
        char[] c;
        int d;
        int e;
        int f;
        b g;
        boolean h;
        int[] i;

        a() {
            this.h = false;
        }

        private void a(int r4) {
            this.f = this.e - this.d;
            this.h = true;
            this.g = null;
            int[] r0 = this.i;
            if (r0 != null) goto L5;
        L6:
            this.i = new int[r4];
        L7:
            int r1 = 0;
        L8:
            if (r1 >= r4) goto L10;
            this.i[r1] = -1;
            r1 = r1 + 1;
            goto L8
        L10:
            return;
        L5:
            if (r0.length == r4) goto L7;
            goto L6
        }

        void a(String r1, int r2, int r3, int r4) {
            this.f3555b = r1;
            this.d = r2;
            this.e = r3;
            a(r4);
        }

        void a(CharacterIterator r3, int r4, int r5, int r6) {
            this.f3554a = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r3, CharacterIterator.class, "com.obric.memorydata.plugin");
            this.d = r4;
            this.e = r5;
            a(r6);
        }

        void a(char[] r1, int r2, int r3, int r4) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            a(r4);
        }
    }

    public RegularExpression(String r3) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(r3, null);
    }

    RegularExpression(String r3, Token r4, int r5, boolean r6, int r7) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        this.regex = r3;
        this.tokentree = r4;
        this.nofparen = r5;
        this.options = r7;
        this.hasBackReferences = r6;
    }

    public RegularExpression(String r3, String r4) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(r3, r4);
    }

    private c compile(Token r10, c r11, boolean r12) {
        int r0 = r10.type;
        int r2 = 0;
        switch(r0) {
            case 0: goto L81;
            case 1: goto L74;
            case 2: goto L69;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L38;
            case 6: goto L31;
            case 7: goto L92;
            case 8: goto L29;
            case 9: goto L39;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            default: goto L4;
        };
    L4:
        c r4 = null;
        switch(r0) {
            case 20: goto L23;
            case 21: goto L22;
            case 22: goto L20;
            case 23: goto L19;
            case 24: goto L95;
            case 25: goto L94;
            case 26: goto L8;
            default: goto L7;
        };
    L8:
        Token.ConditionToken r13 = (Token.ConditionToken) ZeusTransformUtils.preCheckCast(r10, Token.ConditionToken.class, "com.obric.memorydata.plugin");
        int r1 = r13.refNumber;
        if (r13.condition != null) goto L11;
        c r3 = null;
    L12:
        c r5 = compile(r13.yes, r11, r12);
        if (r13.no == null) goto L93;
        r4 = compile(r13.no, r11, r12);
    L93:
        return c.a(r11, r1, r3, r5, r4);
    L11:
        r3 = compile(r13.condition, null, r12);
        goto L12
    L19:
        int r14 = 23;
    L21:
        c r9 = compile(r10.getChild(0), null, true);
    L96:
        return c.a(r14, r11, r9);
    L20:
        r14 = 22;
        goto L21
    L22:
        r14 = 21;
    L24:
        r9 = compile(r10.getChild(0), null, false);
        goto L96
    L23:
        r14 = 20;
        goto L24
    L7:
        throw new RuntimeException("Unknown token type: " + r10.type);
    L94:
        return c.a(r11, compile(r10.getChild(0), null, r12), ((Token.ModifierToken) ZeusTransformUtils.preCheckCast(r10, Token.ModifierToken.class, "com.obric.memorydata.plugin")).getOptions(), ((Token.ModifierToken) ZeusTransformUtils.preCheckCast(r10, Token.ModifierToken.class, "com.obric.memorydata.plugin")).getOptionsMask());
    L95:
        return c.a(r11, compile(r10.getChild(0), null, r12));
    L26:
        c r15 = c.e(r10.getReferenceNumber());
    L82:
        r15.c = r11;
        return r15;
    L27:
        r15 = c.a();
        goto L82
    L28:
        r15 = c.a(r10.getString());
        goto L82
    L29:
        r15 = c.b(r10.getChar());
        goto L82
    L38:
        r15 = c.a(r10);
        goto L82
    L39:
        Token r6 = r10.getChild(0);
        int r7 = r10.getMin();
        int r8 = r10.getMax();
        if (r7 < 0) goto L44;
        if (r7 != r8) goto L44;
    L42:
        if (r2 >= r7) goto L101;
        r11 = compile(r6, r11, r12);
        r2 = r2 + 1;
        goto L42
    L101:
        return r11;
    L44:
        if (r7 <= 0) goto L48;
        if (r8 <= 0) goto L48;
        r8 = r8 - r7;
    L48:
        if (r8 <= 0) goto L58;
        c r16 = r11;
        int r17 = 0;
    L50:
        if (r17 >= r8) goto L56;
        if (r10.type != 9) goto L54;
        boolean r18 = true;
    L55:
        c.b r19 = c.a(r18);
        r19.c = r11;
        r19.a(compile(r6, r16, r12));
        r17 = r17 + 1;
        r16 = r19;
        goto L50
    L54:
        r18 = false;
        goto L55
    L56:
        c r110 = r16;
    L66:
        if (r7 <= 0) goto L99;
    L67:
        if (r2 >= r7) goto L102;
        r110 = compile(r6, r110, r12);
        r2 = r2 + 1;
        goto L67
    L102:
        return r110;
    L99:
        return r110;
    L58:
        if (r10.type != 9) goto L61;
        c.b r111 = c.b();
    L65:
        r111.c = r11;
        r111.a(compile(r6, r111, r12));
        r110 = r111;
        goto L66
    L61:
        if (r6.getMinLength() != 0) goto L63;
        int r112 = this.numberOfClosures;
        this.numberOfClosures = r112 + 1;
    L64:
        r111 = c.d(r112);
        goto L65
    L63:
        r112 = -1;
        goto L64
    L69:
        c.g r20 = c.c(r10.size());
    L71:
        if (r2 >= r10.size()) goto L100;
        r20.a(compile(r10.getChild(r2), r11, r12));
        r2 = r2 + 1;
        goto L71
    L100:
        return r20;
    L74:
        if (r12 == true) goto L79;
        int r113 = r10.size() - 1;
    L76:
        if (r113 < 0) goto L103;
        r11 = compile(r10.getChild(r113), r11, false);
        r113 = r113 - 1;
        goto L76
    L103:
        return r11;
    L79:
        if (r2 >= r10.size()) goto L104;
        r11 = compile(r10.getChild(r2), r11, true);
        r2 = r2 + 1;
        goto L79
    L104:
        return r11;
    L81:
        r15 = c.a(r10.getChar());
        goto L82
    L92:
        return r11;
    L31:
        if (r10.getParenNumber() == 0) goto L97;
        int r21 = r10.getParenNumber();
        if (r12 == false) goto L36;
        c r22 = compile(r10.getChild(0), c.a(r21, r11), r12);
        int r114 = -r10.getParenNumber();
    L98:
        return c.a(r114, r22);
    L36:
        r22 = compile(r10.getChild(0), c.a(-r21, r11), r12);
        r114 = r10.getParenNumber();
        goto L98
    L97:
        return compile(r10.getChild(0), r11, r12);
    }

    private synchronized void compile(Token r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.operations == null) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.numberOfClosures = 0;     // Catch: Throwable -> L11
        this.operations = compile(r3, null, false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private static final int getPreviousWordType(String r1, int r2, int r3, int r4, int r5) {
    L2:
        r4 = r4 - 1;
        int r0 = getWordType(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L2;
        return r0;
    }

    private static final int getPreviousWordType(CharacterIterator r2, int r3, int r4, int r5, int r6) {
        CharacterIterator r7 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r2, CharacterIterator.class, "com.obric.memorydata.plugin");
    L3:
        r5 = r5 - 1;
        int r0 = getWordType(r7, r3, r4, r5, r6);
        if (r0 == 0) goto L3;
        return r0;
    }

    private static final int getPreviousWordType(char[] r1, int r2, int r3, int r4, int r5) {
    L2:
        r4 = r4 - 1;
        int r0 = getWordType(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L2;
        return r0;
    }

    private static final int getWordType(String r0, int r1, int r2, int r3, int r4) {
        if (r3 < r1) goto L7;
        if (r3 < r2) goto L6;
        return 2;
    L6:
        return getWordType0(r0.charAt(r3), r4);
    L7:
        return 2;
    }

    private static final int getWordType(CharacterIterator r2, int r3, int r4, int r5, int r6) {
        CharacterIterator r7 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r2, CharacterIterator.class, "com.obric.memorydata.plugin");
        if (r5 < r3) goto L8;
        if (r5 < r4) goto L7;
        return 2;
    L7:
        return getWordType0(r7.setIndex(r5), r6);
    L8:
        return 2;
    }

    private static final int getWordType(char[] r0, int r1, int r2, int r3, int r4) {
        if (r3 < r1) goto L7;
        if (r3 < r2) goto L6;
        return 2;
    L6:
        return getWordType0(r0[r3], r4);
    L7:
        return 2;
    }

    private static final int getWordType0(char r4, int r5) {
        if (isSet(r5, 64) == false) goto L5;
        int r6 = Character.getType(r4);
        if (r6 != 15) goto L17;
        switch(r4) {
            case 9: goto L24;
            case 10: goto L24;
            case 11: goto L24;
            case 12: goto L24;
            case 13: goto L24;
            default: goto L23;
        };
    L23:
        return 0;
    L24:
        return 2;
    L17:
        if (r6 == 16) goto L21;
        switch(r6) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L20;
            case 6: goto L21;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            case 11: goto L20;
            default: goto L19;
        };
    L19:
        return 2;
    L20:
        return 1;
    L21:
        return 0;
    L5:
        if (isSet(r5, 32) == false) goto L11;
        if (Token.getRange("IsWord", true).match(r4) == true) goto L9;
        return 2;
    L9:
        return 1;
    L11:
        if (isWordChar(r4) == true) goto L13;
        return 2;
    L13:
        return 1;
    }

    private static final boolean isEOLChar(int r1) {
        if (r1 != 10) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 13) goto L12;
        if (r1 == LINE_SEPARATOR) goto L12;
        if (r1 == PARAGRAPH_SEPARATOR) goto L12;
        return false;
    }

    private static final boolean isSet(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean isWordChar(int r3) {
        if (r3 != 95) goto L6;
        return true;
    L6:
        if (r3 >= 48) goto L9;
        return false;
    L9:
        if (r3 <= 122) goto L12;
        return false;
    L12:
        if (r3 > 57) goto L15;
        return true;
    L15:
        if (r3 >= 65) goto L18;
        return false;
    L18:
        if (r3 > 90) goto L21;
        return true;
    L21:
        if (r3 >= 97) goto L23;
        return false;
    L23:
        return true;
    }

    private int matchCharArray(a r11, c r12, int r13, int r14, int r15) {
        char[] r0 = r11.c;
    L4:
        if (r12 == null) goto L6;
        if (r13 > r11.e) goto L386;
        if (r13 < r11.d) goto L386;
        int r1 = r12.f3563b;
        boolean r8 = true;
        if (r1 == 0) goto L349;
        if (r1 == 1) goto L319;
        if (r1 == 15) goto L304;
        if (r1 == 16) goto L276;
        int r9 = 0;
        switch(r1) {
            case 3: goto L229;
            case 4: goto L229;
            case 5: goto L111;
            case 6: goto L94;
            case 7: goto L81;
            case 8: goto L77;
            case 9: goto L74;
            case 10: goto L77;
            case 11: goto L68;
            default: goto L26;
        };
    L68:
        if (r9 >= r12.c()) goto L73;
        int r2 = matchCharArray(r11, r12.f(r9), r13, r14, r15);
        if (r2 >= 0) goto L71;
        r9 = r9 + 1;
        goto L68
    L71:
        return r2;
    L73:
        return -1;
    L74:
        int r3 = matchCharArray(r11, r12.d(), r13, r14, r15);
        if (r3 >= 0) goto L76;
    L227:
        r12 = r12.c;
        goto L4
    L76:
        return r3;
    L77:
        int r4 = matchCharArray(r11, r12.c, r13, r14, r15);
        if (r4 >= 0) goto L79;
        r12 = r12.d();
        goto L4
    L79:
        return r4;
    L81:
        int r10 = r12.e();
        if (r10 < 0) goto L89;
        int r5 = r11.i[r10];
        if (r5 < 0) goto L88;
        if (r5 != r13) goto L88;
        r11.i[r10] = -1;
    L88:
        r11.i[r10] = r13;
    L89:
        int r6 = matchCharArray(r11, r12.d(), r13, r14, r15);
        if (r10 < 0) goto L92;
        r11.i[r10] = -1;
    L92:
        if (r6 < 0) goto L227;
        return r6;
    L94:
        String r7 = r12.h();
        int r16 = r7.length();
        if (isSet(r15, 2) == true) goto L103;
        if (r14 > 0) goto L98;
        r13 = r13 - r16;
        if (regionMatches(r0, r13, r11.e, r7, r16) == true) goto L227;
        return -1;
    L98:
        if (regionMatches(r0, r13, r11.e, r7, r16) == false) goto L99;
    L107:
        r13 = r13 + r16;
        goto L227
    L99:
        return -1;
    L103:
        if (r14 > 0) goto L105;
        r13 = r13 - r16;
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r7, r16) == true) goto L227;
        return -1;
    L105:
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r7, r16) == true) goto L107;
        return -1;
    L111:
        int r17 = r12.e();
        if (r17 == 36) goto L206;
        if (r17 == 60) goto L196;
        if (r17 == 62) goto L186;
        if (r17 == 90) goto L173;
        if (r17 == 94) goto L161;
        if (r17 == 98) goto L152;
        if (r17 == 122) goto L149;
        switch(r17) {
            case 64: goto L142;
            case 65: goto L139;
            case 66: goto L128;
            default: goto L227;
        };
    L128:
        if (r11.f == 0) goto L136;
        int r18 = getWordType(r0, r11.d, r11.e, r13, r15);
        if (r18 == 0) goto L136;
        if (r18 == getPreviousWordType(r0, r11.d, r11.e, r13, r15)) goto L136;
        r8 = false;
    L136:
        if (r8 == true) goto L227;
        return -1;
    L139:
        if (r13 == r11.d) goto L227;
        return -1;
    L142:
        if (r13 == r11.d) goto L227;
        if (r13 <= r11.d) goto L147;
        if (isEOLChar(r0[r13 - 1]) == true) goto L227;
    L147:
        return -1;
    L149:
        if (r13 == r11.e) goto L227;
        return -1;
    L152:
        if (r11.f == 0) goto L153;
        int r19 = getWordType(r0, r11.d, r11.e, r13, r15);
        if (r19 == 0) goto L156;
        if (r19 != getPreviousWordType(r0, r11.d, r11.e, r13, r15)) goto L227;
        return -1;
    L156:
        return -1;
    L153:
        return -1;
    L161:
        if (isSet(r15, 8) == false) goto L170;
        if (r13 == r11.d) goto L227;
        if (r13 <= r11.d) goto L168;
        if (isEOLChar(r0[r13 - 1]) == true) goto L227;
    L168:
        return -1;
    L170:
        if (r13 == r11.d) goto L227;
        return -1;
    L173:
        if (r13 == r11.e) goto L227;
        int r20 = r13 + 1;
        if (r20 != r11.e) goto L179;
        if (isEOLChar(r0[r13]) == true) goto L227;
    L179:
        if ((r13 + 2) != r11.e) goto L184;
        if (r0[r13] != '\r') goto L184;
        if (r0[r20] == '\n') goto L227;
    L184:
        return -1;
    L186:
        if (r11.f == 0) goto L194;
        if (r13 == r11.d) goto L194;
        if (getWordType(r0, r11.d, r11.e, r13, r15) != 2) goto L194;
        if (getPreviousWordType(r0, r11.d, r11.e, r13, r15) == 1) goto L227;
    L194:
        return -1;
    L196:
        if (r11.f == 0) goto L204;
        if (r13 == r11.e) goto L204;
        if (getWordType(r0, r11.d, r11.e, r13, r15) != 1) goto L204;
        if (getPreviousWordType(r0, r11.d, r11.e, r13, r15) == 2) goto L227;
    L204:
        return -1;
    L206:
        if (isSet(r15, 8) == false) goto L215;
        if (r13 == r11.e) goto L227;
        if (r13 >= r11.e) goto L213;
        if (isEOLChar(r0[r13]) == true) goto L227;
    L213:
        return -1;
    L215:
        if (r13 == r11.e) goto L227;
        int r21 = r13 + 1;
        if (r21 != r11.e) goto L221;
        if (isEOLChar(r0[r13]) == true) goto L227;
    L221:
        if ((r13 + 2) != r11.e) goto L226;
        if (r0[r13] != '\r') goto L226;
        if (r0[r21] == '\n') goto L227;
    L226:
        return -1;
    L229:
        if (r14 > 0) goto L231;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L275;
        if (r13 < 0) goto L275;
        char r22 = r0[r13];
        boolean r23 = e.a(r22);
        int r24 = r22;
        if (r23 == false) goto L262;
        r24 = r22;
        if ((r13 - 1) < 0) goto L262;
        r13 = r13 - 1;
        r24 = e.a(r0[r13], r22);
    L262:
        RangeToken r25 = r12.g();
        if (isSet(r15, 2) == false) goto L274;
        RangeToken r26 = r25.getCaseInsensitiveToken();
        if (r26.match(r24) == true) goto L227;
        if (r24 >= 65536) goto L267;
        char r27 = Character.toUpperCase((char) r24);
        if (r26.match(r27) == true) goto L227;
        if (r26.match(Character.toLowerCase(r27)) == true) goto L227;
        return -1;
    L267:
        return -1;
    L274:
        if (r25.match(r24) == true) goto L227;
    L275:
        return -1;
    L231:
        if (r13 >= r11.e) goto L232;
        char r28 = r0[r13];
        boolean r29 = e.b(r28);
        int r30 = r28;
        if (r29 == false) goto L238;
        int r31 = r13 + 1;
        r30 = r28;
        if (r31 >= r11.e) goto L238;
        r13 = r31;
        r30 = e.a(r28, r0[r31]);
    L238:
        RangeToken r32 = r12.g();
        if (isSet(r15, 2) == false) goto L250;
        RangeToken r33 = r32.getCaseInsensitiveToken();
        if (r33.match(r30) == true) goto L252;
        if (r30 >= 65536) goto L243;
        char r34 = Character.toUpperCase((char) r30);
        if (r33.match(r34) == true) goto L252;
        if (r33.match(Character.toLowerCase(r34)) == true) goto L252;
        return -1;
    L243:
        return -1;
    L252:
        r13 = r13 + 1;
        goto L227
    L250:
        if (r32.match(r30) == true) goto L252;
        return -1;
    L232:
        return -1;
    L26:
        switch(r1) {
            case 20: goto L65;
            case 21: goto L62;
            case 22: goto L59;
            case 23: goto L56;
            case 24: goto L52;
            case 25: goto L49;
            case 26: goto L29;
            default: goto L28;
        };
    L28:
        throw new RuntimeException("Unknown operation type: " + r12.f3563b);
    L49:
        r13 = matchCharArray(r11, r12.d(), r13, r14, (r12.e() | r15) & (~r12.f()));
        if (r13 >= 0) goto L227;
        return r13;
    L52:
        r13 = matchCharArray(r11, r12.d(), r13, r14, r15);
        if (r13 >= 0) goto L227;
        return r13;
    L56:
        if (matchCharArray(r11, r12.d(), r13, -1, r15) < 0) goto L227;
        return -1;
    L59:
        if (matchCharArray(r11, r12.d(), r13, -1, r15) >= 0) goto L227;
        return -1;
    L62:
        if (matchCharArray(r11, r12.d(), r13, 1, r15) < 0) goto L227;
        return -1;
    L65:
        if (matchCharArray(r11, r12.d(), r13, 1, r15) >= 0) goto L227;
        return -1;
    L29:
        c.C0175c r110 = (c.C0175c) ZeusTransformUtils.preCheckCast(r12, c.C0175c.class, "com.obric.memorydata.plugin");
        if (r110.d <= 0) goto L42;
        if (r110.d >= this.nofparen) goto L40;
        if (r11.g.b(r110.d) >= 0) goto L36;
    L38:
        r8 = false;
    L43:
        if (r8 == true) goto L44;
        if (r110.g != null) goto L47;
        r12 = r110.c;
        goto L4
    L47:
        r12 = r110.g;
        goto L4
    L44:
        r12 = r110.f;
        goto L4
    L36:
        if (r11.g.c(r110.d) < 0) goto L38;
    L40:
        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + r110.d);
    L42:
        if (matchCharArray(r11, r110.e, r13, r14, r15) < 0) goto L38;
    L276:
        int r35 = r12.e();
        if (r35 <= 0) goto L303;
        if (r35 >= this.nofparen) goto L303;
        if (r11.g.b(r35) < 0) goto L301;
        if (r11.g.c(r35) < 0) goto L301;
        int r36 = r11.g.b(r35);
        int r37 = r11.g.c(r35) - r36;
        if (isSet(r15, 2) == true) goto L294;
        if (r14 > 0) goto L289;
        r13 = r13 - r37;
        if (regionMatches(r0, r13, r11.e, r36, r37) == true) goto L227;
        return -1;
    L289:
        if (regionMatches(r0, r13, r11.e, r36, r37) == false) goto L290;
    L298:
        r13 = r13 + r37;
        goto L227
    L290:
        return -1;
    L294:
        if (r14 > 0) goto L296;
        r13 = r13 - r37;
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r36, r37) == true) goto L227;
    L296:
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r36, r37) == true) goto L298;
        return -1;
    L301:
        return -1;
    L303:
        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + r35);
    L304:
        int r38 = r12.e();
        if (r11.g == null) goto L312;
        if (r38 <= 0) goto L312;
        int r39 = r11.g.b(r38);
        r11.g.a(r38, r13);
        int r111 = matchCharArray(r11, r12.c, r13, r14, r15);
        if (r111 >= 0) goto L310;
        r11.g.a(r38, r39);
    L310:
        return r111;
    L312:
        if (r11.g == null) goto L227;
        if (r38 >= 0) goto L227;
        int r40 = -r38;
        int r41 = r11.g.c(r40);
        r11.g.b(r40, r13);
        int r112 = matchCharArray(r11, r12.c, r13, r14, r15);
        if (r112 >= 0) goto L317;
        r11.g.b(r40, r41);
    L317:
        return r112;
    L319:
        if (isSet(r15, 2) == false) goto L333;
        int r42 = r12.e();
        if (r14 > 0) goto L323;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L332;
        if (r13 < 0) goto L332;
        if (matchIgnoreCase(r42, r0[r13]) == true) goto L227;
    L332:
        return -1;
    L323:
        if (r13 >= r11.e) goto L326;
        if (matchIgnoreCase(r42, r0[r13]) == false) goto L326;
    L340:
        r13 = r13 + 1;
    L326:
        return -1;
    L333:
        int r43 = r12.e();
        if (r14 > 0) goto L336;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L347;
        if (r13 < 0) goto L347;
        if (r43 == r0[r13]) goto L227;
    L347:
        return -1;
    L336:
        if (r13 >= r11.e) goto L341;
        if (r43 == r0[r13]) goto L340;
    L341:
        return -1;
    L349:
        if (r14 > 0) goto L351;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L386;
        if (r13 < 0) goto L386;
        char r44 = r0[r13];
        if (isSet(r15, 4) == true) goto L375;
        boolean r45 = e.a(r44);
        int r46 = r44;
        if (r45 == false) goto L385;
        r46 = r44;
        if ((r13 - 1) < 0) goto L385;
        r13 = r13 - 1;
        r46 = e.a(r0[r13], r44);
    L385:
        if (isEOLChar(r46) == true) goto L227;
    L375:
        if (e.a(r44) == false) goto L227;
        if ((r13 - 1) < 0) goto L227;
        r13 = r13 - 1;
        goto L227
    L351:
        if (r13 >= r11.e) goto L352;
        char r47 = r0[r13];
        if (isSet(r15, 4) == true) goto L356;
        boolean r48 = e.b(r47);
        int r49 = r47;
        if (r48 == false) goto L366;
        int r50 = r13 + 1;
        r49 = r47;
        if (r50 >= r11.e) goto L366;
        r13 = r50;
        r49 = e.a(r47, r0[r50]);
    L366:
        if (isEOLChar(r49) == false) goto L252;
        return -1;
    L356:
        if (e.b(r47) == false) goto L252;
        int r51 = r13 + 1;
        if (r51 >= r11.e) goto L252;
        r13 = r51;
        goto L252
    L352:
        return -1;
    L386:
        return -1;
    L6:
        if (isSet(r15, 512) == true) goto L8;
        return r13;
    L8:
        if (r13 != r11.e) goto L10;
        return r13;
    L10:
        return -1;
    }

    private int matchCharacterIterator(a r11, c r12, int r13, int r14, int r15) {
        CharacterIterator r0 = r11.f3554a;
    L4:
        if (r12 == null) goto L6;
        if (r13 > r11.e) goto L386;
        if (r13 < r11.d) goto L386;
        int r1 = r12.f3563b;
        boolean r8 = true;
        if (r1 == 0) goto L349;
        if (r1 == 1) goto L319;
        if (r1 == 15) goto L304;
        if (r1 == 16) goto L276;
        int r9 = 0;
        switch(r1) {
            case 3: goto L229;
            case 4: goto L229;
            case 5: goto L111;
            case 6: goto L94;
            case 7: goto L81;
            case 8: goto L77;
            case 9: goto L74;
            case 10: goto L77;
            case 11: goto L68;
            default: goto L26;
        };
    L68:
        if (r9 >= r12.c()) goto L73;
        int r2 = matchCharacterIterator(r11, r12.f(r9), r13, r14, r15);
        if (r2 >= 0) goto L71;
        r9 = r9 + 1;
        goto L68
    L71:
        return r2;
    L73:
        return -1;
    L74:
        int r3 = matchCharacterIterator(r11, r12.d(), r13, r14, r15);
        if (r3 >= 0) goto L76;
    L227:
        r12 = r12.c;
        goto L4
    L76:
        return r3;
    L77:
        int r4 = matchCharacterIterator(r11, r12.c, r13, r14, r15);
        if (r4 >= 0) goto L79;
        r12 = r12.d();
        goto L4
    L79:
        return r4;
    L81:
        int r10 = r12.e();
        if (r10 < 0) goto L89;
        int r5 = r11.i[r10];
        if (r5 < 0) goto L88;
        if (r5 != r13) goto L88;
        r11.i[r10] = -1;
    L88:
        r11.i[r10] = r13;
    L89:
        int r6 = matchCharacterIterator(r11, r12.d(), r13, r14, r15);
        if (r10 < 0) goto L92;
        r11.i[r10] = -1;
    L92:
        if (r6 < 0) goto L227;
        return r6;
    L94:
        String r7 = r12.h();
        int r16 = r7.length();
        if (isSet(r15, 2) == true) goto L103;
        if (r14 > 0) goto L98;
        r13 = r13 - r16;
        if (regionMatches(r0, r13, r11.e, r7, r16) == true) goto L227;
        return -1;
    L98:
        if (regionMatches(r0, r13, r11.e, r7, r16) == false) goto L99;
    L107:
        r13 = r13 + r16;
        goto L227
    L99:
        return -1;
    L103:
        if (r14 > 0) goto L105;
        r13 = r13 - r16;
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r7, r16) == true) goto L227;
        return -1;
    L105:
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r7, r16) == true) goto L107;
        return -1;
    L111:
        int r17 = r12.e();
        if (r17 == 36) goto L206;
        if (r17 == 60) goto L196;
        if (r17 == 62) goto L186;
        if (r17 == 90) goto L173;
        if (r17 == 94) goto L161;
        if (r17 == 98) goto L152;
        if (r17 == 122) goto L149;
        switch(r17) {
            case 64: goto L142;
            case 65: goto L139;
            case 66: goto L128;
            default: goto L227;
        };
    L128:
        if (r11.f == 0) goto L136;
        int r18 = getWordType(r0, r11.d, r11.e, r13, r15);
        if (r18 == 0) goto L136;
        if (r18 == getPreviousWordType(r0, r11.d, r11.e, r13, r15)) goto L136;
        r8 = false;
    L136:
        if (r8 == true) goto L227;
        return -1;
    L139:
        if (r13 == r11.d) goto L227;
        return -1;
    L142:
        if (r13 == r11.d) goto L227;
        if (r13 <= r11.d) goto L147;
        if (isEOLChar(r0.setIndex(r13 - 1)) == true) goto L227;
    L147:
        return -1;
    L149:
        if (r13 == r11.e) goto L227;
        return -1;
    L152:
        if (r11.f == 0) goto L153;
        int r19 = getWordType(r0, r11.d, r11.e, r13, r15);
        if (r19 == 0) goto L156;
        if (r19 != getPreviousWordType(r0, r11.d, r11.e, r13, r15)) goto L227;
        return -1;
    L156:
        return -1;
    L153:
        return -1;
    L161:
        if (isSet(r15, 8) == false) goto L170;
        if (r13 == r11.d) goto L227;
        if (r13 <= r11.d) goto L168;
        if (isEOLChar(r0.setIndex(r13 - 1)) == true) goto L227;
    L168:
        return -1;
    L170:
        if (r13 == r11.d) goto L227;
        return -1;
    L173:
        if (r13 == r11.e) goto L227;
        int r20 = r13 + 1;
        if (r20 != r11.e) goto L179;
        if (isEOLChar(r0.setIndex(r13)) == true) goto L227;
    L179:
        if ((r13 + 2) != r11.e) goto L184;
        if (r0.setIndex(r13) != '\r') goto L184;
        if (r0.setIndex(r20) == '\n') goto L227;
    L184:
        return -1;
    L186:
        if (r11.f == 0) goto L194;
        if (r13 == r11.d) goto L194;
        if (getWordType(r0, r11.d, r11.e, r13, r15) != 2) goto L194;
        if (getPreviousWordType(r0, r11.d, r11.e, r13, r15) == 1) goto L227;
    L194:
        return -1;
    L196:
        if (r11.f == 0) goto L204;
        if (r13 == r11.e) goto L204;
        if (getWordType(r0, r11.d, r11.e, r13, r15) != 1) goto L204;
        if (getPreviousWordType(r0, r11.d, r11.e, r13, r15) == 2) goto L227;
    L204:
        return -1;
    L206:
        if (isSet(r15, 8) == false) goto L215;
        if (r13 == r11.e) goto L227;
        if (r13 >= r11.e) goto L213;
        if (isEOLChar(r0.setIndex(r13)) == true) goto L227;
    L213:
        return -1;
    L215:
        if (r13 == r11.e) goto L227;
        int r21 = r13 + 1;
        if (r21 != r11.e) goto L221;
        if (isEOLChar(r0.setIndex(r13)) == true) goto L227;
    L221:
        if ((r13 + 2) != r11.e) goto L226;
        if (r0.setIndex(r13) != '\r') goto L226;
        if (r0.setIndex(r21) == '\n') goto L227;
    L226:
        return -1;
    L229:
        if (r14 > 0) goto L231;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L275;
        if (r13 < 0) goto L275;
        int r22 = r0.setIndex(r13);
        if (e.a(r22) == true) goto L260;
    L262:
        RangeToken r23 = r12.g();
        if (isSet(r15, 2) == false) goto L274;
        RangeToken r24 = r23.getCaseInsensitiveToken();
        if (r24.match(r22) == true) goto L227;
        if (r22 >= 65536) goto L267;
        char r25 = Character.toUpperCase((char) r22);
        if (r24.match(r25) == true) goto L227;
        if (r24.match(Character.toLowerCase(r25)) == true) goto L227;
        return -1;
    L267:
        return -1;
    L274:
        if (r23.match(r22) == true) goto L227;
    L260:
        if ((r13 - 1) < 0) goto L262;
        r13 = r13 - 1;
        r22 = e.a(r0.setIndex(r13), r22);
    L275:
        return -1;
    L231:
        if (r13 >= r11.e) goto L232;
        int r26 = r0.setIndex(r13);
        if (e.b(r26) == false) goto L238;
        int r27 = r13 + 1;
        if (r27 >= r11.e) goto L238;
        r26 = e.a(r26, r0.setIndex(r27));
        r13 = r27;
    L238:
        RangeToken r28 = r12.g();
        if (isSet(r15, 2) == false) goto L250;
        RangeToken r29 = r28.getCaseInsensitiveToken();
        if (r29.match(r26) == true) goto L252;
        if (r26 >= 65536) goto L243;
        char r30 = Character.toUpperCase((char) r26);
        if (r29.match(r30) == true) goto L252;
        if (r29.match(Character.toLowerCase(r30)) == true) goto L252;
        return -1;
    L243:
        return -1;
    L252:
        r13 = r13 + 1;
        goto L227
    L250:
        if (r28.match(r26) == true) goto L252;
        return -1;
    L232:
        return -1;
    L26:
        switch(r1) {
            case 20: goto L65;
            case 21: goto L62;
            case 22: goto L59;
            case 23: goto L56;
            case 24: goto L52;
            case 25: goto L49;
            case 26: goto L29;
            default: goto L28;
        };
    L28:
        throw new RuntimeException("Unknown operation type: " + r12.f3563b);
    L49:
        r13 = matchCharacterIterator(r11, r12.d(), r13, r14, (r12.e() | r15) & (~r12.f()));
        if (r13 >= 0) goto L227;
        return r13;
    L52:
        r13 = matchCharacterIterator(r11, r12.d(), r13, r14, r15);
        if (r13 >= 0) goto L227;
        return r13;
    L56:
        if (matchCharacterIterator(r11, r12.d(), r13, -1, r15) < 0) goto L227;
        return -1;
    L59:
        if (matchCharacterIterator(r11, r12.d(), r13, -1, r15) >= 0) goto L227;
        return -1;
    L62:
        if (matchCharacterIterator(r11, r12.d(), r13, 1, r15) < 0) goto L227;
        return -1;
    L65:
        if (matchCharacterIterator(r11, r12.d(), r13, 1, r15) >= 0) goto L227;
        return -1;
    L29:
        c.C0175c r110 = (c.C0175c) ZeusTransformUtils.preCheckCast(r12, c.C0175c.class, "com.obric.memorydata.plugin");
        if (r110.d <= 0) goto L42;
        if (r110.d >= this.nofparen) goto L40;
        if (r11.g.b(r110.d) >= 0) goto L36;
    L38:
        r8 = false;
    L43:
        if (r8 == true) goto L44;
        if (r110.g != null) goto L47;
        r12 = r110.c;
        goto L4
    L47:
        r12 = r110.g;
        goto L4
    L44:
        r12 = r110.f;
        goto L4
    L36:
        if (r11.g.c(r110.d) < 0) goto L38;
    L40:
        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + r110.d);
    L42:
        if (matchCharacterIterator(r11, r110.e, r13, r14, r15) < 0) goto L38;
    L276:
        int r31 = r12.e();
        if (r31 <= 0) goto L303;
        if (r31 >= this.nofparen) goto L303;
        if (r11.g.b(r31) < 0) goto L301;
        if (r11.g.c(r31) < 0) goto L301;
        int r32 = r11.g.b(r31);
        int r33 = r11.g.c(r31) - r32;
        if (isSet(r15, 2) == true) goto L294;
        if (r14 > 0) goto L289;
        r13 = r13 - r33;
        if (regionMatches(r0, r13, r11.e, r32, r33) == true) goto L227;
        return -1;
    L289:
        if (regionMatches(r0, r13, r11.e, r32, r33) == false) goto L290;
    L298:
        r13 = r13 + r33;
        goto L227
    L290:
        return -1;
    L294:
        if (r14 > 0) goto L296;
        r13 = r13 - r33;
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r32, r33) == true) goto L227;
    L296:
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r32, r33) == true) goto L298;
        return -1;
    L301:
        return -1;
    L303:
        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + r31);
    L304:
        int r34 = r12.e();
        if (r11.g == null) goto L312;
        if (r34 <= 0) goto L312;
        int r35 = r11.g.b(r34);
        r11.g.a(r34, r13);
        int r111 = matchCharacterIterator(r11, r12.c, r13, r14, r15);
        if (r111 >= 0) goto L310;
        r11.g.a(r34, r35);
    L310:
        return r111;
    L312:
        if (r11.g == null) goto L227;
        if (r34 >= 0) goto L227;
        int r36 = -r34;
        int r37 = r11.g.c(r36);
        r11.g.b(r36, r13);
        int r112 = matchCharacterIterator(r11, r12.c, r13, r14, r15);
        if (r112 >= 0) goto L317;
        r11.g.b(r36, r37);
    L317:
        return r112;
    L319:
        if (isSet(r15, 2) == false) goto L333;
        int r38 = r12.e();
        if (r14 > 0) goto L323;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L332;
        if (r13 < 0) goto L332;
        if (matchIgnoreCase(r38, r0.setIndex(r13)) == true) goto L227;
    L332:
        return -1;
    L323:
        if (r13 >= r11.e) goto L326;
        if (matchIgnoreCase(r38, r0.setIndex(r13)) == false) goto L326;
    L340:
        r13 = r13 + 1;
    L326:
        return -1;
    L333:
        int r39 = r12.e();
        if (r14 > 0) goto L336;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L347;
        if (r13 < 0) goto L347;
        if (r39 == r0.setIndex(r13)) goto L227;
    L347:
        return -1;
    L336:
        if (r13 >= r11.e) goto L341;
        if (r39 == r0.setIndex(r13)) goto L340;
    L341:
        return -1;
    L349:
        if (r14 > 0) goto L351;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L386;
        if (r13 < 0) goto L386;
        int r40 = r0.setIndex(r13);
        if (isSet(r15, 4) == false) goto L380;
        if (e.a(r40) == false) goto L227;
        if ((r13 - 1) < 0) goto L227;
        r13 = r13 - 1;
        goto L227
    L380:
        if (e.a(r40) == false) goto L385;
        if ((r13 - 1) < 0) goto L385;
        r13 = r13 - 1;
        r40 = e.a(r0.setIndex(r13), r40);
    L385:
        if (isEOLChar(r40) == true) goto L227;
    L351:
        if (r13 >= r11.e) goto L352;
        int r41 = r0.setIndex(r13);
        if (isSet(r15, 4) == false) goto L361;
        if (e.b(r41) == false) goto L252;
        int r42 = r13 + 1;
        if (r42 >= r11.e) goto L252;
        r13 = r42;
        goto L252
    L361:
        if (e.b(r41) == false) goto L366;
        int r43 = r13 + 1;
        if (r43 >= r11.e) goto L366;
        r41 = e.a(r41, r0.setIndex(r43));
        r13 = r43;
    L366:
        if (isEOLChar(r41) == false) goto L252;
        return -1;
    L352:
        return -1;
    L386:
        return -1;
    L6:
        if (isSet(r15, 512) == true) goto L8;
        return r13;
    L8:
        if (r13 != r11.e) goto L10;
        return r13;
    L10:
        return -1;
    }

    private static final boolean matchIgnoreCase(int r3, int r4) {
        if (r3 != r4) goto L6;
        return true;
    L6:
        if (r3 > 65535) goto L17;
        if (r4 > 65535) goto L17;
        char r5 = Character.toUpperCase((char) r3);
        char r6 = Character.toUpperCase((char) r4);
        if (r5 != r6) goto L13;
        return true;
    L13:
        if (Character.toLowerCase(r5) != Character.toLowerCase(r6)) goto L16;
        return true;
    L16:
        return false;
    L17:
        return false;
    }

    private int matchString(a r11, c r12, int r13, int r14, int r15) {
        String r0 = r11.f3555b;
    L4:
        if (r12 == null) goto L6;
        if (r13 > r11.e) goto L386;
        if (r13 < r11.d) goto L386;
        int r1 = r12.f3563b;
        boolean r8 = true;
        if (r1 == 0) goto L349;
        if (r1 == 1) goto L319;
        if (r1 == 15) goto L304;
        if (r1 == 16) goto L276;
        int r9 = 0;
        switch(r1) {
            case 3: goto L229;
            case 4: goto L229;
            case 5: goto L111;
            case 6: goto L94;
            case 7: goto L81;
            case 8: goto L77;
            case 9: goto L74;
            case 10: goto L77;
            case 11: goto L68;
            default: goto L26;
        };
    L68:
        if (r9 >= r12.c()) goto L73;
        int r2 = matchString(r11, r12.f(r9), r13, r14, r15);
        if (r2 >= 0) goto L71;
        r9 = r9 + 1;
        goto L68
    L71:
        return r2;
    L73:
        return -1;
    L74:
        int r3 = matchString(r11, r12.d(), r13, r14, r15);
        if (r3 >= 0) goto L76;
    L227:
        r12 = r12.c;
        goto L4
    L76:
        return r3;
    L77:
        int r4 = matchString(r11, r12.c, r13, r14, r15);
        if (r4 >= 0) goto L79;
        r12 = r12.d();
        goto L4
    L79:
        return r4;
    L81:
        int r10 = r12.e();
        if (r10 < 0) goto L89;
        int r5 = r11.i[r10];
        if (r5 < 0) goto L88;
        if (r5 != r13) goto L88;
        r11.i[r10] = -1;
    L88:
        r11.i[r10] = r13;
    L89:
        int r6 = matchString(r11, r12.d(), r13, r14, r15);
        if (r10 < 0) goto L92;
        r11.i[r10] = -1;
    L92:
        if (r6 < 0) goto L227;
        return r6;
    L94:
        String r7 = r12.h();
        int r16 = r7.length();
        if (isSet(r15, 2) == true) goto L103;
        if (r14 > 0) goto L98;
        r13 = r13 - r16;
        if (regionMatches(r0, r13, r11.e, r7, r16) == true) goto L227;
        return -1;
    L98:
        if (regionMatches(r0, r13, r11.e, r7, r16) == false) goto L99;
    L107:
        r13 = r13 + r16;
        goto L227
    L99:
        return -1;
    L103:
        if (r14 > 0) goto L105;
        r13 = r13 - r16;
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r7, r16) == true) goto L227;
        return -1;
    L105:
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r7, r16) == true) goto L107;
        return -1;
    L111:
        int r17 = r12.e();
        if (r17 == 36) goto L206;
        if (r17 == 60) goto L196;
        if (r17 == 62) goto L186;
        if (r17 == 90) goto L173;
        if (r17 == 94) goto L161;
        if (r17 == 98) goto L152;
        if (r17 == 122) goto L149;
        switch(r17) {
            case 64: goto L142;
            case 65: goto L139;
            case 66: goto L128;
            default: goto L227;
        };
    L128:
        if (r11.f == 0) goto L136;
        int r18 = getWordType(r0, r11.d, r11.e, r13, r15);
        if (r18 == 0) goto L136;
        if (r18 == getPreviousWordType(r0, r11.d, r11.e, r13, r15)) goto L136;
        r8 = false;
    L136:
        if (r8 == true) goto L227;
        return -1;
    L139:
        if (r13 == r11.d) goto L227;
        return -1;
    L142:
        if (r13 == r11.d) goto L227;
        if (r13 <= r11.d) goto L147;
        if (isEOLChar(r0.charAt(r13 - 1)) == true) goto L227;
    L147:
        return -1;
    L149:
        if (r13 == r11.e) goto L227;
        return -1;
    L152:
        if (r11.f == 0) goto L153;
        int r19 = getWordType(r0, r11.d, r11.e, r13, r15);
        if (r19 == 0) goto L156;
        if (r19 != getPreviousWordType(r0, r11.d, r11.e, r13, r15)) goto L227;
        return -1;
    L156:
        return -1;
    L153:
        return -1;
    L161:
        if (isSet(r15, 8) == false) goto L170;
        if (r13 == r11.d) goto L227;
        if (r13 <= r11.d) goto L168;
        if (isEOLChar(r0.charAt(r13 - 1)) == true) goto L227;
    L168:
        return -1;
    L170:
        if (r13 == r11.d) goto L227;
        return -1;
    L173:
        if (r13 == r11.e) goto L227;
        int r20 = r13 + 1;
        if (r20 != r11.e) goto L179;
        if (isEOLChar(r0.charAt(r13)) == true) goto L227;
    L179:
        if ((r13 + 2) != r11.e) goto L184;
        if (r0.charAt(r13) != '\r') goto L184;
        if (r0.charAt(r20) == '\n') goto L227;
    L184:
        return -1;
    L186:
        if (r11.f == 0) goto L194;
        if (r13 == r11.d) goto L194;
        if (getWordType(r0, r11.d, r11.e, r13, r15) != 2) goto L194;
        if (getPreviousWordType(r0, r11.d, r11.e, r13, r15) == 1) goto L227;
    L194:
        return -1;
    L196:
        if (r11.f == 0) goto L204;
        if (r13 == r11.e) goto L204;
        if (getWordType(r0, r11.d, r11.e, r13, r15) != 1) goto L204;
        if (getPreviousWordType(r0, r11.d, r11.e, r13, r15) == 2) goto L227;
    L204:
        return -1;
    L206:
        if (isSet(r15, 8) == false) goto L215;
        if (r13 == r11.e) goto L227;
        if (r13 >= r11.e) goto L213;
        if (isEOLChar(r0.charAt(r13)) == true) goto L227;
    L213:
        return -1;
    L215:
        if (r13 == r11.e) goto L227;
        int r21 = r13 + 1;
        if (r21 != r11.e) goto L221;
        if (isEOLChar(r0.charAt(r13)) == true) goto L227;
    L221:
        if ((r13 + 2) != r11.e) goto L226;
        if (r0.charAt(r13) != '\r') goto L226;
        if (r0.charAt(r21) == '\n') goto L227;
    L226:
        return -1;
    L229:
        if (r14 > 0) goto L231;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L275;
        if (r13 < 0) goto L275;
        int r22 = r0.charAt(r13);
        if (e.a(r22) == true) goto L260;
    L262:
        RangeToken r23 = r12.g();
        if (isSet(r15, 2) == false) goto L274;
        RangeToken r24 = r23.getCaseInsensitiveToken();
        if (r24.match(r22) == true) goto L227;
        if (r22 >= 65536) goto L267;
        char r25 = Character.toUpperCase((char) r22);
        if (r24.match(r25) == true) goto L227;
        if (r24.match(Character.toLowerCase(r25)) == true) goto L227;
        return -1;
    L267:
        return -1;
    L274:
        if (r23.match(r22) == true) goto L227;
    L260:
        if ((r13 - 1) < 0) goto L262;
        r13 = r13 - 1;
        r22 = e.a(r0.charAt(r13), r22);
    L275:
        return -1;
    L231:
        if (r13 >= r11.e) goto L232;
        int r26 = r0.charAt(r13);
        if (e.b(r26) == false) goto L238;
        int r27 = r13 + 1;
        if (r27 >= r11.e) goto L238;
        r26 = e.a(r26, r0.charAt(r27));
        r13 = r27;
    L238:
        RangeToken r28 = r12.g();
        if (isSet(r15, 2) == false) goto L250;
        RangeToken r29 = r28.getCaseInsensitiveToken();
        if (r29.match(r26) == true) goto L252;
        if (r26 >= 65536) goto L243;
        char r30 = Character.toUpperCase((char) r26);
        if (r29.match(r30) == true) goto L252;
        if (r29.match(Character.toLowerCase(r30)) == true) goto L252;
        return -1;
    L243:
        return -1;
    L252:
        r13 = r13 + 1;
        goto L227
    L250:
        if (r28.match(r26) == true) goto L252;
        return -1;
    L232:
        return -1;
    L26:
        switch(r1) {
            case 20: goto L65;
            case 21: goto L62;
            case 22: goto L59;
            case 23: goto L56;
            case 24: goto L52;
            case 25: goto L49;
            case 26: goto L29;
            default: goto L28;
        };
    L28:
        throw new RuntimeException("Unknown operation type: " + r12.f3563b);
    L49:
        r13 = matchString(r11, r12.d(), r13, r14, (r12.e() | r15) & (~r12.f()));
        if (r13 >= 0) goto L227;
        return r13;
    L52:
        r13 = matchString(r11, r12.d(), r13, r14, r15);
        if (r13 >= 0) goto L227;
        return r13;
    L56:
        if (matchString(r11, r12.d(), r13, -1, r15) < 0) goto L227;
        return -1;
    L59:
        if (matchString(r11, r12.d(), r13, -1, r15) >= 0) goto L227;
        return -1;
    L62:
        if (matchString(r11, r12.d(), r13, 1, r15) < 0) goto L227;
        return -1;
    L65:
        if (matchString(r11, r12.d(), r13, 1, r15) >= 0) goto L227;
        return -1;
    L29:
        c.C0175c r110 = (c.C0175c) ZeusTransformUtils.preCheckCast(r12, c.C0175c.class, "com.obric.memorydata.plugin");
        if (r110.d <= 0) goto L42;
        if (r110.d >= this.nofparen) goto L40;
        if (r11.g.b(r110.d) >= 0) goto L36;
    L38:
        r8 = false;
    L43:
        if (r8 == true) goto L44;
        if (r110.g != null) goto L47;
        r12 = r110.c;
        goto L4
    L47:
        r12 = r110.g;
        goto L4
    L44:
        r12 = r110.f;
        goto L4
    L36:
        if (r11.g.c(r110.d) < 0) goto L38;
    L40:
        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + r110.d);
    L42:
        if (matchString(r11, r110.e, r13, r14, r15) < 0) goto L38;
    L276:
        int r31 = r12.e();
        if (r31 <= 0) goto L303;
        if (r31 >= this.nofparen) goto L303;
        if (r11.g.b(r31) < 0) goto L301;
        if (r11.g.c(r31) < 0) goto L301;
        int r32 = r11.g.b(r31);
        int r33 = r11.g.c(r31) - r32;
        if (isSet(r15, 2) == true) goto L294;
        if (r14 > 0) goto L289;
        r13 = r13 - r33;
        if (regionMatches(r0, r13, r11.e, r32, r33) == true) goto L227;
        return -1;
    L289:
        if (regionMatches(r0, r13, r11.e, r32, r33) == false) goto L290;
    L298:
        r13 = r13 + r33;
        goto L227
    L290:
        return -1;
    L294:
        if (r14 > 0) goto L296;
        r13 = r13 - r33;
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r32, r33) == true) goto L227;
    L296:
        if (regionMatchesIgnoreCase(r0, r13, r11.e, r32, r33) == true) goto L298;
        return -1;
    L301:
        return -1;
    L303:
        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + r31);
    L304:
        int r34 = r12.e();
        if (r11.g == null) goto L312;
        if (r34 <= 0) goto L312;
        int r35 = r11.g.b(r34);
        r11.g.a(r34, r13);
        int r111 = matchString(r11, r12.c, r13, r14, r15);
        if (r111 >= 0) goto L310;
        r11.g.a(r34, r35);
    L310:
        return r111;
    L312:
        if (r11.g == null) goto L227;
        if (r34 >= 0) goto L227;
        int r36 = -r34;
        int r37 = r11.g.c(r36);
        r11.g.b(r36, r13);
        int r112 = matchString(r11, r12.c, r13, r14, r15);
        if (r112 >= 0) goto L317;
        r11.g.b(r36, r37);
    L317:
        return r112;
    L319:
        if (isSet(r15, 2) == false) goto L333;
        int r38 = r12.e();
        if (r14 > 0) goto L323;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L332;
        if (r13 < 0) goto L332;
        if (matchIgnoreCase(r38, r0.charAt(r13)) == true) goto L227;
    L332:
        return -1;
    L323:
        if (r13 >= r11.e) goto L326;
        if (matchIgnoreCase(r38, r0.charAt(r13)) == false) goto L326;
    L340:
        r13 = r13 + 1;
    L326:
        return -1;
    L333:
        int r39 = r12.e();
        if (r14 > 0) goto L336;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L347;
        if (r13 < 0) goto L347;
        if (r39 == r0.charAt(r13)) goto L227;
    L347:
        return -1;
    L336:
        if (r13 >= r11.e) goto L341;
        if (r39 == r0.charAt(r13)) goto L340;
    L341:
        return -1;
    L349:
        if (r14 > 0) goto L351;
        r13 = r13 - 1;
        if (r13 >= r11.e) goto L386;
        if (r13 < 0) goto L386;
        int r40 = r0.charAt(r13);
        if (isSet(r15, 4) == false) goto L380;
        if (e.a(r40) == false) goto L227;
        if ((r13 - 1) < 0) goto L227;
        r13 = r13 - 1;
        goto L227
    L380:
        if (e.a(r40) == false) goto L385;
        if ((r13 - 1) < 0) goto L385;
        r13 = r13 - 1;
        r40 = e.a(r0.charAt(r13), r40);
    L385:
        if (isEOLChar(r40) == true) goto L227;
    L351:
        if (r13 >= r11.e) goto L352;
        int r41 = r0.charAt(r13);
        if (isSet(r15, 4) == false) goto L361;
        if (e.b(r41) == false) goto L252;
        int r42 = r13 + 1;
        if (r42 >= r11.e) goto L252;
        r13 = r42;
        goto L252
    L361:
        if (e.b(r41) == false) goto L366;
        int r43 = r13 + 1;
        if (r43 >= r11.e) goto L366;
        r41 = e.a(r41, r0.charAt(r43));
        r13 = r43;
    L366:
        if (isEOLChar(r41) == false) goto L252;
        return -1;
    L352:
        return -1;
    L386:
        return -1;
    L6:
        if (isSet(r15, 512) == true) goto L8;
        return r13;
    L8:
        if (r13 != r11.e) goto L10;
        return r13;
    L10:
        return -1;
    }

    private static final boolean regionMatches(String r0, int r1, int r2, int r3, int r4) {
        if ((r2 - r1) >= r4) goto L7;
        return false;
    L7:
        return r0.regionMatches(r1, r0, r3, r4);
    }

    private static final boolean regionMatches(String r1, int r2, int r3, String r4, int r5) {
        if ((r3 - r2) >= r5) goto L6;
        return false;
    L6:
        return r1.regionMatches(r2, r4, 0, r5);
    }

    private static final boolean regionMatches(CharacterIterator r2, int r3, int r4, int r5, int r6) {
        CharacterIterator r7 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r2, CharacterIterator.class, "com.obric.memorydata.plugin");
        if (r3 >= 0) goto L6;
        return false;
    L6:
        if ((r4 - r3) >= r6) goto L8;
        return false;
    L8:
        int r8 = r6 - 1;
        if (r6 <= 0) goto L14;
        int r9 = r3 + 1;
        int r1 = r5 + 1;
        if (r7.setIndex(r3) != r7.setIndex(r5)) goto L12;
        r3 = r9;
        r5 = r1;
        r6 = r8;
        goto L8
    L12:
        return false;
    L14:
        return true;
    }

    private static final boolean regionMatches(CharacterIterator r3, int r4, int r5, String r6, int r7) {
        CharacterIterator r8 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r3, CharacterIterator.class, "com.obric.memorydata.plugin");
        if (r4 >= 0) goto L6;
        return false;
    L6:
        if ((r5 - r4) >= r7) goto L8;
        return false;
    L8:
        int r9 = 0;
    L9:
        int r1 = r7 - 1;
        if (r7 <= 0) goto L15;
        int r10 = r4 + 1;
        int r2 = r9 + 1;
        if (r8.setIndex(r4) != r6.charAt(r9)) goto L13;
        r4 = r10;
        r7 = r1;
        r9 = r2;
        goto L9
    L13:
        return false;
    L15:
        return true;
    }

    private static final boolean regionMatches(char[] r2, int r3, int r4, int r5, int r6) {
        if (r3 >= 0) goto L6;
        return false;
    L6:
        if ((r4 - r3) >= r6) goto L8;
        return false;
    L8:
        int r7 = r6 - 1;
        if (r6 <= 0) goto L14;
        int r8 = r3 + 1;
        int r1 = r5 + 1;
        if (r2[r3] != r2[r5]) goto L12;
        r3 = r8;
        r5 = r1;
        r6 = r7;
        goto L8
    L12:
        return false;
    L14:
        return true;
    }

    private static final boolean regionMatches(char[] r3, int r4, int r5, String r6, int r7) {
        if (r4 >= 0) goto L6;
        return false;
    L6:
        if ((r5 - r4) >= r7) goto L8;
        return false;
    L8:
        int r8 = 0;
    L9:
        int r1 = r7 - 1;
        if (r7 <= 0) goto L15;
        int r9 = r4 + 1;
        int r2 = r8 + 1;
        if (r3[r4] != r6.charAt(r8)) goto L13;
        r4 = r9;
        r7 = r1;
        r8 = r2;
        goto L9
    L13:
        return false;
    L15:
        return true;
    }

    private static final boolean regionMatchesIgnoreCase(String r6, int r7, int r8, int r9, int r10) {
        if ((r8 - r7) >= r10) goto L7;
        return false;
    L7:
        return r6.regionMatches(true, r7, r6, r9, r10);
    }

    private static final boolean regionMatchesIgnoreCase(String r6, int r7, int r8, String r9, int r10) {
        return r6.regionMatches(true, r7, r9, 0, r10);
    }

    private static final boolean regionMatchesIgnoreCase(CharacterIterator r2, int r3, int r4, int r5, int r6) {
        CharacterIterator r7 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r2, CharacterIterator.class, "com.obric.memorydata.plugin");
        if (r3 >= 0) goto L6;
        return false;
    L6:
        if ((r4 - r3) >= r6) goto L8;
        return false;
    L8:
        int r8 = r6 - 1;
        if (r6 <= 0) goto L20;
        int r9 = r3 + 1;
        char r10 = r7.setIndex(r3);
        int r1 = r5 + 1;
        char r11 = r7.setIndex(r5);
        if (r10 == r11) goto L19;
        char r12 = Character.toUpperCase(r10);
        char r13 = Character.toUpperCase(r11);
        if (r12 == r13) goto L19;
        if (Character.toLowerCase(r12) == Character.toLowerCase(r13)) goto L19;
        return false;
    L19:
        r3 = r9;
        r5 = r1;
        r6 = r8;
        goto L8
    L20:
        return true;
    }

    private static final boolean regionMatchesIgnoreCase(CharacterIterator r3, int r4, int r5, String r6, int r7) {
        CharacterIterator r8 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r3, CharacterIterator.class, "com.obric.memorydata.plugin");
        if (r4 >= 0) goto L6;
        return false;
    L6:
        if ((r5 - r4) >= r7) goto L8;
        return false;
    L8:
        int r9 = 0;
    L9:
        int r1 = r7 - 1;
        if (r7 <= 0) goto L21;
        int r10 = r4 + 1;
        char r11 = r8.setIndex(r4);
        int r2 = r9 + 1;
        char r12 = r6.charAt(r9);
        if (r11 == r12) goto L20;
        char r13 = Character.toUpperCase(r11);
        char r14 = Character.toUpperCase(r12);
        if (r13 == r14) goto L20;
        if (Character.toLowerCase(r13) == Character.toLowerCase(r14)) goto L20;
        return false;
    L20:
        r4 = r10;
        r7 = r1;
        r9 = r2;
        goto L9
    L21:
        return true;
    }

    private static final boolean regionMatchesIgnoreCase(char[] r2, int r3, int r4, int r5, int r6) {
        if (r3 >= 0) goto L6;
        return false;
    L6:
        if ((r4 - r3) >= r6) goto L8;
        return false;
    L8:
        int r7 = r6 - 1;
        if (r6 <= 0) goto L20;
        int r8 = r3 + 1;
        char r9 = r2[r3];
        int r1 = r5 + 1;
        char r10 = r2[r5];
        if (r9 == r10) goto L19;
        char r11 = Character.toUpperCase(r9);
        char r12 = Character.toUpperCase(r10);
        if (r11 == r12) goto L19;
        if (Character.toLowerCase(r11) == Character.toLowerCase(r12)) goto L19;
        return false;
    L19:
        r3 = r8;
        r5 = r1;
        r6 = r7;
        goto L8
    L20:
        return true;
    }

    private static final boolean regionMatchesIgnoreCase(char[] r3, int r4, int r5, String r6, int r7) {
        if (r4 >= 0) goto L6;
        return false;
    L6:
        if ((r5 - r4) >= r7) goto L8;
        return false;
    L8:
        int r8 = 0;
    L9:
        int r1 = r7 - 1;
        if (r7 <= 0) goto L21;
        int r9 = r4 + 1;
        char r10 = r3[r4];
        int r2 = r8 + 1;
        char r11 = r6.charAt(r8);
        if (r10 == r11) goto L20;
        char r12 = Character.toUpperCase(r10);
        char r13 = Character.toUpperCase(r11);
        if (r12 == r13) goto L20;
        if (Character.toLowerCase(r12) == Character.toLowerCase(r13)) goto L20;
        return false;
    L20:
        r4 = r9;
        r7 = r1;
        r8 = r2;
        goto L9
    L21:
        return true;
    }

    private void setPattern(String r2, int r3) {
        this.regex = r2;
        this.options = r3;
        if (isSet(r3, 512) == false) goto L5;
        f r4 = new d();
    L6:
        this.tokentree = r4.b(this.regex, this.options);
        this.nofparen = r4.i;
        this.hasBackReferences = r4.j;
        this.operations = null;
        this.context = null;
        return;
    L5:
        r4 = new f();
        goto L6
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, RegularExpression.class) == true) goto L8;
        return false;
    L8:
        RegularExpression r5 = (RegularExpression) ZeusTransformUtils.preCheckCast(r4, RegularExpression.class, "com.obric.memorydata.plugin");
        if (this.regex.equals(r5.regex) == true) goto L11;
        return false;
    L11:
        if (this.options != r5.options) goto L15;
        return true;
    L15:
        return false;
    }

    boolean equals(String r2, int r3) {
        if (this.regex.equals(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.options != r3) goto L7;
        return true;
    }

    public int getNumberOfGroups() {
        return this.nofparen;
    }

    public String getOptions() {
        return e.e(this.options);
    }

    public String getPattern() {
        return this.regex;
    }

    public int hashCode() {
        return (this.regex + "/" + getOptions()).hashCode();
    }

    public boolean matches(String r5) {
        return matches(r5, 0, r5.length(), (b) ZeusTransformUtils.preCheckCast(null, b.class, "com.obric.memorydata.plugin"));
    }

    public boolean matches(String r4, int r5, int r6) {
        return matches(r4, r5, r6, (b) ZeusTransformUtils.preCheckCast(null, b.class, "com.obric.memorydata.plugin"));
    }

    public boolean matches(String r12, int r13, int r14, b r15) {
        monitor-enter(this);
    L128:
        th = move-exception;
        throw th;
    L4:
        if (this.operations != null) goto L7;
        prepare();     // Catch: Throwable -> L128
    L7:
        if (this.context != null) goto L9;
        this.context = new a();     // Catch: Throwable -> L128
    L9:
        monitor-exit(this);     // Catch: Throwable -> L128
        a r0 = this.context;
        monitor-enter(r0);
    L125:
        th = move-exception;
        throw th;
    L13:
        if (this.context.h == false) goto L15;
        a r1 = new a();     // Catch: Throwable -> L125
    L16:
        r1.a(r12, r13, r14, this.numberOfClosures);     // Catch: Throwable -> L125
        monitor-exit(r0);     // Catch: Throwable -> L125
        if (r15 == null) goto L21;
        r15.a(this.nofparen);
        r15.a(r12);
    L23:
        r1.g = r15;
        if (isSet(this.options, 512) == false) goto L34;
        int r11 = matchString(r1, this.operations, r1.d, 1, this.options);
        if (r11 == r1.e) goto L28;
        return false;
    L28:
        if (r1.g == null) goto L30;
        r1.g.a(0, r1.d);
        r1.g.b(0, r11);
    L30:
        r1.h = false;
        return true;
    L34:
        if (this.fixedStringOnly == false) goto L45;
        int r16 = this.fixedStringTable.a(r12, r1.d, r1.e);
        if (r16 >= 0) goto L38;
        r1.h = false;
        return false;
    L38:
        if (r1.g == null) goto L40;
        r1.g.a(0, r16);
        r1.g.b(0, r16 + this.fixedString.length());
    L40:
        r1.h = false;
        return true;
    L45:
        if (this.fixedString != null) goto L47;
    L50:
        int r17 = r1.e - this.minlength;
        int r2 = -1;
        c r3 = this.operations;
        if (r3 != null) goto L53;
    L71:
        RangeToken r8 = this.firstChar;
        if (r8 != null) goto L74;
        int r18 = r1.d;
    L111:
        if (r18 > r17) goto L116;
        r2 = matchString(r1, this.operations, r18, 1, this.options);
        if (r2 >= 0) goto L116;
        r18 = r18 + 1;
    L116:
        int r19 = r2;
    L117:
        if (r19 >= 0) goto L119;
        r1.h = false;
        return false;
    L119:
        if (r1.g == null) goto L121;
        r1.g.a(0, r18);
        r1.g.b(0, r19);
    L121:
        r1.h = false;
        return true;
    L74:
        if (isSet(this.options, 2) == false) goto L95;
        RangeToken r9 = this.firstChar.getCaseInsensitiveToken();
        int r10 = r1.d;
    L76:
        if (r10 > r17) goto L109;
        char r4 = r12.charAt(r10);
        if (e.b(r4) == false) goto L85;
        int r5 = r10 + 1;
        if (r5 >= r1.e) goto L85;
        if (r9.match(e.a(r4, r12.charAt(r5))) == false) goto L94;
    L91:
        r2 = matchString(r1, this.operations, r10, 1, this.options);
        if (r2 >= 0) goto L109;
    L94:
        r10 = r10 + 1;
    L85:
        if (r9.match(r4) == true) goto L91;
        char r6 = Character.toUpperCase(r4);
        if (r9.match(r6) == true) goto L91;
        if (r9.match(Character.toLowerCase(r6)) == true) goto L91;
    L109:
        r19 = r2;
        r18 = r10;
        goto L117
    L95:
        r10 = r1.d;
    L96:
        if (r10 > r17) goto L109;
        int r7 = r12.charAt(r10);
        if (e.b(r7) == false) goto L103;
        int r20 = r10 + 1;
        if (r20 >= r1.e) goto L103;
        r7 = e.a(r7, r12.charAt(r20));
    L103:
        if (r8.match(r7) == false) goto L108;
        r2 = matchString(r1, this.operations, r10, 1, this.options);
        if (r2 >= 0) goto L109;
    L108:
        r10 = r10 + 1;
        goto L96
    L53:
        if (r3.f3563b != 7) goto L71;
        if (this.operations.d().f3563b != 0) goto L71;
        if (isSet(this.options, 4) == false) goto L59;
        r18 = r1.d;
        r19 = matchString(r1, this.operations, r1.d, 1, this.options);
        goto L117
    L59:
        boolean r21 = true;
        int r22 = -1;
        int r23 = r1.d;
    L60:
        if (r23 > r17) goto L70;
        if (isEOLChar(r12.charAt(r23)) == false) goto L64;
        r21 = true;
    L69:
        r23 = r23 + 1;
        goto L60
    L64:
        if (r21 == false) goto L68;
        r22 = matchString(r1, this.operations, r23, 1, this.options);
        if (r22 >= 0) goto L70;
    L68:
        r21 = false;
    L70:
        r19 = r22;
        r18 = r23;
        goto L117
    L47:
        if (this.fixedStringTable.a(r12, r1.d, r1.e) >= 0) goto L50;
        r1.h = false;
        return false;
    L21:
        if (this.hasBackReferences == false) goto L23;
        r15 = new b();
        r15.a(this.nofparen);
        goto L23
    L15:
        r1 = this.context;     // Catch: Throwable -> L125
        goto L16
    }

    public boolean matches(String r3, b r4) {
        return matches(r3, 0, r3.length(), r4);
    }

    public boolean matches(CharacterIterator r4) {
        return matches((CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r4, CharacterIterator.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(null, b.class, "com.obric.memorydata.plugin"));
    }

    public boolean matches(CharacterIterator r14, b r15) {
        CharacterIterator r16 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r14, CharacterIterator.class, "com.obric.memorydata.plugin");
        int r0 = r16.getBeginIndex();
        int r1 = r16.getEndIndex();
        monitor-enter(this);
    L129:
        th = move-exception;
        throw th;
    L5:
        if (this.operations != null) goto L8;
        prepare();     // Catch: Throwable -> L129
    L8:
        if (this.context != null) goto L10;
        this.context = new a();     // Catch: Throwable -> L129
    L10:
        monitor-exit(this);     // Catch: Throwable -> L129
        a r2 = this.context;
        monitor-enter(r2);
    L126:
        th = move-exception;
        throw th;
    L14:
        if (this.context.h == false) goto L16;
        a r3 = new a();     // Catch: Throwable -> L126
    L17:
        r3.a(r16, r0, r1, this.numberOfClosures);     // Catch: Throwable -> L126
        monitor-exit(r2);     // Catch: Throwable -> L126
        if (r15 == null) goto L22;
        r15.a(this.nofparen);
        r15.a(r16);
    L24:
        r3.g = r15;
        if (isSet(this.options, 512) == false) goto L35;
        int r13 = matchCharacterIterator(r3, this.operations, r3.d, 1, this.options);
        if (r13 == r3.e) goto L29;
        return false;
    L29:
        if (r3.g == null) goto L31;
        r3.g.a(0, r3.d);
        r3.g.b(0, r13);
    L31:
        r3.h = false;
        return true;
    L35:
        if (this.fixedStringOnly == false) goto L46;
        int r17 = this.fixedStringTable.a(r16, r3.d, r3.e);
        if (r17 >= 0) goto L39;
        r3.h = false;
        return false;
    L39:
        if (r3.g == null) goto L41;
        r3.g.a(0, r17);
        r3.g.b(0, r17 + this.fixedString.length());
    L41:
        r3.h = false;
        return true;
    L46:
        if (this.fixedString != null) goto L48;
    L51:
        int r18 = r3.e - this.minlength;
        int r4 = -1;
        c r5 = this.operations;
        if (r5 != null) goto L54;
    L72:
        RangeToken r10 = this.firstChar;
        if (r10 != null) goto L75;
        int r19 = r3.d;
    L112:
        if (r19 > r18) goto L117;
        r4 = matchCharacterIterator(r3, this.operations, r19, 1, this.options);
        if (r4 >= 0) goto L117;
        r19 = r19 + 1;
    L117:
        int r110 = r4;
    L118:
        if (r110 >= 0) goto L120;
        r3.h = false;
        return false;
    L120:
        if (r3.g == null) goto L122;
        r3.g.a(0, r19);
        r3.g.b(0, r110);
    L122:
        r3.h = false;
        return true;
    L75:
        if (isSet(this.options, 2) == false) goto L96;
        RangeToken r11 = this.firstChar.getCaseInsensitiveToken();
        int r12 = r3.d;
    L77:
        if (r12 > r18) goto L110;
        char r6 = r16.setIndex(r12);
        if (e.b(r6) == false) goto L86;
        int r7 = r12 + 1;
        if (r7 >= r3.e) goto L86;
        if (r11.match(e.a(r6, r16.setIndex(r7))) == false) goto L95;
    L92:
        r4 = matchCharacterIterator(r3, this.operations, r12, 1, this.options);
        if (r4 >= 0) goto L110;
    L95:
        r12 = r12 + 1;
    L86:
        if (r11.match(r6) == true) goto L92;
        char r8 = Character.toUpperCase(r6);
        if (r11.match(r8) == true) goto L92;
        if (r11.match(Character.toLowerCase(r8)) == true) goto L92;
    L110:
        r110 = r4;
        r19 = r12;
        goto L118
    L96:
        r12 = r3.d;
    L97:
        if (r12 > r18) goto L110;
        int r9 = r16.setIndex(r12);
        if (e.b(r9) == false) goto L104;
        int r20 = r12 + 1;
        if (r20 >= r3.e) goto L104;
        r9 = e.a(r9, r16.setIndex(r20));
    L104:
        if (r10.match(r9) == false) goto L109;
        r4 = matchCharacterIterator(r3, this.operations, r12, 1, this.options);
        if (r4 >= 0) goto L110;
    L109:
        r12 = r12 + 1;
        goto L97
    L54:
        if (r5.f3563b != 7) goto L72;
        if (this.operations.d().f3563b != 0) goto L72;
        if (isSet(this.options, 4) == false) goto L60;
        r19 = r3.d;
        r110 = matchCharacterIterator(r3, this.operations, r3.d, 1, this.options);
        goto L118
    L60:
        boolean r21 = true;
        int r22 = -1;
        int r23 = r3.d;
    L61:
        if (r23 > r18) goto L71;
        if (isEOLChar(r16.setIndex(r23)) == false) goto L65;
        r21 = true;
    L70:
        r23 = r23 + 1;
        goto L61
    L65:
        if (r21 == false) goto L69;
        r22 = matchCharacterIterator(r3, this.operations, r23, 1, this.options);
        if (r22 >= 0) goto L71;
    L69:
        r21 = false;
    L71:
        r110 = r22;
        r19 = r23;
        goto L118
    L48:
        if (this.fixedStringTable.a(r16, r3.d, r3.e) >= 0) goto L51;
        r3.h = false;
        return false;
    L22:
        if (this.hasBackReferences == false) goto L24;
        r15 = new b();
        r15.a(this.nofparen);
        goto L24
    L16:
        r3 = this.context;     // Catch: Throwable -> L126
        goto L17
    }

    public boolean matches(char[] r5) {
        return matches(r5, 0, r5.length, (b) ZeusTransformUtils.preCheckCast(null, b.class, "com.obric.memorydata.plugin"));
    }

    public boolean matches(char[] r4, int r5, int r6) {
        return matches(r4, r5, r6, (b) ZeusTransformUtils.preCheckCast(null, b.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean matches(char[] r12, int r13, int r14, b r15) {
        monitor-enter(this);
    L128:
        th = move-exception;
        throw th;
    L4:
        if (this.operations != null) goto L7;
        prepare();     // Catch: Throwable -> L128
    L7:
        if (this.context != null) goto L9;
        this.context = new a();     // Catch: Throwable -> L128
    L9:
        monitor-exit(this);     // Catch: Throwable -> L128
        a r0 = this.context;
        monitor-enter(r0);
    L125:
        th = move-exception;
        throw th;
    L13:
        if (this.context.h == false) goto L15;
        a r1 = new a();     // Catch: Throwable -> L125
    L16:
        r1.a(r12, r13, r14, this.numberOfClosures);     // Catch: Throwable -> L125
        monitor-exit(r0);     // Catch: Throwable -> L125
        if (r15 == null) goto L21;
        r15.a(this.nofparen);
        r15.a(r12);
    L23:
        r1.g = r15;
        if (isSet(this.options, 512) == false) goto L34;
        int r11 = matchCharArray(r1, this.operations, r1.d, 1, this.options);
        if (r11 == r1.e) goto L28;
        return false;
    L28:
        if (r1.g == null) goto L30;
        r1.g.a(0, r1.d);
        r1.g.b(0, r11);
    L30:
        r1.h = false;
        return true;
    L34:
        if (this.fixedStringOnly == false) goto L45;
        int r16 = this.fixedStringTable.a(r12, r1.d, r1.e);
        if (r16 >= 0) goto L38;
        r1.h = false;
        return false;
    L38:
        if (r1.g == null) goto L40;
        r1.g.a(0, r16);
        r1.g.b(0, r16 + this.fixedString.length());
    L40:
        r1.h = false;
        return true;
    L45:
        if (this.fixedString != null) goto L47;
    L50:
        int r17 = r1.e - this.minlength;
        int r2 = -1;
        c r3 = this.operations;
        if (r3 != null) goto L53;
    L71:
        RangeToken r8 = this.firstChar;
        if (r8 != null) goto L74;
        int r18 = r1.d;
    L111:
        if (r18 > r17) goto L116;
        r2 = matchCharArray(r1, this.operations, r18, 1, this.options);
        if (r2 >= 0) goto L116;
        r18 = r18 + 1;
    L116:
        int r19 = r2;
    L117:
        if (r19 >= 0) goto L119;
        r1.h = false;
        return false;
    L119:
        if (r1.g == null) goto L121;
        r1.g.a(0, r18);
        r1.g.b(0, r19);
    L121:
        r1.h = false;
        return true;
    L74:
        if (isSet(this.options, 2) == false) goto L95;
        RangeToken r9 = this.firstChar.getCaseInsensitiveToken();
        int r10 = r1.d;
    L76:
        if (r10 > r17) goto L109;
        char r4 = r12[r10];
        if (e.b(r4) == false) goto L85;
        int r5 = r10 + 1;
        if (r5 >= r1.e) goto L85;
        if (r9.match(e.a(r4, r12[r5])) == false) goto L94;
    L91:
        r2 = matchCharArray(r1, this.operations, r10, 1, this.options);
        if (r2 >= 0) goto L109;
    L94:
        r10 = r10 + 1;
    L85:
        if (r9.match(r4) == true) goto L91;
        char r6 = Character.toUpperCase(r4);
        if (r9.match(r6) == true) goto L91;
        if (r9.match(Character.toLowerCase(r6)) == true) goto L91;
    L109:
        r19 = r2;
        r18 = r10;
        goto L117
    L95:
        r10 = r1.d;
    L96:
        if (r10 > r17) goto L109;
        char r7 = r12[r10];
        boolean r20 = e.b(r7);
        int r21 = r7;
        if (r20 == false) goto L103;
        int r22 = r10 + 1;
        r21 = r7;
        if (r22 >= r1.e) goto L103;
        r21 = e.a(r7, r12[r22]);
    L103:
        if (r8.match(r21) == false) goto L108;
        r2 = matchCharArray(r1, this.operations, r10, 1, this.options);
        if (r2 >= 0) goto L109;
    L108:
        r10 = r10 + 1;
        goto L96
    L53:
        if (r3.f3563b != 7) goto L71;
        if (this.operations.d().f3563b != 0) goto L71;
        if (isSet(this.options, 4) == false) goto L59;
        r18 = r1.d;
        r19 = matchCharArray(r1, this.operations, r1.d, 1, this.options);
        goto L117
    L59:
        boolean r23 = true;
        int r24 = -1;
        int r25 = r1.d;
    L60:
        if (r25 > r17) goto L70;
        if (isEOLChar(r12[r25]) == false) goto L64;
        r23 = true;
    L69:
        r25 = r25 + 1;
        goto L60
    L64:
        if (r23 == false) goto L68;
        r24 = matchCharArray(r1, this.operations, r25, 1, this.options);
        if (r24 >= 0) goto L70;
    L68:
        r23 = false;
    L70:
        r19 = r24;
        r18 = r25;
        goto L117
    L47:
        if (this.fixedStringTable.a(r12, r1.d, r1.e) >= 0) goto L50;
        r1.h = false;
        return false;
    L21:
        if (this.hasBackReferences == false) goto L23;
        r15 = new b();
        r15.a(this.nofparen);
        goto L23
    L15:
        r1 = this.context;     // Catch: Throwable -> L125
        goto L16
    }

    public boolean matches(char[] r3, b r4) {
        return matches(r3, 0, r3.length, r4);
    }

    void prepare() {
        compile(this.tokentree);
        this.minlength = this.tokentree.getMinLength();
        this.firstChar = null;
        if (isSet(this.options, 128) == false) goto L5;
    L9:
        c r1 = this.operations;
        if (r1 == null) goto L28;
        if (r1.f3563b == 6) goto L16;
        if (this.operations.f3563b != 1) goto L28;
    L16:
        if (this.operations.c != null) goto L28;
        this.fixedStringOnly = true;
        if (this.operations.f3563b != 6) goto L22;
        String r0 = this.operations.h();
    L20:
        this.fixedString = r0;
    L25:
        this.fixedStringOptions = this.options;
        com.ctc.wstx.shaded.msv_core.datatype.regexp.a r2 = new com.ctc.wstx.shaded.msv_core.datatype.regexp.a(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
    L26:
        this.fixedStringTable = r2;
        return;
    L22:
        if (this.operations.e() < 65536) goto L24;
        r0 = e.c(this.operations.e());
        goto L20
    L24:
        this.fixedString = new String(new char[]{(char) this.operations.e()});
    L28:
        if (isSet(this.options, 256) == false) goto L30;
        return;
    L30:
        if (isSet(this.options, 512) == true) goto L45;
        Token.a r3 = new Token.a();
        this.tokentree.findFixedString(r3, this.options);
        if (r3.f3556a != null) goto L34;
        String r4 = null;
    L35:
        this.fixedString = r4;
        this.fixedStringOptions = r3.f3557b;
        String r5 = this.fixedString;
        if (r5 == null) goto L41;
        if (r5.length() >= 2) goto L41;
        this.fixedString = null;
    L41:
        if (this.fixedString == null) goto L46;
        r2 = new com.ctc.wstx.shaded.msv_core.datatype.regexp.a(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
        goto L26
    L46:
        return;
    L34:
        r4 = r3.f3556a.getString();
        goto L35
    L45:
        return;
    L5:
        if (isSet(this.options, 512) == true) goto L9;
        RangeToken r6 = Token.createRange();
        if (this.tokentree.analyzeFirstCharacter(r6, this.options) != 1) goto L9;
        r6.compactRanges();
        this.firstChar = r6;
        goto L9
    }

    public void setPattern(String r2) {
        setPattern(r2, this.options);
    }

    public void setPattern(String r1, String r2) {
        setPattern(r1, e.a(r2));
    }

    public String toString() {
        return this.tokentree.toString(this.options);
    }
}
