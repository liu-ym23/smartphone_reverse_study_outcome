package androidx.room.jarjarred.org.antlr.v4.codegen.model.decl;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ModelElement;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.OrderedHashSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CodeBlock extends SrcOp {
    public int codeBlockLevel;

    @ModelElement
    public OrderedHashSet<Decl> locals;

    @ModelElement
    public List<SrcOp> ops;

    @ModelElement
    public List<SrcOp> preamble;
    public int treeLevel;

    public CodeBlock(OutputModelFactory r5) {
        super(r5);
    }

    public void addLocalDecl(Decl r5) {
        if (this.locals != null) goto L5;
        this.locals = new OrderedHashSet();
    L5:
        this.locals.add(r5);
        r5.isLocal = true;
    }

    public void addOp(SrcOp r5) {
        if (this.ops != null) goto L5;
        this.ops = new ArrayList();
    L5:
        this.ops.add(r5);
    }

    public void addOps(List<SrcOp> r5) {
        if (this.ops != null) goto L5;
        this.ops = new ArrayList();
    L5:
        this.ops.addAll(r5);
    }

    public void addPreambleOp(SrcOp r5) {
        if (this.preamble != null) goto L5;
        this.preamble = new ArrayList();
    L5:
        this.preamble.add(r5);
    }

    public void insertOp(int r5, SrcOp r10) {
        if (this.ops != null) goto L5;
        this.ops = new ArrayList();
    L5:
        this.ops.add(r5, r10);
    }

    public CodeBlock(OutputModelFactory r5, int r10, int r11) {
        super(r5);
        this.treeLevel = r10;
        this.codeBlockLevel = r11;
    }
}
