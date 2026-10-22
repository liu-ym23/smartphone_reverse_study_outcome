package org.apache.commons.collections4.functors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class UniquePredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = -3319417438027438040L;
    private final Set<T> iSet;

    public UniquePredicate() {
        this.iSet = new HashSet();
    }

    public static <T> Predicate<T> uniquePredicate() {
        return new UniquePredicate();
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r1) {
        return this.iSet.add(r1);
    }
}
