package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class Pair<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f668b;

    public Pair(A r5, B r10) {
        this.f667a = r5;
        this.f668b = r10;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Pair) == true) goto L8;
        return false;
    L8:
        Pair r11 = (Pair) r10;
        ObjectEqualityComparator r5 = ObjectEqualityComparator.INSTANCE;
        if (r5.equals(this.f667a, r11.f667a) == false) goto L14;
        if (r5.equals(this.f668b, r11.f668b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), this.f667a), this.f668b), 2);
    }

    public String toString() {
        return String.format("(%s, %s)", new Object[]{this.f667a, this.f668b});
    }
}
