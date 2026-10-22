package y82;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.livesdk.interactivity.medialink.ui.player.utils.LiveType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public final boolean a;
    public final boolean b;
    public final LiveType c;
    public final DeviceType d;
    public final DataCenter e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L16;
        f r4 = (f) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        LiveType r6 = this.c;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (r5 + r8) * 31;
        DeviceType r10 = this.d;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r13 = (r9 + r11) * 31;
        DataCenter r14 = this.e;
        if (r14 == null) goto L21;
        r7 = r14.hashCode();
    L21:
        return r13 + r7;
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    }

    public final String toString() {
        return "MediaLayoutCreatorParam(isAnchor=" + this.a + ", isPortrait=" + this.b + ", liveType=" + this.c + ", deviceType=" + this.d + ", dataCenter=" + this.e + ")";
    }

    public f(boolean r2, boolean r3, LiveType r4, DeviceType r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "liveType");
        Intrinsics.checkNotNullParameter(r5, "deviceType");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
