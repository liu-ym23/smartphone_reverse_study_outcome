package lda;

import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w {
    public final String a;
    public final long b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final boolean g;
    public final boolean h;
    public final long i;
    public final OmniTaskTriggerType j;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof w) == true) goto L8;
        return false;
    L8:
        w r9 = (w) r8;
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
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        int r3 = 1231;
        if (this.g == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.h == true) goto L10;
        r3 = 1237;
    L10:
        long r6 = this.i;
        return ((((r5 + r3) * 31) + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.j.hashCode();
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "OmniRuntimeStep(recordId=" + this.a + ", createdAt=" + this.b + ", userQuery=" + this.c + ", stepIndex=" + this.d + ", stepDescription=" + this.e + ", modelReply=" + this.f + ", isLastStep=" + this.g + ", isSuccess=" + this.h + ", finishTimeMillis=" + this.i + ", taskTriggerType=" + this.j + ')';
    }

    public w(String r2, long r3, String r5, int r6, String r7, String r8, boolean r9, boolean r10, long r11, OmniTaskTriggerType r13) {
        Intrinsics.checkNotNullParameter(r2, "recordId");
        Intrinsics.checkNotNullParameter(r5, "userQuery");
        Intrinsics.checkNotNullParameter(r7, "stepDescription");
        Intrinsics.checkNotNullParameter(r8, "modelReply");
        Intrinsics.checkNotNullParameter(r13, "taskTriggerType");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r13;
    }
}
