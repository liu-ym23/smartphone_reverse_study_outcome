package org.apache.xmlbeans.impl.regex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.CharacterIterator;
import java.util.Locale;
import java.util.Stack;

/* JADX INFO: loaded from: classes7.dex */
public class RegularExpression implements Serializable {
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
    private static final long serialVersionUID = 6242499334195006401L;
    transient Context context;
    transient RangeToken firstChar;
    transient String fixedString;
    transient boolean fixedStringOnly;
    transient int fixedStringOptions;
    transient BMPattern fixedStringTable;
    boolean hasBackReferences;
    transient int minlength;
    int nofparen;
    transient int numberOfClosures;
    transient Op operations;
    int options;
    String regex;
    Token tokentree;

    static final class CharArrayTarget extends ExpressionTarget {
        char[] target;

        CharArrayTarget(char[] r1) {
            this.target = r1;
        }

        private boolean regionMatches(int r3, int r4, int r5, int r6) {
        L2:
            int r7 = r6 - 1;
            if (r6 <= 0) goto L9;
            char[] r8 = this.target;
            int r0 = r3 + 1;
            int r1 = r5 + 1;
            if (r8[r3] != r8[r5]) goto L6;
            r6 = r7;
            r3 = r0;
            r5 = r1;
            goto L2
        L6:
            return false;
        L9:
            return true;
        }

        private boolean regionMatches(int r4, int r5, String r6, int r7) {
            int r0 = 0;
        L3:
            int r1 = r7 - 1;
            if (r7 <= 0) goto L9;
            int r2 = r4 + 1;
            int r8 = r0 + 1;
            if (this.target[r4] != r6.charAt(r0)) goto L7;
            r0 = r8;
            r7 = r1;
            r4 = r2;
            goto L3
        L7:
            return false;
        L9:
            return true;
        }

        private boolean regionMatchesIgnoreCase(int r3, int r4, int r5, int r6) {
        L2:
            int r7 = r6 - 1;
            if (r6 <= 0) goto L15;
            char[] r8 = this.target;
            int r0 = r3 + 1;
            char r9 = r8[r3];
            int r1 = r5 + 1;
            char r10 = r8[r5];
            if (r9 == r10) goto L14;
            char r11 = Character.toUpperCase(r9);
            char r12 = Character.toUpperCase(r10);
            if (r11 == r12) goto L14;
            if (Character.toLowerCase(r11) == Character.toLowerCase(r12)) goto L14;
            return false;
        L14:
            r6 = r7;
            r3 = r0;
            r5 = r1;
            goto L2
        L15:
            return true;
        }

        private boolean regionMatchesIgnoreCase(int r4, int r5, String r6, int r7) {
            int r0 = 0;
        L3:
            int r1 = r7 - 1;
            if (r7 <= 0) goto L15;
            int r2 = r4 + 1;
            char r8 = this.target[r4];
            int r9 = r0 + 1;
            char r3 = r6.charAt(r0);
            if (r8 == r3) goto L14;
            char r10 = Character.toUpperCase(r8);
            char r11 = Character.toUpperCase(r3);
            if (r10 == r11) goto L14;
            if (Character.toLowerCase(r10) == Character.toLowerCase(r11)) goto L14;
            return false;
        L14:
            r0 = r9;
            r7 = r1;
            r4 = r2;
            goto L3
        L15:
            return true;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        char charAt(int r1) {
            return this.target[r1];
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean r2, int r3, int r4, int r5, int r6) {
            if (r3 >= 0) goto L4;
            return false;
        L4:
            if ((r4 - r3) < r6) goto L13;
            if (r2 == false) goto L9;
            return regionMatchesIgnoreCase(r3, r4, r5, r6);
        L9:
            return regionMatches(r3, r4, r5, r6);
        L13:
            return false;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean r2, int r3, int r4, String r5, int r6) {
            if (r3 >= 0) goto L4;
            return false;
        L4:
            if ((r4 - r3) < r6) goto L13;
            if (r2 == false) goto L9;
            return regionMatchesIgnoreCase(r3, r4, r5, r6);
        L9:
            return regionMatches(r3, r4, r5, r6);
        L13:
            return false;
        }

        void resetTarget(char[] r1) {
            this.target = r1;
        }
    }

    static final class CharacterIteratorTarget extends ExpressionTarget {
        CharacterIterator target;

        CharacterIteratorTarget(CharacterIterator r3) {
            this.target = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r3, CharacterIterator.class, "com.obric.memorydata.plugin");
        }

        private boolean regionMatches(int r3, int r4, int r5, int r6) {
        L2:
            int r7 = r6 - 1;
            if (r6 <= 0) goto L9;
            int r0 = r3 + 1;
            int r1 = r5 + 1;
            if (this.target.setIndex(r3) != this.target.setIndex(r5)) goto L6;
            r6 = r7;
            r3 = r0;
            r5 = r1;
            goto L2
        L6:
            return false;
        L9:
            return true;
        }

        private boolean regionMatches(int r4, int r5, String r6, int r7) {
            int r0 = 0;
        L3:
            int r1 = r7 - 1;
            if (r7 <= 0) goto L9;
            int r2 = r4 + 1;
            int r8 = r0 + 1;
            if (this.target.setIndex(r4) != r6.charAt(r0)) goto L7;
            r0 = r8;
            r7 = r1;
            r4 = r2;
            goto L3
        L7:
            return false;
        L9:
            return true;
        }

        private boolean regionMatchesIgnoreCase(int r3, int r4, int r5, int r6) {
        L2:
            int r7 = r6 - 1;
            if (r6 <= 0) goto L15;
            int r0 = r3 + 1;
            char r8 = this.target.setIndex(r3);
            int r1 = r5 + 1;
            char r9 = this.target.setIndex(r5);
            if (r8 == r9) goto L14;
            char r10 = Character.toUpperCase(r8);
            char r11 = Character.toUpperCase(r9);
            if (r10 == r11) goto L14;
            if (Character.toLowerCase(r10) == Character.toLowerCase(r11)) goto L14;
            return false;
        L14:
            r6 = r7;
            r3 = r0;
            r5 = r1;
            goto L2
        L15:
            return true;
        }

