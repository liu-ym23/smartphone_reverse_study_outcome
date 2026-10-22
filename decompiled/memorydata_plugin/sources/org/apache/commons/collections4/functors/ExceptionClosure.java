package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: loaded from: classes6.dex */
public final class ExceptionClosure<E> implements Serializable, Closure<E> {
    public static final Closure INSTANCE = null;
    private static final long serialVersionUID = 7179106032121985545L;

    static {
        INSTANCE = new ExceptionClosure();
    }

    private ExceptionClosure() {
    }

    public static <E> Closure<E> exceptionClosure() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E r1) {
        throw new FunctorException("ExceptionClosure invoked");
    }
}
