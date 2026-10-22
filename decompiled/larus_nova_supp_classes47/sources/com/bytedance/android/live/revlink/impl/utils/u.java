package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u {
    public static final boolean b() {
        IMiddlewareHostBusiness r0 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r0 != null) goto L5;
    L7:
        IRoom r1 = a();
        if (r1 == null) goto L15;
        if (r1.isLiveTypeAudio() != true) goto L15;
        if (d51.c.A0.r().Y3() == true) goto L15;
        return false;
    L15:
        return d51.c.A0.r().getEnable();
    L5:
        if (r0.isEnablePersonalRecommend() == true) goto L7;
        return false;
    }

    public static final IRoom a() {
        s r0 = com.bytedance.android.live.revlink.impl.global.b.b0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public static final String c() {
        s r0 = com.bytedance.android.live.revlink.impl.global.b.b0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public static final long d() {
        s r0 = com.bytedance.android.live.revlink.impl.global.b.b0();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d();
    }

    public static final String e() {
        s r0 = com.bytedance.android.live.revlink.impl.global.b.b0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    public static final Pair<Integer, Integer> f() {
        com.bytedance.android.live.revenuelink.rtc.f r0 = com.bytedance.android.live.revlink.impl.global.b.d();
        uf2.d0 r1 = null;
        Object r2 = null;
        if (r0 == null) goto L26;
        com.bytedance.android.live.revenuelink.rtc.i r3 = r0.getRtcManager();
        if (r3 == null) goto L26;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r4 = ILiveWrappedLivePusher.a.b();
        if (r4 == null) goto L13;
        vc0.a r5 = r3.getLiveCore();
        if (r5 == null) goto L12;
        r2 = r5.a;
    L12:
        r1 = r4.buildLiveCore(r2);
    L13:
        int r6 = 0;
        if (r1 == null) goto L18;
        uf2.d0.a r7 = r1.getBuilder();
        if (r7 == null) goto L18;
        int r8 = r7.n();
    L19:
        Integer r9 = Integer.valueOf(r8);
        if (r1 == null) goto L25;
        uf2.d0.a r10 = r1.getBuilder();
        if (r10 == null) goto L25;
        r6 = r10.getVideoHeight();
    L25:
        return new Pair(r9, Integer.valueOf(r6));
    L18:
        r8 = 0;
    L26:
        return null;
    }
}
