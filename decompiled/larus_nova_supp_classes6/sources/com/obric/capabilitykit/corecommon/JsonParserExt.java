package com.obric.capabilitykit.corecommon;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/corecommon/JsonParserExt;", "", "()V", "parseReader", "Lcom/google/gson/JsonElement;", "reader", "Lcom/google/gson/stream/JsonReader;", "Ljava/io/Reader;", "parseString", "json", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class JsonParserExt {
    public static final JsonParserExt INSTANCE = null;

    static {
        INSTANCE = new JsonParserExt();
    }

    private JsonParserExt() {
    }

    public final JsonElement parseReader(JsonReader r7) {
        Intrinsics.checkNotNullParameter(r7, "reader");
        boolean r2 = r7.isLenient();
        r7.setLenient(true);
        JsonElement r0 = Streams.parse(r7);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r7.setLenient(r2);
        return r0;
    L6:
        th = move-exception;
        r7.setLenient(r2);
        throw th;
    L8:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r7 + " to Json", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r7 + " to Json", e);     // Catch: Throwable -> L6
    }

    public final JsonElement parseReader(Reader r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        JsonReader r0 = new JsonReader(r3);     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
        JsonElement r4 = parseReader(r0);     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
        if (r4.isJsonNull() == false) goto L6;
    L10:
        return r4;
    L6:
        if (r0.peek() == JsonToken.END_DOCUMENT) goto L10;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L11 IOException -> L14 MalformedJsonException -> L17
    L14:
        e = move-exception;
        throw new JsonIOException(e);
    L11:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L17:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public final JsonElement parseString(String r2) {
        return parseReader(new StringReader(r2));
    }
}
