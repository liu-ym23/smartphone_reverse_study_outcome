package com.bytedance.android.live.liveinteract.revenue.game;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.q;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.VideoChatDynamic1V7Info;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        IRoomLinkMicSyncData r6 = (IRoomLinkMicSyncData) r5;
        q r0 = r6.getLinkerBaseInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUiLayout() != 15) goto L27;
        ClientUIInfo r1 = r6.getClientUIInfo();
        Long r2 = null;
        if (r1 == null) goto L9;
        VideoChatDynamic1V7Info r3 = r1.getVideoChatDynamic1V7Info();
    L10:
        if (r3 == null) goto L28;
        Long r4 = this.a.c;
        ClientUIInfo r7 = r6.getClientUIInfo();
        if (r7 == null) goto L16;
        VideoChatDynamic1V7Info r8 = r7.getVideoChatDynamic1V7Info();
        if (r8 == null) goto L16;
        Long r9 = Long.valueOf(r8.getStatus());
    L18:
        if ((!Intrinsics.areEqual(r4, r9)) == false) goto L29;
        a r10 = this.a;
        ClientUIInfo r11 = r6.getClientUIInfo();
        if (r11 == null) goto L24;
        VideoChatDynamic1V7Info r12 = r11.getVideoChatDynamic1V7Info();
        if (r12 == null) goto L24;
        r2 = Long.valueOf(r12.getStatus());
    L24:
        r10.c = r2;
        ALogger.d("DanmuGameController", "startObserveMicSeatStatus, update micSeatStatus: " + this.a.c);
        return;
    L29:
        return;
    L16:
        r9 = null;
        goto L18
    L28:
        return;
    L9:
        r3 = null;
        goto L10
    }
}
