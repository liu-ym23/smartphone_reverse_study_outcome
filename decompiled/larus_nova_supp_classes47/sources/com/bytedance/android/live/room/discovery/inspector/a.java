package com.bytedance.android.live.room.discovery.inspector;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final int a;
    public final l b;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.inspector.a$a, reason: collision with other inner class name */
    public static final class C0208a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        l r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "OfficialInspectorData(type=" + this.a + ", config=" + this.b + ")";
    }

    public final int getType() {
        return this.a;
    }

    public a(int r1, l r2) {
        this.a = r1;
        this.b = r2;
    }
}
