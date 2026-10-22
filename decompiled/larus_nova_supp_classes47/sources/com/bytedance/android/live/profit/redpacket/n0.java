package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n0 {
    public final Map<String, Long> a;
    public int b;
    public boolean c;
    public final String d;
    public final int e;
    public final com.bytedance.android.live.revenue.common.u0 f;
    public final com.bytedance.android.live.revenue.common.u0 g;
    public final com.bytedance.android.live.revenue.common.u0 h;
    public final com.bytedance.android.live.revenue.common.u0 i;
    public final IBaseUser j;
    public final int k;
    public final long l;
    public final int m;
    public final List<m> n;
    public final RedPacketDataSource o;
    public final boolean p;
    public final String q;
    public final long r;
    public final String s;
    public final Object t;

    public final int getType() {
        return this.k;
    }

    public n0(String r13, int r14, com.bytedance.android.live.revenue.common.u0 r15, com.bytedance.android.live.revenue.common.u0 r16, com.bytedance.android.live.revenue.common.u0 r17, com.bytedance.android.live.revenue.common.u0 r18, IBaseUser r19, int r20, long r22, int r23, List r24, RedPacketDataSource r25, boolean r26, String r27, long r28, String r30, Object r32) {
        Intrinsics.checkNotNullParameter(r13, "id");
        Intrinsics.checkNotNullParameter(r15, "remoteCreatedAt");
        Intrinsics.checkNotNullParameter(r16, "waitDuration");
        Intrinsics.checkNotNullParameter(r17, "availableAt");
        Intrinsics.checkNotNullParameter(r18, "expireAt");
        Intrinsics.checkNotNullParameter(r19, "sender");
        Intrinsics.checkNotNullParameter(r24, "description");
        Intrinsics.checkNotNullParameter(r25, "dataSource");
        Intrinsics.checkNotNullParameter(r27, "voucherActivityId");
        Intrinsics.checkNotNullParameter(r32, "original");
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r22;
        this.m = r23;
        this.n = r24;
        this.o = r25;
        this.p = r26;
        this.q = r27;
        this.r = r28;
        this.s = r30;
        this.t = r32;
        this.a = new LinkedHashMap();
    }
}
