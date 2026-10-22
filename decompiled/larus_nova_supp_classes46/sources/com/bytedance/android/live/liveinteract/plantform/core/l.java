package com.bytedance.android.live.liveinteract.plantform.core;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.livesdk.chatroom.model.IApplyResult;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ n a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Integer c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ long f;
    public final /* synthetic */ LinkApplyType g;
    public final /* synthetic */ tf0.b h;

    public l(n r1, int r2, Integer r3, int r4, String r5, long r6, LinkApplyType r8, tf0.b r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
        this.h = r9;
    }

    public final void accept(Object r18) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r18;
        Intrinsics.checkNotNullParameter(r4, "response");
        IApplyResult r7 = (IApplyResult) r4.data;
        if (TextUtils.isEmpty(r7.getLinkMicIdStr()) == false) goto L5;
        this.a.i.setInteractId(String.valueOf(r7.getLinkMicId()));
    L6:
        tc0.c r1 = tc0.c.h();
        int r3 = (int) r7.getWaitingListOffset();
        r1.i = r3;
        r1.h = r3;
        this.a.i.b(r7.getVendor());
        hd0.c.f().k(1);
        hd0.c r2 = hd0.c.f();
        r2.g = this.b;
        TeamFightContext.a r5 = TeamFightContext.Companion;
        Integer r6 = this.c;
        if (r6 == null) goto L9;
        int r8 = r6.intValue();
    L10:
        r5.i(r8, this.d);
        int r9 = this.d;
        int r10 = r7.getLinkType();
        String r11 = this.e;
        boolean r12 = r7.getAutoJoin();
        boolean r13 = r7.getAutoJoinFull();
        long r14 = this.f;
        long r15 = System.currentTimeMillis() - r14;
        String r16 = r4.logId;
        InteractLinkFullLinkMonitor.d(r9, r10, r11, r12 ? 1 : 0, r13 ? 1 : 0, r15, r16);
        long r17 = this.f;
        com.bytedance.android.live.liveinteract.plantform.utils.x.m(System.currentTimeMillis() - r17, r7.getSilenceStatus(), this.b, this.d, 0, this.g.getValue(), this.e);
        TalkRoomBusinessFullLinkMonitor r19 = TalkRoomBusinessFullLinkMonitor.a;
        int r20 = this.d;
        LinkApplyType r21 = this.g;
        int r22 = this.b;
        long r23 = this.f;
        r19.getClass();
        TalkRoomBusinessFullLinkMonitor.H(r20, r21, r22, r4, r23);
        Iterator<s> r24 = this.a.c.iterator();
    L12:
        if (r24.hasNext() == false) goto L14;
        s r25 = r24.next();
        this.g.getValue();
        r25.g7(r7);
        goto L12
    L14:
        f2.c(r7.getPrompts(), 0);
        this.a.getClass();
        tf0.b r26 = this.h;
        if (r26 == null) goto L19;
        r26.b(r7);
        return;
    L19:
        return;
    L9:
        r8 = 0;
        goto L10
    L5:
        this.a.i.setInteractId(r7.getLinkMicIdStr());
        goto L6
    }
}
