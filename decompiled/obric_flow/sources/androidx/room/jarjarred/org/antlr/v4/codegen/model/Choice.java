package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.TokenTypeDecl;
import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Choice extends RuleElement {

    @ModelElement
    public List<CodeBlockForAlt> alts;
    public int decision;
    public Decl label;

    @ModelElement
    public List<SrcOp> preamble;

    public Choice(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10);
        this.decision = -1;
        this.preamble = new ArrayList();
        this.alts = r11;
    }

    public TestSetInline addCodeForLookaheadTempVar(IntervalSet r5) {
        TestSetInline r10 = (TestSetInline) Utils.find(this.factory.getLL1Test(r5, this.ast), TestSetInline.class);
        if (r10 == null) goto L5;
        TokenTypeDecl r11 = new TokenTypeDecl(this.factory, r10.varName);
        this.factory.getCurrentRuleFunction().addLocalDecl(r11);
        addPreambleOp(new CaptureNextTokenType(this.factory, r10.varName));
    L5:
        return r10;
    }

    public void addPreambleOp(SrcOp r5) {
        this.preamble.add(r5);
    }

    public List<String[]> getAltLookaheadAsStringLists(IntervalSet[] r10) {
        ArrayList r5 = new ArrayList();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        IntervalSet r13 = r10[r12];
        r5.add(this.factory.getGenerator().getTarget().getTokenTypesAsTargetLabels(this.factory.getGrammar(), r13.toArray()));
        r12 = r12 + 1;
        goto L3
    L5:
        return r5;
    }

    public ThrowNoViableAlt getThrowNoViableAlt(OutputModelFactory r5, GrammarAST r10, IntervalSet r11) {
        return new ThrowNoViableAlt(r5, r10, r11);
    }
}
