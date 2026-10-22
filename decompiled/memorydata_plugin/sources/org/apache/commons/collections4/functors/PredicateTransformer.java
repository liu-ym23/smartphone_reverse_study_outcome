package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class PredicateTransformer<T> implements Serializable, Transformer<T, Boolean> {
    private static final long serialVersionUID = 5278818408044349346L;
    private final Predicate<? super T> iPredicate;

    public PredicateTransformer(Predicate<? super T> r3) {
        this.iPredicate = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
    }

    public static <T> Transformer<T, Boolean> predicateTransformer(Predicate<? super T> r2) {
        Predicate r3 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        return new PredicateTransformer(r3);
    L7:
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public Predicate<? super T> getPredicate() {
        return this.iPredicate;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.collections4.Transformer
    public Boolean transform(T r1) {
        return Boolean.valueOf(this.iPredicate.evaluate(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.Transformer
    public /* bridge */ /* synthetic */ Boolean transform(Object r1) {
        return transform(r1);
    }
}
