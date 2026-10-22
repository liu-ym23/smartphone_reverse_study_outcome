package com.bytedance.retrofit2;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$ConverterPartMap extends ParameterHandler<Map<String, RequestBody>> {
    private final String transferEncoding;

    public ParameterHandler$ConverterPartMap(String r1) {
        this.transferEncoding = r1;
    }

    public void apply(RequestBuilder r6, Map<String, RequestBody> r7) throws IOException {
        if (r7 == null) goto L18;
        Iterator<Map.Entry<String, RequestBody>> r8 = r7.entrySet().iterator();
    L5:
        if (r8.hasNext() == false) goto L15;
        Map.Entry<String, RequestBody> r0 = r8.next();
        String r1 = r0.getKey();
        if (r1 == null) goto L14;
        RequestBody r2 = r0.getValue();
        if (r2 == null) goto L12;
        r6.addPart(Headers.of(new String[]{"Content-Disposition", "form-data; name=\"" + r1 + "\"", "Content-Transfer-Encoding", this.transferEncoding}), r2);
        goto L5
    L12:
        throw new IllegalArgumentException("Part map contained null value for key '" + r1 + "'.");
    L14:
        throw new IllegalArgumentException("Part map contained null key.");
    L15:
        r6.useRequestBody();
        return;
    L18:
        throw new IllegalArgumentException("Part map was null.");
    }

    public /* bridge */ /* synthetic */ void apply(RequestBuilder r1, Object r2) throws IOException {
        apply(r1, (Map) r2);
    }
}
