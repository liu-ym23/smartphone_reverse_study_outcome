package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class NotPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -2654603322338049674L;
    private final Predicate<? super T> iPredicate;

    public NotPredicate(Predicate<? super T> r3) {
        this.iPredicate = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
    }

    public static <T> Predicate<T> notPredicate(Predicate<? super T> r2) {
        Predicate r3 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "Predicate must not be null");
        return new NotPredicate(r3);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r1) {
        return !this.iPredicate.evaluate(r1);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
