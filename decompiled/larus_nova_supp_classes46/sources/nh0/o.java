package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.LayerIndex;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageUpdateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public final StageUpdateType a;
    public final String b;
    public final String c;
    public final String d;
    public final LayerIndex e;
    public final n f;
    public final long g;
    public final boolean h;
    public final boolean i;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof o) == false) goto L24;
        o r7 = (o) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        StageUpdateType r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        LayerIndex r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        n r16 = this.f;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        int r17 = (r15 + r1) * 31;
        long r18 = this.g;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        boolean r20 = this.h;
        ?? r21 = 1;
        ?? r22 = r20;
        if (r20 == false) goto L28;
        r22 = 1;
    L28:
        int r23 = (r19 + r22) * 31;
        boolean r24 = this.i;
        if (r24 == true) goto L33;
        r21 = r24;
    L33:
        return r23 + r21;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "StageExtraObject(type=" + this.a + ", itemId=" + this.b + ", lynxSchema=" + this.c + ", lynxUrl=" + this.d + ", layer=" + this.e + ", frame=" + this.f + ", time=" + this.g + ", useSchema=" + this.h + ", needSendEvent=" + this.i + ")";
    }

    public final StageUpdateType getType() {
        return this.a;
    }

    public o(StageUpdateType r2, String r3, String r4, String r5, LayerIndex r6, n r7, long r8, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "itemId");
        Intrinsics.checkNotNullParameter(r4, "lynxSchema");
        Intrinsics.checkNotNullParameter(r5, "lynxUrl");
        Intrinsics.checkNotNullParameter(r6, "layer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
        this.i = r11;
    }
}
