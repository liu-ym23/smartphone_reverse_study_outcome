package org.apache.commons.collections4;

import org.apache.commons.collections4.functors.StringValueTransformer;

/* JADX INFO: loaded from: classes6.dex */
public class TransformerUtils {
    public static <T> Transformer<T, String> stringValueTransformer() {
        return StringValueTransformer.stringValueTransformer();
    }
}
