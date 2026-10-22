package com.google.gson.internal.bind;

import ai.j0;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/* JADX INFO: loaded from: classes2.dex */
@IgnoreJRERequirement
final class JavaTimeTypeAdapters implements TypeAdapters.FactorySupplier {
    private static final TypeAdapter<Duration> DURATION = null;
    private static final TypeAdapter<Instant> INSTANT = null;
    static final TypeAdapterFactory JAVA_TIME_FACTORY = null;
    private static final TypeAdapter<LocalDate> LOCAL_DATE = null;
    public static final TypeAdapter<LocalTime> LOCAL_TIME = null;
    private static final TypeAdapter<MonthDay> MONTH_DAY = null;
    private static final TypeAdapter<Period> PERIOD = null;
    private static final TypeAdapter<Year> YEAR = null;
    private static final TypeAdapter<YearMonth> YEAR_MONTH = null;
    private static final TypeAdapter<ZoneId> ZONE_ID = null;

    static {
        final String[] r5 = {"seconds", "nanos"};
        DURATION = new AnonymousClass1(r5);
        final String[] r10 = {"seconds", "nanos"};
        INSTANT = new AnonymousClass2(r10);
        final String[] r11 = {"year", "month", "day"};
        LOCAL_DATE = new AnonymousClass3(r11);
        final String[] r12 = {"hour", "minute", "second", "nano"};
        LOCAL_TIME = new AnonymousClass4(r12);
        final String[] r13 = {"month", "day"};
        MONTH_DAY = new AnonymousClass6(r13);
        final String[] r14 = {"years", "months", "days"};
        PERIOD = new AnonymousClass9(r14);
        final String[] r15 = {"year"};
        YEAR = new AnonymousClass10(r15);
        final String[] r16 = {"year", "month"};
        YEAR_MONTH = new AnonymousClass11(r16);
        ZONE_ID = new AnonymousClass12().nullSafe();
        JAVA_TIME_FACTORY = new AnonymousClass14();
    }

    public JavaTimeTypeAdapters() {
    }

    public static /* synthetic */ Object access$000(Object r5, String r10, JsonReader r11) {
        return requireNonNullField(r5, r10, r11);
    }

    public static /* synthetic */ TypeAdapter access$100() {
        return DURATION;
    }

    public static /* synthetic */ TypeAdapter access$1000() {
        return YEAR_MONTH;
    }

    public static /* synthetic */ TypeAdapter access$1100() {
        return ZONE_ID;
    }

    public static /* synthetic */ TypeAdapter access$1200(Gson r5) {
        return zonedDateTime(r5);
    }

    public static /* synthetic */ TypeAdapter access$200() {
        return INSTANT;
    }

    public static /* synthetic */ TypeAdapter access$300() {
        return LOCAL_DATE;
    }

    public static /* synthetic */ TypeAdapter access$400(Gson r5) {
        return localDateTime(r5);
    }

    public static /* synthetic */ TypeAdapter access$500() {
        return MONTH_DAY;
    }

    public static /* synthetic */ TypeAdapter access$600(Gson r5) {
        return offsetDateTime(r5);
    }

    public static /* synthetic */ TypeAdapter access$700(Gson r5) {
        return offsetTime(r5);
    }

    public static /* synthetic */ TypeAdapter access$800() {
        return PERIOD;
    }

    public static /* synthetic */ TypeAdapter access$900() {
        return YEAR;
    }

    private static TypeAdapter<LocalDateTime> localDateTime(Gson r5) {
        final TypeAdapter r10 = r5.getAdapter(LocalDate.class);
        final TypeAdapter r11 = r5.getAdapter(LocalTime.class);
        return new AnonymousClass5(r10, r11).nullSafe();
    }

    private static TypeAdapter<OffsetDateTime> offsetDateTime(Gson r5) {
        final TypeAdapter<LocalDateTime> r10 = localDateTime(r5);
        final TypeAdapter r11 = r5.getAdapter(ZoneOffset.class);
        return new AnonymousClass7(r10, r11).nullSafe();
    }

    private static TypeAdapter<OffsetTime> offsetTime(Gson r5) {
        final TypeAdapter r10 = r5.getAdapter(LocalTime.class);
        final TypeAdapter r11 = r5.getAdapter(ZoneOffset.class);
        return new AnonymousClass8(r10, r11).nullSafe();
    }

    private static <T> T requireNonNullField(T r5, String r10, JsonReader r11) {
        if (r5 == null) goto L4;
        return r5;
    L4:
        StringBuilder r12 = j0.x("Missing ", r10, " field; at path ");
        r12.append(r11.getPreviousPath());
        throw new JsonSyntaxException(r12.toString());
    }

    private static TypeAdapter<ZonedDateTime> zonedDateTime(Gson r5) {
        final TypeAdapter<LocalDateTime> r10 = localDateTime(r5);
        final TypeAdapter r11 = r5.getAdapter(ZoneOffset.class);
        final TypeAdapter r12 = r5.getAdapter(ZoneId.class);
        return new AnonymousClass13(r10, r11, r12).nullSafe();
    }

    @Override // com.google.gson.internal.bind.TypeAdapters.FactorySupplier
    public TypeAdapterFactory get() {
        return JAVA_TIME_FACTORY;
    }
}
