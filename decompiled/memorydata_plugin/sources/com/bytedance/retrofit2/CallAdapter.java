package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public interface CallAdapter<R, T> {

    public static abstract class Factory {
        public Factory() {
        }

        public static Type getParameterUpperBound(int r2, ParameterizedType r3) {
            return Utils.getParameterUpperBound(r2, (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r3, ParameterizedType.class, "com.obric.memorydata.plugin"));
        }

        public static Class<?> getRawType(Type r2) {
            return Utils.getRawType((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin"));
        }

        public abstract CallAdapter<?, ?> get(Type r1, Annotation[] r2, Retrofit r3);
    }

    T adapt(Call<R> r1);

    Type responseType();
}
