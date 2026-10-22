package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class IdentityPredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = -89901658494523293L;
    private final T iValue;

    public IdentityPredicate(T r1) {
        this.iValue = r1;
    }

    public static <T> Predicate<T> identityPredicate(T r1) {
        if (r1 != null) goto L6;
        return NullPredicate.nullPredicate();
    L6:
        return new IdentityPredicate(r1);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r1) {
        if (this.iValue != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public T getValue() {
        return this.iValue;
    }
}
