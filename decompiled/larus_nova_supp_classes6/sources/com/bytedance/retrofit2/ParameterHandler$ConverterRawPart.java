package com.bytedance.retrofit2;

import java.io.IOException;
import okhttp3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$ConverterRawPart extends ParameterHandler<k.b> {
    static final ParameterHandler$ConverterRawPart INSTANCE = null;

    static {
        INSTANCE = new ParameterHandler$ConverterRawPart();
    }

    public ParameterHandler$ConverterRawPart() {
    }

    public void apply(RequestBuilder r1, k.b r2) throws IOException {
        if (r2 == null) goto L4;
        r1.addPart(r2);
    L4:
        r1.useRequestBody();
    }

    public /* bridge */ /* synthetic */ void apply(RequestBuilder r1, Object r2) throws IOException {
        apply(r1, (k.b) r2);
    }
}
