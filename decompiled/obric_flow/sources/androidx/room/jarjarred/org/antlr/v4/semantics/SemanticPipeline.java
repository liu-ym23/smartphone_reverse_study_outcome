package androidx.room.jarjarred.org.antlr.v4.semantics;

import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import androidx.room.jarjarred.org.antlr.v4.automata.LexerATNFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SemanticPipeline {
    public Grammar g;

    public SemanticPipeline(Grammar r5) {
        this.g = r5;
    }

    public void assignChannelTypes(Grammar r10, List<GrammarAST> r11) {
        Grammar r12 = r10.getOutermostGrammar();
        Iterator<GrammarAST> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L17;
        GrammarAST r5 = r13.next();
        String r14 = r5.getText();
        if (r10.getTokenType(r14) == 0) goto L9;
        r10.tool.errMgr.grammarError(ErrorType.CHANNEL_CONFLICTS_WITH_TOKEN, r10.fileName, r5.token, new Object[]{r14});
    L9:
        if (LexerATNFactory.COMMON_CONSTANTS.containsKey(r14) == false) goto L12;
        r10.tool.errMgr.grammarError(ErrorType.CHANNEL_CONFLICTS_WITH_COMMON_CONSTANTS, r10.fileName, r5.token, new Object[]{r14});
    L12:
        if ((r12 instanceof LexerGrammar) == false) goto L16;
        if (((LexerGrammar) r12).modes.containsKey(r14) == false) goto L16;
        r10.tool.errMgr.grammarError(ErrorType.CHANNEL_CONFLICTS_WITH_MODE, r10.fileName, r5.token, new Object[]{r14});
    L16:
        r12.defineChannelName(r5.getText());
        goto L4
    }

    public void assignLexerTokenTypes(Grammar r5, List<GrammarAST> r10) {
        Grammar r11 = r5.getOutermostGrammar();
        Iterator<GrammarAST> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        GrammarAST r13 = r12.next();
        if (Grammar.isTokenName(r13.getText()) == false) goto L4;
        r11.defineTokenName(r13.getText());
        goto L4
    L8:
        Iterator<Rule> r14 = r5.rules.values().iterator();
    L10:
        if (r14.hasNext() == false) goto L16;
        Rule r15 = r14.next();
        if (r15.isFragment() == true) goto L10;
        if (hasTypeOrMoreCommand(r15) == true) goto L10;
        r11.defineTokenName(r15.name);
        goto L10
    L16:
        List<Pair<GrammarAST, GrammarAST>> r16 = Grammar.getStringLiteralAliasesFromLexerRules(r5.ast);
        HashSet r17 = new HashSet();
        if (r16 == null) goto L37;
        Iterator<Pair<GrammarAST, GrammarAST>> r18 = r16.iterator();
    L20:
        if (r18.hasNext() == false) goto L25;
        Pair<GrammarAST, GrammarAST> r19 = r18.next();
        GrammarAST r20 = r19.f667a;
        GrammarAST r21 = r19.f668b;
        if (r11.stringLiteralToTypeMap.containsKey(r21.getText()) == false) goto L23;
        r17.add(r21.getText());
        goto L20
    L23:
        r11.defineTokenAlias(r20.getText(), r21.getText());
        goto L20
    L25:
        Iterator r22 = r17.iterator();
    L27:
        if (r22.hasNext() == false) goto L67;
        String r23 = (String) r22.next();
        Integer r24 = r11.stringLiteralToTypeMap.remove(r23);
        if (r24 == null) goto L27;
        if (r24.intValue() <= 0) goto L27;
        if (r24.intValue() >= r11.typeToStringLiteralList.size()) goto L27;
        if (r23.equals(r11.typeToStringLiteralList.get(r24.intValue())) == false) goto L27;
        r11.typeToStringLiteralList.set(r24.intValue(), null);
        goto L27
    L67:
        return;
    }

    public void assignTokenTypes(Grammar r10, List<GrammarAST> r11, List<GrammarAST> r12, List<GrammarAST> r13) {
        Iterator<GrammarAST> r5 = r11.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        GrammarAST r14 = r5.next();
        if (r10.getTokenType(r14.getText()) == 0) goto L8;
        r10.tool.errMgr.grammarError(ErrorType.TOKEN_NAME_REASSIGNMENT, r10.fileName, r14.token, new Object[]{r14.getText()});
    L8:
        r10.defineTokenName(r14.getText());
        goto L4
    L9:
        Iterator<GrammarAST> r15 = r12.iterator();
    L11:
        if (r15.hasNext() == false) goto L16;
        GrammarAST r16 = r15.next();
        if (r10.getTokenType(r16.getText()) != 0) goto L15;
        r10.tool.errMgr.grammarError(ErrorType.IMPLICIT_TOKEN_DEFINITION, r10.fileName, r16.token, new Object[]{r16.getText()});
    L15:
        r10.defineTokenName(r16.getText());
        goto L11
    L16:
        Iterator<GrammarAST> r17 = r13.iterator();
    L18:
        if (r17.hasNext() == false) goto L25;
        GrammarAST r18 = r17.next();
        if (r18.getType() != 62) goto L18;
        if (r10.getTokenType(r18.getText()) != 0) goto L18;
        r10.tool.errMgr.grammarError(ErrorType.IMPLICIT_STRING_DEFINITION, r10.fileName, r18.token, new Object[]{r18.getText()});
        goto L18
    L25:
        r10.tool.log("semantics", "tokens=" + r10.tokenNameToTypeMap);
        r10.tool.log("semantics", "strings=" + r10.stringLiteralToTypeMap);
    }

    public boolean hasTypeOrMoreCommand(Rule r10) {
        RuleAST r5 = r10.ast;
        if (r5 != null) goto L5;
        return false;
    L5:
        GrammarAST r11 = (GrammarAST) r5.getFirstDescendantWithType(87);
        if (r11 != null) goto L8;
        return false;
    L8:
        int r12 = 1;
    L10:
        if (r12 >= r11.getChildCount()) goto L20;
        GrammarAST r13 = (GrammarAST) r11.getChild(r12);
        if (r13.getType() != 86) goto L17;
        if ("type".equals(r13.getChild(0).getText()) == false) goto L19;
        return true;
    L19:
        r12 = r12 + 1;
        goto L10
    L17:
        if ("more".equals(r13.getText()) == false) goto L19;
        return true;
    L20:
        return false;
    }

    public void identifyStartRules(SymbolCollector r5) {
        Iterator<GrammarAST> r10 = r5.rulerefs.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        String r11 = r10.next().getText();
        Rule r12 = this.g.getRule(r11);
        if (r12 == null) goto L4;
        r12.isStartRule = false;
        goto L4
    }

    public void process() {
        if (this.g.ast != null) goto L5;
        return;
    L5:
        RuleCollector r5 = new RuleCollector(this.g);
        r5.process(this.g.ast);
        int r10 = this.g.tool.errMgr.getNumErrors();
        new BasicSemanticChecks(this.g, r5).process();
        if (this.g.tool.errMgr.getNumErrors() <= r10) goto L8;
        return;
    L8:
        int r11 = this.g.tool.errMgr.getNumErrors();
        new LeftRecursiveRuleTransformer(this.g.ast, r5.rules.values(), this.g).translateLeftRecursiveRules();
        if (this.g.tool.errMgr.getNumErrors() <= r11) goto L11;
        return;
    L11:
        Iterator<Rule> r12 = r5.rules.values().iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        Rule r13 = r12.next();
        this.g.defineRule(r13);
        goto L13
    L15:
        SymbolCollector r14 = new SymbolCollector(this.g);
        r14.process(this.g.ast);
        SymbolChecks r15 = new SymbolChecks(this.g, r14);
        r15.process();
        Iterator<GrammarAST> r16 = r14.namedActions.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        GrammarAST r17 = r16.next();
        this.g.defineAction(r17);
        goto L17
    L19:
        Iterator<Rule> r18 = this.g.rules.values().iterator();
    L21:
        if (r18.hasNext() == false) goto L26;
        Rule r19 = r18.next();
        int r20 = 1;
    L24:
        if (r20 > r19.numberOfAlts) goto L21;
        Alternative r21 = r19.alt[r20];
        r21.ast.alt = r21;
        r20 = r20 + 1;
        goto L24
    L26:
        this.g.importTokensFromTokensFile();
        if (this.g.isLexer() == false) goto L29;
        assignLexerTokenTypes(this.g, r14.tokensDefs);
    L30:
        r15.checkForModeConflicts(this.g);
        r15.checkForUnreachableTokens(this.g);
        assignChannelTypes(this.g, r14.channelDefs);
        r15.checkRuleArgs(this.g, r14.rulerefs);
        identifyStartRules(r14);
        r15.checkForQualifiedRuleIssues(this.g, r14.qualifiedRulerefs);
        if (this.g.tool.getNumErrors() <= 0) goto L33;
        return;
    L33:
        AttributeChecks.checkAllAttributeExpressions(this.g);
        UseDefAnalyzer.trackTokenRuleRefsInActions(this.g);
        return;
    L29:
        assignTokenTypes(this.g, r14.tokensDefs, r14.tokenIDRefs, r14.terminals);
        goto L30
    }
}
