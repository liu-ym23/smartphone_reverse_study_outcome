package com.bytedance.android.live.services.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface LiveDowngradeImpl {
    int[] onTarget() default {};

    Class[] service();

    boolean singleton() default true;
}
