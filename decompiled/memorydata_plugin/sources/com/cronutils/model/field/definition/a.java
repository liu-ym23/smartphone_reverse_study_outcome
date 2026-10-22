package com.cronutils.model.field.definition;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronFieldName;

/* JADX INFO: loaded from: classes2.dex */
public class a extends d {
    private int e;

    public a(com.cronutils.model.definition.b r1, CronFieldName r2) {
        super(r1, r2);
        this.e = 1;
        com.cronutils.utils.a.a(CronFieldName.DAY_OF_WEEK.equals(r2), "CronFieldName must be DAY_OF_WEEK");
    }

    @Override // com.cronutils.model.field.definition.b
    public com.cronutils.model.definition.b a() {
        boolean r0 = this.c.g().isInRange(0);
        this.f3418a.a(new DayOfWeekFieldDefinition(this.f3419b, this.c.g(), this.d, new WeekDay(this.e, r0)));
        return this.f3418a;
    }

    public a a(int r3) {
        this.c.a(r3 - this.e);
        this.e = r3;
        return this;
    }

    public a a(int r1, int r2) {
        super.c(r1, r2);
        return this;
    }

    public a b(int r1, int r2) {
        super.d(r1, r2);
        return this;
    }

    @Override // com.cronutils.model.field.definition.d
    public /* synthetic */ d c(int r1, int r2) {
        return a(r1, r2);
    }

    @Override // com.cronutils.model.field.definition.d
    public /* synthetic */ d d(int r1, int r2) {
        return b(r1, r2);
    }

    @Override // com.cronutils.model.field.definition.d, com.cronutils.model.field.definition.b
    public /* synthetic */ b e(int r1, int r2) {
        return a(r1, r2);
    }

    @Override // com.cronutils.model.field.definition.d, com.cronutils.model.field.definition.b
    public /* synthetic */ b f(int r1, int r2) {
        return b(r1, r2);
    }
}
