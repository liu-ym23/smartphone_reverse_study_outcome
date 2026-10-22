package com.bytedance.retrofit2;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$ConverterPart extends ParameterHandler<RequestBody> {
    private final Headers headers;

    public ParameterHandler$ConverterPart(Headers r1) {
        this.headers = r1;
    }

    public void apply(RequestBuilder r2, RequestBody r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r2.addPart(this.headers, r3);
        r2.useRequestBody();
    }

    public /* bridge */ /* synthetic */ void apply(RequestBuilder r1, Object r2) throws IOException {
        apply(r1, (RequestBody) r2);
    }
}
