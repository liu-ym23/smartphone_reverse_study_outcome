package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.CodeBlock;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public abstract class SrcOp extends OutputModelObject {
    public CodeBlock enclosingBlock;
    public RuleFunction enclosingRuleRunction;
    public int uniqueID;

    public SrcOp(OutputModelFactory r5) {
        this(r5, null);
    }

    public String getContextName() {
        CodeBlockForOuterMostAlt r5 = getOuterMostAltCodeBlock();
        if (r5 == null) goto L8;
        String r10 = r5.altLabel;
        if (r10 == null) goto L8;
        return r10;
    L8:
        return this.enclosingRuleRunction.name;
    }

    public CodeBlockForOuterMostAlt getOuterMostAltCodeBlock() {
        if ((this instanceof CodeBlockForOuterMostAlt) == true) goto L5;
        CodeBlock r5 = this.enclosingBlock;
    L7:
        if (r5 == null) goto L13;
        if ((r5 instanceof CodeBlockForOuterMostAlt) == true) goto L11;
        r5 = r5.enclosingBlock;
        goto L7
    L11:
        return (CodeBlockForOuterMostAlt) r5;
    L13:
        return null;
    L5:
        return (CodeBlockForOuterMostAlt) this;
    }

    public SrcOp(OutputModelFactory r5, GrammarAST r10) {
        super(r5, r10);
        if (r10 == null) goto L5;
        this.uniqueID = r10.token.getTokenIndex();
    L5:
        this.enclosingBlock = r5.getCurrentBlock();
        this.enclosingRuleRunction = r5.getCurrentRuleFunction();
    }
}
