package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.a9;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u {
    public final String a;
    public final long b;
    public final int c;
    public final int d;
    public final a9 e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof u) == false) goto L16;
        u r7 = (u) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((((((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31;
        a9 r5 = this.e;
        if (r5 == null) goto L10;
        r1 = r5.hashCode();
    L10:
        return r4 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("PKInfo{guestUserID=");
        r0.append(this.a);
        r0.append(", channelId=");
        r0.append(this.b);
        r0.append(", dimension=");
        r0.append(this.c);
        r0.append(", layout=");
        r0.append(this.d);
        r0.append(", battleSetting=");
        ILinkMicBattleSetting r1 = this.e.getBattleSetting();
        if (r1 == null) goto L5;
        String r2 = ef2.a.c(r1);
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public u(String r2, long r3, int r5, int r6, a9 r7) {
        Intrinsics.checkNotNullParameter(r7, "roomLinkInfo");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }
}
