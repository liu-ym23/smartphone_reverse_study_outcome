package com.bytedance.retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$Field<T> extends ParameterHandler<T> {
    private final boolean encode;
    private final String name;
    private final Converter<T, String> valueConverter;

    public void apply(RequestBuilder r3, @Nullable T r4) throws IOException {
        if (r4 != null) goto L4;
        return;
    L4:
        String r5 = (String) this.valueConverter.convert(r4);
        if (r5 != null) goto L7;
        return;
    L7:
        r3.addFormField(this.name, r5, this.encode);
    }

    public ParameterHandler$Field(String r2, Converter<T, String> r3, boolean r4) {
        this.name = (String) Utils.checkNotNull(r2, "name == null");
        this.valueConverter = r3;
        this.encode = r4;
    }
}
