package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition {
    public static final int ACTION = 6;
    public static final int ATOM = 5;
    public static final int EPSILON = 1;
    public static final int NOT_SET = 8;
    public static final int PRECEDENCE = 10;
    public static final int PREDICATE = 4;
    public static final int RANGE = 2;
    public static final int RULE = 3;
    public static final int SET = 7;
    public static final int WILDCARD = 9;
    public static final List<String> serializationNames = null;
    public static final Map<Class<? extends Transition>, Integer> serializationTypes = null;
    public ATNState target;

    static {
        serializationNames = Collections.unmodifiableList(Arrays.asList(new String[]{"INVALID", "EPSILON", "RANGE", "RULE", "PREDICATE", "ATOM", "ACTION", "SET", "NOT_SET", "WILDCARD", "PRECEDENCE"}));
        serializationTypes = Collections.unmodifiableMap(new AnonymousClass1());
    }

    public Transition(ATNState r5) {
        if (r5 == null) goto L7;
        this.target = r5;
        return;
    L7:
        throw new NullPointerException("target cannot be null.");
    }

    public abstract int getSerializationType();

    public boolean isEpsilon() {
        return false;
    }

    public IntervalSet label() {
        return null;
    }

    public abstract boolean matches(int r5, int r10, int r11);
}
