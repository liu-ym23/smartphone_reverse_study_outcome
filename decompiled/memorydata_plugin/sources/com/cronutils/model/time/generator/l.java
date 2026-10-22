package com.cronutils.model.time.generator;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.SpecialChar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;

/* JADX INFO: loaded from: classes2.dex */
class l extends k {

    /* JADX INFO: renamed from: com.cronutils.model.time.generator.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3443a = null;

        static {
            int[] r0 = new int[SpecialChar.values().length];
            f3443a = r0;
            r0[SpecialChar.L.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f3443a[SpecialChar.W.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f3443a[SpecialChar.LW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public l(CronField r1, int r2, int r3) {
        super(r1, r2, r3);
        com.cronutils.utils.a.a(CronFieldName.DAY_OF_MONTH.equals(r1.getField()), "CronField does not belong to day of month");
    }

    private int a(On r4, int r5, int r6) {
        int r3 = r4.getTime().getValue().intValue();
        int r0 = AnonymousClass1.f3443a[r4.getSpecialChar().getValue().ordinal()];
        if (r0 != 1) goto L5;
        int r7 = r4.getNth().getValue().intValue();
        int r8 = LocalDate.of(r5, r6, 1).lengthOfMonth();
        if (r7 > 0) goto L32;
        r7 = 0;
    L32:
        return r8 - r7;
    L5:
        if (r0 == 2) goto L15;
        if (r0 != 3) goto L14;
        LocalDate r9 = LocalDate.of(r5, r6, LocalDate.of(r5, r6, 1).lengthOfMonth());
        int r10 = r9.getDayOfWeek().getValue() - 5;
        if (r10 <= 0) goto L12;
        return r9.minusDays(r10).getDayOfMonth();
    L12:
        return r9.getDayOfMonth();
    L14:
        throw new NoSuchValueException();
    L15:
        LocalDate r11 = LocalDate.of(r5, r6, r3);
        if (r11.getDayOfWeek() != DayOfWeek.SATURDAY) goto L22;
        if (r3 != 1) goto L20;
        return 3;
    L20:
        return r3 - 1;
    L22:
        if (r11.getDayOfWeek() != DayOfWeek.SUNDAY) goto L26;
        int r12 = r3 + 1;
        if (r12 > r11.lengthOfMonth()) goto L26;
        return r12;
    L26:
        return r3;
    }

    @Override // com.cronutils.model.time.generator.h
    public int a(int r4) {
        int r3 = a((On) ZeusTransformUtils.preCheckCast(this.c.getExpression(), On.class, "com.obric.memorydata.plugin"), this.f3441a, this.f3442b);
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
    public boolean b(int r5) {
        On r0 = (On) ZeusTransformUtils.preCheckCast(this.c.getExpression(), On.class, "com.obric.memorydata.plugin");
        if (r5 != a(r0, this.f3441a, this.f3442b)) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
