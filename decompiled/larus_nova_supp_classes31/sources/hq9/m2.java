package hq9;

import com.larus.platform.model.LarkSocialImModuleState;
import com.larus.platform.model.LarkSocialSnapshotState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m2 {
    public final LarkSocialSnapshotState a;
    public final v2 b;
    public final boolean c;
    public final boolean d;
    public final v2 e;
    public final LarkSocialImModuleState f;
    public final v2 g;
    public final v2 h;

    public m2() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m2) == true) goto L8;
        return false;
    L8:
        m2 r6 = (m2) r5;
        if (this.a == r6.a) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        v2 r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        int r5 = 1231;
        if (this.c == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (r4 + r6) * 31;
        if (this.d == true) goto L14;
        r5 = 1237;
    L14:
        int r8 = (r7 + r5) * 31;
        v2 r9 = this.e;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (((r8 + r10) * 31) + this.f.hashCode()) * 31;
        v2 r12 = this.g;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        v2 r15 = this.h;
        if (r15 == null) goto L27;
        r2 = r15.hashCode();
    L27:
        return r14 + r2;
    L21:
        r13 = r12.hashCode();
        goto L22
    L17:
        r10 = r9.hashCode();
        goto L18
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkSocialCapabilityState(snapshotState=" + this.a + ", session=" + this.b + ", desiredEnabled=" + this.c + ", activeEnabled=" + this.d + ", officeUserReadySession=" + this.e + ", imModuleState=" + this.f + ", imReadySession=" + this.g + ", imFailureSession=" + this.h + ')';
    }

    public /* synthetic */ m2(int r10) {
        this(LarkSocialSnapshotState.UNKNOWN, null, false, false, null, LarkSocialImModuleState.NOT_LOADED, null, null);
    }

    public m2(LarkSocialSnapshotState r2, v2 r3, boolean r4, boolean r5, v2 r6, LarkSocialImModuleState r7, v2 r8, v2 r9) {
        Intrinsics.checkNotNullParameter(r2, "snapshotState");
        Intrinsics.checkNotNullParameter(r7, "imModuleState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
