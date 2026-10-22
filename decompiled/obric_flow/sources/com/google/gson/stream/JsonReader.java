package com.google.gson.stream;

import ai.j0;
import com.google.gson.Strictness;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.TroubleshootingGuide;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class JsonReader implements Closeable {
    static final int BUFFER_SIZE = 1024;
    static final int DEFAULT_NESTING_LIMIT = 255;
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final Reader f9461in;
    private int limit;
    private int lineNumber;
    private int lineStart;
    private int nestingLimit;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos;
    private int[] stack;
    private int stackSize;
    private Strictness strictness;

    static {
        JsonReaderInternalAccess.INSTANCE = new AnonymousClass1();
    }

    public JsonReader(Reader r5) {
        this.strictness = Strictness.LEGACY_STRICT;
        this.nestingLimit = 255;
        this.buffer = new char[1024];
        this.pos = 0;
        this.limit = 0;
        this.lineNumber = 0;
        this.lineStart = 0;
        this.peeked = 0;
        int[] r10 = new int[32];
        this.stack = r10;
        this.stackSize = 1;
        r10[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(r5, "in == null");
        this.f9461in = r5;
    }

    public static /* synthetic */ IllegalStateException access$000(JsonReader r5, String r10) throws IOException {
        return r5.unexpectedTokenError(r10);
    }

    private void checkLenient() throws MalformedJsonException {
        if (this.strictness != Strictness.LENIENT) goto L6;
        return;
    L6:
        throw syntaxError("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int r5 = this.pos;
        this.pos = r5 - 1;
        if ((r5 + 4) > this.limit) goto L5;
    L7:
        int r10 = this.pos;
        char[] r11 = this.buffer;
        if (r11[r10] == ')') goto L10;
        return;
    L10:
        if (r11[r10 + 1] == ']') goto L12;
        return;
    L12:
        if (r11[r10 + 2] == '}') goto L14;
        return;
    L14:
        if (r11[r10 + 3] == '\'') goto L16;
        return;
    L16:
        if (r11[r10 + 4] != '\n') goto L24;
        this.pos = r10 + 5;
        return;
    L24:
        return;
    L5:
        if (fillBuffer(5) == true) goto L7;
    }

    private boolean fillBuffer(int r10) throws IOException {
        char[] r5 = this.buffer;
        int r11 = this.lineStart;
        int r12 = this.pos;
        this.lineStart = r11 - r12;
        int r13 = this.limit;
        if (r13 == r12) goto L5;
        int r14 = r13 - r12;
        this.limit = r14;
        System.arraycopy(r5, r12, r5, 0, r14);
    L6:
        this.pos = 0;
    L7:
        Reader r15 = this.f9461in;
        int r16 = this.limit;
        int r17 = r15.read(r5, r16, r5.length - r16);
        if (r17 == (-1)) goto L19;
        int r18 = this.limit + r17;
        this.limit = r18;
        if (this.lineNumber != 0) goto L17;
        int r19 = this.lineStart;
        if (r19 != 0) goto L17;
        if (r18 <= 0) goto L17;
        if (r5[0] != 65279) goto L17;
        this.pos++;
        this.lineStart = r19 + 1;
        r10 = r10 + 1;
    L17:
        if (r18 < r10) goto L7;
        return true;
    L19:
        return false;
    L5:
        this.limit = 0;
        goto L6
    }

    private String getPath(boolean r5) {
        StringBuilder r10 = new StringBuilder("$");
        int r11 = 0;
    L3:
        int r12 = this.stackSize;
        if (r11 >= r12) goto L21;
        int r13 = this.stack[r11];
        switch(r13) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L19;
            default: goto L8;
        };
    L9:
        r10.append('.');
        String r14 = this.pathNames[r11];
        if (r14 == null) goto L19;
        r10.append(r14);
        goto L19
    L12:
        int r15 = this.pathIndices[r11];
        if (r5 == false) goto L18;
        if (r15 <= 0) goto L18;
        if (r11 != (r12 - 1)) goto L18;
        r15 = r15 - 1;
    L18:
        r10.append('[');
        r10.append(r15);
        r10.append(']');
        goto L19
    L8:
        throw new AssertionError(j0.g(r13, "Unknown scope value: "));
    L19:
        r11 = r11 + 1;
        goto L3
    L21:
        return r10.toString();
    }

    private boolean isLiteral(char r5) throws IOException {
        if (r5 != '\t') goto L5;
        return false;
    L5:
        if (r5 != '\n') goto L7;
        return false;
    L7:
        if (r5 != '\f') goto L9;
        return false;
    L9:
        if (r5 != '\r') goto L11;
        return false;
    L11:
        if (r5 != ' ') goto L13;
        return false;
    L13:
        if (r5 != '#') goto L15;
    L31:
        checkLenient();
        return false;
    L15:
        if (r5 != ',') goto L17;
        return false;
    L17:
        if (r5 == '/') goto L31;
        if (r5 == '=') goto L31;
        if (r5 != '{') goto L23;
        return false;
    L23:
        if (r5 != '}') goto L25;
        return false;
    L25:
        if (r5 != ':') goto L27;
        return false;
    L27:
        if (r5 == ';') goto L31;
        switch(r5) {
            case 91: goto L43;
            case 92: goto L31;
            case 93: goto L43;
            default: goto L29;
        };
    L29:
        return true;
    L43:
        return false;
    }

    private int nextNonWhitespace(boolean r10) throws IOException {
        char[] r5 = this.buffer;
        int r11 = this.pos;
        int r12 = this.limit;
    L4:
        if (r11 != r12) goto L13;
        this.pos = r11;
        if (fillBuffer(1) == false) goto L7;
        r11 = this.pos;
        r12 = this.limit;
        goto L13
    L7:
        if (r10 == true) goto L11;
        return -1;
    L11:
        throw new EOFException("End of input" + locationString());
    L13:
        int r13 = r11 + 1;
        char r14 = r5[r11];
        if (r14 == '\n') goto L15;
        if (r14 == ' ') goto L45;
        if (r14 == '\r') goto L45;
        if (r14 == '\t') goto L45;
        if (r14 == '/') goto L25;
        if (r14 != '#') goto L43;
        this.pos = r13;
        checkLenient();
        skipToEndOfLine();
        r11 = this.pos;
        r12 = this.limit;
        goto L4
    L43:
        this.pos = r13;
        return r14;
    L25:
        this.pos = r13;
        if (r13 != r12) goto L30;
        this.pos = r11;
        boolean r15 = fillBuffer(2);
        this.pos++;
        if (r15 == true) goto L30;
        return r14;
    L30:
        checkLenient();
        int r16 = this.pos;
        char r17 = r5[r16];
        if (r17 != '*') goto L32;
        this.pos = r16 + 1;
        if (skipTo("*/") == false) goto L39;
        r11 = this.pos + 2;
        r12 = this.limit;
        goto L4
    L39:
        throw syntaxError("Unterminated comment");
    L32:
        if (r17 != '/') goto L33;
        this.pos = r16 + 1;
        skipToEndOfLine();
        r11 = this.pos;
        r12 = this.limit;
        goto L4
    L33:
        return r14;
    L45:
        r11 = r13;
        goto L4
    L15:
        this.lineNumber++;
        this.lineStart = r13;
        goto L45
    }

    private String nextQuotedValue(char r11) throws IOException {
        char[] r5 = this.buffer;
        StringBuilder r10 = null;
    L3:
        int r12 = this.pos;
        int r13 = this.limit;
    L4:
        int r14 = r13;
        int r15 = r12;
    L6:
        if (r12 >= r14) goto L31;
        int r16 = r12 + 1;
        char r17 = r5[r12];
        if (this.strictness == Strictness.STRICT) goto L10;
    L14:
        if (r17 == r11) goto L15;
        if (r17 == '\\') goto L23;
        if (r17 != '\n') goto L30;
        this.lineNumber++;
        this.lineStart = r16;
    L30:
        r12 = r16;
        goto L6
    L23:
        this.pos = r16;
        int r18 = r16 - r15;
        int r19 = r18 - 1;
        if (r10 != null) goto L26;
        r10 = new StringBuilder(Math.max(r18 * 2, 16));
    L26:
        r10.append(r5, r15, r19);
        r10.append(readEscapeCharacter());
        r12 = this.pos;
        r13 = this.limit;
        goto L4
    L15:
        this.pos = r16;
        int r20 = (r16 - r15) - 1;
        if (r10 == null) goto L18;
        r10.append(r5, r15, r20);
        return r10.toString();
    L18:
        return new String(r5, r15, r20);
    L10:
        if (r17 >= ' ') goto L14;
        throw syntaxError("Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode");
    L31:
        if (r10 != null) goto L33;
        r10 = new StringBuilder(Math.max((r12 - r15) * 2, 16));
    L33:
        r10.append(r5, r15, r12 - r15);
        this.pos = r12;
        if (fillBuffer(1) == true) goto L3;
        throw syntaxError("Unterminated string");
    }

    private String nextUnquotedValue() throws IOException {
        StringBuilder r5 = null;
        int r10 = 0;
    L3:
        int r11 = 0;
    L4:
        int r12 = this.pos;
        if ((r12 + r11) < this.limit) goto L6;
        if (r11 >= this.buffer.length) goto L41;
        if (fillBuffer(r11 + 1) == true) goto L4;
    L40:
        r10 = r11;
    L45:
        if (r5 != null) goto L47;
        String r13 = new String(this.buffer, this.pos, r10);
    L48:
        this.pos += r10;
        return r13;
    L47:
        r5.append(this.buffer, this.pos, r10);
        r13 = r5.toString();
        goto L48
    L41:
        if (r5 != null) goto L43;
        r5 = new StringBuilder(Math.max(r11, 16));
    L43:
        r5.append(this.buffer, this.pos, r11);
        this.pos += r11;
        if (fillBuffer(1) == true) goto L3;
    L6:
        char r14 = this.buffer[r12 + r11];
        if (r14 == '\t') goto L40;
        if (r14 == '\n') goto L40;
        if (r14 == '\f') goto L40;
        if (r14 == '\r') goto L40;
        if (r14 == ' ') goto L40;
        if (r14 == '#') goto L34;
        if (r14 == ',') goto L40;
        if (r14 == '/') goto L34;
        if (r14 == '=') goto L34;
        if (r14 == '{') goto L40;
        if (r14 == '}') goto L40;
        if (r14 == ':') goto L40;
        if (r14 == ';') goto L34;
        switch(r14) {
            case 91: goto L40;
            case 92: goto L34;
            case 93: goto L40;
            default: goto L33;
        };
    L33:
        r11 = r11 + 1;
    L34:
        checkLenient();
        goto L40
    }

    private int peekKeyword() throws IOException {
        char r5 = this.buffer[this.pos];
        if (r5 != 't') goto L5;
    L20:
        String r10 = "true";
        String r11 = "TRUE";
        int r12 = 5;
    L22:
        if (this.strictness == Strictness.STRICT) goto L24;
        boolean r13 = true;
    L25:
        int r14 = r10.length();
        int r15 = 0;
    L26:
        if (r15 >= r14) goto L41;
        if ((this.pos + r15) >= this.limit) goto L30;
    L32:
        char r16 = this.buffer[this.pos + r15];
        if (r16 == r10.charAt(r15)) goto L39;
        if (r13 == false) goto L38;
        if (r16 == r11.charAt(r15)) goto L39;
    L38:
        return 0;
    L39:
        r15 = r15 + 1;
        goto L26
    L30:
        if (fillBuffer(r15 + 1) == true) goto L32;
        return 0;
    L41:
        if ((this.pos + r14) < this.limit) goto L45;
        if (fillBuffer(r14 + 1) == true) goto L45;
    L47:
        this.pos += r14;
        this.peeked = r12;
        return r12;
    L45:
        if (isLiteral(this.buffer[this.pos + r14]) == false) goto L47;
        return 0;
    L24:
        r13 = false;
        goto L25
    L5:
        if (r5 == 'T') goto L20;
        if (r5 != 'f') goto L10;
    L19:
        r10 = "false";
        r11 = "FALSE";
        r12 = 6;
        goto L22
    L10:
        if (r5 == 'F') goto L19;
        if (r5 != 'n') goto L15;
    L18:
        r10 = "null";
        r11 = "NULL";
        r12 = 7;
        goto L22
    L15:
        if (r5 == 'N') goto L18;
        return 0;
    }

    private int peekNumber() throws IOException {
        char[] r5 = this.buffer;
        int r10 = this.pos;
        int r11 = this.limit;
        int r12 = 0;
        int r13 = 0;
        char r14 = 0;
        boolean r15 = false;
        boolean r16 = true;
        long r17 = 0;
    L4:
        if ((r10 + r13) == r11) goto L6;
    L12:
        char r18 = r5[r10 + r13];
        if (r18 != '+') goto L15;
        char r19 = 6;
        r12 = 0;
        if (r14 != 5) goto L101;
    L82:
        r14 = r19;
    L100:
        r13 = r13 + 1;
        goto L4
    L101:
        return 0;
    L15:
        if (r18 != 'E') goto L17;
    L90:
        r12 = 0;
        if (r14 != 2) goto L93;
    L96:
        r14 = 5;
        goto L100
    L93:
        if (r14 == 4) goto L96;
        return 0;
    L17:
        if (r18 == 'e') goto L90;
        if (r18 == '-') goto L84;
        r19 = 3;
        if (r18 != '.') goto L23;
        r12 = 0;
        if (r14 == 2) goto L82;
        return 0;
    L23:
        if (r18 < '0') goto L54;
        if (r18 > '9') goto L54;
        if (r14 == 1) goto L52;
        if (r14 == 0) goto L52;
        if (r14 == 2) goto L32;
        if (r14 != 3) goto L48;
        r12 = 0;
        r14 = 4;
        goto L100
    L48:
        if (r14 != 5) goto L50;
    L51:
        r12 = 0;
        r14 = 7;
        goto L100
    L50:
        if (r14 == 6) goto L51;
    L44:
        r12 = 0;
        goto L100
    L32:
        if (r17 == 0) goto L33;
        long r20 = (10 * r17) - ((long) (r18 - '0'));
        if (r17 > MIN_INCOMPLETE_INTEGER) goto L42;
        if (r17 == MIN_INCOMPLETE_INTEGER) goto L39;
    L41:
        boolean r21 = false;
    L43:
        r16 = r16 & r21;
        r17 = r20;
        goto L44
    L39:
        if (r20 >= r17) goto L41;
    L42:
        r21 = true;
        goto L43
    L33:
        return 0;
    L52:
        r17 = -(r18 - '0');
        r14 = 2;
    L54:
        if (isLiteral(r18) == true) goto L78;
    L55:
        if (r14 != 2) goto L68;
        if (r16 == false) goto L68;
        if (r17 != Long.MIN_VALUE) goto L61;
        if (r15 == false) goto L68;
    L61:
        if (r17 != 0) goto L63;
        if (r15 == true) goto L68;
    L63:
        if (r15 == true) goto L66;
        r17 = -r17;
    L66:
        this.peekedLong = r17;
        this.pos += r13;
        this.peeked = 15;
        return 15;
    L68:
        if (r14 != 2) goto L70;
    L76:
        this.peekedNumberLength = r13;
        this.peeked = 16;
        return 16;
    L70:
        if (r14 == 4) goto L76;
        if (r14 == 7) goto L76;
        return 0;
    L78:
        return 0;
    L84:
        r19 = 6;
        r12 = 0;
        if (r14 != 0) goto L87;
        r14 = 1;
        r15 = true;
        goto L100
    L87:
        if (r14 == 5) goto L82;
        return 0;
    L6:
        if (r13 == r5.length) goto L7;
        if (fillBuffer(r13 + 1) == false) goto L55;
        r10 = this.pos;
        r11 = this.limit;
        goto L12
    L7:
        return r12;
    }

    private void push(int r5) throws MalformedJsonException {
        int r10 = this.stackSize;
        if ((r10 - 1) >= this.nestingLimit) goto L10;
        int[] r11 = this.stack;
        if (r10 != r11.length) goto L7;
        int r12 = r10 * 2;
        this.stack = Arrays.copyOf(r11, r12);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r12);
        this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r12);
    L7:
        int[] r13 = this.stack;
        int r14 = this.stackSize;
        this.stackSize = r14 + 1;
        r13[r14] = r5;
        return;
    L10:
        throw new MalformedJsonException("Nesting limit " + this.nestingLimit + " reached" + locationString());
    }

    private char readEscapeCharacter() throws IOException {
        if (this.pos == this.limit) goto L5;
    L9:
        char[] r5 = this.buffer;
        int r10 = this.pos;
        int r11 = r10 + 1;
        this.pos = r11;
        char r12 = r5[r10];
        if (r12 == '\n') goto L72;
        if (r12 != '\"') goto L14;
    L76:
        return r12;
    L14:
        if (r12 == '\'') goto L75;
        if (r12 == '/') goto L76;
        if (r12 == '\\') goto L76;
        if (r12 != 'b') goto L22;
        return '\b';
    L22:
        if (r12 != 'f') goto L24;
        return '\f';
    L24:
        if (r12 != 'n') goto L26;
        return '\n';
    L26:
        if (r12 != 'r') goto L28;
        return '\r';
    L28:
        if (r12 != 't') goto L30;
        return '\t';
    L30:
        if (r12 != 'u') goto L61;
        if ((r10 + 5) > this.limit) goto L34;
    L38:
        int r13 = this.pos;
        int r14 = r13 + 4;
        int r15 = 0;
    L39:
        if (r13 >= r14) goto L58;
        char[] r16 = this.buffer;
        char r17 = r16[r13];
        int r18 = r15 << 4;
        if (r17 < '0') goto L47;
        if (r17 > '9') goto L47;
        int r19 = r17 - '0';
    L45:
        r15 = r19 + r18;
        r13 = r13 + 1;
    L47:
        if (r17 < 'a') goto L51;
        if (r17 > 'f') goto L51;
        r19 = r17 - 'W';
    L51:
        if (r17 < 'A') goto L57;
        if (r17 > 'F') goto L57;
        r19 = r17 - '7';
    L57:
        throw syntaxError("Malformed Unicode escape \\u".concat(new String(r16, this.pos, 4)));
    L58:
        this.pos += 4;
        return (char) r15;
    L34:
        if (fillBuffer(4) == true) goto L38;
        throw syntaxError("Unterminated escape sequence");
    L61:
        throw syntaxError("Invalid escape sequence");
    L75:
        if (this.strictness != Strictness.STRICT) goto L76;
        throw syntaxError("Invalid escaped character \"'\" in strict mode");
    L72:
        if (this.strictness == Strictness.STRICT) goto L80;
        this.lineNumber++;
        this.lineStart = r11;
        goto L75
    L80:
        throw syntaxError("Cannot escape a newline character in strict mode");
    L5:
        if (fillBuffer(1) == true) goto L9;
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char r10) throws IOException {
        char[] r5 = this.buffer;
    L3:
        int r11 = this.pos;
        int r12 = this.limit;
    L5:
        if (r11 >= r12) goto L17;
        int r13 = r11 + 1;
        char r14 = r5[r11];
        if (r14 == r10) goto L8;
        if (r14 == '\\') goto L12;
        if (r14 != '\n') goto L16;
        this.lineNumber++;
        this.lineStart = r13;
    L16:
        r11 = r13;
        goto L5
    L12:
        this.pos = r13;
        readEscapeCharacter();
        r11 = this.pos;
        r12 = this.limit;
        goto L5
    L8:
        this.pos = r13;
        return;
    L17:
        this.pos = r11;
        if (fillBuffer(1) == true) goto L3;
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String r10) throws IOException {
        int r5 = r10.length();
    L3:
        int r11 = 0;
        if ((this.pos + r5) > this.limit) goto L6;
    L9:
        char[] r12 = this.buffer;
        int r13 = this.pos;
        if (r12[r13] != '\n') goto L12;
        this.lineNumber++;
        this.lineStart = r13 + 1;
    L15:
        this.pos++;
    L12:
        if (r11 >= r5) goto L17;
        if (this.buffer[this.pos + r11] != r10.charAt(r11)) goto L15;
        r11 = r11 + 1;
        goto L12
    L17:
        return true;
    L6:
        if (fillBuffer(r5) == true) goto L9;
        return false;
    }

    private void skipToEndOfLine() throws IOException {
    L3:
        if (this.pos >= this.limit) goto L5;
    L6:
        char[] r5 = this.buffer;
        int r10 = this.pos;
        int r11 = r10 + 1;
        this.pos = r11;
        char r12 = r5[r10];
        if (r12 == '\n') goto L8;
        if (r12 != '\r') goto L3;
        return;
    L8:
        this.lineNumber++;
        this.lineStart = r11;
        return;
    L5:
        if (fillBuffer(1) == true) goto L6;
    }

    private void skipUnquotedValue() throws IOException {
    L2:
        int r5 = 0;
    L3:
        int r10 = this.pos;
        if ((r10 + r5) >= this.limit) goto L36;
        char r11 = this.buffer[r10 + r5];
        if (r11 == '\t') goto L34;
        if (r11 == '\n') goto L34;
        if (r11 == '\f') goto L34;
        if (r11 == '\r') goto L34;
        if (r11 == ' ') goto L34;
        if (r11 == '#') goto L33;
        if (r11 == ',') goto L34;
        if (r11 == '/') goto L33;
        if (r11 == '=') goto L33;
        if (r11 == '{') goto L34;
        if (r11 == '}') goto L34;
        if (r11 == ':') goto L34;
        if (r11 == ';') goto L33;
        switch(r11) {
            case 91: goto L34;
            case 92: goto L33;
            case 93: goto L34;
            default: goto L32;
        };
    L32:
        r5 = r5 + 1;
    L33:
        checkLenient();
    L34:
        this.pos += r5;
        return;
    L36:
        this.pos = r10 + r5;
        if (fillBuffer(1) == true) goto L2;
    }

    private MalformedJsonException syntaxError(String r5) throws MalformedJsonException {
        StringBuilder r10 = j0.u(r5);
        r10.append(locationString());
        r10.append("\nSee ");
        r10.append(TroubleshootingGuide.createUrl("malformed-json"));
        throw new MalformedJsonException(r10.toString());
    }

    private IllegalStateException unexpectedTokenError(String r5) throws IOException {
        if (peek() != JsonToken.NULL) goto L5;
        String r10 = "adapter-not-null-safe";
    L6:
        StringBuilder r11 = j0.x("Expected ", r5, " but was ");
        r11.append(peek());
        r11.append(locationString());
        r11.append("\nSee ");
        r11.append(TroubleshootingGuide.createUrl(r10));
        return new IllegalStateException(r11.toString());
    L5:
        r10 = "unexpected-json-structure";
        goto L6
    }

    private void validateAscii(String r5) throws MalformedJsonException {
        int r10 = 0;
    L4:
        if (r10 >= r5.length()) goto L10;
        if (r5.charAt(r10) > 127) goto L9;
        r10 = r10 + 1;
        goto L4
    L9:
        throw syntaxError("String contains non-ASCII characters: ".concat(r5));
    }

    public void beginArray() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 3) goto L10;
        push(1);
        this.pathIndices[this.stackSize - 1] = 0;
        this.peeked = 0;
        return;
    L10:
        throw unexpectedTokenError("BEGIN_ARRAY");
    }

    public void beginObject() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 1) goto L10;
        push(3);
        this.peeked = 0;
        return;
    L10:
        throw unexpectedTokenError("BEGIN_OBJECT");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f9461in.close();
    }

    public int doPeek() throws IOException {
        int[] r5 = this.stack;
        int r10 = this.stackSize;
        int r11 = r5[r10 - 1];
        if (r11 != 1) goto L5;
        r5[r10 - 1] = 2;
    L46:
        int r12 = nextNonWhitespace(true);
        if (r12 == 34) goto L84;
        if (r12 == 39) goto L82;
        if (r12 == 44) goto L75;
        if (r12 == 59) goto L75;
        if (r12 == 91) goto L73;
        if (r12 != 93) goto L55;
        if (r11 != 1) goto L75;
        this.peeked = 4;
        return 4;
    L55:
        if (r12 == 123) goto L68;
        this.pos--;
        int r13 = peekKeyword();
        if (r13 == 0) goto L59;
        return r13;
    L59:
        int r14 = peekNumber();
        if (r14 == 0) goto L63;
        return r14;
    L63:
        if (isLiteral(this.buffer[this.pos]) == false) goto L67;
        checkLenient();
        this.peeked = 10;
        return 10;
    L67:
        throw syntaxError("Expected value");
    L68:
        this.peeked = 1;
        return 1;
    L73:
        this.peeked = 3;
        return 3;
    L75:
        if (r11 == 1) goto L80;
        if (r11 == 2) goto L80;
        throw syntaxError("Unexpected value");
    L80:
        checkLenient();
        this.pos--;
        this.peeked = 7;
        return 7;
    L82:
        checkLenient();
        this.peeked = 8;
        return 8;
    L84:
        this.peeked = 9;
        return 9;
    L5:
        if (r11 != 2) goto L16;
        int r15 = nextNonWhitespace(true);
        if (r15 == 44) goto L46;
        if (r15 == 59) goto L14;
        if (r15 != 93) goto L13;
        this.peeked = 4;
        return 4;
    L13:
        throw syntaxError("Unterminated array");
    L14:
        checkLenient();
        goto L46
    L16:
        if (r11 == 3) goto L88;
        if (r11 == 5) goto L88;
        if (r11 != 4) goto L34;
        r5[r10 - 1] = 5;
        int r16 = nextNonWhitespace(true);
        if (r16 == 58) goto L46;
        if (r16 != 61) goto L32;
        checkLenient();
        if (this.pos >= this.limit) goto L27;
    L28:
        char[] r17 = this.buffer;
        int r18 = this.pos;
        if (r17[r18] != '>') goto L46;
        this.pos = r18 + 1;
        goto L46
    L27:
        if (fillBuffer(1) == false) goto L46;
    L32:
        throw syntaxError("Expected ':'");
    L34:
        if (r11 == 6) goto L36;
        if (r11 == 7) goto L41;
        if (r11 != 8) goto L46;
        throw new IllegalStateException("JsonReader is closed");
    L41:
        if (nextNonWhitespace(false) != (-1)) goto L44;
        this.peeked = 17;
        return 17;
    L44:
        checkLenient();
        this.pos--;
        goto L46
    L36:
        if (this.strictness != Strictness.LENIENT) goto L38;
        consumeNonExecutePrefix();
    L38:
        this.stack[this.stackSize - 1] = 7;
    L88:
        r5[r10 - 1] = 4;
        if (r11 != 5) goto L99;
        int r19 = nextNonWhitespace(true);
        if (r19 == 44) goto L99;
        if (r19 == 59) goto L98;
        if (r19 != 125) goto L97;
        this.peeked = 2;
        return 2;
    L97:
        throw syntaxError("Unterminated object");
    L98:
        checkLenient();
    L99:
        int r20 = nextNonWhitespace(true);
        if (r20 == 34) goto L117;
        if (r20 != 39) goto L103;
        checkLenient();
        this.peeked = 12;
        return 12;
    L103:
        if (r20 == 125) goto L110;
        checkLenient();
        this.pos--;
        if (isLiteral((char) r20) == false) goto L109;
        this.peeked = 14;
        return 14;
    L109:
        throw syntaxError("Expected name");
    L110:
        if (r11 == 5) goto L114;
        this.peeked = 2;
        return 2;
    L114:
        throw syntaxError("Expected name");
    L117:
        this.peeked = 13;
        return 13;
    }

    public void endArray() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 4) goto L10;
        int r10 = this.stackSize;
        this.stackSize = r10 - 1;
        int[] r11 = this.pathIndices;
        int r12 = r10 - 2;
        r11[r12] = r11[r12] + 1;
        this.peeked = 0;
        return;
    L10:
        throw unexpectedTokenError("END_ARRAY");
    }

    public void endObject() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 2) goto L10;
        int r10 = this.stackSize;
        int r11 = r10 - 1;
        this.stackSize = r11;
        this.pathNames[r11] = null;
        int[] r12 = this.pathIndices;
        int r13 = r10 - 2;
        r12[r13] = r12[r13] + 1;
        this.peeked = 0;
        return;
    L10:
        throw unexpectedTokenError("END_OBJECT");
    }

    public final int getNestingLimit() {
        return this.nestingLimit;
    }

    public String getPreviousPath() {
        return getPath(true);
    }

    public final Strictness getStrictness() {
        return this.strictness;
    }

    public boolean hasNext() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 2) goto L8;
    L12:
        return false;
    L8:
        if (r5 == 4) goto L12;
        if (r5 == 17) goto L12;
        return true;
    }

    public final boolean isLenient() {
        if (this.strictness != Strictness.LENIENT) goto L5;
        return true;
    L5:
        return false;
    }

    public String locationString() {
        StringBuilder r5 = j0.v(" at line ", this.lineNumber + 1, (this.pos - this.lineStart) + 1, " column ", " path ");
        r5.append(getPath());
        return r5.toString();
    }

    public boolean nextBoolean() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 5) goto L10;
        this.peeked = 0;
        int[] r10 = this.pathIndices;
        int r11 = this.stackSize - 1;
        r10[r11] = r10[r11] + 1;
        return true;
    L10:
        if (r5 != 6) goto L14;
        this.peeked = 0;
        int[] r12 = this.pathIndices;
        int r13 = this.stackSize - 1;
        r12[r13] = r12[r13] + 1;
        return false;
    L14:
        throw unexpectedTokenError("a boolean");
    }

    public double nextDouble() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 15) goto L10;
        this.peeked = 0;
        int[] r10 = this.pathIndices;
        int r11 = this.stackSize - 1;
        r10[r11] = r10[r11] + 1;
        return this.peekedLong;
    L10:
        if (r5 != 16) goto L13;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L28:
        this.peeked = 11;
        double r12 = Double.parseDouble(this.peekedString);
        if (this.strictness != Strictness.LENIENT) goto L31;
    L37:
        this.peekedString = null;
        this.peeked = 0;
        int[] r13 = this.pathIndices;
        int r14 = this.stackSize - 1;
        r13[r14] = r13[r14] + 1;
        return r12;
    L31:
        if (Double.isNaN(r12) == true) goto L36;
        if (Double.isInfinite(r12) == false) goto L37;
    L36:
        throw syntaxError("JSON forbids NaN and infinities: " + r12);
    L13:
        if (r5 != 8) goto L15;
    L24:
        if (r5 != 8) goto L26;
        char r15 = '\'';
    L27:
        this.peekedString = nextQuotedValue(r15);
        goto L28
    L26:
        r15 = Typography.quote;
        goto L27
    L15:
        if (r5 == 9) goto L24;
        if (r5 != 10) goto L20;
        this.peekedString = nextUnquotedValue();
        goto L28
    L20:
        if (r5 == 11) goto L28;
        throw unexpectedTokenError("a double");
    }

    public int nextInt() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 15) goto L14;
        long r10 = this.peekedLong;
        int r11 = (int) r10;
        if (r10 != r11) goto L12;
        this.peeked = 0;
        int[] r12 = this.pathIndices;
        int r13 = this.stackSize - 1;
        r12[r13] = r12[r13] + 1;
        return r11;
    L12:
        throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
    L14:
        if (r5 != 16) goto L17;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L33:
        this.peeked = 11;
        double r14 = Double.parseDouble(this.peekedString);
        int r15 = (int) r14;
        if (r15 != r14) goto L38;
        this.peekedString = null;
        this.peeked = 0;
        int[] r16 = this.pathIndices;
        int r17 = this.stackSize - 1;
        r16[r17] = r16[r17] + 1;
        return r15;
    L38:
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    L17:
        if (r5 != 8) goto L19;
    L24:
        if (r5 != 10) goto L26;
        this.peekedString = nextUnquotedValue();
    L30:
        validateAscii(this.peekedString);
        int r18 = Integer.parseInt(this.peekedString);     // Catch: NumberFormatException -> L39
        this.peeked = 0;     // Catch: NumberFormatException -> L39
        int[] r19 = this.pathIndices;     // Catch: NumberFormatException -> L39
        int r20 = this.stackSize - 1;     // Catch: NumberFormatException -> L39
        r19[r20] = r19[r20] + 1;     // Catch: NumberFormatException -> L39
        return r18;
    L26:
        if (r5 != 8) goto L28;
        char r21 = '\'';
    L29:
        this.peekedString = nextQuotedValue(r21);
        goto L30
    L28:
        r21 = Typography.quote;
        goto L29
    L19:
        if (r5 == 9) goto L24;
        if (r5 == 10) goto L24;
        throw unexpectedTokenError("an int");
    }

    public long nextLong() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 15) goto L10;
        this.peeked = 0;
        int[] r10 = this.pathIndices;
        int r11 = this.stackSize - 1;
        r10[r11] = r10[r11] + 1;
        return this.peekedLong;
    L10:
        if (r5 != 16) goto L13;
        this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
    L29:
        this.peeked = 11;
        double r12 = Double.parseDouble(this.peekedString);
        long r13 = (long) r12;
        if (r13 != r12) goto L34;
        this.peekedString = null;
        this.peeked = 0;
        int[] r14 = this.pathIndices;
        int r15 = this.stackSize - 1;
        r14[r15] = r14[r15] + 1;
        return r13;
    L34:
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    L13:
        if (r5 != 8) goto L15;
    L20:
        if (r5 != 10) goto L22;
        this.peekedString = nextUnquotedValue();
    L26:
        validateAscii(this.peekedString);
        long r16 = Long.parseLong(this.peekedString);     // Catch: NumberFormatException -> L35
        this.peeked = 0;     // Catch: NumberFormatException -> L35
        int[] r17 = this.pathIndices;     // Catch: NumberFormatException -> L35
        int r18 = this.stackSize - 1;     // Catch: NumberFormatException -> L35
        r17[r18] = r17[r18] + 1;     // Catch: NumberFormatException -> L35
        return r16;
    L22:
        if (r5 != 8) goto L24;
        char r19 = '\'';
    L25:
        this.peekedString = nextQuotedValue(r19);
        goto L26
    L24:
        r19 = Typography.quote;
        goto L25
    L15:
        if (r5 == 9) goto L20;
        if (r5 == 10) goto L20;
        throw unexpectedTokenError("a long");
    }

    public String nextName() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 14) goto L9;
        String r10 = nextUnquotedValue();
    L14:
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = r10;
        return r10;
    L9:
        if (r5 != 12) goto L12;
        r10 = nextQuotedValue('\'');
        goto L14
    L12:
        if (r5 != 13) goto L17;
        r10 = nextQuotedValue(Typography.quote);
        goto L14
    L17:
        throw unexpectedTokenError("a name");
    }

    public void nextNull() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 7) goto L10;
        this.peeked = 0;
        int[] r10 = this.pathIndices;
        int r11 = this.stackSize - 1;
        r10[r11] = r10[r11] + 1;
        return;
    L10:
        throw unexpectedTokenError("null");
    }

    public String nextString() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L6;
        r5 = doPeek();
    L6:
        if (r5 != 10) goto L9;
        String r10 = nextUnquotedValue();
    L23:
        this.peeked = 0;
        int[] r11 = this.pathIndices;
        int r12 = this.stackSize - 1;
        r11[r12] = r11[r12] + 1;
        return r10;
    L9:
        if (r5 != 8) goto L12;
        r10 = nextQuotedValue('\'');
        goto L23
    L12:
        if (r5 != 9) goto L15;
        r10 = nextQuotedValue(Typography.quote);
        goto L23
    L15:
        if (r5 != 11) goto L18;
        r10 = this.peekedString;
        this.peekedString = null;
        goto L23
    L18:
        if (r5 != 15) goto L21;
        r10 = Long.toString(this.peekedLong);
        goto L23
    L21:
        if (r5 != 16) goto L26;
        r10 = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
        goto L23
    L26:
        throw unexpectedTokenError("a string");
    }

    public JsonToken peek() throws IOException {
        int r5 = this.peeked;
        if (r5 != 0) goto L5;
        r5 = doPeek();
    L5:
        switch(r5) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L11;
            case 17: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return JsonToken.END_DOCUMENT;
    L11:
        return JsonToken.NUMBER;
    L13:
        return JsonToken.NAME;
    L15:
        return JsonToken.STRING;
    L17:
        return JsonToken.NULL;
    L19:
        return JsonToken.BOOLEAN;
    L21:
        return JsonToken.END_ARRAY;
    L23:
        return JsonToken.BEGIN_ARRAY;
    L25:
        return JsonToken.END_OBJECT;
    L27:
        return JsonToken.BEGIN_OBJECT;
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

    public final void setNestingLimit(int r5) {
        if (r5 < 0) goto L6;
        this.nestingLimit = r5;
        return;
    L6:
        throw new IllegalArgumentException(j0.g(r5, "Invalid nesting limit: "));
    }

    public final void setStrictness(Strictness r5) {
        Objects.requireNonNull(r5);
        this.strictness = r5;
    }

    public void skipValue() throws IOException {
        int r5 = 0;
    L3:
        int r10 = this.peeked;
        if (r10 != 0) goto L7;
        r10 = doPeek();
    L7:
        switch(r10) {
            case 1: goto L30;
            case 2: goto L27;
            case 3: goto L25;
            case 4: goto L23;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L31;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L31;
            case 12: goto L17;
            case 13: goto L14;
            case 14: goto L11;
            case 15: goto L31;
            case 16: goto L10;
            case 17: goto L9;
            default: goto L31;
        };
    L10:
        this.pos += this.peekedNumberLength;
        goto L31
    L11:
        skipUnquotedValue();
        if (r5 != 0) goto L31;
        this.pathNames[this.stackSize - 1] = "<skipped>";
        goto L31
    L14:
        skipQuotedValue(Typography.quote);
        if (r5 != 0) goto L31;
        this.pathNames[this.stackSize - 1] = "<skipped>";
        goto L31
    L17:
        skipQuotedValue('\'');
        if (r5 != 0) goto L31;
        this.pathNames[this.stackSize - 1] = "<skipped>";
        goto L31
    L20:
        skipUnquotedValue();
        goto L31
    L21:
        skipQuotedValue(Typography.quote);
        goto L31
    L22:
        skipQuotedValue('\'');
        goto L31
    L23:
        this.stackSize--;
    L24:
        r5 = r5 - 1;
        goto L31
    L25:
        push(1);
    L26:
        r5 = r5 + 1;
        goto L31
    L27:
        if (r5 != 0) goto L29;
        this.pathNames[this.stackSize - 1] = null;
    L29:
        this.stackSize--;
        goto L24
    L30:
        push(3);
    L31:
        this.peeked = 0;
        if (r5 > 0) goto L3;
        int[] r11 = this.pathIndices;
        int r12 = this.stackSize - 1;
        r11[r12] = r11[r12] + 1;
        return;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    public String getPath() {
        return getPath(false);
    }
}
