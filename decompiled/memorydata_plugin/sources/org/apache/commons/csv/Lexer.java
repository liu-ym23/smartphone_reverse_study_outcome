package org.apache.commons.csv;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
final class Lexer implements Closeable {
    private static final String CR_STRING = null;
    private static final String LF_STRING = null;
    private final char commentStart;
    private final char delimiter;
    private final char escape;
    private String firstEol;
    private final boolean ignoreEmptyLines;
    private final boolean ignoreSurroundingSpaces;
    private final char quoteChar;
    private final ExtendedBufferedReader reader;

    static {
        CR_STRING = Character.toString('\r');
        LF_STRING = Character.toString('\n');
    }

    Lexer(CSVFormat r1, ExtendedBufferedReader r2) {
        this.reader = r2;
        this.delimiter = r1.getDelimiter();
        this.escape = mapNullToDisabled(r1.getEscapeCharacter());
        this.quoteChar = mapNullToDisabled(r1.getQuoteCharacter());
        this.commentStart = mapNullToDisabled(r1.getCommentMarker());
        this.ignoreSurroundingSpaces = r1.getIgnoreSurroundingSpaces();
        this.ignoreEmptyLines = r1.getIgnoreEmptyLines();
    }

    private boolean isMetaChar(int r2) {
        if (r2 != this.delimiter) goto L5;
    L12:
        return true;
    L5:
        if (r2 == this.escape) goto L12;
        if (r2 == this.quoteChar) goto L12;
        if (r2 == this.commentStart) goto L12;
        return false;
    }

    private char mapNullToDisabled(Character r1) {
        if (r1 != null) goto L5;
        return 65534;
    L5:
        return r1.charValue();
    }

    private Token parseEncapsulatedToken(Token r6) {
        long r0 = getCurrentLineNumber();
    L3:
        int r2 = this.reader.read();
        if (isEscape(r2) == true) goto L5;
        if (isQuoteChar(r2) == false) goto L33;
        if (isQuoteChar(this.reader.lookAhead()) == false) goto L15;
        r2 = this.reader.read();
    L34:
        r6.content.append((char) r2);
    L15:
        int r1 = this.reader.read();
        if (isDelimiter(r1) == true) goto L17;
        if (isEndOfFile(r1) == true) goto L21;
        if (readEndOfLine(r1) == true) goto L25;
        if (isWhitespace(r1) == true) goto L15;
        throw new IOException("(line " + getCurrentLineNumber() + ") invalid char between encapsulated token and delimiter");
    L25:
        r6.type = Token.Type.EORECORD;
        return r6;
    L21:
        r6.type = Token.Type.EOF;
        r6.isReady = true;
        return r6;
    L17:
        r6.type = Token.Type.TOKEN;
        return r6;
    L33:
        if (isEndOfFile(r2) == false) goto L34;
        throw new IOException("(startline " + r0 + ") EOF reached before encapsulated token finished");
    L5:
        int r3 = readEscape();
        if (r3 != (-1)) goto L8;
        StringBuilder r4 = r6.content.append((char) r2);
        r3 = this.reader.getLastChar();
    L9:
        r4.append((char) r3);
        goto L3
    L8:
        r4 = r6.content;
        goto L9
    }

    private Token parseSimpleToken(Token r3, int r4) {
    L3:
        if (readEndOfLine(r4) == true) goto L4;
        if (isEndOfFile(r4) == true) goto L8;
        if (isDelimiter(r4) == true) goto L11;
        if (isEscape(r4) == false) goto L23;
        int r0 = readEscape();
        if (r0 != (-1)) goto L21;
        StringBuilder r5 = r3.content.append((char) r4);
        r0 = this.reader.getLastChar();
    L22:
        r5.append((char) r0);
    L24:
        r4 = this.reader.read();
        goto L3
    L21:
        r5 = r3.content;
        goto L22
    L23:
        r3.content.append((char) r4);
        goto L24
    L11:
        Token.Type r6 = Token.Type.TOKEN;
    L5:
        r3.type = r6;
    L13:
        if (this.ignoreSurroundingSpaces == false) goto L15;
        trimTrailingSpaces(r3.content);
    L15:
        return r3;
    L8:
        r3.type = Token.Type.EOF;
        r3.isReady = true;
        goto L13
    L4:
        r6 = Token.Type.EORECORD;
        goto L5
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.reader.close();
    }

    long getCharacterPosition() {
        return this.reader.getPosition();
    }

    long getCurrentLineNumber() {
        return this.reader.getCurrentLineNumber();
    }

    boolean isClosed() {
        return this.reader.isClosed();
    }

