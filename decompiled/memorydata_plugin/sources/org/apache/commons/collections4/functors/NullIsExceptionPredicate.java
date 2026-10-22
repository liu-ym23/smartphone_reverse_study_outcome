package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public final class NullIsExceptionPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = 3243449850504576071L;
    private final Predicate<? super T> iPredicate;

    public NullIsExceptionPredicate(Predicate<? super T> r3) {
        this.iPredicate = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
    }

    public static <T> Predicate<T> nullIsExceptionPredicate(Predicate<? super T> r2) {
        Predicate r3 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "Predicate must not be null");
        return new NullIsExceptionPredicate(r3);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r1) {
        if (r1 == null) goto L6;
        return this.iPredicate.evaluate(r1);
    L6:
        throw new FunctorException("Input Object must not be null");
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
