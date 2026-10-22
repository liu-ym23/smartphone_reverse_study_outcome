package com.bytedance.retrofit2;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$Method<T> extends ParameterHandler<T> {
    private final String name;
    private final Converter<T, String> valueConverter;

    public ParameterHandler$Method(String r2, Converter<T, String> r3) {
        this.name = (String) Utils.checkNotNull(r2, "name == null");
        this.valueConverter = r3;
    }

    public void apply(RequestBuilder r3, T r4) throws IOException {
        if (r4 == null) goto L6;
        r3.setMethod(this.name, (String) this.valueConverter.convert(r4));
        return;
    L6:
        throw new IllegalArgumentException("Method parameter \"" + this.name + "\" value must not be null.");
    }
}
