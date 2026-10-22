package com.cronutils.model.time.generator;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
class m extends k {
    private static final On d = null;
    private final WeekDay e;

    /* JADX INFO: renamed from: com.cronutils.model.time.generator.m$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3444a = null;

        static {
            int[] r0 = new int[SpecialChar.values().length];
            f3444a = r0;
            r0[SpecialChar.HASH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f3444a[SpecialChar.L.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f3444a[SpecialChar.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        d = new On(new IntegerFieldValue(7));
    }

    public m(CronField r1, int r2, int r3, WeekDay r4) {
        super(r1, r2, r3);
        com.cronutils.utils.a.a(CronFieldName.DAY_OF_WEEK.equals(r1.getField()), "CronField does not belong to day of week");
        this.e = r4;
    }

    private int a(On r3, int r4, int r5) {
        DayOfWeek r6 = LocalDate.of(r4, r5, 1).getDayOfWeek();
        int r2 = com.cronutils.mapper.a.a(this.e, com.cronutils.mapper.a.f3409b, r3.getTime().getValue().intValue());
        int r7 = r3.getNth().getValue().intValue();
        int r8 = r6.getValue() - r2;
        if (r8 >= 0) goto L5;
        int r9 = Math.abs(r8) + 1;
    L6:
        if (r8 <= 0) goto L9;
        r9 = (r9 + 7) - r8;
    L9:
        return ((r7 - 1) * 7) + r9;
    L5:
        r9 = 1;
        goto L6
    }

    private int a(On r3, int r4, int r5, int r6) {
        int r0 = AnonymousClass1.f3444a[r3.getSpecialChar().getValue().ordinal()];
        if (r0 == 1) goto L18;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return b(r3, r4, r5, r6);
    L11:
        throw new NoSuchValueException();
    L13:
        if (r3.getTime().getValue().intValue() != (-1)) goto L16;
        return b(d, r4, r5, r6);
    L16:
        return b(r3, r4, r5);
    L18:
        return a(r3, r4, r5);
    }

    private int b(On r3, int r4, int r5) {
        LocalDate r6 = LocalDate.of(r4, r5, LocalDate.of(r4, r5, 1).lengthOfMonth());
        int r7 = r6.getDayOfWeek().getValue();
        int r2 = com.cronutils.mapper.a.a(this.e, com.cronutils.mapper.a.f3409b, r3.getTime().getValue().intValue());
        int r8 = r7 - r2;
        if (r8 == 0) goto L5;
        if (r8 >= 0) goto L10;
        LocalDate r9 = r6.minusDays(((long) r7) + ((long) (7 - r2)));
    L9:
        return r9.getDayOfMonth();
    L10:
        if (r8 <= 0) goto L13;
        r9 = r6.minusDays(r8);
        goto L9
    L13:
        throw new NoSuchValueException();
    L5:
        return r6.getDayOfMonth();
    }

    private int b(On r2, int r3, int r4, int r5) {
        int r6 = LocalDate.of(r3, r4, 1).getDayOfWeek().getValue() - com.cronutils.mapper.a.a(this.e, com.cronutils.mapper.a.f3409b, r2.getTime().getValue().intValue());
        if (r6 >= 0) goto L5;
        int r1 = Math.abs(r6) + 1;
    L6:
        if (r6 <= 0) goto L8;
        r1 = (r1 + 7) - r6;
    L8:
        if (r5 >= 1) goto L10;
        return r1;
    L10:
        if (r1 > r5) goto L12;
        r1 = r1 + 7;
        goto L10
    L12:
        return r1;
    L5:
        r1 = 1;
        goto L6
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r4) {
        int r3 = a((On) ZeusTransformUtils.preCheckCast(this.c.getExpression(), On.class, "com.obric.memorydata.plugin"), this.f3441a, this.f3442b, r4);
        if (r3 <= r4) goto L6;
        return r3;
    L6:
        throw new NoSuchValueException();
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean a(FieldExpression r1) {
        return ZeusTransformUtils.instanceOf(r1, On.class);
    }

    @Override // com.cronutils.model.time.generator.h
    public boolean b(int r6) {
        if (r6 != a((On) ZeusTransformUtils.preCheckCast(this.c.getExpression(), On.class, "com.obric.memorydata.plugin"), this.f3441a, this.f3442b, r6 - 1)) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
