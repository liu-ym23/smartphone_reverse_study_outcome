package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class NOPTransformer<T> implements Serializable, Transformer<T, T> {
    public static final Transformer INSTANCE = null;
    private static final long serialVersionUID = 2133891748318574490L;

    static {
        INSTANCE = new NOPTransformer();
    }

    private NOPTransformer() {
    }

    public static <T> Transformer<T, T> nopTransformer() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T r1) {
        return r1;
    }
}
