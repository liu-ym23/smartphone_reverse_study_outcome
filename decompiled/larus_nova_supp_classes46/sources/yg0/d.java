package yg0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements on0.a {
    public final /* synthetic */ List a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.h b;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.plantform.commonwindow.g c;
    public final /* synthetic */ long d;

    @Override // on0.a
    public final void b(pn0.d r6) {
        Intrinsics.checkNotNullParameter(r6, "localRequest");
        this.c.b(this.b);
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        ln0.a r1 = h.a;
        long r2 = System.currentTimeMillis() - this.d;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.h r3 = this.b;
        String r4 = r6.e().a.toString();
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.i(101, r2, r3, r4);
        ALogger.i("LayoutConfigGeckoRes", "load failed, traceInfo = " + r6.e().a.toString());
    }

    @Override // on0.a
    public final void a(pn0.d r7, pn0.e r8) {
        Intrinsics.checkNotNullParameter(r7, "localRequest");
        Intrinsics.checkNotNullParameter(r8, "localResponse");
        int r0 = ah0.a.a;
        m r1 = ah0.a.a(r8.a);
        r1.a = r7.i();
        r1.e = this.a;
        if (((Number) this.b.h.getFirst()).intValue() > 0) goto L5;
    L7:
        this.c.a(this.b, new com.bytedance.android.live.liveinteract.plantform.commonwindow.i(r1, r8.b.name()));
        TalkRoomBusinessFullLinkMonitor r9 = TalkRoomBusinessFullLinkMonitor.a;
        ln0.a r2 = h.a;
        long r3 = System.currentTimeMillis() - this.d;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.h r4 = this.b;
        String r5 = r7.e().a.toString();
        r9.getClass();
        TalkRoomBusinessFullLinkMonitor.i(100, r3, r4, r5);
        ALogger.i("LayoutConfigGeckoRes", "load success, traceInfo = " + r7.e().a.toString());
        return;
    L5:
        if (((Number) this.b.h.getSecond()).intValue() <= 0) goto L7;
        ln0.a r6 = h.a;
        r1.d = h.b(r8.a, this.b.h, new Pair(0, 0));
        goto L7
    }

    public d(List r1, com.bytedance.android.live.liveinteract.plantform.commonwindow.h r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.g r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
