package org.apache.xmlbeans.impl.regex;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;
import kotlin.text.Typography;
import okio.Utf8;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
class Token implements Serializable {
    static final int ANCHOR = 8;
    static final int BACKREFERENCE = 12;
    static final int CHAR = 0;
    static final int CHAR_FINAL_QUOTE = 30;
    static final int CHAR_INIT_QUOTE = 29;
    static final int CHAR_LETTER = 31;
    static final int CHAR_MARK = 32;
    static final int CHAR_NUMBER = 33;
    static final int CHAR_OTHER = 35;
    static final int CHAR_PUNCTUATION = 36;
    static final int CHAR_SEPARATOR = 34;
    static final int CHAR_SYMBOL = 37;
    static final int CLOSURE = 3;
    static final int CONCAT = 1;
    static final int CONDITION = 26;
    static final boolean COUNTTOKENS = true;
    static final int DOT = 11;
    static final int EMPTY = 7;
    static final int FC_ANY = 2;
    static final int FC_CONTINUE = 0;
    static final int FC_TERMINAL = 1;
    static final int INDEPENDENT = 24;
    static final int LOOKAHEAD = 20;
    static final int LOOKBEHIND = 22;
    static final int MODIFIERGROUP = 25;
    static final int NEGATIVELOOKAHEAD = 21;
    static final int NEGATIVELOOKBEHIND = 23;
    private static final int NONBMP_BLOCK_START = 84;
    static final int NONGREEDYCLOSURE = 9;
    static final int NRANGE = 5;
    static final int PAREN = 6;
    static final int RANGE = 4;
    static final int STRING = 10;
    static final int UNION = 2;
    static final int UTF16_MAX = 1114111;
    private static final String[] blockNames = null;
    static final String blockRanges = "\u0000\u007f\u0080ÿĀſƀɏɐʯʰ˿̀ͯͰϿЀӿ\u0530֏\u0590\u05ff\u0600ۿ܀ݏހ\u07bfऀॿঀ\u09ff\u0a00\u0a7f\u0a80૿\u0b00\u0b7f\u0b80\u0bffఀ౿ಀ\u0cffഀൿ\u0d80\u0dff\u0e00\u0e7f\u0e80\u0effༀ\u0fffက႟Ⴀჿᄀᇿሀ\u137fᎠ\u13ff᐀ᙿ\u1680\u169fᚠ\u16ffក\u17ff᠀\u18afḀỿἀ\u1fff\u2000\u206f⁰\u209f₠\u20cf⃐\u20ff℀⅏⅐\u218f←⇿∀⋿⌀⏿␀\u243f⑀\u245f①⓿─╿▀▟■◿☀⛿✀➿⠀⣿⺀\u2eff⼀\u2fdf⿰⿿\u3000〿\u3040ゟ゠ヿ\u3100ㄯ\u3130\u318f㆐㆟ㆠㆿ㈀㋿㌀㏿㐀䶵一鿿ꀀ\ua48f꒐\ua4cf가힣\ue000\uf8ff豈\ufaffﬀﭏﭐ﷿︠︯︰﹏﹐\ufe6fﹰ\ufefe\ufeff\ufeff\uff00\uffef";
    private static final Hashtable categories = null;
    private static final Hashtable categories2 = null;
    private static final String[] categoryNames = null;
    static final int[] nonBMPBlockRanges = null;
    static Hashtable nonxs = null;
    static Token token_0to9 = null;
    private static Token token_ccs = null;
    static Token token_dot = null;
    static Token token_empty = null;
    private static Token token_grapheme = null;
    static Token token_linebeginning = null;
    static Token token_linebeginning2 = null;
    static Token token_lineend = null;
    static Token token_not_0to9 = null;
    static Token token_not_spaces = null;
    static Token token_not_wordchars = null;
    static Token token_not_wordedge = null;
    static Token token_spaces = null;
    static Token token_stringbeginning = null;
    static Token token_stringend = null;
    static Token token_stringend2 = null;
    static Token token_wordbeginning = null;
    static Token token_wordchars = null;
    static Token token_wordedge = null;
    static Token token_wordend = null;
    static int tokens = 0;
    static final String viramaString = "्্੍્୍்్್്ฺ྄";
    int type;

    static class CharToken extends Token implements Serializable {
        int chardata;

