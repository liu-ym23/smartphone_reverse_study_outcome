package com.bytedance.android.live.ktv.common.karaokestation.model;

import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.AddMusicControlNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v {
    public final Context a;
    public final com.bytedance.android.live.ktv.common.music.control.b b;
    public final boolean c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v) == false) goto L12;
        v r4 = (v) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Context r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        com.bytedance.android.live.ktv.common.music.control.b r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.c;
        ?? r7 = r6;
        if (r6 == false) goto L13;
        r7 = 1;
    L13:
        return r5 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSongRequest(context=" + this.a + ", node=" + this.b + ", fromOutSide=" + this.c + ")";
    }

    public final Context getContext() {
        return this.a;
    }

    public v(Context r2, AddMusicControlNode r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "node");
        this.a = r2;
        this.b = r3;
        this.c = true;
    }
}
