package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.DoubleKeyMap;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class PredictionContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final EmptyPredictionContext EMPTY = null;
    public static final int EMPTY_RETURN_STATE = Integer.MAX_VALUE;
    private static final int INITIAL_HASH = 1;
    public static int globalNodeCount;
    public final int cachedHashCode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f660id;

    static {
        EMPTY = new EmptyPredictionContext();
        globalNodeCount = 0;
    }

    public PredictionContext(int r5) {
        int r10 = globalNodeCount;
        globalNodeCount = r10 + 1;
        this.f660id = r10;
        this.cachedHashCode = r5;
    }

    public static int calculateEmptyHashCode() {
        return MurmurHash.finish(MurmurHash.initialize(1), 0);
    }

    public static int calculateHashCode(PredictionContext r5, int r10) {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(1), r5), r10), 2);
    }

    public static void combineCommonParents(PredictionContext[] r5) {
        HashMap r10 = new HashMap();
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r5.length) goto L10;
        PredictionContext r13 = r5[r12];
        if (r10.containsKey(r13) == true) goto L8;
        r10.put(r13, r13);
    L8:
        r12 = r12 + 1;
    L10:
        if (r11 >= r5.length) goto L12;
        r5[r11] = (PredictionContext) r10.get(r5[r11]);
        r11 = r11 + 1;
        goto L10
    }

    public static PredictionContext fromRuleContext(ATN r5, RuleContext r10) {
        if (r10 != null) goto L4;
        r10 = RuleContext.EMPTY;
    L4:
        RuleContext r11 = r10.parent;
        if (r11 == null) goto L12;
        if (r10 == RuleContext.EMPTY) goto L12;
        return SingletonPredictionContext.create(fromRuleContext(r5, r11), ((RuleTransition) r5.states.get(r10.invokingState).transition(0)).followState.stateNumber);
    L12:
        return EMPTY;
    }

    public static List<PredictionContext> getAllContextNodes(PredictionContext r5) {
        ArrayList r10 = new ArrayList();
        getAllContextNodes_(r5, r10, new IdentityHashMap());
        return r10;
    }

    public static void getAllContextNodes_(PredictionContext r5, List<PredictionContext> r10, Map<PredictionContext, PredictionContext> r11) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r11.containsKey(r5) == true) goto L12;
        r11.put(r5, r5);
        r10.add(r5);
        int r12 = 0;
    L8:
        if (r12 >= r5.size()) goto L13;
        getAllContextNodes_(r5.getParent(r12), r10, r11);
        r12 = r12 + 1;
        goto L8
    L13:
        return;
    }

    public static PredictionContext getCachedContext(PredictionContext r10, PredictionContextCache r11, IdentityHashMap<PredictionContext, PredictionContext> r12) {
        if (r10.isEmpty() == false) goto L5;
        return r10;
    L5:
        PredictionContext r5 = r12.get(r10);
        if (r5 == null) goto L8;
        return r5;
    L8:
        PredictionContext r13 = r11.get(r10);
        if (r13 == null) goto L12;
        r12.put(r10, r13);
        return r13;
    L12:
        PredictionContext[] r14 = new PredictionContext[r10.size()];
        int r15 = 0;
        boolean r16 = false;
    L14:
        if (r15 >= r14.length) goto L27;
        PredictionContext r17 = getCachedContext(r10.getParent(r15), r11, r12);
        if (r16 == false) goto L18;
    L19:
        if (r16 == true) goto L25;
        r14 = new PredictionContext[r10.size()];
        int r18 = 0;
    L22:
        if (r18 >= r10.size()) goto L24;
        r14[r18] = r10.getParent(r18);
        r18 = r18 + 1;
        goto L22
    L24:
        r16 = true;
    L25:
        r14[r15] = r17;
    L26:
        r15 = r15 + 1;
        goto L14
    L18:
        if (r17 == r10.getParent(r15)) goto L26;
    L27:
        if (r16 == true) goto L31;
        r11.add(r10);
        r12.put(r10, r10);
        return r10;
    L31:
        if (r14.length != 0) goto L34;
        PredictionContext r19 = EMPTY;
    L37:
        r11.add(r19);
        r12.put(r19, r19);
        r12.put(r10, r19);
        return r19;
    L34:
        if (r14.length != 1) goto L36;
        r19 = SingletonPredictionContext.create(r14[0], r10.getReturnState(0));
        goto L37
    L36:
        r19 = new ArrayPredictionContext(r14, ((ArrayPredictionContext) r10).returnStates);
        goto L37
    }

    public static PredictionContext merge(PredictionContext r5, PredictionContext r10, boolean r11, DoubleKeyMap<PredictionContext, PredictionContext, PredictionContext> r12) {
        if (r5 != r10) goto L4;
        return r5;
    L4:
        if (r5.equals(r10) == true) goto L27;
        boolean r13 = r5 instanceof SingletonPredictionContext;
        if (r13 == true) goto L9;
    L12:
        if (r11 == true) goto L14;
    L19:
        if (r13 == false) goto L22;
        r5 = new ArrayPredictionContext((SingletonPredictionContext) r5);
    L22:
        if ((r10 instanceof SingletonPredictionContext) == false) goto L25;
        r10 = new ArrayPredictionContext((SingletonPredictionContext) r10);
    L25:
        return mergeArrays((ArrayPredictionContext) r5, (ArrayPredictionContext) r10, r11, r12);
    L14:
        if ((r5 instanceof EmptyPredictionContext) == false) goto L17;
        return r5;
    L17:
        if ((r10 instanceof EmptyPredictionContext) == false) goto L19;
        return r10;
    L9:
        if ((r10 instanceof SingletonPredictionContext) == false) goto L12;
        return mergeSingletons((SingletonPredictionContext) r5, (SingletonPredictionContext) r10, r11, r12);
    L27:
        return r5;
    }

    public static PredictionContext mergeArrays(ArrayPredictionContext r16, ArrayPredictionContext r17, boolean r18, DoubleKeyMap<PredictionContext, PredictionContext, PredictionContext> r19) {
        if (r19 == null) goto L10;
        PredictionContext r5 = r19.get(r16, r17);
        if (r5 == null) goto L7;
        return r5;
    L7:
        PredictionContext r10 = r19.get(r17, r16);
        if (r10 == null) goto L10;
        return r10;
    L10:
        int[] r11 = r16.returnStates;
        int r12 = r11.length;
        int[] r13 = r17.returnStates;
        int[] r14 = new int[r12 + r13.length];
        int r15 = r11.length + r13.length;
        PredictionContext[] r20 = new PredictionContext[r15];
        int r21 = 0;
        int r22 = 0;
        int r23 = 0;
    L11:
        int[] r110 = r16.returnStates;
        boolean r111 = true;
        if (r21 >= r110.length) goto L42;
        int[] r112 = r17.returnStates;
        if (r22 >= r112.length) goto L42;
        PredictionContext r113 = r16.parents[r21];
        PredictionContext r114 = r17.parents[r22];
        int r115 = r110[r21];
        int r116 = r112[r22];
        if (r115 != r116) goto L37;
        if (r115 != Integer.MAX_VALUE) goto L22;
        if (r113 != null) goto L22;
        if (r114 != null) goto L22;
        boolean r117 = true;
    L23:
        if (r113 == null) goto L28;
        if (r114 == null) goto L28;
        if (r113.equals(r114) == false) goto L28;
    L29:
        if (r117 == true) goto L33;
        if (r111 == true) goto L33;
        r20[r23] = merge(r113, r114, r18, r19);
        r14[r23] = r115;
    L34:
        r21 = r21 + 1;
    L35:
        r22 = r22 + 1;
    L40:
        r23 = r23 + 1;
    L33:
        r20[r23] = r113;
        r14[r23] = r115;
    L28:
        r111 = false;
    L22:
        r117 = false;
        goto L23
    L37:
        if (r115 >= r116) goto L39;
        r20[r23] = r113;
        r14[r23] = r115;
        r21 = r21 + 1;
        goto L40
    L39:
        r20[r23] = r114;
        r14[r23] = r116;
    L42:
        if (r21 >= r110.length) goto L46;
    L43:
        int[] r24 = r16.returnStates;
        if (r21 >= r24.length) goto L49;
        r20[r23] = r16.parents[r21];
        r14[r23] = r24[r21];
        r23 = r23 + 1;
        r21 = r21 + 1;
    L49:
        if (r23 >= r15) goto L56;
        if (r23 != 1) goto L55;
        SingletonPredictionContext r25 = SingletonPredictionContext.create(r20[0], r14[0]);
        if (r19 == null) goto L54;
        r19.put(r16, r17, r25);
    L54:
        return r25;
    L55:
        r20 = (PredictionContext[]) Arrays.copyOf(r20, r23);
        r14 = Arrays.copyOf(r14, r23);
    L56:
        ArrayPredictionContext r26 = new ArrayPredictionContext(r20, r14);
        if (r26.equals(r16) == false) goto L62;
        if (r19 == null) goto L60;
        r19.put(r16, r17, r16);
    L60:
        return r16;
    L62:
        if (r26.equals(r17) == false) goto L66;
        if (r19 == null) goto L65;
        r19.put(r16, r17, r17);
    L65:
        return r17;
    L66:
        combineCommonParents(r20);
        if (r19 == null) goto L69;
        r19.put(r16, r17, r26);
    L69:
        return r26;
    L46:
        int[] r27 = r17.returnStates;
        if (r22 >= r27.length) goto L49;
        r20[r23] = r17.parents[r22];
        r14[r23] = r27[r22];
        r23 = r23 + 1;
        r22 = r22 + 1;
        goto L46
    }

    public static PredictionContext mergeRoot(SingletonPredictionContext r5, SingletonPredictionContext r10, boolean r11) {
        if (r11 == false) goto L9;
        EmptyPredictionContext r12 = EMPTY;
        if (r5 != r12) goto L7;
        return r12;
    L7:
        if (r10 != r12) goto L20;
        return r12;
    L20:
        return null;
    L9:
        EmptyPredictionContext r13 = EMPTY;
        if (r5 != r13) goto L14;
        if (r10 != r13) goto L14;
        return r13;
    L14:
        if (r5 != r13) goto L17;
        int[] r14 = {r10.returnState, Integer.MAX_VALUE};
        return new ArrayPredictionContext(new PredictionContext[]{r10.parent, null}, r14);
    L17:
        if (r10 != r13) goto L20;
        int[] r15 = {r5.returnState, Integer.MAX_VALUE};
        return new ArrayPredictionContext(new PredictionContext[]{r5.parent, null}, r15);
    }

    public static PredictionContext mergeSingletons(SingletonPredictionContext r10, SingletonPredictionContext r11, boolean r12, DoubleKeyMap<PredictionContext, PredictionContext, PredictionContext> r13) {
        if (r13 == null) goto L9;
        PredictionContext r5 = r13.get(r10, r11);
        if (r5 == null) goto L6;
        return r5;
    L6:
        PredictionContext r14 = r13.get(r11, r10);
        if (r14 == null) goto L9;
        return r14;
    L9:
        PredictionContext r15 = mergeRoot(r10, r11, r12);
        if (r15 == null) goto L15;
        if (r13 == null) goto L13;
        r13.put(r10, r11, r15);
    L13:
        return r15;
    L15:
        if (r10.returnState != r11.returnState) goto L26;
        PredictionContext r16 = merge(r10.parent, r11.parent, r12, r13);
        if (r16 != r10.parent) goto L20;
        return r10;
    L20:
        if (r16 != r11.parent) goto L22;
        return r11;
    L22:
        SingletonPredictionContext r17 = SingletonPredictionContext.create(r16, r10.returnState);
        if (r13 == null) goto L25;
        r13.put(r10, r11, r17);
    L25:
        return r17;
    L26:
        if (r10 == r11) goto L33;
        PredictionContext r18 = r10.parent;
        if (r18 != null) goto L30;
    L32:
        PredictionContext r19 = null;
    L35:
        if (r19 == null) goto L43;
        int r20 = r10.returnState;
        int r21 = r11.returnState;
        int[] r22 = {r20, r21};
        if (r20 <= r21) goto L39;
        r22[0] = r21;
        r22[1] = r20;
    L39:
        ArrayPredictionContext r23 = new ArrayPredictionContext(new PredictionContext[]{r19, r19}, r22);
        if (r13 == null) goto L42;
        r13.put(r10, r11, r23);
    L42:
        return r23;
    L43:
        int r24 = r10.returnState;
        int r25 = r11.returnState;
        int[] r110 = {r24, r25};
        PredictionContext r26 = r10.parent;
        PredictionContext r27 = r11.parent;
        PredictionContext[] r28 = {r26, r27};
        if (r24 <= r25) goto L46;
        r110[0] = r25;
        r110[1] = r24;
        r28 = new PredictionContext[]{r27, r26};
    L46:
        ArrayPredictionContext r29 = new ArrayPredictionContext(r28, r110);
        if (r13 == null) goto L49;
        r13.put(r10, r11, r29);
    L49:
        return r29;
    L30:
        if (r18.equals(r11.parent) == false) goto L32;
    L33:
        r19 = r10.parent;
        goto L35
    }

    public static String toDOTString(PredictionContext r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        StringBuilder r5 = new StringBuilder("digraph G {\nrankdir=LR;\n");
        List<PredictionContext> r11 = getAllContextNodes(r10);
        Collections.sort(r11, new AnonymousClass1());
        Iterator<PredictionContext> r12 = r11.iterator();
    L6:
        boolean r13 = true;
        if (r12.hasNext() == false) goto L26;
        PredictionContext r14 = r12.next();
        String r15 = "$";
        if ((r14 instanceof SingletonPredictionContext) == true) goto L10;
        ArrayPredictionContext r16 = (ArrayPredictionContext) r14;
        r5.append("  s");
        r5.append(r16.f660id);
        r5.append(" [shape=box, label=\"[");
        int[] r17 = r16.returnStates;
        int r18 = r17.length;
        int r19 = 0;
    L16:
        if (r19 >= r18) goto L25;
        int r20 = r17[r19];
        if (r13 == true) goto L21;
        r5.append(", ");
    L21:
        if (r20 != Integer.MAX_VALUE) goto L23;
        r5.append("$");
    L24:
        r19 = r19 + 1;
        r13 = false;
        goto L16
    L23:
        r5.append(r20);
        goto L24
    L25:
        r5.append("]\"];\n");
        goto L6
    L10:
        String r21 = String.valueOf(r14.f660id);
        r5.append("  s");
        r5.append(r21);
        String r22 = String.valueOf(r14.getReturnState(0));
        if ((r14 instanceof EmptyPredictionContext) == true) goto L14;
        r15 = r22;
    L14:
        r5.append(" [label=\"");
        r5.append(r15);
        r5.append("\"];\n");
        goto L6
    L26:
        Iterator<PredictionContext> r110 = r11.iterator();
    L28:
        if (r110.hasNext() == false) goto L43;
        PredictionContext r23 = r110.next();
        if (r23 == EMPTY) goto L28;
        int r24 = 0;
    L34:
        if (r24 >= r23.size()) goto L28;
        if (r23.getParent(r24) == null) goto L42;
        String r25 = String.valueOf(r23.f660id);
        r5.append("  s");
        r5.append(r25);
        r5.append("->s");
        r5.append(r23.getParent(r24).f660id);
        if (r23.size() <= 1) goto L41;
        r5.append(" [label=\"parent[" + r24 + "]\"];\n");
        goto L42
    L41:
        r5.append(";\n");
    L42:
        r24 = r24 + 1;
        goto L34
    L43:
        r5.append("}\n");
        return r5.toString();
    }

    public abstract boolean equals(Object r5);

    public abstract PredictionContext getParent(int r5);

    public abstract int getReturnState(int r5);

    public boolean hasEmptyPath() {
        if (getReturnState(size() - 1) == Integer.MAX_VALUE) goto L7;
        return false;
    L7:
        return true;
    }

    public final int hashCode() {
        return this.cachedHashCode;
    }

    public boolean isEmpty() {
        if (this != EMPTY) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract int size();

    public String toString(Recognizer<?, ?> r5) {
        return toString();
    }

    public String[] toStrings(Recognizer<?, ?> r5, int r10) {
        return toStrings(r5, EMPTY, r10);
    }

    public String[] toStrings(Recognizer<?, ?> r13, PredictionContext r14, int r15) {
        ArrayList r5 = new ArrayList();
        int r10 = 0;
    L3:
        StringBuilder r11 = j0.u("[");
        PredictionContext r12 = this;
        int r16 = r15;
        int r17 = 0;
        boolean r18 = true;
    L5:
        if (r12.isEmpty() == true) goto L37;
        if (r12 == r14) goto L37;
        if (r12.size() <= 0) goto L21;
        int r19 = 1;
    L10:
        int r110 = 1 << r19;
        if (r110 >= r12.size()) goto L13;
        r19 = r19 + 1;
        goto L10
    L13:
        int r111 = (r110 - 1) & (r10 >> r17);
        if (r111 < (r12.size() - 1)) goto L16;
        boolean r112 = true;
    L17:
        r18 = r18 & r112;
        if (r111 >= r12.size()) goto L41;
        r17 = r17 + r19;
    L23:
        if (r13 == null) goto L29;
        if (r11.length() <= 1) goto L27;
        r11.append(' ');
    L27:
        r11.append(r13.getRuleNames()[r13.getATN().states.get(r16).ruleIndex]);
    L36:
        r16 = r12.getReturnState(r111);
        r12 = r12.getParent(r111);
        goto L5
    L29:
        if (r12.getReturnState(r111) == Integer.MAX_VALUE) goto L36;
        if (r12.isEmpty() == true) goto L36;
        if (r11.length() <= 1) goto L35;
        r11.append(' ');
    L35:
        r11.append(r12.getReturnState(r111));
    L41:
        r10 = r10 + 1;
        goto L3
    L16:
        r112 = false;
        goto L17
    L21:
        r111 = 0;
    L37:
        r11.append("]");
        r5.add(r11.toString());
        if (r18 == false) goto L41;
        return (String[]) r5.toArray(new String[r5.size()]);
    }

    public static int calculateHashCode(PredictionContext[] r5, int[] r10) {
        int r11 = MurmurHash.initialize(1);
        int r12 = r5.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        r11 = MurmurHash.update(r11, r5[r14]);
        r14 = r14 + 1;
        goto L3
    L5:
        int r15 = r10.length;
    L6:
        if (r13 >= r15) goto L9;
        r11 = MurmurHash.update(r11, r10[r13]);
        r13 = r13 + 1;
        goto L6
    L9:
        return MurmurHash.finish(r11, r5.length * 2);
    }
}
