package com.alibaba.excel.b.b.a;

import com.alibaba.excel.enums.BooleanEnum;
import com.alibaba.excel.enums.poi.BorderStyleEnum;
import com.alibaba.excel.enums.poi.FillPatternTypeEnum;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Inherited
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    short a() default -1;

    BooleanEnum b() default BooleanEnum.DEFAULT;

    BooleanEnum c() default BooleanEnum.DEFAULT;

    BooleanEnum d() default BooleanEnum.DEFAULT;

    HorizontalAlignmentEnum e() default HorizontalAlignmentEnum.DEFAULT;

    BooleanEnum f() default BooleanEnum.DEFAULT;

    VerticalAlignmentEnum g() default VerticalAlignmentEnum.DEFAULT;

    short h() default -1;

    short i() default -1;

    BorderStyleEnum j() default BorderStyleEnum.DEFAULT;

    BorderStyleEnum k() default BorderStyleEnum.DEFAULT;

    BorderStyleEnum l() default BorderStyleEnum.DEFAULT;

    BorderStyleEnum m() default BorderStyleEnum.DEFAULT;

    short n() default -1;

    short o() default -1;

    short p() default -1;

    short q() default -1;

    FillPatternTypeEnum r() default FillPatternTypeEnum.DEFAULT;

    short s() default -1;

    short t() default -1;

    BooleanEnum u() default BooleanEnum.DEFAULT;
}
