package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: loaded from: classes6.dex */
public final class ExceptionFactory<T> implements Serializable, Factory<T> {
    public static final Factory INSTANCE = null;
    private static final long serialVersionUID = 7179106032121985545L;

    static {
        INSTANCE = new ExceptionFactory();
    }

    private ExceptionFactory() {
    }

    public static <T> Factory<T> exceptionFactory() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Factory
    public T create() {
        throw new FunctorException("ExceptionFactory invoked");
    }
}
