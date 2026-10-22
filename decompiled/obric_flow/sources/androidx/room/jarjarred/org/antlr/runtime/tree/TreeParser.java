package androidx.room.jarjarred.org.antlr.runtime.tree;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedTreeNodeException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class TreeParser extends BaseRecognizer {
    public static final int DOWN = 2;
    public static final int UP = 3;
    static String dotdot = ".*[^.]\\.\\.[^.].*";
    static Pattern dotdotPattern = null;
    static String doubleEtc = ".*\\.\\.\\.\\s+\\.\\.\\..*";
    static Pattern doubleEtcPattern;
    protected TreeNodeStream input;

    static {
        dotdotPattern = Pattern.compile(".*[^.]\\.\\.[^.].*");
        doubleEtcPattern = Pattern.compile(doubleEtc);
    }

    public TreeParser(TreeNodeStream r5) {
        setTreeNodeStream(r5);
    }

    public static Object getAncestor(TreeAdaptor r5, String[] r10, Object r11, String r12) {
    L2:
        if (r11 == null) goto L7;
        if (r10[r5.getType(r11)].equals(r12) == true) goto L5;
        r11 = r5.getParent(r11);
        goto L2
    L5:
        return r11;
    L7:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public Object getCurrentInputSymbol(IntStream r5) {
        return ((TreeNodeStream) r5).LT(1);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getErrorHeader(RecognitionException r5) {
        StringBuilder r10 = new StringBuilder();
        r10.append(getGrammarFileName());
        r10.append(": node from ");
        if (r5.approximateLineInfo == false) goto L5;
        String r11 = "after ";
    L6:
        r10.append(r11);
        r10.append("line ");
        r10.append(r5.line);
        r10.append(":");
        r10.append(r5.charPositionInLine);
        return r10.toString();
    L5:
        r11 = "";
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getErrorMessage(RecognitionException r5, String[] r10) {
        TreeAdaptor r11 = ((TreeNodeStream) r5.input).getTreeAdaptor();
        Token r12 = r11.getToken(r5.node);
        r5.token = r12;
        if (r12 != null) goto L6;
        r5.token = new CommonToken(r11.getType(r5.node), r11.getText(r5.node));
    L6:
        return super.getErrorMessage(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public Object getMissingSymbol(IntStream r5, RecognitionException r10, int r11, BitSet r12) {
        String r13 = j0.q(new StringBuilder("<missing "), getTokenNames()[r11], ">");
        return ((TreeNodeStream) r10.input).getTreeAdaptor().create(new CommonToken(r11, r13));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer, androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public String getSourceName() {
        return this.input.getSourceName();
    }

    public TreeNodeStream getTreeNodeStream() {
        return this.input;
    }

    public boolean inContext(String r5) {
        return inContext(this.input.getTreeAdaptor(), getTokenNames(), this.input.LT(1), r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void matchAny(IntStream r5) {
        RecognizerSharedState r10 = this.state;
        int r11 = 0;
        r10.errorRecovery = false;
        r10.failed = false;
        Object r12 = this.input.LT(1);
        if (this.input.getTreeAdaptor().getChildCount(r12) != 0) goto L6;
        this.input.consume();
        return;
    L6:
        int r13 = this.input.getTreeAdaptor().getType(r12);
    L8:
        if (r13 == (-1)) goto L17;
        if (r13 != 3) goto L12;
        if (r11 == 0) goto L17;
    L12:
        this.input.consume();
        r13 = this.input.getTreeAdaptor().getType(this.input.LT(1));
        if (r13 == 2) goto L14;
        if (r13 != 3) goto L8;
        r11 = r11 - 1;
        goto L8
    L14:
        r11 = r11 + 1;
    L17:
        this.input.consume();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public Object recoverFromMismatchedToken(IntStream r5, int r10, BitSet r11) throws RecognitionException {
        throw new MismatchedTreeNodeException(r10, (TreeNodeStream) r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void reset() {
        super.reset();
        TreeNodeStream r5 = this.input;
        if (r5 == null) goto L6;
        r5.seek(0);
        return;
    }

    public void setTreeNodeStream(TreeNodeStream r5) {
        this.input = r5;
    }

    public void traceIn(String r5, int r10) {
        super.traceIn(r5, r10, this.input.LT(1));
    }

    public void traceOut(String r5, int r10) {
        super.traceOut(r5, r10, this.input.LT(1));
    }

    public static boolean inContext(TreeAdaptor r5, String[] r10, Object r11, String r12) {
        Matcher r13 = dotdotPattern.matcher(r12);
        Matcher r14 = doubleEtcPattern.matcher(r12);
        if (r13.find() == true) goto L29;
        if (r14.find() == true) goto L27;
        String[] r15 = r12.replaceAll("\\.\\.\\.", " ... ").trim().split("\\s+");
        int r16 = r15.length - 1;
        Object r17 = r5.getParent(r11);
    L8:
        if (r16 < 0) goto L22;
        if (r17 == null) goto L22;
        if (r15[r16].equals("...") == false) goto L19;
        if (r16 == 0) goto L13;
        r17 = getAncestor(r5, r10, r17, r15[r16 - 1]);
        if (r17 == null) goto L16;
        r16 = r16 - 1;
        goto L19
    L16:
        return false;
    L13:
        return true;
    L19:
        if (r10[r5.getType(r17)].equals(r15[r16]) == false) goto L20;
        r16 = r16 - 1;
        r17 = r5.getParent(r17);
        goto L8
    L20:
        return false;
    L22:
        if (r17 != null) goto L25;
        if (r16 < 0) goto L25;
        return false;
    L25:
        return true;
    L27:
        throw new IllegalArgumentException("invalid syntax: ... ...");
    L29:
        throw new IllegalArgumentException("invalid syntax: ..");
    }

    public TreeParser(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r10);
        setTreeNodeStream(r5);
    }
}
