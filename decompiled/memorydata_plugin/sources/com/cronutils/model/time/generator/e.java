package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.value.FieldValue;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class e extends h {
    public e(CronField r1) {
        super(r1);
    }

    static int a(FieldValue<?> r2) {
        if (ZeusTransformUtils.instanceOf(r2, IntegerFieldValue.class) == false) goto L7;
        return ((IntegerFieldValue) ZeusTransformUtils.preCheckCast(r2, IntegerFieldValue.class, "com.obric.memorydata.plugin")).getValue().intValue();
    L7:
        throw new IllegalArgumentException("Non integer values at intervals are not fully supported yet.");
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r3) {
        Between r2 = (Between) ZeusTransformUtils.preCheckCast(this.c.getExpression(), Between.class, "com.obric.memorydata.plugin");
    L3:
        r3 = r3 + 1;
        if (r3 < a(r2.getFrom())) goto L3;
        if (r3 > a(r2.getTo())) goto L9;
        return r3;
    L9:
        throw new NoSuchValueException();
    }

    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r5, int r6) {
        ArrayList r0 = new ArrayList();
        Between r1 = (Between) ZeusTransformUtils.preCheckCast(this.c.getExpression(), Between.class, "com.obric.memorydata.plugin");
        int r2 = a(r1.getFrom());
        int r3 = a(r1.getTo());
        if (r5 > r3) goto L19;
        if (r2 > r6) goto L19;
        if (r3 < r6) goto L9;
        r3 = r6;
    L9:
        if (a(r1.getFrom()) > r5) goto L12;
        r2 = r5;
    L12:
        if (r2 != r5) goto L21;
    L14:
        int r7 = a(r2);     // Catch: NoSuchValueException -> L20
    L15:
        if (r7 >= r3) goto L17;
        r0.add(Integer.valueOf(r7));     // Catch: NoSuchValueException -> L20
        r7 = a(r7);     // Catch: NoSuchValueException -> L20
        goto L15
    L17:
        if (r3 == r6) goto L19;
        r0.add(Integer.valueOf(r7));     // Catch: NoSuchValueException -> L20
        goto L19
    L21:
        r0.add(Integer.valueOf(r2));     // Catch: NoSuchValueException -> L20
    L19:
        return r0;
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return ZeusTransformUtils.instanceOf(r1, Between.class);
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r3) {
        Between r2 = (Between) ZeusTransformUtils.preCheckCast(this.c.getExpression(), Between.class, "com.obric.memorydata.plugin");
        if (r3 >= a(r2.getFrom())) goto L5;
    L7:
        return false;
    L5:
        if (r3 > a(r2.getTo())) goto L7;
        return true;
    }
}
