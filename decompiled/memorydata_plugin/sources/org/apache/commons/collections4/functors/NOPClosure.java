package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Closure;

/* JADX INFO: loaded from: classes6.dex */
public final class NOPClosure<E> implements Serializable, Closure<E> {
    public static final Closure INSTANCE = null;
    private static final long serialVersionUID = 3518477308466486130L;

    static {
        INSTANCE = new NOPClosure();
    }

    private NOPClosure() {
    }

    public static <E> Closure<E> nopClosure() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E r1) {
    }
}
