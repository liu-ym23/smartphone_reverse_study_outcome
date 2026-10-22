package z82;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.e5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final c a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        c r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "pkProgressBarOption = " + this.a;
    }

    public static int a() {
        if (e5.n() == false) goto L6;
        return 0;
    L6:
        return UtilityKotlinExtentionsKt.i(16);
    }

    public a(c r1) {
        this.a = r1;
    }
}
