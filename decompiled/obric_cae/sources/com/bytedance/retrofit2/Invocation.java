package com.bytedance.retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    public Invocation(Method r8, List<?> r10) {
        this.method = r8;
        this.arguments = Collections.unmodifiableList(r10);
    }

    public static Invocation of(Method r8, List<?> r10) {
        return new Invocation(r8, new ArrayList(r10));
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public Method method() {
        return this.method;
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments});
    }
}
