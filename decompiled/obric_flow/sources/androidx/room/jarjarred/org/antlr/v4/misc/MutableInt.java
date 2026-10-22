package androidx.room.jarjarred.org.antlr.v4.misc;

/* JADX INFO: loaded from: classes.dex */
public class MutableInt extends Number implements Comparable<Number> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f645v;

    public MutableInt(int r5) {
        this.f645v = r5;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Number r5) {
        return compareTo2(r5);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.f645v;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Number) == true) goto L5;
        return false;
    L5:
        if (this.f645v != ((Number) r5).intValue()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.f645v;
    }

    public int hashCode() {
        return this.f645v;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.f645v;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.f645v;
    }

    public String toString() {
        return String.valueOf(this.f645v);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Number r5) {
        return this.f645v - r5.intValue();
    }
}
