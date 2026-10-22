package com.bytedance.android.live.liveinteract.wrds;

import com.bytedance.android.live.liveinteract.IMultiCommonService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import io.reactivex.Single;
import java.util.Set;
import jc1.k;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkWRDSHelper {
    public static final Set<Integer> a = null;
    public static final Set<Integer> b = null;

    public LinkWRDSHelper() {
    }

    static {
        a = SetsKt.setOf(new Integer[]{6, 7, 11, 12, 33, 41});
        if (((Boolean) vm2.d.m8.getValue(null, vm2.d.a[477(0x1dd, float:6.68E-43)])).booleanValue() == false) goto L5;
        Set<Integer> r0 = SetsKt.setOf(new Integer[]{8, 12, 5, 9, 16});
    L6:
        b = r0;
        return;
    L5:
        r0 = SetsKt.setOf(new Integer[]{8, 12, 5, 9});
        goto L6
    }

    public static final boolean a() {
        if (((IMultiCommonService) k.n(IMultiCommonService.class)).checkCommonSetting(b) == true) goto L6;
    L7:
        return false;
    L6:
        if (((Boolean) vm2.d.n8.getValue(null, vm2.d.a[478(0x1de, float:6.7E-43)])).booleanValue() == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final long c() {
        return ((Number) vm2.d.p8.getValue(null, vm2.d.a[480(0x1e0, float:6.73E-43)])).longValue();
    }

    @JvmStatic
    public static final LinkMicRoomDataSyncModel b() {
        u r0 = m.d();
        LinkMicRoomDataSyncModel r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        com.bytedance.live.datacontext.j r2 = r0.D();
        if (r2 == null) goto L8;
        LinkMicRoomDataSyncModel r3 = (LinkMicRoomDataSyncModel) r2.getValue();
    L9:
        if (r3 != null) goto L20;
        com.bytedance.live.datacontext.j r4 = m.i().w1();
        if (r4 == null) goto L15;
        ylc.e r5 = (ylc.e) r4.getValue();
        if (r5 == null) goto L15;
        r1 = (LinkMicRoomDataSyncModel) dc2.b.a(r5, LinkWRDSHelper$getLinkRoomDataSyncModel$1.INSTANCE);
    L15:
        com.bytedance.live.datacontext.j r6 = r0.D();
        if (r6 == null) goto L19;
        r6.d(r1);
    L19:
        return r1;
    L20:
        return r3;
    L8:
        r3 = null;
        goto L9
    }

    public static Single d(com.bytedance.android.live.network.response.e r2) {
        LinkMicRoomDataSyncModel r0 = b();
        Intrinsics.checkNotNullParameter(r2, "response");
        return Single.create(new f(r0, r2));
    }

    public static Single e(com.bytedance.android.live.network.response.e r2) {
        LinkMicRoomDataSyncModel r0 = b();
        Intrinsics.checkNotNullParameter(r2, "response");
        return Single.create(new h(r0, r2));
    }
}
