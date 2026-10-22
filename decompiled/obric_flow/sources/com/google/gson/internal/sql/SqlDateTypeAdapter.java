package com.google.gson.internal.sql;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    static final TypeAdapterFactory FACTORY = null;
    private final DateFormat format;

    static {
        FACTORY = new AnonymousClass1();
    }

    public /* synthetic */ SqlDateTypeAdapter(AnonymousClass1 r5) {
        this();
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Date read(JsonReader r5) throws IOException {
        return read2(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r5, Date r10) throws IOException {
        write2(r5, r10);
    }

    private SqlDateTypeAdapter() {
        this.format = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader r10) throws IOException {
        if (r10.peek() != JsonToken.NULL) goto L6;
        r10.nextNull();
        return null;
    L6:
        String r5 = r10.nextString();
        monitor-enter(this);
        TimeZone r11 = this.format.getTimeZone();     // Catch: Throwable -> L13
        Date r12 = new Date(this.format.parse(r5).getTime());     // Catch: Throwable -> L15 ParseException -> L17
        this.format.setTimeZone(r11);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r12;
    L15:
        th = move-exception;
        this.format.setTimeZone(r11);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L17:
        e = move-exception;
        throw new JsonSyntaxException("Failed parsing '" + r5 + "' as SQL Date; at path " + r10.getPreviousPath(), e);     // Catch: Throwable -> L15
    L13:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r5, Date r10) throws IOException {
        if (r10 != null) goto L5;
        r5.nullValue();
        return;
    L5:
        monitor-enter(this);
        String r11 = this.format.format(r10);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r5.value(r11);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