    boolean isCommentStart(int r1) {
        if (r1 != this.commentStart) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isDelimiter(int r1) {
        if (r1 != this.delimiter) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isEndOfFile(int r1) {
        if (r1 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isEscape(int r1) {
        if (r1 != this.escape) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isQuoteChar(int r1) {
        if (r1 != this.quoteChar) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isStartOfLine(int r1) {
        if (r1 != 10) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 13) goto L10;
        if (r1 == (-2)) goto L10;
        return false;
    }

    boolean isWhitespace(int r1) {
        if (isDelimiter(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (Character.isWhitespace((char) r1) == false) goto L7;
        return true;
    }

    Token nextToken(Token r6) {
        int r0 = this.reader.getLastChar();
        int r1 = this.reader.read();
        boolean r2 = readEndOfLine(r1);
        if (this.ignoreEmptyLines == false) goto L14;
    L4:
        if (r2 == false) goto L14;
        if (isStartOfLine(r0) == false) goto L14;
        int r3 = this.reader.read();
        r2 = readEndOfLine(r3);
        if (isEndOfFile(r3) == true) goto L9;
        int r4 = r1;
        r1 = r3;
        r0 = r4;
    L9:
        Token.Type r5 = Token.Type.EOF;
    L10:
        r6.type = r5;
        return r6;
    L14:
        if (isEndOfFile(r0) == true) goto L9;
        if (isDelimiter(r0) == true) goto L21;
        if (isEndOfFile(r1) == true) goto L9;
    L21:
        if (isStartOfLine(r0) == false) goto L29;
        if (isCommentStart(r1) == false) goto L29;
        String r7 = this.reader.readLine();
        if (r7 == null) goto L9;
        String r8 = r7.trim();
        r6.content.append(r8);
        r5 = Token.Type.COMMENT;
    L29:
        if (r6.type != Token.Type.INVALID) goto L49;
        if (this.ignoreSurroundingSpaces == false) goto L37;
    L33:
        if (isWhitespace(r1) == false) goto L37;
        if (r2 == true) goto L37;
        r1 = this.reader.read();
        r2 = readEndOfLine(r1);
    L37:
        if (isDelimiter(r1) == true) goto L38;
        if (r2 == true) goto L41;
        if (isQuoteChar(r1) == true) goto L44;
        if (isEndOfFile(r1) == true) goto L47;
        parseSimpleToken(r6, r1);
        goto L29
    L47:
        r6.type = Token.Type.EOF;
        r6.isReady = true;
        goto L29
    L44:
        parseEncapsulatedToken(r6);
        goto L29
    L41:
        Token.Type r9 = Token.Type.EORECORD;
    L39:
        r6.type = r9;
        goto L29
    L38:
        r9 = Token.Type.TOKEN;
        goto L39
    L49:
        return r6;
    }

    boolean readEndOfLine(int r4) {
        if (r4 != 13) goto L10;
        if (this.reader.lookAhead() != 10) goto L10;
        r4 = this.reader.read();
        if (this.firstEol != null) goto L10;
        this.firstEol = "\r\n";
    L10:
        if (this.firstEol != null) goto L16;
        if (r4 != 10) goto L14;
        String r2 = LF_STRING;
    L13:
        this.firstEol = r2;
        goto L16
    L14:
        if (r4 != 13) goto L16;
        r2 = CR_STRING;
    L16:
        if (r4 == 10) goto L20;
        if (r4 == 13) goto L20;
        return false;
    L20:
        return true;
    }

    int readEscape() {
        int r0 = this.reader.read();
        if (r0 == (-1)) goto L31;
        if (r0 != 98) goto L7;
        return 8;
    L7:
        if (r0 != 102) goto L9;
        return 12;
    L9:
        if (r0 != 110) goto L11;
        return 10;
    L11:
        if (r0 != 114) goto L13;
        return 13;
    L13:
        if (r0 == 116) goto L22;
        if (r0 == 12) goto L21;
        if (r0 == 13) goto L21;
        switch(r0) {
            case 8: goto L21;
            case 9: goto L21;
            case 10: goto L21;
            default: goto L18;
        };
    L18:
        if (isMetaChar(r0) == false) goto L20;
        return r0;
    L20:
        return -1;
    L21:
        return r0;
    L22:
        return 9;
    L31:
        throw new IOException("EOF whilst processing escape sequence");
    }

    void trimTrailingSpaces(StringBuilder r3) {
        int r2 = r3.length();
    L3:
        if (r2 <= 0) goto L8;
        int r0 = r2 - 1;
        if (Character.isWhitespace(r3.charAt(r0)) == false) goto L8;
        r2 = r0;
    L8:
        if (r2 == r3.length()) goto L13;
        r3.setLength(r2);
        return;
    }
}
