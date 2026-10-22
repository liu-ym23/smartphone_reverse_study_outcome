package com.cronutils.model.field.expression;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class And extends FieldExpression {
    private static final long serialVersionUID = -3406340596495131941L;
    private final List<FieldExpression> expressions;

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= (this.expressions.size() - 1)) goto L7;
        r0.append(((FieldExpression) ListProtector.get(this.expressions, r1)).asString());
        r0.append(",");
        r1 = r1 + 1;
        goto L4
    L7:
        if (this.expressions.size() <= 0) goto L10;
        List<FieldExpression> r2 = this.expressions;
        r0.append(((FieldExpression) ListProtector.get(r2, r2.size() - 1)).asString());
    L10:
        return r0.toString();
    }

    public List<FieldExpression> getExpressions() {
        return Collections.unmodifiableList(this.expressions);
    }

    public And() {
        this.expressions = new ArrayList();
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r3) {
        a r4 = (b) r3;
        r4.a(this);
        Iterator<FieldExpression> r0 = getExpressions().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().accept(r4);
        goto L4
    L6:
        return this;
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public And and(FieldExpression r2) {
        this.expressions.add(r2);
        return this;
    }
}
