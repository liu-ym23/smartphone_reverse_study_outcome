package dwb;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingTopSlotMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final MmRecordingTopSlotMode a;
    public final Integer b;

    public d() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Integer r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRecordingSlotsLayoutPolicy(topMode=" + this.a + ", contentTopInsetPx=" + this.b + ')';
    }

    public d(int r2) {
        MmRecordingTopSlotMode r3 = MmRecordingTopSlotMode.OCCUPY;
        Intrinsics.checkNotNullParameter(r3, "topMode");
        this.a = r3;
        this.b = null;
    }
}
