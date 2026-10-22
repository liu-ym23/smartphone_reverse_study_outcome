package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class ExceptionPredicate<T> implements Serializable, Predicate<T> {
    public static final Predicate INSTANCE = null;
    private static final long serialVersionUID = 7179106032121985545L;

    static {
        INSTANCE = new ExceptionPredicate();
    }

    private ExceptionPredicate() {
    }

    public static <T> Predicate<T> exceptionPredicate() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r1) {
        throw new FunctorException("ExceptionPredicate invoked");
    }
}
