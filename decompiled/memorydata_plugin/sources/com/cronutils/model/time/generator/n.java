package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class n extends h {
    public n(CronField r1) {
        super(r1);
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r3) {
        int r2 = ((On) ZeusTransformUtils.preCheckCast(this.c.getExpression(), On.class, "com.obric.memorydata.plugin")).getTime().getValue().intValue();
        if (r2 <= r3) goto L6;
        return r2;
    L6:
        throw new NoSuchValueException();
    }

    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r4, int r5) {
        ArrayList r0 = new ArrayList();
        int r3 = ((On) ZeusTransformUtils.preCheckCast(this.c.getExpression(), On.class, "com.obric.memorydata.plugin")).getTime().getValue().intValue();
        if (r3 <= r4) goto L6;
        if (r3 >= r5) goto L6;
        r0.add(Integer.valueOf(r3));
    L6:
        return r0;
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return ZeusTransformUtils.instanceOf(r1, On.class);
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r3) {
        if (((On) ZeusTransformUtils.preCheckCast(this.c.getExpression(), On.class, "com.obric.memorydata.plugin")).getTime().getValue().intValue() != r3) goto L5;
        return true;
    L5:
        return false;
    }
}
