package com.bytedance.android.live.network;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.mime.TypedInput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends Converter.Factory {
    public f() {
    }

    public final Converter<TypedInput, ?> responseBodyConverter(Type r1, Annotation[] r2, Retrofit r3) {
        if (r1 == am3.f.class) goto L7;
        return null;
    L7:
        return new e();
    }
}
