package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CharRange extends CharProgression implements ClosedRange<Character>, OpenEndRange<Character> {
    public static final Companion Companion = null;
    private static final CharRange EMPTY = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final CharRange getEMPTY() {
            return CharRange.access$getEMPTY$cp();
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new CharRange(1, 0);
    }

    public CharRange(char r10, char r11) {
        super(r10, r11, 1);
    }

    public static final /* synthetic */ CharRange access$getEMPTY$cp() {
        return EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Char type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void getEndExclusive$annotations() {
    }

    public boolean contains(char r10) {
        if (Intrinsics.compare(getFirst(), r10) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.compare(r10, getLast()) > 0) goto L7;
        return true;
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return contains(((Character) r10).charValue());
    }

    @Override // kotlin.ranges.CharProgression
    public boolean equals(Object r10) {
        if ((r10 instanceof CharRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        CharRange r11 = (CharRange) r10;
        if (getFirst() != r11.getFirst()) goto L13;
        if (getLast() != r11.getLast()) goto L13;
    L12:
        return true;
    L7:
        if (((CharRange) r10).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.OpenEndRange
    public Character getEndExclusive() {
        if (getLast() == 65535) goto L7;
        return Character.valueOf((char) (getLast() + 1));
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return getEndExclusive();
    }

    @Override // kotlin.ranges.ClosedRange
    public Character getEndInclusive() {
        return Character.valueOf(getLast());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return getEndInclusive();
    }

    @Override // kotlin.ranges.ClosedRange
    public Character getStart() {
        return Character.valueOf(getFirst());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return getStart();
    }

    @Override // kotlin.ranges.CharProgression
    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = getFirst() * 31;
        return getLast() + r10;
    }

    @Override // kotlin.ranges.CharProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (Intrinsics.compare(getFirst(), getLast()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.CharProgression
    public String toString() {
        return getFirst() + ".." + getLast();
    }
}
