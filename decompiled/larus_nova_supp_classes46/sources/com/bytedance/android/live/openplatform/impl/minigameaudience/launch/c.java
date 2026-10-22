package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ AudienceLaunchMgContextService a;

    public c(AudienceLaunchMgContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        h1 r5 = (h1) r4;
        if (r5.a != 7) goto L17;
        IRoom r6 = r5.c;
        Long r0 = null;
        if (r6 == null) goto L7;
        Long r7 = Long.valueOf(r6.getId());
    L8:
        Room r1 = this.a.getOpenPlatformContext().getRoom();
        if (r1 == null) goto L12;
        r0 = Long.valueOf(r1.id);
    L12:
        if (Intrinsics.areEqual(r7, r0) == false) goto L18;
        IHostLiveAd r8 = TTLiveSDK.hostService().hostLiveAd();
        if (r8 == null) goto L19;
        r8.livePlayerReceivedBroadcastFinishMsg();
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r7 = null;
        goto L8
    }
}
