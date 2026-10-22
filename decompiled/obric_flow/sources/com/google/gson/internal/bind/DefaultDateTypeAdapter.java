package com.google.gson.internal.bind;

import ai.j0;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    public static final TypeAdapterFactory DEFAULT_STYLE_FACTORY = null;
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = null;
        private final Class<T> dateClass;

        static {
            final Class<Date> r5 = Date.class;
            DATE = new AnonymousClass1(r5);
        }

        public DateType(Class<T> r5) {
            this.dateClass = r5;
        }

        private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> r5) {
            return TypeAdapters.newFactory(this.dateClass, r5);
        }

        public final TypeAdapterFactory createAdapterFactory(String r5) {
            return createFactory(new DefaultDateTypeAdapter(this, r5, null));
        }

        public abstract T deserialize(Date r5);

        public final TypeAdapterFactory createAdapterFactory(int r5, int r10) {
            return createFactory(new DefaultDateTypeAdapter(this, r5, r10, null));
        }
    }

    static {
        DEFAULT_STYLE_FACTORY = new AnonymousClass1();
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType r5, int r10, int r11, AnonymousClass1 r12) {
        this(r5, r10, r11);
    }

    private Date deserializeToDate(JsonReader r5) throws IOException {
        String r10 = r5.nextString();
        List<DateFormat> r11 = this.dateFormats;
        monitor-enter(r11);
        Iterator<DateFormat> r12 = this.dateFormats.iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L18;
        DateFormat r13 = r12.next();     // Catch: Throwable -> L12
        TimeZone r14 = r13.getTimeZone();     // Catch: Throwable -> L12
        Date r15 = r13.parse(r10);     // Catch: Throwable -> L14 ParseException -> L17
    L9:
        r13.setTimeZone(r14);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r15;
    L14:
        th = move-exception;
        r13.setTimeZone(r14);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L17:
        r13.setTimeZone(r14);     // Catch: Throwable -> L12
        goto L6
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return ISO8601Utils.parse(r10, new ParsePosition(0));
    L21:
        e = move-exception;
        StringBuilder r16 = j0.x("Failed parsing '", r10, "' as Date; at path ");
        r16.append(r5.getPreviousPath());
        throw new JsonSyntaxException(r16.toString(), e);
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Object read(JsonReader r5) throws IOException {
        return read(r5);
    }

    public String toString() {
        DateFormat r5 = this.dateFormats.get(0);
        if ((r5 instanceof SimpleDateFormat) == false) goto L7;
        return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) r5).toPattern() + ')';
    L7:
        return "DefaultDateTypeAdapter(" + r5.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r5, Object r10) throws IOException {
        write(r5, (Date) r10);
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType r5, String r10, AnonymousClass1 r11) {
        this(r5, r10);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r5) throws IOException {
        if (r5.peek() != JsonToken.NULL) goto L6;
        r5.nextNull();
        return null;
    L6:
        Date r10 = deserializeToDate(r5);
        return (T) this.dateType.deserialize(r10);
    }

    public void write(JsonWriter r5, Date r10) throws IOException {
        if (r10 != null) goto L5;
        r5.nullValue();
        return;
    L5:
        DateFormat r11 = this.dateFormats.get(0);
        List<DateFormat> r12 = this.dateFormats;
        monitor-enter(r12);
        String r13 = r11.format(r10);     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
        r5.value(r13);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private DefaultDateTypeAdapter(DateType<T> r5, String r10) {
        ArrayList r11 = new ArrayList();
        this.dateFormats = r11;
        Objects.requireNonNull(r5);
        this.dateType = r5;
        Locale r12 = Locale.US;
        r11.add(new SimpleDateFormat(r10, r12));
        if (Locale.getDefault().equals(r12) == true) goto L6;
        r11.add(new SimpleDateFormat(r10));
        return;
    }

    private DefaultDateTypeAdapter(DateType<T> r5, int r10, int r11) {
        ArrayList r12 = new ArrayList();
        this.dateFormats = r12;
        Objects.requireNonNull(r5);
        this.dateType = r5;
        Locale r13 = Locale.US;
        r12.add(DateFormat.getDateTimeInstance(r10, r11, r13));
        if (Locale.getDefault().equals(r13) == true) goto L6;
        r12.add(DateFormat.getDateTimeInstance(r10, r11));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r12.add(PreJava9DateFormatProvider.getUsDateTimeFormat(r10, r11));
        return;
    }
}
