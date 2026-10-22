package jw1;

import com.bytedance.android.livehostapi.business.depend.ad.IHostDislikeListener;
import com.bytedance.android.livesdk.feed.live.HotsoonLiveAdViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements IHostDislikeListener {
    public final /* synthetic */ HotsoonLiveAdViewHolder a;

    public w(HotsoonLiveAdViewHolder r1) {
        this.a = r1;
    }

    public final void onDislike(String r2, boolean r3) {
        if (r2.equals(this.a.g.getItem().getHostMixId()) == false) goto L6;
        HotsoonLiveAdViewHolder r4 = this.a;
        r4.j = true;
        r4.l = r3;
        return;
    }
}
