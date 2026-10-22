package com.cronutils.model.field.constraint;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.value.SpecialChar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f3415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, Integer> f3416b;
    private int c;
    private int d;
    private boolean e;
    private final Set<SpecialChar> f;

    /* JADX INFO: renamed from: com.cronutils.model.field.constraint.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3417a = null;

        static {
            int[] r0 = new int[CronFieldName.values().length];
            f3417a = r0;
            r0[CronFieldName.SECOND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f3417a[CronFieldName.MINUTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f3417a[CronFieldName.HOUR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f3417a[CronFieldName.DAY_OF_WEEK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f3417a[CronFieldName.DAY_OF_MONTH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f3417a[CronFieldName.MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f3417a[CronFieldName.DAY_OF_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private a() {
        this.f3415a = new HashMap();
        this.f3416b = new HashMap();
        this.c = 0;
        this.d = Integer.MAX_VALUE;
        this.e = false;
        HashSet r0 = new HashSet();
        this.f = r0;
        r0.add(SpecialChar.NONE);
    }

    public static a h() {
        return new a();
    }

    private static Map<String, Integer> i() {
        HashMap r0 = new HashMap();
        r0.put("MON", 1);
        r0.put("TUE", 2);
        r0.put("WED", 3);
        r0.put("THU", 4);
        r0.put("FRI", 5);
        r0.put("SAT", 6);
        r0.put("SUN", 7);
        return r0;
    }

    private static Map<String, Integer> j() {
        HashMap r0 = new HashMap();
        r0.put("JAN", 1);
        r0.put("FEB", 2);
        r0.put("MAR", 3);
        r0.put("APR", 4);
        r0.put("MAY", 5);
        r0.put("JUN", 6);
        r0.put("JUL", 7);
        r0.put("AUG", 8);
        r0.put("SEP", 9);
        r0.put("OCT", 10);
        r0.put("NOV", 11);
        r0.put("DEC", 12);
        return r0;
    }

    public a a() {
        this.f.add(SpecialChar.HASH);
        return this;
    }

    public a a(int r6) {
        if (r6 <= 0) goto L4;
    L5:
        Iterator<Map.Entry<String, Integer>> r0 = this.f3415a.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r2 = ((Integer) ZeusTransformUtils.preCheckCast(r1.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue() + r6;
        int r3 = this.d;
        if (r2 <= r3) goto L11;
        r2 = r2 - this.f3415a.size();
    L14:
        Map<String, Integer> r4 = this.f3415a;
        Object r5 = r1.getKey();
        String r7 = (String) r5;
        r4.put(r7, Integer.valueOf(r2));
        goto L7
    L11:
        int r8 = this.c;
        if (r2 >= r8) goto L14;
        r2 = r2 + (r8 - r3);
    L15:
        return this;
    L4:
        if (this.d >= this.f3415a.size()) goto L15;
        goto L5
    }

    public a a(int r2, int r3) {
        this.f3416b.put(Integer.valueOf(r2), Integer.valueOf(r3));
        return this;
    }

    public a a(CronFieldName r2) {
        switch(AnonymousClass1.f3417a[r2.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return this;
    L5:
        this.c = 1;
        int r3 = 366;
    L6:
        this.d = r3;
        return this;
    L8:
        this.f3415a = j();
        this.c = 1;
        r3 = 12;
        goto L6
    L9:
        this.c = 1;
        r3 = 31;
        goto L6
    L10:
        this.f3415a = i();
        r3 = 6;
        goto L6
    L11:
        r3 = 23;
        goto L6
    L12:
        r3 = 59;
        goto L6
    }

    public a b() {
        this.f.add(SpecialChar.L);
        return this;
    }

    public a b(int r1, int r2) {
        this.c = r1;
        this.d = r2;
        return this;
    }

    public a c() {
        this.f.add(SpecialChar.W);
        return this;
    }

    public a d() {
        this.f.add(SpecialChar.LW);
        return this;
    }

    public a e() {
        this.f.add(SpecialChar.QUESTION_MARK);
        return this;
    }

    public a f() {
        this.e = true;
        return this;
    }

    public FieldConstraints g() {
        return new FieldConstraints(this.f3415a, this.f3416b, this.f, this.c, this.d, this.e);
    }
}
