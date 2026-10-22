package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

/* JADX INFO: loaded from: classes.dex */
public class Triple<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f671c;

    public Triple(A r5, B r10, C r11) {
        this.f669a = r5;
        this.f670b = r10;
        this.f671c = r11;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Triple) == true) goto L8;
        return false;
    L8:
        Triple r11 = (Triple) r10;
        ObjectEqualityComparator r5 = ObjectEqualityComparator.INSTANCE;
        if (r5.equals(this.f669a, r11.f669a) == false) goto L16;
        if (r5.equals(this.f670b, r11.f670b) == false) goto L16;
        if (r5.equals(this.f671c, r11.f671c) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return MurmurHash.finish(MurmurHash.update(MurmurHash.update(MurmurHash.update(MurmurHash.initialize(), this.f669a), this.f670b), this.f671c), 3);
    }

    public String toString() {
        return String.format("(%s, %s, %s)", new Object[]{this.f669a, this.f670b, this.f671c});
    }
}
