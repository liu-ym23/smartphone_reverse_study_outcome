package com.bytedance.android.livesdk.ktvapi.util;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IRoomEx;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class KtvCommonSettingHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public KtvCommonSettingHelper() {
    }

    static {
        a = LazyKt.lazy(KtvCommonSettingHelper$LIVE_VIDEO_CHORUS_FEATURE_ENABLE$2.INSTANCE);
        b = LazyKt.lazy(KtvCommonSettingHelper$LIVE_VIDEO_CHORUS_FEATURE_ANCHOR_ENABLE$2.INSTANCE);
    }

    public static boolean b() {
        if (((Boolean) b.getValue()).booleanValue() == false) goto L5;
        return true;
    L5:
        IRoomEx r0 = m.i().getCurrentRoom();
        String r1 = null;
        if (r0 != null) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        r1 = r0.getAnchorAbValue("video_real_time_chorus");
    L11:
        return Intrinsics.areEqual(r1, "1");
    }

    public static boolean a(Map r4) {
        if (v.a() == false) goto L7;
        return ((Boolean) vm2.d.r1.getValue(null, vm2.d.a[119(0x77, float:1.67E-43)])).booleanValue();
    L7:
        if (((Boolean) vm2.d.q1.getValue(null, vm2.d.a[118(0x76, float:1.65E-43)])).booleanValue() == true) goto L22;
        if (r4 != null) goto L16;
        com.bytedance.live.datacontext.m r5 = m.i().getRoom();
        if (r5 == null) goto L14;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L14;
        r4 = r6.getAnchorABMap();
    L14:
        r4 = null;
    L16:
        if (r4 == null) goto L20;
        String r7 = (String) r4.get("ktv_new_mv");
        if (r7 == null) goto L20;
        int r8 = CastIntegerProtector.parseInt(r7);
    L21:
        if (r8 > 0) goto L22;
        return false;
    L20:
        r8 = 0;
    L22:
        return true;
    }
}
