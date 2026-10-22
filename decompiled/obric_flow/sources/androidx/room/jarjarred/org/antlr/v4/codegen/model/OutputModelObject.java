package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public abstract class OutputModelObject {
    public GrammarAST ast;
    public OutputModelFactory factory;

    public OutputModelObject() {
    }

    public OutputModelObject(OutputModelFactory r5) {
        this(r5, null);
    }

    public OutputModelObject(OutputModelFactory r5, GrammarAST r10) {
        this.factory = r5;
        this.ast = r10;
    }
}
