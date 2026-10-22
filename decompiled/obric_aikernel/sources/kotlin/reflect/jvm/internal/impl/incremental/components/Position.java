package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class Position implements Serializable {
    public static final Companion Companion = null;
    private static final Position NO_POSITION = null;
    private final int column;
    private final int line;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final Position getNO_POSITION() {
            return Position.access$getNO_POSITION$cp();
        }
    }

    static {
        Companion = new Companion(null);
        NO_POSITION = new Position(-1, -1);
    }

    public Position(int r10, int r11) {
        this.line = r10;
        this.column = r11;
    }

    public static final /* synthetic */ Position access$getNO_POSITION$cp() {
        return NO_POSITION;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Position) == true) goto L8;
        return false;
    L8:
        Position r11 = (Position) r10;
        if (this.line == r11.line) goto L12;
        return false;
    L12:
        if (this.column == r11.column) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + ')';
    }
}
