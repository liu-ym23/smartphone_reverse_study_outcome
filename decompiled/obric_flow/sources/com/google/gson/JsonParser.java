package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonParser {
    @Deprecated
    public JsonParser() {
    }

    public static JsonElement parseReader(Reader r5) throws JsonIOException, JsonSyntaxException {
        JsonReader r10 = new JsonReader(r5);     // Catch: IOException -> L9 Throwable -> L11
        JsonElement r11 = parseReader(r10);     // Catch: IOException -> L9 Throwable -> L11
        if (r11.isJsonNull() == false) goto L5;
    L13:
        return r11;
    L5:
        if (r10.peek() == JsonToken.END_DOCUMENT) goto L13;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: IOException -> L9 Throwable -> L11
    L11:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L9:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public static JsonElement parseString(String r5) throws JsonSyntaxException {
        return parseReader(new StringReader(r5));
    }

    @Deprecated
    public JsonElement parse(String r5) throws JsonSyntaxException {
        return parseString(r5);
    }

    @Deprecated
    public JsonElement parse(Reader r5) throws JsonIOException, JsonSyntaxException {
        return parseReader(r5);
    }

    @Deprecated
    public JsonElement parse(JsonReader r5) throws JsonIOException, JsonSyntaxException {
        return parseReader(r5);
    }

    public static JsonElement parseReader(JsonReader r5) throws JsonIOException, JsonSyntaxException {
        Strictness r10 = r5.getStrictness();
        if (r10 != Strictness.LEGACY_STRICT) goto L15;
        r5.setStrictness(Strictness.LENIENT);
    L15:
        JsonElement r11 = Streams.parse(r5);     // Catch: Throwable -> L8 Throwable -> L10
        r5.setStrictness(r10);
        return r11;
    L10:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r5 + " to Json", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r5.setStrictness(r10);
        throw th;
    }
}
