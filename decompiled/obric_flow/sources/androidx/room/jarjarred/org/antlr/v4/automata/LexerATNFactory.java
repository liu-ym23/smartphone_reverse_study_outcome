package androidx.room.jarjarred.org.antlr.v4.automata;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.misc.CharSupport;
import androidx.room.jarjarred.org.antlr.v4.misc.EscapeSequenceParsing;
import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ActionTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AtomTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.CodePointTransitions;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerChannelAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerCustomAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerModeAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerMoreAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerPopModeAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerPushModeAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerSkipAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerTypeAction;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.NotSetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.TokensStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RangeAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.FormalArgument;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LexerATNFactory extends ParserATNFactory {
    public static final Map<String, Integer> COMMON_CONSTANTS = null;
    protected Map<LexerAction, Integer> actionToIndexMap;
    public STGroup codegenTemplates;
    protected Map<Integer, LexerAction> indexToActionMap;
    private List<String> ruleCommands;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.automata.LexerATNFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$antlr$v4$automata$LexerATNFactory$CharSetParseState$Mode = null;
        static final /* synthetic */ int[] $SwitchMap$org$antlr$v4$misc$EscapeSequenceParsing$Result$Type = null;

        static {
            int[] r5 = new int[CharSetParseState.Mode.values().length];
            $SwitchMap$org$antlr$v4$automata$LexerATNFactory$CharSetParseState$Mode = r5;
            r5[CharSetParseState.Mode.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L21:
            $SwitchMap$org$antlr$v4$automata$LexerATNFactory$CharSetParseState$Mode[CharSetParseState.Mode.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            $SwitchMap$org$antlr$v4$automata$LexerATNFactory$CharSetParseState$Mode[CharSetParseState.Mode.PREV_CODE_POINT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L33:
            $SwitchMap$org$antlr$v4$automata$LexerATNFactory$CharSetParseState$Mode[CharSetParseState.Mode.PREV_PROPERTY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L9:
            int[] r10 = new int[EscapeSequenceParsing.Result.Type.values().length];
            $SwitchMap$org$antlr$v4$misc$EscapeSequenceParsing$Result$Type = r10;
            r10[EscapeSequenceParsing.Result.Type.INVALID.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L23:
            $SwitchMap$org$antlr$v4$misc$EscapeSequenceParsing$Result$Type[EscapeSequenceParsing.Result.Type.CODE_POINT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L25:
            $SwitchMap$org$antlr$v4$misc$EscapeSequenceParsing$Result$Type[EscapeSequenceParsing.Result.Type.PROPERTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public static class CharSetParseState {
        public static final CharSetParseState ERROR = null;
        public static final CharSetParseState NONE = null;
        public final boolean inRange;
        public final Mode mode;
        public final int prevCodePoint;
        public final IntervalSet prevProperty;

        public static final enum Mode extends Enum<Mode> {
            private static final /* synthetic */ Mode[] $VALUES = null;
            public static final Mode ERROR = null;
            public static final Mode NONE = null;
            public static final Mode PREV_CODE_POINT = null;
            public static final Mode PREV_PROPERTY = null;

            static {
                Mode r5 = new Mode("NONE", 0);
                NONE = r5;
                Mode r10 = new Mode("ERROR", 1);
                ERROR = r10;
                Mode r11 = new Mode("PREV_CODE_POINT", 2);
                PREV_CODE_POINT = r11;
                Mode r12 = new Mode("PREV_PROPERTY", 3);
                PREV_PROPERTY = r12;
                $VALUES = new Mode[]{r5, r10, r11, r12};
            }

            private Mode(String r5, int r10) {
                super(r5, r10);
            }

            public static Mode valueOf(String r5) {
                return (Mode) Enum.valueOf(Mode.class, r5);
            }

            public static Mode[] values() {
                return (Mode[]) $VALUES.clone();
            }
        }

        static {
            Mode r5 = Mode.NONE;
            IntervalSet r10 = IntervalSet.EMPTY_SET;
            NONE = new CharSetParseState(r5, false, -1, r10);
            ERROR = new CharSetParseState(Mode.ERROR, false, -1, r10);
        }

        public CharSetParseState(Mode r5, boolean r10, int r11, IntervalSet r12) {
            this.mode = r5;
            this.inRange = r10;
            this.prevCodePoint = r11;
            this.prevProperty = r12;
        }

        public boolean equals(Object r5) {
            if ((r5 instanceof CharSetParseState) == true) goto L5;
            return false;
        L5:
            CharSetParseState r10 = (CharSetParseState) r5;
            if (this != r10) goto L9;
            return true;
        L9:
            if (Objects.equals(this.mode, r10.mode) == true) goto L11;
            return false;
        L11:
            if (Boolean.valueOf(this.inRange).equals(Boolean.valueOf(r10.inRange)) == true) goto L13;
            return false;
        L13:
            if (Integer.valueOf(this.prevCodePoint).equals(Integer.valueOf(r10.prevCodePoint)) == true) goto L15;
            return false;
        L15:
            if (Objects.equals(this.prevProperty, r10.prevProperty) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mode, Boolean.valueOf(this.inRange), Integer.valueOf(this.prevCodePoint), this.prevProperty});
        }

        public String toString() {
            return String.format("%s mode=%s inRange=%s prevCodePoint=%d prevProperty=%s", new Object[]{super.toString(), this.mode, Boolean.valueOf(this.inRange), Integer.valueOf(this.prevCodePoint), this.prevProperty});
        }
    }

    static {
        HashMap r5 = new HashMap();
        COMMON_CONSTANTS = r5;
        r5.put("HIDDEN", 1);
        r5.put("DEFAULT_TOKEN_CHANNEL", 0);
        r5.put(LexerGrammar.DEFAULT_MODE_NAME, 0);
        r5.put("SKIP", -3);
        r5.put("MORE", -2);
        r5.put("EOF", -1);
        r5.put("MAX_CHAR_VALUE", Integer.valueOf(Lexer.MAX_CHAR_VALUE));
        r5.put("MIN_CHAR_VALUE", 0);
    }

    public LexerATNFactory(LexerGrammar r5) {
        super(r5);
        this.ruleCommands = new ArrayList();
        this.indexToActionMap = new HashMap();
        this.actionToIndexMap = new HashMap();
        String r10 = r5.getOptionString("language");
        this.codegenTemplates = new CodeGenerator(r5.tool, null, r10).getTemplates();
    }

    private void applyPrevState(GrammarAST r5, IntervalSet r10, CharSetParseState r11) {
        int r12 = AnonymousClass1.$SwitchMap$org$antlr$v4$automata$LexerATNFactory$CharSetParseState$Mode[r11.mode.ordinal()];
        if (r12 != 3) goto L5;
        checkSetCollision(r5, r10, r11.prevCodePoint);
        r10.add(r11.prevCodePoint);
        return;
    L5:
        if (r12 != 4) goto L11;
        r10.addAll(r11.prevProperty);
        return;
    }

    private CharSetParseState applyPrevStateAndMoveToCodePoint(GrammarAST r10, IntervalSet r11, CharSetParseState r12, int r13) {
        if (r12.inRange == true) goto L5;
        applyPrevState(r10, r11, r12);
        return new CharSetParseState(CharSetParseState.Mode.PREV_CODE_POINT, false, r13, IntervalSet.EMPTY_SET);
    L5:
        if (r12.prevCodePoint <= r13) goto L7;
        Grammar r5 = this.g;
        r5.tool.errMgr.grammarError(ErrorType.EMPTY_STRINGS_AND_SETS_NOT_ALLOWED, r5.fileName, r10.getToken(), new Object[]{CharSupport.getRangeEscapedString(r12.prevCodePoint, r13)});
    L7:
        checkSetCollision(r10, r11, r12.prevCodePoint, r13);
        r11.add(r12.prevCodePoint, r13);
        return CharSetParseState.NONE;
    }

    private CharSetParseState applyPrevStateAndMoveToProperty(GrammarAST r5, IntervalSet r10, CharSetParseState r11, IntervalSet r12) {
        if (r11.inRange == false) goto L6;
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.UNICODE_PROPERTY_NOT_ALLOWED_IN_RANGE, r13.fileName, r5.getToken(), new Object[]{r5.getText()});
        return CharSetParseState.ERROR;
    L6:
        applyPrevState(r5, r10, r11);
        return new CharSetParseState(CharSetParseState.Mode.PREV_PROPERTY, false, -1, r12);
    }

    private void checkCommands(String r10, Token r11) {
        if (r10.equals("pushMode") == false) goto L5;
    L46:
        this.ruleCommands.add(r10);
        return;
    L5:
        if (r10.equals("popMode") == true) goto L46;
        if (this.ruleCommands.contains(r10) == false) goto L10;
        Grammar r5 = this.g;
        r5.tool.errMgr.grammarError(ErrorType.DUPLICATED_COMMAND, r5.fileName, r11, new Object[]{r10});
    L10:
        if (this.ruleCommands.equals("mode") == true) goto L46;
        String r12 = "skip";
        if (r10.equals("skip") == false) goto L23;
        if (this.ruleCommands.contains("more") == false) goto L17;
    L15:
        r12 = "more";
    L44:
        if (r12 == null) goto L46;
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.INCOMPATIBLE_COMMANDS, r13.fileName, r11, new Object[]{r12, r10});
        goto L46
    L17:
        if (this.ruleCommands.contains("type") == false) goto L20;
    L18:
        r12 = "type";
        goto L44
    L20:
        if (this.ruleCommands.contains(LynxMonitorService.KEY_CHANNEL) == false) goto L43;
    L21:
        r12 = LynxMonitorService.KEY_CHANNEL;
    L43:
        r12 = null;
        goto L44
    L23:
        if (r10.equals("more") == false) goto L34;
        if (this.ruleCommands.contains("skip") == true) goto L44;
        if (this.ruleCommands.contains("type") == true) goto L18;
        if (this.ruleCommands.contains(LynxMonitorService.KEY_CHANNEL) == false) goto L43;
    L34:
        if (r10.equals("type") == true) goto L38;
        if (r10.equals(LynxMonitorService.KEY_CHANNEL) == false) goto L43;
    L38:
        if (this.ruleCommands.contains("more") == true) goto L15;
        if (this.ruleCommands.contains("skip") == false) goto L43;
        goto L43
    }

    private LexerAction createLexerAction(GrammarAST r5, GrammarAST r10) {
        String r11 = r5.getText();
        checkCommands(r11, r5.getToken());
        if ("skip".equals(r11) == false) goto L8;
        if (r10 != null) goto L8;
        return LexerSkipAction.INSTANCE;
    L8:
        if ("more".equals(r11) == false) goto L13;
        if (r10 != null) goto L13;
        return LexerMoreAction.INSTANCE;
    L13:
        if ("popMode".equals(r11) == false) goto L18;
        if (r10 != null) goto L18;
        return LexerPopModeAction.INSTANCE;
    L18:
        if ("mode".equals(r11) == false) goto L26;
        if (r10 == null) goto L26;
        Integer r12 = getModeConstantValue(r10.getText(), r10.getToken());
        if (r12 != null) goto L24;
        return null;
    L24:
        return new LexerModeAction(r12.intValue());
    L26:
        if ("pushMode".equals(r11) == false) goto L34;
        if (r10 == null) goto L34;
        Integer r13 = getModeConstantValue(r10.getText(), r10.getToken());
        if (r13 != null) goto L32;
        return null;
    L32:
        return new LexerPushModeAction(r13.intValue());
    L34:
        if ("type".equals(r11) == false) goto L42;
        if (r10 == null) goto L42;
        Integer r14 = getTokenConstantValue(r10.getText(), r10.getToken());
        if (r14 != null) goto L40;
        return null;
    L40:
        return new LexerTypeAction(r14.intValue());
    L42:
        if (LynxMonitorService.KEY_CHANNEL.equals(r11) == false) goto L49;
        if (r10 == null) goto L49;
        Integer r15 = getChannelConstantValue(r10.getText(), r10.getToken());
        if (r15 != null) goto L48;
        return null;
    L48:
        return new LexerChannelAction(r15.intValue());
    L49:
        return null;
    }

    private Integer getChannelConstantValue(String r5, Token r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.equals("HIDDEN") == false) goto L10;
        return 1;
    L10:
        if (r5.equals("DEFAULT_TOKEN_CHANNEL") == false) goto L14;
        return 0;
    L14:
        if (COMMON_CONSTANTS.containsKey(r5) == false) goto L17;
        Grammar r11 = this.g;
        r11.tool.errMgr.grammarError(ErrorType.CHANNEL_CONFLICTS_WITH_COMMON_CONSTANTS, r11.fileName, r10, new Object[]{r10.getText()});
        return null;
    L17:
        int r12 = this.g.getChannelValue(r5);
        if (r12 >= 2) goto L20;
        return Integer.valueOf(Integer.parseInt(r5));
    L23:
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.CONSTANT_VALUE_IS_NOT_A_RECOGNIZED_CHANNEL_NAME, r13.fileName, r10, new Object[]{r10.getText()});
        return null;
    L20:
        return Integer.valueOf(r12);
    }

    public static Set<String> getCommonConstants() {
        return COMMON_CONSTANTS.keySet();
    }

    private Integer getModeConstantValue(String r5, Token r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.equals(LexerGrammar.DEFAULT_MODE_NAME) == false) goto L10;
        return 0;
    L10:
        if (COMMON_CONSTANTS.containsKey(r5) == false) goto L13;
        Grammar r11 = this.g;
        r11.tool.errMgr.grammarError(ErrorType.MODE_CONFLICTS_WITH_COMMON_CONSTANTS, r11.fileName, r10, new Object[]{r10.getText()});
        return null;
    L13:
        int r12 = new ArrayList(((LexerGrammar) this.g).modes.keySet()).indexOf(r5);
        if (r12 >= 0) goto L16;
        return Integer.valueOf(Integer.parseInt(r5));
    L19:
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.CONSTANT_VALUE_IS_NOT_A_RECOGNIZED_MODE_NAME, r13.fileName, r10, new Object[]{r10.getText()});
        return null;
    L16:
        return Integer.valueOf(r12);
    }

    private Integer getTokenConstantValue(String r5, Token r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.equals("EOF") == false) goto L10;
        return -1;
    L10:
        if (COMMON_CONSTANTS.containsKey(r5) == false) goto L13;
        Grammar r11 = this.g;
        r11.tool.errMgr.grammarError(ErrorType.TOKEN_CONFLICTS_WITH_COMMON_CONSTANTS, r11.fileName, r10, new Object[]{r10.getText()});
        return null;
    L13:
        int r12 = this.g.getTokenType(r5);
        if (r12 != 0) goto L16;
        return Integer.valueOf(Integer.parseInt(r5));
    L19:
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.CONSTANT_VALUE_IS_NOT_A_RECOGNIZED_TOKEN_NAME, r13.fileName, r10, new Object[]{r10.getText()});
        return null;
    L16:
        return Integer.valueOf(r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle action(ActionAST r5) {
        return action(r5, new LexerCustomAction(this.currentRule.index, this.g.lexerActions.get(r5).intValue()));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle charSetLiteral(GrammarAST r5) {
        ATNState r10 = newState(r5);
        ATNState r11 = newState(r5);
        r10.addTransition(new SetTransition(r11, getSetFromCharSetLiteral(r5)));
        r5.atnState = r10;
        return new ATNFactory.Handle(r10, r11);
    }

    public boolean checkRange(GrammarAST r10, GrammarAST r11, int r12, int r13) {
        boolean r5 = false;
        if (r12 != (-1)) goto L5;
        Grammar r14 = this.g;
        r14.tool.errMgr.grammarError(ErrorType.INVALID_LITERAL_IN_LEXER_SET, r14.fileName, r10.getToken(), new Object[]{r10.getText()});
        boolean r15 = false;
    L6:
        if (r13 != (-1)) goto L8;
        Grammar r16 = this.g;
        r16.tool.errMgr.grammarError(ErrorType.INVALID_LITERAL_IN_LEXER_SET, r16.fileName, r11.getToken(), new Object[]{r11.getText()});
    L9:
        if (r5 == true) goto L11;
        return r5;
    L11:
        if (r13 >= r12) goto L13;
        Grammar r17 = this.g;
        r17.tool.errMgr.grammarError(ErrorType.EMPTY_STRINGS_AND_SETS_NOT_ALLOWED, r17.fileName, r10.parent.getToken(), new Object[]{r10.getText() + ".." + r11.getText()});
    L13:
        return r5;
    L8:
        r5 = r15;
        goto L9
    L5:
        r15 = true;
        goto L6
    }

    public void checkSetCollision(GrammarAST r5, IntervalSet r10, int r11) {
        checkSetCollision(r5, r10, r11, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATN createATN() {
        Set<String> r5 = ((LexerGrammar) this.g).modes.keySet();
        Iterator<String> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        String r11 = r10.next();
        TokensStartState r12 = (TokensStartState) newState(TokensStartState.class, null);
        this.atn.modeNameToStartState.put(r11, r12);
        this.atn.modeToStartState.add(r12);
        this.atn.defineDecisionState(r12);
        goto L4
    L6:
        ATN r13 = this.atn;
        r13.ruleToTokenType = new int[this.g.rules.size()];
        Iterator<Rule> r14 = this.g.rules.values().iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Rule r15 = r14.next();
        this.atn.ruleToTokenType[r15.index] = this.g.getTokenType(r15.name);
        goto L8
    L10:
        _createATN(this.g.rules.values());
        ATN r16 = this.atn;
        r16.lexerActions = new LexerAction[this.indexToActionMap.size()];
        Iterator<Map.Entry<Integer, LexerAction>> r17 = this.indexToActionMap.entrySet().iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        Map.Entry<Integer, LexerAction> r18 = r17.next();
        this.atn.lexerActions[r18.getKey().intValue()] = r18.getValue();
        goto L12
    L14:
        Iterator<String> r19 = r5.iterator();
    L16:
        if (r19.hasNext() == false) goto L23;
        String r20 = r19.next();
        List r21 = (List) ((LexerGrammar) this.g).modes.get(r20);
        TokensStartState r22 = this.atn.modeNameToStartState.get(r20);
        Iterator r23 = r21.iterator();
    L19:
        if (r23.hasNext() == false) goto L16;
        Rule r24 = (Rule) r23.next();
        if (r24.isFragment() == true) goto L19;
        epsilon(r22, this.atn.ruleToStartState[r24.index]);
        goto L19
    L23:
        ATNOptimizer.optimize(this.g, this.atn);
        return this.atn;
    }

    public int getLexerActionIndex(LexerAction r5) {
        Integer r10 = this.actionToIndexMap.get(r5);
        if (r10 != null) goto L6;
        r10 = Integer.valueOf(this.actionToIndexMap.size());
        this.actionToIndexMap.put(r5, r10);
        this.indexToActionMap.put(r10, r5);
    L6:
        return r10.intValue();
    }

    public IntervalSet getSetFromCharSetLiteral(GrammarAST r13) {
        String r5 = a.n(r13.getText(), 1, 1);
        IntervalSet r10 = new IntervalSet(new int[0]);
        if (r5.length() != 0) goto L6;
        Grammar r12 = this.g;
        r12.tool.errMgr.grammarError(ErrorType.EMPTY_STRINGS_AND_SETS_NOT_ALLOWED, r12.fileName, r13.getToken(), new Object[]{"[]"});
        return r10;
    L6:
        CharSetParseState r11 = CharSetParseState.NONE;
        int r14 = r5.length();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L39;
        if (r11.mode == CharSetParseState.Mode.ERROR) goto L11;
        int r16 = r5.codePointAt(r15);
        int r17 = Character.charCount(r16);
        if (r16 != 92) goto L26;
        EscapeSequenceParsing.Result r18 = EscapeSequenceParsing.parseEscape(r5, r15);
        int r19 = AnonymousClass1.$SwitchMap$org$antlr$v4$misc$EscapeSequenceParsing$Result$Type[r18.type.ordinal()];
        if (r19 != 1) goto L17;
        int r20 = r18.startOffset;
        String r21 = r5.substring(r20, r18.parseLength + r20);
        Grammar r22 = this.g;
        r22.tool.errMgr.grammarError(ErrorType.INVALID_ESCAPE_SEQUENCE, r22.fileName, r13.getToken(), new Object[]{r21});
        r11 = CharSetParseState.ERROR;
    L24:
        r17 = r18.parseLength;
    L37:
        r15 = r15 + r17;
        goto L7
    L17:
        if (r19 != 2) goto L19;
        r11 = applyPrevStateAndMoveToCodePoint(r13, r10, r11, r18.codePoint);
        goto L24
    L19:
        if (r19 != 3) goto L24;
        r11 = applyPrevStateAndMoveToProperty(r13, r10, r11, r18.propertyIntervalSet);
        goto L24
    L26:
        if (r16 == 45) goto L28;
    L36:
        r11 = applyPrevStateAndMoveToCodePoint(r13, r10, r11, r16);
        goto L37
    L28:
        if (r11.inRange == true) goto L36;
        if (r15 == 0) goto L36;
        if (r15 == (r14 - 1)) goto L36;
        if (r11.mode != CharSetParseState.Mode.PREV_PROPERTY) goto L35;
        Grammar r23 = this.g;
        r23.tool.errMgr.grammarError(ErrorType.UNICODE_PROPERTY_NOT_ALLOWED_IN_RANGE, r23.fileName, r13.getToken(), new Object[]{r13.getText()});
        r11 = CharSetParseState.ERROR;
        goto L37
    L35:
        r11 = new CharSetParseState(r11.mode, true, r11.prevCodePoint, r11.prevProperty);
        goto L37
    L11:
        return new IntervalSet(new int[0]);
    L39:
        if (r11.mode == CharSetParseState.Mode.ERROR) goto L41;
        applyPrevState(r13, r10, r11);
        return r10;
    L41:
        return new IntervalSet(new int[0]);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle lexerAltCommands(ATNFactory.Handle r5, ATNFactory.Handle r10) {
        ATNFactory.Handle r11 = new ATNFactory.Handle(r5.left, r10.right);
        epsilon(r5.right, r10.left);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle lexerCallCommand(GrammarAST r5, GrammarAST r10) {
        LexerAction r11 = createLexerAction(r5, r10);
        if (r11 != null) goto L5;
        ST r12 = this.codegenTemplates.getInstanceOf("Lexer" + CharSupport.capitalize(r5.getText()) + "Command");
        if (r12 != null) goto L10;
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.INVALID_LEXER_COMMAND, r13.fileName, r5.token, new Object[]{r5.getText()});
        return epsilon(r5);
    L10:
        Map<String, FormalArgument> r14 = r12.impl.formalArguments;
        if (r14 != null) goto L13;
    L17:
        Grammar r15 = this.g;
        r15.tool.errMgr.grammarError(ErrorType.UNWANTED_LEXER_COMMAND_ARGUMENT, r15.fileName, r5.token, new Object[]{r5.getText()});
        return epsilon(r5);
    L13:
        if (r14.containsKey("arg") == false) goto L17;
        r12.add("arg", r10.getText());
        r12.add("grammar", r10.g);
        return action(r12.render());
    L5:
        return action(r5, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle lexerCommand(GrammarAST r10) {
        LexerAction r5 = createLexerAction(r10, null);
        if (r5 != null) goto L5;
        ST r11 = this.codegenTemplates.getInstanceOf("Lexer" + CharSupport.capitalize(r10.getText()) + "Command");
        if (r11 != null) goto L10;
        Grammar r12 = this.g;
        r12.tool.errMgr.grammarError(ErrorType.INVALID_LEXER_COMMAND, r12.fileName, r10.token, new Object[]{r10.getText()});
        return epsilon(r10);
    L10:
        Map<String, FormalArgument> r13 = r11.impl.formalArguments;
        if (r13 == null) goto L17;
        if (r13.containsKey("arg") == false) goto L17;
        Grammar r14 = this.g;
        r14.tool.errMgr.grammarError(ErrorType.MISSING_LEXER_COMMAND_ARGUMENT, r14.fileName, r10.token, new Object[]{r10.getText()});
        return epsilon(r10);
    L17:
        return action(r11.render());
    L5:
        return action(r10, r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle range(GrammarAST r5, GrammarAST r10) {
        ATNState r11 = newState(r5);
        ATNState r12 = newState(r10);
        int r13 = CharSupport.getCharValueFromGrammarCharLiteral(r5.getText());
        int r14 = CharSupport.getCharValueFromGrammarCharLiteral(r10.getText());
        checkRange(r5, r10, r13, r14);
        r11.addTransition(CodePointTransitions.createWithCodePointRange(r12, r13, r14));
        r5.atnState = r11;
        r10.atnState = r11;
        return new ATNFactory.Handle(r11, r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle rule(GrammarAST r5, String r10, ATNFactory.Handle r11) {
        this.ruleCommands.clear();
        return super.rule(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle set(GrammarAST r10, List<GrammarAST> r11, boolean r12) {
        ATNState r5 = newState(r10);
        ATNState r13 = newState(r10);
        IntervalSet r14 = new IntervalSet(new int[0]);
        Iterator<GrammarAST> r15 = r11.iterator();
    L4:
        if (r15.hasNext() == false) goto L22;
        GrammarAST r16 = r15.next();
        if (r16.getType() == 52) goto L7;
        if (r16.getType() == 32) goto L12;
        if (r16.getType() == 62) goto L15;
        if (r16.getType() != 66) goto L4;
        Grammar r17 = this.g;
        r17.tool.errMgr.grammarError(ErrorType.UNSUPPORTED_REFERENCE_IN_LEXER_SET, r17.fileName, r16.getToken(), new Object[]{r16.getText()});
        goto L4
    L15:
        int r18 = CharSupport.getCharValueFromGrammarCharLiteral(r16.getText());
        if (r18 != (-1)) goto L17;
        Grammar r19 = this.g;
        r19.tool.errMgr.grammarError(ErrorType.INVALID_LITERAL_IN_LEXER_SET, r19.fileName, r16.getToken(), new Object[]{r16.getText()});
        goto L4
    L17:
        checkSetCollision(r10, r14, r18);
        r14.add(r18);
        goto L4
    L12:
        r14.addAll(getSetFromCharSetLiteral(r16));
        goto L4
    L7:
        int r20 = CharSupport.getCharValueFromGrammarCharLiteral(r16.getChild(0).getText());
        int r21 = CharSupport.getCharValueFromGrammarCharLiteral(r16.getChild(1).getText());
        if (checkRange((GrammarAST) r16.getChild(0), (GrammarAST) r16.getChild(1), r20, r21) == false) goto L4;
        checkSetCollision(r10, r14, r20, r21);
        r14.add(r20, r21);
        goto L4
    L22:
        if (r12 == false) goto L25;
        r5.addTransition(new NotSetTransition(r13, r14));
    L29:
        r10.atnState = r5;
        return new ATNFactory.Handle(r5, r13);
    L25:
        if (r14.getIntervals().size() != 1) goto L27;
        Interval r22 = r14.getIntervals().get(0);
        Transition r23 = CodePointTransitions.createWithCodePointRange(r13, r22.f665a, r22.f666b);
    L28:
        r5.addTransition(r23);
        goto L29
    L27:
        r23 = new SetTransition(r13, r14);
        goto L28
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle stringLiteral(TerminalAST r10) {
        String r5 = r10.getText();
        ATNState r11 = newState(r10);
        String r12 = CharSupport.getStringFromGrammarStringLiteral(r5);
        if (r12 == null) goto L5;
        int r13 = r12.length();
        ATNState r14 = null;
        int r15 = 0;
        ATNState r16 = r11;
    L7:
        if (r15 >= r13) goto L9;
        r14 = newState(r10);
        int r17 = r12.codePointAt(r15);
        r16.addTransition(CodePointTransitions.createWithCodePoint(r14, r17));
        r15 = r15 + Character.charCount(r17);
        r16 = r14;
        goto L7
    L9:
        r10.atnState = r11;
        return new ATNFactory.Handle(r11, r14);
    L5:
        return new ATNFactory.Handle(r11, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle tokenRef(TerminalAST r5) {
        if (r5.getText().equals("EOF") == false) goto L7;
        ATNState r10 = newState(r5);
        ATNState r11 = newState(r5);
        r10.addTransition(new AtomTransition(r11, -1));
        return new ATNFactory.Handle(r10, r11);
    L7:
        return _ruleRef(r5);
    }

    public void checkSetCollision(GrammarAST r5, IntervalSet r10, int r11, int r12) {
        int r13 = r11;
    L3:
        if (r13 > r12) goto L26;
        if (r10.contains(r13) == true) goto L7;
        r13 = r13 + 1;
        goto L3
    L7:
        if (r5.getChildren() != null) goto L9;
        String r14 = r5.getText();
    L18:
        Grammar r15 = this.g;
        r15.tool.errMgr.grammarError(ErrorType.CHARACTERS_COLLISION_IN_SET, r15.fileName, r5.getToken(), new Object[]{CharSupport.getRangeEscapedString(r11, r12), r14});
        return;
    L9:
        StringBuilder r16 = new StringBuilder();
        Iterator<? extends Object> r17 = r5.getChildren().iterator();
    L11:
        if (r17.hasNext() == false) goto L17;
        Object r18 = r17.next();
        if ((r18 instanceof RangeAST) == false) goto L15;
        RangeAST r19 = (RangeAST) r18;
        r16.append(r19.getChild(0).getText());
        r16.append("..");
        r16.append(r19.getChild(1).getText());
    L16:
        r16.append(" | ");
        goto L11
    L15:
        r16.append(((GrammarAST) r18).getText());
        goto L16
    L17:
        r16.replace(r16.length() - 3, r16.length(), "");
        r14 = r16.toString();
        goto L18
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ParserATNFactory, androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle action(String r5) {
        if (r5.trim().isEmpty() == false) goto L6;
        ATNState r10 = newState(null);
        ATNState r11 = newState(null);
        epsilon(r10, r11);
        return new ATNFactory.Handle(r10, r11);
    L6:
        ActionAST r12 = new ActionAST(new CommonToken(4, r5));
        this.currentRule.defineActionInAlt(this.currentOuterAlt, r12);
        return action(r12);
    }

    public ATNFactory.Handle action(GrammarAST r5, LexerAction r10) {
        ATNState r11 = newState(r5);
        ATNState r12 = newState(r5);
        int r13 = getLexerActionIndex(r10);
        r11.addTransition(new ActionTransition(r12, this.currentRule.index, r13, false));
        r5.atnState = r11;
        return new ATNFactory.Handle(r11, r12);
    }
}
