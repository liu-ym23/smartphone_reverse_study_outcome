package so8;

import com.larus.bmhome.chat.zoom.ZoomInAnimationState;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final ZoomInAnimationState a;
    public final long b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "ZoomAnimationInfo(currentState=" + this.a + ", currentStateTimeStamp=" + this.b + ')';
    }

    public /* synthetic */ b(int r3) {
        this(ZoomInAnimationState.IDLE, AppHost.a.getAppClock().currentTimeMillis());
    }

    public b(ZoomInAnimationState r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
        this.a = r2;
        this.b = r3;
    }
}
