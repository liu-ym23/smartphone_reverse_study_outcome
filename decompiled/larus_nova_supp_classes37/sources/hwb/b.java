package hwb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final String a;
    public final gwb.d b;
    public final MmRecordingUILaunchMode c;
    public final gwb.a d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "MmRecordingFloatContentParams(recordingId=" + this.a + ", sessionProvider=" + this.b + ", uiLaunchMode=" + this.c + ", actionHandler=" + this.d + ')';
    }

    public b(String r2, gwb.d r3, MmRecordingUILaunchMode r4, gwb.a r5) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r3, "sessionProvider");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r5, "actionHandler");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
