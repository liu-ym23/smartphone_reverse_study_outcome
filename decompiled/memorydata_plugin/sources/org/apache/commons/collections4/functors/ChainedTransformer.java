package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class ChainedTransformer<T> implements Serializable, Transformer<T, T> {
    private static final long serialVersionUID = 3514945074733160196L;
    private final Transformer<? super T, ? extends T>[] iTransformers;

    private ChainedTransformer(boolean r1, Transformer<? super T, ? extends T>[] r2) {
        if (r1 == false) goto L5;
        r2 = FunctorUtils.copy(r2);
    L5:
        this.iTransformers = r2;
    }

    public ChainedTransformer(Transformer<? super T, ? extends T>... r2) {
        this(true, r2);
    }

    public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<? super T, ? extends T>> r2) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "Transformer collection must not be null");
        if (r3.size() == 0) goto L5;
        Transformer[] r4 = (Transformer[]) ZeusTransformUtils.preCheckCast(r3.toArray(new Transformer[r3.size()]), Transformer[].class, "com.obric.memorydata.plugin");
        FunctorUtils.validate(r4);
        return new ChainedTransformer(false, r4);
    L5:
        return NOPTransformer.nopTransformer();
    }

    public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>... r1) {
        FunctorUtils.validate(r1);
        if (r1.length != 0) goto L7;
        return NOPTransformer.nopTransformer();
    L7:
        return new ChainedTransformer(r1);
    }

    public Transformer<? super T, ? extends T>[] getTransformers() {
        return FunctorUtils.copy(this.iTransformers);
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T r4) {
        Transformer<? super T, ? extends T>[] r3 = this.iTransformers;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4 = r3[r1].transform(r4);
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }
}
