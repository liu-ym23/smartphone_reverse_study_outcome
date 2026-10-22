package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.AltLabelStructDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.RuleContextDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.RuleContextListDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.StructDecl;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.LeftRecursiveRule;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LeftRecursiveRuleFunction extends RuleFunction {
    public LeftRecursiveRuleFunction(OutputModelFactory r10, LeftRecursiveRule r11) {
        super(r10, r11);
        CodeGenerator r5 = r10.getGenerator();
        Iterator<Pair<GrammarAST, String>> r12 = r11.leftRecursiveRuleRefLabels.iterator();
    L4:
        if (r12.hasNext() == false) goto L17;
        Pair<GrammarAST, String> r13 = r12.next();
        GrammarAST r14 = r13.f667a;
        String r15 = r13.f668b;
        String r16 = r14.getText();
        GrammarAST r17 = (GrammarAST) r14.getParent().getChild(1);
        if (r17.getType() != 57) goto L4;
        Rule r18 = r10.getGrammar().getRule(r17.getText());
        String r19 = r5.getTarget().getRuleFunctionContextStructName(r18);
        if (r14.getParent().getType() != 10) goto L10;
        Decl r20 = new RuleContextDecl(r10, r16, r19);
    L11:
        StructDecl r21 = this.ruleCtx;
        Map<String, AltLabelStructDecl> r22 = this.altLabelCtxs;
        if (r22 == null) goto L16;
        AltLabelStructDecl r23 = r22.get(r15);
        if (r23 == null) goto L16;
        r21 = r23;
    L16:
        r21.addDecl(r20);
        goto L4
    L10:
        r20 = new RuleContextListDecl(r10, r16, r19);
        goto L11
    }
}
