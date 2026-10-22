package com.alibaba.excel.b.b.a;

import com.alibaba.excel.enums.BooleanEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Inherited
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    String a() default "";

    short b() default -1;

    BooleanEnum c() default BooleanEnum.DEFAULT;

    BooleanEnum d() default BooleanEnum.DEFAULT;

    short e() default -1;

    short f() default -1;

    byte g() default -1;

    int h() default -1;

    BooleanEnum i() default BooleanEnum.DEFAULT;
}
