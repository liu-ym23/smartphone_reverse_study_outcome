package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public final String a;
    public final d b;
    public final BubbleBannerState c;
    public final f d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final BubbleBannerDismissReason i;
    public final i j;
    public final b k;
    public final Set<BubbleBannerEnterTrigger> l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
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
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        f r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        long r4 = this.e;
        int r5 = (((r0 + r3) * 31) + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        int r6 = 1231;
        if (this.f == false) goto L9;
        int r7 = 1231;
    L10:
        int r8 = (r5 + r7) * 31;
        if (this.g == false) goto L13;
        int r9 = 1231;
    L14:
        int r10 = (r8 + r9) * 31;
        if (this.h == true) goto L18;
        r6 = 1237;
    L18:
        int r11 = (r10 + r6) * 31;
        BubbleBannerDismissReason r12 = this.i;
        if (r12 != null) goto L21;
        int r13 = 0;
    L22:
        int r14 = (r11 + r13) * 31;
        i r15 = this.j;
        if (r15 != null) goto L25;
        int r16 = 0;
    L26:
        int r17 = (r14 + r16) * 31;
        b r18 = this.k;
        if (r18 == null) goto L31;
        r2 = r18.hashCode();
    L31:
        return ((r17 + r2) * 31) + this.l.hashCode();
    L25:
        r16 = r15.hashCode();
        goto L26
    L21:
        r13 = r12.hashCode();
        goto L22
    L13:
        r9 = 1237;
        goto L14
    L9:
        r7 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerModel(promptId=" + this.a + ", input=" + this.b + ", state=" + this.c + ", renderPlan=" + this.d + ", autoDismissAt=" + this.e + ", autoDismissIgnored=" + this.f + ", enterAnimationConsumed=" + this.g + ", hasShownOnScreen=" + this.h + ", dismissReason=" + this.i + ", transition=" + this.j + ", exitCompletion=" + this.k + ", readyEnterTriggers=" + this.l + ')';
    }

    public final String b() {
        f r0 = this.d;
        if (r0 == null) goto L6;
        String r1 = r0.a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        String r2 = g.a(this.b);
        if (r2 != null) goto L11;
        return "";
    L11:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(String r2, d r3, BubbleBannerState r4, f r5, long r6, boolean r8, boolean r9, boolean r10, BubbleBannerDismissReason r11, i r12, b r13, Set<? extends BubbleBannerEnterTrigger> r14) {
        Intrinsics.checkNotNullParameter(r2, "promptId");
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r14, "readyEnterTriggers");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }

    public static e a(e r18, BubbleBannerState r19, f r20, long r21, boolean r23, boolean r24, boolean r25, BubbleBannerDismissReason r26, i r27, b r28, Set r29, int r30) {
        d r3 = null;
        if ((r30 & 1) == 0) goto L5;
        String r5 = r18.a;
    L7:
        if ((r30 & 2) == 0) goto L9;
        r3 = r18.b;
    L9:
        d r6 = r3;
        if ((r30 & 4) == 0) goto L12;
        BubbleBannerState r7 = r18.c;
    L14:
        if ((r30 & 8) == 0) goto L16;
        f r8 = r18.d;
    L18:
        if ((r30 & 16) == 0) goto L20;
        long r9 = r18.e;
    L22:
        if ((r30 & 32) == 0) goto L24;
        boolean r11 = r18.f;
    L26:
        if ((r30 & 64) == 0) goto L28;
        boolean r12 = r18.g;
    L30:
        if ((r30 & 128) == 0) goto L32;
        boolean r13 = r18.h;
    L34:
        if ((r30 & 256) == 0) goto L36;
        BubbleBannerDismissReason r14 = r18.i;
    L38:
        if ((r30 & 512) == 0) goto L40;
        i r15 = r18.j;
    L42:
        if ((r30 & 1024) == 0) goto L44;
        b r16 = r18.k;
    L46:
        if ((r30 & 2048) == 0) goto L48;
        Set r0 = r18.l;
    L49:
        Intrinsics.checkNotNullParameter(r5, "promptId");
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r0, "readyEnterTriggers");
        return new e(r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r0);
    L48:
        r0 = r29;
        goto L49
    L44:
        r16 = r28;
        goto L46
    L40:
        r15 = r27;
        goto L42
    L36:
        r14 = r26;
        goto L38
    L32:
        r13 = r25;
        goto L34
    L28:
        r12 = r24;
        goto L30
    L24:
        r11 = r23;
        goto L26
    L20:
        r9 = r21;
        goto L22
    L16:
        r8 = r20;
        goto L18
    L12:
        r7 = r19;
        goto L14
    L5:
        r5 = null;
        goto L7
    }
}
