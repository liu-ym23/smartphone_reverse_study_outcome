package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r {
    public final String a;
    public final MmRecordingState b;
    public final MmRecordingState c;
    public final MmRecordingError d;
    public final boolean e;

    public r() {
        this(null, null, null, false, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L8;
        return false;
    L8:
        r r6 = (r) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        MmRecordingError r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.e == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingStateData(recordingId=" + this.a + ", currentState=" + this.b + ", lastState=" + this.c + ", error=" + this.d + ", isAllRecordingFinished=" + this.e + ')';
    }

    public r(String r2, MmRecordingState r3, MmRecordingState r4, boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = MmRecordingState.IDLE;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = MmRecordingState.IDLE;
    L12:
        if ((r6 & 16) == 0) goto L14;
        r5 = false;
    L14:
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r3, "currentState");
        Intrinsics.checkNotNullParameter(r4, "lastState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = null;
        this.e = r5;
    }
}
