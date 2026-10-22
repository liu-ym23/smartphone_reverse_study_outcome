package rub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final String a;
    public final int b;
    public final ToastType c;
    public final Integer d;
    public final MmRecordingUILaunchMode e;

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
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        Integer r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmToastConfig(content=" + this.a + ", duration=" + this.b + ", type=" + this.c + ", iconRes=" + this.d + ", uiLaunchMode=" + this.e + ')';
    }

    public final ToastType getType() {
        return this.c;
    }

    public static e a(e r6, MmRecordingUILaunchMode r7) {
        String r1 = r6.a;
        int r2 = r6.b;
        ToastType r3 = r6.c;
        Integer r4 = r6.d;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "content");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r7, "uiLaunchMode");
        return new e(r1, r2, r3, r4, r7);
    }

    public /* synthetic */ e(String r7, ToastType r8, MmRecordingUILaunchMode r9, int r10) {
        if ((r10 & 4) == 0) goto L5;
        r8 = ToastType.NORMAL;
    L5:
        ToastType r3 = r8;
        if ((r10 & 16) == 0) goto L8;
        r9 = MmRecordingUILaunchMode.UNKNOWN;
    L8:
        this(r7, 0, r3, null, r9);
    }

    public e(String r2, int r3, ToastType r4, Integer r5, MmRecordingUILaunchMode r6) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r6, "uiLaunchMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
