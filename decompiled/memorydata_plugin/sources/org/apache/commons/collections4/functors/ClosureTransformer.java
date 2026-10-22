package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class ClosureTransformer<T> implements Serializable, Transformer<T, T> {
    private static final long serialVersionUID = 478466901448617286L;
    private final Closure<? super T> iClosure;

    public ClosureTransformer(Closure<? super T> r3) {
        this.iClosure = (Closure) ZeusTransformUtils.wrapperContextForParams(r3, Closure.class, "com.obric.memorydata.plugin");
    }

    public static <T> Transformer<T, T> closureTransformer(Closure<? super T> r2) {
        Closure r3 = (Closure) ZeusTransformUtils.wrapperContextForParams(r2, Closure.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "Closure must not be null");
        return new ClosureTransformer(r3);
    }

    public Closure<? super T> getClosure() {
        return this.iClosure;
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(T r1) {
        this.iClosure.execute(r1);
        return r1;
    }
}
