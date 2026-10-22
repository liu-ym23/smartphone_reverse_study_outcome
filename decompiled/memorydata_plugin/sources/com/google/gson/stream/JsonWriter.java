package com.google.gson.stream;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS = null;
    private static final String[] REPLACEMENT_CHARS = null;
    private static final Pattern VALID_JSON_NUMBER_PATTERN = null;
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack;
    private int stackSize;

    static {
        VALID_JSON_NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
        REPLACEMENT_CHARS = new String[128];
        int r1 = 0;
    L4:
        if (r1 > 31) goto L6;
        REPLACEMENT_CHARS[r1] = String.format("\\u%04x", new Object[]{Integer.valueOf(r1)});
        r1 = r1 + 1;
        goto L4
    L6:
        String[] r0 = REPLACEMENT_CHARS;
        r0[34] = "\\\"";
        r0[92] = "\\\\";
        r0[9] = "\\t";
        r0[8] = "\\b";
        r0[10] = "\\n";
        r0[13] = "\\r";
        r0[12] = "\\f";
        String[] r2 = (String[]) ZeusTransformUtils.preCheckCast(r0.clone(), String[].class, "com.obric.memorydata.plugin");
        HTML_SAFE_REPLACEMENT_CHARS = r2;
        r2[60] = "\\u003c";
        r2[62] = "\\u003e";
        r2[38] = "\\u0026";
        r2[61] = "\\u003d";
        r2[39] = "\\u0027";
    }

    public JsonWriter(Writer r3) {
        this.stack = new int[32];
        this.stackSize = 0;
        push(6);
        this.separator = ParameterizedMessage.ERROR_MSG_SEPARATOR;
        this.serializeNulls = true;
        this.out = (Writer) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r3, "out == null"), Writer.class, "com.obric.memorydata.plugin");
    }

    private void beforeName() {
        int r0 = peek();
        if (r0 != 5) goto L6;
        this.out.write(44);
    L7:
        newline();
        replaceTop(4);
        return;
    L6:
        if (r0 == 3) goto L7;
        throw new IllegalStateException("Nesting problem.");
    }

    private void beforeValue() {
        int r0 = peek();
        if (r0 == 1) goto L20;
        if (r0 != 2) goto L6;
        this.out.append(',');
    L21:
        newline();
        return;
    L6:
        if (r0 != 4) goto L8;
        this.out.append(this.separator);
        replaceTop(5);
        return;
    L8:
        if (r0 == 6) goto L17;
        if (r0 != 7) goto L16;
        if (this.lenient == true) goto L17;
        throw new IllegalStateException("JSON must have only one top-level value.");
    L16:
        throw new IllegalStateException("Nesting problem.");
    L17:
        replaceTop(7);
        return;
    L20:
        replaceTop(2);
        goto L21
    }

    private JsonWriter close(int r2, int r3, char r4) {
        int r0 = peek();
        if (r0 == r3) goto L9;
        if (r0 == r2) goto L9;
        throw new IllegalStateException("Nesting problem.");
    L9:
        if (this.deferredName != null) goto L16;
        this.stackSize--;
        if (r0 != r3) goto L13;
        newline();
    L13:
        this.out.write(r4);
        return this;
    L16:
        throw new IllegalStateException("Dangling name: " + this.deferredName);
    }

    private static boolean isTrustedNumberType(Class<? extends Number> r1) {
        if (r1 != Integer.class) goto L5;
    L24:
        return true;
    L5:
        if (r1 == Long.class) goto L24;
        if (r1 == Double.class) goto L24;
        if (r1 == Float.class) goto L24;
        if (r1 == Byte.class) goto L24;
        if (r1 == Short.class) goto L24;
        if (r1 == BigDecimal.class) goto L24;
        if (r1 == BigInteger.class) goto L24;
        if (r1 == AtomicInteger.class) goto L24;
        if (r1 == AtomicLong.class) goto L24;
        return false;
    }

    private void newline() {
        if (this.indent != null) goto L5;
        return;
    L5:
        this.out.write(10);
        int r0 = this.stackSize;
        int r1 = 1;
    L6:
        if (r1 >= r0) goto L8;
        this.out.write(this.indent);
        r1 = r1 + 1;
        goto L6
    }

    private JsonWriter open(int r1, char r2) {
        beforeValue();
        push(r1);
        this.out.write(r2);
        return this;
    }

    private int peek() {
        int r0 = this.stackSize;
        if (r0 == 0) goto L7;
        return this.stack[r0 - 1];
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int r4) {
        int r0 = this.stackSize;
        int[] r1 = this.stack;
        if (r0 != r1.length) goto L5;
        this.stack = Arrays.copyOf(r1, r0 * 2);
    L5:
        int[] r2 = this.stack;
        int r3 = this.stackSize;
        this.stackSize = r3 + 1;
        r2[r3] = r4;
    }

    private void replaceTop(int r2) {
        this.stack[this.stackSize - 1] = r2;
    }

    private void string(String r9) {
        if (this.htmlSafe == false) goto L5;
        String[] r0 = HTML_SAFE_REPLACEMENT_CHARS;
    L6:
        this.out.write(34);
        int r1 = r9.length();
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r1) goto L23;
        char r5 = r9.charAt(r3);
        if (r5 >= 128) goto L14;
        String r6 = r0[r5];
        if (r6 == null) goto L22;
    L19:
        if (r4 >= r3) goto L21;
        this.out.write(r9, r4, r3 - r4);
    L21:
        this.out.write(r6);
        r4 = r3 + 1;
    L22:
        r3 = r3 + 1;
        goto L7
    L14:
        if (r5 != 8232) goto L17;
        r6 = "\\u2028";
        goto L19
    L17:
        if (r5 != 8233) goto L22;
        r6 = "\\u2029";
        goto L19
    L23:
        if (r4 >= r1) goto L25;
        this.out.write(r9, r4, r1 - r4);
    L25:
        this.out.write(34);
        return;
    L5:
        r0 = REPLACEMENT_CHARS;
        goto L6
    }

    private void writeDeferredName() {
        if (this.deferredName == null) goto L6;
        beforeName();
        string(this.deferredName);
        this.deferredName = null;
        return;
    }

    public JsonWriter beginArray() {
        writeDeferredName();
        return open(1, '[');
    }

    public JsonWriter beginObject() {
        writeDeferredName();
        return open(3, '{');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
        int r0 = this.stackSize;
        if (r0 > 1) goto L10;
        if (r0 == 1) goto L6;
    L7:
        this.stackSize = 0;
        return;
    L6:
        if (this.stack[r0 - 1] == 7) goto L7;
    L10:
        throw new IOException("Incomplete document");
    }

    public JsonWriter endArray() {
        return close(1, 2, ']');
    }

    public JsonWriter endObject() {
        return close(3, 5, '}');
    }

    public void flush() {
        if (this.stackSize == 0) goto L7;
        this.out.flush();
        return;
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter jsonValue(String r2) {
        if (r2 == null) goto L4;
        writeDeferredName();
        beforeValue();
        this.out.append(r2);
        return this;
    L4:
        return nullValue();
    }

    public JsonWriter name(String r2) {
        Objects.requireNonNull(r2, "name == null");
        if (this.deferredName != null) goto L11;
        if (this.stackSize == 0) goto L9;
        this.deferredName = r2;
        return this;
    L9:
        throw new IllegalStateException("JsonWriter is closed.");
    L11:
        throw new IllegalStateException();
    }

    public JsonWriter nullValue() {
        if (this.deferredName != null) goto L5;
    L9:
        beforeValue();
        this.out.write("null");
        return this;
    L5:
        if (this.serializeNulls == false) goto L7;
        writeDeferredName();
        goto L9
    L7:
        this.deferredName = null;
        return this;
    }

    public final void setHtmlSafe(boolean r1) {
        this.htmlSafe = r1;
    }

    public final void setIndent(String r2) {
        if (r2.length() != 0) goto L5;
        this.indent = null;
        String r3 = ParameterizedMessage.ERROR_MSG_SEPARATOR;
    L6:
        this.separator = r3;
        return;
    L5:
        this.indent = r2;
        r3 = ": ";
        goto L6
    }

    public final void setLenient(boolean r1) {
        this.lenient = r1;
    }

    public final void setSerializeNulls(boolean r1) {
        this.serializeNulls = r1;
    }

    public JsonWriter value(double r3) {
        writeDeferredName();
        if (this.lenient == false) goto L5;
    L11:
        beforeValue();
        this.out.append(Double.toString(r3));
        return this;
    L5:
        if (Double.isNaN(r3) == true) goto L10;
        if (Double.isInfinite(r3) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r3);
    }

    public JsonWriter value(float r3) {
        writeDeferredName();
        if (this.lenient == false) goto L5;
    L11:
        beforeValue();
        this.out.append(Float.toString(r3));
        return this;
    L5:
        if (Float.isNaN(r3) == true) goto L10;
        if (Float.isInfinite(r3) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r3);
    }

    public JsonWriter value(long r2) {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(r2));
        return this;
    }

    public JsonWriter value(Boolean r2) {
        if (r2 == null) goto L4;
        writeDeferredName();
        beforeValue();
        Writer r0 = this.out;
        if (r2.booleanValue() == false) goto L8;
        String r3 = "true";
    L9:
        r0.write(r3);
        return this;
    L8:
        r3 = "false";
        goto L9
    L4:
        return nullValue();
    }

    public JsonWriter value(Number r4) {
        if (r4 == null) goto L4;
        writeDeferredName();
        String r0 = r4.toString();
        if (r0.equals("-Infinity") == true) goto L20;
        if (r0.equals("Infinity") == true) goto L20;
        if (r0.equals("NaN") == true) goto L20;
        Class<?> r5 = r4.getClass();
        if (isTrustedNumberType(r5) == false) goto L15;
    L21:
        beforeValue();
        this.out.append(r0);
        return this;
    L15:
        if (VALID_JSON_NUMBER_PATTERN.matcher(r0).matches() == true) goto L21;
        throw new IllegalArgumentException("String created by " + r5 + " is not a valid JSON number: " + r0);
    L20:
        if (this.lenient == true) goto L21;
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r0);
    L4:
        return nullValue();
    }

    public JsonWriter value(String r1) {
        if (r1 == null) goto L4;
        writeDeferredName();
        beforeValue();
        string(r1);
        return this;
    L4:
        return nullValue();
    }

    public JsonWriter value(boolean r2) {
        writeDeferredName();
        beforeValue();
        Writer r0 = this.out;
        if (r2 == false) goto L5;
        String r3 = "true";
    L6:
        r0.write(r3);
        return this;
    L5:
        r3 = "false";
        goto L6
    }
}
