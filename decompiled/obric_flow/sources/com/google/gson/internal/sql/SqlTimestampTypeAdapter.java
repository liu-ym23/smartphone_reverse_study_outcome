package com.google.gson.internal.sql;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    static final TypeAdapterFactory FACTORY = null;
    private final TypeAdapter<Date> dateTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    public /* synthetic */ SqlTimestampTypeAdapter(TypeAdapter r5, AnonymousClass1 r10) {
        this(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Timestamp read(JsonReader r5) throws IOException {
        return read2(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r5, Timestamp r10) throws IOException {
        write2(r5, r10);
    }

    private SqlTimestampTypeAdapter(TypeAdapter<Date> r5) {
        this.dateTypeAdapter = r5;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Timestamp read2(JsonReader r5) throws IOException {
        Date r10 = this.dateTypeAdapter.read(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return new Timestamp(r10.getTime());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r5, Timestamp r10) throws IOException {
        this.dateTypeAdapter.write(r5, r10);
    }
}
