package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface CallAdapter<T> {

    public static abstract class Factory {
        public Factory() {
        }

        public static Type getParameterUpperBound(int r8, ParameterizedType r10) {
            return Utils.getParameterUpperBound(r8, r10);
        }

        public static Class<?> getRawType(Type r8) {
            return Utils.getRawType(r8);
        }

        public abstract CallAdapter<?> get(Type r8, Annotation[] r10, Retrofit r11);
    }

    <R> T adapt(Call<R> r8);

    Type responseType();
}
