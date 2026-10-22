package com.cronutils.model.field.expression;

import com.cronutils.model.field.value.FieldValue;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.field.value.SpecialCharFieldValue;
import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Between extends FieldExpression {
    private static final long serialVersionUID = 549075258664100474L;
    private final FieldValue<?> from;
    private final FieldValue<?> to;

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

    public Between(Between r2) {
        this(r2.getFrom(), r2.getTo());
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r6) {
        b r7 = (b) r6;
        r7.a(this);
        r7.b(getFrom());
        r7.b(getTo());
        FieldValue<?> r0 = getFrom();
        if ((r0 instanceof SpecialCharFieldValue) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L29;
        FieldValue<?> r2 = getTo();
        if ((r2 instanceof SpecialCharFieldValue) == true) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L29;
        if (r7.a.isStrictRange() == true) goto L19;
    L27:
        return this;
    L19:
        if ((getFrom() instanceof IntegerFieldValue) == false) goto L27;
        if ((getTo() instanceof IntegerFieldValue) == false) goto L27;
        int r8 = ((IntegerFieldValue) getFrom()).getValue().intValue();
        int r4 = ((IntegerFieldValue) getTo()).getValue().intValue();
        if (r8 <= r4) goto L27;
        throw new IllegalArgumentException(String.format("Invalid range! [%s,%s]", new Object[]{Integer.valueOf(r8), Integer.valueOf(r4)}));
    L12:
        if (SpecialChar.L.equals(r2.getValue()) == true) goto L14;
        r3 = true;
    L29:
        throw new IllegalArgumentException("No special characters allowed in range, except for 'L'");
    L5:
        if (SpecialChar.L.equals(r0.getValue()) == true) goto L7;
        r1 = true;
        goto L8
    }

    public Between(FieldValue<?> r1, FieldValue<?> r2) {
        this.from = r1;
        this.to = r2;
    }
}
