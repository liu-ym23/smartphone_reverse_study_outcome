package dj;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface c {
    a defaultValue() default @a;

    boolean isEnum() default false;

    boolean isGetter() default true;

    String keyPath() default "";

    Class nestedClassType() default fj.a.class;

    Class primitiveClassType() default Object.class;

    boolean required() default false;
}
