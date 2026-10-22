package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.android.livesdk.gift.platform.business.effect.delete.CleanOpportunity;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static void a(long r2, long r4, String r6, String r7, CleanDataSource r8, CleanOpportunity r9, String r10, int r11) {
        if ((r11 & 16) == 0) goto L6;
        r8 = CleanDataSource.DEFAULT;
    L6:
        if ((r11 & 32) == 0) goto L9;
        r9 = CleanOpportunity.UNKNOWN;
    L9:
        if ((r11 & 64) == 0) goto L11;
        r10 = BuildConfig.FLAVOR;
    L11:
        Intrinsics.checkNotNullParameter(r6, "md5");
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r8, "cleanDataSource");
        Intrinsics.checkNotNullParameter(r9, "cleanOpportunity");
        Intrinsics.checkNotNullParameter(r10, "assetPoolType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("effect_id", String.valueOf(r2));
        r0.put("live_duration", String.valueOf(r4));
        r0.put("source", r7);
        r0.put("delete_md5", r6);
        r0.put("clean_data_source", String.valueOf(r8.getSource()));
        r0.put("clean_moment", String.valueOf(r9.getValue()));
        r0.put("asset_pool_type", r10);
        mz0.n r3 = new mz0.n();
        Map r5 = r3.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r5.putAll(r0);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.PAGE_SOURCE_LOG);
        r13.b(LogCommon.ROOM);
        List r14 = r3.b;
        ArrayList r15 = (ArrayList) r14;
        r15.addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((f80.a) r17).w3("livesdk_rd_gift_resource_delete", r3.a, r3.b);
    }
}
