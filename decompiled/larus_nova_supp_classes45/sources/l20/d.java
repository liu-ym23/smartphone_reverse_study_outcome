package l20;

import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.live.broadcastgame.xplay.XplayPublishEventService$initEvent$1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements h10.b {
    public final /* synthetic */ e a;
    public final /* synthetic */ h10.b b;

    public d(e r1, XplayPublishEventService$initEvent$1.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // h10.b
    public final void onSendResult(boolean r9, int r11, String r12, String r13) {
        XplayMonitorSession.f(this.a.c, "receive", Integer.valueOf(r11), r12, null, r13, 8);
        h10.b r0 = this.b;
        if (r0 == null) goto L6;
        r0.onSendResult(r9, r11, r12, r13);
        return;
    }
}
