package com.cronutils.model.field.expression;

import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.utils.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Every extends FieldExpression {
    private static final long serialVersionUID = -1103196842332906994L;
    private final FieldExpression expression;
    private final IntegerFieldValue period;

    public Every(FieldExpression r3, IntegerFieldValue r4) {
        this.expression = (FieldExpression) ZeusTransformUtils.preCheckCast(a.a(r3, "Expression must not be null"), FieldExpression.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        r4 = new IntegerFieldValue(1);
    L5:
        this.period = r4;
    }

    public Every(IntegerFieldValue r2) {
        this(always(), r2);
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(com.cronutils.model.field.expression.a.a r3) {
        return ((com.cronutils.model.field.expression.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.cronutils.model.field.expression.a.a.class, "com.obric.memorydata.plugin")).a(this);
    }

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
}
