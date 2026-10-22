package t3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r0 {
    public final String a;
    public final f3.a b;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof r0) == true) goto L8;
        return false;
    L8:
        r0 r11 = (r0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String toString() {
        return "DeviceSensorStartError(message=" + this.a + ", errNo=" + this.b + ')';
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.a;
    }

    public r0(String r10, f3.a r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Intrinsics.checkNotNullParameter(r11, "errNo");
        this.a = r10;
        this.b = r11;
    }
}
