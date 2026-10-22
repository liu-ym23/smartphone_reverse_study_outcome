package com.cronutils.model.time.generator;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.Every;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class f extends g {
    private final int d;
    private int e;
    private int f;
    private final Set<DayOfWeek> g;

    f(CronField r3, int r4, int r5, WeekDay r6) {
        super(r3);
        com.cronutils.utils.a.a(CronFieldName.DAY_OF_WEEK.equals(r3.getField()), "CronField does not belong to day of week");
        this.e = r4;
        this.f = r5;
        boolean r0 = true;
        this.d = LocalDate.of(r4, r5, 1).lengthOfMonth();
        int r7 = ((Every) ZeusTransformUtils.preCheckCast(r3.getExpression(), Every.class, "com.obric.memorydata.plugin")).getPeriod().getValue().intValue();
        if (r7 > 0) goto L5;
    L7:
        r0 = false;
    L8:
        com.cronutils.utils.a.a(r0, "Cron Expression for day of week has an invalid period.");
        this.g = a(r6, r7, this.f3439a, this.f3440b);
        return;
    L5:
        if (r7 >= 8) goto L7;
        goto L7
    }

    private static Set<DayOfWeek> a(WeekDay r2, int r3, int r4, int r5) {
        ArrayList r0 = new ArrayList(7);
    L3:
        if (r4 > r5) goto L6;
        r0.add(DayOfWeek.of(com.cronutils.mapper.a.a(r2, com.cronutils.mapper.a.f3409b, r4)));
        r4 = r4 + r3;
        goto L3
    L6:
        return EnumSet.copyOf(r0);
    }

    @Override // com.cronutils.model.time.generator.g, com.cronutils.model.time.generator.h
    public int a(int r2) {
    L2:
        r2 = r2 + 1;
        if (b(r2) == true) goto L7;
        if (r2 <= this.d) goto L2;
    L7:
        if (r2 > this.d) goto L10;
        return r2;
    L10:
        throw new NoSuchValueException();
    }

    @Override // com.cronutils.model.time.generator.g, com.cronutils.model.time.generator.h
    public List<Integer> a(int r3, int r4) {
        ArrayList r0 = new ArrayList();
    L3:
        if (r3 >= r4) goto L8;
        r3 = a(r3);     // Catch: NoSuchValueException -> L9
        if (r3 >= r4) goto L3;
        r0.add(Integer.valueOf(r3));     // Catch: NoSuchValueException -> L9
    L8:
        return r0;
    }

    @Override // com.cronutils.model.time.generator.g, com.cronutils.model.time.generator.h
    public boolean b(int r3) {
        if (r3 <= this.d) goto L5;
        return false;
    L5:
        if (r3 < 1) goto L11;
        DayOfWeek r4 = LocalDate.of(this.e, this.f, r3).getDayOfWeek();
        return this.g.contains(r4);
    L11:
        return false;
    }
}
