package com.cronutils.model.field;

import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.FieldExpression;
import java.io.Serializable;
import java.util.Comparator;
import sr7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class CronField implements Serializable {
    private static final long serialVersionUID = -4042499846855256325L;
    private final FieldConstraints constraints;
    private final FieldExpression expression;
    private final CronFieldName field;

    public static Comparator<CronField> createFieldComparator() {
        return Comparator.comparingInt(new a());
    }

    public String toString() {
        return "CronField{field=" + this.field + '}';
    }

    public FieldConstraints getConstraints() {
        return this.constraints;
    }

    public FieldExpression getExpression() {
        return this.expression;
    }

    public CronFieldName getField() {
        return this.field;
    }

    public CronField(CronFieldName r1, FieldExpression r2, FieldConstraints r3) {
        this.field = r1;
        zr7.a.b(r2, "FieldExpression must not be null");
        this.expression = r2;
        zr7.a.b(r3, "FieldConstraints must not be null");
        this.constraints = r3;
    }
}
