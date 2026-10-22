package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public class TreeRewriter extends TreeParser {
    fptr bottomup_ftpr;
    protected TreeAdaptor originalAdaptor;
    protected TokenStream originalTokenStream;
    protected boolean showTransformations;
    fptr topdown_fptr;

    public interface fptr {
        Object rule() throws RecognitionException;
    }

    public TreeRewriter(TreeNodeStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public Object applyOnce(Object r5, fptr r10) {
        if (r5 != null) goto L23;
        return null;
    L23:
        this.state = new RecognizerSharedState();     // Catch: RecognitionException -> L22
        CommonTreeNodeStream r11 = new CommonTreeNodeStream(this.originalAdaptor, r5);     // Catch: RecognitionException -> L22
        this.input = r11;     // Catch: RecognitionException -> L22
        r11.setTokenStream(this.originalTokenStream);     // Catch: RecognitionException -> L22
        setBacktrackingLevel(1);     // Catch: RecognitionException -> L22
        TreeRuleReturnScope r12 = (TreeRuleReturnScope) r10.rule();     // Catch: RecognitionException -> L22
        setBacktrackingLevel(0);     // Catch: RecognitionException -> L22
        if (failed() == false) goto L9;
        return r5;
    L9:
        if (this.showTransformations == false) goto L16;
        if (r12 == null) goto L16;
        if (r5.equals(r12.getTree()) == true) goto L16;
        if (r12.getTree() == null) goto L16;
        reportTransformation(r5, r12.getTree());     // Catch: RecognitionException -> L22
    L16:
        if (r12 == null) goto L21;
        if (r12.getTree() == null) goto L21;
        return r12.getTree();
    L21:
        return r5;
    }

    public Object applyRepeatedly(Object r5, fptr r10) {
        boolean r11 = true;
    L3:
        if (r11 == false) goto L5;
        Object r12 = applyOnce(r5, r10);
        r11 = !r5.equals(r12);
        r5 = r12;
        goto L3
    L5:
        return r5;
    }

    public Object bottomup() throws RecognitionException {
        return null;
    }

    public Object downup(Object r5) {
        return downup(r5, false);
    }

    public void reportTransformation(Object r5, Object r10) {
        System.out.println(((Tree) r5).toStringTree() + " -> " + ((Tree) r10).toStringTree());
    }

    public Object topdown() throws RecognitionException {
        return null;
    }

    public TreeRewriter(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.showTransformations = false;
        this.topdown_fptr = new AnonymousClass2(this);
        this.bottomup_ftpr = new AnonymousClass3(this);
        this.originalAdaptor = r5.getTreeAdaptor();
        this.originalTokenStream = r5.getTokenStream();
    }

    public Object downup(Object r5, boolean r10) {
        this.showTransformations = r10;
        return new TreeVisitor(new CommonTreeAdaptor()).visit(r5, new AnonymousClass1(this));
    }
}
