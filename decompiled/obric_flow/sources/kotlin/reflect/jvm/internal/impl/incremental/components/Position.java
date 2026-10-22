package kotlin.reflect.jvm.internal.impl.incremental.components;

import ai.j0;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class Position implements Serializable {
    public static final Companion Companion = null;
    private static final Position NO_POSITION = null;
    private final int column;
    private final int line;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final Position getNO_POSITION() {
            return Position.access$getNO_POSITION$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        NO_POSITION = new Position(-1, -1);
    }

    public Position(int r5, int r10) {
        this.line = r5;
        this.column = r10;
    }

    public static final /* synthetic */ Position access$getNO_POSITION$cp() {
        return NO_POSITION;
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
        if (this.column == r10.column) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r5 = Integer.hashCode(this.line) * 31;
        return Integer.hashCode(this.column) + r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("Position(line=");
        r5.append(this.line);
        r5.append(", column=");
        return j0.n(r5, this.column, ')');
    }
}
