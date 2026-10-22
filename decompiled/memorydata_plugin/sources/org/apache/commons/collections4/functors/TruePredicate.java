package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class TruePredicate<T> implements Serializable, Predicate<T> {
    public static final Predicate INSTANCE = null;
    private static final long serialVersionUID = 3374767158756189740L;

    static {
        INSTANCE = new TruePredicate();
    }

    private TruePredicate() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Predicate<T> truePredicate() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r1) {
        return true;
    }
}
