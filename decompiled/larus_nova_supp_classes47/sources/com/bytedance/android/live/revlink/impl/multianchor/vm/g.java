package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public final long a() {
        if (y41.f.N.f() == false) goto L11;
        b r0 = e();
        if (r0 == null) goto L17;
        m<Long> r1 = r0.getChannelId();
        if (r1 == null) goto L17;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L17;
        return r2.longValue();
    L17:
        return 0;
    L11:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.a;
        if (r3 == null) goto L14;
        LinkCrossRoomDataHolder r4 = r3.getLinkCrossRoomDataHolder();
    L15:
        if (r4 == null) goto L17;
        return r4.c();
    L14:
        r4 = null;
        goto L15
    }

    public final int b() {
        if (y41.f.N.f() == false) goto L11;
        b r0 = e();
        if (r0 == null) goto L17;
        m<Integer> r1 = r0.getInviteType();
        if (r1 == null) goto L17;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L17;
        return r2.intValue();
    L17:
        return 0;
    L11:
        com.bytedance.android.live.revlink.impl.global.c r3 = this.a;
        if (r3 == null) goto L14;
        LinkCrossRoomDataHolder r4 = r3.getLinkCrossRoomDataHolder();
    L15:
        if (r4 == null) goto L17;
        return r4.f();
    L14:
        r4 = null;
        goto L15
    }

    public final String c() {
        if (y41.f.N.f() == false) goto L9;
        b r0 = e();
        if (r0 == null) goto L16;
        m<String> r1 = r0.getLinkerId();
        if (r1 != null) goto L18;
        return null;
    L18:
        return (String) r1.getValue();
    L16:
        return null;
    L9:
        com.bytedance.android.live.revlink.impl.global.c r2 = this.a;
        if (r2 == null) goto L12;
        LinkCrossRoomDataHolder r3 = r2.getLinkCrossRoomDataHolder();
    L13:
        if (r3 != null) goto L15;
        return null;
    L15:
        return r3.e();
    L12:
        r3 = null;
        goto L13
    }

    public final int d() {
        Integer r1 = null;
        if (y41.f.N.f() == false) goto L9;
        b r0 = e();
        if (r0 == null) goto L16;
        m<Integer> r2 = r0.getMatchType();
        if (r2 == null) goto L16;
        r1 = (Integer) r2.getValue();
    L16:
        if (r1 != null) goto L20;
        return 0;
    L20:
        return r1.intValue();
    L9:
        b r3 = e();
        if (r3 == null) goto L16;
        n<? extends f21.a> r4 = r3.getConnectionContext();
        if (r4 == null) goto L16;
        f21.a r5 = (f21.a) r4.getValue();
        if (r5 == null) goto L16;
        r1 = Integer.valueOf(r5.d);
        goto L16
    }

    public final b e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.rb();
    }

    public final b7 f() {
        b r0 = e();
        if (r0 == null) goto L7;
        n<b7> r1 = r0.getMultiChannelInfo();
        if (r1 == null) goto L7;
        return (b7) r1.getValue();
    L7:
        return null;
    }

    public g(LinkFakeGlobalService r1) {
        this.a = r1;
    }
}
