package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface f<F, T> {

    public static abstract class a {
        public a() {
        }

        public f<?, n4.b> a(Type r10, Annotation[] r11, t r12) {
            return null;
        }

        public f<?, Object> b(Type r10, Annotation[] r11, t r12) {
            return null;
        }

        public f<?, r4.f> c(Type r10, Annotation[] r11, Annotation[] r12, t r13) {
            return null;
        }

        public f<r4.e, ?> d(Type r10, Annotation[] r11, t r12) {
            return null;
        }

        public f<?, String> e(Type r10, Annotation[] r11, t r12) {
            return null;
        }
    }

    T convert(F r10);
}
