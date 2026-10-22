package org.apache.xmlbeans.impl.regex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

/* JADX INFO: loaded from: classes7.dex */
class RegexParser {
    int chardata;
    int context;
    boolean hasBackReferences;
    int nexttoken;
    int offset;
    int options;
    int parennumber;
    Vector references;
    String regex;
    int regexlen;
    ResourceBundle resources;

    static class ReferencePosition {
        int position;
        int refNumber;

        ReferencePosition(int r1, int r2) {
            this.refNumber = r1;
            this.position = r2;
        }
    }

    public RegexParser() {
        this.context = 0;
        this.parennumber = 1;
        this.references = null;
        setLocale(Locale.getDefault());
    }

    public RegexParser(Locale r2) {
        this.context = 0;
        this.parennumber = 1;
        this.references = null;
        setLocale(r2);
    }

    private static final int hexChar(int r3) {
        if (r3 >= 48) goto L6;
        return -1;
    L6:
        if (r3 <= 102) goto L9;
        return -1;
    L9:
        if (r3 <= 57) goto L11;
        int r0 = 65;
        if (r3 >= 65) goto L16;
        return -1;
    L16:
        if (r3 <= 70) goto L18;
        r0 = 97;
        if (r3 >= 97) goto L18;
        return -1;
    L18:
        return (r3 - r0) + 10;
    L11:
        return r3 - 48;
    }

