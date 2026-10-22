package com.cronutils.model.time.generator;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.FieldExpression;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes2.dex */
class d extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3438b;
    private final WeekDay d;
    private final Set<Integer> e;

    public d(CronField r3, int r4, int r5, WeekDay r6) {
        super(r3);
        com.cronutils.utils.a.a(CronFieldName.DAY_OF_WEEK.equals(r3.getField()), "CronField does not belong to day of week");
        this.f3437a = r4;
        this.f3438b = r5;
        this.d = r6;
        final HashSet r7 = new HashSet();
        this.e = r7;
        Between r2 = (Between) ZeusTransformUtils.preCheckCast(r3.getExpression(), Between.class, "com.obric.memorydata.plugin");
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getFrom().getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getTo().getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r9 < r8) goto L5;
        IntStream r10 = IntStream.rangeClosed(r8, r9);
        IntConsumer r11 = new $$Lambda$ChCjQ6dFsPPTYRm9u_QXTnRx9B8(r7);
    L6:
        r10.forEach(r11);
        return;
    L5:
        IntStream.rangeClosed(r8, r3.getConstraints().getEndRange()).forEach(new $$Lambda$ChCjQ6dFsPPTYRm9u_QXTnRx9B8(r7));
        r10 = IntStream.rangeClosed(r3.getConstraints().getStartRange(), r9);
        r11 = new $$Lambda$ChCjQ6dFsPPTYRm9u_QXTnRx9B8(r7);
        goto L6
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r1) {
        return 0;
    }

    @Override // com.cronutils.model.time.generator.h
    public List<Integer> a(int r8, int r9) {
        ArrayList r0 = new ArrayList();
        Iterator<Integer> r1 = this.e.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin");
        com.cronutils.model.field.constraint.a r3 = com.cronutils.model.field.constraint.a.h().a(CronFieldName.DAY_OF_WEEK);
        List<Integer> r4 = new m(new com.cronutils.b.b(CronFieldName.DAY_OF_WEEK, r3.g()).a(r2.toString()), this.f3437a, this.f3438b, this.d).b(r8, r9);
        if (r4 == null) goto L4;
        r0.addAll(r4);
        goto L4
    L8:
        Collections.sort(r0);
        return r0;
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return ZeusTransformUtils.instanceOf(r1, Between.class);
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r3) {
        return this.e.contains(Integer.valueOf((LocalDate.of(this.f3437a, this.f3438b, r3).getDayOfWeek().getValue() % 7) + (this.d.getMondayDoWValue() - 1)));
    }
}
