package x48;

import kotlin.jvm.internal.Intrinsics;
import z48.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public final a a;
    public final boolean b;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (this.b == r6.b) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        a r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((r1 * 31) + 0) * 31;
        if (this.b == false) goto L9;
        int r3 = 1231;
    L11:
        return r2 + r3;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerConfig(chatSpeakerUIConfig=" + this.a + ", chatSpeakerStyleConfig=null, chatSpeakerAlterSendTextOrVoice=" + this.b + ')';
    }

    public b(a r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this.a = r1;
        this.b = false;
    }
}
