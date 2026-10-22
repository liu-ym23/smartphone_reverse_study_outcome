package com.bytedance.android.live.liveinteract.voicechat.radio;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.model.interact.k2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ m a;

    public n(m r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
        StringBuilder r0 = new StringBuilder("[RadioSubtitleComponent] requestInitRtcInfo suc: ");
        k2 r1 = null;
        if (r5 == null) goto L5;
        k2 r2 = (k2) r5.data;
    L6:
        r0.append(r2);
        r0.append(" isDestroy:");
        r0.append(this.a.e);
        ALogger.i("RadioStageContainerWidget", r0.toString());
        m r3 = this.a;
        if (r3.e == true) goto L16;
        if (r5 == null) goto L11;
        r1 = (k2) r5.data;
    L11:
        if (r1 != null) goto L13;
        f2.b(2131921830, 0);
        return;
    L13:
        k2 r6 = (k2) r5.data;
        r3.f = r6;
        r3.i(r6);
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
