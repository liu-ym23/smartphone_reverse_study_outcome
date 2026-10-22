package com.google.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = null;
    private final int column;
    private final int line;

    static {
        EMPTY = new TextFormatParseLocation(-1, -1);
    }

    private TextFormatParseLocation(int r8, int r10) {
        this.line = r8;
        this.column = r10;
    }

    public static TextFormatParseLocation create(int r8, int r10) {
        if (r8 != (-1)) goto L7;
        if (r10 != (-1)) goto L7;
        return EMPTY;
    L7:
        if (r8 < 0) goto L12;
        if (r10 < 0) goto L12;
        return new TextFormatParseLocation(r8, r10);
    L12:
        throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", new Object[]{Integer.valueOf(r8), Integer.valueOf(r10)}));
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof TextFormatParseLocation) == true) goto L8;
        return false;
    L8:
        TextFormatParseLocation r10 = (TextFormatParseLocation) r8;
        if (this.line != r10.getLine()) goto L14;
        if (this.column != r10.getColumn()) goto L14;
        return true;
    L14:
        return false;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }

    public String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", new Object[]{Integer.valueOf(this.line), Integer.valueOf(this.column)});
    }
}
