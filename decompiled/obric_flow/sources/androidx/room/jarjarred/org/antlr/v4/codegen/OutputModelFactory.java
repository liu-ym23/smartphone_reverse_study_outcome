package androidx.room.jarjarred.org.antlr.v4.codegen;

import androidx.room.jarjarred.org.antlr.v4.codegen.model.Choice;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForOuterMostAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LabeledOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Lexer;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LexerFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.OutputModelObject;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Parser;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ParserFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.CodeBlock;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface OutputModelFactory {
    List<SrcOp> action(ActionAST r5);

    CodeBlockForAlt alternative(Alternative r5, boolean r10);

    CodeBlockForAlt epsilon(Alternative r5, boolean r10);

    CodeBlockForAlt finishAlternative(CodeBlockForAlt r5, List<SrcOp> r10);

    Choice getChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10, GrammarAST r11);

    int getCodeBlockLevel();

    Choice getComplexChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10);

    Choice getComplexEBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10);

    OutputModelController getController();

    CodeBlock getCurrentBlock();

    Alternative getCurrentOuterMostAlt();

    CodeBlockForOuterMostAlt getCurrentOuterMostAlternativeBlock();

    RuleFunction getCurrentRuleFunction();

    Choice getEBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10);

    CodeGenerator getGenerator();

    Grammar getGrammar();

    Choice getLL1ChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10);

    Choice getLL1EBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10);

    List<SrcOp> getLL1Test(IntervalSet r5, GrammarAST r10);

    OutputModelObject getRoot();

    int getTreeLevel();

    Lexer lexer(LexerFile r5);

    LexerFile lexerFile(String r5);

    boolean needsImplicitLabel(GrammarAST r5, LabeledOp r10);

    Parser parser(ParserFile r5);

    ParserFile parserFile(String r5);

    RuleFunction rule(Rule r5);

    List<SrcOp> rulePostamble(RuleFunction r5, Rule r10);

    List<SrcOp> ruleRef(GrammarAST r5, GrammarAST r10, GrammarAST r11);

    List<SrcOp> sempred(ActionAST r5);

    List<SrcOp> set(GrammarAST r5, GrammarAST r10, boolean r11);

    void setController(OutputModelController r5);

    List<SrcOp> stringRef(GrammarAST r5, GrammarAST r10);

    List<SrcOp> tokenRef(GrammarAST r5, GrammarAST r10, GrammarAST r11);

    List<SrcOp> wildcard(GrammarAST r5, GrammarAST r10);
}
