package androidx.room.jarjarred.org.antlr.v4.codegen;

import androidx.room.jarjarred.org.antlr.v4.codegen.model.Action;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForOuterMostAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.OutputModelObject;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.CodeBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class DefaultOutputModelFactory extends BlankOutputModelFactory {
    public OutputModelController controller;
    public final Grammar g;
    public final CodeGenerator gen;

    public DefaultOutputModelFactory(CodeGenerator r5) {
        this.gen = r5;
        this.g = r5.g;
    }

    public static List<SrcOp> list(SrcOp... r5) {
        return new ArrayList(Arrays.asList(r5));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public int getCodeBlockLevel() {
        return this.controller.codeBlockLevel;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public OutputModelController getController() {
        return this.controller;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeBlock getCurrentBlock() {
        return this.controller.getCurrentBlock();
    }

    public Decl getCurrentDeclForName(String r5) {
        if (getCurrentBlock().locals != null) goto L5;
        return null;
    L5:
        Iterator<Decl> r10 = getCurrentBlock().locals.elements().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        Decl r11 = r10.next();
        if (r11.name.equals(r5) == false) goto L7;
        return r11;
    L11:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Alternative getCurrentOuterMostAlt() {
        return this.controller.getCurrentOuterMostAlt();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeBlockForOuterMostAlt getCurrentOuterMostAlternativeBlock() {
        return this.controller.getCurrentOuterMostAlternativeBlock();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public RuleFunction getCurrentRuleFunction() {
        return this.controller.getCurrentRuleFunction();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeGenerator getGenerator() {
        return this.gen;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Grammar getGrammar() {
        return this.g;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public OutputModelObject getRoot() {
        return this.controller.getRoot();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public int getTreeLevel() {
        return this.controller.treeLevel;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> rulePostamble(RuleFunction r5, Rule r10) {
        if (r10.namedActions.containsKey("after") == false) goto L5;
    L9:
        ST r11 = getGenerator().getTemplates().getInstanceOf("recRuleSetStopToken");
        Action r12 = new Action(this, r5.ruleCtx, r11);
        ArrayList r13 = new ArrayList(1);
        r13.add(r12);
        return r13;
    L5:
        if (r10.namedActions.containsKey("finally") == true) goto L9;
        return super.rulePostamble(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public void setController(OutputModelController r5) {
        this.controller = r5;
    }

    public static List<SrcOp> list(Collection<? extends SrcOp> r5) {
        return new ArrayList(r5);
    }
}
