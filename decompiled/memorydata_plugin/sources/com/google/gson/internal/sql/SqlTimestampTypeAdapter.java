package com.google.gson.internal.sql;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {
    static final TypeAdapterFactory FACTORY = null;
    private final TypeAdapter<Date> dateTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    private SqlTimestampTypeAdapter(TypeAdapter<Date> r1) {
        this.dateTypeAdapter = r1;
    }

    /* synthetic */ SqlTimestampTypeAdapter(TypeAdapter r1, AnonymousClass1 r2) {
        this(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Timestamp read(JsonReader r1) {
        return read2(r1);
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public Timestamp read2(JsonReader r3) {
        Date r2 = (Date) ZeusTransformUtils.preCheckCast(this.dateTypeAdapter.read(r3), Date.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new Timestamp(r2.getTime());
    }

    @Override // com.google.gson.TypeAdapter
    public /* synthetic */ void write(JsonWriter r3, Timestamp r4) {
        write2(r3, (Timestamp) ZeusTransformUtils.preCheckCast(r4, Timestamp.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r1, Timestamp r2) {
        this.dateTypeAdapter.write(r1, r2);
    }
}
