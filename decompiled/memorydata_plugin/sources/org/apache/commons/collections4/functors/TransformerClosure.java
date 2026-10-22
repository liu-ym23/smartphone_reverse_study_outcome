package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformerClosure<E> implements Serializable, Closure<E> {
    private static final long serialVersionUID = -5194992589193388969L;
    private final Transformer<? super E, ?> iTransformer;

    public TransformerClosure(Transformer<? super E, ?> r3) {
        this.iTransformer = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
    }

    public static <E> Closure<E> transformerClosure(Transformer<? super E, ?> r2) {
        Transformer r3 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r2, Transformer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return NOPClosure.nopClosure();
    L7:
        return new TransformerClosure(r3);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E r1) {
        this.iTransformer.transform(r1);
    }

    public Transformer<? super E, ?> getTransformer() {
        return this.iTransformer;
    }
}
