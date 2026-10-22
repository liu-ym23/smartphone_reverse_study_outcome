package kf0;

import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Consumer<Throwable> {
    public final /* synthetic */ f a;

    public e(f r1) {
        this.a = r1;
    }

    public final void accept(Object r1) throws Exception {
        Throwable r2 = (Throwable) r1;
        ((InteractAudienceInviteContract$View) this.a.b).aa0();
    }
}
