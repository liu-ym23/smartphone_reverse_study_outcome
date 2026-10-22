package com.cronutils.model.field.expression;

import com.cronutils.model.field.expression.a.a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FieldExpression implements Serializable {
    private static final long serialVersionUID = 5138279438874391617L;

    public FieldExpression() {
    }

    public static FieldExpression always() {
        return Always.INSTANCE;
    }

    public static FieldExpression questionMark() {
        return QuestionMark.INSTANCE;
    }

    public abstract FieldExpression accept(a r1);

    public And and(FieldExpression r2) {
        return new And().and(this).and(r2);
    }

    public abstract String asString();
}
