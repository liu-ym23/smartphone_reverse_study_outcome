package hwb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.jvm.internal.Intrinsics;
import qub.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final String a;
    public final gwb.b b;
    public final gwb.f c;
    public final d d;
    public final gwb.c e;
    public final gwb.d f;
    public final MmRecordingUILaunchMode g;
    public final g h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        g r1 = this.h;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmRecordingFloatHostConfig(recordingId=" + this.a + ", contentFactory=" + this.b + ", styleProvider=" + this.c + ", initialLayoutState=" + this.d + ", callbacks=" + this.e + ", sessionProvider=" + this.f + ", uiLaunchMode=" + this.g + ", uiModeBridge=" + this.h + ')';
    }

    public c(String r2, com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style.a r3, com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style.b r4, d r5, com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a.b r6, gwb.d r7, MmRecordingUILaunchMode r8, g r9) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r3, "contentFactory");
        Intrinsics.checkNotNullParameter(r4, "styleProvider");
        Intrinsics.checkNotNullParameter(r5, "initialLayoutState");
        Intrinsics.checkNotNullParameter(r6, "callbacks");
        Intrinsics.checkNotNullParameter(r7, "sessionProvider");
        Intrinsics.checkNotNullParameter(r8, "uiLaunchMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
