package com.cronutils.model.field.expression.a;

import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.expression.QuestionMark;
import com.cronutils.model.field.value.FieldValue;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.field.value.SpecialCharFieldValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FieldConstraints f3421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.cronutils.b f3422b;

    public b(FieldConstraints r2) {
        this.f3421a = r2;
        this.f3422b = new com.cronutils.b(r2);
    }

    private void a(FieldExpression r4) {
        String r3 = this.f3422b.a(r4.asString());
        if (r3.isEmpty() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Invalid chars in expression! Expression: %s Invalid chars: %s", new Object[]{r4.asString(), r3}));
    }

    private void c(Between r2) {
        a(r2.getFrom());
        a(r2.getTo());
        if (d(r2.getFrom()) == true) goto L8;
        if (d(r2.getTo()) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("No special characters allowed in range, except for 'L'");
    }

    @Override // com.cronutils.model.field.expression.a.a
    public /* synthetic */ FieldExpression a(Always r1) {
        return b(r1);
    }

    @Override // com.cronutils.model.field.expression.a.a
    public /* synthetic */ FieldExpression a(And r1) {
        return b(r1);
    }

    @Override // com.cronutils.model.field.expression.a.a
    public /* synthetic */ FieldExpression a(Between r1) {
        return b(r1);
    }

    @Override // com.cronutils.model.field.expression.a.a
    public /* synthetic */ FieldExpression a(Every r1) {
        return b(r1);
    }

    @Override // com.cronutils.model.field.expression.a.a
    public /* synthetic */ FieldExpression a(On r1) {
        return b(r1);
    }

    @Override // com.cronutils.model.field.expression.a.a
    public /* synthetic */ FieldExpression a(QuestionMark r1) {
        return b(r1);
    }

    public void a(FieldValue<?> r4) {
        if (ZeusTransformUtils.instanceOf(r4, IntegerFieldValue.class) == false) goto L9;
        int r5 = ((IntegerFieldValue) ZeusTransformUtils.preCheckCast(r4, IntegerFieldValue.class, "com.obric.memorydata.plugin")).getValue().intValue();
        if (this.f3421a.isInRange(r5) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(String.format("Value %s not in range [%s, %s]", new Object[]{Integer.valueOf(r5), Integer.valueOf(this.f3421a.getStartRange()), Integer.valueOf(this.f3421a.getEndRange())}));
    }

    public Always b(Always r1) {
        a(r1);
        return r1;
    }

    public And b(And r5) {
        a(r5);
        Iterator<FieldExpression> r0 = r5.getExpressions().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((FieldExpression) ZeusTransformUtils.preCheckCast(r0.next(), FieldExpression.class, "com.obric.memorydata.plugin")).accept(this);
        goto L4
    L6:
        return r5;
    }

    public Between b(Between r4) {
        a(r4);
        c(r4);
        if (this.f3421a.isStrictRange() == true) goto L5;
    L13:
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r4.getFrom(), IntegerFieldValue.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r4.getTo(), IntegerFieldValue.class) == false) goto L13;
        int r3 = ((IntegerFieldValue) ZeusTransformUtils.preCheckCast(r4.getFrom(), IntegerFieldValue.class, "com.obric.memorydata.plugin")).getValue().intValue();
        int r0 = ((IntegerFieldValue) ZeusTransformUtils.preCheckCast(r4.getTo(), IntegerFieldValue.class, "com.obric.memorydata.plugin")).getValue().intValue();
        if (r3 <= r0) goto L13;
        throw new IllegalArgumentException(String.format("Invalid range! [%s,%s]", new Object[]{Integer.valueOf(r3), Integer.valueOf(r0)}));
    }

    public Every b(Every r2) {
        a(r2);
        if (r2.getExpression() == null) goto L5;
        r2.getExpression().accept(this);
    L5:
        b(r2.getPeriod());
        return r2;
    }

    public On b(On r2) {
        a(r2);
        if (c(r2.getTime()) == true) goto L6;
        a(r2.getTime());
    L6:
        if (c(r2.getNth()) == true) goto L8;
        a(r2.getNth());
    L8:
        return r2;
    }

    public QuestionMark b(QuestionMark r1) {
        a(r1);
        return r1;
    }

    public void b(FieldValue<?> r4) {
        if (ZeusTransformUtils.instanceOf(r4, IntegerFieldValue.class) == false) goto L9;
        int r5 = ((IntegerFieldValue) ZeusTransformUtils.preCheckCast(r4, IntegerFieldValue.class, "com.obric.memorydata.plugin")).getValue().intValue();
        if (this.f3421a.isPeriodInRange(r5) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(String.format("Period %s not in range [%s, %s]", new Object[]{Integer.valueOf(r5), Integer.valueOf(this.f3421a.getStartRange()), Integer.valueOf(this.f3421a.getEndRange())}));
    }

    public boolean c(FieldValue<?> r2) {
        if (ZeusTransformUtils.instanceOf(r2, IntegerFieldValue.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((IntegerFieldValue) ZeusTransformUtils.preCheckCast(r2, IntegerFieldValue.class, "com.obric.memorydata.plugin")).getValue().intValue() != (-1)) goto L7;
        return true;
    }

    public boolean d(FieldValue<?> r1) {
        if (ZeusTransformUtils.instanceOf(r1, SpecialCharFieldValue.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (SpecialChar.L.equals(r1.getValue()) == true) goto L7;
        return true;
    }
}
