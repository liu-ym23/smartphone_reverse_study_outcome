package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    @Deprecated
    public l() {
    }

    public static i b(i6.a r10) {
        boolean r11 = r10.v();
        r10.d0(true);
        i r12 = com.google.gson.internal.j.a(r10);     // Catch: Throwable -> L6 OutOfMemoryError -> L8 StackOverflowError -> L11
        r10.d0(r11);
        return r12;
    L6:
        th = move-exception;
        r10.d0(r11);
        throw th;
    L8:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r10 + " to Json", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source: " + r10 + " to Json", e);     // Catch: Throwable -> L6
    }

    public static i c(Reader r10) {
        i6.a r11 = new i6.a(r10);     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
        i r12 = b(r11);     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
        if (r12.j() == false) goto L5;
    L9:
        return r12;
    L5:
        if (r11.Q() == JsonToken.END_DOCUMENT) goto L9;
        throw new JsonSyntaxException("Did not consume the entire document.");     // Catch: NumberFormatException -> L10 IOException -> L13 MalformedJsonException -> L16
    L16:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L13:
        e = move-exception;
        throw new JsonIOException(e);
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static i d(String r10) {
        return c(new StringReader(r10));
    }

    @Deprecated
    public i a(String r10) {
        return d(r10);
    }
}
