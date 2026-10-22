package com.bytedance.android.live.room.api.messagewindow.monitor;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public final String a;
    public final String b;
    public final long c;
    public final String d;
    public final String e;
    public final Map<String, Object> f;
    public final f g;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.g, ((e) r2).g) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        f r0 = this.g;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "CardNode(builder=" + this.g + ")";
    }

    public e(f r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        this.g = r3;
        this.a = r3.f;
        this.b = r3.a;
        this.c = r3.b;
        this.d = r3.c;
        this.e = r3.d;
        this.f = r3.e;
    }
}