    private boolean isSet(int r1) {
        if ((this.options & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    boolean checkQuestion(int r2) {
        if (r2 < this.regexlen) goto L5;
    L7:
        return false;
    L5:
        if (this.regex.charAt(r2) != '?') goto L7;
        return true;
    }

    int decodeEscaped() {
        if (read() != 10) goto L135;
        int r0 = this.chardata;
        if (r0 == 65) goto L133;
        if (r0 == 90) goto L133;
        if (r0 != 110) goto L11;
        return 10;
    L11:
        if (r0 != 114) goto L13;
        return 13;
    L13:
        if (r0 != 120) goto L15;
        next();
        if (read() != 0) goto L129;
        if (this.chardata != 123) goto L116;
        int r1 = 0;
    L96:
        next();
        if (read() != 0) goto L114;
        int r2 = hexChar(this.chardata);
        if (r2 < 0) goto L101;
        int r4 = r1 * 16;
        if (r1 > r4) goto L112;
        r1 = r4 + r2;
        goto L96
    L112:
        throw ex("parser.descape.2", this.offset - 1);
    L101:
        if (this.chardata != 125) goto L107;
        if (r1 > 1114111) goto L105;
        return r1;
    L105:
        throw ex("parser.descape.4", this.offset - 1);
    L107:
        throw ex("parser.descape.3", this.offset - 1);
    L114:
        throw ex("parser.descape.1", this.offset - 1);
    L116:
        if (read() != 0) goto L127;
        int r3 = hexChar(this.chardata);
        if (r3 < 0) goto L127;
        next();
        if (read() != 0) goto L125;
        int r5 = hexChar(this.chardata);
        if (r5 < 0) goto L125;
    L144:
        return r5 + (r3 * 16);
    L125:
        throw ex("parser.descape.1", this.offset - 1);
    L127:
        throw ex("parser.descape.1", this.offset - 1);
    L129:
        throw ex("parser.descape.1", this.offset - 1);
    L15:
        if (r0 == 122) goto L133;
        if (r0 != 101) goto L19;
        return 27;
    L19:
        if (r0 == 102) goto L89;
        switch(r0) {
            case 116: goto L88;
            case 117: goto L63;
            case 118: goto L22;
            default: goto L140;
        };
    L22:
        next();
        if (read() != 0) goto L62;
        int r6 = hexChar(this.chardata);
        if (r6 < 0) goto L62;
        next();
        if (read() != 0) goto L60;
        int r7 = hexChar(this.chardata);
        if (r7 < 0) goto L60;
        int r8 = (r6 * 16) + r7;
        next();
        if (read() != 0) goto L58;
        int r9 = hexChar(this.chardata);
        if (r9 < 0) goto L58;
        int r10 = (r8 * 16) + r9;
        next();
        if (read() != 0) goto L56;
        int r11 = hexChar(this.chardata);
        if (r11 < 0) goto L56;
        int r12 = (r10 * 16) + r11;
        next();
        if (read() != 0) goto L54;
        int r13 = hexChar(this.chardata);
        if (r13 < 0) goto L54;
        int r14 = (r12 * 16) + r13;
        next();
        if (read() != 0) goto L52;
        int r15 = hexChar(this.chardata);
        if (r15 < 0) goto L52;
        int r16 = r15 + (r14 * 16);
        if (r16 > 1114111) goto L50;
        return r16;
    L50:
        throw ex("parser.descappe.4", this.offset - 1);
    L52:
        throw ex("parser.descape.1", this.offset - 1);
    L54:
        throw ex("parser.descape.1", this.offset - 1);
    L56:
        throw ex("parser.descape.1", this.offset - 1);
    L58:
        throw ex("parser.descape.1", this.offset - 1);
    L60:
        throw ex("parser.descape.1", this.offset - 1);
    L62:
        throw ex("parser.descape.1", this.offset - 1);
    L63:
        next();
        if (read() != 0) goto L87;
        int r17 = hexChar(this.chardata);
        if (r17 < 0) goto L87;
        next();
        if (read() != 0) goto L85;
        int r18 = hexChar(this.chardata);
        if (r18 < 0) goto L85;
        int r19 = (r17 * 16) + r18;
        next();
        if (read() != 0) goto L83;
        int r20 = hexChar(this.chardata);
        if (r20 < 0) goto L83;
        r3 = (r19 * 16) + r20;
        next();
        if (read() != 0) goto L81;
        r5 = hexChar(this.chardata);
        if (r5 >= 0) goto L144;
    L81:
        throw ex("parser.descape.1", this.offset - 1);
    L83:
        throw ex("parser.descape.1", this.offset - 1);
    L85:
        throw ex("parser.descape.1", this.offset - 1);
    L87:
        throw ex("parser.descape.1", this.offset - 1);
    L88:
        return 9;
    L140:
        return r0;
    L89:
        return 12;
    L133:
        throw ex("parser.descape.5", this.offset - 2);
    L135:
        throw ex("parser.next.1", this.offset - 1);
    }

    final ParseException ex(String r2, int r3) {
        return new ParseException(this.resources.getString(r2), r3);
    }

    Token getTokenForShorthand(int r7) {
        boolean r2 = false;
        if (r7 == 68) goto L37;
        if (r7 == 83) goto L33;
        if (r7 == 87) goto L29;
        r2 = true;
        if (r7 == 100) goto L25;
        if (r7 == 115) goto L21;
        if (r7 != 119) goto L19;
        if (isSet(32) == false) goto L42;
    L41:
        return Token.getRange("IsWord", r2);
    L42:
        return Token.token_wordchars;
    L19:
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(r7, 16));
    L21:
        if (isSet(32) == false) goto L44;
    L43:
        return Token.getRange("IsSpace", r2);
    L44:
        return Token.token_spaces;
    L25:
        if (isSet(32) == false) goto L46;
    L45:
        return Token.getRange("Nd", r2);
    L46:
        return Token.token_0to9;
    L29:
        if (isSet(32) == true) goto L41;
        return Token.token_not_wordchars;
    L33:
        if (isSet(32) == true) goto L43;
        return Token.token_not_spaces;
    L37:
        if (isSet(32) == true) goto L45;
        return Token.token_not_0to9;
    }

    final void next() {
        int r0 = this.offset;
        if (r0 < this.regexlen) goto L6;
        this.chardata = -1;
        this.nexttoken = 1;
        return;
    L6:
        String r1 = this.regex;
        this.offset = r0 + 1;
        char r2 = r1.charAt(r0);
        this.chardata = r2;
        int r5 = 10;
        if (this.context != 1) goto L43;
        if (r2 == '-') goto L34;
        if (r2 == '[') goto L19;
        if (r2 != '\\') goto L26;
        int r3 = this.offset;
        if (r3 >= this.regexlen) goto L17;
        String r4 = this.regex;
        this.offset = r3 + 1;
        this.chardata = r4.charAt(r3);
    L40:
        this.nexttoken = r5;
        return;
    L17:
        throw ex("parser.next.1", r3 - 1);
    L26:
        if (REUtil.isHighSurrogate(r2) == false) goto L32;
        int r6 = this.offset;
        if (r6 >= this.regexlen) goto L32;
        char r7 = this.regex.charAt(r6);
        if (REUtil.isLowSurrogate(r7) == false) goto L32;
        this.chardata = REUtil.composeFromSurrogates(r2, r7);
        this.offset++;
    L32:
        r5 = 0;
        goto L40
    L19:
        if (isSet(512) == true) goto L26;
        int r8 = this.offset;
        if (r8 >= this.regexlen) goto L26;
        if (this.regex.charAt(r8) != ':') goto L26;
        this.offset++;
        r5 = 20;
        goto L40
    L34:
        if (isSet(512) == false) goto L32;
        int r9 = this.offset;
        if (r9 >= this.regexlen) goto L32;
        if (this.regex.charAt(r9) != '[') goto L32;
        this.offset++;
        r5 = 24;
        goto L40
    L43:
        if (r2 != '$') goto L45;
        r5 = 12;
    L127:
        this.nexttoken = r5;
        return;
    L45:
        if (r2 != '.') goto L47;
        r5 = 8;
        goto L127
    L47:
        if (r2 != '?') goto L49;
        r5 = 5;
        goto L127
    L49:
        if (r2 != '^') goto L51;
        r5 = 11;
        goto L127
    L51:
        if (r2 == '|') goto L122;
        if (r2 == '[') goto L121;
        if (r2 == '\\') goto L116;
        switch(r2) {
            case 40: goto L59;
            case 41: goto L58;
            case 42: goto L57;
            case 43: goto L56;
            default: goto L55;
        };
    L55:
        r5 = 0;
        goto L127
    L56:
        r5 = 4;
        goto L127
    L57:
        r5 = 3;
        goto L127
    L58:
        r5 = 7;
        goto L127
    L59:
        r5 = 6;
        int r10 = this.offset;
        if (r10 >= this.regexlen) goto L127;
        if (this.regex.charAt(r10) != '?') goto L127;
        int r11 = this.offset + 1;
        this.offset = r11;
        if (r11 >= this.regexlen) goto L115;
        String r12 = this.regex;
        this.offset = r11 + 1;
        char r13 = r12.charAt(r11);
        if (r13 != '!') goto L70;
        r5 = 15;
        goto L127
    L70:
        if (r13 == '#') goto L105;
        if (r13 == ':') goto L104;
        if (r13 == '[') goto L103;
        switch(r13) {
            case 60: goto L92;
            case 61: goto L91;
            case 62: goto L90;
            default: goto L74;
        };
    L74:
        if (r13 != '-') goto L76;
    L89:
        this.offset--;
        r5 = 22;
        goto L127
    L76:
        if ('a' > r13) goto L80;
        if (r13 <= 'z') goto L89;
    L80:
        if ('A' > r13) goto L85;
        if (r13 <= 'Z') goto L89;
    L85:
        if (r13 != '(') goto L88;
        r5 = 23;
        goto L127
    L88:
        throw ex("parser.next.2", this.offset - 2);
    L90:
        r5 = 18;
        goto L127
    L91:
        r5 = 14;
        goto L127
    L92:
        int r14 = this.offset;
        if (r14 >= this.regexlen) goto L102;
        String r15 = this.regex;
        this.offset = r14 + 1;
        char r16 = r15.charAt(r14);
        if (r16 != '=') goto L97;
        r5 = 16;
        goto L127
    L97:
        if (r16 != '!') goto L100;
        r5 = 17;
        goto L127
    L100:
        throw ex("parser.next.3", this.offset - 3);
    L102:
        throw ex("parser.next.2", r14 - 3);
    L103:
        r5 = 19;
        goto L127
    L104:
        r5 = 13;
    L105:
        int r17 = this.offset;
        if (r17 >= this.regexlen) goto L109;
        String r18 = this.regex;
        this.offset = r17 + 1;
        r13 = r18.charAt(r17);
        if (r13 != ')') goto L105;
    L109:
        if (r13 != ')') goto L112;
        r5 = 21;
        goto L127
    L112:
        throw ex("parser.next.4", this.offset - 1);
    L115:
        throw ex("parser.next.2", r11 - 1);
    L116:
        int r19 = this.offset;
        if (r19 >= this.regexlen) goto L120;
        String r20 = this.regex;
        this.offset = r19 + 1;
        this.chardata = r20.charAt(r19);
        goto L127
    L120:
        throw ex("parser.next.1", r19 - 1);
    L121:
        r5 = 9;
        goto L127
    L122:
        r5 = 2;
        goto L127
    }

    synchronized Token parse(String r4, int r5) {
        monitor-enter(this);
        this.options = r5;     // Catch: Throwable -> L22
        int r6 = 0;
        this.offset = 0;     // Catch: Throwable -> L22
        setContext(0);     // Catch: Throwable -> L22
        this.parennumber = 1;     // Catch: Throwable -> L22
        this.hasBackReferences = false;     // Catch: Throwable -> L22
        this.regex = r4;     // Catch: Throwable -> L22
        if (isSet(16) == false) goto L6;
        this.regex = REUtil.stripExtendedComment(this.regex);     // Catch: Throwable -> L22
    L6:
        this.regexlen = this.regex.length();     // Catch: Throwable -> L22
        next();     // Catch: Throwable -> L22
        Token r7 = parseRegex();     // Catch: Throwable -> L22
        int r0 = this.offset;     // Catch: Throwable -> L22
        if (r0 != this.regexlen) goto L21;
        if (this.references != null) goto L11;
    L18:
        monitor-exit(this);
        return r7;
    L11:
        if (r6 >= this.references.size()) goto L17;
        ReferencePosition r1 = (ReferencePosition) ZeusTransformUtils.preCheckCast(this.references.elementAt(r6), ReferencePosition.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (this.parennumber <= r1.refNumber) goto L16;
        r6 = r6 + 1;     // Catch: Throwable -> L22
        goto L11
    L16:
        throw ex("parser.parse.2", r1.position);     // Catch: Throwable -> L22
    L17:
        this.references.removeAllElements();     // Catch: Throwable -> L22
        goto L18
    L21:
        throw ex("parser.parse.1", r0);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    Token parseAtom() {
        int r0 = read();
        if (r0 != 0) goto L5;
        int r1 = this.chardata;
        if (r1 == 93) goto L98;
        if (r1 == 123) goto L98;
        if (r1 == 125) goto L98;
        Token.CharToken r2 = Token.createChar(r1);
        int r3 = this.chardata;
        next();
        if (REUtil.isHighSurrogate(r3) == true) goto L92;
        return r2;
    L92:
        if (read() == 0) goto L94;
        return r2;
    L94:
        if (REUtil.isLowSurrogate(this.chardata) == false) goto L102;
        Token r4 = Token.createParen(Token.createString(new String(new char[]{(char) r3, (char) this.chardata})), 0);
    L59:
        next();
        return r4;
    L102:
        return r2;
    L98:
        throw ex("parser.atom.4", this.offset - 1);
    L5:
        if (r0 == 6) goto L82;
        if (r0 == 13) goto L80;
        if (r0 == 18) goto L78;
        if (r0 == 19) goto L76;
        if (r0 == 22) goto L74;
        if (r0 == 23) goto L72;
        switch(r0) {
            case 8: goto L70;
            case 9: goto L69;
            case 10: goto L19;
            default: goto L18;
        };
    L19:
        int r5 = this.chardata;
        if (r5 == 67) goto L67;
        if (r5 != 68) goto L24;
    L64:
        Token r6 = getTokenForShorthand(r5);
        next();
        return r6;
    L24:
        if (r5 == 73) goto L63;
        if (r5 != 80) goto L28;
    L57:
        int r7 = this.offset;
        r4 = processBacksolidus_pP(r5);
        if (r4 != null) goto L59;
        throw ex("parser.atom.5", r7);
    L28:
        if (r5 == 83) goto L64;
        if (r5 == 105) goto L56;
        if (r5 != 110) goto L34;
    L51:
        r5 = decodeEscaped();
        if (r5 < 65536) goto L42;
        r4 = Token.createString(REUtil.decomposeToSurrogates(r5));
    L42:
        r4 = Token.createChar(r5);
        goto L59
    L34:
        if (r5 == 112) goto L57;
        if (r5 == 87) goto L64;
        if (r5 == 88) goto L50;
        switch(r5) {
            case 49: goto L48;
            case 50: goto L48;
            case 51: goto L48;
            case 52: goto L48;
            case 53: goto L48;
            case 54: goto L48;
            case 55: goto L48;
            case 56: goto L48;
            case 57: goto L48;
            default: goto L40;
        };
    L40:
        switch(r5) {
            case 99: goto L46;
            case 100: goto L64;
            case 101: goto L51;
            case 102: goto L51;
            case 103: goto L44;
            default: goto L41;
        };
    L41:
        switch(r5) {
            case 114: goto L51;
            case 115: goto L64;
            case 116: goto L51;
            case 117: goto L51;
            case 118: goto L51;
            case 119: goto L64;
            case 120: goto L51;
            default: goto L42;
        };
    L44:
        return processBacksolidus_g();
    L46:
        return processBacksolidus_c();
    L48:
        return processBackreference();
    L50:
        return processBacksolidus_X();
    L56:
        return processBacksolidus_i();
    L63:
        return processBacksolidus_I();
    L67:
        return processBacksolidus_C();
    L70:
        next();
        return Token.token_dot;
    L18:
        throw ex("parser.atom.4", this.offset - 1);
    L69:
        return parseCharacterClass(true);
    L72:
        return processCondition();
    L74:
        return processModifiers();
    L76:
        return parseSetOperations();
    L78:
        return processIndependent();
    L80:
        return processParen2();
    L82:
        return processParen();
    }

    public RangeToken parseCharacterClass(boolean r17) {
        setContext(1);
        next();
        RangeToken r5 = null;
        if (read() == 0) goto L5;
    L11:
        RangeToken r2 = Token.createRange();
        boolean r6 = false;
    L12:
        boolean r7 = true;
    L13:
        int r8 = read();
        if (r8 == 1) goto L109;
        if (r8 == 0) goto L18;
    L21:
        int r9 = this.chardata;
        if (r8 != 10) goto L59;
        if (r9 != 67) goto L26;
    L55:
        r9 = processCIinCharacterClass(r2, r9);
        if (r9 < 0) goto L54;
    L79:
        boolean r10 = false;
    L80:
        next();
        if (r10 == true) goto L101;
        if (read() == 0) goto L85;
    L99:
        r2.addRange(r9, r9);
        goto L101
    L85:
        if (this.chardata != 45) goto L99;
        next();
        int r11 = read();
        if (r11 == 1) goto L98;
        if (r11 == 0) goto L91;
    L93:
        int r12 = this.chardata;
        if (r11 != 10) goto L96;
        r12 = decodeEscaped();
    L96:
        next();
        r2.addRange(r9, r12);
        goto L101
    L91:
        if (this.chardata != 93) goto L93;
        r2.addRange(r9, r9);
        r2.addRange(45, 45);
        goto L101
    L98:
        throw ex("parser.cc.2", this.offset);
    L101:
        if (isSet(1024) == false) goto L107;
        if (read() != 0) goto L107;
        if (this.chardata != 44) goto L107;
        next();
    L107:
        r7 = false;
    L54:
        r10 = true;
        goto L80
    L26:
        if (r9 != 68) goto L28;
    L53:
        r2.mergeRanges(getTokenForShorthand(r9));
        goto L54
    L28:
        if (r9 == 73) goto L55;
        if (r9 != 80) goto L32;
    L48:
        int r13 = this.offset;
        RangeToken r14 = processBacksolidus_pP(r9);
        if (r14 == null) goto L52;
        r2.mergeRanges(r14);
        goto L54
    L52:
        throw ex("parser.atom.5", r13);
    L32:
        if (r9 == 83) goto L53;
        if (r9 == 87) goto L53;
        if (r9 == 105) goto L55;
        if (r9 == 112) goto L48;
        if (r9 == 115) goto L53;
        if (r9 == 119) goto L53;
        if (r9 == 99) goto L55;
        if (r9 == 100) goto L53;
        r9 = decodeEscaped();
        goto L79
    L59:
        if (r8 != 20) goto L79;
        int r15 = this.regex.indexOf(58, this.offset);
        if (r15 < 0) goto L78;
        if (this.regex.charAt(this.offset) != '^') goto L65;
        this.offset++;
        boolean r16 = false;
    L66:
        RangeToken r18 = Token.getRange(this.regex.substring(this.offset, r15), r16, isSet(512));
        if (r18 == null) goto L76;
        r2.mergeRanges(r18);
        int r19 = r15 + 1;
        if (r19 >= this.regexlen) goto L74;
        if (this.regex.charAt(r19) != ']') goto L74;
        this.offset = r15 + 2;
    L74:
        throw ex("parser.cc.1", r15);
    L76:
        throw ex("parser.cc.3", this.offset);
    L65:
        r16 = true;
        goto L66
    L78:
        throw ex("parser.cc.1", this.offset);
    L18:
        if (this.chardata != 93) goto L21;
        if (r7 == true) goto L21;
    L109:
        if (read() == 1) goto L116;
        if (r17 == true) goto L113;
        if (r6 == false) goto L113;
        r5.subtractRanges(r2);
        r2 = r5;
    L113:
        r2.sortRanges();
        r2.compactRanges();
        setContext(0);
        next();
        return r2;
    L116:
        throw ex("parser.cc.2", this.offset);
    L5:
        if (this.chardata != 94) goto L11;
        next();
        if (r17 == false) goto L9;
        r2 = Token.createNRange();
    L10:
        r6 = true;
        goto L12
    L9:
        r5 = Token.createRange();
        r5.addRange(0, 1114111);
        r2 = Token.createRange();
        goto L10
    }

    Token parseFactor() {
        switch(read()) {
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L16;
            case 13: goto L48;
            case 14: goto L14;
            case 15: goto L12;
            case 16: goto L10;
            case 17: goto L8;
            case 18: goto L48;
            case 19: goto L48;
            case 20: goto L48;
            case 21: goto L5;
            default: goto L48;
        };
    L5:
        next();
        return Token.createEmpty();
    L19:
        int r0 = this.chardata;
        if (r0 == 60) goto L47;
        if (r0 == 62) goto L45;
        if (r0 == 90) goto L43;
        if (r0 == 98) goto L41;
        if (r0 == 122) goto L39;
        if (r0 == 65) goto L37;
        if (r0 != 66) goto L48;
        return processBacksolidus_B();
    L37:
        return processBacksolidus_A();
    L39:
        return processBacksolidus_z();
    L41:
        return processBacksolidus_b();
    L43:
        return processBacksolidus_Z();
    L45:
        return processBacksolidus_gt();
    L47:
        return processBacksolidus_lt();
    L48:
        Token r1 = parseAtom();
        int r2 = read();
        if (r2 == 0) goto L64;
        if (r2 == 3) goto L62;
        if (r2 == 4) goto L60;
        if (r2 == 5) goto L58;
    L122:
        return r1;
    L58:
        return processQuestion(r1);
    L60:
        return processPlus(r1);
    L62:
        return processStar(r1);
    L64:
        if (this.chardata != 123) goto L122;
        int r3 = this.offset;
        if (r3 >= this.regexlen) goto L122;
        int r4 = r3 + 1;
        char r5 = this.regex.charAt(r3);
        if (r5 < '0') goto L121;
        if (r5 > '9') goto L121;
        int r6 = r5 - '0';
    L73:
        if (r4 >= this.regexlen) goto L84;
        int r7 = r4 + 1;
        r5 = this.regex.charAt(r4);
        if (r5 < '0') goto L82;
        if (r5 > '9') goto L82;
        r6 = ((r6 * 10) + r5) - 48;
        if (r6 < 0) goto L81;
        r4 = r7;
        goto L73
    L81:
        throw ex("parser.quantifier.5", this.offset);
    L82:
        r4 = r7;
    L84:
        if (r5 == ',') goto L86;
        int r8 = r6;
    L112:
        if (r5 != '}') goto L119;
        if (checkQuestion(r4) == false) goto L116;
        r1 = Token.createNGClosure(r1);
        r4 = r4 + 1;
    L117:
        this.offset = r4;
        r1.setMin(r6);
        r1.setMax(r8);
        next();
        goto L122
    L116:
        r1 = Token.createClosure(r1);
        goto L117
    L119:
        throw ex("parser.quantifier.2", this.offset);
    L86:
        if (r4 >= this.regexlen) goto L109;
        int r9 = r4 + 1;
        r5 = this.regex.charAt(r4);
        if (r5 < '0') goto L106;
        if (r5 > '9') goto L106;
        int r10 = r5 - '0';
    L92:
        if (r9 >= this.regexlen) goto L102;
        int r11 = r9 + 1;
        r5 = this.regex.charAt(r9);
        if (r5 < '0') goto L101;
        if (r5 > '9') goto L101;
        r10 = ((r10 * 10) + r5) - 48;
        if (r10 < 0) goto L100;
        r9 = r11;
        goto L92
    L100:
        throw ex("parser.quantifier.5", this.offset);
    L101:
        r9 = r11;
    L102:
        if (r6 > r10) goto L105;
    L107:
        r8 = r10;
        r4 = r9;
        goto L112
    L105:
        throw ex("parser.quantifier.4", this.offset);
    L106:
        r10 = -1;
        goto L107
    L109:
        throw ex("parser.quantifier.3", this.offset);
    L121:
        throw ex("parser.quantifier.1", this.offset);
    L8:
        return processNegativelookbehind();
    L10:
        return processLookbehind();
    L12:
        return processNegativelookahead();
    L14:
        return processLookahead();
    L16:
        return processDollar();
    L18:
        return processCaret();
    }

    Token parseRegex() {
        Token r0 = parseTerm();
        Token.UnionToken r1 = null;
    L4:
        if (read() != 2) goto L9;
        next();
        if (r1 != null) goto L8;
        r1 = Token.createUnion();
        r1.addChild(r0);
        r0 = r1;
    L8:
        r0.addChild(parseTerm());
        goto L4
    L9:
        return r0;
    }

    public RangeToken parseSetOperations() {
        RangeToken r1 = parseCharacterClass(false);
    L3:
        int r2 = read();
        if (r2 == 7) goto L25;
        int r3 = this.chardata;
        if (r2 != 0) goto L9;
        if (r3 == 45) goto L10;
        if (r3 != 38) goto L9;
    L10:
        next();
        if (read() != 9) goto L22;
        RangeToken r7 = parseCharacterClass(false);
        if (r2 == 4) goto L14;
        if (r3 == 45) goto L16;
        if (r3 != 38) goto L20;
        r1.intersectRanges(r7);
        goto L3
    L20:
        throw new RuntimeException("ASSERT");
    L16:
        r1.subtractRanges(r7);
        goto L3
    L14:
        r1.mergeRanges(r7);
        goto L3
    L22:
        throw ex("parser.ope.1", this.offset - 1);
    L9:
        if (r2 == 4) goto L10;
        throw ex("parser.ope.2", this.offset - 1);
    L25:
        next();
        return r1;
    }

    Token parseTerm() {
        int r0 = read();
        if (r0 == 2) goto L19;
        if (r0 == 7) goto L19;
        if (r0 == 1) goto L19;
        Token r1 = parseFactor();
        Token.UnionToken r4 = null;
    L10:
        int r5 = read();
        if (r5 == 2) goto L17;
        if (r5 == 7) goto L17;
        if (r5 == 1) goto L17;
        if (r4 != null) goto L16;
        r4 = Token.createConcat();
        r4.addChild(r1);
        r1 = r4;
    L16:
        r4.addChild(parseFactor());
    L17:
        return r1;
    L19:
        return Token.createEmpty();
    }

    Token processBackreference() {
        int r0 = this.chardata - 48;
        Token.StringToken r1 = Token.createBackReference(r0);
        this.hasBackReferences = true;
        if (this.references != null) goto L5;
        this.references = new Vector();
    L5:
        this.references.addElement(new ReferencePosition(r0, this.offset - 2));
        next();
        return r1;
    }

    Token processBacksolidus_A() {
        next();
        return Token.token_stringbeginning;
    }

    Token processBacksolidus_B() {
        next();
        return Token.token_not_wordedge;
    }

    Token processBacksolidus_C() {
        throw ex("parser.process.1", this.offset);
    }

    Token processBacksolidus_I() {
        throw ex("parser.process.1", this.offset);
    }

    Token processBacksolidus_X() {
        next();
        return Token.getCombiningCharacterSequence();
    }

    Token processBacksolidus_Z() {
        next();
        return Token.token_stringend2;
    }

    Token processBacksolidus_b() {
        next();
        return Token.token_wordedge;
    }

    Token processBacksolidus_c() {
        int r0 = this.offset;
        if (r0 >= this.regexlen) goto L9;
        String r1 = this.regex;
        this.offset = r0 + 1;
        char r2 = r1.charAt(r0);
        if ((65504 & r2) != 64) goto L9;
        next();
        return Token.createChar(r2 - '@');
    L9:
        throw ex("parser.atom.1", this.offset - 1);
    }

    Token processBacksolidus_g() {
        next();
        return Token.getGraphemePattern();
    }

    Token processBacksolidus_gt() {
        next();
        return Token.token_wordend;
    }

    Token processBacksolidus_i() {
        Token.CharToken r0 = Token.createChar(105);
        next();
        return r0;
    }

    Token processBacksolidus_lt() {
        next();
        return Token.token_wordbeginning;
    }

    public RangeToken processBacksolidus_pP(int r5) {
        next();
        if (read() != 0) goto L17;
        if (this.chardata != 123) goto L17;
        if (r5 != 112) goto L9;
        boolean r6 = true;
    L10:
        int r0 = this.offset;
        int r2 = this.regex.indexOf(125, r0);
        if (r2 < 0) goto L15;
        String r1 = this.regex.substring(r0, r2);
        this.offset = r2 + 1;
        return Token.getRange(r1, r6, isSet(512));
    L15:
        throw ex("parser.atom.3", this.offset);
    L9:
        r6 = false;
    L17:
        throw ex("parser.atom.2", this.offset - 1);
    }

    Token processBacksolidus_z() {
        next();
        return Token.token_stringend;
    }

    int processCIinCharacterClass(RangeToken r1, int r2) {
        return decodeEscaped();
    }

    Token processCaret() {
        next();
        return Token.token_linebeginning;
    }

    Token processCondition() {
        int r0 = this.offset;
        if ((r0 + 1) >= this.regexlen) goto L42;
        int r1 = -1;
        char r2 = this.regex.charAt(r0);
        Token r4 = null;
        if ('1' > r2) goto L17;
        if (r2 > '9') goto L17;
        r1 = r2 - '0';
        this.hasBackReferences = true;
        if (this.references != null) goto L11;
        this.references = new Vector();
    L11:
        this.references.addElement(new ReferencePosition(r1, this.offset));
        int r3 = this.offset + 1;
        this.offset = r3;
        if (this.regex.charAt(r3) != ')') goto L15;
        this.offset++;
        Token r5 = null;
    L26:
        next();
        Token r6 = parseRegex();
        if (r6.type != 2) goto L34;
        if (r6.size() != 2) goto L32;
        r4 = r6.getChild(1);
        r6 = r6.getChild(0);
        goto L34
    L32:
        throw ex("parser.factor.6", this.offset);
    L34:
        if (read() != 7) goto L38;
        next();
        return Token.createCondition(r1, r5, r6, r4);
    L38:
        throw ex("parser.factor.1", this.offset - 1);
    L15:
        throw ex("parser.factor.1", this.offset);
    L17:
        if (r2 != '?') goto L19;
        this.offset--;
    L19:
        next();
        r5 = parseFactor();
        int r7 = r5.type;
        if (r7 == 8) goto L25;
        switch(r7) {
            case 20: goto L26;
            case 21: goto L26;
            case 22: goto L26;
            case 23: goto L26;
            default: goto L23;
        };
    L23:
        throw ex("parser.factor.5", this.offset);
    L25:
        if (read() == 7) goto L26;
        throw ex("parser.factor.1", this.offset - 1);
    L42:
        throw ex("parser.factor.4", r0);
    }

    Token processDollar() {
        next();
        return Token.token_lineend;
    }

    Token processIndependent() {
        next();
        Token.ParenToken r0 = Token.createLook(24, parseRegex());
        if (read() != 7) goto L7;
        next();
        return r0;
    L7:
        throw ex("parser.factor.1", this.offset - 1);
    }

    Token processLookahead() {
        next();
        Token.ParenToken r0 = Token.createLook(20, parseRegex());
        if (read() != 7) goto L7;
        next();
        return r0;
    L7:
        throw ex("parser.factor.1", this.offset - 1);
    }

    Token processLookbehind() {
        next();
        Token.ParenToken r0 = Token.createLook(22, parseRegex());
        if (read() != 7) goto L7;
        next();
        return r0;
    L7:
        throw ex("parser.factor.1", this.offset - 1);
    }

    Token processModifiers() {
        int r0 = 0;
        byte r1 = -1;
        int r2 = 0;
    L3:
        int r3 = this.offset;
        if (r3 >= this.regexlen) goto L9;
        r1 = this.regex.charAt(r3);
        int r4 = REUtil.getOptionValue(r1);
        if (r4 == 0) goto L9;
        r2 = r2 | r4;
        this.offset++;
    L9:
        int r5 = this.offset;
        if (r5 >= this.regexlen) goto L38;
        if (r1 != 45) goto L25;
    L13:
        this.offset = r5 + 1;
        int r6 = this.offset;
        if (r6 >= this.regexlen) goto L19;
        r1 = this.regex.charAt(r6);
        int r7 = REUtil.getOptionValue(r1);
        if (r7 == 0) goto L19;
        r0 = r0 | r7;
        r5 = this.offset;
    L19:
        int r8 = this.offset;
        if (r8 < this.regexlen) goto L25;
        throw ex("parser.factor.2", r8 - 1);
    L25:
        if (r1 != 58) goto L32;
        this.offset++;
        next();
        Token.ModifierToken r9 = Token.createModifierGroup(parseRegex(), r2, r0);
        if (read() != 7) goto L30;
        next();
        return r9;
    L30:
        throw ex("parser.factor.1", this.offset - 1);
    L32:
        if (r1 != 41) goto L36;
        this.offset++;
        next();
        return Token.createModifierGroup(parseRegex(), r2, r0);
    L36:
        throw ex("parser.factor.3", this.offset);
    L38:
        throw ex("parser.factor.2", r5 - 1);
    }

    Token processNegativelookahead() {
        next();
        Token.ParenToken r0 = Token.createLook(21, parseRegex());
        if (read() != 7) goto L7;
        next();
        return r0;
    L7:
        throw ex("parser.factor.1", this.offset - 1);
    }

    Token processNegativelookbehind() {
        next();
        Token.ParenToken r0 = Token.createLook(23, parseRegex());
        if (read() != 7) goto L7;
        next();
        return r0;
    L7:
        throw ex("parser.factor.1", this.offset - 1);
    }

    Token processParen() {
        next();
        int r0 = this.parennumber;
        this.parennumber = r0 + 1;
        Token.ParenToken r1 = Token.createParen(parseRegex(), r0);
        if (read() != 7) goto L7;
        next();
        return r1;
    L7:
        throw ex("parser.factor.1", this.offset - 1);
    }

    Token processParen2() {
        next();
        Token.ParenToken r0 = Token.createParen(parseRegex(), 0);
        if (read() != 7) goto L7;
        next();
        return r0;
    L7:
        throw ex("parser.factor.1", this.offset - 1);
    }

    Token processPlus(Token r3) {
        next();
        if (read() != 5) goto L7;
        next();
        Token.ClosureToken r2 = Token.createNGClosure(r3);
    L6:
        return Token.createConcat(r3, r2);
    L7:
        r2 = Token.createClosure(r3);
        goto L6
    }

    Token processQuestion(Token r4) {
        next();
        Token.UnionToken r0 = Token.createUnion();
        if (read() != 5) goto L5;
        next();
        r0.addChild(Token.createEmpty());
        r0.addChild(r4);
    L6:
        return r0;
    L5:
        r0.addChild(r4);
        r0.addChild(Token.createEmpty());
        goto L6
    }

    Token processStar(Token r3) {
        next();
        if (read() != 5) goto L7;
        next();
        return Token.createNGClosure(r3);
    L7:
        return Token.createClosure(r3);
    }

    final int read() {
        return this.nexttoken;
    }

    public final void setContext(int r1) {
        this.context = r1;
    }

    public void setLocale(Locale r3) {
        this.resources = ResourceBundle.getBundle("org.apache.xmlbeans.impl.regex.message", r3, RegexParser.class.getClassLoader());
    }
}
