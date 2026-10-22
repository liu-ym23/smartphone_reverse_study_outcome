package com.bytedance.retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f2561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<?> f2562b;

    n(Method r10, List<?> r11) {
        this.f2561a = r10;
        this.f2562b = Collections.unmodifiableList(r11);
    }

    public Method a() {
        return this.f2561a;
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.f2561a.getDeclaringClass().getName(), this.f2561a.getName(), this.f2562b});
    }
}
