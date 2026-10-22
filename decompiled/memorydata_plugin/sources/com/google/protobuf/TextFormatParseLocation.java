package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = null;
    private final int column;
    private final int line;

    static {
        EMPTY = new TextFormatParseLocation(-1, -1);
    }

    private TextFormatParseLocation(int r1, int r2) {
        this.line = r1;
        this.column = r2;
    }

    static TextFormatParseLocation create(int r3, int r4) {
        if (r3 != (-1)) goto L7;
        if (r4 != (-1)) goto L7;
        return EMPTY;
    L7:
        if (r3 < 0) goto L12;
        if (r4 < 0) goto L12;
        return new TextFormatParseLocation(r3, r4);
    L12:
        throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", new Object[]{Integer.valueOf(r3), Integer.valueOf(r4)}));
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TextFormatParseLocation.class) == true) goto L8;
        return false;
    L8:
        TextFormatParseLocation r6 = (TextFormatParseLocation) ZeusTransformUtils.preCheckCast(r5, TextFormatParseLocation.class, "com.obric.memorydata.plugin");
        if (this.line != r6.getLine()) goto L14;
        if (this.column != r6.getColumn()) goto L14;
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
