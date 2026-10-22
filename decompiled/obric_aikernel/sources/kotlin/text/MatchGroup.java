package kotlin.text;

import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final class MatchGroup {
    private final IntRange range;
    private final String value;

    public MatchGroup(String r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r11, "range");
        this.value = r10;
        this.range = r11;
    }

    public static /* synthetic */ MatchGroup copy$default(MatchGroup r10, String r11, IntRange r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.value;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.range;
    L9:
        return r10.copy(r11, r12);
    }

    public final String component1() {
        return this.value;
    }

    public final IntRange component2() {
        return this.range;
    }

    public final MatchGroup copy(String r10, IntRange r11) {
        Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r11, "range");
        return new MatchGroup(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MatchGroup) == true) goto L8;
        return false;
    L8:
        MatchGroup r11 = (MatchGroup) r10;
        if (Intrinsics.areEqual(this.value, r11.value) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.range, r11.range) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final IntRange getRange() {
        return this.range;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.range.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.range + ')';
    }
}
