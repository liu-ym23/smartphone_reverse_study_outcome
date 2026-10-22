package com.bytedance.android.live.liveinteract.api.utils;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class StringEscapeUtils {

    public static class StringBuilderWriter extends Writer implements Serializable {
        private static final long serialVersionUID = -146927496096066153L;
        private final StringBuilder builder;

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return this.builder.toString();
        }

        public StringBuilderWriter() {
            this.builder = new StringBuilder();
        }

        public StringBuilderWriter(StringBuilder r1) {
            if (r1 != null) goto L6;
            r1 = new StringBuilder();
        L6:
            this.builder = r1;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char r2) {
            this.builder.append(r2);
            return this;
        }

        @Override // java.io.Writer
        public void write(String r2) {
            if (r2 == null) goto L5;
            this.builder.append(r2);
            return;
        }

        public StringBuilderWriter(int r2) {
            this.builder = new StringBuilder(r2);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r2) {
            this.builder.append(r2);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(char r1) throws IOException {
            return append(r1);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r1) throws IOException {
            return append(r1);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence r2, int r3, int r4) {
            this.builder.append(r2, r3, r4);
            return this;
        }

        @Override // java.io.Writer
        public void write(char[] r2, int r3, int r4) {
            if (r2 == null) goto L5;
            this.builder.append(r2, r3, r4);
            return;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public /* bridge */ /* synthetic */ Appendable append(CharSequence r1, int r2, int r3) throws IOException {
            return append(r1, r2, r3);
        }
    }

    public static String a(String r2) {
        if (r2 != null) goto L9;
        return null;
    L9:
        StringBuilderWriter r0 = new StringBuilderWriter(r2.length() * 2);     // Catch: IOException -> L6
        b(r0, r2);     // Catch: IOException -> L6
        return r0.toString();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String c(char r1) {
        return Integer.toHexString(r1).toUpperCase(Locale.ENGLISH);
    }

    public static void b(Writer r6, String r7) throws IOException {
        if (r7 == null) goto L40;
        int r0 = r7.length();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L56;
        char r2 = r7.charAt(r1);
        if (r2 <= 4095) goto L9;
        r6.write("\\u" + c(r2));
    L39:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 <= 255) goto L12;
        r6.write("\\u0" + c(r2));
        goto L39
    L12:
        if (r2 <= 127) goto L15;
        r6.write("\\u00" + c(r2));
        goto L39
    L15:
        if (r2 >= ' ') goto L28;
        switch(r2) {
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L24;
            case 12: goto L19;
            case 13: goto L18;
            default: goto L24;
        };
    L18:
        r6.write(92);
        r6.write(114);
        goto L24
    L19:
        r6.write(92);
        r6.write(102);
        goto L39
    L20:
        r6.write(92);
        r6.write(110);
        goto L39
    L21:
        r6.write(92);
        r6.write(116);
        goto L39
    L22:
        r6.write(92);
        r6.write(98);
    L24:
        if (r2 <= 15) goto L26;
        r6.write("\\u00" + c(r2));
        goto L39
    L26:
        r6.write("\\u000" + c(r2));
        goto L39
    L28:
        if (r2 != '\"') goto L30;
        r6.write(92);
        r6.write(34);
        goto L39
    L30:
        if (r2 != '\'') goto L32;
        r6.write(39);
        goto L39
    L32:
        if (r2 == '/') goto L36;
        if (r2 == '\\') goto L35;
        r6.write(r2);
        goto L39
    L35:
        r6.write(92);
        r6.write(92);
        goto L39
    L36:
        r6.write(47);
        goto L39
    L56:
        return;
    }
}
