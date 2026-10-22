package va8;

import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final FloatChatWindowEventType a;
    public final FloatChatWindowState b;
    public final Message c;
    public final String d;
    public final t0 e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        FloatChatWindowState r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Message r5 = this.c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        t0 r11 = this.e;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        int r12 = (r10 + r2) * 31;
        if (this.f == false) goto L21;
        int r13 = 1231;
    L23:
        return r12 + r13;
    L21:
        r13 = 1237;
        goto L23
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "FloatChatWindowEvent(type=" + this.a + ", targetState=" + this.b + ", anchorMessage=" + this.c + ", queryMsgId=" + this.d + ", viewBusinessPayload=" + this.e + ", needAnim=" + this.f + ')';
    }

    public final FloatChatWindowEventType getType() {
        return this.a;
    }

    public f(FloatChatWindowEventType r3, FloatChatWindowState r4, Message r5, String r6, t0 r7, boolean r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r9 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r9 & 16) == 0) goto L15;
        r7 = null;
    L15:
        if ((r9 & 32) == 0) goto L17;
        r8 = true;
    L17:
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
