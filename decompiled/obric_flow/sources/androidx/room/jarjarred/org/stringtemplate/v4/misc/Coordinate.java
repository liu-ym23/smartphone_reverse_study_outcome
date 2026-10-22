package androidx.room.jarjarred.org.stringtemplate.v4.misc;

/* JADX INFO: loaded from: classes.dex */
public class Coordinate {
    public int charPosition;
    public int line;

    public Coordinate(int r5, int r10) {
        this.line = r5;
        this.charPosition = r10;
    }

    public String toString() {
        return this.line + ":" + this.charPosition;
    }
}
