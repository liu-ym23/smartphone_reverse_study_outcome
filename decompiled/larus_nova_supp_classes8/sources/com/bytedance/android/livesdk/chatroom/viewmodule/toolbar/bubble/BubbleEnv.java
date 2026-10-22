package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BubbleEnv {
    public final Lazy a;
    public final RoomContext b;
    public final DataCenter c;

    public final g a() {
        return (g) this.a.getValue();
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BubbleEnv) == false) goto L10;
        BubbleEnv r4 = (BubbleEnv) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        RoomContext r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        DataCenter r4 = this.c;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "BubbleEnv(roomContext=" + this.b + ", dataCenter=" + this.c + ")";
    }

    public BubbleEnv(RoomContext r1, DataCenter r2) {
        this.b = r1;
        this.c = r2;
        this.a = LazyKt.lazy(BubbleEnv$showRecord$2.INSTANCE);
    }
}
