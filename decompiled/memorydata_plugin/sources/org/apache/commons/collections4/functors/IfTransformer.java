package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class IfTransformer<I, O> implements Serializable, Transformer<I, O> {
    private static final long serialVersionUID = 8069309411242014252L;
    private final Transformer<? super I, ? extends O> iFalseTransformer;
    private final Predicate<? super I> iPredicate;
    private final Transformer<? super I, ? extends O> iTrueTransformer;

    public IfTransformer(Predicate<? super I> r3, Transformer<? super I, ? extends O> r4, Transformer<? super I, ? extends O> r5) {
        Predicate<? super I> r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        Transformer<? super I, ? extends O> r7 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        Transformer<? super I, ? extends O> r8 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r5, Transformer.class, "com.obric.memorydata.plugin");
        this.iPredicate = r6;
        this.iTrueTransformer = r7;
        this.iFalseTransformer = r8;
    }

    public static <T> Transformer<T, T> ifTransformer(Predicate<? super T> r2, Transformer<? super T, ? extends T> r3) {
        Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        Transformer r5 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Predicate must not be null");
        Objects.requireNonNull(r5, "Transformer must not be null");
        return new IfTransformer(r4, r5, NOPTransformer.nopTransformer());
    }

    public static <I, O> Transformer<I, O> ifTransformer(Predicate<? super I> r2, Transformer<? super I, ? extends O> r3, Transformer<? super I, ? extends O> r4) {
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
        Transformer r6 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        Transformer r7 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "Predicate must not be null");
        if (r6 == null) goto L8;
        if (r7 == null) goto L8;
        return new IfTransformer(r5, r6, r7);
    L8:
        throw new NullPointerException("Transformers must not be null");
    }

    public Transformer<? super I, ? extends O> getFalseTransformer() {
        return this.iFalseTransformer;
    }

    public Predicate<? super I> getPredicate() {
        return this.iPredicate;
    }

    public Transformer<? super I, ? extends O> getTrueTransformer() {
        return this.iTrueTransformer;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I r2) {
        if (this.iPredicate.evaluate(r2) == false) goto L7;
        Transformer<? super I, ? extends O> r1 = this.iTrueTransformer;
    L6:
        return r1.transform(r2);
    L7:
        r1 = this.iFalseTransformer;
        goto L6
    }
}
