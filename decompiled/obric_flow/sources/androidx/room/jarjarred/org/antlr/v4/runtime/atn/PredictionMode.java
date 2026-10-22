package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.AbstractEqualityComparator;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.FlexibleHashMap;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MurmurHash;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final enum PredictionMode extends Enum<PredictionMode> {
    private static final /* synthetic */ PredictionMode[] $VALUES = null;
    public static final PredictionMode LL = null;
    public static final PredictionMode LL_EXACT_AMBIG_DETECTION = null;
    public static final PredictionMode SLL = null;

    public static final class AltAndContextConfigEqualityComparator extends AbstractEqualityComparator<ATNConfig> {
        public static final AltAndContextConfigEqualityComparator INSTANCE = null;

        static {
            INSTANCE = new AltAndContextConfigEqualityComparator();
        }

        private AltAndContextConfigEqualityComparator() {
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.EqualityComparator
        public /* bridge */ /* synthetic */ boolean equals(Object r5, Object r10) {
            return equals((ATNConfig) r5, (ATNConfig) r10);
        }

        @Override // androidx.room.jarjarred.org.antlr.v4.runtime.misc.EqualityComparator
        public /* bridge */ /* synthetic */ int hashCode(Object r5) {
            return hashCode((ATNConfig) r5);
        }

        public boolean equals(ATNConfig r5, ATNConfig r10) {
            if (r5 != r10) goto L6;
            return true;
        L6:
            if (r5 == null) goto L16;
            if (r10 == null) goto L16;
            if (r5.state.stateNumber != r10.state.stateNumber) goto L15;
            if (r5.context.equals(r10.context) == false) goto L15;
            return true;
        L15:
            return false;
        L16:
            return false;
        }

        public int hashCode(ATNConfig r5) {
            return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(7), r5.state.stateNumber), r5.context), 2);
        }
    }

    public static class AltAndContextMap extends FlexibleHashMap<ATNConfig, BitSet> {
        public AltAndContextMap() {
            super(AltAndContextConfigEqualityComparator.INSTANCE);
        }
    }

    static {
        PredictionMode r5 = new PredictionMode("SLL", 0);
        SLL = r5;
        PredictionMode r10 = new PredictionMode("LL", 1);
        LL = r10;
        PredictionMode r11 = new PredictionMode("LL_EXACT_AMBIG_DETECTION", 2);
        LL_EXACT_AMBIG_DETECTION = r11;
        $VALUES = new PredictionMode[]{r5, r10, r11};
    }

    private PredictionMode(String r5, int r10) {
        super(r5, r10);
    }

    public static boolean allConfigsInRuleStopStates(ATNConfigSet r5) {
        Iterator<ATNConfig> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if ((r10.next().state instanceof RuleStopState) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static boolean allSubsetsConflict(Collection<BitSet> r5) {
        return !hasNonConflictingAltSet(r5);
    }

    public static boolean allSubsetsEqual(Collection<BitSet> r5) {
        Iterator<BitSet> r10 = r5.iterator();
        BitSet r11 = r10.next();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r10.next().equals(r11) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static BitSet getAlts(Collection<BitSet> r5) {
        BitSet r10 = new BitSet();
        Iterator<BitSet> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.or(r11.next());
        goto L4
    L6:
        return r10;
    }

    public static Collection<BitSet> getConflictingAltSubsets(ATNConfigSet r5) {
        AltAndContextMap r10 = new AltAndContextMap();
        Iterator<ATNConfig> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        ATNConfig r12 = r11.next();
        BitSet r13 = (BitSet) r10.get(r12);
        if (r13 != null) goto L8;
        r13 = new BitSet();
        r10.put(r12, r13);
    L8:
        r13.set(r12.alt);
        goto L4
    L10:
        return r10.values();
    }

    public static int getSingleViableAlt(Collection<BitSet> r5) {
        BitSet r10 = new BitSet();
        Iterator<BitSet> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        r10.set(r11.next().nextSetBit(0));
        if (r10.cardinality() <= 1) goto L4;
        return 0;
    L9:
        return r10.nextSetBit(0);
    }

    public static Map<ATNState, BitSet> getStateToAltMap(ATNConfigSet r5) {
        HashMap r10 = new HashMap();
        Iterator<ATNConfig> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ATNConfig r12 = r11.next();
        BitSet r13 = (BitSet) r10.get(r12.state);
        if (r13 != null) goto L8;
        r13 = new BitSet();
        r10.put(r12.state, r13);
    L8:
        r13.set(r12.alt);
        goto L4
    L9:
        return r10;
    }

    public static int getUniqueAlt(Collection<BitSet> r5) {
        BitSet r10 = getAlts(r5);
        if (r10.cardinality() == 1) goto L5;
        return 0;
    L5:
        return r10.nextSetBit(0);
    }

    public static boolean hasConfigInRuleStopState(ATNConfigSet r5) {
        Iterator<ATNConfig> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if ((r10.next().state instanceof RuleStopState) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static boolean hasConflictingAltSet(Collection<BitSet> r5) {
        Iterator<BitSet> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r10.next().cardinality() <= 1) goto L4;
        return true;
    L8:
        return false;
    }

    public static boolean hasNonConflictingAltSet(Collection<BitSet> r5) {
        Iterator<BitSet> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r10.next().cardinality() != 1) goto L4;
        return true;
    L8:
        return false;
    }

    public static boolean hasSLLConflictTerminatingPrediction(PredictionMode r5, ATNConfigSet r10) {
        if (allConfigsInRuleStopStates(r10) == false) goto L6;
        return true;
    L6:
        if (r5 != SLL) goto L15;
        if (r10.hasSemanticContext == false) goto L15;
        ATNConfigSet r11 = new ATNConfigSet();
        Iterator<ATNConfig> r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L13;
        r11.add(new ATNConfig(r12.next(), SemanticContext.NONE));
        goto L11
    L13:
        r10 = r11;
    L15:
        if (hasConflictingAltSet(getConflictingAltSubsets(r10)) == true) goto L17;
    L19:
        return false;
    L17:
        if (hasStateAssociatedWithOneAlt(r10) == true) goto L19;
        return true;
    }

    public static boolean hasStateAssociatedWithOneAlt(ATNConfigSet r5) {
        Iterator<BitSet> r10 = getStateToAltMap(r5).values().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (r10.next().cardinality() != 1) goto L4;
        return true;
    L8:
        return false;
    }

    public static int resolvesToJustOneViableAlt(Collection<BitSet> r5) {
        return getSingleViableAlt(r5);
    }

    public static PredictionMode valueOf(String r5) {
        return (PredictionMode) Enum.valueOf(PredictionMode.class, r5);
    }

    public static PredictionMode[] values() {
        return (PredictionMode[]) $VALUES.clone();
    }

    public static BitSet getAlts(ATNConfigSet r5) {
        BitSet r10 = new BitSet();
        Iterator<ATNConfig> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.set(r11.next().alt);
        goto L4
    L6:
        return r10;
    }
}
