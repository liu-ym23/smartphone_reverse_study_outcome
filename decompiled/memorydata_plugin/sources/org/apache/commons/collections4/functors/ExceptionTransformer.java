package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public final class ExceptionTransformer<I, O> implements Serializable, Transformer<I, O> {
    public static final Transformer INSTANCE = null;
    private static final long serialVersionUID = 7179106032121985545L;

    static {
        INSTANCE = new ExceptionTransformer();
    }

    private ExceptionTransformer() {
    }

    public static <I, O> Transformer<I, O> exceptionTransformer() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I r1) {
        throw new FunctorException("ExceptionTransformer invoked");
    }
}
