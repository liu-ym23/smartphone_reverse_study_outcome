package androidx.room.jarjarred.org.antlr.v4.runtime.misc;

/* JADX INFO: loaded from: classes.dex */
public class Interval {
    public static final int INTERVAL_POOL_MAX_VALUE = 1000;
    public static final Interval INVALID = null;
    static Interval[] cache;
    public static int creates;
    public static int hits;
    public static int misses;
    public static int outOfRange;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f666b;

    static {
        INVALID = new Interval(-1, -2);
        cache = new Interval[1001];
        creates = 0;
        misses = 0;
        hits = 0;
        outOfRange = 0;
    }

    public Interval(int r5, int r10) {
        this.f665a = r5;
        this.f666b = r10;
    }

    public static Interval of(int r5, int r10) {
        if (r5 != r10) goto L13;
        if (r5 < 0) goto L13;
        if (r5 > 1000) goto L13;
        Interval[] r11 = cache;
        if (r11[r5] != null) goto L11;
        r11[r5] = new Interval(r5, r5);
    L11:
        return cache[r5];
    L13:
        return new Interval(r5, r10);
    }

    public boolean adjacent(Interval r5) {
        if (this.f665a != (r5.f666b + 1)) goto L5;
        return true;
    L5:
        if (this.f666b == (r5.f665a - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    public Interval differenceNotProperlyContained(Interval r5) {
        if (r5.startsBeforeNonDisjoint(this) == false) goto L6;
        return of(Math.max(this.f665a, r5.f666b + 1), this.f666b);
    L6:
        if (r5.startsAfterNonDisjoint(this) == true) goto L11;
        return null;
    L11:
        return of(this.f665a, r5.f665a - 1);
    }

    public boolean disjoint(Interval r5) {
        if (startsBeforeDisjoint(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (startsAfterDisjoint(r5) == true) goto L8;
        return false;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if ((r5 instanceof Interval) == false) goto L16;
        Interval r10 = (Interval) r5;
        if (this.f665a == r10.f665a) goto L10;
        return false;
    L10:
        if (this.f666b != r10.f666b) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        return ((713 + this.f665a) * 31) + this.f666b;
    }

    public Interval intersection(Interval r5) {
        return of(Math.max(this.f665a, r5.f665a), Math.min(this.f666b, r5.f666b));
    }

    public int length() {
        int r5 = this.f666b;
        int r10 = this.f665a;
        if (r5 >= r10) goto L7;
        return 0;
    L7:
        return (r5 - r10) + 1;
    }

    public boolean properlyContains(Interval r5) {
        if (r5.f665a >= this.f665a) goto L5;
    L7:
        return false;
    L5:
        if (r5.f666b > this.f666b) goto L7;
        return true;
    }

    public boolean startsAfter(Interval r5) {
        if (this.f665a <= r5.f665a) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean startsAfterDisjoint(Interval r5) {
        if (this.f665a <= r5.f666b) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean startsAfterNonDisjoint(Interval r5) {
        int r10 = this.f665a;
        if (r10 > r5.f665a) goto L5;
    L7:
        return false;
    L5:
        if (r10 > r5.f666b) goto L7;
        return true;
    }

    public boolean startsBeforeDisjoint(Interval r5) {
        int r10 = this.f665a;
        int r11 = r5.f665a;
        if (r10 < r11) goto L5;
    L7:
        return false;
    L5:
        if (this.f666b >= r11) goto L7;
        return true;
    }

    public boolean startsBeforeNonDisjoint(Interval r5) {
        int r10 = this.f665a;
        int r11 = r5.f665a;
        if (r10 <= r11) goto L5;
    L7:
        return false;
    L5:
        if (this.f666b < r11) goto L7;
        return true;
    }

    public String toString() {
        return this.f665a + ".." + this.f666b;
    }

    public Interval union(Interval r5) {
        return of(Math.min(this.f665a, r5.f665a), Math.max(this.f666b, r5.f666b));
    }
}
