package k31;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.jvm.internal.Intrinsics;
import rc0.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public final int a;
    public final int b;
    public final boolean c;
    public final View d;
    public final boolean e;
    public final ILiveMode f;
    public final String g;
    public final f h;
    public final q i;
    public final k j;
    public final a k;
    public final boolean l;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L30;
        m r4 = (m) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (this.l == r4.l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        boolean r1 = this.c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        View r5 = this.d;
        int r6 = 0;
        if (r5 == null) goto L8;
        int r7 = r5.hashCode();
    L9:
        int r8 = (r4 + r7) * 31;
        boolean r9 = this.e;
        ?? r10 = r9;
        if (r9 == false) goto L12;
        r10 = 1;
    L12:
        int r12 = (r8 + r10) * 31;
        ILiveMode r13 = this.f;
        if (r13 == null) goto L15;
        int r14 = r13.hashCode();
    L16:
        int r15 = (r12 + r14) * 31;
        String r16 = this.g;
        if (r16 == null) goto L19;
        int r17 = r16.hashCode();
    L20:
        int r18 = (r15 + r17) * 31;
        f r19 = this.h;
        if (r19 == null) goto L23;
        int r20 = r19.hashCode();
    L24:
        int r22 = (r18 + r20) * 31;
        q r23 = this.i;
        if (r23 == null) goto L27;
        int r24 = r23.hashCode();
    L28:
        int r25 = (r22 + r24) * 31;
        k r26 = this.j;
        if (r26 == null) goto L31;
        int r27 = r26.hashCode();
    L32:
        int r28 = (r25 + r27) * 31;
        a r29 = this.k;
        if (r29 == null) goto L35;
        r6 = r29.hashCode();
    L35:
        int r30 = (r28 + r6) * 31;
        boolean r32 = this.l;
        if (r32 == true) goto L40;
        r2 = r32;
    L40:
        return r30 + r2;
    L31:
        r27 = 0;
        goto L32
    L27:
        r24 = 0;
        goto L28
    L23:
        r20 = 0;
        goto L24
    L19:
        r17 = 0;
        goto L20
    L15:
        r14 = 0;
        goto L16
    L8:
        r7 = 0;
        goto L9
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("[containerWidth = ");
        r0.append(this.a);
        r0.append(", containerHeight = ");
        r0.append(this.b);
        r0.append(", isFullScreen = ");
        r0.append(this.c);
        r0.append(", isPortrait = ");
        r0.append(this.e);
        r0.append(", seiRaw = ");
        r0.append(this.g);
        r0.append(", statusBarOption = ");
        r0.append(this.j);
        r0.append(", componentsOption = ");
        a r1 = this.k;
        String r2 = null;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r1, "$this$formatString");
        StringBuilder r4 = new StringBuilder("pkProgressBarOption = ");
        g r3 = r1.a;
        if (r3 == null) goto L7;
        Intrinsics.checkNotNullParameter(r3, "$this$formatString");
        r2 = "PkProgressBarOption(transForPkBar=" + r3.a + ", pkBarHeight=" + r3.b + ')';
    L7:
        r4.append(r2);
        r2 = r4.toString();
    L8:
        r0.append(r2);
        r0.append(']');
        return r0.toString();
    }

    public m(int r2, int r3, boolean r4, View r5, boolean r6, LiveMode r7, String r8, q r9, k r10, a r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r5, "playerView");
        Intrinsics.checkNotNullParameter(r7, "liveMode");
        Intrinsics.checkNotNullParameter(r10, "statusBarOption");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = null;
        this.i = r9;
        this.j = r10;
        this.k = r12;
        this.l = r13;
    }
}
