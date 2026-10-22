package com.cronutils.model.time.generator;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.FieldExpression;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class b extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3435b;
    private final WeekDay d;

    public b(CronField r2, int r3, int r4, WeekDay r5) {
        super(r2);
        com.cronutils.utils.a.a(CronFieldName.DAY_OF_WEEK.equals(r2.getField()), "CronField does not belong to day of week");
        this.f3434a = r3;
        this.f3435b = r4;
        this.d = r5;
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r1) {
        return 0;
    }

    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r8, int r9) {
        ArrayList r0 = new ArrayList();
        Iterator<FieldExpression> r1 = ((And) ZeusTransformUtils.preCheckCast(this.c.getExpression(), And.class, "com.obric.memorydata.plugin")).getExpressions().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        FieldExpression r2 = (FieldExpression) ZeusTransformUtils.preCheckCast(r1.next(), FieldExpression.class, "com.obric.memorydata.plugin");
        List<Integer> r3 = i.a(new CronField(CronFieldName.DAY_OF_WEEK, r2, this.c.getConstraints()), this.f3434a, this.f3435b, this.d).b(r8, r9);
        if (r3 == null) goto L4;
        r0.addAll(r3);
        goto L4
    L8:
        return r0;
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return ZeusTransformUtils.instanceOf(r1, And.class);
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r1) {
        return false;
    }
}
