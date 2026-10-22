package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public final class StringValueTransformer<T> implements Serializable, Transformer<T, String> {
    private static final Transformer<Object, String> INSTANCE = null;
    private static final long serialVersionUID = 7511110693171758606L;

    static {
        INSTANCE = new StringValueTransformer();
    }

    private StringValueTransformer() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Transformer<T, String> stringValueTransformer() {
        return (Transformer<T, String>) INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.Transformer
    public /* bridge */ /* synthetic */ String transform(Object r1) {
        return transform2(r1);
    }

    @Override // org.apache.commons.collections4.Transformer
    /* JADX INFO: renamed from: transform, reason: avoid collision after fix types in other method */
    public String transform2(T r1) {
        return String.valueOf(r1);
    }
}
