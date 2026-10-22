package com.cronutils.model.field.expression;

import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Always extends FieldExpression {
    static final Always INSTANCE = null;
    private static final long serialVersionUID = -1221923855248365713L;

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        return "*";
    }

    public String toString() {
        return "Always{}";
    }

    static {
        INSTANCE = new Always();
    }

    private Always() {
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r1) {
        ((b) r1).a(this);
        return this;
    }
}
