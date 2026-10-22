package com.cronutils.model.field.expression;

import com.cronutils.model.field.value.IntegerFieldValue;
import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Every extends FieldExpression {
    private static final long serialVersionUID = -1103196842332906994L;
    private final FieldExpression expression;
    private final IntegerFieldValue period;

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        String r0 = this.expression.asString();
        if ("*".equals(r0) == false) goto L8;
        if (this.period.getValue().intValue() != 1) goto L8;
        return r0;
    L8:
        return String.format("%s/%s", new Object[]{r0, this.period});
    }

    public FieldExpression getExpression() {
        return this.expression;
    }

    public IntegerFieldValue getPeriod() {
        return this.period;
    }

    public Every(IntegerFieldValue r2) {
        this(FieldExpression.always(), r2);
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r5) {
        b r6 = (b) r5;
        r6.a(this);
        if (getExpression() == null) goto L5;
        getExpression().accept(r6);
    L5:
        IntegerFieldValue r0 = getPeriod();
        if ((r0 instanceof IntegerFieldValue) == false) goto L12;
        int r1 = r0.getValue().intValue();
        if (r6.a.isPeriodInRange(r1) == true) goto L12;
        throw new IllegalArgumentException(String.format("Period %s not in range [%s, %s]", new Object[]{Integer.valueOf(r1), Integer.valueOf(r6.a.getStartRange()), Integer.valueOf(r6.a.getEndRange())}));
    L12:
        return this;
    }

    public Every(FieldExpression r2, IntegerFieldValue r3) {
        zr7.a.b(r2, "Expression must not be null");
        this.expression = r2;
        if (r3 != null) goto L5;
        r3 = new IntegerFieldValue(1);
    L5:
        this.period = r3;
    }
}
