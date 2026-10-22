package com.alibaba.excel.b.a;

import com.alibaba.excel.enums.BooleanEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    String a() default "";

    BooleanEnum b() default BooleanEnum.DEFAULT;
}
