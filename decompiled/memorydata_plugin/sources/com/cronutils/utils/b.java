package com.cronutils.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static <T> Predicate<T> a(Predicate<T> r2) {
        return ((Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin")).negate();
    }
}
