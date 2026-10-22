package com.bytedance.retrofit2;

import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class BuiltInConverters$UnitResponseBodyConverter implements Converter<TypedInput, Unit> {
    static final BuiltInConverters$UnitResponseBodyConverter INSTANCE = null;

    public BuiltInConverters$UnitResponseBodyConverter() {
    }

    public final /* synthetic */ Object convertWithRequestBuilder(Object r1, RequestBuilder r2) {
        return Converter.-CC.$default$convertWithRequestBuilder(this, r1, r2);
    }

    public final /* synthetic */ boolean needRequestBuilder() {
        return Converter.-CC.$default$needRequestBuilder(this);
    }

    static {
        INSTANCE = new BuiltInConverters$UnitResponseBodyConverter();
    }

    public Unit convert(TypedInput r1) {
        r1.in().close();     // Catch: IOException -> L4
    L7:
        return Unit.INSTANCE;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public /* bridge */ /* synthetic */ Object convert(Object r1) throws IOException {
        return convert((TypedInput) r1);
    }
}
