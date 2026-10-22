package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class NullIsTruePredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -7625133768987126273L;
    private final Predicate<? super T> iPredicate;

    public NullIsTruePredicate(Predicate<? super T> r3) {
        this.iPredicate = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
    }

    public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> r2) {
        Predicate r3 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "Predicate must not be null");
        return new NullIsTruePredicate(r3);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r1) {
        if (r1 != null) goto L6;
        return true;
    L6:
        return this.iPredicate.evaluate(r1);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
