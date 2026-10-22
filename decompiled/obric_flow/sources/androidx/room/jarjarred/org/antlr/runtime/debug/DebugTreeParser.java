package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser;
import java.io.IOException;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class DebugTreeParser extends TreeParser {
    protected DebugEventListener dbg;
    public boolean isCyclicDecision;

    public DebugTreeParser(TreeNodeStream r5, DebugEventListener r10, RecognizerSharedState r11) {
        if ((r5 instanceof DebugTreeNodeStream) == true) goto L6;
        r5 = new DebugTreeNodeStream(r5, r10);
    L6:
        super(r5, r11);
        this.dbg = null;
        this.isCyclicDecision = false;
        setDebugListener(r10);
    }

    public void beginBacktrack(int r5) {
        this.dbg.beginBacktrack(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void beginResync() {
        this.dbg.beginResync();
    }

    public void endBacktrack(int r5, boolean r10) {
        this.dbg.endBacktrack(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void endResync() {
        this.dbg.endResync();
    }

    public DebugEventListener getDebugListener() {
        return this.dbg;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser, androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public Object getMissingSymbol(IntStream r5, RecognitionException r10, int r11, BitSet r12) {
        Object r13 = super.getMissingSymbol(r5, r10, r11, r12);
        this.dbg.consumeNode(r13);
        return r13;
    }

    public void reportError(IOException r5) {
        PrintStream r10 = System.err;
        r10.println(r5);
        r5.printStackTrace(r10);
    }

    public void setDebugListener(DebugEventListener r5) {
        TreeNodeStream r10 = this.input;
        if ((r10 instanceof DebugTreeNodeStream) == false) goto L5;
        ((DebugTreeNodeStream) r10).setDebugListener(r5);
    L5:
        this.dbg = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void reportError(RecognitionException r5) {
        this.dbg.recognitionException(r5);
    }

    public DebugTreeParser(TreeNodeStream r5, RecognizerSharedState r10) {
        if ((r5 instanceof DebugTreeNodeStream) == true) goto L6;
        r5 = new DebugTreeNodeStream(r5, null);
    L6:
        super(r5, r10);
        this.dbg = null;
        this.isCyclicDecision = false;
    }

    public DebugTreeParser(TreeNodeStream r5, DebugEventListener r10) {
        if ((r5 instanceof DebugTreeNodeStream) == true) goto L6;
        r5 = new DebugTreeNodeStream(r5, r10);
    L6:
        this(r5, r10, null);
    }
}
