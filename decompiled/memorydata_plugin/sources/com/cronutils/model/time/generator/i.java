package com.cronutils.model.time.generator;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.SpecialChar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static h a(CronField r3) {
        FieldExpression r0 = r3.getExpression();
        if (ZeusTransformUtils.instanceOf(r0, Always.class) == false) goto L7;
        return new a(r3);
    L7:
        if (ZeusTransformUtils.instanceOf(r0, And.class) == false) goto L11;
        return new c(r3);
    L11:
        if (ZeusTransformUtils.instanceOf(r0, Between.class) == false) goto L15;
        return new e(r3);
    L15:
        if (ZeusTransformUtils.instanceOf(r0, Every.class) == false) goto L19;
        return new g(r3);
    L19:
        if (ZeusTransformUtils.instanceOf(r0, On.class) == false) goto L27;
        On r1 = (On) ZeusTransformUtils.preCheckCast(r0, On.class, "com.obric.memorydata.plugin");
        if (SpecialChar.NONE.equals(r1.getSpecialChar().getValue()) == false) goto L25;
        return new n(r3);
    L25:
        throw new IllegalArgumentException(String.format("Cannot create instance for On instance with %s value", new Object[]{r1.getSpecialChar()}));
    L27:
        return new j(r3);
    }

    public static h a(CronField r0, int r1) {
        return a(r0);
    }

    public static h a(CronField r3, int r4, int r5) {
        FieldExpression r0 = r3.getExpression();
        if (ZeusTransformUtils.instanceOf(r0, On.class) == false) goto L9;
        On r1 = (On) ZeusTransformUtils.preCheckCast(r0, On.class, "com.obric.memorydata.plugin");
        if (SpecialChar.NONE.equals(r1.getSpecialChar().getValue()) == true) goto L9;
        return new l(r3, r4, r5);
    L9:
        return a(r3);
    }

    public static h a(CronField r2, int r3, int r4, WeekDay r5) {
        FieldExpression r0 = r2.getExpression();
        if (ZeusTransformUtils.instanceOf(r0, On.class) == false) goto L7;
        return new m(r2, r3, r4, r5);
    L7:
        if (ZeusTransformUtils.instanceOf(r0, Between.class) == false) goto L11;
        return new d(r2, r3, r4, r5);
    L11:
        if (ZeusTransformUtils.instanceOf(r0, And.class) == false) goto L15;
        return new b(r2, r3, r4, r5);
    L15:
        if (ZeusTransformUtils.instanceOf(r0, Every.class) == false) goto L19;
        return new f(r2, r3, r4, r5);
    L19:
        return a(r2);
    }

    public static h b(CronField r0) {
        return a(r0);
    }
}
