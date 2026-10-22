package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface Converter<F, T> {

    public static abstract class Factory {
        public Factory() {
        }

        public Converter<?, Header> headerConverter(Type r8, Annotation[] r10, Retrofit r11) {
            return null;
        }

        public Converter<?, Object> objectConverter(Type r8, Annotation[] r10, Retrofit r11) {
            return null;
        }

        public Converter<?, TypedOutput> requestBodyConverter(Type r8, Annotation[] r10, Annotation[] r11, Retrofit r12) {
            return null;
        }

        public Converter<TypedInput, ?> responseBodyConverter(Type r8, Annotation[] r10, Retrofit r11) {
            return null;
        }

        public Converter<?, String> stringConverter(Type r8, Annotation[] r10, Retrofit r11) {
            return null;
        }
    }

    T convert(F r8);
}
