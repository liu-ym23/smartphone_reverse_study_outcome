package com.bytedance.retrofit2;

import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$Part<T> extends ParameterHandler<T> {
    private final Converter<T, TypedOutput> converter;
    private final Method method;
    private final String name;
    private final int p;

    public void apply(RequestBuilder r5, T r6) {
        if (r6 != null) goto L10;
        return;
    L10:
        r5.addPart(this.name, (TypedOutput) this.converter.convert(r6));
        return;
    L7:
        e = move-exception;
        throw Utils.parameterError(this.method, this.p, "Unable to convert " + r6 + " to RequestBody", new Object[]{e});
    }

    public ParameterHandler$Part(Method r1, int r2, String r3, Converter<T, TypedOutput> r4) {
        this.method = r1;
        this.p = r2;
        this.name = r3;
        this.converter = r4;
    }
}
