package dj;

import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    boolean boolValue() default false;

    double doubleValue() default 0.0d;

    int intValue() default 0;

    long longValue() default 0;

    String stringValue() default "";

    DefaultType type() default DefaultType.NONE;
}
