package com.larus.bmhome;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import hq9.v2;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;
import ltb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n0 implements b {
    public final /* synthetic */ l0 a;
    public final /* synthetic */ OfficeSDKUserApi b;
    public final /* synthetic */ v2 c;

    public final void a(mtb.k r5) {
        Intrinsics.checkNotNullParameter(r5, "badge");
        if (this.a.a(this.b, this.c) == true) goto L6;
        FLogger.a.w("SideBarLarkBadgeManager", "ignore stale badge listener callback generation=" + this.c.b);
        return;
    L6:
        FLogger.a.i("SideBarLarkBadgeManager", "onNewFriendBadgeChanged badgeCount=" + r5.a);
        this.a.b.set(r5.a);
        SoftReference r6 = com.larus.utils.y.a;
        final l0 r7 = this.a;
        final OfficeSDKUserApi r0 = this.b;
        final v2 r1 = this.c;
        com.larus.utils.y.c(new m0(r7, r0, r1));
    }

    public n0(l0 r1, OfficeSDKUserApi r2, v2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
