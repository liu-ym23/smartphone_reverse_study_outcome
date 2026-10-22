package com.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WireFieldNoEnum {
    public static final int ONE_OF = 3;
    public static final int OPTIONAL = 1;
    public static final int PACKED = 4;
    public static final int REPEATED = 2;
    public static final int REQUIRED = 0;

    String adapter();

    String keyAdapter() default "";

    int label() default 1;

    boolean redacted() default false;

    int tag();
}
