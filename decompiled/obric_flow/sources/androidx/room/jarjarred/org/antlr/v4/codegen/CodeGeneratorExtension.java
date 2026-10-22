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
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CodeGeneratorExtension {
    public OutputModelFactory factory;

    public CodeGeneratorExtension(OutputModelFactory r5) {
        this.factory = r5;
    }

    public List<SrcOp> action(List<SrcOp> r5) {
        return r5;
    }

    public CodeBlockForAlt alternative(CodeBlockForAlt r5, boolean r10) {
        return r5;
    }

    public CodeBlockForAlt epsilon(CodeBlockForAlt r5) {
        return r5;
    }

    public CodeBlockForAlt finishAlternative(CodeBlockForAlt r5, boolean r10) {
        return r5;
    }

    public Choice getChoiceBlock(Choice r5) {
        return r5;
    }

    public Choice getEBNFBlock(Choice r5) {
        return r5;
    }

    public Lexer lexer(Lexer r5) {
        return r5;
    }

    public LexerFile lexerFile(LexerFile r5) {
        return r5;
    }

    public boolean needsImplicitLabel(GrammarAST r5, LabeledOp r10) {
        return false;
    }

    public Parser parser(Parser r5) {
        return r5;
    }

    public ParserFile parserFile(ParserFile r5) {
        return r5;
    }

    public RuleFunction rule(RuleFunction r5) {
        return r5;
    }

    public List<SrcOp> rulePostamble(List<SrcOp> r5) {
        return r5;
    }

    public List<SrcOp> ruleRef(List<SrcOp> r5) {
        return r5;
    }

    public List<SrcOp> sempred(List<SrcOp> r5) {
        return r5;
    }

    public List<SrcOp> set(List<SrcOp> r5) {
        return r5;
    }

    public List<SrcOp> stringRef(List<SrcOp> r5) {
        return r5;
    }

    public List<SrcOp> tokenRef(List<SrcOp> r5) {
        return r5;
    }

    public List<SrcOp> wildcard(List<SrcOp> r5) {
        return r5;
    }
}
