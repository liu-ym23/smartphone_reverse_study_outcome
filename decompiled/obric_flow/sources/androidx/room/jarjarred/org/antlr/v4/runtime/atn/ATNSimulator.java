package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFAState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class ATNSimulator {
    public static final DFAState ERROR = null;

    @Deprecated
    public static final UUID SERIALIZED_UUID = null;

    @Deprecated
    public static final int SERIALIZED_VERSION = 0;
    public final ATN atn;
    protected final PredictionContextCache sharedContextCache;

    static {
        SERIALIZED_VERSION = ATNDeserializer.SERIALIZED_VERSION;
        SERIALIZED_UUID = ATNDeserializer.SERIALIZED_UUID;
        DFAState r5 = new DFAState(new ATNConfigSet());
        ERROR = r5;
        r5.stateNumber = Integer.MAX_VALUE;
    }

    public ATNSimulator(ATN r5, PredictionContextCache r10) {
        this.atn = r5;
        this.sharedContextCache = r10;
    }

    @Deprecated
    public static void checkCondition(boolean r5) {
        new ATNDeserializer().checkCondition(r5);
    }

    @Deprecated
    public static ATN deserialize(char[] r5) {
        return new ATNDeserializer().deserialize(r5);
    }

    @Deprecated
    public static Transition edgeFactory(ATN r10, int r11, int r12, int r13, int r14, int r15, int r16, List<IntervalSet> r17) {
        return new ATNDeserializer().edgeFactory(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Deprecated
    public static ATNState stateFactory(int r5, int r10) {
        return new ATNDeserializer().stateFactory(r5, r10);
    }

    @Deprecated
    public static int toInt(char r5) {
        return ATNDeserializer.toInt(r5);
    }

    @Deprecated
    public static int toInt32(char[] r5, int r10) {
        return ATNDeserializer.toInt32(r5, r10);
    }

    @Deprecated
    public static long toLong(char[] r5, int r10) {
        return ATNDeserializer.toLong(r5, r10);
    }

    @Deprecated
    public static UUID toUUID(char[] r5, int r10) {
        return ATNDeserializer.toUUID(r5, r10);
    }

    public void clearDFA() {
        throw new UnsupportedOperationException("This ATN simulator does not support clearing the DFA.");
    }

    public PredictionContext getCachedContext(PredictionContext r5) {
        PredictionContextCache r10 = this.sharedContextCache;
        if (r10 != null) goto L5;
        return r5;
    L5:
        monitor-enter(r10);
        IdentityHashMap r11 = new IdentityHashMap();     // Catch: Throwable -> L9
        PredictionContext r12 = PredictionContext.getCachedContext(r5, this.sharedContextCache, r11);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r12;
    L9:
        th = move-exception;
        throw th;
    }

    public PredictionContextCache getSharedContextCache() {
        return this.sharedContextCache;
    }

    public abstract void reset();

    @Deprecated
    public static void checkCondition(boolean r5, String r10) {
        new ATNDeserializer().checkCondition(r5, r10);
    }
}
