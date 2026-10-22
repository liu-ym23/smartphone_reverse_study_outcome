package rc0;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o {
    public final Function1<c, Unit> a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final IRoom e;
    public final boolean f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final LiveMode k;
    public final Context l;
    public g m;
    public final a n;

    public o() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof o) == false) goto L36;
        o r4 = (o) r3;
        r4.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L10;
        return false;
    L10:
        if (this.b == r4.b) goto L12;
        return false;
    L12:
        if (this.c == r4.c) goto L14;
        return false;
    L14:
        if (this.d == r4.d) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L18;
        return false;
    L18:
        if (this.f == r4.f) goto L20;
        return false;
    L20:
        if (this.g == r4.g) goto L22;
        return false;
    L22:
        if (this.h == r4.h) goto L24;
        return false;
    L24:
        if (this.i == r4.i) goto L26;
        return false;
    L26:
        if (this.j == r4.j) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Function1<c, Unit> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = (r2 + 0) * 31;
        boolean r4 = this.b;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.c;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r11 = (r7 + r9) * 31;
        boolean r12 = this.d;
        ?? r13 = r12;
        if (r12 == false) goto L15;
        r13 = 1;
    L15:
        int r14 = (r11 + r13) * 31;
        IRoom r15 = this.e;
        if (r15 == null) goto L18;
        int r16 = r15.hashCode();
    L19:
        int r17 = (r14 + r16) * 31;
        boolean r18 = this.f;
        if (r18 == true) goto L23;
        r5 = r18;
    L23:
        int r19 = (((((((((r17 + r5) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31;
        LiveMode r21 = this.k;
        if (r21 == null) goto L26;
        int r22 = r21.hashCode();
    L27:
        int r23 = (r19 + r22) * 31;
        Context r24 = this.l;
        if (r24 == null) goto L30;
        int r25 = r24.hashCode();
    L31:
        int r26 = (r23 + r25) * 31;
        g r27 = this.m;
        if (r27 == null) goto L34;
        int r28 = r27.hashCode();
    L35:
        int r29 = (r26 + r28) * 31;
        a r31 = this.n;
        if (r31 == null) goto L39;
        r1 = r31.hashCode();
    L39:
        return r29 + r1;
    L34:
        r28 = 0;
        goto L35
    L30:
        r25 = 0;
        goto L31
    L26:
        r22 = 0;
        goto L27
    L18:
        r16 = 0;
        goto L19
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RevenuePlayerLayoutContextExternal(extraLayoutData=null, feedPlayerEvent=" + this.a + ", isPad=" + this.b + ", isFoldScreenFullType=" + this.c + ", isPortrait=" + this.d + ", room=" + this.e + ", isPreview=" + this.f + ", containerWidth=" + this.g + ", containerHeight=" + this.h + ", videoWidth=" + this.i + ", videoHeight=" + this.j + ", streamType=" + this.k + ", activityContext=" + this.l + ", extraRenderControoler=" + this.m + ", bottomSizeInfo=" + this.n + ")";
    }

    public o(Function1 r7, boolean r8, boolean r9, boolean r11, IRoom r12, boolean r13, int r14, int r15, int r16, int r17, LiveMode r18, Context r19, a r110, int r21) {
        if ((r21 & 4096) == 0) goto L5;
        Context r3 = null;
    L7:
        if ((r21 & 16384) == 0) goto L9;
        a r2 = null;
    L10:
        Intrinsics.checkNotNullParameter(r18, "streamType");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r3;
        this.m = null;
        this.n = r2;
        return;
    L9:
        r2 = r110;
        goto L10
    L5:
        r3 = r19;
        goto L7
    }
}
