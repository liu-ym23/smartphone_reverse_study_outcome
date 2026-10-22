package com.bytedance.retrofit2;

import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class BuiltInConverters$VoidResponseBodyConverter implements Converter<TypedInput, Void> {
    static final BuiltInConverters$VoidResponseBodyConverter INSTANCE = null;

    public BuiltInConverters$VoidResponseBodyConverter() {
    }

    public final /* synthetic */ Object convertWithRequestBuilder(Object r1, RequestBuilder r2) {
        return Converter.-CC.$default$convertWithRequestBuilder(this, r1, r2);
    }

    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.-CC.$default$needRequestBuilder(this);
    }

    static {
        INSTANCE = new BuiltInConverters$VoidResponseBodyConverter();
    }

    public Void convert(TypedInput r1) throws IOException {
        InputStream r2 = r1.in();
        if (r2 == null) goto L7;
        r2.close();
        return null;
    L7:
        return null;
    }

    public /* bridge */ /* synthetic */ Object convert(Object r1) throws IOException {
        return convert((TypedInput) r1);
    }
}
