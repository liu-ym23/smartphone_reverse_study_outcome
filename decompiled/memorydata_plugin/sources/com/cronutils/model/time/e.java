package com.cronutils.model.time;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.DayOfWeekFieldDefinition;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.QuestionMark;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.time.generator.NoSuchValueException;
import com.cronutils.model.time.generator.h;
import com.cronutils.model.time.generator.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LocalTime f3429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CronDefinition f3430b;
    private final h c;
    private final CronField d;
    private final CronField e;
    private final CronField f;
    private final f g;
    private final f h;
    private final f i;
    private final f j;

    /* JADX INFO: renamed from: com.cronutils.model.time.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ZonedDateTime f3431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f3432b;

        private a(ZonedDateTime r1, boolean r2) {
            this.f3431a = r1;
            this.f3432b = r2;
        }

        /* synthetic */ a(ZonedDateTime r1, boolean r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public ZonedDateTime a() {
            return this.f3431a;
        }

        public boolean b() {
            return this.f3432b;
        }

        public String toString() {
            return "ExecutionTimeResult{time=" + this.f3431a + ", isMatch=" + this.f3432b + '}';
        }
    }

    static {
        f3429a = LocalTime.MAX.truncatedTo(ChronoUnit.SECONDS);
    }

    e(CronDefinition r5, CronField r6, CronField r7, CronField r8, CronField r9, f r10, f r11, f r12, f r13) {
        this.f3430b = (CronDefinition) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r5), CronDefinition.class, "com.obric.memorydata.plugin");
        if (r5.containsFieldDefinition(CronFieldName.YEAR) == true) goto L5;
        h r14 = i.a(new CronField(CronFieldName.YEAR, Always.always(), com.cronutils.model.field.constraint.a.h().g()));
    L11:
        this.c = r14;
        this.d = (CronField) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r7), CronField.class, "com.obric.memorydata.plugin");
        this.e = (CronField) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r8), CronField.class, "com.obric.memorydata.plugin");
        this.f = r9;
        this.g = (f) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r10), f.class, "com.obric.memorydata.plugin");
        this.h = (f) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r11), f.class, "com.obric.memorydata.plugin");
        this.i = (f) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r12), f.class, "com.obric.memorydata.plugin");
        this.j = (f) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r13), f.class, "com.obric.memorydata.plugin");
        return;
    L5:
        if (r5.getFieldDefinition(CronFieldName.YEAR).isOptional() == true) goto L7;
        com.cronutils.utils.a.a(r6);
    L7:
        if (r6 != null) goto L9;
        r14 = i.a(new CronField(CronFieldName.YEAR, Always.always(), r5.getFieldDefinition(CronFieldName.YEAR).getConstraints()));
        goto L11
    L9:
        r14 = i.b(r6);
        goto L11
    }

    private a a(ZonedDateTime r7, int r8, int r9, int r10) {
        boolean r2 = false;
        d r0 = this.g.a(r7.getMonthValue(), 0);
        int r1 = r0.a();
        AnonymousClass1 r4 = null;
        if (r0.b() > 0) goto L5;
        Optional<f> r3 = a(this.f3430b, ZonedDateTime.of(LocalDateTime.of(r7.getYear(), r1, 1, 0, 0), r7.getZone()));
        if (r3.isPresent() == false) goto L11;
        return new a(r7.truncatedTo(ChronoUnit.SECONDS).withMonth(r1).withDayOfMonth(((Integer) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.preCheckCast(r3.get(), f.class, "com.obric.memorydata.plugin")).a().get(0), Integer.class, "com.obric.memorydata.plugin")).intValue()).with(LocalTime.of(r8, r9, r10)), r2, r4);
    L11:
        return new a(g(r7), r2, r4);
    L5:
        return new a(r7.truncatedTo(ChronoUnit.DAYS).withMonth(1).withDayOfMonth(1).plusYears(r0.b()), r2, r4);
    }

    private a a(ZonedDateTime r7, int r8, int r9, int r10, int r11) {
        int r0 = this.c.a(r7.getYear());
        Optional<f> r1 = a(this.f3430b, ZonedDateTime.of(LocalDate.of(r0, r8, 1), LocalTime.MIN, r7.getZone()));
        AnonymousClass1 r3 = null;
        boolean r4 = false;
        if (r1.isPresent() == false) goto L7;
        return new a(ZonedDateTime.of(LocalDate.of(r0, r8, ((Integer) ZeusTransformUtils.preCheckCast(((f) ZeusTransformUtils.preCheckCast(r1.get(), f.class, "com.obric.memorydata.plugin")).a().get(0), Integer.class, "com.obric.memorydata.plugin")).intValue()), LocalTime.of(r9, r10, r11), r7.getZone()), r4, r3);
    L7:
        return new a(g(r7), r4, r3);
    }

    private a a(ZonedDateTime r4, int r5, int r6, int r7, f r8) {
        boolean r0 = false;
        d r3 = r8.a(r4.getDayOfMonth(), 0);
        AnonymousClass1 r1 = null;
        if (r3.b() <= 0) goto L7;
        return new a(r4.truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1).plusMonths(r3.b()), r0, r1);
    L7:
        return new a(r4.truncatedTo(ChronoUnit.SECONDS).withDayOfMonth(r3.a()).with(LocalTime.of(r5, r6, r7)), r0, r1);
    }

    private static a a(ZonedDateTime r8, f r9, TemporalField r10) {
        TemporalField r11 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r10, TemporalField.class, "com.obric.memorydata.plugin");
        HashSet r0 = new HashSet(r9.f3433a);
        TemporalUnit r12 = r11.getBaseUnit();
        long r1 = r11.range().getMaximum() - r11.range().getMinimum();
        long r3 = 0;
    L4:
        if (r3 >= (2 * r1)) goto L11;
        r8 = r8.plus(1, r12);
        if (r0.contains(Integer.valueOf(r8.get(r11))) == true) goto L8;
        r3 = r3 + 1;
        goto L4
    L8:
        return new a(r8.truncatedTo(r12), false, null);
    L11:
        throw new NoSuchValueException();
    }

    private f a(ZonedDateTime r4, WeekDay r5) {
        int r0 = LocalDate.of(r4.getYear(), r4.getMonthValue(), 1).lengthOfMonth();
        return new f((List) ZeusTransformUtils.preCheckCast(i.a(this.d, r4.getYear(), r4.getMonthValue(), r5).b(1, r0).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin"));
    }

    private static /* synthetic */ Integer a(ZonedDateTime r0, Integer r1) {
        return Integer.valueOf(LocalDate.ofYearDay(r0.getYear(), r1.intValue()).getDayOfMonth());
    }

    private List<Integer> a(int r6, int r7, WeekDay r8) {
        int r1 = LocalDate.of(r6, r7, 1).lengthOfMonth();
        if (ZeusTransformUtils.instanceOf(this.e.getExpression(), Always.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(this.d.getExpression(), Always.class) == false) goto L11;
    L6:
        h r5 = i.a(this.e, r6, r7);
    L7:
        Stream<Integer> r9 = r5.b(1, r1).stream();
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r9.distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(this.e.getExpression(), Always.class) == false) goto L14;
        r5 = i.a(this.d, r6, r7, r8);
        goto L7
    L14:
        if (ZeusTransformUtils.instanceOf(this.d.getExpression(), Always.class) == true) goto L6;
        List<Integer> r10 = i.a(this.d, r6, r7, r8).b(1, r1);
        List<Integer> r11 = i.a(this.e, r6, r7).b(1, r1);
        if (this.f3430b.isMatchDayOfWeekAndDayOfMonth() == false) goto L19;
        final HashSet r12 = new HashSet(r10);
        r9 = r11.stream().filter(new $$Lambda$vbQivBKgZNtGUIub04UkQ3Ify7Y(r12));
        goto L9
    L19:
        r9 = Stream.concat(r10.stream(), r11.stream());
        goto L9
    }

    private Optional<f> a(CronDefinition r3, ZonedDateTime r4) {
        if (a(r3) == false) goto L7;
        return h(r4);
    L7:
        if (r3.getFieldDefinition(CronFieldName.DAY_OF_WEEK) == null) goto L13;
        if (r3.getFieldDefinition(CronFieldName.DAY_OF_MONTH) == null) goto L13;
        return b(r3, r4);
    L13:
        if (r3.getFieldDefinition(CronFieldName.DAY_OF_WEEK) != null) goto L17;
        return i(r4);
    L17:
        return Optional.of(a(r4, ((DayOfWeekFieldDefinition) ZeusTransformUtils.preCheckCast(r3.getFieldDefinition(CronFieldName.DAY_OF_WEEK), DayOfWeekFieldDefinition.class, "com.obric.memorydata.plugin")).getMondayDoWValue()));
    }

    private static /* synthetic */ boolean a(int r1, int r2, Integer r3) {
        if (r3.intValue() >= r1) goto L5;
    L7:
        return false;
    L5:
        if (r3.intValue() >= r2) goto L7;
        return true;
    }

    private boolean a(CronDefinition r2) {
        if (r2.containsFieldDefinition(CronFieldName.DAY_OF_YEAR) == true) goto L7;
        return false;
    L7:
        if (r2.getFieldDefinition(CronFieldName.DAY_OF_YEAR).getConstraints().getSpecialChars().contains(SpecialChar.QUESTION_MARK) == true) goto L10;
        return true;
    L10:
        return !ZeusTransformUtils.instanceOf(this.f.getExpression(), QuestionMark.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ZonedDateTime b(ZonedDateTime r5) {
        int r1 = 0;
        Object[] r2 = 0 == true ? 1 : 0;
        a r0 = new a(r5, r2, null);
    L4:
        if (r1 >= 100000) goto L15;
        r0 = c(r0.a());
        if (r0.b() == true) goto L8;
        if ((r0.a().getYear() - r5.getYear()) > 100) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        throw new NoSuchValueException();
    L8:
        return r0.a();
    L15:
        throw new NoSuchValueException();
    }

    private List<Integer> b(int r6, int r7, WeekDay r8) {
        int r1 = LocalDate.of(r6, r7, 1).lengthOfMonth();
        if (ZeusTransformUtils.instanceOf(this.e.getExpression(), Always.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(this.d.getExpression(), Always.class) == false) goto L11;
    L6:
        h r5 = i.a(this.e, r6, r7);
    L7:
        Stream<Integer> r9 = r5.b(1, r1).stream().distinct();
    L9:
        return (List) ZeusTransformUtils.preCheckCast(r9.sorted().collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(this.e.getExpression(), QuestionMark.class) == false) goto L14;
        r5 = i.a(this.d, r6, r7, r8);
        goto L7
    L14:
        if (ZeusTransformUtils.instanceOf(this.d.getExpression(), QuestionMark.class) == true) goto L6;
        HashSet r2 = new HashSet(i.a(this.e, r6, r7).b(1, r1));
        r2.retainAll(new HashSet(i.a(this.d, r6, r7, r8).b(1, r1)));
        r9 = r2.stream();
        goto L9
    }

    private Optional<f> b(CronDefinition r4, ZonedDateTime r5) {
        if (r4.getFieldDefinition(CronFieldName.DAY_OF_WEEK).getConstraints().getSpecialChars().contains(SpecialChar.QUESTION_MARK) == false) goto L7;
        List<Integer> r3 = b(r5.getYear(), r5.getMonthValue(), ((DayOfWeekFieldDefinition) ZeusTransformUtils.preCheckCast(r4.getFieldDefinition(CronFieldName.DAY_OF_WEEK), DayOfWeekFieldDefinition.class, "com.obric.memorydata.plugin")).getMondayDoWValue());
    L6:
        return Optional.of(r3).filter(com.cronutils.utils.b.a($$Lambda$uXXlsNStXk0AvsHwzsQzoC1L1U.INSTANCE)).map($$Lambda$XMHmbRpJ2TipUmN8oAaqEGbwjHQ.INSTANCE);
    L7:
        r3 = a(r5.getYear(), r5.getMonthValue(), ((DayOfWeekFieldDefinition) ZeusTransformUtils.preCheckCast(r4.getFieldDefinition(CronFieldName.DAY_OF_WEEK), DayOfWeekFieldDefinition.class, "com.obric.memorydata.plugin")).getMondayDoWValue());
        goto L6
    }

    private static /* synthetic */ boolean b(ZonedDateTime r0, Integer r1) {
        if (r1.intValue() < r0.getYear()) goto L5;
        return true;
    L5:
        return false;
    }

    private a c(final ZonedDateTime r14) {
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.c.b(r14.getYear(), r14.getYear()).stream().filter(new $$Lambda$e$gJP77B8lzRwuYJIZFYntpK03Pc(r14)).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(this.g.a().get(0), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r9 = ((Integer) ZeusTransformUtils.preCheckCast(this.h.a().get(0), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r10 = ((Integer) ZeusTransformUtils.preCheckCast(this.i.a().get(0), Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r11 = ((Integer) ZeusTransformUtils.preCheckCast(this.j.a().get(0), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r0.isEmpty() == false) goto L7;
        return a(r14, r6, r9, r10, r11);
    L7:
        if (this.g.a().contains(Integer.valueOf(r14.getMonthValue())) == false) goto L9;
        Optional<f> r1 = a(this.f3430b, r14);
        AnonymousClass1 r4 = null;
        if (r1.isPresent() == false) goto L13;
        f r12 = (f) ZeusTransformUtils.preCheckCast(r1.get(), f.class, "com.obric.memorydata.plugin");
        if (r12.a().contains(Integer.valueOf(r14.getDayOfMonth())) == true) goto L19;
        return a(r14, r9, r10, r11, r12);
    L19:
        if (this.h.a().contains(Integer.valueOf(r14.getHour())) == true) goto L23;
        return d(r14);
    L23:
        if (this.i.a().contains(Integer.valueOf(r14.getMinute())) == true) goto L27;
        return e(r14);
    L27:
        if (this.j.a().contains(Integer.valueOf(r14.getSecond())) == true) goto L31;
        return f(r14);
    L31:
        return new a(r14, true, r4);
    L13:
        return new a(g(r14), r3, r4);
    L9:
        return a(r14, r9, r10, r11);
    }

    private a d(ZonedDateTime r2) {
        return a(r2, this.h, ChronoField.HOUR_OF_DAY);
    }

    private a e(ZonedDateTime r2) {
        return a(r2, this.i, ChronoField.MINUTE_OF_HOUR);
    }

    private a f(ZonedDateTime r2) {
        return a(r2, this.j, ChronoField.SECOND_OF_MINUTE);
    }

    private ZonedDateTime g(ZonedDateTime r3) {
        return r3.truncatedTo(ChronoUnit.DAYS).plusMonths(1).withDayOfMonth(1);
    }

    private Optional<f> h(final ZonedDateTime r6) {
        int r0 = r6.getYear();
        int r1 = r6.getMonthValue();
        int r3 = LocalDate.of(r0, 1, 1).lengthOfYear();
        List<Integer> r5 = i.a(this.f, r0).b(1, r3);
        final int r4 = LocalDate.of(r0, r1, 1).getDayOfYear();
        if (r1 != 12) goto L5;
        final int r2 = LocalDate.of(r0, 12, 31).getDayOfYear() + 1;
    L7:
        return Optional.of((List) ZeusTransformUtils.preCheckCast(r5.stream().filter(new $$Lambda$e$ydKayzpW3kiMJYj3ejumQHL8lQ(r4, r2)).map(new $$Lambda$e$TgwP3Y2vYaeQUUuzjX6CRFKeWvA(r6)).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin")).filter(com.cronutils.utils.b.a($$Lambda$uXXlsNStXk0AvsHwzsQzoC1L1U.INSTANCE)).map($$Lambda$XMHmbRpJ2TipUmN8oAaqEGbwjHQ.INSTANCE);
    L5:
        r2 = LocalDate.of(r0, r1 + 1, 1).getDayOfYear();
        goto L7
    }

    private Optional<f> i(ZonedDateTime r4) {
        int r0 = LocalDate.of(r4.getYear(), r4.getMonthValue(), 1).lengthOfMonth();
        List r3 = (List) ZeusTransformUtils.preCheckCast(i.a(this.e, r4.getYear(), r4.getMonthValue()).b(1, r0).stream().distinct().sorted().collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L6;
        return Optional.empty();
    L6:
        return Optional.of(new f(r3));
    }

    public static /* synthetic */ Integer lambda$TgwP3Y2vYaeQUUuzjX6CRFKeWvA(ZonedDateTime r0, Integer r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$gJP77B8lzRwuY-JIZFYntpK03Pc, reason: not valid java name */
    public static /* synthetic */ boolean m120lambda$gJP77B8lzRwuYJIZFYntpK03Pc(ZonedDateTime r0, Integer r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ydKayzpW-3kiMJYj3ejumQHL8lQ, reason: not valid java name */
    public static /* synthetic */ boolean m121lambda$ydKayzpW3kiMJYj3ejumQHL8lQ(int r0, int r1, Integer r2) {
        return a(r0, r1, r2);
    }

    @Override // com.cronutils.model.time.b
    public Optional<ZonedDateTime> a(ZonedDateTime r7) {
        com.cronutils.utils.a.a(r7);
        ZonedDateTime r0 = b(r7);     // Catch: NoSuchValueException -> L20
        if (r0.equals(r7) == false) goto L18;
        ZonedDateTime r2 = b(r7.plusSeconds(1));     // Catch: NoSuchValueException -> L20
        if (r2.getOffset().compareTo(r7.getOffset()) <= 0) goto L17;
        Optional r3 = Optional.empty();     // Catch: NoSuchValueException -> L20
        r3 = Optional.of(b(r2.plusSeconds(1)));     // Catch: NoSuchValueException -> L22
    L10:
        if (r3.isPresent() == false) goto L17;
        if (Duration.between(r2, (Temporal) ZeusTransformUtils.preCheckCast(r3.get(), Temporal.class, "com.obric.memorydata.plugin")).toHours() <= 1) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        r0 = b(r7.plusSeconds(1).plusHours(1));     // Catch: NoSuchValueException -> L20
        goto L18
    L14:
        r4 = false;
    L17:
        r0 = r2;
    L18:
        return Optional.of(r0);
    L21:
        return Optional.empty();
    }
}
