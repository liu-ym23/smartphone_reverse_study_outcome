package com.cronutils.model.field.definition;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import ur7.b;
import zr7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class FieldDefinition implements Serializable {
    private static final long serialVersionUID = 7285200909397193383L;
    private final FieldConstraints constraints;
    private final CronFieldName fieldName;
    private final boolean optional;

    public int hashCode() {
        return Objects.hash(new Object[]{this.fieldName, this.constraints, Boolean.valueOf(this.optional)});
    }

    public static Comparator<FieldDefinition> createFieldDefinitionComparator() {
        return Comparator.comparingInt(new b());
    }

    public FieldConstraints getConstraints() {
        return this.constraints;
    }

    public CronFieldName getFieldName() {
        return this.fieldName;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        FieldDefinition r6 = (FieldDefinition) r5;
        if (this.optional == r6.optional) goto L13;
    L17:
        return false;
    L13:
        if (this.fieldName != r6.fieldName) goto L17;
        if (this.constraints.equals(r6.constraints) == false) goto L17;
        return true;
    }

    public FieldDefinition(CronFieldName r2, FieldConstraints r3) {
        this(r2, r3, false);
    }

    public FieldDefinition(CronFieldName r2, FieldConstraints r3, boolean r4) {
        a.b(r2, "CronFieldName must not be null");
        this.fieldName = r2;
        a.b(r3, "FieldConstraints must not be null");
        this.constraints = r3;
        this.optional = r4;
    }
}
