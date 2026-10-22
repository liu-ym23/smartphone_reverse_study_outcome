package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;

    public k(d r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        this.a.c = false;
        String r0 = this.b.toString();
        c2 r1 = (c2) r6.data;
        if (r1 == null) goto L7;
        List r2 = r1.getLinkedUsers();
        if (r2 == null) goto L7;
        String r3 = dl0.q.a(r2);
    L8:
        com.bytedance.android.live.liveinteract.plantform.utils.x.D0(r0, "self_panel", r3, null);
        d r4 = this.a;
        DATA r7 = r6.data;
        if (r7 == 0) goto L15;
        r4.d0((UnSilenceResponse) r7);
        d.a r8 = (d.a) ((q46.b) this.a).a;
        if (r8 == null) goto L16;
        r8.G(this.b);
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse");
    L7:
        r3 = null;
        goto L8
    }
}
