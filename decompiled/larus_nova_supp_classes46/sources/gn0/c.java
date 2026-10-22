package gn0;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdk.chatroom.model.interact.n;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements f {
    public final /* synthetic */ b a;
    public final /* synthetic */ long b;

    @Override // gn0.f
    public final void a(n r7) {
        Intrinsics.checkNotNullParameter(r7, "setting");
        int r0 = wh0.c.a;
        boolean r1 = this.a.e();
        Intrinsics.checkNotNullParameter(r7, "audienceSetting");
        String r2 = "call updateLinkSettingByWRDS, audienceSetting = " + r7.toString();
        jy0.b.c("ttlive_link", r2, null, 4);
        if (((Boolean) vm2.e.P.getValue(null, vm2.e.a[40])).booleanValue() == false) goto L6;
        if (r1 == false) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.Q(r2, "from wrds");
    L9:
        b.a(this.a, r7, null);
        return;
    L6:
        r3 = false;
        goto L7
    }

    @Override // gn0.f
    public final void b(Throwable r5) {
        jy0.b.c("ttlive_link", "fetchAudienceLinkSetting failed " + r5, null, 4);
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = this.b;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.GetSettingApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r1), r5, new JSONObject());
    }

    public c(b r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
