package b30;

import com.bytedance.android.livesdk.message.model.p4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 {
    public final p4 a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof d0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((d0) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        p4 r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ShowFollowGuideEvent(message=" + this.a + ")";
    }

    public d0(p4 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.a = r2;
    }
}
