package com.cronutils.model.field;

import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.utils.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class CronField implements Serializable {
    private static final long serialVersionUID = -4042499846855256325L;
    private final FieldConstraints constraints;
    private final FieldExpression expression;
    private final CronFieldName field;

    public CronField(CronFieldName r2, FieldExpression r3, FieldConstraints r4) {
        this.field = r2;
        this.expression = (FieldExpression) ZeusTransformUtils.preCheckCast(a.a(r3, "FieldExpression must not be null"), FieldExpression.class, "com.obric.memorydata.plugin");
        this.constraints = (FieldConstraints) ZeusTransformUtils.preCheckCast(a.a(r4, "FieldConstraints must not be null"), FieldConstraints.class, "com.obric.memorydata.plugin");
    }

    public static Comparator<CronField> createFieldComparator() {
        return Comparator.comparingInt($$Lambda$CronField$PT6ypVXVY076KaaZ7KZDXLBWbwE.INSTANCE);
    }

    static /* synthetic */ int lambda$createFieldComparator$0(CronField r0) {
        return r0.getField().getOrder();
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

    public String toString() {
        return "CronField{field=" + this.field + '}';
    }
}
