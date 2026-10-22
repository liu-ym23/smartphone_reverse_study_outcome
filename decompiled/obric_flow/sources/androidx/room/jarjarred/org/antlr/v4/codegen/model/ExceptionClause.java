package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;

/* JADX INFO: loaded from: classes.dex */
public class ExceptionClause extends SrcOp {

    @ModelElement
    public Action catchAction;

    @ModelElement
    public Action catchArg;

    public ExceptionClause(OutputModelFactory r5, ActionAST r10, ActionAST r11) {
        super(r5, r10);
        this.catchArg = new Action(r5, r10);
        this.catchAction = new Action(r5, r11);
    }
}
