package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String r5) {
        this(new StringReader(r5));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Object r5 = this.lock;
        monitor-enter(r5);
        if (this.parser.peek() == JsonToken.END_DOCUMENT) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r10;
    L7:
        r10 = false;
        goto L8
    L10:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L10
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L10
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ JsonElement next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader r5) {
        JsonReader r10 = new JsonReader(r5);
        this.parser = r10;
        r10.setStrictness(Strictness.LENIENT);
        this.lock = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (hasNext() == false) goto L10;
        return Streams.parse(this.parser);
    L6:
        e = move-exception;
        throw new JsonParseException("Failed parsing JSON source to Json", e);
    L10:
        throw new NoSuchElementException();
    }
}
