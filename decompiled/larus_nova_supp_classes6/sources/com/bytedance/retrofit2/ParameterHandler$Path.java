package com.bytedance.retrofit2;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$Path<T> extends ParameterHandler<T> {
    private final boolean encode;
    private final Method method;
    private final String name;
    private final int p;
    private final Converter<T, String> valueConverter;

    public void apply(RequestBuilder r3, @Nullable T r4) throws IOException {
        if (r4 == null) goto L6;
        r3.addPathParam(this.name, (String) this.valueConverter.convert(r4), this.encode);
        return;
    L6:
        throw Utils.parameterError(this.method, this.p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
    }

    public ParameterHandler$Path(Method r1, int r2, String r3, Converter<T, String> r4, boolean r5) {
        this.method = r1;
        this.p = r2;
        this.name = (String) Utils.checkNotNull(r3, "name == null");
        this.valueConverter = r4;
        this.encode = r5;
    }
}
