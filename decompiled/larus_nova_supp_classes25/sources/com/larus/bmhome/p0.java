package com.larus.bmhome;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import hq9.v2;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p0 implements ltb.a<mtb.k> {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ OfficeSDKUserApi b;
    public final /* synthetic */ v2 c;

    public final void onSuccess(Object r5) {
        mtb.k r6 = (mtb.k) r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        if (this.a.a(this.b, this.c) == true) goto L5;
        FLogger.a.w("SideBarLarkBadgeManager", "ignore stale getNewFriendBadge callback generation=" + this.c.b);
        return;
    L5:
        FLogger.a.i("SideBarLarkBadgeManager", "getNewFriendBadge onSuccess badgeCount=" + r6.a);
        this.a.b.set(r6.a);
        SoftReference r7 = com.larus.utils.y.a;
        final l0 r8 = this.a;
        final OfficeSDKUserApi r0 = this.b;
        final v2 r1 = this.c;
        com.larus.utils.y.c(new o0(r8, r0, r1));
    }

    public final void onError(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        FLogger.a.e("SideBarLarkBadgeManager", "getNewFriendBadge onError code=" + r4 + " message=" + r5);
    }

    public p0(l0 r1, OfficeSDKUserApi r2, v2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
