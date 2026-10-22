package w61;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final String a;
    public final MsgWindowPosition b;

    public final String toString() {
        return "MsgWindowIdentity(roomId=" + this.a + ", position=" + this.b + ")";
    }

    public b() {
        this("", MsgWindowPosition.BOTTOM_RIGHT);
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        int r3 = this.b.ordinal() * 31;
        String r4 = this.a;
        if (r4 == null) goto L16;
        r1 = r4.hashCode();
    L16:
        return r3 + r1;
    L11:
        return this.b.ordinal();
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(b.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L21;
        b r6 = (b) r5;
        if ((!Intrinsics.areEqual(this.a, r6.a)) == false) goto L17;
        return false;
    L17:
        if (this.b == r6.b) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.container.MsgWindowIdentity");
    L8:
        r2 = null;
        goto L10
    }

    public b(String r2, MsgWindowPosition r3) {
        Intrinsics.checkNotNullParameter(r3, "position");
        this.a = r2;
        this.b = r3;
    }
}
