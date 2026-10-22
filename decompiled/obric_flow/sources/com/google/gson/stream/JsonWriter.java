package com.google.gson.stream;

import com.google.gson.FormattingStyle;
import com.google.gson.Strictness;
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

/* JADX INFO: loaded from: classes2.dex */
public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS = null;
    private static final String[] REPLACEMENT_CHARS = null;
    private static final Pattern VALID_JSON_NUMBER_PATTERN = null;
    private String deferredName;
    private String formattedColon;
    private String formattedComma;
    private FormattingStyle formattingStyle;
    private boolean htmlSafe;
    private final Writer out;
    private boolean serializeNulls;
    private int[] stack;
    private int stackSize;
    private Strictness strictness;
    private boolean usesEmptyNewlineAndIndent;

    static {
        VALID_JSON_NUMBER_PATTERN = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
        REPLACEMENT_CHARS = new String[128];
        int r5 = 0;
    L4:
        if (r5 > 31) goto L6;
        REPLACEMENT_CHARS[r5] = String.format("\\u%04x", new Object[]{Integer.valueOf(r5)});
        r5 = r5 + 1;
        goto L4
    L6:
        String[] r10 = REPLACEMENT_CHARS;
        r10[34] = "\\\"";
        r10[92] = "\\\\";
        r10[9] = "\\t";
        r10[8] = "\\b";
        r10[10] = "\\n";
        r10[13] = "\\r";
        r10[12] = "\\f";
        String[] r11 = (String[]) r10.clone();
        HTML_SAFE_REPLACEMENT_CHARS = r11;
        r11[60] = "\\u003c";
        r11[62] = "\\u003e";
        r11[38] = "\\u0026";
        r11[61] = "\\u003d";
        r11[39] = "\\u0027";
    }

    public JsonWriter(Writer r5) {
        this.stack = new int[32];
        this.stackSize = 0;
        push(6);
        this.strictness = Strictness.LEGACY_STRICT;
        this.serializeNulls = true;
        Objects.requireNonNull(r5, "out == null");
        this.out = r5;
        setFormattingStyle(FormattingStyle.COMPACT);
    }

    private static boolean alwaysCreatesValidJsonNumber(Class<? extends Number> r5) {
        if (r5 != Integer.class) goto L5;
    L20:
        return true;
    L5:
        if (r5 == Long.class) goto L20;
        if (r5 == Byte.class) goto L20;
        if (r5 == Short.class) goto L20;
        if (r5 == BigDecimal.class) goto L20;
        if (r5 == BigInteger.class) goto L20;
        if (r5 == AtomicInteger.class) goto L20;
        if (r5 == AtomicLong.class) goto L20;
        return false;
    }

    private void beforeName() throws IOException {
        int r5 = peek();
        if (r5 != 5) goto L6;
        this.out.write(this.formattedComma);
    L7:
        newline();
        replaceTop(4);
        return;
    L6:
        if (r5 == 3) goto L7;
        throw new IllegalStateException("Nesting problem.");
    }

    private void beforeValue() throws IOException {
        int r5 = peek();
        if (r5 == 1) goto L20;
        if (r5 != 2) goto L6;
        this.out.append(this.formattedComma);
        newline();
        return;
    L6:
        if (r5 != 4) goto L8;
        this.out.append(this.formattedColon);
        replaceTop(5);
        return;
    L8:
        if (r5 == 6) goto L17;
        if (r5 != 7) goto L16;
        if (this.strictness == Strictness.LENIENT) goto L17;
        throw new IllegalStateException("JSON must have only one top-level value.");
    L16:
        throw new IllegalStateException("Nesting problem.");
    L17:
        replaceTop(7);
        return;
    L20:
        replaceTop(2);
        newline();
    }

    private JsonWriter closeScope(int r5, int r10, char r11) throws IOException {
        int r12 = peek();
        if (r12 == r10) goto L9;
        if (r12 == r5) goto L9;
        throw new IllegalStateException("Nesting problem.");
    L9:
        if (this.deferredName != null) goto L16;
        this.stackSize--;
        if (r12 != r10) goto L13;
        newline();
    L13:
        this.out.write(r11);
        return this;
    L16:
        throw new IllegalStateException("Dangling name: " + this.deferredName);
    }

    private void newline() throws IOException {
        if (this.usesEmptyNewlineAndIndent == false) goto L5;
        return;
    L5:
        this.out.write(this.formattingStyle.getNewline());
        int r5 = this.stackSize;
        int r10 = 1;
    L6:
        if (r10 >= r5) goto L8;
        this.out.write(this.formattingStyle.getIndent());
        r10 = r10 + 1;
        goto L6
    }

    private JsonWriter openScope(int r5, char r10) throws IOException {
        beforeValue();
        push(r5);
        this.out.write(r10);
        return this;
    }

    private int peek() {
        int r5 = this.stackSize;
        if (r5 == 0) goto L7;
        return this.stack[r5 - 1];
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int r5) {
        int r10 = this.stackSize;
        int[] r11 = this.stack;
        if (r10 != r11.length) goto L5;
        this.stack = Arrays.copyOf(r11, r10 * 2);
    L5:
        int[] r12 = this.stack;
        int r13 = this.stackSize;
        this.stackSize = r13 + 1;
        r12[r13] = r5;
    }

    private void replaceTop(int r5) {
        this.stack[this.stackSize - 1] = r5;
    }

    private void string(String r10) throws IOException {
        if (this.htmlSafe == false) goto L5;
        String[] r5 = HTML_SAFE_REPLACEMENT_CHARS;
    L6:
        this.out.write(34);
        int r11 = r10.length();
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r12 >= r11) goto L23;
        char r14 = r10.charAt(r12);
        if (r14 >= 128) goto L14;
        String r15 = r5[r14];
        if (r15 == null) goto L22;
    L19:
        if (r13 >= r12) goto L21;
        this.out.write(r10, r13, r12 - r13);
    L21:
        this.out.write(r15);
        r13 = r12 + 1;
    L22:
        r12 = r12 + 1;
        goto L7
    L14:
        if (r14 != 8232) goto L17;
        r15 = "\\u2028";
        goto L19
    L17:
        if (r14 != 8233) goto L22;
        r15 = "\\u2029";
        goto L19
    L23:
        if (r13 >= r11) goto L25;
        this.out.write(r10, r13, r11 - r13);
    L25:
        this.out.write(34);
        return;
    L5:
        r5 = REPLACEMENT_CHARS;
        goto L6
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName == null) goto L6;
        beforeName();
        string(this.deferredName);
        this.deferredName = null;
        return;
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return openScope(1, '[');
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return openScope(3, '{');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        int r5 = this.stackSize;
        if (r5 > 1) goto L10;
        if (r5 == 1) goto L6;
    L7:
        this.stackSize = 0;
        return;
    L6:
        if (this.stack[r5 - 1] == 7) goto L7;
    L10:
        throw new IOException("Incomplete document");
    }

    public JsonWriter endArray() throws IOException {
        return closeScope(1, 2, ']');
    }

    public JsonWriter endObject() throws IOException {
        return closeScope(3, 5, '}');
    }

    public void flush() throws IOException {
        if (this.stackSize == 0) goto L7;
        this.out.flush();
        return;
    L7:
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final FormattingStyle getFormattingStyle() {
        return this.formattingStyle;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final Strictness getStrictness() {
        return this.strictness;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        if (this.strictness != Strictness.LENIENT) goto L5;
        return true;
    L5:
        return false;
    }

    public JsonWriter jsonValue(String r5) throws IOException {
        if (r5 == null) goto L4;
        writeDeferredName();
        beforeValue();
        this.out.append(r5);
        return this;
    L4:
        return nullValue();
    }

    public JsonWriter name(String r5) throws IOException {
        Objects.requireNonNull(r5, "name == null");
        if (this.deferredName != null) goto L14;
        int r10 = peek();
        if (r10 != 3) goto L7;
    L11:
        this.deferredName = r5;
        return this;
    L7:
        if (r10 == 5) goto L11;
        throw new IllegalStateException("Please begin an object before writing a name.");
    L14:
        throw new IllegalStateException("Already wrote a name, expecting a value.");
    }

    public JsonWriter nullValue() throws IOException {
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

    public final void setFormattingStyle(FormattingStyle r5) {
        Objects.requireNonNull(r5);
        this.formattingStyle = r5;
        this.formattedComma = ",";
        if (r5.usesSpaceAfterSeparators() == false) goto L7;
        this.formattedColon = ": ";
        if (this.formattingStyle.getNewline().isEmpty() == false) goto L9;
        this.formattedComma = ", ";
    L9:
        if (this.formattingStyle.getNewline().isEmpty() == true) goto L11;
    L13:
        boolean r10 = false;
    L14:
        this.usesEmptyNewlineAndIndent = r10;
        return;
    L11:
        if (this.formattingStyle.getIndent().isEmpty() == false) goto L13;
        r10 = true;
        goto L14
    L7:
        this.formattedColon = ":";
        goto L9
    }

    public final void setHtmlSafe(boolean r5) {
        this.htmlSafe = r5;
    }

    public final void setIndent(String r5) {
        if (r5.isEmpty() == false) goto L5;
        setFormattingStyle(FormattingStyle.COMPACT);
        return;
    L5:
        setFormattingStyle(FormattingStyle.PRETTY.withIndent(r5));
    }

    @Deprecated
    public final void setLenient(boolean r5) {
        if (r5 == false) goto L4;
        Strictness r10 = Strictness.LENIENT;
    L5:
        setStrictness(r10);
        return;
    L4:
        r10 = Strictness.LEGACY_STRICT;
        goto L5
    }

    public final void setSerializeNulls(boolean r5) {
        this.serializeNulls = r5;
    }

    public final void setStrictness(Strictness r5) {
        Objects.requireNonNull(r5);
        this.strictness = r5;
    }

    public JsonWriter value(String r5) throws IOException {
        if (r5 == null) goto L4;
        writeDeferredName();
        beforeValue();
        string(r5);
        return this;
    L4:
        return nullValue();
    }

    public JsonWriter value(boolean r5) throws IOException {
        writeDeferredName();
        beforeValue();
        Writer r10 = this.out;
        if (r5 == false) goto L5;
        String r11 = "true";
    L6:
        r10.write(r11);
        return this;
    L5:
        r11 = "false";
        goto L6
    }

    public JsonWriter value(Boolean r5) throws IOException {
        if (r5 == null) goto L4;
        writeDeferredName();
        beforeValue();
        Writer r10 = this.out;
        if (r5.booleanValue() == false) goto L8;
        String r11 = "true";
    L9:
        r10.write(r11);
        return this;
    L8:
        r11 = "false";
        goto L9
    L4:
        return nullValue();
    }

    public JsonWriter value(float r5) throws IOException {
        writeDeferredName();
        if (this.strictness != Strictness.LENIENT) goto L5;
    L11:
        beforeValue();
        this.out.append(Float.toString(r5));
        return this;
    L5:
        if (Float.isNaN(r5) == true) goto L10;
        if (Float.isInfinite(r5) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r5);
    }

    public JsonWriter value(double r5) throws IOException {
        writeDeferredName();
        if (this.strictness != Strictness.LENIENT) goto L5;
    L11:
        beforeValue();
        this.out.append(Double.toString(r5));
        return this;
    L5:
        if (Double.isNaN(r5) == true) goto L10;
        if (Double.isInfinite(r5) == false) goto L11;
    L10:
        throw new IllegalArgumentException("Numeric values must be finite, but was " + r5);
    }

    public JsonWriter value(long r5) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(r5));
        return this;
    }

    public JsonWriter value(Number r5) throws IOException {
        if (r5 == null) goto L4;
        writeDeferredName();
        String r10 = r5.toString();
        Class<?> r11 = r5.getClass();
        if (alwaysCreatesValidJsonNumber(r11) == false) goto L8;
    L28:
        beforeValue();
        this.out.append(r10);
        return this;
    L8:
        if (r10.equals("-Infinity") == true) goto L24;
        if (r10.equals("Infinity") == true) goto L24;
        if (r10.equals("NaN") == true) goto L24;
        if (r11 == Float.class) goto L28;
        if (r11 == Double.class) goto L28;
        if (VALID_JSON_NUMBER_PATTERN.matcher(r10).matches() == true) goto L28;
        throw new IllegalArgumentException("String created by " + r11 + " is not a valid JSON number: " + r10);
    L24:
        if (this.strictness == Strictness.LENIENT) goto L28;
        throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(r10));
    L4:
        return nullValue();
    }
}
