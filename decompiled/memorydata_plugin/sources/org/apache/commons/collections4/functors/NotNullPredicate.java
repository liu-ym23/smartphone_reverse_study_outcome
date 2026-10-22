package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class NotNullPredicate<T> implements Serializable, Predicate<T> {
    public static final Predicate INSTANCE = null;
    private static final long serialVersionUID = 7533784454832764388L;

    static {
        INSTANCE = new NotNullPredicate();
    }

    private NotNullPredicate() {
    }

    public static <T> Predicate<T> notNullPredicate() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r1) {
        if (r1 == null) goto L4;
        return true;
    L4:
        return false;
    }
}