        CharToken(int r1, int r2) {
            super(r1);
            this.chardata = r2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getChar() {
            return this.chardata;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        boolean match(int r3) {
            if (this.type != 0) goto L10;
            if (r3 != this.chardata) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int r4) {
            int r5 = this.type;
            if (r5 != 0) goto L5;
            int r6 = this.chardata;
            if (r6 != 9) goto L18;
            return "\\t";
        L18:
            if (r6 != 10) goto L20;
            return "\\n";
        L20:
            if (r6 != 12) goto L22;
            return "\\f";
        L22:
            if (r6 != 13) goto L24;
            return "\\r";
        L24:
            if (r6 != 27) goto L26;
            return "\\e";
        L26:
            if (r6 != 46) goto L28;
        L42:
            StringBuilder r7 = new StringBuilder();
        L43:
            StringBuilder r8 = r7.append("\\");
        L44:
            StringBuilder r3 = r8.append((char) this.chardata);
        L53:
            return r3.toString();
        L28:
            if (r6 == 63) goto L42;
            if (r6 == 91) goto L42;
            if (r6 == 92) goto L42;
            if (r6 == 123) goto L42;
            if (r6 == 124) goto L42;
            switch(r6) {
                case 40: goto L42;
                case 41: goto L42;
                case 42: goto L42;
                case 43: goto L42;
                default: goto L39;
            };
        L39:
            if (r6 < 65536) goto L41;
            String r9 = "0" + Integer.toHexString(this.chardata);
            r3 = new StringBuilder().append("\\v").append(r9.substring(r9.length() - 6, r9.length()));
            goto L53
        L41:
            StringBuilder r10 = new StringBuilder();
        L14:
            r8 = r10.append("");
            goto L44
        L5:
            if (r5 == 8) goto L8;
            return null;
        L8:
            if (this != Token.token_linebeginning) goto L10;
        L13:
            r10 = new StringBuilder();
            goto L14
        L10:
            if (this == Token.token_lineend) goto L13;
            r7 = new StringBuilder();
            goto L43
        }
    }

    static class ClosureToken extends Token implements Serializable {
        Token child;
        int max;
        int min;

        ClosureToken(int r1, Token r2) {
            super(r1);
            this.child = r2;
            setMin(-1);
            setMax(-1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int r1) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final int getMax() {
            return this.max;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final int getMin() {
            return this.min;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final void setMax(int r1) {
            this.max = r1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        final void setMin(int r1) {
            this.min = r1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int r7) {
            if (this.type != 3) goto L25;
            if (getMin() < 0) goto L7;
        L9:
            String r5 = "}";
            if (getMin() != getMax()) goto L13;
            StringBuilder r0 = new StringBuilder();
        L33:
            StringBuilder r8 = r0.append(this.child.toString(r7)).append("{");
            int r6 = getMin();
        L34:
            StringBuilder r9 = r8.append(r6).append(r5);
        L47:
            return r9.toString();
        L13:
            if (getMin() < 0) goto L18;
            if (getMax() < 0) goto L18;
            StringBuilder r1 = new StringBuilder();
        L41:
            r8 = r1.append(this.child.toString(r7)).append("{").append(getMin()).append(",");
            r6 = getMax();
        L18:
            if (getMin() < 0) goto L23;
            if (getMax() >= 0) goto L23;
            StringBuilder r10 = new StringBuilder().append(this.child.toString(r7)).append("{").append(getMin());
            String r11 = ",}";
        L29:
            r9 = r10.append(r11);
        L23:
            throw new RuntimeException("Token#toString(): CLOSURE " + getMin() + ", " + getMax());
        L7:
            if (getMax() >= 0) goto L9;
            r10 = new StringBuilder().append(this.child.toString(r7));
            r11 = "*";
            goto L29
        L25:
            if (getMin() < 0) goto L27;
        L30:
            r5 = "}?";
            if (getMin() != getMax()) goto L37;
            r0 = new StringBuilder();
            goto L33
        L37:
            if (getMin() < 0) goto L43;
            if (getMax() < 0) goto L43;
            r1 = new StringBuilder();
        L43:
            if (getMin() < 0) goto L49;
            if (getMax() >= 0) goto L49;
            r10 = new StringBuilder().append(this.child.toString(r7)).append("{").append(getMin());
            r11 = ",}?";
        L49:
            throw new RuntimeException("Token#toString(): NONGREEDYCLOSURE " + getMin() + ", " + getMax());
        L27:
            if (getMax() >= 0) goto L30;
            r10 = new StringBuilder().append(this.child.toString(r7));
            r11 = "*?";
            goto L29
        }
    }

    static class ConcatToken extends Token implements Serializable {
        Token child;
        Token child2;

        ConcatToken(Token r2, Token r3) {
            super(1);
            this.child = r2;
            this.child2 = r3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int r1) {
            if (r1 != 0) goto L5;
            return this.child;
        L5:
            return this.child2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int r4) {
            if (this.child2.type != 3) goto L9;
            if (this.child2.getChild(0) != this.child) goto L9;
            StringBuilder r3 = new StringBuilder().append(this.child.toString(r4));
            String r5 = Marker.ANY_NON_NULL_MARKER;
        L7:
            StringBuilder r6 = r3.append(r5);
        L15:
            return r6.toString();
        L9:
            if (this.child2.type == 9) goto L11;
        L13:
            r6 = new StringBuilder().append(this.child.toString(r4)).append(this.child2.toString(r4));
            goto L15
        L11:
            if (this.child2.getChild(0) != this.child) goto L13;
            r3 = new StringBuilder().append(this.child.toString(r4));
            r5 = "+?";
            goto L7
        }
    }

    static class ConditionToken extends Token implements Serializable {
        Token condition;
        Token no;
        int refNumber;
        Token yes;

        ConditionToken(int r2, Token r3, Token r4, Token r5) {
            super(26);
            this.refNumber = r2;
            this.condition = r3;
            this.yes = r4;
            this.no = r5;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int r3) {
            if (r3 != 0) goto L6;
            return this.yes;
        L6:
            if (r3 != 1) goto L10;
            return this.no;
        L10:
            throw new RuntimeException("Internal Error: " + r3);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            if (this.no != null) goto L5;
            return 1;
        L5:
            return 2;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int r4) {
            if (this.refNumber <= 0) goto L8;
            StringBuilder r5 = new StringBuilder().append("(?(").append(this.refNumber);
        L5:
            StringBuilder r6 = r5.append(")");
        L6:
            String r7 = r6.toString();
            if (this.no != null) goto L14;
            StringBuilder r8 = new StringBuilder().append(r7);
            Token r3 = this.yes;
        L16:
            return r8.append(r3).append(")").toString();
        L14:
            r8 = new StringBuilder().append(r7).append(this.yes).append("|");
            r3 = this.no;
            goto L16
        L8:
            if (this.condition.type != 8) goto L10;
            r5 = new StringBuilder().append("(?(").append(this.condition);
            goto L5
        L10:
            r6 = new StringBuilder().append("(?").append(this.condition);
            goto L6
        }
    }

    static class FixedStringContainer {
        int options;
        Token token;

        FixedStringContainer() {
            this.token = null;
            this.options = 0;
        }
    }

    static class ModifierToken extends Token implements Serializable {
        int add;
        Token child;
        int mask;

        ModifierToken(Token r2, int r3, int r4) {
            super(25);
            this.child = r2;
            this.add = r3;
            this.mask = r4;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int r1) {
            return this.child;
        }

        int getOptions() {
            return this.add;
        }

        int getOptionsMask() {
            return this.mask;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int r4) {
            StringBuilder r0 = new StringBuilder().append("(?");
            int r1 = this.add;
            String r2 = "";
            if (r1 != 0) goto L5;
            String r3 = "";
        L6:
            StringBuilder r5 = r0.append(r3);
            int r6 = this.mask;
            if (r6 == 0) goto L11;
            r2 = REUtil.createOptionString(r6);
        L11:
            return r5.append(r2).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(this.child.toString(r4)).append(")").toString();
        L5:
            r3 = REUtil.createOptionString(r1);
            goto L6
        }
    }

    static class ParenToken extends Token implements Serializable {
        Token child;
        int parennumber;

        ParenToken(int r1, Token r2, int r3) {
            super(r1);
            this.child = r2;
            this.parennumber = r3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int r1) {
            return this.child;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getParenNumber() {
            return this.parennumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            return 1;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int r4) {
            int r0 = this.type;
            if (r0 == 6) goto L13;
            switch(r0) {
                case 20: goto L10;
                case 21: goto L9;
                case 22: goto L8;
                case 23: goto L7;
                case 24: goto L6;
                default: goto L5;
            };
        L5:
            return null;
        L6:
            StringBuilder r1 = new StringBuilder();
            String r2 = "(?>";
        L17:
            return r1.append(r2).append(this.child.toString(r4)).append(")").toString();
        L7:
            r1 = new StringBuilder();
            r2 = "(?<!";
            goto L17
        L8:
            r1 = new StringBuilder();
            r2 = "(?<=";
            goto L17
        L9:
            r1 = new StringBuilder();
            r2 = "(?!";
            goto L17
        L10:
            r1 = new StringBuilder();
            r2 = "(?=";
            goto L17
        L13:
            if (this.parennumber != 0) goto L15;
            r1 = new StringBuilder();
            r2 = "(?:";
            goto L17
        L15:
            r1 = new StringBuilder();
            r2 = "(";
            goto L17
        }
    }

    static class StringToken extends Token implements Serializable {
        int refNumber;
        String string;

        StringToken(int r1, String r2, int r3) {
            super(r1);
            this.string = r2;
            this.refNumber = r3;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int getReferenceNumber() {
            return this.refNumber;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        String getString() {
            return this.string;
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int r2) {
            if (this.type != 12) goto L7;
            return "\\" + this.refNumber;
        L7:
            return REUtil.quoteMeta(this.string);
        }
    }

    static class UnionToken extends Token implements Serializable {
        Vector children;

        UnionToken(int r1) {
            super(r1);
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        void addChild(Token r8) {
            if (r8 != null) goto L5;
            return;
        L5:
            if (this.children != null) goto L8;
            this.children = new Vector();
        L8:
            if (this.type != 2) goto L12;
            this.children.addElement(r8);
            return;
        L12:
            if (r8.type != 1) goto L18;
            int r0 = 0;
        L15:
            if (r0 >= r8.size()) goto L17;
            addChild(r8.getChild(r0));
            r0 = r0 + 1;
            goto L15
        L17:
            return;
        L18:
            int r1 = this.children.size();
            if (r1 != 0) goto L22;
            this.children.addElement(r8);
            return;
        L22:
            int r2 = r1 - 1;
            Token r3 = (Token) ZeusTransformUtils.preCheckCast(this.children.elementAt(r2), Token.class, "com.obric.memorydata.plugin");
            if (r3.type == 0) goto L27;
            if (r3.type == 10) goto L27;
        L30:
            this.children.addElement(r8);
            return;
        L27:
            if (r8.type == 0) goto L33;
            if (r8.type != 10) goto L30;
        L33:
            if (r8.type != 0) goto L35;
            int r4 = 2;
        L37:
            if (r3.type != 0) goto L43;
            StringBuilder r5 = new StringBuilder(r4 + 2);
            int r6 = r3.getChar();
            if (r6 < 65536) goto L41;
            r5.append(REUtil.decomposeToSurrogates(r6));
        L42:
            r3 = Token.createString(null);
            this.children.setElementAt(r3, r2);
        L45:
            if (r8.type != 0) goto L50;
            int r7 = r8.getChar();
            if (r7 < 65536) goto L49;
            String r9 = REUtil.decomposeToSurrogates(r7);
        L51:
            r5.append(r9);
        L52:
            ((StringToken) ZeusTransformUtils.preCheckCast(r3, StringToken.class, "com.obric.memorydata.plugin")).string = new String(r5);
            return;
        L49:
            r5.append((char) r7);
            goto L52
        L50:
            r9 = r8.getString();
            goto L51
        L41:
            r5.append((char) r6);
            goto L42
        L43:
            r5 = new StringBuilder(r3.getString().length() + r4);
            r5.append(r3.getString());
            goto L45
        L35:
            r4 = r8.getString().length();
            goto L37
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        Token getChild(int r2) {
            return (Token) ZeusTransformUtils.preCheckCast(this.children.elementAt(r2), Token.class, "com.obric.memorydata.plugin");
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        int size() {
            Vector r0 = this.children;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        @Override // org.apache.xmlbeans.impl.regex.Token
        public String toString(int r7) {
            int r3 = 0;
            int r4 = 1;
            if (this.type != 1) goto L26;
            if (this.children.size() != 2) goto L19;
            Token r0 = getChild(0);
            Token r6 = getChild(1);
            if (r6.type != 3) goto L13;
            if (r6.getChild(0) != r0) goto L13;
            StringBuilder r8 = new StringBuilder().append(r0.toString(r7));
            String r9 = Marker.ANY_NON_NULL_MARKER;
        L11:
            StringBuilder r10 = r8.append(r9);
        L44:
            return r10.toString();
        L13:
            if (r6.type == 9) goto L15;
        L17:
            r10 = new StringBuilder().append(r0.toString(r7)).append(r6.toString(r7));
            goto L44
        L15:
            if (r6.getChild(0) != r0) goto L17;
            r8 = new StringBuilder().append(r0.toString(r7));
            r9 = "+?";
            goto L11
        L19:
            StringBuilder r1 = new StringBuilder();
        L21:
            if (r3 >= this.children.size()) goto L24;
            r1.append(((Token) ZeusTransformUtils.preCheckCast(this.children.elementAt(r3), Token.class, "com.obric.memorydata.plugin")).toString(r7));
            r3 = r3 + 1;
            goto L21
        L24:
            return new String(r1);
        L26:
            if (this.children.size() != 2) goto L32;
            if (getChild(1).type != 7) goto L32;
            StringBuilder r11 = new StringBuilder().append(getChild(0).toString(r7));
            String r12 = "?";
        L45:
            return r11.append(r12).toString();
        L32:
            if (this.children.size() == 2) goto L34;
        L36:
            StringBuilder r2 = new StringBuilder();
            r2.append(((Token) ZeusTransformUtils.preCheckCast(this.children.elementAt(0), Token.class, "com.obric.memorydata.plugin")).toString(r7));
        L38:
            if (r4 >= this.children.size()) goto L41;
            r2.append('|');
            r2.append(((Token) ZeusTransformUtils.preCheckCast(this.children.elementAt(r4), Token.class, "com.obric.memorydata.plugin")).toString(r7));
            r4 = r4 + 1;
            goto L38
        L41:
            return new String(r2);
        L34:
            if (getChild(0).type != 7) goto L36;
            r11 = new StringBuilder().append(getChild(1).toString(r7));
            r12 = "??";
            goto L45
        }
    }

    static {
        token_empty = new Token(7);
        token_linebeginning = createAnchor(94);
        token_linebeginning2 = createAnchor(64);
        token_lineend = createAnchor(36);
        token_stringbeginning = createAnchor(65);
        token_stringend = createAnchor(122);
        token_stringend2 = createAnchor(90);
        token_wordedge = createAnchor(98);
        token_not_wordedge = createAnchor(66);
        token_wordbeginning = createAnchor(60);
        token_wordend = createAnchor(62);
        token_dot = new Token(11);
        RangeToken r3 = createRange();
        token_0to9 = r3;
        r3.addRange(48, 57);
        RangeToken r4 = createRange();
        token_wordchars = r4;
        r4.addRange(48, 57);
        token_wordchars.addRange(65, 90);
        token_wordchars.addRange(95, 95);
        token_wordchars.addRange(97, 122);
        RangeToken r0 = createRange();
        token_spaces = r0;
        r0.addRange(9, 9);
        token_spaces.addRange(10, 10);
        token_spaces.addRange(12, 12);
        token_spaces.addRange(13, 13);
        token_spaces.addRange(32, 32);
        token_not_0to9 = complementRanges(token_0to9);
        token_not_wordchars = complementRanges(token_wordchars);
        token_not_spaces = complementRanges(token_spaces);
        categories = new Hashtable();
        categories2 = new Hashtable();
        categoryNames = new String[]{"Cn", "Lu", "Ll", "Lt", "Lm", "Lo", "Mn", "Me", "Mc", "Nd", "Nl", "No", "Zs", "Zl", "Zp", "Cc", "Cf", null, "Co", "Cs", "Pd", "Ps", "Pe", "Pc", "Po", "Sm", "Sc", "Sk", "So", "Pi", "Pf", i.u, "M", "N", "Z", "C", i.m, "S"};
        blockNames = new String[]{"Basic Latin", "Latin-1 Supplement", "Latin Extended-A", "Latin Extended-B", "IPA Extensions", "Spacing Modifier Letters", "Combining Diacritical Marks", "Greek", "Cyrillic", "Armenian", "Hebrew", "Arabic", "Syriac", "Thaana", "Devanagari", "Bengali", "Gurmukhi", "Gujarati", "Oriya", "Tamil", "Telugu", "Kannada", "Malayalam", "Sinhala", "Thai", "Lao", "Tibetan", "Myanmar", "Georgian", "Hangul Jamo", "Ethiopic", "Cherokee", "Unified Canadian Aboriginal Syllabics", "Ogham", "Runic", "Khmer", "Mongolian", "Latin Extended Additional", "Greek Extended", "General Punctuation", "Superscripts and Subscripts", "Currency Symbols", "Combining Marks for Symbols", "Letterlike Symbols", "Number Forms", "Arrows", "Mathematical Operators", "Miscellaneous Technical", "Control Pictures", "Optical Character Recognition", "Enclosed Alphanumerics", "Box Drawing", "Block Elements", "Geometric Shapes", "Miscellaneous Symbols", "Dingbats", "Braille Patterns", "CJK Radicals Supplement", "Kangxi Radicals", "Ideographic Description Characters", "CJK Symbols and Punctuation", "Hiragana", "Katakana", "Bopomofo", "Hangul Compatibility Jamo", "Kanbun", "Bopomofo Extended", "Enclosed CJK Letters and Months", "CJK Compatibility", "CJK Unified Ideographs Extension A", "CJK Unified Ideographs", "Yi Syllables", "Yi Radicals", "Hangul Syllables", "Private Use", "CJK Compatibility Ideographs", "Alphabetic Presentation Forms", "Arabic Presentation Forms-A", "Combining Half Marks", "CJK Compatibility Forms", "Small Form Variants", "Arabic Presentation Forms-B", "Specials", "Halfwidth and Fullwidth Forms", "Old Italic", "Gothic", "Deseret", "Byzantine Musical Symbols", "Musical Symbols", "Mathematical Alphanumeric Symbols", "CJK Unified Ideographs Extension B", "CJK Compatibility Ideographs Supplement", "Tags"};
        nonBMPBlockRanges = new int[]{66304, 66351, 66352, 66383, 66560, 66639, 118784, 119039, 119040, 119295, 119808, 120831, 131072, 173782, 194560, 195103, 917504, 917631};
        nonxs = null;
        token_grapheme = null;
        token_ccs = null;
    }

    public Token(int r1) {
        this.type = r1;
    }

    static Token complementRanges(Token r0) {
        return RangeToken.complementRanges(r0);
    }

    private static CharToken createAnchor(int r2) {
        tokens++;
        return new CharToken(8, r2);
    }

    static StringToken createBackReference(int r3) {
        tokens++;
        return new StringToken(12, null, r3);
    }

    static CharToken createChar(int r2) {
        tokens++;
        return new CharToken(0, r2);
    }

    static ClosureToken createClosure(Token r2) {
        tokens++;
        return new ClosureToken(3, r2);
    }

    static ConcatToken createConcat(Token r1, Token r2) {
        tokens++;
        return new ConcatToken(r1, r2);
    }

    static UnionToken createConcat() {
        tokens++;
        return new UnionToken(1);
    }

    static ConditionToken createCondition(int r1, Token r2, Token r3, Token r4) {
        tokens++;
        return new ConditionToken(r1, r2, r3, r4);
    }

    static Token createEmpty() {
        return token_empty;
    }

    static ParenToken createLook(int r2, Token r3) {
        tokens++;
        return new ParenToken(r2, r3, 0);
    }

    static ModifierToken createModifierGroup(Token r1, int r2, int r3) {
        tokens++;
        return new ModifierToken(r1, r2, r3);
    }

    static ClosureToken createNGClosure(Token r2) {
        tokens++;
        return new ClosureToken(9, r2);
    }

    static RangeToken createNRange() {
        tokens++;
        return new RangeToken(5);
    }

    static ParenToken createParen(Token r2, int r3) {
        tokens++;
        return new ParenToken(6, r2, r3);
    }

    static RangeToken createRange() {
        tokens++;
        return new RangeToken(4);
    }

    static StringToken createString(String r3) {
        tokens++;
        return new StringToken(10, r3, 0);
    }

    static UnionToken createUnion() {
        tokens++;
        return new UnionToken(2);
    }

    static synchronized Token getCombiningCharacterSequence() {
        monitor-enter(Token.class);
        Token r1 = token_ccs;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(Token.class);
        return r1;
    L8:
        ClosureToken r2 = createClosure(getRange("M", true));     // Catch: Throwable -> L11
        ConcatToken r3 = createConcat(getRange("M", false), r2);     // Catch: Throwable -> L11
        token_ccs = r3;     // Catch: Throwable -> L11
        monitor-exit(Token.class);
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    static synchronized Token getGraphemePattern() {
        monitor-enter(Token.class);
        Token r1 = token_grapheme;     // Catch: Throwable -> L15
        if (r1 == null) goto L8;
        monitor-exit(Token.class);
        return r1;
    L8:
        RangeToken r2 = createRange();     // Catch: Throwable -> L15
        r2.mergeRanges(getRange("ASSIGNED", true));     // Catch: Throwable -> L15
        r2.subtractRanges(getRange("M", true));     // Catch: Throwable -> L15
        r2.subtractRanges(getRange("C", true));     // Catch: Throwable -> L15
        RangeToken r3 = createRange();     // Catch: Throwable -> L15
        int r4 = 0;
    L10:
        if (r4 >= 11) goto L12;
        viramaString.charAt(r4);     // Catch: Throwable -> L15
        r3.addRange(r4, r4);     // Catch: Throwable -> L15
        r4 = r4 + 1;     // Catch: Throwable -> L15
        goto L10
    L12:
        RangeToken r5 = createRange();     // Catch: Throwable -> L15
        r5.mergeRanges(getRange("M", true));     // Catch: Throwable -> L15
        r5.addRange(4448, 4607);     // Catch: Throwable -> L15
        r5.addRange(65438, 65439);     // Catch: Throwable -> L15
        UnionToken r6 = createUnion();     // Catch: Throwable -> L15
        r6.addChild(r2);     // Catch: Throwable -> L15
        r6.addChild(token_empty);     // Catch: Throwable -> L15
        UnionToken r7 = createUnion();     // Catch: Throwable -> L15
        r7.addChild(createConcat(r3, getRange(i.u, true)));     // Catch: Throwable -> L15
        r7.addChild(r5);     // Catch: Throwable -> L15
        ConcatToken r8 = createConcat(r6, createClosure(r7));     // Catch: Throwable -> L15
        token_grapheme = r8;     // Catch: Throwable -> L15
        monitor-exit(Token.class);
        return r8;
    L15:
        th = move-exception;
        throw th;
    }

    public static RangeToken getRange(String r16, boolean r17) {
        Hashtable r1 = categories;
        if (r1.size() != 0) goto L87;
        monitor-enter(r1);
        int r2 = categoryNames.length;     // Catch: Throwable -> L84
        Token[] r3 = new Token[r2];     // Catch: Throwable -> L84
        int r5 = 0;
    L6:
        if (r5 >= r2) goto L8;
        r3[r5] = createRange();     // Catch: Throwable -> L84
        r5 = r5 + 1;     // Catch: Throwable -> L84
        goto L6
    L8:
        int r6 = 0;
    L9:
        char r7 = Typography.quote;
        if (r6 >= 65536) goto L49;
        int r8 = Character.getType((char) r6);     // Catch: Throwable -> L84
        if (r8 == 21) goto L16;
        if (r8 == 22) goto L16;
    L37:
        r3[r8].addRange(r6, r6);     // Catch: Throwable -> L84
        switch(r8) {
            case 0: goto L45;
            case 1: goto L44;
            case 2: goto L44;
            case 3: goto L44;
            case 4: goto L44;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L43;
            case 8: goto L43;
            case 9: goto L42;
            case 10: goto L42;
            case 11: goto L42;
            case 12: goto L46;
            case 13: goto L46;
            case 14: goto L46;
            case 15: goto L45;
            case 16: goto L45;
            case 17: goto L48;
            case 18: goto L45;
            case 19: goto L45;
            case 20: goto L41;
            case 21: goto L41;
            case 22: goto L41;
            case 23: goto L41;
            case 24: goto L41;
            case 25: goto L40;
            case 26: goto L40;
            case 27: goto L40;
            case 28: goto L40;
            case 29: goto L41;
            case 30: goto L41;
            default: goto L48;
        };     // Catch: Throwable -> L84
    L40:
        r7 = '%';
        goto L46
    L41:
        r7 = Typography.dollar;
        goto L46
    L42:
        r7 = '!';
        goto L46
    L43:
        r7 = ' ';
        goto L46
    L44:
        r7 = 31;
        goto L46
    L45:
        r7 = '#';
        goto L46
    L48:
        throw new RuntimeException("org.apache.xerces.utils.regex.Token#getRange(): Unknown Unicode category: " + r8);     // Catch: Throwable -> L84
    L46:
        r3[r7].addRange(r6, r6);     // Catch: Throwable -> L84
        r6 = r6 + 1;     // Catch: Throwable -> L84
    L16:
        if (r6 != 171) goto L18;
    L27:
        r8 = 29;
    L29:
        if (r6 != 187) goto L31;
    L36:
        r8 = 30;
        goto L37
    L31:
        if (r6 == 8217) goto L36;
        if (r6 == 8221) goto L36;
        if (r6 != 8250) goto L37;
    L18:
        if (r6 == 8216) goto L27;
        if (r6 == 8219) goto L27;
        if (r6 == 8220) goto L27;
        if (r6 == 8223) goto L27;
        if (r6 != 8249) goto L29;
    L49:
        r3[0].addRange(65536, UTF16_MAX);     // Catch: Throwable -> L84
        int r9 = 0;
    L50:
        if (r9 >= r2) goto L57;
        String[] r11 = categoryNames;     // Catch: Throwable -> L84
        if (r11[r9] == null) goto L56;
        if (r9 != 0) goto L55;
        r3[r9].addRange(65536, UTF16_MAX);     // Catch: Throwable -> L84
    L55:
        categories.put(r11[r9], r3[r9]);     // Catch: Throwable -> L84
        categories2.put(r11[r9], complementRanges(r3[r9]));     // Catch: Throwable -> L84
    L56:
        r9 = r9 + 1;     // Catch: Throwable -> L84
        goto L50
    L57:
        StringBuilder r4 = new StringBuilder(50);     // Catch: Throwable -> L84
        int r10 = 0;
    L58:
        String[] r12 = blockNames;     // Catch: Throwable -> L84
        if (r10 >= r12.length) goto L81;
        RangeToken r13 = createRange();     // Catch: Throwable -> L84
        if (r10 >= 84) goto L63;
        int r14 = r10 * 2;     // Catch: Throwable -> L84
        r13.addRange(blockRanges.charAt(r14), blockRanges.charAt(r14 + 1));     // Catch: Throwable -> L84
    L64:
        String r15 = r12[r10];     // Catch: Throwable -> L84
        if (r15.equals("Specials") == false) goto L68;
        r13.addRange(65520, Utf8.REPLACEMENT_CODE_POINT);     // Catch: Throwable -> L84
    L68:
        if (r15.equals("Private Use") == false) goto L70;
        r13.addRange(983040, 1048573);     // Catch: Throwable -> L84
        r13.addRange(1048576, 1114109);     // Catch: Throwable -> L84
    L70:
        categories.put(r15, r13);     // Catch: Throwable -> L84
        categories2.put(r15, complementRanges(r13));     // Catch: Throwable -> L84
        r4.setLength(0);     // Catch: Throwable -> L84
        r4.append("Is");     // Catch: Throwable -> L84
        if (r15.indexOf(32) < 0) goto L79;
        int r18 = 0;
    L74:
        if (r18 >= r15.length()) goto L80;
        if (r15.charAt(r18) == ' ') goto L78;
        r4.append(r15.charAt(r18));     // Catch: Throwable -> L84
    L78:
        r18 = r18 + 1;     // Catch: Throwable -> L84
    L80:
        setAlias(r4.toString(), r15, true);     // Catch: Throwable -> L84
        r10 = r10 + 1;     // Catch: Throwable -> L84
        goto L58
    L79:
        r4.append(r15);     // Catch: Throwable -> L84
        goto L80
    L63:
        int r19 = (r10 - 84) * 2;     // Catch: Throwable -> L84
        int[] r110 = nonBMPBlockRanges;     // Catch: Throwable -> L84
        r13.addRange(r110[r19], r110[r19 + 1]);     // Catch: Throwable -> L84
        goto L64
    L81:
        setAlias("ASSIGNED", "Cn", false);     // Catch: Throwable -> L84
        setAlias("UNASSIGNED", "Cn", true);     // Catch: Throwable -> L84
        RangeToken r20 = createRange();     // Catch: Throwable -> L84
        r20.addRange(0, UTF16_MAX);     // Catch: Throwable -> L84
        Hashtable r21 = categories;     // Catch: Throwable -> L84
        r21.put("ALL", r20);     // Catch: Throwable -> L84
        Hashtable r22 = categories2;     // Catch: Throwable -> L84
        r22.put("ALL", complementRanges(r20));     // Catch: Throwable -> L84
        registerNonXS("ASSIGNED");     // Catch: Throwable -> L84
        registerNonXS("UNASSIGNED");     // Catch: Throwable -> L84
        registerNonXS("ALL");     // Catch: Throwable -> L84
        RangeToken r23 = createRange();     // Catch: Throwable -> L84
        r23.mergeRanges(r3[1]);     // Catch: Throwable -> L84
        r23.mergeRanges(r3[2]);     // Catch: Throwable -> L84
        r23.mergeRanges(r3[5]);     // Catch: Throwable -> L84
        r21.put("IsAlpha", r23);     // Catch: Throwable -> L84
        r22.put("IsAlpha", complementRanges(r23));     // Catch: Throwable -> L84
        registerNonXS("IsAlpha");     // Catch: Throwable -> L84
        RangeToken r111 = createRange();     // Catch: Throwable -> L84
        r111.mergeRanges(r23);     // Catch: Throwable -> L84
        r111.mergeRanges(r3[9]);     // Catch: Throwable -> L84
        r21.put("IsAlnum", r111);     // Catch: Throwable -> L84
        r22.put("IsAlnum", complementRanges(r111));     // Catch: Throwable -> L84
        registerNonXS("IsAlnum");     // Catch: Throwable -> L84
        RangeToken r24 = createRange();     // Catch: Throwable -> L84
        r24.mergeRanges(token_spaces);     // Catch: Throwable -> L84
        r24.mergeRanges(r3[34]);     // Catch: Throwable -> L84
        r21.put("IsSpace", r24);     // Catch: Throwable -> L84
        r22.put("IsSpace", complementRanges(r24));     // Catch: Throwable -> L84
        registerNonXS("IsSpace");     // Catch: Throwable -> L84
        RangeToken r25 = createRange();     // Catch: Throwable -> L84
        r25.mergeRanges(r111);     // Catch: Throwable -> L84
        r25.addRange(95, 95);     // Catch: Throwable -> L84
        r21.put("IsWord", r25);     // Catch: Throwable -> L84
        r22.put("IsWord", complementRanges(r25));     // Catch: Throwable -> L84
        registerNonXS("IsWord");     // Catch: Throwable -> L84
        RangeToken r26 = createRange();     // Catch: Throwable -> L84
        r26.addRange(0, 127);     // Catch: Throwable -> L84
        r21.put("IsASCII", r26);     // Catch: Throwable -> L84
        r22.put("IsASCII", complementRanges(r26));     // Catch: Throwable -> L84
        registerNonXS("IsASCII");     // Catch: Throwable -> L84
        RangeToken r27 = createRange();     // Catch: Throwable -> L84
        r27.mergeRanges(r3[35]);     // Catch: Throwable -> L84
        r27.addRange(32, 32);     // Catch: Throwable -> L84
        r21.put("IsGraph", complementRanges(r27));     // Catch: Throwable -> L84
        r22.put("IsGraph", r27);     // Catch: Throwable -> L84
        registerNonXS("IsGraph");     // Catch: Throwable -> L84
        RangeToken r28 = createRange();     // Catch: Throwable -> L84
        r28.addRange(48, 57);     // Catch: Throwable -> L84
        r28.addRange(65, 70);     // Catch: Throwable -> L84
        r28.addRange(97, 102);     // Catch: Throwable -> L84
        r21.put("IsXDigit", complementRanges(r28));     // Catch: Throwable -> L84
        r22.put("IsXDigit", r28);     // Catch: Throwable -> L84
        registerNonXS("IsXDigit");     // Catch: Throwable -> L84
        setAlias("IsDigit", "Nd", true);     // Catch: Throwable -> L84
        setAlias("IsUpper", "Lu", true);     // Catch: Throwable -> L84
        setAlias("IsLower", "Ll", true);     // Catch: Throwable -> L84
        setAlias("IsCntrl", "C", true);     // Catch: Throwable -> L84
        setAlias("IsPrint", "C", false);     // Catch: Throwable -> L84
        setAlias("IsPunct", i.m, true);     // Catch: Throwable -> L84
        registerNonXS("IsDigit");     // Catch: Throwable -> L84
        registerNonXS("IsUpper");     // Catch: Throwable -> L84
        registerNonXS("IsLower");     // Catch: Throwable -> L84
        registerNonXS("IsCntrl");     // Catch: Throwable -> L84
        registerNonXS("IsPrint");     // Catch: Throwable -> L84
        registerNonXS("IsPunct");     // Catch: Throwable -> L84
        setAlias("alpha", "IsAlpha", true);     // Catch: Throwable -> L84
        setAlias("alnum", "IsAlnum", true);     // Catch: Throwable -> L84
        setAlias("ascii", "IsASCII", true);     // Catch: Throwable -> L84
        setAlias("cntrl", "IsCntrl", true);     // Catch: Throwable -> L84
        setAlias("digit", "IsDigit", true);     // Catch: Throwable -> L84
        setAlias("graph", "IsGraph", true);     // Catch: Throwable -> L84
        setAlias("lower", "IsLower", true);     // Catch: Throwable -> L84
        setAlias("print", "IsPrint", true);     // Catch: Throwable -> L84
        setAlias("punct", "IsPunct", true);     // Catch: Throwable -> L84
        setAlias("space", "IsSpace", true);     // Catch: Throwable -> L84
        setAlias("upper", "IsUpper", true);     // Catch: Throwable -> L84
        setAlias("word", "IsWord", true);     // Catch: Throwable -> L84
        setAlias("xdigit", "IsXDigit", true);     // Catch: Throwable -> L84
        registerNonXS("alpha");     // Catch: Throwable -> L84
        registerNonXS("alnum");     // Catch: Throwable -> L84
        registerNonXS("ascii");     // Catch: Throwable -> L84
        registerNonXS("cntrl");     // Catch: Throwable -> L84
        registerNonXS("digit");     // Catch: Throwable -> L84
        registerNonXS("graph");     // Catch: Throwable -> L84
        registerNonXS("lower");     // Catch: Throwable -> L84
        registerNonXS("print");     // Catch: Throwable -> L84
        registerNonXS("punct");     // Catch: Throwable -> L84
        registerNonXS("space");     // Catch: Throwable -> L84
        registerNonXS("upper");     // Catch: Throwable -> L84
        registerNonXS("word");     // Catch: Throwable -> L84
        registerNonXS("xdigit");     // Catch: Throwable -> L84
        monitor-exit(r1);     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        throw th;
    L87:
        if (r17 == false) goto L89;
        Hashtable r29 = categories;
    L91:
        return (RangeToken) ZeusTransformUtils.preCheckCast(r29.get(r16), RangeToken.class, "com.obric.memorydata.plugin");
    L89:
        r29 = categories2;
        goto L91
    }

    public static RangeToken getRange(String r0, boolean r1, boolean r2) {
        RangeToken r3 = getRange(r0, r1);
        if (r2 == false) goto L9;
        if (r3 != null) goto L6;
        return r3;
    L6:
        if (isRegisterNonXS(r0) == false) goto L11;
        return null;
    L11:
        return r3;
    L9:
        return r3;
    }

    public static boolean isRegisterNonXS(String r1) {
        Hashtable r0 = nonxs;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.containsKey(r1);
    }

    private static final boolean isSet(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isShorterThan(Token r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.type != 10) goto L16;
        int r4 = getString().length();
        if (r5.type != 10) goto L14;
        if (r4 >= r5.getString().length()) goto L17;
        return true;
    L17:
        return false;
    L14:
        throw new RuntimeException("Internal Error: Illegal type: " + r5.type);
    L16:
        throw new RuntimeException("Internal Error: Illegal type: " + this.type);
    }

    public static void registerNonXS(String r1) {
        if (nonxs != null) goto L5;
        nonxs = new Hashtable();
    L5:
        nonxs.put(r1, r1);
    }

    private static void setAlias(String r5, String r6, boolean r7) {
        Hashtable r1 = categories;
        Token r2 = (Token) ZeusTransformUtils.preCheckCast(r1.get(r6), Token.class, "com.obric.memorydata.plugin");
        Hashtable r4 = categories2;
        Token r8 = (Token) ZeusTransformUtils.preCheckCast(r4.get(r6), Token.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L5;
        r1.put(r5, r2);
        r4.put(r5, r8);
        return;
    L5:
        r4.put(r5, r2);
        r1.put(r5, r8);
    }

    void addChild(Token r1) {
        throw new RuntimeException("Not supported.");
    }

    public void addRange(int r1, int r2) {
        throw new RuntimeException("Not supported.");
    }

    final int analyzeFirstCharacter(RangeToken r8, int r9) {
        int r0 = this.type;
        int r5 = 0;
        switch(r0) {
            case 0: goto L77;
            case 1: goto L69;
            case 2: goto L54;
            case 3: goto L51;
            case 4: goto L47;
            case 5: goto L42;
            case 6: goto L21;
            case 7: goto L40;
            case 8: goto L40;
            case 9: goto L51;
            case 10: goto L27;
            case 11: goto L25;
            case 12: goto L23;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 20: goto L22;
            case 21: goto L22;
            case 22: goto L22;
            case 23: goto L22;
            case 24: goto L21;
            case 25: goto L19;
            case 26: goto L7;
            default: goto L6;
        };
    L7:
        int r1 = getChild(0).analyzeFirstCharacter(r8, r9);
        if (size() != 1) goto L10;
        return 0;
    L10:
        if (r1 != 2) goto L12;
        return r1;
    L12:
        int r7 = getChild(1).analyzeFirstCharacter(r8, r9);
        if (r7 != 2) goto L15;
        return r7;
    L15:
        if (r1 == 0) goto L18;
        if (r7 == 0) goto L18;
        return 1;
    L18:
        return 0;
    L19:
        r9 = (r9 | ((ModifierToken) ZeusTransformUtils.preCheckCast(this, ModifierToken.class, "com.obric.memorydata.plugin")).getOptions()) & (~((ModifierToken) ZeusTransformUtils.preCheckCast(this, ModifierToken.class, "com.obric.memorydata.plugin")).getOptionsMask());
        goto L21
    L22:
        return 0;
    L6:
        throw new RuntimeException("Token#analyzeHeadCharacter(): Invalid Type: " + this.type);
    L23:
        r8.addRange(0, UTF16_MAX);
        return 2;
    L25:
        isSet(r9, 4);
        return 0;
    L27:
        int r2 = getString().charAt(0);
        if (REUtil.isHighSurrogate(r2) == true) goto L30;
    L34:
        r8.addRange(r2, r2);
        if (r2 < 65536) goto L37;
    L39:
        return 1;
    L37:
        if (isSet(r9, 2) == false) goto L39;
        char r10 = Character.toUpperCase((char) r2);
        r8.addRange(r10, r10);
        char r11 = Character.toLowerCase(r10);
        r8.addRange(r11, r11);
        goto L39
    L30:
        if (getString().length() < 2) goto L34;
        char r12 = getString().charAt(1);
        if (REUtil.isLowSurrogate(r12) == false) goto L34;
        r2 = REUtil.composeFromSurrogates(r2, r12);
        goto L34
    L40:
        return 0;
    L51:
        getChild(0).analyzeFirstCharacter(r8, r9);
        return 0;
    L69:
        int r3 = 0;
    L71:
        if (r5 >= size()) goto L76;
        r3 = getChild(r5).analyzeFirstCharacter(r8, r9);
        if (r3 != 0) goto L76;
        r5 = r5 + 1;
    L76:
        return r3;
    L77:
        int r13 = getChar();
        r8.addRange(r13, r13);
        if (r13 < 65536) goto L80;
    L82:
        return 1;
    L80:
        if (isSet(r9, 2) == false) goto L82;
        char r14 = Character.toUpperCase((char) r13);
        r8.addRange(r14, r14);
        char r15 = Character.toLowerCase(r14);
        r8.addRange(r15, r15);
    L21:
        return getChild(0).analyzeFirstCharacter(r8, r9);
    L42:
        if (isSet(r9, 2) == false) goto L44;
        Token this = ((RangeToken) ZeusTransformUtils.preCheckCast(this, RangeToken.class, "com.obric.memorydata.plugin")).getCaseInsensitiveToken();
    L44:
        r8.mergeRanges(complementRanges(this));
        return 1;
    L47:
        if (isSet(r9, 2) == false) goto L49;
        this = ((RangeToken) ZeusTransformUtils.preCheckCast(this, RangeToken.class, "com.obric.memorydata.plugin")).getCaseInsensitiveToken();
    L49:
        r8.mergeRanges(this);
        return 1;
    L54:
        if (size() != 0) goto L56;
        return 0;
    L56:
        int r4 = 0;
        int r6 = 0;
        boolean r16 = false;
    L58:
        if (r4 >= size()) goto L65;
        r6 = getChild(r4).analyzeFirstCharacter(r8, r9);
        if (r6 == 2) goto L65;
        if (r6 != 0) goto L64;
        r16 = true;
    L64:
        r4 = r4 + 1;
    L65:
        if (r16 == false) goto L68;
        return 0;
    L68:
        return r6;
    }

    public void compactRanges() {
        throw new RuntimeException("Not supported.");
    }

    final void findFixedString(FixedStringContainer r6, int r7) {
        int r0 = this.type;
        Token r1 = null;
        int r2 = 0;
        switch(r0) {
            case 0: goto L26;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L9;
            case 11: goto L13;
            case 12: goto L13;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 20: goto L13;
            case 21: goto L13;
            case 22: goto L13;
            case 23: goto L13;
            case 24: goto L11;
            case 25: goto L7;
            case 26: goto L13;
            default: goto L6;
        };
    L7:
        getChild(0).findFixedString(r6, (r7 | ((ModifierToken) ZeusTransformUtils.preCheckCast(this, ModifierToken.class, "com.obric.memorydata.plugin")).getOptions()) & (~((ModifierToken) ZeusTransformUtils.preCheckCast(this, ModifierToken.class, "com.obric.memorydata.plugin")).getOptionsMask()));
        return;
    L6:
        throw new RuntimeException("Token#findFixedString(): Invalid Type: " + this.type);
    L9:
        r6.token = this;
        r6.options = r7;
        return;
    L11:
        getChild(0).findFixedString(r6, r7);
        return;
    L13:
        r6.token = null;
        return;
    L15:
        int r3 = 0;
    L17:
        if (r2 >= size()) goto L24;
        getChild(r2).findFixedString(r6, r7);
        if (r1 != null) goto L21;
    L22:
        r1 = r6.token;
        r3 = r6.options;
    L23:
        r2 = r2 + 1;
        goto L17
    L21:
        if (r1.isShorterThan(r6.token) == false) goto L23;
    L24:
        r6.token = r1;
        r6.options = r3;
        return;
    L26:
        r6.token = null;
    }

    int getChar() {
        return -1;
    }

    Token getChild(int r1) {
        return null;
    }

    int getMax() {
        return -1;
    }

    final int getMaxLength() {
        int r0 = this.type;
        int r2 = 1;
        int r3 = 0;
        switch(r0) {
            case 0: goto L44;
            case 1: goto L36;
            case 2: goto L22;
            case 3: goto L17;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L11;
            case 9: goto L17;
            case 10: goto L10;
            case 11: goto L14;
            case 12: goto L8;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 20: goto L7;
            case 21: goto L7;
            case 22: goto L7;
            case 23: goto L7;
            case 24: goto L13;
            case 25: goto L13;
            case 26: goto L22;
            default: goto L6;
        };
    L7:
        return 0;
    L6:
        throw new RuntimeException("Token#getMaxLength(): Invalid Type: " + this.type);
    L8:
        return -1;
    L11:
        return 0;
    L14:
        return 2;
    L36:
        int r1 = 0;
    L38:
        if (r3 >= size()) goto L43;
        int r4 = getChild(r3).getMaxLength();
        if (r4 < 0) goto L41;
        r1 = r1 + r4;
        r3 = r3 + 1;
        goto L38
    L41:
        return -1;
    L43:
        return r1;
    L44:
        return 1;
    L10:
        return getString().length();
    L13:
        return getChild(0).getMaxLength();
    L17:
        if (getMax() >= 0) goto L19;
        return -1;
    L19:
        return getMax() * getChild(0).getMaxLength();
    L22:
        if (size() != 0) goto L24;
        return 0;
    L24:
        int r5 = getChild(0).getMaxLength();
    L25:
        if (r5 < 0) goto L35;
        if (r2 >= size()) goto L35;
        int r6 = getChild(r2).getMaxLength();
        if (r6 < 0) goto L52;
        if (r6 <= r5) goto L33;
        r5 = r6;
    L33:
        r2 = r2 + 1;
        goto L25
    L52:
        return -1;
    L35:
        return r5;
    }

    int getMin() {
        return -1;
    }

    final int getMinLength() {
        int r0 = this.type;
        int r1 = 1;
        int r2 = 0;
        switch(r0) {
            case 0: goto L34;
            case 1: goto L29;
            case 2: goto L19;
            case 3: goto L14;
            case 4: goto L34;
            case 5: goto L34;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L10;
            case 9: goto L14;
            case 10: goto L9;
            case 11: goto L34;
            case 12: goto L7;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 20: goto L7;
            case 21: goto L7;
            case 22: goto L7;
            case 23: goto L7;
            case 24: goto L12;
            case 25: goto L12;
            case 26: goto L19;
            default: goto L6;
        };
    L6:
        throw new RuntimeException("Token#getMinLength(): Invalid Type: " + this.type);
    L7:
        return 0;
    L10:
        return 0;
    L29:
        int r3 = 0;
    L31:
        if (r2 >= size()) goto L33;
        r3 = r3 + getChild(r2).getMinLength();
        r2 = r2 + 1;
        goto L31
    L33:
        return r3;
    L34:
        return 1;
    L9:
        return getString().length();
    L12:
        return getChild(0).getMinLength();
    L14:
        if (getMin() >= 0) goto L16;
        return 0;
    L16:
        return getMin() * getChild(0).getMinLength();
    L19:
        if (size() != 0) goto L21;
        return 0;
    L21:
        int r4 = getChild(0).getMinLength();
    L23:
        if (r1 >= size()) goto L28;
        int r5 = getChild(r1).getMinLength();
        if (r5 >= r4) goto L27;
        r4 = r5;
    L27:
        r1 = r1 + 1;
        goto L23
    L28:
        return r4;
    }

    int getParenNumber() {
        return 0;
    }

    int getReferenceNumber() {
        return 0;
    }

    String getString() {
        return null;
    }

    public void intersectRanges(Token r1) {
        throw new RuntimeException("Not supported.");
    }

    boolean match(int r3) {
        throw new RuntimeException("NFAArrow#match(): Internal error: " + this.type);
    }

    public void mergeRanges(Token r1) {
        throw new RuntimeException("Not supported.");
    }

    void setMax(int r1) {
    }

    void setMin(int r1) {
    }

    int size() {
        return 0;
    }

    public void sortRanges() {
        throw new RuntimeException("Not supported.");
    }

    public void subtractRanges(Token r1) {
        throw new RuntimeException("Not supported.");
    }

    public String toString() {
        return toString(0);
    }

    public String toString(int r1) {
        if (this.type != 11) goto L5;
        return ".";
    L5:
        return "";
    }
}
