package org.apache.commons.collections4.functors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public final class MapTransformer<I, O> implements Serializable, Transformer<I, O> {
    private static final long serialVersionUID = 862391807045468939L;
    private final Map<? super I, ? extends O> iMap;

    private MapTransformer(Map<? super I, ? extends O> r3) {
        this.iMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return ConstantTransformer.nullTransformer();
    L7:
        return new MapTransformer(r3);
    }

    public Map<? super I, ? extends O> getMap() {
        return this.iMap;
    }

    @Override // org.apache.commons.collections4.Transformer
    public O transform(I r1) {
        return this.iMap.get(r1);
    }
}
