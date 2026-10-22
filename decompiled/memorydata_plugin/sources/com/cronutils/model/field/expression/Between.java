package com.cronutils.model.field.expression;

import com.cronutils.model.field.expression.a.a;
import com.cronutils.model.field.value.FieldValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Between extends FieldExpression {
    private static final long serialVersionUID = 549075258664100474L;
    private final FieldValue<?> from;
    private final FieldValue<?> to;

    public Between(Between r2) {
        this(r2.getFrom(), r2.getTo());
    }

    public Between(FieldValue<?> r1, FieldValue<?> r2) {
        this.from = r1;
        this.to = r2;
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r3) {
        return ((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        return String.format("%s-%s", new Object[]{this.from, this.to});
    }

    public FieldValue<?> getFrom() {
        return this.from;
    }

    public FieldValue<?> getTo() {
        return this.to;
    }
}
