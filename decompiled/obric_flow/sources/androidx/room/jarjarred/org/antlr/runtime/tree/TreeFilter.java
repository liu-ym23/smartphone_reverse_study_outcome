package androidx.room.jarjarred.org.antlr.runtime.tree;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public class TreeFilter extends TreeParser {
    fptr bottomup_fptr;
    protected TreeAdaptor originalAdaptor;
    protected TokenStream originalTokenStream;
    fptr topdown_fptr;

    public interface fptr {
        void rule() throws RecognitionException;
    }

    public TreeFilter(TreeNodeStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public void applyOnce(Object r5, fptr r10) {
        if (r5 != null) goto L7;
        return;
    L7:
        this.state = new RecognizerSharedState();     // Catch: RecognitionException -> L6
        CommonTreeNodeStream r11 = new CommonTreeNodeStream(this.originalAdaptor, r5);     // Catch: RecognitionException -> L6
        this.input = r11;     // Catch: RecognitionException -> L6
        r11.setTokenStream(this.originalTokenStream);     // Catch: RecognitionException -> L6
        setBacktrackingLevel(1);     // Catch: RecognitionException -> L6
        r10.rule();     // Catch: RecognitionException -> L6
        setBacktrackingLevel(0);     // Catch: RecognitionException -> L6
        return;
    }

    public void bottomup() throws RecognitionException {
    }

    public void downup(Object r5) {
        new TreeVisitor(new CommonTreeAdaptor()).visit(r5, new AnonymousClass1(this));
    }

    public void topdown() throws RecognitionException {
    }

    public TreeFilter(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.topdown_fptr = new AnonymousClass2(this);
        this.bottomup_fptr = new AnonymousClass3(this);
        this.originalAdaptor = r5.getTreeAdaptor();
        this.originalTokenStream = r5.getTokenStream();
    }
}
