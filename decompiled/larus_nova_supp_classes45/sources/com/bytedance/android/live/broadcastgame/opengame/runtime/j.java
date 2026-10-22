package com.bytedance.android.live.broadcastgame.opengame.runtime;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public final List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> a;
    public final List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> b;
    public final boolean c;
    public final boolean d;
    public final List<Integer> e;
    public final String f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L18;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r11 = (r6 + r9) * 31;
        boolean r12 = this.d;
        if (r12 == true) goto L17;
        r8 = r12;
    L17:
        int r13 = (r11 + r8) * 31;
        List<Integer> r14 = this.e;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f;
        if (r17 == null) goto L25;
        r1 = r17.hashCode();
    L25:
        return r16 + r1;
    L20:
        r15 = 0;
        goto L21
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GameScopeInfo(info=" + this.a + ", domainList=" + this.b + ", disableInteractIm=" + this.c + ", blockConsumeList=" + this.d + ", supportLiveSceneList=" + this.e + ", gameType=" + this.f + ")";
    }

    public j(List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r2, List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r3, boolean r4, boolean r5, List<Integer> r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "domainList");
        Intrinsics.checkNotNullParameter(r7, "gameType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
