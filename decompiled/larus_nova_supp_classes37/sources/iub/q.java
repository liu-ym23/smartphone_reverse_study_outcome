package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class q {
    public final String a;
    public final String b;
    public final MmRecordingState c;
    public final MmRecordingState d;
    public final MmRecordingSource e;
    public final boolean f;
    public final boolean g;
    public final MmRecordingError h;
    public final boolean i;

    public q() {
        MmRecordingSource r2 = null;
        this(r2, false, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        MmRecordingSource r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.f == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.g == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        MmRecordingError r10 = this.h;
        if (r10 == null) goto L18;
        r2 = r10.hashCode();
    L18:
        int r11 = (r9 + r2) * 31;
        if (this.i == true) goto L23;
        r5 = 1237;
    L23:
        return r11 + r5;
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingSessionInfo(recordingId=" + this.a + ", minutesToken=" + this.b + ", currentState=" + this.c + ", lastState=" + this.d + ", source=" + this.e + ", isRealtimeRecording=" + this.f + ", isActive=" + this.g + ", error=" + this.h + ", isAllRecordingFinished=" + this.i + ')';
    }

    public /* synthetic */ q(MmRecordingSource r14, boolean r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r16 & 4) == 0) goto L13;
        MmRecordingState r6 = MmRecordingState.IDLE;
    L15:
        if ((r16 & 8) == 0) goto L17;
        MmRecordingState r7 = MmRecordingState.IDLE;
    L19:
        if ((r16 & 16) == 0) goto L21;
        MmRecordingSource r8 = null;
    L23:
        if ((r16 & 32) == 0) goto L25;
        boolean r9 = false;
    L26:
        this(r4, r5, r6, r7, r8, r9, false, null, false);
        return;
    L25:
        r9 = r15;
        goto L26
    L21:
        r8 = r14;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r4 = null;
        goto L7
    }

    public q(String r2, String r3, MmRecordingState r4, MmRecordingState r5, MmRecordingSource r6, boolean r7, boolean r8, MmRecordingError r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r3, "minutesToken");
        Intrinsics.checkNotNullParameter(r4, "currentState");
        Intrinsics.checkNotNullParameter(r5, "lastState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
