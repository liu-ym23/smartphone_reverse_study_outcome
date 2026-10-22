package androidx.room.jarjarred.org.antlr.v4.codegen.target;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.Target;
import androidx.room.jarjarred.org.antlr.v4.codegen.UnicodeEscapes;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuntimeMetaData;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNDeserializer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNType;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ActionTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AtomTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerActionType;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerChannelAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerCustomAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerModeAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerPushModeAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerTypeAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LoopEndState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PrecedencePredicateTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredicateTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RangeTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.TokensStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntegerList;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

/* JADX INFO: loaded from: classes.dex */
public class SwiftTarget extends Target {
    protected static final String[] swiftKeywords = null;
    private static final ThreadLocal<STGroup> targetTemplates = null;
    protected final Set<String> badWords;
    public String lexerAtnJSON;
    public String parserAtnJSON;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.codegen.target.SwiftTarget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType = null;

        static {
            int[] r5 = new int[LexerActionType.values().length];
            $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType = r5;
            r5[LexerActionType.CHANNEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[LexerActionType.CUSTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[LexerActionType.MODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[LexerActionType.MORE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[LexerActionType.POP_MODE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[LexerActionType.PUSH_MODE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[LexerActionType.SKIP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[LexerActionType.TYPE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static class SwiftStringRenderer extends StringRenderer {
        public SwiftStringRenderer() {
        }

        @Override // androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer, androidx.room.jarjarred.org.stringtemplate.v4.AttributeRenderer
        public String toString(Object r5, String r10, Locale r11) {
            if ("java-escape".equals(r10) == false) goto L7;
            return ((String) r5).replace("\\u", "\\u005Cu");
        L7:
            return super.toString(r5, r10, r11);
        }
    }

    static {
        targetTemplates = new ThreadLocal();
        swiftKeywords = new String[]{"associatedtype", "class", "deinit", "enum", "extension", "func", "import", "init", "inout", "internal", "let", "operator", "private", "protocol", "public", "static", "struct", "subscript", "typealias", "var", "break", "case", "continue", "default", "defer", "do", "else", "fallthrough", "for", "guard", "if", "in", "repeat", "return", "switch", "where", "while", "as", "catch", "dynamicType", "false", "is", "nil", "rethrows", "super", "self", "Self", "throw", "throws", "true", "try", "__COLUMN__", "__FILE__", "__FUNCTION__", "__LINE__", "#column", "#file", "#function", "#line", "_", "#available", "#else", "#elseif", "#endif", "#if", "#selector", "associativity", "convenience", "dynamic", "didSet", "final", "get", "infix", "indirect", "lazy", OpenPageMethod.ALIGN_LEFT, "mutating", "none", "nonmutating", "optional", "override", "postfix", "precedence", "prefix", "Protocol", "required", "right", "set", "Type", "unowned", "weak", "willSet"};
    }

    public SwiftTarget(CodeGenerator r5) {
        super(r5, "Swift");
        this.badWords = new HashSet();
        this.lexerAtnJSON = null;
        this.parserAtnJSON = null;
    }

    private String getLexerOrParserATNJson(Grammar r5, String r10) {
        StringBuilder r11 = j0.x("class ", r10.substring(0, r10.lastIndexOf(getTemplates().getInstanceOf("codeFileExtension").render())), "ATN {\n    let jsonString: String = \"");
        r11.append(serializeTojson(r5.atn).replaceAll("\"", "\\\\\""));
        r11.append("\"\n}");
        return r11.toString();
    }

    private void writeFile(String r5, Grammar r10, String r11) {
        Writer r12 = getCodeGenerator().tool.getOutputFileWriter(r10, r11);     // Catch: IOException -> L4
        r12.write(r5);     // Catch: IOException -> L4
        r12.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        getCodeGenerator().tool.errMgr.toolError(ErrorType.CANNOT_WRITE_FILE, e, new Object[]{r11});
    }

    public void addBadWords() {
        this.badWords.addAll(Arrays.asList(swiftKeywords));
        this.badWords.add("rule");
        this.badWords.add("parserRule");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void appendUnicodeEscapedCodePoint(int r5, StringBuilder r10) {
        UnicodeEscapes.appendSwiftStyleEscapedCodePoint(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public void genFile(Grammar r5, ST r10, String r11) {
        super.genFile(r5, r10, r11);
        if (r5.isLexer() == false) goto L8;
        if (this.lexerAtnJSON != null) goto L8;
        this.lexerAtnJSON = getLexerOrParserATNJson(r5, r11);
    L15:
        if (r11.endsWith(CodeGenerator.VOCAB_FILE_EXTENSION) == false) goto L23;
        String r12 = r11.substring(0, r11.lastIndexOf(CodeGenerator.VOCAB_FILE_EXTENSION));
        if (this.lexerAtnJSON == null) goto L20;
        r12 = j0.j(r12, "ATN.swift");
        writeFile(this.lexerAtnJSON, r5, r12);
    L20:
        if (this.parserAtnJSON == null) goto L24;
        String r13 = j0.j(r12, "ParserATN.swift");
        writeFile(this.parserAtnJSON, r5, r13);
        return;
    L24:
        return;
    L23:
        return;
    L8:
        if (r5.isLexer() == true) goto L15;
        if (this.parserAtnJSON != null) goto L15;
        if (r5.atn == null) goto L15;
        this.parserAtnJSON = getLexerOrParserATNJson(r5, r11);
        goto L15
    }

    public Set<String> getBadWords() {
        if (this.badWords.isEmpty() == false) goto L6;
        addBadWords();
    L6:
        return this.badWords;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public int getSerializedATNSegmentLimit() {
        return 21845;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public String getVersion() {
        return RuntimeMetaData.VERSION;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public STGroup loadTemplates() {
        ThreadLocal<STGroup> r5 = targetTemplates;
        STGroup r10 = r5.get();
        if (r10 != null) goto L6;
        STGroup r11 = super.loadTemplates();
        r11.registerRenderer(String.class, new SwiftStringRenderer(), true);
        r5.set(r11);
        return r11;
    L6:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7, types: [int] */
    /* JADX WARN: Type inference failed for: r15v8 */
    public String serializeTojson(ATN r20) {
        JsonObjectBuilder r5 = Json.createObjectBuilder();
        r5.add("version", ATNDeserializer.SERIALIZED_VERSION);
        r5.add("uuid", ATNDeserializer.SERIALIZED_UUID.toString());
        r5.add("grammarType", r20.grammarType.ordinal());
        r5.add("maxTokenType", r20.maxTokenType);
        HashMap r10 = new HashMap();
        ArrayList r11 = new ArrayList();
        JsonArrayBuilder r12 = Json.createArrayBuilder();
        IntegerList r13 = new IntegerList();
        IntegerList r14 = new IntegerList();
        Iterator<ATNState> r15 = r20.states.iterator();
    L3:
        int r16 = 7;
        int r17 = 1;
        int r18 = 0;
        if (r15.hasNext() == false) goto L38;
        ATNState r19 = r15.next();
        JsonObjectBuilder r110 = Json.createObjectBuilder();
        if (r19 == null) goto L7;
        r110.add("stateType", r19.getStateType());
        r110.add("ruleIndex", r19.ruleIndex);
        if ((r19 instanceof DecisionState) == false) goto L14;
        if (((DecisionState) r19).nonGreedy == false) goto L14;
        r13.add(r19.stateNumber);
    L14:
        if ((r19 instanceof RuleStartState) == false) goto L19;
        if (((RuleStartState) r19).isLeftRecursiveRule == false) goto L19;
        r14.add(r19.stateNumber);
    L19:
        if (r19.getStateType() != 12) goto L22;
        r110.add("detailStateNumber", ((LoopEndState) r19).loopBackState.stateNumber);
    L25:
        if (r19.getStateType() == 7) goto L28;
        r19.getNumberOfTransitions();
    L28:
        if (r18 >= r19.getNumberOfTransitions()) goto L37;
        Transition r111 = r19.transition(r18);
        int r112 = Transition.serializationTypes.get(r111.getClass()).intValue();
        if (r112 != 7) goto L32;
    L33:
        SetTransition r113 = (SetTransition) r111;
        if (r10.containsKey(r113.set) == true) goto L36;
        r11.add(r113.set);
        r10.put(r113.set, Integer.valueOf(r11.size() - 1));
    L36:
        r18 = r18 + 1;
        goto L28
    L32:
        if (r112 != 8) goto L36;
    L37:
        r12.add(r110);
        goto L3
    L22:
        if ((r19 instanceof BlockStartState) == false) goto L25;
        r110.add("detailStateNumber", ((BlockStartState) r19).endState.stateNumber);
        goto L25
    L7:
        r12.addNull();
        goto L3
    L38:
        r5.add("states", r12);
        JsonArrayBuilder r21 = Json.createArrayBuilder();
        int r22 = 0;
    L40:
        if (r22 >= r13.size()) goto L42;
        r21.add(r13.get(r22));
        r22 = r22 + 1;
        goto L40
    L42:
        r5.add("nonGreedyStates", r21);
        JsonArrayBuilder r23 = Json.createArrayBuilder();
        int r24 = 0;
    L44:
        if (r24 >= r14.size()) goto L46;
        r23.add(r14.get(r24));
        r24 = r24 + 1;
        goto L44
    L46:
        r5.add("precedenceStates", r23);
        JsonArrayBuilder r25 = Json.createArrayBuilder();
        int r26 = r20.ruleToStartState.length;
        int r27 = 0;
    L47:
        if (r27 >= r26) goto L52;
        JsonObjectBuilder r28 = Json.createObjectBuilder();
        r28.add("stateNumber", r20.ruleToStartState[r27].stateNumber);
        if (r20.grammarType != ATNType.LEXER) goto L51;
        r28.add("ruleToTokenType", r20.ruleToTokenType[r27]);
    L51:
        r25.add(r28);
        r27 = r27 + 1;
        goto L47
    L52:
        r5.add("ruleToStartState", r25);
        JsonArrayBuilder r29 = Json.createArrayBuilder();
        if (r20.modeToStartState.size() <= 0) goto L58;
        Iterator<TokensStartState> r30 = r20.modeToStartState.iterator();
    L56:
        if (r30.hasNext() == false) goto L58;
        r29.add(r30.next().stateNumber);
    L58:
        r5.add("modeToStartState", r29);
        JsonArrayBuilder r31 = Json.createArrayBuilder();
        r5.add("nsets", r11.size());
        Iterator r32 = r11.iterator();
    L60:
        if (r32.hasNext() == false) goto L79;
        IntervalSet r33 = (IntervalSet) r32.next();
        JsonObjectBuilder r114 = Json.createObjectBuilder();
        boolean r115 = r33.contains(-1);
        if (r115 == true) goto L64;
    L66:
        r114.add("size", r33.getIntervals().size());
    L67:
        r114.add("containsEof", r115 ? 1 : 0);
        JsonArrayBuilder r116 = Json.createArrayBuilder();
        Iterator<Interval> r34 = r33.getIntervals().iterator();
    L69:
        if (r34.hasNext() == false) goto L78;
        Interval r117 = r34.next();
        JsonObjectBuilder r118 = Json.createObjectBuilder();
        int r119 = r117.f665a;
        if (r119 == (-1)) goto L73;
        r118.add("a", r119);
    L77:
        r118.add("b", r117.f666b);
        r116.add(r118);
        goto L69
    L73:
        if (r117.f666b == (-1)) goto L69;
        r118.add("a", 0);
        goto L77
    L78:
        r114.add("Intervals", r116);
        r31.add(r114);
        r17 = 1;
        goto L60
    L64:
        if (r33.getIntervals().get(0).f666b != (-1)) goto L66;
        r114.add("size", r33.getIntervals().size() - r17);
        goto L67
    L79:
        r5.add("IntervalSet", r31);
        JsonArrayBuilder r35 = Json.createArrayBuilder();
        Iterator<ATNState> r36 = r20.states.iterator();
    L81:
        if (r36.hasNext() == false) goto L118;
        ATNState r37 = r36.next();
        if (r37 == null) goto L81;
        if (r37.getStateType() == r16) goto L81;
        JsonArrayBuilder r120 = Json.createArrayBuilder();
        int r121 = r18;
    L90:
        if (r121 >= r37.getNumberOfTransitions()) goto L117;
        JsonObjectBuilder r122 = Json.createObjectBuilder();
        Transition r123 = r37.transition(r121);
        if (r20.states.get(r123.target.stateNumber) == null) goto L116;
        int r38 = r37.stateNumber;
        int r124 = r123.target.stateNumber;
        int r39 = Transition.serializationTypes.get(r123.getClass()).intValue();
        switch(r39) {
            case 2: goto L110;
            case 3: goto L109;
            case 4: goto L108;
            case 5: goto L104;
            case 6: goto L102;
            case 7: goto L101;
            case 8: goto L100;
            case 9: goto L95;
            case 10: goto L97;
            default: goto L95;
        };
    L95:
        r10 = r10;
        Iterator<ATNState> r125 = r36;
        int r126 = r124;
        int r40 = 0;
        int r127 = 0;
    L96:
        ?? r128 = 0;
    L114:
        r122.add("src", r38);
        r122.add("trg", r126);
        r122.add("edgeType", r39);
        r122.add("arg1", r127);
        r122.add("arg2", r40);
        r122.add("arg3", r128);
        r120.add(r122);
        r121 = r121 + 1;
        r10 = r10;
        r36 = r125;
        goto L90
    L97:
        r127 = ((PrecedencePredicateTransition) r123).precedence;
    L98:
        r10 = r10;
        r125 = r36;
        r126 = r124;
    L99:
        r40 = 0;
        goto L96
    L100:
        r127 = ((Integer) r10.get(((SetTransition) r123).set)).intValue();
        goto L98
    L101:
        r127 = ((Integer) r10.get(((SetTransition) r123).set)).intValue();
        goto L98
    L102:
        ActionTransition r129 = (ActionTransition) r123;
        r127 = r129.ruleIndex;
        r40 = r129.actionIndex;
        ?? r130 = r129.isCtxDependent;
    L103:
        r125 = r36;
        int r131 = r124;
        r128 = r130;
        r126 = r131;
        goto L114
    L104:
        r10 = r10;
        r127 = ((AtomTransition) r123).label;
        r125 = r36;
        r126 = r124;
        if (r127 != (-1)) goto L99;
        r40 = 0;
    L107:
        r127 = 0;
        r128 = 1;
        goto L114
    L108:
        PredicateTransition r132 = (PredicateTransition) r123;
        r127 = r132.ruleIndex;
        r40 = r132.predIndex;
        r130 = r132.isCtxDependent;
        goto L103
    L109:
        RuleTransition r133 = (RuleTransition) r123;
        r124 = r133.followState.stateNumber;
        r127 = r133.target.stateNumber;
        r40 = r133.ruleIndex;
        r130 = r133.precedence;
        goto L103
    L110:
        r10 = r10;
        RangeTransition r134 = (RangeTransition) r123;
        r127 = r134.from;
        r40 = r134.f661to;
        r125 = r36;
        if (r127 != (-1)) goto L113;
        r126 = r124;
        goto L107
    L113:
        r126 = r124;
        goto L96
    L116:
        throw new IllegalStateException("Cannot serialize a transition to a removed state.");
    L117:
        r35.add(r120);
        r16 = 7;
        r18 = 0;
        goto L81
    L118:
        r5.add("allTransitionsBuilder", r35);
        r20.decisionToState.size();
        JsonArrayBuilder r41 = Json.createArrayBuilder();
        Iterator<DecisionState> r42 = r20.decisionToState.iterator();
    L120:
        if (r42.hasNext() == false) goto L122;
        r41.add(r42.next().stateNumber);
        goto L120
    L122:
        r5.add("decisionToState", r41);
        JsonArrayBuilder r43 = Json.createArrayBuilder();
        if (r20.grammarType != ATNType.LEXER) goto L139;
        LexerAction[] r44 = r20.lexerActions;
        int r45 = r44.length;
        int r46 = 0;
    L125:
        if (r46 >= r45) goto L139;
        LexerAction r47 = r44[r46];
        JsonObjectBuilder r48 = Json.createObjectBuilder();
        r48.add("actionType", r47.getActionType().ordinal());
        switch(AnonymousClass1.$SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[r47.getActionType().ordinal()]) {
            case 1: goto L137;
            case 2: goto L136;
            case 3: goto L135;
            case 4: goto L134;
            case 5: goto L133;
            case 6: goto L132;
            case 7: goto L131;
            case 8: goto L130;
            default: goto L128;
        };
    L130:
        r48.add("a", ((LexerTypeAction) r47).getType());
        r48.add("b", 0);
    L138:
        r43.add(r48);
        r46 = r46 + 1;
        goto L125
    L131:
        r48.add("a", 0);
        r48.add("b", 0);
        goto L138
    L132:
        r48.add("a", ((LexerPushModeAction) r47).getMode());
        r48.add("b", 0);
        goto L138
    L133:
        r48.add("a", 0);
        r48.add("b", 0);
        goto L138
    L134:
        r48.add("a", 0);
        r48.add("b", 0);
        goto L138
    L135:
        r48.add("a", ((LexerModeAction) r47).getMode());
        r48.add("b", 0);
        goto L138
    L136:
        LexerCustomAction r49 = (LexerCustomAction) r47;
        int r135 = r49.getRuleIndex();
        int r50 = r49.getActionIndex();
        r48.add("a", r135);
        r48.add("b", r50);
        goto L138
    L137:
        r48.add("a", ((LexerChannelAction) r47).getChannel());
        r48.add("b", 0);
        goto L138
    L128:
        Locale.getDefault();
        throw new IllegalArgumentException("The specified lexer action type " + r47.getActionType() + " is not valid.");
    L139:
        r5.add("lexerActions", r43);
        return r5.build().toString();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.Target
    public boolean visibleGrammarSymbolCausesIssueInGeneratedCode(GrammarAST r5) {
        return getBadWords().contains(r5.getText());
    }
}
