package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.j1;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ s a;

    public y(s r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        d1 r0 = (d1) r4.data;
        if (r0 == null) goto L9;
        List<? extends ILinkmicInteractEntrance> r1 = r0.getEntranceList();
        if (r1 == null) goto L9;
        s.a r2 = (s.a) ((q46.b) this.a).a;
        if (r2 == null) goto L9;
        r2.j9(r1);
    L9:
        d1 r5 = (d1) r4.data;
        if (r5 == null) goto L17;
        List<? extends j1> r6 = r5.getEntrancePosList();
        if (r6 == null) goto L18;
        s.a r7 = (s.a) ((q46.b) this.a).a;
        if (r7 == null) goto L19;
        r7.A2(r6);
        return;
    L19:
        return;
    L18:
        return;
    }
}
