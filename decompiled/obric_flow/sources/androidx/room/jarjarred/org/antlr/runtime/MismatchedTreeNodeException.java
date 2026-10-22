package androidx.room.jarjarred.org.antlr.runtime;

import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;

/* JADX INFO: loaded from: classes.dex */
public class MismatchedTreeNodeException extends RecognitionException {
    public int expecting;

    public MismatchedTreeNodeException() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r5 = new StringBuilder("MismatchedTreeNodeException(");
        r5.append(getUnexpectedType());
        r5.append("!=");
        return androidx.constraintlayout.motion.widget.a.s(r5, this.expecting, ")");
    }

    public MismatchedTreeNodeException(int r5, TreeNodeStream r10) {
        super(r10);
        this.expecting = r5;
    }
}
