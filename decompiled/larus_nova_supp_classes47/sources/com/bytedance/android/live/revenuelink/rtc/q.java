package com.bytedance.android.live.revenuelink.rtc;

import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdk.link.model.bridge.t1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final s1 d;

    public q() {
        this(null, 15);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof q) == false) goto L14;
        q r4 = (q) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        if (r7 == true) goto L12;
        r1 = r7;
    L12:
        int r8 = (r6 + r1) * 31;
        s1 r9 = this.d;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L17:
        return r8 + r10;
    L15:
        r10 = 0;
        goto L17
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("StartEngineParams{needPushStream=");
        r0.append(this.a);
        r0.append(", enableAllRemoteRender=");
        r0.append(this.b);
        r0.append(", startForwardStream=");
        r0.append(this.c);
        r0.append(", ");
        s1 r1 = this.d;
        if (r1 == null) goto L5;
        String r2 = t1.a(r1);
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    public /* synthetic */ q(b7 r6, int r7) {
        boolean r1 = false;
        if ((r7 & 1) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r7 & 2) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r7 & 4) == 0) goto L14;
        r1 = true;
    L14:
        if ((r7 & 8) == 0) goto L16;
        r6 = null;
    L16:
        this(r0, r3, r1, r6);
        return;
    L9:
        r3 = false;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public q(boolean r1, boolean r2, boolean r3, s1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
