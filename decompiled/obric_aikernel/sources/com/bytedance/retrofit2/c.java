package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface c<R, T> {

    public static abstract class a {
        public a() {
        }

        protected static Class<?> b(Type r10) {
            return c0.j(r10);
        }

        public abstract c<?, ?> a(Type r10, Annotation[] r11, t r12);
    }

    Type a();

    T b(b<R> r10);
}
