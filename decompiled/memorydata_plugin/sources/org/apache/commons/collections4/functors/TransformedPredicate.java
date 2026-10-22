package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public final class TransformedPredicate<T> implements Serializable, PredicateDecorator<T> {
    private static final long serialVersionUID = -5596090919668315834L;
    private final Predicate<? super T> iPredicate;
    private final Transformer<? super T, ? extends T> iTransformer;

    public TransformedPredicate(Transformer<? super T, ? extends T> r3, Predicate<? super T> r4) {
        Transformer<? super T, ? extends T> r5 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        Predicate<? super T> r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin");
        this.iTransformer = r5;
        this.iPredicate = r6;
    }

    public static <T> Predicate<T> transformedPredicate(Transformer<? super T, ? extends T> r2, Predicate<? super T> r3) {
        Transformer r4 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r2, Transformer.class, "com.obric.memorydata.plugin");
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "The transformer to call must not be null");
        Objects.requireNonNull(r5, "The predicate to call must not be null");
        return new TransformedPredicate(r4, r5);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r2) {
        T r3 = this.iTransformer.transform(r2);
        return this.iPredicate.evaluate(r3);
    }

    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }

    public Transformer<? super T, ? extends T> getTransformer() {
        return this.iTransformer;
    }
}
