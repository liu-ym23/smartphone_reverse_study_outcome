package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class c extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f3436a = null;

    static {
        f3436a = org.slf4j.d.a(c.class);
    }

    public c(CronField r1) {
        super(r1);
    }

    private h a(CronField r3) {
        FieldExpression r2 = r3.getExpression();
        if (ZeusTransformUtils.instanceOf(r2, Always.class) == false) goto L7;
        return new a(r3);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, Between.class) == false) goto L11;
        return new e(r3);
    L11:
        if (ZeusTransformUtils.instanceOf(r2, Every.class) == false) goto L15;
        return new g(r3);
    L15:
        if (ZeusTransformUtils.instanceOf(r2, On.class) == false) goto L19;
        return new n(r3);
    L19:
        throw new IllegalArgumentException(String.format("FieldExpression %s not supported!", new Object[]{r2.getClass()}));
    }

    private static /* synthetic */ Integer a(int r0, h r1) {
        return Integer.valueOf(r1.a(r0));
    L5:
        return Integer.MIN_VALUE;
    }

    private List<Integer> a(com.cronutils.a<h, Integer> r8) {
        com.cronutils.a r9 = (com.cronutils.a) ZeusTransformUtils.wrapperContextForParams(r8, com.cronutils.a.class, "com.obric.memorydata.plugin");
        And r0 = (And) ZeusTransformUtils.preCheckCast(this.c.getExpression(), And.class, "com.obric.memorydata.plugin");
        ArrayList r2 = new ArrayList();
        Iterator<FieldExpression> r1 = r0.getExpressions().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        FieldExpression r3 = (FieldExpression) ZeusTransformUtils.preCheckCast(r1.next(), FieldExpression.class, "com.obric.memorydata.plugin");
        r2.add(r9.apply(a(new CronField(this.c.getField(), r3, this.c.getConstraints()))));
        goto L4
    L6:
        ArrayList r7 = new ArrayList();
        Iterator r10 = r2.iterator();
    L8:
        if (r10.hasNext() == false) goto L12;
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r10.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r4.intValue() < 0) goto L8;
        r7.add(r4);
        goto L8
    L12:
        Collections.sort(r7);
        return r7;
    }

    public static /* synthetic */ Integer lambda$bbt1YAMhWjkK1b26eCxlorL7oqY(int r0, h r1) {
        return a(r0, r1);
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(final int r2) {
        List<Integer> r1 = a(new $$Lambda$c$bbt1YAMhWjkK1b26eCxlorL7oqY(r2));
        if (r1.isEmpty() == true) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(r1.get(0), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L7:
        throw new NoSuchValueException();
    }

    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r3, int r4) {
        ArrayList r0 = new ArrayList();
    L10:
        r3 = a(r3);     // Catch: NoSuchValueException -> L7
        if (r3 >= r4) goto L9;
        r0.add(Integer.valueOf(r3));     // Catch: NoSuchValueException -> L7
    L9:
        return r0;
    L7:
        e = move-exception;
        f3436a.debug("Catched expected exception while generating candidates", e);
        goto L9
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return ZeusTransformUtils.instanceOf(r1, And.class);
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r8) {
        Iterator<FieldExpression> r0 = ((And) ZeusTransformUtils.preCheckCast(this.c.getExpression(), And.class, "com.obric.memorydata.plugin")).getExpressions().iterator();
    L3:
        boolean r3 = false;
    L5:
        if (r0.hasNext() == false) goto L11;
        FieldExpression r4 = (FieldExpression) ZeusTransformUtils.preCheckCast(r0.next(), FieldExpression.class, "com.obric.memorydata.plugin");
        if (r3 == true) goto L10;
        if (a(new CronField(this.c.getField(), r4, this.c.getConstraints())).b(r8) == false) goto L3;
    L10:
        r3 = true;
        goto L5
    L11:
        return r3;
    }
}