        private boolean regionMatchesIgnoreCase(int r4, int r5, String r6, int r7) {
            int r0 = 0;
        L3:
            int r1 = r7 - 1;
            if (r7 <= 0) goto L15;
            int r2 = r4 + 1;
            char r8 = this.target.setIndex(r4);
            int r9 = r0 + 1;
            char r3 = r6.charAt(r0);
            if (r8 == r3) goto L14;
            char r10 = Character.toUpperCase(r8);
            char r11 = Character.toUpperCase(r3);
            if (r10 == r11) goto L14;
            if (Character.toLowerCase(r10) == Character.toLowerCase(r11)) goto L14;
            return false;
        L14:
            r0 = r9;
            r7 = r1;
            r4 = r2;
            goto L3
        L15:
            return true;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        char charAt(int r1) {
            return this.target.setIndex(r1);
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean r2, int r3, int r4, int r5, int r6) {
            if (r3 >= 0) goto L4;
            return false;
        L4:
            if ((r4 - r3) < r6) goto L13;
            if (r2 == false) goto L9;
            return regionMatchesIgnoreCase(r3, r4, r5, r6);
        L9:
            return regionMatches(r3, r4, r5, r6);
        L13:
            return false;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean r2, int r3, int r4, String r5, int r6) {
            if (r3 >= 0) goto L4;
            return false;
        L4:
            if ((r4 - r3) < r6) goto L13;
            if (r2 == false) goto L9;
            return regionMatchesIgnoreCase(r3, r4, r5, r6);
        L9:
            return regionMatches(r3, r4, r5, r6);
        L13:
            return false;
        }

        void resetTarget(CharacterIterator r3) {
            this.target = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r3, CharacterIterator.class, "com.obric.memorydata.plugin");
        }
    }

    static final class ClosureContext {
        int currentIndex;
        int[] offsets;

        ClosureContext() {
            this.offsets = new int[4];
            this.currentIndex = 0;
        }

        private int[] expandOffsets() {
            int[] r0 = this.offsets;
            int[] r1 = new int[r0.length << 1];
            System.arraycopy(r0, 0, r1, 0, this.currentIndex);
            return r1;
        }

        void addOffset(int r4) {
            if (this.currentIndex != this.offsets.length) goto L5;
            this.offsets = expandOffsets();
        L5:
            int[] r0 = this.offsets;
            int r1 = this.currentIndex;
            this.currentIndex = r1 + 1;
            r0[r1] = r4;
        }

