package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Streams {

    /* JADX INFO: renamed from: com.google.gson.internal.Streams$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        private static class CurrentWrite implements CharSequence {
            private String cachedString;
            private char[] chars;

            private CurrentWrite() {
            }

            /* synthetic */ CurrentWrite(AnonymousClass1 r1) {
                this();
            }

            @Override // java.lang.CharSequence
            public char charAt(int r1) {
                return this.chars[r1];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            void setChars(char[] r1) {
                this.chars = r1;
                this.cachedString = null;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int r2, int r3) {
                return new String(this.chars, r2, r3 - r2);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.cachedString != null) goto L6;
                this.cachedString = new String(this.chars);
            L6:
                return this.cachedString;
            }
        }

        AppendableWriter(Appendable r3) {
            Appendable r4 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r3, Appendable.class, "com.obric.memorydata.plugin");
            this.currentWrite = new CurrentWrite(null);
            this.appendable = r4;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.appendable.append(r4);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r3, int r4, int r5) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.appendable.append(r6, r4, r5);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* synthetic */ Appendable append(CharSequence r3) {
            return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* synthetic */ Appendable append(CharSequence r3, int r4, int r5) {
            return append((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r5);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int r1) {
            this.appendable.append((char) r1);
        }

        @Override // java.io.Writer
        public void write(String r1, int r2, int r3) {
            Objects.requireNonNull(r1);
            this.appendable.append(r1, r2, r3 + r2);
        }

        @Override // java.io.Writer
        public void write(char[] r2, int r3, int r4) {
            this.currentWrite.setChars(r2);
            this.appendable.append(this.currentWrite, r3, r4 + r3);
        }
    }

    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader r3) {
        r3.peek();     // Catch: NumberFormatException -> L8 IOException -> L11 MalformedJsonException -> L14 EOFException -> L17
        boolean r0 = false;
        return (JsonElement) ZeusTransformUtils.preCheckCast(TypeAdapters.JSON_ELEMENT.read(r3), JsonElement.class, "com.obric.memorydata.plugin");
    L6:
        e = e;
    L19:
        if (r0 == false) goto L23;
        return JsonNull.INSTANCE;
    L23:
        throw new JsonSyntaxException(e);
    L17:
        e = e;
        r0 = true;
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);
    L11:
        e = move-exception;
        throw new JsonIOException(e);
    L8:
        e = move-exception;
        throw new JsonSyntaxException(e);
    }

    public static void write(JsonElement r1, JsonWriter r2) {
        TypeAdapters.JSON_ELEMENT.write(r2, r1);
    }

    public static Writer writerForAppendable(Appendable r2) {
        Appendable r3 = (Appendable) ZeusTransformUtils.wrapperContextForParams(r2, Appendable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Writer.class) == false) goto L6;
        return (Writer) ZeusTransformUtils.preCheckCast(r3, Writer.class, "com.obric.memorydata.plugin");
    L6:
        return new AppendableWriter(r3);
    }
}
