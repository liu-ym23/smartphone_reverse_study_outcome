package com.bytedance.android.livesdk.gift.framework.base.tracejsonhelper;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
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

    public static String b(String r2) {
        if (r2 != null) goto L9;
        return null;
    L9:
        StringBuilderWriter r0 = new StringBuilderWriter(r2.length());     // Catch: IOException -> L6
        a(r0, r2);     // Catch: IOException -> L6
        return r0.toString();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void a(Writer r10, String r11) throws IOException {
        if (r11 == null) goto L61;
        int r0 = r11.length();
        StringBuilder r1 = new StringBuilder(4);
        int r4 = 0;
        boolean r5 = false;
        boolean r6 = false;
    L5:
        if (r4 >= r0) goto L49;
        char r8 = r11.charAt(r4);
        if (r6 == false) goto L16;
        r1.append(r8);
        if (r1.length() != 4) goto L48;
        r10.write((char) CastIntegerProtector.parseInt(r1.toString(), 16));     // Catch: NumberFormatException -> L12
        r1.setLength(0);     // Catch: NumberFormatException -> L12
        r5 = false;
        r6 = false;
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to parse unicode value: " + r1, e);
    L48:
        r4 = r4 + 1;
        goto L5
    L16:
        if (r5 == true) goto L18;
        if (r8 != '\\') goto L47;
        r5 = true;
        goto L48
    L47:
        r10.write(r8);
        goto L48
    L18:
        if (r8 != '\"') goto L20;
        r10.write(34);
    L44:
        r5 = false;
        goto L48
    L20:
        if (r8 == '\'') goto L42;
        if (r8 != '\\') goto L23;
        r10.write(92);
        goto L44
    L23:
        if (r8 != 'b') goto L25;
        r10.write(8);
        goto L44
    L25:
        if (r8 != 'f') goto L27;
        r10.write(12);
        goto L44
    L27:
        if (r8 != 'n') goto L29;
        r10.write(10);
        goto L44
    L29:
        if (r8 != 'r') goto L31;
        r10.write(13);
        goto L44
    L31:
        if (r8 != 't') goto L33;
        r10.write(9);
        goto L44
    L33:
        if (r8 == 'u') goto L35;
        r10.write(r8);
        goto L44
    L35:
        r5 = false;
        r6 = true;
        goto L48
    L42:
        r10.write(39);
        goto L44
    L49:
        if (r5 == false) goto L62;
        r10.write(92);
        return;
    L62:
        return;
    }
}
