package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.TokenTypeDecl;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public class MatchSet extends MatchToken {

    @ModelElement
    public CaptureNextTokenType capture;

    @ModelElement
    public TestSetInline expr;

    public MatchSet(OutputModelFactory r5, GrammarAST r10) {
        super(r5, r10);
        SetTransition r11 = (SetTransition) r10.atnState.transition(0);
        int r12 = r5.getGenerator().getTarget().getInlineTestSetWordSize();
        TestSetInline r13 = new TestSetInline(r5, null, r11.set, r12);
        this.expr = r13;
        TokenTypeDecl r14 = new TokenTypeDecl(r5, r13.varName);
        r5.getCurrentRuleFunction().addLocalDecl(r14);
        this.capture = new CaptureNextTokenType(r5, this.expr.varName);
    }
}
