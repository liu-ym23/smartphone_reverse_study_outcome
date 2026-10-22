package com.cronutils.model.field.expression;

import com.cronutils.model.field.expression.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class And extends FieldExpression {
    private static final long serialVersionUID = -3406340596495131941L;
    private final List<FieldExpression> expressions;

    public And() {
        this.expressions = new ArrayList();
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r3) {
        return ((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public And and(FieldExpression r2) {
        this.expressions.add(r2);
        return this;
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= (this.expressions.size() - 1)) goto L7;
        r0.append(((FieldExpression) ZeusTransformUtils.preCheckCast(this.expressions.get(r1), FieldExpression.class, "com.obric.memorydata.plugin")).asString());
        r0.append(",");
        r1 = r1 + 1;
        goto L4
    L7:
        if (this.expressions.size() <= 0) goto L10;
        List<FieldExpression> r5 = this.expressions;
        r0.append(((FieldExpression) ZeusTransformUtils.preCheckCast(r5.get(r5.size() - 1), FieldExpression.class, "com.obric.memorydata.plugin")).asString());
    L10:
        return r0.toString();
    }

    public List<FieldExpression> getExpressions() {
        return Collections.unmodifiableList(this.expressions);
    }
}
