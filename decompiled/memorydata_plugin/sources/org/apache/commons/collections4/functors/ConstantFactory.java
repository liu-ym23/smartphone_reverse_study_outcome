package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Factory;

/* JADX INFO: loaded from: classes6.dex */
public class ConstantFactory<T> implements Serializable, Factory<T> {
    public static final Factory NULL_INSTANCE = null;
    private static final long serialVersionUID = -3520677225766901240L;
    private final T iConstant;

    static {
        NULL_INSTANCE = new ConstantFactory(null);
    }

    public ConstantFactory(T r1) {
        this.iConstant = r1;
    }

    public static <T> Factory<T> constantFactory(T r1) {
        if (r1 != null) goto L6;
        return NULL_INSTANCE;
    L6:
        return new ConstantFactory(r1);
    }

    @Override // org.apache.commons.collections4.Factory
    public T create() {
        return this.iConstant;
    }

    public T getConstant() {
        return this.iConstant;
    }
}
