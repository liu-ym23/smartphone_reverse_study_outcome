package com.cronutils.model.field.expression;

import com.cronutils.model.field.expression.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Always extends FieldExpression {
    static final Always INSTANCE = null;
    private static final long serialVersionUID = -1221923855248365713L;

    static {
        INSTANCE = new Always();
    }

    private Always() {
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r3) {
        return ((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        return "*";
    }

    public String toString() {
        return "Always{}";
    }
}
