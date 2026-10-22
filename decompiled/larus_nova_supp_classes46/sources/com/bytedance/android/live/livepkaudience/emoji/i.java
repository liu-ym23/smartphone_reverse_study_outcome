package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager;
import com.bytedance.android.livesdk.chatroom.model.interact.SilenceResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;

    public i(d r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        CompositeDisposable r0 = LinkSecurityManager.b;
        LinkSecurityManager.b(this.b, ((r1) r6.data).getAckMessage(), LinkSecurityManager.AckFromSource.PK_WITH_AUDIENCE_SILENCE_API);
        this.a.b = false;
        cl0.a.g(cl0.a.d);
        String r1 = this.b.toString();
        r1 r2 = (r1) r6.data;
        if (r2 == null) goto L7;
        List r3 = r2.getLinkedUsers();
        if (r3 == null) goto L7;
        String r4 = dl0.q.a(r3);
    L8:
        com.bytedance.android.live.liveinteract.plantform.utils.x.w0(r1, "self_panel", r4, null);
        d r7 = this.a;
        DATA r8 = r6.data;
        if (r8 == 0) goto L15;
        r7.c0((SilenceResponse) r8);
        d.a r9 = (d.a) ((q46.b) this.a).a;
        if (r9 == null) goto L16;
        r9.D(this.b);
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.SilenceResponse");
    L7:
        r4 = null;
        goto L8
    }
}
