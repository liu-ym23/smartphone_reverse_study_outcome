package com.cronutils.a;

import com.cronutils.model.Cron;
import com.cronutils.model.RebootCron;
import com.cronutils.model.SingleCron;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.definition.FieldDefinition;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.expression.a.b;
import com.cronutils.model.field.value.IntegerFieldValue;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<CronFieldName, CronField> f3396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CronDefinition f3397b;

    private a(CronDefinition r3) {
        this.f3396a = new EnumMap(CronFieldName.class);
        this.f3397b = r3;
    }

    public static Cron a(CronDefinition r4) {
        a r0 = new a(r4);
        if (r4.containsFieldDefinition(CronFieldName.SECOND) == false) goto L6;
        r0 = r0.f(new On(new IntegerFieldValue(0)));
    L6:
        if (r4.containsFieldDefinition(CronFieldName.MINUTE) == false) goto L9;
        r0 = r0.e(new On(new IntegerFieldValue(0)));
    L9:
        if (r4.containsFieldDefinition(CronFieldName.HOUR) == false) goto L12;
        r0 = r0.d(new On(new IntegerFieldValue(0)));
    L12:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_MONTH) == false) goto L15;
        r0 = r0.a(new On(new IntegerFieldValue(1)));
    L15:
        if (r4.containsFieldDefinition(CronFieldName.MONTH) == false) goto L18;
        r0 = r0.b(new On(new IntegerFieldValue(1)));
    L18:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_WEEK) == false) goto L21;
        r0 = r0.c(FieldExpression.always());
    L21:
        return r0.a();
    }

    public static Cron b(CronDefinition r0) {
        return a(r0);
    }

    public static Cron c(CronDefinition r4) {
        a r0 = new a(r4);
        if (r4.containsFieldDefinition(CronFieldName.SECOND) == false) goto L6;
        r0 = r0.f(new On(new IntegerFieldValue(0)));
    L6:
        if (r4.containsFieldDefinition(CronFieldName.MINUTE) == false) goto L9;
        r0 = r0.e(new On(new IntegerFieldValue(0)));
    L9:
        if (r4.containsFieldDefinition(CronFieldName.HOUR) == false) goto L12;
        r0 = r0.d(new On(new IntegerFieldValue(0)));
    L12:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_MONTH) == false) goto L15;
        r0 = r0.a(new On(new IntegerFieldValue(1)));
    L15:
        if (r4.containsFieldDefinition(CronFieldName.MONTH) == false) goto L18;
        r0 = r0.b(FieldExpression.always());
    L18:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_WEEK) == false) goto L21;
        r0 = r0.c(FieldExpression.always());
    L21:
        return r0.a();
    }

    public static Cron d(CronDefinition r4) {
        a r0 = new a(r4);
        if (r4.containsFieldDefinition(CronFieldName.SECOND) == false) goto L6;
        r0 = r0.f(new On(new IntegerFieldValue(0)));
    L6:
        if (r4.containsFieldDefinition(CronFieldName.MINUTE) == false) goto L9;
        r0 = r0.e(new On(new IntegerFieldValue(0)));
    L9:
        if (r4.containsFieldDefinition(CronFieldName.HOUR) == false) goto L12;
        r0 = r0.d(new On(new IntegerFieldValue(0)));
    L12:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_MONTH) == false) goto L15;
        r0 = r0.a(FieldExpression.always());
    L15:
        if (r4.containsFieldDefinition(CronFieldName.MONTH) == false) goto L18;
        r0 = r0.b(FieldExpression.always());
    L18:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_WEEK) == false) goto L21;
        r0 = r0.c(new On(new IntegerFieldValue(0)));
    L21:
        return r0.a();
    }

    public static Cron e(CronDefinition r4) {
        a r0 = new a(r4);
        if (r4.containsFieldDefinition(CronFieldName.SECOND) == false) goto L6;
        r0 = r0.f(new On(new IntegerFieldValue(0)));
    L6:
        if (r4.containsFieldDefinition(CronFieldName.MINUTE) == false) goto L9;
        r0 = r0.e(new On(new IntegerFieldValue(0)));
    L9:
        if (r4.containsFieldDefinition(CronFieldName.HOUR) == false) goto L12;
        r0 = r0.d(new On(new IntegerFieldValue(0)));
    L12:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_MONTH) == false) goto L15;
        r0 = r0.a(FieldExpression.always());
    L15:
        if (r4.containsFieldDefinition(CronFieldName.MONTH) == false) goto L18;
        r0 = r0.b(FieldExpression.always());
    L18:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_WEEK) == false) goto L21;
        r0 = r0.c(FieldExpression.always());
    L21:
        return r0.a();
    }

    public static Cron f(CronDefinition r0) {
        return e(r0);
    }

    public static Cron g(CronDefinition r4) {
        a r0 = new a(r4);
        if (r4.containsFieldDefinition(CronFieldName.SECOND) == false) goto L6;
        r0 = r0.f(new On(new IntegerFieldValue(0)));
    L6:
        if (r4.containsFieldDefinition(CronFieldName.MINUTE) == false) goto L9;
        r0 = r0.e(new On(new IntegerFieldValue(0)));
    L9:
        if (r4.containsFieldDefinition(CronFieldName.HOUR) == false) goto L12;
        r0 = r0.d(FieldExpression.always());
    L12:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_MONTH) == false) goto L15;
        r0 = r0.a(FieldExpression.always());
    L15:
        if (r4.containsFieldDefinition(CronFieldName.MONTH) == false) goto L18;
        r0 = r0.b(FieldExpression.always());
    L18:
        if (r4.containsFieldDefinition(CronFieldName.DAY_OF_WEEK) == false) goto L21;
        r0 = r0.c(FieldExpression.always());
    L21:
        return r0.a();
    }

    public static Cron h(CronDefinition r1) {
        return new RebootCron(r1);
    }

    a a(CronFieldName r6, FieldExpression r7) {
        if (this.f3397b == null) goto L5;
        boolean r0 = true;
    L6:
        com.cronutils.utils.a.a(r0, "CronBuilder not initialized.", new Object[0]);
        FieldDefinition r1 = this.f3397b.getFieldDefinition(r6);
        if (r1 == null) goto L9;
        boolean r3 = true;
    L10:
        com.cronutils.utils.a.a(r3, "Cron field definition does not exist: %s", new Object[]{r6});
        FieldConstraints r2 = r1.getConstraints();
        r7.accept(new b(r2));
        this.f3396a.put(r6, new CronField(r6, r7, r2));
        return this;
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public a a(FieldExpression r2) {
        return a(CronFieldName.DAY_OF_MONTH, r2);
    }

    public Cron a() {
        return new SingleCron(this.f3397b, new ArrayList(this.f3396a.values())).validate();
    }

    public a b(FieldExpression r2) {
        return a(CronFieldName.MONTH, r2);
    }

    public a c(FieldExpression r2) {
        return a(CronFieldName.DAY_OF_WEEK, r2);
    }

    public a d(FieldExpression r2) {
        return a(CronFieldName.HOUR, r2);
    }

    public a e(FieldExpression r2) {
        return a(CronFieldName.MINUTE, r2);
    }

    public a f(FieldExpression r2) {
        return a(CronFieldName.SECOND, r2);
    }
}
