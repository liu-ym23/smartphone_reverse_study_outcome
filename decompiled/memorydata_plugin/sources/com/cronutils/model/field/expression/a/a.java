package com.cronutils.model.field.expression.a;

import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.expression.QuestionMark;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    FieldExpression a(Always r1);

    FieldExpression a(And r1);

    FieldExpression a(Between r1);

    FieldExpression a(Every r1);

    FieldExpression a(On r1);

    FieldExpression a(QuestionMark r1);
}
