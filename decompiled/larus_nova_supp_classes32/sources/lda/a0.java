package lda;

import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a0 {
    public final String a;
    public final long b;
    public final String c;
    public final long d;
    public final String e;
    public final OmniTaskTriggerType f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r9 = (a0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31;
        long r3 = this.d;
        return ((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "OmniRuntimeUserStop(recordId=" + this.a + ", createdAt=" + this.b + ", userQuery=" + this.c + ", finishTimeMillis=" + this.d + ", reason=" + this.e + ", taskTriggerType=" + this.f + ')';
    }

    public a0(String r2, long r3, String r5, long r6, String r8, OmniTaskTriggerType r9) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r5, "userQuery");
        Intrinsics.checkNotNullParameter(r8, "reason");
        Intrinsics.checkNotNullParameter(r9, "taskTriggerType");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r8;
        this.f = r9;
    }
}
