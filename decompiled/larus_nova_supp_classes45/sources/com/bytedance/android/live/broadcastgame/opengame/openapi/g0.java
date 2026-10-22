package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LaunchMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 {
    public final String a;
    public final long b;
    public final Context c;
    public final LaunchMode d;
    public final long e;
    public final String f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof g0) == false) goto L18;
        g0 r7 = (g0) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        Context r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        LaunchMode r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r11 = (r7 + r9) * 31;
        long r12 = this.e;
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        String r14 = this.f;
        if (r14 == null) goto L18;
        r1 = r14.hashCode();
    L18:
        return r13 + r1;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenApiParams(appId=" + this.a + ", roomId=" + this.b + ", context=" + this.c + ", launchMode=" + this.d + ", gameId=" + this.e + ", appName=" + this.f + ")";
    }

    public final Context getContext() {
        return this.c;
    }

    public g0(String r2, long r3, Context r5, LaunchMode r6, long r7, String r9) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "launchMode");
        Intrinsics.checkNotNullParameter(r9, "appName");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
    }
}
