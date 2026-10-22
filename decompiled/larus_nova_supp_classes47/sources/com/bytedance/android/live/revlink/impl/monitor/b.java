package com.bytedance.android.live.revlink.impl.monitor;

import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.PkDoubleAudienceDataContext;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public long a;
    public long b;
    public final Lazy c;
    public final ld.a d;
    public final com.bytedance.android.live.revlink.impl.global.c e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        this.a = 0;
        SeiType r2 = SeiType.FirstSei;
        this.b = 0;
        PKLoadSource r0 = PKLoadSource.UnKnown;
    }

    public final void c(IRoom r2) {
        if (r2 == null) goto L6;
        IRoomLinkExt r3 = (IRoomLinkExt) ((vh7.c) r2).castTo(IRoomLinkExt.class);
        if (r3 == null) goto L6;
        a9 r4 = r3.getLinkMicInfo();
    L7:
        if (r4 == null) goto L9;
        i97.a r5 = i97.a.a;
        System.currentTimeMillis();
        return;
    L9:
        b();
        return;
    L6:
        r4 = null;
        goto L7
    }

    public b(ld.a r1, LinkFakeGlobalService r2) {
        this.d = r1;
        this.e = r2;
        SeiType r3 = SeiType.FirstSei;
        PKLoadSource r4 = PKLoadSource.UnKnown;
        this.c = LazyKt.lazy(PkEnterRoomTracer$useLynxDuration$2.INSTANCE);
    }

    public final void a(int r3, long r4) {
        if (r3 == PkDoubleAudienceDataContext.BattleStatsFromType.PKingInRoom.ordinal()) goto L6;
        return;
    L6:
        if (this.b != 0) goto L11;
        i97.a r5 = i97.a.a;
        this.b = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r6 = this.e;
        if (r6 == null) goto L12;
        r6.getPkEnterRoomTracer();
        return;
    L12:
        return;
    }
}
