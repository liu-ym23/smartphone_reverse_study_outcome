package com.cronutils.model.time;

import com.cronutils.model.Cron;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.time.generator.h;
import com.cronutils.model.time.generator.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Cron f3425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f3426b;
    private CronField c;
    private CronField d;
    private CronField e;
    private f f;
    private f g;
    private f h;
    private f i;

    public c(Cron r3) {
        this.f3425a = (Cron) ZeusTransformUtils.wrapperContextForParams(r3, Cron.class, "com.obric.memorydata.plugin");
    }

    private FieldConstraints a(CronFieldName r2) {
        if (this.f3425a.getCronDefinition().getFieldDefinition(r2) == null) goto L6;
        return this.f3425a.getCronDefinition().getFieldDefinition(r2).getConstraints();
    L6:
        return com.cronutils.model.field.constraint.a.h().a(r2).g();
    }

    private f a(CronFieldName r5, int r6, int r7) {
        FieldConstraints r4 = a(r5);
        return new f(i.a(new CronField(r5, new On(new IntegerFieldValue(r6)), r4)).b(r6, r7));
    }

    private void a(CronFieldName r3, CronField r4) {
        com.cronutils.utils.a.a(r3, "Reference CronFieldName cannot be null");
        com.cronutils.utils.a.a(r4.getField(), "CronField's CronFieldName cannot be null");
        if (r3.equals(r4.getField()) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Invalid argument! Expected CronField instance for field %s but found %s", new Object[]{r4.getField(), r3}));
    }

    private f b(CronFieldName r4, int r5, int r6) {
        return new f(i.a(new CronField(r4, FieldExpression.always(), a(r4))).b(r5, r6));
    }

    public b a() {
        if (this.i != null) goto L5;
        this.i = a(CronFieldName.SECOND, 0, 59);
        boolean r0 = false;
    L7:
        if (this.h != null) goto L13;
        CronFieldName r4 = CronFieldName.MINUTE;
        if (r0 == false) goto L11;
        f r1 = b(r4, 0, 59);
    L12:
        this.h = r1;
    L15:
        if (this.g != null) goto L21;
        CronFieldName r5 = CronFieldName.HOUR;
        if (r0 == false) goto L19;
        f r2 = b(r5, 0, 23);
    L20:
        this.g = r2;
    L23:
        if (this.d != null) goto L29;
        FieldConstraints r3 = a(CronFieldName.DAY_OF_MONTH);
        CronFieldName r6 = CronFieldName.DAY_OF_MONTH;
        if (r0 == false) goto L27;
        CronField r7 = new CronField(r6, FieldExpression.always(), r3);
    L28:
        this.d = r7;
    L31:
        if (this.c != null) goto L37;
        FieldConstraints r8 = a(CronFieldName.DAY_OF_WEEK);
        CronFieldName r9 = CronFieldName.DAY_OF_WEEK;
        if (r0 == false) goto L35;
        CronField r10 = new CronField(r9, FieldExpression.always(), r8);
    L36:
        this.c = r10;
    L39:
        if (this.f != null) goto L46;
        CronFieldName r11 = CronFieldName.MONTH;
        if (r0 == false) goto L43;
        f r12 = b(r11, 1, 12);
    L44:
        this.f = r12;
        goto L46
    L43:
        r12 = a(r11, 1, 12);
    L46:
        if (this.f3426b != null) goto L49;
        this.f3426b = i.a(new CronField(CronFieldName.YEAR, FieldExpression.always(), a(CronFieldName.YEAR)));
    L49:
        if (this.e != null) goto L56;
        FieldConstraints r13 = a(CronFieldName.DAY_OF_YEAR);
        CronFieldName r14 = CronFieldName.DAY_OF_YEAR;
        if (r0 == false) goto L53;
        FieldExpression r15 = FieldExpression.questionMark();
    L54:
        this.e = new CronField(r14, r15, r13);
        goto L56
    L53:
        r15 = FieldExpression.always();
    L56:
        return new e(this.f3425a.getCronDefinition(), this.f3425a.retrieve(CronFieldName.YEAR), this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    L35:
        r10 = new CronField(r9, new On(new IntegerFieldValue(1)), r8);
        goto L36
    L37:
        r0 = true;
        goto L39
    L27:
        r7 = new CronField(r6, new On(new IntegerFieldValue(1)), r3);
        goto L28
    L29:
        r0 = true;
        goto L31
    L19:
        r2 = a(r5, 0, 23);
        goto L20
    L21:
        r0 = true;
        goto L23
    L11:
        r1 = a(r4, 0, 59);
        goto L12
    L13:
        r0 = true;
        goto L15
    L5:
        r0 = true;
        goto L7
    }

    public c a(CronField r4) {
        a(CronFieldName.SECOND, r4);
        this.i = new f(i.a(r4).b(0, 59));
        return this;
    }

    public c b(CronField r4) {
        a(CronFieldName.MINUTE, r4);
        this.h = new f(i.a(r4).b(0, 59));
        return this;
    }

    public c c(CronField r4) {
        a(CronFieldName.HOUR, r4);
        this.g = new f(i.a(r4).b(0, 23));
        return this;
    }

    public c d(CronField r4) {
        a(CronFieldName.MONTH, r4);
        this.f = new f(i.a(r4).b(1, 12));
        return this;
    }

    public c e(CronField r2) {
        a(CronFieldName.YEAR, r2);
        this.f3426b = i.a(r2);
        return this;
    }

    public c f(CronField r2) {
        a(CronFieldName.DAY_OF_WEEK, r2);
        this.c = r2;
        return this;
    }

    public c g(CronField r2) {
        a(CronFieldName.DAY_OF_MONTH, r2);
        this.d = r2;
        return this;
    }

    public c h(CronField r2) {
        a(CronFieldName.DAY_OF_YEAR, r2);
        this.e = r2;
        return this;
    }
}
