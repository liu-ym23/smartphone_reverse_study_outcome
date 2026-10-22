package vd8;

import com.larus.bmhome.chat.list.cell.spacer.SpacerAnimationState;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p {
    public final String a;
    public final int b;
    public final Message c;
    public final SpacerAnimationState d;
    public final com.larus.bmhome.chat.list.cell.spacer.a e;
    public final com.larus.bmhome.chat.list.cell.spacer.i f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        com.larus.bmhome.chat.list.cell.spacer.a r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.f.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "SpacerRequest(spacerId=" + this.a + ", heightPx=" + this.b + ", baseMessage=" + this.c + ", animationState=" + this.d + ", animationSpec=" + this.e + ", delegate=" + this.f + ')';
    }

    public p(String r2, int r3, Message r4, SpacerAnimationState r5, com.larus.bmhome.chat.list.cell.spacer.a r6, com.larus.bmhome.chat.list.cell.spacer.i r7) {
        Intrinsics.checkNotNullParameter(r2, "spacerId");
        Intrinsics.checkNotNullParameter(r4, "baseMessage");
        Intrinsics.checkNotNullParameter(r5, "animationState");
        Intrinsics.checkNotNullParameter(r7, "delegate");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
