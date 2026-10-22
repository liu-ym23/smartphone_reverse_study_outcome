package com.bytedance.android.livesdk.ktvapi.model.mv;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public String a;
    public MusicPanel b;
    public int c;
    public int d;
    public final long e;
    public final String f;

    public final int hashCode() {
        long r0 = this.e;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.f;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "MvSongInfo(mId=" + this.e + ", singerId=" + this.f + ")";
    }

    public final boolean equals(Object r7) {
        if ((r7 instanceof k) == true) goto L5;
        return false;
    L5:
        k r8 = (k) r7;
        if (r8.e == this.e) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f, r8.f) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public k(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "singerId");
        this.e = r2;
        this.f = r4;
    }
}
