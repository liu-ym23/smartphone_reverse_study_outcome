package com.cronutils.model.field.expression;

import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class QuestionMark extends FieldExpression {
    static final QuestionMark INSTANCE = null;
    private static final long serialVersionUID = -3043597498019873616L;

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        return "?";
    }

    public String toString() {
        return "QuestionMark{}";
    }

    static {
        INSTANCE = new QuestionMark();
    }

    private QuestionMark() {
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r1) {
        ((b) r1).a(this);
        return this;
    }
}
