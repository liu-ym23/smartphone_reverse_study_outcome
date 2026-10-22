package w72;

import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final boolean a;
    public final Map<String, Long> b;
    public final Map<String, Long> c;
    public final Map<String, o> d;
    public final Map<String, Long> e;
    public final Map<String, o> f;

    public b() {
        this(false, 63);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L18;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
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
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        Map<String, Long> r3 = this.b;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        Map<String, Long> r7 = this.c;
        if (r7 == null) goto L12;
        int r8 = r7.hashCode();
    L13:
        int r9 = (r6 + r8) * 31;
        Map<String, o> r10 = this.d;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r13 = (r9 + r11) * 31;
        Map<String, Long> r14 = this.e;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        Map<String, o> r17 = this.f;
        if (r17 == null) goto L25;
        r4 = r17.hashCode();
    L25:
        return r16 + r4;
    L20:
        r15 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "FrequencyConfig(forAnchor=" + this.a + ", maxWaitingTime=" + this.b + ", maxTimesForScene=" + this.c + ", timeGapConfigForScene=" + this.d + ", maxTimesForType=" + this.e + ", timesGapConfigForType=" + this.f + ")";
    }

    public b(boolean r6, int r7) {
        if ((r7 & 1) == 0) goto L5;
        r6 = false;
    L5:
        HashMap r1 = null;
        if ((r7 & 2) == 0) goto L8;
        HashMap r0 = new HashMap();
    L10:
        if ((r7 & 4) == 0) goto L12;
        HashMap r2 = new HashMap();
    L14:
        if ((r7 & 8) == 0) goto L16;
        HashMap r3 = new HashMap();
    L18:
        if ((r7 & 16) == 0) goto L20;
        HashMap r4 = new HashMap();
    L22:
        if ((r7 & 32) == 0) goto L24;
        r1 = new HashMap();
    L24:
        Intrinsics.checkNotNullParameter(r0, "maxWaitingTime");
        Intrinsics.checkNotNullParameter(r2, "maxTimesForScene");
        Intrinsics.checkNotNullParameter(r3, "timeGapConfigForScene");
        Intrinsics.checkNotNullParameter(r4, "maxTimesForType");
        Intrinsics.checkNotNullParameter(r1, "timesGapConfigForType");
        this.a = r6;
        this.b = r0;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r1;
        return;
    L20:
        r4 = null;
        goto L22
    L16:
        r3 = null;
        goto L18
    L12:
        r2 = null;
        goto L14
    L8:
        r0 = null;
        goto L10
    }
}
