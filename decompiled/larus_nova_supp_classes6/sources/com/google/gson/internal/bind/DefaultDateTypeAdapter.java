package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final DateType<T> dateType;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public String toString() {
        DateFormat r0 = this.dateFormats.get(0);
        if ((r0 instanceof SimpleDateFormat) == false) goto L7;
        return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) r0).toPattern() + ')';
    L7:
        return "DefaultDateTypeAdapter(" + r0.getClass().getSimpleName() + ')';
    }

    private Date deserializeToDate(JsonReader r6) throws IOException {
        String r0 = r6.nextString();
        List<DateFormat> r1 = this.dateFormats;
        monitor-enter(r1);
        Iterator<DateFormat> r2 = this.dateFormats.iterator();     // Catch: Throwable -> L17
    L6:
        if (r2.hasNext() == false) goto L11;
        Date r7 = r2.next().parse(r0);     // Catch: ParseException -> L20 Throwable -> L17
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

    /* JADX INFO: renamed from: read, reason: collision with other method in class */
    public T m10read(JsonReader r3) throws IOException {
        if (r3.peek() != JsonToken.NULL) goto L6;
        r3.nextNull();
        return null;
    L6:
        Date r4 = deserializeToDate(r3);
        return (T) this.dateType.deserialize(r4);
    }

    public /* bridge */ /* synthetic */ Object read(JsonReader r1) throws IOException {
        return m10read(r1);
    }

    private DefaultDateTypeAdapter(DateType<T> r3, int r4) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        Objects.requireNonNull(r3);
        this.dateType = r3;
        Locale r5 = Locale.US;
        r0.add(DateFormat.getDateInstance(r4, r5));
        if (Locale.getDefault().equals(r5) == true) goto L6;
        r0.add(DateFormat.getDateInstance(r4));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r0.add(PreJava9DateFormatProvider.getUSDateFormat(r4));
        return;
    }

    public void write(JsonWriter r3, Date r4) throws IOException {
        if (r4 != null) goto L5;
        r3.nullValue();
        return;
    L5:
        DateFormat r0 = this.dateFormats.get(0);
        List<DateFormat> r1 = this.dateFormats;
        monitor-enter(r1);
        String r5 = r0.format(r4);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        r3.value(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private DefaultDateTypeAdapter(DateType<T> r3, String r4) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        Objects.requireNonNull(r3);
        this.dateType = r3;
        Locale r1 = Locale.US;
        r0.add(new SimpleDateFormat(r4, r1));
        if (Locale.getDefault().equals(r1) == true) goto L6;
        r0.add(new SimpleDateFormat(r4));
        return;
    }

    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Object r2) throws IOException {
        write(r1, (Date) r2);
    }

    private DefaultDateTypeAdapter(DateType<T> r3, int r4, int r5) {
        ArrayList r0 = new ArrayList();
        this.dateFormats = r0;
        Objects.requireNonNull(r3);
        this.dateType = r3;
        Locale r6 = Locale.US;
        r0.add(DateFormat.getDateTimeInstance(r4, r5, r6));
        if (Locale.getDefault().equals(r6) == true) goto L6;
        r0.add(DateFormat.getDateTimeInstance(r4, r5));
    L6:
        if (JavaVersion.isJava9OrLater() == false) goto L9;
        r0.add(PreJava9DateFormatProvider.getUSDateTimeFormat(r4, r5));
        return;
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType r1, String r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public /* synthetic */ DefaultDateTypeAdapter(DateType r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }
}
