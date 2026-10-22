package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public n(d r1, String r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
        if (Intrinsics.areEqual(jc1.k.n(IMiddlewareUserService.class).user().n(), this.b) == false) goto L10;
        d r0 = this.a;
        if ((r0 instanceof d0) == false) goto L8;
        com.bytedance.android.live.liveinteract.linksecurity.b.o(com.bytedance.android.live.liveinteract.linksecurity.b.g);
        goto L10
    L8:
        if ((r0 instanceof f0) == false) goto L10;
        com.bytedance.android.live.liveinteract.linksecurity.c.o(com.bytedance.android.live.liveinteract.linksecurity.c.g);
    L10:
        this.a.b = false;
        InteractLinkFullLinkMonitor.X(this.b, System.currentTimeMillis() - this.c, r7.logId);
        IMultiLinkInternalService r1 = (IMultiLinkInternalService) jc1.k.f(IMultiLinkInternalService.class);
        if (r1 == null) goto L15;
        dn0.c r2 = r1.getLinkSecurityService();
        if (r2 == null) goto L15;
        r2.Z(this.b, ((r1) r7.data).getAckMessage(), AckFromSource.TALK_ROOM_SILENCE_API);
    L15:
        String r3 = this.b;
        r1 r4 = (r1) r7.data;
        String r5 = null;
        if (r4 == null) goto L20;
        List r8 = r4.getLinkedUsers();
        if (r8 == null) goto L20;
        String r9 = je0.d.g0(r8);
    L21:
        r1 r10 = (r1) r7.data;
        if (r10 == null) goto L26;
        Map r11 = r10.getLinkerContentMap();
        if (r11 == null) goto L26;
        r5 = r11.toString();
    L26:
        com.bytedance.android.live.liveinteract.plantform.utils.x.w0(r3, "self_panel", r9, r5);
        this.a.d0((r1) r7.data);
        d.a r12 = (d.a) ((q46.b) this.a).a;
        if (r12 == null) goto L30;
        r12.D(this.b);
        return;
    L30:
        return;
    L20:
        r9 = null;
        goto L21
    }
}
