package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntegerList;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class ATNSerializer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public ATN atn;
    private List<String> tokenNames;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSerializer$3, reason: invalid class name */
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

    public interface CodePointSerializer {
        void serializeCodePoint(IntegerList r5, int r10);
    }

    public ATNSerializer(ATN r5) {
        this.atn = r5;
    }

    public static /* synthetic */ void access$000(ATNSerializer r5, IntegerList r10, int r11) {
        r5.serializeInt(r10, r11);
    }

    private int appendSets(StringBuilder r10, char[] r11, int r12, int r13, int r14, ATNDeserializer.UnicodeDeserializer r15) {
        int r5 = 0;
    L3:
        if (r5 >= r13) goto L17;
        int r16 = r12 + 1;
        int r17 = ATNDeserializer.toInt(r11[r12]);
        r10.append(r5 + r14);
        r10.append(":");
        r12 = r12 + 2;
        if (r11[r16] == 0) goto L7;
        boolean r18 = true;
    L8:
        if (r18 == false) goto L10;
        r10.append(getTokenName(-1));
    L10:
        int r19 = 0;
    L11:
        if (r19 >= r17) goto L16;
        if (r18 == true) goto L14;
        if (r19 > 0) goto L14;
    L15:
        int r20 = r15.readUnicode(r11, r12);
        int r110 = r12 + r15.size();
        int r21 = r15.readUnicode(r11, r110);
        r12 = r110 + r15.size();
        r10.append(getTokenName(r20));
        r10.append("..");
        r10.append(getTokenName(r21));
        r19 = r19 + 1;
    L14:
        r10.append(", ");
        goto L15
    L16:
        r10.append("\n");
        r5 = r5 + 1;
        goto L3
    L7:
        r18 = false;
        goto L8
    L17:
        return r12;
    }

    public static String getDecoded(ATN r5, List<String> r10) {
        char[] r11 = Utils.toCharArray(getSerialized(r5));
        return new ATNSerializer(r5, r10).decode(r11);
    }

    public static IntegerList getSerialized(ATN r5) {
        return new ATNSerializer(r5).serialize();
    }

    public static char[] getSerializedAsChars(ATN r5) {
        return Utils.toCharArray(getSerialized(r5));
    }

    public static String getSerializedAsString(ATN r5) {
        return new String(getSerializedAsChars(r5));
    }

    private void serializeInt(IntegerList r5, int r10) {
        r5.add((char) r10);
        r5.add((char) (r10 >> 16));
    }

    private void serializeLong(IntegerList r5, long r10) {
        serializeInt(r5, (int) r10);
        serializeInt(r5, (int) (r10 >> 32));
    }

    private static void serializeSets(IntegerList r5, Collection<IntervalSet> r10, CodePointSerializer r11) {
        r5.add(r10.size());
        Iterator<IntervalSet> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L22;
        IntervalSet r13 = r12.next();
        boolean r14 = r13.contains(-1);
        if (r14 == true) goto L8;
    L10:
        r5.add(r13.getIntervals().size());
    L11:
        r5.add(r14 ? 1 : 0);
        Iterator<Interval> r15 = r13.getIntervals().iterator();
    L13:
        if (r15.hasNext() == false) goto L4;
        Interval r16 = r15.next();
        int r17 = r16.f665a;
        if (r17 != (-1)) goto L20;
        if (r16.f666b == (-1)) goto L13;
        r11.serializeCodePoint(r5, 0);
    L21:
        r11.serializeCodePoint(r5, r16.f666b);
        goto L13
    L20:
        r11.serializeCodePoint(r5, r17);
        goto L21
    L8:
        if (r13.getIntervals().get(0).f666b != (-1)) goto L10;
        r5.add(r13.getIntervals().size() - 1);
        goto L11
    }

    private void serializeUUID(IntegerList r5, UUID r10) {
        serializeLong(r5, r10.getLeastSignificantBits());
        serializeLong(r5, r10.getMostSignificantBits());
    }

    public String decode(char[] r17) {
        char[] r10 = (char[]) r17.clone();
        int r5 = 1;
    L4:
        if (r5 >= r10.length) goto L6;
        r10[r5] = (char) (r10[r5] - 2);
        r5 = r5 + 1;
        goto L4
    L6:
        StringBuilder r11 = new StringBuilder();
        int r12 = ATNDeserializer.toInt(r10[0]);
        int r13 = ATNDeserializer.SERIALIZED_VERSION;
        if (r12 != r13) goto L64;
        UUID r14 = ATNDeserializer.toUUID(r10, 1);
        UUID r15 = ATNDeserializer.SERIALIZED_UUID;
        if (r14.equals(r15) == false) goto L61;
        int r16 = ATNDeserializer.toInt(r10[10]);
        r11.append("max type ");
        r11.append(r16);
        r11.append("\n");
        int r18 = ATNDeserializer.toInt(r10[11]);
        int r19 = 12;
        int r20 = 0;
    L12:
        if (r20 >= r18) goto L32;
        int r21 = r19 + 1;
        int r22 = ATNDeserializer.toInt(r10[r19]);
        if (r22 != 0) goto L16;
        r19 = r21;
    L31:
        r20 = r20 + 1;
        goto L12
    L16:
        int r110 = r19 + 2;
        int r23 = ATNDeserializer.toInt(r10[r21]);
        if (r23 != 65535) goto L19;
        r23 = -1;
    L19:
        if (r22 != 12) goto L23;
        int r24 = r19 + 3;
        String r111 = j0.g(ATNDeserializer.toInt(r10[r110]), " ");
    L21:
        r110 = r24;
    L30:
        r11.append(r20);
        r11.append(":");
        r11.append(ATNState.serializationNames.get(r22));
        r11.append(" ");
        r11.append(r23);
        r11.append(r111);
        r11.append("\n");
        r19 = r110;
        goto L31
    L23:
        if (r22 != 4) goto L25;
    L29:
        r24 = r19 + 3;
        r111 = j0.g(ATNDeserializer.toInt(r10[r110]), " ");
        goto L21
    L25:
        if (r22 == 5) goto L29;
        if (r22 == 3) goto L29;
        r111 = "";
        goto L30
    L32:
        int r25 = r19 + 1;
        int r26 = ATNDeserializer.toInt(r10[r19]);
        int r27 = 0;
    L33:
        if (r27 >= r26) goto L35;
        ATNDeserializer.toInt(r10[r25]);
        r27 = r27 + 1;
        r25 = r25 + 1;
        goto L33
    L35:
        int r28 = r25 + 1;
        int r29 = ATNDeserializer.toInt(r10[r25]);
        int r30 = 0;
    L36:
        if (r30 >= r29) goto L38;
        ATNDeserializer.toInt(r10[r28]);
        r30 = r30 + 1;
        r28 = r28 + 1;
        goto L36
    L38:
        int r31 = r28 + 1;
        int r32 = ATNDeserializer.toInt(r10[r28]);
        int r33 = 0;
    L39:
        if (r33 >= r32) goto L45;
        int r34 = r31 + 1;
        int r35 = ATNDeserializer.toInt(r10[r31]);
        if (this.atn.grammarType != ATNType.LEXER) goto L43;
        r31 = r31 + 2;
        int r36 = ATNDeserializer.toInt(r10[r34]);
        r11.append("rule ");
        r11.append(r33);
        r11.append(":");
        r11.append(r35);
        r11.append(" ");
        r11.append(r36);
        r11.append('\n');
    L44:
        r33 = r33 + 1;
        goto L39
    L43:
        r11.append("rule ");
        r11.append(r33);
        r11.append(":");
        r11.append(r35);
        r11.append('\n');
        r31 = r34;
        goto L44
    L45:
        int r37 = r31 + 1;
        int r38 = ATNDeserializer.toInt(r10[r31]);
        int r39 = 0;
    L46:
        if (r39 >= r38) goto L48;
        int r40 = r37 + 1;
        int r41 = ATNDeserializer.toInt(r10[r37]);
        r11.append("mode ");
        r11.append(r39);
        r11.append(":");
        r11.append(r41);
        r11.append('\n');
        r39 = r39 + 1;
        r37 = r40;
        goto L46
    L48:
        int r112 = ATNDeserializer.toInt(r10[r37]);
        int r42 = appendSets(r11, r10, r37 + 1, r112, 0, ATNDeserializer.getUnicodeDeserializer(ATNDeserializer.UnicodeDeserializingMode.UNICODE_BMP));
        int r43 = appendSets(r11, r10, r42 + 1, ATNDeserializer.toInt(r10[r42]), r112, ATNDeserializer.getUnicodeDeserializer(ATNDeserializer.UnicodeDeserializingMode.UNICODE_SMP));
        int r44 = r43 + 1;
        int r45 = ATNDeserializer.toInt(r10[r43]);
        int r46 = 0;
    L49:
        if (r46 >= r45) goto L51;
        int r47 = ATNDeserializer.toInt(r10[r44]);
        int r48 = ATNDeserializer.toInt(r10[r44 + 1]);
        int r49 = ATNDeserializer.toInt(r10[r44 + 2]);
        int r50 = ATNDeserializer.toInt(r10[r44 + 3]);
        int r113 = ATNDeserializer.toInt(r10[r44 + 4]);
        int r114 = ATNDeserializer.toInt(r10[r44 + 5]);
        r11.append(r47);
        r11.append("->");
        r11.append(r48);
        r11.append(" ");
        r11.append(Transition.serializationNames.get(r49));
        r11.append(" ");
        r11.append(r50);
        r11.append(",");
        r11.append(r113);
        r11.append(",");
        r11.append(r114);
        r11.append("\n");
        r44 = r44 + 6;
        r46 = r46 + 1;
        goto L49
    L51:
        int r51 = r44 + 1;
        int r52 = ATNDeserializer.toInt(r10[r44]);
        int r53 = 0;
    L52:
        if (r53 >= r52) goto L55;
        int r54 = r51 + 1;
        int r55 = ATNDeserializer.toInt(r10[r51]);
        r11.append(r53);
        r11.append(":");
        r11.append(r55);
        r11.append("\n");
        r53 = r53 + 1;
        r51 = r54;
        goto L52
    L55:
        if (this.atn.grammarType != ATNType.LEXER) goto L60;
        int r56 = r51 + 1;
        int r57 = ATNDeserializer.toInt(r10[r51]);
        int r115 = 0;
    L57:
        if (r115 >= r57) goto L60;
        LexerActionType r58 = LexerActionType.values()[ATNDeserializer.toInt(r10[r56])];
        int r59 = r56 + 2;
        ATNDeserializer.toInt(r10[r56 + 1]);
        r56 = r56 + 3;
        ATNDeserializer.toInt(r10[r59]);
        r115 = r115 + 1;
    L60:
        return r11.toString();
    L61:
        Locale.getDefault();
        throw new UnsupportedOperationException(new InvalidClassException(ATN.class.getName(), "Could not deserialize ATN with UUID " + r14 + " (expected " + r15 + ")."));
    L64:
        throw new UnsupportedOperationException(new InvalidClassException(ATN.class.getName(), String.format("Could not deserialize ATN with version %d (expected %d).", new Object[]{Integer.valueOf(r12), Integer.valueOf(r13)})));
    }

    public String getTokenName(int r5) {
        if (r5 != (-1)) goto L7;
        return "EOF";
    L7:
        if (this.atn.grammarType != ATNType.LEXER) goto L42;
        if (r5 < 0) goto L42;
        if (r5 > 65535) goto L42;
        if (r5 != 12) goto L14;
        return "'\\f'";
    L14:
        if (r5 != 13) goto L16;
        return "'\\r'";
    L16:
        if (r5 != 39) goto L18;
        return "'\\''";
    L18:
        if (r5 == 92) goto L34;
        switch(r5) {
            case 8: goto L32;
            case 9: goto L30;
            case 10: goto L28;
            default: goto L20;
        };
    L20:
        char r10 = (char) r5;
        if (Character.UnicodeBlock.of(r10) != Character.UnicodeBlock.BASIC_LATIN) goto L27;
        if (Character.isISOControl(r10) == true) goto L27;
        return "'" + Character.toString(r10) + '\'';
    L27:
        return j0.k("'\\u", Integer.toHexString(65536 | r5).toUpperCase().substring(1, 5), "'");
    L28:
        return "'\\n'";
    L30:
        return "'\\t'";
    L32:
        return "'\\b'";
    L34:
        return "'\\\\'";
    L42:
        List<String> r11 = this.tokenNames;
        if (r11 == null) goto L50;
        if (r5 < 0) goto L50;
        if (r5 >= r11.size()) goto L50;
        return this.tokenNames.get(r5);
    L50:
        return String.valueOf(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12, types: [int] */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r17v0, types: [androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSerializer] */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntegerList] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v45 */
    /* JADX WARN: Type inference failed for: r8v46 */
    public IntegerList serialize() {
        ?? r5 = new IntegerList();
        r5.add(ATNDeserializer.SERIALIZED_VERSION);
        serializeUUID(r5, ATNDeserializer.SERIALIZED_UUID);
        r5.add(this.atn.grammarType.ordinal());
        r5.add(this.atn.maxTokenType);
        LinkedHashMap r10 = new LinkedHashMap();
        IntegerList r11 = new IntegerList();
        IntegerList r12 = new IntegerList();
        r5.add(this.atn.states.size());
        Iterator<ATNState> r13 = this.atn.states.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L40;
        ATNState r15 = r13.next();
        if (r15 == null) goto L7;
        int r16 = r15.getStateType();
        if ((r15 instanceof DecisionState) == false) goto L14;
        if (((DecisionState) r15).nonGreedy == false) goto L14;
        r11.add(r15.stateNumber);
    L14:
        if ((r15 instanceof RuleStartState) == true) goto L16;
    L18:
        r5.add(r16);
        int r17 = r15.ruleIndex;
        if (r17 != (-1)) goto L21;
        r5.add(65535);
    L23:
        if (r15.getStateType() != 12) goto L26;
        r5.add(((LoopEndState) r15).loopBackState.stateNumber);
    L29:
        if (r15.getStateType() == 7) goto L31;
        r14 = r15.getNumberOfTransitions() + r14;
    L31:
        int r18 = 0;
    L33:
        if (r18 >= r15.getNumberOfTransitions()) goto L4;
        Transition r19 = r15.transition(r18);
        int r110 = Transition.serializationTypes.get(r19.getClass()).intValue();
        if (r110 != 7) goto L37;
    L38:
        r10.put(((SetTransition) r19).set, Boolean.TRUE);
    L39:
        r18 = r18 + 1;
        goto L33
    L37:
        if (r110 != 8) goto L39;
    L26:
        if ((r15 instanceof BlockStartState) == false) goto L29;
        r5.add(((BlockStartState) r15).endState.stateNumber);
        goto L29
    L21:
        r5.add(r17);
        goto L23
    L16:
        if (((RuleStartState) r15).isLeftRecursiveRule == false) goto L18;
        r12.add(r15.stateNumber);
        goto L18
    L7:
        r5.add(0);
        goto L4
    L40:
        r5.add(r11.size());
        int r20 = 0;
    L42:
        if (r20 >= r11.size()) goto L44;
        r5.add(r11.get(r20));
        r20 = r20 + 1;
        goto L42
    L44:
        r5.add(r12.size());
        int r21 = 0;
    L46:
        if (r21 >= r12.size()) goto L48;
        r5.add(r12.get(r21));
        r21 = r21 + 1;
        goto L46
    L48:
        int r22 = this.atn.ruleToStartState.length;
        r5.add(r22);
        int r23 = 0;
    L49:
        if (r23 >= r22) goto L57;
        r5.add(this.atn.ruleToStartState[r23].stateNumber);
        ATN r24 = this.atn;
        if (r24.grammarType != ATNType.LEXER) goto L56;
        int r25 = r24.ruleToTokenType[r23];
        if (r25 != (-1)) goto L55;
        r5.add(65535);
        goto L56
    L55:
        r5.add(r25);
    L56:
        r23 = r23 + 1;
        goto L49
    L57:
        int r26 = this.atn.modeToStartState.size();
        r5.add(r26);
        if (r26 <= 0) goto L63;
        Iterator<TokensStartState> r27 = this.atn.modeToStartState.iterator();
    L61:
        if (r27.hasNext() == false) goto L63;
        r5.add(r27.next().stateNumber);
    L63:
        ArrayList r28 = new ArrayList();
        ArrayList r29 = new ArrayList();
        Iterator r30 = r10.keySet().iterator();
    L65:
        if (r30.hasNext() == false) goto L70;
        IntervalSet r31 = (IntervalSet) r30.next();
        if (r31.getMaxElement() <= 65535) goto L68;
        r29.add(r31);
        goto L65
    L68:
        r28.add(r31);
        goto L65
    L70:
        serializeSets(r5, r28, new AnonymousClass1(this));
        serializeSets(r5, r29, new AnonymousClass2(this));
        HashMap r32 = new HashMap();
        Iterator r33 = r28.iterator();
        int r34 = 0;
    L72:
        if (r33.hasNext() == false) goto L74;
        r32.put((IntervalSet) r33.next(), Integer.valueOf(r34));
        r34 = r34 + 1;
        goto L72
    L74:
        Iterator r35 = r29.iterator();
    L76:
        if (r35.hasNext() == false) goto L78;
        r32.put((IntervalSet) r35.next(), Integer.valueOf(r34));
        r34 = r34 + 1;
        goto L76
    L78:
        r5.add(r14);
        Iterator<ATNState> r36 = this.atn.states.iterator();
    L80:
        if (r36.hasNext() == false) goto L117;
        ATNState r37 = r36.next();
        if (r37 == null) goto L80;
        if (r37.getStateType() == 7) goto L80;
        int r38 = 0;
    L89:
        if (r38 >= r37.getNumberOfTransitions()) goto L80;
        Transition r39 = r37.transition(r38);
        if (this.atn.states.get(r39.target.stateNumber) == null) goto L116;
        int r111 = r37.stateNumber;
        int r112 = r39.target.stateNumber;
        int r113 = Transition.serializationTypes.get(r39.getClass()).intValue();
        switch(r113) {
            case 2: goto L110;
            case 3: goto L109;
            case 4: goto L107;
            case 5: goto L104;
            case 6: goto L100;
            case 7: goto L99;
            case 8: goto L98;
            case 9: goto L94;
            case 10: goto L95;
            default: goto L94;
        };
    L94:
        int r40 = 0;
        int r41 = 0;
        int r114 = r112;
        ?? r115 = 0;
    L114:
        r5.add(r111);
        r5.add(r114);
        r5.add(r113);
        r5.add(r41);
        r5.add(r40);
        r5.add(r115);
        r38 = r38 + 1;
        goto L89
    L95:
        r41 = ((PrecedencePredicateTransition) r39).precedence;
    L96:
        r40 = 0;
    L97:
        r114 = r112;
        r115 = r40;
        goto L114
    L98:
        r41 = ((Integer) r32.get(((SetTransition) r39).set)).intValue();
        goto L96
    L99:
        r41 = ((Integer) r32.get(((SetTransition) r39).set)).intValue();
        goto L96
    L100:
        ActionTransition r42 = (ActionTransition) r39;
        int r116 = r42.ruleIndex;
        r40 = r42.actionIndex;
        if (r40 != (-1)) goto L103;
        r40 = 65535;
    L103:
        r115 = r42.isCtxDependent;
        r41 = r116;
        r114 = r112;
        goto L114
    L104:
        r41 = ((AtomTransition) r39).label;
        r40 = 0;
        if (r41 != (-1)) goto L97;
        r41 = 0;
        r114 = r112;
        r115 = 1;
        goto L114
    L107:
        PredicateTransition r43 = (PredicateTransition) r39;
        int r44 = r43.ruleIndex;
        int r117 = r43.predIndex;
        ?? r45 = r43.isCtxDependent;
    L108:
        ?? r118 = r45;
        r41 = r44;
        r40 = r117;
        r114 = r112;
        r115 = r118 == true ? 1 : 0;
        goto L114
    L109:
        RuleTransition r46 = (RuleTransition) r39;
        r112 = r46.followState.stateNumber;
        r44 = r46.target.stateNumber;
        r117 = r46.ruleIndex;
        r45 = r46.precedence;
        goto L108
    L110:
        RangeTransition r47 = (RangeTransition) r39;
        int r48 = r47.from;
        int r49 = r47.f661to;
        if (r48 != (-1)) goto L113;
        r40 = r49;
        r114 = r112;
        r115 = 1;
        r41 = 0;
        goto L114
    L113:
        r114 = r112;
        r115 = 0;
        r41 = r48;
        r40 = r49;
        goto L114
    L116:
        throw new IllegalStateException("Cannot serialize a transition to a removed state.");
    L117:
        r5.add(this.atn.decisionToState.size());
        Iterator<DecisionState> r50 = this.atn.decisionToState.iterator();
    L119:
        if (r50.hasNext() == false) goto L121;
        r5.add(r50.next().stateNumber);
        goto L119
    L121:
        ATN r51 = this.atn;
        if (r51.grammarType != ATNType.LEXER) goto L162;
        r5.add(r51.lexerActions.length);
        LexerAction[] r52 = this.atn.lexerActions;
        int r53 = r52.length;
        int r54 = 0;
    L124:
        if (r54 >= r53) goto L162;
        LexerAction r55 = r52[r54];
        r5.add(r55.getActionType().ordinal());
        switch(AnonymousClass3.$SwitchMap$org$antlr$v4$runtime$atn$LexerActionType[r55.getActionType().ordinal()]) {
            case 1: goto L156;
            case 2: goto L147;
            case 3: goto L142;
            case 4: goto L141;
            case 5: goto L140;
            case 6: goto L135;
            case 7: goto L134;
            case 8: goto L129;
            default: goto L127;
        };
    L129:
        int r56 = ((LexerTypeAction) r55).getType();
        if (r56 != (-1)) goto L133;
        r56 = 65535;
    L133:
        r5.add(r56);
        r5.add(0);
    L161:
        r54 = r54 + 1;
        goto L124
    L134:
        r5.add(0);
        r5.add(0);
        goto L161
    L135:
        int r57 = ((LexerPushModeAction) r55).getMode();
        if (r57 != (-1)) goto L139;
        r57 = 65535;
    L139:
        r5.add(r57);
        r5.add(0);
        goto L161
    L140:
        r5.add(0);
        r5.add(0);
        goto L161
    L141:
        r5.add(0);
        r5.add(0);
        goto L161
    L142:
        int r58 = ((LexerModeAction) r55).getMode();
        if (r58 != (-1)) goto L146;
        r58 = 65535;
    L146:
        r5.add(r58);
        r5.add(0);
        goto L161
    L147:
        LexerCustomAction r59 = (LexerCustomAction) r55;
        int r60 = r59.getRuleIndex();
        int r61 = r59.getActionIndex();
        if (r60 != (-1)) goto L151;
        r60 = 65535;
    L151:
        r5.add(r60);
        if (r61 != (-1)) goto L155;
        r61 = 65535;
    L155:
        r5.add(r61);
        goto L161
    L156:
        int r62 = ((LexerChannelAction) r55).getChannel();
        if (r62 != (-1)) goto L160;
        r62 = 65535;
    L160:
        r5.add(r62);
        r5.add(0);
        goto L161
    L127:
        Locale.getDefault();
        throw new IllegalArgumentException("The specified lexer action type " + r55.getActionType() + " is not valid.");
    L162:
        int r63 = 1;
    L164:
        if (r63 >= r5.size()) goto L172;
        if (r5.get(r63) < 0) goto L171;
        if (r5.get(r63) > 65535) goto L171;
        r5.set(r63, (r5.get(r63) + 2) & 65535);
        r63 = r63 + 1;
    L171:
        throw new UnsupportedOperationException("Serialized ATN data element " + r5.get(r63) + " element " + r63 + " out of range 0..65535");
    L172:
        return r5;
    }

    public ATNSerializer(ATN r5, List<String> r10) {
        this.atn = r5;
        this.tokenNames = r10;
    }
}
