package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import java.io.InvalidObjectException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WhiteSpaceProcessor implements Serializable {
    private static final WhiteSpaceProcessor backwardCompatibiliyHook1 = null;
    private static final WhiteSpaceProcessor backwardCompatibiliyHook2 = null;
    private static final WhiteSpaceProcessor backwardCompatibiliyHook3 = null;
    private static final long serialVersionUID = 1;
    public static final WhiteSpaceProcessor theCollapse = null;
    public static final WhiteSpaceProcessor thePreserve = null;
    public static final WhiteSpaceProcessor theReplace = null;

    private static class Collapse extends WhiteSpaceProcessor {
        private static final long serialVersionUID = 1;

        private Collapse() {
        }

        /* synthetic */ Collapse(AnonymousClass1 r1) {
            this();
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        public String getName() {
            return "collapse";
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        public String process(String r8) {
            int r7 = r8.length();
            StringBuffer r0 = new StringBuffer(r7);
            int r2 = 0;
            boolean r3 = true;
        L4:
            if (r2 >= r7) goto L14;
            char r5 = r8.charAt(r2);
            boolean r6 = WhiteSpaceProcessor.isWhiteSpace(r5);
            if (r3 == false) goto L9;
            if (r6 == false) goto L9;
        L13:
            r2 = r2 + 1;
        L9:
            if (r6 == false) goto L11;
            r0.append(' ');
        L12:
            r3 = r6;
            goto L13
        L11:
            r0.append(r5);
            goto L12
        L14:
            int r9 = r0.length();
            if (r9 <= 0) goto L20;
            int r10 = r9 - 1;
            if (r0.charAt(r10) != ' ') goto L20;
            r0.setLength(r10);
        L20:
            return r0.toString();
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        int tightness() {
            return 2;
        }
    }

    private static class Preserve extends WhiteSpaceProcessor {
        private static final long serialVersionUID = 1;

        private Preserve() {
        }

        /* synthetic */ Preserve(AnonymousClass1 r1) {
            this();
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        public String getName() {
            return "preserve";
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        public String process(String r1) {
            return r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        int tightness() {
            return 0;
        }
    }

    private static class Replace extends WhiteSpaceProcessor {
        private static final long serialVersionUID = 1;

        private Replace() {
        }

        /* synthetic */ Replace(AnonymousClass1 r1) {
            this();
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        public String getName() {
            return "replace";
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        public String process(String r5) {
            int r4 = r5.length();
            StringBuffer r0 = new StringBuffer(r4);
            int r1 = 0;
        L3:
            if (r1 >= r4) goto L9;
            char r2 = r5.charAt(r1);
            if (WhiteSpaceProcessor.isWhiteSpace(r2) == false) goto L7;
            r2 = ' ';
        L7:
            r0.append(r2);
            r1 = r1 + 1;
            goto L3
        L9:
            return r0.toString();
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.WhiteSpaceProcessor
        int tightness() {
            return 1;
        }
    }

    static {
        AnonymousClass1 r1 = null;
        thePreserve = new Preserve(r1);
        theReplace = new Replace(r1);
        theCollapse = new Collapse(r1);
        backwardCompatibiliyHook1 = new AnonymousClass1();
        backwardCompatibiliyHook2 = new AnonymousClass2();
        backwardCompatibiliyHook3 = new AnonymousClass3();
    }

    public WhiteSpaceProcessor() {
    }

    public static String collapse(String r1) {
        return theCollapse.process(r1);
    }

    public static WhiteSpaceProcessor get(String r2) {
        WhiteSpaceProcessor r0 = theCollapse;
        String r3 = r0.process(r2);
        if (r3.equals("preserve") == false) goto L7;
        return thePreserve;
    L7:
        if (r3.equals("collapse") == false) goto L10;
        return r0;
    L10:
        if (r3.equals("replace") == false) goto L14;
        return theReplace;
    L14:
        throw new DatatypeException(XSDatatypeImpl.localize(XSDatatypeImpl.ERR_INVALID_WHITESPACE_VALUE, r3));
    }

    public static final boolean isWhiteSpace(char r1) {
        if (r1 != '\t') goto L5;
    L12:
        return true;
    L5:
        if (r1 == '\n') goto L12;
        if (r1 == '\r') goto L12;
        if (r1 == ' ') goto L12;
        return false;
    }

    public static String replace(String r1) {
        return theReplace.process(r1);
    }

    public abstract String getName();

    public abstract String process(String r1);

    public Object readResolve() {
        if (getClass() != backwardCompatibiliyHook1.getClass()) goto L7;
        return thePreserve;
    L7:
        if (getClass() != backwardCompatibiliyHook2.getClass()) goto L11;
        return theCollapse;
    L11:
        if (getClass() != backwardCompatibiliyHook3.getClass()) goto L15;
        return theReplace;
    L15:
        return get(getName());
    L17:
        throw new InvalidObjectException("Unknown Processing Mode");
    }

    abstract int tightness();
}
