package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class FactoryTransformer<I, O> implements Serializable, Transformer<I, O> {
    private static final long serialVersionUID = -6817674502475353160L;
    private final Factory<? extends O> iFactory;

    public FactoryTransformer(Factory<? extends O> r3) {
        this.iFactory = (Factory) ZeusTransformUtils.wrapperContextForParams(r3, Factory.class, "com.obric.memorydata.plugin");
    }

    public static <I, O> Transformer<I, O> factoryTransformer(Factory<? extends O> r2) {
        Factory r3 = (Factory) ZeusTransformUtils.wrapperContextForParams(r2, Factory.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "Factory must not be null");
        return new FactoryTransformer(r3);
    }

    public Factory<? extends O> getFactory() {
        return this.iFactory;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I r1) {
        return this.iFactory.create();
    }
}
