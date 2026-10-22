package com.bytedance.android.livesdk.event;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final int a;
    public final String b;
    public final JSONObject c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L12;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        JSONObject r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "BannerH5RoomStatusChangeEvent(position=" + this.a + ", type=" + this.b + ", data=" + this.c + ")";
    }

    public final String getType() {
        return this.b;
    }

    public c(JSONObject r3) {
        Intrinsics.checkNotNullParameter("cny_task_reward", "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a = 1;
        this.b = "cny_task_reward";
        this.c = r3;
    }
}
