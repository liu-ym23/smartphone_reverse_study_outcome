package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.FieldExpression;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class a extends h {
    public a(CronField r1) {
        super(r1);
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r1) {
        int r2 = r1 + 1;
        if (r2 > this.c.getConstraints().getEndRange()) goto L6;
        return r2;
    L6:
        throw new NoSuchValueException();
    }

    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r2, int r3) {
        ArrayList r1 = new ArrayList();
    L3:
        r2 = r2 + 1;
        if (r2 >= r3) goto L6;
        r1.add(Integer.valueOf(r2));
        goto L3
    L6:
        return r1;
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return ZeusTransformUtils.instanceOf(r1, Always.class);
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r3) {
        if (this.c.getField() != CronFieldName.DAY_OF_WEEK) goto L5;
    L8:
        return true;
    L5:
        if (this.c.getConstraints().isInRange(r3) == true) goto L8;
        return false;
    }
}
