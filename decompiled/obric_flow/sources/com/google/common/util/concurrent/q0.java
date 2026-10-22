package com.google.common.util.concurrent;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 implements com.google.common.base.q {
    @Override // java.util.function.Function
    public final Object apply(Object r5) {
        return Boolean.valueOf(Arrays.asList(((Constructor) r5).getParameterTypes()).contains(String.class));
    }
}
