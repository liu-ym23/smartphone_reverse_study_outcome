package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.JsonElementTypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Streams {

    /* JADX INFO: renamed from: com.google.gson.internal.Streams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        public static class CurrentWrite implements CharSequence {
            private String cachedString;
            private char[] chars;

            private CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int r5) {
                return this.chars[r5];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            public void setChars(char[] r5) {
                this.chars = r5;
                this.cachedString = null;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int r5, int r10) {
                return new String(this.chars, r5, r10 - r5);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.cachedString != null) goto L6;
                this.cachedString = new String(this.chars);
            L6:
                return this.cachedString;
            }

            public /* synthetic */ CurrentWrite(AnonymousClass1 r5) {
                this();
            }
        }

        public AppendableWriter(Appendable r5) {
            this.currentWrite = new CurrentWrite(null);
            this.appendable = r5;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r5) throws IOException {
            return append(r5);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Appendable r5 = this.appendable;
            if ((r5 instanceof Closeable) == false) goto L6;
            ((Closeable) r5).close();
            return;
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            Appendable r5 = this.appendable;
            if ((r5 instanceof Flushable) == false) goto L6;
            ((Flushable) r5).flush();
            return;
        }

        @Override // java.io.Writer
        public void write(char[] r5, int r10, int r11) throws IOException {
            this.currentWrite.setChars(r5);
            this.appendable.append(this.currentWrite, r10, r11 + r10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r5, int r10, int r11) throws IOException {
            return append(r5, r10, r11);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r5) throws IOException {
            this.appendable.append(r5);
            return this;
        }

        @Override // java.io.Writer
        public void write(int r5) throws IOException {
            this.appendable.append((char) r5);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r5, int r10, int r11) throws IOException {
            this.appendable.append(r5, r10, r11);
            return this;
        }

        @Override // java.io.Writer
        public void write(String r5, int r10, int r11) throws IOException {
            Objects.requireNonNull(r5);
            this.appendable.append(r5, r10, r11 + r10);
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader r5) throws JsonParseException {
        r5.peek();     // Catch: NumberFormatException -> L6 IOException -> L8 MalformedJsonException -> L10 EOFException -> L20
        boolean r10 = false;
        return JsonElementTypeAdapter.ADAPTER.read(r5);
    L12:
        e = e;
    L22:
        if (r10 == false) goto L26;
        return JsonNull.INSTANCE;
    L26:
        throw new JsonSyntaxException(e);
    L20:
        e = e;
        r10 = true;
    L10:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L8:
        e = move-exception;
        throw new JsonIOException(e);
    L6:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static void write(JsonElement r5, JsonWriter r10) throws IOException {
        JsonElementTypeAdapter.ADAPTER.write2(r10, r5);
    }

    public static Writer writerForAppendable(Appendable r5) {
        if ((r5 instanceof Writer) == false) goto L6;
        return (Writer) r5;
    L6:
        return new AppendableWriter(r5);
    }
}
