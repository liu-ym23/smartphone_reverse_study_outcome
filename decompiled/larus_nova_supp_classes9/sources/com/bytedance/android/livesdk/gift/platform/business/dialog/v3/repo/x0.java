package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x0 {
    public final List<Long> a;
    public final boolean b;
    public final String c;

    public x0() {
        List r2 = null;
        this(r2, false, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof x0) == false) goto L12;
        x0 r4 = (x0) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        List<Long> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L9;
        r5 = 1;
    L9:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        return r6 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateGiftData(giftIds=" + this.a + ", needMarketingAnim=" + this.b + ", source=" + this.c + ")";
    }

    public /* synthetic */ x0(List r2, boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r4 & 4) == 0) goto L11;
        String r5 = BuildConfig.FLAVOR;
    L12:
        this(r2, r3, r5);
        return;
    L11:
        r5 = null;
        goto L12
    }

    public x0(List<Long> r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "giftIds");
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
