package gd0;

import hh1.v0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x {
    public final ei6.a a;
    public final boolean b;
    public final Map<String, Object> c;
    public final d0 d;
    public final boolean e;
    public Object f;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof x) == false) goto L18;
        x r4 = (x) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        ei6.a r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        Map<String, Object> r8 = this.c;
        if (r8 == null) goto L12;
        int r9 = r8.hashCode();
    L13:
        int r10 = (r7 + r9) * 31;
        d0 r11 = this.d;
        if (r11 == null) goto L16;
        int r12 = r11.hashCode();
    L17:
        int r13 = (r10 + r12) * 31;
        boolean r14 = this.e;
        if (r14 == true) goto L21;
        r5 = r14;
    L21:
        int r15 = (r13 + r5) * 31;
        Object r16 = this.f;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        return r15 + r1;
    L16:
        r12 = 0;
        goto L17
    L12:
        r9 = 0;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RtcManagerData(mClient=" + this.a + ", isEngineOn=" + this.b + ", remoteMap=" + this.c + ", liveCore=" + this.d + ", hasLinkAudience4Stop=" + this.e + ", liveClient=" + this.f + ")";
    }

    public x(ei6.a r2, boolean r3, Map<String, Object> r4, d0 r5, boolean r6, Object r7) {
        Intrinsics.checkNotNullParameter(r4, "remoteMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public /* synthetic */ x(ei6.a r8, boolean r9, Map r10, d0 r11, boolean r12, v0 r13, int r14) {
        if ((r14 & 16) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r14 & 32) == 0) goto L9;
        r13 = null;
    L9:
        this(r8, r9, r10, r11, r5, r13);
        return;
    L5:
        r5 = r12;
        goto L7
    }
}
