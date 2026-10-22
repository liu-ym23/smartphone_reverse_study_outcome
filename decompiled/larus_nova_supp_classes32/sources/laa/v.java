package laa;

import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ability.ObricSpecialInputScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v {
    public final DMTaskState a;
    public final StateInfo b;
    public final ObricSpecialInputScene c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L8;
        return false;
    L8:
        v r6 = (v) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        DMTaskState r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        StateInfo r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((r3 + r1) * 31) + this.c.hashCode()) * 31;
        int r6 = 1231;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r5 + r7) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.f == true) goto L23;
        r6 = 1237;
    L23:
        return r10 + r6;
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricSpecialInputStatus(relatedTask=" + this.a + ", currentStateInfo=" + this.b + ", currentScene=" + this.c + ", isChatWindow=" + this.d + ", oIsAutoTimerTask=" + this.e + ", oIsConditionTask=" + this.f + ')';
    }

    public v(DMTaskState r2, StateInfo r3, ObricSpecialInputScene r4, boolean r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "currentScene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
