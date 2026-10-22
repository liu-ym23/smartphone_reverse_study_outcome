package com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc;

import com.bytedance.android.live.liveinteract.plantform.model.e0;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements xb6.b {
    public final /* synthetic */ LinkRoomFightRtcManager a;

    public final Pair<Boolean, String> a() {
        int r0 = LinkRoomFightRtcManager.i;
        StringBuilder r1 = new StringBuilder("engine is stoping, fall back to stop play public stream ");
        e0 r2 = this.a.h.getMcuContent();
        if (r2 == null) goto L5;
        String r3 = r2.getRivalsStreamId();
    L6:
        r1.append(r3);
        jy0.b.d(LinkRoomFightContext.TAG, r1.toString());
        e0 r4 = this.a.h.getMcuContent();
        if (r4 == null) goto L11;
        String r5 = r4.getRivalsStreamId();
        if (r5 == null) goto L11;
        this.a.k(r5);
    L11:
        this.a.n1(false);
        return TuplesKt.to(Boolean.FALSE, "link_room_fight: pre handle before stop rtc engine");
    L5:
        r3 = null;
        goto L6
    }

    public final Pair<Boolean, String> b() {
        return xb6.b.a.a();
    }

    public final Pair<Boolean, String> c() {
        return xb6.b.a.b();
    }

    public final Pair<Boolean, String> e() {
        return xb6.b.a.e();
    }

    public final Pair<Boolean, String> g() {
        return xb6.b.a.l();
    }

    public final Pair<Boolean, String> h() {
        return xb6.b.a.g();
    }

    public final Pair<Boolean, String> k() {
        return xb6.b.a.i();
    }

    public final Pair<Boolean, String> m() {
        return xb6.b.a.c();
    }

    public b(LinkRoomFightRtcManager r1) {
        this.a = r1;
    }

    public final Pair<Boolean, String> d(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return xb6.b.a.f(r2);
    }

    public final Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return xb6.b.a.d(r2);
    }

    public final Pair<Boolean, String> j(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return xb6.b.a.h(r2);
    }

    public final Pair<Boolean, String> l(h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        return xb6.b.a.m(r2);
    }

    public final Pair<Boolean, String> i(long r1, String r3, String r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "secToUserId");
        Intrinsics.checkNotNullParameter(r4, "toUserIdString");
        return xb6.b.a.j(r3, r4);
    }
}
