package com.lark.kmp.containerization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    <T> T a(KClass<T> r1);

    <T> List<T> b(KClass<T> r1);

    <T> void c(KClass<T> r1, Function0<? extends T> r10);
}
