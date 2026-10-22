package kf0;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View;
import com.bytedance.android.live.liveinteract.plantform.model.a1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Consumer<com.bytedance.android.live.network.response.e<a1>> {
    public final /* synthetic */ long a;
    public final /* synthetic */ f b;

    public final void accept(Object r5) throws Exception {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = this.a;
        String r3 = r6.logId;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.D(r1, r3);
        DATA r2 = r6.data;
        if (r2 != 0) goto L5;
        return;
    L5:
        if (((a1) r2).getPlayerInfo() == null) goto L9;
        int r4 = f.d;
        ((a1) r6.data).getPlayerInfo().size();
        ((InteractAudienceInviteContract$View) this.b.b).ba0(jm2.a.a(((a1) r6.data).getPlayerInfo()));
        return;
    }

    public c(f r1, long r2) {
        this.b = r1;
        this.a = r2;
    }
}
