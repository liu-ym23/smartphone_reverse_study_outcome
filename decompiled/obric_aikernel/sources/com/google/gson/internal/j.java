package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import e6.o;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    static /* synthetic */ class a {
    }

    private static final class b extends Writer {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Appendable f4263c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a f4264g;

        private static class a implements CharSequence {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private char[] f4265c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private String f4266g;

            private a() {
            }

            /* synthetic */ a(a r10) {
                this();
            }

            void a(char[] r10) {
                this.f4265c = r10;
                this.f4266g = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int r10) {
                return this.f4265c[r10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f4265c.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int r10, int r11) {
                return new String(this.f4265c, r10, r11 - r10);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f4266g != null) goto L6;
                this.f4266g = new String(this.f4265c);
            L6:
                return this.f4266g;
            }
        }

        b(Appendable r10) {
            this.f4264g = new a(null);
            this.f4263c = r10;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r10) {
            this.f4263c.append(r10);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r10, int r11, int r12) {
            this.f4263c.append(r10, r11, r12);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r10) {
            return append(r10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r10, int r11, int r12) {
            return append(r10, r11, r12);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int r10) {
            this.f4263c.append((char) r10);
        }

        @Override // java.io.Writer
        public void write(String r10, int r11, int r12) {
            Objects.requireNonNull(r10);
            this.f4263c.append(r10, r11, r12 + r11);
        }

        @Override // java.io.Writer
        public void write(char[] r10, int r11, int r12) {
            this.f4264g.a(r10);
            this.f4263c.append(this.f4264g, r11, r12 + r11);
        }
    }

    public static com.google.gson.i a(i6.a r10) {
        r10.Q();     // Catch: NumberFormatException -> L8 IOException -> L11 MalformedJsonException -> L14 EOFException -> L17
        boolean r11 = false;
        return o.V.b(r10);
    L6:
        e = e;
    L19:
        if (r11 == false) goto L23;
        return com.google.gson.j.f4273a;
    L23:
        throw new JsonSyntaxException(e);
    L17:
        e = e;
        r11 = true;
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

    public static void b(com.google.gson.i r10, com.google.gson.stream.a r11) {
        o.V.d(r11, r10);
    }

    public static Writer c(Appendable r10) {
        if ((r10 instanceof Writer) == false) goto L6;
        return (Writer) r10;
    L6:
        return new b(r10);
    }
}
