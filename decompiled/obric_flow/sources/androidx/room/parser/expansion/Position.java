package androidx.room.parser.expansion;

import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/room/parser/expansion/Position;", "", SVGRenderEngine.LINE, "", "charInLine", "(II)V", "getCharInLine", "()I", "getLine", "compareTo", "other", "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Position implements Comparable<Position> {
    private final int charInLine;
    private final int line;

    public Position(int r5, int r10) {
        this.line = r5;
        this.charInLine = r10;
    }

    public static /* synthetic */ Position copy$default(Position r5, int r10, int r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.line;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.charInLine;
    L9:
        return r5.copy(r10, r11);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Position r5) {
        return compareTo2(r5);
    }

    public final int component1() {
        return this.line;
    }

    public final int component2() {
        return this.charInLine;
    }

    public final Position copy(int r5, int r10) {
        return new Position(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Position) == true) goto L8;
        return false;
    L8:
        Position r10 = (Position) r5;
        if (this.line == r10.line) goto L12;
        return false;
    L12:
        if (this.charInLine == r10.charInLine) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getCharInLine() {
        return this.charInLine;
    }

    public final int getLine() {
        return this.line;
    }

    public int hashCode() {
        int r5 = Integer.hashCode(this.line) * 31;
        return Integer.hashCode(this.charInLine) + r5;
    }

    public String toString() {
        return "Position(line=" + this.line + ", charInLine=" + this.charInLine + ")";
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Position r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        int r10 = this.line;
        int r11 = r5.line;
        if (r10 != r11) goto L6;
        return this.charInLine - r5.charInLine;
    L6:
        return r10 - r11;
    }
}
