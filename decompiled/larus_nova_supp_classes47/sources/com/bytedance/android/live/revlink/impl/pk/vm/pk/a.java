package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final IBattleConfigSetting a;
    public final long b;
    public final boolean c;
    public final long d;
    public final v3 e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L16;
        a r7 = (a) r6;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        IBattleConfigSetting r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        boolean r5 = this.c;
        ?? r6 = r5;
        if (r5 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r4 + r6) * 31;
        long r8 = this.d;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        v3 r10 = this.e;
        if (r10 == null) goto L13;
        r1 = r10.hashCode();
    L13:
        return r9 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleInviteParam(battleConfigSetting=" + this.a + ", duration=" + this.b + ", isOnceMore=" + this.c + ", decideDuration=" + this.d + ", clientAttachedInfo=" + this.e + ")";
    }

    public a(IBattleConfigSetting r4, v3 r5) {
        long r0 = l51.a.j();
        Intrinsics.checkNotNullParameter(r4, "battleConfigSetting");
        this.a = r4;
        this.b = r0;
        this.c = false;
        this.d = 0;
        this.e = r5;
    }
}
