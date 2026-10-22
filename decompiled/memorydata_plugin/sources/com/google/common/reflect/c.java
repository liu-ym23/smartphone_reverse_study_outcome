package com.google.common.reflect;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
abstract class c<T> {
    c() {
    }

    final Type capture() {
        Type r2 = getClass().getGenericSuperclass();
        n.a(ZeusTransformUtils.instanceOf(r2, ParameterizedType.class), "%s isn't parameterized", r2);
        return ((ParameterizedType) ZeusTransformUtils.preCheckCast(r2, ParameterizedType.class, "com.obric.memorydata.plugin")).getActualTypeArguments()[0];
    }
}
