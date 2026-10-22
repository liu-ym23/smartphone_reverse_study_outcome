package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public class DFA {
    public static final boolean debug = false;
    protected short[] accept;
    protected int decisionNumber;
    protected short[] eof;
    protected short[] eot;
    protected char[] max;
    protected char[] min;
    protected BaseRecognizer recognizer;
    protected short[] special;
    protected short[][] transition;

    public DFA() {
    }

    public static short[] unpackEncodedString(String r10) {
        int r5 = 0;
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 >= r10.length()) goto L6;
        r12 = r12 + r10.charAt(r11);
        r11 = r11 + 2;
        goto L4
    L6:
        short[] r13 = new short[r12];
        int r14 = 0;
    L8:
        if (r5 >= r10.length()) goto L13;
        char r15 = r10.charAt(r5);
        char r16 = r10.charAt(r5 + 1);
        int r17 = 1;
    L10:
        if (r17 > r15) goto L12;
        r13[r14] = (short) r16;
        r17 = r17 + 1;
        r14 = r14 + 1;
        goto L10
    L12:
        r5 = r5 + 2;
        goto L8
    L13:
        return r13;
    }

    public static char[] unpackEncodedStringToUnsignedChars(String r10) {
        int r5 = 0;
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r11 >= r10.length()) goto L6;
        r12 = r12 + r10.charAt(r11);
        r11 = r11 + 2;
        goto L4
    L6:
        char[] r13 = new char[r12];
        int r14 = 0;
    L8:
        if (r5 >= r10.length()) goto L13;
        char r15 = r10.charAt(r5);
        char r16 = r10.charAt(r5 + 1);
        int r17 = 1;
    L10:
        if (r17 > r15) goto L12;
        r13[r14] = r16;
        r17 = r17 + 1;
        r14 = r14 + 1;
        goto L10
    L12:
        r5 = r5 + 2;
        goto L8
    L13:
        return r13;
    }

    public void error(NoViableAltException r5) {
    }

    public String getDescription() {
        return "n/a";
    }

    public void noViableAlt(int r5, IntStream r10) throws NoViableAltException {
        RecognizerSharedState r11 = this.recognizer.state;
        if (r11.backtracking <= 0) goto L6;
        r11.failed = true;
        return;
    L6:
        NoViableAltException r12 = new NoViableAltException(getDescription(), this.decisionNumber, r5, r10);
        error(r12);
        throw r12;
    }

    public int predict(IntStream r10) throws RecognitionException {
        int r5 = r10.mark();
        int r11 = 0;
    L47:
        short r12 = this.special[r11];     // Catch: Throwable -> L10
        if (r12 >= 0) goto L5;
        short r13 = this.accept[r11];     // Catch: Throwable -> L10
        if (r13 >= 1) goto L16;
        char r14 = (char) r10.LA(1);     // Catch: Throwable -> L10
        char r15 = this.min[r11];     // Catch: Throwable -> L10
        if (r14 < r15) goto L32;
        if (r14 > this.max[r11]) goto L32;
        short r16 = this.transition[r11][r14 - r15];     // Catch: Throwable -> L10
        if (r16 >= 0) goto L31;
        r16 = this.eot[r11];     // Catch: Throwable -> L10
        if (r16 < 0) goto L28;
        r10.consume();     // Catch: Throwable -> L10
    L27:
        r11 = r16;
        goto L47
    L28:
        noViableAlt(r11, r10);     // Catch: Throwable -> L10
        r10.rewind(r5);
        return 0;
    L31:
        r10.consume();     // Catch: Throwable -> L10
    L32:
        short r17 = this.eot[r11];     // Catch: Throwable -> L10
        if (r17 < 0) goto L36;
        r10.consume();     // Catch: Throwable -> L10
        r11 = r17;
        goto L47
    L36:
        if (r14 != 65535) goto L42;
        short r18 = this.eof[r11];     // Catch: Throwable -> L10
        if (r18 < 0) goto L42;
        short r19 = this.accept[r18];     // Catch: Throwable -> L10
        r10.rewind(r5);
        return r19;
    L42:
        noViableAlt(r11, r10);     // Catch: Throwable -> L10
        r10.rewind(r5);
        return 0;
    L16:
        r10.rewind(r5);
        return r13;
    L5:
        r11 = specialStateTransition(r12, r10);     // Catch: Throwable -> L10
        if (r11 == (-1)) goto L7;
        r10.consume();     // Catch: Throwable -> L10
        goto L47
    L7:
        noViableAlt(r11, r10);     // Catch: Throwable -> L10
        r10.rewind(r5);
        return 0;
    L10:
        th = move-exception;
        r10.rewind(r5);
        throw th;
    }

    public int specialStateTransition(int r5, IntStream r10) throws NoViableAltException {
        return -1;
    }
}
