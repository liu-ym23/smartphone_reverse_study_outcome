package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public final class TransformerPredicate<T> implements Serializable, Predicate<T> {
    private static final long serialVersionUID = -2407966402920578741L;
    private final Transformer<? super T, Boolean> iTransformer;

    public TransformerPredicate(Transformer<? super T, Boolean> r3) {
        this.iTransformer = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
    }

    public static <T> Predicate<T> transformerPredicate(Transformer<? super T, Boolean> r2) {
        Transformer r3 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r2, Transformer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "The transformer to call must not be null");
        return new TransformerPredicate(r3);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T r2) {
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(this.iTransformer.transform(r2), Boolean.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        throw new FunctorException("Transformer must return an instanceof Boolean, it was a null object");
    }

    public Transformer<? super T, Boolean> getTransformer() {
        return this.iTransformer;
    }
}
