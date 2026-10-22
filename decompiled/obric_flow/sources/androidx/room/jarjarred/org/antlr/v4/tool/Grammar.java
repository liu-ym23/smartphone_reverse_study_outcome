package androidx.room.jarjarred.org.antlr.v4.tool;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeVisitor;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeWizard;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory;
import androidx.room.jarjarred.org.antlr.v4.misc.CharSupport;
import androidx.room.jarjarred.org.antlr.v4.misc.OrderedHashMap;
import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.parse.ANTLRParser;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.parse.TokenVocabParser;
import androidx.room.jarjarred.org.antlr.v4.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.LexerInterpreter;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserInterpreter;
import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNDeserializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSerializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SemanticContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarRootAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Grammar implements AttributeResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String AUTO_GENERATED_TOKEN_NAME_PREFIX = "T__";
    public static final String GRAMMAR_FROM_STRING_NAME = "<string>";
    public static final String INVALID_RULE_NAME = "<invalid>";
    public static final String INVALID_TOKEN_NAME = "<INVALID>";
    public static final Set<String> LexerBlockOptions = null;
    public static final Set<String> ParserBlockOptions = null;
    public static final Set<String> actionOptions = null;
    public static final Set<String> doNotCopyOptionsToLexer = null;
    public static final Map<String, AttributeDict> grammarAndLabelRefTypeToScope = null;
    public static final Set<String> lexerOptions = null;
    public static final Set<String> parserOptions = null;
    public static final Set<String> ruleOptions = null;
    public static final Set<String> ruleRefOptions = null;
    public static final Set<String> semPredOptions = null;
    public static final Set<String> tokenOptions = null;
    public GrammarRootAST ast;
    public ATN atn;
    public final Map<String, Integer> channelNameToValueMap;
    public final List<String> channelValueToNameList;
    public Map<Integer, DFA> decisionDFAs;
    public List<IntervalSet[]> decisionLOOK;
    public String fileName;
    public LexerGrammar implicitLexer;
    public List<Grammar> importedGrammars;
    public LinkedHashMap<Integer, PredAST> indexToPredMap;
    public List<Rule> indexToRule;
    public LinkedHashMap<ActionAST, Integer> lexerActions;
    int maxChannelType;
    int maxTokenType;
    public String name;
    public Map<String, ActionAST> namedActions;
    public Grammar originalGrammar;
    public TokenStream originalTokenStream;
    public Grammar parent;
    int ruleNumber;
    public OrderedHashMap<String, Rule> rules;
    public LinkedHashMap<PredAST, Integer> sempreds;
    public Map<Integer, Interval> stateToGrammarRegionMap;
    int stringLiteralRuleNumber;
    public final Map<String, Integer> stringLiteralToTypeMap;
    public String text;
    public final Map<String, Integer> tokenNameToTypeMap;
    public final TokenStream tokenStream;
    public final Tool tool;
    public final List<String> typeToStringLiteralList;
    public final List<String> typeToTokenList;

    static {
        HashSet r5 = new HashSet();
        parserOptions = r5;
        r5.add("superClass");
        r5.add("contextSuperClass");
        r5.add("TokenLabelType");
        r5.add("tokenVocab");
        r5.add("language");
        r5.add("accessLevel");
        r5.add("exportMacro");
        lexerOptions = r5;
        ruleOptions = new HashSet();
        ParserBlockOptions = new HashSet();
        LexerBlockOptions = new HashSet();
        HashSet r10 = new HashSet();
        ruleRefOptions = r10;
        r10.add(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        r10.add(LeftRecursiveRuleTransformer.TOKENINDEX_OPTION_NAME);
        HashSet r11 = new HashSet();
        tokenOptions = r11;
        r11.add("assoc");
        r11.add(LeftRecursiveRuleTransformer.TOKENINDEX_OPTION_NAME);
        actionOptions = new HashSet();
        HashSet r12 = new HashSet();
        semPredOptions = r12;
        r12.add(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        r12.add("fail");
        HashSet r13 = new HashSet();
        doNotCopyOptionsToLexer = r13;
        r13.add("superClass");
        r13.add("TokenLabelType");
        r13.add("tokenVocab");
        HashMap r14 = new HashMap();
        grammarAndLabelRefTypeToScope = r14;
        AttributeDict r15 = Rule.predefinedRulePropertiesDict;
        r14.put("parser:RULE_LABEL", r15);
        AttributeDict r16 = AttributeDict.predefinedTokenDict;
        r14.put("parser:TOKEN_LABEL", r16);
        r14.put("combined:RULE_LABEL", r15);
        r14.put("combined:TOKEN_LABEL", r16);
    }

    public Grammar(Tool r5, GrammarRootAST r10) {
        this.rules = new OrderedHashMap();
        this.indexToRule = new ArrayList();
        this.ruleNumber = 0;
        this.stringLiteralRuleNumber = 0;
        this.decisionDFAs = new HashMap();
        this.maxTokenType = 0;
        this.tokenNameToTypeMap = new LinkedHashMap();
        this.stringLiteralToTypeMap = new LinkedHashMap();
        this.typeToStringLiteralList = new ArrayList();
        this.typeToTokenList = new ArrayList();
        this.maxChannelType = 1;
        this.channelNameToValueMap = new LinkedHashMap();
        this.channelValueToNameList = new ArrayList();
        this.namedActions = new HashMap();
        this.lexerActions = new LinkedHashMap();
        this.sempreds = new LinkedHashMap();
        if (r10 == null) goto L11;
        if (r10.tokenStream == null) goto L9;
        this.tool = r5;
        this.ast = r10;
        this.name = r10.getChild(0).getText();
        TokenStream r11 = r10.tokenStream;
        this.tokenStream = r11;
        this.originalTokenStream = r11;
        initTokenSymbolTables();
        return;
    L9:
        throw new IllegalArgumentException("ast must have a token stream");
    L11:
        throw new NullPointerException("ast");
    }

    public static boolean defAlias(GrammarAST r5, String r10, TreeWizard r11, List<Pair<GrammarAST, GrammarAST>> r12) {
        HashMap r13 = new HashMap();
        if (r11.parse(r5, r10, r13) == false) goto L6;
        GrammarAST r14 = (GrammarAST) r13.get("lit");
        r12.add(new Pair((GrammarAST) r13.get("name"), r14));
        return true;
    L6:
        return false;
    }

    public static String getGrammarTypeToFileNameSuffix(int r5) {
        if (r5 != 31) goto L5;
        return "Lexer";
    L5:
        if (r5 != 44) goto L7;
    L10:
        return "Parser";
    L7:
        if (r5 == 81) goto L10;
        return INVALID_RULE_NAME;
    }

    public static Map<Integer, Interval> getStateToGrammarRegionMap(GrammarRootAST r10, IntervalSet r11) {
        HashMap r5 = new HashMap();
        if (r10 != null) goto L5;
        return r5;
    L5:
        Iterator<GrammarAST> r12 = r10.getNodesWithType(r11).iterator();
    L7:
        if (r12.hasNext() == false) goto L24;
        GrammarAST r13 = r12.next();
        if (r13.atnState == null) goto L7;
        Interval r14 = Interval.of(r13.getTokenStartIndex(), r13.getTokenStopIndex());
        int r15 = r13.getType();
        if (r15 != 78) goto L13;
    L17:
        Tree r16 = r13.getAncestor(94);
    L19:
        if ((r16 instanceof RuleAST) == false) goto L23;
        String r17 = ((RuleAST) r16).getRuleName();
        Rule r18 = r10.g.getRule(r17);
        if ((r18 instanceof LeftRecursiveRule) == false) goto L23;
        RuleAST r19 = ((LeftRecursiveRule) r18).getOriginalAST();
        r14 = Interval.of(r19.getTokenStartIndex(), r19.getTokenStopIndex());
    L23:
        r5.put(Integer.valueOf(r13.atnState.stateNumber), r14);
        goto L7
    L13:
        if (r15 == 80) goto L17;
        if (r15 == 94) goto L16;
        r16 = null;
        goto L19
    L16:
        r16 = r13;
        goto L19
    L24:
        return r5;
    }

    public static List<Pair<GrammarAST, GrammarAST>> getStringLiteralAliasesFromLexerRules(GrammarRootAST r10) {
        String[] r5 = {"(RULE %name:TOKEN_REF (BLOCK (ALT %lit:STRING_LITERAL)))", "(RULE %name:TOKEN_REF (BLOCK (ALT %lit:STRING_LITERAL ACTION)))", "(RULE %name:TOKEN_REF (BLOCK (ALT %lit:STRING_LITERAL SEMPRED)))", "(RULE %name:TOKEN_REF (BLOCK (LEXER_ALT_ACTION (ALT %lit:STRING_LITERAL) .)))", "(RULE %name:TOKEN_REF (BLOCK (LEXER_ALT_ACTION (ALT %lit:STRING_LITERAL) . .)))", "(RULE %name:TOKEN_REF (BLOCK (LEXER_ALT_ACTION (ALT %lit:STRING_LITERAL) (LEXER_ACTION_CALL . .))))", "(RULE %name:TOKEN_REF (BLOCK (LEXER_ALT_ACTION (ALT %lit:STRING_LITERAL) . (LEXER_ACTION_CALL . .))))", "(RULE %name:TOKEN_REF (BLOCK (LEXER_ALT_ACTION (ALT %lit:STRING_LITERAL) (LEXER_ACTION_CALL . .) .)))"};
        TreeWizard r11 = new TreeWizard(new GrammarASTAdaptor(r10.token.getInputStream()), ANTLRParser.tokenNames);
        ArrayList r12 = new ArrayList();
        List<GrammarAST> r13 = r10.getNodesWithType(94);
        if (r13 != null) goto L5;
        return null;
    L5:
        if (r13.isEmpty() == true) goto L27;
        Iterator<GrammarAST> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L18;
        GrammarAST r15 = r14.next();
        int r16 = 0;
        if (r15.getChild(0).getType() != 66) goto L9;
    L13:
        if (r16 >= 8) goto L9;
        if (defAlias(r15, r5[r16], r11, r12) == true) goto L9;
        r16 = r16 + 1;
        goto L13
    L18:
        return r12;
    L27:
        return null;
    }

    public static boolean isTokenName(String r5) {
        return Character.isUpperCase(r5.charAt(0));
    }

    public static Grammar load(String r5) {
        return new Tool().loadGrammar(r5);
    }

    public static void setNodeOptions(GrammarAST r5, GrammarAST r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        GrammarASTWithOptions r11 = (GrammarASTWithOptions) r5;
        if (r11.getChildCount() != 0) goto L7;
        return;
    L7:
        if (r10.getChildCount() == 0) goto L23;
        Iterator<? extends Object> r12 = r10.getChildren().iterator();
    L11:
        if (r12.hasNext() == false) goto L24;
        GrammarAST r13 = (GrammarAST) r12.next();
        if (r13.getType() == 10) goto L14;
        r11.setOption(r13.getText(), null);
        goto L11
    L14:
        r11.setOption(r13.getChild(0).getText(), (GrammarAST) r13.getChild(1));
        goto L11
    L24:
        return;
    }

    public GrammarParserInterpreter createGrammarParserInterpreter(androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream r5) {
        if (isLexer() == true) goto L7;
        char[] r10 = ATNSerializer.getSerializedAsChars(this.atn);
        return new GrammarParserInterpreter(this, new ATNDeserializer().deserialize(r10), r5);
    L7:
        throw new IllegalStateException("A parser interpreter can only be created for a parser or combined grammar.");
    }

    public LexerInterpreter createLexerInterpreter(CharStream r11) {
        if (isParser() == true) goto L11;
        if (isCombined() == true) goto L7;
        char[] r5 = ATNSerializer.getSerializedAsChars(this.atn);
        ATN r10 = new ATNDeserializer().deserialize(r5);
        ArrayList r12 = new ArrayList();
        r12.add("DEFAULT_TOKEN_CHANNEL");
        r12.add("HIDDEN");
        r12.addAll(this.channelValueToNameList);
        return new LexerInterpreter(this.fileName, getVocabulary(), Arrays.asList(getRuleNames()), r12, ((LexerGrammar) this).modes.keySet(), r10, r11);
    L7:
        return this.implicitLexer.createLexerInterpreter(r11);
    L11:
        throw new IllegalStateException("A lexer interpreter can only be created for a lexer or combined grammar.");
    }

    public ParserInterpreter createParserInterpreter(androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream r10) {
        if (isLexer() == true) goto L7;
        char[] r5 = ATNSerializer.getSerializedAsChars(this.atn);
        ATN r11 = new ATNDeserializer().deserialize(r5);
        return new ParserInterpreter(this.fileName, getVocabulary(), Arrays.asList(getRuleNames()), r11, r10);
    L7:
        throw new IllegalStateException("A parser interpreter can only be created for a parser or combined grammar.");
    }

    public void defineAction(GrammarAST r10) {
        if (r10.getChildCount() != 2) goto L5;
        String r5 = r10.getChild(0).getText();
        this.namedActions.put(r5, (ActionAST) r10.getChild(1));
        return;
    L5:
        String r11 = r10.getChild(0).getText();
        String r12 = getTypeString();
        if (r11.equals(r12) == false) goto L8;
    L11:
        String r13 = r10.getChild(1).getText();
        this.namedActions.put(r13, (ActionAST) r10.getChild(2));
        return;
    L8:
        if (r11.equals("parser") == true) goto L10;
        return;
    L10:
        if (r12.equals("combined") == true) goto L11;
    }

    public int defineChannelName(String r5) {
        Integer r10 = this.channelNameToValueMap.get(r5);
        if (r10 != null) goto L7;
        return defineChannelName(r5, getNewChannelNumber());
    L7:
        return r10.intValue();
    }

    public boolean defineRule(Rule r5) {
        if (this.rules.get(r5.name) == null) goto L6;
        return false;
    L6:
        this.rules.put(r5.name, r5);
        int r10 = this.ruleNumber;
        this.ruleNumber = r10 + 1;
        r5.index = r10;
        this.indexToRule.add(r5);
        return true;
    }

    public int defineStringLiteral(String r5) {
        if (this.stringLiteralToTypeMap.containsKey(r5) == false) goto L7;
        return this.stringLiteralToTypeMap.get(r5).intValue();
    L7:
        return defineStringLiteral(r5, getNewTokenType());
    }

    public int defineTokenAlias(String r5, String r10) {
        int r11 = defineTokenName(r5);
        this.stringLiteralToTypeMap.put(r10, Integer.valueOf(r11));
        setTokenForType(r11, r5);
        return r11;
    }

    public int defineTokenName(String r5) {
        Integer r10 = this.tokenNameToTypeMap.get(r5);
        if (r10 != null) goto L7;
        return defineTokenName(r5, getNewTokenType());
    L7:
        return r10.intValue();
    }

    public ATN getATN() {
        if (this.atn != null) goto L6;
        this.atn = new ParserATNFactory(this).createATN();
    L6:
        return this.atn;
    }

    public IntSet getAllCharValues() {
        return IntervalSet.of(0, getMaxCharValue());
    }

    public List<Grammar> getAllImportedGrammars() {
        if (this.importedGrammars != null) goto L6;
        return null;
    L6:
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Grammar> r10 = this.importedGrammars.iterator();
    L8:
        if (r10.hasNext() == false) goto L16;
        Grammar r11 = r10.next();
        r5.put(r11.fileName, r11);
        List<Grammar> r12 = r11.getAllImportedGrammars();
        if (r12 == null) goto L8;
        Iterator<Grammar> r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L8;
        Grammar r14 = r13.next();
        r5.put(r14.fileName, r14);
        goto L13
    L16:
        return new ArrayList(r5.values());
    }

    public int getChannelValue(String r5) {
        Integer r10 = this.channelNameToValueMap.get(r5);
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.intValue();
    }

    public String getDefaultActionScope() {
        int r5 = getType();
        if (r5 != 31) goto L5;
        return "lexer";
    L5:
        if (r5 != 44) goto L7;
        return "parser";
    L7:
        if (r5 == 81) goto L14;
        return null;
    L14:
        return "parser";
    }

    public List<Grammar> getGrammarAncestors() {
        if (this != getOutermostGrammar()) goto L6;
        return null;
    L6:
        ArrayList r5 = new ArrayList();
        Grammar r10 = this.parent;
    L7:
        if (r10 == null) goto L9;
        r5.add(0, r10);
        r10 = r10.parent;
        goto L7
    L9:
        return r5;
    }

    public LexerGrammar getImplicitLexer() {
        return this.implicitLexer;
    }

    public Grammar getImportedGrammar(String r5) {
        Iterator<Grammar> r10 = this.importedGrammars.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Grammar r11 = r10.next();
        if (r11.name.equals(r5) == false) goto L4;
        return r11;
    L8:
        return null;
    }

    public List<Grammar> getImportedGrammars() {
        return this.importedGrammars;
    }

    public LinkedHashMap<Integer, PredAST> getIndexToPredicateMap() {
        LinkedHashMap<Integer, PredAST> r5 = new LinkedHashMap();
        Iterator<Rule> r10 = this.rules.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Iterator<ActionAST> r11 = r10.next().actions.iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        ActionAST r12 = r11.next();
        if ((r12 instanceof PredAST) == false) goto L7;
        PredAST r13 = (PredAST) r12;
        r5.put(this.sempreds.get(r13), r13);
        goto L7
    L11:
        return r5;
    }

    public int getMaxCharValue() {
        return Lexer.MAX_CHAR_VALUE;
    }

    public int getMaxTokenType() {
        return this.typeToTokenList.size() - 1;
    }

    public int getNewChannelNumber() {
        int r5 = this.maxChannelType + 1;
        this.maxChannelType = r5;
        return r5;
    }

    public int getNewTokenType() {
        int r5 = this.maxTokenType + 1;
        this.maxTokenType = r5;
        return r5;
    }

    public String getOptionString(String r5) {
        return this.ast.getOptionString(r5);
    }

    public Grammar getOutermostGrammar() {
        Grammar r5 = this.parent;
        if (r5 != null) goto L6;
        return this;
    L6:
        return r5.getOutermostGrammar();
    }

    public String getPredicateDisplayString(SemanticContext.Predicate r5) {
        if (this.indexToPredMap != null) goto L6;
        this.indexToPredMap = getIndexToPredicateMap();
    L6:
        return this.indexToPredMap.get(Integer.valueOf(r5.predIndex)).getText();
    }

    public String getRecognizerName() {
        List<Grammar> r5 = getOutermostGrammar().getGrammarAncestors();
        String r10 = this.name;
        if (r5 == null) goto L10;
        StringBuilder r11 = new StringBuilder();
        Iterator<Grammar> r12 = r5.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r11.append(r12.next().name);
        r11.append('_');
        goto L6
    L8:
        r11.append(this.name);
        r10 = r11.toString();
    L10:
        if (isCombined() == false) goto L12;
    L17:
        String r13 = getGrammarTypeToFileNameSuffix(getType());
    L19:
        return j0.j(r10, r13);
    L12:
        if (isLexer() == true) goto L14;
    L16:
        r13 = "";
        goto L19
    L14:
        if (this.implicitLexer == null) goto L16;
        goto L16
    }

    public Rule getRule(String r5) {
        Rule r10 = this.rules.get(r5);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return null;
    }

    public String[] getRuleNames() {
        String[] r5 = new String[this.rules.size()];
        Arrays.fill(r5, INVALID_RULE_NAME);
        Iterator<Rule> r10 = this.rules.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Rule r11 = r10.next();
        r5[r11.index] = r11.name;
        goto L4
    L6:
        return r5;
    }

    public String getSemanticContextDisplayString(SemanticContext r5) {
        if ((r5 instanceof SemanticContext.Predicate) == false) goto L7;
        return getPredicateDisplayString((SemanticContext.Predicate) r5);
    L7:
        if ((r5 instanceof SemanticContext.AND) == false) goto L11;
        return joinPredicateOperands((SemanticContext.AND) r5, " and ");
    L11:
        if ((r5 instanceof SemanticContext.OR) == false) goto L15;
        return joinPredicateOperands((SemanticContext.OR) r5, " or ");
    L15:
        return r5.toString();
    }

    public Interval getStateToGrammarRegion(int r5) {
        if (this.stateToGrammarRegionMap != null) goto L5;
        this.stateToGrammarRegionMap = getStateToGrammarRegionMap(this.ast, null);
    L5:
        Map<Integer, Interval> r10 = this.stateToGrammarRegionMap;
        if (r10 != null) goto L10;
        return Interval.INVALID;
    L10:
        return r10.get(Integer.valueOf(r5));
    }

    public String getStringLiteralLexerRuleName(String r5) {
        StringBuilder r10 = new StringBuilder(AUTO_GENERATED_TOKEN_NAME_PREFIX);
        int r11 = this.stringLiteralRuleNumber;
        this.stringLiteralRuleNumber = r11 + 1;
        r10.append(r11);
        return r10.toString();
    }

    public Set<String> getStringLiterals() {
        final LinkedHashSet r5 = new LinkedHashSet();
        new AnonymousClass3(this, r5).visitGrammar(this.ast);
        return r5;
    }

    public String getTokenDisplayName(int r5) {
        if (isLexer() == false) goto L10;
        if (r5 < 0) goto L10;
        if (r5 > 1114111) goto L10;
        return CharSupport.getANTLRCharLiteralForChar(r5);
    L10:
        if (r5 != (-1)) goto L13;
        return "EOF";
    L13:
        if (r5 != 0) goto L16;
        return INVALID_TOKEN_NAME;
    L16:
        if (r5 >= 0) goto L18;
    L23:
        if (r5 < 0) goto L31;
        if (r5 >= this.typeToTokenList.size()) goto L31;
        if (this.typeToTokenList.get(r5) == null) goto L31;
        return this.typeToTokenList.get(r5);
    L31:
        return String.valueOf(r5);
    L18:
        if (r5 >= this.typeToStringLiteralList.size()) goto L23;
        if (this.typeToStringLiteralList.get(r5) == null) goto L23;
        return this.typeToStringLiteralList.get(r5);
    }

    public String[] getTokenDisplayNames() {
        int r5 = getMaxTokenType() + 1;
        String[] r10 = new String[r5];
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r10[r11] = getTokenDisplayName(r11);
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    public String[] getTokenLiteralNames() {
        int r5 = getMaxTokenType() + 1;
        String[] r10 = new String[r5];
        int r11 = 0;
    L4:
        if (r11 >= Math.min(r5, this.typeToStringLiteralList.size())) goto L6;
        r10[r11] = this.typeToStringLiteralList.get(r11);
        r11 = r11 + 1;
        goto L4
    L6:
        Iterator<Map.Entry<String, Integer>> r12 = this.stringLiteralToTypeMap.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L16;
        Map.Entry<String, Integer> r13 = r12.next();
        if (r13.getValue().intValue() < 0) goto L8;
        if (r13.getValue().intValue() >= r5) goto L8;
        if (r10[r13.getValue().intValue()] != null) goto L8;
        r10[r13.getValue().intValue()] = r13.getKey();
        goto L8
    L16:
        return r10;
    }

    public String getTokenName(int r5) {
        if (isLexer() == false) goto L10;
        if (r5 < 0) goto L10;
        if (r5 > 1114111) goto L10;
        return CharSupport.getANTLRCharLiteralForChar(r5);
    L10:
        if (r5 != (-1)) goto L13;
        return "EOF";
    L13:
        if (r5 >= 0) goto L15;
        return INVALID_TOKEN_NAME;
    L15:
        if (r5 < this.typeToTokenList.size()) goto L17;
        return INVALID_TOKEN_NAME;
    L17:
        if (this.typeToTokenList.get(r5) != null) goto L19;
        return INVALID_TOKEN_NAME;
    L19:
        return this.typeToTokenList.get(r5);
    }

    public String[] getTokenNames() {
        int r5 = getMaxTokenType() + 1;
        String[] r10 = new String[r5];
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L5;
        r10[r11] = getTokenName(r11);
        r11 = r11 + 1;
        goto L3
    L5:
        return r10;
    }

    public TokenStream getTokenStream() {
        GrammarRootAST r5 = this.ast;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.tokenStream;
    }

    public String[] getTokenSymbolicNames() {
        int r5 = getMaxTokenType() + 1;
        String[] r10 = new String[r5];
        int r11 = 0;
    L4:
        if (r11 >= Math.min(r5, this.typeToTokenList.size())) goto L12;
        if (this.typeToTokenList.get(r11) == null) goto L11;
        if (this.typeToTokenList.get(r11).startsWith(AUTO_GENERATED_TOKEN_NAME_PREFIX) == true) goto L11;
        r10[r11] = this.typeToTokenList.get(r11);
    L11:
        r11 = r11 + 1;
        goto L4
    L12:
        return r10;
    }

    public int getTokenType(String r5) {
        if (r5.charAt(0) != '\'') goto L5;
        Integer r10 = this.stringLiteralToTypeMap.get(r5);
    L6:
        if (r10 != null) goto L8;
        return 0;
    L8:
        return r10.intValue();
    L5:
        r10 = this.tokenNameToTypeMap.get(r5);
        goto L6
    }

    public IntSet getTokenTypes() {
        if (isLexer() == false) goto L7;
        return getAllCharValues();
    L7:
        return IntervalSet.of(1, getMaxTokenType());
    }

    public int getType() {
        GrammarRootAST r5 = this.ast;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.grammarType;
    }

    public String getTypeString() {
        if (this.ast != null) goto L7;
        return null;
    L7:
        return ANTLRParser.tokenNames[getType()].toLowerCase();
    }

    public Vocabulary getVocabulary() {
        return new VocabularyImpl(getTokenLiteralNames(), getTokenSymbolicNames());
    }

    public void importTokensFromTokensFile() {
        if (getOptionString("tokenVocab") == null) goto L11;
        Map<String, Integer> r5 = new TokenVocabParser(this).load();
        this.tool.log("grammar", "tokens=" + r5);
        Iterator<String> r10 = r5.keySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L18;
        String r11 = r10.next();
        if (r11.charAt(0) == '\'') goto L9;
        defineTokenName(r11, r5.get(r11).intValue());
        goto L6
    L9:
        defineStringLiteral(r11, r5.get(r11).intValue());
        goto L6
    L18:
        return;
    }

    public void importVocab(Grammar r5) {
        Iterator<String> r10 = r5.tokenNameToTypeMap.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r11 = r10.next();
        defineTokenName(r11, r5.tokenNameToTypeMap.get(r11).intValue());
        goto L4
    L6:
        Iterator<String> r12 = r5.stringLiteralToTypeMap.keySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        String r13 = r12.next();
        defineStringLiteral(r13, r5.stringLiteralToTypeMap.get(r13).intValue());
        goto L8
    L10:
        Iterator<Map.Entry<String, Integer>> r14 = r5.channelNameToValueMap.entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        Map.Entry<String, Integer> r15 = r14.next();
        defineChannelName(r15.getKey(), r15.getValue().intValue());
        goto L12
    L14:
        Utils.setSize(this.typeToTokenList, Math.max(this.typeToTokenList.size(), r5.typeToTokenList.size()));
        int r16 = 0;
        int r17 = 0;
    L16:
        if (r17 >= r5.typeToTokenList.size()) goto L18;
        this.maxTokenType = Math.max(this.maxTokenType, r17);
        this.typeToTokenList.set(r17, r5.typeToTokenList.get(r17));
        r17 = r17 + 1;
        goto L16
    L18:
        Utils.setSize(this.channelValueToNameList, Math.max(this.channelValueToNameList.size(), r5.channelValueToNameList.size()));
    L20:
        if (r16 >= r5.channelValueToNameList.size()) goto L22;
        this.maxChannelType = Math.max(this.maxChannelType, r16);
        this.channelValueToNameList.set(r16, r5.channelValueToNameList.get(r16));
        r16 = r16 + 1;
        goto L20
    }

    public void initTokenSymbolTables() {
        this.tokenNameToTypeMap.put("EOF", -1);
        this.typeToTokenList.add(null);
    }

    public boolean isCombined() {
        if (getType() != 81) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLexer() {
        if (getType() != 31) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isParser() {
        if (getType() != 44) goto L5;
        return true;
    L5:
        return false;
    }

    public String joinPredicateOperands(SemanticContext.Operator r5, String r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator<SemanticContext> r12 = r5.getOperands().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        SemanticContext r13 = r12.next();
        if (r11.length() <= 0) goto L8;
        r11.append(r10);
    L8:
        r11.append(getSemanticContextDisplayString(r13));
        goto L4
    L10:
        return r11.toString();
    }

    public void loadImportedGrammars() {
        GrammarRootAST r5 = this.ast;
        if (r5 != null) goto L5;
        return;
    L5:
        GrammarAST r10 = (GrammarAST) r5.getFirstChildWithType(29);
        if (r10 != null) goto L8;
        return;
    L8:
        HashSet r11 = new HashSet();
        r11.add(this.name);
        this.importedGrammars = new ArrayList();
        Iterator<? extends Object> r12 = r10.getChildren().iterator();
    L10:
        if (r12.hasNext() == false) goto L26;
        GrammarAST r13 = (GrammarAST) r12.next();
        if (r13.getType() != 10) goto L15;
        r13 = (GrammarAST) r13.getChild(1);
        String r14 = r13.getText();
    L19:
        if (r11.contains(r14) == true) goto L10;
        Grammar r15 = this.tool.loadImportedGrammar(this, r13);     // Catch: IOException -> L25
        if (r15 == null) goto L10;
        r15.parent = this;
        this.importedGrammars.add(r15);
        r15.loadImportedGrammars();
    L25:
        this.tool.errMgr.grammarError(ErrorType.ERROR_READING_IMPORTED_GRAMMAR, r14, r13.getToken(), new Object[]{r14, this.name});
        goto L10
    L15:
        if (r13.getType() != 28) goto L17;
        r14 = r13.getText();
        goto L19
    L17:
        r14 = null;
        goto L19
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public Attribute resolveToAttribute(String r5, ActionAST r10) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToAttributeDict(String r5, ActionAST r10) {
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToLabel(String r5, ActionAST r10) {
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToListLabel(String r5, ActionAST r10) {
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToToken(String r5, ActionAST r10) {
        return false;
    }

    public void setChannelNameForValue(int r5, String r10) {
        if (r5 < this.channelValueToNameList.size()) goto L6;
        Utils.setSize(this.channelValueToNameList, r5 + 1);
    L6:
        if (this.channelValueToNameList.get(r5) != null) goto L9;
        this.channelValueToNameList.set(r5, r10);
        return;
    }

    public void setLookaheadDFA(int r5, DFA r10) {
        this.decisionDFAs.put(Integer.valueOf(r5), r10);
    }

    public void setTokenForType(int r5, String r10) {
        if (r5 != (-1)) goto L6;
        return;
    L6:
        if (r5 < this.typeToTokenList.size()) goto L8;
        Utils.setSize(this.typeToTokenList, r5 + 1);
    L8:
        String r11 = this.typeToTokenList.get(r5);
        if (r11 != null) goto L11;
    L12:
        this.typeToTokenList.set(r5, r10);
        return;
    L11:
        if (r11.charAt(0) == '\'') goto L12;
    }

    public boolean undefineRule(Rule r5) {
        int r10 = r5.index;
        if (r10 >= 0) goto L5;
        return false;
    L5:
        if (r10 < this.indexToRule.size()) goto L7;
        return false;
    L7:
        if (this.indexToRule.get(r5.index) != r5) goto L19;
        this.rules.remove(r5.name);
        this.indexToRule.remove(r5.index);
        int r11 = r5.index;
    L11:
        if (r11 >= this.indexToRule.size()) goto L13;
        this.indexToRule.get(r11).index--;
        r11 = r11 + 1;
        goto L11
    L13:
        this.ruleNumber--;
        return true;
    L19:
        return false;
    }

    public Rule getRule(int r5) {
        return this.indexToRule.get(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public Attribute resolveToAttribute(String r5, String r10, ActionAST r11) {
        return null;
    }

    public Rule getRule(String r5, String r10) {
        if (r5 == null) goto L10;
        Grammar r11 = getImportedGrammar(r5);
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.rules.get(r10);
    L10:
        return getRule(r10);
    }

    public int defineChannelName(String r5, int r10) {
        Integer r11 = this.channelNameToValueMap.get(r5);
        if (r11 != null) goto L5;
        this.channelNameToValueMap.put(r5, Integer.valueOf(r10));
        setChannelNameForValue(r10, r5);
        this.maxChannelType = Math.max(this.maxChannelType, r10);
        return r10;
    L5:
        return r11.intValue();
    }

    public int defineStringLiteral(String r5, int r10) {
        if (this.stringLiteralToTypeMap.containsKey(r5) == true) goto L9;
        this.stringLiteralToTypeMap.put(r5, Integer.valueOf(r10));
        if (r10 < this.typeToStringLiteralList.size()) goto L7;
        Utils.setSize(this.typeToStringLiteralList, r10 + 1);
    L7:
        this.typeToStringLiteralList.set(r10, r5);
        setTokenForType(r10, r5);
        return r10;
    L9:
        return 0;
    }

    public int defineTokenName(String r5, int r10) {
        Integer r11 = this.tokenNameToTypeMap.get(r5);
        if (r11 != null) goto L5;
        this.tokenNameToTypeMap.put(r5, Integer.valueOf(r10));
        setTokenForType(r10, r5);
        this.maxTokenType = Math.max(this.maxTokenType, r10);
        return r10;
    L5:
        return r11.intValue();
    }

    public Grammar(String r5) throws RecognitionException {
        this(GRAMMAR_FROM_STRING_NAME, r5, null);
    }

    public Grammar(String r5, LexerGrammar r10) throws RecognitionException {
        this(GRAMMAR_FROM_STRING_NAME, r5, r10, null);
    }

    public Grammar(String r5, ANTLRToolListener r10) throws RecognitionException {
        this(GRAMMAR_FROM_STRING_NAME, r5, r10);
    }

    public Grammar(String r5, String r10) throws RecognitionException {
        this(r5, r10, null);
    }

    public Grammar(String r5, String r10, ANTLRToolListener r11) throws RecognitionException {
        this(r5, r10, null, r11);
    }

    public Grammar(String r5, String r10, Grammar r11, ANTLRToolListener r12) throws RecognitionException {
        this.rules = new OrderedHashMap();
        this.indexToRule = new ArrayList();
        this.ruleNumber = 0;
        this.stringLiteralRuleNumber = 0;
        this.decisionDFAs = new HashMap();
        this.maxTokenType = 0;
        this.tokenNameToTypeMap = new LinkedHashMap();
        this.stringLiteralToTypeMap = new LinkedHashMap();
        this.typeToStringLiteralList = new ArrayList();
        this.typeToTokenList = new ArrayList();
        this.maxChannelType = 1;
        this.channelNameToValueMap = new LinkedHashMap();
        this.channelValueToNameList = new ArrayList();
        this.namedActions = new HashMap();
        this.lexerActions = new LinkedHashMap();
        this.sempreds = new LinkedHashMap();
        this.text = r10;
        this.fileName = r5;
        Tool r13 = new Tool();
        this.tool = r13;
        r13.addListener(new AnonymousClass1(this));
        r13.addListener(r12);
        ANTLRStringStream r14 = new ANTLRStringStream(r10);
        r14.name = r5;
        GrammarRootAST r15 = r13.parse(r5, r14);
        this.ast = r15;
        if (r15 == null) goto L14;
        TokenStream r16 = r15.tokenStream;
        if (r16 == null) goto L12;
        this.tokenStream = r16;
        this.originalTokenStream = r16;
        new TreeVisitor(new GrammarASTAdaptor()).visit(this.ast, new AnonymousClass2(this, this));
        initTokenSymbolTables();
        if (r11 == null) goto L9;
        importVocab(r11);
    L9:
        r13.process(this, false);
        return;
    L12:
        throw new IllegalStateException("expected ast to have a token stream");
    L14:
        throw new UnsupportedOperationException();
    }
}
