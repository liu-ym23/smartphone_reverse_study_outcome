package androidx.room.jarjarred.org.antlr.v4.codegen;

import androidx.room.jarjarred.org.antlr.v4.codegen.model.Choice;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LabeledOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Lexer;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LexerFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Parser;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ParserFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BlankOutputModelFactory implements OutputModelFactory {
    public BlankOutputModelFactory() {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> action(ActionAST r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeBlockForAlt alternative(Alternative r5, boolean r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeBlockForAlt epsilon(Alternative r5, boolean r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeBlockForAlt finishAlternative(CodeBlockForAlt r5, List<SrcOp> r10) {
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10, GrammarAST r11) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getComplexChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getComplexEBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getEBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getLL1ChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getLL1EBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> getLL1Test(IntervalSet r5, GrammarAST r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Lexer lexer(LexerFile r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public LexerFile lexerFile(String r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public boolean needsImplicitLabel(GrammarAST r5, LabeledOp r10) {
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Parser parser(ParserFile r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public ParserFile parserFile(String r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public RuleFunction rule(Rule r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> rulePostamble(RuleFunction r5, Rule r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> ruleRef(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> sempred(ActionAST r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> set(GrammarAST r5, GrammarAST r10, boolean r11) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> stringRef(GrammarAST r5, GrammarAST r10) {
        return tokenRef(r5, r10, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> tokenRef(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> wildcard(GrammarAST r5, GrammarAST r10) {
        return null;
    }
}
