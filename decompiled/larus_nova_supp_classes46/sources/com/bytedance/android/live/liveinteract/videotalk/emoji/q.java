package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public q(d r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
        this.a.c = false;
        InteractLinkFullLinkMonitor.p0(this.b, System.currentTimeMillis() - this.c, r7.logId);
        String r0 = this.b;
        c2 r1 = (c2) r7.data;
        String r2 = null;
        if (r1 == null) goto L7;
        List r3 = r1.getLinkedUsers();
        if (r3 == null) goto L7;
        String r4 = je0.d.g0(r3);
    L8:
        c2 r5 = (c2) r7.data;
        if (r5 == null) goto L13;
        Map r8 = r5.getLinkerContentMap();
        if (r8 == null) goto L13;
        r2 = r8.toString();
    L13:
        com.bytedance.android.live.liveinteract.plantform.utils.x.D0(r0, "self_panel", r4, r2);
        this.a.e0((c2) r7.data);
        d.a r9 = (d.a) ((q46.b) this.a).a;
        if (r9 == null) goto L17;
        r9.G(this.b);
        return;
    L17:
        return;
    L7:
        r4 = null;
        goto L8
    }
}
