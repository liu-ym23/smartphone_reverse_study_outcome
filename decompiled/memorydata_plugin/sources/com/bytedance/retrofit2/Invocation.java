package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    Invocation(Method r3, List<?> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.method = r3;
        this.arguments = Collections.unmodifiableList(r5);
    }

    public static Invocation of(Method r2, List<?> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Utils.checkNotNull(r2, "method == null");
        Utils.checkNotNull(r4, "arguments == null");
        return new Invocation(r2, new ArrayList(r4));
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
