package com.bytedance.android.livesdk.interactivity.seek.v2;

import android.content.Context;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends b {
    @Override // com.bytedance.android.livesdk.interactivity.seek.v2.b
    public final String f() {
        return "https://" + k.n(IHostNetwork.class).getHostDomain() + "/webcast/im/fetch/traceable/";
    }

    @Override // com.bytedance.android.livesdk.interactivity.seek.v2.b
    public final HashMap<String, String> h() {
        HashMap<String, String> r0 = super.h();
        DataCenter r1 = this.r;
        Room r2 = z.a;
        Intrinsics.checkNotNullParameter(r1, "$this$episode");
        EpisodeBasicInfo r3 = ((Episode) r1.get("data_vs_episode_data", z.b)).episodeBasicInfo;
        if (r3 == null) goto L13;
        Long r4 = Long.valueOf(r3.getGroupId());
        if (r4.longValue() == 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L13;
        r0.put("group_id", String.valueOf(r4.longValue()));
        goto L13
    L7:
        r5 = false;
    L13:
        return r0;
    }

    public a(DataCenter r2, Context r3, long r4, String r6, boolean r7, long r8, int r10, long r11, List r13) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "userId");
        super(r2, r3, r4, r6, r7, r8, r10, r11, r13);
    }
}
