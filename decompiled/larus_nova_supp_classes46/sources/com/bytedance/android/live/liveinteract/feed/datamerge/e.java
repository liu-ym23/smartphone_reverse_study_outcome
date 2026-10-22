package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.aimv.LiveLinkmicAIMVManager;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingInfoV2;
import com.bytedance.android.livesdkapi.depend.message.IUserMicrophoneItem;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ FeedViewInteractSongDataHandler a;
    public final /* synthetic */ int b;

    public e(FeedViewInteractSongDataHandler r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r12) {
        com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
        if (r13 != null) goto L5;
        this.a.f(false);
        return;
    L5:
        FeedViewInteractSongDataHandler r1 = this.a;
        k1 r2 = (k1) r13.data;
        if (r2 == null) goto L12;
        p2 r3 = r2.getLinkmicPlayModeInfo();
        if (r3 == null) goto L12;
        IOrderSingInfoV2 r4 = r3.getOrderSingInfo();
        if (r4 == null) goto L12;
        r4.getMvInfo();
    L12:
        r1.getClass();
        LiveLinkmicAIMVManager r5 = this.a.g;
        if (r5 == null) goto L22;
        k1 r6 = (k1) r13.data;
        if (r6 == null) goto L19;
        p2 r7 = r6.getLinkmicPlayModeInfo();
        if (r7 == null) goto L19;
        IOrderSingInfoV2 r8 = r7.getOrderSingInfo();
    L20:
        r5.b(r8);
    L19:
        r8 = null;
    L22:
        if (com.bytedance.android.live.liveinteract.utils.h.f(this.b) == false) goto L78;
        StringBuilder r9 = new StringBuilder("当前礼物ID");
        k1 r10 = (k1) r13.data;
        if (r10 == null) goto L31;
        p2 r11 = r10.getLinkmicPlayModeInfo();
        if (r11 == null) goto L31;
        IOrderSingInfoV2 r14 = r11.getOrderSingInfo();
        if (r14 == null) goto L31;
        Long r15 = Long.valueOf(r14.getGiftId());
    L32:
        r9.append(r15);
        ALogger.i("InteractiveSongWidget", r9.toString());
        this.a.f(true);
        k1 r16 = (k1) r13.data;
        if (r16 == null) goto L45;
        p2 r17 = r16.getLinkmicPlayModeInfo();
        if (r17 == null) goto L45;
        IOrderSingInfoV2 r18 = r17.getOrderSingInfo();
        if (r18 == null) goto L45;
        List<IUserMicrophoneItem> r19 = r18.getUserMicrophoneList();
        if (r19 == null) goto L45;
        FeedViewInteractSongDataHandler r20 = this.a;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "userMicrophoneList");
        if (r20.b == false) goto L45;
        r20.c = r19;
        j.a r21 = r20.b(r20.c().o());
        if (r21.a == false) goto L45;
        r20.c().t(r21);
    L45:
        k1 r110 = (k1) r13.data;
        if (r110 == null) goto L74;
        p2 r111 = r110.getLinkmicPlayModeInfo();
        if (r111 == null) goto L75;
        IOrderSingInfoV2 r112 = r111.getOrderSingInfo();
        if (r112 == null) goto L76;
        List r113 = r112.getUserMicrophoneList();
        if (r113 == null) goto L77;
        Iterator<T> r114 = r113.iterator();
    L55:
        if (r114.hasNext() == false) goto L79;
        IUserMicrophoneItem r22 = (IUserMicrophoneItem) r114.next();
        IBaseUser r23 = r22.getOrderUser();
        if (r23 == null) goto L59;
        String r24 = r23.getIdString();
    L60:
        int r25 = dg0.a.a;
        IMicrophoneItem r26 = dg0.a.a(r22.getMicrophoneList());
        if (r26 == null) goto L63;
        int r27 = r26.getMicroPhoneNum();
    L64:
        pf0.a r115 = new pf0.a(r24, r27, null, null, null, 28);
        k r28 = this.a.c();
        IBaseUser r29 = r22.getOrderUser();
        if (r29 == null) goto L68;
        String r30 = r29.getIdString();
        if (r30 == null) goto L68;
    L69:
        r28.m(r30, r115);
    L68:
        r30 = "";
        goto L69
    L63:
        r27 = 0;
        goto L64
    L59:
        r24 = null;
        goto L60
    L79:
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L74:
        return;
    L31:
        r15 = null;
        goto L32
    }
}
