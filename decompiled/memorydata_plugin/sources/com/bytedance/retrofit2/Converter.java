package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public interface Converter<F, T> {

    public static abstract class Factory {
        public Factory() {
        }

        public Converter<?, Header> headerConverter(Type r1, Annotation[] r2, Retrofit r3) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin");
            return null;
        }

        public Converter<?, Object> objectConverter(Type r1, Annotation[] r2, Retrofit r3) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin");
            return null;
        }

        public Converter<?, TypedOutput> requestBodyConverter(Type r1, Annotation[] r2, Annotation[] r3, Retrofit r4) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin");
            return null;
        }

        public Converter<TypedInput, ?> responseBodyConverter(Type r1, Annotation[] r2, Retrofit r3) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin");
            return null;
        }

        public Converter<?, String> stringConverter(Type r1, Annotation[] r2, Retrofit r3) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.memorydata.plugin");
            return null;
        }
    }

    T convert(F r1);

    default T convertWithRequestBuilder(F r1, RequestBuilder r2) {
        return null;
    }

    default boolean needRequestBuilder() {
        return false;
    }
}
