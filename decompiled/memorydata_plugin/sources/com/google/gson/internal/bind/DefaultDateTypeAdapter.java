package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class DateType<T extends Date> {
        public static final DateType<Date> DATE = null;
        private final Class<T> dateClass;

        static {
            final Class<Date> r1 = Date.class;
            DATE = new AnonymousClass1(r1);
        }

        public DateType(Class<T> r1) {
            this.dateClass = r1;
        }

        private TypeAdapterFactory createFactory(DefaultDateTypeAdapter<T> r1) {
            return TypeAdapters.newFactory(this.dateClass, r1);
        }

        public final TypeAdapterFactory createAdapterFactory(int r3) {
            return createFactory(new DefaultDateTypeAdapter(this, r3, null));
        }

        public final TypeAdapterFactory createAdapterFactory(int r3, int r4) {
            return createFactory(new DefaultDateTypeAdapter(this, r3, r4, null));
        }

        public final TypeAdapterFactory createAdapterFactory(String r3) {
            return createFactory(new DefaultDateTypeAdapter(this, r3, null));
        }

        public final TypeAdapterFactory createDefaultsAdapterFactory() {
            int r1 = 2;
            return createFactory(new DefaultDateTypeAdapter(this, r1, r1, null));
        }

        public abstract T deserialize(Date r1);
    }

    private DefaultDateTypeAdapter(DateType<T> r4, int r5) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        this.dateType = (DateType) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4), DateType.class, "com.obric.memorydata.plugin");
        r0.add(DateFormat.getDateInstance(r5, Locale.US));
        if (Locale.getDefault().equals(Locale.US) == true) goto L6;
        r0.add(DateFormat.getDateInstance(r5));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r0.add(PreJava9DateFormatProvider.getUSDateFormat(r5));
        return;
    }

    private DefaultDateTypeAdapter(DateType<T> r4, int r5, int r6) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        this.dateType = (DateType) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4), DateType.class, "com.obric.memorydata.plugin");
        r0.add(DateFormat.getDateTimeInstance(r5, r6, Locale.US));
        if (Locale.getDefault().equals(Locale.US) == true) goto L6;
        r0.add(DateFormat.getDateTimeInstance(r5, r6));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r0.add(PreJava9DateFormatProvider.getUSDateTimeFormat(r5, r6));
        return;
    }

    /* synthetic */ DefaultDateTypeAdapter(DateType r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    /* synthetic */ DefaultDateTypeAdapter(DateType r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private DefaultDateTypeAdapter(DateType<T> r4, String r5) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        this.dateType = (DateType) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r4), DateType.class, "com.obric.memorydata.plugin");
        r0.add(new SimpleDateFormat(r5, Locale.US));
        if (Locale.getDefault().equals(Locale.US) == true) goto L6;
        r0.add(new SimpleDateFormat(r5));
        return;
    }

    /* synthetic */ DefaultDateTypeAdapter(DateType r1, String r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private Date deserializeToDate(JsonReader r6) {
        String r0 = r6.nextString();
        List<DateFormat> r1 = this.dateFormats;
        monitor-enter(r1);
        Iterator<DateFormat> r5 = this.dateFormats.iterator();     // Catch: Throwable -> L17
    L6:
        if (r5.hasNext() == false) goto L11;
        Date r7 = ((DateFormat) ZeusTransformUtils.preCheckCast(r5.next(), DateFormat.class, "com.obric.memorydata.plugin")).parse(r0);     // Catch: ParseException -> L20 Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return ISO8601Utils.parse(r0, new ParsePosition(0));
    L14:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r0 + "' as Date; at path " + r6.getPreviousPath(), e);
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Object read(JsonReader r1) {
        return read(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r3) {
        if (r3.peek() != JsonToken.NULL) goto L6;
        r3.nextNull();
        return null;
    L6:
        Date r4 = deserializeToDate(r3);
        return (T) this.dateType.deserialize(r4);
    }

    public String toString() {
        DateFormat r4 = (DateFormat) ZeusTransformUtils.preCheckCast(this.dateFormats.get(0), DateFormat.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SimpleDateFormat.class) == false) goto L7;
        StringBuilder r0 = new StringBuilder().append("DefaultDateTypeAdapter(");
        String r5 = ((SimpleDateFormat) ZeusTransformUtils.preCheckCast(r4, SimpleDateFormat.class, "com.obric.memorydata.plugin")).toPattern();
    L6:
        return r0.append(r5).append(')').toString();
    L7:
        r0 = new StringBuilder().append("DefaultDateTypeAdapter(");
        r5 = r4.getClass().getSimpleName();
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public /* synthetic */ void write(JsonWriter r3, Object r4) {
        write(r3, (Date) ZeusTransformUtils.preCheckCast(r4, Date.class, "com.obric.memorydata.plugin"));
    }

    public void write(JsonWriter r4, Date r5) {
        if (r5 != null) goto L5;
        r4.nullValue();
        return;
    L5:
        DateFormat r0 = (DateFormat) ZeusTransformUtils.preCheckCast(this.dateFormats.get(0), DateFormat.class, "com.obric.memorydata.plugin");
        List<DateFormat> r3 = this.dateFormats;
        monitor-enter(r3);
        String r6 = r0.format(r5);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        r4.value(r6);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
