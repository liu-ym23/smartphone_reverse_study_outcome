package zz;

import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateEvent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateIntent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final LiveRoomStateUpdateIntent a;
    public final LiveRoomStateUpdateEvent b;
    public final String c;
    public final String d;
    public final Map<String, Object> e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L16;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
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

    public final int hashCode() {
        LiveRoomStateUpdateIntent r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        LiveRoomStateUpdateEvent r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.d;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        Map<String, Object> r14 = this.e;
        if (r14 == null) goto L22;
        r1 = r14.hashCode();
    L22:
        return r13 + r1;
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveRoomStateUpdateRequest(intent=" + this.a + ", role=" + this.b + ", source=" + this.c + ", reason=" + this.d + ", params=" + this.e + ')';
    }

    public b(LiveRoomStateUpdateIntent r2, LiveRoomStateUpdateEvent r3, String r4, String r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        Intrinsics.checkNotNullParameter(r3, "role");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
