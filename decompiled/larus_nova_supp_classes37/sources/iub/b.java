package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmAIInterpretationEventType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final MmAIInterpretationEventType a;
    public final n b;
    public final int c;
    public final String d;
    public final int e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        n r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "MmAIInterpretationEvent(type=" + this.a + ", language=" + this.b + ", errorCode=" + this.c + ", message=" + this.d + ", statusCode=" + this.e + ')';
    }

    public final MmAIInterpretationEventType getType() {
        return this.a;
    }

    public b(MmAIInterpretationEventType r2, n r3, String r4, int r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r4 = "";
    L9:
        if ((r6 & 16) == 0) goto L11;
        r5 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.a = r2;
        this.b = r3;
        this.c = 0;
        this.d = r4;
        this.e = r5;
    }
}