        boolean contains(int r4) {
            int r1 = 0;
        L4:
            if (r1 >= this.currentIndex) goto L10;
            if (this.offsets[r1] == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        void reset() {
            this.currentIndex = 0;
        }
    }

    static final class Context {
        private CharArrayTarget charArrayTarget;
        private CharacterIteratorTarget characterIteratorTarget;
        ClosureContext[] closureContexts;
        boolean inuse;
        int length;
        int limit;
        Match match;
        int start;
        private StringTarget stringTarget;
        ExpressionTarget target;

        Context() {
            this.inuse = false;
        }

        private void resetCommon(int r4) {
            this.length = this.limit - this.start;
            setInUse(true);
            this.match = null;
            ClosureContext[] r0 = this.closureContexts;
            if (r0 != null) goto L5;
        L6:
            this.closureContexts = new ClosureContext[r4];
        L7:
            int r1 = 0;
        L8:
            if (r1 >= r4) goto L14;
            ClosureContext[] r2 = this.closureContexts;
            if (r2[r1] != null) goto L12;
            r2[r1] = new ClosureContext();
        L13:
            r1 = r1 + 1;
            goto L8
        L12:
            r2[r1].reset();
            goto L13
        L14:
            return;
        L5:
            if (r0.length == r4) goto L7;
            goto L6
        }

        void reset(String r2, int r3, int r4, int r5) {
            StringTarget r0 = this.stringTarget;
            if (r0 != null) goto L5;
            this.stringTarget = new StringTarget(r2);
        L6:
            this.target = this.stringTarget;
            this.start = r3;
            this.limit = r4;
            resetCommon(r5);
            return;
        L5:
            r0.resetTarget(r2);
            goto L6
        }

        void reset(CharacterIterator r3, int r4, int r5, int r6) {
            CharacterIterator r7 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r3, CharacterIterator.class, "com.obric.memorydata.plugin");
            CharacterIteratorTarget r0 = this.characterIteratorTarget;
            if (r0 != null) goto L5;
            this.characterIteratorTarget = new CharacterIteratorTarget(r7);
        L6:
            this.target = this.characterIteratorTarget;
            this.start = r4;
            this.limit = r5;
            resetCommon(r6);
            return;
        L5:
            r0.resetTarget(r7);
            goto L6
        }

        void reset(char[] r2, int r3, int r4, int r5) {
            CharArrayTarget r0 = this.charArrayTarget;
            if (r0 != null) goto L5;
            this.charArrayTarget = new CharArrayTarget(r2);
        L6:
            this.target = this.charArrayTarget;
            this.start = r3;
            this.limit = r4;
            resetCommon(r5);
            return;
        L5:
            r0.resetTarget(r2);
            goto L6
        }

        synchronized void setInUse(boolean r1) {
            monitor-enter(this);
            this.inuse = r1;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static abstract class ExpressionTarget {
        ExpressionTarget() {
        }

        abstract char charAt(int r1);

        abstract boolean regionMatches(boolean r1, int r2, int r3, int r4, int r5);

        abstract boolean regionMatches(boolean r1, int r2, int r3, String r4, int r5);
    }

    static final class StringTarget extends ExpressionTarget {
        private String target;

        StringTarget(String r1) {
            this.target = r1;
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        char charAt(int r1) {
            return this.target.charAt(r1);
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean r7, int r8, int r9, int r10, int r11) {
            if ((r9 - r8) >= r11) goto L6;
            return false;
        L6:
            if (r7 == false) goto L8;
            String r3 = this.target;
            return r3.regionMatches(true, r8, r3, r10, r11);
        L8:
            String r6 = this.target;
            return r6.regionMatches(r8, r6, r10, r11);
        }

        @Override // org.apache.xmlbeans.impl.regex.RegularExpression.ExpressionTarget
        boolean regionMatches(boolean r8, int r9, int r10, String r11, int r12) {
            if ((r10 - r9) >= r12) goto L5;
            return false;
        L5:
            if (r8 == false) goto L8;
            return this.target.regionMatches(true, r9, r11, 0, r12);
        L8:
            return this.target.regionMatches(r9, r11, 0, r12);
        }

        void resetTarget(String r1) {
            this.target = r1;
        }
    }

    public RegularExpression(String r2) {
        this(r2, null);
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

    public RegularExpression(String r3, String r4, Locale r5) {
        this.hasBackReferences = false;
        this.operations = null;
        this.context = null;
        this.firstChar = null;
        this.fixedString = null;
        this.fixedStringTable = null;
        this.fixedStringOnly = false;
        setPattern(r3, r4, r5);
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

    private Op compile(Token r10, Op r11, boolean r12) {
        int r0 = r10.type;
        int r2 = 0;
        switch(r0) {
            case 0: goto L77;
            case 1: goto L70;
            case 2: goto L65;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L38;
            case 6: goto L31;
            case 7: goto L88;
            case 8: goto L29;
            case 9: goto L39;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            default: goto L4;
        };
    L4:
        Op r4 = null;
        switch(r0) {
            case 20: goto L23;
            case 21: goto L22;
            case 22: goto L20;
            case 23: goto L19;
            case 24: goto L91;
            case 25: goto L90;
            case 26: goto L8;
            default: goto L7;
        };
    L8:
        Token.ConditionToken r13 = (Token.ConditionToken) ZeusTransformUtils.preCheckCast(r10, Token.ConditionToken.class, "com.obric.memorydata.plugin");
        int r1 = r13.refNumber;
        if (r13.condition != null) goto L11;
        Op r3 = null;
    L12:
        Op r5 = compile(r13.yes, r11, r12);
        if (r13.no == null) goto L89;
        r4 = compile(r13.no, r11, r12);
    L89:
        return Op.createCondition(r11, r1, r3, r5, r4);
    L11:
        r3 = compile(r13.condition, null, r12);
        goto L12
    L19:
        int r14 = 23;
    L21:
        Op r9 = compile(r10.getChild(0), null, true);
    L92:
        return Op.createLook(r14, r11, r9);
    L20:
        r14 = 22;
        goto L21
    L22:
        r14 = 21;
    L24:
        r9 = compile(r10.getChild(0), null, false);
        goto L92
    L23:
        r14 = 20;
        goto L24
    L7:
        throw new RuntimeException("Unknown token type: " + r10.type);
    L90:
        return Op.createModifier(r11, compile(r10.getChild(0), null, r12), ((Token.ModifierToken) ZeusTransformUtils.preCheckCast(r10, Token.ModifierToken.class, "com.obric.memorydata.plugin")).getOptions(), ((Token.ModifierToken) ZeusTransformUtils.preCheckCast(r10, Token.ModifierToken.class, "com.obric.memorydata.plugin")).getOptionsMask());
    L91:
        return Op.createIndependent(r11, compile(r10.getChild(0), null, r12));
    L26:
        Op r15 = Op.createBackReference(r10.getReferenceNumber());
    L78:
        r15.next = r11;
        return r15;
    L27:
        r15 = Op.createDot();
        goto L78
    L28:
        r15 = Op.createString(r10.getString());
        goto L78
    L29:
        r15 = Op.createAnchor(r10.getChar());
        goto L78
    L38:
        r15 = Op.createRange(r10);
        goto L78
    L39:
        Token r6 = r10.getChild(0);
        int r7 = r10.getMin();
        int r8 = r10.getMax();
        if (r7 < 0) goto L44;
        if (r7 != r8) goto L44;
    L42:
        if (r2 >= r7) goto L97;
        r11 = compile(r6, r11, r12);
        r2 = r2 + 1;
        goto L42
    L97:
        return r11;
    L44:
        if (r7 <= 0) goto L48;
        if (r8 <= 0) goto L48;
        r8 = r8 - r7;
    L48:
        if (r8 <= 0) goto L58;
        Op r16 = r11;
        int r17 = 0;
    L50:
        if (r17 >= r8) goto L56;
        if (r10.type != 9) goto L54;
        boolean r18 = true;
    L55:
        Op.ChildOp r19 = Op.createQuestion(r18);
        r19.next = r11;
        r19.setChild(compile(r6, r16, r12));
        r17 = r17 + 1;
        r16 = r19;
        goto L50
    L54:
        r18 = false;
        goto L55
    L56:
        Op r110 = r16;
    L62:
        if (r7 <= 0) goto L95;
    L63:
        if (r2 >= r7) goto L98;
        r110 = compile(r6, r110, r12);
        r2 = r2 + 1;
        goto L63
    L98:
        return r110;
    L95:
        return r110;
    L58:
        if (r10.type != 9) goto L60;
        Op.ChildOp r111 = Op.createNonGreedyClosure();
    L61:
        r111.next = r11;
        r111.setChild(compile(r6, r111, r12));
        r110 = r111;
        goto L62
    L60:
        int r112 = this.numberOfClosures;
        this.numberOfClosures = r112 + 1;
        r111 = Op.createClosure(r112);
        goto L61
    L65:
        Op.UnionOp r20 = Op.createUnion(r10.size());
    L67:
        if (r2 >= r10.size()) goto L96;
        r20.addElement(compile(r10.getChild(r2), r11, r12));
        r2 = r2 + 1;
        goto L67
    L96:
        return r20;
    L70:
        if (r12 == true) goto L75;
        int r113 = r10.size() - 1;
    L72:
        if (r113 < 0) goto L99;
        r11 = compile(r10.getChild(r113), r11, false);
        r113 = r113 - 1;
        goto L72
    L99:
        return r11;
    L75:
        if (r2 >= r10.size()) goto L100;
        r11 = compile(r10.getChild(r2), r11, true);
        r2 = r2 + 1;
        goto L75
    L100:
        return r11;
    L77:
        r15 = Op.createChar(r10.getChar());
        goto L78
    L88:
        return r11;
    L31:
        if (r10.getParenNumber() == 0) goto L93;
        int r21 = r10.getParenNumber();
        if (r12 == false) goto L36;
        Op r22 = compile(r10.getChild(0), Op.createCapture(r21, r11), r12);
        int r114 = -r10.getParenNumber();
    L94:
        return Op.createCapture(r114, r22);
    L36:
        r22 = compile(r10.getChild(0), Op.createCapture(-r21, r11), r12);
        r114 = r10.getParenNumber();
        goto L94
    L93:
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

    private static final int getPreviousWordType(ExpressionTarget r1, int r2, int r3, int r4, int r5) {
    L2:
        r4 = r4 - 1;
        int r0 = getWordType(r1, r2, r3, r4, r5);
        if (r0 == 0) goto L2;
        return r0;
    }

    private static final int getWordType(ExpressionTarget r0, int r1, int r2, int r3, int r4) {
        if (r3 < r1) goto L7;
        if (r3 < r2) goto L6;
        return 2;
    L6:
        return getWordType0(r0.charAt(r3), r4);
    L7:
        return 2;
    }

    private static int getWordType0(char r4, int r5) {
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

    private static boolean isEOLChar(int r1) {
        if (r1 != 10) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 13) goto L12;
        if (r1 == LINE_SEPARATOR) goto L12;
        if (r1 == PARAGRAPH_SEPARATOR) goto L12;
        return false;
    }

    private static boolean isSet(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isWordChar(int r3) {
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x01a5 -> B:182:0x0337). Please report as a decompilation issue!!! */
    private int match(Context r23, Op r24, int r25, int r26, int r27) {
        ExpressionTarget r8 = r23.target;
        Stack r9 = new Stack();
        IntStack r10 = new IntStack();
        boolean r11 = isSet(r27, 2);
        int r12 = 0;
        Op r13 = r24;
        int r14 = r25;
        int r15 = r26;
        int r5 = r27;
        boolean r16 = false;
    L3:
        String r3 = "com.obric.memorydata.plugin";
        int r17 = -1;
        if (r13 != null) goto L6;
    L171:
        boolean r21 = true;
        r3 = "com.obric.memorydata.plugin";
        int r2 = r5;
        if (r13 == null) goto L174;
    L179:
        r17 = -1;
    L180:
        r5 = r2;
    L181:
        r16 = r21;
    L182:
        if (r16 == false) goto L225;
        if (r9.isEmpty() == true) goto L185;
        r13 = (Op) ZeusTransformUtils.preCheckCast(r9.pop(), Op.class, r3);
        r14 = r10.pop();
        int r1 = r13.type;
        if (r1 != 15) goto L188;
        int r4 = r13.getData();
        int r6 = r10.pop();
        if (r23.match == null) goto L182;
        if (r17 >= 0) goto L182;
        Match r7 = r23.match;
        if (r4 > 0) goto L223;
        r7.setEnd(-r4, r6);
        goto L182
    L223:
        r7.setBeginning(r4, r6);
        goto L182
    L188:
        switch(r1) {
            case 7: goto L216;
            case 8: goto L214;
            case 9: goto L216;
            case 10: goto L214;
            case 11: goto L208;
            default: goto L189;
        };
    L208:
        int r18 = r10.pop();
        if (r17 >= 0) goto L182;
        int r19 = r18 + 1;
        if (r19 >= r13.size()) goto L76;
        r9.push(r13);
        r10.push(r19);
        r10.push(r14);
        Op r20 = r13.elementAt(r19);
    L213:
        r13 = r20;
    L201:
        r16 = false;
    L76:
        r17 = -1;
        goto L182
    L214:
        if (r17 >= 0) goto L182;
        r13 = r13.getChild();
        goto L201
    L216:
        if (r17 >= 0) goto L182;
        r13 = r13.next;
        goto L201
    L189:
        switch(r1) {
            case 20: goto L205;
            case 21: goto L202;
            case 22: goto L205;
            case 23: goto L202;
            case 24: goto L199;
            case 25: goto L198;
            case 26: goto L191;
            default: goto L182;
        };
    L191:
        Op.ConditionOp r22 = (Op.ConditionOp) ZeusTransformUtils.preCheckCast(r13, Op.ConditionOp.class, r3);
        if (r17 < 0) goto L195;
        r20 = r22.yes;
        goto L213
    L195:
        if (r22.no == null) goto L197;
        r20 = r22.no;
        goto L213
    L197:
        r20 = r22.next;
        goto L213
    L198:
        r5 = r10.pop();
    L199:
        if (r17 < 0) goto L182;
        r13 = r13.next;
        r14 = r17;
        goto L201
    L202:
        r15 = r10.pop();
        if (r17 >= 0) goto L76;
    L204:
        r13 = r13.next;
        r16 = false;
        goto L76
    L205:
        r15 = r10.pop();
        if (r17 < 0) goto L76;
    L185:
        return r17;
    L225:
        r12 = 0;
        goto L3
    L174:
        if (isSet(r2, 512) == true) goto L176;
    L178:
        r17 = r14;
        goto L180
    L176:
        if (r14 == r23.limit) goto L178;
    L6:
        if (r14 > r23.limit) goto L171;
        if (r14 < r23.start) goto L171;
        int r0 = r13.type;
        if (r0 == 0) goto L139;
        if (r0 == 1) goto L128;
        if (r0 != 15) goto L15;
        r3 = "com.obric.memorydata.plugin";
        int r28 = r5;
        int r29 = r13.getData();
        if (r23.match != null) goto L124;
    L75:
        r5 = r28;
        r13 = r13.next;
        goto L76
    L124:
        if (r29 <= 0) goto L126;
        r10.push(r23.match.getBeginning(r29));
        r23.match.setBeginning(r29, r14);
    L127:
        r9.push(r13);
        r10.push(r14);
        goto L75
    L126:
        int r30 = -r29;
        r10.push(r23.match.getEnd(r30));
        r23.match.setEnd(r30, r14);
        goto L127
    L15:
        if (r0 == 16) goto L97;
        switch(r0) {
            case 3: goto L77;
            case 4: goto L77;
            case 5: goto L71;
            case 6: goto L61;
            case 7: goto L53;
            case 8: goto L52;
            case 9: goto L57;
            case 10: goto L52;
            case 11: goto L49;
            default: goto L17;
        };
    L17:
        switch(r0) {
            case 20: goto L40;
            case 21: goto L40;
            case 22: goto L40;
            case 23: goto L40;
            case 24: goto L57;
            case 25: goto L38;
            case 26: goto L20;
            default: goto L19;
        };
    L20:
        Op.ConditionOp r31 = (Op.ConditionOp) ZeusTransformUtils.preCheckCast(r13, Op.ConditionOp.class, "com.obric.memorydata.plugin");
        if (r31.refNumber > 0) goto L23;
        r9.push(r13);
        r10.push(r14);
        Op r32 = r31.condition;
    L58:
        r13 = r32;
        goto L182
    L23:
        if (r31.refNumber >= this.nofparen) goto L36;
        if (r23.match == null) goto L32;
        if (r23.match.getBeginning(r31.refNumber) < 0) goto L32;
        if (r23.match.getEnd(r31.refNumber) < 0) goto L32;
        r32 = r31.yes;
    L32:
        if (r31.no == null) goto L34;
        r32 = r31.no;
        goto L58
    L34:
        r32 = r31.next;
        goto L58
    L36:
        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + r31.refNumber);
    L38:
        int r33 = (r13.getData() | r5) & (~r13.getData2());
        r9.push(r13);
        r10.push(r5);
        r10.push(r14);
        Op r34 = r13.getChild();
        r5 = r33;
    L39:
        r13 = r34;
        goto L182
    L40:
        r9.push(r13);
        r10.push(r15);
        r10.push(r14);
        if (r13.type != 20) goto L43;
    L46:
        int r35 = 1;
    L47:
        r34 = r13.getChild();
        r15 = r35;
        goto L39
    L43:
        if (r13.type == 21) goto L46;
        r35 = -1;
        goto L47
    L19:
        throw new RuntimeException("Unknown operation type: " + r13.type);
    L52:
        r9.push(r13);
        r10.push(r14);
        r32 = r13.next;
        goto L58
    L53:
        int r36 = r13.getData();
        if (r23.closureContexts[r36].contains(r14) == false) goto L56;
    L55:
        r16 = true;
        goto L182
    L56:
        r23.closureContexts[r36].addOffset(r14);
    L57:
        r9.push(r13);
        r10.push(r14);
        r32 = r13.getChild();
        goto L58
    L61:
        String r110 = r13.getString();
        int r111 = r110.length();
        if (r15 <= 0) goto L67;
        r21 = true;
        r3 = "com.obric.memorydata.plugin";
        r28 = r5;
        if (r8.regionMatches(r11, r14, r23.limit, r110, r111) == false) goto L73;
        r14 = r14 + r111;
    L73:
        r5 = r28;
    L74:
        r17 = -1;
        goto L181
    L67:
        r3 = "com.obric.memorydata.plugin";
        r28 = r5;
        r21 = true;
        int r210 = r14 - r111;
        if (r8.regionMatches(r11, r210, r23.limit, r110, r111) == false) goto L73;
        r14 = r210;
        goto L75
    L71:
        r3 = "com.obric.memorydata.plugin";
        r28 = r5;
        r21 = true;
        if (matchAnchor(r8, r13, r23, r14, r5) == true) goto L75;
    L77:
        r3 = "com.obric.memorydata.plugin";
        r28 = r5;
        r21 = true;
        if (r15 <= 0) goto L80;
        int r37 = r14;
    L82:
        if (r37 >= r23.limit) goto L73;
        if (r37 < 0) goto L73;
        int r38 = r8.charAt(r14);
        if (REUtil.isHighSurrogate(r38) == false) goto L92;
        int r39 = r37 + r15;
        if (r39 >= r23.limit) goto L92;
        if (r39 < 0) goto L92;
        r38 = REUtil.composeFromSurrogates(r38, r8.charAt(r39));
        r37 = r39;
    L92:
        if (r13.getToken().match(r38) == false) goto L73;
        if (r15 <= 0) goto L96;
        r37 = r37 + 1;
    L96:
        r5 = r28;
        r14 = r37;
        r13 = r13.next;
        goto L76
    L80:
        r37 = r14 - 1;
        goto L82
    L49:
        if (r13.size() == 0) goto L55;
        r9.push(r13);
        r10.push(r12);
        r10.push(r14);
        r32 = r13.elementAt(r12);
        goto L58
    L97:
        r3 = "com.obric.memorydata.plugin";
        r28 = r5;
        r21 = true;
        int r40 = r13.getData();
        if (r40 <= 0) goto L121;
        if (r40 >= this.nofparen) goto L121;
        if (r23.match != null) goto L104;
    L119:
        r5 = r28;
        goto L76
    L104:
        if (r23.match.getBeginning(r40) < 0) goto L73;
        if (r23.match.getEnd(r40) < 0) goto L73;
        int r41 = r23.match.getBeginning(r40);
        int r112 = r23.match.getEnd(r40) - r41;
        if (r15 > 0) goto L111;
        int r113 = r14 - r112;
        if (r8.regionMatches(r11, r113, r23.limit, r41, r112) == false) goto L73;
        r14 = r113;
    L118:
        r13 = r13.next;
        goto L119
    L111:
        if (r8.regionMatches(r11, r14, r23.limit, r41, r112) == false) goto L73;
        r14 = r14 + r112;
    L121:
        throw new RuntimeException("Internal Error: Reference number must be more than zero: " + r40);
    L128:
        r21 = true;
        r3 = "com.obric.memorydata.plugin";
        r28 = r5;
        if (r15 <= 0) goto L131;
        int r42 = r14;
    L133:
        if (r42 >= r23.limit) goto L73;
        if (r42 < 0) goto L73;
        if (matchChar(r13.getData(), r8.charAt(r42), r11) == false) goto L73;
        r14 = r14 + r15;
        goto L75
    L131:
        r42 = r14 - 1;
        goto L133
    L139:
        r21 = true;
        r3 = "com.obric.memorydata.plugin";
        int r211 = r5;
        if (r15 <= 0) goto L142;
        int r43 = r14;
    L144:
        if (r43 >= r23.limit) goto L169;
        if (r43 < 0) goto L169;
        int r44 = r211;
        if (isSet(r44, 4) == true) goto L150;
        int r45 = r8.charAt(r43);
        if (REUtil.isHighSurrogate(r45) == false) goto L164;
        int r46 = r43 + r15;
        if (r46 < 0) goto L164;
        if (r46 >= r23.limit) goto L164;
        r45 = REUtil.composeFromSurrogates(r45, r8.charAt(r46));
        r43 = r46;
    L164:
        if (isEOLChar(r45) == true) goto L170;
    L166:
        if (r15 <= 0) goto L168;
        r43 = r43 + 1;
    L168:
        r14 = r43;
        r13 = r13.next;
        r5 = r44;
    L170:
        r5 = r44;
        goto L74
    L150:
        if (REUtil.isHighSurrogate(r8.charAt(r43)) == false) goto L166;
        int r47 = r43 + r15;
        if (r47 < 0) goto L166;
        if (r47 >= r23.limit) goto L166;
        r43 = r47;
    L169:
        r44 = r211;
        goto L170
    L142:
        r43 = r14 - 1;
        goto L144
    }

    private boolean matchChar(int r1, int r2, boolean r3) {
        if (r3 == true) goto L8;
        if (r1 != r2) goto L6;
        return true;
    L6:
        return false;
    L8:
        return matchIgnoreCase(r1, r2);
    }

    private static boolean matchIgnoreCase(int r3, int r4) {
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

    private void setPattern(String r1, int r2, Locale r3) {
        this.regex = r1;
        this.options = r2;
        if (isSet(r2, 512) == false) goto L5;
        RegexParser r4 = new ParserForXMLSchema(r3);
    L6:
        this.tokentree = r4.parse(this.regex, this.options);
        this.nofparen = r4.parennumber;
        this.hasBackReferences = r4.hasBackReferences;
        this.operations = null;
        this.context = null;
        return;
    L5:
        r4 = new RegexParser(r3);
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
        return REUtil.createOptionString(this.options);
    }

    public String getPattern() {
        return this.regex;
    }

    public int hashCode() {
        return (this.regex + "/" + getOptions()).hashCode();
    }

    boolean matchAnchor(ExpressionTarget r7, Op r8, Context r9, int r10, int r11) {
        int r6 = r8.getData();
        if (r6 == 36) goto L99;
        if (r6 == 60) goto L89;
        if (r6 == 62) goto L79;
        if (r6 == 90) goto L66;
        if (r6 == 94) goto L52;
        if (r6 == 98) goto L43;
        if (r6 == 122) goto L40;
        switch(r6) {
            case 64: goto L33;
            case 65: goto L30;
            case 66: goto L19;
            default: goto L120;
        };
    L120:
        return true;
    L19:
        if (r9.length != 0) goto L21;
    L20:
        boolean r12 = true;
    L27:
        if (r12 == true) goto L120;
        return false;
    L21:
        int r13 = getWordType(r7, r9.start, r9.limit, r10, r11);
        if (r13 == 0) goto L20;
        if (r13 == getPreviousWordType(r7, r9.start, r9.limit, r10, r11)) goto L20;
        r12 = false;
        goto L27
    L30:
        if (r10 == r9.start) goto L120;
        return false;
    L33:
        if (r10 == r9.start) goto L120;
        if (r10 > r9.start) goto L37;
    L38:
        return false;
    L37:
        if (isEOLChar(r7.charAt(r10 - 1)) == true) goto L120;
    L40:
        if (r10 == r9.limit) goto L120;
        return false;
    L43:
        if (r9.length != 0) goto L45;
        return false;
    L45:
        int r14 = getWordType(r7, r9.start, r9.limit, r10, r11);
        if (r14 != 0) goto L49;
        return false;
    L49:
        if (r14 != getPreviousWordType(r7, r9.start, r9.limit, r10, r11)) goto L120;
        return false;
    L52:
        if (isSet(r11, 8) == false) goto L63;
        if (r10 == r9.start) goto L120;
        if (r10 > r9.start) goto L58;
    L61:
        return false;
    L58:
        if (r10 >= r9.limit) goto L61;
        if (isEOLChar(r7.charAt(r10 - 1)) == true) goto L120;
    L63:
        if (r10 == r9.start) goto L120;
        return false;
    L66:
        if (r10 == r9.limit) goto L120;
        int r15 = r10 + 1;
        if (r15 != r9.limit) goto L72;
        if (isEOLChar(r7.charAt(r10)) == true) goto L120;
    L72:
        if ((r10 + 2) == r9.limit) goto L74;
    L77:
        return false;
    L74:
        if (r7.charAt(r10) != '\r') goto L77;
        if (r7.charAt(r15) == '\n') goto L120;
    L79:
        if (r9.length != 0) goto L81;
    L87:
        return false;
    L81:
        if (r10 == r9.start) goto L87;
        if (getWordType(r7, r9.start, r9.limit, r10, r11) != 2) goto L87;
        if (getPreviousWordType(r7, r9.start, r9.limit, r10, r11) == 1) goto L120;
    L89:
        if (r9.length != 0) goto L91;
    L97:
        return false;
    L91:
        if (r10 == r9.limit) goto L97;
        if (getWordType(r7, r9.start, r9.limit, r10, r11) != 1) goto L97;
        if (getPreviousWordType(r7, r9.start, r9.limit, r10, r11) == 2) goto L120;
    L99:
        if (isSet(r11, 8) == false) goto L108;
        if (r10 == r9.limit) goto L120;
        if (r10 < r9.limit) goto L105;
    L106:
        return false;
    L105:
        if (isEOLChar(r7.charAt(r10)) == true) goto L120;
    L108:
        if (r10 == r9.limit) goto L120;
        int r16 = r10 + 1;
        if (r16 != r9.limit) goto L114;
        if (isEOLChar(r7.charAt(r10)) == true) goto L120;
    L114:
        if ((r10 + 2) == r9.limit) goto L116;
    L119:
        return false;
    L116:
        if (r7.charAt(r10) != '\r') goto L119;
        if (r7.charAt(r16) == '\n') goto L120;
        goto L119
    }

    public boolean matches(String r5) {
        return matches(r5, 0, r5.length(), (Match) ZeusTransformUtils.preCheckCast(null, Match.class, "com.obric.memorydata.plugin"));
    }

    public boolean matches(String r4, int r5, int r6) {
        return matches(r4, r5, r6, (Match) ZeusTransformUtils.preCheckCast(null, Match.class, "com.obric.memorydata.plugin"));
    }

    public boolean matches(String r11, int r12, int r13, Match r14) {
        monitor-enter(this);
    L105:
        th = move-exception;
        throw th;
    L4:
        if (this.operations != null) goto L7;
        prepare();     // Catch: Throwable -> L105
    L7:
        if (this.context != null) goto L9;
        this.context = new Context();     // Catch: Throwable -> L105
    L9:
        monitor-exit(this);     // Catch: Throwable -> L105
        Context r0 = this.context;
        monitor-enter(r0);
    L102:
        th = move-exception;
        throw th;
    L13:
        if (this.context.inuse == false) goto L15;
        Context r1 = new Context();     // Catch: Throwable -> L102
    L16:
        r1.reset(r11, r12, r13, this.numberOfClosures);     // Catch: Throwable -> L102
        monitor-exit(r0);     // Catch: Throwable -> L102
        if (r14 == null) goto L21;
        r14.setNumberOfGroups(this.nofparen);
        r14.setSource(r11);
    L23:
        r1.match = r14;
        if (isSet(this.options, 512) == false) goto L34;
        int r10 = match(r1, this.operations, r1.start, 1, this.options);
        if (r10 == r1.limit) goto L28;
        return false;
    L28:
        if (r1.match == null) goto L30;
        r1.match.setBeginning(0, r1.start);
        r1.match.setEnd(0, r10);
    L30:
        r1.setInUse(false);
        return true;
    L34:
        if (this.fixedStringOnly == false) goto L45;
        int r15 = this.fixedStringTable.matches(r11, r1.start, r1.limit);
        if (r15 >= 0) goto L38;
        r1.setInUse(false);
        return false;
    L38:
        if (r1.match == null) goto L40;
        r1.match.setBeginning(0, r15);
        r1.match.setEnd(0, r15 + this.fixedString.length());
    L40:
        r1.setInUse(false);
        return true;
    L45:
        if (this.fixedString != null) goto L47;
    L50:
        int r16 = r1.limit - this.minlength;
        int r2 = -1;
        Op r3 = this.operations;
        if (r3 != null) goto L53;
    L70:
        RangeToken r8 = this.firstChar;
        if (r8 == null) goto L87;
        int r4 = -1;
        int r5 = r1.start;
    L73:
        if (r5 > r16) goto L86;
        int r6 = r11.charAt(r5);
        if (REUtil.isHighSurrogate(r6) == false) goto L80;
        int r7 = r5 + 1;
        if (r7 >= r1.limit) goto L80;
        r6 = REUtil.composeFromSurrogates(r6, r11.charAt(r7));
    L80:
        if (r8.match(r6) == false) goto L85;
        r4 = match(r1, this.operations, r5, 1, this.options);
        if (r4 >= 0) goto L86;
    L85:
        r5 = r5 + 1;
    L86:
        int r17 = r4;
        int r18 = r5;
    L94:
        if (r17 >= 0) goto L96;
        r1.setInUse(false);
        return false;
    L96:
        if (r1.match == null) goto L98;
        r1.match.setBeginning(0, r18);
        r1.match.setEnd(0, r17);
    L98:
        r1.setInUse(false);
        return true;
    L87:
        r18 = r1.start;
    L88:
        if (r18 > r16) goto L93;
        r2 = match(r1, this.operations, r18, 1, this.options);
        if (r2 >= 0) goto L93;
        r18 = r18 + 1;
    L93:
        r17 = r2;
        goto L94
    L53:
        if (r3.type != 7) goto L70;
        if (this.operations.getChild().type != 0) goto L70;
        if (isSet(this.options, 4) == false) goto L59;
        r18 = r1.start;
        r17 = match(r1, this.operations, r1.start, 1, this.options);
        goto L94
    L59:
        boolean r9 = true;
        r4 = -1;
        r5 = r1.start;
    L60:
        if (r5 > r16) goto L86;
        if (isEOLChar(r11.charAt(r5)) == false) goto L64;
        r9 = true;
    L69:
        r5 = r5 + 1;
        goto L60
    L64:
        if (r9 == false) goto L68;
        r4 = match(r1, this.operations, r5, 1, this.options);
        if (r4 >= 0) goto L86;
    L68:
        r9 = false;
        goto L69
    L47:
        if (this.fixedStringTable.matches(r11, r1.start, r1.limit) >= 0) goto L50;
        r1.setInUse(false);
        return false;
    L21:
        if (this.hasBackReferences == false) goto L23;
        r14 = new Match();
        r14.setNumberOfGroups(this.nofparen);
        goto L23
    L15:
        r1 = this.context;     // Catch: Throwable -> L102
        goto L16
    }

    public boolean matches(String r3, Match r4) {
        return matches(r3, 0, r3.length(), r4);
    }

    public boolean matches(CharacterIterator r4) {
        return matches((CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r4, CharacterIterator.class, "com.obric.memorydata.plugin"), (Match) ZeusTransformUtils.preCheckCast(null, Match.class, "com.obric.memorydata.plugin"));
    }

    public boolean matches(CharacterIterator r13, Match r14) {
        CharacterIterator r15 = (CharacterIterator) ZeusTransformUtils.wrapperContextForParams(r13, CharacterIterator.class, "com.obric.memorydata.plugin");
        int r0 = r15.getBeginIndex();
        int r1 = r15.getEndIndex();
        monitor-enter(this);
    L106:
        th = move-exception;
        throw th;
    L5:
        if (this.operations != null) goto L8;
        prepare();     // Catch: Throwable -> L106
    L8:
        if (this.context != null) goto L10;
        this.context = new Context();     // Catch: Throwable -> L106
    L10:
        monitor-exit(this);     // Catch: Throwable -> L106
        Context r2 = this.context;
        monitor-enter(r2);
    L103:
        th = move-exception;
        throw th;
    L14:
        if (this.context.inuse == false) goto L16;
        Context r3 = new Context();     // Catch: Throwable -> L103
    L17:
        r3.reset(r15, r0, r1, this.numberOfClosures);     // Catch: Throwable -> L103
        monitor-exit(r2);     // Catch: Throwable -> L103
        if (r14 == null) goto L22;
        r14.setNumberOfGroups(this.nofparen);
        r14.setSource(r15);
    L24:
        r3.match = r14;
        if (isSet(this.options, 512) == false) goto L35;
        int r12 = match(r3, this.operations, r3.start, 1, this.options);
        if (r12 == r3.limit) goto L29;
        return false;
    L29:
        if (r3.match == null) goto L31;
        r3.match.setBeginning(0, r3.start);
        r3.match.setEnd(0, r12);
    L31:
        r3.setInUse(false);
        return true;
    L35:
        if (this.fixedStringOnly == false) goto L46;
        int r16 = this.fixedStringTable.matches(r15, r3.start, r3.limit);
        if (r16 >= 0) goto L39;
        r3.setInUse(false);
        return false;
    L39:
        if (r3.match == null) goto L41;
        r3.match.setBeginning(0, r16);
        r3.match.setEnd(0, r16 + this.fixedString.length());
    L41:
        r3.setInUse(false);
        return true;
    L46:
        if (this.fixedString != null) goto L48;
    L51:
        int r17 = r3.limit - this.minlength;
        int r4 = -1;
        Op r5 = this.operations;
        if (r5 != null) goto L54;
    L71:
        RangeToken r10 = this.firstChar;
        if (r10 == null) goto L88;
        int r6 = -1;
        int r7 = r3.start;
    L74:
        if (r7 > r17) goto L87;
        int r8 = r15.setIndex(r7);
        if (REUtil.isHighSurrogate(r8) == false) goto L81;
        int r9 = r7 + 1;
        if (r9 >= r3.limit) goto L81;
        r8 = REUtil.composeFromSurrogates(r8, r15.setIndex(r9));
    L81:
        if (r10.match(r8) == false) goto L86;
        r6 = match(r3, this.operations, r7, 1, this.options);
        if (r6 >= 0) goto L87;
    L86:
        r7 = r7 + 1;
    L87:
        int r18 = r6;
        int r19 = r7;
    L95:
        if (r18 >= 0) goto L97;
        r3.setInUse(false);
        return false;
    L97:
        if (r3.match == null) goto L99;
        r3.match.setBeginning(0, r19);
        r3.match.setEnd(0, r18);
    L99:
        r3.setInUse(false);
        return true;
    L88:
        r19 = r3.start;
    L89:
        if (r19 > r17) goto L94;
        r4 = match(r3, this.operations, r19, 1, this.options);
        if (r4 >= 0) goto L94;
        r19 = r19 + 1;
    L94:
        r18 = r4;
        goto L95
    L54:
        if (r5.type != 7) goto L71;
        if (this.operations.getChild().type != 0) goto L71;
        if (isSet(this.options, 4) == false) goto L60;
        r19 = r3.start;
        r18 = match(r3, this.operations, r3.start, 1, this.options);
        goto L95
    L60:
        boolean r11 = true;
        r6 = -1;
        r7 = r3.start;
    L61:
        if (r7 > r17) goto L87;
        if (isEOLChar(r15.setIndex(r7)) == false) goto L65;
        r11 = true;
    L70:
        r7 = r7 + 1;
        goto L61
    L65:
        if (r11 == false) goto L69;
        r6 = match(r3, this.operations, r7, 1, this.options);
        if (r6 >= 0) goto L87;
    L69:
        r11 = false;
        goto L70
    L48:
        if (this.fixedStringTable.matches(r15, r3.start, r3.limit) >= 0) goto L51;
        r3.setInUse(false);
        return false;
    L22:
        if (this.hasBackReferences == false) goto L24;
        r14 = new Match();
        r14.setNumberOfGroups(this.nofparen);
        goto L24
    L16:
        r3 = this.context;     // Catch: Throwable -> L103
        goto L17
    }

    public boolean matches(char[] r5) {
        return matches(r5, 0, r5.length, (Match) ZeusTransformUtils.preCheckCast(null, Match.class, "com.obric.memorydata.plugin"));
    }

    public boolean matches(char[] r4, int r5, int r6) {
        return matches(r4, r5, r6, (Match) ZeusTransformUtils.preCheckCast(null, Match.class, "com.obric.memorydata.plugin"));
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
    public boolean matches(char[] r11, int r12, int r13, Match r14) {
        monitor-enter(this);
    L105:
        th = move-exception;
        throw th;
    L4:
        if (this.operations != null) goto L7;
        prepare();     // Catch: Throwable -> L105
    L7:
        if (this.context != null) goto L9;
        this.context = new Context();     // Catch: Throwable -> L105
    L9:
        monitor-exit(this);     // Catch: Throwable -> L105
        Context r0 = this.context;
        monitor-enter(r0);
    L102:
        th = move-exception;
        throw th;
    L13:
        if (this.context.inuse == false) goto L15;
        Context r1 = new Context();     // Catch: Throwable -> L102
    L16:
        r1.reset(r11, r12, r13, this.numberOfClosures);     // Catch: Throwable -> L102
        monitor-exit(r0);     // Catch: Throwable -> L102
        if (r14 == null) goto L21;
        r14.setNumberOfGroups(this.nofparen);
        r14.setSource(r11);
    L23:
        r1.match = r14;
        if (isSet(this.options, 512) == false) goto L34;
        int r10 = match(r1, this.operations, r1.start, 1, this.options);
        if (r10 == r1.limit) goto L28;
        return false;
    L28:
        if (r1.match == null) goto L30;
        r1.match.setBeginning(0, r1.start);
        r1.match.setEnd(0, r10);
    L30:
        r1.setInUse(false);
        return true;
    L34:
        if (this.fixedStringOnly == false) goto L45;
        int r15 = this.fixedStringTable.matches(r11, r1.start, r1.limit);
        if (r15 >= 0) goto L38;
        r1.setInUse(false);
        return false;
    L38:
        if (r1.match == null) goto L40;
        r1.match.setBeginning(0, r15);
        r1.match.setEnd(0, r15 + this.fixedString.length());
    L40:
        r1.setInUse(false);
        return true;
    L45:
        if (this.fixedString != null) goto L47;
    L50:
        int r16 = r1.limit - this.minlength;
        int r2 = -1;
        Op r3 = this.operations;
        if (r3 != null) goto L53;
    L70:
        RangeToken r8 = this.firstChar;
        if (r8 == null) goto L87;
        int r4 = -1;
        int r5 = r1.start;
    L73:
        if (r5 > r16) goto L86;
        char r6 = r11[r5];
        boolean r7 = REUtil.isHighSurrogate(r6);
        int r9 = r6;
        if (r7 == false) goto L80;
        int r17 = r5 + 1;
        r9 = r6;
        if (r17 >= r1.limit) goto L80;
        r9 = REUtil.composeFromSurrogates(r6, r11[r17]);
    L80:
        if (r8.match(r9) == false) goto L85;
        r4 = match(r1, this.operations, r5, 1, this.options);
        if (r4 >= 0) goto L86;
    L85:
        r5 = r5 + 1;
    L86:
        int r18 = r4;
        int r19 = r5;
    L94:
        if (r18 >= 0) goto L96;
        r1.setInUse(false);
        return false;
    L96:
        if (r1.match == null) goto L98;
        r1.match.setBeginning(0, r19);
        r1.match.setEnd(0, r18);
    L98:
        r1.setInUse(false);
        return true;
    L87:
        r19 = r1.start;
    L88:
        if (r19 > r16) goto L93;
        r2 = match(r1, this.operations, r19, 1, this.options);
        if (r2 >= 0) goto L93;
        r19 = r19 + 1;
    L93:
        r18 = r2;
        goto L94
    L53:
        if (r3.type != 7) goto L70;
        if (this.operations.getChild().type != 0) goto L70;
        if (isSet(this.options, 4) == false) goto L59;
        r19 = r1.start;
        r18 = match(r1, this.operations, r1.start, 1, this.options);
        goto L94
    L59:
        boolean r20 = true;
        r4 = -1;
        r5 = r1.start;
    L60:
        if (r5 > r16) goto L86;
        if (isEOLChar(r11[r5]) == false) goto L64;
        r20 = true;
    L69:
        r5 = r5 + 1;
        goto L60
    L64:
        if (r20 == false) goto L68;
        r4 = match(r1, this.operations, r5, 1, this.options);
        if (r4 >= 0) goto L86;
    L68:
        r20 = false;
        goto L69
    L47:
        if (this.fixedStringTable.matches(r11, r1.start, r1.limit) >= 0) goto L50;
        r1.setInUse(false);
        return false;
    L21:
        if (this.hasBackReferences == false) goto L23;
        r14 = new Match();
        r14.setNumberOfGroups(this.nofparen);
        goto L23
    L15:
        r1 = this.context;     // Catch: Throwable -> L102
        goto L16
    }

    public boolean matches(char[] r3, Match r4) {
        return matches(r3, 0, r3.length, r4);
    }

    void prepare() {
        compile(this.tokentree);
        this.minlength = this.tokentree.getMinLength();
        this.firstChar = null;
        if (isSet(this.options, 128) == false) goto L5;
    L9:
        Op r1 = this.operations;
        if (r1 == null) goto L28;
        if (r1.type == 6) goto L16;
        if (this.operations.type != 1) goto L28;
    L16:
        if (this.operations.next != null) goto L28;
        this.fixedStringOnly = true;
        if (this.operations.type != 6) goto L22;
        String r0 = this.operations.getString();
    L20:
        this.fixedString = r0;
    L25:
        this.fixedStringOptions = this.options;
        BMPattern r2 = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
    L26:
        this.fixedStringTable = r2;
        return;
    L22:
        if (this.operations.getData() < 65536) goto L24;
        r0 = REUtil.decomposeToSurrogates(this.operations.getData());
        goto L20
    L24:
        this.fixedString = new String(new char[]{(char) this.operations.getData()});
    L28:
        if (isSet(this.options, 256) == false) goto L30;
        return;
    L30:
        if (isSet(this.options, 512) == true) goto L45;
        Token.FixedStringContainer r3 = new Token.FixedStringContainer();
        this.tokentree.findFixedString(r3, this.options);
        if (r3.token != null) goto L34;
        String r4 = null;
    L35:
        this.fixedString = r4;
        this.fixedStringOptions = r3.options;
        String r5 = this.fixedString;
        if (r5 == null) goto L41;
        if (r5.length() >= 2) goto L41;
        this.fixedString = null;
    L41:
        if (this.fixedString == null) goto L46;
        r2 = new BMPattern(this.fixedString, 256, isSet(this.fixedStringOptions, 2));
        goto L26
    L46:
        return;
    L34:
        r4 = r3.token.getString();
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
        setPattern(r2, Locale.getDefault());
    }

    public void setPattern(String r2, String r3) {
        setPattern(r2, r3, Locale.getDefault());
    }

    public void setPattern(String r1, String r2, Locale r3) {
        setPattern(r1, REUtil.parseOptions(r2), r3);
    }

    public void setPattern(String r2, Locale r3) {
        setPattern(r2, this.options, r3);
    }

    public String toString() {
        return this.tokentree.toString(this.options);
    }
}
