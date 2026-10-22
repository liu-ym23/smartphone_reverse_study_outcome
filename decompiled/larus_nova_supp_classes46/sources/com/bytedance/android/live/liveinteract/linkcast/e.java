package com.bytedance.android.live.liveinteract.linkcast;

import android.content.Context;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LinkCastGuestWidget a;

    public e(LinkCastGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        String r0 = null;
        if (r6 == null) goto L26;
        p2 r1 = ((k1) r6.data).getLinkmicPlayModeInfo();
        if (r1 == null) goto L7;
        s0 r2 = r1.getScreenCastInfo();
    L8:
        if (r2 == null) goto L26;
        LinkCastGuestDataContext r3 = LinkCastGuestDataContext.Companion.getContext();
        if (r3 == null) goto L18;
        n<s0> r4 = r3.getMLinkCastInfo();
        if (r4 == null) goto L18;
        p2 r7 = ((k1) r6.data).getLinkmicPlayModeInfo();
        if (r7 == null) goto L16;
        s0 r8 = r7.getScreenCastInfo();
    L17:
        r4.setValue(r8);
        goto L18
    L16:
        r8 = null;
    L18:
        g.b.getClass();
        g.a.g();
        if (v.a() == false) goto L32;
        Context r9 = ((Widget) this.a).context;
        StringBuilder r10 = new StringBuilder("【Debug】获取到互动投屏进房信息\nitemAppId: ");
        p2 r11 = ((k1) r6.data).getLinkmicPlayModeInfo();
        if (r11 == null) goto L25;
        s0 r12 = r11.getScreenCastInfo();
        if (r12 == null) goto L25;
        r0 = r12.getAppId();
    L25:
        r10.append(r0);
        f2.i(r9, r10.toString(), 0);
        return;
    L32:
        return;
    L7:
        r2 = null;
    L26:
        LinkCastGuestDataContext r13 = LinkCastGuestDataContext.Companion.getContext();
        if (r13 == null) goto L34;
        n<s0> r14 = r13.getMLinkCastInfo();
        if (r14 == null) goto L35;
        r14.setValue(null);
        return;
    L35:
        return;
    }
}
