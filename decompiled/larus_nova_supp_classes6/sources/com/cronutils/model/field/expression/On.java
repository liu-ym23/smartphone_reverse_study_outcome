package com.cronutils.model.field.expression;

import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.field.value.SpecialCharFieldValue;
import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class On extends FieldExpression {
    private static final long serialVersionUID = 8746471281123327324L;
    private final IntegerFieldValue nth;
    private final SpecialCharFieldValue specialChar;
    private final IntegerFieldValue time;

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        int r0 = a.a[this.specialChar.getValue().ordinal()];
        if (r0 == 1) goto L42;
        if (r0 == 2) goto L40;
        if (r0 == 3) goto L32;
        if (r0 == 4) goto L17;
        if (r0 != 5) goto L13;
        return "?";
    L13:
        return this.specialChar.toString();
    L17:
        if (getTime().getValue().intValue() != (-1)) goto L19;
        boolean r1 = true;
    L20:
        if (r1 == false) goto L30;
        StringBuilder r2 = new StringBuilder("L");
        if (getNth().getValue().intValue() != (-1)) goto L24;
        boolean r3 = true;
    L25:
        if (r3 == false) goto L27;
        String r4 = "";
    L28:
        r2.append(r4);
        return r2.toString();
    L27:
        r4 = String.format("-%s", new Object[]{getNth()});
        goto L28
    L24:
        r3 = false;
        goto L25
    L30:
        return String.format("%sL", new Object[]{getTime()});
    L19:
        r1 = false;
        goto L20
    L32:
        if (getTime().getValue().intValue() != (-1)) goto L34;
        boolean r5 = true;
    L35:
        if (r5 == false) goto L38;
        return "W";
    L38:
        return String.format("%sW", new Object[]{getTime()});
    L34:
        r5 = false;
        goto L35
    L40:
        return String.format("%s#%s", new Object[]{getTime(), getNth()});
    L42:
        return getTime().toString();
    }

    public IntegerFieldValue getNth() {
        return this.nth;
    }

    public SpecialCharFieldValue getSpecialChar() {
        return this.specialChar;
    }

    public IntegerFieldValue getTime() {
        return this.time;
    }

    public On(IntegerFieldValue r3) {
        this(r3, new SpecialCharFieldValue(SpecialChar.NONE));
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r6) {
        b r7 = (b) r6;
        r7.a(this);
        IntegerFieldValue r0 = getTime();
        boolean r2 = true;
        if ((r0 instanceof IntegerFieldValue) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        r7.b(getTime());
    L10:
        IntegerFieldValue r3 = getNth();
        if ((r3 instanceof IntegerFieldValue) == true) goto L13;
    L15:
        r2 = false;
    L16:
        if (r2 == true) goto L18;
        r7.b(getNth());
    L18:
        return this;
    L13:
        if (r3.getValue().intValue() != (-1)) goto L15;
    L5:
        if (r0.getValue().intValue() != (-1)) goto L7;
        r1 = true;
        goto L8
    }

    public On(SpecialCharFieldValue r3) {
        this(new IntegerFieldValue(-1), r3);
    }

    public On(IntegerFieldValue r3, SpecialCharFieldValue r4) {
        this(r3, r4, new IntegerFieldValue(-1));
        zr7.a.a(!r4.getValue().equals(SpecialChar.HASH), "value missing for a#b cron expression");
    }

    public On(IntegerFieldValue r2, SpecialCharFieldValue r3, IntegerFieldValue r4) {
        zr7.a.b(r2, "time must not be null");
        zr7.a.b(r3, "special char must not null");
        zr7.a.b(r4, "nth value must not be null");
        this.time = r2;
        this.specialChar = r3;
        this.nth = r4;
    }
}
