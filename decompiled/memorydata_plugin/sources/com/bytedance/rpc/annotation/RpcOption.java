package com.bytedance.rpc.annotation;

import com.bytedance.rpc.serialize.SerializeType;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcOption {
    String[] bizParams() default {};

    boolean commonParams() default true;

    SerializeType serialize() default SerializeType.JSON;
}
