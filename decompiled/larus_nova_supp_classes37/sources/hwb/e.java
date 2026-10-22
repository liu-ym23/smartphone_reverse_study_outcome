package hwb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatHostType;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatLifecycleState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final MmRecordingFloatHostType c;
    public final MmRecordingFloatLifecycleState d;
    public final d e;
    public final MmRecordingUILaunchMode f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingFloatSessionState(recordingId=" + this.a + ", visible=" + this.b + ", hostType=" + this.c + ", lifecycleState=" + this.d + ", layoutState=" + this.e + ", uiLaunchMode=" + this.f + ')';
    }

    public static e a(e r9, boolean r10, MmRecordingFloatLifecycleState r11, d r12, int r13) {
        MmRecordingUILaunchMode r1 = null;
        if ((r13 & 1) == 0) goto L5;
        String r3 = r9.a;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r10 = r9.b;
    L9:
        boolean r4 = r10;
        if ((r13 & 4) == 0) goto L12;
        MmRecordingFloatHostType r5 = r9.c;
    L14:
        if ((r13 & 8) == 0) goto L16;
        r11 = r9.d;
    L16:
        MmRecordingFloatLifecycleState r6 = r11;
        if ((r13 & 16) == 0) goto L19;
        r12 = r9.e;
    L19:
        d r7 = r12;
        if ((r13 & 32) == 0) goto L22;
        r1 = r9.f;
    L22:
        MmRecordingUILaunchMode r8 = r1;
        Intrinsics.checkNotNullParameter(r3, "recordingId");
        Intrinsics.checkNotNullParameter(r5, "hostType");
        Intrinsics.checkNotNullParameter(r6, "lifecycleState");
        Intrinsics.checkNotNullParameter(r7, "layoutState");
        Intrinsics.checkNotNullParameter(r8, "uiLaunchMode");
        return new e(r3, r4, r5, r6, r7, r8);
    L12:
        r5 = null;
        goto L14
    L5:
        r3 = null;
        goto L7
    }

    public e(String r2, boolean r3, MmRecordingFloatHostType r4, MmRecordingFloatLifecycleState r5, d r6, MmRecordingUILaunchMode r7) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r4, "hostType");
        Intrinsics.checkNotNullParameter(r5, "lifecycleState");
        Intrinsics.checkNotNullParameter(r6, "layoutState");
        Intrinsics.checkNotNullParameter(r7, "uiLaunchMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
