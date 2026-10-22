package com.bytedance.retrofit2;

import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$PartMap<T> extends ParameterHandler<Map<String, T>> {
    private final Method method;
    private final int p;
    private final String transferEncoding;
    private final Converter<T, TypedOutput> valueConverter;

    public void apply(RequestBuilder r6, @Nullable Map<String, T> r7) throws IOException {
        if (r7 == null) goto L18;
        Iterator<Map.Entry<String, T>> r8 = r7.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        Map.Entry<String, T> r1 = r8.next();
        String r2 = r1.getKey();
        if (r2 == null) goto L15;
        T r3 = r1.getValue();
        if (r3 == null) goto L13;
        r6.addPart(r2, this.transferEncoding, (TypedOutput) this.valueConverter.convert(r3));
        goto L6
    L13:
        throw Utils.parameterError(this.method, this.p, "Part map contained null value for key '" + r2 + "'.", new Object[0]);
    L15:
        throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
    L16:
        return;
    L18:
        throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
    }

    public /* bridge */ /* synthetic */ void apply(RequestBuilder r1, @Nullable Object r2) throws IOException {
        apply(r1, (Map) r2);
    }

    public ParameterHandler$PartMap(Method r1, int r2, Converter<T, TypedOutput> r3, String r4) {
        this.method = r1;
        this.p = r2;
        this.valueConverter = r3;
        this.transferEncoding = r4;
    }
}
