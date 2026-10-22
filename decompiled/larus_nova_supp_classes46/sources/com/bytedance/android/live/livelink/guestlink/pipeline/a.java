package com.bytedance.android.live.livelink.guestlink.pipeline;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.guestlink.k;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.multilink.base.model.guestlink.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements mb6.b.c {
    public final /* synthetic */ GuestLinkPipeLineManager a;
    public final /* synthetic */ int b;

    public a(GuestLinkPipeLineManager r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void C2(long r8, ExtraResponse<? extends c, Extra> r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        Intrinsics.checkNotNullParameter(r10, "response");
        jy0.b.d("GuestLinkPipeLineManager", "sendJoinChannelReq success, duration: " + r8);
        c r0 = (c) r10.data;
        if (r0 == null) goto L61;
        com.bytedance.android.live.base.model.message.guestlink.a r1 = r0.getChannelInfo();
        if (r1 == null) goto L61;
        List r2 = r1.getLinkedUsers();
        k r3 = null;
        Object r4 = null;
        if (r2 == null) goto L20;
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();
        IBaseUser r7 = ((k) r6).getUser();
        if (r7 == null) goto L14;
        String r9 = r7.getIdString();
    L16:
        if (Intrinsics.areEqual(r9, rk0.b.a()) == false) goto L10;
        r4 = r6;
        goto L18
    L14:
        r9 = null;
    L18:
        r3 = (k) r4;
    L20:
        if (r3 != null) goto L22;
    L39:
        ec6.a r11 = this.a.m.n();
        if (r11 == null) goto L46;
        sk0.c r12 = r11.r();
        if (r12 == null) goto L46;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r13 = r12.d;
        if (r13 == null) goto L46;
        r13.c(5);
    L46:
        ei6.a r14 = this.a.m.A();
        if (r14 == null) goto L53;
        xi6.c r15 = r14.t();
        if (r15 == null) goto L53;
        com.bytedance.live.livelink.kmp.impl.core.video.b r16 = r15.f();
        if (r16 == null) goto L53;
        r16.e(true);
    L53:
        ec6.a r17 = this.a.m.n();
        if (r17 == null) goto L60;
        sk0.c r18 = r17.r();
        if (r18 == null) goto L60;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r19 = r18.d;
        if (r19 == null) goto L60;
        r19.d("");
    L60:
        this.a.G().b(r1, "joinChannel");
        goto L61
    L22:
        if (r3.getLinkType() != 1) goto L39;
        if (r3.isBackground() == 1) goto L39;
        ec6.a r20 = this.a.m.n();
        if (r20 == null) goto L32;
        sk0.c r21 = r20.r();
        if (r21 == null) goto L32;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r22 = r21.d;
        if (r22 == null) goto L32;
        r22.c(this.b);
    L32:
        ei6.a r23 = this.a.m.A();
        if (r23 == null) goto L53;
        xi6.c r24 = r23.t();
        if (r24 == null) goto L53;
        com.bytedance.live.livelink.kmp.impl.core.video.b r25 = r24.f();
        if (r25 == null) goto L53;
        r25.e(false);
    L61:
        nb6.a r26 = this.a.c;
        if (r26 == null) goto L69;
        CopyOnWriteArraySet r27 = r26.a;
        if (r27 == null) goto L74;
        Iterator r28 = r27.iterator();
    L67:
        if (r28.hasNext() == false) goto L75;
        ((nb6.b) r28.next()).a.C2(r8, r10);
        goto L67
    L75:
        return;
    L74:
        return;
    }

    public final void o1(long r3, Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "throwable");
        Intrinsics.checkNotNullParameter(r5, "throwable");
        jy0.b.b("GuestLinkPipeLineManager", "sendJoinChannelReq failed, duration: " + r3, r5);
        this.a.k("sendJoinChannelReqFailed");
        this.a.n.release();
        this.a.l.w("onJoinChannelFailed");
        this.a.G().a();
        nb6.a r0 = this.a.c;
        if (r0 == null) goto L10;
        CopyOnWriteArraySet r1 = r0.a;
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((nb6.b) r2.next()).a.o1(r3, r5);
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
