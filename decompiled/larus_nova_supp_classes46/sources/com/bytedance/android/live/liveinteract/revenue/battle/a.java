package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.r2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements zt0.b {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function2 b;

    public final void a(String r7) {
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [asyncCrownBeautyEffectId] onSyncSuccess id " + r7);
        int r0 = i.a;
        com.bytedance.android.live.profit.dress.s r1 = yt0.c.a().getDressData(r7, 33, "CommonWidgetResouce fetchDressList--onSyncSuccess");
        if (r1 == null) goto L5;
        String r2 = r1.d;
    L7:
        if (r2.a(r2) == false) goto L9;
        Function1 r8 = this.a;
        Intrinsics.checkNotNull(r2);
        r8.invoke(r2);
        return;
    L9:
        ALogger.e("CommonWidgetResouce", "#DressResourceDebug# [asyncCrownBeautyEffectId] onSyncSuccess id " + r7 + ", but effectIdSync is invalid " + r2);
        this.b.invoke(-1, "onSyncSuccess id " + r7 + ", but effectIdSync is invalid " + r2);
        return;
    L5:
        r2 = null;
        goto L7
    }

    public a(Function1 r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(String r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "version");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [asyncCrownBeautyEffectId] onSyncFailed id " + r2);
        this.b.invoke(Integer.valueOf(r4), r5);
    }
}
