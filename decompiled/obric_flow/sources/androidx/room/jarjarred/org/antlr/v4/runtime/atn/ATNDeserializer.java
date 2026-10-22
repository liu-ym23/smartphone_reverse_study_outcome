package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class ATNDeserializer {
    private static final UUID ADDED_LEXER_ACTIONS = null;
    private static final UUID ADDED_PRECEDENCE_TRANSITIONS = null;
    private static final UUID ADDED_UNICODE_SMP = null;
    private static final UUID BASE_SERIALIZED_UUID = null;
    public static final UUID SERIALIZED_UUID = null;
    public static final int SERIALIZED_VERSION = 3;
    private static final List<UUID> SUPPORTED_UUIDS = null;
    private final ATNDeserializationOptions deserializationOptions;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNDeserializer$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
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

    public interface UnicodeDeserializer {
        int readUnicode(char[] r5, int r10);

        int size();
    }

    public static final enum UnicodeDeserializingMode extends Enum<UnicodeDeserializingMode> {
        private static final /* synthetic */ UnicodeDeserializingMode[] $VALUES = null;
        public static final UnicodeDeserializingMode UNICODE_BMP = null;
        public static final UnicodeDeserializingMode UNICODE_SMP = null;

        static {
            UnicodeDeserializingMode r5 = new UnicodeDeserializingMode("UNICODE_BMP", 0);
            UNICODE_BMP = r5;
            UnicodeDeserializingMode r10 = new UnicodeDeserializingMode("UNICODE_SMP", 1);
            UNICODE_SMP = r10;
            $VALUES = new UnicodeDeserializingMode[]{r5, r10};
        }

        private UnicodeDeserializingMode(String r5, int r10) {
            super(r5, r10);
        }

        public static UnicodeDeserializingMode valueOf(String r5) {
            return (UnicodeDeserializingMode) Enum.valueOf(UnicodeDeserializingMode.class, r5);
        }

        public static UnicodeDeserializingMode[] values() {
            return (UnicodeDeserializingMode[]) $VALUES.clone();
        }
    }

    static {
        UUID r5 = UUID.fromString("33761B2D-78BB-4A43-8B0B-4F5BEE8AACF3");
        BASE_SERIALIZED_UUID = r5;
        UUID r10 = UUID.fromString("1DA0C57D-6C06-438A-9B27-10BCB3CE0F61");
        ADDED_PRECEDENCE_TRANSITIONS = r10;
        UUID r11 = UUID.fromString("AADB8D7E-AEEF-4415-AD2B-8204D6CF042E");
        ADDED_LEXER_ACTIONS = r11;
        UUID r12 = UUID.fromString("59627784-3BE5-417A-B9EB-8131A7286089");
        ADDED_UNICODE_SMP = r12;
        ArrayList r13 = new ArrayList();
        SUPPORTED_UUIDS = r13;
        r13.add(r5);
        r13.add(r10);
        r13.add(r11);
        r13.add(r12);
        SERIALIZED_UUID = r12;
    }

    public ATNDeserializer() {
        this(ATNDeserializationOptions.getDefaultOptions());
    }

    private int deserializeSets(char[] r10, int r11, List<IntervalSet> r12, UnicodeDeserializer r13) {
        int r14 = r11 + 1;
        int r15 = toInt(r10[r11]);
        int r5 = 0;
    L3:
        if (r5 >= r15) goto L11;
        int r16 = toInt(r10[r14]);
        int r17 = r14 + 1;
        IntervalSet r18 = new IntervalSet(new int[0]);
        r12.add(r18);
        r14 = r14 + 2;
        if (toInt(r10[r17]) == 0) goto L7;
        r18.add(-1);
    L7:
        int r19 = 0;
    L8:
        if (r19 >= r16) goto L10;
        int r20 = r13.readUnicode(r10, r14);
        int r21 = r14 + r13.size();
        int r22 = r13.readUnicode(r10, r21);
        r14 = r21 + r13.size();
        r18.add(r20, r22);
        r19 = r19 + 1;
        goto L8
    L10:
        r5 = r5 + 1;
        goto L3
    L11:
        return r14;
    }

    public static UnicodeDeserializer getUnicodeDeserializer(UnicodeDeserializingMode r5) {
        if (r5 != UnicodeDeserializingMode.UNICODE_BMP) goto L7;
        return new AnonymousClass1();
    L7:
        return new AnonymousClass2();
    }

    public static boolean isFeatureSupported(UUID r5, UUID r10) {
        List<UUID> r11 = SUPPORTED_UUIDS;
        int r12 = r11.indexOf(r5);
        if (r12 >= 0) goto L6;
        return false;
    L6:
        if (r11.indexOf(r10) < r12) goto L9;
        return true;
    L9:
        return false;
    }

    public static int toInt(char r5) {
        return r5;
    }

    public static int toInt32(char[] r5, int r10) {
        char r11 = r5[r10];
        return (r5[r10 + 1] << 16) | r11;
    }

    public static long toLong(char[] r5, int r10) {
        long r11 = ((long) toInt32(r5, r10)) & 4294967295L;
        return (((long) toInt32(r5, r10 + 2)) << 32) | r11;
    }

    public static UUID toUUID(char[] r5, int r10) {
        long r11 = toLong(r5, r10);
        return new UUID(toLong(r5, r10 + 4), r11);
    }

    public void checkCondition(boolean r5) {
        checkCondition(r5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ATN deserialize(char[] r22) {
        char[] r10 = (char[]) r22.clone();
        int r5 = 1;
    L4:
        if (r5 >= r10.length) goto L6;
        r10[r5] = (char) (r10[r5] - 2);
        r5 = r5 + 1;
        goto L4
    L6:
        int r11 = toInt(r10[0]);
        int r12 = SERIALIZED_VERSION;
        if (r11 != r12) goto L214;
        UUID r13 = toUUID(r10, 1);
        if (SUPPORTED_UUIDS.contains(r13) == false) goto L211;
        boolean r14 = isFeatureSupported(ADDED_PRECEDENCE_TRANSITIONS, r13);
        boolean r15 = isFeatureSupported(ADDED_LEXER_ACTIONS, r13);
        ATN r16 = new ATN(ATNType.values()[toInt(r10[9])], toInt(r10[10]));
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        int r19 = toInt(r10[11]);
        int r20 = 12;
        int r21 = 0;
    L11:
        int r23 = 65535;
        if (r21 >= r19) goto L28;
        int r110 = r20 + 1;
        int r111 = toInt(r10[r20]);
        if (r111 != 0) goto L16;
        r16.addState(null);
        r20 = r110;
    L27:
        r21 = r21 + 1;
        goto L11
    L16:
        int r112 = r20 + 2;
        int r113 = toInt(r10[r110]);
        if (r113 != 65535) goto L19;
        r113 = -1;
    L19:
        ATNState r24 = stateFactory(r111, r113);
        if (r111 != 12) goto L24;
        int r25 = r20 + 3;
        r17.add(new Pair((LoopEndState) r24, Integer.valueOf(toInt(r10[r112]))));
    L22:
        r112 = r25;
    L26:
        r16.addState(r24);
        r20 = r112;
        goto L27
    L24:
        if ((r24 instanceof BlockStartState) == false) goto L26;
        r25 = r20 + 3;
        r18.add(new Pair((BlockStartState) r24, Integer.valueOf(toInt(r10[r112]))));
        goto L22
    L28:
        Iterator r26 = r17.iterator();
    L30:
        if (r26.hasNext() == false) goto L32;
        Pair r27 = (Pair) r26.next();
        ((LoopEndState) r27.f667a).loopBackState = r16.states.get(((Integer) r27.f668b).intValue());
        goto L30
    L32:
        Iterator r28 = r18.iterator();
    L34:
        if (r28.hasNext() == false) goto L36;
        Pair r29 = (Pair) r28.next();
        ((BlockStartState) r29.f667a).endState = (BlockEndState) r16.states.get(((Integer) r29.f668b).intValue());
        goto L34
    L36:
        int r30 = toInt(r10[r20]);
        int r31 = r20 + 1;
        int r32 = 0;
    L37:
        if (r32 >= r30) goto L39;
        int r33 = r31 + 1;
        ((DecisionState) r16.states.get(toInt(r10[r31]))).nonGreedy = true;
        r32 = r32 + 1;
        r31 = r33;
        goto L37
    L39:
        if (r14 == false) goto L43;
        int r34 = toInt(r10[r31]);
        r31 = r31 + 1;
        int r35 = 0;
    L41:
        if (r35 >= r34) goto L43;
        int r36 = r31 + 1;
        ((RuleStartState) r16.states.get(toInt(r10[r31]))).isLeftRecursiveRule = true;
        r35 = r35 + 1;
        r31 = r36;
    L43:
        int r37 = r31 + 1;
        int r38 = toInt(r10[r31]);
        if (r16.grammarType != ATNType.LEXER) goto L46;
        r16.ruleToTokenType = new int[r38];
    L46:
        r16.ruleToStartState = new RuleStartState[r38];
        int r39 = r37;
        int r40 = 0;
    L47:
        if (r40 >= r38) goto L59;
        int r41 = r39 + 1;
        r16.ruleToStartState[r40] = (RuleStartState) r16.states.get(toInt(r10[r39]));
        if (r16.grammarType != ATNType.LEXER) goto L57;
        int r42 = r39 + 2;
        int r43 = toInt(r10[r41]);
        if (r43 != 65535) goto L53;
        r43 = -1;
    L53:
        r16.ruleToTokenType[r40] = r43;
        if (isFeatureSupported(ADDED_LEXER_ACTIONS, r13) == true) goto L56;
        r39 = r39 + 3;
        toInt(r10[r42]);
    L58:
        r40 = r40 + 1;
        goto L47
    L56:
        r39 = r42;
        goto L58
    L57:
        r39 = r41;
        goto L58
    L59:
        r16.ruleToStopState = new RuleStopState[r38];
        Iterator<ATNState> r44 = r16.states.iterator();
    L61:
        if (r44.hasNext() == false) goto L66;
        ATNState r45 = r44.next();
        if ((r45 instanceof RuleStopState) == false) goto L61;
        RuleStopState r46 = (RuleStopState) r45;
        RuleStopState[] r47 = r16.ruleToStopState;
        int r48 = r45.ruleIndex;
        r47[r48] = r46;
        r16.ruleToStartState[r48].stopState = r46;
        goto L61
    L66:
        int r49 = toInt(r10[r39]);
        int r50 = r39 + 1;
        int r51 = 0;
    L67:
        if (r51 >= r49) goto L69;
        int r52 = r50 + 1;
        r16.modeToStartState.add((TokensStartState) r16.states.get(toInt(r10[r50])));
        r51 = r51 + 1;
        r50 = r52;
        goto L67
    L69:
        List<IntervalSet> r114 = new ArrayList();
        int r53 = deserializeSets(r10, r50, r114, getUnicodeDeserializer(UnicodeDeserializingMode.UNICODE_BMP));
        if (isFeatureSupported(ADDED_UNICODE_SMP, r13) == false) goto L72;
        r53 = deserializeSets(r10, r53, r114, getUnicodeDeserializer(UnicodeDeserializingMode.UNICODE_SMP));
    L72:
        int r115 = toInt(r10[r53]);
        int r116 = r53 + 1;
        int r54 = 0;
    L73:
        if (r54 >= r115) goto L75;
        int r55 = toInt(r10[r116]);
        r16.states.get(r55).addTransition(edgeFactory(r16, toInt(r10[r116 + 2]), r55, toInt(r10[r116 + 1]), toInt(r10[r116 + 3]), toInt(r10[r116 + 4]), toInt(r10[r116 + 5]), r114));
        r116 = r116 + 6;
        r54 = r54 + 1;
        r23 = r23;
        r115 = r115;
        goto L73
    L75:
        int r117 = r23;
        Iterator<ATNState> r56 = r16.states.iterator();
    L77:
        if (r56.hasNext() == false) goto L92;
        ATNState r57 = r56.next();
        int r58 = 0;
    L80:
        if (r58 >= r57.getNumberOfTransitions()) goto L77;
        Transition r59 = r57.transition(r58);
        if ((r59 instanceof RuleTransition) == false) goto L91;
        RuleTransition r60 = (RuleTransition) r59;
        RuleStartState[] r61 = r16.ruleToStartState;
        int r62 = r60.target.ruleIndex;
        if (r61[r62].isLeftRecursiveRule == true) goto L87;
    L89:
        r62 = -1;
    L90:
        r16.ruleToStopState[r60.target.ruleIndex].addTransition(new EpsilonTransition(r60.followState, r62));
        goto L91
    L87:
        if (r60.precedence != 0) goto L89;
    L91:
        r58 = r58 + 1;
        goto L80
    L92:
        Iterator<ATNState> r63 = r16.states.iterator();
    L94:
        if (r63.hasNext() == false) goto L124;
        ATNState r64 = r63.next();
        if ((r64 instanceof BlockStartState) == false) goto L107;
        BlockStartState r65 = (BlockStartState) r64;
        BlockEndState r66 = r65.endState;
        if (r66 == null) goto L105;
        if (r66.startState != null) goto L103;
        r66.startState = r65;
        goto L107
    L103:
        throw new IllegalStateException();
    L105:
        throw new IllegalStateException();
    L107:
        if ((r64 instanceof PlusLoopbackState) == true) goto L108;
        if ((r64 instanceof StarLoopbackState) == false) goto L94;
        StarLoopbackState r67 = (StarLoopbackState) r64;
        int r68 = 0;
    L119:
        if (r68 >= r67.getNumberOfTransitions()) goto L94;
        ATNState r69 = r67.transition(r68).target;
        if ((r69 instanceof StarLoopEntryState) == false) goto L123;
        ((StarLoopEntryState) r69).loopBackState = r67;
    L123:
        r68 = r68 + 1;
        goto L119
    L108:
        PlusLoopbackState r70 = (PlusLoopbackState) r64;
        int r71 = 0;
    L110:
        if (r71 >= r70.getNumberOfTransitions()) goto L94;
        ATNState r72 = r70.transition(r71).target;
        if ((r72 instanceof PlusBlockStartState) == false) goto L114;
        ((PlusBlockStartState) r72).loopBackState = r70;
    L114:
        r71 = r71 + 1;
        goto L110
    L124:
        int r73 = r116 + 1;
        int r74 = toInt(r10[r116]);
        int r75 = 1;
    L125:
        if (r75 > r74) goto L128;
        int r76 = r73 + 1;
        DecisionState r77 = (DecisionState) r16.states.get(toInt(r10[r73]));
        r16.decisionToState.add(r77);
        r77.decision = r75 - 1;
        r75 = r75 + 1;
        r73 = r76;
        goto L125
    L128:
        if (r16.grammarType != ATNType.LEXER) goto L152;
        if (r15 == false) goto L140;
        int r78 = r73 + 1;
        r16.lexerActions = new LexerAction[toInt(r10[r73])];
        int r79 = 0;
    L132:
        if (r79 >= r16.lexerActions.length) goto L152;
        LexerActionType r80 = LexerActionType.values()[toInt(r10[r78])];
        int r81 = r78 + 2;
        int r82 = toInt(r10[r78 + 1]);
        if (r82 != r117) goto L136;
        r82 = -1;
    L136:
        r78 = r78 + 3;
        int r83 = toInt(r10[r81]);
        if (r83 != r117) goto L139;
        r83 = -1;
    L139:
        r16.lexerActions[r79] = lexerActionFactory(r80, r82, r83);
        r79 = r79 + 1;
        goto L132
    L140:
        ArrayList r84 = new ArrayList();
        Iterator<ATNState> r85 = r16.states.iterator();
    L142:
        if (r85.hasNext() == false) goto L151;
        ATNState r86 = r85.next();
        int r87 = 0;
    L145:
        if (r87 >= r86.getNumberOfTransitions()) goto L142;
        Transition r88 = r86.transition(r87);
        if ((r88 instanceof ActionTransition) == false) goto L150;
        ActionTransition r89 = (ActionTransition) r88;
        int r90 = r89.ruleIndex;
        LexerCustomAction r91 = new LexerCustomAction(r90, r89.actionIndex);
        r86.setTransition(r87, new ActionTransition(r88.target, r90, r84.size(), false));
        r84.add(r91);
    L150:
        r87 = r87 + 1;
        goto L145
    L151:
        r16.lexerActions = (LexerAction[]) r84.toArray(new LexerAction[r84.size()]);
    L152:
        markPrecedenceDecisions(r16);
        if (this.deserializationOptions.isVerifyATN() == false) goto L156;
        verifyATN(r16);
    L156:
        if (this.deserializationOptions.isGenerateRuleBypassTransitions() == true) goto L158;
    L210:
        return r16;
    L158:
        if (r16.grammarType != ATNType.PARSER) goto L210;
        r16.ruleToTokenType = new int[r16.ruleToStartState.length];
        int r92 = 0;
    L161:
        if (r92 >= r16.ruleToStartState.length) goto L163;
        r16.ruleToTokenType[r92] = (r16.maxTokenType + r92) + 1;
        r92 = r92 + 1;
        goto L161
    L163:
        int r118 = 0;
    L165:
        if (r118 >= r16.ruleToStartState.length) goto L208;
        BasicBlockStartState r93 = new BasicBlockStartState();
        r93.ruleIndex = r118;
        r16.addState(r93);
        BlockEndState r94 = new BlockEndState();
        r94.ruleIndex = r118;
        r16.addState(r94);
        r93.endState = r94;
        r16.defineDecisionState(r93);
        r94.startState = r93;
        if (r16.ruleToStartState[r118].isLeftRecursiveRule == false) goto L190;
        Iterator<ATNState> r95 = r16.states.iterator();
    L170:
        if (r95.hasNext() == false) goto L185;
        ATNState r96 = r95.next();
        if (r96.ruleIndex != r118) goto L170;
        if ((r96 instanceof StarLoopEntryState) == false) goto L170;
        ATNState r97 = r96.transition(r96.getNumberOfTransitions() - 1).target;
        if ((r97 instanceof LoopEndState) == false) goto L170;
        if (r97.epsilonOnlyTransitions == false) goto L170;
        if ((r97.transition(0).target instanceof RuleStopState) == false) goto L170;
    L186:
        if (r96 == null) goto L189;
        Transition r98 = ((StarLoopEntryState) r96).loopBackState.transition(0);
    L191:
        Iterator<ATNState> r99 = r16.states.iterator();
    L193:
        if (r99.hasNext() == false) goto L204;
        Iterator<Transition> r100 = r99.next().transitions.iterator();
    L196:
        if (r100.hasNext() == false) goto L193;
        Transition r101 = r100.next();
        if (r101 == r98) goto L196;
        if (r101.target != r96) goto L196;
        r101.target = r94;
    L204:
        if (r16.ruleToStartState[r118].getNumberOfTransitions() <= 0) goto L206;
        RuleStartState r102 = r16.ruleToStartState[r118];
        r93.addTransition(r102.removeTransition(r102.getNumberOfTransitions() - 1));
        goto L204
    L206:
        r16.ruleToStartState[r118].addTransition(new EpsilonTransition(r93));
        r94.addTransition(new EpsilonTransition(r96));
        ATNState r103 = new BasicState();
        r16.addState(r103);
        r103.addTransition(new AtomTransition(r94, r16.ruleToTokenType[r118]));
        r93.addTransition(new EpsilonTransition(r103));
        r118 = r118 + 1;
        goto L165
    L189:
        throw new UnsupportedOperationException("Couldn't identify final state of the precedence rule prefix section.");
    L185:
        r96 = null;
        goto L186
    L190:
        r96 = r16.ruleToStopState[r118];
        r98 = null;
        goto L191
    L208:
        if (this.deserializationOptions.isVerifyATN() == false) goto L210;
        verifyATN(r16);
        goto L210
    L211:
        Locale.getDefault();
        throw new UnsupportedOperationException(new InvalidClassException(ATN.class.getName(), "Could not deserialize ATN with UUID " + r13 + " (expected " + SERIALIZED_UUID + " or a legacy UUID)."));
    L214:
        throw new UnsupportedOperationException(new InvalidClassException(ATN.class.getName(), String.format(Locale.getDefault(), "Could not deserialize ATN with version %d (expected %d).", new Object[]{Integer.valueOf(r11), Integer.valueOf(r12)})));
    }

    public Transition edgeFactory(ATN r5, int r10, int r11, int r12, int r13, int r14, int r15, List<IntervalSet> r16) {
        ATNState r17 = r5.states.get(r12);
        boolean r18 = false;
        switch(r10) {
            case 1: goto L37;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L25;
            case 5: goto L19;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            default: goto L5;
        };
    L19:
        if (r15 == 0) goto L23;
        return new AtomTransition(r17, -1);
    L23:
        return new AtomTransition(r17, r13);
    L31:
        if (r15 == 0) goto L35;
        return new RangeTransition(r17, -1, r14);
    L35:
        return new RangeTransition(r17, r13, r14);
    L5:
        throw new IllegalArgumentException("The specified transition type is not valid.");
    L7:
        return new PrecedencePredicateTransition(r17, r13);
    L9:
        return new WildcardTransition(r17);
    L11:
        return new NotSetTransition(r17, r16.get(r13));
    L13:
        return new SetTransition(r17, r16.get(r13));
    L15:
        if (r15 == 0) goto L18;
        r18 = true;
    L18:
        return new ActionTransition(r17, r13, r14, r18);
    L25:
        if (r15 == 0) goto L28;
        r18 = true;
    L28:
        return new PredicateTransition(r17, r13, r14, r18);
    L30:
        return new RuleTransition((RuleStartState) r5.states.get(r13), r14, r15, r17);
    L37:
        return new EpsilonTransition(r17);
    }

    public LexerAction lexerActionFactory(LexerActionType r5, int r10, int r11) {
        switch(AnonymousClass3.$SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[r5.ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException(String.format(Locale.getDefault(), "The specified lexer action type %d is not valid.", new Object[]{r5}));
    L7:
        return new LexerTypeAction(r10);
    L9:
        return LexerSkipAction.INSTANCE;
    L11:
        return new LexerPushModeAction(r10);
    L13:
        return LexerPopModeAction.INSTANCE;
    L15:
        return LexerMoreAction.INSTANCE;
    L17:
        return new LexerModeAction(r10);
    L19:
        return new LexerCustomAction(r10, r11);
    L21:
        return new LexerChannelAction(r10);
    }

    public void markPrecedenceDecisions(ATN r5) {
        Iterator<ATNState> r10 = r5.states.iterator();
    L4:
        if (r10.hasNext() == false) goto L17;
        ATNState r11 = r10.next();
        if ((r11 instanceof StarLoopEntryState) == false) goto L4;
        if (r5.ruleToStartState[r11.ruleIndex].isLeftRecursiveRule == false) goto L4;
        ATNState r12 = r11.transition(r11.getNumberOfTransitions() - 1).target;
        if ((r12 instanceof LoopEndState) == false) goto L4;
        if (r12.epsilonOnlyTransitions == false) goto L4;
        if ((r12.transition(0).target instanceof RuleStopState) == false) goto L4;
        ((StarLoopEntryState) r11).isPrecedenceDecision = true;
        goto L4
    }

    public ATNState stateFactory(int r5, int r10) {
        switch(r5) {
            case 0: goto L19;
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L4;
        };
    L5:
        ATNState r11 = new LoopEndState();
    L17:
        r11.ruleIndex = r10;
        return r11;
    L6:
        r11 = new PlusLoopbackState();
        goto L17
    L7:
        r11 = new StarLoopEntryState();
        goto L17
    L8:
        r11 = new StarLoopbackState();
        goto L17
    L9:
        r11 = new BlockEndState();
        goto L17
    L10:
        r11 = new RuleStopState();
        goto L17
    L11:
        r11 = new TokensStartState();
        goto L17
    L12:
        r11 = new StarBlockStartState();
        goto L17
    L13:
        r11 = new PlusBlockStartState();
        goto L17
    L14:
        r11 = new BasicBlockStartState();
        goto L17
    L15:
        r11 = new RuleStartState();
        goto L17
    L16:
        r11 = new BasicState();
        goto L17
    L19:
        return null;
    L4:
        throw new IllegalArgumentException(String.format(Locale.getDefault(), "The specified state type %d is not valid.", new Object[]{Integer.valueOf(r5)}));
    }

    public void verifyATN(ATN r10) {
        Iterator<ATNState> r11 = r10.states.iterator();
    L4:
        if (r11.hasNext() == false) goto L89;
        ATNState r5 = r11.next();
        if (r5 == null) goto L4;
        boolean r12 = false;
        if (r5.onlyHasEpsilonTransitions() == false) goto L11;
    L14:
        boolean r13 = true;
    L15:
        checkCondition(r13);
        if ((r5 instanceof PlusBlockStartState) == false) goto L23;
        if (((PlusBlockStartState) r5).loopBackState == null) goto L20;
        boolean r14 = true;
    L21:
        checkCondition(r14);
        goto L23
    L20:
        r14 = false;
    L23:
        if ((r5 instanceof StarLoopEntryState) == false) goto L41;
        StarLoopEntryState r15 = (StarLoopEntryState) r5;
        if (r15.loopBackState == null) goto L27;
        boolean r16 = true;
    L28:
        checkCondition(r16);
        if (r15.getNumberOfTransitions() != 2) goto L31;
        boolean r17 = true;
    L32:
        checkCondition(r17);
        if ((r15.transition(0).target instanceof StarBlockStartState) == false) goto L36;
        checkCondition(r15.transition(1).target instanceof LoopEndState);
        checkCondition(!r15.nonGreedy);
        goto L41
    L36:
        if ((r15.transition(0).target instanceof LoopEndState) == false) goto L39;
        checkCondition(r15.transition(1).target instanceof StarBlockStartState);
        checkCondition(r15.nonGreedy);
        goto L41
    L39:
        throw new IllegalStateException();
    L31:
        r17 = false;
        goto L32
    L27:
        r16 = false;
    L41:
        if ((r5 instanceof StarLoopbackState) == false) goto L48;
        if (r5.getNumberOfTransitions() != 1) goto L45;
        boolean r18 = true;
    L46:
        checkCondition(r18);
        checkCondition(r5.transition(0).target instanceof StarLoopEntryState);
        goto L48
    L45:
        r18 = false;
    L48:
        if ((r5 instanceof LoopEndState) == false) goto L55;
        if (((LoopEndState) r5).loopBackState == null) goto L52;
        boolean r19 = true;
    L53:
        checkCondition(r19);
        goto L55
    L52:
        r19 = false;
    L55:
        if ((r5 instanceof RuleStartState) == false) goto L62;
        if (((RuleStartState) r5).stopState == null) goto L59;
        boolean r20 = true;
    L60:
        checkCondition(r20);
        goto L62
    L59:
        r20 = false;
    L62:
        if ((r5 instanceof BlockStartState) == false) goto L69;
        if (((BlockStartState) r5).endState == null) goto L66;
        boolean r21 = true;
    L67:
        checkCondition(r21);
        goto L69
    L66:
        r21 = false;
    L69:
        if ((r5 instanceof BlockEndState) == false) goto L76;
        if (((BlockEndState) r5).startState == null) goto L73;
        boolean r22 = true;
    L74:
        checkCondition(r22);
        goto L76
    L73:
        r22 = false;
    L76:
        if ((r5 instanceof DecisionState) == true) goto L77;
        if (r5.getNumberOfTransitions() > 1) goto L86;
    L87:
        r12 = true;
    L88:
        checkCondition(r12);
        goto L4
    L86:
        if ((r5 instanceof RuleStopState) == false) goto L88;
    L77:
        DecisionState r23 = (DecisionState) r5;
        if (r23.getNumberOfTransitions() > 1) goto L80;
    L81:
        r12 = true;
    L82:
        checkCondition(r12);
        goto L4
    L80:
        if (r23.decision < 0) goto L82;
    L11:
        if (r5.getNumberOfTransitions() <= 1) goto L14;
        r13 = false;
        goto L15
    }

    public ATNDeserializer(ATNDeserializationOptions r5) {
        if (r5 != null) goto L5;
        r5 = ATNDeserializationOptions.getDefaultOptions();
    L5:
        this.deserializationOptions = r5;
    }

    public void checkCondition(boolean r5, String r10) {
        if (r5 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r10);
    }
}
