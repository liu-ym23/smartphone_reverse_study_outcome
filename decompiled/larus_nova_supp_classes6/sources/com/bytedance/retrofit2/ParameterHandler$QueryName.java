package com.bytedance.retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$QueryName<T> extends ParameterHandler<T> {
    private final boolean encoded;
    private final Converter<T, String> nameConverter;

    public ParameterHandler$QueryName(Converter<T, String> r1, boolean r2) {
        this.nameConverter = r1;
        this.encoded = r2;
    }

    public void apply(RequestBuilder r3, @Nullable T r4) throws IOException {
        if (r4 != null) goto L4;
        return;
    L4:
        r3.addQueryParam((String) this.nameConverter.convert(r4), null, this.encoded);
    }
}
