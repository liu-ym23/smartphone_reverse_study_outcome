package com.cronutils.model.field.definition;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class FieldDefinition implements Serializable {
    private static final long serialVersionUID = 7285200909397193383L;
    private final FieldConstraints constraints;
    private final CronFieldName fieldName;
    private final boolean optional;

    public FieldDefinition(CronFieldName r2, FieldConstraints r3) {
        this(r2, r3, false);
    }

    public FieldDefinition(CronFieldName r3, FieldConstraints r4, boolean r5) {
        this.fieldName = (CronFieldName) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r3, "CronFieldName must not be null"), CronFieldName.class, "com.obric.memorydata.plugin");
        this.constraints = (FieldConstraints) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r4, "FieldConstraints must not be null"), FieldConstraints.class, "com.obric.memorydata.plugin");
        this.optional = r5;
    }

    public static Comparator<FieldDefinition> createFieldDefinitionComparator() {
        return Comparator.comparingInt($$Lambda$FieldDefinition$WQgGsw7i4CunVTc4Se09WkvT8tk.INSTANCE);
    }

    static /* synthetic */ int lambda$createFieldDefinitionComparator$0(FieldDefinition r0) {
        return r0.getFieldName().getOrder();
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
        FieldDefinition r6 = (FieldDefinition) ZeusTransformUtils.preCheckCast(r5, FieldDefinition.class, "com.obric.memorydata.plugin");
        if (this.optional != r6.optional) goto L18;
        if (this.fieldName != r6.fieldName) goto L18;
        if (this.constraints.equals(r6.constraints) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public FieldConstraints getConstraints() {
        return this.constraints;
    }

    public CronFieldName getFieldName() {
        return this.fieldName;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.fieldName, this.constraints, Boolean.valueOf(this.optional)});
    }

    public boolean isOptional() {
        return this.optional;
    }
}
