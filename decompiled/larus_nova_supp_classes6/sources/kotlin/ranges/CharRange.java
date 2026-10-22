package kotlin.ranges;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u001aB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001a\u0010\b\u001a\u00020\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/OpenEndRange;", "start", "endInclusive", "(CC)V", "endExclusive", "getEndExclusive$annotations", "()V", "getEndExclusive", "()Ljava/lang/Character;", "getEndInclusive", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CharRange extends CharProgression implements ClosedRange<Character>, OpenEndRange<Character> {
    public static final Companion Companion = null;
    private static final CharRange EMPTY = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/ranges/CharRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/CharRange;", "getEMPTY", "()Lkotlin/ranges/CharRange;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final CharRange getEMPTY() {
            return CharRange.access$getEMPTY$cp();
        }
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with Char type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    public static /* synthetic */ void getEndExclusive$annotations() {
    }

    static {
        Companion = new Companion(null);
        EMPTY = new CharRange(1, 0);
    }

    @Override // kotlin.ranges.CharProgression
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public Character getEndExclusive() {
        if (getLast() == 65535) goto L7;
        return Character.valueOf((char) (getLast() + 1));
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    public Character getEndInclusive() {
        return Character.valueOf(getLast());
    }

    public Character getStart() {
        return Character.valueOf(getFirst());
    }

    @Override // kotlin.ranges.CharProgression
    public int hashCode() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.CharProgression
    public boolean isEmpty() {
        if (Intrinsics.compare(getFirst(), getLast()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ CharRange access$getEMPTY$cp() {
        return EMPTY;
    }

    /* JADX INFO: renamed from: getEndExclusive, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Comparable m740getEndExclusive() {
        return getEndExclusive();
    }

    /* JADX INFO: renamed from: getEndInclusive, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Comparable m741getEndInclusive() {
        return getEndInclusive();
    }

    /* JADX INFO: renamed from: getStart, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Comparable m742getStart() {
        return getStart();
    }

    public boolean contains(char r2) {
        if (Intrinsics.compare(getFirst(), r2) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.compare(r2, getLast()) > 0) goto L7;
        return true;
    }

    @Override // kotlin.ranges.CharProgression
    public boolean equals(Object r3) {
        if ((r3 instanceof CharRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        CharRange r4 = (CharRange) r3;
        if (getFirst() != r4.getFirst()) goto L13;
        if (getLast() != r4.getLast()) goto L13;
    L12:
        return true;
    L7:
        if (((CharRange) r3).isEmpty() == true) goto L12;
        goto L8
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable r1) {
        return contains(((Character) r1).charValue());
    }

    public CharRange(char r2, char r3) {
        super(r2, r3, 1);
    }
}
