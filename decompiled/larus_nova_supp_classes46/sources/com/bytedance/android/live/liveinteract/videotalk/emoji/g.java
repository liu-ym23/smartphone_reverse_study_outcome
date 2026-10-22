package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.j1;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ d a;

    public g(d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        d1 r0 = (d1) r4.data;
        if (r0 == null) goto L9;
        List<? extends ILinkmicInteractEntrance> r1 = r0.getEntranceList();
        if (r1 == null) goto L9;
        d.a r2 = (d.a) ((q46.b) this.a).a;
        if (r2 == null) goto L9;
        r2.j9(r1);
    L9:
        d1 r5 = (d1) r4.data;
        if (r5 == null) goto L16;
        List<? extends j1> r6 = r5.getEntrancePosList();
        if (r6 == null) goto L16;
        d.a r7 = (d.a) ((q46.b) this.a).a;
        if (r7 == null) goto L16;
        r7.A2(r6);
    L16:
        d1 r8 = (d1) r4.data;
        if (r8 == null) goto L29;
        List<? extends ILinkmicInteractEntrance> r9 = r8.getBannerList();
        if (r9 != null) goto L21;
        return;
    L21:
        if ((!r9.isEmpty()) == true) goto L24;
        r9 = null;
    L24:
        if (r9 == null) goto L31;
        d.a r10 = (d.a) ((q46.b) this.a).a;
        if (r10 == null) goto L32;
        r10.Lu(r9);
        return;
    L32:
        return;
    L31:
        return;
    }
}
