package androidx.room.jarjarred.org.antlr.v4.analysis;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.misc.OrderedHashMap;
import androidx.room.jarjarred.org.antlr.v4.parse.ANTLRLexer;
import androidx.room.jarjarred.org.antlr.v4.parse.ANTLRParser;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.parse.ScopeParser;
import androidx.room.jarjarred.org.antlr.v4.parse.ToolANTLRParser;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.semantics.BasicSemanticChecks;
import androidx.room.jarjarred.org.antlr.v4.semantics.RuleCollector;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeDict;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.GrammarTransformPipeline;
import androidx.room.jarjarred.org.antlr.v4.tool.LabelElementPair;
import androidx.room.jarjarred.org.antlr.v4.tool.LeftRecursiveRule;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarRootAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class LeftRecursiveRuleTransformer {
    public static final String PRECEDENCE_OPTION_NAME = "p";
    public static final String TOKENINDEX_OPTION_NAME = "tokenIndex";
    public GrammarRootAST ast;
    public Grammar g;
    public Collection<Rule> rules;
    public Tool tool;

    public LeftRecursiveRuleTransformer(GrammarRootAST r5, Collection<Rule> r10, Grammar r11) {
        this.ast = r5;
        this.rules = r10;
        this.g = r11;
        this.tool = r11.tool;
    }

    public RuleAST parseArtificialRule(Grammar r5, String r10) {
        ANTLRLexer r11 = new ANTLRLexer(new ANTLRStringStream(r10));
        GrammarASTAdaptor r12 = new GrammarASTAdaptor(r11.getCharStream());
        CommonTokenStream r13 = new CommonTokenStream(r11);
        r11.tokens = r13;
        ToolANTLRParser r14 = new ToolANTLRParser(r13, this.tool);
        r14.setTreeAdaptor(r12);
        ANTLRParser.rule_return r15 = r14.rule();     // Catch: Exception -> L8
        RuleAST r16 = (RuleAST) r15.getTree();     // Catch: Exception -> L8
        Token r17 = (Token) r15.getStart();     // Catch: Exception -> L8
        GrammarTransformPipeline.setGrammarPtr(r5, r16);     // Catch: Exception -> L6
        GrammarTransformPipeline.augmentTokensWithOriginalPosition(r5, r16);     // Catch: Exception -> L6
        return r16;
    L6:
        e = e;
    L10:
        this.tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, e, new Object[]{r17, j0.C("error parsing rule created during left-recursion detection: ", r10)});
        return null;
    L8:
        e = e;
        r17 = null;
        goto L10
    }

    public void setAltASTPointers(LeftRecursiveRule r5, RuleAST r10) {
        BlockAST r11 = (BlockAST) r10.getFirstChildWithType(78);
        int r12 = 0;
        AltAST r13 = (AltAST) r11.getChild(0);
        BlockAST r14 = (BlockAST) r13.getChild(0);
        BlockAST r15 = (BlockAST) r13.getChild(1).getChild(0);
        int r16 = 0;
    L4:
        if (r16 >= r5.recPrimaryAlts.size()) goto L7;
        LeftRecursiveRuleAltInfo r17 = r5.recPrimaryAlts.get(r16);
        AltAST r18 = (AltAST) r14.getChild(r16);
        r17.altAST = r18;
        r18.leftRecursiveAltInfo = r17;
        r17.originalAltAST.leftRecursiveAltInfo = r17;
        r16 = r16 + 1;
    L7:
        if (r12 >= r5.recOpAlts.size()) goto L9;
        LeftRecursiveRuleAltInfo r19 = r5.recOpAlts.getElement(r12);
        AltAST r20 = (AltAST) r15.getChild(r12);
        r19.altAST = r20;
        r20.leftRecursiveAltInfo = r19;
        r19.originalAltAST.leftRecursiveAltInfo = r19;
        r12 = r12 + 1;
        goto L7
    }

    public boolean translateLeftRecursiveRule(GrammarRootAST r10, LeftRecursiveRule r11, String r12) {
        RuleAST r5 = r11.ast;
        LeftRecursiveRuleAnalyzer r13 = new LeftRecursiveRuleAnalyzer(r5, this.tool, r5.getChild(0).getText(), r12);
        boolean r14 = r13.rec_rule();     // Catch: RecognitionException -> L5
    L6:
        if (r14 == true) goto L8;
        return false;
    L8:
        GrammarAST r15 = (GrammarAST) r10.getFirstChildWithType(97);
        RuleAST r16 = parseArtificialRule(r5.g, r13.getArtificialOpPrecRule());
        ((GrammarAST) r16.getChild(0)).token = ((GrammarAST) r5.getChild(0)).getToken();
        r15.setChild(r5.getChildIndex(), r16);
        r11.ast = r16;
        Grammar r17 = this.g;
        GrammarTransformPipeline r18 = new GrammarTransformPipeline(r17, r17.tool);
        r18.reduceBlocksToSets(r11.ast);
        r18.expandParameterizedLoops(r11.ast);
        RuleCollector r19 = new RuleCollector(this.g);
        r19.visit(r16, "rule");
        BasicSemanticChecks r20 = new BasicSemanticChecks(this.g, r19);
        r20.checkAssocElementOption = false;
        r20.visit(r16, "rule");
        ArrayList r21 = new ArrayList();
        r11.recPrimaryAlts = r21;
        r21.addAll(r13.prefixAndOtherAlts);
        if (r11.recPrimaryAlts.isEmpty() == false) goto L11;
        this.tool.errMgr.grammarError(ErrorType.NO_NON_LR_ALTS, this.g.fileName, ((GrammarAST) r11.ast.getChild(0)).getToken(), new Object[]{r11.name});
    L11:
        OrderedHashMap<Integer, LeftRecursiveRuleAltInfo> r22 = new OrderedHashMap();
        r11.recOpAlts = r22;
        r22.putAll(r13.binaryAlts);
        r11.recOpAlts.putAll(r13.ternaryAlts);
        r11.recOpAlts.putAll(r13.suffixAlts);
        setAltASTPointers(r11, r16);
        ActionAST r23 = (ActionAST) r11.ast.getFirstChildWithType(8);
        if (r23 == null) goto L14;
        AttributeDict r24 = ScopeParser.parseTypedArgList(r23, r23.getText(), this.g);
        r11.args = r24;
        r24.type = AttributeDict.DictType.ARG;
        r24.ast = r23;
        r23.resolver = r11.alt[1];
    L14:
        Iterator<Pair<GrammarAST, String>> r25 = r13.leftRecursiveRuleRefLabels.iterator();
    L16:
        if (r25.hasNext() == false) goto L18;
        GrammarAST r26 = r25.next().f667a;
        GrammarAST r27 = (GrammarAST) r26.getParent();
        r11.alt[1].labelDefs.map(r26.getText(), new LabelElementPair(this.g, r26, (GrammarAST) r27.getChild(1), r27.getType()));
        goto L16
    L18:
        r11.leftRecursiveRuleRefLabels = r13.leftRecursiveRuleRefLabels;
        this.tool.log("grammar", "added: " + r16.toStringTree());
        return true;
    L5:
        r14 = false;
        goto L6
    }

    public void translateLeftRecursiveRules() {
        String r5 = this.g.getOptionString("language");
        ArrayList r10 = new ArrayList();
        Iterator<Rule> r11 = this.rules.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        Rule r12 = r11.next();
        if (Grammar.isTokenName(r12.name) == true) goto L4;
        if (LeftRecursiveRuleAnalyzer.hasImmediateRecursiveRuleRefs(r12.ast, r12.name) == false) goto L4;
        if (translateLeftRecursiveRule(this.ast, (LeftRecursiveRule) r12, r5) == true) goto L11;
        this.tool.errMgr.grammarError(ErrorType.NONCONFORMING_LR_RULE, this.g.fileName, ((GrammarAST) r12.ast.getChild(0)).token, new Object[]{r12.name});
        goto L4
    L11:
        r10.add(r12.name);
        goto L4
    L13:
        Iterator<GrammarAST> r13 = this.ast.getNodesWithType(57).iterator();
    L15:
        if (r13.hasNext() == false) goto L25;
        GrammarAST r14 = r13.next();
        if (r14.getParent().getType() == 94) goto L15;
        GrammarASTWithOptions r15 = (GrammarASTWithOptions) r14;
        if (r15.getOptionString(PRECEDENCE_OPTION_NAME) != null) goto L15;
        if (r10.contains(r14.getText()) == false) goto L15;
        r15.setOption(PRECEDENCE_OPTION_NAME, (GrammarAST) new GrammarASTAdaptor().create(30, "0"));
        goto L15
    }
}
