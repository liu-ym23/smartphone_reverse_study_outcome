package com.alibaba.excel.b;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface c {
    String[] a() default {""};

    int b() default -1;

    int c() default Integer.MAX_VALUE;

    Class<? extends com.alibaba.excel.f.b<?>> d() default com.alibaba.excel.f.a.class;
}
