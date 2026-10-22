package com.cronutils.model.field.expression;

import com.cronutils.model.field.expression.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class QuestionMark extends FieldExpression {
    static final QuestionMark INSTANCE = null;
    private static final long serialVersionUID = -3043597498019873616L;

    static {
        INSTANCE = new QuestionMark();
    }

    private QuestionMark() {
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r3) {
        return ((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        return "?";
    }

    public String toString() {
        return "QuestionMark{}";
    }
}
