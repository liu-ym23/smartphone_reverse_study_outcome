package fq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements mq1.i, com.bytedance.android.scope.o {
    public Episode a;

    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final IMainEpisode a() {
        Episode r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.castToOrNull(IMainEpisode.class);
    }

    public final void c(Integer r3, Integer r4) {
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.d().isSaas() == false) goto L5;
        return;
    L5:
        if (r3 == null) goto L13;
        r3.intValue();
        Episode r0 = this.a;
        if (r0 == null) goto L13;
        IMainEpisode r1 = r0.castTo(IMainEpisode.class);
        if (r1 == null) goto L13;
        ReplayPaidInfo r2 = r1.getReplayPaidInfo();
        if (r2 == null) goto L13;
        r2.setViewRight(r3.intValue());
    L13:
        if (r4 == null) goto L22;
        r4.intValue();
        Episode r5 = this.a;
        if (r5 == null) goto L23;
        IMainEpisode r6 = r5.castTo(IMainEpisode.class);
        if (r6 == null) goto L24;
        ReplayPaidInfo r7 = r6.getReplayPaidInfo();
        if (r7 == null) goto L25;
        r7.setDelivery(r4.intValue());
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }
}
