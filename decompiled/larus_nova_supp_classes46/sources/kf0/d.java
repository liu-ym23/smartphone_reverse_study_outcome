package kf0;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Consumer<Throwable> {
    public final /* synthetic */ long a;
    public final /* synthetic */ f b;

    public final void accept(Object r4) throws Exception {
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r1 = this.a;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.C(r1, (Throwable) r4);
        ((InteractAudienceInviteContract$View) this.b.b).aa0();
    }

    public d(f r1, long r2) {
        this.b = r1;
        this.a = r2;
    }
}
