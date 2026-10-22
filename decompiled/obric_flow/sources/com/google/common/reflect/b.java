package com.google.common.reflect;

import com.google.common.base.b0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public b() {
    }

    public final Type capture() {
        Type r5 = getClass().getGenericSuperclass();
        b0.h("%s isn't parameterized", r5 instanceof ParameterizedType, r5);
        return ((ParameterizedType) r5).getActualTypeArguments()[0];
    }
}
