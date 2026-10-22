package c61;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final Long a;
    public final String b;

    public c() {
        this(0L, "");
    }

    public final int hashCode() {
        String r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.a;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final Long getType() {
        return this.a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(c.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L21;
        c r6 = (c) r5;
        if ((!Intrinsics.areEqual(this.a, r6.a)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.b, r6.b)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.draggablecomponent.DraggableScene");
    L8:
        r2 = null;
        goto L10
    }

    public c(Long r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
