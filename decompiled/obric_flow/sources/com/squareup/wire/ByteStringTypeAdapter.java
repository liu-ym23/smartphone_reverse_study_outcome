package com.squareup.wire;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
class ByteStringTypeAdapter extends TypeAdapter<ByteString> {
    public ByteStringTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ ByteString read(JsonReader r5) {
        return read2(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r5, ByteString r10) {
        write2(r5, r10);
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public ByteString read2(JsonReader r5) {
        if (r5.peek() != JsonToken.NULL) goto L7;
        r5.nextNull();
        return null;
    L7:
        return ByteString.decodeBase64(r5.nextString());
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r5, ByteString r10) {
        if (r10 != null) goto L5;
        r5.nullValue();
        return;
    L5:
        r5.value(r10.base64());
    }
}
